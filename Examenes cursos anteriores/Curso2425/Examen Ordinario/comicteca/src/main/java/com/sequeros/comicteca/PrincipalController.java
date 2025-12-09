/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros.comicteca;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jabue
 */
public class PrincipalController implements Initializable {

    @FXML
    private MenuItem miSalir;
    @FXML
    private MenuItem miAdd;
    @FXML
    private MenuItem miModificar;
    @FXML
    private MenuItem miBorrar;
    @FXML
    private Button botonAdd;
    @FXML
    private Button botonBorrar;
    @FXML
    private Button botonSalirGrabando;
    @FXML
    private ImageView ivPortada;
    @FXML
    private ImageView ivPortadaAlternativa;
    @FXML
    private ListView<ComicAbstracta> listviewComicteca;
    @FXML
    private MenuItem miSalirGrabando;
    @FXML
    private Button botonModificar;

    ObservableList<ComicAbstracta> datosObservableList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList<ComicAbstracta> datosArrayList = new ArrayList<>();
        Comicteca comicteca = new Comicteca();
        comicteca.leerComics("comicteca.txt");
        //datosArrayList = Auxiliar.leerComics("comicteca.txt");
        datosArrayList = comicteca.getComics();
        if (datosArrayList.isEmpty()) {
            datosArrayList.add(new ComicSuperheroes("Los Vengadores 16", "MacKay", 1980, "isbn001", "Los Vengadores 16.png", "Los Vengadores alternativa 1.jpg", "Marvel"));
            datosArrayList.add(new ComicSuperheroes("Iron Man 1", "MacKay", 1980, "isbn001", "Iron Man 1.png", "Iron Man 1 alternativa.jpg", "Marvel"));
            datosArrayList.add(new ComicSuperheroes("Los Vengadores 17", "MacKay", 1980, "isbn001", "Los Vengadores 17.png", "Los Vengadores alternativa 2.jpg", "Marvel"));
            datosArrayList.add(new ComicEuropeo("Navis Integral", "Morvan - Buchet - Munuera - Lerolle", 2024, "isbn2024", "navis.jpg", "navis alternativa 1.jpg", "Delcourt"));
            datosArrayList.add(new ComicEuropeo("Mortadelo 1", "Morvan - Buchet - Munuera - Lerolle", 2000, "isbn2024", "mortadelo 1.jpg", "mortadelo alternativa 1.jpg", "Bruguera"));
        }
        // Declaramos la clase envoltorio
        //ObservableList<ComicAbstracta> datosObservableList;
        datosObservableList = FXCollections.observableList(comicteca.getComics());
        // vinculamos la vista
        listviewComicteca.setItems(datosObservableList);
        listviewComicteca.setCellFactory(c -> new ComicListCell());

        listviewComicteca.getSelectionModel().selectedIndexProperty().addListener(
                (o, oldVal, newVal) -> {
                    if (newVal.intValue() == -1) {
                        //botonBorrar.setDisable(true);
                        //vaciar();
                    } else {
                        try {
                            ivPortada.setImage(new Image("" + listviewComicteca.getSelectionModel().getSelectedItem().getPortada()));
                        } catch (IllegalArgumentException e) {
                            ivPortada.setImage(new Image("sinimagen.jpg"));
                        }
                        try {
                            ivPortadaAlternativa.setImage(new Image("" + listviewComicteca.getSelectionModel().getSelectedItem().getPortadaAlternativa()));
                        } catch (IllegalArgumentException e) {
                            ivPortadaAlternativa.setImage(new Image("sinimagen.jpg"));
                        }
                        //botonBorrar.setDisable(false);
                    }
                });
        // El bóton Borrar solo estará habilitado cuando un item esté seleccionado
        botonBorrar.disableProperty().bind(
                Bindings.equal(-1,
                        listviewComicteca.getSelectionModel().selectedIndexProperty()));
        botonModificar.disableProperty().bind(
                Bindings.equal(-1,
                        listviewComicteca.getSelectionModel().selectedIndexProperty()));
    }

    @FXML
    private void salirPulsado(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION, "¿Estás seguro de que deseas salir?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.YES) {
                Platform.exit();
            }
        });
    }

    @FXML
    private void salirGrabandoPulsado(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION, "¿Estás seguro de que deseas salir?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.YES) {
                Auxiliar.grabarComics("comicteca.txt", new ArrayList(datosObservableList));
                Platform.exit();
            }
        });
    }

    @FXML
    private void addPulsado(ActionEvent event) throws IOException {
        FXMLLoader miCargador = new FXMLLoader(
                getClass().getClassLoader().getResource("com/sequeros/comicteca/DatosComicAdd.fxml")
        );
        Parent root = miCargador.load();
        DatosComicController datosComicController = miCargador.<DatosComicController>getController();

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Añadir ==>> Comic");
        stage.initModality(Modality.APPLICATION_MODAL); //la ventana se muestra modal
        stage.showAndWait(); // espera a que se cierre la segunda ventana.

        if (!datosComicController.getCancelar()) {
            datosObservableList.add(datosComicController.getComic());
            listviewComicteca.refresh();
        }
    }

    @FXML
    private void modificarPulsado(ActionEvent event) {
    }

    @FXML
    private void borrarPulsado(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION, "¿Estás seguro de que deseas borrar el comic?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.YES) {
                datosObservableList.remove(listviewComicteca.getSelectionModel().getSelectedItem());
            }
        });
    }

    // Clase local al controlador
    class ComicListCell extends ListCell<ComicAbstracta> {

        private ImageView view = new ImageView();

        @Override
        protected void updateItem(ComicAbstracta item, boolean empty) {
            super.updateItem(item, empty);
            if (item == null || empty) {
                setText(null);
                setGraphic(null);
            } else {
                //view.setImage(new Image("file:./php.png"));
                try {
                    Image image = new Image(item.getPortada(), 46, 46, true, false);
                    view.setImage(image);
                    setGraphic(view);
                } catch (IllegalArgumentException e) {
                    view.setImage(new Image("none.png", 46, 46, true, false));
                    setGraphic(view);
                }
                setText("\t" + item.getTitulo());
            }
        }
    }
}
