module com.mycompany.listviewejemplo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.listviewejemplo to javafx.fxml;
    opens com.mycompany.listviewejemplo.controlador to javafx.fxml;
    exports com.mycompany.listviewejemplo;
    exports com.mycompany.listviewejemplo.modelo;
    exports com.mycompany.listviewejemplo.controlador;
}
