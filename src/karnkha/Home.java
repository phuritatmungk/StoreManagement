package karnkha;

import karnkha.Main;
import component.Sellproduct;

public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Home() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        header1 = new component.Header();
        body = new javax.swing.JPanel();
        icon1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        icon2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        icon3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        icon4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        icon5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        icon6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        icon7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        icon8 = new javax.swing.JLabel();
        icon9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        icon10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1600, 900));

        jPanel1.setBackground(new java.awt.Color(217, 217, 217));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(163, 163, 163)));

        body.setBackground(new java.awt.Color(245, 245, 245));
        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/shopping-cart 1.png"))); // NOI18N
        icon1.setToolTipText("");
        icon1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        icon1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        icon1.setName(""); // NOI18N
        icon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon1MouseClicked(evt);
            }
        });
        body.add(icon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("ขายสินค้า");
        body.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, -1, -1));

        icon2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        icon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/money 1.png"))); // NOI18N
        icon2.setToolTipText("");
        icon2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        icon2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        icon2.setName(""); // NOI18N
        body.add(icon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("ชำระเงินค่าบริการซ่อม และ");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        body.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, -1, -1));
        jLabel2.getAccessibleContext().setAccessibleDescription("");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("อุปกรณ์การเกษตร");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        body.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, -1, -1));

        icon3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        icon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/fix 1.png"))); // NOI18N
        icon3.setToolTipText("");
        icon3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        icon3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        icon3.setName(""); // NOI18N
        body.add(icon3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("รับซ่อมอุปกรณ์ และ");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        body.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 260, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("สินค้าการเกษตร");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        body.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 290, -1, -1));

        icon4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        icon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logistic 2.png"))); // NOI18N
        icon4.setToolTipText("");
        icon4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        icon4.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        icon4.setName(""); // NOI18N
        body.add(icon4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 110, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("จัดการคลังสินค้า");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        body.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 260, -1, -1));

        icon5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        icon5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/report 1.png"))); // NOI18N
        icon5.setToolTipText("");
        icon5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        icon5.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        icon5.setName(""); // NOI18N
        body.add(icon5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 110, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("บันทึกการสั่งซื้อสินค้า");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        body.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 260, -1, -1));

        icon6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        icon6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/product 1.png"))); // NOI18N
        icon6.setToolTipText("");
        icon6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        icon6.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        icon6.setName(""); // NOI18N
        icon6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon6MouseClicked(evt);
            }
        });
        body.add(icon6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 440, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("รับสินค้าตามรายการสั่งซื้อ");
        body.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 590, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("ประวัติการสั่งซื้อ");
        body.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 590, -1, -1));

        icon7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        icon7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/1000005428 1.png"))); // NOI18N
        icon7.setToolTipText("");
        icon7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        icon7.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        icon7.setName(""); // NOI18N
        icon7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon7MouseClicked(evt);
            }
        });
        body.add(icon7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 440, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("จัดการทะเบียนพนักงาน");
        body.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 590, -1, -1));

        icon8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        icon8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/resume 1.png"))); // NOI18N
        icon8.setToolTipText("");
        icon8.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        icon8.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        icon8.setName(""); // NOI18N
        icon8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon8MouseClicked(evt);
            }
        });
        body.add(icon8, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 440, -1, -1));

        icon9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        icon9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/team 1.png"))); // NOI18N
        icon9.setToolTipText("");
        icon9.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        icon9.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        icon9.setName(""); // NOI18N
        icon9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon9MouseClicked(evt);
            }
        });
        body.add(icon9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 440, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("จัดการทะเบียนตัวแทนจำหน่าย");
        body.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 590, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("รายงานแสดงผลการดำเนินงาน");
        body.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 590, -1, -1));

        icon10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        icon10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/analytics 1.png"))); // NOI18N
        icon10.setToolTipText("");
        icon10.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        icon10.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        icon10.setName(""); // NOI18N
        icon10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon10MouseClicked(evt);
            }
        });
        body.add(icon10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 440, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void icon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon1MouseClicked
        new Main().setVisible(true);
        Main.body.removeAll();
        Main.body.add(new Sellproduct());
        Main.body.repaint();
        Main.body.revalidate();
        this.dispose();
    }//GEN-LAST:event_icon1MouseClicked

    private void icon6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_icon6MouseClicked

    private void icon7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_icon7MouseClicked

    private void icon8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_icon8MouseClicked

    private void icon9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_icon9MouseClicked

    private void icon10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_icon10MouseClicked

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private component.Header header1;
    private javax.swing.JLabel icon1;
    private javax.swing.JLabel icon10;
    private javax.swing.JLabel icon2;
    private javax.swing.JLabel icon3;
    private javax.swing.JLabel icon4;
    private javax.swing.JLabel icon5;
    private javax.swing.JLabel icon6;
    private javax.swing.JLabel icon7;
    private javax.swing.JLabel icon8;
    private javax.swing.JLabel icon9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
