package com.sequeros.simeonexamen;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PrimaryController {

    private static final String FICHERO = "personal.csv";

    @FXML private ListView<Persona> listaView;
    @FXML private TextField txtNombre;
    @FXML private TextField txtApellidos;
    @FXML private TextField txtCorreo;
    @FXML private TextField txtGenero;
    @FXML private TextField txtNacimiento;
    @FXML private TextField txtPais;
    @FXML private ImageView imgBandera;
    @FXML private Button btnAnyadir;
    @FXML private Button btnBorrar;
    @FXML private Button btnModificar;
    @FXML private Button btnCerrar;

    private ObservableList<Persona> listaPersonas;

    @FXML
    public void initialize() {
        ArrayList<Persona> datos = Utilidades.leerPersonas(FICHERO);
        listaPersonas = FXCollections.observableArrayList(datos);
        listaView.setItems(listaPersonas);

        listaView.setCellFactory(lv -> new ListCell<Persona>() {
            private final ImageView icono = new ImageView();
            @Override
            protected void updateItem(Persona p, boolean empty) {
                super.updateItem(p, empty);
                if (empty || p == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    try {
                        String img = "male.png";
                        if (p.getGenero() != null && p.getGenero().equalsIgnoreCase("Female")) {
                            img = "female.png";
                        }
                        File f = new File(img);
                        if (f.exists()) {
                            icono.setImage(new Image(f.toURI().toString(), 40, 40, true, true));
                            setGraphic(icono);
                        } else {
                            setGraphic(null);
                        }
                    } catch (Exception e) {
                        setGraphic(null);
                    }
                    setText(p.getApellidos() + ", " + p.getNombre() + " - " + p.getPais());
                }
            }
        });

        listaView.getSelectionModel().selectedItemProperty().addListener(
                (obs, vieja, nueva) -> mostrarPersona(nueva));

        ponerSoloLectura();

        BooleanBinding sinSeleccion = Bindings.equal(-1,
                listaView.getSelectionModel().selectedIndexProperty());
        btnBorrar.disableProperty().bind(sinSeleccion);
        btnModificar.disableProperty().bind(sinSeleccion);
    }

    private void mostrarPersona(Persona p) {
        if (p == null) {
            txtNombre.clear();
            txtApellidos.clear();
            txtCorreo.clear();
            txtGenero.clear();
            txtNacimiento.clear();
            txtPais.clear();
            imgBandera.setImage(null);
            return;
        }
        txtNombre.setText(p.getNombre());
        txtApellidos.setText(p.getApellidos());
        txtCorreo.setText(p.getCorreo());
        txtGenero.setText(p.getGenero());
        if (p.getNacimiento() != null) {
            txtNacimiento.setText(p.getNacimiento().format(Utilidades.FORMATO_FECHA));
        } else {
            txtNacimiento.clear();
        }
        txtPais.setText(p.getPais());
        cargarBandera(p.getPais());
    }

    private void cargarBandera(String pais) {
        try {
            if (pais == null || pais.trim().isEmpty()) {
                imgBandera.setImage(null);
                return;
            }
            File f = new File(pais + ".png");
            if (f.exists()) {
                imgBandera.setImage(new Image(f.toURI().toString(), 60, 40, true, true));
            } else {
                imgBandera.setImage(null);
            }
        } catch (Exception e) {
            imgBandera.setImage(null);
        }
    }

    private void ponerSoloLectura() {
        txtNombre.setEditable(false);
        txtApellidos.setEditable(false);
        txtCorreo.setEditable(false);
        txtGenero.setEditable(false);
        txtNacimiento.setEditable(false);
        txtPais.setEditable(false);
    }

    @FXML
    private void anyadir() {
        try {
            FXMLLoader cargador = new FXMLLoader(App.class.getResource("DatosPersona.fxml"));
            Parent raiz = cargador.load();
            DatosPersonaController ctrl = cargador.getController();
            ArrayList<String> correos = new ArrayList<>();
            for (Persona p : listaPersonas) {
                correos.add(p.getCorreo());
            }
            ctrl.setCorreosExistentes(correos);

            Stage ventana = new Stage();
            ventana.setTitle("Añadir Persona");
            ventana.setScene(new Scene(raiz));
            ventana.initModality(Modality.APPLICATION_MODAL);
            ventana.showAndWait();

            Persona nueva = ctrl.getPersonaCreada();
            if (nueva != null) {
                listaPersonas.add(nueva);
            }
        } catch (IOException e) {
            mostrarError("Error", "No se pudo abrir la ventana: " + e.getMessage());
        }
    }

    @FXML
    private void borrar() {
        Persona sel = listaView.getSelectionModel().getSelectedItem();
        if (sel == null) return;
        listaPersonas.remove(sel);
    }

    @FXML
    private void modificar() {
        Persona sel = listaView.getSelectionModel().getSelectedItem();
        if (sel == null) return;
        try {
            FXMLLoader cargador = new FXMLLoader(App.class.getResource("DatosPersona.fxml"));
            Parent raiz = cargador.load();
            DatosPersonaController ctrl = cargador.getController();
            ArrayList<String> correos = new ArrayList<>();
            for (Persona p : listaPersonas) {
                if (p != sel) correos.add(p.getCorreo());
            }
            ctrl.setCorreosExistentes(correos);
            ctrl.setPersona(sel);

            Stage ventana = new Stage();
            ventana.setTitle("Modificar Persona");
            ventana.setScene(new Scene(raiz));
            ventana.initModality(Modality.APPLICATION_MODAL);
            ventana.showAndWait();

            Persona modificada = ctrl.getPersonaCreada();
            if (modificada != null) {
                sel.setNombre(modificada.getNombre());
                sel.setApellidos(modificada.getApellidos());
                sel.setCorreo(modificada.getCorreo());
                sel.setGenero(modificada.getGenero());
                sel.setNacimiento(modificada.getNacimiento());
                sel.setPais(modificada.getPais());
                listaView.refresh();
                mostrarPersona(sel);
            }
        } catch (IOException e) {
            mostrarError("Error", "No se pudo abrir la ventana: " + e.getMessage());
        }
    }

    @FXML
    private void cerrar() {
        ArrayList<Persona> guardar = new ArrayList<>(listaPersonas);
        Utilidades.grabarPersonas(FICHERO, guardar);
        javafx.application.Platform.exit();
    }

    public ArrayList<Persona> personasPais(String pais) {
        ArrayList<Persona> result = new ArrayList<>();
        for (Persona p : listaPersonas) {
            if (p.getPais() != null && p.getPais().equalsIgnoreCase(pais)) {
                result.add(p);
            }
        }
        return result;
    }

    public ArrayList<Persona> personasCumple(int dia, int mes) {
        ArrayList<Persona> result = new ArrayList<>();
        for (Persona p : listaPersonas) {
            LocalDate f = p.getNacimiento();
            if (f != null && f.getDayOfMonth() == dia && f.getMonthValue() == mes) {
                result.add(p);
            }
        }
        return result;
    }

    public void borrarPorEmail(String email) {
        for (int i = 0; i < listaPersonas.size(); i++) {
            if (listaPersonas.get(i).getCorreo().equalsIgnoreCase(email)) {
                listaPersonas.remove(i);
            }
        }
    }

    private void mostrarError(String cabecera, String mensaje) {
        Alert a = new Alert(AlertType.ERROR);
        a.setTitle("Error");
        a.setHeaderText(cabecera);
        a.setContentText(mensaje);
        a.showAndWait();
    }
}
