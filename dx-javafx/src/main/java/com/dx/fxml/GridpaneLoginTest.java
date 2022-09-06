package com.dx.fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/8/24
 */
public class GridpaneLoginTest extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App04Lable.class.getResource("/com/dx/fxml/GridpaneLoginTest.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        scene.getStylesheets().add(getClass().getResource("/css/GridpaneLoginTest.css").toExternalForm());
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
