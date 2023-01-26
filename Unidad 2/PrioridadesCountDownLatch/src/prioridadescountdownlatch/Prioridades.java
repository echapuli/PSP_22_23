/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prioridadescountdownlatch;

/**
 *
 * @author eduardo
 */
public class Prioridades {

    private int prioridad;
    private int[] prioridades = new int[10];

    public Prioridades(int prioridad) {
        this.prioridad = prioridad;
        //cargo el vector de prioridades aleatoriamente y que no se repita
        cargarVector();
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    private void cargarVector() {
        int i = 0;
        int p;
        boolean encontrado;
        p = ((int) (Math.random() * 10) + 1);
        prioridades[i] = p;
        i++;
        while (i < 10) {
            do {
                p = ((int) (Math.random() * 10) + 1);
                encontrado = false;
                for (int j = 0; j <= i; j++) {
                    if (p == prioridades[j]) {
                      encontrado=true;
                      break;
                    }
                }
                if (!encontrado){
                    prioridades[i] = p;
                    break;
                }
            } while (true);
            i++;
        }
    }

    public int[] getPrioridades() {
        return prioridades;
    }
    

}
