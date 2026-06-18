/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.ejemplotableviewimagenes;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author ja.buenoseva
 */
public class TableViewControlador implements Initializable {

    @FXML
    private Button botonVer;
    @FXML
    private Button botonAdd;
    @FXML
    private Button botonModificar;
    @FXML
    private Button botonBorrar;

    @FXML
    private TableView<Persona> vistaTabla;
    @FXML
    private TableColumn<Persona, String> nombreColumna;
    @FXML
    private TableColumn<Persona, String> apellidosColumna;
    @FXML
    private TableColumn<Persona, Residencia> residenciaColumna;
    @FXML
    private TableColumn<Persona, String> imagenColumna;

    private ObservableList<Persona> datos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        datos = FXCollections.observableArrayList();
        vistaTabla.setItems(datos);

        datos.add(new Persona("Pepe", "Gotera", new Residencia("Almoradi", "Alicante"),
                "./src/main/resources/Sonriente.png"));
        datos.add(new Persona("Pepe", "García", new Residencia("Sagunto", "Castellón"),
                "./src/main/resources/Pregunta.png"));
        datos.add(new Persona("María", "Pérez", new Residencia("Lliria", "Valencia"),
                "./src/main/resources/LLoroso.png"));
        datos.add(new Persona("Carpanta", "Imagenes", new Residencia("Lliria", "Valencia"),
                "./src/main/resources/python.png"));

        nombreColumna.setCellValueFactory(cellData -> cellData.getValue().NombreProperty());
        apellidosColumna.setCellValueFactory(cellData -> cellData.getValue().ApellidosProperty());
        // Definimos que queremos ver
        residenciaColumna.setCellValueFactory(cellData -> cellData.getValue().residenciaProperty());
        // Definimos como queremos verlo
        residenciaColumna.setCellFactory(v -> {
            return new TableCell<Persona, Residencia>() {
                @Override
                protected void updateItem(Residencia item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                    } else {
                        setText(item.getCiudad() + " --> " + item.getProvincia());
                    }
                }
            };
        });
        imagenColumna.setCellValueFactory(cellData -> cellData.getValue().pathImagenProperty());
        imagenColumna.setCellFactory(columna -> {
            return new TableCell<Persona, String>() {
                private ImageView view = new ImageView();

                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setGraphic(null);
                    } else {
                        //System.out.println(item + " " + item.getClass());
                        //Image image = new Image(TableViewController.class.getResourceAsStream(item),
                        //        40, 40, true, true);

                        File imageFile = new File(item);     // item path y nombre del archivo
                        String fileLocation = imageFile.toURI().toString();
                        Image image = new Image(fileLocation, 40, 40, true, true);
                        //Image image = new Image("./src/main/resources/com/sequeros/tableviewimagen/recursos/Sonriente.png", 46, 46, true, false);
                        //Image image = new Image(item, 46, 46, true, false);

                        view.setImage(image);
                        setGraphic(view);
                    }
                }
            };
        });
    }

    @FXML
    private void verAccion(ActionEvent event) {
    }

    @FXML
    private void addAccion(ActionEvent event) {
    }

    @FXML
    private void modificarAccion(ActionEvent event) {
    }

    @FXML
    private void borrarAccion(ActionEvent event) {
    }

}
