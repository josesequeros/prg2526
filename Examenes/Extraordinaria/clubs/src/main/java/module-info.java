module com.mycompany.clubs {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.clubs to javafx.fxml;
    exports com.mycompany.clubs;
}
