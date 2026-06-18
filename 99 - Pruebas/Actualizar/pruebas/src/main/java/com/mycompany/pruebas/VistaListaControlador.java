/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.pruebas;

import java.io.IOException;
import java.net.URL;
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
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ja.buenoseva
 */
public class VistaListaControlador implements Initializable {

    @FXML
    private Button BVerfxID;
    @FXML
    private ListView<Persona> vistadeListafxID;
    @FXML
    private Button BAddfxID;
    @FXML
    private Button BBorrarfxID;
    @FXML
    private Button BModificarfxID;

    private ObservableList<Persona> datos = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        datos = FXCollections.observableArrayList();
        datos.add(new Persona("Pepe", "Gotera"));

        vistadeListafxID.setItems(datos);
        vistadeListafxID.setCellFactory(c -> new PersonaListCell());
    }

    @FXML
    private void VerDatosAction(ActionEvent event) throws IOException {
        FXMLLoader miCargador = new FXMLLoader(
                // getResource() es relativo al paquete; getClassLoader es absoluto desde la raíz.
                //getClass().getClassLoader().getResource("com/mycompany/pruebas/VerDatosPersona.fxml")
                //getClass().getResource("/com/mycompany/pruebas/VerDatosPersona.fxml")
                getClass().getResource("VerDatosPersona.fxml")
        );
        Parent root = miCargador.load();

        VerDatosPersonaControlador controladorPersona
                = miCargador.<VerDatosPersonaControlador>getController();
        Persona p = vistadeListafxID.getSelectionModel().getSelectedItem();
        if (p == null) {
            return;
        }

        controladorPersona.initPersona(p);
        Scene scene = new Scene(root, 500, 300);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Visualizar datos de la Persona");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    @FXML
    private void addAccion(ActionEvent event) throws IOException {
        System.out.println("Añadir");
        FXMLLoader miCargador = new FXMLLoader(
                getClass().getClassLoader().getResource(
                        "com/mycompany/pruebas/DatosPersona.fxml"
                )
        );
        Parent root = miCargador.load();
        DatosPersonaControlador controladorPersona
                = miCargador.<DatosPersonaControlador>getController();
        Persona p = new Persona("", "");

        //controladorPersona.initPersona(p);
        Scene scene = new Scene(root, 500, 300);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Añadir datos de la Persona");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        if (!controladorPersona.getCancelar()) {
            if ((!controladorPersona.getPersona().getNombre().isEmpty())
                    && (controladorPersona.getPersona().getNombre().trim().length() != 0)
                    && (!controladorPersona.getPersona().getApellidos().isEmpty())
                    && (controladorPersona.getPersona().getApellidos().trim().length() != 0)) {
                int indice = datos.indexOf(p);
                System.out.println(indice);
                // índice que ocupara en la lista observable
                Persona personaM = controladorPersona.getPersona();
                datos.add(personaM);
            }
        }
    }

    @FXML
    private void borrarAccion(ActionEvent event) {
    }

    @FXML
    private void modificarAccion(ActionEvent event) throws IOException {
        System.out.println("modificar");
        FXMLLoader miCargador = new FXMLLoader(
                getClass().getClassLoader().getResource(
                        "com/mycompany/pruebas/DatosPersona.fxml"
                )
        );
        Parent root = miCargador.load();
        DatosPersonaControlador controladorPersona
                = miCargador.<DatosPersonaControlador>getController();
        Persona p = vistadeListafxID.getSelectionModel().getSelectedItem();
        if (p == null) {
            return;
        }
        controladorPersona.initPersona(p);
        Scene scene = new Scene(root, 500, 300);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Modificar datos de la Persona");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        if (!controladorPersona.getCancelar()) {
            if ((!controladorPersona.getPersona().getNombre().isEmpty())
                    && (controladorPersona.getPersona().getNombre().trim().length() != 0)
                    && (!controladorPersona.getPersona().getApellidos().isEmpty())
                    && (controladorPersona.getPersona().getApellidos().trim().length() != 0)) {
                int indice = datos.indexOf(p);
                System.out.println(indice);
                // índice que ocupara en la lista observable
                Persona personaM = controladorPersona.getPersona();
                //nuevo valor en el formulario emergente
                ////datos.set(indice, personaM); // actualiza la persona.
                //vistadeListafxID.refresh();
            }
        }
    }

    class PersonaListCell extends ListCell<Persona> {

        @Override
        protected void updateItem(Persona item, boolean empty) {
            super.updateItem(item, empty);
            if (item == null || empty) {
                setText(null);
            } else {
                // Valor inicial
                setText(item.getApellidos() + ", " + item.getNombre());

                // listener para cambios automáticos
                item.NombreProperty().addListener((obs, oldVal, newVal) -> {
                    setText(item.getApellidos() + ", " + item.getNombre());
                });
                item.ApellidosProperty().addListener((obs, oldVal, newVal) -> {
                    setText(item.getApellidos() + ", " + item.getNombre());
                });

            }
        }
    }

}
