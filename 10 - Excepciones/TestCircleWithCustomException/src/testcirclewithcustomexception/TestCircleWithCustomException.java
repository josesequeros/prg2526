/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testcirclewithcustomexception;

/**
 *
 * @author ja.buenoseva
 */
public class TestCircleWithCustomException {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            new CircleWithCustomException(5);
            new CircleWithCustomException(-5);
            new CircleWithCustomException(0);
        } catch (InvalidRadiusException ex) {
            System.out.println(ex);
        }

        System.out.println("Number of objects created: "
                + CircleWithException.getNumberOfObjects());
        System.out.println("Number of objects Custom created: "
                + CircleWithCustomException.getNumberOfObjects());
    }
}

