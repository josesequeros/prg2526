package com.mycompany.persona;

import com.mycompany.persona.Autor;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Optional;
import javafx.scene.image.Image;

public class AutoresController {

    @FXML private TableView<Autor> tablaAutores;
    @FXML private TableColumn<Autor, String> colDni, colNombre, colApellidos, colImagen, colPais;
    @FXML private TableColumn<Autor, LocalDate> colNacimiento;

    @FXML private TextField txtDni, txtNombre, txtApellidos, txtNacimiento, txtImagen;
    @FXML private Button btnAnadir, btnBorrar, btnModificar, btnAplicar, btnCancelar;

    private ObservableList<Autor> listaObservableAutores;
    private final String ARCHIVO = "autores.dat";
    private boolean modoModificar = false;

    @FXML
    public void initialize() {
        // Configurar columnas
        colDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        colNacimiento.setCellValueFactory(new PropertyValueFactory<>("nacimiento"));
        colImagen.setCellValueFactory(new PropertyValueFactory<>("imagen"));

        // Cargar datos
        ArrayList<Autor> datos = leerAutores(ARCHIVO);
        if (datos.isEmpty()) {
            // Requisito: El primer autor debe ser el alumno. 
            // Fecha aproximada por defecto ajustada a tu contexto.
            datos.add(new Autor("12345678Z", "TuNombre", "TuApellido", LocalDate.of(2002, 5, 20), "perfil.jpg"));
        }
        
        listaObservableAutores = FXCollections.observableArrayList(datos);
        tablaAutores.setItems(listaObservableAutores);

        // Listener para la selección de la tabla (Solo lectura al seleccionar)
        tablaAutores.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null && !modoModificar) {
                mostrarDatos(newSelection);
                btnBorrar.setDisable(false);
                btnModificar.setDisable(false);
            } else if (newSelection == null) {
                btnBorrar.setDisable(true);
                btnModificar.setDisable(true);
            }
        });

        // Estado inicial de botones
        btnBorrar.setDisable(true);
        btnModificar.setDisable(true);
        btnAplicar.setDisable(true);
        btnCancelar.setDisable(true);
        habilitarCampos(false);
    }

    private void mostrarDatos(Autor autor) {
        txtDni.setText(autor.getDni());
        txtNombre.setText(autor.getNombre());
        txtApellidos.setText(autor.getApellidos());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        txtNacimiento.setText(autor.getNacimiento().format(formatter));
        txtImagen.setText(autor.getImagen());
    }

    private void habilitarCampos(boolean habilitar) {
        txtDni.setEditable(habilitar);
        txtNombre.setEditable(habilitar);
        txtApellidos.setEditable(habilitar);
        txtNacimiento.setEditable(habilitar);
        txtImagen.setEditable(habilitar);
    }

    private void limpiarCampos() {
        txtDni.clear();
        txtNombre.clear();
        txtApellidos.clear();
        txtNacimiento.clear();
        txtImagen.clear();
    }

    @FXML
    private void onAnadir(ActionEvent event) {
        limpiarCampos();
        habilitarCampos(true);
        tablaAutores.getSelectionModel().clearSelection();
        btnAplicar.setDisable(false);
        btnCancelar.setDisable(false);
        btnAnadir.setDisable(true);
        btnModificar.setDisable(true);
        modoModificar = false;
    }

    @FXML
    private void onModificar(ActionEvent event) {
        if (tablaAutores.getSelectionModel().getSelectedItem() != null) {
            habilitarCampos(true);
            txtDni.setEditable(false); // El DNI no se suele modificar
            btnAplicar.setDisable(false);
            btnCancelar.setDisable(false);
            btnModificar.setDisable(true);
            btnAnadir.setDisable(true);
            modoModificar = true;
        }
    }

    @FXML
    private void onAplicar(ActionEvent event) {
        if (!validarCampos()) return;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse(txtNacimiento.getText(), formatter);

        if (modoModificar) {
            Autor seleccionado = tablaAutores.getSelectionModel().getSelectedItem();
            seleccionado.setNombre(txtNombre.getText());
            seleccionado.setApellidos(txtApellidos.getText());
            seleccionado.setNacimiento(fecha);
            seleccionado.setImagen(txtImagen.getText());
            tablaAutores.refresh();
        } else {
            // Comprobar DNI duplicado
            boolean duplicado = listaObservableAutores.stream()
                    .anyMatch(a -> a.getDni().equalsIgnoreCase(txtDni.getText()));
            if (duplicado) {
                mostrarError("El DNI introducido ya existe en la lista.");
                return;
            }
            Autor nuevo = new Autor(txtDni.getText(), txtNombre.getText(), txtApellidos.getText(), fecha, txtImagen.getText());
            listaObservableAutores.add(nuevo);
        }

        finalizarEdicion();
    }

    @FXML
    private void onCancelar(ActionEvent event) {
        finalizarEdicion();
        Autor seleccionado = tablaAutores.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            mostrarDatos(seleccionado);
        } else {
            limpiarCampos();
        }
    }

    private void finalizarEdicion() {
        habilitarCampos(false);
        btnAplicar.setDisable(true);
        btnCancelar.setDisable(true);
        btnAnadir.setDisable(false);
        modoModificar = false;
        if (tablaAutores.getSelectionModel().getSelectedItem() != null) {
            btnModificar.setDisable(false);
        }
    }

    @FXML
    private void onBorrar(ActionEvent event) {
        Autor seleccionado = tablaAutores.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            listaObservableAutores.remove(seleccionado);
            limpiarCampos();
        }
    }

    @FXML
    private void onSalirGrabando(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Salir");
        alert.setHeaderText("Vas a salir del programa");
        alert.setContentText("¿Estás seguro de que deseas salir y guardar los cambios?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            grabarAutores(ARCHIVO, new ArrayList<>(listaObservableAutores));
            Platform.exit();
        }
    }

    // --- Métodos obligatorios del examen ---

    public static ArrayList<Autor> leerAutores(String nomFich) {
        ArrayList<Autor> lista = new ArrayList<>();
        File file = new File(nomFich);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                lista = (ArrayList<Autor>) ois.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return lista;
    }

    public static void grabarAutores(String archivo, ArrayList<Autor> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean validarLetraNIF(String dni) {
        if (!dni.matches("\\d{8}[A-Za-z]")) return false;
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int numero = Integer.parseInt(dni.substring(0, 8));
        char letraCalculada = letras.charAt(numero % 23);
        char letraIntroducida = Character.toUpperCase(dni.charAt(8));
        return letraCalculada == letraIntroducida;
    }

    private boolean validarCampos() {
        if (txtDni.getText().isEmpty() || txtNombre.getText().isEmpty() || 
            txtApellidos.getText().isEmpty() || txtNacimiento.getText().isEmpty()) {
            mostrarError("No puede haber campos vacíos.");
            return false;
        }

        if (!validarLetraNIF(txtDni.getText())) {
            mostrarError("El DNI no tiene una letra válida.");
            return false;
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate.parse(txtNacimiento.getText(), formatter);
        } catch (DateTimeParseException e) {
            mostrarError("Por favor, ingrese una fecha válida en el formato DD/MM/YYYY");
            return false;
        }

        return true;
    }
     

    private void mostrarError(String mensaje) {
    Alert alerta = new Alert(Alert.AlertType.ERROR);
    alerta.setTitle("Error");
    alerta.setHeaderText("Datos incorrectos");
    alerta.setContentText("El nombre y/o los apellidos no pueden estar vacíos");
    alerta.showAndWait();

    }
}
