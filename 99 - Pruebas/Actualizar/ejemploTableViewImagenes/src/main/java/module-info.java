module com.mycompany.ejemplotableviewimagenes {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.ejemplotableviewimagenes to javafx.fxml;
    exports com.mycompany.ejemplotableviewimagenes;
}
