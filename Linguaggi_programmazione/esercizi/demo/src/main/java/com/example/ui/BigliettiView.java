package com.example.ui;

import com.example.model.Biglietto;
import com.example.model.Cliente;
import com.example.model.Evento;
import com.example.storage.DatabaseBiglietti;
import com.example.storage.DatabaseClienti;
import com.example.storage.DatabaseEventi;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;

public class BigliettiView {

  private static ObservableList<Biglietto> biglietti;
    public static Scene getSceneBiglietti(Stage stage) {
      stage.setTitle("GESTIONE BIGLIETTI");
      HBox navBar = MenuComponent.getMenu(stage);
      biglietti = FXCollections.observableArrayList(DatabaseBiglietti.caricaBiglietto());

      // RICERCA
      TextField cerca = new TextField();
      cerca.setPromptText("Cerca per Cliente, Evento o Data");
      FilteredList<Biglietto> filtered = new FilteredList<>(biglietti, p -> true);
      cerca.textProperty().addListener((obs, oldText, newText) -> {
        String filtro = newText.toLowerCase().trim();
        filtered.setPredicate(b -> {
          if (filtro.isEmpty()) return true;
            return b.getC().getNome().toLowerCase().contains(filtro)
              || b.getC().getCognome().toLowerCase().contains(filtro)
              || b.getE().getDescrizione().toLowerCase().contains(filtro)
              || b.getDataAquisto().toLowerCase().contains(filtro);
          });
      });
      HBox barraRicerca = new HBox(cerca);
      HBox.setHgrow(cerca, Priority.ALWAYS);
      TableView<Biglietto> table = new TableView<>(filtered);

      // COLONNE
      TableColumn<Biglietto, String> colCliente = new TableColumn<>("Cliente");
      colCliente.setCellValueFactory(data ->
          new javafx.beans.property.SimpleStringProperty(
              data.getValue().getC().getNome() + " " +
              data.getValue().getC().getCognome()
          )
      );
      TableColumn<Biglietto, String> colEvento = new TableColumn<>("Evento");
      colEvento.setCellValueFactory(data ->
          new javafx.beans.property.SimpleStringProperty(
              data.getValue().getE().getDescrizione()
          )
      );
      TableColumn<Biglietto, String> colData = new TableColumn<>("Data Acquisto");
      colData.setCellValueFactory(new PropertyValueFactory<>("dataAquisto"));
      table.getColumns().addAll(colCliente, colEvento, colData);
      table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

      // BOTTONI
      Button btnVendi = new Button("Vendi Biglietto");
      Button btnRimuovi = new Button("Rimuovi");
      HBox hbAzioni = new HBox(10, btnVendi, btnRimuovi);
      Runnable aggiorna = () -> {
        table.refresh();
        DatabaseBiglietti.salvaBiglietto(biglietti);
      };

      // VENDITA
      btnVendi.setOnAction(e -> apriFormVendita(aggiorna));

      // RIMOZIONE
      btnRimuovi.setOnAction(e -> {
          Biglietto selezionato = table.getSelectionModel().getSelectedItem();
          if (selezionato != null) {
            biglietti.remove(selezionato);
            DatabaseBiglietti.salvaBiglietto(biglietti);
          } else {
            new Alert(Alert.AlertType.WARNING,
              "Seleziona un biglietto da rimuovere",
              ButtonType.OK).showAndWait();
          }
      });
      VBox root = new VBox(10, navBar, barraRicerca, table, hbAzioni);
      root.setPadding(new Insets(10));
      Scene scene = new Scene(root, 1200, 800);
      stage.setScene(scene);
      return scene;
    }

  // FORM VENDITA BIGLIETTO
  private static void apriFormVendita(Runnable onSave) {
    Stage stage = new Stage();
    stage.setTitle("Vendita Biglietto");
    ComboBox<Cliente> cbCliente = new ComboBox<>();
    ComboBox<Evento> cbEvento = new ComboBox<>();
    cbCliente.setItems(FXCollections.observableArrayList(DatabaseClienti.caricaClienti()));
    cbEvento.setItems(FXCollections.observableArrayList(DatabaseEventi.caricaEventi()));
    cbCliente.setPromptText("Seleziona Cliente");
    cbEvento.setPromptText("Seleziona Evento");
    Button btnSalva = new Button("Vendi");
    btnSalva.setOnAction(e -> {
      Cliente cliente = cbCliente.getValue();
      Evento evento = cbEvento.getValue();
      if (cliente == null || evento == null) {
        new Alert(Alert.AlertType.WARNING,
          "Seleziona cliente ed evento",
          ButtonType.OK).showAndWait();
          return;
      }
      long venduti = biglietti.stream()
        .filter(b -> b.getE().getId().equals(evento.getId()))
        .count();
        if (venduti >= evento.getCapienzaMax()) {
          new Alert(Alert.AlertType.ERROR,
            "Posti esauriti per questo evento",
            ButtonType.OK).showAndWait();
            return;
        }
        biglietti.add(new Biglietto(
          cliente,
          evento,
          LocalDate.now().toString()
        ));
        onSave.run();
        stage.close();
      });

      VBox form = new VBox(10, cbCliente, cbEvento, btnSalva);
      form.setPadding(new Insets(15));
      stage.setScene(new Scene(form, 400, 220));
      stage.show();
  }
}
