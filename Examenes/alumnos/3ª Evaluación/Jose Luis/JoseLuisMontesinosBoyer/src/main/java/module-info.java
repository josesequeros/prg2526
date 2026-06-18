module com.sequeros.joseluismontesinosboyer {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.sequeros.joseluismontesinosboyer to javafx.fxml;
    exports com.sequeros.joseluismontesinosboyer;
}
