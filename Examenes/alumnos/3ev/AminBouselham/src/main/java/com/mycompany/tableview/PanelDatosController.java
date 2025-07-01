/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.tableview;

import com.mycompany.tableview.Autor;
import java.io.File;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author mohbouezz
 */
public class PanelDatosController implements Initializable {

    @FXML
    private TextField casillaDeDNI;
    @FXML
    private TextField casillaDeNombre;
    @FXML
    private ImageView imageView_preview;
    @FXML
    private TextField casillaDeApellidos;
    @FXML
    private TextField casillaDeNacimiento;
    @FXML
    private Button cancelar2;
    @FXML
    private Button aceptar;
    @FXML
    private TextField casillaDeImagen;

    private boolean cancelar = true;
    private Autor persona = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setCancelar(true);
        aceptar.setOnAction(evnt -> accept(evnt));
        cancelar2.setOnAction(evnt -> close(evnt));

    }

    public void initPersona(Autor p) {
        casillaDeNombre.setText(p.getNombre());
        casillaDeApellidos.setText(p.getApellidos());
        casillaDeDNI.setText(p.getDNI());
        casillaDeNacimiento.setText(p.getFechaNacimiento());
        casillaDeImagen.setText(p.getPahtImagen());
    }

    private void accept(ActionEvent evnt) {
        if (!casillaDeNombre.getText().trim().equals("") && !casillaDeImagen.getText().trim().equals("") && !casillaDeDNI.getText().trim().equals("") && !casillaDeApellidos.getText().trim().equals("") && !casillaDeNacimiento.getText().trim().equals("")) {
            if (casillaDeNacimiento.getText().trim().matches("\\d{2}/\\d{2}/\\d{4}")) {
                setCancelar(false);
                setEquipo(new Autor(casillaDeNombre.getText().trim(), casillaDeImagen.getText().trim(), casillaDeDNI.getText().trim(), casillaDeApellidos.getText().trim(), casillaDeNacimiento.getText().trim()));
                Node n = (Node) evnt.getSource();
                n.getScene().getWindow().hide();
            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Excepción");
                alerta.setHeaderText("ERROR");
                alerta.setContentText("La fecha no tiene el formato correcto.");
                alerta.show();
            }
        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Excepción");
            alerta.setHeaderText("ERROR");
            alerta.setContentText("Hay campos vacíos.");
            alerta.show();
        }
    }

    private void close(ActionEvent evnt) {
        setCancelar(true);
        Node n = (Node) evnt.getSource();
        n.getScene().getWindow().hide();
    }

    public boolean getCancelar() {
        return cancelar;
    }

    public void setCancelar(boolean cancelar) {
        this.cancelar = cancelar;
    }

    public Autor getEquipo() {
        return persona;
    }

    public void setEquipo(Autor persona) {
        this.persona = persona;
    }
}
