/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Account.CustomerAccount;
import GUI.DynamicTableModel;
import GUI.TableWrappers.TaskTableModel;
import Processing.Controller;
import Processing.Job;
import Processing.TaskTypeFrame;
import Users.UserController;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author amirharvey
 */
public class AddJob extends javax.swing.JFrame {
    public CustomerAccount SelectedCustomer;
    public Integer Urgency;
    public String JobType;
    public String SpecialInstructions;
    public ArrayList<Integer> TaskTypes;

    public void SetSelectedCustomer(CustomerAccount c) {
        SelectedCustomer = c;
        jLabel2.setText("SELECTED CUSTOMER: " + c.getName());
    }

    public void SetUrgency(Integer index) {
        System.out.println("INDEX: " + index.toString());
        Urgency = index;
        switch (index.intValue()) {
            case 0:
                jLabel3.setText("URGENCY: 24 hours");
                break;
            case 1:
                jLabel3.setText("URGENCY: 6 hours");
                break;
            case 2:
                jLabel3.setText("URGENCY: 3 hours");
                break;
            case 3:
                jLabel3.setText("URGENCY: 2 hours");
                break;
            default:
                jLabel3.setText("URGENCY ERROR LOL");
                break;
        }
    }

    //tested & works
    private void CompleteForm() {
        String urgency = (Urgency == null) ? "1" : Urgency.toString();
        String specialInstructions = SpecialInstructionsTextField.getText();
        Integer jobType = JobTypeDropDown.getSelectedIndex()+1;

        Job j = Controller.createNewJob(SelectedCustomer, jobType, TaskTypes);
        j.setUrgency(UrgencyDropDown.getSelectedIndex());

        if ( (!specialInstructions.equals("SPECIAL INSTRUCTIONS:")) && (!specialInstructions.isEmpty()) ) {
            Controller.createSpecialInstruction(specialInstructions, j);
        }

        System.out.println("Created new job from UI AddJob.java");
    }


    /**
     * Creates new form AddJob
     */
    public AddJob() {
        initComponents();
        TaskTypes = new ArrayList<>();
    }


    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        SpecialInstructionsTextField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        ProcessJobButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        MyTasksButton = new javax.swing.JButton();
        NewCustomerButton = new javax.swing.JButton();
        AddJobButton = new javax.swing.JButton();
        HomeButton = new javax.swing.JButton();
        ProcessPaymentButton = new javax.swing.JButton();
        AdminButton = new javax.swing.JButton();
        JobTypeDropDown = new javax.swing.JComboBox<>();
        SelectCustomerButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        AddTasksButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TaskList = new javax.swing.JTable();
        UrgencyDropDown = new javax.swing.JComboBox<>();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "24 hours", "6 hours", "3 hours", "2 hours" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });

        jScrollPane2.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));

        SpecialInstructionsTextField.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        SpecialInstructionsTextField.setText("SPECIAL INSTRUCTIONS:");
        SpecialInstructionsTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SpecialInstructionsTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                SpecialInstructionsTextFieldFocusLost(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel6.setText("Bloomsbury's Image Processing Laboratory");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ProcessJobButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        ProcessJobButton.setText("PROCESS JOB");

        jPanel4.setAlignmentX(0.0F);
        jPanel4.setAlignmentY(0.0F);

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
        ProcessPaymentButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProcessPaymentButtonMouseClicked(evt);
            }
        });
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MyTasksButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(NewCustomerButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(HomeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ProcessPaymentButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(AddJobButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(AdminButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()

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
                .addContainerGap(140, Short.MAX_VALUE)
                )
        );

        JobTypeDropDown.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        String[] JobTypes = Processing.Controller.getJobTypes();
        JobTypeDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(JobTypes));

        SelectCustomerButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        SelectCustomerButton.setText("SELECT CUSTOMER");

        SelectCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddJobPopUp.SelectMode = "CUSTOMER";
                SelectionPopUpCaller SPUC = new SelectionPopUpCaller();
                SPUC.addSelectionListener(new SelectionListener() {
                    @Override
                    void selectionMade(Object Selection) {
                        CustomerAccount c = (CustomerAccount)Selection;
                        SetSelectedCustomer(c);
                    }
                });
                new AddJobPopUp(SPUC).setVisible(true);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel1.setText("TASKS:");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel2.setText("CUSTOMER: NONE SELECTED");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel3.setText("URGENCY:");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel4.setText("JOBTYPE:");

        AddTasksButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        AddTasksButton.setText("ADD TASK");
        AddTasksButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddTasksButtonMouseClicked(evt);
            }
        });

        ArrayList<String[]> data = new ArrayList<>();
        TaskList.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        TaskTableModel model = new TaskTableModel();
        TaskList.setModel(model);
        TaskList.setRowSelectionAllowed(true);
        TaskList.setColumnSelectionAllowed(false);
        TaskList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                System.out.println(event.getFirstIndex());
            }
        });
        ArrayList<String> columns = new ArrayList<>(Arrays.asList(
                "Order", "Name", "Description", "Price"
        ));

        JScrollPane js = new JScrollPane(TaskList);
        js.setVisible(true);
        add(js);

        jScrollPane3.setViewportView(TaskList);

        UrgencyDropDown.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        UrgencyDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Non Urgent", "6 hours", "3 hours", "2 hours" }));
        UrgencyDropDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(((Integer)UrgencyDropDown.getSelectedIndex()).toString());
                SetUrgency(UrgencyDropDown.getSelectedIndex());
            }
        });

        ProcessJobButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CompleteForm();
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(AddTasksButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                        .addComponent(ProcessJobButton)
                        .addGap(54, 54, 54))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SelectCustomerButton)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane3)
                            .addComponent(UrgencyDropDown, 0, 399, Short.MAX_VALUE)
                            .addComponent(JobTypeDropDown, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SpecialInstructionsTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                            .addComponent(jLabel2)
                        .addComponent(SelectCustomerButton)

                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel3)
                        .addComponent(UrgencyDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel4)
                        .addComponent(JobTypeDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SpecialInstructionsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AddTasksButton)
                            .addComponent(ProcessJobButton))
                        .addGap(27, 27, 27))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

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
    }

    private void ProcessPaymentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProcessPaymentButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProcessPaymentButtonActionPerformed

    private void SpecialInstructionsTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SpecialInstructionsTextFieldFocusGained
        if(SpecialInstructionsTextField.getText().equals("SPECIAL INSTRUCTIONS:"))
        {
            SpecialInstructionsTextField.setText("");
            SpecialInstructionsTextField.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_SpecialInstructionsTextFieldFocusGained

    private void SpecialInstructionsTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SpecialInstructionsTextFieldFocusLost
        if(SpecialInstructionsTextField.getText().equals(""))
        {
            SpecialInstructionsTextField.setText("SPECIAL INSTRUCTIONS:");
            SpecialInstructionsTextField.setForeground(new Color(153,153,153)); 
        }
    }//GEN-LAST:event_SpecialInstructionsTextFieldFocusLost

    private void HomeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeButtonMouseClicked
        this.dispose();
        Home obj = new
        Home();
        obj.setVisible(true);
    }//GEN-LAST:event_HomeButtonMouseClicked

    private void AdminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AdminButtonActionPerformed

    private void MyTasksButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MyTasksButtonMouseClicked
        this.dispose();
        MyTasks obj = new
        MyTasks();
        obj.setVisible(true);
    }//GEN-LAST:event_MyTasksButtonMouseClicked

    private void AddJobButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddJobButtonMouseClicked

    }//GEN-LAST:event_AddJobButtonMouseClicked

    private void NewCustomerButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewCustomerButtonMouseClicked
        this.dispose();
        NewCustomer obj = new
        NewCustomer();
        obj.setVisible(true);
    }//GEN-LAST:event_NewCustomerButtonMouseClicked

    private void ProcessPaymentButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProcessPaymentButtonMouseClicked
        this.dispose();
        Payment obj = new
        Payment();
        obj.setVisible(true);
    }//GEN-LAST:event_ProcessPaymentButtonMouseClicked

    private void AddTasksButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddTasksButtonMouseClicked
        AddTaskPopUpCaller ATPUC = new AddTaskPopUpCaller();
        ATPUC.addSelectionListener(new SelectionListener() {
            @Override
            public String toString() {
                return "AddTasksButtonMouseClicked ATPUC";
            }
            @Override
            public void selectionMade(Object Selection) {
                TaskTypeFrame c = (TaskTypeFrame)Selection;
                ((TaskTableModel)TaskList.getModel()).addElement(c);
                TaskTypes.add(c.TaskType);
            }
        });

        AddTaskPopUp obj = new AddTaskPopUp(ATPUC);
        obj.setVisible(true);
    }//GEN-LAST:event_AddTasksButtonMouseClicked

    private void AdminButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminButtonMouseClicked
        this.dispose();
        AdminLogin obj = new
        AdminLogin();
        obj.setVisible(true);
    }//GEN-LAST:event_AdminButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddJobButton;
    private javax.swing.JButton AddTasksButton;
    private javax.swing.JButton AdminButton;
    private javax.swing.JButton HomeButton;
    private javax.swing.JComboBox<String> JobTypeDropDown;
    private javax.swing.JButton MyTasksButton;
    private javax.swing.JButton NewCustomerButton;
    private javax.swing.JButton ProcessJobButton;
    private javax.swing.JButton ProcessPaymentButton;
    private javax.swing.JButton SelectCustomerButton;
    private javax.swing.JTextField SpecialInstructionsTextField;
    private JTable TaskList;
    private javax.swing.JComboBox<String> UrgencyDropDown;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
