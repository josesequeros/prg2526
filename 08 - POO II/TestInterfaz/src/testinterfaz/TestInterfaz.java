/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testinterfaz;

/**
 *
 * @author jabue
 */
public class TestInterfaz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Publicacion[] publicaciones = new Publicacion[4];
        publicaciones[0] = new Libro("codigo uno", "titulo uno", 10);
        publicaciones[1] = new Revista("Revista uno", "titulo Revista uno", 100, 1);
        publicaciones[2] = new Libro("codigo dos", "titulo dos", 20);
        publicaciones[3] = new Revista("Revista dos", "titulo Revista dosno", 200, 2);
        
        for (Publicacion p : publicaciones) {
            if (p instanceof Libro) {
                System.out.println(p);
                ((Libro) p).prestar();
                System.out.println(p);
                ((Libro) p).devolver();
                System.out.println(p);
            }
            if (p instanceof Revista) {
                System.out.println(((Revista) p).toString());
            }
            System.out.println("Publicacion: " + p);
            System.out.println("");
        }
    }

}

interface Prestable {

    public void prestar();

    public void devolver();

    public boolean estaPrestado();

}

class Publicacion {

    private String codigo;
    protected String titulo;
    public int anyo;

    Publicacion(String codigo, String titulo, int anyo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.anyo = anyo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public int getAnyo() {
        return this.anyo;
    }

    @Override
    public String toString() {
        return "Publicacion{" + "codigo=" + codigo + ", titulo=" + titulo + ", anyo=" + anyo + '}';
    }
    
    

}

class Libro extends Publicacion implements Prestable {

    private boolean prestado;

    Libro(String codigo, String titulo, int anyo) {
        super(codigo, titulo, anyo);
        this.prestado = false;
    }

    @Override
    public void prestar() {
        this.prestado = true;
    }

    @Override
    public void devolver() {
        this.prestado = false;
    }

    @Override
    public boolean estaPrestado() {
        return this.prestado;
    }

    private String dimePrestado() {
        if (this.prestado) {
            return "si";
        } else {
            return "no";
        }
    }

    @Override
    public String toString() {
        return "El libro con codigo " + getCodigo() + " con titulo " + this.titulo + " con año " + this.anyo + " y prestado " + dimePrestado();
    }
}

class Revista extends Publicacion {

    private int numero;

    Revista(String codigo, String titulo, int anyo, int numero) {
        super(codigo, titulo, anyo);
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "La revista con codigo " + getCodigo() + " con titulo " + this.titulo + " con año " + this.anyo + " y numero de revista " + this.numero;
    }
}
