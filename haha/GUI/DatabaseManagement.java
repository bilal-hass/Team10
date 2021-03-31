/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.contacteditor;

/**
 *
 * @author amirharvey
 */
public class DatabaseManagement extends javax.swing.JFrame {

    /**
     * Creates new form DatabaseManagement
     */
    public DatabaseManagement() {
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
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        MyTasksButton = new javax.swing.JButton();
        NewCustomerButton = new javax.swing.JButton();
        AddJobButton = new javax.swing.JButton();
        HomeButton = new javax.swing.JButton();
        ProcessPaymentButton = new javax.swing.JButton();
        AdminButton = new javax.swing.JButton();
        ManageCustomerButton = new javax.swing.JButton();
        ManageDiscountsButton = new javax.swing.JButton();
        ManageStaffButton = new javax.swing.JButton();
        ManageReportButton = new javax.swing.JButton();
        ManageDatabaseButton = new javax.swing.JButton();
        ManageTasksButton = new javax.swing.JButton();
        BackUpDatabase = new javax.swing.JButton();
        LoadDatabase = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel4.setText("Bloomsbury's Image Processing Laboratory");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        jPanel4.setAlignmentX(0.0F);
        jPanel4.setAlignmentY(0.0F);

        MyTasksButton.setText("My Tasks");
        MyTasksButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MyTasksButtonMouseClicked(evt);
            }
        });
        MyTasksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MyTasksButtonActionPerformed(evt);
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

        ManageCustomerButton.setText("Manage Customer");
        ManageCustomerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ManageCustomerButtonMouseClicked(evt);
            }
        });
        ManageCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageCustomerButtonActionPerformed(evt);
            }
        });

        ManageDiscountsButton.setText("Manage Discounts");
        ManageDiscountsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ManageDiscountsButtonMouseClicked(evt);
            }
        });
        ManageDiscountsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageDiscountsButtonActionPerformed(evt);
            }
        });

        ManageStaffButton.setText("Manage Staff");
        ManageStaffButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ManageStaffButtonMouseClicked(evt);
            }
        });
        ManageStaffButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageStaffButtonActionPerformed(evt);
            }
        });

        ManageReportButton.setText("Manage Report");
        ManageReportButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ManageReportButtonMouseClicked(evt);
            }
        });
        ManageReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageReportButtonActionPerformed(evt);
            }
        });

        ManageDatabaseButton.setText("Manage Database");
        ManageDatabaseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ManageDatabaseButtonMouseClicked(evt);
            }
        });
        ManageDatabaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageDatabaseButtonActionPerformed(evt);
            }
        });

        ManageTasksButton.setText("Manage Tasks");
        ManageTasksButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ManageTasksButtonMouseClicked(evt);
            }
        });
        ManageTasksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageTasksButtonActionPerformed(evt);
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
            .addComponent(ManageCustomerButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ManageDiscountsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ManageStaffButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ManageReportButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ManageDatabaseButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ManageTasksButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(0, 0, 0)
                .addComponent(ManageCustomerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(ManageDiscountsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(ManageStaffButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(ManageReportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(ManageDatabaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(ManageTasksButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
        );

        BackUpDatabase.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        BackUpDatabase.setText("BACKUP DATABASE");

        LoadDatabase.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        LoadDatabase.setText("LOAD DATABASE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(199, 199, 199)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LoadDatabase)
                    .addComponent(BackUpDatabase))
                .addContainerGap(165, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(BackUpDatabase)
                        .addGap(68, 68, 68)
                        .addComponent(LoadDatabase))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MyTasksButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MyTasksButtonMouseClicked
        this.dispose();
        MyTasks obj = new
        MyTasks();
        obj.setVisible(true);
    }//GEN-LAST:event_MyTasksButtonMouseClicked

    private void MyTasksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MyTasksButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MyTasksButtonActionPerformed

    private void NewCustomerButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewCustomerButtonMouseClicked
        this.dispose();
        NewCustomer obj = new
        NewCustomer();
        obj.setVisible(true);
    }//GEN-LAST:event_NewCustomerButtonMouseClicked

    private void AddJobButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddJobButtonMouseClicked
        this.dispose();
        AddJob obj = new
        AddJob();
        obj.setVisible(true);
    }//GEN-LAST:event_AddJobButtonMouseClicked

    private void HomeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeButtonMouseClicked
        this.dispose();
        Home obj = new
        Home();
        obj.setVisible(true);
    }//GEN-LAST:event_HomeButtonMouseClicked

    private void ProcessPaymentButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProcessPaymentButtonMouseClicked
        this.dispose();
        Payment obj = new
        Payment();
        obj.setVisible(true);
    }//GEN-LAST:event_ProcessPaymentButtonMouseClicked

    private void ProcessPaymentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProcessPaymentButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProcessPaymentButtonActionPerformed

    private void AdminButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminButtonMouseClicked
        this.dispose();
        AdminLogin obj = new
        AdminLogin();
        obj.setVisible(true);
    }//GEN-LAST:event_AdminButtonMouseClicked

    private void AdminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AdminButtonActionPerformed

    private void ManageCustomerButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ManageCustomerButtonMouseClicked
        this.dispose();
        ManageCustomer obj = new
        ManageCustomer();
        obj.setVisible(true);
    }//GEN-LAST:event_ManageCustomerButtonMouseClicked

    private void ManageCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageCustomerButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ManageCustomerButtonActionPerformed

    private void ManageDiscountsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ManageDiscountsButtonMouseClicked
        this.dispose();
        DiscountManagement obj = new
        DiscountManagement();
        obj.setVisible(true);
    }//GEN-LAST:event_ManageDiscountsButtonMouseClicked

    private void ManageDiscountsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageDiscountsButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ManageDiscountsButtonActionPerformed

    private void ManageStaffButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ManageStaffButtonMouseClicked
        this.dispose();
        StaffManagement obj = new
        StaffManagement();
        obj.setVisible(true);
    }//GEN-LAST:event_ManageStaffButtonMouseClicked

    private void ManageStaffButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageStaffButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ManageStaffButtonActionPerformed

    private void ManageReportButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ManageReportButtonMouseClicked
        this.dispose();
        ReportManagement obj = new
        ReportManagement();
        obj.setVisible(true);
    }//GEN-LAST:event_ManageReportButtonMouseClicked

    private void ManageReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageReportButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ManageReportButtonActionPerformed

    private void ManageDatabaseButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ManageDatabaseButtonMouseClicked
        this.dispose();
        DatabaseManagement obj = new
        DatabaseManagement();
        obj.setVisible(true);
    }//GEN-LAST:event_ManageDatabaseButtonMouseClicked

    private void ManageDatabaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageDatabaseButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ManageDatabaseButtonActionPerformed

    private void ManageTasksButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ManageTasksButtonMouseClicked
        this.dispose();
        TaskManagement obj = new
        TaskManagement();
        obj.setVisible(true);
    }//GEN-LAST:event_ManageTasksButtonMouseClicked

    private void ManageTasksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageTasksButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ManageTasksButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DatabaseManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatabaseManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatabaseManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatabaseManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DatabaseManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddJobButton;
    private javax.swing.JButton AdminButton;
    private javax.swing.JButton BackUpDatabase;
    private javax.swing.JButton HomeButton;
    private javax.swing.JButton LoadDatabase;
    private javax.swing.JButton ManageCustomerButton;
    private javax.swing.JButton ManageDatabaseButton;
    private javax.swing.JButton ManageDiscountsButton;
    private javax.swing.JButton ManageReportButton;
    private javax.swing.JButton ManageStaffButton;
    private javax.swing.JButton ManageTasksButton;
    private javax.swing.JButton MyTasksButton;
    private javax.swing.JButton NewCustomerButton;
    private javax.swing.JButton ProcessPaymentButton;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
