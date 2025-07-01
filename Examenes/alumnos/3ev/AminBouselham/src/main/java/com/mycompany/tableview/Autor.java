package com.mycompany.tableview;

import java.io.Serializable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Autor implements Serializable {

    private static final long serialVersionUID = 1L;

    private final StringProperty Nombre = new SimpleStringProperty();
    private final StringProperty Apellidos = new SimpleStringProperty();
    private final StringProperty DNI = new SimpleStringProperty();
    private final StringProperty fechaNacimiento = new SimpleStringProperty();
    private final StringProperty pahtImagen = new SimpleStringProperty();

    public Autor(String nombre, String imagen, String DNI, String Apellidos, String fechaNacimiento) {
        this.Nombre.setValue(nombre);
        this.DNI.setValue(DNI);
        this.Apellidos.setValue(Apellidos);
        this.fechaNacimiento.setValue(fechaNacimiento);
        this.pahtImagen.setValue(imagen);
    }

    public final StringProperty DNIProperty() {
        return DNI;
    }

    public final java.lang.String getDNI() {
        return this.DNIProperty().get();
    }

    public final void setDNI(final java.lang.String DNI) {
        this.DNIProperty().set(DNI);
    }

    public final StringProperty NombreProperty() {
        return Nombre;
    }

    public final java.lang.String getNombre() {
        return this.NombreProperty().get();
    }

    public final void setNombre(final java.lang.String Nombre) {
        this.NombreProperty().set(Nombre);
    }

    public final StringProperty ApellidosProperty() {
        return Apellidos;
    }

    public final java.lang.String getApellidos() {
        return this.ApellidosProperty().get();
    }

    public final void setApellidos(final java.lang.String Apellidos) {
        this.ApellidosProperty().set(Apellidos);
    }

    public final StringProperty FechaNacimientoProperty() {
        return fechaNacimiento;
    }

    public final java.lang.String getFechaNacimiento() {
        return this.FechaNacimientoProperty().get();
    }

    public final void setFechaNacimiento(final java.lang.String fechaNacimiento) {
        this.FechaNacimientoProperty().set(fechaNacimiento);
    }

    public StringProperty PahtImagenProperty() {
        return pahtImagen;
    }

    public final java.lang.String getPahtImagen() {
        return this.PahtImagenProperty().get();
    }

    public final void setPahtImagen(final java.lang.String pathImage) {
        this.PahtImagenProperty().set(pathImage);
    }
}
