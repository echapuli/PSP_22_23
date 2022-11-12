/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp02ejer3_2prioridadhilos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eduardo
 */
public class PSP02Ejer3_2PrioridadHilos {

    public static void main(String[] args) {
            
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        ClaseHilo hiloHIGH
                = new ClaseHilo(Thread.NORM_PRIORITY + 2, "hiloHIGH");
        ClaseHilo hiloLOW
                = new ClaseHilo(Thread.NORM_PRIORITY - 2, "hiloLOW");
        hiloLOW.start();
        hiloHIGH.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Hilo principal interrumpido.");
        }
        hiloLOW.stop();
        hiloHIGH.stop();
        System.out.println("hiloLOW: " + hiloLOW.hilo.isAlive() + " " + hiloLOW.hilo.getState());
        System.out.println("hiloHIGH: " + hiloHIGH.hilo.isAlive() + " " + hiloHIGH.hilo.getState());

        try {
            //forzamos a que antes de continuar el proceso main se ejecuten
            // y finalicen hiloLOW y hiloHIGH  -- join() Aseguramos que finalicen los hilos
            
            hiloLOW.hilo.join();
            hiloHIGH.hilo.join();            
        } catch (InterruptedException ex) {
            Logger.getLogger(PSP02Ejer3_2PrioridadHilos.class.getName()).log(Level.SEVERE, null, ex);
        }


        System.out.println("hiloLOW: " + hiloLOW.hilo.isAlive() + " " + hiloLOW.hilo.getState());
        System.out.println("hiloHIGH: " + hiloHIGH.hilo.isAlive() + " " + hiloHIGH.hilo.getState());
    }

}

