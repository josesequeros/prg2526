/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.ejemplotableviewbd;

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
public class TableViewController implements Initializable {

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
    private TableColumn<Persona, String> imagenColumna;
    @FXML
    private TableColumn<Persona, String> correoColumna;

    private ObservableList<Persona> datos = null; // Colecci�n vinculada a la vista.
    @FXML
    private TableColumn<Persona, String> generoColumna;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Db.crearTablaSiNoExiste();
        ListaPersonas listaPersonas = Db.leerPersonas();

        datos = FXCollections.observableArrayList(listaPersonas.getPersonal());
        vistaTabla.setItems(datos); // vinculación entre la vista y el modelo
        nombreColumna.setCellValueFactory(cellData -> cellData.getValue().NombreProperty());
        apellidosColumna.setCellValueFactory(cellData -> cellData.getValue().ApellidosProperty());
        correoColumna.setCellValueFactory(cellData -> cellData.getValue().EmailProperty());
        generoColumna.setCellValueFactory(cellData -> cellData.getValue().GeneroProperty());
        generoColumna.setCellFactory(columna -> new PersonaImagenCell());
        imagenColumna.setCellValueFactory(cellData -> cellData.getValue().PaisProperty());
        imagenColumna.setCellFactory(columna -> new BanderaImagenCell());

    }

    // Clase local al controlador
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

    // Clase local al controlador
    class BanderaImagenCell extends TableCell<Persona, String> {
        private ImageView view = new ImageView();

        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            if (item == null || empty) {
                setGraphic(null);
            } else {
                // Si está en la carpeta recursos, con el nombre sobra
                System.out.println(item);
                Image image;
                try {
                    image = new Image(item+".png", 46, 46, true, false);
                    view.setImage(image);
                } catch (IllegalArgumentException e) {
                    view.setImage(null);
                }
                setGraphic(view);
            }

        }
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
