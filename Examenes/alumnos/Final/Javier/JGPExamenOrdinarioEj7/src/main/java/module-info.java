module com.mycompany.examen3ev2026 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.sequeros.jgpexamenordinarioej7 to javafx.fxml;
    exports com.sequeros.jgpexamenordinarioej7;
}
