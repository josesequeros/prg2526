/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros.jgpexamenordinarioej7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import static java.time.LocalDate.now;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
 * @author javgarper6
 */
public class VistaTablaControlador implements Initializable {

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
    private TableView<Persona> vistaTabla;
    @FXML
    private TableColumn<Persona, String> colGenero;
    @FXML
    private TableColumn<Persona, String> colNombre;
    @FXML
    private TableColumn<Persona, String> colApellidos;
    @FXML
    private TableColumn<Persona, String> colCorreo;
    @FXML
    private TableColumn<Persona, String> colImagen;
    
    @FXML
    private Button botonAdd;
    @FXML
    private Button botonBorrar;
    @FXML
    private Button botonModificar;
    @FXML
    private Button botonCerrar;
    @FXML
    private Button botonGuardar;
    @FXML
    private Button botonPais;

    private ObservableList<Persona> listaObservable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaObservable = FXCollections.observableArrayList();
        vistaTabla.setItems(listaObservable);

        ArrayList<Persona> personas = leerPersonas("personal.csv");
        listaObservable.addAll(personas);

        colGenero.setCellValueFactory(cellData -> cellData.getValue().GeneroProperty());
        /* Lo que saqué de los apuntes pero no funciona
        colGenero.setCellValueFactory(columna -> {
            return new TableCell<Persona, String>() {
                private ImageView view = new ImageView();
                @Override
                protected void updateItem(String iten, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setGraphic(null);
                    } else {
                        Image image = new Image(VistaTablaControlador.class.getResourceAsStream(item),
                            40, 40, true, true);
                    }
                    view.setImage(image);
                    setGraphic(view);
                }
            };
        }); */
        
        colNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        colApellidos.setCellValueFactory(new PropertyValueFactory<>("Apellidos"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("Email"));
        
        colImagen.setCellValueFactory(cellData -> cellData.getValue().PaisProperty());
        /*
        colImagen.setCellValueFactory(columna -> {
            return new TableCell<Persona, String>() {
                private ImageView view = new ImageView();
                @Override
                protected void updateItem(String iten, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setGraphic(null);
                    } else {
                        Image image = new Image(VistaTablaControlador.class.getResourceAsStream(item),
                            40, 40, true, true);
                    }
                    view.setImage(image);
                    setGraphic(view);
                }
            };
        }); */
        
        botonModificar.setDisable(true);
        botonBorrar.setDisable(true);
        botonPais.setDisable(true);

        vistaTabla.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            boolean sel = newSel != null;
            botonModificar.setDisable(!sel);
            botonBorrar.setDisable(!sel);
            botonPais.setDisable(!sel);

            if (sel) {
                mostrarDetalles(newSel);
            } else {
                limpiarDetalles();
            }
        });

        vistaTabla.focusedProperty().addListener((obs, oldFocus, newFocus) -> {
            botonAdd.setDisable(newFocus);
        });
    }

    private void mostrarDetalles(Persona persona) {
        nombre.setText(persona.getNombre());
        apellidos.setText(persona.getApellidos());
        correo.setText(persona.getEmail());
        genero.setText(persona.getGenero());
        pais.setText(persona.getPais());
        fechaNacimiento.setText(persona.getNacimientoString());
        cargarBandera(persona.getPais());
    }

    private void limpiarDetalles() {
        nombre.clear();
        apellidos.clear();
        correo.clear();
        genero.clear();
        pais.clear();
        fechaNacimiento.clear();
        imagen.setImage(null);
    }

    public static ArrayList<Persona> leerPersonas(String nomFich) {

        ArrayList<Persona> lista = new ArrayList<>();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        try (BufferedReader br = new BufferedReader(new FileReader(nomFich))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                try {
                    String[] datos = linea.split(",");

                    if (datos.length != 6) {
                        continue;
                    }
                    String nombre = datos[0].trim();
                    String apellidos = datos[1].trim();
                    String email = datos[2].trim();
                    String sexo = datos[3].trim();
                    LocalDate fechaNacimiento = LocalDate.parse(datos[4].trim(), formato);
                    String pais = datos[5].trim();

                    Persona p = new Persona(nombre, apellidos, email, sexo, fechaNacimiento, pais);
                    lista.add(p);

                } catch (DateTimeParseException e) {
                    System.out.println("Fecha invalida: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Excepcion: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.out.println("No se puede leer el fichero: " + e.getMessage());
        }

        return lista;
    }

    public static void grabarPersonas(String archivo, ArrayList<Persona> lista) {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {

            for (Persona p : lista) {
                String linea = p.getNombre() + ","
                        + p.getApellidos() + ","
                        + p.getEmail() + ","
                        + p.getGenero() + ","
                        + p.getNacimiento().format(formato) + ","
                        + p.getPais();

                bw.write(linea);
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error al guardar el fichero: " + e.getMessage());
        }
    }

    public ArrayList<Persona> personasPais(String pais) {

        ArrayList<Persona> resultado = new ArrayList<>();
        for (Persona p : this.listaObservable) {
            if (p.getPais().equals(pais)) {
                resultado.add(p);
            }
        }

        return resultado;
    }
    
    public ArrayList<Persona> personasNombre(String nombre) {

        ArrayList<Persona> resultado = new ArrayList<>();

        for (Persona p : listaObservable) {
            if (p.getNombre().equals(nombre)) {
                resultado.add(p);
            }
        }

        return resultado;
    }

    public ArrayList<Persona> personasCumple(int dia, int mes) {

        ArrayList<Persona> resultado = new ArrayList<>();

        for (Persona p : listaObservable) {
            LocalDate f = p.getNacimiento();

            if (f.getDayOfMonth() == dia && f.getMonthValue() == mes) {
                resultado.add(p);
            }
        }

        return resultado;
    }
    
    public ArrayList<Persona> personasMismaEdad(int edad) {

        ArrayList<Persona> resultado = new ArrayList<>();

        for (Persona p : listaObservable) {
            Period periodo = Period.between(p.getNacimiento(), now());
            int anyos = periodo.getYears();
            if (anyos == edad) {
                resultado.add(p);
            }
        }

        return resultado;
    }
    
    public void borrarPorApellido(String apellido) {

        for (Persona p : listaObservable) {
            if (p.getApellidos().equals(apellido)) {
                listaObservable.removeAll(); // por implementar. no usar ahora mismo
            }
        }
    }

    private void cargarBandera(String pais) {
        try {
            Image img = new Image(getClass().getResourceAsStream("/" + pais + ".png"));
            imagen.setImage(img);
        } catch (Exception e) {
            imagen.setImage(null);
        }
    }

    @FXML
    private void addAccion(ActionEvent event) throws Exception {
        mostrarVentanaDatos(null);
    }

    @FXML
    private void borrarAccion(ActionEvent event) {
        Persona seleccionada = vistaTabla.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            listaObservable.remove(seleccionada);
        }
    }
    
    @FXML
    private void paisAccion(ActionEvent event) throws Exception {
        mostrarVentanaPais("Brazil");
    }
    

    public void borrarPorEmail(String email) {

        Persona encontrada = null;

        for (Persona p : listaObservable) {
            if (p.getEmail().equalsIgnoreCase(email)) {
                encontrada = p;
                break;
            }
        }

        if (encontrada != null) {
            listaObservable.remove(encontrada);
        }
    }

    @FXML
    private void modificarAccion(ActionEvent event) throws Exception {
        Persona seleccionada = vistaTabla.getSelectionModel().getSelectedItem();

        if (seleccionada != null) {
            mostrarVentanaDatos(seleccionada);
        }
    }

    @FXML
    private void cerrarAccion(ActionEvent event) {
        Stage stage = (Stage) botonCerrar.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void guardarAccion(ActionEvent event) {
        ArrayList personas = new ArrayList(listaObservable);
        grabarPersonas("personal.csv",  personas);
    }
    

    private void mostrarVentanaDatos(Persona persona) {
        try {
            URL fxmlLocation = getClass().getResource("/com/sequeros/jgpexamenordinarioej7/DatosPersona.fxml");
            if (fxmlLocation == null) {
                System.out.println("No se encontró el FXML");
                return;
            }

            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            Parent root = loader.load();

            DatosPersonaControlador controlador = loader.getController();
            controlador.setListaObservable(listaObservable);
            controlador.setPersona(persona);

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void mostrarVentanaPais(String pais) {
        try {
            URL fxmlLocation = getClass().getResource("/com/sequeros/jgpexamenordinarioej7/PersonasPais.fxml");
            if (fxmlLocation == null) {
                System.out.println("No se encontró el FXML");
                return;
            }

            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            Parent root = loader.load();

            PersonasPaisControlador controlador = loader.getController();
            
            ObservableList<Persona> personasDePais = FXCollections.observableArrayList();
            personasDePais.addAll(personasPais(pais));
            System.out.println(personasDePais.size());
            
            controlador.setListaObservable(personasDePais);
            controlador.setPais("Brazil");
            controlador.sendValues();

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();

        } catch (IOException e) {
        }
    } 

}
