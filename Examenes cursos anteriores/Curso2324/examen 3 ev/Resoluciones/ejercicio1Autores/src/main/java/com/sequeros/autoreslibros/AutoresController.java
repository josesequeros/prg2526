/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros.autoreslibros;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author jabue
 */
public class AutoresController implements Initializable {

    @FXML
    private Button botonAdd;
    @FXML
    private Button botonBorrar;
    @FXML
    private TextField dni;
    @FXML
    private TextField nombre;
    @FXML
    private TextField apellidos;
    @FXML
    private TextField nacimiento;
    @FXML
    private ImageView imagen;
    @FXML
    private TextField rutaImagen;
    @FXML
    private TableView<Autor> vistaTabla;
    @FXML
    private TableColumn<Autor, String> dniColumna;
    @FXML
    private TableColumn<Autor, String> nombreColumna;
    @FXML
    private TableColumn<Autor, String> apellidosColumna;
    @FXML
    private TableColumn<Autor, LocalDate> nacimientoColumna;
    @FXML
    private TableColumn<Autor, String> imagenColumna;
    @FXML
    private Button botonSalirGrabando;
    @FXML
    private Button botonAplicar;
    @FXML
    private Button botonModificarAutor;
    @FXML
    private Button botonCancelar;

    private ObservableList<Autor> misAutores;
    private ArrayList<Autor> misDatos = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        misDatos = Auxiliar.leerAutores("autores.txt");
        misAutores = FXCollections.observableArrayList(misDatos);
        vistaTabla.setItems(misAutores);
        dniColumna.setCellValueFactory(cellData -> cellData.getValue().DniProperty());
        nombreColumna.setCellValueFactory(cellData -> cellData.getValue().NombreProperty());
        apellidosColumna.setCellValueFactory(cellData -> cellData.getValue().ApellidosProperty());
        nacimientoColumna.setCellValueFactory(cellData -> cellData.getValue().getNacimiento());
        imagenColumna.setCellValueFactory(cellData -> cellData.getValue().pathImagenProperty());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        nacimientoColumna.setCellFactory(column -> new TextFieldTableCell<>(new StringConverter<LocalDate>() {
            @Override
            public String toString(LocalDate date) {
                return date != null ? date.format(formatter) : "";
            }

            @Override
            public LocalDate fromString(String string) {
                return string != null && !string.isEmpty() ? LocalDate.parse(string, formatter) : null;
            }
        }));

        imagenColumna.setCellFactory(columna -> new AutorImagenCell());
    }

    /**
     * Clase local al controlador para la visualización de la imagen
     */
    class AutorImagenCell extends TableCell<Autor, String> {

        private ImageView view = new ImageView();

        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            if (item == null || empty) {
                setText(null);
                setGraphic(null);
            } else {
                try {
                    view.setImage(new Image("" + item, 40, 40, false, true));
                    setGraphic(view);
                } catch (IllegalArgumentException e) {
                    setText("No imagen");
                    setGraphic(null);
                }
            }
        }
    }

    @FXML
    private void borrarAccion(ActionEvent event) {

    }

    @FXML
    private void salirGrabando(ActionEvent event) {
        Auxiliar.grabarAutores("autores.txt", new ArrayList(misAutores));

        Alert alert = new Alert(
                AlertType.CONFIRMATION, "¿Estás seguro de que deseas salir?",
                ButtonType.YES,
                ButtonType.NO
        );
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.YES) {
                Platform.exit();
            }
        });
    }

    @FXML
    private void aplicar(ActionEvent event) {

    }

    @FXML
    private void modificarAutor(ActionEvent event) {

    }

    @FXML
    private void cancelar(ActionEvent event) {

    }

    @FXML
    private void addAccion(ActionEvent event) throws IOException {
        FXMLLoader miCargador = new FXMLLoader(
                getClass().getClassLoader().getResource("com/sequeros/autoreslibros/DatosAutor.fxml")
        );
        Parent root = miCargador.load();
        DatosAutorController datosAutorController = miCargador.<DatosAutorController>getController();

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Añadir ==>> Autor");
        stage.initModality(Modality.APPLICATION_MODAL); //la ventana se muestra modal
        stage.showAndWait(); // espera a que se cierre la segunda ventana.

        if (!datosAutorController.getCancelar()) {
            misAutores.add(datosAutorController.getAutor());
            vistaTabla.refresh();
        }
    }

    public void initAutor(Autor autor) {
        dni.setText(autor.getDni());
        nombre.setText(autor.getNombre());
        apellidos.setText(autor.getApellidos());
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //nacimiento.setText(autor.getNacimiento().get().format(formatter));
        rutaImagen.setText(autor.getPathImagen());
        //ImageView view = new ImageView();
        //imagen.setImage(new Image("" + autor.getPathImagen()));
    }

}
