/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librointerfaz;

/**
 *
 * @author josgimgar3
 */
public class LibroNoFiccion extends LibroAbstracta{
    private String tema;

    public LibroNoFiccion(String titulo, String autor, int publicacion, String ISBN, String tema) {
        super(titulo, autor, publicacion, ISBN);
        this.tema = tema;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    @Override
    public String toString() {
        return super.toString() + "LibroNoFiccion{" + "tema=" + tema + '}';
    }
    
}
