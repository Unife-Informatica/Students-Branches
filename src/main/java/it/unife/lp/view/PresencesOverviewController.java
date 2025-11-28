package it.unife.lp.view;

import java.time.LocalDate;

import it.unife.lp.MainApp;
import it.unife.lp.model.Person;
import it.unife.lp.model.Presence;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PresencesOverviewController {
    @FXML 
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> nameColumn;
    @FXML
    private TableColumn<Person, String> surnameColumn;
    
    @FXML 
    private TableView<Presence> presenceTable;
    @FXML
    private TableColumn<Presence, LocalDate> dayColumn;
    @FXML
    private TableColumn<Presence, Integer> entranceHourColumn;
    @FXML
    private TableColumn<Presence, Integer> exitHourColumn;

    private MainApp mainApp;

    public PresencesOverviewController() {
    }

    @FXML
    private void initialize() {
        nameColumn.setCellValueFactory(
                cellData -> cellData.getValue().firstNameProperty());
        surnameColumn.setCellValueFactory(
                cellData -> cellData.getValue().lastNameProperty());
        dayColumn.setCellValueFactory(
                cellData -> cellData.getValue().dateProperty());
        entranceHourColumn.setCellValueFactory(
                cellData -> cellData.getValue().entranceHourProperty().asObject());
        exitHourColumn.setCellValueFactory(
                cellData -> cellData.getValue().exitHourProperty().asObject());

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

    @FXML
    private void handleNewPresence() {
        Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            Presence tempPresence = new Presence();
            boolean okClicked = mainApp.showPresenceEditDialog(selectedPerson);
            if (okClicked) {
                selectedPerson.getPresenze().add(tempPresence);
            }
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Attenzione");
            alert.setHeaderText("Nessun membro selezionato");
            alert.showAndWait();
        }
    }

}
