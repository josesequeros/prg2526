module com.sequeros.ejercicio2menufiguras {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.sequeros.ejercicio2menufiguras to javafx.fxml;
    exports com.sequeros.ejercicio2menufiguras;
}
