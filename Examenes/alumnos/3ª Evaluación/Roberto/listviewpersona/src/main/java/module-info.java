module com.mycompany.listviewpersona {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.listviewpersona to javafx.fxml;
    exports com.mycompany.listviewpersona;
}
