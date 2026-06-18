/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatosPersonaController;

/**
 *
 * @author pabbermor3
 */
public class DatosDeLasPersonas {

    import javafx.fxml.FXML ;
    import javafx.scene.control.*;
    import javafx.scene.image.Image ;
    import javafx.scene.image.ImageView ;
    import javafx.stage.Stage ;
    import models.Persona ;
    import java.time.LocalDate ;
    import java.time.format.DateTimeFormatter ;

    public class DatosPersonaController {

       
        private TextField txtNombre, txtApellidos, txtPais, txtEmail, txtFecha;
       
        private ComboBox<String> cmbGenero;
        
        private ImageView imgBandera;
        
        private Button btnSalvar, btnCancelar;

        private Persona personaActual;
        private MainController mainController;
        private boolean esModificacion = false;

        private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        public void setPersona(Persona p, MainController main) {
            this.mainController = main;
            this.personaActual = p;
            this.esModificacion = (p != null);

            if (p != null) {
                txtNombre.setText(p.getNombre());
                txtApellidos.setText(p.getApellidos());
                txtPais.setText(p.getPais());
                txtEmail.setText(p.getEmail());
                txtFecha.setText(p.getFechaNacimientoStr());
                cmbGenero.setValue(p.getGenero());
            }

           
            txtPais.textProperty().addListener((obs, old, newValue) -> cargarBandera(newValue));
            if (p != null) {
                cargarBandera(p.getPais());
            }
        }

        private void cargarBandera(String pais) {
            if (pais == null || pais.trim().isEmpty()) {
                imgBandera.setImage(null);
                return;
            }
            try {
                Image img = new Image(getClass().getResourceAsStream("/flags/" + pais.trim().toUpperCase() + ".png"));
                imgBandera.setImage(img);
            } catch (Exception e) {
                imgBandera.setImage(null);
            }
        }

       
        private void salvar() {
            if (!validarDatos()) {
                return;
            }

            String email = txtEmail.getText().trim();
            if (!esModificacion && emailExiste(email)) {
                mostrarError("Error", "Ya existe una persona con ese correo electrónico.");
                return;
            }

            if (personaActual == null) {
                personaActual = new Persona();
            }

            personaActual.setNombre(txtNombre.getText().trim());
            personaActual.setApellidos(txtApellidos.getText().trim());
            personaActual.setPais(txtPais.getText().trim());
            personaActual.setEmail(email);
            personaActual.setFechaNacimiento(LocalDate.parse(txtFecha.getText().trim(), FORMATTER));
            personaActual.setGenero(cmbGenero.getValue());

            if (!esModificacion) {
                mainController.personas.add(personaActual);
            }

            mainController.refreshList();
            cerrarVentana();
        }

        private boolean emailExiste(String email) {
            return mainController.personas.stream().anyMatch(p -> p.getEmail().equalsIgnoreCase(email));
        }

        private boolean validarDatos() {
            if (txtNombre.getText().trim().isEmpty() || txtApellidos.getText().trim().isEmpty()
                    || txtFecha.getText().trim().isEmpty()) {
                mostrarError("Datos incorrectos", "El nombre, apellidos y fecha no pueden estar vacíos.");
                return false;
            }

            try {
                LocalDate.parse(txtFecha.getText().trim(), FORMATTER);
            } catch (Exception e) {
                mostrarError("Error", "La fecha debe tener formato dd/MM/yyyy");
                return false;
            }
            return true;
        }

        private void mostrarError(String titulo, String mensaje) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(titulo);
            alert.setContentText(mensaje);
            alert.showAndWait();
        }

       
        private void cancelar() {
            cerrarVentana();
        }

        private void cerrarVentana() {
            Stage stage = (Stage) btnCancelar.getScene().getWindow();
            stage.close();
        }
    }
}
