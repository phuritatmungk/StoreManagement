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
import component.Pay_for_repair_services3;
import component.Pay_for_repair_services2;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;

public class Pay_for_repair_services2 extends javax.swing.JPanel {
    
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public Pay_for_repair_services2() {
        initComponents();
        con = DB.mycon();
        showProductsInTable();
        TableActionEventTrash event = new TableActionEventTrash() {
            @Override
            public void onDelete(int row) {
                if (jTable.isEditing()) {
                    jTable.getCellEditor().stopCellEditing();
                }
                DefaultTableModel model = (DefaultTableModel) jTable.getModel();
                model.removeRow(row);
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
        back_button = new javax.swing.JLabel();
        txtSearch1 = new javax.swing.JTextField();
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
        add(back_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 50, 30, 30));

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
        add(txtSearch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 50, 260, 30));

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
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        updateQuantitiesInDatabase();
        Main.body.removeAll();
        Main.body.add(new Pay_for_repair_services3());
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
        Main.body.removeAll();
        Main.body.add(new Pay_for_repair_services());
        Main.body.repaint();
        Main.body.revalidate();
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
    
            for (int i = 0; i < rowCount; i++) {
                String productId = (String) model.getValueAt(i, 1);
                int quantity = (int) model.getValueAt(i, 4); 
        

            updateQuantityInDatabase(productId, quantity);
            }
        }
    
    private void updateQuantityInDatabase(String productId, int quantity) {
        String updateQuery = "UPDATE repaircart SET Quantity = ? WHERE Id = ?";
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Topic;
    private javax.swing.JLabel back_button;
    private javax.swing.JLabel back_button1;
    private javax.swing.JButton btnNext;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField txtSearch1;
    // End of variables declaration//GEN-END:variables

}
