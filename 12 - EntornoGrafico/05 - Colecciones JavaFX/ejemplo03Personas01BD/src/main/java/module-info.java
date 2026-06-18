module com.mycompany.listviewejemplo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.mycompany.listviewejemplo to javafx.fxml;
    exports com.mycompany.listviewejemplo;
}
