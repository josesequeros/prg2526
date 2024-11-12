/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecasencilla;

/**
 *
 * @author jabue
 */
public class LibroNoFiccion extends LibroAbstracta {

    private String tema;

    public LibroNoFiccion(String titulo, String autor, int fechaPublicacion, String isbn, String portada, String tema) {
        super(titulo, autor, fechaPublicacion, isbn, portada);
        this.tema = tema;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println(
                "No Ficcion {"
                + "titulo=" + titulo
                + ", autor=" + autor
                + ", fechaPublicacion=" + fechaPublicacion
                + ", isbn=" + isbn
                + ", portada=" + portada
                + ", tema=" + this.tema
                + "}");
    }

    public String getTema() {
        return tema;
    }

}
