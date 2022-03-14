package javafx.scene;

import java.util.ArrayList;

import javafx.beans.property.BooleanProperty;

public class Node {
    
    public final ArrayList<Object> getChildren() {
        return new ArrayList<>();
    }

    public final void setVisible(boolean b){
    }

    public final BooleanProperty managedProperty() {
        return new BooleanProperty();
    }

    public final Object visibleProperty() {
        return new Object();
    }

}
