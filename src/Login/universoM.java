
package Login;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class universoM extends javax.swing.JFrame {

    Variables NombredeUsuario = new Variables();

    public universoM() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Batallas = new javax.swing.JButton();
        Ranking = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        JUGADAS = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Batallas.setBackground(new java.awt.Color(102, 0, 0));
        Batallas.setForeground(new java.awt.Color(0, 0, 0));
        Batallas.setText("LISTA DE USUARIOS");
        Batallas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BatallasActionPerformed(evt);
            }
        });
        getContentPane().add(Batallas, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 150, 80));

        Ranking.setBackground(new java.awt.Color(0, 0, 153));
        Ranking.setForeground(new java.awt.Color(0, 0, 0));
        Ranking.setText("RANKING");
        Ranking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RankingActionPerformed(evt);
            }
        });
        getContentPane().add(Ranking, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 150, 80));

        jButton3.setBackground(new java.awt.Color(0, 153, 204));
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Regresar al Menu");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 470, 150, 80));

        JUGADAS.setBackground(new java.awt.Color(153, 51, 255));
        JUGADAS.setForeground(new java.awt.Color(0, 0, 0));
        JUGADAS.setText("JUGADAS");
        JUGADAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JUGADASActionPerformed(evt);
            }
        });
        getContentPane().add(JUGADAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 150, 80));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("UNIVERSO MARVEL");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/universoMarvel.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
        new MenuPrincipal().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void RankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RankingActionPerformed
        String Ranking;
        int temp;
        ArrayList<String> Usuarios = new ArrayList<>();
        ArrayList<Integer> Points = new ArrayList<>();

        for (int contador = 0; contador < NombredeUsuario.getNombredeUsuario().size(); contador++) {
            Usuarios.add(NombredeUsuario.getNombredeUsuario().get(contador));
            Points.add(NombredeUsuario.getPuntos().get(contador));
        }
        for (int loop = 0; loop < Usuarios.size() - 1; loop++) {
            for (int bucle = 0; bucle < Usuarios.size() - 1 - loop; bucle++) {
                if (Points.get(bucle + 1) > Points.get(bucle)) {
                    temp = Points.get(bucle);
                    Points.set(bucle, Points.get(bucle + 1));
                    Points.set(bucle + 1, temp);
                    Ranking = Usuarios.get(bucle);
                    Usuarios.set(bucle, Usuarios.get(bucle + 1));
                    Usuarios.set(bucle + 1, Ranking);
                }
            }
        }
        Ranking = "";
        for (int palindromo = 0; palindromo < Usuarios.size(); palindromo++) {
            Ranking += "Puesto " + (palindromo + 1) + " " + "Usuario: " + Usuarios.get(palindromo) + " " + "Puntos: " + Points.get(palindromo) + "\n";
        }
        JOptionPane.showMessageDialog(this, Ranking);
    }//GEN-LAST:event_RankingActionPerformed

    private void BatallasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BatallasActionPerformed
        String UserA = "Usuarios Activos \n";

        for (int pepe = 0; pepe < NombredeUsuario.getNombredeUsuario().size(); pepe++) {
            UserA += NombredeUsuario.getNombredeUsuario().get(pepe) + "\n";
        }

        UserA += "Cuentas Eliminadas \n";

        for (int papa = 0; papa < NombredeUsuario.getNombredeUsuarioH().size(); papa++) {
            UserA += NombredeUsuario.getNombredeUsuarioH().get(papa) + "\n";
        }
        JOptionPane.showMessageDialog(this, UserA);
    }//GEN-LAST:event_BatallasActionPerformed

    private void JUGADASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JUGADASActionPerformed
        String games = "Partidas Jugadas \n";

        for (int mama = 0; mama < NombredeUsuario.getNombredeUsuario().size(); mama++) {
            if (NombredeUsuario.getUser().equals(NombredeUsuario.getNombredeUsuario().get(mama))) {
                games += "Partidas Ganadas como Heroe \n";
                games += NombredeUsuario.getPG_HEROES().get(mama) + "\n";
                games += "Partidas Ganadas como Villano \n";
                games += NombredeUsuario.getPG_VILLAINS().get(mama) + "\n";
            }
        }
        JOptionPane.showMessageDialog(this, games);
    }//GEN-LAST:event_JUGADASActionPerformed

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
            java.util.logging.Logger.getLogger(universoM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(universoM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(universoM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(universoM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new universoM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Batallas;
    private javax.swing.JButton JUGADAS;
    private javax.swing.JButton Ranking;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
