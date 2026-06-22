/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.clubs;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
 * @author ja.buenoseva
 */
public class clubController implements Initializable {

    @FXML
    private ImageView imagen;
    @FXML
    private TextField rutaImagen;
    @FXML
    private TextField totalJugadores;
    @FXML
    private TextField totalNomina;
    @FXML
    private Button bJugadores;
    @FXML
    private Button bCerrar;
    @FXML
    private Button botonAdd;
    @FXML
    private Button botonBorrar;
    @FXML
    private Button botonModificar;
    @FXML
    private ListView<Club> vistaListaClub;
    
    ObservableList<Club> datosObservableList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //deshabilitarTextEdit();
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
        
        datosObservableList = FXCollections.observableList(datosArrayList);
        // vinculamos la vista
        vistaListaClub.setItems(datosObservableList);
        vistaListaClub.setCellFactory(c -> new ClubListCell());
        vistaListaClub.getSelectionModel().selectedIndexProperty().addListener(
                (o, oldVal, newVal) -> {
                    if (newVal.intValue() == -1) {
                        //botonBorrar.setDisable(true);
                        //vaciar();
                    } else {
                        rellenar(vistaListaClub.getSelectionModel().getSelectedItem());
                        //botonBorrar.setDisable(false);
                    }
                });
    }

    @FXML
    private void jugadoresAccion(ActionEvent event) throws IOException {

        FXMLLoader miCargador = new FXMLLoader(getClass().getResource("deportistas.fxml"));
        Parent root = miCargador.load();
        deportistasController controlador
                = miCargador.<deportistasController>getController();
        // persona seleccionada en la tabla
        Club club = vistaListaClub.getSelectionModel().getSelectedItem();
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

    @FXML
    private void addAccion(ActionEvent event) throws IOException {
        System.out.println("añadir");
        FXMLLoader miCargador = new FXMLLoader(
                getClass().getClassLoader().getResource(
                        "com/mycompany/clubs/DatosClub.fxml"
                )
        );
        //FXMLLoader miCargador = new FXMLLoader(getClass().getResource("DatosClub.fxml"));
        Parent root = miCargador.load();
        DatosClubControlador controladorDatosClub
                = miCargador.<DatosClubControlador>getController();

        Scene scene = new Scene(root, 600, 400);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Añadir Club");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        if (controladorDatosClub.getClub() != null) {
            Club personaM = controladorDatosClub.getClub();
            System.out.println(personaM.getImagen());
            datosObservableList.add(personaM);

            int ultimo = vistaListaClub.getItems().size() - 1;
            vistaListaClub.getSelectionModel().select(ultimo);
            vistaListaClub.scrollTo(ultimo);

            //vistaLista.refresh();
            //rellenar(personaM);
        }
    }

    @FXML
    private void borrarAccion(ActionEvent event) {
        vistaListaClub.getItems().remove(vistaListaClub.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void modificarAccion(ActionEvent event) {
    }

    private void deshabilitarTextEdit() {
        rutaImagen.setEditable(false);
        totalJugadores.setEditable(false);
        totalNomina.setEditable(false);
    }

    private void rellenar(Club club) {
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
                Image image = null;
                try {
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
}
