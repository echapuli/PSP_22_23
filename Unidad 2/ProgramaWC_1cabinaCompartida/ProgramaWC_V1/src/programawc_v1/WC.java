package programawc_v1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class WC {

    //atributos

    private boolean ocupado = false;
    private int hombres = 0;
    private int mujeres = 0;
    private String secuencia = "";



    /**
     * la persona entra en el baño si esta libre lo ocupa sino espera
     *
     * @param p
     */
    public synchronized void entrarWc(Persona p) {

        while (ocupado) {
            System.out.println("-------"+p.getNombre()+" intenta entrar ......"); 
             try {
                //si esta ocupado lo para hasta que este libre
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(WC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
        ocupado = true;
        System.out.println(p.getNombre() + " "+p.getSexo()+" ha entrado al WC!");
        System.out.println("WC ocupado!");

    }

    /**
     * la persona sale del baño, indica cuantos hombres y mujeres han entrado y
     * lo deja libre
     *
     * @param p
     */
    public synchronized void salirWC(Persona p) {
        System.out.println(p.getNombre() + " ha salido del WC");
        if (p.getSexo().equals( "H")) {
            hombres++;
            secuencia += "H ";
        } else {
            mujeres++;
            secuencia += "M ";
        }

        System.out.println("El WC lo han usado " + hombres + " hombres y " + mujeres + " mujeres.");
        System.out.println("La secuencia de uso ha sido " + secuencia);
        ocupado = false;
        notifyAll();
    }

}

