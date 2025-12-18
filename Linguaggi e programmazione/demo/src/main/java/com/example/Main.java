package com.example;

import com.example.ui.LibriView;
import com.example.ui.PrestitiView;
import com.example.ui.UtentiView;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        stage.setTitle("Biblioteca");

        // HOME ROOT
        Label titolo = new Label("BIBLIOTECA");
        titolo.getStyleClass().add("tlt");

        Button btnLibri = new Button("Gestione Libri");
        Button btnUtenti = new Button("Gestione Utenti");
        Button btnPrestiti = new Button("Gestione Prestiti");

        btnLibri.getStyleClass().add("btn");
        btnUtenti.getStyleClass().add("btn");
        btnPrestiti.getStyleClass().add("btn");

        // → Cambia scena
        btnLibri.setOnAction(e -> stage.setScene(LibriView.getSceneLibri(stage)));
        btnUtenti.setOnAction(e -> stage.setScene(UtentiView.getSceneUtenti(stage)));
        btnPrestiti.setOnAction(e -> stage.setScene(PrestitiView.getScenePrestiti(stage)));

        // Layout della home
        VBox layout = new VBox(25, titolo, btnLibri, btnUtenti, btnPrestiti);
        layout.setAlignment(Pos.CENTER);

        Scene homeScene = new Scene(layout, 1200, 800);
        homeScene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        stage.setScene(homeScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
