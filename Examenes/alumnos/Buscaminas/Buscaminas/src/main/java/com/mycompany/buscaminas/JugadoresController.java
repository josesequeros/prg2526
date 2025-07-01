/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.buscaminas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/** Este es el controlador de la ventana de selección de jugadores. Te muestra la lista de jugadores con un ListView,
 *  y te permite tanto seleccionar un jugador para comenzar el juego o volver atrás por si cambias de idea y te quieres crear uno nuevo.
 */
public class JugadoresController implements Initializable {

    @FXML
    private ListView<Jugador> listaJugadores;
    @FXML
    private Button selectbttn;
    @FXML
    private Button returnbttn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Aquí especifico la disponibilidad de los botones al iniciar la ventana. No lo pedía la práctica pero tú seguro que me lo pides en 
        //el examen xd.
        //Por defecto, el botón de seleccionar está deshabilitado porque no es necesario mientras no se seleccione un jugador.
        //El botón de volver atrás está habilitado porque siempre puedes volver a la ventana de inicio.
        selectbttn.setDisable(true);
        returnbttn.setDisable(false);

        // Aquí leo los jugadores desde el archivo "jugadores.txt". Los jugadores que leemos del archivo los almacenamos en
        // una lista de objetos Jugador, que es una clase que he creado para almacenar el nombre y la ruta de la imagen del jugador.
        java.util.List<Jugador> lista = new java.util.ArrayList<>();
        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader("jugadores.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length >= 1) {
                    Jugador jugador = new Jugador();
                    jugador.setNombre(partes[0]);
                    if (partes.length > 1)
                        jugador.setImgpath(partes[1]);
                    lista.add(jugador);
                }
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        // Este fragmento convierte la lista de jugadores que he generado antes a un ObservableList para usarlo en el ListView
        javafx.collections.ObservableList<Jugador> jugadoresObservable = javafx.collections.FXCollections
                .observableArrayList(lista);
        listaJugadores.setItems(jugadoresObservable); // Asignamos la lista observable al ListView
        // Y aquí añado un listener al ListView para habilitar el botón de seleccionar cuando se selecciona un jugador, 
        //esto tuve que preguntarlo a la IA porque no sabía cómo hacerlo y cada vez que abría la lista no podía seleccionar nada.
        listaJugadores.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            selectbttn.setDisable(newVal == null);
        });

        // Esta parte de código tiene como funcion mostrar la imagen del jugador en el ListView.
        // Si el jugador tiene una imagen, se muestra; si no, se muestra solo el nombre.
        // Me rompí la cabeza con esto porque al principio solo era capaz de mostrar el nombre del jugador, y no sabía si el error
        // estaba en esta parte o en la ruta de la imagen. Resulta si pones la carpeta de imagenes dentro únicamente de la carpeta src,
        // funciona, pero si la pones en la carpeta de recursos, no funciona.
        //Esta parte me la explicó Pomares, en plan, la de cómo mostrar la imagen a partir de imagenPath.

        listaJugadores.setCellFactory(lv -> new javafx.scene.control.ListCell<Jugador>() {
            private final javafx.scene.image.ImageView imageView = new javafx.scene.image.ImageView();

            @Override 
            protected void updateItem(Jugador jugador, boolean empty) {
                super.updateItem(jugador, empty); // Llamamos al método updateItem de la clase padre para asegurarnos de que se actualiza correctamente.
                if (empty || jugador == null) { // Si la celda está vacía o el jugador es nulo, limpiamos el texto y la imagen.
                    setText(null);
                    setGraphic(null);
                } else { // Si hay un jugador, mostramos su nombre y su imagen, a no ser que no tenga imagen, que entonces no se muestra nada más que el nombre.
                    setText(jugador.getNombre());
                    if (jugador.getImgpath() != null && !jugador.getImgpath().isEmpty()) {
                        try {
                            javafx.scene.image.Image img = new javafx.scene.image.Image(jugador.getImgpath(), 40, 40,
                                    true, true);
                            javafx.scene.image.ImageView imageView = new javafx.scene.image.ImageView(img);
                            setGraphic(imageView);
                        } catch (Exception e) {
                            setGraphic(null);
                        }
                    } else {
                        setGraphic(null);
                    }
                }
            }
        });
    }

    // Este método se ejecuta al pulsar seleccionar, y lo que hace es cargar y pasar a la ventana del juego.
    @FXML
    private void select(ActionEvent event) {
        Jugador jugadorSeleccionado = listaJugadores.getSelectionModel().getSelectedItem();
        if (jugadorSeleccionado != null) {
            try {
                javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("primary.fxml"));
                javafx.scene.Parent root = loader.load();

                // ESTO DE AQUÍ. Estoy segura de que me lo habría podido ahorrar de haber planteado mejor la estructura del juego, pero bueno,
                // tuve que preguntar a la IA como pasar información recogida en una escena a otra escena.
                //Recuerdo que esto también me dio problemas en JavaScript en Lenguaje de Marcas xd.
                PrimaryController primaryController = loader.getController(); // Obtenemos el controlador de la ventana del juego
                // Y le pasamos el nombre del jugador seleccionado para poder usarlo ahí.
                primaryController.setNombreJugador(jugadorSeleccionado.getNombre());

                javafx.scene.Scene scene = new javafx.scene.Scene(root);
                javafx.stage.Stage stage = (javafx.stage.Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Este método se ejecuta al pulsar volver atrás, y lo que hace es cargar la ventana de inicio.
    @FXML
    private void back(ActionEvent event) {
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(
                    getClass().getResource("inicio.fxml"));
            javafx.scene.Parent root = loader.load();
            javafx.scene.Scene scene = new javafx.scene.Scene(root);
            javafx.stage.Stage stage = (javafx.stage.Stage) ((javafx.scene.Node) event.getSource()).getScene()
                    .getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
