module com.dx.dxjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.dx to javafx.fxml;
    exports com.dx;
}
