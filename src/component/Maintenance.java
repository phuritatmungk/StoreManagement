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
        
        showDate();
        
        showTime();
    }
    
    public void showDate(){
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat(" dd/MM/yy");
        String dat = s.format(d);
        Date.setText(dat);
    }
    
    public void showTime(){
        new Timer (0,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm");
                String tim = s.format(d);
                Time.setText(tim);
            }
        }).start();
            
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
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
        txtQueue = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        Date = new javax.swing.JTextField();
        Time = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
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

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("ลำดับคิว :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("รับซ่อมอุปกรณ์และสินค้าการเกษตร");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("วันที่ :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("เวลา :");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 150, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("ผู้ส่งซ่อม :");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("หมายเลขโทรศัพท์ :");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setText("อุปกรณ์ที่รับซ่อม :");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 240, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setText("รหัสพนักงาน :");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox1.setBorder(null);
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 190, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setText("ผู้รับซ่อม :");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, -1, -1));

        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox2.setBorder(null);
        jComboBox2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 340, 190, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setText("อาการเสีย :");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setText("สถานะสินค้า :");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 340, -1, -1));

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextArea2.setRows(5);
        jTextArea2.setBorder(null);
        jScrollPane3.setViewportView(jTextArea2);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 360, 160));

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnSave.setText("บันทึก");
        btnSave.setBorder(null);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 640, 130, 50));

        txtQueue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtQueue.setForeground(new java.awt.Color(123, 123, 123));
        txtQueue.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtQueue.setText("1");
        txtQueue.setBorder(null);
        txtQueue.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtQueueFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQueueFocusLost(evt);
            }
        });
        add(txtQueue, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 90, 30));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 90, 30));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 150, 30));

        Date.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Date.setForeground(new java.awt.Color(123, 123, 123));
        Date.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Date.setText("00/00/00");
        Date.setBorder(null);
        Date.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                DateFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                DateFocusLost(evt);
            }
        });
        Date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateActionPerformed(evt);
            }
        });
        add(Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 150, 30));
        Date.getAccessibleContext().setAccessibleName("");

        Time.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Time.setForeground(new java.awt.Color(123, 123, 123));
        Time.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Time.setText("  00 : 00");
        Time.setBorder(null);
        Time.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TimeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TimeFocusLost(evt);
            }
        });
        add(Time, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 150, 80, 30));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 180, 80, 30));

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
        add(txtCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 210, 30));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 210, 30));

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
        add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 240, 210, 30));

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 270, 210, 30));

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
        add(txtBrokenItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 240, 210, 30));

        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 270, 210, 30));

        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 370, 130, 30));

        txtStatus.setEditable(false);
        txtStatus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtStatus.setForeground(new java.awt.Color(123, 123, 123));
        txtStatus.setText("   รอดำเนินการ");
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
        add(txtStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 340, 130, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void txtQueueFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQueueFocusGained
        if(txtQueue.getText().equals("1"))
        {
            txtQueue.setText("");
            txtQueue.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_txtQueueFocusGained

    private void txtQueueFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQueueFocusLost
        if (txtQueue.getText().length()==0) {
            txtQueue.setText("1");
            txtQueue.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_txtQueueFocusLost

    private void DateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DateFocusGained
        if(Date.getText().equals(" 00/00/00"))
       {
           Date.setText("");
           Date.setForeground(new Color(0, 0, 0));
       }
    }//GEN-LAST:event_DateFocusGained

    private void DateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DateFocusLost
        if (Date.getText().length()==0) {
            Date.setText(" 00/00/00");
            Date.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_DateFocusLost

    private void TimeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TimeFocusGained
        if (Time.getText().equals("  00 : 00"))
        {
            Time.setText("");
            Time.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_TimeFocusGained

    private void TimeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TimeFocusLost
        if (Time.getText().length()==0) {
            Time.setText("  00 : 00");
            Time.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_TimeFocusLost

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

    private void txtBrokenItemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBrokenItemFocusGained
        if(txtBrokenItem.getText().equals(" ชื่ออุปกรณ์ที่รับซ่อม"))
       {
           txtBrokenItem.setText("");
           txtBrokenItem.setForeground(new Color(0, 0, 0));
       }
    }//GEN-LAST:event_txtBrokenItemFocusGained

    private void txtBrokenItemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBrokenItemFocusLost
        if (txtBrokenItem.getText().length()==0) {
            txtBrokenItem.setText(" ชื่ออุปกรณ์ที่รับซ่อม");
            txtBrokenItem.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_txtBrokenItemFocusLost

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

    private void DateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Integer no = getNextQueueNumber();
        java.util.Date date = new java.util.Date();
        java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
        String name = txtCustomer.getText();
        Integer phone = Integer.valueOf(txtPhone.getText().toString());
        String item = txtBrokenItem.getText();
        Integer id = Integer.valueOf(jComboBox1.getSelectedItem().toString());
        String repairman = jComboBox2.getSelectedItem().toString();
        String status = txtStatus.getText();
        String malfunction = jTextArea2.getText();
        
        String insertQuery = "INSERT INTO `request`(`No`, `Datetime`, `Name`, `Phone`, `Item`, `Id`, `Repairman`, `Status`, `Malfunction`) VALUES (?,?,?,?,?,?,?,?,?)";
        
        try {
                
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
            ps.setInt(1, no);
            ps.setTimestamp(2, timestamp);
            ps.setString(3, name);
            ps.setInt(4, phone);
            ps.setString(5, item);
            ps.setInt(6, id);
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
    }//GEN-LAST:event_btnSaveActionPerformed

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
    private javax.swing.JTextField Date;
    private javax.swing.JTextField Time;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField txtBrokenItem;
    private javax.swing.JTextField txtCustomer;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtQueue;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables
}
