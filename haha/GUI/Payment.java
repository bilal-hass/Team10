/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Account.CustomerAccount;
import Discount.DiscountController;
import Processing.Job;

import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import java.awt.Color;
import java.awt.event.*;
import Payment.PaymentController;
import Users.UserController;

/**
 *
 * @author amirharvey
 */
public class Payment extends javax.swing.JFrame {

    CustomerAccount SelectedCustomer;
    Job SelectedJob;
    /**
     * Creates new form Payment
     */
    public Payment() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        ConfirmPPButton = new javax.swing.JButton();
        PaymentDropDown = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        MyTasksButton = new javax.swing.JButton();
        NewCustomerButton = new javax.swing.JButton();
        AddJobButton = new javax.swing.JButton();
        HomeButton = new javax.swing.JButton();
        ProcessPaymentButton = new javax.swing.JButton();
        AdminButton = new javax.swing.JButton();
        CustomerLabel = new javax.swing.JLabel();
        JobLabel = new javax.swing.JLabel();
        SelectCustomerButton = new javax.swing.JButton();
        SelectJobButton = new javax.swing.JButton();
        PriceLabel = new javax.swing.JLabel();
        CardNumberText = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel6.setText("Bloomsbury's Image Processing Laboratory");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(420, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ConfirmPPButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        ConfirmPPButton.setText("Process Payment");

        PaymentDropDown.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        PaymentDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pay by Cash", "Pay by Card" }));

        jPanel3.setAlignmentX(0.0F);
        jPanel3.setAlignmentY(0.0F);

        MyTasksButton.setText("My Tasks");
        MyTasksButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MyTasksButtonMouseClicked(evt);
            }
        });

        NewCustomerButton.setText("New Customer");
        NewCustomerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NewCustomerButtonMouseClicked(evt);
            }
        });

        AddJobButton.setText("Add Job");
        AddJobButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddJobButtonMouseClicked(evt);
            }
        });

        HomeButton.setText("Home");
        HomeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeButtonMouseClicked(evt);
            }
        });

        ProcessPaymentButton.setText("Process Payment");
        ProcessPaymentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProcessPaymentButtonActionPerformed(evt);
            }
        });

        AdminButton.setText("Administration");
        AdminButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AdminButtonMouseClicked(evt);
            }
        });
        AdminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MyTasksButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(NewCustomerButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(HomeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ProcessPaymentButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(AddJobButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(AdminButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(HomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(MyTasksButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(AddJobButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(NewCustomerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(ProcessPaymentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(AdminButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(164, Short.MAX_VALUE))
        );

        CustomerLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        CustomerLabel.setText("CUSTOMER: NONE SELECTED");

        JobLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        JobLabel.setText("JOB: NONE SELECTED");

        SelectCustomerButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        SelectCustomerButton.setText("SELECT CUSTOMER");
        SelectCustomerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {



                SelectCustomerButtonMouseClicked(evt);
            }
        });

        SelectJobButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        SelectJobButton.setText("SELECT JOB");
        SelectJobButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SelectJobButtonMouseClicked(evt);
            }
        });

        PriceLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        PriceLabel.setText("PRICE:");

        CardNumberText.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        CardNumberText.setText("CARD NUMBER:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ConfirmPPButton)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PaymentDropDown, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CustomerLabel)
                                    .addComponent(JobLabel))
                                .addGap(84, 84, 84)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(SelectCustomerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(SelectJobButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addComponent(CardNumberText, javax.swing.GroupLayout.Alignment.LEADING)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CustomerLabel)
                            .addComponent(SelectCustomerButton))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JobLabel)
                            .addComponent(SelectJobButton))
                        .addGap(52, 52, 52)
                        .addComponent(PaymentDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CardNumberText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(PriceLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ConfirmPPButton)
                        .addGap(53, 53, 53))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        SelectJobButton.setVisible(false);
        JobLabel.setVisible(false);
        ConfirmPPButton.setVisible(false);
        CardNumberText.setVisible(false);

        PaymentDropDown.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                            String item = (String)e.getItem();

                            if (item.equals("Pay by Card")) {
                                CardNumberText.setVisible(true);
                            }
                            else
                            {
                                CardNumberText.setVisible(false);
                            }
                        }
                    }
                });

            }
        });



        ConfirmPPButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 if (SelectedCustomer != null && SelectedJob != null) {
                     SelectedJob.setPaid();
                 }
                 if (PaymentDropDown.getSelectedIndex() == 0) {
                     PaymentController.createNewPayment(SelectedJob, "Cash");
                 }
                 else if (PaymentDropDown.getSelectedIndex() == 1) {
                     PaymentController.createNewPayment(SelectedJob, "Card", CardNumberText.getText());
                 }
                 new Home().setVisible(true);
                 dispose();
            }
        });

        if (!UserController.currentUser.hasRolePermissions(2)) {
            AdminButton.setVisible(false);
        }
        if (!UserController.currentUser.hasRolePermissions(3)) {
            AddJobButton.setVisible(false);
            NewCustomerButton.setVisible(false);
            ProcessPaymentButton.setVisible(false);
        }
        if (!UserController.currentUser.hasRolePermissions(4)) {
            MyTasksButton.setVisible(false);
        }

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ProcessPaymentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProcessPaymentButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProcessPaymentButtonActionPerformed

    private void AdminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AdminButtonActionPerformed

    private void HomeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeButtonMouseClicked
        this.dispose();
        Home obj = new
        Home();
        obj.setVisible(true);
    }//GEN-LAST:event_HomeButtonMouseClicked

    private void MyTasksButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MyTasksButtonMouseClicked
        this.dispose();
        MyTasks obj = new
        MyTasks();
        obj.setVisible(true);
    }//GEN-LAST:event_MyTasksButtonMouseClicked

    private void SelectCustomerButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SelectCustomerButtonMouseClicked
        SelectionPopUpCaller SPUC = new SelectionPopUpCaller();
        SPUC.addSelectionListener(new SelectionListener() {
            @Override
            void selectionMade(Object Selection) {
                SelectedCustomer = (CustomerAccount)Selection;
                CustomerLabel.setText("SELECTED CUSTOMER: " + SelectedCustomer.getName());
                JobLabel.setVisible(true);
                SelectJobButton.setVisible(true);
            }
        });
        AddJobPopUp.SelectMode = "CUSTOMER";
        AddJobPopUp obj = new AddJobPopUp(SPUC);
        obj.setVisible(true);
    }//GEN-LAST:event_SelectCustomerButtonMouseClicked

    private void SelectJobButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SelectJobButtonMouseClicked
        AddJobPopUp.filterCustomer = SelectedCustomer;
        SelectionPopUpCaller SPUC = new SelectionPopUpCaller();
        SPUC.addSelectionListener(new SelectionListener() {
            @Override
            void selectionMade(Object Selection) {
                SelectedJob = (Job)Selection;
                JobLabel.setText("SELECTED JOB: " + SelectedJob.getId().toString());
                PriceLabel.setText("Price: £" + DiscountController.getDiscount(SelectedCustomer).getPrice(SelectedJob).toString());
                ConfirmPPButton.setVisible(true);
            }
        });
        AddJobPopUp.SelectMode = "JOB";
        AddJobPopUp obj = new AddJobPopUp(SPUC);
        obj.setVisible(true);
    }//GEN-LAST:event_SelectJobButtonMouseClicked

    private void AddJobButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddJobButtonMouseClicked
        this.dispose();
        AddJob obj = new
        AddJob();
        obj.setVisible(true);
    }//GEN-LAST:event_AddJobButtonMouseClicked

    private void NewCustomerButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewCustomerButtonMouseClicked
        this.dispose();
        NewCustomer obj = new
        NewCustomer();
        obj.setVisible(true);
    }//GEN-LAST:event_NewCustomerButtonMouseClicked

    private void AdminButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminButtonMouseClicked
        this.dispose();
        AdminLogin obj = new
        AdminLogin();
        obj.setVisible(true);
    }//GEN-LAST:event_AdminButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddJobButton;
    private javax.swing.JButton AdminButton;
    private javax.swing.JTextField CardNumberText;
    private javax.swing.JButton ConfirmPPButton;
    private javax.swing.JLabel CustomerLabel;
    private javax.swing.JButton HomeButton;
    private javax.swing.JLabel JobLabel;
    private javax.swing.JButton MyTasksButton;
    private javax.swing.JButton NewCustomerButton;
    private javax.swing.JComboBox<String> PaymentDropDown;
    private javax.swing.JLabel PriceLabel;
    private javax.swing.JButton ProcessPaymentButton;
    private javax.swing.JButton SelectCustomerButton;
    private javax.swing.JButton SelectJobButton;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
