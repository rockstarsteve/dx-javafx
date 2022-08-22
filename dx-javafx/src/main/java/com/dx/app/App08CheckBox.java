package com.dx.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
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
public class App08CheckBox extends Application {

    @Override
    public void start(Stage primaryStage) {
        /**
         * 按钮
         */
        VBox root = new VBox();

        CheckBox checkBox = new CheckBox("不知道写什么");
        checkBox.setText("First");
        checkBox.setSelected(true);
        root.getChildren().add(checkBox);

        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("窗口");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
