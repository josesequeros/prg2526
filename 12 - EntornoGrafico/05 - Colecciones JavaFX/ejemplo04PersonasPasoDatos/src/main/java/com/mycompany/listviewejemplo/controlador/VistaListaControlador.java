package com.mycompany.listviewejemplo.controlador;

import com.mycompany.listviewejemplo.modelo.Persona;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VistaListaControlador implements Initializable {

    @FXML
    private ListView<Persona> vistadeListafxID;
    @FXML
    private Button BAddfxID;
    @FXML
    private Button BBorrarfxID;
    @FXML
    private Button BModificarfxID;

    private ObservableList<Persona> datos = null; // Colecci�n vinculada a la vista.
    @FXML
    private Button BVerfxID;

    @FXML
    void addAccion(ActionEvent event) throws IOException {
        //editarAccion(event);
        Button clickedButton = (Button) event.getSource();
        System.out.println(clickedButton.getId());

        //FXMLLoader miCargador = new FXMLLoader(getClass().getResource("com/mycompany/listviewejemplo/DatosPersona.fxml"));
        FXMLLoader miCargador = new FXMLLoader(getClass().getClassLoader().getResource("com/mycompany/listviewejemplo/DatosPersona.fxml"));
        Parent root = miCargador.load();
        // acceso al controlador de datos persona
        DatosPersonaControlador controladorPersona = miCargador.<DatosPersonaControlador>getController();
        // creamos una persona nula
        Persona persona = new Persona("", "");
        controladorPersona.initPersona(persona); // pasa los datos al segundo controlador
        Scene scene = new Scene(root, 500, 300);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Añadir persona");
        // stage.show();
        stage.initModality(Modality.APPLICATION_MODAL); //la ventana se muestra modal
        stage.showAndWait();    // espera a que se cierre la segunda ventana.

        // Datos del controlador
        if (!controladorPersona.getCancelar()) {
            if ((!controladorPersona.getPersona().getNombre().isEmpty())
                    && (controladorPersona.getPersona().getNombre().trim().length() != 0)
                    && (!controladorPersona.getPersona().getApellidos().isEmpty())
                    && (controladorPersona.getPersona().getApellidos().trim().length() != 0)) {
                datos.add(controladorPersona.getPersona());
                vistadeListafxID.refresh();
            }
        }
    }

    @FXML
    void borrarAccion(ActionEvent event) {
        int i = vistadeListafxID.getSelectionModel().getSelectedIndex();
        if (i >= 0) {
            datos.remove(i);
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        // en el código de inicialización del controlador
        // TODO Auto-generated method stub
        ArrayList<Persona> misdatos = new ArrayList<Persona>();
        misdatos.add(new Persona("Pepe", "García"));
        misdatos.add(new Persona("María", "Pérez"));
        /*
        ObservableList<Persona> datos
                = FXCollections.observableArrayList(
                        new Persona("Jacob", "Smith"),
                        new Persona("Isabella", "Johnson"),
                        new Persona("Ethan", "Williams"),
                        new Persona("Emma", "Jones"),
                        new Persona("Michael", "Brown"));
         */
        datos = FXCollections.observableArrayList(misdatos);

        vistadeListafxID.setItems(datos); // vinculación entre la vista y el modelo

        // inhabilitar botones al arrancar.
        BAddfxID.setDisable(false);
        BBorrarfxID.setDisable(true);

        // oyente de foco para el listView
        vistadeListafxID.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
                    Boolean newValue) {
                if (!vistadeListafxID.isFocused()) {
                    BBorrarfxID.setDisable(true);
                }
                int i = vistadeListafxID.getSelectionModel().getSelectedIndex();
                if (i >= 0) {
                    BBorrarfxID.setDisable(false);
                }
            }

        });

        // en el código de inicialización del controlador
        vistadeListafxID.setCellFactory(c -> new PersonListCell());

    }

    @FXML
    private void modificarAccion(ActionEvent event) throws IOException {
        editarAccion(event);
    }

    @FXML
    private void VerDatosAction(ActionEvent event) throws IOException {
        FXMLLoader miCargador = new FXMLLoader(
                getClass().getClassLoader().getResource(
                        "com/mycompany/listviewejemplo/VerDatosPersona.fxml"));
        Parent root = miCargador.load();
        VerDatosPersonaControlador controladorPersona = 
                miCargador.<VerDatosPersonaControlador>getController();
        // persona seleccionada en la tabla
        Persona persona = vistadeListafxID.getSelectionModel().getSelectedItem();
        if (persona == null) {
            return;
        }
        controladorPersona.initPersona(persona);
        Scene scene = new Scene(root, 500, 300);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Ver Datos Persona");
        // stage.show();
        stage.initModality(Modality.APPLICATION_MODAL); //la ventana se muestra modal
        stage.showAndWait(); // espera a que se cierre la segunda ventana.
    }

    // Clase local al controlador
    class PersonListCell extends ListCell<Persona> {

        @Override
        protected void updateItem(Persona item, boolean empty) {
            super.updateItem(item, empty); // Obligatoria esta llamada
            if (item == null || empty) {
                setText(null);
            } else {
                setText(item.getApellidos() + ", " + item.getNombre());
            }
        }
    }

    private void editarAccion(ActionEvent event) throws IOException {
        Button clickedButton = (Button) event.getSource();
        System.out.println(clickedButton.getId());

        FXMLLoader miCargador = new FXMLLoader(getClass().getClassLoader().getResource("com/mycompany/listviewejemplo/DatosPersona.fxml"));
        Parent root = miCargador.load();
        // acceso al controlador de datos persona
        DatosPersonaControlador controladorPersona = miCargador.<DatosPersonaControlador>getController();

        Scene scene = new Scene(root, 500, 300);
        Stage stage = new Stage();
        stage.setScene(scene);

        Persona persona = new Persona("", "");
        if (clickedButton.getId().equals("BAddfxID")) {
            controladorPersona.initPersona(persona); // pasa los datos al segundo controlador
            stage.setTitle("Añadir ==>> Persona");
        } else {
            // obtiene los datos de la fila seleccionada.
            persona = vistadeListafxID.getSelectionModel().getSelectedItem();
            if (persona == null) {
                return; // si no hay selección sale del método
            }
            stage.setTitle("Modificar -->  Persona");
        }
        controladorPersona.initPersona(persona); // pasa los datos al segundo controlador
        // stage.show();
        stage.initModality(Modality.APPLICATION_MODAL); //la ventana se muestra modal
        stage.showAndWait(); // espera a que se cierre la segunda ventana.

        // Datos del controlador
        if (!controladorPersona.getCancelar()) {
            if ((!controladorPersona.getPersona().getNombre().isEmpty())
                    && (controladorPersona.getPersona().getNombre().trim().length() != 0)
                    && (!controladorPersona.getPersona().getApellidos().isEmpty())
                    && (controladorPersona.getPersona().getApellidos().trim().length() != 0)) {
                if (clickedButton.getId().equals("BAddfxID")) {
                    datos.add(controladorPersona.getPersona());
                } else {
                    /*
                    vistadeListafxID.getSelectionModel().getSelectedItem().setNombre(
                            controladorPersona.getPersona().getNombre()
                    );
                    vistadeListafxID.getSelectionModel().getSelectedItem().setApellidos(
                            controladorPersona.getPersona().getApellidos()
                    );
                    */
                    int indice = datos.indexOf(persona);
                    // índice que ocupara en la lista observable
                    Persona p = controladorPersona.getPersona();
                    //nuevo valor en el formulario emergente
                    datos.set(indice, p); // actualiza la persona.
                }
                vistadeListafxID.refresh();
            }
        }
    }

}
