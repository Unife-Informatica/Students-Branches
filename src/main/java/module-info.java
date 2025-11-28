module it.unife.lp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.prefs;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires javafx.graphics;
    requires javafx.base;

    opens it.unife.lp to javafx.fxml;
    opens it.unife.lp.view to javafx.fxml;
    opens it.unife.lp.model to com.fasterxml.jackson.databind;
    
    exports it.unife.lp;
    exports it.unife.lp.model;
    exports it.unife.lp.view;
}
