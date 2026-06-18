package com.sequeros.danielhernandeznavarro;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.time.LocalDate;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Alert;

/**
 *
 * @author danhernav
 */
public class Autor {

    private final StringProperty nombre;
    private final StringProperty apellidos;
    private final ObjectProperty<LocalDate> nacimiento;

    // Constructor
    public Autor(String nombre, String apellidos, LocalDate nacimiento) {
        this.nombre = new SimpleStringProperty(nombre);
        this.apellidos = new SimpleStringProperty(apellidos);
        this.nacimiento = new SimpleObjectProperty<>(nacimiento);
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public StringProperty apellidosProperty() {
        return apellidos;
    }

    public ObjectProperty<LocalDate> nacimientoProperty() {
        return nacimiento;
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getApellidos() {
        return apellidos.get();
    }

    public void setApellidos(String apellidos) {
        this.apellidos.set(apellidos);
    }

    public LocalDate getNacimiento() {
        return nacimiento.get();
    }

    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento.set(nacimiento);
    }
}
