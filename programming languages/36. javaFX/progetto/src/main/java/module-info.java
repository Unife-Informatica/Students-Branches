module it.unife.informatica {
    requires javafx.controls;
    requires javafx.fxml;

    opens it.unife.informatica to javafx.fxml;
    exports it.unife.informatica;
}
