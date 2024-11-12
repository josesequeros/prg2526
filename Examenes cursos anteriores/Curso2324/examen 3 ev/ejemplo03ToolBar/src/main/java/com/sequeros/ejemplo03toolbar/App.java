package com.sequeros.ejemplo03toolbar;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    // Un canvas para dibujar las figuras
    Canvas canvas = new Canvas(300, 300);

    public static void main(String[] args) {
        Application.launch(args);
    }

    public void start(Stage stage) {
        // Create ToolBar items
        Button rectBtn = new Button("", new Rectangle(0, 0, 16, 16));
        Button circleBtn = new Button("", new Circle(0, 0, 8));
        Button ellipseBtn = new Button("", new Ellipse(8, 8, 8, 6));
        Button exitBtn = new Button("Salir");

        // Tooltips
        rectBtn.setTooltip(new Tooltip("Dibujar un Rectángulo"));
        circleBtn.setTooltip(new Tooltip("Dibujar un Círculo"));
        ellipseBtn.setTooltip(new Tooltip("Dibujar una Elipse"));
        exitBtn.setTooltip(new Tooltip("Salir de la Aplicación"));

        // AddActionEvent handlers para los items
        rectBtn.setOnAction(e -> draw("Rectangle"));
        circleBtn.setOnAction(e -> draw("Circle"));
        ellipseBtn.setOnAction(e -> draw("Ellipse"));
        exitBtn.setOnAction(e -> Platform.exit());

        ToolBar toolBar = new ToolBar(rectBtn, circleBtn, ellipseBtn, new Separator(), exitBtn);

        // Create Menu items
        MenuItem drawRectMenuItem = new MenuItem("Dibujar Rectángulo");
        MenuItem drawCircleMenuItem = new MenuItem("Dibujar Círculo");
        MenuItem drawEllipseMenuItem = new MenuItem("Dibujar Elipse");
        MenuItem exitMenuItem = new MenuItem("Salir");

        // AddActionEvent handlers para los items del menú
        drawRectMenuItem.setOnAction(e -> draw("Rectangle"));
        drawCircleMenuItem.setOnAction(e -> draw("Circle"));
        drawEllipseMenuItem.setOnAction(e -> draw("Ellipse"));
        exitMenuItem.setOnAction(e -> Platform.exit());

        // Create the Menus
        Menu drawMenu = new Menu("Dibujar");
        drawMenu.getItems().addAll(drawRectMenuItem, drawCircleMenuItem, drawEllipseMenuItem);
        Menu fileMenu = new Menu("Archivo");
        fileMenu.getItems().add(exitMenuItem);

        // Create the MenuBar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, drawMenu);

        BorderPane root = new BorderPane();
        root.setTop(new VBox(menuBar, new Label("Clic sobre la figura a dibujar."), toolBar));
        root.setCenter(canvas);
        root.setStyle("-fx-padding: 10;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;"
                + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Figuras ToolBar y Menú");
        stage.show();
    }

    public void draw(String shapeType) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, 300, 300); // First clear the canvas
        gc.setFill(Color.TAN);

        if (shapeType.equals("Rectangle")) {
            gc.fillRect(0, 0, 200, 200);
        } else if (shapeType.equals("Circle")) {
            gc.fillOval(0, 0, 200, 200);
        } else if (shapeType.equals("Ellipse")) {
            gc.fillOval(10, 40, 180, 120);
        }
    }
}
