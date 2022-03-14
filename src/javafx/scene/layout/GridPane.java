package javafx.scene.layout;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;

public class GridPane extends Node {

    public ObservableList<ColumnConstraints> getColumnConstraints() {
        return new ObservableList<>();
    }

    public ObservableList<RowConstraints> getRowConstraints() {
        return new ObservableList<>();
    }

    public void add(Node inputFilePanel, int i, int j, int k, int l) {
    }

    public void addRow(int i, Label label, Label label2) {
    }

    public void add(TitledPane logPanel, int i, int j) {
    }
    
}
