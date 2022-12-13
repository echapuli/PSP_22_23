
public class Consumidor extends Thread{

    public DatosCompartidos datos;
    public String nombre;

    public Consumidor(DatosCompartidos dc, String nmbr) {
        datos = dc;
        nombre = nmbr;
    }

    public void run() {
     for (int i=1;i<6;i++){
           System.out.println("Consumiendo: "+nombre + " " + datos.getDato());
        }
    }
}

