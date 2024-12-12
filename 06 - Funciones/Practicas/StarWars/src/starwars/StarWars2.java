/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package starwars;

import java.util.Scanner;

/**
 *
 * @author Jabue
 */
public class StarWars2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int respuestaNumero;
        int respuesta = 0, tuRespuesta;
        int nivel = 0;

        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce el ancho del terreno: ");

        respuestaNumero = mostrarTexto("Hace mucho tiempo, en una galaxia muy, muy lejana… \n"
                + "La Princesa Leia, Luke Skywalker, Han Solo, Chewbacca, C3PO y R2D2 \n"
                + "viajan en una nave imperial robada en una misión secreta para \n"
                + "infiltrarse en otra estrella de la muerte que el imperio está \n"
                + "construyendo para destruirla. \n"
                + "(Presiona Intro para continuar)");
        entrada.nextLine();
        nivel = 1;
        while (nivel <= 5) {
            switch (nivel) {
                case 1:
                    respuesta = nivel1();
                    break;
                case 2:
                    respuesta = nivel2();
                    break;
                case 3:
                    respuesta = nivel3();
                    break;
                case 4:
                    respuesta = nivel4();
                    break;
                case 5:
                    respuesta = nivel5();
                    break;
                default:
                    nivel = 6;

            }

            System.out.print(respuesta + " Introduzca número: ");
            tuRespuesta = entrada.nextInt();
            if (respuesta == tuRespuesta) {
                nivel++;
                if (nivel > 5) {
                    System.out.println("Has Ganado");
                    break;
                }
            } else {
                System.out.println("Respuesta equivocada. Has perdido");
                break;
            }
        }
        //respuestaNumero = Integer.parseInt(respuesta);
        //System.out.println(respuestaNumero);
    }

    public static int mostrarTexto(String texto) {
        System.out.println(texto);
        System.out.println("");
        return 0;
    }

    public static int nivel1() {

        int sistema, sector;

        System.out.println("Nivel 1");
        sistema = (int) (1 + Math.random() * (11));
        sector = (int) (20 + Math.random() * (11));

        String texto = "Los problemas empiezan cuando deben realizar un salto hiperespacial hasta al\n"
                + "sistema " + sistema + " en el sector " + sector + ", pero el sistema de navegación está estropeado y el\n"
                + "computador tiene problemas para calcular parte de las coordenadas de salto.\n"
                + "Chewbacca, piloto experto, se da cuenta que falta el cuarto número de la serie.\n"
                + "Recuerda de sus tiempos en la academia de pilotos que para calcularlo hay que\n"
                + "calcular el sumatorio entre el nº del sistema y el nº del sector (ambos inclusive).\n"
                + "¿Qué debe introducir?";

        System.out.println(texto);
        int suma = 0;
        for (int i = sistema; i <= sector; i++) {
            suma += i;
        }

        return suma;
    }

    public static int nivel2() {
        int espacioPuerto, naveImperial;

        System.out.println("Nivel 2");
        espacioPuerto = (int) (1 + Math.random() * (7 - 1 + 1));
        naveImperial = (int) (8 + Math.random() * (12 - 8 + 1));

        String texto = "Gracias a Chewbacca consiguen llegar al sistema correcto y ven a lo lejos la estrella\n"
                + "de la muerte. Como van en una nave imperial robada se aproximan lentamente con\n"
                + "la intención de pasar desapercibidos. De repente suena el comunicador. “Aquí\n"
                + "agente de espaciopuerto " + espacioPuerto + " contactando con nave imperial " + naveImperial + ". No están destinados\n"
                + "en este sector. ¿Qué hacen aquí?”. Han Solo coge el comunicador e improvisa.\n"
                + "“Eh… tenemos un fallo en el… eh… condensador de fluzo... Solicitamos permiso\n"
                + "para atracar y reparar la nave”. El agente, que no se anda con tonterías, responde\n"
                + "“Proporcione código de acceso o abriremos fuego”. Han Solo ojea rápidamente el\n"
                + "manual del piloto que estaba en la guantera y da con la página correcta. El código\n"
                + "es el productorio entre el nº del agente y el nº de la nave (ambos inclusive).\n"
                + "¿Cuál es el código?";

        System.out.println(texto);
        int producto = 1;
        for (int i = espacioPuerto; i <= naveImperial; i++) {
            producto *= i;
        }

        return producto;
    }

    public static int nivel3() {
        int niveles;

        System.out.println("Nivel 3");
        niveles = (int) (50 + Math.random() * (100 - 50 + 1));

        String texto = "Han Solo proporciona el código correcto. Atracan en la estrella de la muerte, se\n"
                + "equipan con trajes de soldados imperiales que encuentran en la nave para pasar\n"
                + "desapercibidos y bajan. Ahora deben averiguar en qué nivel de los " + niveles + " existentes se\n"
                + "encuentra el reactor principal. Se dirigen al primer panel computerizado que\n"
                + "encuentran y la Princesa Leia intenta acceder a los planos de la nave pero necesita\n"
                + "introducir una clave de acceso. Entonces recuerda la información que le proporcionó\n"
                + "Lando Calrissian “La clave de acceso a los planos de la nave es el factorial de N/10\n"
                + "(redondeando N hacia abajo), donde N es el nº de niveles”.\n"
                + "¿Cual es el nivel correcto?";

        System.out.println(texto);
        int nivelCorrecto = factorial((int) (niveles / 10));

        return nivelCorrecto;
    }

    public static int nivel4() {
        int numeroGenerado;
        boolean acierto = false;
        int respuesta;
        int codigo;

        System.out.println("Nivel 4");
        numeroGenerado = (int) (10 + Math.random() * (7 - 1 + 1));

        String texto = "Gracias a la inteligencia de Leia llegan al nivel correcto y encuentran la puerta\n"
                + "acorazada que da al reactor principal. R2D2 se conecta al panel de acceso para\n"
                + "intentar hackear el sistema y abrir la puerta. Para desencriptar la clave necesita\n"
                + "verificar si el número " + numeroGenerado + " es primo o no. Si es primo introduce un 1, si no lo es\n"
                + "introduce un 0.";
        System.out.println(texto);
        if (esPrimo(numeroGenerado)) {
            codigo = 1;
        } else {
            codigo = 0;
        }

        return codigo;
    }

    public static int nivel5() {
        int minutos, segundos;

        System.out.println("Nivel 5");
        minutos = (int) (5 + Math.random() * (10 - 5 + 1));
        segundos = (int) (5 + Math.random() * (10 - 5 + 1));

        String texto = "Consiguen entrar al reactor. Ya solo queda que Luke Skywalker coloque la bomba,\n"
                + "programe el temporizador y salir de allí corriendo. Necesita programarlo para que\n"
                + "explote en exactamente " + minutos + " minutos y " + segundos + " segundos, el tiempo suficiente para escapar\n"
                + "antes de que explote pero sin que el sistema de seguridad anti-explosivos detecte y\n"
                + "desactive la bomba. Pero el temporizador utiliza un reloj Zordgiano un tanto\n"
                + "peculiar. Para convertir los minutos y segundos al sistema Zordgiano hay que sumar\n"
                + "el factorial de M y el factorial de S. ¿Qué valor debe introducir?";

        System.out.println(texto);
        int zordgiano = factorial(minutos) + factorial(segundos);

        return zordgiano;
    }

    public static int factorial(int n) {
        int factorial = 1;
        while (n > 0) {
            factorial *= n--;
        }
        return factorial;
    }

    public static boolean esPrimo(int numero) {
        int divisor;
        boolean puedeSerlo;
        if (numero == 2 || numero == 1) {
            return true;
        } else if (numero < 1 || numero % 2 == 0) {
            return false;           // <n> no es primo
        } else {                      // Se buscan posibles divisores impares de <n>
            puedeSerlo = true;      // <n> es candidato a primo
            divisor = 3;            // primer divisor a probar
            while (puedeSerlo && divisor * divisor <= numero) {     // menor que la raíz cuadrada 
                puedeSerlo = numero % divisor > 0;                  // ¿ aún sin divisores?
                divisor = divisor + 2; 			                    // sig. divisor a probar
            }
            return puedeSerlo;
        }
    }

}
