/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oodj_assignment;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JLabel;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class managerViewTrainingSessionForm extends javax.swing.JFrame {

    private Gym APUGym;
    private Manager ma_acc;
    
    public managerViewTrainingSessionForm(Gym APUGym, Manager ma_acc) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        
        this.APUGym = APUGym;
        this.ma_acc = ma_acc;
        
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
            totalSessions++;
            if(ts.getTrainingSessionStatus().equals("Completed") || ts.getTrainingSessionStatus().equals("Cancelled")){
               pastSessionsModel.addRow(new Object[]{
                   ts.getTrainingSessionID(), 
                   ts.getTrainingSessionName(),
                   ts.getTrainerName(APUGym.getTrainers()), 
                   String.join(", ", ts.getCustomerName(APUGym.getCustomers())),
                   ts.getTrainingSessionDate() + " - " + ts.getTrainingSessionDuration(),
                   ts.getTrainingSessionStatus()});
            } else if(ts.getTrainingSessionStatus().equals("Not Started")){
               upcomingSessionsModel.addRow(new Object[]{
                   ts.getTrainingSessionID(), 
                   ts.getTrainingSessionName(),
                   ts.getTrainerName(APUGym.getTrainers()), 
                   String.join(", ", ts.getCustomerName(APUGym.getCustomers())),
                   ts.getTrainingSessionDate() + " - " + ts.getTrainingSessionDuration(),
                   ts.getTrainingSessionStatus()});
            }
        }
        totalSessionsNum.setText(Integer.toString(totalSessions));
        
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
        
        pastSessionsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                JFrame frame = (JFrame) SwingUtilities.getRoot(mouseEvent.getComponent());
                JTable table =(JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    for(TrainingSession ts_details: APUGym.getTrainingSessions()){
                        if(ts_details.getTrainingSessionID() == table.getValueAt(row, 0)){
                            new managerViewTrainingSessionDetailsForm(APUGym, ma_acc, ts_details).setVisible(true);
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
                    for(TrainingSession ts_details: APUGym.getTrainingSessions()){
                        if(ts_details.getTrainingSessionID() == table.getValueAt(row, 0)){
                            new managerViewTrainingSessionDetailsForm(APUGym, ma_acc, ts_details).setVisible(true);
                            frame.dispose();
                            break;
                        }
                    }
                }
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
        jLabel5 = new javax.swing.JLabel();
        totalSessionsNum = new javax.swing.JLabel();
        jLayeredPane9 = new javax.swing.JLayeredPane();
        jLabel12 = new javax.swing.JLabel();

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
                "ID", "Session Name", "Trainer", "Customers", "Date & Time", "Status"
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
        pastSessionsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(pastSessionsTable);
        if (pastSessionsTable.getColumnModel().getColumnCount() > 0) {
            pastSessionsTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            pastSessionsTable.getColumnModel().getColumn(0).setMaxWidth(70);
            pastSessionsTable.getColumnModel().getColumn(1).setPreferredWidth(170);
            pastSessionsTable.getColumnModel().getColumn(1).setMaxWidth(170);
            pastSessionsTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            pastSessionsTable.getColumnModel().getColumn(2).setMaxWidth(100);
            pastSessionsTable.getColumnModel().getColumn(3).setPreferredWidth(150);
            pastSessionsTable.getColumnModel().getColumn(3).setMaxWidth(150);
            pastSessionsTable.getColumnModel().getColumn(4).setPreferredWidth(150);
            pastSessionsTable.getColumnModel().getColumn(4).setMaxWidth(150);
            pastSessionsTable.getColumnModel().getColumn(5).setPreferredWidth(70);
            pastSessionsTable.getColumnModel().getColumn(5).setMaxWidth(70);
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                "ID", "Session Name", "Trainer", "Customers", "Date & Time", "Status"
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
        upcomingSessionsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(upcomingSessionsTable);
        if (upcomingSessionsTable.getColumnModel().getColumnCount() > 0) {
            upcomingSessionsTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            upcomingSessionsTable.getColumnModel().getColumn(0).setMaxWidth(50);
            upcomingSessionsTable.getColumnModel().getColumn(1).setPreferredWidth(170);
            upcomingSessionsTable.getColumnModel().getColumn(1).setMaxWidth(170);
            upcomingSessionsTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            upcomingSessionsTable.getColumnModel().getColumn(2).setMaxWidth(100);
            upcomingSessionsTable.getColumnModel().getColumn(4).setPreferredWidth(150);
            upcomingSessionsTable.getColumnModel().getColumn(4).setMaxWidth(150);
            upcomingSessionsTable.getColumnModel().getColumn(5).setPreferredWidth(70);
            upcomingSessionsTable.getColumnModel().getColumn(5).setMaxWidth(70);
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

        returnBut.setText("Return to Manager Menu");
        returnBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Total Sessions:");

        totalSessionsNum.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totalSessionsNum.setText("0");

        jLayeredPane9.setBackground(new java.awt.Color(0, 153, 204));
        jLayeredPane9.setForeground(new java.awt.Color(102, 255, 102));
        jLayeredPane9.setOpaque(true);

        jLabel12.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 25)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oodj_assignment/resources/report.png"))); // NOI18N
        jLabel12.setText("Training Sessions");

        jLayeredPane9.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane9Layout = new javax.swing.GroupLayout(jLayeredPane9);
        jLayeredPane9.setLayout(jLayeredPane9Layout);
        jLayeredPane9Layout.setHorizontalGroup(
            jLayeredPane9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane9Layout.setVerticalGroup(
            jLayeredPane9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
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
                .addComponent(totalSessionsNum)
                .addGap(49, 49, 49))
            .addComponent(jLayeredPane9)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(returnBut, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalSessionsNum))
                .addContainerGap())
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
        new managerTrainerMenuForm(APUGym,ma_acc).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_returnButActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane jLayeredPane9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField pastSessionsSearchField;
    private javax.swing.JTable pastSessionsTable;
    private javax.swing.JButton returnBut;
    private javax.swing.JLabel totalSessionsNum;
    private javax.swing.JTextField upcomingSessionsSearchField;
    private javax.swing.JTable upcomingSessionsTable;
    // End of variables declaration//GEN-END:variables
}
