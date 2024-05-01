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
import karnkha.Main;
import karnkha.RevenueInfo;
import component.ReportMenu;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import karnkha.RepairRequest;
import karnkha.RepairRequest1;
import karnkha.SalesReport;

public class Revenue_Report extends javax.swing.JPanel {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    private DateChooser chDate = new DateChooser();
    private DefaultTableModel model;
    
    public Revenue_Report() {
        initComponents();
        chDate.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        chDate.setDateSelectionMode(DateChooser.DateSelectionMode.BETWEEN_DATE_SELECTED);
        chDate.setTextField(searchdata__box);
        model = (DefaultTableModel)jTable.getModel();
        chDate.addActionDateChooserListener(new DateChooserAdapter() {
            @Override
            public void dateBetweenChanged(DateBetween db, DateChooserAction action) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String dateFrom = df.format(db.getFromDate());
                String toDate = df.format(db.getToDate());
                loadSalesData("SELECT * FROM `reportsales` WHERE `Date` BETWEEN '" + dateFrom + "' AND '" + toDate + "'");
                loadRequestData("SELECT * FROM `requestpaid` WHERE `Date` BETWEEN '" + dateFrom + "' AND '" + toDate + "'");
                model.fireTableDataChanged();
            }
        });
    try {
        DB.getInstance().getConnection();
    } catch (Exception e) {
        System.err.println(e);
    }
    con = DB.mycon();
    showProductsInTable();
}

    private void loadSalesData(String sql) {
    try {
        model.setRowCount(0); 
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        DecimalFormat fWithDecimal = new DecimalFormat("###0.0");
        DecimalFormat fWithoutDecimal = new DecimalFormat("###0"); 
        fWithDecimal.setMinimumFractionDigits(1); // ตั้งค่าให้มีตัวเลขหลังจุดทศนิยมอย่างน้อย 1 ตัว
        fWithDecimal.setMaximumFractionDigits(1); // ตั้งค่าให้มีตัวเลขหลังจุดทศนิยมมากสุด 1 ตัว
        PreparedStatement p = DB.getInstance().getConnection().prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            String Date = r.getString("Date");
            String Id = r.getString("Id");
            String List = r.getString("List");
            String Category = r.getString("Category");
            double cost = r.getDouble("Cost");
            double price = r.getDouble("Price");
            double total = r.getDouble("Total");
            String Cost =  fWithDecimal.format(cost); 
            String Quantity = fWithoutDecimal.format(r.getInt("Quantity")); 
            String Price = fWithDecimal.format(price);
            String Total = fWithDecimal.format(total); 
            model.addRow(new Object[] { Date,Id,List,Category,Cost,Quantity,Price,Total});
        }
        r.close();
        p.close();
        model.fireTableDataChanged();
    } catch (Exception e) {
        System.err.println(e);
    }
}

private void loadRequestData(String sql) {
    try {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        DecimalFormat fWithDecimal = new DecimalFormat("###0.0"); 
        DecimalFormat fWithoutDecimal = new DecimalFormat("###0"); 
        fWithDecimal.setMinimumFractionDigits(1); 
        fWithDecimal.setMaximumFractionDigits(1);
        PreparedStatement p = DB.getInstance().getConnection().prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            String Date = r.getString("Date");
            String PId = r.getString("PId");
            String PName = r.getString("PName");
            String Category = r.getString("Category");
            double cost = r.getDouble("Cost");
            double price = r.getDouble("Price");
            double total = r.getDouble("Total");
            double service = r.getDouble("Service");
            String Cost = fWithDecimal.format(cost);
            String Quantity = fWithoutDecimal.format(r.getInt("Quantity"));
            String Price = fWithDecimal.format(price);
            String Total = fWithDecimal.format(total);
            String Service = fWithDecimal.format(service);
            model.addRow(new Object[] { Date,PId,PName,Category,Cost,Quantity,Price,Total,Service});
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        B_Date = new javax.swing.JLabel();
        searchdata__box = new javax.swing.JTextField();
        Topic4 = new javax.swing.JLabel();

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
        add(Topic, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 640, -1, -1));

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
        add(txtSum, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 640, 190, 30));

        Topic2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Topic2.setText("รายงานสรุปรายรับ");
        add(Topic2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, -1, -1));

        jTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Date", "Product ID", "List", "Category", "Cost", "Quantity", "Price", "Total", "Service"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
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

        B_Date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        B_Date.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/calendar.png"))); // NOI18N
        B_Date.setToolTipText("");
        B_Date.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B_DateMouseClicked(evt);
            }
        });
        add(B_Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 640, 30, 30));

        searchdata__box.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        searchdata__box.setForeground(new java.awt.Color(123, 123, 123));
        searchdata__box.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchdata__box.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        searchdata__box.setEnabled(false);
        searchdata__box.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchdata__boxFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchdata__boxFocusLost(evt);
            }
        });
        add(searchdata__box, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 640, 300, 30));

        Topic4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Topic4.setText("วันที่:");
        add(Topic4, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 640, -1, 30));
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

    private void searchdata__boxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchdata__boxFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_searchdata__boxFocusGained

    private void searchdata__boxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchdata__boxFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_searchdata__boxFocusLost

    private void B_DateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B_DateMouseClicked
        chDate.showPopup();
    }//GEN-LAST:event_B_DateMouseClicked

    ArrayList<SalesReport> salesArray = new ArrayList<>();
    
    int position = 0;
    public ArrayList<SalesReport> getProductsList()
    {
        ArrayList<SalesReport> list = new ArrayList<>();
        String selectQuery = "SELECT * FROM `reportsales`";
        
        Statement st;
        ResultSet rs;
        
        try {
            st = DB.getConnection().createStatement();
            rs = st.executeQuery(selectQuery);
            SalesReport sales;
            
            while(rs.next())
            {
                sales = new SalesReport(rs.getString("Date"), rs.getString("Id"),
                                      rs.getString("List"), rs.getString("Category"), rs.getDouble("Cost"),
                                      rs.getInt("Quantity"), rs.getDouble("Price"), rs.getDouble("Total"), rs.getDouble("Service"));
                list.add(sales);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        salesArray = list;
        return list;
        
    }
    
    ArrayList<RepairRequest1> requestArray = new ArrayList<>();
   
    public ArrayList<RepairRequest1> getRequestList()
    {
        ArrayList<RepairRequest1> list = new ArrayList<>();
        String selectQuery = "SELECT * FROM `requestpaid`";
        
        Statement st;
        ResultSet rs;
        
        try {
            st = DB.getConnection().createStatement();
            rs = st.executeQuery(selectQuery);
            RepairRequest1 request;
            
            while(rs.next())
            {
                request = new RepairRequest1(rs.getInt("No"), rs.getString("Date"),
                                      rs.getString("PName"),rs.getString("Name"),rs.getString("PId"), rs.getString("Category"), rs.getDouble("Cost"),
                                      rs.getDouble("Price"), rs.getInt("Quantity"), rs.getDouble("Total"), rs.getDouble("Service"));
                list.add(request);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        requestArray = list;
        return list;
        
    }
    
    
    public void showProductsInTable()
    {
        ArrayList<SalesReport> salesList = getProductsList();
        ArrayList<RepairRequest1> repairList = getRequestList();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();

        model.setRowCount(0);

        for (SalesReport sales : salesList) {
            Object[] row = new Object[9];
            row[0] = sales.getDate();
            row[1] = sales.getId();
            row[2] = sales.getName();
            row[3] = sales.getCategory();
            row[4] = sales.getCost();
            row[5] = sales.getQuantity();
            row[6] = sales.getPrice();
            row[7] = sales.getTotal();
            row[8] = sales.getService();
            model.addRow(row);
        }

        for (RepairRequest1 request : repairList) {
            Object[] row = new Object[9];
            row[0] = request.getDate();
            row[1] = request.getPid();
            row[2] = request.getPname();
            row[3] = request.getCategory();
            row[4] = request.getCost();
            row[5] = request.getQuantity();
            row[6] = request.getPrice();
            row[7] = request.getResult();

            if (requestArray.indexOf(request) == 0 || !request.getPname().equals(repairList.get(requestArray.indexOf(request) - 1).getPname()) || !request.getDate().equals(repairList.get(requestArray.indexOf(request) - 1).getDate())) {
                row[8] = request.getService();
            } else {
                row[8] = ""; 
            }

            model.addRow(row);
        }
        
        double total = 0;
        
        for (int i = 0; i < model.getRowCount(); i++) {
            int quantity = (int) model.getValueAt(i, 5);
            double price = (double) model.getValueAt(i, 6);
            double service = (double) model.getValueAt(i, 8);
            total += quantity * price + service; 
        }
        
        txtSum.setText(String.format("%.2f บาท", total));

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel B_Date;
    private javax.swing.JLabel Topic;
    private javax.swing.JLabel Topic1;
    private javax.swing.JLabel Topic2;
    private javax.swing.JLabel Topic4;
    private javax.swing.JLabel back_button1;
    private javax.swing.JButton btnPrint;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField searchdata__box;
    private javax.swing.JTextField txtSum;
    // End of variables declaration//GEN-END:variables

}
