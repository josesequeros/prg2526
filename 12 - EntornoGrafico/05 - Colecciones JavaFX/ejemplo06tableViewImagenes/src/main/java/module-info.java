module com.sequeros.tableviewdemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.sequeros.tableviewimagen to javafx.fxml;
    exports com.sequeros.tableviewimagen;

    opens com.sequeros.tableviewimagen.Controladores to javafx.fxml;
}
