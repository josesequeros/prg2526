module com.mycompany.ejemplotableview {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.ejemplotableview to javafx.fxml;
    exports com.mycompany.ejemplotableview;
}
