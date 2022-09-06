package com.dx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.function.Consumer;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/8/10
 */
@Slf4j
public class App32AlterToasterfx2Controller implements Initializable {

    @FXML
    private Label title;

    private Consumer<ActionEvent> onAction;


    /**
     * <h2>绑定</h2>
     *
     * @param onAction           执行操作
     */
    public void bind(@NonNull Consumer<ActionEvent> onAction) {
        this.onAction = onAction;
    }

    /**
     * <h2>解除绑定</h2>
     */
    public void unBind() {
        this.onAction = null;
        this.title.textProperty().unbind();
        log.debug("ProgressToastController is unbinding.");
    }

    public void onClick(ActionEvent event) {
        String text = title.getText();
        System.out.println("处理的消息时间是text:"+text);

        System.out.println("点击了当前的东西，需要关闭。。。");
//        this.onAction.accept(event);
//        toast.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        title.setText("测试随的内容" + new Date());
    }
}
