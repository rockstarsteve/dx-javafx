package com.dx.app;

import com.dx.util.AlertUtil;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Optional;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/8/10
 */
public class App32Alter extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Text text = new Text(100, 250, "JavaFX 2.0");
        root.getChildren().add(text);
        Scene scene = new Scene(root, 600, 600, Color.PINK);
        primaryStage.setScene(scene);
        primaryStage.setTitle("文本");
        primaryStage.show();

        //监听关闭窗口事件
        primaryStage.setOnCloseRequest(e -> {
            Alert alert = AlertUtil.buildConfirmAlert("头3", "我是内容");
            Optional<ButtonType> buttonType = alert.showAndWait();
            if (buttonType.isPresent() && !buttonType.get().getButtonData().getTypeCode().equals(ButtonBar.ButtonData.OK_DONE.getTypeCode())) {
                System.out.println("取消");
                e.consume();
            }else {
                System.out.println("确定");
            }
        });


    }

    public static void main(String[] args) {
        launch();
    }

}
