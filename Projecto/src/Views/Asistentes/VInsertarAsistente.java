package Views.Asistentes;

import Excepciones.DatoNoValido;
import Modelo_UML.Asistente;
import Modelo_UML.Entrenador;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import projecto.Controlador;
import static javax.swing.JOptionPane.*;
import validaciones.validaciones;

/**
 *
 * @author 1GDAW12
 */
public class VInsertarAsistente extends javax.swing.JFrame {

    int xx;
    int xy;
    Asistente asistente;
    Entrenador entrenador;

    /**
     * Creates new form VInsertarAsistente
     */
    public VInsertarAsistente() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/descarga.png")).getImage());
        this.setLocationRelativeTo(null);
    }

    public void validarDatosAsistente(String n, String s, String t, String na) throws DatoNoValido {
       validaciones.validarNombre(n);
       validaciones.validarsueldo(s);
       validaciones.validartelefono(t);
       validaciones.validarnacionalidad(na);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lMinimizar = new javax.swing.JLabel();
        lCerrar = new javax.swing.JLabel();
        lNombreUsuario = new javax.swing.JLabel();
        pMenu = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        tfSueldoAsis = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        tfNombreAsis = new javax.swing.JTextField();
        bAceptarAsis = new javax.swing.JButton();
        bCancelarAsis = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        tfTelefonoAsis = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        tfNacionalidadAsis = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        tfIdAsis = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(6, 57, 113));
        jPanel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel4MouseDragged(evt);
            }
        });
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel4MousePressed(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lMinimizar.setBackground(new java.awt.Color(6, 57, 113));
        lMinimizar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lMinimizar.setForeground(new java.awt.Color(255, 255, 255));
        lMinimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lMinimizar.setText("_");
        lMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lMinimizarMouseClicked(evt);
            }
        });
        jPanel4.add(lMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, -10, 20, 30));

        lCerrar.setBackground(new java.awt.Color(6, 57, 113));
        lCerrar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lCerrar.setForeground(new java.awt.Color(255, 255, 255));
        lCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lCerrar.setText("X");
        lCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lCerrarMouseClicked(evt);
            }
        });
        jPanel4.add(lCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, -1, -1));

        lNombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lNombreUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(lNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 310, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 690, 30));

        pMenu.setBackground(new java.awt.Color(51, 51, 51));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel3MouseDragged(evt);
            }
        });
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(205, 205, 205));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fallo-ilustracion-mando-joystick-aislado-efectos-ruido-sobre-fondo-oscuro_168425-94.jpg"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("E-Sports");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pMenuLayout = new javax.swing.GroupLayout(pMenu);
        pMenu.setLayout(pMenuLayout);
        pMenuLayout.setHorizontalGroup(
            pMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMenuLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pMenuLayout.setVerticalGroup(
            pMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMenuLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(398, Short.MAX_VALUE))
        );

        jPanel1.add(pMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 520));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Insertar Asistente");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, -1, -1));

        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, -1, -1));

        jLabel3.setText("Sueldo");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, -1, -1));

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfSueldoAsis.setBackground(new java.awt.Color(204, 204, 204));
        tfSueldoAsis.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel8.add(tfSueldoAsis, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 240, 40));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 260, 40));

        jPanel9.setBackground(new java.awt.Color(204, 204, 204));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfNombreAsis.setBackground(new java.awt.Color(204, 204, 204));
        tfNombreAsis.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tfNombreAsis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNombreAsisActionPerformed(evt);
            }
        });
        jPanel9.add(tfNombreAsis, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 240, 40));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 260, 40));

        bAceptarAsis.setBackground(new java.awt.Color(0, 0, 0));
        bAceptarAsis.setForeground(new java.awt.Color(255, 255, 255));
        bAceptarAsis.setText("Aceptar");
        bAceptarAsis.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bAceptarAsis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAceptarAsisActionPerformed(evt);
            }
        });
        jPanel1.add(bAceptarAsis, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 420, 120, 30));

        bCancelarAsis.setBackground(new java.awt.Color(0, 0, 0));
        bCancelarAsis.setForeground(new java.awt.Color(255, 255, 255));
        bCancelarAsis.setText("Cancelar");
        bCancelarAsis.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bCancelarAsis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarAsisActionPerformed(evt);
            }
        });
        jPanel1.add(bCancelarAsis, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 420, 120, 30));

        jLabel7.setText("Telefono");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, -1, -1));

        jPanel11.setBackground(new java.awt.Color(204, 204, 204));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfTelefonoAsis.setBackground(new java.awt.Color(204, 204, 204));
        tfTelefonoAsis.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel11.add(tfTelefonoAsis, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 240, 40));

        jPanel1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 260, 40));

        jLabel8.setText("Nacionalidad");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, -1, -1));

        jPanel12.setBackground(new java.awt.Color(204, 204, 204));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfNacionalidadAsis.setBackground(new java.awt.Color(204, 204, 204));
        tfNacionalidadAsis.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel12.add(tfNacionalidadAsis, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 240, 40));

        jPanel1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 260, 40));

        jLabel6.setText("Entrenador");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, -1, -1));

        jPanel10.setBackground(new java.awt.Color(204, 204, 204));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfIdAsis.setBackground(new java.awt.Color(204, 204, 204));
        tfIdAsis.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tfIdAsis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdAsisActionPerformed(evt);
            }
        });
        jPanel10.add(tfIdAsis, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 240, 40));

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, 260, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 829, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lMinimizarMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_lMinimizarMouseClicked

    private void lCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lCerrarMouseClicked
        Controlador.cerrarVentana(this);
    }//GEN-LAST:event_lCerrarMouseClicked

    private void jPanel4MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jPanel4MouseDragged

    private void jPanel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel4MousePressed

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jPanel3MouseDragged

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel3MousePressed

    private void tfNombreAsisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombreAsisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNombreAsisActionPerformed

    private void bAceptarAsisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarAsisActionPerformed
        try {
            
            validarDatosAsistente(this.tfNombreAsis.getText(), this.tfSueldoAsis.getText(),
                    this.tfTelefonoAsis.getText(), this.tfNacionalidadAsis.getText());
            asistente = Controlador.buscarAsistente(this.tfNombreAsis.getText());
            entrenador = Controlador.buscarEntrenador(tfIdAsis.getText());
            if (asistente == null) {
                Controlador.insertarAsistente(tfNombreAsis.getText(), tfSueldoAsis.getText(),
                        tfTelefonoAsis.getText(), tfNacionalidadAsis.getText(),entrenador);
                showMessageDialog(null, "Asistente Insertado");
                // Cerrar ventanas
                Controlador.cerrarVentana(this);
            } else {
                showMessageDialog(null, "Ya existe un Asistente con ese Nombre");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_bAceptarAsisActionPerformed

    private void bCancelarAsisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarAsisActionPerformed
        Controlador.cerrarVentana(this);
    }//GEN-LAST:event_bCancelarAsisActionPerformed

    private void tfIdAsisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdAsisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdAsisActionPerformed

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
            java.util.logging.Logger.getLogger(VInsertarAsistente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VInsertarAsistente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VInsertarAsistente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VInsertarAsistente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VInsertarAsistente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptarAsis;
    private javax.swing.JButton bCancelarAsis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lCerrar;
    private javax.swing.JLabel lMinimizar;
    private javax.swing.JLabel lNombreUsuario;
    private javax.swing.JPanel pMenu;
    private javax.swing.JTextField tfIdAsis;
    private javax.swing.JTextField tfNacionalidadAsis;
    private javax.swing.JTextField tfNombreAsis;
    private javax.swing.JTextField tfSueldoAsis;
    private javax.swing.JTextField tfTelefonoAsis;
    // End of variables declaration//GEN-END:variables

}
