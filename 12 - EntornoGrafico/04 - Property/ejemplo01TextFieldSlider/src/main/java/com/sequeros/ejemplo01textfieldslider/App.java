package com.sequeros.ejemplo01textfieldslider;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Label label = new Label();
        label.setFont(Font.font("Times New Roman", 22));
        TextField textField = new TextField();
        Slider slider = new Slider(0, 5, 0);
        slider.setBlockIncrement(0.5);
        slider.setMax(150);

        textField.textProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue o, Object oldVal, Object newVal) {
                label.setText(newVal + "");
            }
        });

        slider.valueProperty().addListener((observable, oldVal, newVal) -> {
            label.setText(newVal + "");
        });

        var scene = new Scene(new VBox(label, textField, slider), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
