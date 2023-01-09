package pila;

class Consumidor extends Thread {

    private int n;
    public DatosPila p;

    public Consumidor(DatosPila p, int max, String c) {
        this.p = p;
        n = max;
        this.setName(c);
    }

    public void run() {
        char v;
        for (int i = 0; i < n; i++) {
            p.pop();
        }
        System.out.println("Fin del consumidor "+getName());
    }
}
