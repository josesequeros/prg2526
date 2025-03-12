package com.sequeros.ejemplo01textfieldyslider;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;

public class PrimaryController implements Initializable {

    @FXML
    private TextField textField;
    @FXML
    private Slider slider;
    @FXML
    private Label label;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Enlace unidireccional
        label.textProperty().bind(textField.textProperty());
        // Enlace Bidireccional
        textField.textProperty().bindBidirectional(
                slider.valueProperty(), new NumberStringConverter());
        
        /*
        // .......................... Con Bindings
        label.textProperty().bind(Bindings.format("%.2f", slider.valueProperty()));
        textField.textProperty().bind(Bindings.format("%.2f", slider.valueProperty()));
        */
    }

}
