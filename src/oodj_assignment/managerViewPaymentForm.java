/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oodj_assignment;

import java.awt.Color;
import javax.swing.JLabel;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class managerViewPaymentForm extends javax.swing.JFrame {

    private Gym APUGym;
    private Manager ma_acc;
    
    public managerViewPaymentForm(Gym APUGym, Manager ma_acc) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        
        this.APUGym = APUGym;
        this.ma_acc = ma_acc;
        
	transHistoryTable.setRowHeight(35);
        outPaymentsTable.setRowHeight(35);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        transHistoryTable.setDefaultRenderer(String.class, centerRenderer);
        outPaymentsTable.setDefaultRenderer(String.class, centerRenderer);

        ArrayList<Payment> Payments = APUGym.getPayments();
        
        DefaultTableModel transHistoryModel = (DefaultTableModel) transHistoryTable.getModel();
        DefaultTableModel outPaymentsModel = (DefaultTableModel) outPaymentsTable.getModel();
        double totalAmount = 0;
        for(int i = Payments.size() - 1; i >= 0; i--){
            Payment pay = Payments.get(i);
            if(pay.getPaymentStatus().equals("Paid")||pay.getPaymentStatus().equals("Cancelled")){
               transHistoryModel.addRow(new Object[]{
                   pay.getPaymentID(), 
                   pay.getCustomerName(APUGym.getCustomers()),
                   pay.getPaymentItem(),
                   "RM "+String.format("%.2f", pay.getPaymentAmount()),
                   pay.getPaymentDateTime().replace("T"," "),
                   pay.getPaymentStatus()});
               if(pay.getPaymentStatus().equals("Paid")){
                   totalAmount = totalAmount + pay.getPaymentAmount();
               }
            } else if(pay.getPaymentStatus().equals("Pending")){
               outPaymentsModel.addRow(new Object[]{
                   pay.getPaymentID(), 
                   pay.getCustomerName(APUGym.getCustomers()),
                   pay.getPaymentItem(),
                   "RM "+String.format("%.2f", pay.getPaymentAmount()),
                   pay.getPaymentDateTime().replace("T"," ")});
            }
        }
        totalAmountNum.setText(String.format("%.2f", totalAmount));
        
        TableRowSorter<TableModel> transHistoryRowSorter = new TableRowSorter<>(transHistoryTable.getModel());
        transHistoryTable.setRowSorter(transHistoryRowSorter);
        transHistorySearchField.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = transHistorySearchField.getText();

                if (text.trim().length() == 0) {
                    transHistoryRowSorter.setRowFilter(null);
                } else {
                    transHistoryRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = transHistorySearchField.getText();

                if (text.trim().length() == 0) {
                    transHistoryRowSorter.setRowFilter(null);
                } else {
                    transHistoryRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        
        TableRowSorter<TableModel> outPaymentsRowSorter = new TableRowSorter<>(outPaymentsTable.getModel());
        outPaymentsTable.setRowSorter(outPaymentsRowSorter);
        outPaymentsSearchField.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = outPaymentsSearchField.getText();

                if (text.trim().length() == 0) {
                    outPaymentsRowSorter.setRowFilter(null);
                } else {
                    outPaymentsRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = outPaymentsSearchField.getText();

                if (text.trim().length() == 0) {
                    outPaymentsRowSorter.setRowFilter(null);
                } else {
                    outPaymentsRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
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
        transHistorySearchField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        transHistoryTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        outPaymentsSearchField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        outPaymentsTable = new javax.swing.JTable();
        returnBut = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        totalAmountNum = new javax.swing.JLabel();
        jLayeredPane8 = new javax.swing.JLayeredPane();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        transHistorySearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transHistorySearchFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Search:");

        transHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
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
        transHistoryTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(transHistoryTable);
        if (transHistoryTable.getColumnModel().getColumnCount() > 0) {
            transHistoryTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            transHistoryTable.getColumnModel().getColumn(0).setMaxWidth(50);
            transHistoryTable.getColumnModel().getColumn(1).setPreferredWidth(140);
            transHistoryTable.getColumnModel().getColumn(1).setMaxWidth(140);
            transHistoryTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            transHistoryTable.getColumnModel().getColumn(3).setMaxWidth(100);
            transHistoryTable.getColumnModel().getColumn(4).setPreferredWidth(140);
            transHistoryTable.getColumnModel().getColumn(4).setMaxWidth(140);
            transHistoryTable.getColumnModel().getColumn(5).setPreferredWidth(70);
            transHistoryTable.getColumnModel().getColumn(5).setMaxWidth(70);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(transHistorySearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(transHistorySearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Transaction History", jPanel1);

        outPaymentsSearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outPaymentsSearchFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Search:");

        outPaymentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Customer Name", "Purchased Item", "Payment Amount", "Date & Time"
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
        outPaymentsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(outPaymentsTable);
        if (outPaymentsTable.getColumnModel().getColumnCount() > 0) {
            outPaymentsTable.getColumnModel().getColumn(0).setPreferredWidth(70);
            outPaymentsTable.getColumnModel().getColumn(0).setMaxWidth(70);
            outPaymentsTable.getColumnModel().getColumn(1).setPreferredWidth(150);
            outPaymentsTable.getColumnModel().getColumn(1).setMaxWidth(150);
            outPaymentsTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            outPaymentsTable.getColumnModel().getColumn(3).setMaxWidth(100);
            outPaymentsTable.getColumnModel().getColumn(4).setPreferredWidth(30);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outPaymentsSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(outPaymentsSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Outstanding Payments", jPanel2);

        returnBut.setText("Return to Manager Menu");
        returnBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Total Received Amount: RM");

        totalAmountNum.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totalAmountNum.setText("0");

        jLayeredPane8.setBackground(new java.awt.Color(0, 153, 204));
        jLayeredPane8.setForeground(new java.awt.Color(102, 255, 102));
        jLayeredPane8.setOpaque(true);

        jLabel11.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 25)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oodj_assignment/resources/payment logo.png"))); // NOI18N
        jLabel11.setText("Payment Received");

        jLayeredPane8.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane8Layout = new javax.swing.GroupLayout(jLayeredPane8);
        jLayeredPane8.setLayout(jLayeredPane8Layout);
        jLayeredPane8Layout.setHorizontalGroup(
            jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane8Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane8Layout.setVerticalGroup(
            jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(20, 20, 20))
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
                .addComponent(totalAmountNum)
                .addGap(47, 47, 47))
            .addComponent(jLayeredPane8)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(returnBut, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalAmountNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void transHistorySearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transHistorySearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_transHistorySearchFieldActionPerformed

    private void outPaymentsSearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outPaymentsSearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outPaymentsSearchFieldActionPerformed

    private void returnButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButActionPerformed
        // TODO add your handling code here:
        new managerCustomerMenuForm(APUGym,ma_acc).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_returnButActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane jLayeredPane8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField outPaymentsSearchField;
    private javax.swing.JTable outPaymentsTable;
    private javax.swing.JButton returnBut;
    private javax.swing.JLabel totalAmountNum;
    private javax.swing.JTextField transHistorySearchField;
    private javax.swing.JTable transHistoryTable;
    // End of variables declaration//GEN-END:variables
}
