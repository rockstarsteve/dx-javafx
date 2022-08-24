package com.dx.app;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;
import org.kordamp.bootstrapfx.scene.layout.Panel;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/8/24
 */
public class AppBootstrapFX extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {                   //(1)
        Panel panel = new Panel("这个是文字标题");
        panel.getStyleClass().add("panel-primary");                            //(2)
        BorderPane content = new BorderPane();
        content.setPadding(new Insets(20));
        Button button = new Button("这是按钮");
        button.getStyleClass().setAll("btn", "btn-danger");                     //(2)
        content.setCenter(button);
        panel.setBody(content);

        Scene scene = new Scene(panel, 500, 500);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());       //(3)

        primaryStage.setTitle("展示窗口");
        primaryStage.setScene(scene);
//        primaryStage.sizeToScene();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
