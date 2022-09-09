package com.dx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.Date;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.UUID;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/9/9
 */
public class ToastTowCloseTestNodeController implements Initializable {

    @FXML
    private Label title;
    @FXML
    private String hideId;

    /**
     * 关闭弹窗事件
     */
    public void onClick(ActionEvent event) {
        System.out.println("点击了一个节点内容。。。");
        Map<Object, Object> properties = ((Node) event.getSource()).getProperties();
        System.out.println("id: " + hideId);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        title.setText("随意的一个数：" + new Date());
        this.hideId = UUID.randomUUID().toString();
    }
}
