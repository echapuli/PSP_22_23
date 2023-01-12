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
public class Hilo extends Thread {

    private int numhilo;
    private Turno t;

    public Hilo(int numhilo, Turno t) {
        this.numhilo = numhilo;
        this.t = t;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            t.mirarTurno();

            System.out.println("hilo " + numhilo + " - " + i);
            t.siguienteTurno();

        }
    }

    public int getNumhilo() {
        return numhilo;
    }

}
