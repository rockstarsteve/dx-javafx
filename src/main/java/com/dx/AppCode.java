package com.dx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class AppCode extends Application {

    public static boolean mouseMovedFlag = false;

    @Override
    public void start(Stage stage) throws IOException {
        /**
         * 窗体 stage
         * 场景 scene
         * 布局 节点内容全部挂载在BorderPane上
         */
        BorderPane root = new BorderPane();
        Button button = new Button("点我");
        button.setOnAction(actionEvent -> {
            System.out.println("actionEvent:" + actionEvent);
        });
        button.setOnMouseMoved(mouseMoved -> {
            if (!mouseMovedFlag){
                System.out.println("mouseMoved:" + mouseMoved);
                mouseMovedFlag = true;
            }
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    mouseMovedFlag = false;
                }
            }, 3000);
        });
        root.setTop(button);
        Scene scene = new Scene(root, 320, 240);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}
