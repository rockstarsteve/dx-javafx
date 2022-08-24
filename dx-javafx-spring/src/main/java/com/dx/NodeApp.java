package com.dx;

import com.dx.controller.ConfigSettingMainUiController;
import com.dx.controller.MainUiController;
import com.dx.util.AlertUtil;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

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

    private static Stage stage;
    private static SystemTray systemTray;
    private static TrayIcon trayIcon;
    //窗口宽度定义
    private static final double PRIMARY_STAGE_WIDTH = 450.0;
    private static final double PRIMARY_STAGE_HEIGHT = 400.0;

    //定义节点程序全局数据
    private static Map<String, NodeApp> nodeTellerAppHashMap = new HashMap<>();

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
            nodeTellerAppHashMap.put("测试桌面程序", this);
            //判断是否需要设置全局参数
            startRunCheckSettingField();
            //创建主窗体
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

        if (SystemTray.isSupported()) {
            try {
                SystemTray systemTray = SystemTray.getSystemTray();
                this.systemTray = systemTray;
                this.trayIcon = getTrayIcon(systemTray);
                systemTray.add(this.trayIcon);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("The current platform does not support system tray.");
        }


    }


    /**
     * 获取托盘内容
     *
     * @param systemTray
     * @return
     * @throws IOException
     */
    private TrayIcon getTrayIcon(SystemTray systemTray) throws IOException {
        BufferedImage read = ImageIO.read(Objects.requireNonNull(NodeApp.class.getResourceAsStream("/images/icon.png")));
        TrayIcon newTrayIcon = new TrayIcon(read, "SeNT_Node");
        newTrayIcon.setImageAutoSize(true);

        newTrayIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //点击左键 弹出主界面
                if (e.getButton() == MouseEvent.BUTTON1) {
                    Platform.runLater(() -> showPrimaryStage(NodeApp.stage));
                }
                //鼠标右键
                if (e.getButton() == MouseEvent.BUTTON3) {
                    PopupMenu popMenu = new PopupMenu();
                    MenuItem exitMenuItem = exitMenuItem(systemTray, newTrayIcon);
                    MenuItem aboutMenuItem = aboutMenuItem();
                    popMenu.add(aboutMenuItem);
                    popMenu.add(exitMenuItem);
                    newTrayIcon.setPopupMenu(popMenu);
                }
            }
        });
        return newTrayIcon;
    }

    /**
     * 关于软件的菜单
     *
     * @return
     */
    private MenuItem aboutMenuItem() {
        MenuItem aboutMenuItem = new MenuItem("关于软件");
        aboutMenuItem.addActionListener(clickEvent ->
                Platform.runLater(() -> {
                    AlertUtil.buildErrorAlert("提示", "这个是关于软件的一些信息");
                }));
        return aboutMenuItem;
    }

    /**
     * 退出程序
     *
     * @param systemTray
     * @param newTrayIcon
     * @return
     */
    private MenuItem exitMenuItem(SystemTray systemTray, TrayIcon newTrayIcon) {
        //退出菜单
        MenuItem exitMenuItem = new MenuItem("exit退出");
        exitMenuItem.addActionListener(exitEvent ->
                Platform.runLater(() -> {
                    Alert confirmAlert = AlertUtil.buildConfirmAlert("提示", "是否退出节点程序");
                    Optional<ButtonType> buttonType = confirmAlert.showAndWait();
                    if (buttonType.isPresent() && buttonType.get().getButtonData().getTypeCode().equals(ButtonBar.ButtonData.OK_DONE.getTypeCode())) {
                        Platform.setImplicitExit(true);
                        systemTray.remove(newTrayIcon);
                        this.stage.close();
                        //关闭程序
                        Platform.exit();
                        System.exit(0);
                    }
                }));
        return exitMenuItem;
    }

    /**
     * 显示主界面
     *
     * @param primaryStage
     */
    private void showPrimaryStage(Stage primaryStage) {
        initPrimaryStage(primaryStage);
        //判断stage 是否隐藏，若隐藏则展示 ,并且移至屏幕最前端
        if (primaryStage.isIconified()) {
            primaryStage.setIconified(false);
        }
        if (!primaryStage.isShowing()) {
            primaryStage.show();
        }
        primaryStage.toFront();
    }


    /**
     * 初始化右下角的窗口
     *
     * @param stage
     */
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
        boolean configDateFlag = false;
        if (configDateFlag) {
            Platform.runLater(() -> {
                try {
                    ConfigSettingMainUiController.buildConfigSettingUi();
                } catch (Exception ex) {
                    log.error("#==>An error occurred while building the configuration Settings screen", ex);
                }
            });
        }

    }

    private void setPrimaryStage(Stage primaryStage) {
        this.stage = primaryStage;
    }


}
