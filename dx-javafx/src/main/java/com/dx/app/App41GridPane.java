package com.dx.app;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/8/10
 */
public class App41GridPane extends Application {

    @Override
    public void start(Stage stage) {
        Text copyText = new Text("版权所有：电信班");
        Text text1 = new Text("用户名：");
        Text text2 = new Text("密码：");
        TextField textField1 = new TextField();
        TextField textField2 = new TextField();

        //Creating Buttons
        Button button1 = new Button("提交");
        Button button2 = new Button("重置");

        //Creating a Grid Pane
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER_RIGHT);
//        gridPane.setStyle("-fx-background-color: red;");
        gridPane.setMinSize(400, 200);
        gridPane.setPadding(new Insets(15, 10, 15, 10));
        gridPane.setVgap(10);//上下高度
        gridPane.setHgap(0);//左右宽度
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(text1, 0, 0);
        gridPane.add(textField1, 1, 0);
        gridPane.add(text2, 0, 1);
        gridPane.add(textField2, 1, 1);
        gridPane.add(button1, 0, 2);
        gridPane.add(button2, 1, 2);
        gridPane.add(copyText,0,3);

        Scene scene = new Scene(gridPane);
        stage.setTitle("Grid Pane Example");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
