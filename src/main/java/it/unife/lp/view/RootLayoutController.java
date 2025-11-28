package it.unife.lp.view;

import javafx.fxml.FXML;
import javafx.stage.FileChooser;

import java.io.File;

import it.unife.lp.MainApp;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class RootLayoutController {

    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleNew() {
        mainApp.getPersonData().clear();
        mainApp.setPersonFilePath(null);
        mainApp.getActivityData().clear();
        mainApp.setActivityFilePath(null);
    }

    @FXML
    private void handleOpen() {
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "Json files (*.json)", "*.json");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File personFile = fileChooser.showOpenDialog(mainApp.getPrimaryStage());
        File activityFile = fileChooser.showOpenDialog(mainApp.getPrimaryStage());

        if (personFile != null) {
            mainApp.loadPersonDataFromFile(personFile);
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("PersonFile");
            alert.setContentText("Non trovato.");
            alert.showAndWait();
        }

        if (activityFile != null) {
            mainApp.loadActivityDataFromFile(activityFile);
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("ActivityFile");
            alert.setContentText("Non trovato.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleSave() {
        File personFile = mainApp.getPersonFilePath();
        if (personFile != null) {
            mainApp.savePersonDataToFile(personFile);
        } else {
            handleSaveAs();
        }

        File activityFile = mainApp.getActivityFilePath();
        if (activityFile != null) {
            mainApp.saveActivityDataToFile(activityFile);
        } else {
            handleSaveAs();
        }
    }

    @FXML
    private void handleSaveAs() {
        FileChooser fileChooser = new FileChooser(); // apre gestore file sistema

        // Permette all'utente di selezionare il tipo di file in cui salvare i dati
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                // etichetta visibile all'utente, estensione del file
                "JSON files (*.json)", "*.json");

        // aggiunge il filtro al fileChooser
        fileChooser.getExtensionFilters().add(extFilter);

        
        // associa a file il file selezionato dall'utente per Person
        File personFile = fileChooser.showSaveDialog(mainApp.getPrimaryStage());
        
        // Imposta un nome predefinito per il file
        fileChooser.setInitialFileName("personData.json");
        
        if (personFile != null) {
            if (!personFile.getPath().endsWith(".json")) {
                personFile = new File(personFile.getPath() + ".json");
            }
            mainApp.savePersonDataToFile(personFile);
        }
        
        // associa a file il file selezionato dall'utente per Activity
        File activityFile = fileChooser.showSaveDialog(mainApp.getPrimaryStage());
        fileChooser.setInitialFileName("activityData.json");

        if (activityFile != null) {
            if (!activityFile.getPath().endsWith(".json")) {
                activityFile = new File(activityFile.getPath() + ".json");
            }
            mainApp.saveActivityDataToFile(activityFile);
        }
    }

    @FXML
    private void handleExit() {
        System.exit(0);
    }

    @FXML
    private void handleShowPresenceStatistics() {
        mainApp.showPresenceStatistics();
    }

    @FXML
    public void handleShowPersonOverview() {
        mainApp.showPersonOverview();
    }

    @FXML
    public void handleShowClassOverview() {
        mainApp.showActivityOverview();
    }

    @FXML
    public void handleShowPresencesOverview() {
        mainApp.showPresencesOverview();
    }

}