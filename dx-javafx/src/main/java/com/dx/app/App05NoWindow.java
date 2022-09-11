package com.dx.app;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Description:
 * 显示没有任务栏的内容
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/8/10
 */
public class App05NoWindow extends Application {

    /**
     * 弹窗的内容的变量
     */
    private static VBox content;

    @Override
    public void start(Stage primaryStage) {
        /**
         * 按钮
         */
        VBox root = new VBox();

        Button btn = new Button("弹出");
        btn.setOnAction(actionEvent -> {
            //1：不显示的弹窗窗口
            Stage noShowStage = new Stage();
            noShowStage.initStyle(StageStyle.UTILITY);
            noShowStage.setMaxHeight(0);
            noShowStage.setMaxWidth(0);
            noShowStage.setX(Double.MAX_VALUE);//这个是最重要的
            noShowStage.show();

            //2：显示的弹窗的窗口
            VBox content = new VBox();
            content.setMinWidth(100);
            content.setMinHeight(100);
            this.content = content;
            Label label = new Label("显示的弹出框");
            content.getChildren().add(label);
            Scene scene = new Scene(content);
            Stage showStage = new Stage();
            showStage.setScene(scene);

            //显示的位置
            Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
            double maxX = primaryScreenBounds.getMaxX();
            double maxY = primaryScreenBounds.getMaxY();
            showStage.setX(maxX - 100);
            showStage.setY(maxY - 200);

            //绑定到不显示的窗体上
            showStage.initStyle(StageStyle.UNDECORATED);
            showStage.initOwner(noShowStage);
            showStage.show();
        });

        Button btn2 = new Button("改变内容大小");
        btn2.setOnAction(actionEvent -> {
            this.content.getScene().getWindow().setHeight(200);
        });

        root.getChildren().addAll(btn,btn2);

        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("窗口");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
