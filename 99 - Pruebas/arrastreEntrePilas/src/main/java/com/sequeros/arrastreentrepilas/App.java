package com.sequeros.arrastreentrepilas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    private static final int NUM_PILAS = 7;
    private static final int CARTA_ANCHO = 80;
    private static final int CARTA_ALTO = 100;
    private static final int ESPACIADO = 30;

    private List<List<Card>> pilas = new ArrayList<>();
    private Pane root;
    private double startX, startY;
    private Card selectedCard;
    private int pilaOrigen;

    @Override
    public void start(Stage primaryStage) {
        root = new Pane();

        // Crear las 7 pilas
        for (int i = 0; i < NUM_PILAS; i++) {
            pilas.add(new ArrayList<>());
        }

        // Crear cartas en cada pila
        for (int i = 0; i < NUM_PILAS; i++) {
            for (int j = 0; j < i + 1; j++) {  // Se crea un número progresivo de cartas
                Card card = new Card(100 + i * 120, 50 + j * ESPACIADO, CARTA_ANCHO, CARTA_ALTO);
                pilas.get(i).add(card);
                root.getChildren().add(card);

                // Agregar eventos de arrastre
                card.setOnMousePressed(this::onMousePressed);
                card.setOnMouseDragged(this::onMouseDragged);
                card.setOnMouseReleased(this::onMouseReleased);
            }
        }

        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.setTitle("Solitario - Arrastrar entre pilas");
        primaryStage.show();
    }

    private void onMousePressed(MouseEvent event) {
        if (event.getSource() instanceof Card) {
            selectedCard = (Card) event.getSource();
            startX = event.getSceneX();
            startY = event.getSceneY();

            // Determinar la pila de origen
            pilaOrigen = -1;
            for (int i = 0; i < NUM_PILAS; i++) {
                if (pilas.get(i).contains(selectedCard) && pilas.get(i).indexOf(selectedCard) == pilas.get(i).size() - 1) {
                    pilaOrigen = i;
                    break;
                }
            }

            // Solo permitir mover la última carta de la pila
            if (pilaOrigen == -1) {
                selectedCard = null;
            }
        }
    }

    private void onMouseDragged(MouseEvent event) {
        if (selectedCard != null) {
            double deltaX = event.getSceneX() - startX;
            double deltaY = event.getSceneY() - startY;

            selectedCard.setX(selectedCard.getX() + deltaX);
            selectedCard.setY(selectedCard.getY() + deltaY);

            startX = event.getSceneX();
            startY = event.getSceneY();
        }
    }

    private void onMouseReleased(MouseEvent event) {
        if (selectedCard != null) {
            int nuevaPila = getNearestPila(event.getSceneX());

            if (nuevaPila != -1 && nuevaPila != pilaOrigen) {
                // Mover carta a la nueva pila
                pilas.get(pilaOrigen).remove(selectedCard);
                pilas.get(nuevaPila).add(selectedCard);

                // Ajustar la posición en la nueva pila
                selectedCard.setX(100 + nuevaPila * 120);
                selectedCard.setY(50 + (pilas.get(nuevaPila).size() - 1) * ESPACIADO);
            } else {
                // Devolver la carta a su posición original
                selectedCard.setX(100 + pilaOrigen * 120);
                selectedCard.setY(50 + (pilas.get(pilaOrigen).size() - 1) * ESPACIADO);
            }
            selectedCard = null;
        }
    }

    // Determina la pila más cercana a la posición X
    private int getNearestPila(double x) {
        int pilaMasCercana = -1;
        double minDistancia = Double.MAX_VALUE;

        for (int i = 0; i < NUM_PILAS; i++) {
            double centroPila = 100 + i * 120;
            double distancia = Math.abs(x - centroPila);
            if (distancia < minDistancia) {
                minDistancia = distancia;
                pilaMasCercana = i;
            }
        }
        return pilaMasCercana;
    }

    public static void main(String[] args) {
        launch(args);
    }

    // Clase personalizada para representar una carta
    static class Card extends Rectangle {
        public Card(double x, double y, double width, double height) {
            super(width, height, Color.LIGHTBLUE);
            setX(x);
            setY(y);
            setStroke(Color.BLACK);
        }
    }
}
