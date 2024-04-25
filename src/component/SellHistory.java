package component;

import com.formdev.flatlaf.FlatIntelliJLaf;
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
import karnkha.SalesInfo;

public class SellHistory extends javax.swing.JPanel {
    
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private DateChooser chDate = new DateChooser();
    private DefaultTableModel model;

    public SellHistory() {
        initComponents();
        chDate.setTextField(search__box);
        chDate.setDateSelectionMode(DateChooser.DateSelectionMode.BETWEEN_DATE_SELECTED);
        chDate.setDateFormat(new SimpleDateFormat("dd-MM-yyyy"));
        model = (DefaultTableModel)jTable.getModel();
        chDate.addActionDateChooserListener(new DateChooserAdapter() {
            @Override
            public void dateBetweenChanged(DateBetween db, DateChooserAction action) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String dateFrom = df.format(db.getFromDate());
                String toDate = df.format(db.getToDate());
                loadData("SELECT * FROM `sales` WHERE `Date` BETWEEN '" + dateFrom + "' AND '" + toDate + "'");
        
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
            String No = r.getString("No");
            String Id = r.getString("Id");
            String Date = r.getString("Date");
            String Name = r.getString("Name");
            String Category = r.getString("Category");
            String Quantity = f.format(r.getDouble("Quantity"));
            String Price = f.format(r.getDouble("Price"));
            
            model.addRow(new Object[] { No,Id, Date, Name,Category, Quantity, Price });
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
        Topic3 = new javax.swing.JLabel();
        search__box = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
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
        Topic.setText("ประวัติการซื้อสินค้า");
        add(Topic, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, -1, -1));

        Topic3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Topic3.setText("วันที่ :");
        add(Topic3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 60, -1, 30));

        search__box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search__boxActionPerformed(evt);
            }
        });
        add(search__box, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 60, 230, 30));

        jTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Date", "Product ID", "Product Name", "Category", "Quantity", "Price"
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
        jScrollPane3.setViewportView(jTable);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 1240, 520));
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
    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        // TODO add your handling code here:
        int index = jTable.getSelectedRow();
        position = index;
    }//GEN-LAST:event_jTableMouseClicked

    private void search__boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search__boxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search__boxActionPerformed

    ArrayList<SalesInfo> productsArray = new ArrayList<>();
    
    int position = 0;
    public ArrayList<SalesInfo> getProductsList()
    {
        ArrayList<SalesInfo> list = new ArrayList<>();
        String selectQuery = "SELECT * FROM `sales`";
        
        Statement st;
        ResultSet rs;
        
        try {
            st = DB.getConnection().createStatement();
            rs = st.executeQuery(selectQuery);
            SalesInfo product;
            
            while(rs.next())
            {
                product = new SalesInfo(rs.getInt("No"), rs.getInt("Id"),
                                      rs.getString("Date"), rs.getString("Name"), rs.getString("Category"),
                                      rs.getInt("Quantity"), rs.getDouble("Price"));
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
        ArrayList<SalesInfo> productsList = getProductsList();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        
        model.setRowCount(0);
        
        Object[] row = new Object[7];
        
        for(int i = 0; i < productsList.size(); i++)
        {
            row[0] = productsList.get(i).getNo();
            row[1] = productsList.get(i).getDate();
            row[2] = productsList.get(i).getId();
            row[3] = productsList.get(i).getName();
            row[4] = productsList.get(i).getCategory();
            row[5] = productsList.get(i).getQuantity();
            row[6] = productsList.get(i).getPrice();
            
            model.addRow(row);
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Topic;
    private javax.swing.JLabel Topic3;
    private javax.swing.JLabel back_button1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField search__box;
    // End of variables declaration//GEN-END:variables

}
