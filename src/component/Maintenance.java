package component;

public class Maintenance extends javax.swing.JPanel {

    public Maintenance() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        queue = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        queue1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        queue2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        queue3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        queue4 = new javax.swing.JTextField();
        queue5 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        queue6 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(245, 245, 245));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(139, 139, 139));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back-button.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 60));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("ลำดับคิว :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("รับซ่อมอุปกรณ์และสินค้าการเกษตร");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, -1, -1));

        queue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(queue, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 90, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("วันที่ :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, -1, -1));

        queue1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(queue1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 150, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("เวลา :");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 150, -1, -1));

        queue2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(queue2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 150, 90, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("ผู้ส่งซ่อม :");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        queue3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(queue3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 240, 210, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("หมายเลขโทรศัพท์ :");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, -1, -1));

        queue4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(queue4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 210, 30));

        queue5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(queue5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 240, 210, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("อุปกรณ์ที่รับซ่อม :");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 240, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("รหัสพนักงาน :");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 190, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("ผู้รับซ่อม :");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, -1, -1));

        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 340, 190, 30));

        queue6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(queue6, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 340, 140, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("อาการเสีย :");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("สถานะสินค้า :");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 340, -1, -1));

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 360, 160));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("บันทึก");
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 640, 130, 50));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField queue;
    private javax.swing.JTextField queue1;
    private javax.swing.JTextField queue2;
    private javax.swing.JTextField queue3;
    private javax.swing.JTextField queue4;
    private javax.swing.JTextField queue5;
    private javax.swing.JTextField queue6;
    // End of variables declaration//GEN-END:variables
}
