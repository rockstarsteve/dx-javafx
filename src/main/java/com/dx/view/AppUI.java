package com.dx.view;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/8/10
 */
public class AppUI implements Initializable  {

    public Label text;
    private AppModel model = new AppModel();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        text.textProperty().bindBidirectional(model.textProperty());
        model.setText("Hello JavaFX.");
    }
}
