module com.sequeros.comicteca {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.sequeros.comicteca to javafx.fxml;
    exports com.sequeros.comicteca;
}
