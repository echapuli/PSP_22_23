class Productor extends Thread {

    private DatosCompartidos datos;
    private String nombre;

    public Productor(DatosCompartidos dc, String nmbr) {
        datos = dc;
        nombre = nmbr;
    }

    public void run() {
        int i = 0;
        for (i=1;i<6;i++){
            datos.newDato(nombre + i);
        }
    }
}
