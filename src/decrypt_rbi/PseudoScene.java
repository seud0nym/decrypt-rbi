package decrypt_rbi;

import java.util.Map;

import main.gui_construct;
import main.rbi_info;

public class PseudoScene extends gui_construct {

    private final rbi_info info;

    public PseudoScene(rbi_info rbi_info) {
        info = rbi_info;
    }

    public rbi_info getRbiInfo() {
        return info;
    }

    public void updateInfoBlockSubPanel() {
        Map<String, String> infoblock = info.getInfoBlockTable();
        for (Map.Entry<String, String> entry : infoblock.entrySet()) {
            System.out.println("INFO:  InfoBlock " + entry.getKey().concat(" = ").concat(entry.getValue()));
        }
    }
}
