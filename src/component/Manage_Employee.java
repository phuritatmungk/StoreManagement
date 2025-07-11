package component;

import raven.cell.TableActionCellEditorEdit;
import raven.cell.TableActionCellRenderEdit;
import raven.cell.TableActionEventEdit;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import karnkha.DB;
import karnkha.EmployeeInfo;
import karnkha.Main;
import component.Employee_Register;
import component.Edit_employee_info;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.table.TableRowSorter;
import karnkha.Home;
public class Manage_Employee extends javax.swing.JPanel {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public Manage_Employee() {
        initComponents();
        con = DB.mycon();
        showEmployeeInTable();
        TableActionEventEdit event = new TableActionEventEdit() {
            @Override
            public void onEdit(int row) {
                System.out.println("Edit row : " + row);
                Main.body.removeAll();
                Main.body.add(new Edit_employee_info());
                Main.body.repaint();
                Main.body.revalidate();
                int index = jTable.getSelectedRow();
                showProductData(index);
                position = index;
            }

        };
        jTable.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRenderEdit());
        jTable.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditorEdit(event));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back_button1 = new javax.swing.JLabel();
        Topic = new javax.swing.JLabel();
        back_button = new javax.swing.JLabel();
        search__box = new javax.swing.JTextField();
        Save_bt1 = new javax.swing.JButton();
        delete_bt = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

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
        Topic.setText("จัดการทะเบียนพนักงาน");
        add(Topic, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, -1, -1));

        back_button.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        back_button.setForeground(new java.awt.Color(139, 139, 139));
        back_button.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        back_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/loupe2_1.png"))); // NOI18N
        add(back_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 50, 30, 30));

        search__box.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        search__box.setForeground(new java.awt.Color(123, 123, 123));
        search__box.setText("ค้นหารหัสพนักงาน");
        search__box.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        search__box.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                search__boxFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                search__boxFocusLost(evt);
            }
        });
        search__box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search__boxActionPerformed(evt);
            }
        });
        search__box.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search__boxKeyReleased(evt);
            }
        });
        add(search__box, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 50, 300, 30));

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
        add(Save_bt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 680, 130, 50));

        delete_bt.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        delete_bt.setText("ลบ");
        delete_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btActionPerformed(evt);
            }
        });
        add(delete_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 680, 130, 50));

        jTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No", "Employee Name", "Employee ID", "Job Titles", "Daily Wage", ""
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
            String deleteQuery = "DELETE FROM employee WHERE No=?";
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

    private void Save_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Save_bt1ActionPerformed

    }//GEN-LAST:event_Save_bt1ActionPerformed

    private void Save_bt1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Save_bt1MouseClicked
        Main.body.removeAll();
        Main.body.add(new Employee_Register());
        Main.body.repaint();
        Main.body.revalidate();
    }//GEN-LAST:event_Save_bt1MouseClicked

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        // TODO add your handling code here:
        int index = jTable.getSelectedRow();
        position = index;
    }//GEN-LAST:event_jTableMouseClicked

    private void search__boxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_search__boxFocusGained
        if(search__box.getText().equals("ค้นหารหัสพนักงาน")){
                search__box.setText("");
                search__box.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_search__boxFocusGained

    private void search__boxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_search__boxFocusLost
        if (search__box.getText().length()==0) {
            search__box.setText("ค้นหารหัสพนักงาน");
            search__box.setForeground(new Color(123, 123, 123));
        }
    }//GEN-LAST:event_search__boxFocusLost

    private void search__boxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search__boxKeyReleased
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        jTable.setRowSorter(sorter);
        int columnIndexToFilter = 1;
        int columnIndexToFilter2 = 2;
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + search__box.getText().trim(), columnIndexToFilter));
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + search__box.getText().trim(), columnIndexToFilter2));
    }//GEN-LAST:event_search__boxKeyReleased

    private void search__boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search__boxActionPerformed

    }//GEN-LAST:event_search__boxActionPerformed

    private void back_button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_button1MouseClicked
        Home homePage = new Home();
        homePage.setVisible(true);
        JFrame thisFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        thisFrame.dispose();
    }//GEN-LAST:event_back_button1MouseClicked

    ArrayList<EmployeeInfo> employeesArray = new ArrayList<>();
    
    int position = 0;
    public ArrayList<EmployeeInfo> getProductsList()
    {
        ArrayList<EmployeeInfo> list = new ArrayList<>();
        String selectQuery = "SELECT * FROM `employee`";
        
        Statement st;
        ResultSet rs;
        
        try {
            st = DB.getConnection().createStatement();
            rs = st.executeQuery(selectQuery);
            EmployeeInfo employee;
            
            while(rs.next())
            {
                employee = new EmployeeInfo(rs.getInt("No"), rs.getString("Fname"),
                                      rs.getString("Sname"), rs.getString("Id"), rs.getString("Job"),
                                      rs.getDouble("Wage"), rs.getString("Phone"), rs.getString("Address"),rs.getString("Image"));
                list.add(employee);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        employeesArray = list;
        return list;
        
    }
    
    public void showEmployeeInTable()
    {
        ArrayList<EmployeeInfo> employeesList = getProductsList();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        
        model.setRowCount(0);
        
        Object[] row = new Object[5];
        
        for(int i = 0; i < employeesList.size(); i++)
        {
            row[0] = employeesList.get(i).getNo();
            row[1] = employeesList.get(i).getFull();
            row[2] = employeesList.get(i).getId();
            row[3] = employeesList.get(i).getJob();
            row[4] = employeesList.get(i).getWage();
            
            model.addRow(row);
        }
        
    }
public void showProductData(int index)
      {
        JLabel img = Edit_employee_info.picture_box;   
        Edit_employee_info.txtNo.setText(employeesArray.get(index).getNo().toString());
        Edit_employee_info.txtId.setText(employeesArray.get(index).getId().toString());
        Edit_employee_info.txtName.setText(employeesArray.get(index).getFname().toString());
        Edit_employee_info.txtSname.setText(employeesArray.get(index).getSname().toString());
        Edit_employee_info.txtPhone.setText(employeesArray.get(index).getPhone().toString());
        Edit_employee_info.comboJob.setSelectedItem(employeesArray.get(index).getJob());
        Edit_employee_info.txtSalary.setText(employeesArray.get(index).getWage().toString());
        Edit_employee_info.txtAddress.setText(employeesArray.get(index).getAddress().toString());
        Edit_employee_info.jTextField_imgPath.setText(employeesArray.get(index).getImg().toString());
        displayImage(employeesArray.get(index).getImg(),img,'a');
        
    }
    public void displayImage(String imgPath, JLabel label, char rsc)
    {
        ImageIcon imgIco;
        if(rsc == 'r')
        {
            imgIco = new ImageIcon(getClass().getResource(imgPath));
        }
        else
        {
         imgIco = new ImageIcon(imgPath);
        }
        
        Image img = imgIco.getImage().getScaledInstance(200, 190, Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(img));

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Save_bt1;
    private javax.swing.JLabel Topic;
    private javax.swing.JLabel back_button;
    private javax.swing.JLabel back_button1;
    private javax.swing.JButton delete_bt;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField search__box;
    // End of variables declaration//GEN-END:variables
}
