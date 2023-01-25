
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

	public class  Trabajador extends Thread {
		CountDownLatch x;
		String nombre;
 
		public Trabajador(CountDownLatch x, String nombre) {
			this.x = x;
			this.nombre = nombre;
		}
 
		public void run() {
                    try {
                        // frenamos la ejecución del hilo hasta la señal de countDown
                        this.x.await();
                        
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Trabajador.class.getName()).log(Level.SEVERE, null, ex);
                    }
			
			System.out.println("Ejecutando " + nombre+".");
		}
	}
