package com.mycompany.personas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

public class SecondaryController implements Initializable{

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
    
    private Persona p;
    private boolean edicion;
    private Persona original;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.nombre.setText("");
        this.apellidos.setText("");
        this.correo.setText("");
        this.genero.setText("");
        this.nacimiento.setText("");
        this.pais.setText("");
        
        borderPane.sceneProperty().addListener((obs, oldScene, newScene) -> {
            if (newScene != null) {
                newScene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
                    esc_borderPane(event);
                });
            }
        });
    }

    @FXML
    private void salvarPulsado(ActionEvent event) {
        p = new Persona(this.nombre.getText(), this.apellidos.getText(), this.correo.getText(), this.genero.getText(), this.nacimiento.getText(), this.pais.getText());
        
        
        Node n = (Node) event.getSource();
        n.getScene().getWindow().hide();
    }

    @FXML
    private void cancelarPulsado(ActionEvent event) {
        Node n = (Node) event.getSource();
        n.getScene().getWindow().hide();
    }
    
    public void setEdicion(boolean edicion, Persona persona){
    this.edicion = edicion;
    this.original = persona;
    
        if (edicion && original != null) {
            this.nombre.setText(persona.getNombre());
            this.apellidos.setText(persona.getApellidos());
            this.correo.setText(persona.getCorreo());
            this.genero.setText(persona.getGenero());
            this.nacimiento.setText(persona.getNacimiento());
            this.pais.setText(persona.getPais());
            
    }

    }
    public Persona getPersona() {
        return p;
    }

    @FXML
    private void esc_borderPane(KeyEvent event) {
        if (event.getCode() == KeyCode.ESCAPE) {
            Node n = (Node) event.getSource();
        n.getScene().getWindow().hide();
        }
    }
}