package component;

import java.awt.Color;
import karnkha.Main;
import component.Manage_Warehouse;
import java.awt.Image;
import java.io.File;
import karnkha.DB;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class EditProduct extends javax.swing.JPanel {
    
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public EditProduct() {
        initComponents();
        con = DB.mycon();
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
        jSeparator7 = new javax.swing.JSeparator();
        jCost_price = new javax.swing.JLabel();
        txtCost_price = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jPrice = new javax.swing.JLabel();
        jAmount = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        txtNo = new javax.swing.JTextField();
        jTextField_imgPath = new javax.swing.JTextField();
        Com_Type = new javax.swing.JComboBox<>();

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
        txtProductid.setText("000000001");
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
        Add_dealer_information.setText("แก้ไขสินค้า");
        add(Add_dealer_information, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, -1, -1));

        picture_box.setBackground(new java.awt.Color(255, 255, 255));
        picture_box.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        picture_box.setForeground(new java.awt.Color(123, 123, 123));
        picture_box.setText("                     รูปนามสินค้า");
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
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 620, 130, 50));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 370, 30));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 370, 30));

        jType.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jType.setText("ประเภทสินค้า");
        add(jType, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, -1, -1));

        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 430, 370, 30));

        jCost_price.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jCost_price.setText("ราคาต้นทุน");
        add(jCost_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, -1, -1));

        txtCost_price.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCost_price.setText("0");
        txtCost_price.setBorder(null);
        txtCost_price.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCost_priceFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCost_priceFocusLost(evt);
            }
        });
        txtCost_price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCost_priceKeyReleased(evt);
            }
        });
        add(txtCost_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 400, 370, 30));

        txtPrice.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
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

        txtAmount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
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

        jSeparator9.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 570, 370, 30));

        txtNo.setEditable(false);
        txtNo.setBackground(new java.awt.Color(255, 255, 255));
        txtNo.setForeground(new java.awt.Color(255, 255, 255));
        txtNo.setText("1");
        txtNo.setBorder(null);
        txtNo.setFocusable(false);
        add(txtNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 850, -1, 40));

        jTextField_imgPath.setEditable(false);
        jTextField_imgPath.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_imgPath.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_imgPath.setBorder(null);
        add(jTextField_imgPath, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 570, -1, -1));

        Com_Type.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Com_Type.setMaximumRowCount(8);
        Com_Type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "เลือกประเภทสินค้า", "เครื่องยนต์และอุปกรณ์การเกษตร", "อะไหล่เครื่องดีเซล", "อะไหล่เครื่องเบนซิน", "อะไหล่เครื่องตัดหญ้า", "อะไหล่เครื่องตัดไม้", "อะไหล่เป้เครื่องพ่นยา", "อะไหล่เป้พ่นยาไฟฟ้า", "อะไหล่ปั้มพ่นยา", "อะไหล่เครื่องเจาะดิน", "อะไหล่ปั้มน้ำ", "อะไหล่ปั้มน้ำไฟฟ้า", "อุปกรณ์อื่นๆ" }));
        Com_Type.setLightWeightPopupEnabled(false);
        add(Com_Type, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 370, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtProductidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductidFocusLost
        if (txtProductid.getText ().length() ==0){
            txtProductid.setText ("XXX00000") ;
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

    private void txtCost_priceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCost_priceFocusLost
        if (txtCost_price.getText ().length() ==0){
            txtCost_price.setText ("0") ;
            txtCost_price.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_txtCost_priceFocusLost

    private void txtPriceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPriceFocusLost
        if (txtPrice.getText ().length() ==0){
            txtPrice.setText ("0") ;
            txtPrice.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_txtPriceFocusLost

    private void txtAmountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAmountFocusLost
        if (txtAmount.getText ().length() ==0){
            txtAmount.setText ("0") ;
            txtAmount.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_txtAmountFocusLost

    private void txtProductidFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductidFocusGained
        if (txtProductid.getText().equals("XXX00000"))
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

    private void txtCost_priceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCost_priceFocusGained
        if (txtCost_price.getText().equals("0"))
        {
            txtCost_price.setText("");
            txtCost_price.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_txtCost_priceFocusGained

    private void txtPriceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPriceFocusGained
        if (txtPrice.getText().equals("0"))
        {
            txtPrice.setText("");
            txtPrice.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_txtPriceFocusGained

    private void txtAmountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAmountFocusGained
        if (txtAmount.getText().equals("0"))
        {
            txtAmount.setText("");
            txtAmount.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_txtAmountFocusGained

    private void back_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_buttonMouseClicked
        Main.body.removeAll();
        Main.body.add(new Manage_Warehouse());
        Main.body.repaint();
        Main.body.revalidate();
    }//GEN-LAST:event_back_buttonMouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        
        Double price_var = Double.valueOf(txtPrice.getText());
        Double cost_var = Double.valueOf(txtCost_price.getText());
        String id_var = txtProductid.getText();
        
        if(checkEmptyFields()) {
            if (id_var.length() == 8) {
                if (price_var >= cost_var) {
                    Integer no = Integer.valueOf(txtNo.getText().toString()); 
                    String id = txtProductid.getText();
                    java.util.Date date = new java.util.Date();
                    String name = txtName.getText();
                    String category = Com_Type.getSelectedItem().toString();
                    Double cost = Double.valueOf(txtCost_price.getText().toString());
                    Integer quantity = Integer.valueOf(txtAmount.getText().toString());
                    Double price = Double.valueOf(txtPrice.getText().toString());
                    String img = jTextField_imgPath.getText().toString();

                    if (!isProductIDExists(id_var,no)) {   
                    String updateQuery = "UPDATE inventory SET Id=?, Date=?, Name=?, Category=?, Cost=? , Quantity=? , Price=?,Image=? WHERE No=?";
                    try {
                        PreparedStatement ps = DB.getConnection().prepareStatement(updateQuery);

                        ps.setString(1, id);
                        ps.setDate(2, new java.sql.Date(date.getTime()));
                        ps.setString(3, name);
                        ps.setString(4, category);
                        ps.setDouble(5, cost);
                        ps.setInt(6, quantity); 
                        ps.setDouble(7, price);
                        ps.setString(8, img);
                        ps.setInt(9, no);


                        if(ps.executeUpdate() > 0)
                        {
                            Main.body.removeAll();
                            Main.body.add(new Manage_Warehouse());
                            Main.body.repaint();
                            Main.body.revalidate();
                            JOptionPane.showMessageDialog(null, "Edit Product Successfully", "Edit Product", JOptionPane.INFORMATION_MESSAGE);
                            System.out.println("Updated");
                        }
                        else
                        {
                            System.out.println("Failed");
                        }

                    } catch (SQLException ex) {
                        System.out.println(ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Product Id already exists Please change the product Id", "Error", JOptionPane.WARNING_MESSAGE);
                }
                }else {
                    JOptionPane.showMessageDialog(null, "Price must equal or higher than cost", "Error", JOptionPane.WARNING_MESSAGE);
                    txtPrice.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Product ID must contains only 8 characters", "Error", JOptionPane.WARNING_MESSAGE);
                txtProductid.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(null, "You must insert all fields", "ERROR", JOptionPane.WARNING_MESSAGE);
            System.out.println("Updated");
        }
    }
    private boolean isProductIDExists(String id, int no) {
    boolean isExists = false;
    try {
        String query = "SELECT COUNT(*) FROM inventory WHERE Id = ? AND No != ?";
        PreparedStatement ps = DB.getConnection().prepareStatement(query);
        ps.setString(1, id);
        ps.setInt(2, no);
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

    private void txtCost_priceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCost_priceKeyReleased
        try {
        String text = txtCost_price.getText();

            if (!isNumericOrDecimal(text)) {

                evt.consume();
                return;
            }

            Double.valueOf(text);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Cost value must contain only numbers", "Error", JOptionPane.WARNING_MESSAGE);
            txtCost_price.setText("");
        }
    }//GEN-LAST:event_txtCost_priceKeyReleased

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
        String cost = txtCost_price.getText().trim();
        String id = txtProductid.getText().trim();
        String category = Com_Type.getSelectedItem().toString().trim();
        String img = jTextField_imgPath.getText().trim();
        
        if(name.equals("") || name.equals("ชื่อสินค้า") || quantity.equals("") || quantity.equals("0") || price.equals("") || price.equals("0") || cost.equals("") || cost.equals("0")
                || id.equals("") || id.equals("XXX00000") || category.equals("") || category.equals("เลือกประเภทสินค้า") || img.equals("")) {
            return false;
        }
        else {
          return true;    
        }
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
        
        Image img = imgIco.getImage().getScaledInstance(330, 270, Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(img));

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Add_dealer_information;
    public static javax.swing.JComboBox<String> Com_Type;
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
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    public static javax.swing.JTextField jTextField_imgPath;
    private javax.swing.JLabel jType;
    public static javax.swing.JLabel picture_box;
    public static javax.swing.JTextField txtAmount;
    public static javax.swing.JTextField txtCost_price;
    public static javax.swing.JTextField txtName;
    public static javax.swing.JTextField txtNo;
    public static javax.swing.JTextField txtPrice;
    public static javax.swing.JTextField txtProductid;
    // End of variables declaration//GEN-END:variables
}
