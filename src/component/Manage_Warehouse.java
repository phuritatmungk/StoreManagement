package component;


import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import karnkha.DB;
import karnkha.InventoryInfo;
import karnkha.Main;
import raven.cell.TableActionCellEditorEdit;
import raven.cell.TableActionCellRenderEdit;
import raven.cell.TableActionEventEdit;
import component.AddProduct;
import component.EditProduct;
import static component.EditProduct.txtNo;
import java.awt.Color;
import java.awt.Component;
import javax.swing.table.TableRowSorter;

public class Manage_Warehouse extends javax.swing.JPanel {
    
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public Manage_Warehouse() {
        initComponents();
        con = DB.mycon();
        loadAllProducts();
        
            
        TableActionEventEdit event = new TableActionEventEdit() {
            @Override
            public void onEdit(int row) {
                System.out.println("Edit row :" + row);
                Main.body.removeAll();
                Main.body.add(new EditProduct());
                Main.body.repaint();
                Main.body.revalidate();
                int index = jTable.getSelectedRow();
                showProductData(index);
                position = index;
            }
        };
        jTable.getColumnModel().getColumn(7).setCellRenderer(new TableActionCellRenderEdit());
        jTable.getColumnModel().getColumn(7).setCellEditor(new TableActionCellEditorEdit(event));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        CategoryBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        Bgo = new javax.swing.JButton();
        Bmax = new javax.swing.JTextField();
        Bmin = new javax.swing.JTextField();
        back_button1 = new javax.swing.JLabel();
        Topic = new javax.swing.JLabel();
        back_button = new javax.swing.JLabel();
        search__box = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        delete_bt = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        jFrame1.setBounds(new java.awt.Rectangle(50, 50, 0, 0));
        jFrame1.setPreferredSize(new java.awt.Dimension(500, 500));
        jFrame1.setResizable(false);
        jFrame1.setSize(new java.awt.Dimension(500, 500));
        jFrame1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 370, 10));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("จำนวนคงเหลือ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        CategoryBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CategoryBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoryBoxActionPerformed(evt);
            }
        });
        jPanel1.add(CategoryBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 120, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("สืบค้นข้อมูลสินค้าในคลัง");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("เลือกประเภท");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("ช่วงราคาของสินค้า");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("ราคาของสินค้า");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setText("จำนวน : มาก > น้อย");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 150, 30));

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton7.setText("จำนวน : น้อย < มาก");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 150, 30));

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton8.setText("ราคา : น้อย < มาก");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 150, 30));

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton9.setText("ราคา : มาก > น้อย");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 150, 30));

        Bgo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Bgo.setText("Go");
        Bgo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BgoActionPerformed(evt);
            }
        });
        jPanel1.add(Bgo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 50, 30));

        Bmax.setText("$Max");
        Bmax.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BmaxFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                BmaxFocusLost(evt);
            }
        });
        Bmax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BmaxActionPerformed(evt);
            }
        });
        Bmax.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BmaxKeyReleased(evt);
            }
        });
        jPanel1.add(Bmax, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 80, 30));

        Bmin.setText("$Min");
        Bmin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BminFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                BminFocusLost(evt);
            }
        });
        Bmin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BminKeyReleased(evt);
            }
        });
        jPanel1.add(Bmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 80, 30));

        jFrame1.getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 510));

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back_button1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        back_button1.setForeground(new java.awt.Color(139, 139, 139));
        back_button1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        back_button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back-button.png"))); // NOI18N
        add(back_button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 60));

        Topic.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Topic.setText("จัดการคลังสินค้า");
        add(Topic, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, -1, -1));

        back_button.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        back_button.setForeground(new java.awt.Color(139, 139, 139));
        back_button.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        back_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/loupe2_1.png"))); // NOI18N
        add(back_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 50, 30, 30));

        search__box.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        search__box.setForeground(new java.awt.Color(123, 123, 123));
        search__box.setText("ค้นหาสินค้า");
        search__box.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        search__box.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                search__boxFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                search__boxFocusLost(evt);
            }
        });
        search__box.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search__boxKeyReleased(evt);
            }
        });
        add(search__box, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 50, 300, 30));

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnAdd.setText("เพิ่ม");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 640, 130, 50));

        delete_bt.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        delete_bt.setText("ลบ");
        delete_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btActionPerformed(evt);
            }
        });
        add(delete_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 640, 130, 50));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/settings3.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setDefaultCapable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 110, 50, 40));

        jTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Product ID", "Date", "Product Name", "Category", "Quantity", "Price", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.setRowHeight(50);
        jTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 1240, 520));
    }// </editor-fold>//GEN-END:initComponents

    
    private void delete_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btActionPerformed
    int selectedRow = jTable.getSelectedRow(); 
    if(selectedRow != -1) { 
        int id = (int) jTable.getValueAt(selectedRow, 0); 
        if(id > 0) { 
            String deleteQuery = "DELETE FROM inventory WHERE No=?";
            try {
                PreparedStatement ps = DB.getConnection().prepareStatement(deleteQuery);
                ps.setInt(1, id);
                int deletedRows = ps.executeUpdate(); 
                if(deletedRows > 0) { 
                    DefaultTableModel model = (DefaultTableModel) jTable.getModel(); 
                    model.removeRow(selectedRow); 
                    JOptionPane.showMessageDialog(null, "Product Deleted Successfully", "Remove Product", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to delete product", "Remove Product", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                System.out.println("Failed to remove product: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Product Not Deleted, Make Sure The ID is Valid", "Remove Product", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(null, "Please select a row to delete", "Remove Product", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_delete_btActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Main.body.removeAll();
        Main.body.add(new AddProduct());
        Main.body.repaint();
        Main.body.revalidate();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked

    }//GEN-LAST:event_btnAddMouseClicked

    private void search__boxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_search__boxFocusGained
        if(search__box.getText().equals("ค้นหาสินค้า")){
                search__box.setText("");
                search__box.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_search__boxFocusGained

    private void search__boxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_search__boxFocusLost
        if (search__box.getText().length()==0) {
            search__box.setText("ค้นหาสินค้า");
            search__box.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_search__boxFocusLost

    private void search__boxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search__boxKeyReleased
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        jTable.setRowSorter(sorter);
        int columnIndexToFilter = 1;
        int columnIndexToFilter2 = 3;

        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + search__box.getText().trim(), columnIndexToFilter));
    }//GEN-LAST:event_search__boxKeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        sortProductsByQuantityDescending();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        sortProductsByPriceDescending();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jFrame1.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        sortProductsByPriceAscending();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        sortProductsByQuantityAscending();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void BmaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BmaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BmaxActionPerformed

    private void BminFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BminFocusGained
        if (Bmin.getText().equals("$Min"))
        {
            Bmin.setText("");
            Bmin.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_BminFocusGained

    private void BminFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BminFocusLost
         if (Bmin.getText ().length() ==0){
            Bmin.setText ("$Min") ;
            Bmin.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_BminFocusLost

    private void BmaxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BmaxFocusGained
        if (Bmax.getText().equals("$Max"))
        {
            Bmax.setText("");
            Bmax.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_BmaxFocusGained

    private void BmaxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BmaxFocusLost
         if (Bmax.getText ().length() ==0){
            Bmax.setText ("$Max") ;
            Bmax.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_BmaxFocusLost

    private void BgoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BgoActionPerformed
         String minPriceStr = Bmin.getText().trim();
         String maxPriceStr = Bmax.getText().trim();
         if (!minPriceStr.isEmpty() && !maxPriceStr.isEmpty()) {
        try {
            double minPrice = Double.parseDouble(minPriceStr);
            double maxPrice = Double.parseDouble(maxPriceStr);

            // เชื่อมต่อฐานข้อมูลและดึงข้อมูลสินค้าตามช่วงราคา
            con = DB.mycon();
            String query = "SELECT * FROM inventory WHERE Price BETWEEN ? AND ?";
            pst = con.prepareStatement(query);
            pst.setDouble(1, minPrice);
            pst.setDouble(2, maxPrice);
            rs = pst.executeQuery();

            // อัพเดตตารางด้วยข้อมูลที่ดึงมา
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            model.setRowCount(0); // Clear ข้อมูลเก่าในตาราง

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("No"),
                    rs.getInt("Id"),
                    rs.getString("Date"),
                    rs.getString("Name"),
                    rs.getString("Category"),
                    rs.getInt("Quantity"),
                    rs.getDouble("Price")
                };
                model.addRow(row); // เพิ่มแถวใหม่ในตาราง
            }

        } catch (NumberFormatException | SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    } else {
        // แจ้งให้ผู้ใช้กรอกข้อมูลในทั้ง Bmin และ Bmax
        JOptionPane.showMessageDialog(this, "กรุณากรอกค่า Price ทั้งสอง", "ข้อผิดพลาด", JOptionPane.ERROR_MESSAGE);
    }
  
    }//GEN-LAST:event_BgoActionPerformed

    private void BminKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BminKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_BminKeyReleased

    private void BmaxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BmaxKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_BmaxKeyReleased

    private void CategoryBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoryBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CategoryBoxActionPerformed

    
     private void loadAllProducts() {
        ArrayList<InventoryInfo> productsList = getProductsList(""); // Fetch all products
        
        // Update table with all products
        updateTableWithProducts(productsList);
    }
    
    private void sortProductsByPriceAscending() {
        ArrayList<InventoryInfo> sortedList = getProductsList("ORDER BY Price ASC");
        updateTableWithProducts(sortedList);
    }
    
    private void sortProductsByPriceDescending() {
        ArrayList<InventoryInfo> sortedList = getProductsList("ORDER BY Price DESC");
        updateTableWithProducts(sortedList);
    }
    
    private void sortProductsByQuantityAscending() {
        ArrayList<InventoryInfo> sortedList = getProductsList("ORDER BY Quantity ASC");
        updateTableWithProducts(sortedList);
    }
    
    private void sortProductsByQuantityDescending() {
        ArrayList<InventoryInfo> sortedList = getProductsList("ORDER BY Quantity DESC");
        updateTableWithProducts(sortedList);
    }
    
    
    ArrayList<InventoryInfo> productsArray = new ArrayList<>();
    int position = 0;
    private ArrayList<InventoryInfo> getProductsList(String orderBy) {
        ArrayList<InventoryInfo> list = new ArrayList<>();
        String selectQuery = "SELECT * FROM `inventory` " + orderBy;

        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(selectQuery)) {

            while (rs.next()) {
                InventoryInfo product = new InventoryInfo(
                    rs.getInt("No"), rs.getInt("Id"),
                    rs.getString("Date"), rs.getString("Name"), rs.getString("Category"),
                    rs.getDouble("Cost"), rs.getInt("Quantity"), rs.getDouble("Price")
                );
                list.add(product);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return list;
    }
    
    
    
    
    private void updateTableWithProducts(ArrayList<InventoryInfo> productsList) {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);

        for (InventoryInfo product : productsList) {
            Object[] row = {
                product.getNo(),
                product.getId(),
                product.getDate(),
                product.getName(),
                product.getCategory(),
                product.getQuantity(),
                product.getPrice()
            };
            model.addRow(row);
        }
    }
    
    public void showProductData(int index)
    {
        EditProduct.txtNo.setText(productsArray.get(index).getNo().toString());
        EditProduct.txtProductid.setText(productsArray.get(index).getId().toString());
        EditProduct.txtName.setText(productsArray.get(index).getName());
        EditProduct.txtType.setText(productsArray.get(index).getCategory());
        EditProduct.txtCost_price.setText(productsArray.get(index).getCost().toString());
        EditProduct.txtPrice.setText(productsArray.get(index).getPrice().toString());
        EditProduct.txtAmount.setText(productsArray.get(index).getQuantity().toString());
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bgo;
    private javax.swing.JTextField Bmax;
    private javax.swing.JTextField Bmin;
    private javax.swing.JComboBox<String> CategoryBox;
    private javax.swing.JLabel Topic;
    private javax.swing.JLabel back_button;
    private javax.swing.JLabel back_button1;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton delete_bt;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField search__box;
    // End of variables declaration//GEN-END:variables

}
