/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eduardo
 */
public class Turno {
    private int turno;

    public Turno(int turno) {
        this.turno = turno;
    }
    public synchronized void siguienteTuno(){
        if (turno==1) turno=2;
        else turno=1;
    }

    public synchronized int getTurno() {
        return turno;
    }
    
    
}
