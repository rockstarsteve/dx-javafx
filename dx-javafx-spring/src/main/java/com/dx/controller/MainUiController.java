package com.dx.controller;

import com.dx.network.OkHttpUtils;
import com.dx.util.AlertUtil;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
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
public class MainUiController {

    /**
     * 生成主页的内容
     *
     * @return
     */
    public static Parent load() {
        BorderPane root = new BorderPane();
        Label label = new Label("这个是主页面的内容");
        root.setTop(label);

        Button button = new Button("点我发送消息");


        button.setOnAction(actionEvent -> {
            log.info("点击了请求的百度接口的按钮！！");
            // get请求，方法顺序按照这种方式，切记选择post/get一定要放在倒数第二，同步或者异步倒数第一，才会正确执行
            String async = OkHttpUtils.builder()
                    .url("http://www.bidu.com")
                    .get()
                    .async();
            log.info("请求百度返回的内容是:" + async);
            AlertUtil.buildInfoAlert("提示", "请求百度成功，请查看日志输出");
        });

        root.setCenter(button);
        return root;
    }

}
