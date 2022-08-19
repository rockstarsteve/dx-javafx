package com.dx.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
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
public class App11Button extends Application {

    @Override
    public void start(Stage primaryStage) {
        /**
         * 按钮
         */
        VBox root = new VBox();

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Your password");
        root.getChildren().add(passwordField);

        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("窗口");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
