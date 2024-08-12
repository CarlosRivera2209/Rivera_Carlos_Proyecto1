
package Login;

public class Inicio extends javax.swing.JFrame {

    public Inicio() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        iniciarS = new javax.swing.JButton();
        CrearPlayer = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iniciarS.setBackground(new java.awt.Color(51, 51, 0));
        iniciarS.setForeground(new java.awt.Color(0, 0, 0));
        iniciarS.setText("CREAR PLAYER");
        iniciarS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarSActionPerformed(evt);
            }
        });
        jPanel1.add(iniciarS, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 440, 150, 80));

        CrearPlayer.setBackground(new java.awt.Color(0, 51, 51));
        CrearPlayer.setForeground(new java.awt.Color(0, 0, 0));
        CrearPlayer.setText("INICIAR SESION");
        CrearPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearPlayerActionPerformed(evt);
            }
        });
        jPanel1.add(CrearPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 150, 90));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BIENVENIDO.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iniciarSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarSActionPerformed

        dispose();
        new Registro().setVisible(true);
    }//GEN-LAST:event_iniciarSActionPerformed

    private void CrearPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearPlayerActionPerformed

        dispose();
        new iniciarSesion().setVisible(true);
    }//GEN-LAST:event_CrearPlayerActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CrearPlayer;
    private javax.swing.JButton iniciarS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
