/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros.tresenraya;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author IEUser
 */
public class PrimaryController implements Initializable {

    @FXML
    private TextField player1;
    @FXML
    private TextField player2;
    @FXML
    private Button buttonReset;
    @FXML
    private Button buttonStart;
    @FXML
    private GridPane miGrid;
    @FXML
    private Button boton11;
    @FXML
    private Button boton21;
    @FXML
    private Button boton31;
    @FXML
    private Button boton12;
    @FXML
    private Button boton22;
    @FXML
    private Button boton32;
    @FXML
    private Button boton13;
    @FXML
    private Button boton23;
    @FXML
    private Button boton33;
    @FXML
    private Label labelJugador1;
    @FXML
    private Label labelJugador2;

    private int turnoJugador;
    final int JUGADOR1 = 0;
    final int JUGADOR2 = 1;
    private boolean jugar = false;
    private String simbolos[];
    private int jugadas = 0;
    private int[][] matrizJuego = new int[3][3];
    private String[] imagenes = new String[2];

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        simbolos = new String[2];
        simbolos[0] = "X";
        simbolos[1] = "O";
        imagenes[0] = "cruz.png";
        imagenes[1] = "circulo.png";
        turnoJugador = 0;
        jugar = false;

        buttonStart.setOnAction(this::startPulsado);
        //buttonStart.setOnAction((ActionEvent e) -> startPulsado(e));

        buttonReset.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            limpiarTablero(true);// limpiar el tablero
            player1.setText("0");
            player2.setText("0");
        });

        limpiarTablero(true);
        player1.setEditable(false);
        player2.setEditable(false);
        Platform.runLater(() -> buttonStart.requestFocus());    // Asignamos el foco a botonStart
        //comprobar(0, 0);
    }

    @FXML
    private void botonPulsado(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        if (clickedButton.getText().equals("") && jugar) {
            clickedButton.setText(simbolos[turnoJugador]);
            //clickedButton.setGraphic(new ImageView(new Image(imagenes[turnoJugador],100,100,true,true)));
            //clickedButton.setDisable(true);
            //clickedButton.setShape(new Circle(40));
            if (ganador()) {
                //System.out.println(simbolos[turnoJugador]);
                if (turnoJugador == JUGADOR1) {
                    player1.setText((Integer.parseInt(player1.getText()) + 1) + "");
                } else {
                    player2.setText((Integer.parseInt(player2.getText()) + 1) + "");
                }
                jugar = false;
            } else {
                turnoJugador++;
                turnoJugador = turnoJugador % 2;
                //System.out.println(turnoJugador);
                resaltarJugadorActual();
                jugadas++;
            }
        }
        if (jugadas == 9) {
            jugar = false;
            labelJugador1.setTextFill(Color.valueOf("BLACK"));
            labelJugador2.setTextFill(Color.valueOf("BLACK"));
        }
    }

    void startPulsado(ActionEvent event) {
        limpiarTablero(false);
        resaltarJugadorActual();
        jugar = true;
    }

    private void limpiarTablero(boolean desactivar) {
        miGrid.getChildren().forEach((Node button) -> {
            button.disableProperty().setValue(desactivar);
            if (button instanceof Button) {
                //((Button) button).textProperty().setValue("");
                ((Button) button).setText("");
                //((Button) button).setGraphic(null);
            }
        });
        jugar = false;
        turnoJugador = 0;
        jugadas = 0;
        //resaltarJugadorActual();
        labelJugador1.setTextFill(Color.valueOf("BLACK"));
        labelJugador2.setTextFill(Color.valueOf("BLACK"));
    }

    private void resaltarJugadorActual() {
        if (turnoJugador == JUGADOR1) {
            labelJugador1.setTextFill(Color.valueOf("GREEN"));
            labelJugador2.setTextFill(Color.valueOf("BLACK"));
        } else {
            labelJugador1.setTextFill(Color.valueOf("BLACK"));
            labelJugador2.setTextFill(Color.valueOf("GREEN"));
        }
    }

    private boolean hasGanado() {
        boolean ganador = false;
        int f = 0;
        int c = 0;
        while (f < 3 && !ganador) {
            ganador = true;
            while (c < 3 && ganador) {
                ganador = ganador;
                c++;
            }
            f++;
        }

        return ganador;
    }

    private Boolean ganador() {
        String[][] matriz = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = getNodoPosicion(i, j) != null ? getNodoPosicion(i, j).getText() : "";
                //System.out.print(i + "" + j + " -> " + matriz[i][j] + " ");
            }
        }

        if (haGanado(matriz)) {
            System.out.println("Ha Ganado");
        }

        Boolean gana
                = boton11.getText().equals(simbolos[turnoJugador])
                && boton12.getText().equals(simbolos[turnoJugador])
                && boton13.getText().equals(simbolos[turnoJugador])
                || boton21.getText().equals(simbolos[turnoJugador])
                && boton22.getText().equals(simbolos[turnoJugador])
                && boton23.getText().equals(simbolos[turnoJugador])
                || boton31.getText().equals(simbolos[turnoJugador])
                && boton32.getText().equals(simbolos[turnoJugador])
                && boton33.getText().equals(simbolos[turnoJugador])
                || boton11.getText().equals(simbolos[turnoJugador])
                && boton21.getText().equals(simbolos[turnoJugador])
                && boton31.getText().equals(simbolos[turnoJugador])
                || boton12.getText().equals(simbolos[turnoJugador])
                && boton22.getText().equals(simbolos[turnoJugador])
                && boton32.getText().equals(simbolos[turnoJugador])
                || boton13.getText().equals(simbolos[turnoJugador])
                && boton23.getText().equals(simbolos[turnoJugador])
                && boton33.getText().equals(simbolos[turnoJugador])
                || boton11.getText().equals(simbolos[turnoJugador])
                && boton22.getText().equals(simbolos[turnoJugador])
                && boton33.getText().equals(simbolos[turnoJugador])
                || boton13.getText().equals(simbolos[turnoJugador])
                && boton22.getText().equals(simbolos[turnoJugador])
                && boton31.getText().equals(simbolos[turnoJugador]);
        return gana;
    }

    private Button getNodoPosicion(int fila, int col) {
        //System.out.println("Fila: " + fila + " columna: " + col);
        for (Node nodo : miGrid.getChildren()) {
            //System.out.println("Id: " + nodo.getId());
            //Button b = (Button) nodo;
            //System.out.println("Nodo: " + b.getText());
            if (nodo instanceof Button) {
                Integer filaGrid = miGrid.getRowIndex(nodo);
                Integer columnaGrid = miGrid.getColumnIndex(nodo);
                if (filaGrid != null && columnaGrid != null
                        && filaGrid == fila && columnaGrid == col) {
                    return (Button) nodo;
                }
            }
        }
        return null;
    }

    private void comprobar(int fila, int col) {
        //System.out.println("Fila: " + fila + " columna: " + col);
        int i = 0;
        for (Node nodo : miGrid.getChildren()) {
            if (nodo instanceof Button) {
                System.out.println(++i + " Id: " + nodo.getId());
                System.out.println(miGrid.getRowIndex(nodo));
                System.out.println(miGrid.getColumnIndex(nodo));
            } else {
                System.out.println(nodo);
            }
        }
    }

    private boolean haGanado(String[][] matriz) {
        boolean gana = false;
        int i = 0;
        int j = 0;
        String simbolo = simbolos[turnoJugador];

        // Comprobar filas
        while (!gana && i < 3) {
            j = 0;
            gana = true;
            while (j < 3) {
                gana = gana && matriz[i][j].equals(simbolo);
                j++;
            }
            i++;
        }
        // Comprobar columnas
        j = 0;
        while (!gana && j < 3) {
            i = 0;
            gana = true;
            while (i < 3) {
                gana = gana && matriz[i][j].equals(simbolo);
                i++;
            }
            j++;
        }
        // Comprobar diagonal principal
        if (!gana) {
            i = 0;
            gana = true;
            while (i < 3) {
                gana = gana && matriz[i][i].equals(simbolo);
                i++;
            }
        }
        // Comprobar diagonal secundaria
        if (!gana) {
            i = 0;
            gana = true;
            while (i < 3) {
                j = 0;
                while (j < 3) {
                    if (i + j == 2) {
                        gana = gana && matriz[i][j].equals(simbolo);
                    }
                    j++;
                }
                i++;
            }
        }

        return gana;
    }
}
