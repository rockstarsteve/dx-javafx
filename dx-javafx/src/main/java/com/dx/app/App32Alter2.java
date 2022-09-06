package com.dx.app;

import com.dx.util.MessageUtils;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/8/10
 */
public class App32Alter2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        ObservableList<Node> children = root.getChildren();

        Button btn = new Button("打开冒泡");
        btn.setOnAction(actionEvent -> {
            System.out.println("actionEvent:" + actionEvent);

            MessageUtils.info(root, "这是提示信息！", 5000, null, null);
        });

        root.getChildren().add(btn);

        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("窗口");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
