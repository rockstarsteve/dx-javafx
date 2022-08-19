package com.dx.app;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/8/10
 */
public class App01Line extends Application {

    @Override
    public void start(Stage stage) {
        /**
         * 画线
         */
        Line line = new Line(0, 0, 0, 0);

        //定时器调度每隔两秒重新画一个
        Timer timer = new Timer();
        Random rand = new Random();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                double x1 = rand.nextDouble() * 600;
                line.setStartX(x1);
                double y1 = rand.nextDouble() * 600;
                line.setStartY(+y1);
                double x2 = rand.nextDouble() * 600;
                line.setEndX(x2);
                double y2 = rand.nextDouble() * 600;
                line.setEndY(y2);
            }
        }, 2000, 2000);


        Group root = new Group(line);
        Scene scene = new Scene(root, 600, 600);
        stage.setScene(scene);
        stage.setTitle("画线测试");
        stage.show();

    }


    public static void main(String[] args) {
        launch();
    }

}
