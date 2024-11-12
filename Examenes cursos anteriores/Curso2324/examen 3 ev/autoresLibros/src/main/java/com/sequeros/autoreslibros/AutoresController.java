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

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        misDatos = Auxiliar.leerAutores("autores.txt");
        misAutores = FXCollections.observableArrayList(misDatos);
        vistaTabla.setItems(misAutores);

        dniColumna.setCellValueFactory(cellData -> cellData.getValue().DniProperty());
        nombreColumna.setCellValueFactory(cellData -> cellData.getValue().NombreProperty());
        apellidosColumna.setCellValueFactory(cellData -> cellData.getValue().ApellidosProperty());

        nacimientoColumna.setCellValueFactory(cellData -> cellData.getValue().getNacimiento());
        //nacimientoColumna.setCellFactory(columna -> new NacimientoCell());

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

        imagenColumna.setCellValueFactory(cellData -> cellData.getValue().pathImagenProperty());
        imagenColumna.setCellFactory(columna -> new AutorImagenCell());

        vistaTabla.getSelectionModel().selectedIndexProperty().addListener(
                (o, oldVal, newVal) -> {
                    if (newVal.intValue() == -1) {
                        botonBorrar.setDisable(true);
                        //vaciar();
                    } else {
                        rellenar(vistaTabla.getSelectionModel().getSelectedItem());
                        botonBorrar.setDisable(false);
                    }
                });

        botonModificarAutor.setDisable(true);
        botonAplicar.setVisible(false);
        botonCancelar.setVisible(false);
        habilitar(false);

        // inhabilitar botones al arrancar.
        botonAdd.setDisable(false);
        botonBorrar.setDisable(true);
        botonSalirGrabando.setDisable(false);

    }

    @FXML
    private void borrarAccion(ActionEvent event) {
        vistaTabla.getItems().remove(vistaTabla.getSelectionModel().getSelectedItem());
        dni.setText("");
        nombre.setText("");
        apellidos.setText("");
        nacimiento.setText("");
        rutaImagen.setText("");
        imagen.setImage(null);
    }

    private void rellenar(Autor autor) {
        dni.setText(autor.getDni());
        nombre.setText(autor.getNombre());
        apellidos.setText(autor.getApellidos());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        nacimiento.setText(autor.getNacimiento().get().format(formatter));
        rutaImagen.setText(autor.getPathImagen());
        //ImageView view = new ImageView();
        try {
            imagen.setImage(new Image("" + autor.getPathImagen()));
        } catch (IllegalArgumentException e) {
            imagen.setImage(null);
        }
        botonModificarAutor.setDisable(false);
    }



    @FXML
    private void salirGrabando(ActionEvent event) {
        Auxiliar.grabarAutores("autores.txt", new ArrayList(misAutores));

        Alert alert = new Alert(AlertType.CONFIRMATION, "¿Estás seguro de que deseas salir?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.YES) {
                Platform.exit();
            }
        });
    }

    @FXML
    private void aplicar(ActionEvent event) {
        Autor autor = vistaTabla.getSelectionModel().getSelectedItem();

        int indice = misAutores.indexOf(autor);
        // índice que ocupara en la lista observable
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            LocalDate date = LocalDate.parse(nacimiento.getText(), formatter);
            Autor autorModificado = new Autor(dni.getText(), nombre.getText(), apellidos.getText(), date, rutaImagen.getText());
            System.out.println(autorModificado);
            misAutores.set(indice, autorModificado);
            vistaTabla.scrollTo(indice);
            vistaTabla.getSelectionModel().select(indice);
            botonAplicar.setVisible(false);
            botonCancelar.setVisible(false);
            botonModificarAutor.setVisible(true);
            habilitar(false);
        } catch (DateTimeParseException e) {
            System.err.println("Error en el formato de la fecha: " + e.getMessage());
            // Mostrar un diálogo de información al usuario
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error al analizar la fecha");
            alert.setContentText("Por favor, ingrese una fecha válida en el formato DD/MM/YYYY.");
            Optional<ButtonType> result = alert.showAndWait();
            vistaTabla.refresh();
        }

    }

    @FXML
    private void modificarAutor(ActionEvent event) {
        botonAplicar.setVisible(true);
        botonCancelar.setVisible(true);
        botonModificarAutor.setVisible(false);
        habilitar(true);
    }

    @FXML
    private void cancelar(ActionEvent event) {
        rellenar(vistaTabla.getSelectionModel().getSelectedItem());
        botonAplicar.setVisible(false);
        botonCancelar.setVisible(false);
        botonModificarAutor.setVisible(true);
    }

    // Clase local al controlador
    class AutorImagenCell extends TableCell<Autor, String> {

        private ImageView view = new ImageView();

        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            if (item == null || empty) {
                setText(null);
                setGraphic(null);
            } else {
                // Si está en la carpeta recursos, con el nombre sobra
                try {
                    view.setImage(new Image("" + item, 40, 40, false, true));
                    setGraphic(view);
                } catch (IllegalArgumentException e) {
                    setText(null);
                    setGraphic(null);
                }
                //view.setImage(item.getPathImagen());

                //setText(item.getNombre());
            }
        }
    }

    // Clase local al controlador
    class NacimientoCell extends TableCell<Autor, LocalDate> {

        //@Override
        protected void updateItem(Autor item, boolean empty) {
            //  super.updateItem(item, empty);
            if (item == null || empty) {
                setText(null);
            } else {
                setText(item.nacimientoProperty().get().toString());
            }
        }
    }

    private void habilitar(boolean valor) {
        dni.setEditable(valor);
        nombre.setEditable(valor);
        apellidos.setEditable(valor);
        nacimiento.setEditable(valor);
        rutaImagen.setEditable(valor);

    }

    @FXML
    private void addAccion(ActionEvent event) throws IOException {

        Button clickedButton = (Button) event.getSource();

        FXMLLoader miCargador = new FXMLLoader(getClass().getClassLoader().getResource("com/sequeros/autoreslibros/DatosAutor.fxml"));
        Parent root = miCargador.load();
        // acceso al controlador de datos persona
        DatosAutorController datosAutorController = miCargador.<DatosAutorController>getController();

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);

        Autor autor = new Autor("", "", "", null, "");

        datosAutorController.initAutor(autor); // pasa los datos al segundo controlador
        stage.setTitle("Añadir ==>> Autor");

        datosAutorController.initAutor(autor); // pasa los datos al segundo controlador
        // stage.show();
        stage.initModality(Modality.APPLICATION_MODAL); //la ventana se muestra modal
        stage.showAndWait(); // espera a que se cierre la segunda ventana.

        // Datos del controlador
        if (!datosAutorController.getCancelar()) {
            System.out.println("nacimiento: " + datosAutorController.getAutor().getNacimiento());
            if ((!datosAutorController.getAutor().getNombre().isEmpty())
                    && (datosAutorController.getAutor().getNombre().trim().length() != 0)
                    && (!datosAutorController.getAutor().getApellidos().isEmpty())
                    && (datosAutorController.getAutor().getApellidos().trim().length() != 0)
                    ) {
                if (clickedButton.getId().equals("botonAdd")) {
                    System.out.println("guardando");
                    misAutores.add(datosAutorController.getAutor());
                }
                vistaTabla.refresh();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Datos no válidos");
                alert.setContentText("Por favor, ingrese correctamente los datos");
                Optional<ButtonType> result = alert.showAndWait();
                datosAutorController.initAutor(datosAutorController.getAutor());
                //addAccion(event);
                stage.showAndWait();
            }
        }
    }
}
