/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.autores_sanaekassari;

import com.mycompany.autores_sanaekassari.Autor;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableCell;
import java.io.File;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sankas
 */
public class PrimaryController implements Initializable {

    private ObservableList<Autor> autores;

    @FXML
    private MenuItem salirOp;
    @FXML
    private MenuItem salirGrabandoOp;
    @FXML
    private MenuItem addOpcion;
    @FXML
    private MenuItem modificarOpcion;
    @FXML
    private MenuItem borrarOpcion;
    @FXML
    private TableView<Autor> tabla;
    @FXML
    private TableColumn<Autor, String> dniCol;
    @FXML
    private TableColumn<Autor, String> nombreCol;
    @FXML
    private TableColumn<Autor, String> apellidosCol;
    @FXML
    private TableColumn<Autor, String> nacimientoCol;
    @FXML
    private TableColumn<Autor, String> imagenCol;
    @FXML
    private TextField dni;
    @FXML
    private TextField nombre;
    @FXML
    private TextField apellidos;
    @FXML
    private TextField nacimiento;
    @FXML
    private TextField rutaImagen;
    @FXML
    private ImageView imagen;
    @FXML
    private Button btnAplicar;
    @FXML
    private Button btnCancelar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList<Autor> datos = new ArrayList<Autor>();
        datos.add(new Autor("12345678A", "Brandon", "Sanderson", "28/01/1980",
                "./src/main/resources/com/mycompany/autores_sanaekassari/foto1.jpeg"));
        datos.add(new Autor("23456789B", "Ana", "Gallego", "01/02/1980",
                "./src/main/resources/com/mycompany/autores_sanaekassari/foto2.jpeg"));

        dniCol.setCellValueFactory(new PropertyValueFactory<>("dni"));
        nombreCol.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        apellidosCol.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        nacimientoCol.setCellValueFactory(new PropertyValueFactory<>("nacimiento"));
        imagenCol.setCellFactory(columna -> {
            return new TableCell<Autor, String>() {
                private ImageView view = new ImageView();

                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setGraphic(null);
                    } else {
                        File imageFile = new File(item);
                        String fileLocation = imageFile.toURI().toString();
                        Image image = new Image(fileLocation, 40, 40, true, true);
                        view.setImage(image);
                        setGraphic(view);
                    }
                }
            };
        });
        autores = FXCollections.observableArrayList(datos);
        tabla.setItems(autores);

    }

    @FXML
    private void salir(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText("Vas a salir del programa");
        alert.setContentText("¿Seguro que quieres salir?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            System.out.println("OK");
            alert.close();
        } else {
            System.out.println("CANCEL");
        }
    }

    @FXML
    private void salirGrabando(ActionEvent event) {
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText("Vas a salir del programa");
        alert.setContentText("¿Seguro que quieres salir?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            System.out.println("OK");
            alert.close();
        } else {
            System.out.println("CANCEL");
        }
    }

    @FXML
    private void add(ActionEvent event) throws IOException {
        Button clickedButton = (Button) event.getSource();
        System.out.println(clickedButton.getId());

        FXMLLoader addOpcion = new FXMLLoader(getClass().getClassLoader().getResource("com/mycompany/autores_sanaekassari/addAutor.fxml"));
        Parent root = addOpcion.load();
        AddAutorController ControladorPersona = addOpcion.<AddAutorController>getController();

        Autor autor = new Autor("", "", "", "", "");
        ControladorPersona.initPersona(autor);
        Scene scene = new Scene(root, 500, 500);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Añadir Autor");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();


        if (!ControladorPersona.getCancelar()) {
            if ((!ControladorPersona.getPersona().getDni().isEmpty())
                    && (ControladorPersona.getPersona().getDni().trim().length() != 0)
                    && (!ControladorPersona.getPersona().getNombre().isEmpty())
                    && (ControladorPersona.getPersona().getNombre().trim().length() != 0)
                    && (!ControladorPersona.getPersona().getApellidos().isEmpty())
                    && (ControladorPersona.getPersona().getApellidos().trim().length() != 0)
                    && (!ControladorPersona.getPersona().getNacimiento().isEmpty())
                    && (ControladorPersona.getPersona().getNacimiento().trim().length() != 0)) {
                autores.add(ControladorPersona.getPersona());
                tabla.refresh();
            }
        }
        
    }

    @FXML
    private void modificar(ActionEvent event) {
        
    }

    @FXML
    private void borrar(ActionEvent event) {
        Autor selectedPerson=tabla.getSelectionModel().getSelectedItem();
        if(selectedPerson == null){
            return;
        }
        autores.remove(selectedPerson);
        tabla.refresh();
    }

    @FXML
    private void aplicar(ActionEvent event) {
    }
    
    public boolean validarDni(String dni){
          if (!dni.matches("\\d{8}[A-HJ-NP-TV-Z]")) {
            return false;
        }
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int numero = Integer.parseInt(dni.substring(0, 8));
        char letraEsperada = letras.charAt(numero % 23);
        char letraDNI = dni.charAt(8);
        return letraDNI == letraEsperada;
    }
    }


