package com.example.ui;

import com.example.model.Utente;
import com.example.storage.DatabaseUtenti;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UtentiView {

    private static ObservableList<Utente> utenti;

    public static Scene getSceneUtenti(Stage stage) {

        stage.setTitle("Gestione Utenti");
        HBox navBar = MenuComponent.getMenu(stage);

        utenti = FXCollections.observableArrayList(DatabaseUtenti.caricaUtenti());

        TextField cerca = new TextField();
        cerca.setPromptText("Cerca per ID, Nome, Cognome, Email");
        cerca.getStyleClass().add("fieldCerca");

        FilteredList<Utente> filteredUtenti = new FilteredList<>(utenti, p -> true);

        cerca.textProperty().addListener((obs, oldText, newText) -> {
            String filtro = newText.toLowerCase().trim();
            filteredUtenti.setPredicate(u -> filtro.isEmpty()
                    || u.getId().toLowerCase().contains(filtro)
                    || u.getNome().toLowerCase().contains(filtro)
                    || u.getCognome().toLowerCase().contains(filtro)
                    || u.getEmail().toLowerCase().contains(filtro));
        });

        HBox barraRicerca = new HBox(cerca);
        HBox.setHgrow(cerca, Priority.ALWAYS);

        TableView<Utente> table = new TableView<>(filteredUtenti);

        TableColumn<Utente, String> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Utente, String> colNome = new TableColumn<>("Nome");
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        TableColumn<Utente, String> colCognome = new TableColumn<>("Cognome");
        colCognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));

        TableColumn<Utente, String> colEmail = new TableColumn<>("Email");
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        table.getColumns().addAll(colId, colNome, colCognome, colEmail);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        Button btnAggiungi = new Button("Aggiungi");
        Button btnModifica = new Button("Modifica");
        Button btnRimuovi = new Button("Rimuovi");

        btnAggiungi.getStyleClass().add("btn");
        btnModifica.getStyleClass().add("btn");
        btnRimuovi.getStyleClass().add("btn");

        HBox hbAzioni = new HBox(10, btnAggiungi, btnModifica, btnRimuovi);

        Runnable aggiorna = () -> {
            table.refresh();
            DatabaseUtenti.salvaUtenti(utenti);
        };

        btnAggiungi.setOnAction(e -> apriForm(null, aggiorna));

        btnModifica.setOnAction(e -> {
            Utente selezionato = table.getSelectionModel().getSelectedItem();
            if (selezionato != null) {
                apriForm(selezionato, aggiorna);
            } else {
                new Alert(Alert.AlertType.WARNING, "Seleziona un utente da modificare!", ButtonType.OK).showAndWait();
            }
        });

        btnRimuovi.setOnAction(e -> {
            Utente selezionato = table.getSelectionModel().getSelectedItem();
            if (selezionato != null) {
                utenti.remove(selezionato);
                DatabaseUtenti.salvaUtenti(utenti);
            } else {
                new Alert(Alert.AlertType.WARNING, "Seleziona un utente da rimuovere!", ButtonType.OK).showAndWait();
            }
        });

        VBox root = new VBox(10, navBar, barraRicerca, table, hbAzioni);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 1200, 800);
        scene.getStylesheets().add(UtentiView.class.getResource("/style.css").toExternalForm());
        stage.setScene(scene);

        return scene;
    }

    private static void apriForm(Utente utente, Runnable onSave) {

        Stage formStage = new Stage();
        formStage.setTitle(utente == null ? "Aggiungi Utente" : "Modifica Utente");

        TextField tfId = new TextField(utente == null ? "" : utente.getId());
        TextField tfNome = new TextField(utente == null ? "" : utente.getNome());
        TextField tfCognome = new TextField(utente == null ? "" : utente.getCognome());
        TextField tfEmail = new TextField(utente == null ? "" : utente.getEmail());

        tfId.setPromptText("ID");
        tfNome.setPromptText("Nome");
        tfCognome.setPromptText("Cognome");
        tfEmail.setPromptText("Email");

        Button btnSalva = new Button("Salva");
        btnSalva.getStyleClass().add("btn");

        btnSalva.setOnAction(e -> {
            if (tfId.getText().isEmpty() || tfNome.getText().isEmpty()
                    || tfCognome.getText().isEmpty() || tfEmail.getText().isEmpty()) {
                new Alert(Alert.AlertType.WARNING, "Tutti i campi sono obbligatori.", ButtonType.OK).showAndWait();
                return;
            }

            if (utente == null) {
                utenti.add(new Utente(tfId.getText(), tfNome.getText(), tfCognome.getText(), tfEmail.getText()));
            } else {
                utente.setId(tfId.getText());
                utente.setNome(tfNome.getText());
                utente.setCognome(tfCognome.getText());
                utente.setEmail(tfEmail.getText());
            }

            onSave.run();
            formStage.close();
        });

        VBox form = new VBox(10, tfId, tfNome, tfCognome, tfEmail, btnSalva);
        form.setPadding(new Insets(15));

        Scene sceneForm = new Scene(form, 400, 330);
        sceneForm.getStylesheets().add(UtentiView.class.getResource("/style.css").toExternalForm());
        formStage.setScene(sceneForm);
        formStage.show();
    }
}
