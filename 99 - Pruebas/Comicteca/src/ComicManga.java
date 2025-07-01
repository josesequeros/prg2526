public class ComicManga extends ComicAbstracta {
    private String genero;

    public ComicManga(String titulo, String autor, int publicacion, String isbn, String portada, String trasera, String genero) {
        super(titulo, autor, publicacion, isbn, portada, trasera);
        this.genero = genero;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("📗 Comic Manga:");
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Año: " + publicacion);
        System.out.println("ISBN: " + isbn);
        System.out.println("Portada: " + portada);
        System.out.println("Trasera: " + trasera);
        System.out.println("Género: " + genero);
    }
}