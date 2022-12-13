
class DatosCompartidos {

    public String dato;
    public boolean datoDisponible = false;

    public synchronized String getDato() {
        
        return dato;
    }

    public synchronized void newDato(String dato) {
        this.dato = dato;
    }
}


