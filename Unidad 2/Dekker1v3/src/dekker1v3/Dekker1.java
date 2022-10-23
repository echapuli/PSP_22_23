/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dekker1v3;

/**
 *
 * @author eduardo
 */
public class Dekker1 {

    /**
     * @param args the command line arguments
     */
    //Primer Algoritmo de Dekker. Alternancia estricta. 
    //Garantiza la exclusión mutua, pero su desventaja es que acopla los procesos fuertemente, esto significa que los procesos lentos atrasan 
    //a los procesos rápidos
    private static int turno = 1;
    
    private static class ClaseHilo extends Thread {

        private int numHilo;

        public ClaseHilo(int numHilo) {
            this.numHilo = numHilo;
        }

        @Override
        public void run() {
            System.out.println("Ejecutando hilo " + numHilo);
            //entramos 10 veces a la sección cítica

            for (int j = 1; j < 11; j++) {

                while (turno != numHilo) {
//                try {
//                    //mientras el turno no sea suyo espera
//                    sleep(10);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(ClaseHilo.class.getName()).log(Level.SEVERE, null, ex);
//                }
                    System.out.println("Turno " + turno + "-Espera Hilo " + numHilo);
                }
                //entra en sección Critica
                System.out.println("Hilo " + numHilo + " entra en sección critica " + j + " veces");
                for (int i = 1; i < 11; i++) { //cuenta hasta 10
                    System.out.println("hilo " + numHilo + " valor " + i);
                }
                //sale de la sección critica
                //le da el turno al otro hilo
                System.out.println("Hilo " + numHilo + " sale en sección critica");
                if (turno == 1) {
                    turno = 2;
                } else {
                    turno = 1;
                }

            }
            System.out.println("Hilo " + numHilo + " termina");
        }

    }    

    public static void main(String[] args) {
        //otra forma de compartir valores entre hilos sin usar clases static
        ClaseHilo h1 = new ClaseHilo(1);
        ClaseHilo h2 = new ClaseHilo(2);

        h1.start();
        h2.start();

    }


}
