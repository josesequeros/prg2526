module com.sequeros._ejercicio_03_relojanalogicofxml {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.sequeros._ejercicio_03_relojanalogicofxml to javafx.fxml;
    exports com.sequeros._ejercicio_03_relojanalogicofxml;
}
