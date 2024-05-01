package component;

import java.awt.Color;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import karnkha.DB;
import karnkha.CartInfo;
import karnkha.Main;
import component.Sellproduct2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;
public class Sellproduct3 extends javax.swing.JPanel {
    
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public Sellproduct3() {
        initComponents();
        
        showDate();
        
        showTime();
        
        con = DB.mycon();
        
        showProductsInTable();
    }
    
    public void showDate(){
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yy");
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

        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        back_button1 = new javax.swing.JLabel();
        Topic = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        Topic2 = new javax.swing.JLabel();
        Date = new javax.swing.JTextField();
        btnNext1 = new javax.swing.JButton();
        Topic3 = new javax.swing.JLabel();
        Topic4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        Time = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Product ID", "Product Name", "Category", "Cost", "Quantity", "Price", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setRowHeight(50);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable2);

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

        Topic2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Topic2.setText("วันที่ :");
        add(Topic2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 50, -1, 30));

        Date.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Date.setForeground(new java.awt.Color(123, 123, 123));
        Date.setText("00:00:00");
        Date.setBorder(null);
        Date.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                DateFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                DateFocusLost(evt);
            }
        });
        add(Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 50, 130, 30));

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

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 1240, 430));

        Time.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Time.setForeground(new java.awt.Color(123, 123, 123));
        Time.setText("00 : 00");
        Time.setBorder(null);
        Time.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TimeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TimeFocusLost(evt);
            }
        });
        Time.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimeActionPerformed(evt);
            }
        });
        add(Time, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 90, 80, 30));

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(255, 255, 255));
        txtTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTotal.setBorder(null);
        txtTotal.setFocusable(false);
        add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 580, 160, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNextActionPerformed

    private void DateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DateFocusGained
        if (Date.getText().equals("  00 : 00"))
        {
            Date.setText("");
            Date.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_DateFocusGained

    private void DateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DateFocusLost
        if (Date.getText().length()==0) {
            Date.setText("  00 : 00");
            Date.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_DateFocusLost

    private void btnNext1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext1ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        
        for (int i = 0; i < model.getRowCount(); i++) {
            String id = (String) model.getValueAt(i, 1);
            String name = (String) model.getValueAt(i, 2);
            String category = (String) model.getValueAt(i, 3);
            double cost = (double) model.getValueAt(i, 4);
            int quantity = (int) model.getValueAt(i, 5);
            double price = (double) model.getValueAt(i, 6);
            java.util.Date date = new java.util.Date();
            double total = (double) model.getValueAt(i, 7);


            updateInventory(id, quantity);
            deleteFromCart((int) jTable.getValueAt(i, 0));
            String insertQuery = "INSERT INTO `reportsales` (`Date`, `Id`, `List`, `Category`, `Cost`, `Quantity`, `Price`, `Total`) VALUES (?,?,?,?,?,?,?,?)";
            try {
                Connection con = DB.getConnection();
                PreparedStatement ps = con.prepareStatement(insertQuery);
                ps.setDate(1, new java.sql.Date(date.getTime()));
                ps.setString(2, id);
                ps.setString(3, name); 
                ps.setString(4, category);
                ps.setDouble(5, cost);
                ps.setInt(6, quantity);
                ps.setDouble(7, price);
                ps.setDouble(8, total);
                ps.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            String deleteQuery = "DELETE FROM `cart` WHERE `No` = ?";
            try {
                PreparedStatement pst = DB.getConnection().prepareStatement(deleteQuery);
                pst.setInt(1, (int) jTable.getValueAt(i, 0));
                pst.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }//GEN-LAST:event_btnNext1ActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        // TODO add your handling code here:
        int index = jTable.getSelectedRow();
        position = index;
    }//GEN-LAST:event_jTableMouseClicked

    private void back_button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_button1MouseClicked
        Main.body.removeAll();
        Main.body.add(new Sellproduct2());
        Main.body.repaint();
        Main.body.revalidate();
    }//GEN-LAST:event_back_button1MouseClicked

    private void TimeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TimeFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_TimeFocusGained

    private void TimeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TimeFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_TimeFocusLost

    private void TimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TimeActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseClicked

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
                product = new CartInfo(rs.getInt("No"), rs.getString("Id"),
                                      rs.getString("Name"), rs.getString("Category"), rs.getDouble("Cost"),
                                      rs.getInt("Quantity"), rs.getDouble("Price"));
                list.add(product);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        productsArray = list;
        return list;
        
    }
    
    public void showProductsInTable(){
        ArrayList<CartInfo> productsList = getProductsList();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
    
        model.setRowCount(0);
        model2.setRowCount(0);
    
        Object[] row = new Object[6];
        Object[] row2 = new Object[8];

        for (int i = 0; i < productsList.size(); i++) {
            row[0] = productsList.get(i).getNo();
            row[1] = productsList.get(i).getId();
            row[2] = productsList.get(i).getName();
            row[3] = productsList.get(i).getCategory();
            row[4] = productsList.get(i).getQuantity();
            row[5] = productsList.get(i).getPrice();
        
            model.addRow(row);
        }
        
        for (int i = 0; i < productsList.size(); i++) {
            row2[0] = productsList.get(i).getNo();
            row2[1] = productsList.get(i).getId();
            row2[2] = productsList.get(i).getName();
            row2[3] = productsList.get(i).getCategory();
            row2[4] = productsList.get(i).getCost();
            row2[5] = productsList.get(i).getQuantity();
            row2[6] = productsList.get(i).getPrice();
            row2[7] = productsList.get(i).getTotal();
            
            model2.addRow(row2);
        }
        calculateTotalPrice();
}
    
    private void calculateTotalPrice() {
        double total = 0;
    
        for (int i = 0; i < jTable.getRowCount(); i++) {
            int quantity = (int) jTable.getValueAt(i, 4);
            double price = (double) jTable.getValueAt(i, 5);
        
            double productTotal = quantity * price;
        
            total += productTotal;
        }
    
        txtTotal.setText(String.format("%.2f", total));
    }
private void updateInventory(String productId, int soldQuantity) {
    try {
        Connection con = DB.getConnection();
        String updateQuery = "UPDATE inventory SET Quantity = Quantity - ? WHERE Id = ?";
        PreparedStatement ps = con.prepareStatement(updateQuery);
        ps.setInt(1, soldQuantity);
        ps.setString(2, productId);
        ps.executeUpdate();
    } catch (SQLException ex) {
        System.out.println(ex);
    }
}

private void deleteFromCart(int cartItemId) {
    try {
        Connection con = DB.getConnection();
        String deleteQuery = "DELETE FROM cart WHERE No = ?";
        PreparedStatement pst = con.prepareStatement(deleteQuery);
        pst.setInt(1, cartItemId);
        pst.executeUpdate();
    } catch (SQLException ex) {
        System.out.println(ex);
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Date;
    private javax.swing.JTextField Time;
    private javax.swing.JLabel Topic;
    private javax.swing.JLabel Topic2;
    private javax.swing.JLabel Topic3;
    private javax.swing.JLabel Topic4;
    private javax.swing.JLabel back_button1;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnNext1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

}
