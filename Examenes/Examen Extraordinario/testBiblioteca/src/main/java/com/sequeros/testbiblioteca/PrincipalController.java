/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros.testbiblioteca;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

//import com.sequeros.testbiblioteca.PrincipalController.ComicListCell;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
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
    private MenuItem miSalirGrabando;
    @FXML
    private MenuItem miAdd;
    @FXML
    private MenuItem miModificar;
    @FXML
    private MenuItem miBorrar;
    @FXML
    private Button botonAdd;
    @FXML
    private Button botonModificar;
    @FXML
    private Button botonBorrar;
    @FXML
    private Button botonSalirGrabando;
    @FXML
    private ImageView ivPortada;
    @FXML
    private ListView<LibroFiccion> listviewComicteca;
    @FXML
    private ImageView ivContraportada;

    ObservableList<LibroFiccion> datosObservableList;
    ArrayList<LibroFiccion> datosArrayList = new ArrayList<>();

    Biblioteca biblioteca = new Biblioteca();
    @FXML
    private TextField titulo;
    @FXML
    private Button botonFiltrar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        biblioteca.leerBiblioteca("biblioteca.txt");
        //datosArrayList = Auxiliar.leerComics("comicteca.txt");
        datosArrayList = biblioteca.getBiblioteca();
        if (datosArrayList.isEmpty()) {
            System.out.println("vacio");
            datosArrayList.add(new LibroFiccion("Dune", "Frank Herbert", 1965, "123-456", "dune.jpg", "duneC.jpg", "Saga galáctica", "Ciencia ficción"));
            datosArrayList.add(new LibroFiccion("Dune", "Frank Herbert", 1965, "123-457", "dune.jpg", "duneC.jpg", "Saga galáctica", "Ciencia ficción"));
            datosArrayList.add(new LibroFiccion("Dune", "Frank Herbert", 1965, "123-458", "dune.jpg", "duneC.jpg", "Saga galáctica", "Ciencia ficción"));
            datosArrayList.add(new LibroFiccion("Dune", "Frank Herbert", 1965, "123-459", "dune.jpg", "duneC.jpg", "Saga galáctica", "Ciencia ficción"));
            datosArrayList.add(new LibroFiccion("1984", "George Orwell", 1949, "987-654", "1984.jpg", "1984.jpg", "Distopía política", "Distopía"));
        }
        // Declaramos la clase envoltorio
        //ObservableList<ComicAbstracta> datosObservableList;
        datosObservableList = FXCollections.observableList(biblioteca.getBiblioteca());
        // vinculamos la vista
        listviewComicteca.setItems(datosObservableList);
        listviewComicteca.setCellFactory(c -> new LibroListCell());

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
                            ivContraportada.setImage(new Image("" + listviewComicteca.getSelectionModel().getSelectedItem().getContraportada()));
                        } catch (IllegalArgumentException e) {
                            ivContraportada.setImage(new Image("sinimagen.jpg"));
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
        botonFiltrar.setOnAction(eh -> filtrar());
    }

    @FXML
    private void salirPulsado(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "¿Estás seguro de que deseas salir?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.YES) {
                Platform.exit();
            }
        });
    }

    @FXML
    private void salirGrabandoPulsado(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "¿Estás seguro de que deseas salir?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.YES) {
                biblioteca.grabarBiblioteca("biblioteca.txt");
                Platform.exit();
            }
        });
    }

    @FXML
    private void addPulsado(ActionEvent event) throws IOException {
        FXMLLoader miCargador = new FXMLLoader(
                getClass().getClassLoader().getResource("com/sequeros/testbiblioteca/DatosLibroAdd.fxml")
        );
        Parent root = miCargador.load();
        DatosLibroController datosLibroController = miCargador.<DatosLibroController>getController();

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Añadir ==>> Libro");
        stage.initModality(Modality.APPLICATION_MODAL); //la ventana se muestra modal
        stage.showAndWait(); // espera a que se cierre la segunda ventana.

        if (!datosLibroController.getCancelar()) {
            datosObservableList.add(datosLibroController.getLibro());
            listviewComicteca.refresh();
        }
    }

    @FXML
    private void modificarPulsado(ActionEvent event) {
    }

    @FXML
    private void borrarPulsado(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "¿Estás seguro de que deseas borrar el comic?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.YES) {
                datosObservableList.remove(listviewComicteca.getSelectionModel().getSelectedItem());
            }
        });
    }

    @FXML
    private void salvarPulsado(ActionEvent event) {
    }

    private void filtrar() {
        //datosObservableList = biblioteca.buscarComic(titulo.getText()).getBiblioteca();
        if (titulo.getText().length() == 0) {
            biblioteca = new Biblioteca();
            biblioteca.leerBiblioteca("biblioteca.txt");
            //datosObservableList = FXCollections.observableList(biblioteca.getBiblioteca());
            datosObservableList = FXCollections.observableList(biblioteca.getBiblioteca());
        } else {
            datosObservableList = FXCollections.observableList(biblioteca.buscarComic(titulo.getText()).getBiblioteca());
        }
        listviewComicteca.setItems(datosObservableList);
        listviewComicteca.refresh();
        System.out.println("filtrando " + titulo.getText());
    }

    // Clase local al controlador
    class LibroListCell extends ListCell<LibroFiccion> {

        private ImageView view = new ImageView();

        @Override
        protected void updateItem(LibroFiccion item, boolean empty) {
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
