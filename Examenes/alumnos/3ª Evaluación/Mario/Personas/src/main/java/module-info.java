module com.mycompany.personas {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.personas to javafx.fxml;
    exports com.mycompany.personas;
}
