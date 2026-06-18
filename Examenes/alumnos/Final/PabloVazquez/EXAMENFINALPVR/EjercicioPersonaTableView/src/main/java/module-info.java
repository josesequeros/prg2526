module com.mycompany.examenprogramacionraro {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.examenprogramacionraro to javafx.fxml;
    exports com.mycompany.examenprogramacionraro;
}
