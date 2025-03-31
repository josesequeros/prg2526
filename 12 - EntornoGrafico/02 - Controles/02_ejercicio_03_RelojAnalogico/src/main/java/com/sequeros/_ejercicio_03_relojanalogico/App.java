package com.sequeros._ejercicio_03_relojanalogico;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

/**
 * JavaFX App
 */
public class App extends Application {
    
    private static RelojAnalogico clock = new RelojAnalogico();
    private static Label lblCurrentTime = new Label();
    
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a clock and a label
        clock.setCurrentTime();
        String timeString = clock.getHour() + ":" + clock.getMinute()
                + ":" + clock.getSecond();

        // Place clock and label in border pane
        BorderPane pane = new BorderPane();
        pane.setCenter(clock);
        lblCurrentTime = new Label(timeString);
        pane.setBottom(lblCurrentTime);
        BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);

        // Timeline para actualizar el reloj cada segundo
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> actualizar()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 250, 250);
        primaryStage.setTitle("DisplayClock"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
    
    public static void main(String[] args) {
        launch();
    }
    
    public static void actualizar() {
        clock.setCurrentTime();
        String timeString = clock.getHour() + ":" + clock.getMinute()
                + ":" + clock.getSecond();
        lblCurrentTime.setText(clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond());
    }
    
}
