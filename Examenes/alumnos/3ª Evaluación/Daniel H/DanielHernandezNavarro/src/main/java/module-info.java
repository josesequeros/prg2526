module com.sequeros.danielhernandeznavarro {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
    requires java.base;

    opens com.sequeros.danielhernandeznavarro to javafx.fxml;
    exports com.sequeros.danielhernandeznavarro;
}
