/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros.deportistaslistview;

import java.net.URL;
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
 * @author carme
 */
public class deportistasController implements Initializable {

    @FXML
    private Label selectedItem;
    @FXML
    private TextField nombre;
    @FXML
    private TextField edad;
    @FXML
    private TextField deporte;
    @FXML
    private TextField club;
    @FXML
    private ImageView imagen;
    @FXML
    private Label etiqueta;
    @FXML
    private TextField campoSubclase;
    @FXML
    private ListView<DeportistaBaseAbstracta> vistadeListafxID;
    @FXML
    private Button BAddfxID;
    @FXML
    private Button botonBorrar;
    @FXML
    private Button bModificarfxID;
    @FXML
    private Button bCerrar;

    private Club clubJugadores;
    private ArrayList<DeportistaBaseAbstracta> datosArrayList = new ArrayList<>();
    private ObservableList<DeportistaBaseAbstracta> datosObservableList;
    @FXML
    private TextField rutaImagen;
    @FXML
    private Label cabecera;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //System.out.println(clubJugadores.getNombre());
        
        Club club = new Club("Real Madrid", "realmadrid.jpg");
        datosArrayList.add(new JugadorBaloncesto("Ricky", 20, "Baloncesto", clubJugadores, "", 10));
        club.addDeportista(new JugadorFutbol("Pepe", 20, "Futbol", club, "", 5));
        //datosArrayList = leerJugadores();
        //System.out.println(clubJugadores.getDeportistas().size());

        /*
        datosArrayList.add(new LibroNoFiccion("Nombres Fósiles", new Image("hombresFosiles.jpg", 46, 46, true, false)));
        datosArrayList.add(new LibroNoFiccion("Física Existencial", new Image("fisicaExistencial.jpg", 46, 46, true, false)));
        datosArrayList.add(new LibroFiccion("Elantris", new Image("elantris.jpg", 46, 46, true, true)));
         */
        // Declaramos la clase envoltorio
        
        datosObservableList = FXCollections.observableList(datosArrayList);
        // vinculamos la vista
        vistadeListafxID.setItems(datosObservableList);

        botonBorrar.disableProperty().bind(
                Bindings.equal(-1,
                        vistadeListafxID.getSelectionModel().selectedIndexProperty()));
        bModificarfxID.disableProperty().bind(
                Bindings.equal(-1,
                        vistadeListafxID.getSelectionModel().selectedIndexProperty()));
        // El botón Add (Añadir) solo estará habilitado cuando el TextField no esté vacío
        //BAddfxID.disableProperty().bind(valorText.textProperty().isEmpty());

        vistadeListafxID.setCellFactory(c -> new DeportistaListCell());
        vistadeListafxID.getSelectionModel().selectedIndexProperty().addListener(
                (o, oldVal, newVal) -> {
                    if (newVal.intValue() == -1) {
                        //botonBorrar.setDisable(true);
                        //vaciar();
                    } else {
                        //rellenar(vistadeListafxID.getSelectionModel().getSelectedItem());
                        //botonBorrar.setDisable(false);
                    }
                });
    }

    @FXML
    private void addAccion(ActionEvent event) {
    }

    @FXML
    private void borrarAccion(ActionEvent event) {
    }

    @FXML
    private void modificarAccion(ActionEvent event) {
    }

    void initClub(Club club) {
        clubJugadores = club;
        cabecera.setText("Deportistas "+ club.getNombre());
        datosObservableList = FXCollections.observableList(club.getDeportistas());
        // vinculamos la vista
        vistadeListafxID.setItems(datosObservableList);
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

    private ArrayList<DeportistaBaseAbstracta> leerJugadores() {
        return clubJugadores.getDeportistas();
    }

    class DeportistaListCell extends ListCell<DeportistaBaseAbstracta> {

        private ImageView view = new ImageView();

        @Override
        protected void updateItem(DeportistaBaseAbstracta item, boolean empty) {
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
                setText("\t" + item.getNombre() );
            }
        }
    }

    private void rellenar(DeportistaBaseAbstracta deportista) {
        
        if (deportista instanceof JugadorBaloncesto) {
            etiqueta.setText("Triples");
            campoSubclase.setText(((JugadorBaloncesto) deportista).getTriplesAnotados()+"");
        } else {
            etiqueta.setText("Goles");
            campoSubclase.setText(((JugadorFutbol) deportista).getGolesMarcados()+"");
        }
        nombre.setText(deportista.getNombre());
        edad.setText(deportista.getEdad()+"");
        deporte.setText(deportista.getDeporte());

        club.setText(deportista.getClub().getNombre()+ "");
         
        rutaImagen.setText(deportista.getImagen());
        ImageView view = new ImageView();
        try {
            imagen.setImage(new Image("" + deportista.getImagen()));
        } catch (IllegalArgumentException e) {
            imagen.setImage(null);
        }

        //botonModificarAutor.setDisable(false);
    }
}
