/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainControllalol;

/**
 *
 * @author pabbermor3
 */
public class MainControlalol {

}

    import javafx.collections.FXCollections;
    import javafx.collections.ObservableList;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
    import javafx.scene.Parent;
        import javafx.scene.Scene;
    import javafx.scene.control.*;
    import javafx.stage.Modality;
    import javafx.stage.Stage;
    import models.Persona;
    import java.io.*;
    import java.time.LocalDate;
    import java.util.ArrayList;

import java.util.Optional;

public class MainController {

    @FXML
    private ListView<Persona> listViewPersonas;
    @FXML
    private TextField txtNombre, txtApellidos, txtPais, txtEmail, txtFecha, txtGenero;
    @FXML
    private Button btnAñadir, btnModificar, btnBorrar, btnCerrar;

    private ObservableList<Persona> personas = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Carga los super datos
        personas.addAll(leerPersonas("personal.csv"));
        listViewPersonas.setItems(personas);

        listViewPersonas.setCellFactory(lv -> new PersonaListCell());

        // Listener de selección
        listViewPersonas.getSelectionModel().selectedItemProperty().addListener((obs, old, newValue) -> {
            mostrarDatosPersona(newValue);
            actualizarBotones();
        });

        actualizarBotones();
    }

    private void mostrarDatosPersona(Persona p) {
        if (p == null) {
            limpiarCampos();
            return;
        }
        txtNombre.setText(p.getNombre());
        txtApellidos.setText(p.getApellidos());
        txtPais.setText(p.getPais());
        txtEmail.setText(p.getEmail());
        txtFecha.setText(p.getFechaNacimientoStr());
        txtGenero.setText(p.getGenero());
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtApellidos.clear();
        txtPais.clear();
        txtEmail.clear();
        txtFecha.clear();
        txtGenero.clear();
    }

    private void actualizarBotones() {
        boolean haySeleccion = listViewPersonas.getSelectionModel().getSelectedItem() != null;
        btnModificar.setDisable(!haySeleccion);
        btnBorrar.setDisable(!haySeleccion);
    }

    
    private void añadirPersona() {
        abrirVentanaDatos(null);
    }

   
    private void modificarPersona() {
        Persona seleccionada = listViewPersonas.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            abrirVentanaDatos(seleccionada);
        }
    }

    private void abrirVentanaDatos(Persona persona) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/DatosPersona.fxml"));
            Parent root = loader.load();

            DatosPersonaController controller = loader.getController();
            controller.setPersona(persona, this);

            Stage stage = new Stage();
            stage.setTitle(persona == null ? "Añadiendo Persona" : "Modificando Persona");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void borrarPersona() {
        Persona seleccionada = listViewPersonas.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            personas.remove(seleccionada);
            grabarPersonas("personal.csv", new ArrayList<>(personas));
        }
    }

    @FXML
    private void cerrarAplicacion() {
        System.exit(0);
    }

 
    public static ArrayList<Persona> leerPersonas(String nomFich) {
        ArrayList<Persona> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nomFich))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    continue;
                }
                String[] datos = linea.split(",");
                if (datos.length >= 6) {
                    try {
                        LocalDate fecha = LocalDate.parse(datos[4], java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        Persona p = new Persona(datos[0], datos[1], datos[2], datos[3], fecha, datos[5]);
                        lista.add(p);
                    } catch (Exception e) {
                       
                    }
                }
            }
        } catch (Exception e) {
           
        }
        return lista;
    }

    public static void grabarPersonas(String archivo, ArrayList<Persona> lista) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (Persona p : lista) {
                pw.println(p.getNombre() + "," + p.getApellidos() + "," + p.getPais() + ","
                        + p.getEmail() + "," + p.getFechaNacimientoStr() + "," + p.getGenero());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Persona> personasPais(String pais) {
        ArrayList<Persona> result = new ArrayList<>();
        for (Persona p : personas) {
            if (p.getPais().equalsIgnoreCase(pais)) {
                result.add(p);
            }
        }
        return result;
    }

    public ArrayList<Persona> personasCumple(int dia, int mes) {
        ArrayList<Persona> result = new ArrayList<>();
        for (Persona p : personas) {
            if (p.getFechaNacimiento().getDayOfMonth() == dia
                    && p.getFechaNacimiento().getMonthValue() == mes) {
                result.add(p);
            }
        }
        return result;
    }

    public void borrarPorEmail(String email) {
        personas.removeIf(p -> p.getEmail().equalsIgnoreCase(email));
    }

    
    public void refreshList() {
        listViewPersonas.refresh();
        grabarPersonas("personal.csv", new ArrayList<>(personas));
    }
}
