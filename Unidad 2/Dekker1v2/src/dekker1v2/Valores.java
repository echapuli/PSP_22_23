/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dekker1v2;

/**
 *
 * @author Eduardo
 */
public class Valores {

    private volatile int turno = 1;
    //¡¡¡OJO!!!
    //cuando el programa es ejecutado en una computadora con varios núcleos — todas las modernas — , los hilos hilo1 y hilo2 pueden ser ejecutados en procesadores diferentes
    //Anteponiendo volatile a la definición de la variable _stop estamos diciendo al compilador que el valor contenido en esa dirección de memoria puede modificarse en 
    //cualquier momento, y queremos que dicha modificación sea visible inmediatamente para todos los hilos que están accediendo a ella, no queremos que su valor sea copiado 
    //en la caché del procesador.

    public Valores() {
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

}
