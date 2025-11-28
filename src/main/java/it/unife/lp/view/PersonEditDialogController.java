package it.unife.lp.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import it.unife.lp.model.Person;
import it.unife.lp.util.DateUtil;

/**
 * Dialog to edit details of a person.
 * 
 * @author Marco Jakob
 */
public class PersonEditDialogController {

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField birthdayField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField subField;

    private Stage dialogStage;
    private Person person;
    private boolean okClicked = false;

    @FXML
    private void initialize() {
    }

    @SuppressWarnings("exports")
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setPerson(Person person) {
        this.person = person;

        firstNameField.setText(person.getNome());
        lastNameField.setText(person.getCognome());
        addressField.setText(person.getAddress());
        phoneField.setText(person.getPhone());
        emailField.setText(person.getEmail());
        birthdayField.setText(DateUtil.format(person.getBirthday()));
        birthdayField.setPromptText("dd.mm.yyyy");
        subField.setText(person.getIscritto());
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            person.setFirstName(firstNameField.getText());
            person.setLastName(lastNameField.getText());
            person.setAddress(addressField.getText());
            person.setPhone(phoneField.getText());
            person.setEmail(emailField.getText());
            person.setBirthday(DateUtil.parse(birthdayField.getText()));
            person.setIscritto(subField.getText());
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

        if (firstNameField.getText() == null || firstNameField.getText().isEmpty()) {
            errorMessage += "Nome non valido!\n"; 
        }
        if (lastNameField.getText() == null || lastNameField.getText().isEmpty()) {
            errorMessage += "Cognome non valido!\n"; 
        }
        if (addressField.getText() == null || addressField.getText().isEmpty()) {
            errorMessage += "Indirizzo non valido!\n"; 
        }

        if (phoneField.getText() == null || phoneField.getText().length() < 10 || !phoneField.getText().startsWith("3")) {
            errorMessage += "Cellulare non valido!\n"; 
        } 

        if (emailField.getText() == null || emailField.getText().isEmpty() || !emailField.getText().contains("@")) {
            errorMessage += "Email non valida!\n"; 
        }

        if (birthdayField.getText() == null || birthdayField.getText().isEmpty()) {
            errorMessage += "Data di nascita non valida!\n";
        } else {
            if (!DateUtil.validDate(birthdayField.getText())) {
                errorMessage += "Data di nascita non valia. Usare formato dd.mm.yyyy!\n";
            }
        }

        if (subField.getText() == null || subField.getText().isEmpty()) {
            errorMessage += "Campo Iscritto non valido!\n"; 
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
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
