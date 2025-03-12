module com.sequeros._ejercicio01_eventosraton_sb {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.sequeros._ejercicio01_eventosraton_sb to javafx.fxml;
    exports com.sequeros._ejercicio01_eventosraton_sb;
}
