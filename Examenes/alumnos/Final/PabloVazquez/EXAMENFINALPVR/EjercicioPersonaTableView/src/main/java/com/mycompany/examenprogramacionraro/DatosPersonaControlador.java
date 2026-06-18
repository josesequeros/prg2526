/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.examenprogramacionraro;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author pablo
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

    /**
     * Initializes the controller class.
     */
    
    private Persona persona;
    private VistaListaControlador controladorPrincipal;
    private boolean guardo = false;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     public void setDatos(Persona p, VistaListaControlador controlador) {
        this.persona = p;
        this.controladorPrincipal = controlador;

        if (p != null) {
            encabezado.setText("Modificar Persona");
            nombre.setText(p.getNombre());
            apellidos.setText(p.getApellidos());
            correo.setText(p.getEmail());
            genero.setText(p.getGenero());
            pais.setText(p.getPais());
            nacimiento.setText(p.getNacimiento().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
            
            cargarImagen(p.getGenero());
        } else {
            encabezado.setText("Añadir Persona");
            nombre.clear();
            apellidos.clear();
            correo.clear();
            genero.clear();
            pais.clear();
            nacimiento.clear();
            imagen.setImage(null);
        }
    }
    
    @FXML
    private void salvarPulsado() {
        if (validarCampos()) {
            try {
                LocalDate fecha = LocalDate.parse(nacimiento.getText(), DateTimeFormatter.ofPattern("yyyy/MM/dd"));
                
                if (persona == null) {
                    for (Persona p : controladorPrincipal.listaPersonas) {
                        if (p.getEmail().equalsIgnoreCase(correo.getText())) {
                            mostrarAlerta("Email duplicado", "Ya existe una persona con ese correo.");
                            return;
                        }
                    }
                   
                    persona = new Persona(nombre.getText(), apellidos.getText(), correo.getText(), 
                                          genero.getText(), fecha, pais.getText());
                    controladorPrincipal.listaPersonas.add(persona);
                } else {
                    persona.setNombre(nombre.getText());
                    persona.setApellidos(apellidos.getText());
                    persona.setEmail(correo.getText());
                    persona.setGenero(genero.getText());
                    persona.setNacimiento(fecha);
                    persona.setPais(pais.getText());
                }
                
                mostrarAlerta("Éxito", "Datos guardados correctamente.");
                
                cerrarVentana();
                
            } catch (DateTimeParseException e) {
                mostrarAlerta("Error de fecha", "Formato incorrecto. Usa AAAA/MM/DD (ej: 1990/05/20)");
            } catch (Exception e) {
                e.printStackTrace();
                mostrarAlerta("Error", "Ocurrió un error al guardar: " + e.getMessage());
            }
        }
    }
    
    private boolean validarCampos() {
        if (nombre.getText().trim().isEmpty() || apellidos.getText().trim().isEmpty() || 
            correo.getText().trim().isEmpty() || pais.getText().trim().isEmpty() || nacimiento.getText().trim().isEmpty()) {
            mostrarAlerta("Campos vacíos", "Por favor, rellena todos los campos obligatorios.");
            return false;
        }

        if (!correo.getText().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            mostrarAlerta("Email inválido", "El formato del correo no es correcto.");
            return false;
        }

        try {
            LocalDate.parse(nacimiento.getText(), DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        } catch (Exception e) {
            mostrarAlerta("Fecha inválida", "Usa el formato AAAA/MM/DD (ej: 1990/05/20)");
            return false;
        }

        if (persona == null) {
            for (Persona p : controladorPrincipal.listaPersonas) {
                if (p.getEmail().equalsIgnoreCase(correo.getText())) {
                    mostrarAlerta("Duplicado", "Ya existe una persona con ese email.");
                    return false;
                }
            }
        }

        return true;
    }
    
    @FXML
    private void cancelarPulsado(ActionEvent event) {
        guardo = false;
        cerrarVentana();
    }
    
    private void cerrarVentana() {
        Stage stage = (Stage) botonSalvar.getScene().getWindow();
        stage.close();
    }
    
    private void cargarImagen(String genero) {
        String ruta = "/com/mycompany/examenprogramacionraro/usuarios/";
        if ("Female".equalsIgnoreCase(genero)) {
            ruta += "woman.png";
        } else {
            ruta += "man.png";
        }
        Image img = new Image(getClass().getResourceAsStream(ruta));
        if (!img.isError()) {
            imagen.setImage(img);
        }
    }
    
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    
    public boolean seGuardo() {
        return guardo;
    }
}
