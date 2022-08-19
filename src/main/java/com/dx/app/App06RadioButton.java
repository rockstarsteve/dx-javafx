package com.dx.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
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
public class App06RadioButton extends Application {

    @Override
    public void start(Stage primaryStage) {
        /**
         * 按钮
         */
        HBox root = new HBox();

        ToggleGroup group = new ToggleGroup();
        RadioButton button1 = new RadioButton("select first");
        button1.setToggleGroup(group);
        RadioButton button2 = new RadioButton("select second");
        button2.setToggleGroup(group);

        root.getChildren().add(button1);
        root.getChildren().add(button2);

        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("窗口");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
