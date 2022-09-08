/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oodj_assignment;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class managerTrainingSessionFeedbackForm extends javax.swing.JFrame {

    private Gym APUGym;
    private Manager ma_acc;
    private TrainingSession ts_details;
    
    public managerTrainingSessionFeedbackForm(Gym APUGym, Manager ma_acc, TrainingSession ts_details) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        getContentPane().setBackground(Color.WHITE);

        this.APUGym = APUGym;
        this.ma_acc = ma_acc;
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
        jLayeredPane8 = new javax.swing.JLayeredPane();
        jLabel18 = new javax.swing.JLabel();
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
            feedbackTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            feedbackTable.getColumnModel().getColumn(0).setMaxWidth(50);
            feedbackTable.getColumnModel().getColumn(1).setPreferredWidth(150);
            feedbackTable.getColumnModel().getColumn(1).setMaxWidth(150);
            feedbackTable.getColumnModel().getColumn(3).setPreferredWidth(70);
            feedbackTable.getColumnModel().getColumn(3).setMaxWidth(70);
        }

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Total Feedback: ");

        feedbackNum.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        feedbackNum.setText("0");

        jLayeredPane8.setBackground(new java.awt.Color(0, 153, 204));
        jLayeredPane8.setForeground(new java.awt.Color(102, 255, 102));
        jLayeredPane8.setOpaque(true);

        jLabel18.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 25)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oodj_assignment/resources/feedback logo.png"))); // NOI18N
        jLabel18.setText("Feedback of Training Session");

        feedbackTrainingSessionID.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        feedbackTrainingSessionID.setForeground(new java.awt.Color(255, 255, 255));
        feedbackTrainingSessionID.setText("# TS001");

        jLayeredPane8.setLayer(jLabel18, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(feedbackTrainingSessionID, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane8Layout = new javax.swing.GroupLayout(jLayeredPane8);
        jLayeredPane8.setLayout(jLayeredPane8Layout);
        jLayeredPane8Layout.setHorizontalGroup(
            jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(feedbackTrainingSessionID, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane8Layout.setVerticalGroup(
            jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane8Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 451, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(feedbackNum)
                .addGap(40, 40, 40))
            .addComponent(jLayeredPane8, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(365, 365, 365)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBut, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(feedbackNum))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(98, 98, 98)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(84, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButActionPerformed
        // TODO add your handling code here:
        new managerViewTrainingSessionDetailsForm(APUGym,ma_acc,ts_details).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBut;
    private javax.swing.JLabel feedbackNum;
    private javax.swing.JTable feedbackTable;
    private javax.swing.JLabel feedbackTrainingSessionID;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane8;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}