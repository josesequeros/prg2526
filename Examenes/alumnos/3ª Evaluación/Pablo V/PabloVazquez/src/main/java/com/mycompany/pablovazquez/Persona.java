/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pablovazquez;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

/**
 *
 * @author pabvazrui
 */
public class Persona {

    private final StringProperty Nombre = new SimpleStringProperty();
    private final StringProperty Apellidos = new SimpleStringProperty();
    private final StringProperty Correo = new SimpleStringProperty();
    private final StringProperty Genero = new SimpleStringProperty();
    private final StringProperty Nacimiento = new SimpleStringProperty();
    private final StringProperty Pais = new SimpleStringProperty();
    private String getGenero;
    private String getNacimiento;
    private String getPais;

    public Persona(String nombre, String apellidos, String correo, String genero, String nacimiento, String pais) {
        Nombre.setValue(nombre);
        Apellidos.setValue(apellidos);
        Correo.setValue(correo);
        Genero.setValue(genero);
        Nacimiento.setValue(nacimiento);
        Pais.setValue(pais);
        
    }  

    public final StringProperty NombreProperty() {
        return this.Nombre;
    }
    
    public final String getNombre() {
        return this.NombreProperty().get();
    }
    
    public final void setNombre(final String Nombre) {
        this.NombreProperty().set(Nombre);
    }

    public final StringProperty ApellidosProperty() {
        return this.Apellidos;
    }

    public final String getApellidos() {
        return this.ApellidosProperty().get();
    }

    public final void setApellidos(final String Apellidos) {
        this.ApellidosProperty().set(Apellidos);
    }
    
    public final StringProperty CorreoProperty() {
        return this.Correo;
    }
    
    public final String getCorreo() {
        return this.CorreoProperty().get();
    }
    
    public final void setCorreo(final String Correo) {
        this.CorreoProperty().set(Correo);
    }
    
    public final StringProperty GeneroProperty() {
        return this.Genero;
    }
    
    public final String getGenero() {
        return this.GeneroProperty().get();
    }
    
    public final void setGenero(final String Genero) {
        this.GeneroProperty().set(Genero);
    }
    
    public final StringProperty NacimientoProperty() {
        return this.Nacimiento;
    }
    
    public final String getNacimiento() {
        return this.NacimientoProperty().get();
    }
    
    public final void setNacimiento(final String Nacimiento) {
        this.NacimientoProperty().set(Nacimiento);
    }
    
    public final StringProperty PaisProperty() {
        return this.Pais;
    }
    
    public final String getPais() {
        return this.PaisProperty().get();
    }
    
    public final void setPais(final String Pais) {
        this.PaisProperty().set(Pais);
    }

    @Override
    public String toString() {
        return getNombre() + " " + getApellidos() + " " + getCorreo() + " " + getGenero + " " + getNacimiento + " " + getPais;
    }
    
    
}
