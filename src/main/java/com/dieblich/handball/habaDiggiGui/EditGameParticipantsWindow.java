package com.dieblich.handball.habaDiggiGui;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

class EditGameParticipantsWindow extends Stage {

    private Button editHomeTeam = new Button("Heimmannschaft");
    private Button editVisitorTeam = new Button("Gastmannschaft");

    private Button editFirstReferee = new Button("1. Schiedsrichter");
    private Button editSecondReferee = new Button("2. Schiedsrichter");

    private Button editTimeKeeper = new Button("Zeitnehmer");
    private Button editSecretary = new Button("Sekretär");

    EditGameParticipantsWindow(){
        setTitle("HabaDiggi: Beteiligte Parteien");
        GridPane grid = new GridPane();
        grid.setHgap(20);
        grid.setVgap(30);
        grid.setPadding(new Insets(10, 10, 10, 10));

        grid.add(editHomeTeam, 0,0);
        grid.setHalignment(editHomeTeam, HPos.CENTER);
        grid.add(editVisitorTeam, 1,0);
        grid.setHalignment(editVisitorTeam, HPos.CENTER);

        grid.add(editFirstReferee, 0,1);
        grid.setHalignment(editFirstReferee, HPos.CENTER);
        grid.add(editSecondReferee, 1,1);
        grid.setHalignment(editSecondReferee, HPos.CENTER);

        grid.add(editTimeKeeper, 0,2);
        grid.setHalignment(editTimeKeeper, HPos.CENTER);
        grid.add(editSecretary, 1,2);
        grid.setHalignment(editSecretary, HPos.CENTER);

        Scene mainScene = new Scene(grid);
        setScene(mainScene);
    }
}
