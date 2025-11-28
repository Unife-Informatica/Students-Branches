package it.unife.lp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import it.unife.lp.model.Activity;
import it.unife.lp.model.Person;
import it.unife.lp.view.ActivityEditDialogController;
import it.unife.lp.view.ActivityOverviewController;
import it.unife.lp.view.ActivitySubEditDialogController;
import it.unife.lp.view.PersonEditDialogController;
import it.unife.lp.view.PersonOverviewController;
import it.unife.lp.view.PresenceEditDialogController;
import it.unife.lp.view.PresenceStatisticsController;
import it.unife.lp.view.PresencesOverviewController;
import it.unife.lp.view.RootLayoutController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Person> personData = FXCollections.observableArrayList();
    private ObservableList<Activity> activityData = FXCollections.observableArrayList();

    public MainApp() {
        personData.add(new Person("Harry", "Potter"));
        personData.add(new Person("Ronald", "Wisley"));
        personData.add(new Person("Hermione", "Granger"));
        personData.add(new Person("Nevil", "Pachoc"));
        personData.add(new Person("Rubeus", "Hagrid"));
        personData.add(new Person("Sirius", "Black"));
        personData.add(new Person("Albus", "Silente"));
        personData.add(new Person("Minerva", "McGranitt"));
        personData.add(new Person("Severus", "Piton"));

        activityData.add(new Activity("Calisthenics", "Michael Jackson"));
        activityData.add(new Activity("Yoga", "Emanuela Antolini"));
        activityData.add(new Activity("Aerobica", "Gabriele Munari"));
    }

    public ObservableList<Person> getPersonData() {
        return personData;
    }

    public ObservableList<Activity> getActivityData() {
        return activityData;
    }

    public ObservableList<Person> getSubData() {
        return activityData.get(0).getIscritti();
    }

    @Override
    @SuppressWarnings("exports")
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Gym Manager");

        initRootLayout();

        // Carica i dati dai file all'avvio
        File personFile = getPersonFilePath();
        if (personFile != null) {
            loadPersonDataFromFile(personFile);
        }

        File activityFile = getActivityFilePath();
        if (activityFile != null) {
            loadActivityDataFromFile(activityFile);
        }
    }

    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);
            primaryStage.setMaximized(true);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //funzioni per il salvataggio dei dati

    //get...FilePath
    public File getPersonFilePath() {
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        String filePath = prefs.get("filePath", null);
        if (filePath != null) {
            return new File(filePath);
        } else {
            return null;
        }
    }
    public File getActivityFilePath() {
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        String filePath = prefs.get("activityFilePath", null);
        if (filePath != null) {
            return new File(filePath);
        } else {
            return null;
        }
    }

    //set...FilePath
    public void setPersonFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        if (file != null) {
            //salva il percorso del file come una stringa nel file di preferenze
            prefs.put("filePath", file.getPath());

            //Aggiorna il titolo dell'applicazione
            primaryStage.setTitle("Gym Manager - " + file.getName());
        } else {

            //se il file è null, rimuove il percorso del file dal file di preferenze
            prefs.remove("filePath");

            //Aggiorna il titolo dell'applicazione
            primaryStage.setTitle("Gym Manager");
        }
    }
    public void setActivityFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        if (file != null) {
            prefs.put("activityFilePath", file.getPath());
            primaryStage.setTitle("Gym Manager - " + file.getName());
        } else {
            prefs.remove("activityFilePath");
            primaryStage.setTitle("Gym Manager");
        }
    }

    //load...DataFromFile
    public void loadPersonDataFromFile(File personFile) {
        try {
            if (!personFile.exists()) {
                personFile = new File("C:/Users/loren/Desktop/progettoJava/data/personData.json");
                if (!personFile.exists()) {
                    personFile.createNewFile();
                }
            }
            // classe principale di jackson per serial. / deserial.
            ObjectMapper mapper = new ObjectMapper();

            //Questa configurazione abilita l'output formattato (con indentazione) del JSON.
            mapper.registerModule(new JavaTimeModule());

            //deserializza il file JSON specificato in un oggetto di tipo List<Person>.
            List<Person> persons = mapper.readValue(personFile, new TypeReference<List<Person>>() {});

            //aggiorna la lista osservabile personData con i dati deserializzati.
            personData.setAll(FXCollections.observableArrayList(persons));

            //imposta il percorso del file come percorso del file specificato.
            setPersonFilePath(personFile);
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not load data");
            alert.setContentText("loadPerson: Could not load data from file:\n" + personFile.getPath());
            e.printStackTrace();
            System.out.println(e);
            alert.showAndWait();
        }
    }
    public void loadActivityDataFromFile(File activityFile) {
        try {
            if (!activityFile.exists()) {
                activityFile = new File("C:/Users/loren/Desktop/progettoJava/data/activityData.json");
                if (!activityFile.exists()) {
                    activityFile.createNewFile();
                }
            }
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            List<Activity> activities = mapper.readValue(activityFile, new TypeReference<List<Activity>>() {});
            activityData.setAll(FXCollections.observableArrayList(activities));
            System.out.println(activityData);

            setActivityFilePath(activityFile);
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not load data");
            alert.setContentText("loadActivity: Could not load data from file:\n" + activityFile.getPath());
            e.printStackTrace();
            System.out.println(e);
            alert.showAndWait();
        }
    }

    //save...DataToFile
    public void savePersonDataToFile(File file) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            for(Person p : personData) {
                p.getPresenze().removeIf(
                    presence -> presence.getDate() == null 
                    || presence.getEntranceHour() == 0
                    || presence.getExitHour() == 0
                );
            }
            // classe principale di jackson per serial. / deserial.
            ObjectMapper mapper = new ObjectMapper(); 

            //Questa configurazione abilita l'output formattato (con indentazione) del JSON.
            mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            
            //modulo di Jackson che aggiunge il supporto per le nuove API di data e ora di Java 8
            mapper.registerModule(new JavaTimeModule());

            //serializza l'oggetto personData in JSON e lo scrive nel file specificato. 
            //file è un'istanza di File che rappresenta il file di destinazione.
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, new ArrayList<>(personData));

            //imposta il percorso del file come percorso del file specificato.
            setPersonFilePath(file);
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not save data");
            alert.setContentText("savePerson: Could not save data to file:\n" + file.getPath());
            e.printStackTrace();
            alert.showAndWait();
        }
    }
    public void saveActivityDataToFile(File file) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            mapper.registerModule(new JavaTimeModule());
            mapper.writeValue(file, activityData);
            
            setActivityFilePath(file);
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not save data");
            alert.setContentText("saveActivity: Could not save data to file:\n" + file.getPath());
            e.printStackTrace();
            alert.showAndWait();
        }
    }


    //funzioni per la gestione delle finestre
    public void showPersonOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PersonOverview.fxml"));
            HBox personOverview = (HBox) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Gestione membri");
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(personOverview);
            dialogStage.setScene(scene);

            PersonOverviewController controller = loader.getController();
            controller.setMainApp(this);

            dialogStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showActivityOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/ActivityOverview.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Attività");
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            ActivityOverviewController controller = loader.getController();
            controller.setMainApp(this);

            dialogStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showPresencesOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PresencesOverview.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Presenze");
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            PresencesOverviewController controller = loader.getController();
            controller.setMainApp(this);

            dialogStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public boolean showPersonEditDialog(Person person) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PersonEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            PersonEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(person);
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean showActivitySubEditDialog(Activity activity) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/ActivitySubEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Nuova iscrizione");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            ActivitySubEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setActivity(activity);
            controller.setMainApp(this);

            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean showActivityEditDialog(Activity activity) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/ActivityEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Modifica attività");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            ActivityEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setAct(activity);
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @SuppressWarnings("exports")
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public boolean showPresenceEditDialog(Person person) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PresenceEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Nuova presenza");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            PresenceEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(person);
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void showPresenceStatistics() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PresenceStatistics.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Presence Statistics");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
    
            PresenceStatisticsController controller = loader.getController();
            controller.setPersonData(personData);
    
            dialogStage.show();
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}