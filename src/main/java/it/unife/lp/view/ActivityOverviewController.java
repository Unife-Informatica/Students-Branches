package it.unife.lp.view;

import it.unife.lp.MainApp;
import it.unife.lp.model.Activity;
import it.unife.lp.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ActivityOverviewController {
    @FXML
    private TableView<Activity> activityTable;
    @FXML
    private TableColumn<Activity, String> activityColummn;
    @FXML
    private TableView<Person> subTable;
    @FXML
    private TableColumn<Person, String> subNameColumn;
    @FXML
    private TableColumn<Person, String> subSurnameColumn;
    @FXML
    private Label classNameLabel;
    @FXML
    private Label teacherLabel;
    @FXML
    private Label hourLabel;
    @FXML
    private Label descLabel;

    private MainApp mainApp;

    private Activity currentActivity;

    public void setCurrentActivity(Activity activity) {
        this.currentActivity = activity;
    }

    public ActivityOverviewController() {
    }

    @FXML
    private void initialize() {
        activityColummn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        subNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        subSurnameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());

        showClassDetails(null);

        activityTable.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) ->  {
                setCurrentActivity(newValue);
                showClassDetails(newValue);
                if(newValue != null) {
                    subTable.setItems(newValue.getIscritti());
                } else {
                    subTable.setItems(null);
                }           
            }
        );
    }
        
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        activityTable.setItems(mainApp.getActivityData());
        if(currentActivity != null) {
            subTable.setItems(mainApp.getSubData());
        } else {
            subTable.setItems(null);
        }
    }
        
    private void showClassDetails(Activity activity) {
        if (activity != null) {
            classNameLabel.setText(activity.getNome());
            teacherLabel.setText(activity.getIstruttore());
            hourLabel.setText(activity.getOrario());
            descLabel.setText(activity.getDescrizione());
        } else {
            classNameLabel.setText("");
            teacherLabel.setText("");
            hourLabel.setText("");
            descLabel.setText("");
        }
    }

     @FXML
    private void handleDeleteActivity() {
        int selectedIndex = activityTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            activityTable.getItems().remove(selectedIndex);
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Attenzione");
            alert.setHeaderText("Nessun Attività selezionata.");
            alert.showAndWait();
        }
    }

    //funzioni activity

    @FXML
    private void handleNewActivity() {
        Activity tempAct = new Activity();
        boolean okClicked = mainApp.showActivityEditDialog(tempAct);
        if (okClicked) {
            mainApp.getActivityData().add(tempAct);
        }
    }

    
    @FXML
    private void handleEditActivity() {
        Activity selectedAct = activityTable.getSelectionModel().getSelectedItem();
        if (selectedAct != null) {
            boolean okClicked = mainApp.showActivityEditDialog(selectedAct);
            if (okClicked) {
                showClassDetails(selectedAct);
            }
            
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Attenzione");
            alert.setHeaderText("Nessuna attività selezionata.");
            alert.showAndWait();
        }
    }

    //funzioni iscritti

    @FXML
    private void handleNewSub() {
        if (currentActivity != null) {
            boolean okClicked = mainApp.showActivitySubEditDialog(currentActivity);
            if (okClicked) {
                subTable.setItems(currentActivity.getIscritti());
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Attenzione");
            alert.setHeaderText("Nessuna attività selezionata.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleDeleteSub() {
        int selectedIndex = subTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            subTable.getItems().remove(selectedIndex);
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Attenzione");
            alert.setHeaderText("Nessun iscritto selezionato.");
            alert.showAndWait();
        }
    }
}
