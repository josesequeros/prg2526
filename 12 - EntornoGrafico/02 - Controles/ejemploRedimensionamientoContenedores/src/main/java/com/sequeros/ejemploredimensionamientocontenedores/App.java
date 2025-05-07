package com.sequeros.ejemploredimensionamientocontenedores;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        // 1. Pane (no redimensiona)
        Pane pane = new Pane();
        Button btnPane = new Button("Pane (fijo)");
        btnPane.setLayoutX(10);
        btnPane.setLayoutY(10);
        pane.getChildren().add(btnPane);
        pane.setStyle("-fx-border-color: red; -fx-min-height: 60;");

        // 2. HBox (horizontal, se adapta)
        HBox hbox = new HBox();
        Button btnHBox = new Button("HBox (se adapta)");
        btnHBox.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(btnHBox, Priority.ALWAYS);
        hbox.getChildren().add(btnHBox);
        hbox.setStyle("-fx-border-color: green; -fx-min-height: 60;");

        // 3. VBox (vertical, se adapta)
        VBox vbox = new VBox();
        Button btnVBox = new Button("VBox (se adapta)");
        btnVBox.setMaxWidth(Double.MAX_VALUE);
        //btnVBox.setMaxHeight(Double.MAX_VALUE); 
        VBox.setVgrow(btnVBox, Priority.ALWAYS);
        vbox.getChildren().add(btnVBox);
        vbox.setStyle("-fx-border-color: blue; -fx-min-height: 60;");

        // 4. BorderPane (regiones)
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(new Label("Top"));
        Button btnBorderPane = new Button("Center (crece)");
        // btnBorderPane.setMaxWidth(Double.MAX_VALUE);
        // btnBorderPane.setMaxHeight(Double.MAX_VALUE); 
        borderPane.setCenter(btnBorderPane);
        borderPane.setBottom(new Label("Bottom"));
        borderPane.setStyle("-fx-border-color: orange; -fx-min-height: 80;");

        // 5. GridPane (tabla)
        GridPane gridPane = new GridPane();
        Button g1 = new Button("0,0");
        Button g2 = new Button("0,1");
        Button g3 = new Button("1,0");
        Button g4 = new Button("1,1");
        g1.setMaxWidth(Double.MAX_VALUE);
        g2.setMaxWidth(Double.MAX_VALUE);
        g3.setMaxWidth(Double.MAX_VALUE);
        g4.setMaxWidth(Double.MAX_VALUE);
        gridPane.add(g1, 0, 0);
        gridPane.add(g2, 1, 0);
        gridPane.add(g3, 0, 1);
        gridPane.add(g4, 1, 1);
        ColumnConstraints cc = new ColumnConstraints();
        cc.setHgrow(Priority.ALWAYS);
        gridPane.getColumnConstraints().addAll(cc, cc);
        gridPane.setStyle("-fx-border-color: purple; -fx-min-height: 80;");

        // 6. StackPane (apila todo)
        StackPane stackPane = new StackPane();
        Button btnStack = new Button("StackPane (centra y crece)");
        // btnStack.setMaxWidth(Double.MAX_VALUE);
        // btnStack.setMaxHeight(Double.MAX_VALUE); 
        stackPane.getChildren().add(btnStack);
        stackPane.setStyle("-fx-border-color: brown; -fx-min-height: 80;");

        // Agregar todos los contenedores
        root.getChildren().addAll(
                new Label("1. Pane"),
                pane,
                new Label("2. HBox"),
                hbox,
                new Label("3. VBox"),
                vbox,
                new Label("4. BorderPane"),
                borderPane,
                new Label("5. GridPane"),
                gridPane,
                new Label("6. StackPane"),
                stackPane
        );

        Scene scene = new Scene(root, 500, 700);
        stage.setTitle("Comparación de Contenedores JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
