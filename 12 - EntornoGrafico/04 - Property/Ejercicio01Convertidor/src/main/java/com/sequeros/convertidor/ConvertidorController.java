/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros.convertidor;

import static java.lang.String.format;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.util.converter.NumberStringConverter;

/**
 * FXML Controller class
 *
 * @author IEUser
 */
public class ConvertidorController implements Initializable {

    @FXML
    private Slider slider;
    @FXML
    private Text labelConversionRate;
    @FXML
    private TextField textInput;
    @FXML
    private TextField textOutput;
    @FXML
    private Button botonConvertir;
    @FXML
    private Button botonClear;
    @FXML
    private CheckBox cbAutomatico;
    @FXML
    private Text textTasaConversionAnonima;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        botonClear.setOnAction(e -> {
            textOutput.setText("");
            textInput.setText("");
            slider.setValue(0);
        });

        // Mediante una función lambda
        slider.valueProperty().addListener(
                (observable, oldVal, newVal) -> {
                    Double aux = (Double) newVal;
                    labelConversionRate.setText(format("%.2f", Math.round(aux*100.0)/100.0));
                    if (cbAutomatico.isSelected()) {
                        calcular();
                    }
                }
        );
        /*
        // Mediante una clase anónima
        slider.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue o, Object oldVal, Object newVal) {
                textTasaConversionAnonima.setText(format("%.2f",newVal));
            }
        });
         */
        // Usar un enlace (bind)
        //textTasaConversionAnonima.textProperty().bindBidirectional(slider.valueProperty(),new NumberStringConverter());
        textTasaConversionAnonima.textProperty().bind(Bindings.format("%.2f", slider.valueProperty()));

        /*
        // método de conveniencia y función lamda
        botonConvertir.setOnAction((ActionEvent e) -> {
            if (!textInput.getText().equals(" ")) {
                Double resultado = Double.parseDouble(textInput.getText().replace(',', '.'))*slider.getValue();
                textOutput.setText(String.format("%.2f",resultado));
            }
        });
        */
        
        // método de conveniencia y clase anónima
        botonConvertir.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                calcular();
            }
        });

        // método de conveniencia y clase interna
        //botonConvertir.addEventHandler(ActionEvent.ACTION, new botonConvertirActionHandler());
    }

    @FXML
    private void cbAutomaticoOnAction(ActionEvent event) {
        botonConvertir.setDisable(cbAutomatico.isSelected());
        if (cbAutomatico.isSelected()) {
            calcular();
        }
    }

    /*  // No usada
    class botonConvertirActionHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            calcular();
        }
    }
    */
    
    public static boolean esNumerico(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void calcular() {
        if (textInput.getText().length() != 0) {
            if (esNumerico(textInput.getText().replace(',', '.'))) {
                Double resultado = Double.parseDouble(textInput.getText().replace(',', '.')) * Math.round(slider.getValue()*100.0)/100.0;
                textOutput.setText(String.format("%.2f", resultado));
            } else {
                textInput.setText("Valor no numérico");
            }
        } else {
            textOutput.setText("");
        }
    }
}
