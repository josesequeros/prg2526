package com.sequeros.calculadora;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class CalculadoraController implements Initializable {

    private Label etiqueta;
    @FXML
    private GridPane miGrid;
    @FXML
    private TextField tfDisplay;

    // Para el cálculo
    private double resultado = 0;      // Resultado del cáculo
    private String inStr = "0";  // La entrada de números como un String
    // Operador Previo: ' '(nada), '+', '-', '*', '/', '='
    private char lastOperador = ' ';

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        miGrid.getChildren().forEach((Node button) -> {
            //button.disableProperty().setValue(true);
            if (button instanceof Button) {
                //((Button) button).textProperty().setValue("");
                ((Button) button).setOnAction(this::botonPulsado);
                //((Button) button).setGraphic(null);
            }
        });
    }

    private void botonPulsado(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        System.out.println(clickedButton.getText());
        String currentBtnLabel = ((Button) event.getSource()).getText();
        switch (currentBtnLabel) {
            // Buttons de números
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                if (inStr.equals("0")) {
                    inStr = currentBtnLabel;  // para eliminar el 0 del principio
                } else {
                    inStr += currentBtnLabel; // añadimos el dígito pulsado
                }
                tfDisplay.setText(inStr);
                // Limpiamos el buffer si el último operador es '='
                if (lastOperador == '=') {
                    resultado = 0;
                    lastOperador = ' ';
                }
                break;
            case ".":
                if (inStr.contains(".")) {
                    //inStr = currentBtnLabel;  
                    System.out.println("Dos .");
                } else {
                    inStr += currentBtnLabel; // añadimos el punto
                }
                tfDisplay.setText(inStr);
                // Limpiamos el buffer si el último operador es '='
                if (lastOperador == '=') {
                    resultado = 0;
                    lastOperador = ' ';
                }
                break;
            // Buttons de Operadores: '+', '-', 'x', '/' o '='
            case "+":
                calcular();
                lastOperador = '+';
                break;
            case "-":
                calcular();
                lastOperador = '-';
                break;
            case "X":
                calcular();
                lastOperador = '*';
                break;
            case "/":
                calcular();
                lastOperador = '/';
                break;
            case "=":
                calcular();
                lastOperador = '=';
                break;

            // Button de Limpiar
            case "C":
                resultado = 0;
                inStr = "0";
                lastOperador = ' ';
                tfDisplay.setText("0");
                break;
        }
    }

    // Cuando el usuario pulsa el botón '+', '-', '*', '/' o '=' 
    // Realizamos el cálculo del resultado previo y el número de entrada actual
    // basado en el operador previo.
    private void calcular() {
        double inNum = Double.parseDouble(inStr);
        inStr = "0";
        switch (lastOperador) {
            case ' ':
                resultado = inNum;
                break;
            case '+':
                resultado += inNum;
                break;
            case '-':
                resultado -= inNum;
                break;
            case '*':
                resultado *= inNum;
                break;
            case '/':
                if (inNum != 0) {
                    resultado /= inNum;
                }
                break;
            case '=':   // Nada. Mantenemos el resultado para la siguiente operación
                break;
            default:
                break;
        }
        tfDisplay.setText(resultado + "");
    }
}
