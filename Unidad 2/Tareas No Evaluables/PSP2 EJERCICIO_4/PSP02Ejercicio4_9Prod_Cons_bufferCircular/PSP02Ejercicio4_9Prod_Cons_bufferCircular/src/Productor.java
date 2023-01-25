 class Productor extends Thread {

    private int N;
    public BufferCircular b;    

    public Productor(BufferCircular b, int max, String c) {        
        this.b=b;
        N = max;
        this.setName(c);
    }

    public void run() {
        for (int i = 0; i < N; i++) {
            b.put(i);            
        }
        System.out.println("Fin del productor");
        b.finalizar();
    }
}
