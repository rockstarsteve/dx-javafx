package com.dx.app;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
public class App37StackPane extends Application {

    @Override
    public void start(Stage stage) {

        /**
         * 堆叠内容，从里面往外面
         */

        //Drawing a Circle
        Circle circle = new Circle(300, 135, 100);
        circle.setFill(Color.DARKSLATEBLUE);
        circle.setStroke(Color.BLACK);

        //Drawing Sphere
        Sphere sphere = new Sphere(50);

        //Creating a text
        Text text = new Text("Hello how are you");
        text.setFont(Font.font(null, FontWeight.BOLD, 15));
        text.setFill(Color.CRIMSON);
        text.setX(20);
        text.setY(50);

        //Creating a Stackpane
        StackPane stackPane = new StackPane();
//        stackPane.setMargin(circle, new Insets(50, 50, 50, 50));
        stackPane.setMargin(circle, new Insets(0, 0, 0, 0));

        ObservableList list = stackPane.getChildren();
        list.addAll(circle, sphere, text);

        Scene scene = new Scene(stackPane);
        stage.setTitle("Stack Pane Example");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
