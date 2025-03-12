module com.mycompany.listviewejemplo {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.listviewejemplo to javafx.fxml;
    opens com.mycompany.listviewejemplo.controlador to javafx.fxml;
    exports com.mycompany.listviewejemplo;
}
