/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros.bibliotecalistview;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author jabue
 */
public class vistaListaLenguajesController implements Initializable {

    @FXML
    private ListView<LibroAbstracta> vistadeListafxID;
    @FXML
    private Button BAddfxID;

    @FXML
    private Label selectedItem;
    private TextField valorText;
    private TextField dni;
    private TextField nombre;
    private TextField nacimiento;
    @FXML
    private ImageView imagen;
    @FXML
    private TextField rutaImagen;
    @FXML
    private Button bModificarfxID;
    @FXML
    private Button bCerrar;
    @FXML
    private TextField titulo;
    @FXML
    private TextField autor;
    @FXML
    private TextField publicacion;
    @FXML
    private TextField isbn;
    @FXML
    private Button botonBorrar;
    @FXML
    private TextField campoSubclase;
    @FXML
    private Label etiqueta;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        deshabilitarTextEdit();
        // Datos para visualizar ArrayList
        ArrayList<LibroAbstracta> datosArrayList = new ArrayList<>();
        datosArrayList.add(new LibroNoFiccion("Nombres Fósiles", "Autor 1", 1980, "isbn001", "hombresFosiles.jpg", "tema 01"));
        datosArrayList.add(new LibroNoFiccion("Física Existencial", "autor 2", 1982, "isbn 02", "fisicaExistencial.jpg", "tema 2"));
        datosArrayList.add(new LibroFiccion("Elantris", "Autor 3", 1983, "isbn 03", "elantris.jpg", "genero 01"));
        /*
        datosArrayList.add(new LibroNoFiccion("Nombres Fósiles", new Image("hombresFosiles.jpg", 46, 46, true, false)));
        datosArrayList.add(new LibroNoFiccion("Física Existencial", new Image("fisicaExistencial.jpg", 46, 46, true, false)));
        datosArrayList.add(new LibroFiccion("Elantris", new Image("elantris.jpg", 46, 46, true, true)));
         */

        // Declaramos la clase envoltorio
        ObservableList<LibroAbstracta> datosObservableList;
        datosObservableList = FXCollections.observableList(datosArrayList);
        // vinculamos la vista
        vistadeListafxID.setItems(datosObservableList);

        // Configuramos listeners al elemento seleccionado del ListBox
        /*        
        // Método 1
        selectedItem.textProperty().bind(vistadeListafxID.getSelectionModel().selectedItemProperty());
        // Método 2
        vistadeListafxID.getSelectionModel().selectedIndexProperty().addListener(
                (o, oldVal, newVal) -> {
                    if (newVal.intValue() == -1) {
                        selectedItem.setText("none");
                    } else {
                        selectedItem.setText(datosObservableList.get(newVal.intValue()));
                    }
                });
        selectedItem.setText("none");
        // Método 3
        selectedItem.textProperty().bind(
                Bindings.when(vistadeListafxID.getSelectionModel().selectedIndexProperty().isEqualTo(-1)).
                        then("none").
                        otherwise(vistadeListafxID.getSelectionModel().selectedItemProperty().asString()
                        )
        );
         */
        // El bóton Borrar solo estará habilitado cuando un item esté seleccionado
        botonBorrar.disableProperty().bind(
                Bindings.equal(-1,
                        vistadeListafxID.getSelectionModel().selectedIndexProperty()));
        // El botón Add (Añadir) solo estará habilitado cuando el TextField no esté vacío
        //BAddfxID.disableProperty().bind(valorText.textProperty().isEmpty());
        bModificarfxID.disableProperty().bind(
                Bindings.equal(-1,
                        vistadeListafxID.getSelectionModel().selectedIndexProperty()));

        vistadeListafxID.setCellFactory(c -> new LibroListCell());
        vistadeListafxID.getSelectionModel().selectedIndexProperty().addListener(
                (o, oldVal, newVal) -> {
                    if (newVal.intValue() == -1) {
                        //botonBorrar.setDisable(true);
                        //vaciar();
                    } else {
                        rellenar(vistadeListafxID.getSelectionModel().getSelectedItem());
                        //botonBorrar.setDisable(false);
                    }
                });

    }

    @FXML
    private void addAccion(ActionEvent event) {
        //vistadeListafxID.getItems().add(valorText.getText());
    }

    @FXML
    private void borrarAccion(ActionEvent event) {
        //vistadeListafxID.getItems().remove(vistadeListafxID.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void modificarAccion(ActionEvent event) {
    }

    private void deshabilitarTextEdit() {
        titulo.setEditable(false);
        autor.setEditable(false);
        isbn.setEditable(false);
        publicacion.setEditable(false);
        titulo.setEditable(false);
        titulo.setEditable(false);
    }

    // Clase local al controlador
    class LibroListCell extends ListCell<LibroAbstracta> {

        private ImageView view = new ImageView();

        @Override
        protected void updateItem(LibroAbstracta item, boolean empty) {
            super.updateItem(item, empty);
            if (item == null || empty) {
                setText(null);
                setGraphic(null);
            } else {
                //view.setImage(new Image("file:./php.png"));
                Image image = new Image(item.getPortada(), 46, 46, true, false);
                view.setImage(image);
                setGraphic(view);
                setText("\t" + item.getTitulo());
            }
        }
    }

    private void rellenar(LibroAbstracta libro) {
        if (libro instanceof LibroFiccion) {
            etiqueta.setText("Género");
            campoSubclase.setText(((LibroFiccion) libro).getGenero());
        } else {
            etiqueta.setText("Tema");
            campoSubclase.setText(((LibroNoFiccion) libro).getTema());
        }
        titulo.setText(libro.getTitulo());
        autor.setText(libro.getAutor());
        isbn.setText(libro.getIsbn());

        publicacion.setText(libro.getFechaPublicacion() + "");
        rutaImagen.setText(libro.getPortada());
        ImageView view = new ImageView();
        try {
            imagen.setImage(new Image("" + libro.getPortada()));
        } catch (IllegalArgumentException e) {
            imagen.setImage(null);
        }
        //botonModificarAutor.setDisable(false);
    }
}
