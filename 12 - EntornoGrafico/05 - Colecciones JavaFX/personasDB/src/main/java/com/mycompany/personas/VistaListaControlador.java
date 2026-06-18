/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.personas;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VistaListaControlador implements Initializable {

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
    private ListView<Persona> vistaLista;
    @FXML
    private Button botonAdd;
    @FXML
    private Button botonBorrar;
    @FXML
    private Button botonModificar;
    @FXML
    private Button botonCerrar;

    private ObservableList<Persona> datos = null; // Colecci�n vinculada a la vista.

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //ListaPersonas listaPersonas = Auxiliar.leerPersonas("personal.csv");

        if (!Db.existeTabla("persona")) {
            Db.crearTablaSiNoExiste();
            ListaPersonas lista = Auxiliar.leerPersonas("personal.csv");
            Db.guardarPersonas(lista.getPersonal());
        }
        ListaPersonas listaPersonas = Db.leerPersonas();
        //System.out.println(listaPersonas.personasCumple(28, 8).size());
        datos = FXCollections.observableArrayList(listaPersonas.getPersonal());
        vistaLista.setItems(datos); // vinculación entre la vista y el modelo
        vistaLista.setCellFactory(c -> new PersonaListCell2());
        vistaLista.getSelectionModel().selectedIndexProperty().addListener(
                (o, oldVal, newVal) -> {
                    if (newVal.intValue() == -1) {
                        //botonBorrar.setDisable(true);
                        //vaciar();
                    } else {
                        rellenar(vistaLista.getSelectionModel().getSelectedItem());
                        //botonBorrar.setDisable(false);
                    }
                });

        botonBorrar.disableProperty().bind(
                Bindings.equal(-1,
                        vistaLista.getSelectionModel().selectedIndexProperty()));

        botonModificar.disableProperty().bind(
                Bindings.equal(-1,
                        vistaLista.getSelectionModel().selectedIndexProperty()));
        botonAdd.disableProperty().bind(vistaLista.focusedProperty());
        //botonBorrar.disableProperty().bind(vistaLista.focusedProperty().not());

//        botonBorrar.disableProperty().bind(
//                vistaLista.getSelectionModel().selectedItemProperty().isNull()
//                        .or(vistaLista.focusedProperty().not())
//        );
        deshabilitarTextEdit();
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

            int ultimo = vistaLista.getItems().size() - 1;
            vistaLista.getSelectionModel().select(ultimo);
            vistaLista.scrollTo(ultimo);

            Db.insertarPersona(personaM);
            //vistaLista.refresh();
            //rellenar(personaM);
        }
    }

    @FXML
    void borrarAccion(ActionEvent event) {
        Persona p = vistaLista.getSelectionModel().getSelectedItem();
        vistaLista.getItems().remove(vistaLista.getSelectionModel().getSelectedItem());
        Db.borrarPersona(p.getId());
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
        Persona p = vistaLista.getSelectionModel().getSelectedItem();
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
            vistaLista.refresh();
            rellenar(personaM);
            System.out.println("Id: " + personaM.getId());
            Db.actualizarPersona(personaM);
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

    // Clase local al controlador
    class PersonaListCell extends ListCell<Persona> {

        private ImageView view = new ImageView();

        @Override
        protected void updateItem(Persona item, boolean empty) {
            super.updateItem(item, empty);
            String imagenGenero = "";
            //view.setImage(null);
            if (item == null || empty) {
                setText(null);
                setGraphic(null);
            } else {
                if ("Female".equals(item.getGenero())) {
                    imagenGenero = "woman.png";
                } else {
                    imagenGenero = "man.png";
                }
                Image image;
                try {
                    image = new Image(imagenGenero, 46, 46, true, false);
                    view.setImage(image);
                } catch (IllegalArgumentException e) {
                    view.setImage(null);
                }

                setGraphic(view);
                setText("\t" + item.getApellidos() + ", " + item.getNombre() + " - " + item.getPais());
            }
        }
    }

    class PersonaListCell2 extends ListCell<Persona> {

        private ImageView view1 = new ImageView();
        private ImageView view2 = new ImageView();
        Label label = new Label();
        private HBox hbox = new HBox();
        
        {
            hbox.getChildren().addAll(view1,label,view2);
        }

        @Override
        protected void updateItem(Persona item, boolean empty) {
            super.updateItem(item, empty);
            String imagenGenero = "";
            //view.setImage(null);
            if (item == null || empty) {
                setText(null);
                setGraphic(null);
            } else {
                if ("Female".equals(item.getGenero())) {
                    imagenGenero = "woman.png";
                } else {
                    imagenGenero = "man.png";
                }
                Image image;
                try {
                    image = new Image(imagenGenero, 46, 46, true, false);
                    view1.setImage(image);
                    view2.setImage(image);
                } catch (IllegalArgumentException e) {
                    view1.setImage(null);
                    view2.setImage(null);
                }

                setGraphic(hbox);
                // setText("\t" + item.getApellidos() + ", " + item.getNombre() + " - " + item.getPais());
                label.setText("\t" + item.getApellidos() + ", " + item.getNombre() + " - " + item.getPais()+"\t");
            }
        }
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
}
