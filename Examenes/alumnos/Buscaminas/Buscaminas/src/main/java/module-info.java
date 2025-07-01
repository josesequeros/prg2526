module com.mycompany.buscaminas {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.buscaminas to javafx.fxml;
    exports com.mycompany.buscaminas;
}
