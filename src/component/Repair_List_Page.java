package component;

import java.sql.*;
import java.sql.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
import java.util.ArrayList;
import raven.cell.TableActionCellEditorEditView;
import raven.cell.TableActionCellRenderEditView;
import raven.cell.TableActionEventEditView;
import karnkha.RepairRequest;
import karnkha.DB;
import karnkha.Main;
import component.Maintenance;
import java.awt.Color;
import javax.swing.table.TableRowSorter;
import karnkha.Home;

public class Repair_List_Page extends javax.swing.JPanel {
    
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public Repair_List_Page() {
        initComponents();
        con = DB.mycon();
        showRequestInTable();
        loadEmployees();
        TableActionEventEditView event = new TableActionEventEditView() {
            @Override
            public void onEdit(int row) {
                System.out.println("Edit row : " + row);
                jFrame2.setVisible(true);
                int index = jTable.getSelectedRow();
                showProductData2(index);
                position = index;
            }
            public void onView(int row) {
                System.out.println("View row : " + row);
                jFrame1.setVisible(true);   
                int index = jTable.getSelectedRow();
                showProductData(index);
                position = index;
            }
        };
        jTable.getColumnModel().getColumn(8).setCellRenderer(new TableActionCellRenderEditView());
        jTable.getColumnModel().getColumn(8).setCellEditor(new TableActionCellEditorEditView(event));
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField_No = new javax.swing.JTextField();
        jTextField_Date = new javax.swing.JTextField();
        jTextField_Name = new javax.swing.JTextField();
        jTextField_Phone = new javax.swing.JTextField();
        jTextField_Repairman = new javax.swing.JTextField();
        jTextField_Id = new javax.swing.JTextField();
        jTextField_Item = new javax.swing.JTextField();
        jComboBox_Status = new javax.swing.JComboBox<>();
        jScrollPane_Behavior = new javax.swing.JScrollPane();
        jTextArea_Behavior = new javax.swing.JTextArea();
        jFrame2 = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jComboBox_Id = new javax.swing.JComboBox<>();
        jComboBox_Repairman = new javax.swing.JComboBox<>();
        jTextField_No2 = new javax.swing.JTextField();
        jTextField_Date2 = new javax.swing.JTextField();
        jTextField_Name2 = new javax.swing.JTextField();
        jTextField_Phone2 = new javax.swing.JTextField();
        jTextField_Item2 = new javax.swing.JTextField();
        jComboBox_Status2 = new javax.swing.JComboBox<>();
        btnEdit = new javax.swing.JButton();
        jScrollPane_Behavior1 = new javax.swing.JScrollPane();
        jTextArea_Behavior1 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        back_button1 = new javax.swing.JLabel();
        Topic = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        delete_bt = new javax.swing.JButton();
        Status_Combo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jFrame1.setAlwaysOnTop(true);
        jFrame1.setBackground(new java.awt.Color(255, 255, 255));
        jFrame1.setLocation(new java.awt.Point(800, 350));
        jFrame1.setMinimumSize(new java.awt.Dimension(440, 440));
        jFrame1.setResizable(false);
        jFrame1.setSize(new java.awt.Dimension(440, 440));
        jFrame1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setVerifyInputWhenFocusTarget(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("ลำดับ :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 13, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("วันที่ :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 43, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("ผู้ส่งซ่อม :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 73, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("หมายเลขโทรศัพท์ :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 103, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("ผู้รับซ่อม :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 133, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("รหัสพนักงาน :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 163, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("อุปกรณ์ที่รับซ่อม :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 193, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("อาการเสีย :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 250, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("สถานะสินค้า :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 223, -1, -1));

        jTextField_No.setEditable(false);
        jTextField_No.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_No.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField_No.setBorder(null);
        jTextField_No.setFocusable(false);
        jPanel1.add(jTextField_No, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 140, 25));

        jTextField_Date.setEditable(false);
        jTextField_Date.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_Date.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField_Date.setBorder(null);
        jTextField_Date.setFocusable(false);
        jPanel1.add(jTextField_Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 140, 25));

        jTextField_Name.setEditable(false);
        jTextField_Name.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_Name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField_Name.setBorder(null);
        jTextField_Name.setFocusable(false);
        jPanel1.add(jTextField_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 140, 25));

        jTextField_Phone.setEditable(false);
        jTextField_Phone.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_Phone.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField_Phone.setBorder(null);
        jTextField_Phone.setFocusable(false);
        jPanel1.add(jTextField_Phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 140, 25));

        jTextField_Repairman.setEditable(false);
        jTextField_Repairman.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_Repairman.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField_Repairman.setBorder(null);
        jTextField_Repairman.setFocusable(false);
        jPanel1.add(jTextField_Repairman, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 140, 25));

        jTextField_Id.setEditable(false);
        jTextField_Id.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_Id.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField_Id.setBorder(null);
        jTextField_Id.setFocusable(false);
        jPanel1.add(jTextField_Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 140, 25));

        jTextField_Item.setEditable(false);
        jTextField_Item.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_Item.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField_Item.setForeground(new java.awt.Color(255, 0, 51));
        jTextField_Item.setBorder(null);
        jTextField_Item.setFocusable(false);
        jTextField_Item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_ItemActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField_Item, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 140, 25));

        jComboBox_Status.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_Status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "รอดําเนินการ", "กำลังดำเนินการ", "เสร็จสิ้น" }));
        jComboBox_Status.setEnabled(false);
        jComboBox_Status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_StatusActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox_Status, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 140, 30));

        jScrollPane_Behavior.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jScrollPane_Behavior.setEnabled(false);

        jTextArea_Behavior.setEditable(false);
        jTextArea_Behavior.setColumns(20);
        jTextArea_Behavior.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextArea_Behavior.setLineWrap(true);
        jTextArea_Behavior.setRows(5);
        jTextArea_Behavior.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextArea_Behavior.setEnabled(false);
        jScrollPane_Behavior.setViewportView(jTextArea_Behavior);

        jPanel1.add(jScrollPane_Behavior, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 230, 120));

        jFrame1.getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 630));

        jFrame2.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jFrame2.setAlwaysOnTop(true);
        jFrame2.setLocation(new java.awt.Point(800, 350));
        jFrame2.setMinimumSize(new java.awt.Dimension(440, 440));
        jFrame2.setResizable(false);
        jFrame2.setSize(new java.awt.Dimension(440, 500));
        jFrame2.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("ลำดับ :");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 13, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("วันที่ :");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 43, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("ผู้ส่งซ่อม :");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 73, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("หมายเลขโทรศัพท์ :");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 103, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("ผู้รับซ่อม :");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 133, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("รหัสพนักงาน :");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 163, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("อุปกรณ์ที่รับซ่อม :");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 193, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("อาการเสีย :");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 250, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("สถานะสินค้า :");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 223, -1, -1));

        jComboBox_Id.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_Id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_IdActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox_Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 140, 25));

        jComboBox_Repairman.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_Repairman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_RepairmanActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox_Repairman, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 140, 25));

        jTextField_No2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField_No2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jTextField_No2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 140, 25));

        jTextField_Date2.setEditable(false);
        jTextField_Date2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField_Date2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jTextField_Date2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 140, 25));

        jTextField_Name2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField_Name2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField_Name2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_Name2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_Name2FocusLost(evt);
            }
        });
        jPanel2.add(jTextField_Name2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 140, 25));

        jTextField_Phone2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField_Phone2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jTextField_Phone2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 140, 25));

        jTextField_Item2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField_Item2.setForeground(new java.awt.Color(255, 0, 51));
        jTextField_Item2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField_Item2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Item2ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField_Item2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 140, 25));

        jComboBox_Status2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_Status2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "รอดําเนินการ", "กำลังดำเนินการ", "เสร็จสิ้น" }));
        jComboBox_Status2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_Status2ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox_Status2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 140, 30));

        btnEdit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEdit.setText("บันทึก");
        btnEdit.setFocusPainted(false);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel2.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 170, 50));

        jScrollPane_Behavior1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jTextArea_Behavior1.setColumns(20);
        jTextArea_Behavior1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextArea_Behavior1.setLineWrap(true);
        jTextArea_Behavior1.setRows(5);
        jScrollPane_Behavior1.setViewportView(jTextArea_Behavior1);

        jPanel2.add(jScrollPane_Behavior1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 230, 120));

        jFrame2.getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 670));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
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
        Topic.setText("รับซ่อมอุปกรณ์และสินค้าเกษตร");
        add(Topic, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, -1, -1));

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnAdd.setText("เพิ่ม");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 640, 130, 50));

        delete_bt.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        delete_bt.setText("ลบ");
        delete_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btActionPerformed(evt);
            }
        });
        add(delete_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 640, 130, 50));

        Status_Combo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Status_Combo.setForeground(new java.awt.Color(123, 123, 123));
        Status_Combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ค้นหาสถานะ", "รอดำเนินการ", "กำลังดำเนินการ", "เสร็จสิ้น", "ชำระเสร็จสิ้น" }));
        Status_Combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Status_ComboItemStateChanged(evt);
            }
        });
        add(Status_Combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 50, 170, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("ค้นหาสถานะ");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 60, -1, -1));

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

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 1240, 520));
    }// </editor-fold>//GEN-END:initComponents

    private void delete_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btActionPerformed
    int selectedRow = jTable.getSelectedRow(); 
    if(selectedRow != -1) { 
        int id = (int) jTable.getValueAt(selectedRow, 0); 
        if(id > 0) { 
            String deleteQuery = "DELETE FROM request WHERE No=?";
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

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        Main.body.removeAll();
        Main.body.add(new Maintenance());
        Main.body.repaint();
        Main.body.revalidate();
    }//GEN-LAST:event_btnAddMouseClicked

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        // TODO add your handling code here:
        int index = jTable.getSelectedRow();
        position = index;
    }//GEN-LAST:event_jTableMouseClicked

    private void jTextField_ItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_ItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_ItemActionPerformed

    private void jTextField_Item2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Item2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Item2ActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        
        Integer no = Integer.valueOf(jTextField_No2.getText().toString());
        String strdate = jTextField_Date2.getText();
        java.util.Date date = new java.util.Date();
        String name =  jTextField_Name2.getText();
        String phone = jTextField_Phone2.getText();
        String item = jTextField_Item2.getText();
        String id = jComboBox_Id.getSelectedItem().toString();
        String repairman =  jComboBox_Repairman.getSelectedItem().toString();
        String status =  jComboBox_Status2.getSelectedItem().toString();
 
        String updateQuery = "UPDATE `request` SET `Datetime`=?,`Name`=?,`Phone`=?,`Item`=? ,`Id`=? ,`Repairman`=? ,`Status`=? WHERE `No`=?";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(updateQuery);
            ps.setDate(1, new java.sql.Date(date.getTime()));
            ps.setString(2, name);
            ps.setString(3, phone);
            ps.setString(4, item);
            ps.setString(5, id);
            ps.setString(6, repairman); 
            ps.setString(7, status);
            ps.setInt(8, no);
            
            if(ps.executeUpdate() > 0)
            {
                showRequestInTable();
                System.out.println("Updated");
            }
            else
            {
                System.out.println("Failed");
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
       
    }//GEN-LAST:event_btnEditActionPerformed

    private void jComboBox_Status2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_Status2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_Status2ActionPerformed

    private void jComboBox_StatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_StatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_StatusActionPerformed

    private void Status_ComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Status_ComboItemStateChanged
        String query = Status_Combo.getSelectedItem().toString();
        filter(query);
    }//GEN-LAST:event_Status_ComboItemStateChanged

    private void back_button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_button1MouseClicked
        Home homePage = new Home();
        homePage.setVisible(true);
        JFrame thisFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        thisFrame.dispose();
    }//GEN-LAST:event_back_button1MouseClicked

    private void jTextField_Name2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_Name2FocusGained
        if (jTextField_Name2.getText().equals("ผู้ส่งซ่อม"))
        {
            jTextField_Name2.setText("");
            jTextField_Name2.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_jTextField_Name2FocusGained

    private void jTextField_Name2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_Name2FocusLost
        if (jTextField_Name2.getText ().length() ==0){
            jTextField_Name2.setText ("ผู้ส่งซ่อม") ;
            jTextField_Name2.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_jTextField_Name2FocusLost
    private void jComboBox_IdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_IdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_IdActionPerformed

    private void jComboBox_RepairmanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_RepairmanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_RepairmanActionPerformed

    ArrayList<RepairRequest> requestArray = new ArrayList<>();
    
    int position = 0;
    public ArrayList<RepairRequest> getRequestList()
    {
        ArrayList<RepairRequest> list = new ArrayList<>();
        String selectQuery = "SELECT * FROM `request`";
        
        Statement st;
        ResultSet rs;
        
        try {
            st = DB.getConnection().createStatement();
            rs = st.executeQuery(selectQuery);
            RepairRequest request;
            
            while(rs.next())
            {
                request = new RepairRequest(rs.getInt("No"), rs.getString("Datetime"),
                                      rs.getString("Name"), rs.getString("Phone"), rs.getString("Item"),
                                      rs.getString("ID"), rs.getString("Repairman"), rs.getString("Status"));
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
        public void showProductData(int index)
    {
        jTextField_No.setText(requestArray.get(index).getNo().toString());
        jTextField_Date.setText(requestArray.get(index).getDate());
        jTextField_Name.setText(requestArray.get(index).getName());
        jTextField_Phone.setText(requestArray.get(index).getPhone().toString());
        jTextField_Item.setText(requestArray.get(index).getItem());
        jTextField_Id.setText(requestArray.get(index).getId().toString());
        jTextField_Repairman.setText(requestArray.get(index).getRepairman());
        jComboBox_Status.setSelectedItem(requestArray.get(index).getStatus());
        jTextArea_Behavior1.setText(requestArray.get(index).getName());
    }
        public void showProductData2(int index)
    {
        jTextField_No2.setText(requestArray.get(index).getNo().toString());
        jTextField_Date2.setText(requestArray.get(index).getDate());
        jTextField_Name2.setText(requestArray.get(index).getName());
        jTextField_Phone2.setText(requestArray.get(index).getPhone().toString());
        jTextField_Item2.setText(requestArray.get(index).getItem());
        jComboBox_Id.setSelectedItem(requestArray.get(index).getId());
        jComboBox_Repairman.setSelectedItem(requestArray.get(index).getRepairman());
        jComboBox_Status2.setSelectedItem(requestArray.get(index).getStatus());
        jTextArea_Behavior.setText(requestArray.get(index).getName());
    }
        public boolean checkEmptyFields()
    {
        String no = jTextField_No2.getText().trim();
        String date = jTextField_Date2.getText().trim();
        String name = jTextField_Name2.getText().trim();
        String phone = jTextField_Phone2.getText().trim();
        String item = jTextField_Item2.getText().trim();
        if(no.equals("") || date.equals("") || name.equals("") || phone.equals("") || item.equals(""))
         {
            return false;
        }
            else
        {
            return true;    
        }
  

     }
        private void filter(String query){
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
            jTable.setRowSorter(sorter);

            if (!query.equals("ค้นหาสถานะ")) { 
                sorter.setRowFilter(RowFilter.regexFilter(query, 7));
                 } else {
                 jTable.setRowSorter(sorter); 
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

                jComboBox_Id.addItem(employeeID);
                jComboBox_Repairman.addItem(employeeName);
            }

        } catch (SQLException ex) {
            System.out.println("Failed to load employees: " + ex.getMessage());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Status_Combo;
    private javax.swing.JLabel Topic;
    private javax.swing.JLabel back_button1;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton delete_bt;
    private javax.swing.JComboBox<String> jComboBox_Id;
    private javax.swing.JComboBox<String> jComboBox_Repairman;
    private javax.swing.JComboBox<String> jComboBox_Status;
    private javax.swing.JComboBox<String> jComboBox_Status2;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane_Behavior;
    private javax.swing.JScrollPane jScrollPane_Behavior1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea_Behavior;
    private javax.swing.JTextArea jTextArea_Behavior1;
    private javax.swing.JTextField jTextField_Date;
    private javax.swing.JTextField jTextField_Date2;
    private javax.swing.JTextField jTextField_Id;
    private javax.swing.JTextField jTextField_Item;
    private javax.swing.JTextField jTextField_Item2;
    private javax.swing.JTextField jTextField_Name;
    private javax.swing.JTextField jTextField_Name2;
    private javax.swing.JTextField jTextField_No;
    private javax.swing.JTextField jTextField_No2;
    private javax.swing.JTextField jTextField_Phone;
    private javax.swing.JTextField jTextField_Phone2;
    private javax.swing.JTextField jTextField_Repairman;
    // End of variables declaration//GEN-END:variables

    private void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
