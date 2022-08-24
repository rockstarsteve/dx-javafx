package com.dx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/8/13
 */
public class LoginTestController {

    @FXML
    private HBox usernameBox;
    @FXML
    private HBox passwordBox;
    @FXML
    private HBox btnBox;
    @FXML
    private HBox copyBox;
    @FXML
    private TextField usernameText;
    @FXML
    private PasswordField passwordText;
    @FXML
    private Button loginBtn;
    @FXML
    private Button cancleBtn;

    @FXML
    protected void loginBtn() {
        System.out.println("用户名是：" + usernameText.getText());
        System.out.println("密码是：" + passwordText.getText());

        System.out.println("你开始登录了");
    }

    @FXML
    protected void cancleBtn() {
        System.out.println("取消了");

    }

}
