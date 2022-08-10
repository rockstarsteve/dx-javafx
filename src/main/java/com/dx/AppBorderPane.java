package com.dx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AppBorderPane extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        BorderPane borderPane = (BorderPane) FXMLLoader.load(AppBorderPane.class.getResource("BorderPane.fxml"));
        Scene scene = new Scene(borderPane, 320, 240);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
