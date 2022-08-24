package com.dx.app;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/8/10
 */
public class App34HBox extends Application {

    @Override
    public void start(Stage stage) {
        TextField textField = new TextField();
        Button playButton = new Button("Play");
        Button stopButton = new Button("stop");

        //设置hbox
        HBox hbox = new HBox();
        hbox.setSpacing(2);

        //设置hbox里面的内容
        hbox.setMargin(textField, new Insets(0, 0, 0, 0));
        hbox.setMargin(playButton, new Insets(23, 0, 32, 0));
        hbox.setMargin(stopButton, new Insets(0, 0, 0, 0));

        //添加
        hbox.getChildren().addAll(textField, playButton, stopButton);

        Scene scene = new Scene(hbox);
        stage.setTitle("Hbox Example");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
