package com.sequeros.practicaexamenterceraevaluacion;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

// CONTROLADOR DE DIÁLOGO – ExitView.fxml
// → cargado desde pedirConfirmacionSalir() en ControlInicioController
// EXAMEN patrón diálogo con resultado:
//   1) campo boolean confirmed = false
//   2) botón OK  → confirmed = true  + cerrar
//   3) botón Cancel → confirmed = false + cerrar
//   4) el padre llama isConfirmed() DESPUÉS de showAndWait()
public class ExitViewController {

    // → fx:id en ExitView.fxml
    @FXML private Button btnOk;
    @FXML private Button btnCancel;

    private boolean confirmed = false; // false por defecto = cerrar con la X cuenta como Cancelar

    // ── handlers – onAction en ExitView.fxml ─────────────────────────────────
    @FXML
    private void handleOk() {
       confirmed = true;
        cerrarVentana();
    }

    @FXML
    private void handleCancel() {
       confirmed = true;
        cerrarVentana();
    }

    // → llamado desde pedirConfirmacionSalir() tras showAndWait()
    public boolean isConfirmed() {
        return confirmed;
    }
    // EXAMEN cerrar ventana secundaria: nodo → getScene() → getWindow() → (Stage) → close()
    private void cerrarVentana() {
        ((Stage) btnOk.getScene().getWindow()).close();
    }
}
   
