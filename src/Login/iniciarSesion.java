
package Login;

import java.awt.Component;
import java.awt.Container;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

/**
 *
 * @author caugu
 */
public class iniciarSesion extends javax.swing.JFrame {

    Variables NombredeUsuario = new Variables();

    public iniciarSesion() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Ingreso = new javax.swing.JTextField();
        passIngreso = new javax.swing.JPasswordField();
        iniciarSesion = new javax.swing.JButton();
        Regreso = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        mirarPass = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NOMBRE DE USUARIO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 250, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CONTRASEÑA");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        Ingreso.setBackground(new java.awt.Color(255, 255, 255));
        Ingreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresoActionPerformed(evt);
            }
        });
        getContentPane().add(Ingreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 251, -1));

        passIngreso.setBackground(new java.awt.Color(255, 255, 255));
        passIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passIngresoActionPerformed(evt);
            }
        });
        getContentPane().add(passIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 251, -1));

        iniciarSesion.setBackground(new java.awt.Color(255, 204, 0));
        iniciarSesion.setForeground(new java.awt.Color(0, 0, 0));
        iniciarSesion.setText("INICIAR SESION");
        iniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarSesionActionPerformed(evt);
            }
        });
        getContentPane().add(iniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, 137, 48));

        Regreso.setBackground(new java.awt.Color(255, 51, 51));
        Regreso.setForeground(new java.awt.Color(0, 0, 0));
        Regreso.setText("REGRESAR AL MENU");
        Regreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresoActionPerformed(evt);
            }
        });
        getContentPane().add(Regreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, -1, 48));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        mirarPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Untitled design (3).jpg"))); // NOI18N
        mirarPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mirarPassActionPerformed(evt);
            }
        });
        getContentPane().add(mirarPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 30, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("INICIAR SESIÓN");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/413c019acb6b6f899686851d15d80b60.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresoActionPerformed
        dispose();
        new Inicio().setVisible(true);
    }//GEN-LAST:event_RegresoActionPerformed

    private void iniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarSesionActionPerformed
        for (int contar = 0; contar < NombredeUsuario.getNombredeUsuario().size(); contar++) {

            if (Ingreso.getText().equals(NombredeUsuario.getNombredeUsuario().get(contar))) {
                if (passIngreso.getText().equals(NombredeUsuario.getContras().get(contar))) {
                    if (NombredeUsuario.getUser().equals(("X. USADO"))) {
                    NombredeUsuario.setUser(Ingreso.getText());
                    dispose();
                    new MenuPrincipal().setVisible(true);
                    }else if(!NombredeUsuario.getUser().equals(Ingreso.getText())){
                        NombredeUsuario.setUser2(Ingreso.getText());
                        dispose();
                        new GameBoard().setVisible(true);                    }
                }
            }
        }
    }//GEN-LAST:event_iniciarSesionActionPerformed

    private void mirarPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mirarPassActionPerformed
        if (passIngreso.echoCharIsSet()) {
            passIngreso.setEchoChar((char) 0);
        } else
            passIngreso.setEchoChar('\u2022');
    }//GEN-LAST:event_mirarPassActionPerformed

    private void IngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IngresoActionPerformed

    private void passIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passIngresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passIngresoActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Ingreso;
    private javax.swing.JButton Regreso;
    private javax.swing.JButton iniciarSesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton mirarPass;
    private javax.swing.JPasswordField passIngreso;
    // End of variables declaration//GEN-END:variables
}
