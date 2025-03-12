module com.sequeros.menudialogoejemplo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.sequeros.menudialogoejemplo to javafx.fxml;
    exports com.sequeros.menudialogoejemplo;
}
