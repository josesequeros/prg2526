module com.sequeros.convertidor {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.sequeros.convertidor to javafx.fxml;
    exports com.sequeros.convertidor;
}
