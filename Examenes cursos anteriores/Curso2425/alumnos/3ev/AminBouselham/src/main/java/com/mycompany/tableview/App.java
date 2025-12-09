package com.mycompany.tableview;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage myStage;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("PanelPrincipal"), 550, 500);
        setMyStage(stage);
        myStage.setScene(scene);
        myStage.show();
        stage.setTitle("Autores - Amin Bouselham");
        stage.setResizable(false);
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static Stage getMyStage() {
        return myStage;
    }

    public static void setMyStage(Stage aMyStage) {
        myStage = aMyStage;
    }
}
