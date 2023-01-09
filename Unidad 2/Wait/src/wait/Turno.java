/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wait;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eduardo
 */
public class Turno {

    private int turno;

    public Turno() {
        turno = 1;
    }

    public synchronized int getTurno() {

        while (((Hilo) Thread.currentThread()).getNumhilo() != turno) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Turno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return turno;
    }

    public synchronized void siguienteTurno() {
        if (turno == 3) {
            turno = 1;
        } else {
            turno++;
        }
        notifyAll();
    }

}
