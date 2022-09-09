package com.dx.app;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * Description:
 * 一个窗体属于另外一个窗体
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/9/9
 */

public class App45Model extends Application {

    public static void main(String[] args) {
//        调用launch方法启动应用
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage s1 = new Stage();
        s1.setTitle("1");

        Stage s2 = new Stage();
        s2.setHeight(200);
        s2.setWidth(200);
        s2.setX(100);
        s2.setY(100);
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        double maxX = primaryScreenBounds.getMaxX();
        double maxY = primaryScreenBounds.getMaxY();
        s2.setX(maxX - 200);
        s2.setY(maxY - 200);

        s2.setTitle("2");
        //设置两个窗口关联，s2窗口的拥有者为s1
        s2.initOwner(s1);
//        s2.initModality(Modality.WINDOW_MODAL); //s2设置模块化，对s1窗口起作用


        s1.show();
        s2.show();

    }

}
