module com.sequeros.testbiblioteca {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.sequeros.testbiblioteca to javafx.fxml;
    exports com.sequeros.testbiblioteca;
}
