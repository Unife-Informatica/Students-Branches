package it.unife.lp.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StringPropertyWrapper {
    private String value;

    public StringPropertyWrapper() {
    }

    public StringPropertyWrapper(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    
    @SuppressWarnings("exports")
    public StringProperty toStringProperty() {
        return new SimpleStringProperty(value);
    }

    public static StringPropertyWrapper fromStringProperty(@SuppressWarnings("exports") StringProperty property) {
        return new StringPropertyWrapper(property.get());
    }
}
