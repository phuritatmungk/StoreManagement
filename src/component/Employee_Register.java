package component;

import static component.Edit_employee_info.jTextField_imgPath;
import java.awt.Color;
import karnkha.Main;
import component.Manage_Employee;
import java.awt.Image;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import karnkha.DB;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Employee_Register extends javax.swing.JPanel {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public Employee_Register() {
        initComponents();
        
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
        jSeparator5 = new javax.swing.JSeparator();
        txtSalary = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jTextField_imgPath = new javax.swing.JTextField();
        comboJob = new javax.swing.JComboBox<>();

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
        txtId.setText("1234567890");
        txtId.setBorder(null);
        txtId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIdFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdFocusLost(evt);
            }
        });
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdKeyReleased(evt);
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
        txtPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPhoneKeyReleased(evt);
            }
        });
        add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 410, 220, 30));

        Add_dealer_information.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Add_dealer_information.setText("เพิ่มข้อมูลพนักงาน");
        add(Add_dealer_information, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

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

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 180, 220, 30));

        txtSalary.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSalary.setForeground(new java.awt.Color(123, 123, 123));
        txtSalary.setText("0");
        txtSalary.setBorder(null);
        txtSalary.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSalaryFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSalaryFocusLost(evt);
            }
        });
        txtSalary.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSalaryKeyReleased(evt);
            }
        });
        add(txtSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 230, 220, 30));

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 260, 220, 30));

        jTextField_imgPath.setEditable(false);
        jTextField_imgPath.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_imgPath.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_imgPath.setBorder(null);
        add(jTextField_imgPath, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 460, -1, -1));

        comboJob.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboJob.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "เลือกตำแหน่ง", "พนักงานขาย", "พนักงานซ่อม" }));
        add(comboJob, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 150, 220, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btnImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImgActionPerformed
        JFileChooser filechooser = new JFileChooser();
        filechooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*images", ".png","jpg",".jpeg");
        filechooser.addChoosableFileFilter(filter);
        
        if(filechooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
        {
          File selectedImage = filechooser.getSelectedFile();
          String image_path = selectedImage.getAbsolutePath();
          displayImage(image_path, picture_box,'a');
          jTextField_imgPath.setText(image_path);
          System.out.println(image_path);
        }
        else
        {
            System.out.println("no file selected");
        }
                
    }//GEN-LAST:event_btnImgActionPerformed

    private void txtIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdFocusGained
        if(txtId.getText().equals("1234567890"))
       {
           txtId.setText("");
           txtId.setForeground(new Color(0, 0, 0));
       }
    }//GEN-LAST:event_txtIdFocusGained

    private void txtIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdFocusLost
        if (txtId.getText().length()==0) {
            txtId.setText("1234567890");
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

    private void txtSalaryFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSalaryFocusGained
        if(txtSalary.getText().equals("0"))
       {
           txtSalary.setText("");
           txtSalary.setForeground(new Color(0, 0, 0));
       }
    }//GEN-LAST:event_txtSalaryFocusGained

    private void txtSalaryFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSalaryFocusLost
        if (txtSalary.getText().length()==0) {
            txtSalary.setText("0");
            txtSalary.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_txtSalaryFocusLost

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        
        String id_var = txtId.getText();
        String phone_var = txtPhone.getText();
        
        if (checkEmptyFields()) {
            if (phone_var.length() == 10) {
                if (id_var.length () == 10) {
        
                    Integer no = getNextQueueNumber();
                    String id = txtId.getText();
                    String fname = txtName.getText();
                    String sname = txtSname.getText();
                    String address = txtAddress.getText();
                    String job = comboJob.getSelectedItem().toString();
                    Double wage = Double.valueOf(txtSalary.getText().toString());
                    String phone = txtPhone.getText();
                    String img = jTextField_imgPath.getText();
                    
                    if (!isEmployeeIDExists(id_var)) {
                    String insertQuery = "INSERT INTO `employee`(`No`,`Fname`, `Sname`, `Id`, `Phone`, `Job`, `Wage`, `Address`,`Image`) VALUES (?,?,?,?,?,?,?,?,?)";

                    try {

                        PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
                        ps.setInt(1, no);
                        ps.setString(2, fname);
                        ps.setString(3, sname);
                        ps.setString(4, id);
                        ps.setString(5, phone);
                        ps.setString(6, job);
                        ps.setDouble(7, wage);
                        ps.setString(8, address);
                        ps.setString(9, img);

                        if(ps.executeUpdate() > 0)
                        {
                            Main.body.removeAll();
                            Main.body.add(new Manage_Employee());
                            Main.body.repaint();
                            Main.body.revalidate();
                            JOptionPane.showMessageDialog(null, "New Employee Added Successfully", "Add Employee", JOptionPane.INFORMATION_MESSAGE);
                            System.out.println("Added Complete");
                        }
                        else
                        {
                          JOptionPane.showMessageDialog(null, "Employee Not Added", "Add Employee", JOptionPane.ERROR_MESSAGE);
                          System.out.println("Some Error Message Here");  
                        }

                    } catch (SQLException ex) {
                        System.out.println(ex);
                    }     
                } else {
                    JOptionPane.showMessageDialog(null, "Employee Id already exists Please change the Employee Id", "Error", JOptionPane.WARNING_MESSAGE);
                }
                }else {
                    JOptionPane.showMessageDialog(null, "Employee ID must contains only 10 numbers", "ERROR", JOptionPane.ERROR_MESSAGE);
                    txtPhone.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Phone must contains only 10 numbers", "ERROR", JOptionPane.ERROR_MESSAGE);
                txtPhone.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(null, "You must insert all fields", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
   }
      
    private boolean isEmployeeIDExists(String id) {
    boolean isExists = false;
    try {
        String query = "SELECT COUNT(*) FROM employee WHERE Id = ?";
        PreparedStatement ps = DB.getConnection().prepareStatement(query);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int count = rs.getInt(1);
            if (count > 0) {
                isExists = true;
            }
        }
    } catch (SQLException ex) {
        System.out.println("Error checking product ID existence: " + ex.getMessage());
    }
    return isExists;
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyReleased
        String text = txtId.getText();
        
        if (!isNumeric(text)) {
            evt.consume();
            return;
        }
        else {
            JOptionPane.showMessageDialog(null, "ID value must contain only numbers", "Error", JOptionPane.WARNING_MESSAGE);
            txtId.setText("");
        }
    }//GEN-LAST:event_txtIdKeyReleased

    private void txtSalaryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSalaryKeyReleased
        try {
        String text = txtSalary.getText();

            if (!isNumericOrDecimal(text)) {

                evt.consume();
                return;
            }

        Double.valueOf(text);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Wage value must contain only numbers", "Error", JOptionPane.WARNING_MESSAGE);
            txtSalary.setText("");
        }
    }//GEN-LAST:event_txtSalaryKeyReleased

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
    
    private boolean isNumericOrDecimal(String input) {

        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c) && c != '.') {
                return true;
            }
        }
        return false;
    }   
    
    private boolean isNumeric(String input) {

        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }   
    
    public boolean checkEmptyFields() {
        
        String id = txtId.getText().trim();
        String name = txtName.getText().trim();
        String sname = txtSname.getText().trim();
        String wage = txtSalary.getText().trim();
        String address = txtAddress.getText().trim();
        String phone = txtPhone.getText().trim();
        String img = jTextField_imgPath.getText().trim();
        String job = comboJob.getSelectedItem().toString();
        
        if(id.equals("") || id.equals("1234567890") || name.equals("") || name.equals("ชื่อ") || sname.equals("") || sname.equals("นามสกุล") || address.equals("")
                || wage.equals("") || wage.equals("0") || phone.equals("") || phone.equals("เบอร์โทรศัพท์") || img.equals("") || job.equals("เลือกตำแหน่ง")) {
            return false;
        }
        else {
          return true;    
        }
    }
            
    private int getNextQueueNumber() {
        int nextQueueNumber = 1; 

        try {
            String query = "SELECT MAX(No) AS MaxNo FROM employee"; 
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
    public void displayImage(String imgPath, JLabel label, char rsc)
    {
        ImageIcon imgIco;
        if(rsc == 'r')
        {
            imgIco = new ImageIcon(getClass().getResource(imgPath));
        }
        else
        {
         imgIco = new ImageIcon(imgPath);
        }
        
        Image img = imgIco.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(img));
        
    }

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
    public static javax.swing.JComboBox<String> comboJob;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTextField jTextField_imgPath;
    private javax.swing.JLabel picture_box;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSalary;
    private javax.swing.JTextField txtSname;
    // End of variables declaration//GEN-END:variables
}
