/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prioridadescountdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eduardo
 */
public class Hilos extends Thread {

    private String nombre;
    private Prioridades p;
    private CountDownLatch cuentaAtras;

    public Hilos(String nombre, Prioridades p, CountDownLatch cuentaAtras, int pr) {
        this.nombre = nombre;
        this.p = p;
        this.cuentaAtras = cuentaAtras;
        this.setPriority(pr);
    }

    @Override
    public void run() {
        //Los hilos esperan hasta que el contador de CountDownLatch valga 0
        try {
            cuentaAtras.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilos.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (p.getPrioridad()!=this.getPriority()){
            this.yield(); //para que no haya una espera activa lo saco de ejecución
        }
        System.out.println(nombre + " prioridad " + this.getPriority());
        p.setPrioridad(p.getPrioridad()+1); //aumento la prioridad en uno
    }

}
