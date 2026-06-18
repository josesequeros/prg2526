module com.mycompany.personas {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.personas to javafx.fxml;
    exports com.mycompany.personas;
}
