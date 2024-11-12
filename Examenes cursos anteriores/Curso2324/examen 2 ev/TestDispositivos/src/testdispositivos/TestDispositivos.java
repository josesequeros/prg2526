/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testdispositivos;

/**
 *
 * @author jabue
 */
public class TestDispositivos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DispositivoElectronico[] dispositivos = new DispositivoElectronico[6];
        dispositivos[0] = new Smartphone(1, 8, 100, "Apple", "iphone X", 2000);
        dispositivos[1] = new Smartphone(2, 12, 90, "marca 2", "modelo 2", 2020);
        dispositivos[2] = new Portatil(15, "windows 10", "usuario1", "pass1", 80, "hp", "pavilion 1", 2003);
        dispositivos[3] = new Portatil(13, "windows 11", "usuario2", "pass2", 80, "toshiba", "modelo p2", 2004);
        dispositivos[4] = new PCSobremesa("Linux", "usuario4", "pass4", "servidor", "ibm", "modelo4", 2004);
        dispositivos[5] = new PCSobremesa("Widnows 10", "usuario5", "pass5", "cliente", "hp", "modelo5", 2005);
        for (DispositivoElectronico dispositivo : dispositivos) {
            dispositivo.powerOn();
            System.out.println(dispositivo);
            dispositivo.mostrarInformacion();
            dispositivo.powerOff();
            System.out.println(dispositivo);
            dispositivo.mostrarInformacion();
        }
    }
    
}
