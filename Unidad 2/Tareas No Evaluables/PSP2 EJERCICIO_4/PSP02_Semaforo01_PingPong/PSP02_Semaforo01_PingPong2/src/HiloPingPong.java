
import static java.lang.Thread.yield;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloPingPong extends Thread {

    private int jugador;
    private Semaphore semaforoPelota;
    private Turno turno;

    HiloPingPong(int jugador, Semaphore s, Turno turno) {
        this.jugador = jugador;
        this.semaforoPelota = s;
        this.turno = turno;
    }

    public void run() {
        int i = 0;
        do {
            //para garantizar que golpean alternativamente los jugafores
            while (turno.getTurno() != jugador) {
                yield();
            }
            //bloqueo el recurso

            try {
                semaforoPelota.acquire(); //adquiere  el acceso
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloPingPong.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (turno.getTurno() == jugador) {
                i++;

                //imprimo
                if (jugador == 1) {
                    System.out.println(getName() + "-PING");
                } else {
                    System.out.println(getName() + "-PONG");
                }

                //libero el recurso
                turno.siguienteTuno();
            }
            semaforoPelota.release();
            yield();
        } while (i <= 10);
    }
}
