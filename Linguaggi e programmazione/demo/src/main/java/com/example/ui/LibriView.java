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

    public static Scene getSceneLibri(Stage stage) {

        stage.setTitle("Gestione Libri");

        HBox navBar = MenuComponent.getMenu(stage);

        libri = FXCollections.observableArrayList(DatabaseLibri.caricaLibri());

        TextField cerca = new TextField();
        cerca.setPromptText("Cerca per ISBN, titolo, autore o genere");
        cerca.getStyleClass().add("fieldCerca");

        FilteredList<Libro> filteredLibri = new FilteredList<>(libri, l -> true);

        cerca.textProperty().addListener((obs, oldValue, newValue) -> {
            String filtro = newValue.toLowerCase().trim();

            filteredLibri.setPredicate(libro -> {
                if (filtro.isEmpty()) {
                    return true;
                }

                return libro.getISBN().toLowerCase().contains(filtro)
                        || libro.getTitolo().toLowerCase().contains(filtro)
                        || libro.getAutore().toLowerCase().contains(filtro)
                        || libro.getGenere().toLowerCase().contains(filtro);
            });
        });

        HBox barraRicerca = new HBox(cerca);
        HBox.setHgrow(cerca, Priority.ALWAYS);

        TableView<Libro> table = new TableView<>(filteredLibri);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

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

        table.setRowFactory(tv -> {
            TableRow<Libro> row = new TableRow<>();

            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && !row.isEmpty()) {
                    Libro libro = row.getItem();

                    ClipboardContent content = new ClipboardContent();
                    content.putString(libro.getISBN());
                    Clipboard.getSystemClipboard().setContent(content);

                    new Alert(
                            Alert.AlertType.INFORMATION,
                            "ISBN copiato negli appunti:\n" + libro.getISBN(),
                            ButtonType.OK
                    ).showAndWait();
                }
            });

            return row;
        });

        Button btnAggiungi = new Button("Aggiungi");
        Button btnModifica = new Button("Modifica");
        Button btnRimuovi = new Button("Rimuovi");

        btnAggiungi.getStyleClass().add("btn");
        btnModifica.getStyleClass().add("btn");
        btnRimuovi.getStyleClass().add("btn");

        HBox boxAzioni = new HBox(10, btnAggiungi, btnModifica, btnRimuovi);

        btnRimuovi.setOnAction(e -> {
            Libro selezionato = table.getSelectionModel().getSelectedItem();

            if (selezionato == null) {
                new Alert(
                        Alert.AlertType.WARNING,
                        "Seleziona un libro da rimuovere",
                        ButtonType.OK
                ).showAndWait();
                return;
            }

            libri.remove(selezionato);
            DatabaseLibri.salvaLibri(libri);
        });

        Runnable aggiorna = () -> {
            table.refresh();
            DatabaseLibri.salvaLibri(libri);
        };

        btnAggiungi.setOnAction(e -> apriForm(null, aggiorna));

        btnModifica.setOnAction(e -> {
            Libro selezionato = table.getSelectionModel().getSelectedItem();

            if (selezionato == null) {
                new Alert(
                        Alert.AlertType.WARNING,
                        "Seleziona un libro da modificare",
                        ButtonType.OK
                ).showAndWait();
                return;
            }

            apriForm(selezionato, aggiorna);
        });

        VBox root = new VBox(10, navBar, barraRicerca, table, boxAzioni);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 1200, 800);
        scene.getStylesheets().add(
                LibriView.class.getResource("/style.css").toExternalForm()
        );

        stage.setScene(scene);
        return scene;
    }

    private static void apriForm(Libro libro, Runnable onSave) {

        Stage stage = new Stage();
        stage.setTitle(libro == null ? "Aggiungi libro" : "Modifica libro");

        TextField tfIsbn = new TextField(libro == null ? "" : libro.getISBN());
        TextField tfTitolo = new TextField(libro == null ? "" : libro.getTitolo());
        TextField tfAutore = new TextField(libro == null ? "" : libro.getAutore());
        TextField tfGenere = new TextField(libro == null ? "" : libro.getGenere());
        TextField tfAnno = new TextField(
                libro == null ? "" : String.valueOf(libro.getAnno())
        );

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
                    libri.add(new Libro(
                            tfIsbn.getText(),
                            tfTitolo.getText(),
                            tfAutore.getText(),
                            tfGenere.getText(),
                            anno
                    ));
                } else {
                    libro.setISBN(tfIsbn.getText());
                    libro.setTitolo(tfTitolo.getText());
                    libro.setAutore(tfAutore.getText());
                    libro.setGenere(tfGenere.getText());
                    libro.setAnno(anno);
                }

                onSave.run();
                stage.close();

            } catch (NumberFormatException ex) {
                new Alert(
                        Alert.AlertType.ERROR,
                        "Inserisci un anno valido",
                        ButtonType.OK
                ).showAndWait();
            }
        });

        VBox form = new VBox(10,
                tfIsbn, tfTitolo, tfAutore, tfGenere, tfAnno, btnSalva
        );
        form.setPadding(new Insets(15));

        Scene scene = new Scene(form, 400, 350);
        scene.getStylesheets().add(
                LibriView.class.getResource("/style.css").toExternalForm()
        );

        stage.setScene(scene);
        stage.show();
    }
}
