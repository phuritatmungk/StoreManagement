package component;
import java.awt.Color;
import component.Manage_Distributor;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import karnkha.DB;
import karnkha.Main;
import java.sql.*;

public class Distributor_Register extends javax.swing.JPanel {
    
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public Distributor_Register() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back_button = new javax.swing.JLabel();
        Topic = new javax.swing.JLabel();
        JName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        JSurname = new javax.swing.JLabel();
        txtSname = new javax.swing.JTextField();
        JCompany = new javax.swing.JLabel();
        txtCompany = new javax.swing.JTextField();
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
        jSeparator5 = new javax.swing.JSeparator();

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
        Topic.setText("จัดการทะเบียนตัวแทนจำหน่าย");
        add(Topic, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, -1, -1));

        JName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JName.setText("ชื่อ");
        add(JName, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, -1, -1));

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
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 370, 30));

        JSurname.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JSurname.setText("นามสกุล");
        add(JSurname, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, -1, -1));

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
        add(txtSname, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, 370, 30));

        JCompany.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JCompany.setText("บริษัท");
        add(JCompany, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, -1, -1));

        txtCompany.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCompany.setForeground(new java.awt.Color(123, 123, 123));
        txtCompany.setText("ชื่อบริษัท");
        txtCompany.setBorder(null);
        txtCompany.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCompanyFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCompanyFocusLost(evt);
            }
        });
        add(txtCompany, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, 370, 30));

        JAddress.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JAddress.setText("ที่อยู่");
        add(JAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, -1, -1));

        txtAddress.setColumns(20);
        txtAddress.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtAddress.setRows(5);
        txtAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        address_box.setViewportView(txtAddress);

        add(address_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 370, 370, 160));

        JPhone.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JPhone.setText("เบอร์โทรศัพท์");
        add(JPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 570, -1, -1));

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
        txtPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPhoneKeyReleased(evt);
            }
        });
        add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 570, 370, 30));

        Add_dealer_information.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Add_dealer_information.setText("เพิ่มข้อมูลตัวแทนจำหน่าย");
        add(Add_dealer_information, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 140, -1, -1));

        picture_box.setBackground(new java.awt.Color(255, 255, 255));
        picture_box.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        picture_box.setForeground(new java.awt.Color(123, 123, 123));
        picture_box.setText("                     รูปนามบัตร");
        picture_box.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(picture_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 190, 330, 270));

        btnImg.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnImg.setText("เลือกรูป");
        btnImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImgActionPerformed(evt);
            }
        });
        add(btnImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 490, 130, 50));

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnSave.setText("บันทึก");
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 640, 130, 50));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 600, 370, 30));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 370, 30));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 370, 30));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, 370, 30));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, 370, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btnImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImgActionPerformed

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

    private void txtCompanyFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCompanyFocusGained
        if(txtCompany.getText().equals("ชื่อบริษัท"))
       {
           txtCompany.setText("");
           txtCompany.setForeground(new Color(0, 0, 0));
       }
    }//GEN-LAST:event_txtCompanyFocusGained

    private void txtCompanyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCompanyFocusLost
        if (txtCompany.getText().length()==0) {
            txtCompany.setText("ชื่อบริษัท");
            txtCompany.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_txtCompanyFocusLost

    private void back_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_buttonMouseClicked
        Main.body.removeAll();
        Main.body.add(new Manage_Distributor());
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

    private void txtNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusLost
        if (txtName.getText().length()==0) {
            txtName.setText("ชื่อ");
            txtName.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_txtNameFocusLost

    private void txtNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusGained
        if(txtName.getText().equals("ชื่อ"))
        {
            txtName.setText("");
            txtName.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_txtNameFocusGained

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        String phone_var = txtPhone.getText();
        
        if (checkEmptyFields()) {
            if (phone_var.length() == 10) {
                Integer no = getNextQueueNumber();
                String name = txtName.getText();        
                String sname = txtSname.getText();
                String company = txtCompany.getText();
                String address = txtAddress.getText();
                Integer phone = Integer.valueOf(txtPhone.getText().toString());

                String insertQuery = "INSERT INTO `distributor`(`No`,`Company`, `FName`, `Sname`, `Phone`, `Address`) VALUES (?,?,?,?,?,?)";

                try {

                    PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
                    ps.setInt(1, no);
                    ps.setString(2, company);
                    ps.setString(3, name);
                    ps.setString(4, sname);
                    ps.setInt(5, phone);
                    ps.setString(6, address);

                    if(ps.executeUpdate() > 0)
                    {
                        Main.body.removeAll();
                        Main.body.add(new Manage_Distributor());
                        Main.body.repaint();
                        Main.body.revalidate();
                        JOptionPane.showMessageDialog(null, "New Distributor Added Successfully", "Add Distributor", JOptionPane.INFORMATION_MESSAGE);
                        System.out.println("Added Complete");
                    }
                    else
                    {
                      JOptionPane.showMessageDialog(null, "Distributor Not Added", "Add Distributor", JOptionPane.ERROR_MESSAGE);
                      System.out.println("Some Error Message Here");  
                    }

                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Phone must contains only 10 numbers", "ERROR", JOptionPane.ERROR_MESSAGE);
                txtPhone.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(null, "You must insert all fields", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveMouseClicked

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
    
    private boolean isNumeric(String input) {

        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }   
    
    public boolean checkEmptyFields() {
        String name = txtName.getText().trim();
        String sname = txtSname.getText().trim();
        String company = txtCompany.getText().trim();
        String address = txtAddress.getText().trim();
        String phone = txtPhone.getText().trim();
        
        if(name.equals("") || name.equals("ชื่อ") || sname.equals("") || sname.equals("นามสกุล") || company.equals("") || company.equals("ชื่อบริษัท") || address.equals("")
                || phone.equals("") || phone.equals("เบอร์โทรศัพท์")) {
            return false;
        }
        else {
          return true;    
        }
    }
    
    private int getNextQueueNumber() {
        int nextQueueNumber = 1; 

        try {
            String query = "SELECT MAX(No) AS MaxNo FROM distributor"; 
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
    private javax.swing.JLabel Add_dealer_information;
    private javax.swing.JLabel JAddress;
    private javax.swing.JLabel JCompany;
    private javax.swing.JLabel JName;
    private javax.swing.JLabel JPhone;
    private javax.swing.JLabel JSurname;
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
    private javax.swing.JLabel picture_box;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtCompany;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSname;
    // End of variables declaration//GEN-END:variables
}
