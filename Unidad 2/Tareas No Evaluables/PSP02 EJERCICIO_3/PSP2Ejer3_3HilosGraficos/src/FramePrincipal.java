
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class FramePrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FramePrincipal
     */
    static FramePrincipal ppal;
    private  HiloPestaña1 hilo1;
    private  HiloPestaña2 hilo2;

    public FramePrincipal() {
        initComponents();
        // final HiloPestaña1 hilo1;
        // final HiloPestaña2 hilo2;
        hilo1 = new HiloPestaña1();
        hilo2 = new HiloPestaña2();
        //añado las pestañas hilo1 y hilo2 al frameprincipal
        jTabbedPane1.addTab("Hilo1", hilo1);
        jTabbedPane1.addTab("Hilo2", hilo2);
        hilo1.creaHilo();        
        hilo2.creaHilo();
        hilo1.hiloaux.start();
        hilo2.hiloaux.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelPrincipal1 = new javax.swing.JPanel();
        labelInfoHilo1 = new java.awt.Label();
        valueHilo1 = new java.awt.TextField();
        boton = new javax.swing.JButton();
        labelInfoHilo2 = new java.awt.Label();
        valueHilo2 = new java.awt.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelInfoHilo1.setText("Valor Hilo1");

        valueHilo1.setText("Contador = 0");
        valueHilo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valueHilo1ActionPerformed(evt);
            }
        });

        boton.setText("ACTUALIZAR");
        boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActionPerformed(evt);
            }
        });

        labelInfoHilo2.setText("Valor Hilo2");

        valueHilo2.setText("Hola Que Tal = 0");

        javax.swing.GroupLayout panelPrincipal1Layout = new javax.swing.GroupLayout(panelPrincipal1);
        panelPrincipal1.setLayout(panelPrincipal1Layout);
        panelPrincipal1Layout.setHorizontalGroup(
            panelPrincipal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipal1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelPrincipal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelInfoHilo1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelInfoHilo2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(panelPrincipal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(valueHilo2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton)
                    .addComponent(valueHilo1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        panelPrincipal1Layout.setVerticalGroup(
            panelPrincipal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipal1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panelPrincipal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelInfoHilo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valueHilo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panelPrincipal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelInfoHilo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valueHilo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(boton)
                .addGap(41, 41, 41))
        );

        jTabbedPane1.addTab("PanelPrinpical", panelPrincipal1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void valueHilo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valueHilo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valueHilo1ActionPerformed

    private void botonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActionPerformed
         valueHilo1.setText(Integer.toString(hilo1.devolverCont()));
         valueHilo2.setText(Integer.toString(hilo2.devolverCont()));
    }//GEN-LAST:event_botonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        ppal = new FramePrincipal();
        ppal.setVisible(true);
    
        //para asegurarse de que se cierra el proceso de la ventana ppal
        ppal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton;
    private javax.swing.JTabbedPane jTabbedPane1;
    private java.awt.Label labelInfoHilo1;
    private java.awt.Label labelInfoHilo2;
    private javax.swing.JPanel panelPrincipal1;
    private java.awt.TextField valueHilo1;
    private java.awt.TextField valueHilo2;
    // End of variables declaration//GEN-END:variables
}
