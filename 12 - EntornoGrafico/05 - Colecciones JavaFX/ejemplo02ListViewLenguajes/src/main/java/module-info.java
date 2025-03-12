module com.sequeros.ejemplolistviewlenguajes {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.sequeros.ejemplolistviewlenguajes to javafx.fxml;
    exports com.sequeros.ejemplolistviewlenguajes;
}
