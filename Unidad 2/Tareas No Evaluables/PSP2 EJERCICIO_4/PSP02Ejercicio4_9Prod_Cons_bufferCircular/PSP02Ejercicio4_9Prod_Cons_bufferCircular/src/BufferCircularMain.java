
public class BufferCircularMain {

    public static void main(String[] args) {
       BufferCircular b = new BufferCircular(4);
        
      
        (new Productor(b,8,"p1")).start();
        (new Productor(b,8,"p2")).start();
        Consumidor  c1,c2;
        
        c1 =new Consumidor(b,"c1");

        c2 = new Consumidor(b,"c2");
        c1.start();
        c2.start();
    }
}
