/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pila;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eduardo
 */
public class DatosPila {

    private char[] pila;
    private int tope, posicion;

    public DatosPila(int tope) {
        this.tope = tope;
        posicion = -1;
        pila = new char[tope];
    }

    public boolean pilaLlena() {
        return posicion == tope;
    }

    public boolean pilaVacia() {
        return posicion == -1;
    }

    public synchronized void push(char valor) {
        while (pilaLlena()) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(DatosPila.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        pila[++posicion] = valor;
        System.out.println(Thread.currentThread().getName() + ": Almacenado el valor " + valor);
        notifyAll();

        Thread.currentThread().yield();

    }

    public synchronized void pop() {
        char v;
        while (pilaVacia()) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(DatosPila.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        v = pila[posicion--];
        System.out.println(Thread.currentThread().getName() + ": Extraido el valor " + v);

        notifyAll();
        Thread.currentThread().yield();
    }

}
