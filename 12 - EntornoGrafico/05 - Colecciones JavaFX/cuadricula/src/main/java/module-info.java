module com.sequeros.cuadricula {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.sequeros.cuadricula to javafx.fxml;
    exports com.sequeros.cuadricula;
}
