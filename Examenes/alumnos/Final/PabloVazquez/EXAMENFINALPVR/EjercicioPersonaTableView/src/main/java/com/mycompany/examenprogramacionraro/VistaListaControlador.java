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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.beans.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author pablo
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
    private ListView<Persona> vistaLista;
    @FXML
    private Button botonAdd;
    @FXML
    private Button botonBorrar;
    @FXML
    private Button botonModificar;
    @FXML
    private Button botonCerrar;
    /**
     * Initializes the controller class.
     */

    public ObservableList<Persona> listaPersonas = FXCollections.observableArrayList();
    private Persona personaSeleccionada;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cargarPersonasDesdeCSV(); 
        configurarListView();  
        configurarSelector();  
    }
    
    private void cargarPersonasDesdeCSV() {

        LocalDate hoy = LocalDate.now();
        
        listaPersonas.add(new Persona("Phythian", "Durant", "dphythian@nasa.gov", "Male", LocalDate.of(1998, 1, 15), "Ukraine"));
        listaPersonas.add(new Persona("Celestina", "Peidro", "cpeidro@java.com", "Female", LocalDate.of(2009, 1, 1), "Spain"));
        listaPersonas.add(new Persona("Clementine", "Fulun", "cfulun2@edublogs.org", "Female", LocalDate.of(1999, 11, 28), "China"));
        listaPersonas.add(new Persona("Ethan", "McAllister", "emcallister1@example.gov", "Male", LocalDate.of(1998, 4, 17), "Canada"));
        listaPersonas.add(new Persona("Omar", "Khalidi", "okhalidi2@example.com", "Female", LocalDate.of(2009, 1, 1), "Palestinian Territory"));
        listaPersonas.add(new Persona("Lukas", "Meier", "lmeier4@example.org", "Female", LocalDate.of(1999, 11, 28), "Switzerland"));
        
        System.out.println("Cargadas " + listaPersonas.size() + " personas de prueba.");
    }

    private void configurarListView() {
        vistaLista.setItems(listaPersonas);
        vistaLista.setCellFactory(param -> new ListCell<Persona>() {
            private final ImageView imageView = new ImageView();

            {
                imageView.setFitWidth(40);
                imageView.setFitHeight(40);
                imageView.setPreserveRatio(true);
            }

            @Override
            protected void updateItem(Persona persona, boolean empty) {
                super.updateItem(persona, empty);
                if (empty || persona == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    String rutaImagen = "/com/mycompany/examenprogramacionraro/usuarios/";
                    if ("Female".equalsIgnoreCase(persona.getGenero())) {
                        rutaImagen += "woman.png";
                    } else {
                        rutaImagen += "man.png";
                    }

                    Image img = new Image(getClass().getResourceAsStream(rutaImagen));
                    imageView.setImage(img);

                    setText(persona.getNombre() + ", " + persona.getApellidos() + " - " + persona.getPais());
                    setGraphic(imageView);
                }
            }
        });
    }

    private void configurarSelector() {
        vistaLista.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                personaSeleccionada = (Persona) newVal; 
                mostrarDetalles(personaSeleccionada);
            }
        });
    }

    private void mostrarDetalles(Persona p) {
        nombre.setText(p.getNombre());
        apellidos.setText(p.getApellidos());
        correo.setText(p.getEmail());
        genero.setText(p.getGenero());
        pais.setText(p.getPais());
        fechaNacimiento.setText(p.getNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        selectedItem.setText("Seleccionado: " + p.getNombre());

        // Cargar bandera
        String nombreArchivo = p.getPais().replace(" ", "");
        
        nombreArchivo = p.getPais(); 

        String rutaBandera = "/com/mycompany/examenprogramacionraro/banderas/" + nombreArchivo + ".png";

        try {
            Image bandera = new Image(getClass().getResourceAsStream(rutaBandera));
            if (bandera.isError()) {
                System.out.println("No se encontró la bandera: " + rutaBandera);
                imagen.setImage(null);
            } else {
                imagen.setImage(bandera);
            }
        } catch (Exception e) {
            System.err.println("Error cargando bandera: " + rutaBandera);
            imagen.setImage(null);
        }
    }

    @FXML
    private void addAccion(ActionEvent event) {
        abrirVentanaModal(null); 
    }

    @FXML
    private void borrarAccion(ActionEvent event) {
        if (personaSeleccionada != null) {
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
            confirm.setTitle("Confirmar borrado");
            confirm.setHeaderText("¿Estás seguro de borrar a " + personaSeleccionada.getNombre() + "?");
            if (confirm.showAndWait().get() == javafx.scene.control.ButtonType.OK) {
                listaPersonas.remove(personaSeleccionada);
                limpiarCampos();
                personaSeleccionada = null;
            }
        } else {
            mostrarAlerta("Advertencia", "Selecciona una persona para borrar");
        }
    }

    @FXML
    private void modificarAccion(ActionEvent event) {
        if (personaSeleccionada != null) {
            abrirVentanaModal(personaSeleccionada); 
        } else {
            mostrarAlerta("Advertencia", "Selecciona una persona para modificar");
        }
    }

    @FXML
    private void cerrarAccion(ActionEvent event) {
        Stage stage = (Stage) nombre.getScene().getWindow();
        stage.close();
    }

    private void abrirVentanaModal(Persona persona) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mycompany/examenprogramacionraro/DatosPersona.fxml"));
            BorderPane root = loader.load();
            
            DatosPersonaControlador controlador = loader.getController();
            
            controlador.setDatos(persona, this);

            Stage stage = new Stage();
            stage.setTitle(persona == null ? "Añadir Persona" : "Modificar Persona");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new javafx.scene.Scene(root));
            

            stage.showAndWait();

            vistaLista.refresh();

        } catch (IOException e) {
            e.printStackTrace();
            mostrarAlerta("Error", "No se pudo abrir la ventana de datos: " + e.getMessage());
        }
    }


    private void limpiarCampos() {
        nombre.clear();
        apellidos.clear();
        correo.clear();
        genero.clear();
        pais.clear();
        fechaNacimiento.clear();
        imagen.setImage(null);
        selectedItem.setText("");
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
