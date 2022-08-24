package com.dx.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
public class AppLoginTest extends Application {

    @Override
    public void start(Stage primaryStage) {

        VBox root = new VBox();

        HBox usernameBox = new HBox();
        Text usernametext = new Text("用户名：");
        TextField usernametextField = new TextField("");
        usernameBox.getChildren().addAll(usernametext, usernametextField);

        HBox passwordBox = new HBox();
        Text passwordtext = new Text("密码：");
        PasswordField passwordtextField = new PasswordField();
        passwordBox.getChildren().addAll(passwordtext, passwordtextField);

        HBox btnBox = new HBox();
        Button submitBtn = new Button("登录");
        Button cancelBtn = new Button("取消");
        btnBox.getChildren().addAll(submitBtn, cancelBtn);

        HBox copyBox = new HBox();
        Text copytext = new Text("版权所属©：电信班");
        copyBox.getChildren().addAll(copytext);

        root.getChildren().addAll(usernameBox, passwordBox, btnBox, copyBox);

        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("窗口");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
