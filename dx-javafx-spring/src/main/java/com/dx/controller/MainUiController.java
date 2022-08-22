package com.dx.controller;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/8/22
 */
public class MainUiController {


    public static Parent load() {
        BorderPane root = new BorderPane();
        Label label = new Label("这个是主页面的内容");
        root.setTop(label);
        return root;
    }
}
