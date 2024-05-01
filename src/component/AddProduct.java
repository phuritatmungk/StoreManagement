package component;

import java.awt.Color;
import karnkha.Main;
import component.Manage_Warehouse;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.*;
import javax.swing.JOptionPane;
import karnkha.DB;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AddProduct extends javax.swing.JPanel {
    
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public AddProduct() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back_button = new javax.swing.JLabel();
        Topic = new javax.swing.JLabel();
        jProductid = new javax.swing.JLabel();
        txtProductid = new javax.swing.JTextField();
        jName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        Add_dealer_information = new javax.swing.JLabel();
        picture_box = new javax.swing.JLabel();
        btnPic = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jType = new javax.swing.JLabel();
        txtType = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jCost_price = new javax.swing.JLabel();
        txtCost = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jPrice = new javax.swing.JLabel();
        jAmount = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        txtAmount = new javax.swing.JTextField();
        jTextField_imgPath = new javax.swing.JTextField();

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
        Topic.setText("จัดการคลังสินค้า");
        add(Topic, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, -1, -1));

        jProductid.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jProductid.setText("รหัสสินค้า");
        add(jProductid, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, -1, -1));

        txtProductid.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtProductid.setForeground(new java.awt.Color(123, 123, 123));
        txtProductid.setText("ABC00000");
        txtProductid.setBorder(null);
        txtProductid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtProductidFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProductidFocusLost(evt);
            }
        });
        add(txtProductid, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 370, 30));

        jName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jName.setText("ชื่อสินค้า");
        add(jName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, -1, -1));

        txtName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtName.setForeground(new java.awt.Color(123, 123, 123));
        txtName.setText("ชื่อสินค้า");
        txtName.setBorder(null);
        txtName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNameFocusLost(evt);
            }
        });
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 370, 30));

        Add_dealer_information.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Add_dealer_information.setText("เพิ่มสินค้า");
        add(Add_dealer_information, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, -1, -1));

        picture_box.setBackground(new java.awt.Color(255, 255, 255));
        picture_box.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        picture_box.setForeground(new java.awt.Color(123, 123, 123));
        picture_box.setText("                       รูปสินค้า");
        picture_box.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(picture_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 190, 330, 270));

        btnPic.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnPic.setText("เลือกรูป");
        btnPic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPicActionPerformed(evt);
            }
        });
        add(btnPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 490, 130, 50));

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnSave.setText("บันทึก");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 620, 130, 50));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 370, 30));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 370, 30));

        jType.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jType.setText("ประเภทสินค้า");
        add(jType, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, -1, -1));

        txtType.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtType.setForeground(new java.awt.Color(123, 123, 123));
        txtType.setText("ประเภทสินค้า");
        txtType.setBorder(null);
        txtType.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTypeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTypeFocusLost(evt);
            }
        });
        add(txtType, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 370, 30));

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, 370, 30));

        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 430, 370, 30));

        jCost_price.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jCost_price.setText("ราคาต้นทุน");
        add(jCost_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, -1, -1));

        txtCost.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCost.setForeground(new java.awt.Color(123, 123, 123));
        txtCost.setText("0");
        txtCost.setBorder(null);
        txtCost.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCostFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCostFocusLost(evt);
            }
        });
        txtCost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCostKeyReleased(evt);
            }
        });
        add(txtCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 400, 370, 30));

        txtPrice.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPrice.setForeground(new java.awt.Color(123, 123, 123));
        txtPrice.setText("0");
        txtPrice.setBorder(null);
        txtPrice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPriceFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPriceFocusLost(evt);
            }
        });
        txtPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPriceKeyReleased(evt);
            }
        });
        add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 470, 370, 30));

        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 500, 370, 30));

        jPrice.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPrice.setText("ราคาสินค้า");
        add(jPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, -1, -1));

        jAmount.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jAmount.setText("จำนวนสินค้า");
        add(jAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 540, -1, -1));

        jSeparator9.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 570, 370, 30));

        txtAmount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtAmount.setForeground(new java.awt.Color(123, 123, 123));
        txtAmount.setText("0");
        txtAmount.setBorder(null);
        txtAmount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtAmountFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAmountFocusLost(evt);
            }
        });
        txtAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAmountKeyReleased(evt);
            }
        });
        add(txtAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 540, 370, 30));

        jTextField_imgPath.setEditable(false);
        jTextField_imgPath.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_imgPath.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_imgPath.setText("jTextField1");
        jTextField_imgPath.setBorder(null);
        add(jTextField_imgPath, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 570, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtProductidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductidFocusLost
        if (txtProductid.getText ().length() ==0){
            txtProductid.setText ("ABC00000") ;
            txtProductid.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_txtProductidFocusLost

    private void txtNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusLost
        if (txtName.getText ().length() ==0){
             txtName.setText ("ชื่อสินค้า") ;
             txtName.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_txtNameFocusLost

    private void btnPicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPicActionPerformed
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
                              
    }//GEN-LAST:event_btnPicActionPerformed

    private void txtTypeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTypeFocusLost
        if (txtType.getText ().length() ==0){
            txtType.setText ("ประเภทสินค้า") ;
            txtType.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_txtTypeFocusLost

    private void txtCostFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCostFocusLost
        if (txtCost.getText ().length() ==0){
            txtCost.setText ("0") ;
            txtCost.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_txtCostFocusLost

    private void txtPriceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPriceFocusLost
        if (txtPrice.getText().length() == 0){
            txtPrice.setText ("0");
            txtPrice.setForeground(new Color(123,123,123));
        }
    }//GEN-LAST:event_txtPriceFocusLost

    private void txtProductidFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductidFocusGained
        if (txtProductid.getText().equals("ABC00000"))
        {
            txtProductid.setText("");
            txtProductid.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_txtProductidFocusGained

    private void txtNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusGained
        if (txtName.getText().equals("ชื่อสินค้า"))
        {
            txtName.setText("");
            txtName.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_txtNameFocusGained

    private void txtTypeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTypeFocusGained
        if (txtType.getText().equals("ประเภทสินค้า"))
        {
            txtType.setText("");
            txtType.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_txtTypeFocusGained

    private void txtCostFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCostFocusGained
        if (txtCost.getText().equals("0"))
        {
            txtCost.setText("");
            txtCost.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_txtCostFocusGained

    private void txtPriceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPriceFocusGained
        if (txtPrice.getText().equals("0"))
        {
            txtPrice.setText("");
            txtPrice.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_txtPriceFocusGained

    private void back_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_buttonMouseClicked
        Main.body.removeAll();
        Main.body.add(new Manage_Warehouse());
        Main.body.repaint();
        Main.body.revalidate();
    }//GEN-LAST:event_back_buttonMouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        
        Double price_var = Double.valueOf(txtPrice.getText());
        Double cost_var = Double.valueOf(txtCost.getText());
        String id_var = txtProductid.getText();
        
        if (checkEmptyFields()) {
            if (id_var.length() == 8) {
                if (price_var >= cost_var) {
                    Integer no = getNextQueueNumber();
                    String id = txtProductid.getText();
                    String name = txtName.getText();
                    String category = txtType.getText();
                    Double cost = Double.valueOf(txtCost.getText().toString());
                    Double price = Double.valueOf(txtPrice.getText().toString());
                    Integer quantity = Integer.valueOf(txtAmount.getText().toString());
                    java.util.Date date = new java.util.Date();
                    String img = jTextField_imgPath.getText();

                    String insertQuery = "INSERT INTO `inventory`(`No`,`Id`, `Date`, `Name`, `Category`, `Cost`, `Quantity`, `Price`,`Image`) VALUES (?,?,?,?,?,?,?,?,?)";

                    try {

                        PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
                        ps.setInt(1, no);
                        ps.setString(2, id);
                        ps.setDate(3, new java.sql.Date(date.getTime()));
                        ps.setString(4, name);
                        ps.setString(5, category);
                        ps.setDouble(6, cost);
                        ps.setInt(7, quantity);
                        ps.setDouble(8, price);
                        ps.setString(9,img);

                        if(ps.executeUpdate() > 0)
                        {
                            Main.body.removeAll();
                            Main.body.add(new Manage_Warehouse());
                            Main.body.repaint();
                            Main.body.revalidate();
                            JOptionPane.showMessageDialog(null, "New Product Added Successfully", "Add Product", JOptionPane.INFORMATION_MESSAGE);
                            System.out.println("Added Complete");
                        }
                        else
                        {
                          JOptionPane.showMessageDialog(null, "Product Not Added", "Add Product", JOptionPane.ERROR_MESSAGE);
                          System.out.println("Some Error Message Here");  
                        }

                    } catch (SQLException ex) {
                        System.out.println(ex);
                    }                     
                } else {
                    JOptionPane.showMessageDialog(null, "Price must equal or higher than cost", "Error", JOptionPane.WARNING_MESSAGE);
                    txtPrice.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Product ID must contains only 8 characters", "Error", JOptionPane.WARNING_MESSAGE);
                    txtProductid.requestFocus();
            }
        } 
        else {
            JOptionPane.showMessageDialog(null, "You must insert all fields", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtAmountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAmountFocusGained
        if (txtAmount.getText().equals("0"))
        {
            txtAmount.setText("");
            txtAmount.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_txtAmountFocusGained

    private void txtAmountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAmountFocusLost
        if (txtAmount.getText ().length() ==0){
            txtAmount.setText ("0") ;
            txtAmount.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_txtAmountFocusLost

    private void txtPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceKeyReleased
        try {
        String text = txtPrice.getText();

            if (!isNumericOrDecimal(text)) {

                evt.consume();
                return;
            }

        Double.valueOf(text);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Price value must contain only numbers", "Error", JOptionPane.WARNING_MESSAGE);
            txtPrice.setText("");
        }
    }//GEN-LAST:event_txtPriceKeyReleased

    private void txtCostKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostKeyReleased
        try {
        String text = txtCost.getText();

            if (!isNumericOrDecimal(text)) {

                evt.consume();
                return;
            }

            Double.valueOf(text);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Cost value must contain only numbers", "Error", JOptionPane.WARNING_MESSAGE);
            txtCost.setText("");
        }
    }//GEN-LAST:event_txtCostKeyReleased

    private void txtAmountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAmountKeyReleased
        
        String text = txtAmount.getText();
        
        if (!isNumeric(text)) {
            evt.consume();
            return;
        }
        else {
            JOptionPane.showMessageDialog(null, "Amount value must contain only numbers", "Error", JOptionPane.WARNING_MESSAGE);
            txtAmount.setText("");
        }
            
    }//GEN-LAST:event_txtAmountKeyReleased

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
        String name = txtName.getText().trim();
        String quantity = txtAmount.getText().trim();
        String price = txtPrice.getText().trim();
        String cost = txtCost.getText().trim();
        String id = txtProductid.getText().trim();
        String category = txtType.getText().trim();
        
        if(name.equals("") || name.equals("ชื่อสินค้า") || quantity.equals("") || quantity.equals("0") || price.equals("") || price.equals("0") || cost.equals("") || cost.equals("0")
                || id.equals("") || id.equals("ABC00000") || category.equals("") || category.equals("ประเภทสินค้า")) {
            return false;
        }
        else {
          return true;    
        }
    }
    
    private int getNextQueueNumber() {
        int nextQueueNumber = 1; 

        try {
            String query = "SELECT MAX(No) AS MaxNo FROM inventory"; 
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
    private javax.swing.JLabel Topic;
    private javax.swing.JLabel back_button;
    private javax.swing.JButton btnPic;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jAmount;
    private javax.swing.JLabel jCost_price;
    private javax.swing.JLabel jName;
    private javax.swing.JLabel jPrice;
    private javax.swing.JLabel jProductid;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField jTextField_imgPath;
    private javax.swing.JLabel jType;
    private javax.swing.JLabel picture_box;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtCost;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtProductid;
    private javax.swing.JTextField txtType;
    // End of variables declaration//GEN-END:variables
}
