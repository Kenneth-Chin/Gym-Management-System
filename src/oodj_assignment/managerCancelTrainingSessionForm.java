/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oodj_assignment;

import java.util.*;
import java.awt.Color;
import javax.swing.*;
import javax.swing.table.*;

public class managerCancelTrainingSessionForm extends javax.swing.JFrame {

    /**
     * Creates new form customerMenuForm
     */
    private Gym APUGym;
    private Manager ma_acc;
    
    public managerCancelTrainingSessionForm(Gym APUGym, Manager ma_acc) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        this.APUGym = APUGym;
        this.ma_acc = ma_acc;
        
        trainingSessionID.setText("ID: -----");
        trainingSessionName.setText("No Session Selected");
        trainingSessionTrainer.setText("-----");
        trainingSessionDate.setText("-----");
        trainingSessionTime.setText("-----");
        trainingSessionLevel.setText("-----");
        trainingSessionStatus.setText("-----");
        trainingSessionCustomersNum.setText("0");
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        customersTable.setDefaultRenderer(String.class, centerRenderer);
        
        ArrayList<TrainingSession> TrainingSessions = APUGym.getTrainingSessions();
        for(TrainingSession ts: TrainingSessions){
            if(ts.getTrainingSessionStatus().equals("Not Started")){
                selectTrainingSession.addItem(ts.getTrainingSessionID() + " - " + ts.getTrainingSessionName());
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel15 = new javax.swing.JLabel();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        trainingSessionID = new javax.swing.JLabel();
        trainingSessionName = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        trainingSessionDate = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        trainingSessionTime = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        trainingSessionLevel = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        trainingSessionStatus = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        trainingSessionCustomersNum = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        customersTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        trainingSessionTrainer = new javax.swing.JLabel();
        jLayeredPane8 = new javax.swing.JLayeredPane();
        jLabel11 = new javax.swing.JLabel();
        selectTrainingSession = new javax.swing.JComboBox<>();
        backBut = new javax.swing.JButton();
        cancelBut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel15.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 25)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Select Session:");

        jLayeredPane4.setBackground(new java.awt.Color(204, 204, 204));
        jLayeredPane4.setForeground(new java.awt.Color(102, 255, 102));
        jLayeredPane4.setOpaque(true);

        trainingSessionID.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        trainingSessionID.setText("ID: #TS059457");

        trainingSessionName.setFont(new java.awt.Font("Agency FB", 1, 28)); // NOI18N
        trainingSessionName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        trainingSessionName.setText("Full-Body Workout for Beginners");
        trainingSessionName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Date:");

        trainingSessionDate.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        trainingSessionDate.setText("20/5/2022");

        jLabel10.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Time:");

        trainingSessionTime.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        trainingSessionTime.setText("5.00 p.m. - 6.00 p.m.");

        jLabel12.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Level:");

        trainingSessionLevel.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        trainingSessionLevel.setText("Beginner");

        jLabel17.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Status:");

        trainingSessionStatus.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        trainingSessionStatus.setText("Completed");

        jLabel20.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        jLabel20.setText("Total Customers:");

        trainingSessionCustomersNum.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        trainingSessionCustomersNum.setText("10");

        customersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Customer Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        customersTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(customersTable);
        if (customersTable.getColumnModel().getColumnCount() > 0) {
            customersTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("This training session will be conducted by Trainer: ");

        trainingSessionTrainer.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        trainingSessionTrainer.setText("Jordan Yeoh");

        jLayeredPane4.setLayer(trainingSessionID, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(trainingSessionName, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(trainingSessionDate, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(trainingSessionTime, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(trainingSessionLevel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel17, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(trainingSessionStatus, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel20, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(trainingSessionCustomersNum, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(trainingSessionTrainer, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane4Layout = new javax.swing.GroupLayout(jLayeredPane4);
        jLayeredPane4.setLayout(jLayeredPane4Layout);
        jLayeredPane4Layout.setHorizontalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(trainingSessionID))
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(trainingSessionTrainer)))
                .addContainerGap(160, Short.MAX_VALUE))
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(trainingSessionName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane4Layout.createSequentialGroup()
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(27, 27, 27))
                            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(27, 27, 27))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane4Layout.createSequentialGroup()
                                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(26, 26, 26)))
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(trainingSessionDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(trainingSessionTime, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(trainingSessionLevel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(trainingSessionStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(trainingSessionCustomersNum))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85))
        );
        jLayeredPane4Layout.setVerticalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(trainingSessionID)
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addComponent(trainingSessionName, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(trainingSessionDate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(trainingSessionTime))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(trainingSessionLevel))
                        .addGap(12, 12, 12)
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(trainingSessionStatus)))
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(trainingSessionCustomersNum))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(trainingSessionTrainer))
                .addGap(17, 31, Short.MAX_VALUE))
        );

        jLayeredPane8.setBackground(new java.awt.Color(0, 153, 204));
        jLayeredPane8.setForeground(new java.awt.Color(102, 255, 102));
        jLayeredPane8.setOpaque(true);

        jLabel11.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 25)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oodj_assignment/resources/cancel.png"))); // NOI18N
        jLabel11.setText("Cancel Training Session");

        jLayeredPane8.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane8Layout = new javax.swing.GroupLayout(jLayeredPane8);
        jLayeredPane8.setLayout(jLayeredPane8Layout);
        jLayeredPane8Layout.setHorizontalGroup(
            jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(336, Short.MAX_VALUE))
        );
        jLayeredPane8Layout.setVerticalGroup(
            jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(20, 20, 20))
        );

        selectTrainingSession.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
        selectTrainingSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectTrainingSessionActionPerformed(evt);
            }
        });

        backBut.setBackground(new java.awt.Color(255, 102, 102));
        backBut.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        backBut.setText("BACK");
        backBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButActionPerformed(evt);
            }
        });

        cancelBut.setBackground(new java.awt.Color(102, 204, 0));
        cancelBut.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        cancelBut.setText("CANCEL SESSION");
        cancelBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane8)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backBut, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelBut)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectTrainingSession, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLayeredPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(selectTrainingSession))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBut, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelBut, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButActionPerformed
        // TODO add your handling code here:
        if(trainingSessionID.getText().equals("-----")){
            JOptionPane.showMessageDialog(null, "No training session selected" , "Try again",JOptionPane.ERROR_MESSAGE);
        } else{
            int input = JOptionPane.showConfirmDialog(null, "Are you Sure?");
            if(input==0){
                String sessionID = trainingSessionID.getText().split("#")[1];
                TrainingSession session = null;
                for(TrainingSession ts: APUGym.getTrainingSessions()){
                    if(ts.getTrainingSessionID().equals(sessionID)){
                        session = ts;
                    }
                }
                session.setTrainingSessionStatus("Cancelled");
                for(Payment pay: APUGym.getPayments()){
                    if(Arrays.asList(session.getCustomerID()).contains(pay.getCustomerID()) && pay.getPaymentStatus().equals("Pending") && pay.getPaymentItem().startsWith(sessionID)){
                        pay.setPaymentStatus("Cancelled");
                    }
                }
                new managerTrainerMenuForm(APUGym, ma_acc).setVisible(true);
                this.dispose();
            } else{
                JOptionPane.getRootFrame().dispose();
            }
        }
    }//GEN-LAST:event_cancelButActionPerformed

    private void backButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButActionPerformed
        // TODO add your handling code here:
        new managerTrainerMenuForm(APUGym, ma_acc).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButActionPerformed

    private void selectTrainingSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectTrainingSessionActionPerformed
        // TODO add your handling code here:
        if(selectTrainingSession.getSelectedItem().equals("-")){
            trainingSessionID.setText("ID: -----");
            trainingSessionName.setText("No Session Selected");
            trainingSessionTrainer.setText("-----");
            trainingSessionDate.setText("-----");
            trainingSessionTime.setText("-----");
            trainingSessionLevel.setText("-----");
            trainingSessionStatus.setText("-----");
            trainingSessionCustomersNum.setText("0");
            DefaultTableModel customersModel = (DefaultTableModel) customersTable.getModel();
            customersModel.setRowCount(0);
        } else{
            String selectedID = selectTrainingSession.getSelectedItem().toString().split(" - ")[0];
            TrainingSession session = null;
            for(TrainingSession ts: APUGym.getTrainingSessions()){
                if(ts.getTrainingSessionID().equals(selectedID)){
                    session = ts;
                }
            }
            trainingSessionID.setText("ID: #" + session.getTrainingSessionID());
            trainingSessionName.setText(session.getTrainingSessionName());
            trainingSessionTrainer.setText(session.getTrainerName(APUGym.getTrainers()));
            trainingSessionDate.setText(session.getTrainingSessionDate());
            trainingSessionTime.setText(session.getTrainingSessionDuration());
            trainingSessionLevel.setText(session.getTrainingSessionLevel());
            trainingSessionStatus.setText(session.getTrainingSessionStatus());
            DefaultTableModel customersModel = (DefaultTableModel) customersTable.getModel();
            customersModel.setRowCount(0);
            String[] bookedCustomerID = session.getCustomerID();
            String[] bookedCustomerName = session.getCustomerName(APUGym.getCustomers());
            for(int i=0; i<bookedCustomerID.length; i++){
                customersModel.addRow(new Object[]{bookedCustomerID[i], bookedCustomerName[i]});
            }
            trainingSessionCustomersNum.setText(String.valueOf(bookedCustomerID.length));
        }
    }//GEN-LAST:event_selectTrainingSessionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBut;
    private javax.swing.JButton cancelBut;
    private javax.swing.JTable customersTable;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JLayeredPane jLayeredPane8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> selectTrainingSession;
    private javax.swing.JLabel trainingSessionCustomersNum;
    private javax.swing.JLabel trainingSessionDate;
    private javax.swing.JLabel trainingSessionID;
    private javax.swing.JLabel trainingSessionLevel;
    private javax.swing.JLabel trainingSessionName;
    private javax.swing.JLabel trainingSessionStatus;
    private javax.swing.JLabel trainingSessionTime;
    private javax.swing.JLabel trainingSessionTrainer;
    // End of variables declaration//GEN-END:variables
}
