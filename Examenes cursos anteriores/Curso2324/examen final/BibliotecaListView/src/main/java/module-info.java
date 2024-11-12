module com.sequeros.bibliotecalistview {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.sequeros.bibliotecalistview to javafx.fxml;
    exports com.sequeros.bibliotecalistview;
}
