module com.sequeros.josemiguelgimenogarcia {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.sequeros.josemiguelgimenogarcia to javafx.fxml;
    exports com.sequeros.josemiguelgimenogarcia;
}
