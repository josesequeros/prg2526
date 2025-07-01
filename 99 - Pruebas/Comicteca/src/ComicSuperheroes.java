public class ComicSuperheroes extends ComicAbstracta {
    private String universo;

    public ComicSuperheroes(String titulo, String autor, int publicacion, String isbn, String portada, String trasera, String universo) {
        super(titulo, autor, publicacion, isbn, portada, trasera);
        this.universo = universo;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("📘 Comic de Superhéroes:");
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Año: " + publicacion);
        System.out.println("ISBN: " + isbn);
        System.out.println("Portada: " + portada);
        System.out.println("Trasera: " + trasera);
        System.out.println("Universo: " + universo);
    }
}