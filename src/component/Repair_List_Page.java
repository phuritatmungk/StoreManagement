package component;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
import java.util.ArrayList;
import raven.cell.TableActionCellEditorEditView;
import raven.cell.TableActionCellRenderEditView;
import raven.cell.TableActionEventEditView;
import karnkha.RepairRequest;
import karnkha.DB;

public class Repair_List_Page extends javax.swing.JPanel {
    
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public Repair_List_Page() {
        initComponents();
        con = DB.mycon();
        showRequestInTable();
        TableActionEventEditView event = new TableActionEventEditView() {
            @Override
            public void onEdit(int row) {
                System.out.println("Edit row : " + row);
            }
            public void onView(int row) {
                System.out.println("View row : " + row);
            }
        };
        jTable.getColumnModel().getColumn(8).setCellRenderer(new TableActionCellRenderEditView());
        jTable.getColumnModel().getColumn(8).setCellEditor(new TableActionCellEditorEditView(event));
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back_button1 = new javax.swing.JLabel();
        Topic = new javax.swing.JLabel();
        Save_bt1 = new javax.swing.JButton();
        delete_bt = new javax.swing.JButton();
        Status_Combo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
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
        Topic.setText("รับซ่อมอุปกรณ์และสินค้าเกษตร");
        add(Topic, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, -1, -1));

        Save_bt1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Save_bt1.setText("เพิ่ม");
        Save_bt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Save_bt1MouseClicked(evt);
            }
        });
        Save_bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Save_bt1ActionPerformed(evt);
            }
        });
        add(Save_bt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 640, 130, 50));

        delete_bt.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        delete_bt.setText("ลบ");
        delete_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btActionPerformed(evt);
            }
        });
        add(delete_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 640, 130, 50));

        Status_Combo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Status_Combo.setForeground(new java.awt.Color(123, 123, 123));
        Status_Combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ค้นหาสถานะ", "รอการดำเนินการ", "กำลังดำเนินการ", "เสร็จการดำเนินการ", "ชำระเสร็จสิ้น" }));
        add(Status_Combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1122, 50, 170, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("ค้นหาสถานะ");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 60, -1, -1));

        jTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Date", "Customer Name", "Phone", "Item", "Employee ID", "Repairman", "Status", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
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

    private void delete_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delete_btActionPerformed

    private void Save_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Save_bt1ActionPerformed

    }//GEN-LAST:event_Save_bt1ActionPerformed

    private void Save_bt1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Save_bt1MouseClicked

    }//GEN-LAST:event_Save_bt1MouseClicked

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        // TODO add your handling code here:
        int index = jTable.getSelectedRow();
        position = index;
    }//GEN-LAST:event_jTableMouseClicked

    ArrayList<RepairRequest> requestArray = new ArrayList<>();
    
    int position = 0;
    public ArrayList<RepairRequest> getRequestList()
    {
        ArrayList<RepairRequest> list = new ArrayList<>();
        String selectQuery = "SELECT * FROM `request`";
        
        Statement st;
        ResultSet rs;
        
        try {
            st = DB.getConnection().createStatement();
            rs = st.executeQuery(selectQuery);
            RepairRequest request;
            
            while(rs.next())
            {
                request = new RepairRequest(rs.getInt("No"), rs.getString("Date"),
                                      rs.getString("Name"), rs.getInt("Phone"), rs.getString("Item"),
                                      rs.getInt("ID"), rs.getString("Repairman"), rs.getString("Status"));
                list.add(request);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        requestArray = list;
        return list;
        
    }
    
    public void showRequestInTable()
    {
        ArrayList<RepairRequest> requestsList = getRequestList();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        
        model.setRowCount(0);
        
        Object[] row = new Object[8];
        
        for(int i = 0; i < requestsList.size(); i++)
        {
            row[0] = requestsList.get(i).getNo();
            row[1] = requestsList.get(i).getDate();
            row[2] = requestsList.get(i).getName();
            row[3] = requestsList.get(i).getPhone();
            row[4] = requestsList.get(i).getItem();
            row[5] = requestsList.get(i).getId();
            row[6] = requestsList.get(i).getRepairman();
            row[7] = requestsList.get(i).getStatus();
            
            model.addRow(row);
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Save_bt1;
    private javax.swing.JComboBox<String> Status_Combo;
    private javax.swing.JLabel Topic;
    private javax.swing.JLabel back_button1;
    private javax.swing.JButton delete_bt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables

    private void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
