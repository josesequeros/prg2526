module com.sequeros.tableviewdemofxml {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.sequeros.tableviewdemofxml to javafx.fxml;
    exports com.sequeros.tableviewdemofxml;
}
