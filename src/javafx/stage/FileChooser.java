package javafx.stage;

import java.io.File;
import java.util.ArrayList;

public class FileChooser {
    public static final class ExtensionFilter {

        public ExtensionFilter(String string, String string2, String string3) {
        }

        public ExtensionFilter(String string, String string2) {
        }

    }

    public ArrayList<Object> getExtensionFilters() {
        return null;
    }

    public File showOpenDialog(Stage stage) {
        return null;
    }

    public void setInitialDirectory(File parentFile) {
    }

    public void setInitialFileName(String replaceFirst) {
    }

    public File showSaveDialog(Stage stage) {
        return null;
    }
}
