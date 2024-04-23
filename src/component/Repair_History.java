package component;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import raven.cell.TableActionCellEditorAdd;
import raven.cell.TableActionCellEditorView;
import raven.cell.TableActionCellRenderAdd;
import raven.cell.TableActionCellRenderView;
import raven.cell.TableActionEventAdd;
import raven.cell.TableActionEventView;

public class Repair_History extends javax.swing.JPanel {

    public Repair_History() {
    initComponents();{
     TableActionEventView event = new TableActionEventView() {
            @Override
            public void onView(int row) {
                System.out.println("Edit row : " + row);
            }

        };
        table.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRenderView());
        table.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditorView(event));
        table.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                setHorizontalAlignment(SwingConstants.RIGHT);
                return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
            }
        });
        };      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back_button1 = new javax.swing.JLabel();
        Topic = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        txtCustomer1 = new javax.swing.JTextField();
        Topic2 = new javax.swing.JLabel();
        Topic3 = new javax.swing.JLabel();
        txtCustomer2 = new javax.swing.JTextField();
        btnNext = new javax.swing.JButton();

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

        table.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", null, "A", "001", null, null, null, null, null},
                {"2", null, "B", "002", null, null, null, null, null},
                {"3", null, "C", "003", null, null, null, null, null},
                {"4", null, "D", "004", null, null, null, null, null}
            },
            new String [] {
                "No.", "Date", "Name", "Phone", "Product ", "Employee ID", "Employee Name", "Price", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        table.setRowHeight(40);
        table.setSelectionBackground(new java.awt.Color(56, 138, 112));
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(3).setResizable(false);
            table.getColumnModel().getColumn(5).setResizable(false);
            table.getColumnModel().getColumn(6).setResizable(false);
            table.getColumnModel().getColumn(7).setResizable(false);
            table.getColumnModel().getColumn(8).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 1160, 560));

        txtCustomer1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCustomer1.setForeground(new java.awt.Color(123, 123, 123));
        txtCustomer1.setText(" ##/##/##");
        txtCustomer1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCustomer1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCustomer1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCustomer1FocusLost(evt);
            }
        });
        add(txtCustomer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 70, 190, 30));

        Topic2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Topic2.setText("ถึง :");
        add(Topic2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 70, -1, 30));

        Topic3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Topic3.setText("วันที่ :");
        add(Topic3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, -1, 30));

        txtCustomer2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCustomer2.setForeground(new java.awt.Color(123, 123, 123));
        txtCustomer2.setText(" ##/##/##");
        txtCustomer2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCustomer2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCustomer2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCustomer2FocusLost(evt);
            }
        });
        add(txtCustomer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, 190, 30));

        btnNext.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnNext.setText("ค้นหา");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 70, 110, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void txtCustomer1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustomer1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomer1FocusGained

    private void txtCustomer1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustomer1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomer1FocusLost

    private void txtCustomer2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustomer2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomer2FocusGained

    private void txtCustomer2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustomer2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomer2FocusLost

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNextActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Topic;
    private javax.swing.JLabel Topic2;
    private javax.swing.JLabel Topic3;
    private javax.swing.JLabel back_button1;
    private javax.swing.JButton btnNext;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtCustomer1;
    private javax.swing.JTextField txtCustomer2;
    // End of variables declaration//GEN-END:variables

}
