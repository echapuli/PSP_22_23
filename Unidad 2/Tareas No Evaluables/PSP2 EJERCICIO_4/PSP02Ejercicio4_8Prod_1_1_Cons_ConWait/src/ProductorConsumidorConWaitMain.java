
public class ProductorConsumidorConWaitMain {

    public static void main(String[] args) {
        DatosCompartidos datos = new DatosCompartidos();
        int totalDatos = 5;
        Productor p1 = new Productor(datos, "prod1 ",totalDatos);
        Consumidor c1 = new Consumidor(datos, "consumidor1 ",totalDatos);
       
        p1.start();
        c1.start();        
    }
}
