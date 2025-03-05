/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package contarpalabras;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author jabue
 */
public class ContarPalabras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Set text in a string
        String text = "Buenas tardes. Tengo buenas sensaciones para la tarde de hoy. "
                + "Pasemos un rato divertido!";
        text = """
               Por cuanto por parte de vos, Miguel de Cervantes, nos fue fecha relación
que habíades compuesto un libro intitulado El ingenioso hidalgo de la
Mancha, el cual os había costado mucho trabajo y era muy útil y provechoso,
nos pedistes y suplicastes os mandásemos dar licencia y facultad para le
poder imprimir, y previlegio por el tiempo que fuésemos servidos, o como la
nuestra merced fuese; lo cual visto por los del nuestro Consejo, por cuanto
en el dicho libro se hicieron las diligencias que la premática últimamente
por nos fecha sobre la impresión de los libros dispone, fue acordado que
debíamos mandar dar esta nuestra cédula para vos, en la dicha razón; y nos
tuvímoslo por bien. Por la cual, por os hacer bien y merced, os damos
licencia y facultad para que vos, o la persona que vuestro poder hubiere, y
no otra alguna, podáis imprimir el dicho libro, intitulado El ingenioso
hidalgo de la Mancha, que desuso se hace mención, en todos estos nuestros
reinos de Castilla, por tiempo y espacio de diez años, que corran y se
cuenten desde el dicho día de la data desta nuestra cédula; so pena que la
persona o personas que, sin tener vuestro poder, lo imprimiere o vendiere,
o hiciere imprimir o vender, por el mesmo caso pierda la impresión que
hiciere, con los moldes y aparejos della; y más, incurra en pena de
cincuenta mil maravedís cada vez que lo contrario hiciere. La cual dicha
pena sea la tercia parte para la persona que lo acusare, y la otra tercia
parte para nuestra Cámara, y la otra tercia parte para el juez que lo
sentenciare. Con tanto que todas las veces que hubiéredes de hacer imprimir
el dicho libro, durante el tiempo de los dichos diez años, le traigáis al
nuestro Consejo, juntamente con el original que en él fue visto, que va
rubricado cada plana y firmado al fin dél de Juan Gallo de Andrada, nuestro
Escribano de Cámara, de los que en él residen, para saber si la dicha
impresión está conforme el original; o traigáis fe en pública forma de cómo
por corretor nombrado por nuestro mandado, se vio y corrigió la dicha
impresión por el original, y se imprimió conforme a él, y quedan impresas
las erratas por él apuntadas, para cada un libro de los que así fueren
impresos, para que se tase el precio que por cada volume hubiéredes de
haber. Y mandamos al impresor que así imprimiere el dicho libro, no imprima
el principio ni el primer pliego dél, ni entregue más de un solo libro con
el original al autor, o persona a cuya costa lo imprimiere, ni otro alguno,
para efeto de la dicha correción y tasa, hasta que antes y primero el dicho
libro esté corregido y tasado por los del nuestro Consejo; y, estando
hecho, y no de otra manera, pueda imprimir el dicho principio y primer
pliego, y sucesivamente ponga esta nuestra cédula y la aprobación, tasa y
erratas, so pena de caer e incurrir en las penas contenidas en las leyes y
premáticas destos nuestros reinos. Y mandamos a los del nuestro Consejo, y
a otras cualesquier justicias dellos, guarden y cumplan esta nuestra cédula
y lo en ella contenido. Fecha en Valladolid, a veinte y seis días del mes
de setiembre de mil y seiscientos y cuatro años.""";
        // Create a TreeMap to hold words as key and count as value
        Map<String, Integer> map = new TreeMap<>();

        String[] words = text.split("[\\s+\\p{P}]");
        for (int i = 0; i < words.length; i++) {
            String key = words[i].toLowerCase();

            if (key.length() > 0) {
                if (!map.containsKey(key)) {
                    map.put(key, 1);
                } else {
                    int value = map.get(key);
                    value++;
                    map.put(key, value);
                }
            }
        }

        // Display key and value for each entry
        map.forEach((k, v) -> System.out.println(k + "\t" + v));
    }
}
