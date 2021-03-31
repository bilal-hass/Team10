/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.contacteditor;
import java.awt.Color;
/**
 *
 * @author amirharvey
 */
public class NewCustomer extends javax.swing.JFrame {

    /**
     * 
     * 
     * Creates new form NewCustomer
     */
    
    
    
    public NewCustomer() {
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
        FNameText = new javax.swing.JTextField();
        SNameText = new javax.swing.JTextField();
        EmailText = new javax.swing.JTextField();
        PhoneText = new javax.swing.JTextField();
        AddressText = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        CAConfirmButton = new javax.swing.JButton();
        PostCodeText = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        MyTasksButton = new javax.swing.JButton();
        NewCustomerButton = new javax.swing.JButton();
        AddJobButton = new javax.swing.JButton();
        HomeButton = new javax.swing.JButton();
        ProcessPaymentButton = new javax.swing.JButton();
        AdminButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));

        FNameText.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        FNameText.setText("FIRST NAME:");
        FNameText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                FNameTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                FNameTextFocusLost(evt);
            }
        });

        SNameText.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        SNameText.setText("SURNAME:");
        SNameText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SNameTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                SNameTextFocusLost(evt);
            }
        });

        EmailText.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        EmailText.setText("EMAIL:");
        EmailText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                EmailTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                EmailTextFocusLost(evt);
            }
        });

        PhoneText.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        PhoneText.setText("PHONE NUMBER:");
        PhoneText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PhoneTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PhoneTextFocusLost(evt);
            }
        });

        AddressText.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        AddressText.setText("ADDRESS:");
        AddressText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                AddressTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                AddressTextFocusLost(evt);
            }
        });

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        CAConfirmButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        CAConfirmButton.setText("Create Account");

        PostCodeText.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        PostCodeText.setText("POST CODE:");
        PostCodeText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PostCodeTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PostCodeTextFocusLost(evt);
            }
        });

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
                .addContainerGap(137, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AddressText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                    .addComponent(SNameText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                    .addComponent(EmailText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                    .addComponent(PhoneText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                    .addComponent(FNameText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                    .addComponent(PostCodeText, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(30, 30, 30)
                .addComponent(CAConfirmButton)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(FNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(SNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(EmailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(PhoneText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AddressText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PostCodeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CAConfirmButton)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void ProcessPaymentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProcessPaymentButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProcessPaymentButtonActionPerformed

    private void FNameTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FNameTextFocusGained
        if(FNameText.getText().equals("FIRST NAME: "))
        {
            FNameText.setText("");
            FNameText.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_FNameTextFocusGained

    private void FNameTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FNameTextFocusLost
        if(FNameText.getText().equals(""))
        {
            FNameText.setText("FIRST NAME: ");
            FNameText.setForeground(new Color(153,153,153)); 
        }
    }//GEN-LAST:event_FNameTextFocusLost

    private void SNameTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SNameTextFocusGained
        if(SNameText.getText().equals("SURNAME: "))
        {
            SNameText.setText("");
            SNameText.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_SNameTextFocusGained

    private void SNameTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SNameTextFocusLost
        if(SNameText.getText().equals(""))
        {
            SNameText.setText("SURNAME: ");
            SNameText.setForeground(new Color(153,153,153)); 
        }
    }//GEN-LAST:event_SNameTextFocusLost

    private void EmailTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmailTextFocusGained
        if(EmailText.getText().equals("EMAIL: "))
        {
            EmailText.setText("");
            EmailText.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_EmailTextFocusGained

    private void EmailTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmailTextFocusLost
        if(EmailText.getText().equals(""))
        {
            EmailText.setText("EMAIL: ");
            EmailText.setForeground(new Color(153,153,153)); 
        }
    }//GEN-LAST:event_EmailTextFocusLost

    private void PhoneTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PhoneTextFocusGained
        if(PhoneText.getText().equals("PHONE NUMBER: "))
        {
            PhoneText.setText("");
            PhoneText.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_PhoneTextFocusGained

    private void PhoneTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PhoneTextFocusLost
        if(PhoneText.getText().equals(""))
        {
            PhoneText.setText("PHONE NUMBER: ");
            PhoneText.setForeground(new Color(153,153,153)); 
        }
    }//GEN-LAST:event_PhoneTextFocusLost

    private void AddressTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AddressTextFocusGained
        if(AddressText.getText().equals("ADDRESS: "))
        {
            AddressText.setText("");
            AddressText.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_AddressTextFocusGained

    private void AddressTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AddressTextFocusLost
        if(AddressText.getText().equals(""))
        {
            AddressText.setText("ADDRESS: ");
            AddressText.setForeground(new Color(153,153,153)); 
        }
    }//GEN-LAST:event_AddressTextFocusLost

    private void PostCodeTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PostCodeTextFocusGained
        if(PostCodeText.getText().equals("POST CODE: "))
        {
            PostCodeText.setText("");
            PostCodeText.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_PostCodeTextFocusGained

    private void PostCodeTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PostCodeTextFocusLost
        if(PostCodeText.getText().equals(""))
        {
            PostCodeText.setText("POST CODE: ");
            PostCodeText.setForeground(new Color(153,153,153)); 
        }
    }//GEN-LAST:event_PostCodeTextFocusLost

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

    private void ProcessPaymentButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProcessPaymentButtonMouseClicked
        this.dispose();
        Payment obj = new
        Payment();
        obj.setVisible(true);
    }//GEN-LAST:event_ProcessPaymentButtonMouseClicked

    private void AdminButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminButtonMouseClicked
        this.dispose();
        AdminLogin obj = new
        AdminLogin();
        obj.setVisible(true);
    }//GEN-LAST:event_AdminButtonMouseClicked
                               

    
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
            java.util.logging.Logger.getLogger(NewCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
      
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewCustomer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddJobButton;
    private javax.swing.JTextField AddressText;
    private javax.swing.JButton AdminButton;
    private javax.swing.JButton CAConfirmButton;
    private javax.swing.JTextField EmailText;
    private javax.swing.JTextField FNameText;
    private javax.swing.JButton HomeButton;
    private javax.swing.JButton MyTasksButton;
    private javax.swing.JButton NewCustomerButton;
    private javax.swing.JTextField PhoneText;
    private javax.swing.JTextField PostCodeText;
    private javax.swing.JButton ProcessPaymentButton;
    private javax.swing.JTextField SNameText;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
