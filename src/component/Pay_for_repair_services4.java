package component;

import java.awt.Color;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import karnkha.CartInfo;
import karnkha.DB;
import karnkha.Main;
import component.Pay_for_repair_services3;
import karnkha.RepairRequest;
public class Pay_for_repair_services4 extends javax.swing.JPanel {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public Pay_for_repair_services4() {
        initComponents();
        con = DB.mycon();
        showProductsInTable();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back_button1 = new javax.swing.JLabel();
        Topic = new javax.swing.JLabel();
        btnPrint = new javax.swing.JButton();
        btnpay = new javax.swing.JButton();
        txtRepairman = new javax.swing.JTextField();
        Topic1 = new javax.swing.JLabel();
        Topic2 = new javax.swing.JLabel();
        txtSearch3 = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtProduct = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        Topic3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back_button1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        back_button1.setForeground(new java.awt.Color(139, 139, 139));
        back_button1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        back_button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back-button.png"))); // NOI18N
        back_button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back_button1MouseClicked(evt);
            }
        });
        add(back_button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 60));

        Topic.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Topic.setText("ผู้รับซ่อม");
        add(Topic, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 650, -1, 30));

        btnPrint.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/printer1.png"))); // NOI18N
        btnPrint.setText("Print the bill");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 650, 200, 50));

        btnpay.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnpay.setText("ชำระอุปกรณ์ซ่อม");
        btnpay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpayActionPerformed(evt);
            }
        });
        add(btnpay, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 650, 200, 50));

        txtRepairman.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtRepairman.setForeground(new java.awt.Color(123, 123, 123));
        txtRepairman.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRepairman.setText("นาย แม็ก");
        txtRepairman.setBorder(null);
        txtRepairman.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtRepairmanFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRepairmanFocusLost(evt);
            }
        });
        txtRepairman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRepairmanActionPerformed(evt);
            }
        });
        add(txtRepairman, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 650, 110, 30));

        Topic1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Topic1.setText("ชำระเงินค่าบริการซ่อม และอุปกรณ์การเกษตร");
        add(Topic1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, -1, -1));

        Topic2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Topic2.setText("Total :");
        add(Topic2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 50, -1, 30));

        txtSearch3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSearch3.setForeground(new java.awt.Color(123, 123, 123));
        txtSearch3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSearch3.setText("240 บาท");
        txtSearch3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtSearch3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearch3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearch3FocusLost(evt);
            }
        });
        txtSearch3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearch3ActionPerformed(evt);
            }
        });
        add(txtSearch3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 50, 200, 30));

        txtPhone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPhone.setForeground(new java.awt.Color(123, 123, 123));
        txtPhone.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPhone.setText("0000000000");
        txtPhone.setBorder(null);
        txtPhone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPhoneFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPhoneFocusLost(evt);
            }
        });
        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });
        add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 600, 150, 30));

        txtName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtName.setForeground(new java.awt.Color(123, 123, 123));
        txtName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtName.setText("นาย กล้า");
        txtName.setBorder(null);
        txtName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNameFocusLost(evt);
            }
        });
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 600, 110, 30));

        txtProduct.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtProduct.setForeground(new java.awt.Color(123, 123, 123));
        txtProduct.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtProduct.setText("ปั้มน้ำ");
        txtProduct.setBorder(null);
        txtProduct.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtProductFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProductFocusLost(evt);
            }
        });
        txtProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductActionPerformed(evt);
            }
        });
        add(txtProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 600, 60, 30));

        txtId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtId.setForeground(new java.awt.Color(123, 123, 123));
        txtId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtId.setText("0000000000");
        txtId.setBorder(null);
        txtId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIdFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdFocusLost(evt);
            }
        });
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 650, 150, 30));

        Topic3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Topic3.setText("ผู้ส่งซ่อม");
        add(Topic3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 600, -1, 30));

        jTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No", "Product ID", "Product Name", "Category", "Quantity", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.setRowHeight(50);
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 1240, 480));
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnpayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnpayActionPerformed

    private void txtRepairmanFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRepairmanFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRepairmanFocusGained

    private void txtRepairmanFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRepairmanFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRepairmanFocusLost

    private void txtRepairmanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRepairmanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRepairmanActionPerformed

    private void txtSearch3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearch3FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch3FocusGained

    private void txtSearch3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearch3FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch3FocusLost

    private void txtSearch3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearch3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch3ActionPerformed

    private void txtPhoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPhoneFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneFocusGained

    private void txtPhoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPhoneFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneFocusLost

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneActionPerformed

    private void txtNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameFocusGained

    private void txtNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameFocusLost

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtProductFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductFocusGained

    private void txtProductFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductFocusLost

    private void txtProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductActionPerformed

    private void txtIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdFocusGained

    private void txtIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdFocusLost

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        // TODO add your handling code here:
        int index = jTable.getSelectedRow();
        position = index;
    }//GEN-LAST:event_jTableMouseClicked

    private void back_button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_button1MouseClicked
        Main.body.removeAll();
        Main.body.add(new Pay_for_repair_services3());
        Main.body.repaint();
        Main.body.revalidate();
    }//GEN-LAST:event_back_button1MouseClicked

    ArrayList<CartInfo> productsArray = new ArrayList<>();
    
    int position = 0;
    public ArrayList<CartInfo> getProductsList()
    {
        ArrayList<CartInfo> list = new ArrayList<>();
        String selectQuery = "SELECT * FROM `repaircart`";
        
        Statement st;
        ResultSet rs;
        
        try {
            st = DB.getConnection().createStatement();
            rs = st.executeQuery(selectQuery);
            CartInfo product;
            
            while(rs.next())
            {
                product = new CartInfo(rs.getInt("No"), rs.getInt("Id"),
                                      rs.getString("Name"), rs.getString("Category"),
                                      rs.getInt("Quantity"), rs.getDouble("Price"));
                list.add(product);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        productsArray = list;
        return list;
        
    }
    
    
    public void showProductsInTable()
    {
        ArrayList<CartInfo> productsList = getProductsList();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        
        model.setRowCount(0);
        
        Object[] row = new Object[6];
        
        for(int i = 0; i < productsList.size(); i++)
        {
            row[0] = productsList.get(i).getNo();
            row[1] = productsList.get(i).getId();
            row[2] = productsList.get(i).getName();
            row[3] = productsList.get(i).getCategory();
            row[4] = productsList.get(i).getQuantity();
            row[5] = productsList.get(i).getPrice();
            
            model.addRow(row);
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Topic;
    private javax.swing.JLabel Topic1;
    private javax.swing.JLabel Topic2;
    private javax.swing.JLabel Topic3;
    private javax.swing.JLabel back_button1;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnpay;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    public static javax.swing.JTextField txtId;
    public static javax.swing.JTextField txtName;
    public static javax.swing.JTextField txtPhone;
    public static javax.swing.JTextField txtProduct;
    public static javax.swing.JTextField txtRepairman;
    private javax.swing.JTextField txtSearch3;
    // End of variables declaration//GEN-END:variables

}
