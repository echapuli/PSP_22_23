
public class HiloPestaña2 extends javax.swing.JPanel  implements Runnable {

    /**
     * Creates new form HiloPestaña2
     */
    Thread hiloaux;
    private boolean terminar=false; //controla la parada del bucle de contar
    private int cont=0; //contador para la cuenta
    public HiloPestaña2() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etiqueta1PestañaHilo2 = new java.awt.Label();
        mostrarContadorHilo2 = new java.awt.TextArea();

        etiqueta1PestañaHilo2.setText("ESTOY SALUDANDO!!!!!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mostrarContadorHilo2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiqueta1PestañaHilo2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(189, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(etiqueta1PestañaHilo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(mostrarContadorHilo2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        etiqueta1PestañaHilo2.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label etiqueta1PestañaHilo2;
    private java.awt.TextArea mostrarContadorHilo2;
    // End of variables declaration//GEN-END:variables

    public void creaHilo(){
        hiloaux = new Thread(this);
        //hiloaux.start();
    }
    
    @Override
    public void run() {
     while(!terminar){
            //inserto cada nueva cuenta arriba del todo del Textarea, para que lo vea siempre
            //Es la posición 0.
            mostrarContadorHilo2.append("Hola Que Tal = "+cont+"\n");
            cont++;
            try {
                //uso sleep para ralentizar un poco el contador y poder verlo
		Thread.sleep(500);
            } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
            }
    }
   }
    public int devolverCont(){
        return cont;
    }
            
    public void parar(){
         this.terminar=true;
    }
}
