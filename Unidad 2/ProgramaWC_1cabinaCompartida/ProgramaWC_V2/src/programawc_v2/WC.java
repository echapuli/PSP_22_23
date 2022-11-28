/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programawc_v2;

/**
 *
 * @author Eduardo
 */
public class WC {

    private String secuencia;
    private boolean libre;
    private int numHombres;
    private int numMujeres;

    public WC() {
        secuencia = "";
        libre = true;
        numHombres = 0;
        numMujeres = 0;
    }

    public void entraPersona(Persona p) { //agrega una persona que entro al WC
        libre = false;
        System.out.println(p.getNombre() + " "+p.getSexo()+" ha entrado al WC!");
        System.out.println("WC ocupado!");
    }

    public void salePersona(Persona p) { //persona sale del WC
        System.out.println(p.getNombre() + " ha salido del WC");
        if (p.getSexo().equals( "H")) {
            numHombres++;
            secuencia += "H ";
        } else {
            numMujeres++;
            secuencia += "M ";
        }

        System.out.println("El WC lo han usado " + numHombres + " hombres y " + numMujeres + " mujeres.");
        System.out.println("La secuencia de uso ha sido " + secuencia);        
        libre = true;

    }


 
}
