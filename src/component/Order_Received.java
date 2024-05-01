package component;

import Com_Table.Table_OrderRec;
import com.raven.datechooser.DateBetween;
import com.raven.datechooser.DateChooser;
import com.raven.datechooser.listener.DateChooserAction;
import com.raven.datechooser.listener.DateChooserAdapter;
import java.awt.Color;
import java.awt.Component;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import karnkha.DB;
import karnkha.Main;
import karnkha.OrderReceivedInfo;
import raven.cell.TableActionCellEditorEditView;
import raven.cell.TableActionCellRenderEditView;
import raven.cell.TableActionEventEditView;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Order_Received extends javax.swing.JPanel {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    private DateChooser chDate = new DateChooser();
    private DefaultTableModel model;
    
    public Order_Received() {
        initComponents();
        loadDistributor();
        loadEmployees();
        chDate.setTextField(searchDate);
        chDate.setDateSelectionMode(DateChooser.DateSelectionMode.BETWEEN_DATE_SELECTED);
        chDate.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        model = (DefaultTableModel)jTable.getModel();
        chDate.addActionDateChooserListener(new DateChooserAdapter() {
            @Override
            public void dateBetweenChanged(DateBetween db, DateChooserAction action) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String dateFrom = df.format(db.getFromDate());
                String toDate = df.format(db.getToDate());
                loadData("SELECT * FROM `orderreceived` WHERE `Date` BETWEEN '" + dateFrom + "' AND '" + toDate + "'");
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
        showProductsTable();
        TableActionEventEditView event = new TableActionEventEditView() {
            @Override
            public void onEdit(int row) {
               String date = jTable.getValueAt(row, 1).toString();
               String company = jTable.getValueAt(row, 2).toString();
               String id = jTable.getValueAt(row, 3).toString();
               String recipient = jTable.getValueAt(row, 4).toString();
               
                ComboBox_Company2.setSelectedItem(company);
                ComboBox_Employee1.setSelectedItem(recipient);
                ComboBox_ID1.setSelectedItem(id);
                chDate.setTextField(TextField_Date1);
                TextField_Date1.setText(date);
                chDate.setDateSelectionMode(DateChooser.DateSelectionMode.SINGLE_DATE_SELECTED);
                chDate.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
               
               String query = "SELECT * FROM `orderreceived` WHERE `Date` = ? AND `Company` = ? AND `Id` = ? AND `Recipient` = ?";
               try {
                   Connection connection = DB.mycon();
                   PreparedStatement statement = connection.prepareStatement(query);
                   statement.setString(1, date);
                   statement.setString(2, company);
                   statement.setString(3, id);
                   statement.setString(4, recipient);
                   ResultSet resultSet = statement.executeQuery();

                   DefaultTableModel model = new DefaultTableModel();
                   Table_Receive_Pro1.setModel(model);

                   model.addColumn("No");
                   model.addColumn("Name");
                   model.addColumn("Category");
                   model.addColumn("Quantity");
                   model.addColumn("Cost");
                   model.addColumn("Total");

                   int rowCount = 1;

                   while (resultSet.next()) {
                       String productName = resultSet.getString("Name");
                       String category = resultSet.getString("Category");
                       String quantity = resultSet.getString("Quantity");
                       String cost = resultSet.getString("Cost");
                       String total = resultSet.getString("Total");

                       Object[] rowData = {
                           rowCount,
                           productName,
                           category,
                           quantity,
                           cost,
                           total
                       };
                       model.addRow(rowData);
                       rowCount++; 
                   }

                   resultSet.close();
                   statement.close();
                   connection.close();
               } catch (SQLException ex) {
                   ex.printStackTrace();
               }
               jFrame2.setVisible(true);
               Table_Receive_Pro1.setDefaultEditor(Object.class, null); 
            }
            public void onView(int row) {
                System.out.println("Edit row : " + row);
                String date = jTable.getValueAt(row, 1).toString();
                String company = jTable.getValueAt(row, 2).toString();
                String id = jTable.getValueAt(row, 3).toString();
                String recipient = jTable.getValueAt(row, 4).toString();

                TextField_Date.setText(date);
                Company_Text.setText(company);
                Employee_Text.setText(recipient);
                EmployeeID_Text.setText(id);

                String query = "SELECT * FROM `orderreceived` WHERE `Date` = ? AND `Company` = ? AND `Id` = ? AND `Recipient` = ?";
                try {
                    Connection connection = DB.mycon();
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, date);
                    statement.setString(2, company);
                    statement.setString(3, id);
                    statement.setString(4, recipient);
                    ResultSet resultSet = statement.executeQuery();


                    double totalPrices = 0.0; 

                    DefaultTableModel model = new DefaultTableModel();
                    Table_Order_Recieved1.setModel(model);

                    model.addColumn("No");
                    model.addColumn("Name");
                    model.addColumn("Category");
                    model.addColumn("Quantity");
                    model.addColumn("Cost");
                    model.addColumn("Total");

                    Set<String> remarksSet = new HashSet<>(); 

                    int rowCount = 1; 

                    while (resultSet.next()) {
                        String productName = resultSet.getString("Name");
                        String category = resultSet.getString("Category");
                        String quantity = resultSet.getString("Quantity");
                        String cost = resultSet.getString("Cost");
                        String allPrices = resultSet.getString("Total");

                        double price = Double.parseDouble(allPrices);
                        totalPrices += price;

                        String remark = resultSet.getString("Remark");
                        remarksSet.add(remark);

                        Object[] rowData = {
                           rowCount, 
                           productName,
                           category,
                           quantity,
                           cost,
                           allPrices
                        };
                        model.addRow(rowData);
                        rowCount++; 
                    }

                    All_prices.setText(String.valueOf(totalPrices));

                    resultSet.close();
                    statement.close();
                    connection.close();

                    StringBuilder remarksBuilder = new StringBuilder();
                    for (String remark : remarksSet) {
                        remarksBuilder.append(remark).append("\n");
                    }

                    jTextArea_Information.setText(remarksBuilder.toString());

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                jFrame3.setVisible(true);
                Table_Order_Recieved1.setDefaultEditor(Object.class, null);

            }

        };
        jTable.getColumnModel().getColumn(7).setCellRenderer(new TableActionCellRenderEditView());
        jTable.getColumnModel().getColumn(7).setCellEditor(new TableActionCellEditorEditView(event));
        mergeAndRefreshTable();
        jFrame1.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                e.getWindow().dispose();
                Main.body.removeAll();
                Main.body.add(new Order_Received());
                Main.body.repaint();
                Main.body.revalidate();
            }
        });

        jFrame2.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                e.getWindow().dispose(); 
                Main.body.removeAll();
                Main.body.add(new Order_Received());
                Main.body.repaint();
                Main.body.revalidate();
            }
        });
    }

     public void showForm(Component com) {
        body.add(com);
        body.repaint();
        body.revalidate();
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
            String Company = r.getString("Company");
            String Name = r.getString("Name");
            String Category = r.getString("Category");
            String Id = r.getString("Id");
            String Cost = f.format(r.getDouble("Cost"));
            String Recipient = r.getString("Recipient");
            String Quantity = f.format(r.getDouble("Quantity"));
            String Total = f.format(r.getDouble("Total"));
            String Remark = r.getString("Remark");

            model.addRow(new Object[] { No,Date,Company,Name,Category,Id,Cost,Recipient,Quantity,Total,Remark});
            
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
        jSeparator11 = new javax.swing.JSeparator();
        body = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        ComboBox_Type = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Table_Receive_Pro = new javax.swing.JTable();
        Btt_Calender = new javax.swing.JLabel();
        TextField_Date = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ComboBox_ID = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Field_Quantity = new javax.swing.JTextField();
        ComboBox_Company1 = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea_Information = new javax.swing.JTextArea();
        Field_Cost = new javax.swing.JTextField();
        ComboBox_Employee = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        btnAdd1 = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        Field_Product1 = new javax.swing.JTextField();
        jFrame2 = new javax.swing.JFrame();
        btnAdd2 = new javax.swing.JButton();
        btnDelete1 = new javax.swing.JButton();
        btnSave1 = new javax.swing.JButton();
        ComboBox_ID1 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea_Information1 = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        ComboBox_Employee1 = new javax.swing.JComboBox<>();
        Field_Cost1 = new javax.swing.JTextField();
        Field_Quantity1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        ComboBox_Type1 = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        Field_Product3 = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        Table_Receive_Pro1 = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        Btt_Calender1 = new javax.swing.JLabel();
        TextField_Date1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        ComboBox_Company2 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jFrame3 = new javax.swing.JFrame();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea_Information2 = new javax.swing.JTextArea();
        ScrollPane_Note = new javax.swing.JScrollPane();
        Table_Order_Recieved1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        Label_Note = new javax.swing.JLabel();
        Label_Aprices1 = new javax.swing.JLabel();
        All_prices = new javax.swing.JLabel();
        Company_label = new javax.swing.JLabel();
        Company_Text = new javax.swing.JLabel();
        Date_Text = new javax.swing.JLabel();
        Date_label1 = new javax.swing.JLabel();
        Employee_Text = new javax.swing.JLabel();
        Company_label1 = new javax.swing.JLabel();
        EmployeeID_Text = new javax.swing.JLabel();
        Company_label2 = new javax.swing.JLabel();
        back_button1 = new javax.swing.JLabel();
        Topic = new javax.swing.JLabel();
        searchDate = new javax.swing.JTextField();
        Save_bt1 = new javax.swing.JButton();
        delete_bt = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        jFrame1.setSize(new java.awt.Dimension(1550, 800));
        jFrame1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator11.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator11.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSeparator11.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jFrame1.getContentPane().add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 10, 740));

        body.setBackground(new java.awt.Color(245, 245, 245));
        body.setPreferredSize(new java.awt.Dimension(590, 800));
        body.setLayout(new java.awt.BorderLayout());
        jFrame1.getContentPane().add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 800));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1550, 800));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ComboBox_Type.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ComboBox_Type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ประเภทสินค้า" }));
        jPanel1.add(ComboBox_Type, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 500, 210, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("บริษัทที่เป็นตัวแทนจำหน่าย :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 20, -1, -1));

        Table_Receive_Pro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Table_Receive_Pro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Product", "Category", "Quantity", "Cost", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table_Receive_Pro.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(Table_Receive_Pro);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, 920, 350));

        Btt_Calender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/calendar.png"))); // NOI18N
        jPanel1.add(Btt_Calender, new org.netbeans.lib.awtextra.AbsoluteConstraints(1075, 25, -1, -1));

        TextField_Date.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TextField_Date.setText("DD/MM/YYYY");
        jPanel1.add(TextField_Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 20, 150, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("หมายเหตุ :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 560, -1, -1));

        ComboBox_ID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ComboBox_ID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "เลือกรหัสพนักงาน" }));
        jPanel1.add(ComboBox_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 620, 210, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("วันเวลาทีรับสินค้า :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 20, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("รหัสพนักงาน :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 620, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("ประเภทสินค้า :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 500, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("ชื่อสินค้า :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 440, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("จำนวนสินค้า :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 440, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("ราคาต้นทุนสินค้า :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 500, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("พนักงานรับสินค้า :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 560, -1, -1));

        Field_Quantity.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Field_Quantity.setForeground(new java.awt.Color(123, 123, 123));
        Field_Quantity.setText("0");
        Field_Quantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Field_QuantityFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Field_QuantityFocusLost(evt);
            }
        });
        Field_Quantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Field_QuantityKeyReleased(evt);
            }
        });
        jPanel1.add(Field_Quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 440, 210, -1));

        ComboBox_Company1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ComboBox_Company1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "เลือกบริษัท" }));
        jPanel1.add(ComboBox_Company1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 20, 180, 30));

        jScrollPane4.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jTextArea_Information.setColumns(20);
        jTextArea_Information.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextArea_Information.setLineWrap(true);
        jTextArea_Information.setRows(5);
        jScrollPane4.setViewportView(jTextArea_Information);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 560, 210, 100));

        Field_Cost.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Field_Cost.setForeground(new java.awt.Color(123, 123, 123));
        Field_Cost.setText("0");
        Field_Cost.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Field_CostFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Field_CostFocusLost(evt);
            }
        });
        Field_Cost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Field_CostKeyReleased(evt);
            }
        });
        jPanel1.add(Field_Cost, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 500, 210, -1));

        ComboBox_Employee.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ComboBox_Employee.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "เลือกพนักงาน" }));
        jPanel1.add(ComboBox_Employee, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 560, 210, 30));

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnSave.setText("บันทึก");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 690, 170, 50));

        btnAdd1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnAdd1.setText("เพิ่ม");
        btnAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 690, 170, 50));

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnDelete.setText("ลบ");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 690, 170, 50));

        Field_Product1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Field_Product1.setForeground(new java.awt.Color(123, 123, 123));
        Field_Product1.setText("ชื่อสินค้า");
        Field_Product1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Field_Product1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Field_Product1FocusLost(evt);
            }
        });
        jPanel1.add(Field_Product1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 440, 210, -1));

        jFrame1.getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1550, 800));

        jFrame2.setSize(new java.awt.Dimension(1200, 800));
        jFrame2.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAdd2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnAdd2.setText("เพิ่ม");
        btnAdd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd2ActionPerformed(evt);
            }
        });
        jFrame2.getContentPane().add(btnAdd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 680, 170, 50));

        btnDelete1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnDelete1.setText("ลบ");
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });
        jFrame2.getContentPane().add(btnDelete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 680, 170, 50));

        btnSave1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnSave1.setText("บันทึก");
        btnSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSave1ActionPerformed(evt);
            }
        });
        jFrame2.getContentPane().add(btnSave1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 680, 170, 50));

        ComboBox_ID1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ComboBox_ID1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "เลือกรหัสพนักงาน" }));
        ComboBox_ID1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_ID1ActionPerformed(evt);
            }
        });
        jFrame2.getContentPane().add(ComboBox_ID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 620, 210, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("รหัสพนักงาน :");
        jFrame2.getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 620, -1, -1));

        jScrollPane5.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jTextArea_Information1.setEditable(false);
        jTextArea_Information1.setColumns(20);
        jTextArea_Information1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextArea_Information1.setLineWrap(true);
        jTextArea_Information1.setRows(5);
        jScrollPane5.setViewportView(jTextArea_Information1);

        jFrame2.getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 560, 210, 100));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("หมายเหตุ :");
        jFrame2.getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 560, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("พนักงานรับสินค้า :");
        jFrame2.getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 560, -1, -1));

        ComboBox_Employee1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ComboBox_Employee1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "เลือกพนักงาน" }));
        jFrame2.getContentPane().add(ComboBox_Employee1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 560, 210, 30));

        Field_Cost1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Field_Cost1.setText("0");
        jFrame2.getContentPane().add(Field_Cost1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 500, 210, -1));

        Field_Quantity1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Field_Quantity1.setText("0");
        jFrame2.getContentPane().add(Field_Quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 440, 210, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("จำนวนสินค้า :");
        jFrame2.getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 440, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("ราคาต้นทุนสินค้า :");
        jFrame2.getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 500, -1, -1));

        ComboBox_Type1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ComboBox_Type1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ประเภทสินค้า" }));
        jFrame2.getContentPane().add(ComboBox_Type1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 500, 210, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("ประเภทสินค้า :");
        jFrame2.getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 500, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("ชื่อสินค้า :");
        jFrame2.getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 440, -1, -1));

        Field_Product3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Field_Product3.setText("ชื่อสินค้า");
        Field_Product3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Field_Product3ActionPerformed(evt);
            }
        });
        jFrame2.getContentPane().add(Field_Product3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 440, 210, -1));

        Table_Receive_Pro1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Table_Receive_Pro1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No.", "Product", "Category", "Quantity", "Cost", "All Prices"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table_Receive_Pro1.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(Table_Receive_Pro1);

        jFrame2.getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 1110, 350));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setText("วันเวลาทีรับสินค้า :");
        jFrame2.getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));

        Btt_Calender1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/calendar.png"))); // NOI18N
        jFrame2.getContentPane().add(Btt_Calender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(705, 25, -1, -1));

        TextField_Date1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TextField_Date1.setText("DD/MM/YYYY");
        jFrame2.getContentPane().add(TextField_Date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 150, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("บริษัทที่เป็นตัวแทนจำหน่าย :");
        jFrame2.getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, -1, -1));

        ComboBox_Company2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ComboBox_Company2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "เลือกบริษัท", " " }));
        jFrame2.getContentPane().add(ComboBox_Company2, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 20, 180, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jFrame2.getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 800));

        jFrame3.setSize(new java.awt.Dimension(1550, 800));
        jFrame3.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane7.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jTextArea_Information2.setEditable(false);
        jTextArea_Information2.setColumns(20);
        jTextArea_Information2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextArea_Information2.setLineWrap(true);
        jTextArea_Information2.setRows(5);
        jScrollPane7.setViewportView(jTextArea_Information2);

        jFrame3.getContentPane().add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 660, 370, 80));

        Table_Order_Recieved1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Table_Order_Recieved1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No.", "Product", "Category", "Quantity", "Cost", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table_Order_Recieved1.getTableHeader().setReorderingAllowed(false);
        ScrollPane_Note.setViewportView(Table_Order_Recieved1);

        jFrame3.getContentPane().add(ScrollPane_Note, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 1440, 550));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Label_Note.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Label_Note.setText("หมายเหตุ :");
        jPanel3.add(Label_Note, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 660, -1, -1));

        Label_Aprices1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Label_Aprices1.setText("ราคาสินค้าทั้งหมด :");
        jPanel3.add(Label_Aprices1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 620, -1, -1));

        All_prices.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        All_prices.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        All_prices.setText("00.00");
        jPanel3.add(All_prices, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 620, 250, -1));

        Company_label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Company_label.setText("บริษัท : ");
        jPanel3.add(Company_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        Company_Text.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel3.add(Company_Text, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 200, -1));

        Date_Text.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel3.add(Date_Text, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 110, -1));

        Date_label1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Date_label1.setText("วันที่ : ");
        jPanel3.add(Date_label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        Employee_Text.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel3.add(Employee_Text, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 615, 200, 30));

        Company_label1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Company_label1.setText("พนักงานรับสินค้า :");
        jPanel3.add(Company_label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 620, -1, -1));

        EmployeeID_Text.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel3.add(EmployeeID_Text, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 615, 200, 30));

        Company_label2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Company_label2.setText("รหัสพนักงาน :");
        jPanel3.add(Company_label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 620, -1, -1));

        jFrame3.getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1550, 800));

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back_button1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        back_button1.setForeground(new java.awt.Color(139, 139, 139));
        back_button1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        back_button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back-button.png"))); // NOI18N
        add(back_button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 60));

        Topic.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Topic.setText("รับสินค้าตามรายการสั่งซื้อ");
        add(Topic, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, -1, -1));

        searchDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        searchDate.setForeground(new java.awt.Color(123, 123, 123));
        searchDate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        searchDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchDateActionPerformed(evt);
            }
        });
        add(searchDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 50, 290, 30));

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("วันที่ :");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 50, -1, 30));

        jTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Date", "Company", "Employee ID", "Recipient", "Quantity", "Total", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
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

    private void searchDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchDateActionPerformed

    private void delete_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btActionPerformed
     int selectedRow = jTable.getSelectedRow(); 
    if(selectedRow != -1) { 
        int id = (int) jTable.getValueAt(selectedRow, 0); 
        if(id > 0) { 
            String deleteQuery = "DELETE FROM orderreceived WHERE No=?";
            try {
                PreparedStatement ps = DB.getConnection().prepareStatement(deleteQuery);
                ps.setInt(1, id);
                int deletedRows = ps.executeUpdate(); 
                if(deletedRows > 0) { 
                    DefaultTableModel model = (DefaultTableModel) jTable.getModel(); 
                    model.removeRow(selectedRow); 
                    JOptionPane.showMessageDialog(null, "Product Deleted Successfully", "Remove Product", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to delete product", "Remove Product", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                System.out.println("Failed to remove product: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Product Not Deleted, Make Sure The ID is Valid", "Remove Product", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(null, "Please select a row to delete", "Remove Product", JOptionPane.ERROR_MESSAGE);
    }     
    }//GEN-LAST:event_delete_btActionPerformed

    private void Save_bt1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Save_bt1MouseClicked
        jFrame1.setVisible(true);
        showForm(new Table_OrderRec());
        chDate.setTextField(TextField_Date);
        chDate.setDateSelectionMode(DateChooser.DateSelectionMode.SINGLE_DATE_SELECTED);
        chDate.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
    }//GEN-LAST:event_Save_bt1MouseClicked

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        int index = jTable.getSelectedRow();
        position = index;
    }//GEN-LAST:event_jTableMouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
       if (Table_Receive_Pro.getRowCount() == 0) {
           JOptionPane.showMessageDialog(null, "ไม่มีข้อมูลในตารางที่จะบันทึก", "ข้อผิดพลาด", JOptionPane.ERROR_MESSAGE);
           return;
       }
       String company2 = ComboBox_Company1.getSelectedItem().toString();
       if(company2.equals("เลือกบริษัท")) {
           JOptionPane.showMessageDialog(null, "You must select distributor", "Error", JOptionPane.WARNING_MESSAGE);
       } else {
            String insertQuery = "INSERT INTO `orderreceived`(`Date`, `Company`, `Name`, `id`, `Category`, `Recipient`, `Cost`, `Quantity`, `Total`, `Remark`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            String updateQuery = "UPDATE `orderreceived` SET `Name` = ?, `Company` = ?, `Id` = ?, `Recipient` = ?, `Remark` = ? WHERE `Date` = ? AND `Name` = ? AND `Company` = ?";

            try {
                Connection con = DB.mycon();
                PreparedStatement psInsert = con.prepareStatement(insertQuery);
                PreparedStatement psUpdate = con.prepareStatement(updateQuery);

                for (int i = 0; i < Table_Receive_Pro.getRowCount(); i++) {
                    String date = TextField_Date.getText();
                    String company = ComboBox_Company1.getSelectedItem().toString(); 
                    String name = Table_Receive_Pro.getValueAt(i, 1).toString();
                    String id = ComboBox_ID.getSelectedItem().toString();
                    String recipient = ComboBox_Employee.getSelectedItem().toString();
                    String category = Table_Receive_Pro.getValueAt(i, 2).toString();
                    Integer quantity = Integer.parseInt(Table_Receive_Pro.getValueAt(i, 3).toString());
                    Double cost = Double.parseDouble(Table_Receive_Pro.getValueAt(i, 4).toString());   
                    Double total = Double.parseDouble(Table_Receive_Pro.getValueAt(i, 5).toString());
                    String remark = jTextArea_Information.getText(); 

                    if (isDataExists(date, company, name, con)) {
                        psUpdate.setString(1, company);
                        psUpdate.setString(2, id);
                        psUpdate.setString(3, recipient);
                        psUpdate.setString(4, remark);
                        psUpdate.setString(5, date);
                        psUpdate.setString(6, name);
                        psUpdate.setString(7, company);
                        psUpdate.executeUpdate();
                    } else {
                        psInsert.setString(1, date); 
                        psInsert.setString(2, company);
                        psInsert.setString(3, name);
                        psInsert.setString(4, id);
                        psInsert.setString(5, category);
                        psInsert.setString(6, recipient);
                        psInsert.setDouble(7, cost);
                        psInsert.setInt(8, quantity);
                        psInsert.setDouble(9, total);
                        psInsert.setString(10, remark);
                        psInsert.executeUpdate();
                    }
                }

                jFrame1.setVisible(false);
                Main.body.removeAll();
                Main.body.add(new Order_Received());
                Main.body.repaint();
                Main.body.revalidate();
                JOptionPane.showMessageDialog(null, "บันทึกข้อมูลเรียบร้อยแล้ว", "บันทึกข้อมูล", JOptionPane.INFORMATION_MESSAGE);

                psInsert.close();
                psUpdate.close();
                con.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
       }
    }//GEN-LAST:event_btnSaveActionPerformed

    private boolean isDataExists(String date, String company, String name, Connection con) throws SQLException {
            String text = TextField_Date.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date textFieldAsDate = null;
            try{
                textFieldAsDate = sdf.parse(text);
                
            }
            catch(ParseException pe){
                
            }
            java.sql.Date date2 = java.sql.Date.valueOf(sdf.format(textFieldAsDate));
            String checkQuery = "SELECT * FROM `orderreceived` WHERE `Date` = ? AND `Company` = ? AND `Name` = ?";
            PreparedStatement psCheck = con.prepareStatement(checkQuery);
            psCheck.setDate(1, date2);
            psCheck.setString(2, company);
            psCheck.setString(3, name);
            ResultSet rs = psCheck.executeQuery();
            boolean exists = rs.next();
            rs.close();
            psCheck.close();
            return exists;
}
    
    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
        if (checkEmptyFields()) {
            String name = Field_Product1.getText();
            String category = ComboBox_Type.getSelectedItem().toString();
            Double cost = Double.valueOf(Field_Cost.getText());
            Integer quantity = Integer.valueOf(Field_Quantity.getText());

            Double total = cost * quantity;
            String remark = jTextArea_Information.getText();

            DefaultTableModel model = (DefaultTableModel) Table_Receive_Pro.getModel();
            Object[] rowData = new Object[]{model.getRowCount() + 1, name, category, quantity, cost, total, remark};
            model.addRow(rowData);

            Field_Product1.setText("ชื่อสินค้า");
            ComboBox_Type.setSelectedIndex(0);
            Field_Cost.setText("0");
            Field_Quantity.setText("0");
            jTextArea_Information.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "You must insert all fields", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAdd1ActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int selectedRow = Table_Receive_Pro.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) Table_Receive_Pro.getModel();
            model.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(null, "โปรดเลือกแถวที่ต้องการลบ", "ลบแถว", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAdd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd2ActionPerformed
       String name = Field_Product3.getText();
        String category = ComboBox_Type1.getSelectedItem().toString();
        String costText = Field_Cost1.getText();
        String quantityText = Field_Quantity1.getText();

        if (name.isEmpty() || category.isEmpty() || costText.isEmpty() || quantityText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "กรุณากรอกข้อมูลให้ครบทุกฟิลด์", "ข้อผิดพลาด", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Double cost;
        try {
            cost = Double.valueOf(costText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "กรุณากรอกราคาให้เป็นตัวเลข", "ข้อผิดพลาด", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Integer quantity;
        try {
            quantity = Integer.valueOf(quantityText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "กรุณากรอกจำนวนให้เป็นตัวเลขจำนวนเต็ม", "ข้อผิดพลาด", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Double total = cost * quantity;
        String remark = jTextArea_Information1.getText();
        

        try {
            Connection con = DB.mycon();

            String updateAllQuery = "UPDATE `orderreceived` SET `Date` = ?, `Company` = ?, `Id` = ?, `Recipient` = ?, `Remark` = ? WHERE `Date` IS NOT NULL AND `Company` IS NOT NULL AND `Id` IS NOT NULL AND `Recipient` IS NOT NULL AND `Remark` IS NOT NULL";
            PreparedStatement psUpdateAll = con.prepareStatement(updateAllQuery);
            psUpdateAll.setString(1, TextField_Date1.getText());
            psUpdateAll.setString(2, ComboBox_Company2.getSelectedItem().toString());
            psUpdateAll.setString(3, ComboBox_ID1.getSelectedItem().toString());
            psUpdateAll.setString(4, ComboBox_Employee1.getSelectedItem().toString());
            psUpdateAll.setString(5, remark);
            psUpdateAll.executeUpdate(); // สั่งให้อัปเดตแถว

            String insertQuery = "INSERT INTO `orderreceived`(`Date`, `Company`, `Name`, `id`, `Category`, `Recipient`, `Cost`, `Quantity`, `Total`, `Remark`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement psInsert = con.prepareStatement(insertQuery);
            psInsert.setString(1, TextField_Date1.getText());
            psInsert.setString(2, ComboBox_Company2.getSelectedItem().toString());
            psInsert.setString(3, name);
            psInsert.setString(4, ComboBox_ID1.getSelectedItem().toString());
            psInsert.setString(5, category);
            psInsert.setString(6, ComboBox_Employee1.getSelectedItem().toString());
            psInsert.setDouble(7, cost);
            psInsert.setInt(8, quantity);
            psInsert.setDouble(9, total);
            psInsert.setString(10, remark);
            psInsert.executeUpdate(); // สั่งให้เพิ่มข้อมูลใหม่
            
            DefaultTableModel model = (DefaultTableModel) Table_Receive_Pro1.getModel();
            Object[] rowData = new Object[]{model.getRowCount() + 1, name, category, quantity, cost,  total, remark};
            model.addRow(rowData);

            Field_Product3.setText("");
            ComboBox_Type1.setSelectedIndex(0);
            Field_Cost1.setText("");
            Field_Quantity1.setText("");
            jTextArea_Information1.setText("");

            psInsert.close();
            psUpdateAll.close();
            con.close();
           Main.body.removeAll();
           Main.body.add(new Order_Received());
           Main.body.repaint();
           Main.body.revalidate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnAdd2ActionPerformed

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
        int selectedRow = Table_Receive_Pro1.getSelectedRow(); 
        if(selectedRow != -1) { 
            String product = (String)Table_Receive_Pro1.getValueAt(selectedRow, 1); 
            String company = (String)Table_Receive_Pro1.getValueAt(selectedRow, 2); 
            System.out.println(product);
                String deleteQuery = "DELETE FROM `orderreceived` WHERE `Name` = ? AND `Category` = ? ";
                try {
                    PreparedStatement ps = DB.getConnection().prepareStatement(deleteQuery);
                    ps.setString(1, product);
                    ps.setString(2, company);
                    int deletedRows = ps.executeUpdate(); 
                    if(deletedRows > 0) { 
                        DefaultTableModel model = (DefaultTableModel) Table_Receive_Pro1.getModel(); 
                        model.removeRow(selectedRow); 
                        JOptionPane.showMessageDialog(null, "Product Deleted Successfully", "Remove Product", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to delete product", "Remove Product", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    System.out.println("Failed to remove product: " + ex.getMessage());
                }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to delete", "Remove Product", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDelete1ActionPerformed

    private void btnSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSave1ActionPerformed
        jFrame2.setVisible(false);
        try {
        Connection con = DB.mycon();

        String updateAllQuery = "UPDATE `orderreceived` SET `Date` = ?, `Company` = ?, `Id` = ?, `Recipient` = ?, `Remark` = ? WHERE `Date` IS NOT NULL AND `Company` IS NOT NULL AND `Id` IS NOT NULL AND `Recipient` IS NOT NULL AND `Remark` IS NOT NULL";
        PreparedStatement psUpdateAll = con.prepareStatement(updateAllQuery);
        psUpdateAll.setString(1, TextField_Date1.getText());
        psUpdateAll.setString(2, ComboBox_Company2.getSelectedItem().toString());
        psUpdateAll.setString(3, ComboBox_ID1.getSelectedItem().toString());
        psUpdateAll.setString(4, ComboBox_Employee1.getSelectedItem().toString());
        psUpdateAll.setString(5, jTextArea_Information1.getText());
        psUpdateAll.executeUpdate(); 

        psUpdateAll.close();
        con.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        Main.body.removeAll();
        Main.body.add(new Order_Received());
        Main.body.repaint();
        Main.body.revalidate();
        JOptionPane.showMessageDialog(null, "บันทึกข้อมูลเรียบร้อยแล้ว", "บันทึกข้อมูล", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnSave1ActionPerformed

    private void Field_Product3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Field_Product3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Field_Product3ActionPerformed

    private void ComboBox_ID1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_ID1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBox_ID1ActionPerformed

    private void Save_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Save_bt1ActionPerformed
       
    }//GEN-LAST:event_Save_bt1ActionPerformed

    private void Field_Product1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Field_Product1FocusGained
        if (Field_Product1.getText().equals("ชื่อสินค้า"))
        {
            Field_Product1.setText("");
            Field_Product1.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_Field_Product1FocusGained

    private void Field_Product1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Field_Product1FocusLost
        if (Field_Product1.getText ().length() ==0){
            Field_Product1.setText ("ชื่อสินค้า") ;
            Field_Product1.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_Field_Product1FocusLost

    private void Field_QuantityFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Field_QuantityFocusGained
        if (Field_Quantity.getText().equals("0"))
        {
            Field_Quantity.setText("");
            Field_Quantity.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_Field_QuantityFocusGained

    private void Field_QuantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Field_QuantityFocusLost
        if (Field_Quantity.getText ().length() ==0){
            Field_Quantity.setText ("0") ;
            Field_Quantity.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_Field_QuantityFocusLost

    private void Field_QuantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Field_QuantityKeyReleased
        String text = Field_Quantity.getText();
        
        if (!isNumeric(text)) {
            evt.consume();
            return;
        }
        else {
            JOptionPane.showMessageDialog(null, "Quantity value must contain only numbers", "Error", JOptionPane.WARNING_MESSAGE);
            Field_Quantity.setText("");
        }
    }//GEN-LAST:event_Field_QuantityKeyReleased

    private void Field_CostFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Field_CostFocusGained
        if (Field_Cost.getText().equals("0"))
        {
            Field_Cost.setText("");
            Field_Cost.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_Field_CostFocusGained

    private void Field_CostFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Field_CostFocusLost
        if (Field_Cost.getText ().length() ==0){
            Field_Cost.setText ("0") ;
            Field_Cost.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_Field_CostFocusLost

    private void Field_CostKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Field_CostKeyReleased
        try {
        String text = Field_Cost.getText();

            if (!isNumericOrDecimal(text)) {

                evt.consume();
                return;
            }

            Double.valueOf(text);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Cost value must contain only numbers", "Error", JOptionPane.WARNING_MESSAGE);
            Field_Cost.setText("");
        }
    }//GEN-LAST:event_Field_CostKeyReleased

    ArrayList<OrderReceivedInfo> productsArray = new ArrayList<>();
    
    int position = 0;
    public ArrayList<OrderReceivedInfo> getProductsList()
    {
        ArrayList<OrderReceivedInfo> list = new ArrayList<>();
        String selectQuery = "SELECT * FROM `orderreceived`";
        
        Statement st;
        ResultSet rs;
        
        try {
            st = DB.getConnection().createStatement();
            rs = st.executeQuery(selectQuery);
            OrderReceivedInfo product;
            
            while(rs.next())
            {
                product = new OrderReceivedInfo(rs.getInt("No"), rs.getString("Date"), rs.getString("Company"),
                                      rs.getString("Name"), rs.getString("Category"), rs.getInt("Id"), rs.getDouble("Cost"), rs.getString("Recipient"),
                                      rs.getInt("Quantity"), rs.getDouble("Total"), rs.getString("Remark"));
                list.add(product);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        productsArray = list;
        return list;
        
    }   
    
         public void showProductsTable()
    {
        ArrayList<OrderReceivedInfo> productsList = getProductsList();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        
        model.setRowCount(0);
        
        Object[] row = new Object[7];
        
        for(int i = 0; i < productsList.size(); i++)
        {
            row[0] = productsList.get(i).getNo();
            row[1] = productsList.get(i).getDate();
            row[2] = productsList.get(i).getCompany();
            row[3] = productsList.get(i).getId();
            row[4] = productsList.get(i).getRecipient();
            row[5] = productsList.get(i).getQuantity();
            row[6] = productsList.get(i).getTotal();
            
            model.addRow(row);
        }
    }
        
        public void loadEmployees() {
            try {
                String query = "SELECT Id, Fname FROM employee";
                PreparedStatement ps = DB.getConnection().prepareStatement(query);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    String employeeID = rs.getString("Id");
                    String employeeName = rs.getString("Fname");

                    ComboBox_ID.addItem(employeeID);
                    ComboBox_Employee.addItem(employeeName);
                    ComboBox_ID1.addItem(employeeID);
                    ComboBox_Employee1.addItem(employeeName);
                }

            } catch (SQLException ex) {
                System.out.println("Failed to load employees: " + ex.getMessage());
            }
        }
        
    public void loadDistributor() {
        try {
            String query = "SELECT Company FROM distributor";
            PreparedStatement ps = DB.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String distributor = rs.getString("Company");

                ComboBox_Company1.addItem(distributor);
                ComboBox_Company2.addItem(distributor);
            }

        } catch (SQLException ex) {
            System.out.println("Failed to load company: " + ex.getMessage());
        }
}
        
        
    private void mergeAndRefreshTable() {
    HashMap<String, OrderReceivedInfo> mergedRows = new HashMap<>();

        for (OrderReceivedInfo product : productsArray) {
            String key = product.getDate() + product.getCompany() + product.getId() + product.getRecipient();

            if (mergedRows.containsKey(key)) {
                OrderReceivedInfo mergedProduct = mergedRows.get(key);
                mergedProduct.setQuantity(mergedProduct.getQuantity() + product.getQuantity());
                mergedProduct.setTotal(mergedProduct.getTotal() + product.getTotal());
            } else {
                mergedRows.put(key, product);
            }
        }

        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);

        
        List<OrderReceivedInfo> sortedProducts = new ArrayList<>(mergedRows.values());
        sortedProducts.sort(Comparator.comparing(OrderReceivedInfo::getDate));

        int index = 1;
        for (OrderReceivedInfo mergedProduct : sortedProducts) {
            Object[] row = new Object[]{
                index++,
                mergedProduct.getDate(),
                mergedProduct.getCompany(),
                mergedProduct.getId(),
                mergedProduct.getRecipient(),
                mergedProduct.getQuantity(),
                mergedProduct.getTotal()
            };
            model.addRow(row);
        }

        model.fireTableDataChanged();
}
    private boolean isNumericOrDecimal(String input) {

        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c) && c != '.') {
                return true;
            }
        }
        return false;
    }   
    
    private boolean isNumeric(String input) {

        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }   
    
    public boolean checkEmptyFields() {
        String name = Field_Product1.getText().trim();
        String quantity = Field_Quantity.getText().trim();
        String cost = Field_Cost.getText().trim();
        String recipient = String.valueOf(ComboBox_Employee.getSelectedItem().toString());
        String category = String.valueOf(ComboBox_Type.getSelectedItem().toString());
        String remark = jTextArea_Information.getText().trim();
        String id = String.valueOf(ComboBox_ID.getSelectedItem().toString());
        
        if(name.equals("") || name.equals("ชื่อสินค้า") || quantity.equals("") || quantity.equals("0") || cost.equals("") || cost.equals("0") || recipient.equals("")
                || recipient.equals("เลือกพนักงาน")|| id.equals("") || id.equals("เลือกรหัสพนักงาน") || category.equals("ประเภทสินค้า") || remark.equals("")) {
            return false;
        }
        else {
          return true;    
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel All_prices;
    private javax.swing.JLabel Btt_Calender;
    private javax.swing.JLabel Btt_Calender1;
    private javax.swing.JComboBox<String> ComboBox_Company1;
    private javax.swing.JComboBox<String> ComboBox_Company2;
    private javax.swing.JComboBox<String> ComboBox_Employee;
    private javax.swing.JComboBox<String> ComboBox_Employee1;
    private javax.swing.JComboBox<String> ComboBox_ID;
    private javax.swing.JComboBox<String> ComboBox_ID1;
    private javax.swing.JComboBox<String> ComboBox_Type;
    private javax.swing.JComboBox<String> ComboBox_Type1;
    private javax.swing.JLabel Company_Text;
    private javax.swing.JLabel Company_label;
    private javax.swing.JLabel Company_label1;
    private javax.swing.JLabel Company_label2;
    private javax.swing.JLabel Date_Text;
    private javax.swing.JLabel Date_label1;
    private javax.swing.JLabel EmployeeID_Text;
    private javax.swing.JLabel Employee_Text;
    private javax.swing.JTextField Field_Cost;
    private javax.swing.JTextField Field_Cost1;
    private javax.swing.JTextField Field_Product1;
    private javax.swing.JTextField Field_Product3;
    private javax.swing.JTextField Field_Quantity;
    private javax.swing.JTextField Field_Quantity1;
    private javax.swing.JLabel Label_Aprices1;
    private javax.swing.JLabel Label_Note;
    private javax.swing.JButton Save_bt1;
    private javax.swing.JScrollPane ScrollPane_Note;
    private javax.swing.JTable Table_Order_Recieved1;
    private javax.swing.JTable Table_Receive_Pro;
    private javax.swing.JTable Table_Receive_Pro1;
    private javax.swing.JTextField TextField_Date;
    private javax.swing.JTextField TextField_Date1;
    private javax.swing.JLabel Topic;
    private javax.swing.JLabel back_button1;
    public static javax.swing.JPanel body;
    private javax.swing.JButton btnAdd1;
    private javax.swing.JButton btnAdd2;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSave1;
    private javax.swing.JButton delete_bt;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JFrame jFrame3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JTable jTable;
    private javax.swing.JTextArea jTextArea_Information;
    private javax.swing.JTextArea jTextArea_Information1;
    private javax.swing.JTextArea jTextArea_Information2;
    private javax.swing.JTextField searchDate;
    // End of variables declaration//GEN-END:variables
}
