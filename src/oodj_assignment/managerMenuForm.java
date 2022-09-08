/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oodj_assignment;

import java.awt.Color;
import javax.swing.JOptionPane;

public class managerMenuForm extends javax.swing.JFrame {

    /**
     * Creates new form customerMenuForm
     */
    private Gym APUGym;
    private Manager ma_acc;
    
    public managerMenuForm(Gym APUGym, Manager ma_acc) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        this.APUGym = APUGym;
        this.ma_acc = ma_acc;
        
        managerName.setText(ma_acc.getUserName());
        managerID.setText(ma_acc.getUserID());
        managerPhoneNumber.setText("Contact: " + ma_acc.getUserPhoneNumber());
        managerJoinDate.setText("Joined Date: " + ma_acc.getUserJoinDate());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        logoutBut = new javax.swing.JButton();
        managerID = new javax.swing.JLabel();
        managerName = new javax.swing.JLabel();
        managerJoinDate = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        manageTrainerBut = new javax.swing.JButton();
        manageCustBut = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        managerPhoneNumber = new javax.swing.JLabel();
        editBut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLayeredPane1.setBackground(new java.awt.Color(0, 153, 204));
        jLayeredPane1.setForeground(new java.awt.Color(102, 255, 102));
        jLayeredPane1.setOpaque(true);

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 25)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Welcome to Manager Menu");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oodj_assignment/resources/home logo.png"))); // NOI18N

        logoutBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oodj_assignment/resources/logoutblack.png"))); // NOI18N
        logoutBut.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        logoutBut.setBorderPainted(false);
        logoutBut.setContentAreaFilled(false);
        logoutBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(logoutBut, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutBut)
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(31, 31, 31))
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel2))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logoutBut)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        managerID.setFont(new java.awt.Font("Segoe UI", 2, 15)); // NOI18N
        managerID.setText("MA059457");

        managerName.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 25)); // NOI18N
        managerName.setForeground(new java.awt.Color(102, 102, 102));
        managerName.setText("TAN ZHI JUN");

        managerJoinDate.setText("Joined Date: 20 March 2020");

        jLayeredPane2.setBackground(new java.awt.Color(0, 0, 0));
        jLayeredPane2.setOpaque(true);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oodj_assignment/resources/level.png"))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Agency FB", 1, 25)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Manager");

        jLayeredPane2.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel12))
                    .addComponent(jLabel10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel15.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 25)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Manage:");

        jLayeredPane4.setBackground(new java.awt.Color(204, 255, 255));
        jLayeredPane4.setForeground(new java.awt.Color(102, 255, 102));
        jLayeredPane4.setOpaque(true);

        manageTrainerBut.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        manageTrainerBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oodj_assignment/resources/trainer.png"))); // NOI18N
        manageTrainerBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageTrainerButActionPerformed(evt);
            }
        });

        manageCustBut.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        manageCustBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oodj_assignment/resources/customer.png"))); // NOI18N
        manageCustBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageCustButActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 20)); // NOI18N
        jLabel17.setText("CUSTOMER");

        jLabel16.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 20)); // NOI18N
        jLabel16.setText("TRAINER");

        jLayeredPane4.setLayer(manageTrainerBut, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(manageCustBut, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel17, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel16, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane4Layout = new javax.swing.GroupLayout(jLayeredPane4);
        jLayeredPane4.setLayout(jLayeredPane4Layout);
        jLayeredPane4Layout.setHorizontalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(manageCustBut))
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel17)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addComponent(manageTrainerBut, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane4Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(145, 145, 145))))
        );
        jLayeredPane4Layout.setVerticalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addComponent(manageTrainerBut, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16))
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addComponent(manageCustBut, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        managerPhoneNumber.setText("Contact: 016-3099309");

        editBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oodj_assignment/resources/edit.png"))); // NOI18N
        editBut.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        editBut.setBorderPainted(false);
        editBut.setContentAreaFilled(false);
        editBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLayeredPane4))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(editBut)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(managerName)
                            .addComponent(managerID)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(managerJoinDate)
                            .addComponent(managerPhoneNumber))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editBut)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(managerName)
                                .addGap(6, 6, 6)
                                .addComponent(managerID))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(managerPhoneNumber)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(managerJoinDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void manageTrainerButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageTrainerButActionPerformed
        // TODO add your handling code here:
        new managerTrainerMenuForm(APUGym,ma_acc).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_manageTrainerButActionPerformed

    private void editButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButActionPerformed
        // TODO add your handling code here:
        new managerProfileForm(APUGym,ma_acc).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_editButActionPerformed

    private void logoutButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButActionPerformed
        // TODO add your handling code here:
        int input = JOptionPane.showConfirmDialog(null, "Are you Sure?");
        if(input==0)
        {
            APUGym.saveAllRecords();
            new startForm(APUGym).setVisible(true);
            this.dispose();
        }else
        {
            JOptionPane.getRootFrame().dispose();
        }
    }//GEN-LAST:event_logoutButActionPerformed

    private void manageCustButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageCustButActionPerformed
        // TODO add your handling code here:
        new managerCustomerMenuForm(APUGym,ma_acc).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_manageCustButActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editBut;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JButton logoutBut;
    private javax.swing.JButton manageCustBut;
    private javax.swing.JButton manageTrainerBut;
    private javax.swing.JLabel managerID;
    private javax.swing.JLabel managerJoinDate;
    private javax.swing.JLabel managerName;
    private javax.swing.JLabel managerPhoneNumber;
    // End of variables declaration//GEN-END:variables
}