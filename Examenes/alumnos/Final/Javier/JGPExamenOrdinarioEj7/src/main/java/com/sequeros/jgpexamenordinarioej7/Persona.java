package com.sequeros.jgpexamenordinarioej7;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Persona {

    private final StringProperty Nombre = new SimpleStringProperty();
    private final StringProperty Apellidos = new SimpleStringProperty();
    private final StringProperty Email = new SimpleStringProperty();
    private final StringProperty Genero = new SimpleStringProperty();
    private final ObjectProperty<LocalDate> Nacimiento = new SimpleObjectProperty<>();
    private final StringProperty Pais = new SimpleStringProperty();

    public Persona(String nombre, String apellidos) {
        Nombre.setValue(nombre);
        Apellidos.setValue(apellidos);
    }

    public Persona(String nombre, String apellidos, String email,
            String genero, LocalDate nacimiento, String pais) {

        Nombre.set(nombre);
        Apellidos.set(apellidos);
        Email.set(email);
        Genero.set(genero);
        Pais.set(pais);
        this.Nacimiento.set(nacimiento);
    }

    public final StringProperty NombreProperty() {
        return this.Nombre;
    }

    public final java.lang.String getNombre() {
        return this.NombreProperty().get();
    }

    public final void setNombre(final java.lang.String Nombre) {
        this.NombreProperty().set(Nombre);
    }

    public final StringProperty ApellidosProperty() {
        return this.Apellidos;
    }

    public final java.lang.String getApellidos() {
        return this.ApellidosProperty().get();
    }

    public final void setApellidos(final java.lang.String Apellidos) {
        this.ApellidosProperty().set(Apellidos);
    }

    public final StringProperty EmailProperty() {
        return this.Email;
    }

    public final String getEmail() {
        return this.EmailProperty().get();
    }

    public final void setEmail(final String Email) {
        this.EmailProperty().set(Email);
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

    public final StringProperty PaisProperty() {
        return this.Pais;
    }

    public final String getPais() {
        return this.PaisProperty().get();
    }

    public final void setPais(final String Pais) {
        this.PaisProperty().set(Pais);
    }

    public final ObjectProperty nacimientoProperty() {
        return this.Nacimiento;
    }

    public LocalDate getNacimiento() {
        return Nacimiento.get();
    }
    
    public String getNacimientoString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return Nacimiento.get().format(formato);
    }

    public void setNacimiento(LocalDate nacimiento) {
        this.Nacimiento.set(nacimiento);
    }

    @Override
    public String toString() {
        return "Persona{" + "Nombre=" + Nombre + ", Apellidos=" + Apellidos + ", Email=" + Email + ", Genero=" + Genero + ", Nacimiento=" + Nacimiento + ", Pais=" + Pais + '}';
    }



}
