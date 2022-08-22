package com.dx.app;

import com.dx.util.AlertUtil;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/8/10
 */
public class App31Alter extends Application {

    /**
     * 所有的弹框
     *
     * @param primaryStage
     */

    @Override
    public void start(Stage primaryStage) {
//        AlertUtil.buildErrorAlert("头1", "我是内容");
//        AlertUtil.buildErrorAlert("头2", "我是内容", 500);
//        AlertUtil.buildConfirmAlert("头3", "我是内容").show();
//        AlertUtil.buildInfoAlert("头4", "我是内容");
//        AlertUtil.buildInfoAlert("头5", "我是内容", 500);
//        AlertUtil.buildWarnAlert("头6", "我是内容").show();
//        AlertUtil.buildSubmitSuccessInfoAlert();
        AlertUtil.buildSubmitErrorInfoAlert();
    }

    public static void main(String[] args) {
        launch();
    }

}
