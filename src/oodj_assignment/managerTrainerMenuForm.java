/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oodj_assignment;

import java.awt.Color;
import javax.swing.JOptionPane;

public class managerTrainerMenuForm extends javax.swing.JFrame {

    private Gym APUGym;
    private Manager ma_acc;
    
    public managerTrainerMenuForm(Gym APUGym, Manager ma_acc) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        this.APUGym = APUGym;
        this.ma_acc = ma_acc;
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
        homeBut = new javax.swing.JLabel();
        logoutBut = new javax.swing.JButton();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        viewTrainerBut = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        cancelBookingBut = new javax.swing.JButton();
        viewTrainingSessionBut = new javax.swing.JButton();
        scheduleTranningBut = new javax.swing.JButton();
        registerTrainerBut = new javax.swing.JButton();
        switchCustomer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLayeredPane1.setBackground(new java.awt.Color(0, 153, 204));
        jLayeredPane1.setForeground(new java.awt.Color(102, 255, 102));
        jLayeredPane1.setOpaque(true);

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 25)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Trainer Management");

        homeBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oodj_assignment/resources/home logo.png"))); // NOI18N
        homeBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeButMouseClicked(evt);
            }
        });

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
        jLayeredPane1.setLayer(homeBut, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(logoutBut, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(homeBut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 303, Short.MAX_VALUE)
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
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(homeBut)
                    .addComponent(logoutBut))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLayeredPane4.setBackground(new java.awt.Color(204, 255, 255));
        jLayeredPane4.setForeground(new java.awt.Color(102, 255, 102));
        jLayeredPane4.setOpaque(true);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oodj_assignment/resources/mini logo.png"))); // NOI18N

        viewTrainerBut.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        viewTrainerBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oodj_assignment/resources/listcust.png"))); // NOI18N
        viewTrainerBut.setText("View Trainer");
        viewTrainerBut.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        viewTrainerBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewTrainerButActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 25)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("SELECT");

        cancelBookingBut.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        cancelBookingBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oodj_assignment/resources/cancel.png"))); // NOI18N
        cancelBookingBut.setText("Cancel Session");
        cancelBookingBut.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        cancelBookingBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBookingButActionPerformed(evt);
            }
        });

        viewTrainingSessionBut.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        viewTrainingSessionBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oodj_assignment/resources/report.png"))); // NOI18N
        viewTrainingSessionBut.setText("View Training Session");
        viewTrainingSessionBut.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        viewTrainingSessionBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewTrainingSessionButActionPerformed(evt);
            }
        });

        scheduleTranningBut.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        scheduleTranningBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oodj_assignment/resources/bookcust.png"))); // NOI18N
        scheduleTranningBut.setText("Schedule Training");
        scheduleTranningBut.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        scheduleTranningBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scheduleTranningButActionPerformed(evt);
            }
        });

        registerTrainerBut.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        registerTrainerBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oodj_assignment/resources/register.png"))); // NOI18N
        registerTrainerBut.setText("Registration");
        registerTrainerBut.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 2, true));
        registerTrainerBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerTrainerButActionPerformed(evt);
            }
        });

        switchCustomer.setText("Swtich to Customer");
        switchCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switchCustomerActionPerformed(evt);
            }
        });

        jLayeredPane4.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(viewTrainerBut, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel15, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(cancelBookingBut, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(viewTrainingSessionBut, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(scheduleTranningBut, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(registerTrainerBut, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(switchCustomer, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane4Layout = new javax.swing.GroupLayout(jLayeredPane4);
        jLayeredPane4.setLayout(jLayeredPane4Layout);
        jLayeredPane4Layout.setHorizontalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addGap(0, 51, Short.MAX_VALUE)
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(scheduleTranningBut, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(registerTrainerBut, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(64, 64, 64)
                                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cancelBookingBut, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(viewTrainerBut, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                                .addComponent(viewTrainingSessionBut, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(141, 141, 141))))
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addComponent(switchCustomer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel1)
                .addContainerGap())
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addGap(292, 292, 292)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane4Layout.setVerticalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(registerTrainerBut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(viewTrainerBut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(scheduleTranningBut, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancelBookingBut, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(viewTrainingSessionBut, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(switchCustomer))
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane4)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane4)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void viewTrainerButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewTrainerButActionPerformed
        // TODO add your handling code here:
        new managerViewTrainerForm(APUGym,ma_acc).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_viewTrainerButActionPerformed

    private void cancelBookingButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBookingButActionPerformed
        // TODO add your handling code here:
        new managerCancelTrainingSessionForm(APUGym,ma_acc).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelBookingButActionPerformed

    private void viewTrainingSessionButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewTrainingSessionButActionPerformed
        // TODO add your handling code here:
        new managerViewTrainingSessionForm(APUGym,ma_acc).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_viewTrainingSessionButActionPerformed

    private void scheduleTranningButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scheduleTranningButActionPerformed
        // TODO add your handling code here:
        new managerScheduleTrainingSessionForm(APUGym,ma_acc).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_scheduleTranningButActionPerformed

    private void registerTrainerButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerTrainerButActionPerformed
        // TODO add your handling code here:
        new managerRegisterTrainerForm(APUGym,ma_acc).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_registerTrainerButActionPerformed

    private void switchCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_switchCustomerActionPerformed
        // TODO add your handling code here:
        new managerCustomerMenuForm(APUGym,ma_acc).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_switchCustomerActionPerformed

    private void homeButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButMouseClicked
        new managerMenuForm(APUGym,ma_acc).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeButMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBookingBut;
    private javax.swing.JLabel homeBut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JButton logoutBut;
    private javax.swing.JButton registerTrainerBut;
    private javax.swing.JButton scheduleTranningBut;
    private javax.swing.JButton switchCustomer;
    private javax.swing.JButton viewTrainerBut;
    private javax.swing.JButton viewTrainingSessionBut;
    // End of variables declaration//GEN-END:variables
}
