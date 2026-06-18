module com.sequeros.simeonexamen {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.sequeros.simeonexamen to javafx.fxml;
    exports com.sequeros.simeonexamen;
}
