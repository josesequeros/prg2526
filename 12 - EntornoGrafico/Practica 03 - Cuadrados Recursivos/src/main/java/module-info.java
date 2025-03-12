module com.sequeros.eje {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.sequeros.eje to javafx.fxml;
    exports com.sequeros.eje;
}
