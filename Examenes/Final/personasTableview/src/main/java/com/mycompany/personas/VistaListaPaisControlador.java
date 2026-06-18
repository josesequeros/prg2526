/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.personas;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author jabue
 */
public class VistaListaPaisControlador implements Initializable {

    @FXML
    private Label selectedItem;
    @FXML
    private ImageView imagen;
    @FXML
    private TableView<Persona> vistaTabla;
    @FXML
    private TableColumn<Persona, String> generoColumna;
    @FXML
    private TableColumn<Persona, String> nombreColumna;
    @FXML
    private TableColumn<Persona, String> apellidosColumna;
    @FXML
    private TableColumn<Persona, String> correoColumna;
    @FXML
    private TableColumn<Persona, LocalDate> nacimientoColumna;

    private ObservableList<Persona> datos = null; // Colecci�n vinculada a la vista.

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println("initialize");
        //datos = FXCollections.observableArrayList();
        vistaTabla.setItems(datos); // vinculación entre la vista y el modelo
        nombreColumna.setCellValueFactory(cellData -> cellData.getValue().NombreProperty());
        apellidosColumna.setCellValueFactory(cellData -> cellData.getValue().ApellidosProperty());
        correoColumna.setCellValueFactory(cellData -> cellData.getValue().EmailProperty());
        generoColumna.setCellValueFactory(cellData -> cellData.getValue().GeneroProperty());
        generoColumna.setCellFactory(columna -> new PersonaImagenCell());
        nacimientoColumna.setCellValueFactory(cellData -> cellData.getValue().nacimientoProperty());
        nacimientoColumna.setCellFactory(columna -> new NacimientoCell());
    }

    public void cargarPais(ObservableList<Persona> datosPais) {
        System.out.println("Cargar Pais");
        datos = datosPais;
        vistaTabla.setItems(datos); // vinculación entre la vista y el modelo
        ImageView view = new ImageView();
        try {
            imagen.setImage(new Image(datosPais.get(0).getPais() + ".png"));
        } catch (IllegalArgumentException e) {
            imagen.setImage(null);
            System.out.println(e);
            System.out.println(datosPais.get(0).getPais() + ".png");
        }
    }

    class PersonaImagenCell extends TableCell<Persona, String> {

        private ImageView view = new ImageView();

        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            if (item == null || empty) {
                setGraphic(null);
            } else {
                Persona persona = getTableRow().getItem();

                if (persona == null) {
                    setGraphic(null);
                    return;
                }
                String imagenGenero = "";
                if ("Female".equals(item)) {
                    imagenGenero = "woman.png";
                } else {
                    imagenGenero = "man.png";
                }

                // Si está en la carpeta recursos, con el nombre sobra
                Image image;
                try {
                    image = new Image(imagenGenero, 46, 46, true, false);
                    view.setImage(image);
                } catch (IllegalArgumentException e) {
                    view.setImage(null);
                }
                setGraphic(view);
            }

        }
    }

    class NacimientoCell extends TableCell<Persona, LocalDate> {

        //private ImageView view = new ImageView();
        @Override
        protected void updateItem(LocalDate item, boolean empty) {
            super.updateItem(item, empty);

            if (item == null || empty) {
                setGraphic(null);
                setText(null);
            } else {
                try {

                    setText(item.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                } catch (IllegalArgumentException e) {

                }

            }

        }
    }


}
