/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testvehiculos;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author josgimgar3
 */
public class TestVehiculos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<VehiculoInteligente> lista;
        lista = new ArrayList(Arrays.asList(
                new DronReparto("5", 20, 120, "Marca Dron1", "Modelo A", 2020, 50),
                new DronReparto("5", 20, 120, "Marca Dron2", "Modelo B", 2020, 50)),
                new DronReparto("5", 20, 120, "Marca Dron3", "Modelo C", 2020, 50),
                new VehiculoInteligente("Seat", "Leon", 0, 0),
                new VehiculoInteligente("Seat", "Leon", 0, 0),
                new VehiculoInteligente("Seat", "Leon", 0, 0))
        );
       
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).mostrarinformacion();
        }
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).bateria = 100;
        }

    }

}
