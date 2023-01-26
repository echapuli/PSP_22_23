
package psp02ejercicio_14_cyclicbarrier;

import static java.lang.Thread.sleep;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal_CyclicBarrier {

    public static void main(String[] args) {
         int numeroHilos = 10; 
	 final CyclicBarrier barreraInicio = new CyclicBarrier(numeroHilos + 1); 
	 final CyclicBarrier barreraFin = new CyclicBarrier(numeroHilos+1); 
	
         //creamos los 10 hilos
         for (int i = 0; i < numeroHilos; i++) { 
            new Hilo(barreraInicio,barreraFin,i).start();
             try {
                 sleep(500);
             } catch (InterruptedException ex) {
                 Logger.getLogger(Principal_CyclicBarrier.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
        //cuando sale del bucle los hilos estan creados pero frenados
        try {
            barreraInicio.await(); //fuerza el cyclicBarrier 11 y hace que se ejecuten todos los hilos
            System.out.println ("Levantando barrera de inicio, todos los hilos han arrancado y los ejecuto");
            sleep(500);
            
            barreraFin.await();//fuerzo la finalización de todos los hilos y cuando llegue al 11 muestra en mensaje de abajo
        } catch (InterruptedException ex) {
            Logger.getLogger(Principal_CyclicBarrier.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BrokenBarrierException ex) {
            Logger.getLogger(Principal_CyclicBarrier.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         System.out.println("Finalizando programa");
         
    }
}
