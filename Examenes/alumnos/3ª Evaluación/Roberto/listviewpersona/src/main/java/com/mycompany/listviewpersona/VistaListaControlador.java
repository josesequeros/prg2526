/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.listviewpersona;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
public class VistaListaControlador {
@FXML
private ListView<String> vistadeListafxID;
private final ObservableList<String> listaPersonas =
FXCollections.observableArrayList();
    @FXML
    private Button BVerfxID;
    @FXML
    private Button BAddfxID;
    @FXML
    private Button BBorrarfxID;
    @FXML
    private Button BModificarfxID;
    @FXML
    private TextField nombrefield;
    @FXML
    private TextField apellidofield;
    @FXML
    private TextField generofield;
public void initialize() {
vistadeListafxID.setItems(listaPersonas);// lo de abajo meter en los textfield no me da tiempo
nombrefield.setText(vistadeListafxID.getSelectionModel().getSelectedItem());
apellidofield.setText(vistadeListafxID.getSelectionModel().getSelectedItem());
generofield.setText(vistadeListafxID.getSelectionModel().getSelectedItem());
}
@FXML
private void addAccion() {
try {
FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mycompany/listviewpersona/DatosPersona.fxml"));
Parent root = loader.load();
DatosPersonaControlador controlador = loader.getController();
Stage stage = new Stage();
stage.setTitle("Añadir Persona");
stage.setScene(new Scene(root));
stage.initModality(Modality.APPLICATION_MODAL);
stage.showAndWait();
if (controlador.isGuardar()) {
String persona = controlador.getNombre() + " " +
controlador.getApellido()
+controlador.getCorreo();
listaPersonas.add(persona);
}
} catch (IOException e) {
e.printStackTrace();
}
}
@FXML
private void borrarAccion() {
int indice = vistadeListafxID.getSelectionModel().getSelectedIndex();
if (indice >= 0) {
listaPersonas.remove(indice);
}
}
@FXML
private void modificarAccion() {
int indice = vistadeListafxID.getSelectionModel().getSelectedIndex();
if (indice >= 0) {
try {
String[] datos = listaPersonas.get(indice).split(" ", 2);
FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mycompany/listviewpersona/DatosPersona.fxml"));
Parent root = loader.load();
DatosPersonaControlador controlador = loader.getController();

Stage stage = new Stage();
stage.setTitle("Modificar Persona");
stage.setScene(new Scene(root));
stage.initModality(Modality.APPLICATION_MODAL);
stage.showAndWait();
if (controlador.isGuardar()) {
String personaModificada = controlador.getNombre() + " "
+ controlador.getApellido();
listaPersonas.set(indice, personaModificada);
}
} catch (IOException e) {
e.printStackTrace();
}
}
}
private void VerDatosAction() {
int indice = vistadeListafxID.getSelectionModel().getSelectedIndex();
if (indice >= 0) {
try {
String[] datos = listaPersonas.get(indice).split(" ", 2);
FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mycompany/listviewpersona/VerDatosPersona.fxml"));
Parent root = loader.load();
VerDatosPersonaControlador controlador =
loader.getController();

Stage stage = new Stage();
stage.setTitle("Ver Datos");
stage.setScene(new Scene(root));
stage.initModality(Modality.APPLICATION_MODAL);
stage.showAndWait();
} catch (IOException e) {
e.printStackTrace();
}
}
}

    @FXML
    private void cerrar(ActionEvent event) {
        System.exit(0);
    }
}

