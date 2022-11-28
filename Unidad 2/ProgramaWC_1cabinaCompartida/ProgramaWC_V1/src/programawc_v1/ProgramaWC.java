package programawc_v1;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author J
 */
public class ProgramaWC {

    public static void main(String[] args) {
        final int NUMEROPERSONAS = 10; //número de personas
        //Semilla para generar nÃúmeros aleatorios
        Random generador = new Random();
        String sexo; //Hombre o mujer
        String nombre; //identifica la persona
        int tiempo;
        //crea un objeto random
        Random rand = new Random();
        //creamos el WC a compartir
        WC wc = new WC();

        for (int i = 1; i <= NUMEROPERSONAS; i++) {

            //Creando el objeto y arrancando el hilo, simultaneamente
            Persona persona = new Persona("P" + i, wc);
           System.out.println("La persona P"+i+" va al WC");            
            persona.start();
            //tiempo que tarda en llegar otra persona con ganas de ir al WC
            // genera un número entre 1000 y 2000 milisegundos
            tiempo = rand.nextInt(1001) + 1000;

            try {
                Thread.sleep(tiempo);  //tiempo entre 1000 y 2000 milisegundos 
            } catch (InterruptedException ex) {
                Logger.getLogger(ProgramaWC.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
