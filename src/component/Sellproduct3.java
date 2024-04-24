package component;

import java.awt.Color;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import karnkha.DB;
import karnkha.CartInfo;

public class Sellproduct3 extends javax.swing.JPanel {
    
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public Sellproduct3() {
        initComponents();
        con = DB.mycon();
        showProductsInTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back_button1 = new javax.swing.JLabel();
        Topic = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        Topic1 = new javax.swing.JLabel();
        Topic2 = new javax.swing.JLabel();
        txtTime = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCustomer1 = new javax.swing.JTextField();
        btnNext1 = new javax.swing.JButton();
        Topic3 = new javax.swing.JLabel();
        Topic4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back_button1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        back_button1.setForeground(new java.awt.Color(139, 139, 139));
        back_button1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        back_button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back-button.png"))); // NOI18N
        add(back_button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 60));

        Topic.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Topic.setText("เวลา :");
        add(Topic, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 90, -1, 30));

        btnNext.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/printer1.png"))); // NOI18N
        btnNext.setText("Print the bill");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 570, 190, 50));

        Topic1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Topic1.setText("6,000 บาท");
        add(Topic1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 580, -1, -1));

        Topic2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Topic2.setText("วันที่ :");
        add(Topic2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 50, -1, 30));

        txtTime.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTime.setForeground(new java.awt.Color(123, 123, 123));
        txtTime.setText("  00 : 00");
        txtTime.setBorder(null);
        txtTime.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimeFocusLost(evt);
            }
        });
        txtTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimeActionPerformed(evt);
            }
        });
        add(txtTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 90, 80, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/calendar1_1.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 50, -1, 30));

        txtCustomer1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCustomer1.setForeground(new java.awt.Color(123, 123, 123));
        txtCustomer1.setText(" ##/##/##");
        txtCustomer1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCustomer1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCustomer1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCustomer1FocusLost(evt);
            }
        });
        add(txtCustomer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 50, 190, 30));

        btnNext1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnNext1.setText("ดำเนินการต่อ");
        btnNext1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNext1ActionPerformed(evt);
            }
        });
        add(btnNext1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 650, 170, 50));

        Topic3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Topic3.setText("ขายสินค้า");
        add(Topic3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, -1, -1));

        Topic4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Topic4.setText("Total :");
        add(Topic4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 580, -1, -1));

        jTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Product ID", "Product Name", "Category", "Quantity", "Price", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
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

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 1240, 430));
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNextActionPerformed

    private void txtTimeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimeFocusGained
        if (txtTime.getText().equals("  00 : 00"))
        {
            txtTime.setText("");
            txtTime.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_txtTimeFocusGained

    private void txtTimeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimeFocusLost
        if (txtTime.getText().length()==0) {
            txtTime.setText("  00 : 00");
            txtTime.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_txtTimeFocusLost

    private void txtTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimeActionPerformed

    private void txtCustomer1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustomer1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomer1FocusGained

    private void txtCustomer1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustomer1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomer1FocusLost

    private void btnNext1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNext1ActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        // TODO add your handling code here:
        int index = jTable.getSelectedRow();
        position = index;
    }//GEN-LAST:event_jTableMouseClicked

    ArrayList<CartInfo> productsArray = new ArrayList<>();
    
    int position = 0;
    public ArrayList<CartInfo> getProductsList()
    {
        ArrayList<CartInfo> list = new ArrayList<>();
        String selectQuery = "SELECT * FROM `cart`";
        
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
    private javax.swing.JLabel Topic4;
    private javax.swing.JLabel back_button1;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnNext1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField txtCustomer1;
    private javax.swing.JTextField txtTime;
    // End of variables declaration//GEN-END:variables

}
