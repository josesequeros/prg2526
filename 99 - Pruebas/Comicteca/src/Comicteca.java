import java.util.ArrayList;
import java.util.List;

public class Comicteca {
    private List<ComicAbstracta> comics;

    public Comicteca() {
        comics = new ArrayList<>();
    }

    public void addComic(ComicAbstracta comic) {
        comics.add(comic);
    }

    public void borrarComic(String isbn) {
        comics.removeIf(c -> c.getISBN().equals(isbn));
    }

    public ComicAbstracta buscarComic(String titulo) {
        for (ComicAbstracta c : comics) {
            if (c.getTitulo().equalsIgnoreCase(titulo)) {
                return c;
            }
        }
        return null;
    }

    public void mostrarComicteca() {
        if (comics.isEmpty()) {
            System.out.println("La comicteca está vacía.");
            return;
        }
        for (ComicAbstracta c : comics) {
            c.mostrarInformacion();
            System.out.println("----------------------");
        }
    }
}