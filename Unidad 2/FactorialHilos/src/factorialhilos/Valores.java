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
     private volatile static int factorial; 
     private volatile static String cadena;

    public static int getFactorial() {
        return factorial;
    }

    public static void setFactorial(int fac) {
        factorial = fac;
    }

    public static String getCadena() {
        return cadena;
    }

    public static void setCadena(String cad) {
        cadena = cad;
    }
     
}
