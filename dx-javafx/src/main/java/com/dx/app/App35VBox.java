package com.dx.app;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/8/10
 */
public class App35VBox extends Application {

    @Override
    public void start(Stage stage) {
        TextField textField = new TextField();
        Button playButton = new Button("Play");
        Button stopButton = new Button("stop");

        VBox vBox = new VBox();
        vBox.setSpacing(0);

        vBox.setMargin(textField, new Insets(0, 0, 0, 0));
        vBox.setMargin(playButton, new Insets(13, 34, 20, 0));
        vBox.setMargin(stopButton, new Insets(0, 0, 0, 0));

        ObservableList list = vBox.getChildren();
        list.addAll(textField, playButton, stopButton);

        Scene scene = new Scene(vBox);
        stage.setTitle("Vbox Example");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
