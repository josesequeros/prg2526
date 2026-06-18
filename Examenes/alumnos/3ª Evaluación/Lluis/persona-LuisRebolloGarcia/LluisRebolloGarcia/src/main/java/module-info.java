module es.sequeros.lluisrebollogarcia {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens es.sequeros.lluisrebollogarcia to javafx.fxml;
    exports es.sequeros.lluisrebollogarcia;
}
