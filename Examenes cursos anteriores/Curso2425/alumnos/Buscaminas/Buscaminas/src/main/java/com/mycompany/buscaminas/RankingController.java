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

/**
 * FXML Controller class
 *
 * @author Tina
 */
public class RankingController implements Initializable {

    @FXML
    private ListView<Partida> ranking;
    @FXML
    private Button backbttn;

    private String dificultadActual;
    private String archivo;

    /*
     * El controlador de la ventana del ranking, que muestra, como se pide en la
     * práctica, un ranking diferente para cada dificultad.
     * Esa es realmente la parte fácil de esto, ya que solo tengo que leer el
     * archivo de texto correspondiente a la dificultad seleccionada y mostrarlo en
     * un ListView.
     * La parte chunga fue la misma que antes con el nombre del jugador, pasar la
     * dificultad seleccionada desde la ventana de inicio a la ventana del ranking.
     * Para ello tuve que crear la variable dificultadActual, que se asigna en el
     * primaryController, y luego se usa aquí para cargar el archivo
     * correspondiente.
     * También tuve que crear el método setDificultadActual, que se llama desde el
     * primaryController cuando se selecciona una dificultad y sirve para
     * seleccionar mediante un
     * switch el archivo de texto correspondiente a la dificultad seleccionada.
     */

    public void setDificultadActual(String dificultad) {
        this.dificultadActual = dificultad;
        switch (dificultadActual) {
            case "Fácil":
                archivo = "easy.txt";
                break;
            case "Medio":
                archivo = "medium.txt";
                break;
            case "Difícil":
                archivo = "hard.txt";
                break;
            default:
                archivo = "custom.txt";
        }
        cargarRanking(); // Esto al principio olvidé ponerlo y no me cargaba el ranking al abrir la
                         // ventana xddd vaya paseo de práctica.
    }

    private void cargarRanking() {
        if (archivo == null)
            return;
        // Limpia la lista antes de cargar para poder alternar entre diferentes rankings
        // tener entradas que no corresponden porque pertenecen a otra dificultad.
        ranking.getItems().clear();

        // Aquí lo mismo, leemos el archivo y lo separamos por líneas y partes
        // (separadas por punto y coma).
        // Si la línea tiene al menos un elemento, es decir, que hay algo escrito en esa
        // línea, creamos una nueva partida y le asignamos el nombre del jugador que es
        // la primera parte
        // y el tiempo de juego que es la segunda.
        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length > 1) {
                    Partida partida = new Partida();
                    partida.setNombreJugador(partes[0]);
                    partida.setTiempoJuego(Integer.parseInt(partes[1]));
                    ranking.getItems().add(partida);
                }
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    // Método para volver atrás a la ventana de juego. Me habría gustado que al volver a la ventana de inicio se mantuviera
    // el progreso de la partida, pero honestamente, como no lo pedía la práctica y quería tenerla lista y comentada antes de
    //la recuperación, he decidido dejarlo así.
    @FXML
    private void back(ActionEvent event) {
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("primary.fxml"));
            javafx.scene.Parent root = loader.load();
            javafx.scene.Scene scene = new javafx.scene.Scene(root);
            javafx.stage.Stage stage = (javafx.stage.Stage) backbttn.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
