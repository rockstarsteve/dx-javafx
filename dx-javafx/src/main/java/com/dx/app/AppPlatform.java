package com.dx.app;

import com.dx.util.AlertUtil;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

public class AppPlatform extends Application {

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
            if (!mouseMovedFlag) {
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
        //图标
        stage.getIcons().add(new Image(AppPlatform.class.getResourceAsStream("/images/icon.png")));
        //是否可以改变窗体大小
        stage.setResizable(false);
        stage.show();

        //默认为true
        //当true时，关闭最后一个窗口，程序也关闭，将会调用Application.stop()
        //false，关闭最后一个窗口，程序继续运行,除非使用Platform.exit()
        Platform.setImplicitExit(false);

        stage.setOnCloseRequest(e -> {
            Alert alert = AlertUtil.buildConfirmAlert("提示", "是否最小化到系统托盘");
            Optional<ButtonType> buttonType = alert.showAndWait();
            if (buttonType.isPresent() && !buttonType.get().getButtonData().getTypeCode().equals(ButtonBar.ButtonData.OK_DONE.getTypeCode())) {
                e.consume();
            }
        });
    }


    public static void main(String[] args) {
        launch();
    }
}
