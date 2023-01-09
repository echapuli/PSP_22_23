/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yield;

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
        return turno;
    }

    public synchronized void siguienteTurno() {
        if (turno == 3) {
            turno = 1;
        } else {
            turno++;
        }
    }

}
