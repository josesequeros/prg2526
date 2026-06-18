/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.joaquinparedesgomez;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class VistaListaControlador implements Initializable {

    @FXML
    private Label selectedItem;
    @FXML
    private TextField nombre;
    @FXML
    private TextField apellidos;
    @FXML
    private TextField correo;
    @FXML
    private TextField genero;
    @FXML
    private ImageView imagen;
    @FXML
    private TextField pais;
    @FXML
    private TextField fechaNacimiento;
    @FXML
    private Label etiqueta;
    @FXML
    private ListView<Persona> vistaLista;
    @FXML
    private Button botonAdd;
    @FXML
    private Button botonBorrar;
    @FXML
    private Button botonModificar;
    @FXML
    private Button botonCerrar;

    ObservableList<Persona> listaPersonas;

    Image imagenMale = null;
    Image imagenFemale = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        listaPersonas = FXCollections.observableArrayList(leerPersonas("personal.csv"));
        vistaLista.setItems(listaPersonas);

        try {
            imagenMale = new Image(getClass().getResourceAsStream("man.png"));
        } catch (Exception e) {
            System.out.println("Error al cargar imagen male: " + e.getMessage());
        }

        try {
            imagenFemale = new Image(getClass().getResourceAsStream("woman.png"));
        } catch (Exception e) {
            System.out.println("Error al cargar imagen female: " + e.getMessage());
        }

        vistaLista.setCellFactory(lv -> new ListCell<Persona>() {
            private final ImageView iv = new ImageView();

            {
                iv.setFitWidth(32);
                iv.setFitHeight(32);
                iv.setPreserveRatio(true);
                setGraphic(iv);
            }

            @Override
            protected void updateItem(Persona p, boolean empty) {
                super.updateItem(p, empty);
                if (empty || p == null) {
                    setText(null);
                    iv.setImage(null);
                } else {
                    setText(p.toString());
                    iv.setImage("Male".equalsIgnoreCase(p.getGenero()) ? imagenMale : imagenFemale);
                }
            }
        });

        vistaLista.getSelectionModel().selectedItemProperty()
                .addListener((obs, oldVal, newVal) -> {
                    if (newVal != null) {
                        nombre.setText(newVal.getNombre());
                        apellidos.setText(newVal.getApellidos());
                        correo.setText(newVal.getCorreo());
                        genero.setText(newVal.getGenero());
                        pais.setText(newVal.getPais());
                        fechaNacimiento.setText(newVal.getFechaNacimiento() != null
                                ? newVal.getFechaNacimiento().format(Persona.FORMATO_DISPLAY) : "");
                        cargarBandera(newVal.getPais());
                    } else {
                        nombre.setText("");
                        apellidos.setText("");
                        correo.setText("");
                        genero.setText("");
                        pais.setText("");
                        fechaNacimiento.setText("");
                        imagen.setImage(null);
                    }
                });

        nombre.setEditable(false);
        apellidos.setEditable(false);
        correo.setEditable(false);
        genero.setEditable(false);
        pais.setEditable(false);
        fechaNacimiento.setEditable(false);

        botonAdd.disableProperty().bind(vistaLista.focusedProperty());

        botonBorrar.disableProperty().bind(
                vistaLista.getSelectionModel().selectedItemProperty().isNull());

        botonModificar.disableProperty().bind(
                vistaLista.getSelectionModel().selectedItemProperty().isNull());

    }

    @FXML
    private void addAccion(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DatosPersona.fxml"));
            Scene scene = new Scene(loader.load());
            DatosPersonaControlador ctrl = loader.getController();
            ctrl.setModo(null, listaPersonas);
            Stage stage = new Stage();
            stage.setTitle("Añadir Persona");
            stage.setScene(scene);
            stage.showAndWait();
            vistaLista.refresh();
        } catch (Exception e) {
            System.out.println("Error al abrir ventana: " + e.getMessage());
        }
    }

    @FXML
    private void borrarAccion(ActionEvent event) {

        Persona seleccionada = vistaLista.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            listaPersonas.remove(seleccionada);
            grabarPersonas("personal.csv", new ArrayList<>(listaPersonas));
        }

    }

    @FXML
    private void modificarAccion(ActionEvent event) {
        Persona seleccionada = vistaLista.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("DatosPersona.fxml"));
                Scene scene = new Scene(loader.load());
                DatosPersonaControlador ctrl = loader.getController();
                ctrl.setModo(seleccionada, listaPersonas);
                Stage stage = new Stage();
                stage.setTitle("Modificar Persona");
                stage.setScene(scene);
                stage.showAndWait();
                vistaLista.refresh();
            } catch (Exception e) {
                System.out.println("Error al abrir ventana: " + e.getMessage());
            }
        }
    }

    @FXML
    private void cerrarAccion(ActionEvent event) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Confirmación");
        alerta.setHeaderText("¿Seguro que quieres salir?");
        alerta.setContentText("Los cambios no guardados se perderán.");
        Optional<ButtonType> result = alerta.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            grabarPersonas("personal.csv", new ArrayList<>(listaPersonas));
            Platform.exit();
        }
    }

    public static ArrayList<Persona> leerPersonas(String nomFich) {
        ArrayList<Persona> lista = new ArrayList<>();
        try {

            InputStream is = new FileInputStream(new File(nomFich));
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] p = linea.split(",");
                if (p.length >= 6) {
                    try {
                        LocalDate fecha = LocalDate.parse(p[4].trim(), Persona.FORMATO_CSV);
                        lista.add(new Persona(p[0].trim(), p[1].trim(), p[2].trim(),
                                p[3].trim(), fecha, p[5].trim()));
                    } catch (Exception e) {
                        System.out.println("Error con la fecha: " + e.getMessage());
                    }
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error al cargar el fichero: " + e.getMessage());
        }
        return lista;
    }

    private void cargarBandera(String pais) {
        try {
            InputStream is = getClass().getResourceAsStream("banderas/" + pais + ".png");
            if (is != null) {
                imagen.setImage(new Image(is));
            } else {
                imagen.setImage(null);
            }
        } catch (Exception e) {
            imagen.setImage(null);
        }
    }

    public static void grabarPersonas(String archivo, ArrayList<Persona> lista) {
    try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
        for (Persona p : lista) {
            String fecha = p.getFechaNacimiento() != null
                    ? p.getFechaNacimiento().format(Persona.FORMATO_CSV) : "";
            pw.println(p.getNombre() + "," + p.getApellidos() + "," + p.getCorreo()
                     + "," + p.getGenero() + "," + fecha + "," + p.getPais());
        }
    } catch (Exception e) {
        System.out.println("Error al guardar: " + e.getMessage());
    }
}
    
}
