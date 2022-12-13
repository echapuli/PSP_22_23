
public class ProductorConsumidorSinWaitMain {

    public static void main(String[] args) {
        DatosCompartidos datos = new DatosCompartidos();
        Productor p1 = new Productor(datos, "p1 ");
      //Productor p2 = new Productor(datos, "p2 ");
        Consumidor c1 = new Consumidor(datos, "c1 ");
        Consumidor c2 = new Consumidor(datos, "c2 ");
      //Consumidor c3 = new Consumidor(datos, "c3 ");
        p1.start();
    //  p2.start();
        c1.start();
        c2.start();
     // c3.start();
    }
}
