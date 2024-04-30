package component;

import raven.cell.TableActionCellEditorAdd;
import raven.cell.TableActionCellRenderAdd;
import raven.cell.TableActionEventAdd;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import karnkha.DB;
import karnkha.InventoryInfo;
import karnkha.Main;
import component.Pay_for_repair_services2;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import java.sql.*;
import javax.swing.JOptionPane;

public class Pay_for_repair_services extends javax.swing.JPanel {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public Pay_for_repair_services() {
        initComponents();
        con = DB.mycon();
        showProductsInTable();
        TableActionEventAdd event = new TableActionEventAdd() {
            @Override
            public void onAdd(int row) {
                System.out.println("Edit row : " + row);
                System.out.println("Add row : " + row);
                int index = jTable.getSelectedRow();
                showProductData(index);
                position = index;
                Integer id = Integer.valueOf(jText_Id.getText().toString());
                String name = jText_Name.getText().toString();
                String category = jText_Category.getText().toString();
                Integer quantity = Integer.valueOf(jText_Quantity.getText().toString());
                Double price = Double.valueOf(jText_Price.getText());
                
                int currentQuantity = Integer.valueOf(jText_Quantity.getText().toString());
                currentQuantity--;
                if(currentQuantity < 1){
                    JOptionPane.showMessageDialog(null,"Not Enough Item","Error",JOptionPane.ERROR_MESSAGE);
                }else{
                    String updateQuery = "UPDATE `inventory`SET`Quantity` = ? WHERE `Id`=? ";
        
        try {
            
            PreparedStatement ps = DB.getConnection().prepareStatement(updateQuery);
            ps.setInt(1, currentQuantity);
            ps.setInt(2, id);
            
            if(ps.executeUpdate() > 0)
            {
                jTable.setValueAt(currentQuantity, row, 4);
                JOptionPane.showMessageDialog(null, "New Product Added Successfully", "Add Product", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("New Product Added");
            }
            else
            {
              JOptionPane.showMessageDialog(null, "Product Not Added", "Add Product", JOptionPane.ERROR_MESSAGE);
              System.out.println("Some Error Message Here");  
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        String insertQuery = "INSERT INTO `repaircart`(`Id`, `Name`, `Category`, `Quantity`, `Price`) VALUES (?,?,?,?,?)";
                try {
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, category);
            ps.setInt(4, 1);
            ps.setDouble(5, price);

            if (ps.executeUpdate() > 0) {
                showProductsInTable();
                System.out.println("New Product Added");
            } else {
                JOptionPane.showMessageDialog(null, "Product Not Added", "Add Product", JOptionPane.ERROR_MESSAGE);
                System.out.println("Some Error Message Here");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}

        };
        jTable.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRenderAdd());
        jTable.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditorAdd(event));
   
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back_button1 = new javax.swing.JLabel();
        Topic = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        back_button = new javax.swing.JLabel();
        txtSearch1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jText_Id = new javax.swing.JTextField();
        jText_No = new javax.swing.JTextField();
        jText_Name = new javax.swing.JTextField();
        jText_Category = new javax.swing.JTextField();
        jText_Quantity = new javax.swing.JTextField();
        jText_Price = new javax.swing.JTextField();

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

        Topic.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Topic.setText("ชำระเงินค่าบริการซ่อม และอุปกรณ์การเกษตร");
        add(Topic, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, -1, -1));

        btnNext.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnNext.setText("ดำเนินการต่อ");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 650, 170, 50));

        back_button.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        back_button.setForeground(new java.awt.Color(139, 139, 139));
        back_button.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        back_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/loupe2.png"))); // NOI18N
        add(back_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 60, 30, 30));

        txtSearch1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSearch1.setForeground(new java.awt.Color(123, 123, 123));
        txtSearch1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtSearch1.setText("ค้นหาสินค้า");
        txtSearch1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtSearch1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearch1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearch1FocusLost(evt);
            }
        });
        txtSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearch1ActionPerformed(evt);
            }
        });
        txtSearch1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearch1KeyReleased(evt);
            }
        });
        add(txtSearch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 60, 260, 30));

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
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 1240, 520));

        jText_Id.setEditable(false);
        jText_Id.setBackground(new java.awt.Color(255, 255, 255));
        jText_Id.setForeground(new java.awt.Color(255, 255, 255));
        jText_Id.setText("jTextField1");
        jText_Id.setBorder(null);
        add(jText_Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 650, -1, -1));

        jText_No.setEditable(false);
        jText_No.setBackground(new java.awt.Color(255, 255, 255));
        jText_No.setForeground(new java.awt.Color(255, 255, 255));
        jText_No.setText("jTextField1");
        jText_No.setBorder(null);
        add(jText_No, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 650, -1, -1));

        jText_Name.setEditable(false);
        jText_Name.setBackground(new java.awt.Color(255, 255, 255));
        jText_Name.setForeground(new java.awt.Color(255, 255, 255));
        jText_Name.setText("jTextField1");
        jText_Name.setBorder(null);
        add(jText_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 690, -1, -1));

        jText_Category.setEditable(false);
        jText_Category.setBackground(new java.awt.Color(255, 255, 255));
        jText_Category.setForeground(new java.awt.Color(255, 255, 255));
        jText_Category.setText("jTextField1");
        jText_Category.setBorder(null);
        add(jText_Category, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 730, -1, -1));

        jText_Quantity.setEditable(false);
        jText_Quantity.setBackground(new java.awt.Color(255, 255, 255));
        jText_Quantity.setForeground(new java.awt.Color(255, 255, 255));
        jText_Quantity.setText("jTextField1");
        jText_Quantity.setBorder(null);
        add(jText_Quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 690, -1, 20));

        jText_Price.setEditable(false);
        jText_Price.setBackground(new java.awt.Color(255, 255, 255));
        jText_Price.setForeground(new java.awt.Color(255, 255, 255));
        jText_Price.setText("jTextField1");
        jText_Price.setBorder(null);
        jText_Price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_PriceActionPerformed(evt);
            }
        });
        add(jText_Price, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 730, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        Main.body.removeAll();
        Main.body.add(new Pay_for_repair_services2());
        Main.body.repaint();
        Main.body.revalidate();
    }//GEN-LAST:event_btnNextActionPerformed

    private void txtSearch1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearch1FocusGained
         if(txtSearch1.getText().equals("ค้นหาสินค้า")){
                txtSearch1.setText("");
                txtSearch1.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_txtSearch1FocusGained

    private void txtSearch1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearch1FocusLost
       if (txtSearch1.getText().length()==0) {
            txtSearch1.setText("ค้นหาสินค้า");
            txtSearch1.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_txtSearch1FocusLost

    private void txtSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearch1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch1ActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        // TODO add your handling code here:
        int index = jTable.getSelectedRow();
        position = index;
    }//GEN-LAST:event_jTableMouseClicked

    private void back_button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_button1MouseClicked

    }//GEN-LAST:event_back_button1MouseClicked

    private void txtSearch1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch1KeyReleased
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        jTable.setRowSorter(sorter);
        int columnIndexToFilter = 1;
        int columnIndexToFilter2 = 2;
        int columnIndexToFilter3 = 5;
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + txtSearch1.getText().trim(), columnIndexToFilter));
    }//GEN-LAST:event_txtSearch1KeyReleased

    private void jText_PriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_PriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jText_PriceActionPerformed

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
                product = new InventoryInfo(rs.getInt("No"), rs.getString("Id"),
                                      rs.getString("Date"), rs.getString("Name"), rs.getString("Category"),
                                      rs.getDouble("Cost"), rs.getInt("Quantity"), rs.getDouble("Price"));
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
        ArrayList<InventoryInfo> productsList = getProductsList();
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
    
     public void showProductData(int index)
    {
        jText_Id.setText(productsArray.get(index).getId().toString());
        jText_Name.setText(productsArray.get(index).getName().toString());
        jText_Category.setText(productsArray.get(index).getCategory().toString());
        jText_Quantity.setText(productsArray.get(index).getQuantity().toString());
        jText_Price.setText(productsArray.get(index).getPrice().toString());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Topic;
    private javax.swing.JLabel back_button;
    private javax.swing.JLabel back_button1;
    private javax.swing.JButton btnNext;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jText_Category;
    private javax.swing.JTextField jText_Id;
    private javax.swing.JTextField jText_Name;
    private javax.swing.JTextField jText_No;
    private javax.swing.JTextField jText_Price;
    private javax.swing.JTextField jText_Quantity;
    private javax.swing.JTextField txtSearch1;
    // End of variables declaration//GEN-END:variables

}
