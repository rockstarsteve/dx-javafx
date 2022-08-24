package com.dx.app;

import com.dx.util.AlertUtil;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/8/10
 */
public class App33SystemTray extends Application {

    private static Stage primaryStage;
    private static SystemTray systemTray;
    private static TrayIcon trayIcon;
    //窗口位置
    private static final double PRIMARY_STAGE_WIDTH = 450.0;
    private static final double PRIMARY_STAGE_HEIGHT = 400.0;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        Group root = new Group();
        Text text = new Text(100, 250, "JavaFX 2.0");
        root.getChildren().add(text);
        Scene scene = new Scene(root, 600, 600, Color.PINK);
        primaryStage.setScene(scene);
        primaryStage.setTitle("文本");
        primaryStage.show();
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
        BufferedImage read = ImageIO.read(Objects.requireNonNull(App33SystemTray.class.getResourceAsStream("/images/icon.png")));
        TrayIcon newTrayIcon = new TrayIcon(read, "SeNT_Node");
        newTrayIcon.setImageAutoSize(true);

        newTrayIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //点击左键 弹出主界面
                if (e.getButton() == MouseEvent.BUTTON1) {
                    Platform.runLater(() ->
                            showPrimaryStage(App33SystemTray.getPrimaryStage()));
                }
                //鼠标右键
                if (e.getButton() == MouseEvent.BUTTON3) {
                    PopupMenu popMenu = new PopupMenu();
                    MenuItem exitMenuItem = exitMenuItem(systemTray, newTrayIcon);
//                    MenuItem aboutMenuItem = aboutMenuItem();
//                    popMenu.add(aboutMenuItem);
                    popMenu.add(exitMenuItem);
                    newTrayIcon.setPopupMenu(popMenu);
                }
            }
        });
        return newTrayIcon;
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
     * 初始化窗口
     *
     * @param primaryStage
     */
    public void initPrimaryStage(Stage primaryStage) {
        primaryStage.setWidth(PRIMARY_STAGE_WIDTH);
        primaryStage.setHeight(PRIMARY_STAGE_HEIGHT);
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        double maxX = primaryScreenBounds.getMaxX();
        double maxY = primaryScreenBounds.getMaxY();
        primaryStage.setX(maxX - PRIMARY_STAGE_WIDTH);
        primaryStage.setY(maxY - PRIMARY_STAGE_HEIGHT);
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
//        exitMenuItem.setFont(new Font("微软雅黑", 20, 20));
        exitMenuItem.addActionListener(exitEvent ->
                Platform.runLater(() -> {
                    Alert confirmAlert = AlertUtil.buildConfirmAlert("提示", "是否退出节点程序");
                    Optional<ButtonType> buttonType = confirmAlert.showAndWait();
                    if (buttonType.isPresent() && buttonType.get().getButtonData().getTypeCode().equals(ButtonBar.ButtonData.OK_DONE.getTypeCode())) {
                        Platform.setImplicitExit(true);
                        systemTray.remove(newTrayIcon);
                        App33SystemTray.getPrimaryStage().close();
                        //关闭程序
                        Platform.exit();
                        System.exit(0);
                    }
                }));
        return exitMenuItem;
    }


    public static void main(String[] args) {
        launch();
    }


    public static Stage getPrimaryStage() {
        return primaryStage;
    }

}
