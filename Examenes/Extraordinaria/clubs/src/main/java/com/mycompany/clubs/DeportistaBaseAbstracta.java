package com.mycompany.clubs;

/**
 *
 * @author
 */

import javafx.beans.property.*;

public abstract class DeportistaBaseAbstracta implements DeportistaInterfaz {

    private StringProperty nombre;
    private IntegerProperty edad;
    private StringProperty deporte;
    private ObjectProperty<Club> club;
    private StringProperty imagen;

    public DeportistaBaseAbstracta(String nombre, int edad, String deporte, Club club, String imagen) {
        this.nombre = new SimpleStringProperty(nombre);
        this.edad = new SimpleIntegerProperty(edad);
        this.deporte = new SimpleStringProperty(deporte);
        this.club = new SimpleObjectProperty<>(club);
        this.imagen = new SimpleStringProperty(imagen);
    }

    // Getters normales 
    @Override
    public String getNombre() {
        return nombre.get();
    }

    @Override
    public int getEdad() {
        return edad.get();
    }

    @Override
    public String getDeporte() {
        return deporte.get();
    }

    @Override
    public Club getClub() {
        return club.get();
    }

    @Override
    public String getImagen() {
        return imagen.get();
    }

    // Properties
    public StringProperty nombreProperty() {
        return nombre;
    }

    public IntegerProperty edadProperty() {
        return edad;
    }

    public StringProperty deporteProperty() {
        return deporte;
    }

    public ObjectProperty<Club> clubProperty() {
        return club;
    }

    public StringProperty imagenProperty() {
        return imagen;
    }

    // Setters 
    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public void setEdad(int edad) {
        this.edad.set(edad);
    }

    public void setDeporte(String deporte) {
        this.deporte.set(deporte);
    }

    public void setClub(Club club) {
        this.club.set(club);
    }

    public void setImagen(String imagen) {
        this.imagen.set(imagen);
    }

    @Override
    public abstract int calcularSalarioMensual();
}