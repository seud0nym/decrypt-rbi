package javafx.scene.control;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ComboBox<T> {

    public SingleSelectionModel<T> getSelectionModel() {
        return null;
    }

    public ReadOnlyObjectProperty<T> getEditor() {
        return new ReadOnlyObjectProperty<>();
    }

    public ObservableList<T> getItems() {
        return new ObservableList<>();
    }

    public void setItems(ObservableList<T> observableArrayList) {
    }

    public void setEditable(boolean b) {
    }

    public void setOnAction(EventHandler<ActionEvent> checkBoardSelectHandler) {
    }
    
}
