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
public class EstadosHilos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClaseHilo hilo;
        Thread.currentThread().setName("Hilo principal");
        System.out.println("Ejecutando " + Thread.currentThread().getName());

        hilo = new ClaseHilo("Hilo hijo", 6); //duerme 6 segundos
        System.out.println("Despues del new el " + hilo.getName() + " su estado es " + hilo.getState());
        hilo.start();
        System.out.println("Despues del start el " + hilo.getName() + ", su estado es " + hilo.getState());
        try {
            Thread.currentThread().sleep(1000);
            System.out.println("Mientras duerme el " + hilo.getName() + " su estado es " + hilo.getState());
            hilo.join(); //el hilo que lo invoca no continua hasta que termina el hilo invocado
        } catch (InterruptedException ex) {
            Logger.getLogger(EstadosHilos.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Una vez finalizado el " + hilo.getName() + " su estado es " + hilo.getState());

        System.out.println("Finalizando " + Thread.currentThread().getName());
    }

}
