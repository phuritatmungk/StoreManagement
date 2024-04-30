package component;

import Com_Table.Table_OrderRec;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.raven.datechooser.DateBetween;
import com.raven.datechooser.DateChooser;
import com.raven.datechooser.listener.DateChooserAction;
import com.raven.datechooser.listener.DateChooserAdapter;
import java.awt.Component;
import raven.cell.TableActionCellEditorEdit;
import raven.cell.TableActionCellRenderEdit;
import raven.cell.TableActionEventEdit;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import karnkha.DB;
import karnkha.Main;
import karnkha.OrderReceivedInfo;

public class Order_Received extends javax.swing.JPanel {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    private DateChooser chDate = new DateChooser();
    private DefaultTableModel model;
    
    public Order_Received() {
        initComponents();
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
        TableActionEventEdit event = new TableActionEventEdit() {
            @Override
            public void onEdit(int row) {
                System.out.println("Edit row : " + row);
                jFrame2.setVisible(true);
            }

        };
        jTable.getColumnModel().getColumn(7).setCellRenderer(new TableActionCellRenderEdit());
        jTable.getColumnModel().getColumn(7).setCellEditor(new TableActionCellEditorEdit(event));
    }

     public void showForm(Component com) {
        body.add(com);
        body.repaint();
        body.revalidate();
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

            // เพิ่มข้อมูลใหม่เข้าไปในตาราง
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
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Table_Receive_Pro = new javax.swing.JTable();
        Btt_Calender = new javax.swing.JLabel();
        TextField_Date = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ComboBox_Type = new javax.swing.JComboBox<>();
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
        Field_type = new javax.swing.JTextField();
        ComboBox_Employee = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        btnAdd1 = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        Field_Product4 = new javax.swing.JTextField();
        jFrame2 = new javax.swing.JFrame();
        btnAdd2 = new javax.swing.JButton();
        btnDelete1 = new javax.swing.JButton();
        btnSave1 = new javax.swing.JButton();
        ComboBox_Type2 = new javax.swing.JComboBox<>();
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
        ComboBox_Type3 = new javax.swing.JComboBox<>();
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

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("บริษัทที่เป็นตัวแทนจำหน่าย :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 20, -1, -1));

        Table_Receive_Pro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No.", "Product", "Quantity", "Product Cost", "Product Type", "Total"
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

        ComboBox_Type.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ComboBox_Type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "123" }));
        jPanel1.add(ComboBox_Type, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 620, 210, 30));

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
        Field_Quantity.setText("0");
        jPanel1.add(Field_Quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 440, 210, -1));

        ComboBox_Company1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(ComboBox_Company1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 20, 180, 30));

        jScrollPane4.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jTextArea_Information.setEditable(false);
        jTextArea_Information.setColumns(20);
        jTextArea_Information.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextArea_Information.setLineWrap(true);
        jTextArea_Information.setRows(5);
        jScrollPane4.setViewportView(jTextArea_Information);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 560, 210, 100));

        Field_Cost.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Field_Cost.setText("0");
        jPanel1.add(Field_Cost, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 500, 210, -1));

        Field_type.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Field_type.setText("ประเภทสินค้า");
        jPanel1.add(Field_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 500, 210, -1));

        ComboBox_Employee.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ComboBox_Employee.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pongsapak" }));
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

        Field_Product4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Field_Product4.setText("ชื่อสินค้า");
        jPanel1.add(Field_Product4, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 440, 210, -1));

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

        ComboBox_Type2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ComboBox_Type2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1587" }));
        ComboBox_Type2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_Type2ActionPerformed(evt);
            }
        });
        jFrame2.getContentPane().add(ComboBox_Type2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 620, 210, 30));

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
        ComboBox_Employee1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pongsapak" }));
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

        ComboBox_Type3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ComboBox_Type3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ได่" }));
        jFrame2.getContentPane().add(ComboBox_Type3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 500, 210, 30));

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

        Table_Receive_Pro1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No.", "Product", "Quantity", "Product Cost", "Product Type", "All Prices"
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
        ComboBox_Company2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "บริษัทไก่", " " }));
        jFrame2.getContentPane().add(ComboBox_Company2, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 20, 180, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jFrame2.getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 800));

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
                "No", "Date", "Company Name", "Employee Id", "Recipient", "Quantity", "Total", ""
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
    }//GEN-LAST:event_Save_bt1MouseClicked

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        // TODO add your handling code here:
        int index = jTable.getSelectedRow();
        position = index;
    }//GEN-LAST:event_jTableMouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String name = Field_Product4.getText();
        String category = Field_type.getText();
        String company = ComboBox_Company2.getSelectedItem().toString();
        String recipient = ComboBox_Employee.getSelectedItem().toString();
        Integer id = Integer.valueOf(ComboBox_Type.getSelectedItem().toString());
        Double cost = Double.valueOf(Field_Cost.getText().toString());
        Integer quantity = Integer.valueOf(Field_Quantity.getText().toString());
        java.util.Date date = new java.util.Date();
        Double total = cost * quantity;
        String remark = jTextArea_Information.getText();
        
        String insertQuery = "INSERT INTO `orderreceived`(`Date`, `Company`, `Name`, `Category`, `Id`, `Recipient`, `Cost`, `Quantity`, `Total`, `Remark`) VALUES (?,?,?,?,?,?,?,?,?,?)";
        
        try {
                
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
            
            ps.setDate(1, new java.sql.Date(date.getTime()));
            ps.setString(2, company);
            ps.setString(3, name);
            ps.setString(4, category);
            ps.setInt(5, id);
            ps.setString(6, recipient);
            ps.setDouble(7, cost);
            ps.setInt(8, quantity);
            ps.setDouble(9, total);
            ps.setString(10, remark);
            
            if(ps.executeUpdate() > 0)
            {
                showProductsTable();
                jFrame1.dispose();
                JOptionPane.showMessageDialog(null, "New Order Added Successfully", "Add Order", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Added Complete");
            }
            else
            {
              JOptionPane.showMessageDialog(null, "Order Not Added", "Add Order", JOptionPane.ERROR_MESSAGE);
              System.out.println("Some Error Message Here");  
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }     
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
        String name = Field_Product4.getText();
        String category = Field_type.getText();
        String company = ComboBox_Company2.getSelectedItem().toString();
        String recipient = ComboBox_Employee.getSelectedItem().toString();
        Integer id = Integer.valueOf(ComboBox_Type.getSelectedItem().toString());
        Double cost = Double.valueOf(Field_Cost.getText().toString());
        Integer quantity = Integer.valueOf(Field_Quantity.getText().toString());
        java.util.Date date = new java.util.Date();
        Double total = cost * quantity;
        String remark = jTextArea_Information.getText();
        
        String insertQuery = "INSERT INTO `orderreceived`(`Date`, `Company`, `Name`, `Category`, `Id`, `Recipient`, `Cost`, `Quantity`, `Total`, `Remark`) VALUES (?,?,?,?,?,?,?,?,?,?)";
        
        try {
                
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
            
            ps.setDate(1, new java.sql.Date(date.getTime()));
            ps.setString(2, company);
            ps.setString(3, name);
            ps.setString(4, category);
            ps.setInt(5, id);
            ps.setString(6, recipient);
            ps.setDouble(7, cost);
            ps.setInt(8, quantity);
            ps.setDouble(9, total);
            ps.setString(10, remark);
            
            if(ps.executeUpdate() > 0)
            {
                showProductsInTable();
                JOptionPane.showMessageDialog(null, "New Order Added Successfully", "Add Order", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Added Complete");
            }
            else
            {
              JOptionPane.showMessageDialog(null, "Order Not Added", "Add Order", JOptionPane.ERROR_MESSAGE);
              System.out.println("Some Error Message Here");  
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }                     
    }//GEN-LAST:event_btnAdd1ActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAdd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd2ActionPerformed

    }//GEN-LAST:event_btnAdd2ActionPerformed

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDelete1ActionPerformed

    private void btnSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSave1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSave1ActionPerformed

    private void Field_Product3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Field_Product3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Field_Product3ActionPerformed

    private void ComboBox_Type2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_Type2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBox_Type2ActionPerformed

    private void Save_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Save_bt1ActionPerformed
       
    }//GEN-LAST:event_Save_bt1ActionPerformed

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
    
    public void showProductsInTable()
    {
        ArrayList<OrderReceivedInfo> productsList = getProductsList();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        
        model.setRowCount(0);
        
        Object[] row = new Object[7];
        
        for(int i = 0; i < productsList.size(); i++)
        {
            row[0] = productsList.get(i).getNo();
            row[1] = productsList.get(i).getName();
            row[2] = productsList.get(i).getQuantity();
            row[3] = productsList.get(i).getId();
            row[4] = productsList.get(i).getCost();
            row[5] = productsList.get(i).getCategory();
            row[6] = productsList.get(i).getTotal();
            
            model.addRow(row);
        }
        
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Btt_Calender;
    private javax.swing.JLabel Btt_Calender1;
    private javax.swing.JComboBox<String> ComboBox_Company1;
    private javax.swing.JComboBox<String> ComboBox_Company2;
    private javax.swing.JComboBox<String> ComboBox_Employee;
    private javax.swing.JComboBox<String> ComboBox_Employee1;
    private javax.swing.JComboBox<String> ComboBox_Type;
    private javax.swing.JComboBox<String> ComboBox_Type2;
    private javax.swing.JComboBox<String> ComboBox_Type3;
    private javax.swing.JTextField Field_Cost;
    private javax.swing.JTextField Field_Cost1;
    private javax.swing.JTextField Field_Product3;
    private javax.swing.JTextField Field_Product4;
    private javax.swing.JTextField Field_Quantity;
    private javax.swing.JTextField Field_Quantity1;
    private javax.swing.JTextField Field_type;
    private javax.swing.JButton Save_bt1;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JTable jTable;
    private javax.swing.JTextArea jTextArea_Information;
    private javax.swing.JTextArea jTextArea_Information1;
    private javax.swing.JTextField searchDate;
    // End of variables declaration//GEN-END:variables
}
