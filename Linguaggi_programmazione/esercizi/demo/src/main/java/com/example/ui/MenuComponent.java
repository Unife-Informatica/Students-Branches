package com.example.ui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MenuComponent {
  public static HBox getMenu(Stage stage){
    HBox menu = new HBox();
    menu.setPadding(new Insets(10));
    menu.setSpacing(10);

    Button btnClienti = new Button("Clienti");
    Button btnEventi = new Button("Eventi");
    Button btnBiglietti = new Button("Biglietti");

    btnClienti.setOnAction(e -> stage.setScene(ClientiView.getSceneClienti(stage)));
    btnEventi.setOnAction(e -> stage.setScene(EventiView.getSceneEventi(stage)));
    btnBiglietti.setOnAction(e -> stage.setScene(BigliettiView.getSceneBiglietti(stage)));

    menu.getChildren().addAll(btnClienti, btnEventi, btnBiglietti);

    return menu;
  }
}
