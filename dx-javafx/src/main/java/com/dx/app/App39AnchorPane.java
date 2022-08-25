package com.dx.app;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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
public class App39AnchorPane extends Application {

    @Override
    public void start(Stage stage) {
        Text text1 = new Text("我是第一个文字");
        text1.setFont(new Font(15));
        text1.setFill(Color.DARKSLATEBLUE);

        Text text2 = new Text("我是第二段话");
        text2.setFont(new Font(15));
        text2.setFill(Color.DARKGOLDENROD);

        AnchorPane anchorPane = new AnchorPane();

        AnchorPane.setTopAnchor(text1, 0.0);
        AnchorPane.setLeftAnchor(text1, 0.0);
//        AnchorPane.setRightAnchor(text1, 0.0);
//        AnchorPane.setBottomAnchor(text1, 0.0);

//        AnchorPane.setTopAnchor(text2, 10.0);
//        AnchorPane.setLeftAnchor(text2, 0.0);
        AnchorPane.setRightAnchor(text2, 0.0);
        AnchorPane.setBottomAnchor(text2, 0.0);

        ObservableList list = anchorPane.getChildren();
        list.addAll(text1, text2);

        Scene scene = new Scene(anchorPane, 600, 600);
        stage.setTitle("Anchor Pane Example");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
