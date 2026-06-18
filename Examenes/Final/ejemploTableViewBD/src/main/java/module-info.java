module com.mycompany.ejemplotableviewbd {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens com.mycompany.ejemplotableviewbd to javafx.fxml;
    exports com.mycompany.ejemplotableviewbd;
}
