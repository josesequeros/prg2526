package com.mycompany.variasventanas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Ventana2Controller implements Initializable {

    @FXML
    private Button abrirButton;
    @FXML
    private Button salirButton;

    Stage primaryStage;
    
    void initStage(Stage stage) {
        primaryStage = stage;
        primaryStage.setTitle("Ventana 2");
    }

    @FXML
    private void abrirVentana2(ActionEvent event) {
        // pendiente de implementar
    }

    @FXML
    private void salir(ActionEvent event) {
        Node n = (Node) event.getSource();
        n.getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
