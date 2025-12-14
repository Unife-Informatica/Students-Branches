package com.example;

import com.example.ui.ClientiView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{

    @Override
    public void start(Stage stage){
        stage.setScene(ClientiView.getSceneClienti(stage));
        stage.show();
    }
    public static void main(String[] args) {
       launch(args);
    }
}