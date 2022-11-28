/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programawc_v2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Eduardo
 */
public class ProgramaWC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //creo el WC
        WC wc=new WC();
        //crea un objeto random
        Random rand = new Random();
        int tiempo;
        final int NUMPERSONAS = 10;
        for (int i = 1; i <= NUMPERSONAS; i++) {
           Persona persona=new Persona("P"+i,wc);
           System.out.println("La persona P"+i+" va al WC");
           persona.start();
           // genera un número entre 1000 y 2000 milisegundos
           tiempo = rand.nextInt(1001)+1000;             
            try {
                Thread.sleep(tiempo); //tiempo entre 1000 y 2000 milisegundos
            } catch (InterruptedException ex) {
                Logger.getLogger(ProgramaWC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
