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
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
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
        back_button = new javax.swing.JLabel();
        search__box = new javax.swing.JTextField();
        Save_bt1 = new javax.swing.JButton();
        delete_bt = new javax.swing.JButton();
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

        Topic.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Topic.setText("จัดการทะเบียนตัวแทนจำหน่าย");
        add(Topic, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, -1, -1));

        back_button.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        back_button.setForeground(new java.awt.Color(139, 139, 139));
        back_button.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        back_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/loupe2_1.png"))); // NOI18N
        add(back_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 50, 30, 30));

        search__box.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        search__box.setForeground(new java.awt.Color(123, 123, 123));
        search__box.setText("ค้นหาชื่อบริษัท");
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
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 1240, 520));
    }// </editor-fold>//GEN-END:initComponents

    private void search__boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search__boxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search__boxActionPerformed

    private void delete_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delete_btActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        // TODO add your handling code here:
        int index = jTable.getSelectedRow();
        position = index;
    }//GEN-LAST:event_jTableMouseClicked

    private void search__boxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_search__boxFocusGained
        if(search__box.getText().equals("ค้นหาชื่อบริษัท")){
                search__box.setText("");
                search__box.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_search__boxFocusGained

    private void search__boxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_search__boxFocusLost
        if (search__box.getText().length()==0) {
            search__box.setText("ค้นหาชื่อบริษัท");
            search__box.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_search__boxFocusLost

    private void search__boxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search__boxKeyReleased
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        jTable.setRowSorter(sorter);
        int columnIndexToFilter = 1;
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + search__box.getText().trim(), columnIndexToFilter));
    }//GEN-LAST:event_search__boxKeyReleased

    private void Save_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Save_bt1ActionPerformed
        Main.body.removeAll();
        Main.body.add(new Distributor_Register());
        Main.body.repaint();
        Main.body.revalidate();
    }//GEN-LAST:event_Save_bt1ActionPerformed

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
                                      rs.getString("Salesman"), rs.getInt("Phone"));
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
            row[1] = distributorsList.get(i).getName();
            row[2] = distributorsList.get(i).getSalesman();
            row[3] = distributorsList.get(i).getPhone();
            
            model.addRow(row);
        }
        
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
