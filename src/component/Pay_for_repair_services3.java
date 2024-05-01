package component;

import raven.cell.TableActionCellEditorView;
import raven.cell.TableActionCellRenderView;
import raven.cell.TableActionEventView;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import karnkha.DB;
import karnkha.Main;
import karnkha.RepairRequest;
import component.Pay_for_repair_services4;
import component.Pay_for_repair_services2;
import static component.Pay_for_repair_services4.txtId;
import static component.Pay_for_repair_services4.txtName;
import static component.Pay_for_repair_services4.txtPhone;
import javax.swing.JOptionPane;
import static component.Pay_for_repair_services4.txtItem;
import static component.Pay_for_repair_services4.txtRepair;
public class Pay_for_repair_services3 extends javax.swing.JPanel {
    
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public Pay_for_repair_services3() {
        initComponents();
        con = DB.mycon();
        showRequestInTable();
        TableActionEventView event = new TableActionEventView() {
            @Override
            public void onView(int row) {
                System.out.println("Edit row : " + row);
                jFrame1.setVisible(true);
                int index = jTable.getSelectedRow();
                showProductData(index);
                position = index;
            }

        };
        jTable.getColumnModel().getColumn(8).setCellRenderer(new TableActionCellRenderView());
        jTable.getColumnModel().getColumn(8).setCellEditor(new TableActionCellEditorView(event));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField_No = new javax.swing.JTextField();
        jTextField_Date = new javax.swing.JTextField();
        jTextField_Name = new javax.swing.JTextField();
        jTextField_Phone = new javax.swing.JTextField();
        jTextField_Repairman = new javax.swing.JTextField();
        jTextField_Id = new javax.swing.JTextField();
        jTextField_Item = new javax.swing.JTextField();
        jTextField_Behavior = new javax.swing.JTextField();
        jComboBox_Status = new javax.swing.JComboBox<>();
        back_button1 = new javax.swing.JLabel();
        Topic = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jFrame1.setAlwaysOnTop(true);
        jFrame1.setBackground(new java.awt.Color(255, 255, 255));
        jFrame1.setLocation(new java.awt.Point(800, 350));
        jFrame1.setMinimumSize(new java.awt.Dimension(440, 440));
        jFrame1.setResizable(false);
        jFrame1.setSize(new java.awt.Dimension(440, 440));
        jFrame1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setVerifyInputWhenFocusTarget(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("ลำดับ :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 13, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("วันที่ :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 43, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("ผู้ส่งซ่อม :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 73, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("หมายเลขโทรศัพท์ :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 103, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("ผู้รับซ่อม :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 133, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("รหัสพนักงาน :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 163, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("อุปกรณ์ที่รับซ่อม :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 193, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("อาการเสีย :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 250, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("สถานะสินค้า :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 223, -1, -1));

        jTextField_No.setEditable(false);
        jTextField_No.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_No.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField_No.setBorder(null);
        jTextField_No.setFocusable(false);
        jPanel1.add(jTextField_No, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 140, 25));

        jTextField_Date.setEditable(false);
        jTextField_Date.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_Date.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField_Date.setBorder(null);
        jTextField_Date.setFocusable(false);
        jPanel1.add(jTextField_Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 140, 25));

        jTextField_Name.setEditable(false);
        jTextField_Name.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_Name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField_Name.setBorder(null);
        jTextField_Name.setFocusable(false);
        jPanel1.add(jTextField_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 140, 25));

        jTextField_Phone.setEditable(false);
        jTextField_Phone.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_Phone.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField_Phone.setBorder(null);
        jTextField_Phone.setFocusable(false);
        jPanel1.add(jTextField_Phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 140, 25));

        jTextField_Repairman.setEditable(false);
        jTextField_Repairman.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_Repairman.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField_Repairman.setBorder(null);
        jTextField_Repairman.setFocusable(false);
        jPanel1.add(jTextField_Repairman, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 140, 25));

        jTextField_Id.setEditable(false);
        jTextField_Id.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_Id.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField_Id.setBorder(null);
        jTextField_Id.setFocusable(false);
        jPanel1.add(jTextField_Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 140, 25));

        jTextField_Item.setEditable(false);
        jTextField_Item.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_Item.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField_Item.setForeground(new java.awt.Color(255, 0, 51));
        jTextField_Item.setBorder(null);
        jTextField_Item.setFocusable(false);
        jTextField_Item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_ItemActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField_Item, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 140, 25));

        jTextField_Behavior.setEditable(false);
        jTextField_Behavior.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_Behavior.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField_Behavior.setBorder(null);
        jTextField_Behavior.setFocusable(false);
        jPanel1.add(jTextField_Behavior, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 330, 120));

        jComboBox_Status.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_Status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "กำลังดำเนินการ", "เสร็จสิ้น" }));
        jComboBox_Status.setEnabled(false);
        jPanel1.add(jComboBox_Status, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 140, 30));

        jFrame1.getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 630));

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
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 1240, 520));
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
    int index = jTable.getSelectedRow();
    if (index != -1) {
        RepairRequest selectedRequest = requestArray.get(index);
        Main.body.removeAll();
        Main.body.add(new Pay_for_repair_services4(selectedRequest));
        Main.body.repaint();
        Main.body.revalidate();
        showProductData2(index);
    } else {
        JOptionPane.showMessageDialog(this, "Please select a request", "Warning", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_btnNextActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        // TODO add your handling code here:
        int index = jTable.getSelectedRow();
        position = index;
    }//GEN-LAST:event_jTableMouseClicked

    private void jTextField_ItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_ItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_ItemActionPerformed

    private void back_button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_button1MouseClicked
        Main.body.removeAll();
        Main.body.add(new Pay_for_repair_services2());
        Main.body.repaint();
        Main.body.revalidate();
    }//GEN-LAST:event_back_button1MouseClicked

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
                request = new RepairRequest(rs.getInt("No"), rs.getString("Datetime"),
                                      rs.getString("Name"), rs.getString("Phone"), rs.getString("Item"),
                                      rs.getString("ID"), rs.getString("Repairman"), rs.getString("Status"), rs.getString("Malfunction"));
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
        if(requestsList.get(i).getStatus().equals("เสร็จสิ้น"))
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
    

    }
        public void showProductData(int index)
    {
        jTextField_No.setText(requestArray.get(index).getNo().toString());
        jTextField_Date.setText(requestArray.get(index).getDate());
        jTextField_Name.setText(requestArray.get(index).getName());
        jTextField_Phone.setText(requestArray.get(index).getPhone().toString());
        jTextField_Item.setText(requestArray.get(index).getItem());
        jTextField_Id.setText(requestArray.get(index).getId().toString());
        jTextField_Repairman.setText(requestArray.get(index).getRepairman());
        jComboBox_Status.setSelectedItem(requestArray.get(index).getStatus());
        jTextField_Behavior.setText(requestArray.get(index).getMalfunction());
    } 
        public void showProductData2(int index)
    {
        Pay_for_repair_services4.txtName.setText(requestArray.get(index).getName());
        Pay_for_repair_services4.txtPhone.setText(requestArray.get(index).getPhone().toString());
        Pay_for_repair_services4.txtItem.setText(requestArray.get(index).getItem());
        Pay_for_repair_services4.txtId.setText(String.valueOf(requestArray.get(index).getId()));
        Pay_for_repair_services4.txtRepair.setText(requestArray.get(index).getRepairman());
        Pay_for_repair_services4.txtDate.setText(requestArray.get(index).getDate());
        Pay_for_repair_services4.txtStatus.setText(requestArray.get(index).getStatus());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Topic;
    private javax.swing.JLabel back_button1;
    private javax.swing.JButton btnNext;
    private javax.swing.JComboBox<String> jComboBox_Status;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextField_Behavior;
    private javax.swing.JTextField jTextField_Date;
    private javax.swing.JTextField jTextField_Id;
    private javax.swing.JTextField jTextField_Item;
    private javax.swing.JTextField jTextField_Name;
    private javax.swing.JTextField jTextField_No;
    private javax.swing.JTextField jTextField_Phone;
    private javax.swing.JTextField jTextField_Repairman;
    // End of variables declaration//GEN-END:variables

}
