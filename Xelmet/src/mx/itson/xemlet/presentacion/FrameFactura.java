/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.xemlet.presentacion;

import mx.itson.xemlet.nucleo.controlador.ControladorFactura;
import mx.itson.xemlet.nucleo.controlador.ControladorFramePrincipal;

/**
 *
 * @author javiershaka
 */
public class FrameFactura extends javax.swing.JDialog {

    /**
     * Creates new form Factura
     */
    public FrameFactura(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //se llena el nombre nombre con el nombre del clienteS
        txtNombre.setText("" + Registro.txtNombreCliente.getText());
        this.setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbMes = new javax.swing.JComboBox<>();
        txtAño = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMinutosCelular = new javax.swing.JTextField();
        txtLlamadasFijas = new javax.swing.JTextField();
        txtLlamadasRealizadas = new javax.swing.JTextField();
        txtCostoPaquete = new javax.swing.JTextField();
        txtCargosAdicionales = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        btnVG = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MES", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Novembre", "Diciembre", " " }));
        cbMes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMesItemStateChanged(evt);
            }
        });
        getContentPane().add(cbMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 11, -1, -1));

        txtAño.setToolTipText("Año");
        getContentPane().add(txtAño, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 11, 135, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 49, -1, -1));

        txtNombre.setEditable(false);
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 69, 100, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Minutos a celular");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 95, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Llamadas fijas");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 141, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Llamadas realizadas");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 192, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Costo del paquete");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 238, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cargos adicionales");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 284, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Total");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 330, -1, -1));

        txtMinutosCelular.setEditable(false);
        getContentPane().add(txtMinutosCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 115, 100, -1));

        txtLlamadasFijas.setEditable(false);
        getContentPane().add(txtLlamadasFijas, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 166, 100, -1));

        txtLlamadasRealizadas.setEditable(false);
        getContentPane().add(txtLlamadasRealizadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 212, 100, -1));

        txtCostoPaquete.setEditable(false);
        getContentPane().add(txtCostoPaquete, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 258, 100, -1));

        txtCargosAdicionales.setEditable(false);
        getContentPane().add(txtCargosAdicionales, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 304, 100, -1));

        txtTotal.setEditable(false);
        getContentPane().add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 350, 100, -1));

        btnVG.setText("Verificar");
        btnVG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVGActionPerformed(evt);
            }
        });
        getContentPane().add(btnVG, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 404, -1, -1));

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 404, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/itson/xemlet/presentacion/imagenes/7157e37d0d1bc68.jpg"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 330, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVGActionPerformed
        // TODO add your handling code here:
        //validacion para saber que metodo llamar en su caso verificar si existe el registro o si ya esta facturar
        if (btnVG.getText().equalsIgnoreCase("Facturar")) {
            new ControladorFactura().AgregarFactura();
            new ControladorFramePrincipal().llenarTablaFramePrincipalFactura();
            this.setVisible(false);
        }
        if (btnVG.getText().equalsIgnoreCase("Verificar")) {
            new ControladorFactura().VerificarFacturar();

        }


    }//GEN-LAST:event_btnVGActionPerformed

    private void cbMesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMesItemStateChanged
        // TODO add your handling code here:
        btnVG.setText("Verificar");
    }//GEN-LAST:event_cbMesItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FrameFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrameFactura dialog = new FrameFactura(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnVG;
    public static javax.swing.JComboBox<String> cbMes;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public static javax.swing.JFormattedTextField txtAño;
    public static javax.swing.JTextField txtCargosAdicionales;
    public static javax.swing.JTextField txtCostoPaquete;
    public static javax.swing.JTextField txtLlamadasFijas;
    public static javax.swing.JTextField txtLlamadasRealizadas;
    public static javax.swing.JTextField txtMinutosCelular;
    public static javax.swing.JTextField txtNombre;
    public static javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
