package com.dx.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Description:
 * 可以隐藏label标签
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/8/10
 */
public class App04Label extends Application {

    @Override
    public void start(Stage primaryStage) {
        /**
         * label标签
         */
        VBox root = new VBox();
        root.setStyle("-fx-background-color: pink;");

        Label label = new Label("        这个是label标签          ");
        //隐藏label标签
        label.setVisible(false);
        Label label2 = new Label("     这个是label标签222          ");


        HBox hBox = new HBox();
        hBox.setStyle("-fx-pref-width: 100;-fx-background-color: green;");
        Label label3 = new Label("这个是超长的文本这个是超长的文本这个是超长的文本这个是超长的文本这个是超长的文本这个是超长的文本这个是超长的文本这个是超长的文本这个是超长的文本这个是超长的文本这个是超长的文本这个是超长的文本这个是超长的文本这个是超长的文本这个是超长的文本这个是超长的文本");
        //文本换行
        label3.setStyle("-fx-wrap-text: true");
        hBox.getChildren().add(label3);


        root.getChildren().addAll(label, label2, hBox);
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("窗口");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
