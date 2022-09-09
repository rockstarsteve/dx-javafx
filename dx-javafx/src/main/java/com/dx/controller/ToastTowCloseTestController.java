package com.dx.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/9/6
 */
public class ToastTowCloseTestController {

    public static Parent load(){
        FXMLLoader fxmlLoader = new FXMLLoader(ToastTowCloseTestController.class.getResource("/fxml/dialog/ProgressToast2Node.fxml"));
        try {
            return fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
