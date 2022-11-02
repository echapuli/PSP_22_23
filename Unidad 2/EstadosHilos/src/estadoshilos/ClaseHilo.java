/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estadoshilos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eduardo
 */
public class ClaseHilo extends Thread{
    private int segundos;
    public ClaseHilo(String nombre, int segundos) {
        this.setName(nombre);
        this.segundos=segundos;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.getName()+" se va a dormir "+segundos+" segundos");
            sleep(segundos*1000); //el tiempo se da en milisegundos
            System.out.println(this.getName()+" deaspierta, su estado es "+this.getState());            
        } catch (InterruptedException ex) {
            Logger.getLogger(ClaseHilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
