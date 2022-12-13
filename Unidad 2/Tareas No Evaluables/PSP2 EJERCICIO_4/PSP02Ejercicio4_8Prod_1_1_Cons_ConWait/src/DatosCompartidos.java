
import java.util.logging.Level;
import java.util.logging.Logger;

class DatosCompartidos {

    public String dato;
    public boolean dato_disponible = false;

    public synchronized String getDato() {
        while (dato_disponible == false) {
            //no se ha producido ningun dato
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrumpido " + Thread.currentThread().getName());
            }
        }
        dato_disponible = false;      
        notifyAll();
        return dato;
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
        System.out.println("Almacenado el valor: "+dato);
        dato_disponible = true;
        notifyAll();       
    }
}
