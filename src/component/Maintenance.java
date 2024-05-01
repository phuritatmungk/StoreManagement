package component;

import java.awt.Color;
import karnkha.Main;
import component.Repair_List_Page;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import karnkha.DB;
import java.sql.ResultSet;
public class Maintenance extends javax.swing.JPanel {

    public Maintenance() {
        initComponents();
        loadEmployees();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        btnSave = new javax.swing.JButton();
        txtCustomer = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        txtPhone = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        txtBrokenItem = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        txtStatus = new javax.swing.JTextField();

        setBackground(new java.awt.Color(245, 245, 245));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(139, 139, 139));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back-button.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 60));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("รับซ่อมอุปกรณ์และสินค้าการเกษตร");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("ผู้ส่งซ่อม :");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("หมายเลขโทรศัพท์ :");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setText("อุปกรณ์ที่รับซ่อม :");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 190, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setText("รหัสพนักงาน :");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "เลือกรหัสพนักงาน" }));
        jComboBox1.setToolTipText("");
        jComboBox1.setBorder(null);
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 190, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setText("ผู้รับซ่อม :");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, -1, -1));

        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "เลือกพนักงาน" }));
        jComboBox2.setToolTipText("");
        jComboBox2.setBorder(null);
        jComboBox2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 290, 190, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setText("อาการเสีย :");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setText("สถานะสินค้า :");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 290, -1, -1));

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextArea2.setRows(5);
        jTextArea2.setBorder(null);
        jScrollPane3.setViewportView(jTextArea2);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 360, 160));

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnSave.setText("บันทึก");
        btnSave.setBorder(null);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 590, 130, 50));

        txtCustomer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCustomer.setForeground(new java.awt.Color(123, 123, 123));
        txtCustomer.setText(" ชื่อผู้ส่งซ่อม");
        txtCustomer.setBorder(null);
        txtCustomer.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCustomerFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCustomerFocusLost(evt);
            }
        });
        add(txtCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 210, 30));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 210, 30));

        txtPhone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPhone.setForeground(new java.awt.Color(123, 123, 123));
        txtPhone.setText(" หมายเลขโทรศัพท์");
        txtPhone.setBorder(null);
        txtPhone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPhoneFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPhoneFocusLost(evt);
            }
        });
        txtPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPhoneKeyReleased(evt);
            }
        });
        add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 190, 210, 30));

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 220, 210, 30));

        txtBrokenItem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtBrokenItem.setForeground(new java.awt.Color(123, 123, 123));
        txtBrokenItem.setText(" ชื่ออุปกรณ์ที่รับซ่อม");
        txtBrokenItem.setBorder(null);
        txtBrokenItem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBrokenItemFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBrokenItemFocusLost(evt);
            }
        });
        add(txtBrokenItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 190, 210, 30));

        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 220, 210, 30));

        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 320, 130, 30));

        txtStatus.setEditable(false);
        txtStatus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtStatus.setForeground(new java.awt.Color(123, 123, 123));
        txtStatus.setText("รอดำเนินการ");
        txtStatus.setBorder(null);
        txtStatus.setFocusable(false);
        txtStatus.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtStatusFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtStatusFocusLost(evt);
            }
        });
        txtStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStatusActionPerformed(evt);
            }
        });
        add(txtStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 290, 130, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void txtCustomerFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustomerFocusGained
        if(txtCustomer.getText().equals(" ชื่อผู้ส่งซ่อม"))
       {
           txtCustomer.setText("");
           txtCustomer.setForeground(new Color(0, 0, 0));
       }
    }//GEN-LAST:event_txtCustomerFocusGained

    private void txtCustomerFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustomerFocusLost
        if (txtCustomer.getText().length()==0) {
            txtCustomer.setText(" ชื่อผู้ส่งซ่อม");
            txtCustomer.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_txtCustomerFocusLost

    private void txtPhoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPhoneFocusGained
        if(txtPhone.getText().equals(" หมายเลขโทรศัพท์"))
       {
           txtPhone.setText("");
           txtPhone.setForeground(new Color(0, 0, 0));
       }
    }//GEN-LAST:event_txtPhoneFocusGained

    private void txtPhoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPhoneFocusLost
        if (txtPhone.getText().length()==0) {
            txtPhone.setText(" หมายเลขโทรศัพท์");
            txtPhone.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_txtPhoneFocusLost

    private void txtStatusFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStatusFocusGained
        if(txtStatus.getText().equals("   รอดำเนินการ"))
       {
           txtStatus.setText("");
           txtStatus.setForeground(new Color(0, 0, 0));
       }
    }//GEN-LAST:event_txtStatusFocusGained

    private void txtStatusFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStatusFocusLost
        if (txtStatus.getText().length()==0) {
            txtStatus.setText("   รอดำเนินการ");
            txtStatus.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_txtStatusFocusLost

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        Main.body.removeAll();
        Main.body.add(new Repair_List_Page());
        Main.body.repaint();
        Main.body.revalidate();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        
        String phone_var = txtPhone.getText();
        
        if (checkEmptyFields()) {
            if (phone_var.length() == 10) {
                Integer no = getNextQueueNumber();
                java.util.Date date = new java.util.Date();
                java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
                String name = txtCustomer.getText();
                String phone = txtPhone.getText();
                String item = txtBrokenItem.getText();
                String id = jComboBox1.getSelectedItem().toString();
                String repairman = jComboBox2.getSelectedItem().toString();
                String status = txtStatus.getText();
                String malfunction = jTextArea2.getText();

                String insertQuery = "INSERT INTO `request`(`No`, `Datetime`, `Name`, `Phone`, `Item`, `Id`, `Repairman`, `Status`, `Malfunction`) VALUES (?,?,?,?,?,?,?,?,?)";

                try {

                    PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
                    ps.setInt(1, no);
                    ps.setTimestamp(2, timestamp);
                    ps.setString(3, name);
                    ps.setString(4, phone);
                    ps.setString(5, item);
                    ps.setString(6, id);
                    ps.setString(7, repairman);
                    ps.setString(8, status);
                    ps.setString(9, malfunction);

                    if(ps.executeUpdate() > 0)
                    {
                        Main.body.removeAll();
                        Main.body.add(new Repair_List_Page());
                        Main.body.repaint();
                        Main.body.revalidate();
                        JOptionPane.showMessageDialog(null, "New Request Added Successfully", "Add Request", JOptionPane.INFORMATION_MESSAGE);
                        System.out.println("Added Complete");
                    }
                    else
                    {
                      JOptionPane.showMessageDialog(null, "Request Not Added", "Add Request", JOptionPane.ERROR_MESSAGE);
                      System.out.println("Some Error Message Here");  
                    }

                } catch (SQLException ex) {
                    System.out.println(ex);
                }                    
            } else {
                JOptionPane.showMessageDialog(null, "Phone must contains only 10 numbers", "Error", JOptionPane.WARNING_MESSAGE);
                txtPhone.requestFocus();
            }
        } 
        else {
            JOptionPane.showMessageDialog(null, "You must insert all fields", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtPhoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneKeyReleased
        String text = txtPhone.getText();
        
        if (!isNumeric(text)) {
            evt.consume();
            return;
        }
        else {
            JOptionPane.showMessageDialog(null, "Phone value must contain only numbers", "Error", JOptionPane.WARNING_MESSAGE);
            txtPhone.setText("");
        }
    }//GEN-LAST:event_txtPhoneKeyReleased

    private void txtBrokenItemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBrokenItemFocusLost
        if (txtBrokenItem.getText().length()==0) {
            txtBrokenItem.setText(" ชื่ออุปกรณ์ที่รับซ่อม");
            txtBrokenItem.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_txtBrokenItemFocusLost

    private void txtBrokenItemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBrokenItemFocusGained
        if(txtBrokenItem.getText().equals(" ชื่ออุปกรณ์ที่รับซ่อม"))
        {
            txtBrokenItem.setText("");
            txtBrokenItem.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_txtBrokenItemFocusGained

    private void txtStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStatusActionPerformed
    
    private boolean isNumeric(String input) {

        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }   
    
    public boolean checkEmptyFields() {
        String customer = txtCustomer.getText().trim();
        String phone = txtPhone.getText().trim();
        String item = txtBrokenItem.getText().trim();
        String recipient = String.valueOf(jComboBox2.getSelectedItem().toString());
        String id = String.valueOf(jComboBox1.getSelectedItem().toString());
        String malfunction = jTextArea2.getText().trim();
        
        if(customer.equals("") || customer.equals(" ชื่อผู้ส่งซ่อม") || phone.equals("") || phone.equals(" หมายเลขโทรศัพท์") || item.equals("") || item.equals(" ชื่ออุปกรณ์ที่รับซ่อม") || recipient.equals("")
                || recipient.equals("เลือกพนักงาน")|| id.equals("") || id.equals("เลือกรหัสพนักงาน") || malfunction.equals("")) {
            return false;
        }
        else {
          return true;    
        }
    }
    
    public void loadEmployees() {
        try {
            String query = "SELECT Id, Fname FROM employee";
            PreparedStatement ps = DB.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String employeeID = rs.getString("Id");
                String employeeName = rs.getString("Fname");

                jComboBox1.addItem(employeeID);
                jComboBox2.addItem(employeeName);
            }

        } catch (SQLException ex) {
            System.out.println("Failed to load employees: " + ex.getMessage());
        }
    }
    
    private int getNextQueueNumber() {
        int nextQueueNumber = 1; 

        try {
            String query = "SELECT MAX(No) AS MaxNo FROM request"; 
            PreparedStatement ps = DB.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                nextQueueNumber = rs.getInt("MaxNo") + 1;
            }
        } catch (SQLException ex) {
            System.out.println("Failed to get next queue number: " + ex.getMessage());
        }

        return nextQueueNumber;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField txtBrokenItem;
    private javax.swing.JTextField txtCustomer;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables
}
