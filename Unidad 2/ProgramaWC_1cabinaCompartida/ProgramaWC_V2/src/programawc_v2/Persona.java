/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programawc_v2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eduardo
 */
public class Persona extends Thread {

    private String sexo;
    private String nombre;
    private WC wc;

    public Persona(String nombre, WC wc) {
        int nsexo;
        //crea un objeto random
        Random rand = new Random();
        // genera número 0 o 1 ---> O-H 1-M
        nsexo = rand.nextInt(2);
        if (nsexo == 0) {
            sexo = "H";
        } else {
            sexo = "M";
        }
        this.nombre = nombre;
        this.wc = wc;
    }

    @Override
    public void run() {
        //tiempo que usa el WC
        Random rand = new Random();
        // genera un número entre 500 y 1000 milisegundos
        int tiempo = rand.nextInt(501) + 500; //tiempo entre 500 y 1000 milisegundos
        synchronized (wc) {
            wc.entraPersona(this);
            try {
                sleep(tiempo);  //tiempo entre 500 y 1000 milisegundos
            } catch (InterruptedException ex) {
                Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            }
            wc.salePersona(this);

        }
    }

    public String getSexo() {
        return sexo;
    }

    public String getNombre() {
        return nombre;
    }

}
