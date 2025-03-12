module com.sequeros.tresenraya {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.sequeros.tresenraya to javafx.fxml;
    exports com.sequeros.tresenraya;
}
