/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros.ejemplolistviewlenguajes;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.util.Callback;

import com.sequeros.ejemplolistviewlenguajes.vistaListaLenguajesController.LenguajeListCell;

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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author jabue
 */
public class vistaListaLenguajesController implements Initializable {

    @FXML
    private ListView<Lenguaje> vistadeListafxID;
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
        ArrayList<Lenguaje> datosArrayList = new ArrayList<>();
        datosArrayList.add(new Lenguaje("Java", new Image("java.png", 46, 46, true, false)));
        datosArrayList.add(new Lenguaje("JavaFX", new Image("file:./javafx.png", 46, 46, true, false)));
        datosArrayList.add(new Lenguaje("C++", new Image("file:./cplusplus.png")));
        datosArrayList.add(new Lenguaje("Python", new Image("python.png", 46, 46, true, false)));
        datosArrayList.add(new Lenguaje("Javascript", new Image("javascript.png", 46, 46, true, false)));
        datosArrayList.add(new Lenguaje("C#", new Image("csharp.png", 46, 46, true, false)));
        datosArrayList.add(new Lenguaje("Elantris", new Image("elantris.jpg", 46, 46, true, true)));
        // Declaramos la clase envoltorio
        ObservableList<Lenguaje> datosObservableList;
        datosObservableList = FXCollections.observableList(datosArrayList);
        // vinculamos la vista
        vistadeListafxID.setItems(datosObservableList);

        // Configuramos listeners al elemento seleccionado del ListBox
        /*        
        // Método 1
        selectedItem.textProperty().bind(vistadeListafxID.getSelectionModel().selectedItemProperty());
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

        // Personalizar cada celda con una CellFactory
        //vistadeListafxID.setCellFactory(c -> new LenguajeListCell());
                
        vistadeListafxID.setCellFactory(new Callback<ListView<Lenguaje>, ListCell<Lenguaje>>() {
            @Override
            public ListCell<Lenguaje> call(ListView<Lenguaje> listView) {
                return new ListCell<Lenguaje>() {
                    private ImageView view = new ImageView();
                    @Override
                    protected void updateItem(Lenguaje item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null) {
                            setText(null);
                            setGraphic(null);
                        } else {
                            view.setImage(item.getImagen());
                            setGraphic(view);
                            setText("\t"+item.getNombre());
                            setTextFill(Color.BLUE); // Color del texto
                            setFont(Font.font("Arial", 16)); // Fuente
                        }
                    }
                };
            }
        });

    }

    @FXML
    private void addAccion(ActionEvent event) {
        //vistadeListafxID.getItems().add(valorText.getText());
    }

    @FXML
    private void borrarAccion(ActionEvent event) {
        //vistadeListafxID.getItems().remove(vistadeListafxID.getSelectionModel().getSelectedItem());
    }

    // Clase local al controlador
    class LenguajeListCell extends ListCell<Lenguaje> {

        private ImageView view = new ImageView();

        @Override
        protected void updateItem(Lenguaje item, boolean empty) {
            super.updateItem(item, empty);
            if (item == null || empty) {
                setText(null);
                setGraphic(null);
            } else {
                //view.setImage(new Image("file:./php.png"));
                view.setImage(item.getImagen());
                setGraphic(view);
                setText("\t"+item.getNombre());
                setTextFill(Color.BLUE);
                setFont(Font.font("Arial",16));
            }
        }
    }
}
