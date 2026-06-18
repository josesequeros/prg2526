package com.mycompany.ejemplotableviewbd;

import java.time.LocalDate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Persona {

    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty nombre = new SimpleStringProperty();
    private final StringProperty Apellidos = new SimpleStringProperty();
    private final StringProperty Email = new SimpleStringProperty();
    private final StringProperty Genero = new SimpleStringProperty();
    private final ObjectProperty<LocalDate> Nacimiento = new SimpleObjectProperty<>();
    private final StringProperty Pais = new SimpleStringProperty();

    public Persona(String nombre, String apellidos) {
        this.nombre.setValue(nombre);
        Apellidos.setValue(apellidos);
    }

    public Persona(int id, String nombre, String apellidos, String email,
            String genero, LocalDate nacimiento, String pais) {

        this.id.set(id);
        this.nombre.set(nombre);
        Apellidos.set(apellidos);
        Email.set(email);
        Genero.set(genero);
        Pais.set(pais);
        this.Nacimiento.set(nacimiento);
    }

    public Persona(String nombre, String apellidos, String email,
            String genero, LocalDate nacimiento, String pais) {

        this.nombre.set(nombre);
        Apellidos.set(apellidos);
        Email.set(email);
        Genero.set(genero);
        Pais.set(pais);
        this.Nacimiento.set(nacimiento);
    }

    public int getId() {
        return this.id.get();
    }

    public void setId(int value) {
        id.set(value);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public final StringProperty NombreProperty() {
        return this.nombre;
    }

    public final String getNombre() {
        return this.nombre.get();
    }

    public final void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public final StringProperty ApellidosProperty() {
        return this.Apellidos;
    }

    public final String getApellidos() {
        return this.Apellidos.get();
    }

    public final void setApellidos(String Apellidos) {
        this.Apellidos.set(Apellidos);
    }

    public final StringProperty EmailProperty() {
        return this.Email;
    }

    public final String getEmail() {
        return this.Email.get();
    }

    public final void setEmail(String Email) {
        this.Email.set(Email);
    }

    public final StringProperty GeneroProperty() {
        return this.Genero;
    }

    public final String getGenero() {
        return this.Genero.get();
    }

    public final void setGenero(String Genero) {
        this.Genero.set(Genero);
    }

    public final StringProperty PaisProperty() {
        return this.Pais;
    }

    public final String getPais() {
        return this.Pais.get();
    }

    public final void setPais(String Pais) {
        this.Pais.set(Pais);
    }

    public final ObjectProperty nacimientoProperty() {
        return this.Nacimiento;
    }

    public LocalDate getNacimiento() {
        return Nacimiento.get();
    }

    public void setNacimiento(LocalDate nacimiento) {
        this.Nacimiento.set(nacimiento);
    }

    @Override
    public String toString() {
        return "Persona{" + "Nombre=" + nombre + ", Apellidos=" + Apellidos + ", Email=" + Email + ", Genero=" + Genero + ", Nacimiento=" + Nacimiento + ", Pais=" + Pais + '}';
    }

}
