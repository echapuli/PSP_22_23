import java.util.concurrent.CountDownLatch;
 
public class CountDownLatchExample {
 
	public static void main(String... args) {
		// Instantiating countdownlatch class.
		CountDownLatch cuentaAtras = new CountDownLatch(1);
		System.out.println("Creando Hilos...");
 
		// creando los hilos y lanzandolos
		for(int i=0;i<50;i++) {
                        System.out.println("Creando hilo"+i);
			Trabajador worker = new Trabajador(cuentaAtras, "Trabajador #"+i);
			worker.start(); //lanzando hilo
 		}
                System.out.println("Finalizada la creación de todos los hilos, "
                        + "Forzamos la ejecución de todos los hilos a la vez");
		// Ahora se ejecutan todos los hilos a la vez desde
                //el punto en el que quedaron en espera
		cuentaAtras.countDown();
 
	}
	
}
