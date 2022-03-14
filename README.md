# decrypt-rbi

This fork is a command line wrapper for https://github.com/Ansuel/Decrypt_RBI_Firmware_Utility.

## Usage

Download the latest decrypt-rbi.jar release file and then run it by passing the path to the RBI file as the only parameter.
```
java -jar decrypt-rbi.jar path_to_file.rbi
```

This will decrypt the RBI file and create the new decrypted file in the same directory with an extension of `.bin`.

You can then extract the filesystem from the `.bin` file with a utility such as [p7zip](https://www.7-zip.org/). e.g.
```
/usr/bin/7z x -o'directory_name' 'decrypted_rbi_file.bin'
```

### Oracle Java-8 JRE 

If you are using an Oracle Java-8 JRE, you need to _exclude_ the standard JavaFX libraries. e.g.
```
java -Djava.ext.dirs= -jar decrypt-rbi.jar path_to_file.rbi
```
