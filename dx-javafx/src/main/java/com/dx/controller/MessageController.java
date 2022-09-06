package com.dx.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @ClassName MessageController
 * @function [业务功能]
 * @Author lcz
 * @Date 2020/12/20 21:27
 */
@Slf4j
@Data
public class MessageController implements Initializable  {

    @FXML
    private Text messageInfo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
