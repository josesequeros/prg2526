package com.mycompany.variasventanas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Ventana1Controller implements Initializable {

    @FXML
    private Button abrirButton;
    @FXML
    private Button salirButton;

    private Stage primaryStage;

    public void initStage(Stage stage) {
        primaryStage = stage;
        primaryStage.setTitle("Ventana 1");
    }

    @FXML
    private void abrirVentana2(ActionEvent event) {
        try {
            Stage estageActual = new Stage();
            //FXMLLoader miCargador = new FXMLLoader(getClass()
            //        .getClassLoader().getResource("com/mycompany/variasventanas/ventana2.fxml"));
            FXMLLoader miCargador = new FXMLLoader(getClass().getResource("ventana2.fxml"));
            Parent root = miCargador.load();
            miCargador.<Ventana2Controller>getController().initStage(estageActual);
            Scene scene = new Scene(root, 400, 400);
            estageActual.setScene(scene);
            estageActual.initModality(Modality.APPLICATION_MODAL);
            estageActual.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
