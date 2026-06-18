package com.sequeros.simeonexamen;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class DatosPersonaController {

    @FXML private Label titulo;
    @FXML private TextField txtNombre;
    @FXML private TextField txtApellidos;
    @FXML private TextField txtCorreo;
    @FXML private TextField txtGenero;
    @FXML private TextField txtNacimiento;
    @FXML private TextField txtPais;
    @FXML private ImageView imgBandera;

    private Persona personaCreada = null;
    private Persona personaOriginal = null;
    private List<String> correosExistentes = new ArrayList<>();

    @FXML
    public void initialize() {
        txtPais.textProperty().addListener((obs, viejo, nuevo) -> cargarBandera(nuevo));
    }

    public void setCorreosExistentes(List<String> correos) {
        this.correosExistentes = correos;
    }

    public void setPersona(Persona p) {
        this.personaOriginal = p;
        titulo.setText("Modificando Persona");
        txtNombre.setText(p.getNombre());
        txtApellidos.setText(p.getApellidos());
        txtCorreo.setText(p.getCorreo());
        txtGenero.setText(p.getGenero());
        if (p.getNacimiento() != null) {
            txtNacimiento.setText(p.getNacimiento().format(Utilidades.FORMATO_FECHA));
        }
        txtPais.setText(p.getPais());
    }

    public Persona getPersonaCreada() {
        return personaCreada;
    }

    private void cargarBandera(String pais) {
        try {
            if (pais == null || pais.trim().isEmpty()) {
                imgBandera.setImage(null);
                return;
            }
            File f = new File(pais + ".png");
            if (f.exists()) {
                imgBandera.setImage(new Image(f.toURI().toString(), 70, 50, true, true));
            } else {
                imgBandera.setImage(null);
            }
        } catch (Exception e) {
            imgBandera.setImage(null);
        }
    }

    @FXML
    private void salvar() {
        String nombre = txtNombre.getText().trim();
        String apellidos = txtApellidos.getText().trim();
        String correo = txtCorreo.getText().trim();
        String genero = txtGenero.getText().trim();
        String fechaTexto = txtNacimiento.getText().trim();
        String pais = txtPais.getText().trim();

        if (nombre.isEmpty() || apellidos.isEmpty()) {
            Alert alerta = new Alert(AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("Datos incorrectos");
            alerta.setContentText("El nombre y/o los apellidos no pueden estar vacíos");
            alerta.showAndWait();
            return;
        }

        if (fechaTexto.isEmpty()) {
            Alert alerta = new Alert(AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("Datos incorrectos");
            alerta.setContentText("La fecha no puede estar vacía");
            alerta.showAndWait();
            return;
        }

        LocalDate fecha;
        try {
            fecha = LocalDate.parse(fechaTexto, Utilidades.FORMATO_FECHA);
        } catch (DateTimeParseException e) {
            Alert alerta = new Alert(AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("Error al analizar la fecha");
            alerta.setContentText("Por favor, ingrese una fecha válida en el formato DD/MM/YYYY.");
            alerta.showAndWait();
            return;
        }

        for (String c : correosExistentes) {
            if (c != null && c.equalsIgnoreCase(correo)) {
                Alert alerta = new Alert(AlertType.ERROR);
                alerta.setTitle("Error");
                alerta.setHeaderText("Correo duplicado");
                alerta.setContentText("Ya existe una persona con el correo " + correo);
                alerta.showAndWait();
                return;
            }
        }

        personaCreada = new Persona(nombre, apellidos, correo, genero, fecha, pais);
        Stage v = (Stage) txtNombre.getScene().getWindow();
        v.close();
    }

    @FXML
    private void cancelar() {
        Stage v = (Stage) txtNombre.getScene().getWindow();
        v.close();
    }
}
