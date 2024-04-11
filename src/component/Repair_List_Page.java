package component;

public class Repair_List_Page extends javax.swing.JPanel {

    public Repair_List_Page() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back_button1 = new javax.swing.JLabel();
        Topic = new javax.swing.JLabel();
        edit_bt = new javax.swing.JButton();
        Save_bt1 = new javax.swing.JButton();
        delete_bt = new javax.swing.JButton();
        Status_Combo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back_button1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        back_button1.setForeground(new java.awt.Color(139, 139, 139));
        back_button1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        back_button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back-button.png"))); // NOI18N
        add(back_button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 60));

        Topic.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Topic.setText("รับซ่อมอุปกรณ์และสินค้าเกษตร");
        add(Topic, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, -1, -1));

        edit_bt.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        edit_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/edit_1.png"))); // NOI18N
        edit_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_btActionPerformed(evt);
            }
        });
        add(edit_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 130, 40, 40));

        Save_bt1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Save_bt1.setText("เพิ่ม");
        Save_bt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Save_bt1MouseClicked(evt);
            }
        });
        Save_bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Save_bt1ActionPerformed(evt);
            }
        });
        add(Save_bt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 640, 130, 50));

        delete_bt.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        delete_bt.setText("ลบ");
        delete_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btActionPerformed(evt);
            }
        });
        add(delete_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 640, 130, 50));

        Status_Combo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Status_Combo.setForeground(new java.awt.Color(123, 123, 123));
        Status_Combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ค้นหาสถานะ", "รอการดำเนินการ", "กำลังดำเนินการ", "เสร็จการดำเนินการ", "ชำระเสร็จสิ้น" }));
        add(Status_Combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1122, 50, 170, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("ค้นหาสถานะ");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 60, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void edit_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_btActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edit_btActionPerformed

    private void delete_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delete_btActionPerformed

    private void Save_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Save_bt1ActionPerformed

    }//GEN-LAST:event_Save_bt1ActionPerformed

    private void Save_bt1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Save_bt1MouseClicked

    }//GEN-LAST:event_Save_bt1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Save_bt1;
    private javax.swing.JComboBox<String> Status_Combo;
    private javax.swing.JLabel Topic;
    private javax.swing.JLabel back_button1;
    private javax.swing.JButton delete_bt;
    private javax.swing.JButton edit_bt;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    private void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
