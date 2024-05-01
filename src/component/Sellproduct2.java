package component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import karnkha.DB;
import karnkha.CartInfo;
import karnkha.Main;
import raven.cell.TableActionCellEditorTrash;
import raven.cell.TableActionCellRenderTrash;
import raven.cell.TableActionEventTrash;
import component.Sellproduct3;
import component.Sellproduct;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;

public class Sellproduct2 extends javax.swing.JPanel {
    
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public Sellproduct2() {
        initComponents();
        con = DB.mycon();
        showProductsInTable();
        TableActionEventTrash event = new TableActionEventTrash() {
            @Override
            public void onDelete(int row) {
                if (jTable.isEditing()) {
                    jTable.getCellEditor().stopCellEditing();
                }
                int selectedRow = jTable.getSelectedRow(); 
                if(selectedRow != -1) { 
                    int id = (int) jTable.getValueAt(selectedRow, 0); 
                    if(id > 0) { 
                        String deleteQuery = "DELETE FROM cart WHERE No=?";
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
            }
        };
        jTable.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRenderTrash());
        jTable.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditorTrash(event));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back_button1 = new javax.swing.JLabel();
        Topic = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        back_button = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();

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
        Topic.setText("ขายสินค้า");
        add(Topic, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, -1, -1));

        btnNext.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnNext.setText("ดำเนินการต่อ");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 650, 170, 50));

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
                false, false, false, false, true, false, true
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

        back_button.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        back_button.setForeground(new java.awt.Color(139, 139, 139));
        back_button.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        back_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/loupe2.png"))); // NOI18N
        add(back_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 60, 30, 30));

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(123, 123, 123));
        txtSearch.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtSearch.setText("ค้นหาสินค้า");
        txtSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchFocusLost(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 60, 260, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
            updateQuantitiesInDatabase();
    }//GEN-LAST:event_btnNextActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        // TODO add your handling code here:
        int index = jTable.getSelectedRow();
        position = index;
    }//GEN-LAST:event_jTableMouseClicked

    private void back_button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_button1MouseClicked
        Main.body.removeAll();
        Main.body.add(new Sellproduct());
        Main.body.repaint();
        Main.body.revalidate(); 
    }//GEN-LAST:event_back_button1MouseClicked

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        if(txtSearch.getText().equals("ค้นหาสินค้า")){
            txtSearch.setText("");
            txtSearch.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_txtSearchFocusGained

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        if (txtSearch.getText().length()==0) {
            txtSearch.setText("ค้นหาสินค้า");
            txtSearch.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_txtSearchFocusLost

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        jTable.setRowSorter(sorter);

        int[] columnIndexToFilter = {1,2,3};

        StringBuilder regexPattern = new StringBuilder();
        for (int columnIndex : columnIndexToFilter) {
            if (regexPattern.length() > 0) {
                regexPattern.append("|");
            }
            regexPattern.append("(?i)").append(txtSearch.getText().trim());
        }

        sorter.setRowFilter(RowFilter.regexFilter(regexPattern.toString(), columnIndexToFilter));
    }//GEN-LAST:event_txtSearchKeyReleased

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
    
    public void showProductsInTable()
    {
        ArrayList<CartInfo> productsList = getProductsList();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        
        Object[] row = new Object[6];
        
        jTable.getColumnModel().getColumn(4).setCellEditor(new QtyCellEditor(new EventCellInputChange() {
            @Override
            public void inputChanged() {
                System.out.println("Changed");
            }
        }));
        jTable.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(SwingConstants.CENTER);
                return this;
            }
        });        
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
    
    private void updateQuantitiesInDatabase() {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        int rowCount = model.getRowCount();
        boolean quantityExceedsInventory = false; 

        for (int i = 0; i < rowCount; i++) {
            String productId = (String) model.getValueAt(i, 1);
            int quantity = (int) model.getValueAt(i, 4);
            
            int inventoryQuantity = getInventoryQuantity(productId);
            
            if (quantity > inventoryQuantity) {
            quantityExceedsInventory = true;
            break;
            }

            updateQuantityInDatabase(productId, quantity);
        }

        if (quantityExceedsInventory) {
            JOptionPane.showMessageDialog(this, "Insufficient quantity of products", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            Main.body.removeAll();            
            Main.body.add(new Sellproduct3());
            Main.body.repaint();
            Main.body.revalidate();
        }
    }
    
    private void updateQuantityInDatabase(String productId, int quantity) {
        String updateQuery = "UPDATE cart SET Quantity = ? WHERE Id = ?";
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement(updateQuery);
            ps.setInt(1, quantity);
            ps.setString(2, productId);
            int updatedRows = ps.executeUpdate();
        if (updatedRows > 0) {
            System.out.println("Quantity for product ID " + productId + " updated successfully.");
        } else {
            System.out.println("Failed to update quantity for product ID " + productId);
        }
        } catch (SQLException ex) {
        System.out.println("Failed to update quantity: " + ex.getMessage());
    }
    }
    
    private int getInventoryQuantity(String productId) {
        int inventoryQuantity = 0;
        String selectQuery = "SELECT Quantity FROM inventory WHERE Id = ?";
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement(selectQuery);
            ps.setString(1, productId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                inventoryQuantity = rs.getInt("Quantity");
            }
        } catch (SQLException ex) {
            System.out.println("Failed to fetch inventory quantity: " + ex.getMessage());
        }
        return inventoryQuantity;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Topic;
    private javax.swing.JLabel back_button;
    private javax.swing.JLabel back_button1;
    private javax.swing.JButton btnNext;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable jTable;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

}
