package karnkha;

import component.DefaultForm;
import java.awt.Component;
import raven.menu.MenuEvent;
import component.Manage_Employee;
import component.ReportMenu;
import component.Sellproduct;
import component.SellHistory;
import component.Pay_for_repair_services;
import component.Repair_List_Page;
import component.Manage_Warehouse;
import component.Order_Record;
import component.Manage_Distributor;
import component.Order_Received;
import component.Repair_History;
import component.Sellproduct2;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author RAVEN
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    
    public Main() {
        initComponents();
        menu1.setEvent(new MenuEvent() {
            @Override
            public void selected(int index, int subIndex) {
                if (index == 0) {
                    showForm(new Sellproduct());
                } 
                else if (index == 1) {
                    showForm(new Pay_for_repair_services());
                }
                else if (index == 2) {
                    showForm(new Repair_List_Page());
                }
                else if (index == 3) {
                    showForm(new Manage_Warehouse());
                }
                else if (index ==4){
                    showForm(new Order_Record());
                }
                else if (index ==5){
                    showForm(new Order_Received());
                }
                else if (index == 6){
                    if (subIndex == 1){
                        showForm(new SellHistory());
                    }
                    if (subIndex == 2) {
                        showForm(new Repair_History());
                    }
                }
                else if (index == 7) {
                    showForm(new Manage_Employee());
                }
                else if (index == 8) {
                    showForm(new Manage_Distributor());
                }
                else if (index ==9){
                    showForm(new ReportMenu());
                }
                else {
                    showForm(new DefaultForm("Form : " + index + " " + subIndex));
                }
                clearAllData(); 
                clearAllData2();
            }
        });
    }

    private void showForm(Component com) {
        body.removeAll();
        body.add(com);
        body.repaint();
        body.revalidate();
}
      private void clearAllData() {
        if (Sellproduct2.jTable != null) {
            // Clear table data
            DefaultTableModel model = (DefaultTableModel) Sellproduct2.jTable.getModel();
            model.setRowCount(0);
        }

        // Clear database data
        try {
            String deleteQuery = "DELETE FROM cart";
            PreparedStatement ps = DB.getConnection().prepareStatement(deleteQuery);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Failed to clear database data: " + ex.getMessage());
        }
    }
      private void clearAllData2() {
        if (Sellproduct2.jTable != null) {
            // Clear table data
            DefaultTableModel model = (DefaultTableModel) Sellproduct2.jTable.getModel();
            model.setRowCount(0);
        }

        // Clear database data
        try {
            String deleteQuery = "DELETE FROM repaircart";
            PreparedStatement ps = DB.getConnection().prepareStatement(deleteQuery);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Failed to clear database data: " + ex.getMessage());
        }
    }      

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        scrollPaneWin111 = new raven.scroll.win11.ScrollPaneWin11();
        menu1 = new raven.menu.Menu();
        header1 = new component.Header();
        body = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1600, 900));

        jPanel1.setBackground(new java.awt.Color(217, 217, 217));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(163, 163, 163)));

        scrollPaneWin111.setBorder(null);
        scrollPaneWin111.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneWin111.setViewportView(menu1);

        body.setBackground(new java.awt.Color(245, 245, 245));
        body.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(scrollPaneWin111, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneWin111, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel body;
    private component.Header header1;
    private javax.swing.JPanel jPanel1;
    private raven.menu.Menu menu1;
    private raven.scroll.win11.ScrollPaneWin11 scrollPaneWin111;
    // End of variables declaration//GEN-END:variables
}
