package component;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.raven.datechooser.DateBetween;
import com.raven.datechooser.DateChooser;
import com.raven.datechooser.listener.DateChooserAction;
import com.raven.datechooser.listener.DateChooserAdapter;
import raven.cell.TableActionCellEditorView;
import raven.cell.TableActionCellRenderView;
import raven.cell.TableActionEventView;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.swing.table.DefaultTableModel;
import karnkha.DB;
import karnkha.RepairRequest;

public class Repair_History extends javax.swing.JPanel {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    private DateChooser chDate = new DateChooser();
    private DefaultTableModel model;
    
    public Repair_History() {
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
                loadData("SELECT * FROM `requestpaid` WHERE `Date` BETWEEN '" + dateFrom + "' AND '" + toDate + "'");
                mergeAndRefreshTable();
                model.fireTableDataChanged();
            }
        });
                try{
            DB.getInstance().getConnection();
        } catch (Exception e) {
            System.err.println(e);
            }
                
        con = DB.mycon();
        showRequestInTable();
        
        TableActionEventView event = new TableActionEventView() {
            @Override
            public void onView(int row) {
            System.out.println("Edit row : " + row);
            String date = jTable.getValueAt(row, 1).toString();
            String company = jTable.getValueAt(row, 2).toString();

            String query = "SELECT * FROM requestpaid WHERE `Date` = ? AND `Name` = ?";
            try {
                Connection connection = DB.mycon();
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, date);
                statement.setString(2, company);
                ResultSet resultSet = statement.executeQuery();

                DefaultTableModel model = new DefaultTableModel();
                Table_Order_Record1.setModel(model);

                model.addColumn("No");
                model.addColumn("PId");
                model.addColumn("Pname");
                model.addColumn("Category");
                model.addColumn("Quantity");
                model.addColumn("Price");

                double totalAmount = 0.0;
                int rowCount = 1;

                while (resultSet.next()) {
                    String pid = resultSet.getString("PId");
                    String pname = resultSet.getString("Pname");
                    String category = resultSet.getString("Category");
                    String quantity = resultSet.getString("Quantity");
                    String price = resultSet.getString("Price");
                    String total = resultSet.getString("Total");

                    Object[] rowData = {
                        rowCount, 
                        pid,
                        pname,
                        category,
                        quantity,
                        price,
                        total
                    };
                    model.addRow(rowData);
                    rowCount++; 


                    totalAmount = Double.parseDouble(total);
                }

                txtTotal.setText(Double.toString(totalAmount));

                resultSet.close();
                statement.close();
                connection.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            jFrame1.setVisible(true);
            Table_Order_Record1.setDefaultEditor(Object.class, null);
        }


        };
        jTable.getColumnModel().getColumn(8).setCellRenderer(new TableActionCellRenderView());
        jTable.getColumnModel().getColumn(8).setCellEditor(new TableActionCellEditorView(event));
        mergeAndRefreshTable();
    }

    private void loadData(String sql) {
        try {
            model.setRowCount(0);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            DecimalFormat f = new DecimalFormat("$ #,##0.##");
            PreparedStatement p = DB.getInstance().getConnection().prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while (r.next()) {
            String No = r.getString("No");
            String Date = r.getString("Date");
            String Name = r.getString("Name");
            String Phone = f.format(r.getDouble("Phone"));
            String Item = r.getString("Item");
            String ID = r.getString("ID");
            String Repairman = r.getString("Repairman");
            String Status = r.getString("Status");
            
            model.addRow(new Object[] { No,Date,Name,Phone,Item,ID,Repairman,Status});

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

        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        Label_Aprices1 = new javax.swing.JLabel();
        Company_label = new javax.swing.JLabel();
        ScrollPane_Note = new javax.swing.JScrollPane();
        Table_Order_Record1 = new javax.swing.JTable();
        txtTotal = new javax.swing.JTextField();
        back_button1 = new javax.swing.JLabel();
        Topic = new javax.swing.JLabel();
        Topic3 = new javax.swing.JLabel();
        searchdata__box = new javax.swing.JTextField();
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

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(255, 255, 255));
        txtTotal.setFocusable(false);
        jPanel1.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 680, 110, -1));

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

        Topic3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Topic3.setText("วันที่ :");
        add(Topic3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 70, -1, 30));

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
        add(searchdata__box, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 70, 220, 30));

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

    private void searchdata__boxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchdata__boxFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_searchdata__boxFocusGained

    private void searchdata__boxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchdata__boxFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_searchdata__boxFocusLost

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
    private void mergeAndRefreshTable() {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        if (jTable != null && model != null) {
            int rowCount = model.getRowCount();
            HashMap<String, String[]> dateMap = new HashMap<>();

            for (int i = 0; i < rowCount; i++) {
                String name = model.getValueAt(i, 2).toString();
                String date = model.getValueAt(i, 1).toString(); 

                String key = name + date; 

                if (dateMap.containsKey(key)) {
                    String[] values = dateMap.get(key);
                    values[0] = String.valueOf(model.getValueAt(i, 3)); 
                    values[1] = String.valueOf(model.getValueAt(i, 4)); 
                    values[2] = String.valueOf(model.getValueAt(i, 5)); 
                    values[3] = String.valueOf(model.getValueAt(i, 6)); 
                    values[4] = String.valueOf(model.getValueAt(i, 7)); 
                } else {
                    String[] values = new String[5];
                    values[0] = String.valueOf(model.getValueAt(i, 3)); 
                    values[1] = String.valueOf(model.getValueAt(i, 4)); 
                    values[2] = String.valueOf(model.getValueAt(i, 5)); 
                    values[3] = String.valueOf(model.getValueAt(i, 6)); 
                    values[4] = String.valueOf(model.getValueAt(i, 7)); 
                    dateMap.put(key, values);
                }
            }

            model.setRowCount(0);
            int newRowNumber = 1;

            for (Map.Entry<String, String[]> entry : dateMap.entrySet()) {
                String key = entry.getKey();
                String[] values = entry.getValue();

                String name = key.substring(0, key.length() - 10); 
                String date = key.substring(key.length() - 10);

                Object[] rowData = new Object[]{newRowNumber++, date, name,  values[0], values[1], values[2], values[3], values[4]};
                model.addRow(rowData);
            }
 
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Company_label;
    private javax.swing.JLabel Label_Aprices1;
    private javax.swing.JScrollPane ScrollPane_Note;
    private javax.swing.JTable Table_Order_Record1;
    private javax.swing.JLabel Topic;
    private javax.swing.JLabel Topic3;
    private javax.swing.JLabel back_button1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField searchdata__box;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

}
