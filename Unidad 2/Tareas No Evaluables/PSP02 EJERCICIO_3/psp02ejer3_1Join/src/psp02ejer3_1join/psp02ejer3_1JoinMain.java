package psp02ejer3_1join;

public class psp02ejer3_1JoinMain {

    public static void main(String[] args) {
        System.out.println("Proceso " + Thread.currentThread().getName() + " está activo");
        NewHilo ob1 = new NewHilo("Hilo1");
        NewHilo ob2 = new NewHilo("Hilo2");
        NewHilo ob3 = new NewHilo("Hilo3");
        ob1.start();
        try {// espera hasta que termine hilo 1
            System.out.println("Proceso " + Thread.currentThread().getName() + " espera finalizacion hilo " + ob1.getT().getName());
            System.out.println("El hilo1  esta vivo: " + ob1.getT().isAlive());
            System.out.println("El hilo2  esta vivo: " + ob2.getT().isAlive());
            System.out.println("El hilo3  esta vivo: " + ob3.getT().isAlive());
            ob1.getT().join();
        } catch (InterruptedException e) {
            System.out.println("Interrupcion del hilo principal");
        }
        System.out.println("Proceso " + Thread.currentThread().getName() + " está activo");
        ob2.start();
        try {// espera hasta que termine hilo 2
            System.out.println("Proceso " + Thread.currentThread().getName() + " espera finalizacion hilo " + ob2.getT().getName());
            System.out.println("El hilo1  esta vivo: " + ob1.getT().isAlive());
            System.out.println("El hilo2  esta vivo: " + ob2.getT().isAlive());
            System.out.println("El hilo3  esta vivo: " + ob3.getT().isAlive());
            ob2.getT().join();
        } catch (InterruptedException e) {
            System.out.println("Interrupcion del hilo principal");
        }
        System.out.println("Proceso " + Thread.currentThread().getName() + " está activo");
        ob3.start();
        try {// espera hasta que terminen los otros hilos
            System.out.println("Proceso " + Thread.currentThread().getName() + " espera finalizacion hilo " + ob3.getT().getName());
            System.out.println("El hilo1  esta vivo: " + ob1.getT().isAlive());
            System.out.println("El hilo2  esta vivo: " + ob2.getT().isAlive());
            System.out.println("El hilo3  esta vivo: " + ob3.getT().isAlive());
            ob3.getT().join();
        } catch (InterruptedException e) {
            System.out.println("Interrupcion del hilo principal");
        }
        System.out.println("Proceso " + Thread.currentThread().getName() + " está activo");

        System.out.println("El hilo1  esta vivo: " + ob1.getT().isAlive());
        System.out.println("El hilo2  esta vivo " + ob2.getT().isAlive());
        System.out.println("El hilo3  esta vivo: " + ob3.getT().isAlive());
        System.out.println("Sale del proceso " + Thread.currentThread().getName());
    }
}
