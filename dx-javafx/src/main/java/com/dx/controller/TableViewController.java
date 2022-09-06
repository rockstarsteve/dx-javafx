package com.dx.controller;

import com.dx.bean.DataRecord;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/9/6
 */
public class TableViewController implements Initializable {

    @FXML
    private TableView<DataRecord> dataTable = new TableView<DataRecord>();
    @FXML
    private TableColumn variableId = new TableColumn();
    @FXML
    private TableColumn variableName = new TableColumn();
    @FXML
    private TableColumn variableAlias = new TableColumn();
    private ObservableList<DataRecord> data;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        variableId.setCellValueFactory(new PropertyValueFactory<DataRecord, Integer>("id"));
        variableName.setCellValueFactory(new PropertyValueFactory<DataRecord, String>("name"));
        variableAlias.setCellValueFactory(new PropertyValueFactory<DataRecord, String>("alias"));
        dataTable.getItems().setAll(getDataRecordInfo());
    }

    public List<DataRecord> getDataRecordInfo(){
        data =  FXCollections.observableArrayList(
                new DataRecord("1", "Smith", "张三"),
                new DataRecord("2", "Johnson", "李四"),
                new DataRecord("3", "Williams", "王五"),
                new DataRecord("4", "Jones", "卢二"),
                new DataRecord("5", "Brown", "赵一")
        );
        return data;
    }

}

