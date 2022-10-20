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
public class Dekker1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread h1=new ClaseHilo(1);
        Thread h2=new ClaseHilo(2);
        h1.start();
        h2.start();
    }
    
}
