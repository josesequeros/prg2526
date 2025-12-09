/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.tableview;

import java.io.File;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mohbouezz
 */
public class PanelPrincipalController implements Initializable {

    @FXML
    private TableView<Autor> tabla;
    @FXML
    private ImageView imagen;
    @FXML
    private TableColumn<Autor, String> columnaDNI;
    @FXML
    private TableColumn<Autor, String> columnaNombre;
    @FXML
    private TableColumn<Autor, String> columnaApellidos;
    @FXML
    private TableColumn<Autor, String> columnaNacimiento;
    @FXML
    private TableColumn<Autor, String> columnaImagen;
    @FXML
    private TextField casillaDeDNI;
    @FXML
    private TextField casillaDeNombre;
    @FXML
    private TextField casillaDeApellidos;
    @FXML
    private TextField casillaDeNacimiento;
    @FXML
    private TextField casillaDeImagen;
    @FXML
    private Button borrar;
    @FXML
    private Button guardar;

    private ObservableList<Autor> observableListAutores;
    private ArrayList<Autor> misDatos;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        misDatos = A.load();
        if (misDatos.isEmpty()) {
            misDatos.add(new Autor("Mohamed Amin", "src/main/resources/A.png", "78131102X", "Bouselham Ez Zerrab", "26/11/2005"));
        }
        observableListAutores = FXCollections.observableArrayList(misDatos);
        tabla.setItems(observableListAutores);
        columnaDNI.setCellValueFactory(cellData -> cellData.getValue().DNIProperty());
        columnaNombre.setCellValueFactory(cellData -> cellData.getValue().NombreProperty());
        columnaApellidos.setCellValueFactory(cellData -> cellData.getValue().ApellidosProperty());
        columnaNacimiento.setCellValueFactory(cellData -> cellData.getValue().FechaNacimientoProperty());
        columnaImagen.setCellValueFactory(cellData -> cellData.getValue().PahtImagenProperty());
        columnaImagen.setCellFactory(v -> {
            return new TableCell<Autor, String>() {
                private ImageView view = new ImageView();

                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setGraphic(null);
                    } else {
                        File imageFile = new File(item);
                        if (imageFile.exists() == true) {
                            String fileLocation = imageFile.toURI().toString();
                            Image image = new Image(fileLocation, 50, 50, true, true);
                            view.setImage(image);
                            setGraphic(view);
                        } else {
                            setText("Imagen no válida");
                        }
                    }
                }
            };
        });
        tabla.getSelectionModel().selectedItemProperty().addListener(obs -> {
            cargarDatos();
        });
        borrar.disableProperty().bind((Bindings.equal(-1, tabla.getSelectionModel().selectedIndexProperty())));
        guardar.disableProperty().bind((Bindings.equal(-1, tabla.getSelectionModel().selectedIndexProperty())));
    }

    @FXML
    private void añadir(ActionEvent event) throws IOException {
        FXMLLoader miCargador = new FXMLLoader(getClass().getClassLoader().getResource("com/mycompany/tableview/PanelDatos.fxml"));
        Parent root = miCargador.load();
        PanelDatosController controladorPersona = miCargador.<PanelDatosController>getController();
        Autor persona = new Autor("", "", "", "", "");
        controladorPersona.initPersona(persona);
        Scene scene = new Scene(root, 500, 500);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Añadir persona");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        if (!controladorPersona.getCancelar()) {
            if ((!controladorPersona.getEquipo().getNombre().isEmpty()) && (controladorPersona.getEquipo().getNombre().trim().length() != 0) && (!controladorPersona.getEquipo().getNombre().isEmpty()) && (controladorPersona.getEquipo().getApellidos().trim().length() != 0)) {
                observableListAutores.add(controladorPersona.getEquipo());
                tabla.refresh();
            }
        }
    }

    @FXML
    private void salirYGuardar(ActionEvent event) {
        A.save(new ArrayList<>(observableListAutores));
        App.getMyStage().close();
    }

    @FXML
    private void guardar(ActionEvent event) {
        if (tabla.getSelectionModel().getSelectedItem() != null) {
            tabla.getSelectionModel().getSelectedItem().setDNI(casillaDeDNI.getText());
            tabla.getSelectionModel().getSelectedItem().setNombre(casillaDeNombre.getText());
            tabla.getSelectionModel().getSelectedItem().setApellidos(casillaDeApellidos.getText());
            tabla.getSelectionModel().getSelectedItem().setFechaNacimiento(casillaDeNacimiento.getText());
            tabla.getSelectionModel().getSelectedItem().setPahtImagen(casillaDeImagen.getText());
        }
    }

    @FXML
    private void borrar(ActionEvent event) {
        observableListAutores.remove(tabla.getSelectionModel().getSelectedIndex());
    }

    private void cargarDatos() {
        if (tabla.getSelectionModel().getSelectedItem() != null) {
            casillaDeDNI.setText(tabla.getSelectionModel().getSelectedItem().getDNI());
            casillaDeNombre.setText(tabla.getSelectionModel().getSelectedItem().getNombre());
            casillaDeApellidos.setText(tabla.getSelectionModel().getSelectedItem().getApellidos());
            casillaDeNacimiento.setText(tabla.getSelectionModel().getSelectedItem().getFechaNacimiento());
            casillaDeImagen.setText(tabla.getSelectionModel().getSelectedItem().getPahtImagen());
            File imageFile = new File(tabla.getSelectionModel().getSelectedItem().getPahtImagen());
            if (imageFile.exists()) {
                String fileLocation = imageFile.toURI().toString();
                imagen.setImage(new Image(fileLocation));
            }
        }
    }
}
