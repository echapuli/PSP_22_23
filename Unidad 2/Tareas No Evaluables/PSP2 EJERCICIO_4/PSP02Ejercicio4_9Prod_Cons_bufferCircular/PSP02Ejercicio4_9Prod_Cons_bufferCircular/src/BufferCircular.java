
import java.util.logging.Level;
import java.util.logging.Logger;

class BufferCircular {

    private int[] v;
    private int N, n, cabecera, cola;

    public BufferCircular(int max) {
        N = max;
        n = cola = cabecera = 0;
        v = new int[N];
    }

    private boolean lleno() {
        return n == N;
    }

    private boolean vacio() {
        return n == 0;
    }

    public synchronized void put(int x) {
        while (lleno()) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(BufferCircular.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        v[cabecera] = x;
        cabecera = (cabecera + 1) % N;
        n++;
        System.out.println(Thread.currentThread().getName() + ": Almacenado el valor " + x);
        notifyAll();
    }

    public synchronized int get() {
        int x;
        while (vacio()) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(BufferCircular.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        x = v[cola];
        cola = (cola + 1) % N;
        n--;
        System.out.println(Thread.currentThread().getName() + ": Extraido el valor " + x);
        notifyAll();
        return x;
    }
    public void finalizar(){
        n=-1;
    }

    public int getN() {
        return n;
    }
    
}
