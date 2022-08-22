module com.dx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    //fxml的路径
    exports com.dx.app;
    exports com.dx.fxml;
    //fxml对应处理类的路径
    opens com.dx.controller to javafx.fxml;
}
