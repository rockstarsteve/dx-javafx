package com.dx.app;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/8/10
 */
public class App42FlowPane extends Application {

    @Override
    public void start(Stage stage) {
        Button button1 = new Button("Button1");
        Button button2 = new Button("Button2");
        Button button3 = new Button("Button3");
        Button button4 = new Button("Button4");

        FlowPane flowPane = new FlowPane();
//        flowPane.setHgap(25);
//        flowPane.setMargin(button1, new Insets(20, 0, 20, 20));
        ObservableList list = flowPane.getChildren();
        list.addAll(button1, button2, button3, button4);

        Scene scene = new Scene(flowPane);
        stage.setTitle("Flow Pane Example");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
