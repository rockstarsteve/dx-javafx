package com.dx.app;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/8/10
 */
public class App02Ellipse extends Application {

    @Override
    public void start(Stage primaryStage) {
        /**
         * 画椭圆
         */
        Group root = new Group();
        Rectangle rect = new Rectangle(20, 20, 200, 200);
        rect.setArcHeight(20);
        rect.setArcWidth(180);


        root.getChildren().add(rect);
        Scene scene = new Scene(root, 600, 600, Color.PINK);

        primaryStage.setScene(scene);
        primaryStage.setTitle("画椭圆");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
