package com.dx.app;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/9/6
 */
public class App43Loding extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //创建滑动条
        final Slider slider = new Slider();
        //设置滑动条的最小值和最大值
        slider.setMin(0);
        slider.setMax(50);
        //创建不确定的进度饼图
        final ProgressIndicator pi = new ProgressIndicator();
//        ChangeListener<Number> changeListener = new ChangeListener<Number>() {
//            @Override
//            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
//                //50是滚动条的最大值，所以最后处于50可以得到滑动条的进度
//                pi.setProgress(newValue.doubleValue() / 50);
//            }
//        };
//        //监听滑动条
//        slider.valueProperty().addListener(changeListener);
        //创建单行面板
        final HBox hb = new HBox();
        hb.setSpacing(5);
        hb.setAlignment(Pos.CENTER);
        hb.getChildren().addAll( pi);
        Scene scene = new Scene(hb,400,400);
        primaryStage.setTitle("进度条应用程序");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
