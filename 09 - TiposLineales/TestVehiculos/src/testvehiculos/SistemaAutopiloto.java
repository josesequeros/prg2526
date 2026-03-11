/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package testvehiculos;

/**
 *
 * @author ja.buenoseva
 */
public interface SistemaAutopiloto {
    public boolean iniciarSesion(String usuario, String password);
    public void cerraSesion();
    public void ejecutarModulo(String modulo);
}
