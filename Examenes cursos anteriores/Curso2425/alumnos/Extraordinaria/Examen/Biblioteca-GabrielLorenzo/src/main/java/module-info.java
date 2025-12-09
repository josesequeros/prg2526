module com.mycompany.biblioteca.gabriellorenzo {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.biblioteca.gabriellorenzo to javafx.fxml;
    exports com.mycompany.biblioteca.gabriellorenzo;
}
