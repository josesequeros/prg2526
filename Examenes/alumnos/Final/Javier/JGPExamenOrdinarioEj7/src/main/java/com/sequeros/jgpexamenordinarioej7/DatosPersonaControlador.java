/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros.jgpexamenordinarioej7;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author javgarper6
 */
public class DatosPersonaControlador implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    private Label encabezado;
    @FXML
    private Button botonSalvar;
    @FXML
    private Button botonCancelar;
    @FXML
    private TextField nombre;
    @FXML
    private TextField apellidos;
    @FXML
    private TextField correo;
    @FXML
    private TextField genero;
    @FXML
    private TextField nacimiento;
    @FXML
    private TextField pais;
    @FXML
    private ImageView imagen;

    private ObservableList<Persona> listaObservable;
    private Persona persona;

    public void setListaObservable(ObservableList<Persona> lista) {
        this.listaObservable = lista;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
        if (persona != null) {
            nombre.setText(persona.getNombre());
            apellidos.setText(persona.getApellidos());
            pais.setText(persona.getPais());
            correo.setText(persona.getEmail());
            nacimiento.setText(persona.getNacimientoString());
            genero.setText(persona.getGenero());
            cargarBandera(persona.getPais());
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pais.textProperty().addListener((obs, oldVal, newVal) -> cargarBandera(newVal));
    }

    @FXML
    private void salvarPulsado(ActionEvent event) {
        String newNombre = nombre.getText().trim();
        String newApellidos = apellidos.getText().trim();
        String newPais = pais.getText().trim();
        String newCorreo = correo.getText().trim();
        String newGenero = genero.getText().trim();

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate newNacimiento;
        try {
            newNacimiento = LocalDate.parse(nacimiento.getText().trim(), formato);
        } catch (Exception e) {
            mostrarError("Formato de fecha incorrecto (dd/MM/yyyy)");
            return;
        }

        if (!validarDatos(newNombre, newApellidos, newNacimiento, newCorreo)) {
            return;
        }

        if (persona == null) {
            persona = new Persona(newNombre, newApellidos, newCorreo, newGenero, newNacimiento, newPais);
            listaObservable.add(persona);
        } else {
            persona.setNombre(newNombre);
            persona.setApellidos(newApellidos);
            persona.setNacimiento(newNacimiento);
            persona.setPais(newPais);
            persona.setEmail(newCorreo);
        }

        Stage stage = (Stage) botonSalvar.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void cancelarPulsado(ActionEvent event) {
        Stage stage = (Stage) botonCancelar.getScene().getWindow();
        stage.close();
    }

    private void cargarBandera(String pais) {
        try {
            Image img = new Image(getClass().getResourceAsStream("/" + pais + ".png"));
            imagen.setImage(img);
        } catch (Exception e) {
            imagen.setImage(null);
        }
    }

    private boolean validarDatos(String nombre, String apellidos, LocalDate fechaNacimiento, String email) {
        if (nombre.isEmpty() || apellidos.isEmpty()) {
            mostrarError("El nombre y/o los apellidos no pueden estar vacíos.");
            return false;
        }
        if (fechaNacimiento == null) {
            mostrarError("La fecha de nacimiento no puede estar vacía.");
            return false;
        }
        
        boolean existe = listaObservable.stream()
                .anyMatch(p -> p.getEmail().equals(email)
                && (persona == null || !p.equals(persona)));
        if (existe) {
            mostrarError("Ya existe una persona con ese correo.");
            return false;
        }

        return true;
    }

    private void mostrarError(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Error");
        alerta.setHeaderText("Datos incorrectos");
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

}
