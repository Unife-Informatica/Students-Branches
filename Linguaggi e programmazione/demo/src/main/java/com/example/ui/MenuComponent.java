package com.example.ui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MenuComponent {

    public static HBox getMenu(Stage stage) {
        HBox menu = new HBox();
        menu.setPadding(new Insets(10));
        menu.setSpacing(10);
        menu.getStyleClass().add("menuModern");

        Button btnUtenti = new Button("Utenti");
        Button btnLibri = new Button("Libri");
        Button btnPrestiti = new Button("Prestiti");

        // NAVIGAZIONE
        btnUtenti.setOnAction(e -> stage.setScene(UtentiView.getSceneUtenti(stage)));
        btnLibri.setOnAction(e -> stage.setScene(LibriView.getSceneLibri(stage)));
        btnPrestiti.setOnAction(e -> stage.setScene(PrestitiView.getScenePrestiti(stage)));

        menu.getChildren().addAll(btnLibri, btnUtenti, btnPrestiti);

        return menu;
    }
}
