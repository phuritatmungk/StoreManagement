package component;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import karnkha.DB;
import karnkha.InvReport;
import component.ReportMenu;
import karnkha.Main;
public class Sales_Report extends javax.swing.JPanel {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public Sales_Report() {
        initComponents();
        con = DB.mycon();
        showProductsInTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back_button1 = new javax.swing.JLabel();
        Topic = new javax.swing.JLabel();
        btnPrint = new javax.swing.JButton();
        Topic1 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        txtSum = new javax.swing.JTextField();
        txtDate2 = new javax.swing.JTextField();
        Topic2 = new javax.swing.JLabel();
        Topic3 = new javax.swing.JLabel();
        txtDate1 = new javax.swing.JTextField();
        Topic4 = new javax.swing.JLabel();
        Topic5 = new javax.swing.JLabel();
        txtSum2 = new javax.swing.JTextField();
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

        Topic.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Topic.setText("มูลค่าสินค้าในคลัง");
        add(Topic, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 740, -1, -1));

        btnPrint.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/printer.png"))); // NOI18N
        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 50, 130, 40));

        Topic1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Topic1.setText("รายงานแสดงผลการดำเนินงาน");
        add(Topic1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, -1, -1));

        btnSearch.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnSearch.setText("ค้นหา");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 650, 170, 50));

        txtSum.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSum.setForeground(new java.awt.Color(123, 123, 123));
        txtSum.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtSum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtSum.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSumFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSumFocusLost(evt);
            }
        });
        txtSum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSumActionPerformed(evt);
            }
        });
        add(txtSum, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 660, 200, 70));

        txtDate2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtDate2.setForeground(new java.awt.Color(123, 123, 123));
        txtDate2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtDate2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtDate2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDate2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDate2FocusLost(evt);
            }
        });
        txtDate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDate2ActionPerformed(evt);
            }
        });
        add(txtDate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 660, 190, 30));

        Topic2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Topic2.setText("รายงานสรุปข้อมูลการขายสินค้า");
        add(Topic2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, -1, -1));

        Topic3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Topic3.setText("ถึง:");
        add(Topic3, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 660, -1, -1));

        txtDate1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtDate1.setForeground(new java.awt.Color(123, 123, 123));
        txtDate1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtDate1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtDate1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDate1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDate1FocusLost(evt);
            }
        });
        txtDate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDate1ActionPerformed(evt);
            }
        });
        add(txtDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 660, 190, 30));

        Topic4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Topic4.setText("เลือกวันที่:");
        add(Topic4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 660, -1, -1));

        Topic5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Topic5.setText("จำนวนสินค้าออกจากคลังทั้งหมด");
        add(Topic5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 740, -1, -1));

        txtSum2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSum2.setForeground(new java.awt.Color(123, 123, 123));
        txtSum2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtSum2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtSum2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSum2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSum2FocusLost(evt);
            }
        });
        txtSum2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSum2ActionPerformed(evt);
            }
        });
        add(txtSum2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 660, 200, 70));

        jTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Date", "Product ID", "Product Name", "Category", "Cost", "Quantity", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtSumFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSumFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSumFocusGained

    private void txtSumFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSumFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSumFocusLost

    private void txtSumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSumActionPerformed

    private void txtDate2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDate2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDate2FocusGained

    private void txtDate2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDate2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDate2FocusLost

    private void txtDate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDate2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDate2ActionPerformed

    private void txtDate1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDate1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDate1FocusGained

    private void txtDate1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDate1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDate1FocusLost

    private void txtDate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDate1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDate1ActionPerformed

    private void txtSum2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSum2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSum2FocusGained

    private void txtSum2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSum2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSum2FocusLost

    private void txtSum2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSum2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSum2ActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        // TODO add your handling code here:
        int index = jTable.getSelectedRow();
        position = index;
    }//GEN-LAST:event_jTableMouseClicked

    private void back_button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_button1MouseClicked
        Main.body.removeAll();
        Main.body.add(new ReportMenu());
        Main.body.repaint();
        Main.body.revalidate();
    }//GEN-LAST:event_back_button1MouseClicked

    ArrayList<InvReport> salesArray = new ArrayList<>();
    
    int position = 0;
    public ArrayList<InvReport> getProductsList()
    {
        ArrayList<InvReport> list = new ArrayList<>();
        String selectQuery = "SELECT * FROM `reportsales`";
        
        Statement st;
        ResultSet rs;
        
        try {
            st = DB.getConnection().createStatement();
            rs = st.executeQuery(selectQuery);
            InvReport sales;
            
            while(rs.next())
            {
                sales = new InvReport(rs.getString("Date"), rs.getInt("Id"),
                                      rs.getString("List"), rs.getString("Category"), rs.getDouble("Cost"),
                                      rs.getInt("Quantity"), rs.getDouble("Total"));
                list.add(sales);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        salesArray = list;
        return list;
        
    }
    
    public void showProductsInTable()
    {
        ArrayList<InvReport> salessList = getProductsList();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        
        model.setRowCount(0);
        
        Object[] row = new Object[7];
        
        for(int i = 0; i < salessList.size(); i++)
        {
            row[0] = salessList.get(i).getDate();
            row[1] = salessList.get(i).getId();
            row[2] = salessList.get(i).getName();
            row[3] = salessList.get(i).getCategory();
            row[4] = salessList.get(i).getCost();
            row[5] = salessList.get(i).getQuantity();
            row[6] = salessList.get(i).getTotal();
            
            model.addRow(row);
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Topic;
    private javax.swing.JLabel Topic1;
    private javax.swing.JLabel Topic2;
    private javax.swing.JLabel Topic3;
    private javax.swing.JLabel Topic4;
    private javax.swing.JLabel Topic5;
    private javax.swing.JLabel back_button1;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSearch;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField txtDate1;
    private javax.swing.JTextField txtDate2;
    private javax.swing.JTextField txtSum;
    private javax.swing.JTextField txtSum2;
    // End of variables declaration//GEN-END:variables

}
