package com.dx.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Description:
 * 下拉框
 * 下拉选择框
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/8/10
 */
public class App09ChoiceBox extends Application {

    @Override
    public void start(Stage primaryStage) {
        /**
         * 下拉框
         */
        VBox root = new VBox();

        ChoiceBox<keyVal> cb = new ChoiceBox<keyVal>();
        cb.getItems().addAll(new keyVal("张三", "zs"), new keyVal("李四", "ls"), new keyVal("王五", "ww"), new keyVal("赵六", "zl"));
        cb.setValue(new keyVal("请选择",""));


        Button btn = new Button("获取choicebox中的值");
        btn.setOnAction(actionEvent -> {
            System.out.println("actionEvent:" + actionEvent);
            System.out.println("选择的内容对象是：" + cb.getValue());
            System.out.println("选择的内容key是：" + cb.getValue().getKey());
            System.out.println("选择的内容val是：" + cb.getValue().getVal());
        });

        //重写显示的方法
        cb.converterProperty().set(new StringConverter<keyVal>() {
            @Override
            public String toString(keyVal keyVal) {
                return keyVal.getKey();
            }

            @Override
            public keyVal fromString(String s) {
                return null;
            }
        });

        root.getChildren().addAll(btn, cb);

        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("窗口");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
class keyVal {

    public String key;
    public String val;


}
