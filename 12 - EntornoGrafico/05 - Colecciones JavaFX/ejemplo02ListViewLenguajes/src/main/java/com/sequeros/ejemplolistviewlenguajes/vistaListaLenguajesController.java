/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros.ejemplolistviewlenguajes;

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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author jabue
 */
public class vistaListaLenguajesController implements Initializable {

    @FXML
    private ListView<String> vistadeListafxID;
    @FXML
    private Button BAddfxID;
    @FXML
    private Button BBorrarfxID;
    @FXML
    private Label selectedItem;
    @FXML
    private TextField valorText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // Datos para visualizar ArrayList
        ArrayList<String> datosArrayList = new ArrayList<>();
        datosArrayList.add("Java");
        datosArrayList.add("JavaFX");
        datosArrayList.add("C++");
        datosArrayList.add("Python");
        datosArrayList.add("Javascript");
        datosArrayList.add("C#");
        // Declaramos la clase envoltorio
        ObservableList<String> datosObservableList;
        datosObservableList = FXCollections.observableList(datosArrayList);
        // vinculamos la vista
        vistadeListafxID.setItems(datosObservableList);

        // Configuramos listeners al elemento seleccionado del ListBox
               
        // Método 1
        selectedItem.textProperty().bind(vistadeListafxID.getSelectionModel().selectedItemProperty());
        /* 
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
        BBorrarfxID.disableProperty().bind(
                Bindings.equal(-1,
                        vistadeListafxID.getSelectionModel().selectedIndexProperty()));
        // El botón Add (Añadir) solo estará habilitado cuando el TextField no esté vacío
        BAddfxID.disableProperty().bind(valorText.textProperty().isEmpty());

    }

    @FXML
    private void addAccion(ActionEvent event) {
        //vistadeListafxID.getItems().add(valorText.getText());
    }

    @FXML
    private void borrarAccion(ActionEvent event) {
        //vistadeListafxID.getItems().remove(vistadeListafxID.getSelectionModel().getSelectedItem());
    }

}
