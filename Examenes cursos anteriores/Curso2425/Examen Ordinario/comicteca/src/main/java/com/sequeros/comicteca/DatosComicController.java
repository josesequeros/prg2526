/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros.comicteca;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author jabue
 */
public class DatosComicController implements Initializable {

    private boolean pulsadoCancelar = true;
    private ComicAbstracta comicModificada;

    @FXML
    private Button botonSalvar;
    @FXML
    private Button botonCancelar;
    @FXML
    private TextField publicacion;
    @FXML
    private TextField isbn;
    @FXML
    private TextField portada;
    @FXML
    private TextField portadaAlternativa;
    @FXML
    private TextField titulo;
    @FXML
    private ImageView ivPortada;
    @FXML
    private ImageView ivPortadaAlternativa;
    @FXML
    private TextField autor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void salvarPulsado(ActionEvent event) {
        pulsadoCancelar = false;
        try {
            if (autor.getText().isEmpty()
                    || titulo.getText().trim().length() == 0
                    || publicacion.getText().isEmpty()
                    || isbn.getText().trim().length() == 0) {
                throw new Exception("No pueden ser vacíos")  ;
            }

            comicModificada = new ComicSuperheroes(
                    titulo.getText(),
                    autor.getText(),
                    Integer.parseInt(publicacion.getText()),
                    isbn.getText(),
                    portada.getText(),
                    portadaAlternativa.getText(),
                    "Universo"
            );
            ((Button) event.getSource()).getScene().getWindow().hide();
        } 
         catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error en el año de Publicación");
            alert.setContentText("Por favor, ingrese un año válido");
            Optional<ButtonType> result = alert.showAndWait();
            pulsadoCancelar = true;
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error en los datos");
            alert.setContentText("Datos no pueden estar en blanco");
            Optional<ButtonType> result = alert.showAndWait();
            pulsadoCancelar = true;
        }
    }

    @FXML
    private void cancelarPulsado(ActionEvent event) {
        pulsadoCancelar = true;
        ((Button) event.getSource()).getScene().getWindow().hide();
    }

    public boolean getCancelar() {
        return pulsadoCancelar;
    }

    public ComicAbstracta getComic() {
        return comicModificada;
    }

        public void initAutor(ComicAbstracta comic) {
        titulo.setText(comic.getTitulo());
        autor.setText(comic.getAutor());
        publicacion.setText(comic.getPublicacion()+"");

        portada.setText(comic.getPortada());
        portadaAlternativa.setText(comic.getPortadaAlternativa());
    }
}
