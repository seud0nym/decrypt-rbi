package javafx.stage;

import java.util.ArrayList;

import javafx.scene.Scene;

public interface Stage {

    void setTitle(String string);

    ArrayList<Object> getIcons();

    void setScene(Scene scene);

    void setMaxWidth(Object width);

    void setMaxHeight(Object height);

    void show();
    
}
