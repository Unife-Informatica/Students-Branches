package com.example;

import java.util.List;

import com.example.model.Cliente;
import com.example.storage.DatabaseClienti;
import com.example.ui.ClientiView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{

    @Override
    public void start(Stage stage){
        stage.setTitle("CLIENTI");

        VBox layout = new VBox(25);
        Scene clientiScene = new Scene(layout,1200,800);
        stage.setScene(clientiScene);
        stage.show();

        stage.setScene(ClientiView.getSceneClienti(stage));
    }
    public static void main(String[] args) {
       launch(args);
    }
}