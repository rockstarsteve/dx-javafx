package com.dx.app;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/8/10
 */
public class App40TilePane extends Application {

    @Override
    public void start(Stage stage) {
        //Creating an array of Buttons
        Button[] buttons = new Button[] {
                new Button("SunDay"),
                new Button("MonDay"),
                new Button("TuesDay"),
                new Button("WednesDay"),
                new Button("ThursDay"),
                new Button("FriDay"),
                new Button("SaturDay")
        };
        TilePane tilePane = new TilePane();

        //Setting the orientation for the Tile Pane
        tilePane.setOrientation(Orientation.HORIZONTAL);

        //Setting the alignment for the Tile Pane
        tilePane.setTileAlignment(Pos.CENTER_LEFT);

        //Setting the preferred columns for the Tile Pane
        tilePane.setPrefRows(4);

        ObservableList list = tilePane.getChildren();
        list.addAll(buttons);

        Scene scene = new Scene(tilePane);
        stage.setTitle("Tile Pane Example");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
