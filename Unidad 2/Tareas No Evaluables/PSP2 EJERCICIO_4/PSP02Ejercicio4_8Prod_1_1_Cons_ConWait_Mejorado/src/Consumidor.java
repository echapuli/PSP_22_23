
import static java.lang.Thread.yield;

public class Consumidor extends Thread {

    private DatosCompartidos datos;
    private String nombre;
    private int totalDatos;

    public Consumidor(DatosCompartidos dc, String nmbr, int totalDatos) {
        datos = dc;
        nombre = nmbr;
        this.totalDatos = totalDatos;
    }

    public void run() {
        for (int i = 1; i <= totalDatos; i++) {
            datos.cogeDato();
        }
        System.out.println("se acaba el hilo " + nombre);
    }

    public String getNombre() {
        return nombre;
    }

}
