package component;

public class Edit_dealer_information extends javax.swing.JPanel {

    public Edit_dealer_information() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back_button = new javax.swing.JLabel();
        Topic = new javax.swing.JLabel();
        name_text = new javax.swing.JLabel();
        name__box = new javax.swing.JTextField();
        surname_text = new javax.swing.JLabel();
        surname_box = new javax.swing.JTextField();
        company_text = new javax.swing.JLabel();
        company_box = new javax.swing.JTextField();
        address_text = new javax.swing.JLabel();
        address_box = new javax.swing.JScrollPane();
        address_area = new javax.swing.JTextArea();
        phone_number_text = new javax.swing.JLabel();
        phone_number_box = new javax.swing.JTextField();
        Add_dealer_information = new javax.swing.JLabel();
        picture_box = new javax.swing.JLabel();
        add_picture_bt = new javax.swing.JButton();
        Save_bt = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        name__box1 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back_button.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        back_button.setForeground(new java.awt.Color(139, 139, 139));
        back_button.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        back_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back-button.png"))); // NOI18N
        add(back_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 60));

        Topic.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Topic.setText("จัดการทะเบียนตัวแทนจำหน่าย");
        add(Topic, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, -1, -1));

        name_text.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        name_text.setText("ชื่อ");
        add(name_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, -1, -1));

        name__box.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        name__box.setForeground(new java.awt.Color(123, 123, 123));
        name__box.setText("ชื่อ");
        name__box.setBorder(null);
        add(name__box, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 370, 30));

        surname_text.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        surname_text.setText("นามสกุล");
        add(surname_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, -1, -1));

        surname_box.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        surname_box.setForeground(new java.awt.Color(123, 123, 123));
        surname_box.setText("นามสกุล");
        surname_box.setBorder(null);
        add(surname_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 370, 30));

        company_text.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        company_text.setText("บริษัท");
        add(company_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, -1, -1));

        company_box.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        company_box.setForeground(new java.awt.Color(123, 123, 123));
        company_box.setText("ชื่อบริษัท");
        company_box.setBorder(null);
        company_box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                company_boxActionPerformed(evt);
            }
        });
        add(company_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, 370, 30));

        address_text.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        address_text.setText("ที่อยู่");
        add(address_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, -1, -1));

        address_area.setColumns(20);
        address_area.setRows(5);
        address_area.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        address_box.setViewportView(address_area);

        add(address_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, 370, 160));

        phone_number_text.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        phone_number_text.setText("เบอร์โทรศัพท์");
        add(phone_number_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 570, -1, -1));

        phone_number_box.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        phone_number_box.setForeground(new java.awt.Color(123, 123, 123));
        phone_number_box.setText("เบอร์โทรศัพท์");
        phone_number_box.setBorder(null);
        add(phone_number_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 570, 370, 30));

        Add_dealer_information.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Add_dealer_information.setText("ข้อมูลตัวแทนจำหน่าย");
        add(Add_dealer_information, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 140, -1, -1));

        picture_box.setBackground(new java.awt.Color(255, 255, 255));
        picture_box.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        picture_box.setForeground(new java.awt.Color(123, 123, 123));
        picture_box.setText("                     รูปนามบัตร");
        picture_box.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(picture_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 190, 330, 270));

        add_picture_bt.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        add_picture_bt.setText("เลือกรูป");
        add_picture_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_picture_btActionPerformed(evt);
            }
        });
        add(add_picture_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 490, 130, 50));

        Save_bt.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Save_bt.setText("บันทึก");
        add(Save_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 640, 130, 50));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 600, 370, 30));

        name__box1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        name__box1.setForeground(new java.awt.Color(123, 123, 123));
        name__box1.setText("ชื่อ");
        name__box1.setBorder(null);
        add(name__box1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 370, 30));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 370, 30));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 370, 30));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 370, 30));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 370, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void add_picture_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_picture_btActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_add_picture_btActionPerformed

    private void company_boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_company_boxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_company_boxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Add_dealer_information;
    private javax.swing.JButton Save_bt;
    private javax.swing.JLabel Topic;
    private javax.swing.JButton add_picture_bt;
    private javax.swing.JTextArea address_area;
    private javax.swing.JScrollPane address_box;
    private javax.swing.JLabel address_text;
    private javax.swing.JLabel back_button;
    private javax.swing.JTextField company_box;
    private javax.swing.JLabel company_text;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField name__box;
    private javax.swing.JTextField name__box1;
    private javax.swing.JLabel name_text;
    private javax.swing.JTextField phone_number_box;
    private javax.swing.JLabel phone_number_text;
    private javax.swing.JLabel picture_box;
    private javax.swing.JTextField surname_box;
    private javax.swing.JLabel surname_text;
    // End of variables declaration//GEN-END:variables
}
