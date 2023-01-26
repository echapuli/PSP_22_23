
package psp02ejercicio_14_cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hilo extends Thread{
    CyclicBarrier barreraInicio;
    CyclicBarrier barreraFin;
    int i;
    
    public Hilo(CyclicBarrier barreraInicio, CyclicBarrier barreraFin, int i){
        this.barreraInicio = barreraInicio;
        this.barreraFin=barreraFin;
        this.i=i;
    }
    public void run() { 
        try {
            System.out.println("Iniciando el hilo "+i);
            //freno la ejecución del hilo
            barreraInicio.await();
            //cuando se generen los 10 hilos se ejecutan
            System.out.println("hilo "+i+" ejecutandose"); 
            
            barreraFin.await();
 
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BrokenBarrierException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
	
    }

}
