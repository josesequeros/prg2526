package com.mycompany.arrastrarcartas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;

/**
 * JavaFX App
 */
public class App extends Application {

    private double startX, startY; // Posición inicial del mouse
    private double offsetX, offsetY; // Desplazamiento desde el punto de clic
    private List<Card> selectedCards = new ArrayList<>(); // Cartas seleccionadas
    private Pane root;
    private Rectangle dropZoneValid, dropZoneInvalid;

    @Override
    public void start(Stage primaryStage) {
        root = new Pane();

        // Crear una pila de cartas
        List<Card> cardStack = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Card card = new Card(100, 50 + (i * 30), 80, 100);
            root.getChildren().add(card);
            cardStack.add(card);

            // Manejo de eventos
            card.setOnMousePressed(this::onMousePressed);
            card.setOnMouseDragged(this::onMouseDragged);
            card.setOnMouseReleased(this::onMouseReleased);
        }

        // Zona donde SÍ se pueden soltar las cartas (Verde)
        dropZoneValid = new Rectangle(400, 200, 80, 100);
        dropZoneValid.setFill(Color.LIGHTGREEN);
        dropZoneValid.setStroke(Color.BLACK);
        root.getChildren().add(dropZoneValid);

        // Zona donde NO se pueden soltar las cartas (Rojo)
        dropZoneInvalid = new Rectangle(600, 200, 80, 100);
        dropZoneInvalid.setFill(Color.PINK);
        dropZoneInvalid.setStroke(Color.BLACK);
        root.getChildren().add(dropZoneInvalid);

        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setTitle("Solitario con JavaFX - Drag & Drop");
        primaryStage.show();
    }

    private void onMousePressed(MouseEvent event) {
        if (event.getSource() instanceof Card) {
            Card clickedCard = (Card) event.getSource(); // Conversión explícita

            startX = event.getSceneX();
            startY = event.getSceneY();
            offsetX = clickedCard.getX() - startX;
            offsetY = clickedCard.getY() - startY;
            selectedCards.clear();

            // Seleccionar la carta y las que están arriba
            for (javafx.scene.Node node : root.getChildren()) {
                if (node instanceof Card) {
                    Card card = (Card) node;
                    if (card.getY() >= clickedCard.getY()) {
                        selectedCards.add(card);
                    }
                }
            }
        }
    }

    private void onMouseDragged(MouseEvent event) {
        double deltaX = event.getSceneX() - startX;
        double deltaY = event.getSceneY() - startY;

        for (Card card : selectedCards) {
            card.setX(card.getX() + deltaX);
            card.setY(card.getY() + deltaY);
        }

        startX = event.getSceneX();
        startY = event.getSceneY();
    }

    private void onMouseReleased(MouseEvent event) {
        // Verificar si la carta está dentro de la zona válida
        if (isInDropZone(dropZoneValid, event.getSceneX(), event.getSceneY())) {
            System.out.println("Carta soltada en zona válida.");
        } else if (isInDropZone(dropZoneInvalid, event.getSceneX(), event.getSceneY())) {
            System.out.println("Carta NO se puede soltar aquí. Regresando...");
            resetCardsPosition();
        }
    }

    // Verifica si una posición está dentro de una zona específica
    private boolean isInDropZone(Rectangle zone, double x, double y) {
        return x >= zone.getX() && x <= zone.getX() + zone.getWidth()
                && y >= zone.getY() && y <= zone.getY() + zone.getHeight();
    }

    // Si la carta se suelta en una zona inválida, regresa a la posición original
    private void resetCardsPosition() {
        for (Card card : selectedCards) {
            card.setX(100);
            card.setY(50 + (selectedCards.indexOf(card) * 30));
        }
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
