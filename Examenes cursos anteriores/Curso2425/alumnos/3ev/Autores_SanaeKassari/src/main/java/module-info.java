module com.mycompany.autores_sanaekassari {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.autores_sanaekassari to javafx.fxml;
    exports com.mycompany.autores_sanaekassari;
}
