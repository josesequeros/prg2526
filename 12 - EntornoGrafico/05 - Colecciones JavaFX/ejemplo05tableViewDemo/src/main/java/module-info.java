module com.sequeros.tableviewdemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.sequeros.tableviewdemo to javafx.fxml;
    exports com.sequeros.tableviewdemo;

    opens com.sequeros.tableviewdemo.Controladores to javafx.fxml;
    opens com.sequeros.tableviewdemo.Modelos to javafx.base;
}
