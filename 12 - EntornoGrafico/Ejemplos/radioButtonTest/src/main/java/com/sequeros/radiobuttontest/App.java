package com.sequeros.radiobuttontest;

import java.io.File;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    protected Text text = new Text(50, 50, "Programación JavaFX");

    protected BorderPane getPane() {
        HBox paneForButtons = new HBox(20);
        Button bb = new Button();
        /*
        Button btLeft = new Button(
                "Left", 
                new ImageView(new File("/imagenes/left.png").toURI().toString())
        );
        Button btRight = new Button(
                "Right", 
                new ImageView(new File("imagenes/right.gif").toURI().toString())
        );
        */
        Button btLeft = new Button(
                "Left", 
                new ImageView(getClass().getResource("/imagenes/left.gif").toString())
        );
        Button btRight = new Button("Right", new ImageView(getClass().getResource("/imagenes/right.gif").toString()));
        
        
        paneForButtons.getChildren().addAll(btLeft, btRight);
        paneForButtons.setAlignment(Pos.CENTER);
        paneForButtons.setStyle("-fx-border-color: green");

        BorderPane pane = new BorderPane();
        pane.setBottom(paneForButtons);

        Pane paneForText = new Pane();
        paneForText.getChildren().add(text);
        pane.setCenter(paneForText);

        btLeft.setOnAction(e -> text.setX(text.getX() - 10));
        btRight.setOnAction(e -> text.setX(text.getX() + 10));

        return pane;
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(getPane(), 450, 200);
        stage.setTitle("ButtonDemo"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.show(); // Display the stage
    }

    public static void main(String[] args) {
        launch();
    }

}
