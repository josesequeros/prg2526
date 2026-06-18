module com.mycompany.joaquinparedesgomez {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.joaquinparedesgomez to javafx.fxml;
    exports com.mycompany.joaquinparedesgomez;
}
