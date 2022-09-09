package com.dx.app;

import com.dx.controller.App32AlterToasterfx2Controller;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import lombok.extern.slf4j.Slf4j;
import org.pomo.toasterfx.ToastBarToasterService;
import org.pomo.toasterfx.model.ToastParameter;
import org.pomo.toasterfx.model.impl.SingleToast;
import org.pomo.toasterfx.model.impl.ToastTypes;
import org.pomo.toasterfx.util.FXUtils;

import java.net.URL;
import java.util.function.BiConsumer;

/**
 * Description: 自定义显示内容
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/8/10
 */
@Slf4j
public class App32ToasterfxCustomer2 extends Application {

    ToastBarToasterService service = new ToastBarToasterService();

    @Override
    public void start(Stage primaryStage) {
        service.initialize();
        VBox root = new VBox();

        Button btn = new Button("打开冒泡");
        btn.setOnAction(actionEvent -> {
            ToastParameter randomAudioIndefiniteParameter = ToastParameter.builder().timeout(Duration.INDEFINITE).build();

            SingleToast singleToast = new SingleToast(
                    randomAudioIndefiniteParameter,
                    ToastTypes.INFO,
                    "我的窗口",
                    toast -> {
                        URL url = App32ToasterfxCustomer2.class.getResource("/fxml/dialog/ProgressToastNode.fxml");
                        return FXUtils.load(url, (BiConsumer<VBox, App32AlterToasterfx2Controller>) Node::setUserData);
                    }
            );
            singleToast.setIsShowClose(false);
            this.service.push(singleToast);
        });


        root.getChildren().add(btn);
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("窗口");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }


}
