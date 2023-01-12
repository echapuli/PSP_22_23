
public class ProductorConsumidorConWaitMain {

    public static void main(String[] args) {
        DatosCompartidos datos = new DatosCompartidos();
        int totalDatos = 5;
        Productor p1 = new Productor(datos, "prod1 ", totalDatos);
        Productor p2 = new Productor(datos, "prod2 ", totalDatos);
        Productor p3 = new Productor(datos, "prod3 ", totalDatos);
        Consumidor c1 = new Consumidor(datos, "consumidor1 ", totalDatos);
        Consumidor c2 = new Consumidor(datos, "consumidor2 ", totalDatos);
        Consumidor c3 = new Consumidor(datos, "consumidor3 ", totalDatos);        
        p1.start();
        p2.start();
        p3.start();
        c1.start();
        c2.start();
        c3.start();        
    }
}
