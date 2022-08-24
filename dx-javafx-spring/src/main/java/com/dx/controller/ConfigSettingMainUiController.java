package com.dx.controller;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.extern.slf4j.Slf4j;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/8/22
 */
@Slf4j
public class ConfigSettingMainUiController {

    //设置页面的窗口
    private static Stage settingStage = new Stage(StageStyle.TRANSPARENT);
    /**
     * 关于界面移动偏移量
     */
    private static double xOffset = 0;
    private static double yOffset = 0;

    /**
     * 创建显示的页面，并赋予一些属性
     */
    public static void buildConfigSettingUi() {
        BorderPane root = new BorderPane();
        Label label = new Label("这个是配置全局设置的页面");
        root.setTop(label);
        Scene scene = new Scene(root, 320, 240);

        // 设置界面 移动事件
        scene.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        //窗体的移动事件处理
        root.setOnMouseDragged(event -> {
            settingStage.setX(event.getScreenX() - xOffset);
            settingStage.setY(event.getScreenY() - yOffset);
        });


        settingStage.setScene(scene);
        settingStage.show();
    }


}
