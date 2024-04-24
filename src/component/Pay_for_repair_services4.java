package component;

import java.awt.Color;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import karnkha.CartInfo;
import karnkha.DB;
import karnkha.Main;
import component.Pay_for_repair_services3;
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
        txtSearch2 = new javax.swing.JTextField();
        Topic1 = new javax.swing.JLabel();
        Topic2 = new javax.swing.JLabel();
        txtSearch3 = new javax.swing.JTextField();
        txtSearch4 = new javax.swing.JTextField();
        txtSearch5 = new javax.swing.JTextField();
        txtSearch6 = new javax.swing.JTextField();
        txtSearch7 = new javax.swing.JTextField();
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

        txtSearch2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSearch2.setForeground(new java.awt.Color(123, 123, 123));
        txtSearch2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSearch2.setText("นาย แม็ก");
        txtSearch2.setBorder(null);
        txtSearch2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearch2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearch2FocusLost(evt);
            }
        });
        txtSearch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearch2ActionPerformed(evt);
            }
        });
        add(txtSearch2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 650, 110, 30));

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

        txtSearch4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSearch4.setForeground(new java.awt.Color(123, 123, 123));
        txtSearch4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSearch4.setText("0000000000");
        txtSearch4.setBorder(null);
        txtSearch4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearch4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearch4FocusLost(evt);
            }
        });
        txtSearch4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearch4ActionPerformed(evt);
            }
        });
        add(txtSearch4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 600, 150, 30));

        txtSearch5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSearch5.setForeground(new java.awt.Color(123, 123, 123));
        txtSearch5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSearch5.setText("นาย กล้า");
        txtSearch5.setBorder(null);
        txtSearch5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearch5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearch5FocusLost(evt);
            }
        });
        txtSearch5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearch5ActionPerformed(evt);
            }
        });
        add(txtSearch5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 600, 110, 30));

        txtSearch6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSearch6.setForeground(new java.awt.Color(123, 123, 123));
        txtSearch6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSearch6.setText("ปั้มน้ำ");
        txtSearch6.setBorder(null);
        txtSearch6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearch6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearch6FocusLost(evt);
            }
        });
        txtSearch6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearch6ActionPerformed(evt);
            }
        });
        add(txtSearch6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 600, 60, 30));

        txtSearch7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSearch7.setForeground(new java.awt.Color(123, 123, 123));
        txtSearch7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSearch7.setText("0000000000");
        txtSearch7.setBorder(null);
        txtSearch7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearch7FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearch7FocusLost(evt);
            }
        });
        txtSearch7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearch7ActionPerformed(evt);
            }
        });
        add(txtSearch7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 650, 150, 30));

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

    private void txtSearch2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearch2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch2FocusGained

    private void txtSearch2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearch2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch2FocusLost

    private void txtSearch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearch2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch2ActionPerformed

    private void txtSearch3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearch3FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch3FocusGained

    private void txtSearch3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearch3FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch3FocusLost

    private void txtSearch3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearch3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch3ActionPerformed

    private void txtSearch4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearch4FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch4FocusGained

    private void txtSearch4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearch4FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch4FocusLost

    private void txtSearch4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearch4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch4ActionPerformed

    private void txtSearch5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearch5FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch5FocusGained

    private void txtSearch5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearch5FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch5FocusLost

    private void txtSearch5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearch5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch5ActionPerformed

    private void txtSearch6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearch6FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch6FocusGained

    private void txtSearch6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearch6FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch6FocusLost

    private void txtSearch6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearch6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch6ActionPerformed

    private void txtSearch7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearch7FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch7FocusGained

    private void txtSearch7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearch7FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch7FocusLost

    private void txtSearch7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearch7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch7ActionPerformed

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
    private javax.swing.JTextField txtSearch2;
    private javax.swing.JTextField txtSearch3;
    private javax.swing.JTextField txtSearch4;
    private javax.swing.JTextField txtSearch5;
    private javax.swing.JTextField txtSearch6;
    private javax.swing.JTextField txtSearch7;
    // End of variables declaration//GEN-END:variables

}
