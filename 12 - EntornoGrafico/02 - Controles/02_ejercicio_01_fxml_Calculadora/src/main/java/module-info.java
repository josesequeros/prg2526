module com.sequeros._ejercicio_01_fxml_calculadora {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.sequeros._ejercicio_01_fxml_calculadora to javafx.fxml;
    exports com.sequeros._ejercicio_01_fxml_calculadora;
}
