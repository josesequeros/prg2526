module com.sequeros._ejercicio01_eventosraton {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.sequeros._ejercicio01_eventosraton to javafx.fxml;
    exports com.sequeros._ejercicio01_eventosraton;
}
