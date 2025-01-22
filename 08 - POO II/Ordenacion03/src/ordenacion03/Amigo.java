/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ordenacion03;

/**
 *
 * @author jabue
 */
public class Amigo {
        private String nombre;
        private String telefono;
        private String email;

        public Amigo(String nombre, String telefono, String email) {
            this.nombre = nombre;
            this.telefono = telefono;
            this.email = email;
        }

        @Override
        public String toString() {
            return nombre + "\t telefono=" + telefono + "\t email=" + email ;
        }   

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public int compareTo(Amigo amigo) {
        return this.getTelefono().compareTo(amigo.getTelefono());
    }
        
        
}
