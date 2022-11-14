
public class Jardin {
        private int contPersonas;
        
        public Jardin(int totalPersonas){
            contPersonas= totalPersonas;
        }
        
        public  void entraPersonaAlJardin(){
            //muestra el hilo que entra en el método
            System.out.println("hilo "+ Thread.currentThread().getName()+
                    " ----- Entra en el jardín ");
            //incrementa el número de personas que hay en el jardin
            contPersonas++;
            //mostramos el total de personas que hay
            System.out.println("personas en el jardín: "+contPersonas);
        }
        
        public  void salePersonaDelJardin(){
            //muestra el hilo que sale en el método
            System.out.println("hilo "+ Thread.currentThread().getName()+
                    " ----- Sale  del jardín ");
            //incrementa el número de personas que hay en el jardin
            contPersonas--;
            //mostramos el total de personas que hay
            System.out.println("personas en el jardín: "+contPersonas);
        }
}