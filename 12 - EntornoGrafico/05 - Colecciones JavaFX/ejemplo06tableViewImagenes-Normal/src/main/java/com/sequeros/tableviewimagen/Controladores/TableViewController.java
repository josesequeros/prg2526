/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros.tableviewimagen.Controladores;

import com.sequeros.tableviewimagen.Modelos.Persona;
import com.sequeros.tableviewimagen.Modelos.Residencia;
import java.io.File;
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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jabue
 */
public class TableViewController implements Initializable {

    @FXML
    private Button botonVer;
    @FXML
    private Button botonModificar;
    @FXML
    private Button botonBorrar;
    @FXML
    private TableColumn<Persona, String> nombreColumna;
    @FXML
    private TableColumn<Persona, String> apellidosColumna;
    @FXML
    private TableColumn<Persona, Residencia> residenciaColumna;
    @FXML
    private TableColumn<Persona, String> imagenColumna;
    @FXML
    private TableView<Persona> vistaTabla;

    private ObservableList<Persona> misPersonas;
    @FXML
    private Button botonAdd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList<Persona> misDatos = new ArrayList<Persona>();
        
        misDatos.add(new Persona("Pepe", "Gotera", new Residencia("Almoradi", "Alicante"),
                "./src/main/resources/Sonriente.png"));
        misDatos.add(new Persona("Pepe", "García", new Residencia("Sagunto", "Castellón"),
                "./src/main/resources/Pregunta.png"));
        misDatos.add(new Persona("María", "Pérez", new Residencia("Lliria", "Valencia"),
                "./src/main/resources/LLoroso.png"));
        misDatos.add(new Persona("Carpanta", "Imagenes", new Residencia("Lliria", "Valencia"),
                "./src/main/resources/python.png"));

        /*
                misDatos.add(new Persona("Carpanta", "Imagenes", new Residencia("Lliria", "Valencia"),
                "./imagenes/python.png"));
        
        misDatos.add(new Persona("Pepe", "Gotera", new Residencia("Almoradi", "Alicante"),
                "./Sonriente.png"));
        misDatos.add(new Persona("Pepe", "García", new Residencia("Sagunto", "Castellón"),
                "./Pregunta.png"));
        misDatos.add(new Persona("María", "Pérez", new Residencia("Lliria", "Valencia"),
                "./LLoroso.png"));
        misDatos.add(new Persona("Carpanta", "Imagenes", new Residencia("Lliria", "Valencia"),
                "./python.png"));
*/
        misPersonas = FXCollections.observableArrayList(misDatos);
        vistaTabla.setItems(misPersonas);
        // Clase de Conveniencia
        //nombreColumna.setCellValueFactory(new PropertyValueFactory<Persona, String>("Nombre"));
        //apellidosColumna.setCellValueFactory(new PropertyValueFactory<Persona, String>("Apellidos"));
        // mejor que lo anterior es una expresión lamda
        nombreColumna.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        apellidosColumna.setCellValueFactory(new PropertyValueFactory<>("Apellidos"));

        // Definimos que queremos ver
        residenciaColumna.setCellValueFactory(new PropertyValueFactory<>("Residencia"));
        // Definimos como queremos verlo
        residenciaColumna.setCellFactory(v -> {
            return new TableCell<Persona, Residencia>() {
                @Override
                protected void updateItem(Residencia item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                    } else {
                        setText(item.getCiudad() + " --> " + item.getProvincia());
                        //setText(item.toString());
                    }
                }
            };
        });

        // así mostrará la ruta
        //imagenColumna.setCellValueFactory(cellData -> cellData.getValue().getPathImagen());
        // así mostraremos la imagen (al usar setCellFactory)
        imagenColumna.setCellValueFactory(new PropertyValueFactory<>("PathImagen"));
        imagenColumna.setCellFactory(columna -> {
            return new TableCell<Persona, String>() {
                private ImageView view = new ImageView();

                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setGraphic(null);
                    } else {
                        //System.out.println(item + " " + item.getClass());
                        //Image image = new Image(TableViewController.class.getResourceAsStream(item),
                        //        40, 40, true, true);
                        
                        File imageFile = new File(item);     // item path y nombre del archivo
                        String fileLocation = imageFile.toURI().toString();
                        Image image = new Image(fileLocation, 40, 40, true, true);
                        //Image image = new Image("./src/main/resources/com/sequeros/tableviewimagen/recursos/Sonriente.png", 46, 46, true, false);
                        //Image image = new Image(item, 46, 46, true, false);
                         
                        view.setImage(image);
                        setGraphic(view);
                    }
                }
            };
        });
    }

    @FXML
    private void verAccion(ActionEvent event) {

    }

    @FXML
    private void addAccion(ActionEvent event) throws IOException {
        editar(event);
    }

    @FXML
    private void modificarAccion(ActionEvent event) throws IOException {
        editar(event);
    }

    @FXML
    private void borrarAccion(ActionEvent event) {
        vistaTabla.getItems().remove(vistaTabla.getSelectionModel().getSelectedItem());
    }

    private void editar(ActionEvent event) throws IOException {
        Button clickedButton = (Button) event.getSource();

        FXMLLoader miCargador = new FXMLLoader(getClass().getClassLoader().getResource("com/sequeros/tableviewimagen/DatosPersona.fxml"));
        Parent root = miCargador.load();
        // acceso al controlador de datos persona
        DatosPersonaControlador controladorPersona = miCargador.<DatosPersonaControlador>getController();

        Scene scene = new Scene(root, 500, 300);
        Stage stage = new Stage();
        stage.setScene(scene);

        Persona persona = new Persona("", "", new Residencia(null, ""),"");
        if (clickedButton.getId().equals("botonAdd")) {
            controladorPersona.initPersona(persona); // pasa los datos al segundo controlador
            stage.setTitle("Añadir ==>> Persona");
        } else {
            // obtiene los datos de la fila seleccionada.
            persona = vistaTabla.getSelectionModel().getSelectedItem();
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
                if (clickedButton.getId().equals("botonAdd")) {
                    misPersonas.add(controladorPersona.getPersona());
                } else {
                    /*
                    vistadeListafxID.getSelectionModel().getSelectedItem().setNombre(
                            controladorPersona.getPersona().getNombre()
                    );
                    vistadeListafxID.getSelectionModel().getSelectedItem().setApellidos(
                            controladorPersona.getPersona().getApellidos()
                    );
                     */
                    int indice = misPersonas.indexOf(persona);
                    // índice que ocupara en la lista observable
                    Persona p = controladorPersona.getPersona();
                    //nuevo valor en el formulario emergente
                    misPersonas.set(indice, p); // actualiza la persona.
                }
                vistaTabla.refresh();
            }
        }
    }

}
