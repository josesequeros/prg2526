package com.mycompany.ejemplobordepane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-border-color: red; -fx-border-width: 2;");
        
        /*
        Label top = new Label("TOP");
        top.setStyle("-fx-background-color: lightblue; -fx-border-color: black;");

        Label bottom = new Label("BOTTOM");
        bottom.setStyle("-fx-background-color: lightcoral; -fx-border-color: black;");

        Label left = new Label("LEFT");
        left.setStyle("-fx-background-color: lightgreen; -fx-border-color: black;");

        Label right = new Label("RIGHT");
        right.setStyle("-fx-background-color: lightyellow; -fx-border-color: black;");

        Label center = new Label("CENTER");
        center.setStyle("-fx-background-color: lightgray; -fx-border-color: black;");

        root.setTop(new Button("Arriba"));
        HBox group = new HBox();
        group.getChildren().addAll(new Button("Abajo 1"), new Button("Abajo 2"));
        root.setBottom(group); // y setLeft, setCenter y setRight
*/
        StackPane top = new StackPane(new Label("TOP"));
        top.setStyle("-fx-background-color: lightblue; -fx-border-color: black;");

        StackPane bottom = new StackPane(new Label("BOTTOM"));
        bottom.setStyle("-fx-background-color: lightcoral; -fx-border-color: black;");

        StackPane left = new StackPane(new Label("LEFT"));
        left.setStyle("-fx-background-color: lightgreen; -fx-border-color: black;");

        StackPane right = new StackPane(new Label("RIGHT"));
        right.setStyle("-fx-background-color: lightyellow; -fx-border-color: black;");

        StackPane center = new StackPane(new Label("CENTER"));
        center.setStyle("-fx-background-color: lightgray; -fx-border-color: black;");

        root.setTop(top);
        root.setBottom(bottom);
        root.setLeft(left);
        root.setRight(right);
        root.setCenter(center);

        var scene = new Scene(new StackPane(root), 200, 200);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
