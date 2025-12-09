module com.ejemplo.prueba2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.ejemplo.prueba2 to javafx.fxml;
    exports com.ejemplo.prueba2;
}
