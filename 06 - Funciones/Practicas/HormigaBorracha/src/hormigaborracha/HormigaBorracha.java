/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hormigaborracha;

import java.util.Scanner;

/**
 *
 * @author IEUser
 */
public class HormigaBorracha {

    static int dimensionTablero;    // dimensión del tablero
    static int movimientosHormiga;  // número de movimientos que debe realizar la hormiga
    static int terronesAzucar;  // número de terrones solo de azucar
    static int terronesLicor;   // número de terrones con licor
    static int terronesVeneno;  // número de terrones con veneno
    static int filaInicial, columnaInicial; // posición inicial de la hormiga
    static int movimientosEbria;    // número de movimientos aleatorios a sumar
    static int ebria = 0;   // movimientos a realizar aleatoriamente

    final static int libre = 0;
    final static int terronConAzucar = 1;
    final static int terronConLicor = 2;
    final static int terronConVeneno = 3;
    final static int hormiga = 5;

    final static int arriba = 0;
    final static int derecha = 1;
    final static int abajo = 2;
    final static int izquierda = 3;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        pedirDatos();
        int[][] tablero = new int[dimensionTablero][dimensionTablero];
        //HormigaBorracha juego = new HormigaBorracha();

        System.out.println("Tablero: " + dimensionTablero + " * " + dimensionTablero);
        System.out.println("Movimientos a Realizar: " + movimientosHormiga);
        System.out.println("Terrones de Azucar: " + terronesAzucar);
        System.out.println("Terrones de Licor: " + terronesLicor);
        System.out.println("Terronesde Veneno: " + terronesVeneno);
        System.out.println("Posición Inicial: Fila: " + filaInicial + " Columna: " + columnaInicial);
        System.out.println("Número de movimientos se está ebria: " + movimientosEbria);

        // Crear Tablero
        crearTablero(tablero);
        visualizarTablero(tablero);

        int[][] camino = new int[movimientosHormiga + 1][];
        camino[0] = new int[]{filaInicial, columnaInicial};
        empiezaJuego(tablero, camino);
        
        int pasos = visualizarCamino(tablero, camino);
        System.out.println("");
        if (pasos<movimientosHormiga){
            System.out.print("Nuestra amiga ha fallecido");
        }
        else {
            System.out.print("Nuestra amiga ha completado su recorrido");
        }
        if (ebria>0){
            System.out.println(" ebria");
        }
        else {
            System.out.println(" serena");
        }
        System.out.println("");
        visualizarTablero(tablero);
    }

    public static void pedirDatos() {
        Scanner sc = new Scanner(System.in);

        /*
        System.out.print("Tamaño de la cuadrícula: ");
        dimensionTablero = sc.nextInt();
        System.out.print("Movimientos a realizar por la Hormiga: ");
        movimientosHormiga = sc.nextInt();
        System.out.println("Terrenos de Azucar");
        System.out.print("Normales: ");
        terronesAzucar = sc.nextInt();
        System.out.print("Con Licor: ");
        terronesLicor = sc.nextInt();
        System.out.print("Veneno: ");
        terronesVeneno = sc.nextInt();
        System.out.println("Posición inicial de la Hormiga: ");
        System.out.println("Fila: ");
        FilaInicial = sc.nextInt();
        System.out.println("Columna: ");
        columnaInicial = sc.nextInt();
        System.out.print("Movimientos si está Ebria: ");
        movimientosEbria = sc.nextInt();
         */
        dimensionTablero = 10;
        movimientosHormiga = 20;
        terronesAzucar = 5;
        terronesLicor = 14;
        terronesVeneno = 13;
        filaInicial = 0;
        columnaInicial = 0;
        movimientosEbria = 5;
    }

    public static void crearTablero(int[][] tablero) {

        int azucar = 0, licor = 0, veneno = 0;

        for (int fila = 0; fila < dimensionTablero; fila++) {
            for (int columna = 0; columna < dimensionTablero; columna++) {
                tablero[fila][columna] = 0;
            }
        }

        tablero[filaInicial][columnaInicial] = hormiga;
        // Rellenar Tablero
        while (azucar < terronesAzucar) {
            int fila = (int) (Math.random() * (dimensionTablero));
            int columna = (int) (Math.random() * (dimensionTablero));
            if (tablero[fila][columna] == libre) {
                tablero[fila][columna] = terronConAzucar;
                azucar++;
            }
        }
        while (licor < terronesLicor) {
            int fila = (int) (Math.random() * (dimensionTablero));
            int columna = (int) (Math.random() * (dimensionTablero));
            if (tablero[fila][columna] == libre) {
                tablero[fila][columna] = terronConLicor;
                licor++;
            }
        }
        while (veneno < terronesVeneno) {
            int fila = (int) (Math.random() * (dimensionTablero));
            int columna = (int) (Math.random() * (dimensionTablero));
            if (tablero[fila][columna] == libre) {
                tablero[fila][columna] = terronConVeneno;
                veneno++;
            }
        }
    }

    public static void visualizarTablero(int[][] tablero) {
        for (int fila = 0; fila < dimensionTablero; fila++) {
            for (int columna = 0; columna < dimensionTablero; columna++) {
                //System.out.printf("%3d", tablero[fila][columna]);
                switch (tablero[fila][columna]) {
                    case libre:
                        System.out.print(" . ");
                        break;
                    case terronConAzucar:
                        System.out.print(" A ");
                        break;
                    case terronConLicor:
                        System.out.print(" L ");
                        break;
                    case terronConVeneno:
                        System.out.print(" V ");
                        break;
                    case hormiga:
                        System.out.print(" h ");
                        break;
                    default:

                        throw new AssertionError();
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static void empiezaJuego(int[][] tablero, int[][] camino) {
        int direccion = (int) (Math.random() * 4);
        int movimiento = 0;
        int fila = filaInicial;
        int columna = columnaInicial;

        while (movimiento < movimientosHormiga) {
            if (ebria > 0) {
                direccion = (int) (Math.random() * 4);
            }
            switch (direccion) {
                case arriba ->
                    fila--;
                case derecha ->
                    columna++;
                case abajo ->
                    fila++;
                case izquierda ->
                    columna--;
            }
            if (fila >= dimensionTablero || fila < 0 || columna >= dimensionTablero || columna < 0) {
                switch (direccion) {
                    case arriba ->
                        fila++;
                    case derecha ->
                        columna--;
                    case abajo ->
                        fila--;
                    case izquierda ->
                        columna++;
                }
                direccion = (int) (Math.random() * 4); // movimiento aleatorio, no por ebria sino por salir del tablero
            } else {
                movimiento++;
                if (ebria > 0) {
                    ebria--;
                }
                camino[movimiento] = new int[]{fila, columna};
                //System.out.println("Movimiento: " + movimiento);
                //visualizarCamino(camino);
                switch (tablero[fila][columna]) {
                    case libre -> {
                        //tablero[fila][columna] = hormiga;
                    }
                    case terronConAzucar -> {
                        //tablero[fila][columna] = hormiga;
                        ebria = 0;
                    }
                    case terronConLicor -> {
                        //tablero[fila][columna] = hormiga;
                        ebria += movimientosEbria;
                    }
                    case terronConVeneno -> {
                        //tablero[fila][columna] = hormiga;
                        if (ebria > 0) {
                            movimiento = 20;
                        }
                    }
                }
                
            }
        }
    }

    public static int visualizarCamino(int[][] tablero, int[][] camino) {
        int pasos = 0;
        
        for (int[] is : camino) {
            if (is != null) {
                System.out.print("(" + is[0] + "," + is[1] + ") ");
                pasos++;
                tablero[is[0]][is[1]] = hormiga;
            }
        }
        /*
        for (int i = 0; i < camino.length; i++) {
            
            System.out.print("("+camino[i][0] + "," + camino[i][1]+") ");
        }
         */
        System.out.println("");
        return pasos;
    }

}
