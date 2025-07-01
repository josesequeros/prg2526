module com.sequeros.autoresexamen {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.sequeros.autoresexamen to javafx.fxml;
    exports com.sequeros.autoresexamen;
}
