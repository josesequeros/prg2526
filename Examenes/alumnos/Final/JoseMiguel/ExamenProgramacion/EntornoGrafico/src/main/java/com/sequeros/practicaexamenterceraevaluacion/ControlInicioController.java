/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros.practicaexamenterceraevaluacion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class ControlInicioController implements Initializable {

    private static final String FILE_NAME = "personal.csv";
    private static final String IMG_FOLDER = "";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    @FXML
    private MenuItem menuExit;
    @FXML
    private MenuItem ExitMenuGuart;
    @FXML
    private MenuItem menuAnyadir;
    @FXML
    private MenuItem menuModificar;
    @FXML
    private MenuItem menuBorrar;

    @FXML
    private Button addButton;
    @FXML
    private Button delButton;
    @FXML
    private Button salirGrabandoButton;

    @FXML
    private TableView<Persona> tableGeneral;
    @FXML
    private TableColumn<Persona, String> nameColum;
    @FXML
    private TableColumn<Persona, String> subColum;
    @FXML
    private TableColumn<Persona, String> dateColum;
    @FXML
    private TableColumn<Persona, String> generoColum;
    @FXML
    private TableColumn<Persona, String> paisColum;
    @FXML
    private TableColumn<Persona, String> bandColum;
     @FXML
    private TableColumn<Persona, String> emailColum;

    
    @FXML
    private ImageView bandPreview;
    @FXML
    private TextField nameField;
    @FXML
    private TextField subField;
    @FXML
    private TextField dateField;
    @FXML
    private TextField generoField;
    @FXML
    private TextField paisField;

    @FXML
    private Button modificarButton;
    @FXML
    private Button aplicarButton;
    @FXML
    private Button cancelarButton;
    /**
     * Initializes the controller class.
     */

    private ObservableList<Persona> lista;
    private Persona personaOriginalBackup;
   
    @FXML
    private TextField emailField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // 1. cargar datos del fichero
        lista = FXCollections.observableArrayList(leerPersonas(FILE_NAME));

        // 2. conectar lista con la tabla
        tableGeneral.setItems(lista);

        // 3. enlazar columnas con getters del modelo
        emailColum.setCellValueFactory(new PropertyValueFactory<>("email"));
        nameColum.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        subColum.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        dateColum.setCellValueFactory(new PropertyValueFactory<>("nacimiento"));
        paisColum.setCellValueFactory(new PropertyValueFactory<>("pais"));

        // ── generoColum: imagen man.png / woman.png según "H" o "M" ──────────
        generoColum.setCellValueFactory(new PropertyValueFactory<>("genero"));
        generoColum.setCellFactory(col -> new TableCell<Persona, String>() {
            private final ImageView iv = new ImageView();

            {
                iv.setFitWidth(40);
                iv.setFitHeight(40);
                iv.setPreserveRatio(true);
            }

            @Override
            protected void updateItem(String genero, boolean empty) {
                super.updateItem(genero, empty);
                if (empty || genero == null || genero.isEmpty()) {
                    setGraphic(null);
                    return;
                }
                String fichero;
                if (genero.equalsIgnoreCase("Male")) {
                    fichero = "man.png";
                } else if (genero.equalsIgnoreCase("Female")) {
                    fichero = "woman.png";
                } else {
                    fichero = null;
                }
                if (fichero != null) {
                    File f = new File(IMG_FOLDER + fichero);
                    if (f.exists()) {
                        try {
                            iv.setImage(new Image(f.toURI().toString()));
                            setGraphic(iv);
                        } catch (Exception e) {
                            setGraphic(null);
                        }
                    } else {
                        setGraphic(null);
                    }
                }
            }
        });
        
        // ── bandColum: imagen de la bandera (fichero = pais + ".png") ─────────
        bandColum.setCellValueFactory(new PropertyValueFactory<>("pais"));
        bandColum.setCellFactory(col -> new TableCell<Persona, String>() {
            private final ImageView iv = new ImageView();

            {
                iv.setFitWidth(60);
                iv.setFitHeight(40);
                iv.setPreserveRatio(true);
            }

            @Override
            protected void updateItem(String pais, boolean empty) {
                super.updateItem(pais, empty);
                if (empty || pais == null || pais.isEmpty()) {
                    setGraphic(null);
                    return;
                }
                File f = new File(IMG_FOLDER + pais + ".png");
                if (f.exists()) {
                    try {
                        iv.setImage(new Image(f.toURI().toString()));
                        setGraphic(iv);
                    } catch (Exception e) {
                        setGraphic(null);
                    }
                } else {
                    setGraphic(null);
                }
            }
        });
        
        // 4. campos en solo lectura por defecto
        setFieldsEditable(false);
        
        // 5. estado inicial de botones
        delButton.setDisable(true);

        if (modificarButton != null) {
            modificarButton.setDisable(true);
        }
        if (aplicarButton != null) {
            aplicarButton.setVisible(false);
        }
        if (cancelarButton != null) {
            cancelarButton.setVisible(false);
        }
        if (menuModificar != null) {
            menuModificar.setDisable(true);
        }
        if (menuBorrar != null) {
            menuBorrar.setDisable(true);
        }
        
        // 6. listener de selección
        // EXAMEN: se ejecuta cada vez que el usuario hace clic en una fila distinta
        tableGeneral.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        mostrarDatosPersona(newValue);
                        delButton.setDisable(false);
                        if (modificarButton != null) {
                            modificarButton.setDisable(false);
                        }
                        if (menuModificar != null) {
                            menuModificar.setDisable(false);
                        }
                        if (menuBorrar != null) {
                            menuBorrar.setDisable(false);
                        }
                    }else {
                        clearFields();
                        delButton.setDisable(true);
                        if (modificarButton != null) {
                            modificarButton.setDisable(true);
                        }
                        if (menuModificar != null) {
                            menuModificar.setDisable(true);
                        }
                        if (menuBorrar != null) {
                            menuBorrar.setDisable(true);
                        }
                    }
                });
    }

    @FXML
    private void handleSalir(ActionEvent event) {
        if (pedirConfirmacionSalir()) {
            Platform.exit();
        }
    }

    @FXML
    private void handleSalirGrabando(ActionEvent event) {
         if (pedirConfirmacionSalir()) {
            grabarAutores(FILE_NAME, new ArrayList<>(lista));
            Platform.exit();
        }
    }

    @FXML
    private void handleAnyadir(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddAutor.fxml"));
            Parent root = loader.load();
            AddAutorController ctrl = loader.getController();
            ctrl.setListaPersonas(lista);
            Stage stage = new Stage();
            stage.setTitle("Añadir Persona");
            stage.setScene(new Scene(root, 450, 380));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            mostrarError("Error", "No se pudo abrir la ventana de añadir", e.getMessage());
        }
    }

    @FXML
    private void handleModificar(ActionEvent event) {
        Persona seleccionado = tableGeneral.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            return;
        }
        // guardar copia para restaurar si se pulsa Cancelar
        personaOriginalBackup = new Persona(
                seleccionado.getNombre(), seleccionado.getApellidos(),seleccionado.getEmail(),
                seleccionado.getGenero(),seleccionado.getNacimiento(),  seleccionado.getPais()
        );
        
        setFieldsEditable(true);
         if (modificarButton != null) {
            modificarButton.setVisible(false);
        }
        if (aplicarButton != null) {
            aplicarButton.setVisible(true);
        }
        if (cancelarButton != null) {
            cancelarButton.setVisible(true);
        }
        addButton.setDisable(true);
        delButton.setDisable(true);
    }

    @FXML
    private void handleBorrar(ActionEvent event) {
        Persona seleccionado = tableGeneral.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            lista.remove(seleccionado);
            clearFields();
        }
    }

    @FXML
    private void handleAplicar(ActionEvent event) {
         if (!validarCampos()) {
            return;
        }

        Persona seleccionado = tableGeneral.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            return;
        }

        String nuevoEmail = emailField.getText().trim().toUpperCase();
        for (Persona a : lista) {
            if (a != seleccionado && a.getEmail().equalsIgnoreCase(nuevoEmail)) {
                mostrarError("Email duplicado", "Ya existe ese Email",
                        "Ya hay una ersona con el Email " + nuevoEmail + ". Introduce otro.");
                return;
            }
        }

        try {
            LocalDate fecha = LocalDate.parse(dateField.getText().trim(), FORMATTER);
            seleccionado.setEmail(nuevoEmail);
            seleccionado.setNombre(nameField.getText().trim());
            seleccionado.setApellidos(subField.getText().trim());
            seleccionado.setNacimiento(fecha);
            seleccionado.setGenero(generoField != null ? generoField.getText().trim().toUpperCase() : "");
            seleccionado.setPais(paisField != null ? paisField.getText().trim() : "");
            tableGeneral.refresh();
            finalizarEdicion();
        } catch (DateTimeParseException e) {
            mostrarError("Error de fecha", "Error al analizar la fecha",
                    "Por favor, ingrese una fecha válida en el formato DD/MM/YYYY.");
        }
    }
    private void finalizarEdicion() {
        setFieldsEditable(false);
        if (modificarButton != null) {
            modificarButton.setVisible(true);
        }
        if (aplicarButton != null) {
            aplicarButton.setVisible(false);
        }
        if (cancelarButton != null) {
            cancelarButton.setVisible(false);
        }
        addButton.setDisable(false);
        delButton.setDisable(tableGeneral.getSelectionModel().getSelectedItem() == null);
        personaOriginalBackup = null;
    }

    @FXML
    private void handleCancelar(ActionEvent event) {
        if (personaOriginalBackup != null) {
            mostrarDatosPersona(personaOriginalBackup);
        }
        finalizarEdicion();
    }

    public boolean pedirConfirmacionSalir() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ExitView.fxml"));
            Parent root = loader.load();
            ExitViewController ctrl = loader.getController();
            Stage stage = new Stage();
            stage.setTitle("Salir");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
            return ctrl.isConfirmed();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmación");
            alert.setHeaderText("Vas a salir del programa");
            alert.setContentText("¿Seguro que quieres salir?");
            Optional<ButtonType> result = alert.showAndWait();
            return result.isPresent() && result.get() == ButtonType.OK;
        }
    }

    public static ArrayList<Persona> leerPersonas(String nomFich) {
        ArrayList<Persona> result = new ArrayList<>();
        File file = new File(nomFich);
        if (!file.exists()) {
            return result;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] p = linea.split(",", -1);
                if (p.length >= 4) {
                    LocalDate fecha = LocalDate.parse(p[4], FORMATTER);
                    String genero = p[3];
                    String pais = p[5];
                    result.add(new Persona(p[0], p[1], p[2], genero, fecha, pais));
                    //new Autor(p[0], p[1], p[2], fecha, genero, pais)
                }
            }
        } catch (Exception e) {
            /* línea malformada → ignorar */ }
        return result;
    }
     private void setFieldsEditable(boolean editable) {
        
        nameField.setEditable(editable);
        subField.setEditable(editable);
        dateField.setEditable(editable);
        if (generoField != null) {
            generoField.setEditable(editable);
        }
        if (paisField != null) {
            paisField.setEditable(editable);
        }

    }
        private boolean validarFecha() {
        try {
            LocalDate.parse(dateField.getText().trim(), FORMATTER);
        } catch (DateTimeParseException e) {
            mostrarError("Error de fecha", "Error al analizar la fecha",
                    "Por favor, ingrese una fecha válida en el formato DD/MM/YYYY.");
            return false;
        }
        return true;
    } 
    private void mostrarError(String titulo, String header, String contenido) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
    public static boolean validarDni(String dni) {
        if (dni == null || dni.length() < 2) {
            return false;
        }
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        try {
            String numStr = dni.substring(0, dni.length() - 1);
            char letraIntroducida = Character.toUpperCase(dni.charAt(dni.length() - 1));
            int numero = Integer.parseInt(numStr);
            char letraCorrecta = letras.charAt(numero % 23);
            return letraCorrecta == letraIntroducida;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static void grabarAutores(String archivo, ArrayList<Persona> lista) {
           try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (Persona a : lista) {
                pw.println(
                    
                    a.getNombre()    + "," +
                    a.getApellidos() + "," +
                    a.getEmail()+ "," +
                    (a.getGenero()     != null ? a.getGenero()     : "") + "," +
                    (a.getNacimiento() != null ? FORMATTER.format(a.getNacimiento()) : "") + "," +
                    (a.getPais()       != null ? a.getPais()       : "")
                );
            }
        } catch (IOException e) { /* error de escritura → ignorar */ }
    }
    private void clearFields() {
        emailField.clear();
        nameField.clear();
        subField.clear();
        dateField.clear();
        if (generoField != null) {
            generoField.clear();
        }
        if (paisField != null) {
            paisField.clear();
        }
        if (bandPreview != null) {
            bandPreview.setImage(null);
        }
    }
    private void mostrarDatosPersona(Persona a) {
        emailField.setText(a.getEmail());
        nameField.setText(a.getNombre());
        subField.setText(a.getApellidos());
        dateField.setText(a.getNacimiento() != null ? FORMATTER.format(a.getNacimiento()) : "");
        if (generoField != null) {
            generoField.setText(a.getGenero() != null ? a.getGenero() : "");
        }
        if (paisField != null) {
            paisField.setText(a.getPais() != null ? a.getPais() : "");
        }
        cargarBandera(a.getPais());
    }
    private void cargarBandera(String pais) {
        if (bandPreview == null) {
            return;
        }
        if (pais != null && !pais.isEmpty()) {
            try {
                File f = new File(IMG_FOLDER + pais + ".png");
                bandPreview.setImage(f.exists() ? new Image(f.toURI().toString()) : null);
            } catch (Exception e) {
                bandPreview.setImage(null);
            }
        } else {
            bandPreview.setImage(null);
        }
    }
    private boolean validarCampos() {
        if (emailField.getText().trim().isEmpty() || nameField.getText().trim().isEmpty()
                || subField.getText().trim().isEmpty() || dateField.getText().trim().isEmpty()) {
            mostrarError("Campos vacíos", "Error de validación", "No puede haber campos vacíos.");
            return false;
        }
        try {
            LocalDate.parse(dateField.getText().trim(), FORMATTER);
        } catch (DateTimeParseException e) {
            mostrarError("Error de fecha", "Error al analizar la fecha",
                    "Por favor, ingrese una fecha válida en el formato DD/MM/YYYY.");
            return false;
        }
        return true;
    }
}
