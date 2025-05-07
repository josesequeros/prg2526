/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros.controlcirclefxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author jabue
 */
public class PrimaryController implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    private HBox hBox;
    @FXML
    private Button btAumentar;
    @FXML
    private Button btDisminuir;
    @FXML
    private Circle circle;

    private Scene scenePropia;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        btAumentar.setOnAction(new AumentarHandler());
        btDisminuir.setOnAction(new DisminuirHandler());

        circle.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                aumentar();
            } else if (e.getButton() == MouseButton.SECONDARY) {
                disminuir();
            }
        });

        circle.requestFocus();

        // aquí no tenemos acceso a 
/*        scenePropia.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                aumentar();
                circle.requestFocus();
                System.out.println("up");
            } else if (e.getCode() == KeyCode.DOWN) {
                disminuir();
                circle.requestFocus();
                System.out.println("down");
            }
        });
*/
        btAumentar.setFocusTraversable(false);
        btDisminuir.setFocusTraversable(false);
        
        // otro método, se ejecuta cuando ya se ha cargado la vista
/*
        Platform.runLater(() -> {
            Scene scene = circle.getScene();
            // Ahora podés usarlo
            scene.setOnKeyPressed(e -> {
                if (e.getCode() == KeyCode.UP) {
                    aumentar();
                    circle.requestFocus();
                    System.out.println("up");
                } else if (e.getCode() == KeyCode.DOWN) {
                    disminuir();
                    circle.requestFocus();
                    System.out.println("down");
                }
            });
            System.out.println("Ancho de la ventana: " + scene.getWidth());
        });
*/
    }

    class AumentarHandler implements EventHandler<ActionEvent> {

        @Override // Sobreescribimos el método handle (manejador)
        public void handle(ActionEvent e) {
            aumentar();
        }
    }

    class DisminuirHandler implements EventHandler<ActionEvent> {

        @Override // Sobreescribimos el método handle (manejador)
        public void handle(ActionEvent e) {
            disminuir();
        }
    }

    public void aumentar() {
        circle.setRadius(circle.getRadius() + 2);
    }

    public void disminuir() {
        circle.setRadius(circle.getRadius() > 2
                ? circle.getRadius() - 2 : circle.getRadius() - 1);
    }

    public void setScene(Scene scene) {
        this.scenePropia = scene;
        scenePropia.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                aumentar();
                circle.requestFocus();
                System.out.println("up");
            } else if (e.getCode() == KeyCode.DOWN) {
                disminuir();
                circle.requestFocus();
                System.out.println("down");
            }
        });
        System.out.println("scene cargada");
    }

}
