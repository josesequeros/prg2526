module com.sequeros.ejemplo01ejemplofxcollectionsfxml {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.sequeros.ejemplo01ejemplofxcollectionsfxml to javafx.fxml;
    exports com.sequeros.ejemplo01ejemplofxcollectionsfxml;
}
