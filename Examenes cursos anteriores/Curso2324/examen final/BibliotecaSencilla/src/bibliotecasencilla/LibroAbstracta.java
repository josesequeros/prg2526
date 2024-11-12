/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecasencilla;

/**
 *
 * @author jabue
 */
public abstract class LibroAbstracta implements LibroInterfaz{
    protected String titulo;
    protected String autor;
    protected int fechaPublicacion;
    protected String isbn;
    protected String portada;

    public LibroAbstracta(String titulo, String autor, int fechaPublicacion, String isbn, String portada) {
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.isbn = isbn;
        this.portada = portada;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getFechaPublicacion() {
        return fechaPublicacion;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPortada() {
        return portada;
    }
    
    @Override
    public abstract void mostrarInformacion();

 
    
}
