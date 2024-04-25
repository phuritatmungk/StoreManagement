package component;
import java.awt.Color;
import karnkha.Main;
import component.Manage_Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import karnkha.DB;

public class Edit_employee_info extends javax.swing.JPanel {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
    public Edit_employee_info() {
        initComponents();
        con = DB.mycon();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back_button = new javax.swing.JLabel();
        Topic = new javax.swing.JLabel();
        JId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        JName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        JSname = new javax.swing.JLabel();
        txtSname = new javax.swing.JTextField();
        JAddress = new javax.swing.JLabel();
        address_box = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        JPhone = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        Add_dealer_information = new javax.swing.JLabel();
        picture_box = new javax.swing.JLabel();
        btnImg = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        JJob = new javax.swing.JLabel();
        JSalary = new javax.swing.JLabel();
        txtJob = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        txtSalary = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        txtNo = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back_button.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        back_button.setForeground(new java.awt.Color(139, 139, 139));
        back_button.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        back_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back-button.png"))); // NOI18N
        back_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back_buttonMouseClicked(evt);
            }
        });
        add(back_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 60));

        Topic.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Topic.setText("จัดการทะเบียนพนักงาน");
        add(Topic, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, -1, -1));

        JId.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JId.setText("รหัสพนักงาน");
        add(JId, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, -1, -1));

        txtId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtId.setForeground(new java.awt.Color(123, 123, 123));
        txtId.setText("รหัสพนักงาน");
        txtId.setBorder(null);
        txtId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIdFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdFocusLost(evt);
            }
        });
        add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, 220, 30));

        JName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JName.setText("ชื่อ");
        add(JName, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, -1, -1));

        txtName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtName.setForeground(new java.awt.Color(123, 123, 123));
        txtName.setText("ชื่อ");
        txtName.setBorder(null);
        txtName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNameFocusLost(evt);
            }
        });
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, 220, 30));

        JSname.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JSname.setText("นามสกุล");
        add(JSname, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, -1, -1));

        txtSname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSname.setForeground(new java.awt.Color(123, 123, 123));
        txtSname.setText("นามสกุล");
        txtSname.setBorder(null);
        txtSname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSnameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSnameFocusLost(evt);
            }
        });
        add(txtSname, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, 220, 30));

        JAddress.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JAddress.setText("ที่อยู่");
        add(JAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 320, -1, -1));

        txtAddress.setColumns(20);
        txtAddress.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtAddress.setRows(5);
        txtAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        address_box.setViewportView(txtAddress);

        add(address_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 330, 320, 170));

        JPhone.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JPhone.setText("เบอร์โทรศัพท์");
        add(JPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 410, -1, -1));

        txtPhone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPhone.setForeground(new java.awt.Color(123, 123, 123));
        txtPhone.setText("เบอร์โทรศัพท์");
        txtPhone.setBorder(null);
        txtPhone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPhoneFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPhoneFocusLost(evt);
            }
        });
        add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 410, 220, 30));

        Add_dealer_information.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Add_dealer_information.setText("ข้อมูลพนักงาน");
        add(Add_dealer_information, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, -1));

        picture_box.setBackground(new java.awt.Color(255, 255, 255));
        picture_box.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        picture_box.setForeground(new java.awt.Color(123, 123, 123));
        picture_box.setText("          รูปพนักงาน");
        picture_box.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(picture_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 200, 190));

        btnImg.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnImg.setText("เลือกรูป");
        btnImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgActionPerformed(evt);
            }
        });
        add(btnImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 120, 50));

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnSave.setText("บันทึก");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 590, 130, 50));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 440, 220, 30));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 220, 30));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 260, 220, 30));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 350, 220, 30));

        JJob.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JJob.setText("ตำแหน่ง");
        add(JJob, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 150, -1, -1));

        JSalary.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JSalary.setText("อัตราจ้าง");
        add(JSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 230, -1, -1));

        txtJob.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtJob.setForeground(new java.awt.Color(123, 123, 123));
        txtJob.setText("ตำแหน่ง");
        txtJob.setBorder(null);
        txtJob.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtJobFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtJobFocusLost(evt);
            }
        });
        add(txtJob, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 150, 220, 30));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 180, 220, 30));

        txtSalary.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSalary.setForeground(new java.awt.Color(123, 123, 123));
        txtSalary.setText("จำนวนเงิน");
        txtSalary.setBorder(null);
        txtSalary.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSalaryFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSalaryFocusLost(evt);
            }
        });
        add(txtSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 230, 220, 30));

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 260, 220, 30));

        txtNo.setEditable(false);
        txtNo.setBackground(new java.awt.Color(255, 255, 255));
        txtNo.setForeground(new java.awt.Color(255, 255, 255));
        txtNo.setText("1");
        txtNo.setBorder(null);
        txtNo.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtNo.setFocusable(false);
        add(txtNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 870, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImgActionPerformed

    private void txtIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdFocusGained
        if(txtId.getText().equals("รหัสพนักงาน"))
       {
           txtId.setText("");
           txtId.setForeground(new Color(0, 0, 0));
       }
    }//GEN-LAST:event_txtIdFocusGained

    private void txtIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdFocusLost
        if (txtId.getText().length()==0) {
            txtId.setText("รหัสพนักงาน");
            txtId.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_txtIdFocusLost

    private void txtNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusGained
        if(txtName.getText().equals("ชื่อ"))
       {
           txtName.setText("");
           txtName.setForeground(new Color(0, 0, 0));
       }
    }//GEN-LAST:event_txtNameFocusGained

    private void txtNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusLost
        if (txtName.getText().length()==0) {
            txtName.setText("ชื่อ");
            txtName.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_txtNameFocusLost

    private void txtSnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSnameFocusGained
        if(txtSname.getText().equals("นามสกุล"))
       {
           txtSname.setText("");
           txtSname.setForeground(new Color(0, 0, 0));
       }
    }//GEN-LAST:event_txtSnameFocusGained

    private void txtSnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSnameFocusLost
        if (txtSname.getText().length()==0) {
            txtSname.setText("นามสกุล");
            txtSname.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_txtSnameFocusLost

    private void back_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_buttonMouseClicked
        Main.body.removeAll();
        Main.body.add(new Manage_Employee());
        Main.body.repaint();
        Main.body.revalidate();
    }//GEN-LAST:event_back_buttonMouseClicked

    private void txtPhoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPhoneFocusGained
        if(txtPhone.getText().equals("เบอร์โทรศัพท์"))
       {
           txtPhone.setText("");
           txtPhone.setForeground(new Color(0, 0, 0));
       }
    }//GEN-LAST:event_txtPhoneFocusGained

    private void txtPhoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPhoneFocusLost
        if (txtPhone.getText().length()==0) {
            txtPhone.setText("เบอร์โทรศัพท์");
            txtPhone.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_txtPhoneFocusLost

    private void txtJobFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtJobFocusGained
        if(txtJob.getText().equals("ตำแหน่ง"))
       {
           txtJob.setText("");
           txtJob.setForeground(new Color(0, 0, 0));
       }
    }//GEN-LAST:event_txtJobFocusGained

    private void txtJobFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtJobFocusLost
        if (txtJob.getText().length()==0) {
            txtJob.setText("ตำแหน่ง");
            txtJob.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_txtJobFocusLost

    private void txtSalaryFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSalaryFocusGained
        if(txtSalary.getText().equals("จำนวนเงิน"))
       {
           txtSalary.setText("");
           txtSalary.setForeground(new Color(0, 0, 0));
       }
    }//GEN-LAST:event_txtSalaryFocusGained

    private void txtSalaryFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSalaryFocusLost
        if (txtSalary.getText().length()==0) {
            txtSalary.setText("จำนวนเงิน");
            txtSalary.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_txtSalaryFocusLost

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Integer no = Integer.valueOf(txtNo.getText().toString());
        Integer id = Integer.valueOf(txtId.getText().toString());
        String fname = txtName.getText();
        String sname = txtSname.getText();
        String address = txtAddress.getText();
        String job = txtJob.getText();
        Double wage = Double.valueOf(txtSalary.getText().toString());
        Integer phone = Integer.valueOf(txtPhone.getText().toString());


 
        String updateQuery = "UPDATE employee SET Fname=?,SName=?,Id=?,Phone=? ,Job=? ,Wage=?,Address=? WHERE No=?";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(updateQuery);
            ps.setString(1, fname);
            ps.setString(2, sname);
            ps.setInt(3, id);
            ps.setInt(4, phone);
            ps.setString(5, job);
            ps.setDouble(6, wage); 
            ps.setString(7, address);
            ps.setInt(8, no);

            if(ps.executeUpdate() > 0)
            {
                Main.body.removeAll();
                Main.body.add(new Manage_Distributor());
                Main.body.repaint();
                Main.body.revalidate();
                JOptionPane.showMessageDialog(null, "Edit Employee Info Successfully", "Edit Employee Info", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Updated");
            }
            else
            {
                System.out.println("Failed");
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Add_dealer_information;
    private javax.swing.JLabel JAddress;
    private javax.swing.JLabel JId;
    private javax.swing.JLabel JJob;
    private javax.swing.JLabel JName;
    private javax.swing.JLabel JPhone;
    private javax.swing.JLabel JSalary;
    private javax.swing.JLabel JSname;
    private javax.swing.JLabel Topic;
    private javax.swing.JScrollPane address_box;
    private javax.swing.JLabel back_button;
    private javax.swing.JButton btnImg;
    private javax.swing.JButton btnSave;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel picture_box;
    public static javax.swing.JTextArea txtAddress;
    public static javax.swing.JTextField txtId;
    public static javax.swing.JTextField txtJob;
    public static javax.swing.JTextField txtName;
    public static javax.swing.JTextField txtNo;
    public static javax.swing.JTextField txtPhone;
    public static javax.swing.JTextField txtSalary;
    public static javax.swing.JTextField txtSname;
    // End of variables declaration//GEN-END:variables
}
