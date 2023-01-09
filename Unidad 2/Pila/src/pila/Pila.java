/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pila;

/**
 *
 * @author Eduardo
 */
public class Pila {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DatosPila p = new DatosPila(40);
        (new Productor(p, 20, "p1")).start();
        (new Productor(p, 20, "p2")).start();
        Consumidor c1, c2;
        c1 = new Consumidor(p,20, "c1");
        c2 = new Consumidor(p,20, "c2");
        c1.start();
        c2.start();
    }

}
