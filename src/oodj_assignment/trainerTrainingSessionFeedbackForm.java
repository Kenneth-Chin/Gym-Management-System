/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oodj_assignment;

import java.awt.Color;
import javax.swing.*;
import javax.swing.table.*;

public class trainerTrainingSessionFeedbackForm extends javax.swing.JFrame {

    /**
     * Creates new form customerTrainingSessionForm
     */
    private Gym APUGym;
    private Trainer tr_acc;
    private TrainingSession ts_details;
    
    public trainerTrainingSessionFeedbackForm(Gym APUGym, Trainer tr_acc, TrainingSession ts_details) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        this.APUGym = APUGym;
        this.tr_acc = tr_acc;
        this.ts_details = ts_details;
        feedbackTrainingSessionID.setText("# " + ts_details.getTrainingSessionID());
        
        feedbackTable.setRowHeight(35);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        feedbackTable.setDefaultRenderer(String.class, centerRenderer);
        DefaultTableModel feedbackModel = (DefaultTableModel) feedbackTable.getModel();
        int totalFeedback = 0;
        for(Feedback fe: APUGym.getFeedbacks()){
            if(fe.getTrainingSessionID().equals(ts_details.getTrainingSessionID())){
                totalFeedback++;
                feedbackModel.addRow(new Object[]{fe.getFeedbackID(), 
                    fe.getCustomerName(APUGym.getCustomers()), 
                    fe.getFeedbackComment(), String.valueOf(fe.getFeedbackRating())});
            }
        }
        feedbackNum.setText(String.valueOf(totalFeedback));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backBut = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        feedbackTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        feedbackNum = new javax.swing.JLabel();
        jLayeredPane10 = new javax.swing.JLayeredPane();
        jLabel20 = new javax.swing.JLabel();
        feedbackTrainingSessionID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backBut.setText("Back");
        backBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButActionPerformed(evt);
            }
        });

        feedbackTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Customer Name", "Feedback Comment", "Rating"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        feedbackTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(feedbackTable);
        if (feedbackTable.getColumnModel().getColumnCount() > 0) {
            feedbackTable.getColumnModel().getColumn(0).setPreferredWidth(70);
            feedbackTable.getColumnModel().getColumn(0).setMaxWidth(70);
            feedbackTable.getColumnModel().getColumn(1).setPreferredWidth(150);
            feedbackTable.getColumnModel().getColumn(1).setMaxWidth(150);
            feedbackTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            feedbackTable.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Total Feedback: ");

        feedbackNum.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        feedbackNum.setText("0");

        jLayeredPane10.setBackground(new java.awt.Color(0, 204, 51));
        jLayeredPane10.setForeground(new java.awt.Color(102, 255, 102));
        jLayeredPane10.setOpaque(true);

        jLabel20.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 25)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oodj_assignment/resources/feedback logo.png"))); // NOI18N
        jLabel20.setText("Feedback of Training Session");

        feedbackTrainingSessionID.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        feedbackTrainingSessionID.setForeground(new java.awt.Color(255, 255, 255));
        feedbackTrainingSessionID.setText("# T001");

        jLayeredPane10.setLayer(jLabel20, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane10.setLayer(feedbackTrainingSessionID, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane10Layout = new javax.swing.GroupLayout(jLayeredPane10);
        jLayeredPane10.setLayout(jLayeredPane10Layout);
        jLayeredPane10Layout.setHorizontalGroup(
            jLayeredPane10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(feedbackTrainingSessionID, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane10Layout.setVerticalGroup(
            jLayeredPane10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane10Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jLayeredPane10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(feedbackTrainingSessionID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(backBut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 452, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(feedbackNum)
                .addGap(40, 40, 40))
            .addComponent(jLayeredPane10)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBut, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(feedbackNum))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButActionPerformed
        // TODO add your handling code here:
        new trainerTrainingSessionDetailsForm(APUGym, tr_acc, ts_details).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBut;
    private javax.swing.JLabel feedbackNum;
    private javax.swing.JTable feedbackTable;
    private javax.swing.JLabel feedbackTrainingSessionID;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane10;
    private javax.swing.JLayeredPane jLayeredPane8;
    private javax.swing.JLayeredPane jLayeredPane9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel trainingSessionID;
    private javax.swing.JLabel trainingSessionID1;
    // End of variables declaration//GEN-END:variables
}
