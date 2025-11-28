package it.unife.lp.view;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import it.unife.lp.model.Presence;
import it.unife.lp.MainApp;
import it.unife.lp.model.Person;

public class PresenceOverviewController {

    @FXML
    private TableView<Presence> presenceTable;
    @FXML
    private TableColumn<Presence, String> dayColumn;
    @FXML
    private TableColumn<Presence, Integer> entranceHourColumn;
    @FXML
    private TableColumn<Presence, Integer> exitHourColumn;

    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> nameColumn;
    @FXML
    private TableColumn<Person, String> surnameColumn;

    @SuppressWarnings("unused")
    private MainApp mainApp;

    @FXML
    private void initialize() {
        // Inizializza le colonne della tabella
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        surnameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        dayColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty().asString());
        entranceHourColumn.setCellValueFactory(cellData -> cellData.getValue().entranceHourProperty().asObject());
        exitHourColumn.setCellValueFactory(cellData -> cellData.getValue().exitHourProperty().asObject());

        // Listen for selection changes and show the person details when changed.
        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPresenceDetails(newValue));
    }

    private void showPresenceDetails(Person person) {
        if (person != null) {
            presenceTable.setItems(person.getPresenze());
        }
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        personTable.setItems(mainApp.getPersonData());
    }
}