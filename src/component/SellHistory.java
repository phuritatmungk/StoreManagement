package component;

import com.raven.datechooser.DateBetween;
import com.raven.datechooser.DateChooser;
import com.raven.datechooser.listener.DateChooserAction;
import com.raven.datechooser.listener.DateChooserAdapter;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import karnkha.DB;
import karnkha.Home;
import karnkha.SalesReport;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SellHistory extends javax.swing.JPanel {
    
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private DateChooser chDate = new DateChooser();
    private DefaultTableModel model;

    public SellHistory() {
        initComponents();
        chDate.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        chDate.setDateSelectionMode(DateChooser.DateSelectionMode.BETWEEN_DATE_SELECTED);
        chDate.setTextField(search__box);
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
            model.setRowCount(0);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            DecimalFormat f = new DecimalFormat("#,##0.##");
            PreparedStatement p = DB.getInstance().getConnection().prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while (r.next()) {
            String Date = r.getString("Date");
            String Id = r.getString("Id");
            String List = r.getString("List");
            String Category = r.getString("Category");
            String Quantity = f.format(r.getInt("Quantity"));
            double price = r.getDouble("Price");
            String Price = String.valueOf(price);
            
            model.addRow(new Object[] { Date,Id, List,Category, Quantity, Price });
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
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        B_Date = new javax.swing.JLabel();
        search__box = new javax.swing.JTextField();
        Topic3 = new javax.swing.JLabel();

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
        Topic.setText("ประวัติการขายสินค้า");
        add(Topic, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, -1, -1));

        jTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Date", "Product ID", "Product Name", "Category", "Quantity", "Price"
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
        jScrollPane3.setViewportView(jTable);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 1240, 550));

        B_Date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        B_Date.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/calendar.png"))); // NOI18N
        B_Date.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B_DateMouseClicked(evt);
            }
        });
        add(B_Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 60, 30, 30));

        search__box.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        search__box.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        search__box.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        search__box.setEnabled(false);
        search__box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search__boxActionPerformed(evt);
            }
        });
        add(search__box, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 60, 300, 30));

        Topic3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Topic3.setText("วันที่ :");
        add(Topic3, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 60, -1, 30));
    }// </editor-fold>//GEN-END:initComponents
    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        // TODO add your handling code here:
        int index = jTable.getSelectedRow();
        position = index;
    }//GEN-LAST:event_jTableMouseClicked

    private void back_button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_button1MouseClicked
        Home homePage = new Home();
        homePage.setVisible(true);
        JFrame thisFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        thisFrame.dispose();
    }//GEN-LAST:event_back_button1MouseClicked

    private void search__boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search__boxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search__boxActionPerformed

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
    
    public void showProductsInTable()
    {
        ArrayList<SalesReport> salessList = getProductsList();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        
        model.setRowCount(0);
        
        Object[] row = new Object[6];
        
        for(int i = 0; i < salessList.size(); i++)
        {
            row[0] = salessList.get(i).getDate();
            row[1] = salessList.get(i).getId();
            row[2] = salessList.get(i).getName();
            row[3] = salessList.get(i).getCategory();
            row[4] = salessList.get(i).getQuantity();
            row[5] = salessList.get(i).getPrice();
            
            model.addRow(row);
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel B_Date;
    private javax.swing.JLabel Topic;
    private javax.swing.JLabel Topic3;
    private javax.swing.JLabel back_button1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField search__box;
    // End of variables declaration//GEN-END:variables
}
