/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.joaquinparedesgomez;

import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI
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

    private Persona personaEditando;
    private ObservableList<Persona> lista;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        borderPane.sceneProperty().addListener((obs, oldScene, newScene) -> {
            if (newScene != null) {
                newScene.setOnKeyPressed(e -> {
                    if (e.getCode() == KeyCode.ESCAPE) {
                        Stage stage = (Stage) borderPane.getScene().getWindow();
                        stage.close();
                    }
                });
            }
        });

        pais.textProperty().addListener((obs, oldVal, newVal) -> {
            try {
                InputStream is = getClass().getResourceAsStream("banderas/" + newVal + ".png");
                if (is != null) {
                    imagen.setImage(new Image(is));
                } else {
                    imagen.setImage(null);
                }
            } catch (Exception e) {
                imagen.setImage(null);
            }
        });

    }

    @FXML
    private void salvarPulsado(ActionEvent event) {

        if (nombre.getText().trim().isEmpty()) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("Datos incorrectos");
            alerta.setContentText("El nombre no puede estar vacío.");
            alerta.showAndWait();
            return;
        }

        if (apellidos.getText().trim().isEmpty()) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("Datos incorrectos");
            alerta.setContentText("Los apellidos no pueden estar vacíos.");
            alerta.showAndWait();
            return;
        }

        LocalDate fecha = null;
        try {
            fecha = LocalDate.parse(nacimiento.getText().trim(), Persona.FORMATO_DISPLAY);
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("Error al analizar la fecha");
            alerta.setContentText("Por favor, ingrese una fecha válida en el formato DD/MM/YYYY.");
            alerta.showAndWait();
            return;
        }

        String emailNuevo = correo.getText().trim();
        for (Persona p : lista) {
            if (p != personaEditando && p.getCorreo().equalsIgnoreCase(emailNuevo)) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error");
                alerta.setHeaderText("Correo duplicado");
                alerta.setContentText("Ya existe una persona con ese correo electrónico.");
                alerta.showAndWait();
                return;
            }
        }

        if (personaEditando == null) {

            Persona nueva = new Persona(
                    nombre.getText().trim(),
                    apellidos.getText().trim(),
                    emailNuevo,
                    genero.getText().trim(),
                    fecha,
                    pais.getText().trim()
            );
            lista.add(nueva);
        } else {

            personaEditando.setNombre(nombre.getText().trim());
            personaEditando.setApellidos(apellidos.getText().trim());
            personaEditando.setCorreo(emailNuevo);
            personaEditando.setGenero(genero.getText().trim());
            personaEditando.setFechaNacimiento(fecha);
            personaEditando.setPais(pais.getText().trim());
        }

        VistaListaControlador.grabarPersonas("personal.csv", new ArrayList<>(lista));
        Stage stage = (Stage) botonSalvar.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void cancelarPulsado(ActionEvent event) {
        Stage stage = (Stage) botonCancelar.getScene().getWindow();
        stage.close();
    }

    public void setModo(Persona persona, ObservableList<Persona> lista) {
        this.lista = lista;
        this.personaEditando = persona;

        if (persona == null) {
            encabezado.setText("Añadiendo Persona");
        } else {
            encabezado.setText("Modificando Persona");
            nombre.setText(persona.getNombre());
            apellidos.setText(persona.getApellidos());
            correo.setText(persona.getCorreo());
            genero.setText(persona.getGenero());
            pais.setText(persona.getPais());
            nacimiento.setText(persona.getFechaNacimiento() != null
                    ? persona.getFechaNacimiento().format(Persona.FORMATO_DISPLAY) : "");
        }

    }

}
