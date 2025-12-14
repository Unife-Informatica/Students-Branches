package com.example.ui;

import com.example.model.Cliente;
import com.example.storage.DatabaseClienti;

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

public class ClientiView {

    private static ObservableList<Cliente> Clienti;

    public static Scene getSceneClienti(Stage stage) {

        stage.setTitle("GESTIONE CLIENTI");
        HBox navBar = MenuComponent.getMenu(stage);

        // CARICA CLIENTI

        Clienti = FXCollections.observableArrayList(DatabaseClienti.caricaClienti());

        // RICERCA

        TextField cerca = new TextField();
        cerca.setPromptText("Cerca per ID, Nome, Cognome, Eta, Email, Numero telefono");

        FilteredList<Cliente> filteredClienti = new FilteredList<>(Clienti, p -> true);

        cerca.textProperty().addListener((obs, oldText, newText) -> {
            String filtro = newText.toLowerCase().trim();
            filteredClienti.setPredicate(u -> {
                if (filtro.isEmpty()) return true;
                return u.getId().toLowerCase().contains(filtro)
                    || u.getNome().toLowerCase().contains(filtro)
                    || u.getCognome().toLowerCase().contains(filtro)
                    || Integer.toString(u.getEta()).toLowerCase().contains(filtro)
                    || u.getEmail().toLowerCase().contains(filtro)
                    || u.getNumTelefono().toLowerCase().contains(filtro);
            });
        });

        HBox barraRicerca = new HBox(cerca);
        barraRicerca.setSpacing(10);
        HBox.setHgrow(cerca, Priority.ALWAYS);

        TableView<Cliente> table = new TableView<>(filteredClienti);

        TableColumn<Cliente, String> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Cliente, String> colNome = new TableColumn<>("Nome");
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        TableColumn<Cliente, String> colCognome = new TableColumn<>("Cognome");
        colCognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));

        TableColumn<Cliente, Integer> colEta = new TableColumn<>("Età");
        colEta.setCellValueFactory(new PropertyValueFactory<>("eta"));

        TableColumn<Cliente, String> colEmail = new TableColumn<>("Email");
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Cliente, String> colTel = new TableColumn<>("Tel");
        colTel.setCellValueFactory(new PropertyValueFactory<>("numTelefono"));

        table.getColumns().addAll(colId, colNome, colCognome, colEta, colEmail, colTel);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // Pulsanti
        Button btnAggiungi = new Button("Aggiungi");

        Button btnModifica = new Button("Modifica");

        Button btnRimuovi = new Button("Rimuovi");

        HBox hbAzioni = new HBox(10, btnAggiungi, btnModifica, btnRimuovi);

        Runnable aggiorna = () -> {
            table.refresh();
            DatabaseClienti.salvaCliente(Clienti);
        };

        // AGGIUNGI

        btnAggiungi.setOnAction(e -> apriForm(null, aggiorna));

        // MODIFICA

        btnModifica.setOnAction(e -> {
            Cliente selezionato = table.getSelectionModel().getSelectedItem();
            if (selezionato != null) {
                apriForm(selezionato, aggiorna);
            } else {
                new Alert(Alert.AlertType.WARNING, "Seleziona un Cliente da modificare!", ButtonType.OK).showAndWait();
            }
        });

        // RIMUOVI

        btnRimuovi.setOnAction(e -> {
            Cliente selezionato = table.getSelectionModel().getSelectedItem();
            if (selezionato != null) {
                Clienti.remove(selezionato);
                DatabaseClienti.salvaCliente(Clienti);
            } else {
                new Alert(Alert.AlertType.WARNING, "Seleziona un Cliente da rimuovere!", ButtonType.OK).showAndWait();
            }
        });

        VBox root = new VBox(10, navBar, barraRicerca, table, hbAzioni);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 1200, 800);
        stage.setScene(scene);

        return scene;
    }

    // AGGIUNTA e MODIFICA

    private static void apriForm(Cliente Cliente, Runnable onSave) {

        Stage formStage = new Stage();
        formStage.setTitle(Cliente == null ? "Aggiungi Cliente" : "Modifica Cliente");

        TextField tfId = new TextField(Cliente == null ? "" : Cliente.getId());
        TextField tfNome = new TextField(Cliente == null ? "" : Cliente.getNome());
        TextField tfCognome = new TextField(Cliente == null ? "" : Cliente.getCognome());
        TextField tfEta = new TextField(Cliente == null ? "" : String.valueOf(Cliente.getEta()));
        TextField tfEmail = new TextField(Cliente == null ? "" : Cliente.getEmail());
        TextField tfNumTel = new TextField(Cliente == null ? "" : Cliente.getNumTelefono());

        tfId.setPromptText("ID");
        tfNome.setPromptText("Nome");
        tfCognome.setPromptText("Cognome");
        tfEta.setPromptText("Età");
        tfEmail.setPromptText("Email");
        tfNumTel.setPromptText("NumTel");

        Button btnSalva = new Button("Salva");

        btnSalva.setOnAction(e -> {

            if (tfId.getText().isEmpty() ||
                tfNome.getText().isEmpty() ||
                tfCognome.getText().isEmpty() ||
                tfEta.getText().isEmpty() ||
                tfEmail.getText().isEmpty() ||
                tfNumTel.getText().isEmpty()) {

                new Alert(Alert.AlertType.WARNING, "Tutti i campi sono obbligatori.", ButtonType.OK).showAndWait();
                return;
            }

            int eta;
            try {
                eta = Integer.parseInt(tfEta.getText());
            }catch(NumberFormatException ex) {
                new Alert(Alert.AlertType.ERROR, "L'età deve essere un numero",
                ButtonType.OK).showAndWait();
                return;
            }

            if (Cliente == null) {
                // Aggiungi
                Clienti.add(new Cliente(
                    tfId.getText(),
                    tfNome.getText(),
                    tfCognome.getText(),
                    eta,
                    tfEmail.getText(),
                    tfNumTel.getText()
                ));
            } else {
                // Modifica
                Cliente.setId(tfId.getText());
                Cliente.setNome(tfNome.getText());
                Cliente.setCognome(tfCognome.getText());
                Cliente.setEta(eta);
                Cliente.setEmail(tfEmail.getText());
                Cliente.setNumTel(tfNumTel.getText());
            }

            onSave.run();
            formStage.close();
        });

        VBox form = new VBox(10, tfId, tfNome, tfCognome, tfEta, tfEmail, tfNumTel, btnSalva);
        form.setPadding(new Insets(15));

        Scene sceneForm = new Scene(form, 400, 330);
        formStage.setScene(sceneForm);
        formStage.show();
    }
}
