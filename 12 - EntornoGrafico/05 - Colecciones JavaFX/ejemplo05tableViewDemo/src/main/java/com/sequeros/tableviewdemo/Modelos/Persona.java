package com.sequeros.tableviewdemo.Modelos;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Persona {

    private final StringProperty nombre = new SimpleStringProperty();
    private final StringProperty apellidos = new SimpleStringProperty();

    public Persona(String nombre, String apellidos) {
        this.nombre.setValue(nombre);
        this.apellidos.setValue(apellidos);
    }

    public final StringProperty NombreProperty() {
        return this.nombre;
    }

    public final java.lang.String getNombre() {
        return this.NombreProperty().get();
    }

    public final void setNombre(final java.lang.String Nombre) {
        this.NombreProperty().set(Nombre);
    }

    public final StringProperty ApellidosProperty() {
        return this.apellidos;
    }

    public final java.lang.String getApellidos() {
        return this.ApellidosProperty().get();
    }

    public final void setApellidos(final java.lang.String Apellidos) {
        this.ApellidosProperty().set(Apellidos);
    }
}

