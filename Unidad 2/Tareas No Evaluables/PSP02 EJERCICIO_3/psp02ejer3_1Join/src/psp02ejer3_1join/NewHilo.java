/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package psp02ejer3_1join;

public class NewHilo implements Runnable {

    private String name; // nombre del hilo
    private Thread t;

    NewHilo(String threadname) {
        name = threadname;
        t = new Thread(this, name);
    }

    public void start() {
        System.out.println("Arranca hilo: " + name);
        t.start(); // Comienza el hilo      
    }

    public void run() {// Este es el punto de entrada del hilo
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupcion del hilo " + name);
        }
        System.out.println("Sale del hilo " + name);
    }

    public Thread getT() {
        return t;
    }

}
