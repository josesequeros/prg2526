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
    
    @Override // Sobrescribir el método start en la clase Application
    public void start(Stage primaryStage) {
        // Crear un reloj y una etiqueta
        clock.setCurrentTime();
        String timeString = clock.getHora() + ":" + clock.getMinutos()
                + ":" + clock.getSegundos();
        lblCurrentTime = new Label(timeString);
        
        // Coloque el reloj y la etiqueta en border pane
        BorderPane pane = new BorderPane();
        pane.setCenter(clock);      
        pane.setBottom(lblCurrentTime);
        BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);

        // Timeline para actualizar el reloj cada segundo
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> actualizar()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        // Crea una escena y colocarla en el escenario
        Scene scene = new Scene(pane, 250, 250);
        primaryStage.setTitle("Reloj"); // Set el título del escenario
        primaryStage.setScene(scene); // Situar la escena en el escenario
        primaryStage.show(); // Visualizar el escenario
    }
    
    public static void main(String[] args) {
        launch();
    }
    
    public static void actualizar() {
        clock.setCurrentTime();
        lblCurrentTime.setText(clock.getHora() + ":" + clock.getMinutos() + ":" + clock.getSegundos());
    }
    
}
