module com.mycompany.pablovazquez {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.pablovazquez to javafx.fxml;
    exports com.mycompany.pablovazquez;
}
