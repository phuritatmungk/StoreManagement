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
import karnkha.InvReport;
import component.ReportMenu;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import karnkha.Main;
public class Sales_Report extends javax.swing.JPanel {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    private DateChooser chDate = new DateChooser();
    private DefaultTableModel model;
    
    public Sales_Report() {
        initComponents();
        chDate.setTextField(searchdata__box);
        chDate.setDateSelectionMode(DateChooser.DateSelectionMode.BETWEEN_DATE_SELECTED);
        chDate.setDateFormat(new SimpleDateFormat("dd-MM-yyyy"));
        model = (DefaultTableModel)jTable.getModel();
        chDate.addActionDateChooserListener(new DateChooserAdapter() {
            @Override
            public void dateBetweenChanged(DateBetween db, DateChooserAction action) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String dateFrom = df.format(db.getFromDate());
                String toDate = df.format(db.getToDate());
                loadData("SELECT * FROM `reportsales` WHERE `Date` BETWEEN '" + dateFrom + "' AND '" + toDate + "'");
        
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
            String Total = f.format(r.getDouble("Total"));
            // เพิ่มข้อมูลใหม่เข้าไปในตาราง
            model.addRow(new Object[] { Date,Id,List,Category,Cost,Quantity, Total});
            
            
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
        searchdata__box = new javax.swing.JTextField();
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
        add(Topic, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 740, -1, -1));

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
        add(txtSum, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 660, 200, 70));

        Topic2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Topic2.setText("รายงานสรุปข้อมูลการขายสินค้า");
        add(Topic2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, -1, -1));

        searchdata__box.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        searchdata__box.setForeground(new java.awt.Color(123, 123, 123));
        searchdata__box.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchdata__box.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        searchdata__box.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchdata__boxFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchdata__boxFocusLost(evt);
            }
        });
        searchdata__box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchdata__boxActionPerformed(evt);
            }
        });
        add(searchdata__box, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 650, 210, 30));

        Topic4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Topic4.setText("วันที่:");
        add(Topic4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 650, -1, 30));

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
public static void main (String args []) {
        FlatIntelliJLaf.registerCustomDefaultsSource("style");
        FlatIntelliJLaf. setup ();
        java.awt. EventQueue. invokeLater (new Runnable () {
            public void run () {
                new Order_Record() .setVisible(true);
            }
        });
    }
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

    private void searchdata__boxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchdata__boxFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_searchdata__boxFocusGained

    private void searchdata__boxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchdata__boxFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_searchdata__boxFocusLost

    private void searchdata__boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchdata__boxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchdata__boxActionPerformed

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
    private javax.swing.JLabel Topic4;
    private javax.swing.JLabel Topic5;
    private javax.swing.JLabel back_button1;
    private javax.swing.JButton btnPrint;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField searchdata__box;
    private javax.swing.JTextField txtSum;
    private javax.swing.JTextField txtSum2;
    // End of variables declaration//GEN-END:variables

}
