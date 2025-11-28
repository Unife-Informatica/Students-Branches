package it.unife.lp.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import it.unife.lp.model.Activity;

public class ActivityEditDialogController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField teacherField;
    @FXML
    private TextField hourField;
    @FXML
    private TextField descField;

    private Stage dialogStage;
    private Activity activity;
    private boolean okClicked = false;

    @FXML
    private void initialize() {
    }

    @SuppressWarnings("exports")
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setAct(Activity activity) {
        this.activity = activity;

        nameField.setText(activity.getNome());
        teacherField.setText(activity.getIstruttore());
        hourField.setText(activity.getOrario());
        descField.setText(activity.getDescrizione());
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            activity.setNome(nameField.getText());
            activity.setIstruttore(teacherField.getText());
            activity.setOrario(hourField.getText());
            activity.setDescrizione(descField.getText());
            
            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (nameField.getText() == null || nameField.getText().isEmpty()) {
            errorMessage += "Nome non valido!\n"; 
        }
        if (teacherField.getText() == null || teacherField.getText().isEmpty()) {
            errorMessage += "Nome istruttore non valido!\n"; 
        }
        if (hourField.getText() == null || hourField.getText().isEmpty()) {
            errorMessage += "orario non valido!\n"; 
        }

        if (descField.getText() == null || descField.getText().isEmpty()) {
            errorMessage += "Descrizione non valida!\n"; 
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
