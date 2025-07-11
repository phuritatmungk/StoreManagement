/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Com_Table;

import karnkha.Main;
import Com_Table.Table_OrderRec;
import component.Order_Received;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.table.DefaultTableModel;
import karnkha.DB;
import karnkha.OrderInfo;

/**
 *
 * @author pongs
 */
public class Table_RecivePro extends javax.swing.JPanel {

    /**
     * Creates new form Table_OrderRec
     */
    private String date;
    private String company;

    
    public Table_RecivePro(String date, String company) {
        initComponents();
        this.date = date;
        this.company = company;
        // เรียกเมทอดสำหรับการแสดงข้อมูล
        showOrderData();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea_Information = new javax.swing.JTextArea();
        Label_Note = new javax.swing.JLabel();
        ScrollPane_Note = new javax.swing.JScrollPane();
        Table_Order_Recive = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        back_button1 = new javax.swing.JLabel();
        All_prices = new javax.swing.JLabel();
        Label_Aprices1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(580, 800));
        setPreferredSize(new java.awt.Dimension(590, 800));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jTextArea_Information.setEditable(false);
        jTextArea_Information.setColumns(20);
        jTextArea_Information.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextArea_Information.setLineWrap(true);
        jTextArea_Information.setRows(5);
        jScrollPane4.setViewportView(jTextArea_Information);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 670, 360, 80));

        Label_Note.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Label_Note.setText("หมายเหตุ :");
        add(Label_Note, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 670, -1, -1));

        Table_Order_Recive.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Table_Order_Recive.setModel(new javax.swing.table.DefaultTableModel(
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
        Table_Order_Recive.getTableHeader().setReorderingAllowed(false);
        Table_Order_Recive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_Order_ReciveMouseClicked(evt);
            }
        });
        ScrollPane_Note.setViewportView(Table_Order_Recive);

        add(ScrollPane_Note, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 570, 590));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back_button1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        back_button1.setForeground(new java.awt.Color(139, 139, 139));
        back_button1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        back_button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back-button Table.png"))); // NOI18N
        back_button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back_button1MouseClicked(evt);
            }
        });
        jPanel1.add(back_button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 40));

        All_prices.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        All_prices.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        All_prices.setText("00.00");
        jPanel1.add(All_prices, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 640, 120, -1));

        Label_Aprices1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Label_Aprices1.setText("ราคาสินค้าทั้งหมด :");
        jPanel1.add(Label_Aprices1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 640, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 800));
    }// </editor-fold>//GEN-END:initComponents

    private void showOrderData() {
        String query = "SELECT * FROM `order` WHERE `Date` = ? AND `Company` = ?";
        try {
            Connection connection = DB.mycon();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, date);
            statement.setString(2, company);
            ResultSet resultSet = statement.executeQuery();

            DefaultTableModel model = (DefaultTableModel) Table_Order_Recive.getModel();
            model.setRowCount(0); 

            double totalPrices = 0.0; 
            Set<String> remarksSet = new HashSet<>(); 

            int rowCount = 1; 

            while (resultSet.next()) {
                String productName = resultSet.getString("Name");
                String productType = resultSet.getString("Category");
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
                    productType,
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
}
    
    private void Table_Order_ReciveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_Order_ReciveMouseClicked

    }//GEN-LAST:event_Table_Order_ReciveMouseClicked

    private void back_button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_button1MouseClicked
        Order_Received.body.removeAll();
        Order_Received.body.add(new Table_OrderRec());
        Order_Received.body.repaint();
        Order_Received.body.revalidate();
    }//GEN-LAST:event_back_button1MouseClicked

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
            DefaultTableModel model = (DefaultTableModel) Table_Order_Recive.getModel();

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel All_prices;
    private javax.swing.JLabel Label_Aprices1;
    private javax.swing.JLabel Label_Note;
    private javax.swing.JScrollPane ScrollPane_Note;
    private javax.swing.JTable Table_Order_Recive;
    private javax.swing.JLabel back_button1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea_Information;
    // End of variables declaration//GEN-END:variables
}
