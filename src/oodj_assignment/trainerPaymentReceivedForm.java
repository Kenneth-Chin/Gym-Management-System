/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oodj_assignment;

import java.util.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import javax.swing.border.*;

/**
 *
 * @author User
 */
public class trainerPaymentReceivedForm extends javax.swing.JFrame {

    /**
     * Creates new form customerTrainingSessionForm
     */
    private Gym APUGym;
    private Trainer tr_acc;
    
    public trainerPaymentReceivedForm(Gym APUGym, Trainer tr_acc) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        this.APUGym = APUGym;
        this.tr_acc = tr_acc;
        
        transactionHistoryTable.setRowHeight(35);
        outstandingPaymentsTable.setRowHeight(35);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        transactionHistoryTable.setDefaultRenderer(String.class, centerRenderer);
        outstandingPaymentsTable.setDefaultRenderer(String.class, centerRenderer);
        ArrayList<Payment> Payments = APUGym.getPayments();
        
        DefaultTableModel paymentHistoryModel = (DefaultTableModel) transactionHistoryTable.getModel();
        DefaultTableModel pendingPaymentsModel = (DefaultTableModel) outstandingPaymentsTable.getModel();
        double totalReceivedAmount = 0;
        for(int i = Payments.size() - 1; i >= 0; i--){
            Payment pay = Payments.get(i);
            if(pay.getStaffID().equals(tr_acc.getUserID())){
                if(pay.getPaymentStatus().equals("Paid") || pay.getPaymentStatus().equals("Cancelled")){
                    paymentHistoryModel.addRow(new Object[]{
                        pay.getPaymentID(),
                        pay.getCustomerName(APUGym.getCustomers()),
                        pay.getPaymentItem(),
                        "RM " + String.format("%.2f", pay.getPaymentAmount()),
                        pay.getPaymentDateTime().replace("T", " "),
                        pay.getPaymentStatus()});
                    if(pay.getPaymentStatus().equals("Paid")){
                        totalReceivedAmount += pay.getPaymentAmount();
                    }
                } else if(pay.getPaymentStatus().equals("Pending")){
                    pendingPaymentsModel.addRow(new Object[]{
                        pay.getPaymentID(),
                        pay.getCustomerName(APUGym.getCustomers()),
                        pay.getPaymentItem(),
                        "RM " + String.format("%.2f", pay.getPaymentAmount()),
                        pay.getPaymentDateTime().replace("T", " ")});
                }
            }
        }

        totalReceivedAmountNum.setText(String.format("%.2f", totalReceivedAmount));
        
        TableRowSorter<TableModel> transactionHistoryRowSorter = new TableRowSorter<>(transactionHistoryTable.getModel());
        transactionHistoryTable.setRowSorter(transactionHistoryRowSorter);
        transactionHistorySearchField.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = transactionHistorySearchField.getText();

                if (text.trim().length() == 0) {
                    transactionHistoryRowSorter.setRowFilter(null);
                } else {
                    transactionHistoryRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = transactionHistorySearchField.getText();

                if (text.trim().length() == 0) {
                    transactionHistoryRowSorter.setRowFilter(null);
                } else {
                    transactionHistoryRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        
        TableRowSorter<TableModel> outstandingPaymentsRowSorter = new TableRowSorter<>(outstandingPaymentsTable.getModel());
        outstandingPaymentsTable.setRowSorter(outstandingPaymentsRowSorter);
        outstandingPaymentsSearchField.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = outstandingPaymentsSearchField.getText();

                if (text.trim().length() == 0) {
                    outstandingPaymentsRowSorter.setRowFilter(null);
                } else {
                    outstandingPaymentsRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = outstandingPaymentsSearchField.getText();

                if (text.trim().length() == 0) {
                    outstandingPaymentsRowSorter.setRowFilter(null);
                } else {
                    outstandingPaymentsRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        transactionHistorySearchField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        transactionHistoryTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        outstandingPaymentsSearchField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        outstandingPaymentsTable = new javax.swing.JTable();
        returnBut = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        totalReceivedAmountNum = new javax.swing.JLabel();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        transactionHistorySearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionHistorySearchFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Search:");

        transactionHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Customer Name", "Purchased Item", "Payment Amount", "Date & Time", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        transactionHistoryTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(transactionHistoryTable);
        if (transactionHistoryTable.getColumnModel().getColumnCount() > 0) {
            transactionHistoryTable.getColumnModel().getColumn(0).setPreferredWidth(70);
            transactionHistoryTable.getColumnModel().getColumn(0).setMaxWidth(70);
            transactionHistoryTable.getColumnModel().getColumn(1).setPreferredWidth(110);
            transactionHistoryTable.getColumnModel().getColumn(1).setMaxWidth(110);
            transactionHistoryTable.getColumnModel().getColumn(3).setPreferredWidth(110);
            transactionHistoryTable.getColumnModel().getColumn(3).setMaxWidth(110);
            transactionHistoryTable.getColumnModel().getColumn(4).setPreferredWidth(130);
            transactionHistoryTable.getColumnModel().getColumn(4).setMaxWidth(130);
            transactionHistoryTable.getColumnModel().getColumn(5).setPreferredWidth(80);
            transactionHistoryTable.getColumnModel().getColumn(5).setMaxWidth(80);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(transactionHistorySearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(492, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(transactionHistorySearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Transaction History", jPanel1);

        outstandingPaymentsSearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outstandingPaymentsSearchFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Search:");

        outstandingPaymentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Customer Name", "Purchased Item", "Outstanding Amount", "Date & Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        outstandingPaymentsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(outstandingPaymentsTable);
        if (outstandingPaymentsTable.getColumnModel().getColumnCount() > 0) {
            outstandingPaymentsTable.getColumnModel().getColumn(0).setPreferredWidth(70);
            outstandingPaymentsTable.getColumnModel().getColumn(0).setMaxWidth(70);
            outstandingPaymentsTable.getColumnModel().getColumn(1).setPreferredWidth(125);
            outstandingPaymentsTable.getColumnModel().getColumn(1).setMaxWidth(125);
            outstandingPaymentsTable.getColumnModel().getColumn(3).setPreferredWidth(130);
            outstandingPaymentsTable.getColumnModel().getColumn(3).setMaxWidth(130);
            outstandingPaymentsTable.getColumnModel().getColumn(4).setPreferredWidth(140);
            outstandingPaymentsTable.getColumnModel().getColumn(4).setMaxWidth(140);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outstandingPaymentsSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(outstandingPaymentsSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Outstanding Payments", jPanel2);

        returnBut.setText("Return to Trainer Menu");
        returnBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Total Received Amount: RM");

        totalReceivedAmountNum.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totalReceivedAmountNum.setText("0");

        jLayeredPane3.setBackground(new java.awt.Color(0, 204, 51));
        jLayeredPane3.setForeground(new java.awt.Color(102, 255, 102));
        jLayeredPane3.setOpaque(true);

        jLabel11.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 25)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Payment Received ");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oodj_assignment/resources/payment.png"))); // NOI18N

        jButton6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLayeredPane3.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jButton6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addContainerGap())
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(31, 31, 31))
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel12))
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(returnBut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalReceivedAmountNum)
                .addGap(48, 48, 48))
            .addComponent(jLayeredPane3)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalReceivedAmountNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(returnBut, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void transactionHistorySearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionHistorySearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_transactionHistorySearchFieldActionPerformed

    private void outstandingPaymentsSearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outstandingPaymentsSearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outstandingPaymentsSearchFieldActionPerformed

    private void returnButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButActionPerformed
        // TODO add your handling code here:
        new trainerMenuForm(APUGym, tr_acc).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_returnButActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField outstandingPaymentsSearchField;
    private javax.swing.JTable outstandingPaymentsTable;
    private javax.swing.JButton returnBut;
    private javax.swing.JLabel totalReceivedAmountNum;
    private javax.swing.JTextField transactionHistorySearchField;
    private javax.swing.JTable transactionHistoryTable;
    // End of variables declaration//GEN-END:variables
}
