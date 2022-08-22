package com.dx;

import com.dx.controller.ConfigSettingMainUiController;
import com.dx.controller.MainUiController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/8/21
 */
@Slf4j
public class NodeApp extends Application {

    //定义全局窗口
    private Stage stage;
    //定义节点程序全局数据
    private static Map<String, NodeApp> nodeTellerAppHashMap = new HashMap<>();
    /**
     * define  primary Stage width and height.
     */
    private static final double PRIMARY_STAGE_WIDTH = 450.0;
    private static final double PRIMARY_STAGE_HEIGHT = 400.0;


    @Override
    public void init() throws Exception {
        System.out.println("init");
        super.init();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("stop");
        super.stop();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Platform.runLater(() -> {
            setPrimaryStage(stage);
            nodeTellerAppHashMap.put("SeNT_Node", this);
            startRunCheckSettingField();
            build();
        });
    }

    //创建窗口
    private void build() {
        Parent root = null;
        try {
            root = MainUiController.load();
        } catch (Exception ioe) {
            log.error("An error occurred in the startup program.", ioe);
        }

        if (root != null) {
            Scene scene = new Scene(root);
            stage.setTitle("这个是头");
            stage.getIcons().add(new Image(NodeApp.class.getResourceAsStream("/images/icon.png")));
            stage.setScene(scene);
            stage.setResizable(false);
            initPrimaryStage(stage);
            stage.hide();
        }

        //关闭窗口后退出程序
        Platform.setImplicitExit(false);
    }

    private void initPrimaryStage(Stage stage) {
        stage.setWidth(PRIMARY_STAGE_WIDTH);
        stage.setHeight(PRIMARY_STAGE_HEIGHT);
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        double maxX = primaryScreenBounds.getMaxX();
        double maxY = primaryScreenBounds.getMaxY();
        stage.setX(maxX - PRIMARY_STAGE_WIDTH);
        stage.setY(maxY - PRIMARY_STAGE_HEIGHT);
    }

    private void startRunCheckSettingField() {
        System.out.println("开始运行检查设置字段");
        //假设没有设置全局的节点程序的数据，则创建一个节点程序的数据
        boolean configDateFlag = true;
        if (configDateFlag  ){
            Platform.runLater(() -> {
                try {
                    ConfigSettingMainUiController.buildConfigSettingUi();
                } catch (Exception ex) {
                    log.error("#==>An error occurred while building the configuration Settings screen", ex);
                }
            });
        }

    }

    private void setPrimaryStage(Stage stage) {
        this.stage = stage;
    }


}
