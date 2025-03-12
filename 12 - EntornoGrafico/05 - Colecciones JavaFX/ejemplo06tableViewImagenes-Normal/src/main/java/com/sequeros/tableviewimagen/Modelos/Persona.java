package com.sequeros.tableviewimagen.Modelos;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Persona {

    private String Nombre;// = new SimpleStringProperty();
    private String Apellidos;// = new SimpleStringProperty();
    private Residencia residencia;// = new SimpleObjectProperty<>();
    private String pathImagen;// = new SimpleStringProperty();

    public Persona(String nombre, String apellidos, Residencia residencia, String imagen) {
        this.Nombre = nombre;
        this.Apellidos = apellidos;
        this.residencia = residencia;
        this.pathImagen = imagen;
    }

    public final String getNombre() {
        return this.Nombre;
    }

    public final void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public final String getApellidos() {
        return this.Apellidos;
    }

    public final void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public Residencia getResidencia() {
        return residencia;
    }

    public void setResidencia(Residencia residencia) {
        this.residencia = residencia;
    }

    public String getPathImagen() {
        return this.pathImagen;
    }

    public void setPathImagen(String pathImagen) {
        this.pathImagen = pathImagen;
    }

}
