package com.dx.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
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
public class App29TreeItem extends Application {

    @Override
    public void start(Stage primaryStage) {
        /**
         * 按钮
         */
        VBox root = new VBox();

        TreeItem<String> rootItem = new TreeItem<>("Root");
        rootItem.setExpanded(true);
        TreeItem<String> item = new TreeItem<>("A");
        rootItem.getChildren().add(item);
        item = new TreeItem<>("B");
        rootItem.getChildren().add(item);
        TreeView<String> tree = new TreeView<>(rootItem);
        root.getChildren().add(tree);

        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("窗口");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
