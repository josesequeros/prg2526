/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librointerfaz;

/**
 *
 * @author josgimgar3
 */
public class LibroFiccion extends LibroAbstracta{
        private String genero;

    public LibroFiccion(String titulo, String autor, int publicacion, String ISBN, String genero) {
        super(titulo, autor, publicacion, ISBN);
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return super.toString() + "LibroFiccion{" + "genero=" + genero + '}';
    }
    
    
}
