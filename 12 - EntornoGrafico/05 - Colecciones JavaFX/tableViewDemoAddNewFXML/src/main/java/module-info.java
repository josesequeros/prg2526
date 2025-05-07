module com.sequeros.tableviewdemoaddnewfxml {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.sequeros.tableviewdemoaddnewfxml to javafx.fxml;
    exports com.sequeros.tableviewdemoaddnewfxml;
}
