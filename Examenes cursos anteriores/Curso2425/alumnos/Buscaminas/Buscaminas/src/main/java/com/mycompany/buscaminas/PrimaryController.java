package com.mycompany.buscaminas;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Bueno, hemos llegado a Frankenstein, el controlador de la ventana principal
 * del juego.
 * Aquí lo tengo prácticamente todo y me arrepiento mucho de no haberlo hecho
 * más modular,
 * porque a la hora de encontrar errores o solucionar problemas o hacer
 * literalmente cualquier cosa,
 * me ha costado un montón.
 */
public class PrimaryController implements Initializable {

    @FXML
    private GridPane gridpane;
    @FXML
    private Menu newgame;
    @FXML
    private Menu options;
    @FXML
    private MenuItem easy;
    @FXML
    private MenuItem medium;
    @FXML
    private MenuItem hard;
    @FXML
    private MenuItem custom;
    @FXML
    private Menu ranking;
    @FXML
    private Menu help;
    @FXML
    private Button limpiarbttn;
    @FXML
    private Button pausebttn;
    @FXML
    private Button rankingbttn;
    @FXML
    private Button helpbttn;
    @FXML
    private Button exitbttn;
    @FXML
    private Text nmbrmines;
    @FXML
    private Text tpo;
    @FXML
    private MenuItem mifacil;
    @FXML
    private MenuItem mimedio;
    @FXML
    private MenuItem midificil;
    @FXML
    private MenuItem micustom;

    // Variables de clase:
    private Button[][] botones;
    private int numFilas;
    private int numColumnas;
    private int numMinesLeft;
    private int numMinas;
    private Partida partida;
    private String dificultadActual = "";
    private String nombreJugador;
    private String tiempo;

    // Inicializar controles

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Opciones de dificultad
        newgame(new ActionEvent());
    }

    // Estos dos métodos son muy necesarios para poder pasar el nombre del jugador y
    // el tiempo de juego a la clase Partida,
    // que luego se utiliza para guardar el ranking.
    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public void setTiempoJuego(String tiempo) {
        this.tiempo = tiempo;
    }

    // Método para crear juego nuevo. Salta un scene control de dialogo para
    // seleccionar la dificultad.
    // Si se pulsa cancelar, se sale del juego.
    @FXML
    private void newgame(ActionEvent event) {
        java.util.List<String> choices = java.util.Arrays.asList("Fácil", "Medio", "Difícil", "Personalizado");
        javafx.scene.control.ChoiceDialog<String> dialog = new javafx.scene.control.ChoiceDialog<>("Fácil", choices);
        dialog.setTitle("Nueva partida");
        dialog.setHeaderText("Selecciona la dificultad");
        dialog.setContentText("Dificultad:");

        java.util.Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            String selected = result.get();
            switch (selected) {
                case "Fácil":
                    easy(new ActionEvent());
                    break;
                case "Medio":
                    medium(new ActionEvent());
                    break;
                case "Difícil":
                    hard(new ActionEvent());
                    break;
                case "Personalizado":
                    custom(new ActionEvent());
                    break;
            }
        } else {
            exit(null); // Si se pulsa cancelar, se sale del juego.
        }
    }

    // Con este metodo limpiamos el gridpane y reiniciamos el contador de minas.
    // Tienes que volver a seleccionar una dificultad para jugar de nuevo.
    @FXML
    private void clear(ActionEvent event) {
        gridpane.getChildren().clear();
        nmbrmines.setText("0");
    }

    private javafx.animation.AnimationTimer timerInstance;

    // Este método pausa o reanuda el temporizador. Si el temporizador está activo,
    // lo detiene; si está detenido, lo inicia.
    @FXML
    private void pause(ActionEvent event) {
        if (timerInstance != null) {
            timerInstance.stop();
        } else {
            timerInstance.start();
        }
    }

    // Este método abre la ventana de ranking, pasando la dificultad actual al
    // controlador del ranking.
    @FXML
    private void ranking(ActionEvent event) {
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("ranking.fxml"));
            javafx.scene.Parent root = loader.load();

            // Obtener el controlador al que pasar la dificultad, igual que antes.
            RankingController rankingController = loader.getController();
            rankingController.setDificultadActual(dificultadActual);

            javafx.scene.Scene scene = new javafx.scene.Scene(root);
            javafx.stage.Stage stage = (javafx.stage.Stage) gridpane.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Este método muestra un diálogo de ayuda con instrucciones del juego.
    @FXML
    private void help(ActionEvent event) {
        // Logic to show help information
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(
                javafx.scene.control.Alert.AlertType.INFORMATION);
        alert.setHeight(500);
        alert.setWidth(500);
        alert.setTitle("Ayuda");
        alert.setHeaderText("Instrucciones del juego");
        alert.setContentText("Haz clic en los botones para descubrir casillas. "
                + "Evita las minas y trata de despejar el tablero.");
        alert.showAndWait();

    }

    // Con este metodo podemos salir del juego, no sin antes preguntar si queremos
    // salir mediante un dialogo de confirmación.
    @FXML
    private void exit(ActionEvent event) {
        javafx.scene.control.Alert alerta = new javafx.scene.control.Alert(
                javafx.scene.control.Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Confirmación de salida");
        alerta.setHeaderText("¿Estás seguro que quieres salir?");
        alerta.setContentText("Se perderá la partida actual");
        java.util.Optional<javafx.scene.control.ButtonType> result = alerta.showAndWait();
        if (result.isPresent()) {
            if (result.get() == javafx.scene.control.ButtonType.OK
                    || result.get() == javafx.scene.control.ButtonType.YES) {
                System.exit(0);
            }
        }
    }

    // Aquí están los métodos para seleccionar la dificultad del juego, en los que
    // inicializamos el temporizador y creamos los botones
    // con las minas correspondientes a partir de los parametros de filas, columnas
    // y minas. La variable dificultadActual se usa para guardar la
    // dificultad seleccionada y luego se utiliza para guardar el ranking.
    @FXML
    private void easy(ActionEvent event) {
        dificultadActual = "Fácil";
        startTimer();
        int numFilas = 8;
        int numColumnas = 8;
        int numMinas = 10;
        gridpane.getChildren().clear();
        crearBotones(numFilas, numColumnas, numMinas);
    }

    @FXML
    private void medium(ActionEvent event) {
        dificultadActual = "Medio";
        startTimer();
        int numFilas = 16;
        int numColumnas = 16;
        int numMinas = 40;
        gridpane.getChildren().clear();
        crearBotones(numFilas, numColumnas, numMinas);

    }

    @FXML
    private void hard(ActionEvent event) {
        dificultadActual = "Difícil";
        startTimer();
        int numFilas = 16;
        int numColumnas = 30;
        int numMinas = 99;
        gridpane.getChildren().clear();
        crearBotones(numFilas, numColumnas, numMinas);

    }

    // Eb el nivel personalizado pedimos los parámetros al usuario, en este caso,
    // mediante diálogos de entrada. He puesto los parametros del nivel
    // fácil como valores por defecto.
    @FXML
    private void custom(ActionEvent event) {
        dificultadActual = "Personalizado";
        startTimer();
        int numFilas = getIntFromDialog("Número de filas:", 8);
        int numColumnas = getIntFromDialog("Número de columnas:", 8);
        int numMinas = getIntFromDialog("Número de minas:", 10);
        gridpane.getChildren().clear();
        crearBotones(numFilas, numColumnas, numMinas);
    }

    // Este método es el auxiliar que genera la ventana de diálogo para pedir al
    // usuario los parámetros del nivel personalizado.
    // Si el usuario introduce un valor no válido, se devuelve el valor por defecto.
    private int getIntFromDialog(String message, int defaultValue) {
        javafx.scene.control.TextInputDialog dialog = new javafx.scene.control.TextInputDialog(
                String.valueOf(defaultValue));
        dialog.setTitle("Entrada personalizada");
        dialog.setHeaderText(null);
        dialog.setContentText(message);
        java.util.Optional<String> result = dialog.showAndWait();
        try {
            return result.map(Integer::parseInt).orElse(defaultValue);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    // Este método salta cuando el jugador pisa una mina, pausa el temporizador y
    // muestra el mensaje de que has perdido.
    private void gameOver() {
        timerInstance.stop();
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
        alert.setTitle("Juego Terminado");
        alert.setHeaderText("Has pisado una mina!");
        alert.setContentText("Inténtalo de nuevo.");
        alert.showAndWait();

    }

    // Este método lo utilizamos para inciar el temporizador, tuve que buscar cómo
    // hacer el temporizador porque ni idea.
    private void startTimer() {
        timerInstance = new javafx.animation.AnimationTimer() {
            private long lastUpdate = 0;
            private int seconds = 0;

            @Override
            public void handle(long now) {
                if (lastUpdate == 0) {
                    lastUpdate = now;
                }
                if (now - lastUpdate >= 1_000_000_000) { // 1 second in nanoseconds
                    seconds++;
                    tpo.setText(String.valueOf(seconds));
                    lastUpdate = now;
                }
            }
        };
        timerInstance.start();
    }

    // Utilizo un HashSet para almacenar las posiciones de las minas, ya que es más
    // eficiente para comprobar si una posición contiene una mina y no
    // permite duplicados. Guardamos las posiciones como String "fila,columna". Coge
    // el numero de minas de la dificultad seleccionada.
    private Set<String> minePositions = new HashSet<>();

    private void generarMinas(int numMinas, int filas, int columnas) {
        minePositions.clear(); // Limpiar posiciones de minas anteriores
        while (minePositions.size() < numMinas) {
            int fila = (int) (Math.random() * filas);
            int columna = (int) (Math.random() * columnas);
            minePositions.add(fila + "," + columna); // Guardar posición de mina como cadena
        }
    }

    // Este método crea los botones del gridpane y asigna las minas a las posiciones
    // generadas. Igual que antes con las minas, coge los parametros de la
    // dificultad seleccionada.
    // También he utilizado este método para asignar el evento de clic a cada botón
    // que es lo que hace que se descubra el botón al hacer clic izquierdo o se
    // marque con una bandera al hacer clic derecho.
    // ADEMÁS (este método hace literal de todo, debería haberlo dividido en varios
    // métodos más pequeños), te calcula el número de minas que quedan por
    // descubrir y lo muestra en el Text nmbrmines.

    private void crearBotones(int filas, int columnas, int numMinas) {
        generarMinas(numMinas, filas, columnas);
        this.numMinas = numMinas;
        numMinesLeft = numMinas;
        numFilas = filas;
        numColumnas = columnas;
        botones = new Button[filas][columnas];
        gridpane.getChildren().clear(); // Limpia el grid antes de añadir botones

        // Prueba: Configura las columnas y filas para que se expandan. La prueba
        // funciona. Esto obviamente no lo he hecho yo xd.
        gridpane.getColumnConstraints().clear(); // Limpia las restricciones de columnas
        gridpane.getRowConstraints().clear(); // Limpia las restricciones de filas
        // Configura las restricciones de columnas y filas para que se expandan
        for (int c = 0; c < columnas; c++) { // Recorre cada columna
            // Crea una nueva ColumnConstraints para cada columna
            ColumnConstraints cc = new ColumnConstraints();
            cc.setHgrow(Priority.ALWAYS); // Permite que la columna crezca
            cc.setPercentWidth(100.0 / columnas); // Asigna el ancho de la columna como un porcentaje del total
            // Añade la ColumnConstraints al GridPane
            gridpane.getColumnConstraints().add(cc);
        }
        for (int r = 0; r < filas; r++) { // Lo mismo con las filas
            // Crea una nueva RowConstraints para cada fila
            RowConstraints rc = new RowConstraints(); // Crea una nueva RowConstraints para cada fila
            rc.setVgrow(Priority.ALWAYS); // Permite que la fila crezca verticalmente
            // Asigna el alto de la fila como un porcentaje del total
            rc.setPercentHeight(100.0 / filas);
            gridpane.getRowConstraints().add(rc); // Añade la RowConstraints al GridPane
        }

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                botones[i][j] = new Button();
                botones[i][j].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE); // Permite que los botones se expandan
                gridpane.add(botones[i][j], j, i);

                int fila = i;
                int columna = j;
                botones[i][j].setOnMouseClicked(event -> {
                    Button boton = botones[fila][columna];
                    if (event.getButton() == javafx.scene.input.MouseButton.PRIMARY) {
                        if (!"🚩".equals(boton.getText())) {
                            descubrirBoton(fila, columna, boton);
                        }
                    } else if (event.getButton() == javafx.scene.input.MouseButton.SECONDARY) {
                        if ("🚩".equals(boton.getText())) {
                            boton.setText("");
                            boton.setStyle("");
                            numMinesLeft++; // Si desmarcamos una bandera, aumentamos el contador de minas restantes
                        } else if (!boton.isDisabled()) {
                            boton.setText("🚩");
                            boton.setStyle("-fx-background-color: yellow;");
                            numMinesLeft--; // Si marcamos una bandera, disminuimos el contador de minas restantes
                        }
                        // Actualizar el contador de minas restantes que se ve en la parte inferior de
                        // la ventana
                        nmbrmines.setText(String.valueOf(numMinesLeft) + "/" + String.valueOf(numMinas));
                    }
                });
            }
        }
    }

    // Este método es el que se encarga de descubrir el botón al hacer clic
    // izquierdo. Si es una mina, muestra el emoji de bomba y cambia el color del
    // botón a rojo.
    // Si no es una mina, cuenta las minas alrededor y muestra el número
    // correspondiente en el botón.
    // Por último, llama al método comprobarVictoria para verificar si el jugador ha
    // ganado al abrir todas las casillas sin minas.
    private void descubrirBoton(int fila, int columna, Button boton) {
        String pos = fila + "," + columna;
        if (minePositions.contains(pos)) {
            boton.setText("💣");
            boton.setStyle("-fx-background-color: red;");
            gameOver();
        } else {
            int minasAlrededor = 0;
            for (int i = fila - 1; i <= fila + 1; i++) {
                for (int j = columna - 1; j <= columna + 1; j++) {
                    if (i >= 0 && i < numFilas && j >= 0 && j < numColumnas
                            && minePositions.contains(i + "," + j)) {
                        minasAlrededor++;
                    }
                }
            }

            if (minasAlrededor > 0) {
                boton.setText(String.valueOf(minasAlrededor));
                boton.setDisable(true);

            } else if (minasAlrededor == 0) {
                boton.setDisable(true);
                boton.setText("0");
                for (int k = fila - 1; k <= fila + 1; k++) {
                    for (int l = columna - 1; l <= columna + 1; l++) {
                        if (k >= 0 && k < numFilas && l >= 0 && l < numColumnas && !(k == fila && l == columna)) {
                            Button botonAdyacente = botones[k][l];
                            if (!botonAdyacente.isDisabled() && !minePositions.contains(k + "," + l)) {
                                descubrirBoton(k, l, botonAdyacente);
                                comprobarVictoria();
                            }
                        }
                    }
                }
            }
            comprobarVictoria();
        }
    }

    // Con este método me ayudó Pedro porque yo ya no era ni capaz de pensar xd,
    // pero bueno, al final hacemos un bucle que se ejecuta
    // mientras haya casillas sin descubrir, comprobando que esas casillas sin
    // descubrir no son minas. En el momento en el que las unicas casillas sin
    // descubrir son las minas, se considera que el jugador ha ganado.
    private void comprobarVictoria() {
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                String pos = i + "," + j;
                if (!minePositions.contains(pos) && !botones[i][j].isDisabled()) {
                    return;
                }
            }
        }

        // Si llegamos aquí, significa que todas las casillas sin minas han sido
        // descubiertas.
        // Salta diálogo de victoria y preguntamos al jugador si quiere guardar su
        // partida, si guarda la partida se añade al archivo de texto correspondiente al
        // nivel en el que estaba jugando, y si no, se vuelve al menú principal.
        javafx.scene.control.Alert alerta = new javafx.scene.control.Alert(
                javafx.scene.control.Alert.AlertType.CONFIRMATION);
        alerta.setTitle("¡Victoria!");
        alerta.setHeaderText("¡Has ganado!");
        alerta.setContentText("¿Quieres guardar la partida?");
        java.util.Optional<javafx.scene.control.ButtonType> result = alerta.showAndWait();
        if (result.isPresent() && result.get() == javafx.scene.control.ButtonType.OK) {

            tiempo = tpo.getText();

            if ("Fácil".equals(dificultadActual)) {
                String linea = nombreJugador + ";" + tiempo + System.lineSeparator();
                try (java.io.FileWriter fw = new java.io.FileWriter("easy.txt", true)) {
                    fw.write(linea);
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
            } else if ("Medio".equals(dificultadActual)) {
                String linea = nombreJugador + ";" + tiempo + System.lineSeparator();
                try (java.io.FileWriter fw = new java.io.FileWriter("medium.txt", true)) {
                    fw.write(linea);
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
            } else if ("Difícil".equals(dificultadActual)) {
                String linea = nombreJugador + ";" + tiempo + System.lineSeparator();
                try (java.io.FileWriter fw = new java.io.FileWriter("hard.txt", true)) {
                    fw.write(linea);
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
            } else {
                String linea = nombreJugador + ";" + tiempo + System.lineSeparator();
                try (java.io.FileWriter fw = new java.io.FileWriter("custom.txt", true)) {
                    fw.write(linea);
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
            }

        } else {
            try {
                javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("inicio.fxml"));
                javafx.scene.Parent root = loader.load();
                javafx.scene.Scene scene = new javafx.scene.Scene(root);
                javafx.stage.Stage stage = (javafx.stage.Stage) gridpane.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

// Este ha sido el último controlador que he comentado y me he dado cuenta de
// que cambiaría un montón de cosas si volviera a hacer el proyecto,
// pero lo hecho, hecho está. Otra cosa no, pero aprender... Una cosa que cabe
// destacar es que la ventana sí cambia de tamaño, y quiero arreglar eso, pero
// por otra parte, te lo quiero entregar ya, estoy agotada xd