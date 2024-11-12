module com.sequeros.deportistaslistview {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.sequeros.deportistaslistview to javafx.fxml;
    exports com.sequeros.deportistaslistview;
}
