package com.dx.util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * @Author:Fan
 * @Description:
 * @Date:Create in 14:37 2021/8/11
 * @Modify By:
 **/
public class AlertUtil {
    private String title;
    private String msg;

    private static Stage stage = new Stage();

    public static void buildErrorAlert(String title, String msg) {
        Alert errorAlert = new Alert(AlertType.ERROR);
        errorAlert.setTitle(title);
        errorAlert.setHeaderText(null);
        errorAlert.setContentText(msg);
        check(errorAlert);
        errorAlert.show();
    }
    public static void buildErrorAlert(String title, String msg, double height) {
        Alert errorAlert = new Alert(AlertType.ERROR);
        errorAlert.setHeight(height);
        errorAlert.setTitle(title);
        errorAlert.setHeaderText(null);
        errorAlert.setContentText(msg);
        check(errorAlert);
        errorAlert.show();
    }

    public static Alert buildConfirmAlert(String title, String msg) {
        Alert confirmAlert = new Alert(AlertType.CONFIRMATION);
        confirmAlert.setTitle(title);
        confirmAlert.setHeaderText(null);
        confirmAlert.setContentText(msg);
        check(confirmAlert);
        return confirmAlert;
    }

    public static void buildInfoAlert(String title, String msg) {
        Alert infoAlert = new Alert(AlertType.INFORMATION);
        infoAlert.setTitle(title);
        infoAlert.setHeaderText(null);
        infoAlert.setContentText(msg);
        check(infoAlert);
        infoAlert.show();
    }
    public static void buildInfoAlert(String title, String msg, double height) {
        Alert infoAlert = new Alert(AlertType.INFORMATION);
        infoAlert.setHeight(height);
        infoAlert.setTitle(title);
        infoAlert.setHeaderText(null);
        infoAlert.setContentText(msg);
        check(infoAlert);
        infoAlert.show();
    }

    public static Alert buildWarnAlert(String title, String msg) {
        Alert warnAlert = new Alert(AlertType.WARNING);
        warnAlert.setTitle(title);
        warnAlert.setHeaderText(null);
        warnAlert.setContentText(msg);
        check(warnAlert);
        return warnAlert;
    }

    public static void buildSubmitSuccessInfoAlert() {
        buildInfoAlert("提交信息", "提交成功");
    }

    public static void buildSubmitErrorInfoAlert() {
        buildErrorAlert("提交信息", "提交失败");
    }

    private static void check(Alert alert) {
        alert.getDialogPane().setStyle("-fx-font-size: 16");
        stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(AlertUtil.class.getResourceAsStream("/images/icon.png")));
    }



}
