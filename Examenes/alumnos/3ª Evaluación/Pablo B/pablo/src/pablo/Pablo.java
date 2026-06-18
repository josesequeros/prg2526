/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pablo;

import java.io.IOException;

/**
 *
 * @author pabbermor3
 */
public class Pablo {

    /**
     * @param args the command line arguments huevos
     */
    public static void main(String[] args) {
        import javafx.application.Application;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Scene;
        import javafx.stage.Stage;
        import java.io.IOException;

        //Los comentarios molan

    public class Main extends Application {

        private static void launch(String[] args) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public void start(Stage primaryStage) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/main.fxml"));
            Scene scene = new Scene(loader.load());

            primaryStage.setTitle("Personas del Mundo – PabloBerna");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        // :3
        public static void main(String[] args) {
            launch(args);
        }
    }
}
