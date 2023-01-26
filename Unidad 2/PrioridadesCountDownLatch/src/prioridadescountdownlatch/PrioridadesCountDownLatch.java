/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prioridadescountdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 *
 * @author eduardo
 */
public class PrioridadesCountDownLatch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Prioridades prioridad = new Prioridades(1); //inicialmente la prioridad a mirar es la más alta 1
        CountDownLatch cuentaAtras = new CountDownLatch(1); //creo CountDownLatch con contador igual a 1
        //creo y arranco los hilos
        for (int i = 1; i <= 10; i++) {
            Hilos h=new Hilos("hilo"+i,prioridad,cuentaAtras,prioridad.getPrioridades()[i-1]);
            h.start();
        }
        //decremento el contador de CountDownLatch (estaba en 1) pasa a 0 y arranca todos los hilos a la vez
        cuentaAtras.countDown();
    }

}
