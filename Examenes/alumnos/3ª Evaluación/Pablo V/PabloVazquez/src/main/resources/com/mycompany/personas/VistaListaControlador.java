/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.personas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author pabvazrui
 */
public class VistaListaControlador implements Initializable {


    @FXML
    private Label selectedItem;
    @FXML
    private TextField nombre;
    @FXML
    private TextField apellidos;
    @FXML
    private TextField correo;
    @FXML
    private TextField genero;
    @FXML
    private ImageView imagen;
    @FXML
    private TextField pais;
    @FXML
    private TextField fechaNacimiento;
    @FXML
    private Label etiqueta;
    @FXML
    private Button botonAdd;
    @FXML
    private Button botonBorrar;
    @FXML
    private Button botonModificar;
    @FXML
    private Button botonCerrar;
    
    @FXML
    private ListView<String> vistaLista;
    private final ObservableList<String> listaPersonas
            = FXCollections.observableArrayList();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vistaLista.setItems(listaPersonas);
    }    
    
    @FXML
    private void addAccion(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mycompany/listviewpersona/DatosPersona.fxml"));
            Parent root = loader.load();
            DatosPersonaControlador controlador = loader.getController();
            Stage stage = new Stage();
            stage.setTitle("Añadir Persona");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
            if (controlador.isGuardar()) {
                String persona = controlador.getNombre() + " "
                        + controlador.getApellido();
                listaPersonas.add(persona);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void borrarAccion(ActionEvent event) {
        int indice = vistaLista.getSelectionModel().getSelectedIndex();
        if (indice >= 0) {
            listaPersonas.remove(indice);
        }
    }

    @FXML
    private void modificarAccion(ActionEvent event) {
        int indice = vistaLista.getSelectionModel().getSelectedIndex();
        if (indice >= 0) {
            try {
                String[] datos = listaPersonas.get(indice).split(" ", 2);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mycompany/listviewpersona/DatosPersona.fxml"));
                Parent root = loader.load();
                DatosPersonaControlador controlador = loader.getController();
                //controlador.setDatos(datos[0], datos.length > 1 ? datos[1]
                       /// : "");
                Stage stage = new Stage();
                stage.setTitle("Modificar Persona");
                stage.setScene(new Scene(root));
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.showAndWait();
                if (controlador.isGuardar()) {
                    String personaModificada = controlador.getNombre() + " "
                            + controlador.getApellido();
                    listaPersonas.set(indice, personaModificada);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void cerrarAccion(ActionEvent event) {
        Stage stage = (Stage) nombre.getScene().getWindow();
        stage.close();
    }

}
