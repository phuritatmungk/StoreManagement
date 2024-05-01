package component;

import java.awt.Color;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import karnkha.CartInfo;
import karnkha.DB;
import karnkha.Main;
import component.Pay_for_repair_services3;
import static component.Sellproduct2.jTable;
import javax.swing.JOptionPane;
import karnkha.RepairRequest;
public class Pay_for_repair_services4 extends javax.swing.JPanel {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public Pay_for_repair_services4(RepairRequest request) {
        initComponents();
        con = DB.mycon();
        showProductsInTable();
        showProductsInTable2();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back_button1 = new javax.swing.JLabel();
        Topic = new javax.swing.JLabel();
        btnPrint = new javax.swing.JButton();
        btnpay = new javax.swing.JButton();
        txtRepair = new javax.swing.JTextField();
        Topic1 = new javax.swing.JLabel();
        Topic2 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtItem = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        Topic3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        txtDate = new javax.swing.JTextField();
        txtStatus = new javax.swing.JTextField();
        txtService = new javax.swing.JTextField();
        Topic4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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
        Topic.setText("ผู้รับซ่อม");
        add(Topic, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 650, -1, 30));

        btnPrint.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/printer1.png"))); // NOI18N
        btnPrint.setText("Print the bill");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 650, 200, 50));

        btnpay.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnpay.setText("ชำระอุปกรณ์ซ่อม");
        btnpay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpayActionPerformed(evt);
            }
        });
        add(btnpay, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 650, 200, 50));

        txtRepair.setEditable(false);
        txtRepair.setBackground(new java.awt.Color(255, 255, 255));
        txtRepair.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtRepair.setForeground(new java.awt.Color(123, 123, 123));
        txtRepair.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRepair.setText("wdsawdsadw");
        txtRepair.setBorder(null);
        txtRepair.setFocusable(false);
        txtRepair.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtRepairFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRepairFocusLost(evt);
            }
        });
        txtRepair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRepairActionPerformed(evt);
            }
        });
        add(txtRepair, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 650, 110, 30));

        Topic1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Topic1.setText("ชำระเงินค่าบริการซ่อม และอุปกรณ์การเกษตร");
        add(Topic1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, -1, -1));

        Topic2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Topic2.setText("ค่าบริการ :");
        add(Topic2, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 610, -1, 30));

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(255, 255, 255));
        txtTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(123, 123, 123));
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTotal.setFocusable(false);
        txtTotal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTotalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTotalFocusLost(evt);
            }
        });
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });
        add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 50, 200, 30));

        txtPhone.setEditable(false);
        txtPhone.setBackground(new java.awt.Color(255, 255, 255));
        txtPhone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPhone.setForeground(new java.awt.Color(123, 123, 123));
        txtPhone.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPhone.setText("wdsawdsa");
        txtPhone.setBorder(null);
        txtPhone.setFocusable(false);
        txtPhone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPhoneFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPhoneFocusLost(evt);
            }
        });
        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });
        add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 600, 150, 30));

        txtName.setEditable(false);
        txtName.setBackground(new java.awt.Color(255, 255, 255));
        txtName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtName.setForeground(new java.awt.Color(123, 123, 123));
        txtName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtName.setText("eawdsawd");
        txtName.setBorder(null);
        txtName.setFocusable(false);
        txtName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNameFocusLost(evt);
            }
        });
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 600, 110, 30));

        txtItem.setEditable(false);
        txtItem.setBackground(new java.awt.Color(255, 255, 255));
        txtItem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtItem.setForeground(new java.awt.Color(123, 123, 123));
        txtItem.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtItem.setText("dawdsa");
        txtItem.setBorder(null);
        txtItem.setFocusable(false);
        txtItem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtItemFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtItemFocusLost(evt);
            }
        });
        txtItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemActionPerformed(evt);
            }
        });
        add(txtItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 600, 60, 30));

        txtId.setEditable(false);
        txtId.setBackground(new java.awt.Color(255, 255, 255));
        txtId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtId.setForeground(new java.awt.Color(123, 123, 123));
        txtId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtId.setText("dawdasdas");
        txtId.setBorder(null);
        txtId.setFocusable(false);
        txtId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIdFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdFocusLost(evt);
            }
        });
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 650, 150, 30));

        Topic3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Topic3.setText("ผู้ส่งซ่อม");
        add(Topic3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 600, -1, 30));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Product ID", "Product Name", "Category", "Quantity", "Price", "Cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(50);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setHeaderValue("Cost");
        }

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 830, 1240, 480));

        jTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No", "Product ID", "Product Name", "Category", "Quantity", "Price"
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
        jScrollPane2.setViewportView(jTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 1240, 480));

        txtDate.setEditable(false);
        txtDate.setBackground(new java.awt.Color(255, 255, 255));
        txtDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtDate.setForeground(new java.awt.Color(255, 255, 255));
        txtDate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDate.setText("dawdasdas");
        txtDate.setBorder(null);
        txtDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDateFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDateFocusLost(evt);
            }
        });
        txtDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateActionPerformed(evt);
            }
        });
        add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 680, 150, 30));

        txtStatus.setEditable(false);
        txtStatus.setBackground(new java.awt.Color(255, 255, 255));
        txtStatus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtStatus.setForeground(new java.awt.Color(255, 255, 255));
        txtStatus.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStatus.setText("dawdasdas");
        txtStatus.setBorder(null);
        txtStatus.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtStatusFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtStatusFocusLost(evt);
            }
        });
        txtStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStatusActionPerformed(evt);
            }
        });
        add(txtStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 680, 150, 30));

        txtService.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtService.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtService.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtService.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtServiceFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtServiceFocusLost(evt);
            }
        });
        txtService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtServiceActionPerformed(evt);
            }
        });
        txtService.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtServiceKeyReleased(evt);
            }
        });
        add(txtService, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 610, 200, 30));

        Topic4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Topic4.setText("Total :");
        add(Topic4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 50, -1, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnpayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpayActionPerformed

        if (txtService.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the service fee before proceeding with the payment.", "Error", JOptionPane.WARNING_MESSAGE);
            return; 
        }

            double serviceCost = Double.parseDouble(txtService.getText());
            double total = serviceCost;

        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            int quantity = (int) model.getValueAt(i, 4);
            double price = (double) model.getValueAt(i, 5);
            total += quantity * price; 
        }

        txtTotal.setText(String.format("%.2f บาท", total));     
        for (int i = 0; i < model.getRowCount(); i++) {
            String name = txtName.getText();
            String item = txtItem.getText();
            Integer phone = Integer.valueOf(txtPhone.getText().toString());
            String repair = txtRepair.getText();
            String id = txtId.getText();
            String status = txtStatus.getText();
            java.util.Date date  = new java.util.Date();
            String pid = (String) model.getValueAt(i,1);
            String pname = (String) model.getValueAt(i,2);
            String category = (String)  model.getValueAt(i,3);
            int quantity = (int) model.getValueAt(i, 4);
            double price = (double) model.getValueAt(i, 5);
            double cost = (double) jTable1.getValueAt(i, 6);
            Double service = Double.valueOf(txtService.getText().toString());
        
            String insertQuery = "INSERT INTO `requestpaid` (`Date`, `Name`, `Phone`, `PId`, `Pname`, `Category`,`Quantity`,`Price`,`Item`,`Id`,`Repairman`,`Status`,`Total`,`Cost`,`Service`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement(insertQuery);
            ps.setDate(1, new java.sql.Date(date.getTime())); 
            ps.setString(2, name);
            ps.setInt(3, phone);
            ps.setString(4, pid);
            ps.setString(5, pname);
            ps.setString(6, category);
            ps.setInt(7, quantity);
            ps.setDouble(8, price);
            ps.setString(9, item);
            ps.setString(10, id);
            ps.setString(11, repair);
            ps.setString(12, status);
            ps.setDouble(13,total);
            ps.setDouble(14,cost);
            ps.setDouble(15,service);
            
            ps.executeUpdate();
            updateInventory(pid, quantity);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        }
        
    }//GEN-LAST:event_btnpayActionPerformed

    private void txtRepairFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRepairFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRepairFocusGained

    private void txtRepairFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRepairFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRepairFocusLost

    private void txtRepairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRepairActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRepairActionPerformed

    private void txtTotalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTotalFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalFocusGained

    private void txtTotalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTotalFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalFocusLost

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtPhoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPhoneFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneFocusGained

    private void txtPhoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPhoneFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneFocusLost

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneActionPerformed

    private void txtNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameFocusGained

    private void txtNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameFocusLost

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtItemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtItemFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtItemFocusGained

    private void txtItemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtItemFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtItemFocusLost

    private void txtItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtItemActionPerformed

    private void txtIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdFocusGained

    private void txtIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdFocusLost

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        // TODO add your handling code here:
        int index = jTable.getSelectedRow();
        position = index;
    }//GEN-LAST:event_jTableMouseClicked

    private void back_button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_button1MouseClicked
        Main.body.removeAll();
        Main.body.add(new Pay_for_repair_services3());
        Main.body.repaint();
        Main.body.revalidate();
    }//GEN-LAST:event_back_button1MouseClicked

    private void txtDateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDateFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateFocusGained

    private void txtDateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDateFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateFocusLost

    private void txtDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateActionPerformed

    private void txtStatusFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStatusFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStatusFocusGained

    private void txtStatusFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStatusFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStatusFocusLost

    private void txtStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStatusActionPerformed

    private void txtServiceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtServiceFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtServiceFocusGained

    private void txtServiceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtServiceFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtServiceFocusLost

    private void txtServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtServiceActionPerformed
        calculateTotalPrice();
    }//GEN-LAST:event_txtServiceActionPerformed

    private void txtServiceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtServiceKeyReleased
        try {
            Double.parseDouble(txtService.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number for the service fee.", "Error", JOptionPane.WARNING_MESSAGE);
        return;
    }
    }//GEN-LAST:event_txtServiceKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    ArrayList<CartInfo> productsArray = new ArrayList<>();
    
    int position = 0;
    public ArrayList<CartInfo> getProductsList()
    {
        ArrayList<CartInfo> list = new ArrayList<>();
        String selectQuery = "SELECT * FROM `repaircart`";
        
        Statement st;
        ResultSet rs;
        
        try {
            st = DB.getConnection().createStatement();
            rs = st.executeQuery(selectQuery);
            CartInfo product;
            
            while(rs.next())
            {
                product = new CartInfo(rs.getInt("No"), rs.getString("Id"),
                                      rs.getString("Name"), rs.getString("Category"), rs.getDouble("Cost"),
                                      rs.getInt("Quantity"), rs.getDouble("Price"));
                list.add(product);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        productsArray = list;
        return list;
        
    }
    ArrayList<RepairRequest> requestArray = new ArrayList<>();
    

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
                                      rs.getString("ID"), rs.getString("Repairman"), rs.getString("Status"), rs.getString("Malfunction"));
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
        ArrayList<CartInfo> productsList = getProductsList();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        
        model.setRowCount(0);
        
        Object[] row = new Object[6];
        
        for(int i = 0; i < productsList.size(); i++)
        {
            row[0] = productsList.get(i).getNo();
            row[1] = productsList.get(i).getId();
            row[2] = productsList.get(i).getName();
            row[3] = productsList.get(i).getCategory();
            row[4] = productsList.get(i).getQuantity();
            row[5] = productsList.get(i).getPrice();
            
            model.addRow(row);
            
        }
    }
    public void showProductsInTable2()
    {
        ArrayList<CartInfo> productsList = getProductsList();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        model.setRowCount(0);
        
        Object[] row = new Object[7];
        
        for(int i = 0; i < productsList.size(); i++)
        {
            row[0] = productsList.get(i).getNo();
            row[1] = productsList.get(i).getId();
            row[2] = productsList.get(i).getName();
            row[3] = productsList.get(i).getCategory();
            row[4] = productsList.get(i).getQuantity();
            row[5] = productsList.get(i).getPrice();
            row[6] = productsList.get(i).getCost();       
            
            model.addRow(row);
            
        }
    }
    private void calculateTotalPrice() {
    DefaultTableModel model = (DefaultTableModel) jTable.getModel();
    double totalPrice = 0.0;

    for (int i = 0; i < model.getRowCount(); i++) {
        int quantity = (int) model.getValueAt(i, 4);
        double price = (double) model.getValueAt(i, 5);
        totalPrice += quantity * price;
    }

    if (!txtService.getText().isEmpty()) {
        double serviceCost = Double.parseDouble(txtService.getText());
        totalPrice += serviceCost;
    }

    txtTotal.setText(String.format("%.2f บาท", totalPrice));
    }
    private boolean isNumericOrDecimal(String input) {

        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c) && c != '.') {
                return true;
            }
        }
        return false;
    }   
private void updateInventory(String productId, int soldQuantity) {
    try {
        Connection con = DB.getConnection();
        String updateQuery = "UPDATE inventory SET Quantity = Quantity - ? WHERE Id = ?";
        PreparedStatement ps = con.prepareStatement(updateQuery);
        ps.setInt(1, soldQuantity);
        ps.setString(2, productId);
        ps.executeUpdate();
    } catch (SQLException ex) {
        System.out.println(ex);
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Topic;
    private javax.swing.JLabel Topic1;
    private javax.swing.JLabel Topic2;
    private javax.swing.JLabel Topic3;
    private javax.swing.JLabel Topic4;
    private javax.swing.JLabel back_button1;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnpay;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable;
    private javax.swing.JTable jTable1;
    public static javax.swing.JTextField txtDate;
    public static javax.swing.JTextField txtId;
    public static javax.swing.JTextField txtItem;
    public static javax.swing.JTextField txtName;
    public static javax.swing.JTextField txtPhone;
    public static javax.swing.JTextField txtRepair;
    private javax.swing.JTextField txtService;
    public static javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

}
