package com.dx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DxApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(DxApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("开发");
//        stage.setScene(scene);
//        stage.show();


        BorderPane root = new BorderPane();
        Label label = new Label("你好啊");
        Button button = new Button("点击按钮");

        root.setCenter(label);
        root.setTop(button);
        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("开发");
        stage.setScene(scene);
        stage.show();














    }

    public static void main(String[] args) {
        launch();
    }
}
