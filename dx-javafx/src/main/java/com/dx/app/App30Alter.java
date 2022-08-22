package com.dx.app;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/8/10
 */
public class App30Alter extends Application {

    @Override
    public void start(Stage primaryStage) {
        /**
         * 弹框的实现
         */
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setHeight(100);
        errorAlert.setTitle("头");
        errorAlert.setHeaderText(null);
        errorAlert.setContentText("我是内容");
        primaryStage = (Stage) errorAlert.getDialogPane().getScene().getWindow();
        primaryStage.getIcons().add(new Image(App30Alter.class.getResourceAsStream("/images/icon.png")));
        errorAlert.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
