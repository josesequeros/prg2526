/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.personas;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
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

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jabue
 */
public class VistaTablaControlador implements Initializable {

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
    private Button botonAdd;
    @FXML
    private Button botonBorrar;
    @FXML
    private Button botonModificar;
    @FXML
    private Button botonCerrar;
    @FXML
    private Button botonPais;
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
    private TableColumn<Persona, String> imagenColumna;

    private ObservableList<Persona> datos = null; // Colecci�n vinculada a la vista.

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ListaPersonas listaPersonas = Auxiliar.leerPersonas("personal.csv");
        datos = FXCollections.observableArrayList(listaPersonas.getPersonal());
        vistaTabla.setItems(datos); // vinculación entre la vista y el modelo
        nombreColumna.setCellValueFactory(cellData -> cellData.getValue().NombreProperty());
        apellidosColumna.setCellValueFactory(cellData -> cellData.getValue().ApellidosProperty());
        correoColumna.setCellValueFactory(cellData -> cellData.getValue().EmailProperty());
        generoColumna.setCellValueFactory(cellData -> cellData.getValue().GeneroProperty());
        generoColumna.setCellFactory(columna -> new PersonaImagenCell());
        imagenColumna.setCellValueFactory(cellData -> cellData.getValue().PaisProperty());
        imagenColumna.setCellFactory(columna -> new BanderaImagenCell());

        vistaTabla.getSelectionModel().selectedIndexProperty().addListener(
                (o, oldVal, newVal) -> {
                    if (newVal.intValue() == -1) {
                        //botonBorrar.setDisable(true);
                        //vaciar();
                    } else {
                        rellenar(vistaTabla.getSelectionModel().getSelectedItem());
                        //botonBorrar.setDisable(false);
                    }
                });

        botonBorrar.disableProperty().bind(
                Bindings.equal(-1,
                        vistaTabla.getSelectionModel().selectedIndexProperty()));
        botonPais.disableProperty().bind(botonBorrar.disableProperty());

        botonModificar.disableProperty().bind(
                Bindings.equal(-1,
                        vistaTabla.getSelectionModel().selectedIndexProperty()));
        botonAdd.disableProperty().bind(vistaTabla.focusedProperty());
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

    class BanderaImagenCell extends TableCell<Persona, String> {

        private ImageView view = new ImageView();

        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            if (item == null || empty) {
                setGraphic(null);
            } else {
                // Si está en la carpeta recursos, con el nombre sobra
                Image image;
                try {
                    image = new Image(item + ".png", 46, 46, true, false);
                    view.setImage(image);
                } catch (IllegalArgumentException e) {
                    view.setImage(null);
                }
                setGraphic(view);
            }

        }
    }

    @FXML
    void addAccion(ActionEvent event) throws IOException {
        System.out.println("añadir");
        FXMLLoader miCargador = new FXMLLoader(
                getClass().getClassLoader().getResource(
                        "com/mycompany/personas/DatosPersona.fxml"
                )
        );
        Parent root = miCargador.load();
        DatosPersonaControlador controladorPersona
                = miCargador.<DatosPersonaControlador>getController();

        Scene scene = new Scene(root, 600, 400);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Añadir Persona");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        if (controladorPersona.getPersona() != null) {
            Persona personaM = controladorPersona.getPersona();
            datos.add(personaM);

            int ultimo = vistaTabla.getItems().size() - 1;
            vistaTabla.getSelectionModel().select(ultimo);
            vistaTabla.scrollTo(ultimo);

            //vistaLista.refresh();
            //rellenar(personaM);
        }
    }

    @FXML
    void borrarAccion(ActionEvent event) {
        vistaTabla.getItems().remove(vistaTabla.getSelectionModel().getSelectedItem());
    }

    @FXML
    void modificarAccion(ActionEvent event) throws IOException {
        System.out.println("modificar");
        FXMLLoader miCargador = new FXMLLoader(
                getClass().getClassLoader().getResource(
                        "com/mycompany/personas/DatosPersona.fxml"
                )
        );
        Parent root = miCargador.load();
        DatosPersonaControlador controladorPersona
                = miCargador.<DatosPersonaControlador>getController();
        Persona p = vistaTabla.getSelectionModel().getSelectedItem();
        if (p == null) {
            return;
        }
        controladorPersona.initPersona(p);
        Scene scene = new Scene(root, 600, 400);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Modificar datos de la Persona");
        stage.initModality(Modality.APPLICATION_MODAL);

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                Stage stage2 = (Stage) scene.getWindow();
                stage2.close();
            }
        });

        stage.showAndWait();
        if (controladorPersona.getPersona() != null) {
            Persona personaM = controladorPersona.getPersona();
            vistaTabla.refresh();
            rellenar(personaM);
        }
    }

    @FXML
    private void cerrarAccion(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "¿Estás seguro de que deseas salir?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.YES) {
                Platform.exit();
            }
        });
    }

    private void rellenar(Persona persona) {

        nombre.setText(persona.getNombre());
        apellidos.setText(persona.getApellidos());
        correo.setText(persona.getEmail());

        genero.setText(persona.getGenero());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha = persona.getNacimiento().format(formatter);

        fechaNacimiento.setText(fecha);
        pais.setText(persona.getPais());
        ImageView view = new ImageView();
        try {
            imagen.setImage(new Image(persona.getPais() + ".png"));
        } catch (IllegalArgumentException e) {
            imagen.setImage(null);
        }
        //botonModificarAutor.setDisable(false);
    }

    private void deshabilitarTextEdit() {
        nombre.setEditable(false);
        apellidos.setEditable(false);
        correo.setEditable(false);
        genero.setEditable(false);
        fechaNacimiento.setEditable(false);
        pais.setEditable(false);
    }

    @FXML
    private void paisAccion(ActionEvent event) throws IOException {
        System.out.println(this.vistaTabla.getSelectionModel().getSelectedItem().getPais());
        String pais = this.vistaTabla.getSelectionModel().getSelectedItem().getPais();
        ArrayList<Persona> listaPais = new ArrayList<>();
        for (Persona persona : this.datos) {
            if (persona.getPais().equals(pais)) {
                listaPais.add(persona);
            }
        }
        ObservableList<Persona> datosPais = FXCollections.observableArrayList(listaPais);
        System.out.println(datosPais.size());

        /*
        FXMLLoader miCargador = new FXMLLoader(
                getClass().getClassLoader().getResource(
                        "com/mycompany/personas/VistaListaPais.fxml"
                )
        );
        */
        FXMLLoader miCargador = new FXMLLoader(getClass().getResource("VistaListaPais.fxml"));
        Parent root = miCargador.load();
        
        VistaListaPaisControlador controller = miCargador.getController();
        controller.cargarPais(datosPais);
        
        Scene scene = new Scene(root,800,600);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Personas de " + pais);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }
}
