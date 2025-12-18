package com.example.ui;

import com.example.model.Libro;
import com.example.storage.DatabaseLibri;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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

public class LibriView {

    private static ObservableList<Libro> libri;

    @SuppressWarnings("deprecation")
    public static Scene getSceneLibri(Stage stage) {

        stage.setTitle("Gestione Libri");
        HBox navBar = MenuComponent.getMenu(stage);

        // ===========================
        // CARICA LIBRI
        // ===========================
        libri = FXCollections.observableArrayList(DatabaseLibri.caricaLibri());

        // ===========================
        // RICERCA LIVE
        // ===========================
        TextField cerca = new TextField();
        cerca.setPromptText("Cerca per ISBN, Titolo, Autore, Genere");
        cerca.getStyleClass().add("fieldCerca");

        FilteredList<Libro> filteredLibri = new FilteredList<>(libri, p -> true);

        cerca.textProperty().addListener((obs, oldText, newText) -> {
            String filtro = newText.toLowerCase().trim();
            filteredLibri.setPredicate(libro -> {
                if (filtro.isEmpty()) return true;
                return libro.getISBN().toLowerCase().contains(filtro) ||
                       libro.getTitolo().toLowerCase().contains(filtro) ||
                       libro.getAutore().toLowerCase().contains(filtro) ||
                       libro.getGenere().toLowerCase().contains(filtro);
            });
        });

        HBox barraRicerca = new HBox(cerca);
        barraRicerca.setSpacing(10);
        HBox.setHgrow(cerca, Priority.ALWAYS);

        // ===========================
        // TABELLA
        // ===========================
        TableView<Libro> table = new TableView<>(filteredLibri);

        TableColumn<Libro, String> colIsbn = new TableColumn<>("ISBN");
        colIsbn.setCellValueFactory(new PropertyValueFactory<>("ISBN"));

        TableColumn<Libro, String> colTitolo = new TableColumn<>("Titolo");
        colTitolo.setCellValueFactory(new PropertyValueFactory<>("titolo"));

        TableColumn<Libro, String> colAutore = new TableColumn<>("Autore");
        colAutore.setCellValueFactory(new PropertyValueFactory<>("autore"));

        TableColumn<Libro, String> colGenere = new TableColumn<>("Genere");
        colGenere.setCellValueFactory(new PropertyValueFactory<>("genere"));

        TableColumn<Libro, Integer> colAnno = new TableColumn<>("Anno");
        colAnno.setCellValueFactory(new PropertyValueFactory<>("anno"));

        table.getColumns().addAll(colIsbn, colTitolo, colAutore, colGenere, colAnno);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // ===========================
        // DOPPIO CLICK PER COPIA
        // ===========================
        table.setRowFactory(tv -> {
            TableRow<Libro> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && !row.isEmpty()) {
                    Libro rowData = row.getItem();
                    String testo = rowData.getISBN();
                    Clipboard clipboard = Clipboard.getSystemClipboard();
                    ClipboardContent content = new ClipboardContent();
                    content.putString(testo);
                    clipboard.setContent(content);

                    new Alert(Alert.AlertType.INFORMATION, "Copia negli appunti:\n" + testo, ButtonType.OK).showAndWait();
                }
            });
            return row;
        });

        // ===========================
        // PULSANTI
        // ===========================
        Button btnAggiungi = new Button("Aggiungi");
        btnAggiungi.getStyleClass().add("btn");

        Button btnModifica = new Button("Modifica");
        btnModifica.getStyleClass().add("btn");

        Button btnRimuovi = new Button("Rimuovi");
        btnRimuovi.getStyleClass().add("btn");

        HBox hbAzioni = new HBox(10, btnAggiungi, btnModifica, btnRimuovi);

        // ===========================
        // LOGICA RIMOZIONE
        // ===========================
        btnRimuovi.setOnAction(e -> {
            Libro selezionato = table.getSelectionModel().getSelectedItem();
            if (selezionato != null) {
                libri.remove(selezionato);
                DatabaseLibri.salvaLibri(libri);
            } else {
                new Alert(Alert.AlertType.WARNING, "Seleziona un libro da rimuovere!", ButtonType.OK).showAndWait();
            }
        });

        // ===========================
        // FUNZIONE GENERICA PER FORM (AGGIUNGI / MODIFICA)
        // ===========================
        Runnable aggiornaTabella = () -> {
            table.refresh();
            DatabaseLibri.salvaLibri(libri);
        };

        // FORM AGGIUNGI
        btnAggiungi.setOnAction(e -> apriForm(null, aggiornaTabella));

        // FORM MODIFICA
        btnModifica.setOnAction(e -> {
            Libro selezionato = table.getSelectionModel().getSelectedItem();
            if (selezionato != null) {
                apriForm(selezionato, aggiornaTabella);
            } else {
                new Alert(Alert.AlertType.WARNING, "Seleziona un libro da modificare!", ButtonType.OK).showAndWait();
            }
        });

        // ===========================
        // LAYOUT FINALE
        // ===========================
        VBox root = new VBox(10, navBar, barraRicerca, table, hbAzioni);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 1200, 800);
        scene.getStylesheets().add(LibriView.class.getResource("/style.css").toExternalForm());
        stage.setScene(scene);

        return scene;
    }

    // ===============================================
    // FORM UNICO PER AGGIUNGERE / MODIFICARE
    // ===============================================
    private static void apriForm(Libro libro, Runnable onSave) {
        Stage formStage = new Stage();
        formStage.setTitle(libro == null ? "Aggiungi Libro" : "Modifica Libro");

        TextField tfIsbn = new TextField(libro == null ? "" : libro.getISBN());
        TextField tfTitolo = new TextField(libro == null ? "" : libro.getTitolo());
        TextField tfAutore = new TextField(libro == null ? "" : libro.getAutore());
        TextField tfGenere = new TextField(libro == null ? "" : libro.getGenere());
        TextField tfAnno = new TextField(libro == null ? "" : String.valueOf(libro.getAnno()));

        tfIsbn.setPromptText("ISBN");
        tfTitolo.setPromptText("Titolo");
        tfAutore.setPromptText("Autore");
        tfGenere.setPromptText("Genere");
        tfAnno.setPromptText("Anno");

        Button btnSalva = new Button("Salva");
        btnSalva.getStyleClass().add("btn");

        btnSalva.setOnAction(e -> {
            try {
                int anno = Integer.parseInt(tfAnno.getText());

                if (libro == null) {
                    // Aggiungi nuovo
                    Libro nuovo = new Libro(
                        tfIsbn.getText(),
                        tfTitolo.getText(),
                        tfAutore.getText(),
                        tfGenere.getText(),
                        anno
                    );
                    libri.add(nuovo);
                } else {
                    // Modifica esistente
                    libro.setISBN(tfIsbn.getText());
                    libro.setTitolo(tfTitolo.getText());
                    libro.setAutore(tfAutore.getText());
                    libro.setGenere(tfGenere.getText());
                    libro.setAnno(anno);
                }

                onSave.run();
                formStage.close();

            } catch (NumberFormatException ex) {
                new Alert(Alert.AlertType.ERROR, "Anno non valido!", ButtonType.OK).showAndWait();
            }
        });

        VBox form = new VBox(10, tfIsbn, tfTitolo, tfAutore, tfGenere, tfAnno, btnSalva);
        form.setPadding(new Insets(15));

        Scene sceneForm = new Scene(form, 400, 360);
        sceneForm.getStylesheets().add(LibriView.class.getResource("/style.css").toExternalForm());
        formStage.setScene(sceneForm);
        formStage.show();
    }
}
