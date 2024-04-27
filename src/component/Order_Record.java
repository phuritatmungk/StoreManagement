package component;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.raven.datechooser.DateBetween;
import com.raven.datechooser.DateChooser;
import com.raven.datechooser.listener.DateChooserAction;
import com.raven.datechooser.listener.DateChooserAdapter;
import com.raven.datechooser.listener.DateChooserListener;
import raven.cell.TableActionCellEditorEdit;

import java.sql.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import static java.time.Clock.system;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import karnkha.DB;
import karnkha.Main;
import karnkha.OrderInfo;
import com.raven.datechooser.*;
import raven.cell.TableActionCellEditorEditView;
import raven.cell.TableActionCellRenderEditView;
import raven.cell.TableActionEventEditView;


public class Order_Record extends javax.swing.JPanel {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private DateChooser chDate = new DateChooser();
    private DefaultTableModel model;
    
    public Order_Record() {
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
                loadData("SELECT * FROM `order` WHERE `Date` BETWEEN '" + dateFrom + "' AND '" + toDate + "'");
        
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
        TableActionEventEditView event = new TableActionEventEditView() {
            @Override
            public void onEdit(int row) {
                System.out.println("Edit row : " + row);
                jFrame2.setVisible(true);
                showProductsInTable2();
            }
            public void onView(int row) {
                System.out.println("Edit row : " + row);
                jFrame1.setVisible(true);
            }

        };
        jTable.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRenderEditView());
        jTable.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditorEditView(event));
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
            String Quantity = f.format(r.getDouble("Quantity"));
            String Total = f.format(r.getDouble("Total"));
            // เพิ่มข้อมูลใหม่เข้าไปในตาราง
            model.addRow(new Object[] { No, Date, Company, Quantity, Total });
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
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea_Information = new javax.swing.JTextArea();
        Label_Note = new javax.swing.JLabel();
        Label_Aprices1 = new javax.swing.JLabel();
        All_prices = new javax.swing.JLabel();
        ScrollPane_Note = new javax.swing.JScrollPane();
        Table_Order_Record1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        Company_label = new javax.swing.JLabel();
        Date_Text1 = new javax.swing.JLabel();
        Date_Text = new javax.swing.JLabel();
        Date_label1 = new javax.swing.JLabel();
        jFrame2 = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        Field_Quantity = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Btt_Calender = new javax.swing.JLabel();
        ComboBox_Type1 = new javax.swing.JComboBox<>();
        ComboBox_Company1 = new javax.swing.JComboBox<>();
        btnDelete = new javax.swing.JButton();
        Field_Cost = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea_Information1 = new javax.swing.JTextArea();
        btnAdd1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        Table_Receive_Pro = new javax.swing.JTable();
        Field_Product2 = new javax.swing.JTextField();
        TextField_Date = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jFrame3 = new javax.swing.JFrame();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnSave1 = new javax.swing.JButton();
        Field_Quantity1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Btt_Calender1 = new javax.swing.JLabel();
        ComboBox_Type2 = new javax.swing.JComboBox<>();
        ComboBox_Company2 = new javax.swing.JComboBox<>();
        btnDelete1 = new javax.swing.JButton();
        Field_Cost1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea_Information2 = new javax.swing.JTextArea();
        btnAdd2 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        Table_Receive_Pro1 = new javax.swing.JTable();
        Field_Product3 = new javax.swing.JTextField();
        TextField_Date1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        back_button1 = new javax.swing.JLabel();
        Topic = new javax.swing.JLabel();
        search__box = new javax.swing.JTextField();
        Save_bt1 = new javax.swing.JButton();
        delete_bt = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        jFrame1.setSize(new java.awt.Dimension(1550, 800));
        jFrame1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jTextArea_Information.setEditable(false);
        jTextArea_Information.setColumns(20);
        jTextArea_Information.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextArea_Information.setLineWrap(true);
        jTextArea_Information.setRows(5);
        jScrollPane4.setViewportView(jTextArea_Information);

        jFrame1.getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 660, 360, 80));

        Label_Note.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Label_Note.setText("หมายเหตุ :");
        jFrame1.getContentPane().add(Label_Note, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 660, -1, -1));

        Label_Aprices1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Label_Aprices1.setText("ราคาสินค้าทั้งหมด :");
        jFrame1.getContentPane().add(Label_Aprices1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 660, -1, -1));

        All_prices.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        All_prices.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        All_prices.setText("00.00");
        jFrame1.getContentPane().add(All_prices, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 660, 250, -1));

        Table_Order_Record1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No.", "Product", "Product Type", "Quantity", "Cost", "All Prices"
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

        jFrame1.getContentPane().add(ScrollPane_Note, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 1440, 590));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Company_label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Company_label.setText("บริษัท : ");
        jPanel1.add(Company_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        Date_Text1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Date_Text1.setText("ชื่อบริษัท");
        jPanel1.add(Date_Text1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 200, -1));

        Date_Text.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Date_Text.setText("DD/MM/YY");
        jPanel1.add(Date_Text, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 110, -1));

        Date_label1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Date_label1.setText("วันที่ : ");
        jPanel1.add(Date_label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        jFrame1.getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1550, 800));

        jFrame2.setSize(new java.awt.Dimension(1550, 800));
        jFrame2.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("บริษัทที่เป็นตัวแทนจำหน่าย :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 430, -1, -1));

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnSave.setText("บันทึก");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel2.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 650, 170, 50));

        Field_Quantity.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Field_Quantity.setText("0");
        jPanel2.add(Field_Quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 500, 210, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("จำนวนสินค้า :");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 500, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("ประเภทสินค้า :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 570, 110, -1));

        Btt_Calender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/calendar.png"))); // NOI18N
        jPanel2.add(Btt_Calender, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 435, -1, -1));

        ComboBox_Type1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ComboBox_Type1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ประเภทสินค้า" }));
        jPanel2.add(ComboBox_Type1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 570, 210, 30));

        ComboBox_Company1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ComboBox_Company1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Test", "asd" }));
        jPanel2.add(ComboBox_Company1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 430, 210, 30));

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnDelete.setText("ลบ");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 650, 170, 50));

        Field_Cost.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Field_Cost.setText("0");
        jPanel2.add(Field_Cost, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 570, 210, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("หมายเหตุ :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 430, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("ชื่อสินค้า :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 500, -1, -1));

        jScrollPane5.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jTextArea_Information1.setEditable(false);
        jTextArea_Information1.setColumns(20);
        jTextArea_Information1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextArea_Information1.setLineWrap(true);
        jTextArea_Information1.setRows(5);
        jScrollPane5.setViewportView(jTextArea_Information1);

        jPanel2.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 430, 280, 170));

        btnAdd1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnAdd1.setText("เพิ่ม");
        btnAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnAdd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 650, 170, 50));

        Table_Receive_Pro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No.", "Product", "Product Type", "Quantity", "Product Cost", "All Prices"
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

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 1470, 350));

        Field_Product2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Field_Product2.setText("ชื่อสินค้า");
        jPanel2.add(Field_Product2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 500, 210, -1));

        TextField_Date.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TextField_Date.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextField_Date.setText("DD/MM/YYYY");
        jPanel2.add(TextField_Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, 210, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("ราคาต้นทุนสินค้า :");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 570, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("วันที :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 430, -1, -1));

        jFrame2.getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1550, 800));

        jFrame3.setSize(new java.awt.Dimension(1550, 800));
        jFrame3.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("บริษัทที่เป็นตัวแทนจำหน่าย :");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 430, -1, -1));

        btnSave1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnSave1.setText("บันทึก");
        btnSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSave1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnSave1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 650, 170, 50));

        Field_Quantity1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Field_Quantity1.setText("0");
        jPanel3.add(Field_Quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 500, 210, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("จำนวนสินค้า :");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 500, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("ประเภทสินค้า :");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 570, 110, -1));

        Btt_Calender1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/calendar.png"))); // NOI18N
        jPanel3.add(Btt_Calender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 435, -1, -1));

        ComboBox_Type2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ComboBox_Type2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "kuy" }));
        jPanel3.add(ComboBox_Type2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 570, 210, 30));

        ComboBox_Company2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ComboBox_Company2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Test", "asd" }));
        jPanel3.add(ComboBox_Company2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 430, 210, 30));

        btnDelete1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnDelete1.setText("ลบ");
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnDelete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 650, 170, 50));

        Field_Cost1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Field_Cost1.setText("0");
        jPanel3.add(Field_Cost1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 570, 210, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("หมายเหตุ :");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 430, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("ชื่อสินค้า :");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 500, -1, -1));

        jScrollPane6.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jTextArea_Information2.setEditable(false);
        jTextArea_Information2.setColumns(20);
        jTextArea_Information2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextArea_Information2.setLineWrap(true);
        jTextArea_Information2.setRows(5);
        jScrollPane6.setViewportView(jTextArea_Information2);

        jPanel3.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 430, 280, 170));

        btnAdd2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnAdd2.setText("เพิ่ม");
        btnAdd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd2ActionPerformed(evt);
            }
        });
        jPanel3.add(btnAdd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 650, 170, 50));

        Table_Receive_Pro1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No.", "Product", "Product Type", "Quantity", "Product Cost", "All Prices"
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
        jScrollPane7.setViewportView(Table_Receive_Pro1);

        jPanel3.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 1470, 350));

        Field_Product3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Field_Product3.setText("ชื่อสินค้า");
        jPanel3.add(Field_Product3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 500, 210, -1));

        TextField_Date1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TextField_Date1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextField_Date1.setText("DD/MM/YYYY");
        jPanel3.add(TextField_Date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, 210, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("ราคาต้นทุนสินค้า :");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 570, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("วันที :");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 430, -1, -1));

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
        Topic.setText("บันทึกการสั่งซื้อสินค้า");
        add(Topic, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, -1, -1));

        search__box.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        search__box.setForeground(new java.awt.Color(123, 123, 123));
        search__box.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        search__box.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        search__box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search__boxActionPerformed(evt);
            }
        });
        add(search__box, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 50, 290, 30));

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
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No", "Date", "Company Name", "Quantity", "Total", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.setRowHeight(50);
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
    private void search__boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search__boxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search__boxActionPerformed

    private void delete_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btActionPerformed
    int selectedRow = jTable.getSelectedRow(); 
    if(selectedRow != -1) { 
        int id = (int) jTable.getValueAt(selectedRow, 0); 
        if(id > 0) { 
            String deleteQuery = "DELETE FROM `order` WHERE No=?";
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
                System.out.println(ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Product Not Deleted, Make Sure The ID is Valid", "Remove Product", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(null, "Please select a row to delete", "Remove Product", JOptionPane.ERROR_MESSAGE);
    }   
    }//GEN-LAST:event_delete_btActionPerformed

    private void Save_bt1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Save_bt1MouseClicked
        jFrame2.setVisible(true);
    }//GEN-LAST:event_Save_bt1MouseClicked

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        int selectedRow = jTable.getSelectedRow();
        if (selectedRow != -1) {
        DefaultTableModel model = (DefaultTableModel) Table_Receive_Pro.getModel();
        model.setRowCount(0); 


        Object[] rowData = new Object[6];
        for (int i = 0; i < jTable.getColumnCount(); i++) {
            rowData[i] = jTable.getValueAt(selectedRow, i);
        }

 
        model.addRow(rowData);
    }
    }//GEN-LAST:event_jTableMouseClicked

    private void Table_Order_Record1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_Order_Record1MouseClicked

    }//GEN-LAST:event_Table_Order_Record1MouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
        String name = Field_Product2.getText();
        String category = ComboBox_Type1.getSelectedItem().toString();
        String company = ComboBox_Company1.getSelectedItem().toString();
        Double cost = Double.valueOf(Field_Cost.getText().toString());
        Integer quantity = Integer.valueOf(Field_Quantity.getText().toString());
        java.util.Date date = new java.util.Date();
        Double total = cost * quantity;
        String remark = jTextArea_Information1.getText();
        
        String insertQuery = "INSERT INTO `order`(`Date`, `Company`, `Name`, `Category`, `Cost`, `Quantity`, `Total`, `Remark`) VALUES (?,?,?,?,?,?,?,?)";
        
        try {
                
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
            
            ps.setDate(1, new java.sql.Date(date.getTime()));
            ps.setString(2, company);
            ps.setString(3, name);
            ps.setString(4, category);
            ps.setDouble(5, cost);
            ps.setInt(6, quantity);
            ps.setDouble(7, total);
            ps.setString(8, remark);
            
            if(ps.executeUpdate() > 0)
            {
                Main.body.removeAll();
                Main.body.add(new Order_Record());
                Main.body.repaint();
                Main.body.revalidate();
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

    private void Save_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Save_bt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Save_bt1ActionPerformed

    private void btnSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSave1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSave1ActionPerformed

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDelete1ActionPerformed

    private void btnAdd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd2ActionPerformed

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
        
        Object[] row = new Object[5];
        
        for(int i = 0; i < productsList.size(); i++)
        {
            row[0] = productsList.get(i).getNo();
            row[1] = productsList.get(i).getDate();
            row[2] = productsList.get(i).getCompany();
            row[3] = productsList.get(i).getQuantity();
            row[4] = productsList.get(i).getTotal();
            
            model.addRow(row);
        }
        
    }
     public void showProductsInTable2()
    {
        ArrayList<OrderInfo> productsList = getProductsList();
        DefaultTableModel model = (DefaultTableModel) Table_Receive_Pro.getModel();
        
        model.setRowCount(0);
        
    Object[] row = new Object[6];

    for(int i = 0; i < productsList.size(); i++) {
        row[0] = productsList.get(i).getNo();
        row[1] = productsList.get(i).getName();
        row[2] = productsList.get(i).getCategory();
        row[3] = productsList.get(i).getQuantity();
        row[4] = productsList.get(i).getCost();
        row[5] = productsList.get(i).getTotal();
        model.addRow(row);
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel All_prices;
    private javax.swing.JLabel Btt_Calender;
    private javax.swing.JLabel Btt_Calender1;
    private javax.swing.JComboBox<String> ComboBox_Company1;
    private javax.swing.JComboBox<String> ComboBox_Company2;
    private javax.swing.JComboBox<String> ComboBox_Type1;
    private javax.swing.JComboBox<String> ComboBox_Type2;
    private javax.swing.JLabel Company_label;
    private javax.swing.JLabel Date_Text;
    private javax.swing.JLabel Date_Text1;
    private javax.swing.JLabel Date_label1;
    private javax.swing.JTextField Field_Cost;
    private javax.swing.JTextField Field_Cost1;
    private javax.swing.JTextField Field_Product2;
    private javax.swing.JTextField Field_Product3;
    private javax.swing.JTextField Field_Quantity;
    private javax.swing.JTextField Field_Quantity1;
    private javax.swing.JLabel Label_Aprices1;
    private javax.swing.JLabel Label_Note;
    private javax.swing.JButton Save_bt1;
    private javax.swing.JScrollPane ScrollPane_Note;
    private javax.swing.JTable Table_Order_Record1;
    private javax.swing.JTable Table_Receive_Pro;
    private javax.swing.JTable Table_Receive_Pro1;
    private javax.swing.JTextField TextField_Date;
    private javax.swing.JTextField TextField_Date1;
    private javax.swing.JLabel Topic;
    private javax.swing.JLabel back_button1;
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
    private javax.swing.JTable jTable;
    private javax.swing.JTextArea jTextArea_Information;
    private javax.swing.JTextArea jTextArea_Information1;
    private javax.swing.JTextArea jTextArea_Information2;
    private javax.swing.JTextField search__box;
    // End of variables declaration//GEN-END:variables

}
