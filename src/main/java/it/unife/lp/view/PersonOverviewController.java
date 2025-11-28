package it.unife.lp.view;

import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import it.unife.lp.MainApp;
import it.unife.lp.model.Person;
import it.unife.lp.util.DateUtil;

public class PersonOverviewController {
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;
    @FXML
    private TextField nameToSearch;
    @FXML
    private CheckBox activeSub;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label birthdayLabel;
    @FXML
    private Label addressLabel;
    @FXML
    private Label phoneLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label subLabel;

    private MainApp mainApp;

    public PersonOverviewController() {
    }

    @FXML
    private void initialize() {
        firstNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().lastNameProperty());
    
        showPersonDetails(null);
    
        // Listen for selection changes and show the person details when changed.
        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));
       
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        personTable.setItems(mainApp.getPersonData());
    }

    private void showPersonDetails(Person person) {
        if (person != null) {
            // Fill the labels with info from the person object.
            firstNameLabel.setText(person.getNome());
            lastNameLabel.setText(person.getCognome());
            addressLabel.setText(person.getAddress());
            phoneLabel.setText(person.getPhone());
            emailLabel.setText(person.getEmail());
            subLabel.setText(person.getIscritto());
            birthdayLabel.setText(DateUtil.format(person.getBirthday()));
        } else {
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            addressLabel.setText("");
            phoneLabel.setText("");
            emailLabel.setText("");
            birthdayLabel.setText("");
            subLabel.setText("");
        }
    }

    @FXML
    private void handleDeletePerson() {
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            //verifica che l'iscritto non sia iscritto ad alcuna attività
            if (mainApp.getActivityData().stream().anyMatch(activity -> activity.getIscritti().contains(personTable.getItems().get(selectedIndex)))) {
                mainApp.getActivityData().forEach(activity -> activity.getIscritti().remove(personTable.getItems().get(selectedIndex)));
            }
            personTable.getItems().remove(selectedIndex);
            
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Attenzione");
            alert.setHeaderText("Nessun Membro selezionato.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleNewPerson() {
        Person tempPerson = new Person();
        boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
        if (okClicked) {
            mainApp.getPersonData().add(tempPerson);
        }
    }

    @FXML
    private void handleEditPerson() {
        Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
            if (okClicked) {
                showPersonDetails(selectedPerson);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Attenzione");
            alert.setHeaderText("Nessun Membro selezionato.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handlerSearch() {
        String name = nameToSearch.getText();

        boolean active = activeSub.isSelected();

        if (name.isEmpty() && !active) { //00
            personTable.setItems(mainApp.getPersonData());
        } else if (name.isEmpty() && active){ //01
            personTable.setItems(mainApp.getPersonData().filtered(p -> p.getIscritto().equalsIgnoreCase("Si")));  
        } else if(!name.isEmpty() && !active) { //10
            FilteredList<Person> filteredName = new FilteredList<>(mainApp.getPersonData().filtered(p -> p.getNome().equalsIgnoreCase(name)));
            if (filteredName.isEmpty()) {
                filteredName = new FilteredList<>(mainApp.getPersonData().filtered(p -> p.getCognome().equalsIgnoreCase(name)));
                personTable.setItems(filteredName);
            } else {
                personTable.setItems(filteredName);
            }
            
            if (filteredName.isEmpty()) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.initOwner(mainApp.getPrimaryStage());
                alert.setTitle("Attenzione");
                alert.setHeaderText("Nessun Membro trovato.");
                alert.showAndWait();
            }
        } else if(!name.isEmpty() && active) { //11
            FilteredList<Person> filteredName = new FilteredList<>(mainApp.getPersonData().filtered(p -> p.getNome().equalsIgnoreCase(name)));
            if (filteredName.isEmpty()) {
                filteredName = new FilteredList<>(mainApp.getPersonData().filtered(p -> p.getCognome().equalsIgnoreCase(name)));
                personTable.setItems(filteredName.filtered(p -> p.getIscritto().equalsIgnoreCase("Si")));
            } else {
                personTable.setItems(filteredName.filtered(p -> p.getIscritto().equalsIgnoreCase("Si")));
            }
            
            if (filteredName.isEmpty()) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.initOwner(mainApp.getPrimaryStage());
                alert.setTitle("Attenzione");
                alert.setHeaderText("Nessun Membro trovato.");
                alert.showAndWait();
            }
        }

        nameToSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
            new Thread(() -> {
                try {
                Thread.sleep(500);
                if (nameToSearch.getText().isEmpty()) {
                    personTable.setItems(mainApp.getPersonData());
                }
                } catch (InterruptedException e) {
                e.printStackTrace();
                }
            }).start();
            }
        });
    }   
}