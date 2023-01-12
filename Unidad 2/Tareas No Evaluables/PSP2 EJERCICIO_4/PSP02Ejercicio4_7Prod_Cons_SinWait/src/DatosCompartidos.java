
class DatosCompartidos {

    private String dato;

    public synchronized String getDato() {
        
        return dato;
    }

    public synchronized void newDato(String dato) {
        this.dato = dato;
    }
}


