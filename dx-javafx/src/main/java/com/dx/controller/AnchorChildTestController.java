package com.dx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/8/13
 */
public class AnchorChildTestController {

    @FXML
    private Label usertxt;
    @FXML
    private Label passwordtxt;
    @FXML
    private TextField usernameInput;
    @FXML
    private PasswordField passwordInput;
    @FXML
    private Button loginBtn;
    @FXML
    private Button cancleBtn;

    @FXML
    protected void loginBtn() {
        System.out.println("用户名是：" + usernameInput.getText());
        System.out.println("密码是：" + passwordInput.getText());

        System.out.println("你开始登录了");
    }

    @FXML
    protected void cancleBtn() {
        System.out.println("取消了");

    }

}
