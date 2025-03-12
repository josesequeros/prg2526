module com.sequeros.movercirculo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.sequeros.movercirculo to javafx.fxml;
    exports com.sequeros.movercirculo;
}
