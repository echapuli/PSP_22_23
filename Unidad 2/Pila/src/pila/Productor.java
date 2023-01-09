package pila;

 class Productor extends Thread {

    private int n;
    public DatosPila b;    

    public Productor(DatosPila b, int max, String c) {        
        this.b=b;
        n = max;
        this.setName(c);
    }

    public void run() {
        for (char i = 'a'; i < 'a'+n; i++) {
            b.push(i);            
        }
        System.out.println("Fin del productor "+getName());
    }
}
