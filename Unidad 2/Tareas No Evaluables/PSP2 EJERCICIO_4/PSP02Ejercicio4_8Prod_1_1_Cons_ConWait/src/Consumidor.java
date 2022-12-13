
import static java.lang.Thread.yield;


public class Consumidor extends Thread{

    public DatosCompartidos datos;
    public String nombre;
    int totalDatos;

    public Consumidor(DatosCompartidos dc, String nmbr, int totalDatos) {
        datos = dc;
        nombre = nmbr;
        this.totalDatos = totalDatos;
    }

    public void run() {
     for (int i=1;i<=totalDatos;i++){            
            String valorAlmacen = datos.getDato();
           //muestro el valor cogido del almacen
           System.out.println(nombre + " coge " + valorAlmacen);
        }
     System.out.println("se acaba el hilo "+ nombre);
    }
}

