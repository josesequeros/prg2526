package com.sequeros.ejemplo04testbindings;

import java.util.Locale;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        DoubleProperty radio = new SimpleDoubleProperty(5.0);
        DoubleProperty area = new SimpleDoubleProperty(0.0);
        // Vinculamos area a una expresión que calcula el área del círculo
        area.bind(Bindings.multiply(Bindings.multiply(radio, radio), Math.PI));
        // Crea una string expression para describir el círculo
        StringExpression desc = Bindings.format(Locale.US,
                "Radio = %.2f, Area = %.2f", radio, area);
        System.out.println(desc.get());
        // Modificamos el radio
        radio.set(10.0);
        // Comprobamos que se ha actualizado el valor del área
        System.out.println(desc.getValue());

        //var scene = new Scene(new StackPane(), 640, 480);
        //stage.setScene(scene);
        //stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
