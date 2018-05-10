/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.xemlet.presentacion;

import java.awt.Color;
import mx.itson.xemlet.persistencia.SessionPaquete;
import mx.itson.xemlet.nucleo.controlador.ControladorCliente;
import mx.itson.xemlet.nucleo.controlador.ControladorFramePrincipal;

/**
 *
 * @author javiershaka
 */
public class FrameAgregarCliente extends javax.swing.JFrame {

    /**
     * Creates new form FrameAgregarCliente
     */
    public FrameAgregarCliente() {
        initComponents();
        this.setLocationRelativeTo(null);
        // se inicia seccion en hibernate para que obtenga los paquetes para el combo box de abajo
        SessionPaquete paquetes = new SessionPaquete();
        cmbxPaquete.removeAllItems();
        for (int o = 0; o < paquetes.obtenerTodos().size(); o++) {
            cmbxPaquete.addItem("" + paquetes.obtenerTodos().get(o).getNombre());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtNumeroTelefonico = new javax.swing.JFormattedTextField();
        txtDomicilio = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        cmbxPaquete = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 11, -1, -1));

        jLabel2.setText("Numero Telefonio:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 52, -1, -1));

        jLabel3.setText("Domicilio:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 90, -1, -1));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 11, 200, -1));
        getContentPane().add(txtNumeroTelefonico, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 49, 200, -1));
        getContentPane().add(txtDomicilio, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 87, 200, -1));

        btnAgregar.setText("Aceptar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 166, -1, -1));

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 166, -1, -1));

        getContentPane().add(cmbxPaquete, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 125, 200, 23));

        jLabel4.setText("Paquete:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 134, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/itson/xemlet/presentacion/imagenes/Big_Data.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 220));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        //validaciones para los texfield si no estan llenos
        if (txtDomicilio.getText().isEmpty()) {
            txtDomicilio.setBackground(Color.red);
        }
        if (txtNombre.getText().isEmpty()) {
            txtNombre.setBackground(Color.red);
        }
        if (txtNumeroTelefonico.getText().isEmpty()) {
            txtNumeroTelefonico.setBackground(Color.red);
        }
        //condicion para mandar a llamar a los metodos modificaro o agregar cliente
        if (!txtDomicilio.getText().isEmpty() && !txtNombre.getText().isEmpty() && !txtNumeroTelefonico.getText().isEmpty()) {
            new ControladorCliente().AgregarOrModificarCliente();
            new ControladorFramePrincipal().llenarTablaFramePrincipalClientes();
            this.setVisible(false);
        } else {

        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //se vuelve invisible la ventana
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(FrameAgregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameAgregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameAgregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameAgregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameAgregarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAgregar;
    public static javax.swing.JComboBox<String> cmbxPaquete;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public static javax.swing.JTextField txtDomicilio;
    public static javax.swing.JTextField txtNombre;
    public static javax.swing.JFormattedTextField txtNumeroTelefonico;
    // End of variables declaration//GEN-END:variables
}
