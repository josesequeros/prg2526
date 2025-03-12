module com.mycompany.variasventanas {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.variasventanas to javafx.fxml;
    exports com.mycompany.variasventanas;
}
