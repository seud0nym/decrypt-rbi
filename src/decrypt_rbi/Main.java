package decrypt_rbi;

import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Map;
import java.util.zip.DataFormatException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import main.board;
import main.os_key_couple;
import main.rbi_info;
import main.rbi_reader;
import main.string_util;

public class Main {
	public static void main(String[] args) throws IOException {
		Security.setProperty("crypto.policy", "unlimited");

        System.out.println("INFO:  decrypt-rbi " + Main.class.getPackage().getImplementationVersion());

        if (args.length != 1) {
            System.err.println("ERROR: You must provide the path of the .rbi file to decrypt!");
            System.exit(1);
        }

		File file = new File(args[0]);

		if (!file.exists()) {
            System.err.println("ERROR: " + file.getAbsolutePath() + " not found!");
            System.exit(1);
		} else if (!file.isFile()) {
            System.err.println("ERROR: " + file.getAbsolutePath() + " is not a file?");
            System.exit(1);
		} else if (!file.canRead()) {
            System.err.println("ERROR: " + file.getAbsolutePath() + " cannot be read?");
            System.exit(1);
		}

        System.out.println("INFO:  Reading " + file.getAbsolutePath());

        rbi_info rbi = new rbi_info(file);
        rbi_reader rdr = rbi.getReader();
        rdr.openFile();
        Map<String,String> hdr = rbi.getHeaderTable();

        for (Map.Entry<String, String> entry : hdr.entrySet()) {
            System.out.println("INFO:  Header " + entry.getKey().concat(" = ").concat(entry.getValue()));
        }

        String boardname = hdr.get("boardname");
        if (board.getMap().containsKey(boardname)) {
            PseudoScene scene = new PseudoScene(rbi);
            board b = board.getByMnemonic(boardname);

            for (os_key_couple keys : b.getAllOsKeys()) {
                byte[] osck = string_util.hexStringToByteArray(keys.Osck);
                byte[] osik = string_util.hexStringToByteArray(keys.Osik);

                try {
                    rdr.processPayload(osck, osik, scene);

                    File outputFile = changeExtension(file, ".bin");
                    if (outputFile != null) {
                        System.out.println("INFO:  Writing " + outputFile.getAbsolutePath());
                        rdr.saveFile(outputFile, scene);
                        System.out.println("INFO:  Decryption complete!");
                        System.out.println("NEXT:  /usr/bin/7z x -o'" + changeExtension(file, "").getAbsolutePath() + "' '" + outputFile.getAbsolutePath() + "'");
                    }
                    break;
                } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
                    System.err.println("ERROR: Failed to decrypt file! (" + e.getMessage() + ")");
                } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | DataFormatException e) {
                    System.err.println("ERROR: Failed to decrypt file? (" + e.getMessage() + ")");
                } catch (IOException e) {
                    System.err.println("ERROR: I/O ERROR? (" + e.getMessage() + ")");
                    break;
                }
            }
        } else {
            System.err.println("ERROR: Unable to detected board name?");
            System.exit(1);
        }
	}

    private static File changeExtension(File f, String newExtension) {
        int i = f.getName().lastIndexOf('.');
        String name = f.getName().substring(0,i);
        return new File(f.getParent(), name + newExtension);
    }
}
