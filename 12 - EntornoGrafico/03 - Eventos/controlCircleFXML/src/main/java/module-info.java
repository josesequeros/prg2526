module com.sequeros.controlcirclefxml {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.sequeros.controlcirclefxml to javafx.fxml;
    exports com.sequeros.controlcirclefxml;
}
