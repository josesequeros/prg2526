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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PrimaryController implements Initializable{

    
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
    private ListView<Persona> vistaLista;
    @FXML
    private Button botonAdd;
    @FXML
    private Button botonBorrar;
    @FXML
    private Button botonModificar;
    @FXML
    private Button botonCerrar;

    private ObservableList<Persona> datos;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        datos = FXCollections.observableArrayList();
        vistaLista.setItems(datos);
        
        botonBorrar.disableProperty().bind(
            vistaLista.getSelectionModel().selectedItemProperty().isNull()
        );
        
        botonModificar.disableProperty().bind(
            vistaLista.getSelectionModel().selectedItemProperty().isNull()
        );
        
        this.vistaLista.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            nombre.setText(vistaLista.getSelectionModel().getSelectedItem().getNombre());
            apellidos.setText(vistaLista.getSelectionModel().getSelectedItem().getApellidos());
            correo.setText(vistaLista.getSelectionModel().getSelectedItem().getCorreo());
            genero.setText(vistaLista.getSelectionModel().getSelectedItem().getGenero());
            fechaNacimiento.setText(vistaLista.getSelectionModel().getSelectedItem().getNacimiento());
            pais.setText(vistaLista.getSelectionModel().getSelectedItem().getPais());
        });
        
        
       //nombre.setText(vistaLista.getSelectionModel().getSelectedItem().getNombre());
        
        
        
        
        
    }
    @FXML
    private void addAccion(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("secondary.fxml"));
        Parent root = loader.load();
        
        SecondaryController secondaryController = loader.getController();
        
        Scene scene = new Scene(root);
        Stage estageActual = new Stage();
        
        
        estageActual.setScene(scene);
        estageActual.setTitle("Añadir Persona");
        estageActual.initModality(Modality.APPLICATION_MODAL);
        estageActual.showAndWait();
        
        Persona p = secondaryController.getPersona();
        
        if (p != null) {
            datos.add(p);
            vistaLista.refresh();
            
            
        }
    
    }

    @FXML
    private void borrarAccion(ActionEvent event) {
        Persona seleccion = vistaLista.getSelectionModel().getSelectedItem();
        if (seleccion != null) {
            datos.remove(seleccion);
        }
    }

    @FXML
    private void modificarAccion(ActionEvent event) throws IOException {
        Persona seleccion = vistaLista.getSelectionModel().getSelectedItem();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("secondary.fxml"));
        
        Parent root = loader.load();
        
        SecondaryController secondaryController = loader.getController();
        
        secondaryController.setEdicion(true, seleccion);
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Modificar");
        stage.showAndWait();
        
        Persona modificada = secondaryController.getPersona();
        
        if (modificada != null) {
            seleccion.setNombre(modificada.getNombre());
            seleccion.setApellidos(modificada.getApellidos());
            seleccion.setCorreo(modificada.getCorreo());
            seleccion.setGenero(modificada.getGenero());
            seleccion.setNacimiento(modificada.getNacimiento());
            seleccion.setPais(modificada.getPais());
            
            vistaLista.refresh();
        }
    }

    @FXML
    private void cerrarAccion(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void esc_borderPane(KeyEvent event) {
    }
}
