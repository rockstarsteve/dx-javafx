package com.dx.app;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/8/10
 */
public class App03Text extends Application {

    @Override
    public void start(Stage primaryStage) {
        /**
         * 文本
         */
        Group root = new Group();

        Text text = new Text(100, 250, "JavaFX 2.0");
        root.getChildren().add(text);
        Scene scene = new Scene(root, 600, 600, Color.PINK);

        primaryStage.setScene(scene);
        primaryStage.setTitle("文本");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
