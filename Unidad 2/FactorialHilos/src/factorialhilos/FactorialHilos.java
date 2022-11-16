/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorialhilos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eduardo
 */
public class FactorialHilos {
     private int factorial; //resultado factorial
     private String cadena; //cadena a mostrar
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            
            HiloFactorial hilo=new HiloFactorial(5); //factorial de 7
            hilo.start();
            try {
                hilo.join(); //para el hilo actual hasta que termine el hilo 'hilo'
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloFactorial.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(Valores.getCadena()+"="+Valores.getFactorial());

    }

    public int getFactorial() {
        return factorial;
    }

    public void setFactorial(int factorial) {
        this.factorial = factorial;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
    
}
