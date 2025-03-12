package com.sequeros.ejemplo01textfieldyslider;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable {

    @FXML
    private TextField textField;
    @FXML
    private Slider slider;
    @FXML
    private Label label;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        textField.textProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue o, Object oldVal, Object newVal) {
                label.setText(newVal + "");
            }
        });

        slider.valueProperty().addListener((observable, oldVal, newVal) -> {
            label.setText(newVal + "");
        });
    }

}
