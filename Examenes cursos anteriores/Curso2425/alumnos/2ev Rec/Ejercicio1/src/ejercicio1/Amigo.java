/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

/**
 *
 * @author robgarbor
 */
public class Amigo extends Persona {
     public String telefono;

       public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
     
     
     
     
   class amigo extends Persona implements personas {

        private final String telefono;

        @Override
        public String nombre() {
            return null;
        }

        @Override
        public String email() {
            return null;
        }

        @Override
        public char Sexo() {
            return 0;
        }
        public amigo( String nombre,  String email, char sexo,String telefono){
        this.email= email;
        this.nombre =nombre;
        this.sexo = sexo;
        this.telefono = telefono;
        }
    }
  
   
    /**
     * @return the telefono
     */
  
  
}

