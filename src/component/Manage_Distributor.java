package component;

import raven.cell.TableActionCellEditorEdit;
import raven.cell.TableActionCellRenderEdit;
import raven.cell.TableActionEventEdit;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import karnkha.DB;
import karnkha.DistributorInfo;
import karnkha.Main;
import component.Distributor_Register;
import component.Edit_dealer_info;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.table.TableRowSorter;
import karnkha.Home;
public class Manage_Distributor extends javax.swing.JPanel {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public Manage_Distributor() {
        initComponents();
        con = DB.mycon();
        showDistributorInTable();
        TableActionEventEdit event = new TableActionEventEdit() {
            @Override
            public void onEdit(int row) {
                System.out.println("Edit row : " + row);
                Main.body.removeAll();
                Main.body.add(new Edit_dealer_info());
                Main.body.repaint();
                Main.body.revalidate();
                int index = jTable.getSelectedRow();
                showProductData(index);
                position = index;
            }

        };
        jTable.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRenderEdit());
        jTable.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditorEdit(event));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back_button1 = new javax.swing.JLabel();
        Topic = new javax.swing.JLabel();
        Save_bt1 = new javax.swing.JButton();
        delete_bt = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        back_button = new javax.swing.JLabel();
        search__box = new javax.swing.JTextField();

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
        Topic.setText("จัดการทะเบียนตัวแทนจำหน่าย");
        add(Topic, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, -1, -1));

        Save_bt1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Save_bt1.setText("เพิ่ม");
        Save_bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Save_bt1ActionPerformed(evt);
            }
        });
        add(Save_bt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 680, 130, 50));

        delete_bt.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        delete_bt.setText("ลบ");
        delete_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btActionPerformed(evt);
            }
        });
        add(delete_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 680, 130, 50));

        jTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "Company Name", "Salesman Name", "Phone No", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
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
        back_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/loupe2_1.png"))); // NOI18N
        add(back_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 50, 30, 30));

        search__box.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        search__box.setForeground(new java.awt.Color(123, 123, 123));
        search__box.setText("ค้นหา");
        search__box.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        search__box.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                search__boxFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                search__boxFocusLost(evt);
            }
        });
        search__box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search__boxActionPerformed(evt);
            }
        });
        search__box.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search__boxKeyReleased(evt);
            }
        });
        add(search__box, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 50, 300, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void delete_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btActionPerformed
    int selectedRow = jTable.getSelectedRow(); 
    if(selectedRow != -1) { 
        int id = (int) jTable.getValueAt(selectedRow, 0); 
        if(id > 0) { 
            String deleteQuery = "DELETE FROM distributor WHERE No=?";
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

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        // TODO add your handling code here:
        int index = jTable.getSelectedRow();
        position = index;
    }//GEN-LAST:event_jTableMouseClicked

    private void Save_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Save_bt1ActionPerformed
        Main.body.removeAll();
        Main.body.add(new Distributor_Register());
        Main.body.repaint();
        Main.body.revalidate();
    }//GEN-LAST:event_Save_bt1ActionPerformed

    private void back_button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_button1MouseClicked
        Home homePage = new Home();
        homePage.setVisible(true);
        JFrame thisFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        thisFrame.dispose();
    }//GEN-LAST:event_back_button1MouseClicked

    private void search__boxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_search__boxFocusGained
        if(search__box.getText().equals("ค้นหา")){
            search__box.setText("");
            search__box.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_search__boxFocusGained

    private void search__boxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_search__boxFocusLost
        if (search__box.getText().length()==0) {
            search__box.setText("ค้นหา");
            search__box.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_search__boxFocusLost

    private void search__boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search__boxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search__boxActionPerformed

    private void search__boxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search__boxKeyReleased
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        jTable.setRowSorter(sorter);

        int[] columnIndexToFilter = {1,2,3};

        StringBuilder regexPattern = new StringBuilder();
        for (int columnIndex : columnIndexToFilter) {
            if (regexPattern.length() > 0) {
                regexPattern.append("|");
            }
            regexPattern.append("(?i)").append(search__box.getText().trim());
        }

        sorter.setRowFilter(RowFilter.regexFilter(regexPattern.toString(), columnIndexToFilter));
    }//GEN-LAST:event_search__boxKeyReleased

    ArrayList<DistributorInfo> distributorArray = new ArrayList<>();
    
    int position = 0;
    public ArrayList<DistributorInfo> getProductsList()
    {
        ArrayList<DistributorInfo> list = new ArrayList<>();
        String selectQuery = "SELECT * FROM `distributor`";
        
        Statement st;
        ResultSet rs;
        
        try {
            st = DB.getConnection().createStatement();
            rs = st.executeQuery(selectQuery);
            DistributorInfo distributor;
            
            while(rs.next())
            {
                distributor = new DistributorInfo(rs.getInt("No"), rs.getString("Company"),
                                       rs.getString("Fname"),rs.getString("Sname"),
                                       rs.getString("Phone"),rs.getString("Address"),rs.getString("Image"));
                list.add(distributor);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        distributorArray = list;
        return list;
        
    }
    
    public void showDistributorInTable()
    {
        ArrayList<DistributorInfo> distributorsList = getProductsList();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        
        model.setRowCount(0);
        
        Object[] row = new Object[5];
        
        for(int i = 0; i < distributorsList.size(); i++)
        {
            row[0] = distributorsList.get(i).getNo();
            row[1] = distributorsList.get(i).getCompany();
            row[2] = distributorsList.get(i).getSalesman();
            row[3] = distributorsList.get(i).getPhone();
            
            model.addRow(row);
        }

    }
        public void showProductData(int index)     
      {
        JLabel img = Edit_dealer_info.picture_box; 
        Edit_dealer_info.txtNo.setText(distributorArray.get(index).getNo().toString());
        Edit_dealer_info.txtName.setText(distributorArray.get(index).getFname().toString());
        Edit_dealer_info.txtSname.setText(distributorArray.get(index).getSname().toString());
        Edit_dealer_info.txtCompany.setText(distributorArray.get(index).getCompany().toString());
        Edit_dealer_info.txtAddress.setText(distributorArray.get(index).getAddress().toString());
        Edit_dealer_info.txtPhone.setText(distributorArray.get(index).getPhone().toString());
        Edit_dealer_info.jTextField_imgPath.setText(distributorArray.get(index).getImg().toString());
        displayImage(distributorArray.get(index).getImg(),img,'a');

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
    private javax.swing.JButton Save_bt1;
    private javax.swing.JLabel Topic;
    private javax.swing.JLabel back_button;
    private javax.swing.JLabel back_button1;
    private javax.swing.JButton delete_bt;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField search__box;
    // End of variables declaration//GEN-END:variables
}
