/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.gabriellorenzo;

/**
 *
 * @author gablorber
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author gabri
 */
public class AñadirLibroController {

    
    @FXML private TextField txtTitulo;
    @FXML private TextField txtAutor;
    @FXML private TextField txtPublicacion;
    @FXML private TextField txtISBN;
    @FXML private TextField txtPortada;
    @FXML private TextField txtContraportada;
    @FXML private TextField txtgenero;
    @FXML private TextField txtsinopsis;
    private Biblioteca biblioteca;
    private ListView<LibroAbstracta> listView;
    private LibroFiccion libroParaEditar;
    public void setListaView(ListView<LibroAbstracta> la) {
        this.listView = la;
    }
    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @FXML
    private void onSalvar() {
        String titulo = txtTitulo.getText();
        String autor = txtAutor.getText();
        String publicacion = txtPublicacion.getText();
        String isbn = txtISBN.getText();
        String portada = txtPortada.getText();
        String contraportada = txtContraportada.getText();
        String genero = txtgenero.getText();
        String sinopsis = txtsinopsis.getText();
        if (titulo.isEmpty() || autor.isEmpty() || publicacion.isEmpty()
                || isbn.isEmpty() || portada.isEmpty() || contraportada.isEmpty() || genero.isEmpty() ||
                sinopsis.isEmpty()) {
            mostrarError("Estos campos son obligatorios");
            return;
        }
        int anio;
        try {
            anio = Integer.parseInt(publicacion);
            if (anio < 1900 || anio > 2025) {
                mostrarError("El año debe estar entre 1900 y 2025");
                return;
            }
        } catch (NumberFormatException e) {
            mostrarError("La publicación debe ser un número válido");
            return;
        }
        LibroAbstracta existente = biblioteca.buscarLibroISBN(isbn);
       if (existente != null && existente != libroParaEditar) {
    mostrarError("Ya existe un libro con ese ISBN");
    return;
    }
      if (libroParaEditar != null) {
    libroParaEditar.setTitulo(titulo);
    libroParaEditar.setAutor(autor);
    libroParaEditar.setPublicacion(anio);
    libroParaEditar.setPortada(portada);
    libroParaEditar.setContraportada(contraportada);
    libroParaEditar.setGenero(genero);
    libroParaEditar.setGenero(sinopsis);
    listView.refresh();
} else {
    LibroFiccion nuevo = new LibroFiccion(titulo, autor, anio, isbn, portada, contraportada, genero, sinopsis);
    biblioteca.addLibro(nuevo);
    listView.getItems().add(nuevo);
}

        
        biblioteca.guardarLibros("biblioteca.txt");
        Stage ventana = (Stage) txtTitulo.getScene().getWindow();
        ventana.close();

    }
    @FXML
    private void onCancelar() {
        ((Stage) txtTitulo.getScene().getWindow()).close();
    }
    private void mostrarError(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Error");
        alerta.setHeaderText("Error al añadir libro");
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
    public void setEditarLibro(LibroFiccion libro) {
    this.libroParaEditar = libro;


    txtTitulo.setText(libro.getTitulo());
    txtAutor.setText(libro.getAutor());
    txtPublicacion.setText(String.valueOf(libro.getPublicacion()));
    txtISBN.setText(libro.getISBN());
    txtPortada.setText(libro.getPortada());
    txtContraportada.setText(libro.getContraportada());
    txtgenero.setText(libro.getGenero());
    txtsinopsis.setText(libro.getSinopsis());

    txtISBN.setDisable(true); 
}

}
