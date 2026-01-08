package com.example.ui;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import com.example.model.Libro;
import com.example.model.Prestito;
import com.example.model.Utente;
import com.example.storage.DatabaseLibri;
import com.example.storage.DatabasePrestito;
import com.example.storage.DatabaseUtenti;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PrestitiView {

    private static ObservableList<Prestito> prestiti;

    public static Scene getScenePrestiti(Stage stage) {

        stage.setTitle("Gestione Prestiti");

        HBox navBar = MenuComponent.getMenu(stage);

        prestiti = FXCollections.observableArrayList(DatabasePrestito.caricaPrestiti());

        TextField cerca = new TextField();
        cerca.setPromptText("Cerca per ISBN o Nome Utente");
        cerca.getStyleClass().add("fieldCerca");

        FilteredList<Prestito> filtered = new FilteredList<>(prestiti, p -> true);

        cerca.textProperty().addListener((obs, old, neu) -> {
            String filtro = neu.toLowerCase().trim();
            filtered.setPredicate(p -> filtro.isEmpty() 
                    || p.getISBN().toLowerCase().contains(filtro) 
                    || p.getUtente().getNome().toLowerCase().contains(filtro));
        });

        HBox barraRicerca = new HBox(cerca);
        HBox.setHgrow(cerca, Priority.ALWAYS);

        TableView<Prestito> table = new TableView<>(filtered);

        TableColumn<Prestito, String> colISBN = new TableColumn<>("ISBN");
        colISBN.setCellValueFactory(new PropertyValueFactory<>("ISBN"));

        TableColumn<Prestito, String> colUtente = new TableColumn<>("Utente");
        colUtente.setCellValueFactory(c ->
                new javafx.beans.property.SimpleStringProperty(
                        c.getValue().getUtente().getNome() + " " + c.getValue().getUtente().getCognome()
                )
        );

        TableColumn<Prestito, Date> colDataI = new TableColumn<>("Inizio Prestito");
        colDataI.setCellValueFactory(new PropertyValueFactory<>("dataInizio"));

        TableColumn<Prestito, Date> colDataF = new TableColumn<>("Restituzione Prevista");
        colDataF.setCellValueFactory(new PropertyValueFactory<>("dataFinePrevista"));

        TableColumn<Prestito, Boolean> colAttivo = new TableColumn<>("Attivo");
        colAttivo.setCellValueFactory(new PropertyValueFactory<>("attivo"));

        table.getColumns().addAll(colISBN, colUtente, colDataI, colDataF, colAttivo);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        table.setRowFactory(tv -> new TableRow<>() {
            @Override
            protected void updateItem(Prestito item, boolean empty) {
                super.updateItem(item, empty);
                getStyleClass().removeAll("table-row-attivo", "table-row-chiuso");
                if (item != null && !empty) {
                    getStyleClass().add(item.isAttivo() ? "table-row-attivo" : "table-row-chiuso");
                } else {
                    setStyle("");
                }
            }
        });

        table.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                Prestito p = table.getSelectionModel().getSelectedItem();
                if (p != null) {
                    ClipboardContent content = new ClipboardContent();
                    content.putString("ISBN: " + p.getISBN() + ", Utente: " 
                            + p.getUtente().getNome() + " " + p.getUtente().getCognome());
                    Clipboard.getSystemClipboard().setContent(content);
                    new Alert(Alert.AlertType.INFORMATION, "Prestito copiato negli appunti!", ButtonType.OK).showAndWait();
                }
            }
        });

        Button btnAggiungi = new Button("Nuovo Prestito");
        Button btnRestituisci = new Button("Restituisci");
        Button btnRimuovi = new Button("Rimuovi");

        btnAggiungi.getStyleClass().add("btn");
        btnRestituisci.getStyleClass().add("btn");
        btnRimuovi.getStyleClass().add("btn");

        HBox hbAzioni = new HBox(10, btnAggiungi, btnRestituisci, btnRimuovi);
        hbAzioni.setPadding(new Insets(10, 0, 0, 0));

        btnRimuovi.setOnAction(e -> {
            Prestito p = table.getSelectionModel().getSelectedItem();
            if (p != null) {
                prestiti.remove(p);
                DatabasePrestito.salvaPrestiti(prestiti);
            } else {
                new Alert(Alert.AlertType.WARNING, "Seleziona un prestito da rimuovere!", ButtonType.OK).showAndWait();
            }
        });

        btnRestituisci.setOnAction(e -> {
            Prestito p = table.getSelectionModel().getSelectedItem();
            if (p != null) {
                if (!p.isAttivo()) {
                    new Alert(Alert.AlertType.INFORMATION, "Questo prestito è già chiuso!", ButtonType.OK).showAndWait();
                    return;
                }
                Alert conferma = new Alert(Alert.AlertType.CONFIRMATION, "Confermi la restituzione del libro?", ButtonType.YES, ButtonType.NO);
                conferma.showAndWait();
                if (conferma.getResult() == ButtonType.YES) {
                    p.setAttivo(false);
                    table.refresh();
                    DatabasePrestito.salvaPrestiti(prestiti);
                }
            } else {
                new Alert(Alert.AlertType.WARNING, "Seleziona un prestito!", ButtonType.OK).showAndWait();
            }
        });

        btnAggiungi.setOnAction(e -> apriFormPrestito(table));

        VBox root = new VBox(10, navBar, barraRicerca, table, hbAzioni);
        root.setPadding(new Insets(15));

        Scene scene = new Scene(root, 1200, 800);
        scene.getStylesheets().add(PrestitiView.class.getResource("/style.css").toExternalForm());
        stage.setScene(scene);

        return scene;
    }

    private static void apriFormPrestito(TableView<Prestito> table) {
        Stage formStage = new Stage();
        formStage.setTitle("Nuovo Prestito");

        ObservableList<Libro> libri = FXCollections.observableArrayList(DatabaseLibri.caricaLibri());
        ObservableList<Utente> utenti = FXCollections.observableArrayList(DatabaseUtenti.caricaUtenti());

        TextField tfLibro = new TextField();
        tfLibro.setPromptText("Cerca libro per titolo o ISBN...");
        tfLibro.getStyleClass().add("fieldCerca");
        ListView<Libro> lvLibri = new ListView<>(libri);
        lvLibri.setMaxHeight(150);
        FilteredList<Libro> filteredLibri = new FilteredList<>(libri, l -> true);
        lvLibri.setItems(filteredLibri);
        tfLibro.textProperty().addListener((obs, oldVal, newVal) -> {
            String filtro = newVal.toLowerCase().trim();
            filteredLibri.setPredicate(l -> l.getTitolo().toLowerCase().contains(filtro) 
                    || l.getISBN().toLowerCase().contains(filtro));
        });

        TextField tfUtente = new TextField();
        tfUtente.setPromptText("Cerca utente per nome o cognome...");
        tfUtente.getStyleClass().add("fieldCerca");
        ListView<Utente> lvUtenti = new ListView<>(utenti);
        lvUtenti.setMaxHeight(150);
        FilteredList<Utente> filteredUtenti = new FilteredList<>(utenti, u -> true);
        lvUtenti.setItems(filteredUtenti);
        tfUtente.textProperty().addListener((obs, oldVal, newVal) -> {
            String filtro = newVal.toLowerCase().trim();
            filteredUtenti.setPredicate(u -> u.getNome().toLowerCase().contains(filtro) 
                    || u.getCognome().toLowerCase().contains(filtro));
        });

        DatePicker dpInizio = new DatePicker(LocalDate.now());
        DatePicker dpFine = new DatePicker(LocalDate.now().plusDays(30));

        Button btnSalva = new Button("Salva");
        btnSalva.getStyleClass().add("btn");

        btnSalva.setOnAction(e -> {
            Libro libroSelezionato = lvLibri.getSelectionModel().getSelectedItem();
            Utente utenteSelezionato = lvUtenti.getSelectionModel().getSelectedItem();

            if (libroSelezionato == null || utenteSelezionato == null) {
                new Alert(Alert.AlertType.WARNING, "Seleziona libro e utente!", ButtonType.OK).showAndWait();
                return;
            }

            Prestito nuovo = new Prestito(
                    libroSelezionato.getISBN(),
                    utenteSelezionato,
                    Date.from(dpInizio.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()),
                    Date.from(dpFine.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant())
            );

            prestiti.add(nuovo);
            table.refresh();
            DatabasePrestito.salvaPrestiti(prestiti);
            formStage.close();
        });

        VBox form = new VBox(10, tfLibro, lvLibri, tfUtente, lvUtenti, dpInizio, dpFine, btnSalva);
        form.setPadding(new Insets(15));

        Scene sceneForm = new Scene(form, 500, 600);
        sceneForm.getStylesheets().add(PrestitiView.class.getResource("/style.css").toExternalForm());
        formStage.setScene(sceneForm);
        formStage.show();
    }
}
