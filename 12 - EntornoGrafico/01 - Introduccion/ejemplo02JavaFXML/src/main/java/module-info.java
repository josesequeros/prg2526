module com.sequeros.ejemplo02javafxml {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.sequeros.ejemplo02javafxml to javafx.fxml;
    exports com.sequeros.ejemplo02javafxml;
}
