/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.personas;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
 * @author jabue
 */
public class DatosPersonaControlador implements Initializable {

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
    private TextField pais;
    @FXML
    private ImageView imagen;
    @FXML
    private TextField nacimiento;

    Persona personaModificada = null;
    @FXML
    private BorderPane borderPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        pais.textProperty().addListener(
                (o, oldVal, newVal) -> {
                    try {
                        imagen.setImage(new Image(newVal + ".png"));
                    } catch (IllegalArgumentException e) {
                        imagen.setImage(null);
                    }
                });


/*
        borderPane.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                Stage stage = (Stage) borderPane.getScene().getWindow();
                stage.close();
            }
        });
*/
    }

    @FXML
    private void salvarPulsado(ActionEvent event) {
        try {
            LocalDate fechaNacimiento = LocalDate.parse(nacimiento.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            if (nombre.getText().isEmpty()
                    || nombre.getText().trim().length() == 0
                    || apellidos.getText().isEmpty()
                    || apellidos.getText().trim().length() == 0) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error");
                alerta.setHeaderText("Datos incorrectos");
                alerta.setContentText("El nombre y/o los apellidos no pueden estar vacíos");
                alerta.showAndWait();
            } else {
                if (personaModificada == null) {
                    personaModificada = new Persona(
                            nombre.getText(),
                            apellidos.getText(),
                            correo.getText(),
                            genero.getText(),
                            fechaNacimiento,
                            pais.getText()
                    );
                } else {
                    personaModificada.setNombre(nombre.getText());
                    personaModificada.setApellidos(apellidos.getText());
                    personaModificada.setEmail(correo.getText());
                    personaModificada.setGenero(genero.getText());
                    personaModificada.setNacimiento(fechaNacimiento);
                    personaModificada.setPais(pais.getText());
                }
                ((Button) event.getSource()).getScene().getWindow().hide();
            }

        } catch (java.time.format.DateTimeParseException e) {
            System.out.println("Formato de fecha erróneo");
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("Formato de fecha erróneo");
            alerta.setContentText("Introduzca la fecha bien");
            alerta.showAndWait();
            nacimiento.requestFocus();
        }

    }

    @FXML
    private void cancelarPulsado(ActionEvent event) {
        ((Button) event.getSource()).getScene().getWindow().hide();
    }

    public void initPersona(Persona p) {
        nombre.setText(p.getNombre());
        apellidos.setText(p.getApellidos());
        correo.setText(p.getEmail());
        genero.setText(p.getGenero());
        DateTimeFormatter formatoFechaNacimiento = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String textoFechaNacimiento = p.getNacimiento().format(formatoFechaNacimiento);
        nacimiento.setText(textoFechaNacimiento);
        pais.setText(p.getPais());

        ImageView view = new ImageView();
        try {
            imagen.setImage(new Image(p.getPais() + ".png"));
        } catch (IllegalArgumentException e) {
            imagen.setImage(null);
        }
        personaModificada = p;
    }

    public Persona getPersona() {
        return personaModificada;
    }
}
