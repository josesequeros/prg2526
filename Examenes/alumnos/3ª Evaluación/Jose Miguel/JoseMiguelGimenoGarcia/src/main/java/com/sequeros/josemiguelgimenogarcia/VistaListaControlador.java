/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros.josemiguelgimenogarcia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.beans.property.StringProperty;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author josgimgar3
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
    
    private ObservableList<Persona> lista;
    
    private Persona autorOriginalBackup;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       File personal  = new File("personal.csv");
        try (BufferedReader br = new BufferedReader(new FileReader(personal))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                // Trim para quitar espacios al inicio/final de la línea antes del split
                String[] datos = linea.trim().split(","); // split por espacios (uno o varios)

                if (datos.length >= 5) {
                    String nom = datos[0].trim();
                    String subn = datos[1].trim();
                    String corr = datos[2].trim();
                    String gene = datos[3].trim();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate naci = LocalDate.parse(datos[4].trim(), formatter);
                    String paisc = datos[5].trim();
                    
                    lista.add(new Persona(nom, paisc, paisc, gene, LocalDate.MIN, paisc));
                 
                }
            }

        } catch (IOException io) {
            System.out.println("No se lee el documento" + io.getMessage());
        }
        // 1. Cargar datos del fichero y meter en la ObservableList
        // EXAMEN: new ArrayList<>(leerAutores()) crea la lista editable inicial
        lista = FXCollections.observableArrayList();

        
        // 2. Enlazar la ObservableList con la TableView
        vistaLista.setItems(lista);
         // 3. Campos en solo lectura por defecto 
        vistaLista.setCellFactory(c -> new PersonaListCell());
        
    }    

    @FXML
    private void addAccion(ActionEvent event) {
        try {
            // EXAMEN: cargar un FXML secundario y obtener su controlador
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DatosPersona.fxml"));
            Parent root = loader.load();

            // Pasar la lista al controlador de la ventana hija
            VistaListaControlador ctrl = loader.getController();
            ctrl.setListaAutores(lista);

            Stage stage = new Stage();
            stage.setTitle("Añadir Autor");
            stage.setScene(new Scene(root, 450, 350));
            // EXAMEN: initModality(APPLICATION_MODAL) bloquea la ventana padre
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();   // espera a que se cierre antes de continuar

        } catch (IOException e) {
            mostrarError("Error", "No se pudo abrir la ventana de añadir", e.getMessage());
        }
    }

    @FXML
    private void borrarAccion(ActionEvent event) {
        Persona seleccionado = vistaLista.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            lista.remove(seleccionado);   // la ObservableList actualiza la tabla sola
        }
    }

    @FXML
    private void modificarAccion(ActionEvent event) {
         Persona seleccionado = vistaLista.getSelectionModel().getSelectedItem();
        if (seleccionado == null) return;

        // Guardar copia por si el usuario pulsa Cancelar
        autorOriginalBackup = new Persona(seleccionado.getNombre(), seleccionado.getApellidos(), seleccionado.getEmail(), seleccionado.getGenero(), seleccionado.getNacimiento(), seleccionado.getPais());
        

        
    }

    @FXML
    private void cerrarAccion(ActionEvent event) {
    }

    public ObservableList<Persona> getLista() {
        return lista;
    }

    public void setLista(ObservableList<Persona> lista) {
        this.lista = lista;
    }

    private void setListaAutores(ObservableList<Persona> lista) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private void mostrarError(String titulo, String header, String contenido) {
        // EXAMEN: Alert.AlertType.ERROR para errores de validación
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
    private class PersonaListCell extends ListCell<Persona> {

        @Override
        protected void updateItem(Persona item, boolean empty) {
            super.updateItem(item, empty); // OBLIGATORIO: siempre llamar al padre primero

            // Si la celda está vacía o el objeto es null, limpiar el texto
            if (item == null || empty) {
                setText(null);
            } else {
                // Mostrar "Apellidos, Nombre" en cada fila de la lista
                setText(item.getApellidos() + ", " + item.getNombre());
            }
        }
    }
}
