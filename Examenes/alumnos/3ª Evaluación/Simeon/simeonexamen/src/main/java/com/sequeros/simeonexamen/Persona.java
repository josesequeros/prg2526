package com.sequeros.simeonexamen;

import java.time.LocalDate;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Persona {

    private final StringProperty nombre = new SimpleStringProperty();
    private final StringProperty apellidos = new SimpleStringProperty();
    private final StringProperty correo = new SimpleStringProperty();
    private final StringProperty genero = new SimpleStringProperty();
    private final ObjectProperty<LocalDate> nacimiento = new SimpleObjectProperty<>();
    private final StringProperty pais = new SimpleStringProperty();

    public Persona() {
    }

    public Persona(String nombre, String apellidos, String correo, String genero, LocalDate nacimiento, String pais) {
        this.nombre.setValue(nombre);
        this.apellidos.setValue(apellidos);
        this.correo.setValue(correo);
        this.genero.setValue(genero);
        this.nacimiento.setValue(nacimiento);
        this.pais.setValue(pais);
    }

    public StringProperty nombreProperty() { return nombre; }
    public String getNombre() { return nombre.get(); }
    public void setNombre(String nombre) { this.nombre.set(nombre); }

    public StringProperty apellidosProperty() { return apellidos; }
    public String getApellidos() { return apellidos.get(); }
    public void setApellidos(String apellidos) { this.apellidos.set(apellidos); }

    public StringProperty correoProperty() { return correo; }
    public String getCorreo() { return correo.get(); }
    public void setCorreo(String correo) { this.correo.set(correo); }

    public StringProperty generoProperty() { return genero; }
    public String getGenero() { return genero.get(); }
    public void setGenero(String genero) { this.genero.set(genero); }

    public ObjectProperty<LocalDate> nacimientoProperty() { return nacimiento; }
    public LocalDate getNacimiento() { return nacimiento.get(); }
    public void setNacimiento(LocalDate nacimiento) { this.nacimiento.set(nacimiento); }

    public StringProperty paisProperty() { return pais; }
    public String getPais() { return pais.get(); }
    public void setPais(String pais) { this.pais.set(pais); }

    @Override
    public String toString() {
        return apellidos.get() + ", " + nombre.get() + " - " + pais.get();
    }
}
