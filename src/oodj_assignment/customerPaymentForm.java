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
public class customerPaymentForm extends javax.swing.JFrame {

    /**
     * Creates new form customerTrainingSessionForm
     */
    private Gym APUGym;
    private Customer cust_acc;
    
    public customerPaymentForm(Gym APUGym, Customer cust_acc) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        this.APUGym = APUGym;
        this.cust_acc = cust_acc;
        
        paymentHistoryTable.setRowHeight(35);
        pendingPaymentsTable.setRowHeight(35);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        paymentHistoryTable.setDefaultRenderer(String.class, centerRenderer);
        pendingPaymentsTable.setDefaultRenderer(String.class, centerRenderer);
        ArrayList<Payment> Payments = APUGym.getPayments();
        
        DefaultTableModel paymentHistoryModel = (DefaultTableModel) paymentHistoryTable.getModel();
        DefaultTableModel pendingPaymentsModel = (DefaultTableModel) pendingPaymentsTable.getModel();
        double totalPaidAmount = 0;
        for(int i = Payments.size() - 1; i >= 0; i--){
            Payment pay = Payments.get(i);
            if(pay.getCustomerID().equals(cust_acc.getUserID())){
                if(pay.getPaymentStatus().equals("Paid")){
                    totalPaidAmount += pay.getPaymentAmount();
                    paymentHistoryModel.addRow(new Object[]{
                        pay.getPaymentID(), 
                        pay.getPaymentItem(),
                        pay.getPaymentMethod(), 
                        "RM " + String.format("%.2f", pay.getPaymentAmount()),
                        pay.getPaymentDateTime().replace("T", " ")});
                } else if(pay.getPaymentStatus().equals("Pending")){
                    pendingPaymentsModel.addRow(new Object[]{
                        pay.getPaymentID(), 
                        pay.getPaymentItem(),
                        "RM " + String.format("%.2f", pay.getPaymentAmount()),
                        pay.getStaffID() + ": " + pay.getStaffName(APUGym.getTrainers(), APUGym.getManagers()),
                        "Pay"});
                }
            }
        }
        Action pay = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e){};
        };
 
        ButtonColumn buttonColumn = new ButtonColumn(pendingPaymentsTable, pay, 4);

        totalPaidAmountNum.setText(String.format("%.2f", totalPaidAmount));
        
        pendingPaymentsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                JFrame frame = (JFrame) SwingUtilities.getRoot(mouseEvent.getComponent());
                JTable table =(JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                int col = table.columnAtPoint(point);
                if (mouseEvent.getClickCount() == 1 && table.getSelectedRow() != -1 && col == 4) {
                    Payment pay_details = null;
                    for(Payment pay: APUGym.getPayments()){
                        if(pay.getPaymentID().equals(pendingPaymentsTable.getValueAt(row, 0))){
                            pay_details = pay;
                        }
                    }
                    new customerPaymentMethodForm(APUGym, cust_acc, pay_details).setVisible(true);
                    frame.dispose();
                }
            }
        });
        
        TableRowSorter<TableModel> paymentHistoryRowSorter = new TableRowSorter<>(paymentHistoryTable.getModel());
        paymentHistoryTable.setRowSorter(paymentHistoryRowSorter);
        paymentHistorySearchField.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = paymentHistorySearchField.getText();

                if (text.trim().length() == 0) {
                    paymentHistoryRowSorter.setRowFilter(null);
                } else {
                    paymentHistoryRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = paymentHistorySearchField.getText();

                if (text.trim().length() == 0) {
                    paymentHistoryRowSorter.setRowFilter(null);
                } else {
                    paymentHistoryRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        
        TableRowSorter<TableModel> pendingPaymentsRowSorter = new TableRowSorter<>(pendingPaymentsTable.getModel());
        pendingPaymentsTable.setRowSorter(pendingPaymentsRowSorter);
        pendingPaymentsSearchField.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = pendingPaymentsSearchField.getText();

                if (text.trim().length() == 0) {
                    pendingPaymentsRowSorter.setRowFilter(null);
                } else {
                    pendingPaymentsRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = pendingPaymentsSearchField.getText();

                if (text.trim().length() == 0) {
                    pendingPaymentsRowSorter.setRowFilter(null);
                } else {
                    pendingPaymentsRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
    }
    
    public class ButtonColumn extends AbstractCellEditor
	implements TableCellRenderer, TableCellEditor, ActionListener, MouseListener
    {
	private JTable table;
	private Action action;
	private int mnemonic;
	private Border originalBorder;
	private Border focusBorder;

	private JButton renderButton;
	private JButton editButton;
	private Object editorValue;
	private boolean isButtonColumnEditor;

	/**
	 *  Create the ButtonColumn to be used as a renderer and editor. The
	 *  renderer and editor will automatically be installed on the TableColumn
	 *  of the specified column.
	 *
	 *  @param table the table containing the button renderer/editor
	 *  @param action the Action to be invoked when the button is invoked
	 *  @param column the column to which the button renderer/editor is added
	 */
	public ButtonColumn(JTable table, Action action, int column)
	{
		this.table = table;
		this.action = action;

		renderButton = new JButton();
		editButton = new JButton();
		editButton.setFocusPainted( false );
		editButton.addActionListener( this );
		originalBorder = editButton.getBorder();
		setFocusBorder( new LineBorder(Color.BLUE) );

		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(column).setCellRenderer( this );
		columnModel.getColumn(column).setCellEditor( this );
		table.addMouseListener( this );
	}


	/**
	 *  Get foreground color of the button when the cell has focus
	 *
	 *  @return the foreground color
	 */
	public Border getFocusBorder()
	{
		return focusBorder;
	}

	/**
	 *  The foreground color of the button when the cell has focus
	 *
	 *  @param focusBorder the foreground color
	 */
	public void setFocusBorder(Border focusBorder)
	{
		this.focusBorder = focusBorder;
		editButton.setBorder( focusBorder );
	}

	public int getMnemonic()
	{
		return mnemonic;
	}

	/**
	 *  The mnemonic to activate the button when the cell has focus
	 *
	 *  @param mnemonic the mnemonic
	 */
	public void setMnemonic(int mnemonic)
	{
		this.mnemonic = mnemonic;
		renderButton.setMnemonic(mnemonic);
		editButton.setMnemonic(mnemonic);
	}

	@Override
	public Component getTableCellEditorComponent(
		JTable table, Object value, boolean isSelected, int row, int column)
	{
		if (value == null)
		{
			editButton.setText( "" );
			editButton.setIcon( null );
		}
		else if (value instanceof Icon)
		{
			editButton.setText( "" );
			editButton.setIcon( (Icon)value );
		}
		else
		{
			editButton.setText( value.toString() );
			editButton.setIcon( null );
		}

		this.editorValue = value;
		return editButton;
	}

	@Override
	public Object getCellEditorValue()
	{
		return editorValue;
	}

//
//  Implement TableCellRenderer interface
//
	public Component getTableCellRendererComponent(
		JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
	{
		if (isSelected)
		{
			renderButton.setForeground(table.getSelectionForeground());
	 		renderButton.setBackground(table.getSelectionBackground());
		}
		else
		{
			renderButton.setForeground(table.getForeground());
			renderButton.setBackground(UIManager.getColor("Button.background"));
		}

		if (hasFocus)
		{
			renderButton.setBorder( focusBorder );
		}
		else
		{
			renderButton.setBorder( originalBorder );
		}

//		renderButton.setText( (value == null) ? "" : value.toString() );
		if (value == null)
		{
			renderButton.setText( "" );
			renderButton.setIcon( null );
		}
		else if (value instanceof Icon)
		{
			renderButton.setText( "" );
			renderButton.setIcon( (Icon)value );
		}
		else
		{
			renderButton.setText( value.toString() );
			renderButton.setIcon( null );
		}

		return renderButton;
	}

//
//  Implement ActionListener interface
//
	/*
	 *	The button has been pressed. Stop editing and invoke the custom Action
	 */
	public void actionPerformed(ActionEvent e)
	{
		int row = table.convertRowIndexToModel( table.getEditingRow() );
		fireEditingStopped();

		//  Invoke the Action

		ActionEvent event = new ActionEvent(
			table,
			ActionEvent.ACTION_PERFORMED,
			"" + row);
		action.actionPerformed(event);
	}

//
//  Implement MouseListener interface
//
	/*
	 *  When the mouse is pressed the editor is invoked. If you then then drag
	 *  the mouse to another cell before releasing it, the editor is still
	 *  active. Make sure editing is stopped when the mouse is released.
	 */
        public void mousePressed(MouseEvent e)
        {
            if (table.isEditing()
                    &&  table.getCellEditor() == this)
                            isButtonColumnEditor = true;
        }

        public void mouseReleased(MouseEvent e)
        {
            if (isButtonColumnEditor
            &&  table.isEditing())
                    table.getCellEditor().stopCellEditing();

                    isButtonColumnEditor = false;
        }

        public void mouseClicked(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
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
        paymentHistorySearchField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        paymentHistoryTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        pendingPaymentsSearchField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pendingPaymentsTable = new javax.swing.JTable();
        returnBut = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        totalPaidAmountNum = new javax.swing.JLabel();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        paymentHistorySearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentHistorySearchFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Search:");

        paymentHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Purchased Item", "Payment Method", "Payment Amount", "Date & Time"
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
        paymentHistoryTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(paymentHistoryTable);
        if (paymentHistoryTable.getColumnModel().getColumnCount() > 0) {
            paymentHistoryTable.getColumnModel().getColumn(0).setPreferredWidth(70);
            paymentHistoryTable.getColumnModel().getColumn(0).setMaxWidth(70);
            paymentHistoryTable.getColumnModel().getColumn(2).setPreferredWidth(150);
            paymentHistoryTable.getColumnModel().getColumn(2).setMaxWidth(150);
            paymentHistoryTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            paymentHistoryTable.getColumnModel().getColumn(3).setMaxWidth(100);
            paymentHistoryTable.getColumnModel().getColumn(4).setPreferredWidth(30);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paymentHistorySearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(492, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(paymentHistorySearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Payment History", jPanel1);

        pendingPaymentsSearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pendingPaymentsSearchFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Search:");

        pendingPaymentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Purchased Item", "Outstanding Amount", "Staff In-charge", "Do Payment"
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
        pendingPaymentsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(pendingPaymentsTable);
        if (pendingPaymentsTable.getColumnModel().getColumnCount() > 0) {
            pendingPaymentsTable.getColumnModel().getColumn(0).setPreferredWidth(10);
            pendingPaymentsTable.getColumnModel().getColumn(4).setPreferredWidth(30);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pendingPaymentsSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pendingPaymentsSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Pending Payments", jPanel2);

        returnBut.setText("Return to Customer Menu");
        returnBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Total Paid Amount: RM");

        totalPaidAmountNum.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totalPaidAmountNum.setText("0");

        jLayeredPane3.setBackground(new java.awt.Color(255, 102, 102));
        jLayeredPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        jLayeredPane3.setForeground(new java.awt.Color(102, 255, 102));
        jLayeredPane3.setOpaque(true);

        jLabel11.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 25)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Payment Details");

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
                .addComponent(totalPaidAmountNum)
                .addGap(48, 48, 48))
            .addComponent(jLayeredPane3)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalPaidAmountNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(returnBut, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void paymentHistorySearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentHistorySearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paymentHistorySearchFieldActionPerformed

    private void pendingPaymentsSearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pendingPaymentsSearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pendingPaymentsSearchFieldActionPerformed

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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField paymentHistorySearchField;
    private javax.swing.JTable paymentHistoryTable;
    private javax.swing.JTextField pendingPaymentsSearchField;
    private javax.swing.JTable pendingPaymentsTable;
    private javax.swing.JButton returnBut;
    private javax.swing.JLabel totalPaidAmountNum;
    // End of variables declaration//GEN-END:variables
}
