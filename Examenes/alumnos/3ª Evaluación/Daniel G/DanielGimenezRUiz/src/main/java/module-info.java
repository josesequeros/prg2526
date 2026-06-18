module com.sequeros.danielgimenezruiz {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.sequeros.danielgimenezruiz to javafx.fxml;
    exports com.sequeros.danielgimenezruiz;
}
