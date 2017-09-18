package com.dieblich.handball.habaDiggiGui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ChooseGameWindow extends Application {

    private Button startNewGameButton = new Button("Neues Spiel erstellen");

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("HabaDiggi: Spiel auswählen");
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(startNewGameButton);
        Scene mainScene  = new Scene(borderPane, 300, 275);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
