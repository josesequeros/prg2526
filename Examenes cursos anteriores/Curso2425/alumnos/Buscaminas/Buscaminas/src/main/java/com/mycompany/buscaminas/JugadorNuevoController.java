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
import javafx.scene.control.TextField;

/**Esta es la clase controladora de la ventana de jugador nuevo, en la que se pide el nombre y la imagen del jugador.
 * Como se pide en la práctica, tanto el nombre como la imagen se guardan en un archivo de texto llamado "jugadores.txt", además,
 * el nombre del jugador no puede estar vacío ni repetirse.
 */
public class JugadorNuevoController implements Initializable {

    @FXML
    private TextField nombretxt;
    @FXML
    private TextField imagentxt;
    @FXML
    private Button clearbttn;
    @FXML
    private Button savebttn;
    @FXML
    private Button exitbttn;

    public String nombre;
    public String imgpath;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void newname(ActionEvent event) {
        nombre = nombretxt.getText();
    }

    @FXML
    private void newimage(ActionEvent event) {
        imgpath = imagentxt.getText();
    }

    @FXML
    private void clear(ActionEvent event) {
        nombretxt.clear();
        imagentxt.clear();
    }


    //No comento lo anterior porque creo que es muy simple y ya bastante biblia te estoy haciendo.
    // En este método guardamos el nombre y el path de la imagen en el archivo de texto.
    //Recuerdo que en un principio hice que añadir imagen fuera opcional, pero probando por qué se me veía solo el nombre y no la imagen
    // en el listView decidí hacer obligatorio que se guardase la imagen como forma de "depurar", y bueno, ahora ya lo voy a dejar así.
    // También comprobamos que el nombre no esté vacío ni repetido, si no cumple alguna condición, mostramos mensaje de error.
    @FXML
    private void save(ActionEvent event) {
        nombre = nombretxt.getText();
        imgpath = imagentxt.getText();
        if (nombre == null || nombre.isEmpty() || imgpath == null || imgpath.isEmpty()) {
            javafx.scene.control.Alert alerta = new javafx.scene.control.Alert(
                    javafx.scene.control.Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("No puede haber campos vacíos");
            alerta.setContentText("Por favor, complete todos los campos antes de guardar.");
            alerta.showAndWait();
            return;
        }

        // Esta es la parte en la que leemos el txt para comprobar que el nombre no exista ya.
        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader("jugadores.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length > 0 && nombre.equalsIgnoreCase(partes[0].trim())) {
                    javafx.scene.control.Alert alerta = new javafx.scene.control.Alert(
                            javafx.scene.control.Alert.AlertType.ERROR);
                    alerta.setTitle("Error");
                    alerta.setHeaderText("Nombre duplicado");
                    alerta.setContentText("Ya existe un jugador con ese nombre.");
                    alerta.showAndWait();
                    return;
                }
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        // Una vez que hemos comprobado todo, guardamos el nuevo jugador en el archivo de texto, separando el nombre y la imagen con un punto y coma.
        String linea = nombre + ";file:" + imgpath + System.lineSeparator();
        try (java.io.FileWriter fw = new java.io.FileWriter("jugadores.txt", true)) {
            fw.write(linea);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        //Una vez guardado el jugador, volvemos a la ventana de inicio para poder seleccionar el jugador recién creado y empezar a jugar.
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("inicio.fxml"));
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

    //Este método simplemente cierra la aplicación, no tiene más.
    //A lo mejor tendría que ser un botón de volver atrás como en seleccionar jugador, y sé que es una tontería cambiarlo, pero ya no doy más de mí.
    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }

}
