/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros.danielgimenezruiz;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dangimrui
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
    private ListView<?> vistaLista;
    @FXML
    private Button botonAdd;
    @FXML
    private Button botonBorrar;
    @FXML
    private Button botonModificar;
    @FXML
    private Button botonCerrar;

    private ObservableList<Persona> lista;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lista = FXCollections.observableArrayList(leerPersona(personal.csv));
        botonBorrar.setDisable(true);
        if (botonModificar != null) {
            botonModificar.setDisable(true);
        }
        if (botonAdd != null) {
            botonAdd.setVisible(false);
        }
        if (botonCerrar != null) {
            botonCerrar.setVisible(false);
        }
        if (botonModificar != null) {
            botonModificar.setDisable(true);
        }
        if (botonBorrar != null) {
            botonBorrar.setDisable(true);
        }

        tableGeneral.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        // Hay selección → rellenar formulario y habilitar botones
                        mostrarDatosPersona(newValue);
                        botonBorrar.setDisable(false);
                        if (botonModificar != null) {
                            botonModificar.setDisable(false);
                        };
                    } else {
                        // Sin selección → limpiar y deshabilitar
                        clearFields();
                        botonBorrar.setDisable(true);
                        if (botonModificar != null) {
                            botonModificar.setDisable(true);
                        }
                    }
                });
    }

    @FXML
    private void addAccion(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DatosPersona.fxml"));
            Parent root = loader.load();
            DatosPersonaControlador ctrl = loader.getController();
            ctrl.setListaPersona(lista);

            Stage stage = new Stage();
            stage.setTitle("Añadir persona");
            stage.setScene(new Scene(root, 450, 350));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

        } catch (IOException e) {
            mostrarError("Error", "No se pudo abrir la ventana de añadir", e.getMessage());
        }
    }

    @FXML
    private void borrarAccion(ActionEvent event) {

    }

    @FXML
    private void modificarAccion(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DatosPersona.fxml"));
            Parent root = loader.load();
            DatosPersonaControlador ctrl = loader.getController();
            ctrl.setListaPersona(lista);

            Stage stage = new Stage();
            stage.setTitle("Modificar persona");
            stage.setScene(new Scene(root, 450, 350));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

        } catch (IOException e) {
            mostrarError("Error", "No se pudo abrir la ventana de añadir", e.getMessage());
        }
    }

    @FXML
    private void cerrarAccion(ActionEvent event) {
        cerrarVentana();
    }

    private void cargarImagen(String ruta) {
        if (imagen == null) {
            return;
        }
        if (ruta != null && !ruta.isEmpty()) {
            try {
                File f = new File(ruta);
                // EXAMEN: file.toURI().toString() convierte ruta local a URI válido para Image
                imagen.setImage(f.exists() ? new Image(f.toURI().toString()) : null);
            } catch (Exception e) {
                imagen.setImage(null);
            }
        } else {
            imagen.setImage(null);
        }
    }

    private void cerrarVentana() {
        Stage stage = (Stage) fechaNacimiento.getScene().getWindow();
        stage.close();
    }

    private void clearFields() {
        nombre.clear();
        apellidos.clear();
        fechaNacimiento.clear();
        imagen.imageProperty().toString().isEmpty();
        if (imagen != null) {
            imagen.setImage(null);
        }
    }

    private void mostrarError(String titulo, String header, String contenido) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    private boolean pedirConfirmacionSalir() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText("Vas a salir del programa");
        alert.setContentText("¿Seguro que quieres salir?");
        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == ButtonType.OK;
    }

}
