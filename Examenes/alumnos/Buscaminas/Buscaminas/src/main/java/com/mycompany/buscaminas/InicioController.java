/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.buscaminas;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

//Este es el controlador de la v entana de inicio, donde doy la opción de crear un nuevo jugador, con nombre e imagen, 
//seleccionar un jugador existente (he dejado uno ya creado para que uses ese porque en la carpeta imágenes solo he puesto una),
//y salir de la aplicación.

public class InicioController implements Initializable {

    @FXML
    private Button npbttn;
    @FXML
    private Button spbttn;
    @FXML
    private Button exitbttn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    //Aquí llamo a la ventana de crear nuevo jugador, que ahora en frio creo que no la tendría que haber llamado como root, pero bueno, funciona.
    @FXML
    private void newPlayer(ActionEvent event) {
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("jugadorNuevo.fxml"));
            javafx.scene.Parent root = loader.load();
            javafx.scene.Scene scene = new javafx.scene.Scene(root);
            javafx.stage.Stage stage = (javafx.stage.Stage) ((javafx.scene.Node) event.getSource()).getScene()
                    .getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Literalmente lo mismo que antes, la podría haber llamado sin seleccionar como root, no sé ni para qué he creado el método Parent loadFXML.
    @FXML
    private void selectPlayer(ActionEvent event) {
         try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("jugadores.fxml"));
            javafx.scene.Parent root = loader.load();
            javafx.scene.Scene scene = new javafx.scene.Scene(root);
            javafx.stage.Stage stage = (javafx.stage.Stage) ((javafx.scene.Node) event.getSource()).getScene()
                    .getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Este método simplemente cierra la ventana, no hace falta que haga nada más ya que no hay cambios que guardar ni nada por el estilo.
    @FXML
    private void exit(ActionEvent event) {
        javafx.stage.Stage stage = (javafx.stage.Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
