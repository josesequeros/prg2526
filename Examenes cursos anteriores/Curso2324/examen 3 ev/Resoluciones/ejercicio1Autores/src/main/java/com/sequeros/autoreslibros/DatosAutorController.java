/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros.autoreslibros;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author IEUser
 */
public class DatosAutorController implements Initializable {

    private boolean pulsadoCancelar = true;
    private Autor autorModificada;

    @FXML
    private TextField dni;
    @FXML
    private TextField nombre;
    @FXML
    private TextField apellidos;
    @FXML
    private TextField nacimiento;
    @FXML
    private ImageView imagen;
    @FXML
    private TextField rutaImagen;
    @FXML
    private Button botonSalvar;
    @FXML
    private Button botonCancelar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void salvarPulsado(ActionEvent event) {
        pulsadoCancelar = false;
        try {
            if (!Auxiliar.validarNif(dni.getText())) {
                throw new NumberFormatException();
            }
            if (nombre.getText().isEmpty()
                    || nombre.getText().trim().length() == 0
                    || apellidos.getText().isEmpty()
                    || apellidos.getText().trim().length() == 0) {
                throw new Exception("No pueden ser vacíos")  ;
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(nacimiento.getText(), formatter);
            autorModificada = new Autor(
                    dni.getText(),
                    nombre.getText(),
                    apellidos.getText(),
                    date,
                    rutaImagen.getText());
            ((Button) event.getSource()).getScene().getWindow().hide();
        } catch (DateTimeParseException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error al analizar la fecha");
            alert.setContentText("Por favor, ingrese una fecha válida en el formato DD/MM/YYYY.");
            Optional<ButtonType> result = alert.showAndWait();
            pulsadoCancelar = true;
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error en el DNI");
            alert.setContentText("Por favor, ingrese un DNI válido");
            Optional<ButtonType> result = alert.showAndWait();
            pulsadoCancelar = true;
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error en los datos");
            alert.setContentText("Nombre y Apellidos no pueden estar en blanco");
            Optional<ButtonType> result = alert.showAndWait();
            pulsadoCancelar = true;
        }
    }

    @FXML
    private void cancelarPulsado(ActionEvent event) {
        pulsadoCancelar = true;
        ((Button) event.getSource()).getScene().getWindow().hide();
    }

    public boolean getCancelar() {
        return pulsadoCancelar;
    }

    public Autor getAutor() {
        return autorModificada;
    }

    public void initAutor(Autor autor) {
        dni.setText(autor.getDni());
        nombre.setText(autor.getNombre());
        apellidos.setText(autor.getApellidos());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        nacimiento.setText(autor.getNacimiento().get().format(formatter));
        rutaImagen.setText(autor.getPathImagen());
    }
}
