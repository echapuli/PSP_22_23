
public class GestionJardin {

    public static void main(String[] args) {
        //creamos el jardin ya con 100 personas
        Jardin jardinCiudad = new Jardin(100);
         
        
        for(int i=1; i<=10;i++){
            new HiloPersonaEntra("entra Persona "+i,jardinCiudad).start();
        }
        
        for(int j=1; j<=15;j++){
            new HiloPersonaSale("sale Persona "+j,jardinCiudad).start();
        }
    }
}
