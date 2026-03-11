/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testvehiculos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author ja.buenoseva
 */
public class TestVehiculos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // Fecha de inicio
        LocalDate fechaInicio = LocalDate.now();
        // crear la lista para los vehículos
        System.out.println("Creando Lista de vehiculos");
        //to do
        ArrayList<VehiculoInteligente> lista = new ArrayList<>();
        // Crear vehiculos y añadir a la lista
        System.out.println("\nCreando y añadiendo vehivulos a la lista");
        Dron dron = new Dron("Marca Dron 1", "Modelo A", 2025, 1, 10);
        lista.add(dron);
        dron = new Dron("Marca Dron 2", "Modelo B", 2020, 1, 20);
        lista.add(dron);
        dron = new Dron("Marca Dron 3", "Modelo C", 2023, 1, 30);
        lista.add(dron);
        Coche coche = new Coche("Seat", "Ibiza", 2015, "1234 ABS", 5);
        lista.add(coche);
        coche = new Coche("Seat", "Leon", 2025, "1221 BBB", 5);
        lista.add(coche);
        coche = new Coche("Fiat", "Panda", 2026, "5678 MMM", 4);
        lista.add(coche);

        System.out.println("\nMostrando datos iniciales de los vehículos");
        for (VehiculoInteligente v : lista) {
            v.mostrarInformacion();
            System.out.println("dias desde mantenimiento: " + v.diasDesdeUltimoMantenimiento());
            System.out.println("");
        }
        // Recargamos todos los vehículos
        System.out.println("\nRecargando todos los vehiculos");
        System.out.println("------------------------------");

        for (VehiculoInteligente v : lista) {
            if (v instanceof Dron) {
                System.out.println("Recargando Dron");
                ((Dron) v).recargar(100);
            }
            if (v instanceof Coche) {
                System.out.println("Recargando Coche");
                ((Coche) v).recargar(100);
            }
            Thread.sleep(500);
            v.mostrarInformacion();
            System.out.println("dias desde mantenimiento: " + v.diasDesdeUltimoMantenimiento());
            System.out.println("");

        }
        System.out.println("Vehiculos recargados");
        System.out.println("--------------------");
        //coche.recargar(100);
        System.out.println("\nEncendiendo Coche");
        if (coche.powerOn()) {
            System.out.println("Encendido: " + coche.getTiempoEncendido());
        }
        Thread.sleep(2000);
        System.out.println("\n Apagando coche tras 2 segundos para comprobar el tiempo de encendido");
        coche.powerOff();
        System.out.println("\nEncendiendo coche para comprobar ejecucion de modulos");
        System.out.println("Encendido: " + coche.getTiempoEncendido());
        coche.mostrarInformacion();
        coche.powerOn();
        System.out.println("Ejecutar 5 modulos. Total 150 de energia");
        coche.ejecutarModulo("Conectar GPS1");
        coche.ejecutarModulo("Conectar GPS2");
        coche.ejecutarModulo("Conectar GPS3");
        coche.ejecutarModulo("Conectar GPS4");
        coche.ejecutarModulo("Conectar GPS5");

        System.out.println("\nComprobando la repetición de encendido y apagado consecutivo");
        System.out.println("--- Encender ---");
        coche.recargar(50);
        Thread.sleep(1000);
        System.out.println("Realizamos el Primer encendido");
        coche.powerOn();
        Thread.sleep(2000);
        System.out.println("Realizamos el Segundo encendido");
        Thread.sleep(1000);
        coche.powerOn();
        System.out.println("Realizamos el Primer apagado");
        coche.powerOff();
        Thread.sleep(2000);
        System.out.println("Realizamos el Segundo apagado");
        Thread.sleep(1000);
        coche.powerOn();
        coche.mostrarInformacion();

        System.out.println("\nProgramar mantenimiento");
        LocalDate fecha;
        fecha = coche.programarMantenimiento(365);
        String fechaStr = fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println(fechaStr);
        coche.mostrarInformacion();

    }

}
