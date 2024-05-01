package component;

import com.raven.datechooser.DateBetween;
import com.raven.datechooser.DateChooser;
import com.raven.datechooser.listener.DateChooserAction;
import com.raven.datechooser.listener.DateChooserAdapter;

import java.sql.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import karnkha.DB;
import karnkha.Main;
import karnkha.OrderInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.table.DefaultTableModel;
import karnkha.Home;
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
        chDate.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        chDate.setDateSelectionMode(DateChooser.DateSelectionMode.BETWEEN_DATE_SELECTED);
        chDate.setLabelCurrentDayVisible(false);
        chDate.setTextField(search__box);
        model = (DefaultTableModel)jTable.getModel();
        chDate.addActionDateChooserListener(new DateChooserAdapter() {
            @Override
            public void dateBetweenChanged(DateBetween db, DateChooserAction action) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String dateFrom = df.format(db.getFromDate());
                String toDate = df.format(db.getToDate());
                loadData("SELECT * FROM `order` WHERE `Date` BETWEEN '" + dateFrom + "' AND '" + toDate + "'");
                mergeAndRefreshTable();
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
        TableActionEventEditView event = new TableActionEventEditView() {
            @Override
            public void onEdit(int row) {
               String date = jTable.getValueAt(row, 1).toString();
               String company = jTable.getValueAt(row, 2).toString();

               String query = "SELECT * FROM `order` WHERE `Date` = ? AND `Company` = ?";
               try {
                   Connection connection = DB.mycon();
                   PreparedStatement statement = connection.prepareStatement(query);
                   statement.setString(1, date);
                   statement.setString(2, company);
                   ResultSet resultSet = statement.executeQuery();

                   DefaultTableModel model = new DefaultTableModel();
                   Table_Receive_Pro1.setModel(model);

                   model.addColumn("No");
                   model.addColumn("Name");
                   model.addColumn("Category");
                   model.addColumn("Quantity");
                   model.addColumn("Cost");
                   model.addColumn("Total");

                   int rowCount = 1; // เริ่มต้นที่เลข 1

                   while (resultSet.next()) {
                       String productName = resultSet.getString("Name");
                       String productType = resultSet.getString("Category");
                       String quantity = resultSet.getString("Quantity");
                       String cost = resultSet.getString("Cost");
                       String allPrices = resultSet.getString("Total");

                       Object[] rowData = {
                           rowCount, // ใช้ rowCount แทน No
                           productName,
                           productType,
                           quantity,
                           cost,
                           allPrices
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
               jFrame3.setVisible(true);
               Table_Receive_Pro1.setDefaultEditor(Object.class, null); // ไม่ให้แก้ไขเซลล์ในตาราง
               //Dateเพิ่ม
                chDate.setTextField(TextField_Date1);
                chDate.setDateSelectionMode(DateChooser.DateSelectionMode.SINGLE_DATE_SELECTED);
                chDate.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
               addTableMouseListener() ;
               
           }
        public void onView(int row) {
            System.out.println("Edit row : " + row);
            String date = jTable.getValueAt(row, 1).toString();
            String company = jTable.getValueAt(row, 2).toString();

            // Set Company and Date TextFields
            Company_Text.setText(company);
            Date_Text.setText(date);

            String query = "SELECT * FROM `order` WHERE `Date` = ? AND `Company` = ?";
            try {
                Connection connection = DB.mycon();
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, date);
                statement.setString(2, company);
                ResultSet resultSet = statement.executeQuery();

                double totalPrices = 0.0; // เพิ่มตัวแปรสำหรับเก็บผลรวมของราคาทั้งหมด

                DefaultTableModel model = new DefaultTableModel();
                Table_Order_Record1.setModel(model);

                model.addColumn("No");
                model.addColumn("Name");
                model.addColumn("Category");
                model.addColumn("Quantity");
                model.addColumn("Cost");
                model.addColumn("Total");

                Set<String> remarksSet = new HashSet<>(); // เก็บ Remark ที่ไม่ซ้ำกัน

                int rowCount = 1; // เริ่มต้นที่เลข 1

                while (resultSet.next()) {
                    String productName = resultSet.getString("Name");
                    String productType = resultSet.getString("Category");
                    String quantity = resultSet.getString("Quantity");
                    String cost = resultSet.getString("Cost");
                    String allPrices = resultSet.getString("Total");

                    double price = Double.parseDouble(allPrices);
                    totalPrices += price; // เพิ่มราคารวม

                    String remark = resultSet.getString("Remark");
                    remarksSet.add(remark); // เพิ่ม Remark เข้า Set

                    Object[] rowData = {
                        rowCount, // ใช้ rowCount แทน No
                        productName,
                        productType,
                        quantity,
                        cost,
                        allPrices
                    };
                    model.addRow(rowData);
                    rowCount++; // เพิ่มค่า rowCount ให้เพื่อเปลี่ยนเลข No ในแถวถัดไป
                }

                // Set total prices TextField
                All_prices.setText(String.valueOf(totalPrices));

                resultSet.close();
                statement.close();
                connection.close();

                // รวม Remark เป็นข้อความเดียวกัน
                StringBuilder remarksBuilder = new StringBuilder();
                for (String remark : remarksSet) {
                    remarksBuilder.append(remark).append("\n");
                }

                // Set remarks in jTextArea_Information
                jTextArea_Information.setText(remarksBuilder.toString());

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            jFrame1.setVisible(true);
            Table_Order_Record1.setDefaultEditor(Object.class, null);
            
        }

        };
        jTable.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRenderEditView());
        jTable.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditorEditView(event));
        mergeAndRefreshTable();
        
         jFrame2.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                e.getWindow().dispose();
                Main.body.removeAll();
                Main.body.add(new Order_Record());
                Main.body.repaint();
                Main.body.revalidate();
            }
        });

        jFrame3.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                e.getWindow().dispose(); 
                Main.body.removeAll();
                Main.body.add(new Order_Record());
                Main.body.repaint();
                Main.body.revalidate();
            }
        });
    }
    
    private void loadData(String sql) {
        try {
            model.setRowCount(0); // เคลียร์ข้อมูลในตารางก่อนโหลดข้อมูลใหม่
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            DecimalFormat f = new DecimalFormat("0");
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
        ScrollPane_Note = new javax.swing.JScrollPane();
        Table_Order_Record1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        Label_Note = new javax.swing.JLabel();
        Label_Aprices1 = new javax.swing.JLabel();
        All_prices = new javax.swing.JLabel();
        Company_label = new javax.swing.JLabel();
        Company_Text = new javax.swing.JLabel();
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
        btnDelete2 = new javax.swing.JButton();
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
        B_date = new javax.swing.JButton();
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

        Table_Order_Record1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Table_Order_Record1.setModel(new javax.swing.table.DefaultTableModel(
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
        Table_Order_Record1.getTableHeader().setReorderingAllowed(false);
        ScrollPane_Note.setViewportView(Table_Order_Record1);

        jFrame1.getContentPane().add(ScrollPane_Note, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 1440, 590));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Label_Note.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Label_Note.setText("หมายเหตุ :");
        jPanel1.add(Label_Note, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 660, -1, -1));

        Label_Aprices1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Label_Aprices1.setText("ราคาสินค้าทั้งหมด :");
        jPanel1.add(Label_Aprices1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 660, -1, -1));

        All_prices.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        All_prices.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        All_prices.setText("00.00");
        jPanel1.add(All_prices, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 660, 250, -1));

        Company_label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Company_label.setText("บริษัท : ");
        jPanel1.add(Company_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        Company_Text.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Company_Text.setText("ชื่อบริษัท");
        jPanel1.add(Company_Text, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 200, -1));

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
        Btt_Calender.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btt_CalenderMouseClicked(evt);
            }
        });
        jPanel2.add(Btt_Calender, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 435, -1, -1));

        ComboBox_Type1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ComboBox_Type1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ประเภทสินค้า" }));
        jPanel2.add(ComboBox_Type1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 570, 210, 30));

        ComboBox_Company1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ComboBox_Company1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Test", "asd" }));
        jPanel2.add(ComboBox_Company1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 430, 210, 30));

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
        jPanel2.add(btnAdd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 650, 170, 50));

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

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 1470, 350));

        Field_Product2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Field_Product2.setText("ชื่อสินค้า");
        jPanel2.add(Field_Product2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 500, 210, -1));

        TextField_Date.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TextField_Date.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextField_Date.setText("DD/MM/YYYY");
        TextField_Date.setEnabled(false);
        jPanel2.add(TextField_Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, 210, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("ราคาต้นทุนสินค้า :");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 570, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("วันที :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 430, -1, -1));

        btnDelete2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnDelete2.setText("ลบ");
        btnDelete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete2ActionPerformed(evt);
            }
        });
        jPanel2.add(btnDelete2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 650, 170, 50));

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
        Btt_Calender1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btt_Calender1MouseClicked(evt);
            }
        });
        jPanel3.add(Btt_Calender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 435, -1, -1));

        ComboBox_Type2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ComboBox_Type2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ประเภทสินค้า" }));
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

        Table_Receive_Pro1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Table_Receive_Pro1.setModel(new javax.swing.table.DefaultTableModel(
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
        Table_Receive_Pro1.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(Table_Receive_Pro1);

        jPanel3.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 1470, 350));

        Field_Product3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Field_Product3.setText("ชื่อสินค้า");
        jPanel3.add(Field_Product3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 500, 210, -1));

        TextField_Date1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TextField_Date1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextField_Date1.setText("DD/MM/YYYY");
        TextField_Date1.setEnabled(false);
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
        back_button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back_button1MouseClicked(evt);
            }
        });
        add(back_button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 60));

        Topic.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Topic.setText("บันทึกการสั่งซื้อสินค้า");
        add(Topic, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, -1, -1));

        B_date.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/calendar1_1.png"))); // NOI18N
        B_date.setBorder(null);
        B_date.setContentAreaFilled(false);
        B_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_dateActionPerformed(evt);
            }
        });
        add(B_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 50, 40, 30));

        search__box.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        search__box.setForeground(new java.awt.Color(123, 123, 123));
        search__box.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        search__box.setText("เลือกช่วงเวลา");
        search__box.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        search__box.setEnabled(false);
        add(search__box, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 50, 290, 30));

        Save_bt1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Save_bt1.setText("เพิ่ม");
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
                "No", "Date", "Company", "Quantity", "Total", ""
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

    private void delete_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btActionPerformed
        int selectedRow = jTable.getSelectedRow();
        if (selectedRow == -1) {
            // ไม่มีแถวที่ถูกเลือก แสดงข้อความข้อผิดพลาดหรือจัดการตามความเหมาะสม
            JOptionPane.showMessageDialog(null, "กรุณาเลือกแถวที่ต้องการลบ", "ข้อผิดพลาด", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // ดึงวันที่และบริษัทจากแถวที่เลือก
        String date = jTable.getValueAt(selectedRow, 1).toString();
        String company = jTable.getValueAt(selectedRow, 2).toString();

        // สร้างคำสั่ง SQL DELETE
        String deleteQuery = "DELETE FROM `order` WHERE `Date` = ? AND `Company` = ?";

        try {
            // เชื่อมต่อกับฐานข้อมูลและเตรียมคำสั่ง
            Connection con = DB.mycon();
            PreparedStatement pst = con.prepareStatement(deleteQuery);
            pst.setString(1, date);
            pst.setString(2, company);

            // ดำเนินการลบ
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                // ลบแถวสำเร็จ
                JOptionPane.showMessageDialog(null, "ลบแถวสำเร็จ", "สำเร็จ", JOptionPane.INFORMATION_MESSAGE);

                // รีเฟรชตาราง;
                mergeAndRefreshTable();
                Main.body.removeAll();
                Main.body.add(new Order_Record());
                Main.body.repaint();
                Main.body.revalidate();
                
            } else {
                // ไม่มีแถวถูกลบ
                JOptionPane.showMessageDialog(null, "ไม่มีแถวถูกลบ", "คำเตือน", JOptionPane.WARNING_MESSAGE);
            }

            // ปิดทรัพยากร
            pst.close();
            con.close();
        } catch (SQLException ex) {
            // จัดการข้อผิดพลาด SQL
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "เกิดข้อผิดพลาดในการลบแถว: " + ex.getMessage(), "ข้อผิดพลาด", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_delete_btActionPerformed

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

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
            // เช็คว่ามีข้อมูลในตารางหรือไม่
       if (Table_Receive_Pro.getRowCount() == 0) {
           JOptionPane.showMessageDialog(null, "ไม่มีข้อมูลในตารางที่จะบันทึก", "ข้อผิดพลาด", JOptionPane.ERROR_MESSAGE);
           return;
       }

       // SQL query สำหรับเพิ่มข้อมูลใหม่ลงในตาราง order
       String insertQuery = "INSERT INTO `order`(`Date`, `Company`, `Name`, `Category`, `Cost`, `Quantity`, `Total`, `Remark`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

       // SQL query สำหรับอัปเดตข้อมูลที่มีการแก้ไข
       String updateQuery = "UPDATE `order` SET `Name` = ?, `Company` = ?, `Remark` = ? WHERE `Date` = ? AND `Name` = ? AND `Company` = ?";

       try {
           // เชื่อมต่อกับฐานข้อมูลและเตรียมคำสั่ง SQL
           Connection con = DB.mycon();
           PreparedStatement psInsert = con.prepareStatement(insertQuery);
           PreparedStatement psUpdate = con.prepareStatement(updateQuery);

           // ลูปเพื่อเพิ่มข้อมูลจากแต่ละบรรทัดในตาราง
           for (int i = 0; i < Table_Receive_Pro.getRowCount(); i++) {
               // รับค่าข้อมูลจากแต่ละคอลัมน์ในแต่ละบรรทัด
               java.util.Date date = new java.util.Date(); // รับวันที่ปัจจุบัน
               String company = ComboBox_Company1.getSelectedItem().toString(); // รับชื่อบริษัทจาก ComboBox
               String name = Table_Receive_Pro.getValueAt(i, 1).toString();
               String category = Table_Receive_Pro.getValueAt(i, 2).toString();
               Double cost = Double.parseDouble(Table_Receive_Pro.getValueAt(i, 4).toString());
               Integer quantity = Integer.parseInt(Table_Receive_Pro.getValueAt(i, 3).toString());
               Double total = Double.parseDouble(Table_Receive_Pro.getValueAt(i, 5).toString());
               String remark = jTextArea_Information1.getText(); // รับค่าหมายเหตุจาก JTextArea

               // ตรวจสอบว่าข้อมูลมีอยู่ในฐานข้อมูลแล้วหรือไม่
               if (isDataExists(date, company, name, con)) {
                   // ถ้ามีอยู่แล้ว ให้อัปเดตข้อมูล
                   psUpdate.setString(1, name);
                   psUpdate.setString(2, company);
                   psUpdate.setString(3, remark);
                   psUpdate.setDate(4, new java.sql.Date(date.getTime()));
                   psUpdate.setString(5, name);
                   psUpdate.setString(6, company);
                   psUpdate.executeUpdate();
               } else {
                   // ถ้ายังไม่มีให้เพิ่มข้อมูลใหม่
                   psInsert.setDate(1, new java.sql.Date(date.getTime())); // ปรับรูปแบบของวันที่เป็น java.sql.Date
                   psInsert.setString(2, company);
                   psInsert.setString(3, name);
                   psInsert.setString(4, category);
                   psInsert.setDouble(5, cost);
                   psInsert.setInt(6, quantity);
                   psInsert.setDouble(7, total);
                   psInsert.setString(8, remark);
                   psInsert.executeUpdate();
               }
           }

           // แจ้งเตือนว่าข้อมูลถูกบันทึกเรียบร้อยแล้ว
           jFrame2.setVisible(false);
           Main.body.removeAll();
           Main.body.add(new Order_Record());
           Main.body.repaint();
           Main.body.revalidate();
           JOptionPane.showMessageDialog(null, "บันทึกข้อมูลเรียบร้อยแล้ว", "บันทึกข้อมูล", JOptionPane.INFORMATION_MESSAGE);

           // ปิดการเชื่อมต่อกับฐานข้อมูล
           psInsert.close();
           psUpdate.close();
           con.close();
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "เกิดข้อผิดพลาดในการบันทึกข้อมูล: " + ex.getMessage(), "ข้อผิดพลาด", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_btnSaveActionPerformed

    private boolean isDataExists(java.util.Date date, String company, String name, Connection con) throws SQLException {
        String checkQuery = "SELECT * FROM `order` WHERE `Date` = ? AND `Company` = ? AND `Name` = ?";
        PreparedStatement psCheck = con.prepareStatement(checkQuery);
        psCheck.setDate(1, new java.sql.Date(date.getTime()));
        psCheck.setString(2, company);
        psCheck.setString(3, name);
        ResultSet rs = psCheck.executeQuery();
        boolean exists = rs.next();
        rs.close();
        psCheck.close();
        return exists;
}
    
    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
        String name = Field_Product2.getText();
        String category = ComboBox_Type1.getSelectedItem().toString();
        String costText = Field_Cost.getText();
        String quantityText = Field_Quantity.getText();

        // ตรวจสอบว่ามีข้อมูลทุกฟิลด์หรือไม่
        if (name.isEmpty() || category.isEmpty() || costText.isEmpty() || quantityText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "กรุณากรอกข้อมูลให้ครบทุกฟิลด์", "ข้อผิดพลาด", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // แปลงค่าราคาเป็น Double
        Double cost;
        try {
            cost = Double.valueOf(costText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "กรุณากรอกราคาให้เป็นตัวเลข", "ข้อผิดพลาด", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // แปลงค่าจำนวนเป็น Integer
        Integer quantity;
        try {
            // แปลงค่าจำนวนเป็น Integer โดยตัดทศนิยมทิ้ง
            quantity = Double.valueOf(quantityText).intValue();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "กรุณากรอกจำนวนให้เป็นตัวเลขจำนวนเต็ม", "ข้อผิดพลาด", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // คำนวณค่ารวม
        Double total = cost * quantity;
        String remark = jTextArea_Information1.getText();

        DefaultTableModel model = (DefaultTableModel) Table_Receive_Pro.getModel();
        // สร้างข้อมูลที่จะเพิ่มลงในตารางโดยรวมลำดับข้างหน้าด้วย
        Object[] rowData = new Object[]{model.getRowCount() + 1, name, category, quantity, cost, total, remark};
        model.addRow(rowData);

        // เคลียร์ข้อมูลในฟิลด์หลังจากการเพิ่มข้อมูล
        Field_Product2.setText("");
        ComboBox_Type1.setSelectedIndex(0);
        Field_Cost.setText("");
        Field_Quantity.setText("");
        jTextArea_Information1.setText("");
    }//GEN-LAST:event_btnAdd1ActionPerformed
//Date เพิ่ม
    private void Save_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Save_bt1ActionPerformed
        jFrame2.setVisible(true);
        chDate.setTextField(TextField_Date);
        chDate.setDateSelectionMode(DateChooser.DateSelectionMode.SINGLE_DATE_SELECTED);
        chDate.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        
    }//GEN-LAST:event_Save_bt1ActionPerformed

    private void btnSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSave1ActionPerformed
           jFrame3.setVisible(false);
           
           try {
            Connection con = DB.mycon();

            // อัปเดตข้อมูลในตาราง order ทั้งหมดที่มีข้อมูลว่าง (null) ในฟิลด์ Date, Company, และ Remark
            String updateAllQuery = "UPDATE `order` SET `Date` = ?, `Company` = ?, `Remark` = ? WHERE `Date` IS NOT NULL AND `Company` IS NOT NULL AND `Remark` IS NOT NULL";
            PreparedStatement psUpdateAll = con.prepareStatement(updateAllQuery);
            psUpdateAll.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
            psUpdateAll.setString(2, ComboBox_Company2.getSelectedItem().toString());
            psUpdateAll.setString(3, jTextArea_Information2.getText());
            psUpdateAll.executeUpdate(); // สั่งให้อัปเดตข้อมูลในตารางทั้งหมด

            // ปิดการเชื่อมต่อกับฐานข้อมูล
            psUpdateAll.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
           
           Main.body.removeAll();
           Main.body.add(new Order_Record());
           Main.body.repaint();
           Main.body.revalidate();
           JOptionPane.showMessageDialog(null, "บันทึกข้อมูลเรียบร้อยแล้ว", "บันทึกข้อมูล", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnSave1ActionPerformed

    private void btnAdd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd2ActionPerformed
        String name = Field_Product3.getText();
        String category = ComboBox_Type2.getSelectedItem().toString();
        String costText = Field_Cost1.getText();
        String quantityText = Field_Quantity1.getText();

        // ตรวจสอบว่าข้อมูลว่างหรือไม่
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
        String remark = jTextArea_Information2.getText();

        try {
            Connection con = DB.mycon();

            // อัปเดตแถวทั้งหมดในตาราง order ที่มีข้อมูลว่าง (null) ในฟิลด์ Date, Company, และ Remark
            String updateAllQuery = "UPDATE `order` SET `Date` = ?, `Company` = ?, `Remark` = ? WHERE `Date` IS NOT NULL AND `Company` IS NOT NULL AND `Remark` IS NOT NULL";
            PreparedStatement psUpdateAll = con.prepareStatement(updateAllQuery);
            psUpdateAll.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
            psUpdateAll.setString(2, ComboBox_Company2.getSelectedItem().toString());
            psUpdateAll.setString(3, remark);
            psUpdateAll.executeUpdate(); // สั่งให้อัปเดตแถว

            // เพิ่มข้อมูลใหม่ลงในตาราง order
            String insertQuery = "INSERT INTO `order`(`Date`, `Company`, `Name`, `Category`, `Cost`, `Quantity`, `Total`, `Remark`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement psInsert = con.prepareStatement(insertQuery);
            psInsert.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
            psInsert.setString(2, ComboBox_Company2.getSelectedItem().toString());
            psInsert.setString(3, name);
            psInsert.setString(4, category);
            psInsert.setDouble(5, cost);
            psInsert.setInt(6, quantity);
            psInsert.setDouble(7, total);
            psInsert.setString(8, remark);
            psInsert.executeUpdate(); // สั่งให้เพิ่มข้อมูลใหม่

            // อัปเดตข้อมูลในตาราง GUI
            DefaultTableModel model = (DefaultTableModel) Table_Receive_Pro1.getModel();
            Object[] rowData = new Object[]{model.getRowCount() + 1, name, category, quantity, cost, total, remark};
            model.addRow(rowData);

            // ล้างข้อมูลในฟิลด์และ JTextArea
            Field_Product3.setText("");
            ComboBox_Type2.setSelectedIndex(0);
            Field_Cost1.setText("");
            Field_Quantity1.setText("");
            jTextArea_Information2.setText("");

            // ปิดการเชื่อมต่อกับฐานข้อมูล
            psInsert.close();
            psUpdateAll.close();
            con.close();
           Main.body.removeAll();
           Main.body.add(new Order_Record());
           Main.body.repaint();
           Main.body.revalidate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnAdd2ActionPerformed

    private void btnDelete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete2ActionPerformed
    int selectedRow = Table_Receive_Pro.getSelectedRow();
        if (selectedRow != -1) {
            // ลบแถวที่เลือกออกจากตาราง
            DefaultTableModel model = (DefaultTableModel) Table_Receive_Pro.getModel();
            model.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(null, "โปรดเลือกแถวที่ต้องการลบ", "ลบแถว", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDelete2ActionPerformed

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
      int selectedRow = Table_Receive_Pro1.getSelectedRow(); 
        if(selectedRow != -1) { 
            String id = (String)Table_Receive_Pro1.getValueAt(selectedRow, 1); 
            System.out.println(id);
                String deleteQuery = "DELETE FROM `order` WHERE `Name` = ?";
                try {
                    PreparedStatement ps = DB.getConnection().prepareStatement(deleteQuery);
                    ps.setString(1, id);
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

    private void back_button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_button1MouseClicked
         Home homePage = new Home();
         homePage.setVisible(true);
         JFrame thisFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
         thisFrame.dispose();
    }//GEN-LAST:event_back_button1MouseClicked

    private void B_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_dateActionPerformed
        chDate.showPopup();
    }//GEN-LAST:event_B_dateActionPerformed

    private void Btt_CalenderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btt_CalenderMouseClicked
        chDate.showPopup();
    }//GEN-LAST:event_Btt_CalenderMouseClicked

    private void Btt_Calender1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btt_Calender1MouseClicked
        chDate.showPopup();
    }//GEN-LAST:event_Btt_Calender1MouseClicked

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


    private void mergeAndRefreshTable() {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        if (jTable != null && model != null) {
            int rowCount = model.getRowCount();
            HashMap<String, Double[]> dateMap = new HashMap<>();

            // วนลูปผ่านแถวของตาราง
            for (int i = 0; i < rowCount; i++) {
                String company = model.getValueAt(i, 2).toString(); // อ้างถึงคอลัมน์ที่ 1 (บริษัท)
                String date = model.getValueAt(i, 1).toString(); // อ้างถึงคอลัมน์ที่ 2 (วันที่)

                String key = company + date; // สร้าง key โดยรวมชื่อบริษัทและวันที่

                if (dateMap.containsKey(key)) {
                    Double[] values = dateMap.get(key);
                    values[0] += Double.parseDouble(model.getValueAt(i, 3).toString()); // อ้างถึงคอลัมน์ที่ 4 (จำนวน)
                    values[1] += Double.parseDouble(model.getValueAt(i, 4).toString()); // อ้างถึงคอลัมน์ที่ 5 (รวม)
                } else {
                    Double[] values = new Double[2];
                    values[0] = Double.parseDouble(model.getValueAt(i, 3).toString()); // อ้างถึงคอลัมน์ที่ 4 (จำนวน)
                    values[1] = Double.parseDouble(model.getValueAt(i, 4).toString()); // อ้างถึงคอลัมน์ที่ 5 (รวม)
                    dateMap.put(key, values);
                }
            }

            model.setRowCount(0);
            int newRowNumber = 1;

            for (Map.Entry<String, Double[]> entry : dateMap.entrySet()) {
                String key = entry.getKey();
                Double[] values = entry.getValue();

                String company = key.substring(0, key.length() - 10); // แยกชื่อบริษัทจาก key
                String date = key.substring(key.length() - 10); // แยกวันที่จาก key

                Object[] rowData = new Object[]{newRowNumber++, date, company,  values[0], values[1]}; // ลำดับ, บริษัท, วันที่, จำนวน, รวม
                model.addRow(rowData);
            }
 
        }
    }

    private void addTableMouseListener() {
    Table_Receive_Pro1.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int row = Table_Receive_Pro1.getSelectedRow();
            if (row >= 0) {
                DefaultTableModel model = (DefaultTableModel) Table_Receive_Pro1.getModel();
                Field_Product3.setText(model.getValueAt(row, 1).toString());
                ComboBox_Type2.setSelectedItem(model.getValueAt(row, 2).toString());
                Field_Cost1.setText(model.getValueAt(row, 4).toString());
                Field_Quantity1.setText(model.getValueAt(row, 3).toString());
            }
        }
    });
 }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel All_prices;
    private javax.swing.JButton B_date;
    private javax.swing.JLabel Btt_Calender;
    private javax.swing.JLabel Btt_Calender1;
    private javax.swing.JComboBox<String> ComboBox_Company1;
    private javax.swing.JComboBox<String> ComboBox_Company2;
    private javax.swing.JComboBox<String> ComboBox_Type1;
    private javax.swing.JComboBox<String> ComboBox_Type2;
    private javax.swing.JLabel Company_Text;
    private javax.swing.JLabel Company_label;
    private javax.swing.JLabel Date_Text;
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
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnDelete2;
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
