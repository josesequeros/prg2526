/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros.deportistaslistview;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
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
public class clubController implements Initializable {

    @FXML
    private ListView<Club> vistadeListafxID;

    private TextField valorText;
    private TextField dni;
    private TextField nombre;
    private TextField nacimiento;
    @FXML
    private ImageView imagen;
    @FXML
    private TextField rutaImagen;
    private Button bModificarfxID;
    @FXML
    private Button bCerrar;
    private TextField titulo;
    private TextField autor;
    private TextField publicacion;
    private TextField isbn;
    private Button botonBorrar;
    @FXML
    private Button bJugadores;
    @FXML
    private TextField totalJugadores;
    @FXML
    private TextField totalNomina;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        deshabilitarTextEdit();
        // Datos para visualizar ArrayList
        ArrayList<Club> datosArrayList = new ArrayList<>();
        Club club = new Club("Real Madrid", "realmadrid.jpg");
        datosArrayList.add(club);
        club.addDeportista(new JugadorBaloncesto("Rudy", 39, "Baloncesto", club, "rudy.jpg", 10));
        club.addDeportista(new JugadorFutbol("Dani Carvajal", 32, "Futbol", club, "carvajal.jpg", 5));
        club.addDeportista(new JugadorFutbol("Luka Modric", 38, "Futbol", club, "modric.jpg", 15));

        club = new Club("FC Barcelona", "barcelona.jpg");
        datosArrayList.add(club);
        club.addDeportista(new JugadorBaloncesto("Ricky Rubio", 34, "Baloncesto", club, "ricky.jpg", 20));
        club.addDeportista(new JugadorFutbol("Gavi", 19, "Futbol", club, "gavi.jpg", 5));

        datosArrayList.add(new Club("Athletic Bilbao", "bilbao.jpg"));
        /*
        datosArrayList.add(new LibroNoFiccion("Nombres Fósiles", new Image("hombresFosiles.jpg", 46, 46, true, false)));
        datosArrayList.add(new LibroNoFiccion("Física Existencial", new Image("fisicaExistencial.jpg", 46, 46, true, false)));
        datosArrayList.add(new LibroFiccion("Elantris", new Image("elantris.jpg", 46, 46, true, true)));
         */

        // Declaramos la clase envoltorio
        ObservableList<Club> datosObservableList;
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
        bJugadores.disableProperty().bind(
                Bindings.equal(-1,
                        vistadeListafxID.getSelectionModel().selectedIndexProperty()));
        // El botón Add (Añadir) solo estará habilitado cuando el TextField no esté vacío
        //BAddfxID.disableProperty().bind(valorText.textProperty().isEmpty());

        vistadeListafxID.setCellFactory(c -> new ClubListCell());
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

    private void deshabilitarTextEdit() {
        rutaImagen.setEditable(false);
        totalJugadores.setEditable(false);
        totalNomina.setEditable(false);
    }

    @FXML
    private void jugadoresAccion(ActionEvent event) throws IOException {
        FXMLLoader miCargador = new FXMLLoader(
                getClass().getClassLoader().getResource(
                        "com/sequeros/deportistaslistview/deportistas.fxml"));
        Parent root = miCargador.load();
        deportistasController controlador
                = miCargador.<deportistasController>getController();
        // persona seleccionada en la tabla
        Club club = vistadeListafxID.getSelectionModel().getSelectedItem();
        if (club == null) {
            return;
        }
        controlador.initClub(club);
        Scene scene = new Scene(root);
        //Scene scene = new Scene(FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml")));
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Ver Jugadores");
        // stage.show();
        stage.initModality(Modality.APPLICATION_MODAL); //la ventana se muestra modal
        stage.showAndWait(); // espera a que se cierre la segunda ventana.
    }

    @FXML
    private void cerrarAccion(ActionEvent event) {
    }

    // Clase local al controlador
    class ClubListCell extends ListCell<Club> {

        private ImageView view = new ImageView();

        @Override
        protected void updateItem(Club item, boolean empty) {
            super.updateItem(item, empty);
            if (item == null || empty) {
                setText(null);
                setGraphic(null);
            } else {
                //view.setImage(new Image("file:./php.png"));
                Image image = null;
                try {
                    //imagen.setImage(new Image("" + libro.getPortada()));
                    image = new Image(item.getImagen(), 46, 46, true, false);
                    view.setImage(image);
                } catch (IllegalArgumentException e) {
                    view.setImage(null);
                }
                setGraphic(view);
                setText("\t" + item.getNombre());
            }
        }
    }

    private void rellenar(Club club) {
        /*
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
         */
        rutaImagen.setText(club.getImagen());
        int importeNomina = club.calcularNomina();
        totalNomina.setText(importeNomina + "");
        totalJugadores.setText(club.getDeportistas().size() + "");
        ImageView view = new ImageView();
        try {
            imagen.setImage(new Image("" + club.getImagen()));
        } catch (IllegalArgumentException e) {
            imagen.setImage(null);
        }

        //botonModificarAutor.setDisable(false);
    }
}
