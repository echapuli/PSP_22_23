/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dekker1v2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eduardo
 */
public class ClaseHilo extends Thread {

    private int numHilo;
    private Valores v;

    public ClaseHilo(int numHilo, Valores v) {
        this.numHilo = numHilo;
        this.v=v;
    }

    @Override
    public void run() {
        System.out.println("Ejecutando hilo " + numHilo);
        //entramos 10 veces a la sección cítica

        for (int j = 1; j < 11; j++) {

            while (v.getTurno() != numHilo) {
                try {
                    //mientras el turno no sea suyo espera
                    sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ClaseHilo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //entra en sección Critica
            System.out.println("Hilo " + numHilo + " entra en sección critica "+j+" veces");
            for (int i = 1; i < 11; i++) { //cuenta hasta 10
                System.out.println("hilo " + numHilo + " valor " + i);
            }
            //sale de la sección critica
            //le da el turno al otro hilo
            System.out.println("Hilo " + numHilo + " sale en sección critica");
            if (v.getTurno() == 1) {
                v.setTurno(2);
            } else {
                v.setTurno(1);
            }

        }
        System.out.println("Hilo " + numHilo + " termina");
    }

}
