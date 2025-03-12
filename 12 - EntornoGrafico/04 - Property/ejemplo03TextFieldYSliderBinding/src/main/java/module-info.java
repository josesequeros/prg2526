module com.sequeros.ejemplo01textfieldyslider {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.sequeros.ejemplo01textfieldyslider to javafx.fxml;
    exports com.sequeros.ejemplo01textfieldyslider;
}
