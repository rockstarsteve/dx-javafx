package com.dx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/8/13
 */
public class ButtonController {

    private static Stage noShowStage = null;

    static {
        //1：不显示的弹窗窗口
        noShowStage = new Stage();
        noShowStage.initStyle(StageStyle.UTILITY);
        noShowStage.setMaxHeight(0);
        noShowStage.setMaxWidth(0);
        noShowStage.setX(Double.MAX_VALUE);
        noShowStage.show();
    }

    @FXML
    private Button btn;

    private static VBox content;

    @FXML
    protected void get() {
        //2：显示的弹窗的窗口
        VBox content = new VBox();
        content.setMinWidth(100);
        content.setMinHeight(100);
        this.content = content;
        Label label = new Label("显示的弹出框");
        content.getChildren().add(label);
        Scene scene = new Scene(content);
        Stage showStage = new Stage();
        showStage.setScene(scene);

        //显示的位置
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        double maxX = primaryScreenBounds.getMaxX();
        double maxY = primaryScreenBounds.getMaxY();
        showStage.setX(maxX - 100);
        showStage.setY(maxY - 200);

        //绑定到不显示的窗体上
        showStage.initStyle(StageStyle.UNDECORATED);
        showStage.initOwner(noShowStage);
        showStage.show();
    }

    public void change(ActionEvent actionEvent) {
        this.content.getScene().getWindow().setHeight(200);
    }
}
