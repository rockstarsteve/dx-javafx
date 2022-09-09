package com.dx.fxml;

import com.dx.util.AlertUtil;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
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
 * @since 2022/8/24
 */
public class LoginTrayTest extends Application {

    private static Stage stage;
    private static SystemTray systemTray;
    private static TrayIcon trayIcon;
    //窗口宽度定义
    private static final double PRIMARY_STAGE_WIDTH = 600.0;
    private static final double PRIMARY_STAGE_HEIGHT = 600.0;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Lable.class.getResource("/fxml/loginTest.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setResizable(false);
        stage.setScene(scene);
        //设置图标
        stage.getIcons().add(new Image(LoginTrayTest.class.getResourceAsStream("/images/icon.png")));
        initStage(stage);
        stage.show();


        Stage s2 = new Stage();
        s2.setHeight(200);
        s2.setWidth(200);
        s2.setX(100);
        s2.setY(100);
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        double maxX = primaryScreenBounds.getMaxX();
        double maxY = primaryScreenBounds.getMaxY();
        s2.setX(maxX - 200);
        s2.setY(maxY - 200);
        s2.setTitle("提示弹窗");

        //把弹窗绑定到主程序
        s2.initOwner(stage);
        s2.show();

        //关闭窗口后退出程序
        Platform.setImplicitExit(false);

        //设置托盘
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
        BufferedImage read = ImageIO.read(Objects.requireNonNull(LoginTrayTest.class.getResourceAsStream("/images/icon.png")));
        TrayIcon newTrayIcon = new TrayIcon(read, "测试程序");
        newTrayIcon.setImageAutoSize(true);

        newTrayIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //点击左键 弹出主界面
                if (e.getButton() == MouseEvent.BUTTON1) {
                    Platform.runLater(() -> showPrimaryStage(LoginTrayTest.stage));
                }
                //鼠标右键
                if (e.getButton() == MouseEvent.BUTTON3) {
                    PopupMenu popMenu = new PopupMenu();
                    MenuItem exitMenuItem = exitMenuItem(systemTray, newTrayIcon);
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
     * @param stage
     */
    private void showPrimaryStage(Stage stage) {
        initStage(stage);
        //判断stage 是否隐藏，若隐藏则展示 ,并且移至屏幕最前端
        if (stage.isIconified()) {
            stage.setIconified(false);
        }
        if (!stage.isShowing()) {
            stage.show();
        }
        stage.toFront();
    }

    /**
     * 初始化右下角的窗口
     *
     * @param stage
     */
    private void initStage(Stage stage) {
        stage.setWidth(PRIMARY_STAGE_WIDTH);
        stage.setHeight(PRIMARY_STAGE_HEIGHT);
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        double maxX = primaryScreenBounds.getMaxX();
        double maxY = primaryScreenBounds.getMaxY();
        stage.setX(maxX - PRIMARY_STAGE_WIDTH);
        stage.setY(maxY - PRIMARY_STAGE_HEIGHT);
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
        MenuItem exitMenuItem = new MenuItem("exitsoft");
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

}
