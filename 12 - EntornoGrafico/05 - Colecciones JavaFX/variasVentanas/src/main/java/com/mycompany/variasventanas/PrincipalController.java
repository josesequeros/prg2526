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

public class PrincipalController implements Initializable {

    @FXML
    private Button principalButton;
    @FXML
    private Button salirButton;

    @FXML
    private void abrirVentana1(ActionEvent event) {
        try {
            Stage estageActual = new Stage();
            //FXMLLoader miCargador = new FXMLLoader(getClass()
            //        .getClassLoader().getResource("com/mycompany/variasventanas/ventana1.fxml"));
            FXMLLoader miCargador = new FXMLLoader(getClass().getResource("ventana1.fxml"));
            Parent root = miCargador.load();
            miCargador.<Ventana1Controller>getController().initStage(estageActual);
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
