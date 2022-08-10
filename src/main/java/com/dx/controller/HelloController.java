package com.dx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {

    @FXML
    private Label welcomeText;

    @FXML
    protected void loginBtn() {
        welcomeText.setText("没有发现您输入的用户名密码!");
    }

    @FXML
    protected void hiden() {

    }

    @FXML
    protected void exit() {
        System.exit(0);
    }
}
