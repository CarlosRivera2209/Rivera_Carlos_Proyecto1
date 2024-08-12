package Login;


public class MenuPrincipal extends javax.swing.JFrame {

    Variables NombredeUsuario = new Variables();

    public MenuPrincipal() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        perfil = new javax.swing.JButton();
        uniMarvel = new javax.swing.JButton();
        Cerrar = new javax.swing.JButton();
        NuevaPartida = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        perfil.setBackground(new java.awt.Color(0, 51, 102));
        perfil.setForeground(new java.awt.Color(0, 0, 0));
        perfil.setText("MI PERFIL");
        perfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perfilActionPerformed(evt);
            }
        });
        getContentPane().add(perfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 240, 80));

        uniMarvel.setBackground(new java.awt.Color(102, 153, 255));
        uniMarvel.setForeground(new java.awt.Color(0, 0, 0));
        uniMarvel.setText("UNIVERSO MARVEL");
        uniMarvel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uniMarvelActionPerformed(evt);
            }
        });
        getContentPane().add(uniMarvel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 240, 80));

        Cerrar.setBackground(new java.awt.Color(204, 0, 0));
        Cerrar.setForeground(new java.awt.Color(0, 0, 0));
        Cerrar.setText("CERRAR SESIÓN");
        Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarActionPerformed(evt);
            }
        });
        getContentPane().add(Cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 450, 240, 70));

        NuevaPartida.setBackground(new java.awt.Color(0, 153, 255));
        NuevaPartida.setForeground(new java.awt.Color(0, 0, 0));
        NuevaPartida.setText("NUEVA PARTIDA");
        NuevaPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevaPartidaActionPerformed(evt);
            }
        });
        getContentPane().add(NuevaPartida, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 240, 80));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("MARVEL");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, 50));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 51));
        jLabel3.setText("STRATEGO");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/menu.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void perfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perfilActionPerformed
        dispose();
        new MI_PERFIL().setVisible(true);
    }//GEN-LAST:event_perfilActionPerformed

    private void uniMarvelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uniMarvelActionPerformed
        dispose();
        new universoM().setVisible(true);
    }//GEN-LAST:event_uniMarvelActionPerformed

    private void CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarActionPerformed
        NombredeUsuario.setUser("X. USADO");
        dispose();
        new Inicio().setVisible(true);
    }//GEN-LAST:event_CerrarActionPerformed

    private void NuevaPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevaPartidaActionPerformed

        if (NombredeUsuario.getNombredeUsuario().size() >= 2) {
            dispose();
            new iniciarSesion().setVisible(true);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "NO HAY SUFICIENTES CUENTAS PARA JUGAR",
                    "Advertencia", javax.swing.JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_NuevaPartidaActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cerrar;
    private javax.swing.JButton NuevaPartida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton perfil;
    private javax.swing.JButton uniMarvel;
    // End of variables declaration//GEN-END:variables
}
