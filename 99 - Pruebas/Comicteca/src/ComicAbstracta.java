public abstract class ComicAbstracta implements ComicInterfaz {
    protected String titulo;
    protected String autor;
    protected int publicacion;
    protected String isbn;
    protected String portada;
    protected String trasera;

    public ComicAbstracta(String titulo, String autor, int publicacion, String isbn, String portada, String trasera) {
        this.titulo = titulo;
        this.autor = autor;
        this.publicacion = publicacion;
        this.isbn = isbn;
        this.portada = portada;
        this.trasera = trasera;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getFechaPublicacion() { return publicacion; }
    public String getISBN() { return isbn; }

    public abstract void mostrarInformacion();
}