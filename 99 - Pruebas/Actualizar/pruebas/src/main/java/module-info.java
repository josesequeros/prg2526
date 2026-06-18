module com.mycompany.pruebas {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.pruebas to javafx.fxml;
    exports com.mycompany.pruebas;
}
