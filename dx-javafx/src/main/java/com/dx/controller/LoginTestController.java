package com.dx.controller;

import com.dx.bean.RespToken;
import com.dx.store.ApplicatonStore;
import com.dx.util.AlertUtil;
import com.dx.util.OkHttpUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import okhttp3.Call;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/8/13
 */
public class LoginTestController implements Initializable {

    ObjectMapper objectMapper = new ObjectMapper();

    @FXML
    private HBox usernameBox;
    @FXML
    private HBox passwordBox;
    @FXML
    private HBox btnBox;
    @FXML
    private HBox copyBox;
    @FXML
    private TextField usernameInput;
    @FXML
    private PasswordField passwordInput;
    @FXML
    private Button loginBtn;
    @FXML
    private Button cancleBtn;
    @FXML
    private Text texttoken;

    @FXML
    protected void loginBtn() throws Exception {
        String username = usernameInput.getText();
        String password = passwordInput.getText();
        System.out.println("用户名是：" + usernameInput.getText());
        System.out.println("密码是：" + passwordInput.getText());

        OkHttpUtils.builder().url("http://localhost:8088/getToken").addParam("typeId", "123").post(true).async(new OkHttpUtils.ICallBack() {
            @Override
            public void onSuccessful(Call call, String data) throws JsonProcessingException {
                System.out.println("成功返回的参数是：" + data);
                RespToken respToken = objectMapper.readValue(data, RespToken.class);
                ApplicatonStore.setToken(respToken.getToken());
            }

            @Override
            public void onFailure(Call call, String errorMsg) {
                System.out.println("失败返回的数据是：" + errorMsg);
            }
        });

        if ("root".equals(username) && "root".equals(password)) {
            AlertUtil.buildInfoAlert("提示", "用户登录成功");
        } else {
            AlertUtil.buildErrorAlert("登录提示", "登录失败");
        }
        System.out.println("你开始登录了");
    }

    @FXML
    protected void cancleBtn() {
        System.out.println("取消了...");

        String token = ApplicatonStore.getToken();
        System.out.println("token:" + token);

    }

    /**
     * 初始化绑定关系
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SimpleStringProperty simpleStringProperty = ApplicatonStore.tokenProperty();
        texttoken.textProperty().bind(simpleStringProperty);
    }
}
