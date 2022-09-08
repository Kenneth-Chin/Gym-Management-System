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
/**
 *
 * @author User
 */
public class customerTrainingSessionForm extends javax.swing.JFrame {

    /**
     * Creates new form customerTrainingSessionForm
     */
    private Gym APUGym;
    private Customer cust_acc;
    
    public customerTrainingSessionForm(Gym APUGym, Customer cust_acc) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        this.APUGym = APUGym;
        this.cust_acc = cust_acc;
        
        pastSessionsTable.setRowHeight(35);
        upcomingSessionsTable.setRowHeight(35);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        pastSessionsTable.setDefaultRenderer(String.class, centerRenderer);
        upcomingSessionsTable.setDefaultRenderer(String.class, centerRenderer);
        ArrayList<TrainingSession> TrainingSessions = APUGym.getTrainingSessions();
        
        DefaultTableModel pastSessionsModel = (DefaultTableModel) pastSessionsTable.getModel();
        DefaultTableModel upcomingSessionsModel = (DefaultTableModel) upcomingSessionsTable.getModel();
        int totalSessions = 0;
        for(int i = TrainingSessions.size() - 1; i >= 0; i--){
            TrainingSession ts = TrainingSessions.get(i);
            if(Arrays.asList(ts.getCustomerID()).contains(cust_acc.getUserID())){
                totalSessions++;
                if(ts.getTrainingSessionStatus().equals("Completed") || ts.getTrainingSessionStatus().equals("Cancelled")){
                    pastSessionsModel.addRow(new Object[]{
                        ts.getTrainingSessionID(), 
                        ts.getTrainingSessionName(),
                        ts.getTrainerName(APUGym.getTrainers()), 
                        ts.getTrainingSessionDate() + " - " + ts.getTrainingSessionDuration(),
                        ts.getTrainingSessionStatus()});
                } else if(ts.getTrainingSessionStatus().equals("Not Started")){
                    upcomingSessionsModel.addRow(new Object[]{
                        ts.getTrainingSessionID(), 
                        ts.getTrainingSessionName(),
                        ts.getTrainerName(APUGym.getTrainers()), 
                        ts.getTrainingSessionDate() + " - " + ts.getTrainingSessionDuration(),
                        ts.getTrainingSessionStatus()});
                }
            }
        }
        totalSessionsNum.setText(Integer.toString(totalSessions));
        
        pastSessionsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                JFrame frame = (JFrame) SwingUtilities.getRoot(mouseEvent.getComponent());
                JTable table =(JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    for(TrainingSession ts: APUGym.getTrainingSessions()){
                        if(ts.getTrainingSessionID() == table.getValueAt(row, 0)){
                            new customerTrainingSessionDetailsForm(APUGym, cust_acc, ts).setVisible(true);
                            frame.dispose();
                            break;
                        }
                    }
                }
            }
        });
        
        upcomingSessionsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                JFrame frame = (JFrame) SwingUtilities.getRoot(mouseEvent.getComponent());
                JTable table =(JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    for(TrainingSession ts: APUGym.getTrainingSessions()){
                        if(ts.getTrainingSessionID() == table.getValueAt(row, 0)){
                            new customerTrainingSessionDetailsForm(APUGym, cust_acc, ts).setVisible(true);
                            frame.dispose();
                            break;
                        }
                    }
                }
            }
        });
        
        TableRowSorter<TableModel> pastSessionsRowSorter = new TableRowSorter<>(pastSessionsTable.getModel());
        pastSessionsTable.setRowSorter(pastSessionsRowSorter);
        pastSessionsSearchField.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = pastSessionsSearchField.getText();

                if (text.trim().length() == 0) {
                    pastSessionsRowSorter.setRowFilter(null);
                } else {
                    pastSessionsRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = pastSessionsSearchField.getText();

                if (text.trim().length() == 0) {
                    pastSessionsRowSorter.setRowFilter(null);
                } else {
                    pastSessionsRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        
        TableRowSorter<TableModel> upcomingSessionsRowSorter = new TableRowSorter<>(upcomingSessionsTable.getModel());
        upcomingSessionsTable.setRowSorter(upcomingSessionsRowSorter);
        upcomingSessionsSearchField.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = upcomingSessionsSearchField.getText();

                if (text.trim().length() == 0) {
                    upcomingSessionsRowSorter.setRowFilter(null);
                } else {
                    upcomingSessionsRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = upcomingSessionsSearchField.getText();

                if (text.trim().length() == 0) {
                    upcomingSessionsRowSorter.setRowFilter(null);
                } else {
                    upcomingSessionsRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
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
        pastSessionsSearchField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pastSessionsTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        upcomingSessionsSearchField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        upcomingSessionsTable = new javax.swing.JTable();
        returnBut = new javax.swing.JButton();
        totalSessionsLabel = new javax.swing.JLabel();
        totalSessionsNum = new javax.swing.JLabel();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pastSessionsSearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pastSessionsSearchFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Search:");

        pastSessionsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Session Name", "Trainer", "Date & Time", "Status"
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
        pastSessionsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(pastSessionsTable);
        if (pastSessionsTable.getColumnModel().getColumnCount() > 0) {
            pastSessionsTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            pastSessionsTable.getColumnModel().getColumn(0).setMaxWidth(50);
            pastSessionsTable.getColumnModel().getColumn(2).setPreferredWidth(120);
            pastSessionsTable.getColumnModel().getColumn(2).setMaxWidth(120);
            pastSessionsTable.getColumnModel().getColumn(3).setPreferredWidth(150);
            pastSessionsTable.getColumnModel().getColumn(3).setMaxWidth(150);
            pastSessionsTable.getColumnModel().getColumn(4).setPreferredWidth(70);
            pastSessionsTable.getColumnModel().getColumn(4).setMaxWidth(70);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pastSessionsSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pastSessionsSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Past Sessions", jPanel1);

        upcomingSessionsSearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upcomingSessionsSearchFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Search:");

        upcomingSessionsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Session Name", "Trainer", "Date & Time", "Status"
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
        upcomingSessionsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(upcomingSessionsTable);
        if (upcomingSessionsTable.getColumnModel().getColumnCount() > 0) {
            upcomingSessionsTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            upcomingSessionsTable.getColumnModel().getColumn(0).setMaxWidth(50);
            upcomingSessionsTable.getColumnModel().getColumn(2).setPreferredWidth(120);
            upcomingSessionsTable.getColumnModel().getColumn(2).setMaxWidth(120);
            upcomingSessionsTable.getColumnModel().getColumn(3).setPreferredWidth(150);
            upcomingSessionsTable.getColumnModel().getColumn(3).setMaxWidth(150);
            upcomingSessionsTable.getColumnModel().getColumn(4).setPreferredWidth(70);
            upcomingSessionsTable.getColumnModel().getColumn(4).setMaxWidth(70);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(upcomingSessionsSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(upcomingSessionsSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Upcoming Sessions", jPanel2);

        returnBut.setText("Return to Customer Menu");
        returnBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButActionPerformed(evt);
            }
        });

        totalSessionsLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totalSessionsLabel.setText("Total Sessions:");

        totalSessionsNum.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totalSessionsNum.setText("0");

        jLayeredPane3.setBackground(new java.awt.Color(255, 102, 102));
        jLayeredPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        jLayeredPane3.setForeground(new java.awt.Color(102, 255, 102));
        jLayeredPane3.setOpaque(true);

        jLabel11.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 25)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Training Sessions");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oodj_assignment/resources/fitness.png"))); // NOI18N

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
                .addComponent(totalSessionsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalSessionsNum)
                .addGap(49, 49, 49))
            .addComponent(jLayeredPane3)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalSessionsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(totalSessionsNum)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(returnBut, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pastSessionsSearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pastSessionsSearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pastSessionsSearchFieldActionPerformed

    private void upcomingSessionsSearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upcomingSessionsSearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_upcomingSessionsSearchFieldActionPerformed

    private void returnButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButActionPerformed
        // TODO add your handling code here:
        new customerMenuForm(APUGym, cust_acc).setVisible(true);
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
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField pastSessionsSearchField;
    private javax.swing.JTable pastSessionsTable;
    private javax.swing.JButton returnBut;
    private javax.swing.JLabel totalSessionsLabel;
    private javax.swing.JLabel totalSessionsNum;
    private javax.swing.JTextField upcomingSessionsSearchField;
    private javax.swing.JTable upcomingSessionsTable;
    // End of variables declaration//GEN-END:variables
}
