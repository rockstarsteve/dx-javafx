module com.dx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    exports com.dx;
    exports com.dx.controller;
    opens com.dx.controller to javafx.fxml;
}
