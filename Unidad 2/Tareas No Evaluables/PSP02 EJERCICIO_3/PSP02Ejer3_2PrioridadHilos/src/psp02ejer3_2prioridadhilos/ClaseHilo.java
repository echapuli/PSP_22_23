/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp02ejer3_2prioridadhilos;

/**
 *
 * @author Eduardo
 */
public class ClaseHilo implements Runnable{

    int cont = 0;
    Thread hilo;
    private volatile boolean running = true;

    public ClaseHilo(int p, String nom) {
        hilo = new Thread(this);
        hilo.setPriority(p);
        hilo.setName(nom);
    }

    public void run() {
        // ejecutamos el bucle de forma infinita 
        //hasta que lo obliguemos a parar metodo stop
        while (running) {
            cont++;
        }
        System.out.println("hilo: " + Thread.currentThread().getName() + " contador=" + cont);
    }

    public void stop() {
        running = false;
    }

    public void start() {
        hilo.start();
    }

}
