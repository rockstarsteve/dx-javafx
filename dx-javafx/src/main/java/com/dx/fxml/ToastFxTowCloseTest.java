package com.dx.fxml;

import com.dx.app.App32ToasterfxCustomer2;
import com.dx.controller.ToastTowCloseTestController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.pomo.toasterfx.ToastBarToasterService;
import org.pomo.toasterfx.model.ToastParameter;
import org.pomo.toasterfx.model.impl.SingleToast;
import org.pomo.toasterfx.model.impl.ToastTypes;
import org.pomo.toasterfx.util.FXUtils;

import java.io.IOException;
import java.net.URL;
import java.util.function.BiConsumer;

/**
 * Description:
 * 测试toastfx的弹出内容扩展
 * 测试根据点击的按钮获取id值
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/9/6
 */
public class ToastFxTowCloseTest extends Application {

    static ToastBarToasterService service = new ToastBarToasterService();
    static SingleToast singleToast = null;
    static VBox singleToastVbox = null;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Lable.class.getResource("/fxml/ToastFxTowCloseTest.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    /**
     * 点击弹出弹窗
     *
     * @param actionEvent
     */
    public void toastClick(ActionEvent actionEvent) {
        service.initialize();
        ToastParameter randomAudioIndefiniteParameter = ToastParameter.builder().timeout(Duration.INDEFINITE).build();
        SingleToast singleToast = new SingleToast(
                randomAudioIndefiniteParameter,
                ToastTypes.INFO,
                "我的一个弹窗",
                toast -> {
                    URL url = App32ToasterfxCustomer2.class.getResource("/fxml/dialog/ProgressToast2.fxml");
                    VBox load = FXUtils.load(url, (BiConsumer<VBox, ToastTowCloseTestController>) Node::setUserData);
                    this.singleToastVbox = load;
                    return load;
                }
        );
        this.singleToast = singleToast;
        singleToast.setIsShowClose(false);
        this.service.push(singleToast);
    }

    /**
     * 添加一个节点
     */
    public void addNode(ActionEvent actionEvent) {
        System.out.println("要拿到的内容是:" + this.singleToastVbox.getChildren().get(0));
        Parent load = ToastTowCloseTestController.load();
        this.singleToastVbox.getChildren().add(load);
    }

    public void toastClickNew(ActionEvent actionEvent) {
        service.bomb("ok", "232", ToastTypes.INFO);
    }
}



