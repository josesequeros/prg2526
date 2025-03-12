/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros.eje;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.converter.NumberStringConverter;

/**
 * FXML Controller class
 *
 * @author jabue
 */
public class CuadradosController implements Initializable {

    @FXML
    private TextField tfNivel;
    @FXML
    private Button botonAplicar;
    @FXML
    private Pane pane;

    private double milado;
    @FXML
    private BorderPane borderPane;
    @FXML
    private CheckBox cbInvertir;
    @FXML
    private Slider slider;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // Crear un TextFormatter con una expresión regular para aceptar solo números
        tfNivel.setTextFormatter(new TextFormatter<>(change -> {
            if (change.getControlNewText().matches("\\d*")) {
                return change;
            }
            return null;
        }));
        
        tfNivel.setText("1");
        tfNivel.textProperty().bindBidirectional(
                slider.valueProperty(), new NumberStringConverter());

        //botonAplicar.setOnAction(this::botonPulsado);
        botonAplicar.setOnAction((ActionEvent event) -> {
            botonPulsado();
        });
        // Redondear el valor del slider al valor más cercano de los ticks mientras se arrastra
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            // Obtener el valor del tick más cercano
            double tickValue = Math.round(newValue.doubleValue() / slider.getMajorTickUnit()) * slider.getMajorTickUnit();
            // Establecer el valor del slider al valor del tick más cercano
            slider.setValue(tickValue);
        });

        borderPane.widthProperty().addListener((observable, oldValue, newValue) -> {
            milado = newValue.doubleValue() / 2;
            milado = Math.min(pane.getWidth(), pane.getHeight()) / 2;
            botonPulsado();

        });
        borderPane.heightProperty().addListener((observable, oldValue, newValue) -> {
            milado = Math.min(pane.getWidth(), pane.getHeight()) / 2;
            botonPulsado();
        });

        //dibujarEjes();
    }

    private void dibujarEjes() {
        // Crear las líneas del eje X e Y
        Line ejeX = new Line();
        Line ejeY = new Line();
        // Listener para el cambio en el ancho y alto del Pane
        borderPane.widthProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Ancho del borderPane: " + newValue);
            System.out.println("Ancho del pane: " + pane.getWidth());
            System.out.println("Alto del pane: " + pane.getHeight());
            milado = newValue.doubleValue() / 2;
            milado = Math.min(pane.getWidth(), pane.getHeight()) / 2;
            botonPulsado();

        });
        borderPane.heightProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Alto del borderPane: " + newValue);
            System.out.println("Ancho del pane: " + pane.getWidth());
            System.out.println("Alto del pane: " + pane.getHeight());
            milado = Math.min(pane.getWidth(), pane.getHeight()) / 2;
        });

        // Establecer el color de las líneas del eje
        ejeX.setStroke(Color.RED);
        ejeY.setStroke(Color.RED);

        // Agregar las líneas al panel
        pane.getChildren().addAll(ejeX, ejeY);
    }

    private void botonPulsado() {
        int nivel;
        pane.getChildren().clear();
        /*
        if (tfNivel.getText().equals("")) {
            tfNivel.setText("1");
        }
         */
        try {
            nivel = Integer.parseInt(tfNivel.getText());
            if (nivel > 8) {
                nivel = 8;
                tfNivel.setText("8");
            }
        } catch (NumberFormatException e) {
            tfNivel.setText("1");
            nivel = 1;
        }
        int lado = (int) milado;
        double centroX = (pane.getWidth() - lado) / 2;
        double centroY = (pane.getHeight() - lado) / 2;
        if (cbInvertir.isSelected()) {
            rCuadradoInverso(nivel, centroX, centroY, lado);
        } else {
            rCuadrado(nivel, centroX, centroY, lado);
        }

    }

    private void rCuadrado(int n, double centroX, double centroY, double lado) {
        Rectangle square = new Rectangle(centroX, centroY, lado, lado); // ancho y alto
        square.setFill(Color.WHITE);
        square.setStroke(Color.BLUE);
        pane.getChildren().add(square);
        if (n > 1) {
            rCuadrado(n - 1, centroX - lado / 4, centroY - lado / 4, lado / 2);
            rCuadrado(n - 1, centroX - lado / 4, (centroY + lado) - lado / 4, lado / 2);
            rCuadrado(n - 1, (centroX + lado) - lado / 4, centroY - lado / 4, lado / 2);
            rCuadrado(n - 1, (centroX + lado) - lado / 4, (centroY + lado) - lado / 4, lado / 2);
        }
    }

    private void rCuadradoInverso(int n, double centroX, double centroY, double lado) {
        if (n > 1) {
            rCuadradoInverso(n - 1, centroX - lado / 4, centroY - lado / 4, lado / 2);
            rCuadradoInverso(n - 1, centroX - lado / 4, (centroY + lado) - lado / 4, lado / 2);
            rCuadradoInverso(n - 1, (centroX + lado) - lado / 4, centroY - lado / 4, lado / 2);
            rCuadradoInverso(n - 1, (centroX + lado) - lado / 4, (centroY + lado) - lado / 4, lado / 2);
        }
        Rectangle square = new Rectangle(centroX, centroY, lado, lado); // ancho y alto
        square.setFill(Color.WHITE);
        square.setStroke(Color.BLUE);
        pane.getChildren().add(square);

    }

}
