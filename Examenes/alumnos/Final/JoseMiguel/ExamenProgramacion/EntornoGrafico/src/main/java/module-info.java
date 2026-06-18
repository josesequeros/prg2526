module com.sequeros.practicaexamenterceraevaluacion {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.base;

    opens com.sequeros.practicaexamenterceraevaluacion to javafx.fxml;
    exports com.sequeros.practicaexamenterceraevaluacion;
}
