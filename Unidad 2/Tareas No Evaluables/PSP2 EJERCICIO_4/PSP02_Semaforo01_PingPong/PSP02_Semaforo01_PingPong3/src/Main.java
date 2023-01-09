
import java.util.concurrent.Semaphore;

/**
 * Se trata de simular el acceso simultáneo de 4 terminales (hilos) a un
 * servidor y llevar la cuenta de accesos en cada instante. Desde cada terminal
 * se simularán 10 accesos.
 */
public class Main {

    public static void main(String[] args) {
        Semaphore semaforoPelota = new Semaphore(1);
        Turno turno = new Turno(1);
        //semáforo para las secciones críticas de esta clase (permisos 1)

        HiloPingPong j11 = new HiloPingPong("jugador11", 1, semaforoPelota, turno);
        HiloPingPong j12 = new HiloPingPong("jugador12", 1, semaforoPelota, turno);
        HiloPingPong j21 = new HiloPingPong("jugador21", 2, semaforoPelota, turno);
        HiloPingPong j22 = new HiloPingPong("jugador22", 2, semaforoPelota, turno);

        j11.start();
        j12.start();
        j21.start();        
        j22.start();

    }
}
