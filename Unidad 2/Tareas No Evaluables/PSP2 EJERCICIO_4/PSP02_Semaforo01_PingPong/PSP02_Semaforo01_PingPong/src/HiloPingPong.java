
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloPingPong extends Thread {
    private String sonidoJugador;
    private Semaphore semaforoPelota;

    HiloPingPong(String sonidoJugador, Semaphore s) {
        this.sonidoJugador =sonidoJugador;
        this.semaforoPelota = s;
    }
    
    public void run() {
        for (int i = 1; i <= 10; i++) {
            //bloqueo el recurso
            try {
                semaforoPelota.acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloPingPong.class.getName()).log(Level.SEVERE, null, ex);
            }
            //imprimo
            System.out.println(sonidoJugador+" ");
            //libero el recurso
            semaforoPelota.release();
            //para que el hilo deje el procesador, auqneu no se 
            //garantiza que volverá a entrar el mismo
            yield();            
        }
    }
}
