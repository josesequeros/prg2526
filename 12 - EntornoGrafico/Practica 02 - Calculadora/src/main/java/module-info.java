module com.sequeros.molde {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.sequeros.calculadora to javafx.fxml;
    exports com.sequeros.calculadora;
}
