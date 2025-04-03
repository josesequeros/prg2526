package com.mycompany.listviewejemplo;

public class Persona {

    //private final StringProperty Nombre = new SimpleStringProperty();
    //private final StringProperty Apellidos = new SimpleStringProperty();
    private String Nombre = new String();
    private String Apellidos = new String();

    public Persona(String nombre, String apellidos) {
        Nombre = nombre;
        Apellidos = apellidos;
    }

    public final String getNombre() {
        //return this.NombreProperty().get();
        return this.Nombre;
    }

    public final void setNombre(final String Nombre) {
        //this.NombreProperty().set(Nombre);
        this.Nombre = Nombre;
    }

    public final java.lang.String getApellidos() {
        return this.Apellidos;
    }

    public final void setApellidos(final String Apellidos) {
        this.Apellidos = Apellidos;
    }

    @Override
    public String toString() {
        return this.getApellidos() + ", " + this.getNombre();
    }

}
