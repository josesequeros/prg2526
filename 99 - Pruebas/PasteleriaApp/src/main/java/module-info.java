module com.sequeros.pasteleriaapp {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.sequeros.pasteleriaapp to javafx.fxml;
    exports com.sequeros.pasteleriaapp;
}
