package it.unife.lp.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import it.unife.lp.MainApp;
import it.unife.lp.model.Activity;
import it.unife.lp.model.Person;

public class ActivitySubEditDialogController {

    @FXML
    private TableView<Person> memberTable;
    @FXML
    private TableColumn<Person, String> nameColumn;
    @FXML
    private TableColumn<Person, String> surnameColumn;
    
    private Stage dialogStage;
    private Activity activity;
    private boolean okClicked = false;

    private MainApp mainApp;

    @FXML
    private void initialize() {
        // Inizializza le colonne della tabella
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        surnameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        // Popola la tabella con i dati dei membri
        if (mainApp.getPersonData() != null && !mainApp.getPersonData().isEmpty()) {
            memberTable.setItems(mainApp.getPersonData());
            System.out.println("Person data loaded: " + mainApp.getPersonData());
        } else {
            System.out.println("Person data is null or empty");
        }
    }

    @SuppressWarnings("exports")
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        Person selectedPerson = memberTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            if (activity != null && activity.getIscritti() != null) {
                activity.getIscritti().add(selectedPerson);
                okClicked = true;
                dialogStage.close();
            } else if (activity == null) {
                System.out.println("Activity is null");
            } else if (activity.getIscritti() == null) {
                System.out.println("List iscritti is null");
            } else {
                System.out.println("Input is not valid");
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(dialogStage);
            alert.setTitle("Nessuna selezione");
            alert.setHeaderText("Nessun membro selezionato");
            alert.setContentText("Per favore seleziona un membro dalla tabella.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
}