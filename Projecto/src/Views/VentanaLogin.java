/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import projecto.Controlador;
import static javax.swing.JOptionPane.*;

/**
 *
 * @author 1GDAW12
 */
public class VentanaLogin extends javax.swing.JFrame {
    int xx;
    int xy;
    boolean a = true;
    String rol;
    /**
     * Creates new form VentanaLogin
     */
    public VentanaLogin() {
        initComponents();
         this.setLocationRelativeTo(null);
         this.rbUsuario.setSelected(true);
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/descarga.png")).getImage());
        lUsuOContErr.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lMinimizar = new javax.swing.JLabel();
        lCerrar = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        tfCorreo = new javax.swing.JTextField();
        tfClave = new javax.swing.JPanel();
        pfClave = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        bLogin = new javax.swing.JButton();
        lUsuOContErr = new javax.swing.JLabel();
        vercontrasena = new javax.swing.JLabel();
        rbUsuario = new javax.swing.JRadioButton();
        rbAdministrador = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(6, 57, 113));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Inicio de Sesión");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        lMinimizar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lMinimizar.setForeground(new java.awt.Color(255, 255, 255));
        lMinimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lMinimizar.setText("_");
        lMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lMinimizarMouseClicked(evt);
            }
        });
        jPanel2.add(lMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, -10, 20, 30));

        lCerrar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lCerrar.setForeground(new java.awt.Color(255, 255, 255));
        lCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lCerrar.setText("X");
        lCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lCerrarMouseClicked(evt);
            }
        });
        jPanel2.add(lCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 30, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 70));

        jPanel3.setBackground(new java.awt.Color(205, 205, 205));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 440, 20));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/23982d31ee932c26a021b175c47bb157.png"))); // NOI18N
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 50, 60));

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfCorreo.setBackground(new java.awt.Color(204, 204, 204));
        tfCorreo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfCorreo.setText("Correo");
        tfCorreo.setToolTipText("");
        tfCorreo.setBorder(null);
        tfCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCorreoFocusLost(evt);
            }
        });
        tfCorreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfCorreoMouseClicked(evt);
            }
        });
        tfCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCorreoActionPerformed(evt);
            }
        });
        jPanel8.add(tfCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 240, 40));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 270, 40));

        tfClave.setBackground(new java.awt.Color(204, 204, 204));
        tfClave.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pfClave.setBackground(new java.awt.Color(204, 204, 204));
        pfClave.setText("Contraseña");
        pfClave.setBorder(null);
        pfClave.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pfClaveFocusLost(evt);
            }
        });
        pfClave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pfClaveMouseClicked(evt);
            }
        });
        tfClave.add(pfClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 240, -1));

        jPanel1.add(tfClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 270, 40));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/png-clipart-lock-computer-icons-padlock-technic-security.png"))); // NOI18N
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 40, 40));

        bLogin.setBackground(new java.awt.Color(0, 0, 0));
        bLogin.setForeground(new java.awt.Color(255, 255, 255));
        bLogin.setText("Aceptar");
        bLogin.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoginActionPerformed(evt);
            }
        });
        jPanel1.add(bLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 120, 30));

        lUsuOContErr.setBackground(new java.awt.Color(255, 255, 255));
        lUsuOContErr.setForeground(new java.awt.Color(255, 51, 51));
        lUsuOContErr.setText("Usuario o contraseña errona");
        jPanel1.add(lUsuOContErr, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 170, -1));

        vercontrasena.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1001008.png"))); // NOI18N
        vercontrasena.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                vercontrasenaMousePressed(evt);
            }
        });
        jPanel1.add(vercontrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, -1, 30));

        buttonGroup1.add(rbUsuario);
        rbUsuario.setText("USUARIO");
        rbUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(rbUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        buttonGroup1.add(rbAdministrador);
        rbAdministrador.setSelected(true);
        rbAdministrador.setText("ADMINISTRADOR");
        rbAdministrador.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        rbAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAdministradorActionPerformed(evt);
            }
        });
        jPanel1.add(rbAdministrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, -1, -1));

        jPanel5.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 420));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCorreoFocusLost
        if(tfCorreo.getText().isEmpty())
        tfCorreo.setText("Correo");
    }//GEN-LAST:event_tfCorreoFocusLost

    private void tfCorreoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfCorreoMouseClicked
        tfCorreo.setText("");
    }//GEN-LAST:event_tfCorreoMouseClicked

    private void tfCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCorreoActionPerformed
        
    }//GEN-LAST:event_tfCorreoActionPerformed

    private void pfClaveFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pfClaveFocusLost
        if(pfClave.getText().isEmpty())
        pfClave.setText("Contraseña");
    }//GEN-LAST:event_pfClaveFocusLost

    private void pfClaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pfClaveMouseClicked
        pfClave.setText("");
    }//GEN-LAST:event_pfClaveMouseClicked

    private void lMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lMinimizarMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_lMinimizarMouseClicked

    private void lCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lCerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lCerrarMouseClicked

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        xx=evt.getX();
        xy=evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x-xx, y-xy);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void vercontrasenaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vercontrasenaMousePressed
        if (a) {
            pfClave.setEchoChar((char)0);
            a = false;
        }
        else {
            pfClave.setEchoChar('•');
            a = true;
        }
    }//GEN-LAST:event_vercontrasenaMousePressed

    private void bLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoginActionPerformed
       
      if(this.rbUsuario.isSelected()){
          rol="usuario" ;
      }else{
          rol="administrador";
      }
      Controlador.inicioSesion(rol,this.tfCorreo.getText(),this.tfClave.getToolTipText());
    }//GEN-LAST:event_bLoginActionPerformed

    private void rbAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAdministradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbAdministradorActionPerformed

    private void rbUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbUsuarioActionPerformed
        
    }//GEN-LAST:event_rbUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bLogin;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lCerrar;
    private javax.swing.JLabel lMinimizar;
    private javax.swing.JLabel lUsuOContErr;
    private javax.swing.JPasswordField pfClave;
    private javax.swing.JRadioButton rbAdministrador;
    private javax.swing.JRadioButton rbUsuario;
    private javax.swing.JPanel tfClave;
    private javax.swing.JTextField tfCorreo;
    private javax.swing.JLabel vercontrasena;
    // End of variables declaration//GEN-END:variables
}
