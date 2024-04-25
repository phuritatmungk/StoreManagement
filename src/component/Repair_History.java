package component;

import raven.cell.TableActionCellEditorView;
import raven.cell.TableActionCellRenderView;
import raven.cell.TableActionEventView;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import karnkha.DB;
import karnkha.RepairRequest;

public class Repair_History extends javax.swing.JPanel {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public Repair_History() {
        initComponents();
        con = DB.mycon();
        showRequestInTable();
        TableActionEventView event = new TableActionEventView() {
            @Override
            public void onView(int row) {
                System.out.println("View row : " + row);
                jFrame1.setVisible(true);
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
        Label_Aprices1 = new javax.swing.JLabel();
        Company_label = new javax.swing.JLabel();
        ScrollPane_Note = new javax.swing.JScrollPane();
        Table_Order_Record1 = new javax.swing.JTable();
        All_prices = new javax.swing.JLabel();
        back_button1 = new javax.swing.JLabel();
        Topic = new javax.swing.JLabel();
        txtCustomer1 = new javax.swing.JTextField();
        Topic2 = new javax.swing.JLabel();
        Topic3 = new javax.swing.JLabel();
        txtCustomer2 = new javax.swing.JTextField();
        btnNext = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        jFrame1.setSize(new java.awt.Dimension(1550, 800));
        jFrame1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Label_Aprices1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Label_Aprices1.setText("ราคารวมทั้งหมด :");
        jPanel1.add(Label_Aprices1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 680, -1, -1));

        Company_label.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Company_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Company_label.setText("รายละเอียดประวัติการซ่อมสินค้า");
        jPanel1.add(Company_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 1440, -1));

        Table_Order_Record1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No.", "ID Product", "Product", "Product Type", "Quantity", "Prices"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table_Order_Record1.getTableHeader().setReorderingAllowed(false);
        Table_Order_Record1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_Order_Record1MouseClicked(evt);
            }
        });
        ScrollPane_Note.setViewportView(Table_Order_Record1);

        jPanel1.add(ScrollPane_Note, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 1440, 590));

        All_prices.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        All_prices.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        All_prices.setText("00.00");
        jPanel1.add(All_prices, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 680, 250, -1));

        jFrame1.getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1550, 800));

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back_button1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        back_button1.setForeground(new java.awt.Color(139, 139, 139));
        back_button1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        back_button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back-button.png"))); // NOI18N
        add(back_button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 60));

        Topic.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Topic.setText("ประวัติการซ่อมสินค้า");
        add(Topic, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, -1, -1));

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
        add(txtCustomer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 70, 190, 30));

        Topic2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Topic2.setText("ถึง :");
        add(Topic2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 70, -1, 30));

        Topic3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Topic3.setText("วันที่ :");
        add(Topic3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, -1, 30));

        txtCustomer2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCustomer2.setForeground(new java.awt.Color(123, 123, 123));
        txtCustomer2.setText(" ##/##/##");
        txtCustomer2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCustomer2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCustomer2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCustomer2FocusLost(evt);
            }
        });
        add(txtCustomer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, 190, 30));

        btnNext.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnNext.setText("ค้นหา");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 70, 110, 30));

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
        jScrollPane2.setViewportView(jTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 1240, 560));
    }// </editor-fold>//GEN-END:initComponents

    private void txtCustomer1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustomer1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomer1FocusGained

    private void txtCustomer1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustomer1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomer1FocusLost

    private void txtCustomer2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustomer2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomer2FocusGained

    private void txtCustomer2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustomer2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomer2FocusLost

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNextActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        // TODO add your handling code here:
        int index = jTable.getSelectedRow();
        position = index;
    }//GEN-LAST:event_jTableMouseClicked

    private void Table_Order_Record1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_Order_Record1MouseClicked

    }//GEN-LAST:event_Table_Order_Record1MouseClicked

    ArrayList<RepairRequest> requestArray = new ArrayList<>();
    
    int position = 0;
    public ArrayList<RepairRequest> getRequestList()
    {
        ArrayList<RepairRequest> list = new ArrayList<>();
        String selectQuery = "SELECT * FROM `requestpaid`";
        
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
    private javax.swing.JLabel All_prices;
    private javax.swing.JLabel Company_label;
    private javax.swing.JLabel Label_Aprices1;
    private javax.swing.JScrollPane ScrollPane_Note;
    private javax.swing.JTable Table_Order_Record1;
    private javax.swing.JLabel Topic;
    private javax.swing.JLabel Topic2;
    private javax.swing.JLabel Topic3;
    private javax.swing.JLabel back_button1;
    private javax.swing.JButton btnNext;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField txtCustomer1;
    private javax.swing.JTextField txtCustomer2;
    // End of variables declaration//GEN-END:variables

}
