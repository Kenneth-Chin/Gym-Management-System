/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oodj_assignment;

import java.util.*;
import java.time.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author kelwi
 */
public class managerBookTrainingSessionCustomerForm extends javax.swing.JFrame {

    /**
     * Creates new form customerMenuForm
     */
    private Gym APUGym;
    private Manager ma_acc;
    
    public managerBookTrainingSessionCustomerForm(Gym APUGym, Manager ma_acc) {
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
        trainingSessionTrainer = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        trainingSessionDate = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        trainingSessionTime = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        trainingSessionLevel = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        trainingSessionStatus = new javax.swing.JLabel();
        jLayeredPane8 = new javax.swing.JLayeredPane();
        jLabel11 = new javax.swing.JLabel();
        selectCustomers = new javax.swing.JComboBox<>();
        bookingBut = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        selectTrainingSession = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        customersTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        backBut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel15.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 25)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Select Customers:");

        jLayeredPane4.setBackground(new java.awt.Color(204, 204, 204));
        jLayeredPane4.setForeground(new java.awt.Color(102, 255, 102));
        jLayeredPane4.setOpaque(true);

        trainingSessionID.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        trainingSessionID.setText("ID: #TR001");

        trainingSessionName.setFont(new java.awt.Font("Agency FB", 1, 28)); // NOI18N
        trainingSessionName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        trainingSessionName.setText("Full-Body Workout for Beginners");
        trainingSessionName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Trainer:");

        trainingSessionTrainer.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        trainingSessionTrainer.setText("Jordan Yeoh");

        jLabel10.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Date:");

        trainingSessionDate.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        trainingSessionDate.setText("20/5/2022");

        jLabel12.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Time:");

        trainingSessionTime.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        trainingSessionTime.setText("5.00 p.m. - 6.00 p.m.");

        jLabel17.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Level:");

        trainingSessionLevel.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        trainingSessionLevel.setText("Beginner");

        jLabel18.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Status:");

        trainingSessionStatus.setFont(new java.awt.Font("Agency FB", 1, 20)); // NOI18N
        trainingSessionStatus.setText("Not Started");

        jLayeredPane4.setLayer(trainingSessionID, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(trainingSessionName, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(trainingSessionTrainer, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(trainingSessionDate, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(trainingSessionTime, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel17, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(trainingSessionLevel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel18, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(trainingSessionStatus, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane4Layout = new javax.swing.GroupLayout(jLayeredPane4);
        jLayeredPane4.setLayout(jLayeredPane4Layout);
        jLayeredPane4Layout.setHorizontalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(trainingSessionName, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(trainingSessionTrainer, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(trainingSessionDate, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(trainingSessionTime, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(trainingSessionLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(trainingSessionStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(trainingSessionID))
        );
        jLayeredPane4Layout.setVerticalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(trainingSessionID)
                .addGap(18, 18, 18)
                .addComponent(trainingSessionName, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(trainingSessionTrainer))
                .addGap(12, 12, 12)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(trainingSessionDate))
                .addGap(12, 12, 12)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(trainingSessionTime))
                .addGap(12, 12, 12)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(trainingSessionLevel))
                .addGap(12, 12, 12)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(trainingSessionStatus)))
        );

        jLayeredPane8.setBackground(new java.awt.Color(0, 153, 204));
        jLayeredPane8.setForeground(new java.awt.Color(102, 255, 102));
        jLayeredPane8.setOpaque(true);

        jLabel11.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 25)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oodj_assignment/resources/bookcust.png"))); // NOI18N
        jLabel11.setText("Book Training Session for Customers");

        jLayeredPane8.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane8Layout = new javax.swing.GroupLayout(jLayeredPane8);
        jLayeredPane8.setLayout(jLayeredPane8Layout);
        jLayeredPane8Layout.setHorizontalGroup(
            jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(183, Short.MAX_VALUE))
        );
        jLayeredPane8Layout.setVerticalGroup(
            jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(20, 20, 20))
        );

        selectCustomers.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Available Customers" }));
        selectCustomers.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                selectCustomersItemStateChanged(evt);
            }
        });
        selectCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectCustomersActionPerformed(evt);
            }
        });

        bookingBut.setBackground(new java.awt.Color(102, 204, 0));
        bookingBut.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        bookingBut.setText("CONFIRM BOOKING");
        bookingBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingButActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 25)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 102));
        jLabel24.setText("Select Session:");

        selectTrainingSession.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
        selectTrainingSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectTrainingSessionActionPerformed(evt);
            }
        });

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

        jLabel1.setText("To be booked:");

        backBut.setBackground(new java.awt.Color(255, 102, 102));
        backBut.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        backBut.setText("BACK");
        backBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane8)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backBut, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bookingBut)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addComponent(selectCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 40, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(98, 98, 98))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addComponent(selectTrainingSession, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLayeredPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(selectTrainingSession)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addGap(1, 1, 1)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bookingBut, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(backBut, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bookingButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingButActionPerformed
        // TODO add your handling code here:
        if(trainingSessionID.getText().equals("-----")){
            JOptionPane.showMessageDialog(null, "No training session selected" , "Try again",JOptionPane.ERROR_MESSAGE);
        } else if(customersTable.getRowCount() == 0){
            JOptionPane.showMessageDialog(null, "No customers selected" , "Try again",JOptionPane.ERROR_MESSAGE);
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
                ArrayList<Payment> Payments = APUGym.getPayments();
                String lastPaymentID = Payments.get(Payments.size() - 1).getPaymentID();
                lastPaymentID = lastPaymentID.replace("PA","");
                int num = Integer.parseInt(lastPaymentID);

                for(int i=0; i<customersTable.getRowCount(); i++){
                    String custID = customersTable.getValueAt(i, 0).toString();
                    session.addCustomerBooking(custID);
                    num++;
                    if(num<10){
                        lastPaymentID = "PA00"+Integer.toString(num);
                    }else if(num>=10 || num<100){
                        lastPaymentID = "PA0"+Integer.toString(num);
                    }else{
                        lastPaymentID = "PA"+Integer.toString(num); 
                    }
                    Payment bookingPayment = new Payment(lastPaymentID, 
                            session.getTrainingSessionID() + " - " + session.getTrainingSessionName(), 
                            "-", 
                            session.getTrainerHourlyRate(APUGym.getTrainers()) * session.getTrainingSessionDurationHours(), 
                            custID, 
                            session.getTrainerID(), 
                            LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES),"Pending");
                    APUGym.getPayments().add(bookingPayment);
                }
                new managerCustomerMenuForm(APUGym, ma_acc).setVisible(true);
                this.dispose();
            } else{
                JOptionPane.getRootFrame().dispose();
            }
        }
    }//GEN-LAST:event_bookingButActionPerformed

    private void selectCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectCustomersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectCustomersActionPerformed

    private void selectTrainingSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectTrainingSessionActionPerformed
        if(selectTrainingSession.getSelectedItem().equals("-")){
            trainingSessionID.setText("ID: -----");
            trainingSessionName.setText("No Session Selected");
            trainingSessionTrainer.setText("-----");
            trainingSessionDate.setText("-----");
            trainingSessionTime.setText("-----");
            trainingSessionLevel.setText("-----");
            trainingSessionStatus.setText("-----");
            selectCustomers.removeAllItems();
            selectCustomers.addItem("Available Customers");
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
            selectCustomers.removeAllItems();
            selectCustomers.addItem("Available Customers");
            for(Customer cust: APUGym.getCustomers()){
                if(!(Arrays.asList(session.getCustomerID()).contains(cust.getUserID()))){
                    selectCustomers.addItem(cust.getUserID() + " - " + cust.getUserName());
                }
            }
        }
        DefaultTableModel customersModel = (DefaultTableModel) customersTable.getModel();
        customersModel.setRowCount(0);
    }//GEN-LAST:event_selectTrainingSessionActionPerformed

    private void backButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButActionPerformed
        // TODO add your handling code here:
        new managerCustomerMenuForm(APUGym, ma_acc).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButActionPerformed

    private void selectCustomersItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_selectCustomersItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if(!(selectCustomers.getSelectedItem().equals("Available Customers"))){
                Object selectedCust = selectCustomers.getSelectedItem();
                selectCustomers.setSelectedItem("Available Customers");
                selectCustomers.removeItem(selectedCust);
                String[] selectedCustArr = selectedCust.toString().split(" - ");
                DefaultTableModel customersModel = (DefaultTableModel) customersTable.getModel();
                customersModel.addRow(new Object[]{selectedCustArr[0], selectedCustArr[1]});
            }
        }
    }//GEN-LAST:event_selectCustomersItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBut;
    private javax.swing.JButton bookingBut;
    private javax.swing.JTable customersTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JLayeredPane jLayeredPane8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> selectCustomers;
    private javax.swing.JComboBox<String> selectTrainingSession;
    private javax.swing.JLabel trainingSessionDate;
    private javax.swing.JLabel trainingSessionID;
    private javax.swing.JLabel trainingSessionLevel;
    private javax.swing.JLabel trainingSessionName;
    private javax.swing.JLabel trainingSessionStatus;
    private javax.swing.JLabel trainingSessionTime;
    private javax.swing.JLabel trainingSessionTrainer;
    // End of variables declaration//GEN-END:variables
}
