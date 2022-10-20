/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dekker1;

/**
 *
 * @author eduardo
 */
public class ClaseHilo extends Thread {

    private int numHilo;
    private boolean matar = false;

    public ClaseHilo(int numHilo) {
        this.numHilo = numHilo;
    }

    @Override
    public void run() {
        System.out.println("Ejecutando hilo " + numHilo);
        while (!matar) {
            while (Valores.getTurno() != numHilo) {
                //espera activa mientras no tenga el turno
            }
            //entra en sección Critica
            System.out.println("Hilo " + numHilo + " entra en sección critica");
            for (int i = 1; i < 11; i++) {
                System.out.println("hilo " + numHilo + " valor " + i);
            }
            //sale de la sección critica
            //le da el turno al otro hilo
                       System.out.println("Hilo " + numHilo + " sale en sección critica");     
            if (Valores.getTurno()==1)
                  Valores.setTurno(2);
            else
                  Valores.setTurno(1);
            
        
        }
    }

    public void setMatar() {
        this.matar = true;
    }

}
