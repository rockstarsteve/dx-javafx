package com.dx.fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;


/**
 * Description:
 * 设置登录边框阴影
 * 设置图标栏图片
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/8/10
 */
public class windowShadow extends Application {

    private static double xOffset = 0;
    private static double yOffset = 0;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(Lable.class.getResource("/fxml/windowShadow.fxml"));
        Scene scene = new Scene(fxmlLoader, 640, 640);
        scene.setFill(Color.TRANSPARENT);

        // 设置界面 移动事件
        scene.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        //窗体的移动事件处理
        fxmlLoader.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - xOffset);
            primaryStage.setY(event.getScreenY() - yOffset);
        });
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.getIcons().add(new Image(windowShadow.class.getResourceAsStream("/images/icon.png")));
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
