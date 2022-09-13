package com.dx.app;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Description:
 * 滚动面板学习
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/9/6
 */
public class App43ScrollPane extends Application {

    final ScrollPane sp = new ScrollPane();//创建一个滚动面板对象
    final Image[] images = new Image[5];//创建一个图形数组对象
    final ImageView[] pics = new ImageView[5];//创建一个图形可视区域对象数组
    final VBox vb = new VBox();//创建垂直方向的盒子布局器对象
    final Label fileName = new Label();//创建一个文字标签对象
    final String[] imageNames = new String[]{"/images/icon.png", "/images/icon.png", "/images/icon.png", "/images/icon.png", "/images/icon.png"};//图片的相对url值

    @Override
    public void start(Stage stage) {
        VBox box = new VBox();//创建盒子布局器对象
        Scene scene = new Scene(box, 500, 300);//创建一个场景对象
        stage.setScene(scene);//舞台挂载场景对象
        stage.setTitle("ScrollPaneSample");//给舞台设置标题
        box.getChildren().addAll(sp, fileName);//垂直盒子布局对象上瓜子scrollPane对象和一个Label类型标签对象fileName
        VBox.setVgrow(sp, Priority.ALWAYS);//Vbox对象设置垂直方向增长优先级参数，总是以scrollPane对象的在垂直轴上的增长值为基准

        fileName.setLayoutX(30);//设置Label对象在X轴上的坐标位置
        fileName.setLayoutY(160);//设置Label对象在Y轴上的坐标位置

        Image roses = new Image(getClass().getResourceAsStream("/images/icon.png"));//创建一个图片对象
        System.out.println(getClass().getResourceAsStream("/images/icon.png"));
        sp.setContent(new ImageView(roses));//将图片对象加载到ImageView视图区域对象中，并将ImageView对象添加到scrollPane对象的内容区域当中去
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);//设置scrollPane对象的水平滚动策略(本例中设置为水平位置从不滚动)


        for (int i = 0; i < 5; i++) {
            images[i] = new Image(getClass().getResourceAsStream(imageNames[i]));//加载图片到图片数组对象元素中
            pics[i] = new ImageView(images[i]);//将可视化图形区域挂载图片对象
            pics[i].setFitWidth(100);//固定图片可视化区域宽度
            pics[i].setPreserveRatio(true);//图片可视化区域保留比例
            vb.getChildren().add(pics[i]);//vbox语句对象添加图片可视化区域为自己的被布局元素
        }

        sp.setVmax(440);//设置scrollPane对象在垂直轴上的最大可滚动值
        sp.setPrefSize(115, 150);//初始化scrollPane对象的宽度和高度
        sp.setContent(vb);//设置VBox类型对象为scrollPanel对象的内容区域挂载内容
        sp.setPannable(true);//是否可平移
        sp.vvalueProperty().addListener((ObservableValue<? extends Number> ov,
                                         Number old_val, Number new_val) -> {//设置scrollPane对象在垂直轴上滚动的值改变事件处理机制
            fileName.setText(imageNames[(new_val.intValue() - 1) / 100]);//设置标签Label类型对象的文本取值，通过计算得出来的图片名称
        });
        stage.show();//舞台展现
    }

    public static void main(String[] args) {
        launch(args);
    }
}
