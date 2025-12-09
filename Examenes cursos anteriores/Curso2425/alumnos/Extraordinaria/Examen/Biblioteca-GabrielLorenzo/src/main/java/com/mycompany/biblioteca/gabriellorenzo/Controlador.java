/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.gabriellorenzo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 *
 * @author gablorber
 */
public class Controlador {

    @FXML private ListView<LibroAbstracta> listViewLibros;
    @FXML private Button btnAñadir;
    @FXML private Button btnModificar;
    @FXML private Button btnBorrar;
    @FXML private Button btnSalirGrabando;
    @FXML private ImageView portada;
    @FXML private ImageView contraportada;
    private final ObservableList<Biblioteca> libros = FXCollections.observableArrayList();
    private Biblioteca biblioteca;
    @FXML
    public void initialize() {
        biblioteca = new Biblioteca();
        try {
    biblioteca.leerLibros("biblioteca.txt");
    listViewLibros.getItems().addAll(biblioteca.getListaLibros());
} catch (Exception e) {  // Captura cualquier excepción genérica
    System.out.println("Error al leer libros: " + e.getMessage());
    e.printStackTrace();
}
        btnModificar.setDisable(true);
        btnBorrar.setDisable(true);

       listViewLibros.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
    btnModificar.setDisable(newVal == null);
    btnBorrar.setDisable(newVal == null);

    if (newVal != null) {
        try {
            // Carga la imagen de portada
            String rutaPortada = "/imagenes/" + newVal.getPortada();
InputStream portadaStream = getClass().getResourceAsStream(rutaPortada);
if (portadaStream != null) {
    portada.setImage(new Image(portadaStream));
} else {
    portada.setImage(new Image(getClass().getResourceAsStream("/imagenes/default.jpg")));
}

            
            String rutaContra = "/imagenes/" + newVal.getContraportada();
            InputStream contraStream = getClass().getResourceAsStream(rutaContra);
            if (contraStream != null) {
                contraportada.setImage(new Image(contraStream));
            } else {
                System.err.println("No se encontró: " + rutaContra);
                contraportada.setImage(new Image(getClass().getResourceAsStream("/imagenes/default.jpg")));
            }
        } catch (Exception e) {
            System.err.println("Error al cargar imágenes: " + e.getMessage());
        }
    } else {
        portada.setImage(null);
        contraportada.setImage(null);
    }
});
       listViewLibros.setCellFactory(lv -> new javafx.scene.control.ListCell<LibroAbstracta>() {
    @Override
    protected void updateItem(LibroAbstracta libro, boolean empty) {
        super.updateItem(libro, empty);
        if (empty || libro == null) {
            setText(null);
        } else {
            setText(libro.getTitulo() + " - " + libro.getAutor() + " (" + libro.getPublicacion() + ")");
        }
    }
});
    }
    @FXML
    public void guardarComics(String nombreFichero) {
        System.out.println("Número de libros a guardar: " + biblioteca.getListaLibros().size());
    List<LibroAbstracta> lista = biblioteca.getListaLibros();
    System.out.println("Guardando " + lista.size() + " libros en " + nombreFichero);
    try (PrintWriter pw = new PrintWriter(new FileWriter(nombreFichero))) {
        for (LibroAbstracta l : lista) {
            if (l instanceof LibroFiccion) {
                LibroFiccion lf = (LibroFiccion) l;
                pw.println(lf.getTitulo() + ";" + lf.getAutor() + ";" + lf.getPublicacion() + ";" +
                    lf.getISBN() + ";" + lf.getPortada() + ";" + lf.getContraportada() + ";" +
                    lf.getGenero() + ";ficcion");
            }
        }
    } catch (IOException e) {
        System.out.println("Error al guardar: " + e.getMessage());
        e.printStackTrace();
    }
}
    private void sincronizarListaBibliotecaConListView() {
    biblioteca.getListaLibros().clear();
    biblioteca.getListaLibros().addAll(listViewLibros.getItems());
}
@FXML
private void onSalirGrabando() {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmar salida");
    alert.setHeaderText(null);
    alert.setContentText("¿Deseas salir guardando?");
    alert.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);

    alert.showAndWait().ifPresent(respuesta -> {
        if (respuesta == ButtonType.YES) {
            sincronizarListaBibliotecaConListView(); // <-- Sincroniza la lista interna antes de guardar
            String fichero = "biblioteca.txt";
            System.out.println("Guardando en: " + new java.io.File(fichero).getAbsolutePath());
            biblioteca.guardarLibros(fichero);
            Platform.exit();
        } else if (respuesta == ButtonType.NO) {
            Platform.exit();
        }
    });
}


    @FXML
    private void onAbrirVentanaAñadir() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("añadirlibro.fxml"));
            Parent root = loader.load();
            
            AñadirLibroController controladorAñadir = loader.getController();
            controladorAñadir.setBiblioteca(this.biblioteca);
            controladorAñadir.setListaView(listViewLibros);
            
            Stage stage = new Stage();
            stage.setTitle("Añadir libros");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL); 
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

 
    @FXML
private void onEliminar() {
    LibroAbstracta seleccionado = listViewLibros.getSelectionModel().getSelectedItem();
    if (seleccionado != null) {
        biblioteca.borrarLibro(seleccionado.getISBN());
        listViewLibros.getItems().remove(seleccionado);
    }
}
@FXML
private void onAbrirVentanaModificar() {
    LibroAbstracta seleccionado = listViewLibros.getSelectionModel().getSelectedItem();
    if (seleccionado == null) return;
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("añadirLibro.fxml"));
        Parent root = loader.load();

        AñadirLibroController controladorModificar = loader.getController();
        controladorModificar.setBiblioteca(biblioteca);
        controladorModificar.setListaView(listViewLibros);
        controladorModificar.setEditarLibro((LibroFiccion) seleccionado); 

        Stage stage = new Stage();
        stage.setTitle("Modificar libro");
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
@FXML
private void onSalirSinGuardar() {
    // Mostrar confirmación antes de salir
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Salir sin guardar");
    alert.setHeaderText("¿Estás seguro de que quieres salir sin guardar los cambios?");
    alert.setContentText("Todos los cambios no guardados se perderán.");


    alert.showAndWait().ifPresent(response -> {
        if (response == ButtonType.OK) {
            Platform.exit(); 
        }
    });
}

}
