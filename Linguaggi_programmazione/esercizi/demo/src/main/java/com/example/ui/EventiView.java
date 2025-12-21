package com.example.ui;

import com.example.model.Evento;
import com.example.storage.DatabaseEventi;

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

public class EventiView {
   private static ObservableList<Evento> Eventi;

    public static Scene getSceneEventi(Stage stage) {

        stage.setTitle("GESTIONE EVENTI");
        HBox navBar = MenuComponent.getMenu(stage);

        // CARICA EVENTI

        Eventi = FXCollections.observableArrayList(DatabaseEventi.caricaEventi());

        // RICERCA

        TextField cerca = new TextField();
        cerca.setPromptText("Cerca per ID, Data, Ora, Capienza max, Prezzo, Descrizione");

        FilteredList<Evento> filteredEventi = new FilteredList<>(Eventi, p -> true);

        cerca.textProperty().addListener((obs, oldText, newText) -> {
            String filtro = newText.toLowerCase().trim();
            filteredEventi.setPredicate(u -> {
                if (filtro.isEmpty()) return true;
                return u.getId().toLowerCase().contains(filtro)
                    || u.getData().toLowerCase().contains(filtro)
                    || Integer.toString(u.getOra()).toLowerCase().contains(filtro)
                    || Integer.toString(u.getCapienzaMax()).toLowerCase().contains(filtro)
                    || Double.toString(u.getPrezzoBiglietto()).toLowerCase().contains(filtro)
                    || u.getDescrizione().toLowerCase().contains(filtro);
            });
        });

        HBox barraRicerca = new HBox(cerca);
        barraRicerca.setSpacing(10);
        HBox.setHgrow(cerca, Priority.ALWAYS);

        TableView<Evento> table = new TableView<>(filteredEventi);

        TableColumn<Evento, String> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Evento, String> colData = new TableColumn<>("Data");
        colData.setCellValueFactory(new PropertyValueFactory<>("data"));

        TableColumn<Evento, Integer> colOra = new TableColumn<>("Ora");
        colOra.setCellValueFactory(new PropertyValueFactory<>("ora"));

        TableColumn<Evento, Integer> colCapienzaMax = new TableColumn<>("CapienzaMax");
        colCapienzaMax.setCellValueFactory(new PropertyValueFactory<>("capienzaMax"));

        TableColumn<Evento, Double> colPrezzoBiglietto = new TableColumn<>("Prezzo biglietto");
        colPrezzoBiglietto.setCellValueFactory(new PropertyValueFactory<>("prezzoBiglietto"));

        TableColumn<Evento, String> colDescrizione = new TableColumn<>("Descrizione");
        colDescrizione.setCellValueFactory(new PropertyValueFactory<>("descrizione"));

        table.getColumns().addAll(colId, colData, colOra, colCapienzaMax, colPrezzoBiglietto, colDescrizione);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // Pulsanti
        Button btnAggiungi = new Button("Aggiungi");

        Button btnModifica = new Button("Modifica");

        Button btnRimuovi = new Button("Rimuovi");

        HBox hbAzioni = new HBox(10, btnAggiungi, btnModifica, btnRimuovi);

        Runnable aggiorna = () -> {
            table.refresh();
            DatabaseEventi.salvaEvento(Eventi);
        };

        // AGGIUNGI

        btnAggiungi.setOnAction(e -> apriForm(null, aggiorna));

        // MODIFICA

        btnModifica.setOnAction(e -> {
            Evento selezionato = table.getSelectionModel().getSelectedItem();
            if (selezionato != null) {
                apriForm(selezionato, aggiorna);
            } else {
                new Alert(Alert.AlertType.WARNING, "Seleziona un evento da modificare!", ButtonType.OK).showAndWait();
            }
        });

        // RIMUOVI

        btnRimuovi.setOnAction(e -> {
            Evento selezionato = table.getSelectionModel().getSelectedItem();
            if (selezionato != null) {
                Eventi.remove(selezionato);
                DatabaseEventi.salvaEvento(Eventi);
            } else {
                new Alert(Alert.AlertType.WARNING, "Seleziona un Evento da rimuovere!", ButtonType.OK).showAndWait();
            }
        });

        VBox root = new VBox(10, navBar, barraRicerca, table, hbAzioni);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 1200, 800);
        stage.setScene(scene);

        scene.getStylesheets().add(
        ClientiView.class.getResource("/style.css").toExternalForm()
        );

        return scene;
    }

    // AGGIUNTA e MODIFICA

    private static void apriForm(Evento Evento, Runnable onSave) {

        Stage formStage = new Stage();
        formStage.setTitle(Evento == null ? "Aggiungi Evento" : "Modifica Evento");

        TextField tfId = new TextField(Evento == null ? "" : Evento.getId());
        TextField tfData = new TextField(Evento == null ? "" : Evento.getData());
        TextField tfOra = new TextField(Evento == null ? "" : String.valueOf(Evento.getOra()));
        TextField tfCapienzaMax = new TextField(Evento == null ? "" : String.valueOf(Evento.getCapienzaMax()));
        TextField tfPrezzoBiglietto = new TextField(Evento == null ? "" : String.valueOf(Evento.getPrezzoBiglietto()));
        TextField tfDescrizione = new TextField(Evento == null ? "" : Evento.getDescrizione());

        tfId.setPromptText("ID");
        tfData.setPromptText("Data");
        tfOra.setPromptText("Ora");
        tfCapienzaMax.setPromptText("Capienza Massima");
        tfPrezzoBiglietto.setPromptText("Prezzo Biglietto");
        tfDescrizione.setPromptText("Descrizione");

        Button btnSalva = new Button("Salva");

        btnSalva.setOnAction(e -> {

            if (tfId.getText().isEmpty() ||
                tfData.getText().isEmpty() ||
                tfOra.getText().isEmpty() ||
                tfCapienzaMax.getText().isEmpty() ||
                tfPrezzoBiglietto.getText().isEmpty() ||
                tfDescrizione.getText().isEmpty()) {

                new Alert(Alert.AlertType.WARNING, "Tutti i campi sono obbligatori.", ButtonType.OK).showAndWait();
                return;
            }

            int ora;
            try {
                ora = Integer.parseInt(tfOra.getText());
            }catch(NumberFormatException ex) {
                new Alert(Alert.AlertType.ERROR, "L'ora deve essere un numero",
                ButtonType.OK).showAndWait();
                return;
            }

            int capienza;
            try {
                capienza = Integer.parseInt(tfCapienzaMax.getText());
            }catch(NumberFormatException ex) {
                new Alert(Alert.AlertType.ERROR, "La capienza deve essere un numero",
                ButtonType.OK).showAndWait();
                return;
            }

            double prezzo;
            try {
                prezzo = Integer.parseInt(tfPrezzoBiglietto.getText());
            }catch(NumberFormatException ex) {
                new Alert(Alert.AlertType.ERROR, "Il prezzo deve essere un numero",
                ButtonType.OK).showAndWait();
                return;
            }

            if (Evento == null) {
                // Aggiungi
                Eventi.add(new Evento(
                    tfId.getText(),
                    tfData.getText(),
                    ora,
                    capienza,
                    prezzo,
                    tfDescrizione.getText()
                ));
            } else {
                // Modifica
                Evento.setId(tfId.getText());
                Evento.setData(tfData.getText());
                Evento.setOra(ora);
                Evento.setCapienzaMax(capienza);
                Evento.setPrezzoBiglietto(prezzo);
                Evento.setDescrizione(tfDescrizione.getText());
            }

            onSave.run();
            formStage.close();
        });

        VBox form = new VBox(10, tfId, tfData, tfOra, tfCapienzaMax, tfPrezzoBiglietto, tfDescrizione, btnSalva);
        form.setPadding(new Insets(15));

        Scene sceneForm = new Scene(form, 400, 330);

        sceneForm.getStylesheets().add(
        ClientiView.class.getResource("/style.css").toExternalForm()
        );

        formStage.setScene(sceneForm);
        formStage.show();
    }
}
