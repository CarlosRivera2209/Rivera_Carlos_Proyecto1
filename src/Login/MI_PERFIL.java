package Login;

import Login.Inicio;
import Login.MenuPrincipal;
import Login.Variables;
import javax.swing.JOptionPane;

public class MI_PERFIL extends javax.swing.JFrame {

    Variables NombredeUsuario = new Variables();

    public MI_PERFIL() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EliminarCuenta = new javax.swing.JButton();
        CambiarPassword = new javax.swing.JButton();
        UltiGame = new javax.swing.JButton();
        VolverM = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        EliminarCuenta.setBackground(new java.awt.Color(102, 0, 51));
        EliminarCuenta.setForeground(new java.awt.Color(0, 0, 0));
        EliminarCuenta.setText("ELIMINAR CUENTA");
        EliminarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarCuentaActionPerformed(evt);
            }
        });
        getContentPane().add(EliminarCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 190, 110));

        CambiarPassword.setBackground(new java.awt.Color(102, 0, 102));
        CambiarPassword.setForeground(new java.awt.Color(0, 0, 0));
        CambiarPassword.setText("CAMBIAR PASSWORD");
        CambiarPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CambiarPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(CambiarPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 190, 110));

        UltiGame.setBackground(new java.awt.Color(204, 102, 255));
        UltiGame.setForeground(new java.awt.Color(0, 0, 0));
        UltiGame.setText("ULTIMOS JUEGOS");
        UltiGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UltiGameActionPerformed(evt);
            }
        });
        getContentPane().add(UltiGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 190, 110));

        VolverM.setBackground(new java.awt.Color(153, 0, 51));
        VolverM.setForeground(new java.awt.Color(0, 0, 0));
        VolverM.setText("Volver al Menu");
        VolverM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverMActionPerformed(evt);
            }
        });
        getContentPane().add(VolverM, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, 180, 70));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("MI PERFIL");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 230, 70));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/PERFIL.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VolverMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverMActionPerformed
        dispose();
        new MenuPrincipal().setVisible(true);
    }//GEN-LAST:event_VolverMActionPerformed

    private void CambiarPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CambiarPasswordActionPerformed
        for (int contar = 0; contar < NombredeUsuario.getNombredeUsuario().size(); contar++) {
            if (NombredeUsuario.getUser().equals(NombredeUsuario.getNombredeUsuario().get(contar))) {
                String passwordActual = javax.swing.JOptionPane.showInputDialog(this, "Ingrese la contraseña actual:");

                if (passwordActual != null && !passwordActual.isEmpty()) {
                    if (passwordActual.equals(NombredeUsuario.getContras().get(contar))) {
                        String nuevaPassword = javax.swing.JOptionPane.showInputDialog(this, "Ingrese la nueva contraseña:");

                        if (nuevaPassword != null && !nuevaPassword.isEmpty()) {
                            if (!NombredeUsuario.getContras().get(contar).equals(nuevaPassword)) {
                                NombredeUsuario.getContras().set(contar, nuevaPassword);
                                javax.swing.JOptionPane.showMessageDialog(this, "Contraseña cambiada con éxito.");
                            } else {
                                javax.swing.JOptionPane.showMessageDialog(this, "Ingrese una contraseña distinta.");
                            }
                        } else {
                            javax.swing.JOptionPane.showMessageDialog(this, "La nueva contraseña no puede estar vacía.");
                        }
                    } else {
                        javax.swing.JOptionPane.showMessageDialog(this, "Contraseña actual incorrecta.");
                    }
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "La contraseña actual no puede estar vacía.");
                }
            }
        }
    }//GEN-LAST:event_CambiarPasswordActionPerformed

    private void EliminarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarCuentaActionPerformed

        for (int contar = 0; contar < NombredeUsuario.getNombredeUsuario().size(); contar++) {
            if (NombredeUsuario.getUser().equals(NombredeUsuario.getNombredeUsuario().get(contar))) {
                String passwordActual = javax.swing.JOptionPane.showInputDialog(this, "Ingrese la contraseña actual:");

                if (passwordActual != null && passwordActual.equals(NombredeUsuario.getContras().get(contar))) {
                    NombredeUsuario.getNombredeUsuarioH().add(NombredeUsuario.getNombredeUsuario().get(contar));
                    NombredeUsuario.getContras().remove(contar);
                    NombredeUsuario.getNombredeUsuario().remove(contar);
                    NombredeUsuario.setUser("X. USADO");
                    NombredeUsuario.getPuntos().remove(contar);
                    NombredeUsuario.getPG_HEROES().remove(contar);
                    NombredeUsuario.getPG_VILLAINS().remove(contar);
                    dispose();
                    new Inicio().setVisible(true);
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Contraseña actual incorrecta o no ingresada.");
                }
                return; 
            }
        }
        javax.swing.JOptionPane.showMessageDialog(this, "Usuario no encontrado.");


    }//GEN-LAST:event_EliminarCuentaActionPerformed

    private void UltiGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UltiGameActionPerformed
        String log = "";
        for (int abuelo = NombredeUsuario.getLogs().size() - 1; abuelo >= 0; abuelo--) {
            if (NombredeUsuario.getLogs().get(abuelo).contains(NombredeUsuario.getUser())) {
                log += NombredeUsuario.getLogs().get(abuelo) + "\n";
                System.out.println(NombredeUsuario.getLogs());
            }
        }
        JOptionPane.showMessageDialog(this, log);
    }//GEN-LAST:event_UltiGameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CambiarPassword;
    private javax.swing.JButton EliminarCuenta;
    private javax.swing.JButton UltiGame;
    private javax.swing.JButton VolverM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
