package component;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.raven.datechooser.DateBetween;
import com.raven.datechooser.DateChooser;
import com.raven.datechooser.listener.DateChooserAction;
import com.raven.datechooser.listener.DateChooserAdapter;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import karnkha.DB;
import karnkha.ExpenseInfo;
import karnkha.Main;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import karnkha.OrderInfo;
public class Expense_Report extends javax.swing.JPanel {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    private DateChooser chDate = new DateChooser();
    private DefaultTableModel model;
    
    public Expense_Report() {
        initComponents();
        chDate.setTextField(searchDate);
        chDate.setDateSelectionMode(DateChooser.DateSelectionMode.BETWEEN_DATE_SELECTED);
        chDate.setDateFormat(new SimpleDateFormat("dd-MM-yyyy"));
        model = (DefaultTableModel)jTable.getModel();
        chDate.addActionDateChooserListener(new DateChooserAdapter() {
            @Override
            public void dateBetweenChanged(DateBetween db, DateChooserAction action) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String dateFrom = df.format(db.getFromDate());
                String toDate = df.format(db.getToDate());
                loadData("SELECT * FROM `reportexpense` WHERE `Date` BETWEEN '" + dateFrom + "' AND '" + toDate + "'");
        
                model.fireTableDataChanged();
            }
        });
                try{
            DB.getInstance().getConnection();
        } catch (Exception e) {
            System.err.println(e);
            }
        con = DB.mycon();
        showProductsInTable();
    }
    
    private void loadData(String sql) {
        try {
            model.setRowCount(0); // เคลียร์ข้อมูลในตารางก่อนโหลดข้อมูลใหม่
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            DecimalFormat f = new DecimalFormat("$ #,##0.##");
            PreparedStatement p = DB.getInstance().getConnection().prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while (r.next()) {
            String Date = r.getString("Date");
            String Id = r.getString("Id");
            String List = r.getString("List");
            String Category = r.getString("Category");
            String Cost = f.format(r.getDouble("Cost"));
            String Quantity = f.format(r.getDouble("Quantity"));
            String Expense = f.format(r.getDouble("Expense"));
            String Total = f.format(r.getDouble("Total"));
            
            // เพิ่มข้อมูลใหม่เข้าไปในตาราง
            model.addRow(new Object[] { Date,Id,List,Category,Cost,Quantity,Expense,Total});
            
            
            
        }
        r.close();
        p.close();
        model.fireTableDataChanged();
    } catch (Exception e) {
        System.err.println(e);
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back_button1 = new javax.swing.JLabel();
        Topic = new javax.swing.JLabel();
        btnPrint = new javax.swing.JButton();
        Topic1 = new javax.swing.JLabel();
        txtSum = new javax.swing.JTextField();
        Topic2 = new javax.swing.JLabel();
        Topic4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        searchDate = new javax.swing.JTextField();

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

        Topic.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Topic.setText("รายรับทั้งหมด");
        add(Topic, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 660, -1, -1));

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
        add(txtSum, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 660, 190, 30));

        Topic2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Topic2.setText("รายงานสรุปรายจ่าย");
        add(Topic2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, -1, -1));

        Topic4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Topic4.setText("วันที่:");
        add(Topic4, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 640, -1, 30));

        jTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Date", "Product Name", "Category", "Cost", "Quantity", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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

        searchDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        searchDate.setForeground(new java.awt.Color(123, 123, 123));
        searchDate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        searchDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchDateActionPerformed(evt);
            }
        });
        add(searchDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 640, 260, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrintActionPerformed

    private void txtSumFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSumFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSumFocusGained

    private void txtSumFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSumFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSumFocusLost

    private void txtSumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSumActionPerformed

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

    private void searchDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchDateActionPerformed

    ArrayList<OrderInfo> productsArray = new ArrayList<>();
    
    int position = 0;
    public ArrayList<OrderInfo> getProductsList()
    {
        ArrayList<OrderInfo> list = new ArrayList<>();
        String selectQuery = "SELECT * FROM `order`";
        
        Statement st;
        ResultSet rs;
        
        try {
            st = DB.getConnection().createStatement();
            rs = st.executeQuery(selectQuery);
            OrderInfo product;
            
            while(rs.next())
            {
                product = new OrderInfo(rs.getInt("No"), rs.getString("Date"),
                                      rs.getString("Company"), rs.getString("Name"), rs.getString("Category"), 
                                      rs.getDouble("Cost"), rs.getInt("Quantity"), rs.getDouble("Total"), rs.getString("Remark"));
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
        ArrayList<OrderInfo> productsList = getProductsList();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        
        model.setRowCount(0);
        
        Object[] row = new Object[6];
        
        for(int i = 0; i < productsList.size(); i++)
        {
            row[0] = productsList.get(i).getDate();
            row[1] = productsList.get(i).getName();
            row[2] = productsList.get(i).getCategory();
            row[3] = productsList.get(i).getCost();
            row[4] = productsList.get(i).getQuantity();
            row[5] = productsList.get(i).getTotal();
            
            model.addRow(row);
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Topic;
    private javax.swing.JLabel Topic1;
    private javax.swing.JLabel Topic2;
    private javax.swing.JLabel Topic4;
    private javax.swing.JLabel back_button1;
    private javax.swing.JButton btnPrint;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField searchDate;
    private javax.swing.JTextField txtSum;
    // End of variables declaration//GEN-END:variables

}
