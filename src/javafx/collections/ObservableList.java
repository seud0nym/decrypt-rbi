package javafx.collections;

import java.util.ArrayList;

public class ObservableList<T> extends ArrayList<T>{
    @SafeVarargs
    public final boolean addAll(T... args) {
        return true;
    }
}
