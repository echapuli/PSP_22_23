/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author IMCG
 */

public class Main {
 public static void main(String[] args) {
       //se crean dos hilos: hrojo y hazul
       Color hrojo = new Color ("Rojo");
       Color hazul = new Color ("Azul");
       Color hverde = new Color ("Verde");
       //se inician los hilos para su ejecución
       hrojo.start();
       hazul.start();
       hverde.start();
    }
}
