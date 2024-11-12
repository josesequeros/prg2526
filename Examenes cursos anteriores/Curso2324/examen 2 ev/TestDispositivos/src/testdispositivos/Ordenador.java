/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package testdispositivos;

/**
 *
 * @author jabue
 */
public interface Ordenador {
    public boolean logon(String usuario, String password);
    public void logoff();
    public void ejecutarAplicacion(String aplicacion);
}
