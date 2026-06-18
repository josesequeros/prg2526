module com.mycompany.persona {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.persona to javafx.fxml;
    exports com.mycompany.persona;
}
