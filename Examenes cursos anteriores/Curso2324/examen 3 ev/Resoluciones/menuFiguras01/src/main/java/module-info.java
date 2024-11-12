module com.sequeros.menufiguras01 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.sequeros.menufiguras01 to javafx.fxml;
    exports com.sequeros.menufiguras01;
}
