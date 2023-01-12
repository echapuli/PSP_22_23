
import java.util.logging.Level;
import java.util.logging.Logger;

class DatosCompartidos {

    private String dato;
    private boolean dato_disponible = false;

    public synchronized void cogeDato() {
        while (dato_disponible == false) {
            //no se ha producido ningun dato
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrumpido " + Thread.currentThread().getName());
            }
        }
        dato_disponible = false;    
        System.out.println(((Consumidor)Thread.currentThread()).getNombre() + " consume el valor: " + dato);        
        notifyAll();
    }

    public synchronized void newDato(String dato) {
        while (dato_disponible == true) {
            //ya hay un dato que no ha recogido ningun consumidor
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrumpido " + Thread.currentThread().getName());
            }
        }
        this.dato = dato;
        System.out.println("Productor "+((Productor)Thread.currentThread()).getNombre()+" produce el valor: "+dato);
        dato_disponible = true;
        notifyAll();       
    }
}
