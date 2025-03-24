/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejr1.java;
import java.util.ArrayList;
      




/**
 *
 * @author robgarbor
 */
public class Ejr1Java {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ArrayList<persona> trabajadores = new ArrayList();
        
        empleado trabajador1 = new empleado(100, "Angel", "Martinez Lorenzo", "empleado1@contabilidad.es");
        empleado trabajador2 = new empleado(200, "Bernardo", "Alba Lopez", "2empleado@gestion.es");
        empleado trabajador3 = new empleado(300, "Trabajador3", "Tercer Trabajador", "empleado3@gestion.es");
        Becario becario1 = new Becario("Universidad de Alicante", "Becario1", "Apellido1 Apellido2", "becario1@contabilidad.es");
        Becario becario2 = new Becario("Universidad de Elche", "Becario2", "Segundo Becario", "2becario@gestion.es");
        
        trabajadores.add(trabajador1);
        trabajadores.add(trabajador2);
        trabajadores.add(becario1);
        trabajadores.add(becario2);
        trabajadores.add(trabajador3);
               
        System.out.println(trabajador1.sueldo +" "+trabajador1.nombre +" " + trabajador1.apellidos +" "+ trabajador1.correo);
        System.out.println(trabajador2.sueldo +" "+trabajador2.nombre +" " + trabajador2.apellidos +" "+ trabajador2.correo);
        System.out.println(trabajador3.sueldo +" "+trabajador3.nombre +" " + trabajador3.apellidos +" "+ trabajador3.correo);
        System.out.println(becario1.universidad +" "+becario1.nombre +" " + becario1.apellidos +" "+ becario1.correo);
        System.out.println(becario2.universidad +" "+becario2.nombre +" " + becario2.apellidos +" "+ becario2.correo);

   
    }
    
}

 