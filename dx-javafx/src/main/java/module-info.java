module com.dx {

    //导入需要用到的包
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires com.fasterxml.jackson.databind;
    requires okhttp3;
    requires lombok;
    requires org.slf4j;
    requires org.pomo.toasterfx;

    requires javafx.base;
    requires javafx.graphics;
//    requires javafx.media;
//    requires javafx.web;


    //导出bean
    exports com.dx.bean;
    //fxml的路径
    exports com.dx.app;
    exports com.dx.fxml;
    //fxml对应处理类的路径
    opens com.dx.controller to javafx.fxml;
}


