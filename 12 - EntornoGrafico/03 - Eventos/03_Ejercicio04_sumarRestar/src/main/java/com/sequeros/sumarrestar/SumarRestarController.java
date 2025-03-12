/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros.sumarrestar;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author 
 */
public class SumarRestarController implements Initializable {

    @FXML
    private Label resultado;
    @FXML
    private CheckBox cbResta;
    @FXML
    private TextField textValor;
    @FXML
    private Text mensajeResta;
    @FXML
    private Button botonSuma;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mensajeResta.setVisible(Boolean.FALSE);
    }

    @FXML
    private void pulsarBotonNumerico(ActionEvent event) {
        Double sumar = 0.0;
        Double resultadoPrevio = Double.parseDouble(resultado.getText().replace(',', '.'));
        String id = ((Button) event.getSource()).getText();
        sumar = Double.parseDouble(id);
        if (cbResta.isSelected()) {
            sumar = sumar * (-1);
        }
        resultadoPrevio = resultadoPrevio + sumar;
        resultado.setText(String.format("%.2f",resultadoPrevio));
    }

    @FXML
    private void checkboxRestaPulsar(ActionEvent event) {
        mensajeResta.setVisible(cbResta.isSelected());
    }

    @FXML
    private void sumarBoton(ActionEvent event) {
        if (!textValor.getText().equals("")) {
            if (cbResta.isSelected()) {
                resultado.setText(String.format("%.2f", 
                        Double.parseDouble(resultado.getText().replace(',', '.')) 
                        - Double.parseDouble(textValor.getText().replace(',', '.'))));
            } else {
                Double nuevo = Double.parseDouble(resultado.getText().replace(',', '.')) 
                        + Double.parseDouble(textValor.getText().replace(',', '.'));
                resultado.setText(String.format("%.2f", nuevo));
            }
        }
    }

}
