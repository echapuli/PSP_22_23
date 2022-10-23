/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorialhilos;

/**
 *
 * @author Eduardo
 */
public class Valores {
     private static int factorial; 
     private static String cadena;

    public Valores() {
    }

    public static int getFactorial() {
        return factorial;
    }

    public static void setFactorial(int factorial) {
        Valores.factorial = factorial;
    }

    public static String getCadena() {
        return cadena;
    }

    public static void setCadena(String cadena) {
        Valores.cadena = cadena;
    }
     
}
