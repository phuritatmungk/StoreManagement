package karnkha;

import java.awt.Color;


public class Login extends javax.swing.JFrame {

  
    public Login() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        T_User1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        eye_hide = new javax.swing.JLabel();
        eye = new javax.swing.JLabel();
        P_Pass1 = new javax.swing.JPasswordField();
        BLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 500));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(147, 26, 37));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("LOGIN");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 90, 50));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("User Name");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 230, 40));

        T_User1.setForeground(new java.awt.Color(153, 153, 153));
        T_User1.setText("User Name");
        T_User1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                T_User1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                T_User1FocusLost(evt);
            }
        });
        jPanel2.add(T_User1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 280, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Password");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 230, 40));

        eye_hide.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eye_hide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/eye_hide.png"))); // NOI18N
        eye_hide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                eye_hideMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                eye_hideMouseReleased(evt);
            }
        });
        jPanel2.add(eye_hide, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 30, 40));

        eye.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eye.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/eye.png"))); // NOI18N
        jPanel2.add(eye, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 30, 40));

        P_Pass1.setForeground(new java.awt.Color(153, 153, 153));
        P_Pass1.setText("Password");
        P_Pass1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                P_Pass1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                P_Pass1FocusLost(evt);
            }
        });
        jPanel2.add(P_Pass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 280, 40));

        BLogin.setBackground(new java.awt.Color(147, 26, 37));
        BLogin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BLogin.setForeground(new java.awt.Color(255, 255, 255));
        BLogin.setText("Login");
        BLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BLoginActionPerformed(evt);
            }
        });
        jPanel2.add(BLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 280, 30));

        jPanel1.add(jPanel2);
        jPanel2.setBounds(220, 10, 350, 440);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("LOGIN");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void T_User1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_T_User1FocusGained
        if(T_User1.getText().equals("User Name")) {
            T_User1.setText("");
            T_User1.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_T_User1FocusGained

    private void T_User1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_T_User1FocusLost
        if (T_User1.getText().isEmpty()) {
            T_User1.setText("User Name");
            T_User1.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_T_User1FocusLost

    private void BLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BLoginActionPerformed

    private void eye_hideMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eye_hideMousePressed
        eye.setVisible(true);
        eye_hide.setVisible(false);
        P_Pass1.setEchoChar((char)0);
    }//GEN-LAST:event_eye_hideMousePressed

    private void eye_hideMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eye_hideMouseReleased
        eye.setVisible(false);
        eye_hide.setVisible(true);
        P_Pass1.setEchoChar('*');
    }//GEN-LAST:event_eye_hideMouseReleased

    private void P_Pass1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_P_Pass1FocusGained
        String password = new String(P_Pass1.getPassword());
        if(password.equals("Password")) {
            P_Pass1.setText("");
            P_Pass1.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_P_Pass1FocusGained

    private void P_Pass1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_P_Pass1FocusLost
        String password = new String(P_Pass1.getPassword());
        if (password.isEmpty()) {
            P_Pass1.setText("Password");
            P_Pass1.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_P_Pass1FocusLost


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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BLogin;
    private javax.swing.JPasswordField P_Pass1;
    private javax.swing.JTextField T_User1;
    private javax.swing.JLabel eye;
    private javax.swing.JLabel eye_hide;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
