import java.util.ArrayList;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class VistaListaControlador {

    private ObservableList<Persona> personas;

    @FXML
    private ListView<Persona> vistaLista;

    @FXML
    private TextField nombre;

    @FXML
    private TextField apellidos;

    @FXML
    private TextField correo;

    @FXML
    private TextField genero;

    @FXML
    private TextField fechaNacimiento;

    @FXML
    private TextField pais;

    @FXML
    private ImageView imagen;

    @FXML
    private Button botonBorrar;

    @FXML
    private Button botonModificar;

    @FXML
    private void initialize() {
        ArrayList<Persona> lista = Auxiliar.leerPersonas("Personas/Recursos/personal.csv");

        personas = FXCollections.observableArrayList(lista);
        vistaLista.setItems(personas);

        botonBorrar.setDisable(true);
        botonModificar.setDisable(true);

        vistaLista.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue != null) {
                mostrarPersona(newValue);
            } else {
                limpiarCampos();
            }
        });
    }

    private void mostrarPersona(Persona persona) {
        nombre.setText(persona.getNombre());
        apellidos.setText(persona.getApellido());
        correo.setText(persona.getEmail());
        genero.setText(persona.getGenero());
        fechaNacimiento.setText(persona.getNacimientoTexto());
        pais.setText(persona.getPais());
    }

    private void limpiarCampos() {
        nombre.clear();
        apellidos.clear();
        correo.clear();
        genero.clear();
        fechaNacimiento.clear();
        pais.clear();
        imagen.setImage(null);
    }

    @FXML
    private void addAccion() {
        System.out.println("Añadir pulsado");
    }

    @FXML
    private void borrarAccion() {
        Persona seleccionada = vistaLista.getSelectionModel().getSelectedItem();

        if (seleccionada != null) {
            personas.remove(seleccionada);
            limpiarCampos();
        }
    }

    @FXML
    private void modificarAccion() {
        System.out.println("Modificar pulsado");
    }

    @FXML
    private void cerrarAccion() {
        Platform.exit();
    }
}