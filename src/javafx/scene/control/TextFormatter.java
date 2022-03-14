package javafx.scene.control;

import java.util.function.UnaryOperator;

public class TextFormatter<T> {
    
    public static final class Change extends Object implements Cloneable {

        public CharSequence getControlNewText() {
            return null;
        }

    }

    public TextFormatter(UnaryOperator<TextFormatter.Change> filter) {
    }
}
