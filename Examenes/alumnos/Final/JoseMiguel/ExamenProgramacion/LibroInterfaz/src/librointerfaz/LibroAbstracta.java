/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librointerfaz;

/**
 *
 * @author josgimgar3
 */
public class LibroAbstracta {

    private String titulo;
    private String autor;
    private int publicacion;
    private String ISBN;

    public LibroAbstracta(String titulo, String autor, int publicacion, String ISBN) {
        this.titulo = titulo;
        this.autor = autor;
        this.publicacion = publicacion;
        this.ISBN = ISBN;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setPublicacion(int publicacion) {
        this.publicacion = publicacion;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getPublicacion() {
        return publicacion;
    }

    public String getISBN() {
        return ISBN;
    }
//El toString seria el equivalente a  mostrarInformacion()
    @Override
    public String toString() {
        return "LibroAbstracta{" + "titulo=" + titulo + ", autor=" + autor + ", publicacion=" + publicacion + ", ISBN=" + ISBN + '}';
    }

    
   
    
}
