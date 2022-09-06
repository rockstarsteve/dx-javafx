package com.dx.app;

import com.dx.controller.App32AlterToasterfx2Controller;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import lombok.extern.slf4j.Slf4j;
import org.pomo.toasterfx.ToastBarToasterService;
import org.pomo.toasterfx.model.ToastParameter;
import org.pomo.toasterfx.model.impl.SingleToast;
import org.pomo.toasterfx.model.impl.ToastTypes;
import org.pomo.toasterfx.util.FXMessages;
import org.pomo.toasterfx.util.FXUtils;

import java.net.URL;
import java.util.function.BiConsumer;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/8/10
 */
@Slf4j
public class App32AlterToasterfx2 extends Application {

    ToastBarToasterService service = new ToastBarToasterService();
    FXMessages messages;

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
                    "demo.customDigest",
                    toast -> {
                        URL url = App32AlterToasterfx2.class.getResource("/com/dx/fxml/dialog/ProgressToastNode.fxml");
                        return FXUtils.load(url, (BiConsumer<VBox, App32AlterToasterfx2Controller>) Node::setUserData);
                    }
            );


            singleToast.setIsShowClose(false);

//            singleToast.setOnDock((toast, node) -> {
//                App32AlterToasterfx2Controller controller = (App32AlterToasterfx2Controller) node.getUserData();
//                controller.bind(it -> task.action(toast)
//                );
//            });

            this.service.push(singleToast);

//            new Timer().schedule(new TimerTask() {
//                @Override
//                public void run() {
//                    Platform.runLater(new Runnable() {
//                        @Override
//                        public void run() {
//                            //更新JavaFX的主线程的代码放在此处
//                            singleToast.close();
//                        }
//                    });
//                }
//            }, 5000);
        });


        root.getChildren().add(btn);
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("窗口");
        primaryStage.show();
    }

    /**
     * <h2>绑定文本属性</h2>
     *
     * @param labeledArray labeled 数组
     */
    private void bindTextProperty(Labeled... labeledArray) {
        for (Labeled labeled : labeledArray) {
            this.messages.bindProperty(this, labeled.textProperty(), "demo." + labeled.getId());
        }
    }

    public static void main(String[] args) {
        launch();
    }


}
