package component;

import java.awt.Color;
import karnkha.Main;
import component.Manage_Warehouse;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import karnkha.DB;
import karnkha.InventoryInfo;
public class EditProduct extends javax.swing.JPanel {

    public EditProduct() {
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
        txtCost_price = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jPrice = new javax.swing.JLabel();
        jAmount = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();

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
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 710, 130, 50));

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

        txtCost_price.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCost_price.setForeground(new java.awt.Color(123, 123, 123));
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
        add(txtCost_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 400, 370, 30));

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
        add(txtAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 540, 370, 30));

        jSeparator9.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 570, 370, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void txtProductidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductidFocusLost
        if (txtProductid.getText ().length() ==0){
            txtProductid.setText ("000000001") ;
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
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPicActionPerformed

    private void txtTypeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTypeFocusLost
        if (txtType.getText ().length() ==0){
            txtType.setText ("ประเภทสินค้า") ;
            txtType.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_txtTypeFocusLost

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
        if (txtProductid.getText().equals("000000001"))
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

    ArrayList<InventoryInfo> productsArray = new ArrayList<>();
    
    int position = 0;
    public ArrayList<InventoryInfo> getProductsList()
    {
        ArrayList<InventoryInfo> list = new ArrayList<>();
        String selectQuery = "SELECT * FROM `inventory`";
        
        Statement st;
        ResultSet rs;
        
        try {
            st = DB.getConnection().createStatement();
            rs = st.executeQuery(selectQuery);
            InventoryInfo product;
            
            while(rs.next())
            {
                product = new InventoryInfo(rs.getInt("No"), rs.getInt("Id"),
                                      rs.getString("Date"), rs.getString("Name"), rs.getString("Category"),
                                      rs.getInt("Quantity"), rs.getDouble("Price"));
                list.add(product);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        productsArray = list;
        return list;
        
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
    private javax.swing.JLabel jType;
    private javax.swing.JLabel picture_box;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtCost_price;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtProductid;
    private javax.swing.JTextField txtType;
    // End of variables declaration//GEN-END:variables
}
