/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen2eva.excepciones;

/**
 *
 * @author IEUser
 */
public class EmailExcepcion extends Exception{
    String mensaje;
    @Override
    public String getMessage() {
        return "email incorrecto";  //super.getMessage(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
}
