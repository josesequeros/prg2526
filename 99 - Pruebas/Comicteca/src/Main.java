public class Main {
    public static void main(String[] args) {
        Comicteca comicteca = new Comicteca();

        ComicSuperheroes batman = new ComicSuperheroes(
            "Batman: Año Uno",
            "Frank Miller",
            1987,
            "1234",
            "PortadaBatman.jpg",
            "TraseraBatman.jpg",
            "DC"
        );

        ComicManga naruto = new ComicManga(
            "Naruto",
            "Masashi Kishimoto",
            1999,
            "5678",
            "PortadaNaruto.jpg",
            "TraseraNaruto.jpg",
            "Shonen"
        );

        // Añadir cómics
        comicteca.addComic(batman);
        comicteca.addComic(naruto);

        // Mostrar todos
        System.out.println("📚 Mostrar Comicteca:");
        comicteca.mostrarComicteca();

        // Buscar por título
        System.out.println("\n🔍 Buscar 'Naruto':");
        ComicAbstracta buscado = comicteca.buscarComic("Naruto");
        if (buscado != null) {
            buscado.mostrarInformacion();
        } else {
            System.out.println("No encontrado.");
        }

        // Borrar un cómic
        System.out.println("\n🗑️ Borrar '1234' (Batman):");
        comicteca.borrarComic("1234");

        // Mostrar Comicteca final
        System.out.println("\n📚 Comicteca actualizada:");
        comicteca.mostrarComicteca();
    }
}