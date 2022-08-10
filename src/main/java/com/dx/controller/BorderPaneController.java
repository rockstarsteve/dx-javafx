package com.dx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/8/10
 */
public class BorderPaneController {


    @FXML
    private Button btnHello;

    @FXML
    protected void handleButtonAction() {
        btnHello.setText("Hello World, I am JavaFX!");
    }

}
