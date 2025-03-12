module com.sequeros.ejemplo03login {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.sequeros.ejemplo03login to javafx.fxml;
    exports com.sequeros.ejemplo03login;
}
