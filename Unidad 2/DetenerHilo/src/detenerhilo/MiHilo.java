/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detenerhilo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eduardo
 */
public class MiHilo extends Thread {

    // boolean que pondremos a false cuando queramos parar el hilo
    private boolean continuar = true;
    private int cont = 0;
    // metodo para poner el boolean a false.

    public void detenElHilo() {
        continuar = false;
        //this.stop();
    }

    @Override
    public void run() {
        try {
            while (continuar) {
                System.out.println("Valor Hilo " + this.getName() + " " + cont);
                this.sleep(3000);
                cont++;
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(MiHilo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
