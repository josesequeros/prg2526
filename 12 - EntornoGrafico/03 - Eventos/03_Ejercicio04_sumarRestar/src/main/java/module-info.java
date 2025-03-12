module com.sequeros.sumarrestar {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.sequeros.sumarrestar to javafx.fxml;
    exports com.sequeros.sumarrestar;
}
