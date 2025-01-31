/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Account.CustomerAccount;
import Report.ReportController;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.Temporal;
import java.util.Date;

/**
 *
 * @author amirharvey
 */
public class IndividualReport extends javax.swing.JFrame {

    private CustomerAccount SelectedCustomer;
    private void SetSelectedCustomer(CustomerAccount c) {
        SelectedCustomer = c;
        StaffLabel.setText("SELECTED: " + c.getName());
    }

    /**
     * Creates new form IndividualReport
     */
    public IndividualReport() {
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
        StaffLabel = new javax.swing.JLabel();
        GenerateButton = new javax.swing.JButton();
        SelectButton = new javax.swing.JButton();
        TimeDropDown = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));

        StaffLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        StaffLabel.setText("CUSTOMER: NONE SELECTED");

        GenerateButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        GenerateButton.setText("GENERATE");
        GenerateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GenerateButtonMouseClicked(evt);
            }
        });

        SelectButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        SelectButton.setText("SELECT");
        SelectButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SelectButtonMouseClicked(evt);
            }
        });

        TimeDropDown.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        TimeDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PAST WEEK", "PAST MONTH", "PAST YEAR" }));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel1.setText("SINCE:");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel2.setText("");
        jLabel2.setForeground(Color.RED);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(StaffLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SelectButton)
                .addGap(149, 149, 149))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(GenerateButton)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(TimeDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StaffLabel)
                    .addComponent(SelectButton))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TimeDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GenerateButton)
                    .addComponent(jLabel2))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GenerateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GenerateButtonMouseClicked
        if (SelectedCustomer == null) {
            jLabel2.setText("A Customer must be selected!");
            return;
        }

        Instant time;
        switch (TimeDropDown.getSelectedIndex()) {
            case 0:
                time = Instant.now().minusSeconds(60*60*24*7);
            case 1:
                time = Instant.now().minusSeconds(60*60*24*31);
            case 2:
                time = Instant.now().minusSeconds(60*60*24*365);
            default:
                time = Instant.now().minusSeconds(60*60*24*7);
        }


        /*try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            time = dateFormat.parse(dateFormat.format(new Date())).getTime() - 1000*60*60*24*30;
        } catch (ParseException e) {
            e.printStackTrace();
        }*/

        ReportController.createCustomerReport(SelectedCustomer, time);
    }//GEN-LAST:event_GenerateButtonMouseClicked

    private void SelectButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SelectButtonMouseClicked
        AddJobPopUp.SelectMode = "CUSTOMER";
        SelectionPopUpCaller SPUC = new SelectionPopUpCaller();
        SPUC.addSelectionListener(new SelectionListener() {
            @Override
            void selectionMade(Object Selection) {
                SetSelectedCustomer((CustomerAccount)Selection);
            }
        });
        AddJobPopUp obj = new AddJobPopUp(SPUC);
        obj.setVisible(true);
    }//GEN-LAST:event_SelectButtonMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GenerateButton;
    private javax.swing.JButton SelectButton;
    private javax.swing.JLabel StaffLabel;
    private javax.swing.JComboBox<String> TimeDropDown;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
