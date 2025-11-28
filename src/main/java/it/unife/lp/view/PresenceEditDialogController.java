package it.unife.lp.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import it.unife.lp.model.Person;
import it.unife.lp.model.Presence;

public class PresenceEditDialogController {

    @FXML
    private TextField dayField;
    @FXML
    private TextField entranceHourField;
    @FXML
    private TextField exitHourField;
    
    private Stage dialogStage;
    private Person person;
    private boolean okClicked = false;

    @FXML
    private void initialize() {
        setDayField();
    }

    @SuppressWarnings("exports")
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setDayField() {
        dayField.setText(LocalDate.now().toString());
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            if (person != null && person.getPresenze() != null) {
                int entranceHour = Integer.parseInt(entranceHourField.getText());
                int exitHour = Integer.parseInt(exitHourField.getText());
                Presence newPresence = new Presence(LocalDate.parse(dayField.getText()), entranceHour, exitHour);
                person.addPresenza(newPresence);
                okClicked = true;
                dialogStage.close();
            } else if (person == null) {
                System.out.println("person is null");
            } else if (person.getPresenze() == null) {
                System.out.println("List presenze is null");
            } else {
                System.out.println("Input is not valid");
            }
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = "";

        // Verifica che il campo dayField contenga una data valida
        try {
            LocalDate.parse(dayField.getText(), DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (DateTimeParseException e) {
            errorMessage += "Giorno non valido! Usa il formato AAAA-MM-GG.\n";
        }

        // Verifica che il campo entranceHourField contenga un'ora valida
        try {
            int entranceHour = Integer.parseInt(entranceHourField.getText());
            if (entranceHour < 9 || entranceHour > 22) {
                errorMessage += "Orario di arrivo non valido! Deve essere tra 9 e 22.\n";
            }
        } catch (NumberFormatException e) {
            errorMessage += "Orario di arrivo non valido! Deve essere un numero intero.\n";
        }

        // Verifica che il campo exitHourField contenga un'ora valida
        try {
            int exitHour = Integer.parseInt(exitHourField.getText());
            if (exitHour < 9 || exitHour > 22 || exitHour < Integer.parseInt(entranceHourField.getText())) {
                errorMessage += "Orario di uscita non valido! Deve essere tra 9 e 22 e maggiore dell'orario di arrivo.\n";
            }
        } catch (NumberFormatException e) {
            errorMessage += "Orario di uscita non valido! Deve essere un numero intero.\n";
        }

        if (errorMessage.isEmpty()) {
            return true;
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Campi non validi.");
            alert.setHeaderText("Per favore correggi i campi non validi.");
            alert.setContentText(errorMessage);
            
            alert.showAndWait();
            
            return false;
        }
    }
}