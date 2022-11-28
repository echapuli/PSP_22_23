
package programawc_v1;

import static java.lang.Math.random;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Persona extends Thread{
    
    private String nombre;      //Nombre de la persona
    private WC wc;              //Wc al que va
    private String sexo;     //Si es hombre o mujer
        
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

    public void run() {
        Random rand = new Random();
        // genera un número entre 500 y 1000 milisegundos
        int tiempo = rand.nextInt(501) + 500; //tiempo entre 500 y 1000 milisegundos        
        //entra al wc
        wc.entrarWc(this);      
        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //sale del wc
        wc.salirWC(this);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public WC getWc() {
        return wc;
    }

    public void setWc(WC wc) {
        this.wc = wc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
 
    
}
