package com.mycompany.listviewpersona;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

public class Persona {

    private final StringProperty Nombre = new SimpleStringProperty();
    private final StringProperty Apellidos = new SimpleStringProperty();
private final StringProperty pais = new SimpleStringProperty();
 private final StringProperty correo = new SimpleStringProperty();
private final StringProperty genero = new SimpleStringProperty();
private final StringProperty nacimiento = new SimpleStringProperty();
 private Image Imagen;   

public Persona(String nombre, String apellidos,String Nacimiento,String Pais,String Genero,String Correo,Image imagen) {
        Nombre.setValue(nombre);
        Apellidos.setValue(apellidos);
        pais.setValue(Pais);
        correo.setValue(Correo);
        genero.setValue(Genero);
        nacimiento.setValue(Nacimiento);
        Imagen.equals(imagen);
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

    @Override
    public String toString() {
        return getNombre() + " " + getApellidos();
    }

    public StringProperty getPais() {
        return pais;
    }

    public StringProperty getCorreo() {
        return correo;
    }

    public StringProperty getGenero() {
        return genero;
    }

    public StringProperty getNacimiento() {
        return nacimiento;
    }

    public Image getImagen() {
        return Imagen;
    }
    
    
}