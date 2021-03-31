/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Account.CustomerAccount;
import DB.DBConnWrapper;
import Discount.DiscountController;
import GUI.TableWrappers.CustomerTableModel;
import GUI.TableWrappers.DiscountTableModel;
import GUI.TableWrappers.JobTableModel;
import GUI.TableWrappers.UserTableModel;
import Processing.Job;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Discount.Discount;
import Users.User;

/**
 *
 * @author amirharvey
 */
public class AddJobPopUp extends javax.swing.JFrame {

    public static String SelectMode = "CUSTOMER";
    public static CustomerAccount filterCustomer;
    /**
     * Creates new form AddJobPopUp
     */

    public AddJobPopUp(SelectionPopUpCaller SPUC) {
        initComponents();
        //first initComponents;

        if (SelectMode.equals("CUSTOMER")) {
            String query = "SELECT * FROM CustomerAccount;";
            Connection conn = DBConnWrapper.getConnection();
            try {
                ResultSet RS = conn.createStatement().executeQuery(query);
                while (RS.next()) {
                    Integer id = RS.getInt("No");
                    CustomerAccount c = new CustomerAccount(id);
                    ((CustomerTableModel)SelectionTable.getModel()).addElement(c);
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }

            ConfirmButton.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    int SelectedRow = SelectionTable.getSelectedRow();
                    if (SelectedRow == -1) {
                        return;
                    }

                    System.out.println("CLICKED CONFIRM WITH ROW: " + SelectedRow);

                    SPUC.SelectionMade( ((CustomerTableModel)SelectionTable.getModel()).getCustomerAt(SelectionTable.getSelectedRow()) );
                    ConfirmButtonMouseClicked(evt);

                }
            });
        }
        else if (SelectMode.equals("JOB")) {
            SelectionTable.setModel(new JobTableModel());
            String query = "SELECT * FROM Job WHERE Paid = 0 AND CustomerNo = " + filterCustomer.getId().toString();
            Connection conn = DBConnWrapper.getConnection();
            try {
                ResultSet RS = conn.createStatement().executeQuery(query);
                while (RS.next()) {
                    ((JobTableModel)SelectionTable.getModel()).addJob(new Job(RS.getInt("id"), filterCustomer));
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }

            ConfirmButton.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    int SelectedRow = SelectionTable.getSelectedRow();
                    if (SelectedRow == -1) {
                        return;
                    }

                    System.out.println("CLICKED CONFIRM WITH ROW: " + SelectedRow);

                    SPUC.SelectionMade( ((JobTableModel)SelectionTable.getModel()).getJobAt(SelectionTable.getSelectedRow()) );
                    ConfirmButtonMouseClicked(evt);

                }
            });



        }
        else if (SelectMode.equals("STAFF")) {
            SelectionTable.setModel(new UserTableModel());
            String query = "SELECT * FROM StaffAccount;";
            Connection conn = DBConnWrapper.getConnection();
            try {
                ResultSet RS = conn.createStatement().executeQuery(query);
                while (RS.next()) {
                    Integer id = RS.getInt("id");
                    User c = new User(id);
                    ((UserTableModel)SelectionTable.getModel()).addElement(c);
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }

            ConfirmButton.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    int SelectedRow = SelectionTable.getSelectedRow();
                    if (SelectedRow == -1) {
                        return;
                    }

                    System.out.println("CLICKED CONFIRM WITH ROW: " + SelectedRow);

                    SPUC.SelectionMade( ((UserTableModel)SelectionTable.getModel()).getUserAt(SelectionTable.getSelectedRow()) );
                    ConfirmButtonMouseClicked(evt);

                }
            });
        }
        else if (SelectMode.equals("DISCOUNTPLAN")) {
            SelectionTable.setModel(new DiscountTableModel());

            String query = "SELECT * FROM DiscountPlan;";
            Connection conn = DBConnWrapper.getConnection();
            try {
                ResultSet RS = conn.createStatement().executeQuery(query);
                while (RS.next()) {
                    Integer _id = RS.getInt("id");
                    Discount d = DiscountController.getDiscountById(_id);
                    ((DiscountTableModel)SelectionTable.getModel()).addDiscount(d);
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }

            ConfirmButton.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    int SelectedRow = SelectionTable.getSelectedRow();
                    if (SelectedRow == -1) {
                        return;
                    }

                    System.out.println("CLICKED CONFIRM WITH ROW: " + SelectedRow);

                    SPUC.SelectionMade( ((DiscountTableModel)SelectionTable.getModel()).getDiscountAt(SelectionTable.getSelectedRow()) );
                    ConfirmButtonMouseClicked(evt);

                }
            });

        }

        NameSearchText.setVisible(false);
        NumberSearchText.setVisible(false);



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
        NameSearchText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        SelectionTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        ConfirmButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        NumberSearchText = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));
        jPanel1.setForeground(new java.awt.Color(255, 255, 204));

        NameSearchText.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel2.setText("LIST OF CUSTOMERS:");

        SelectionTable.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(SelectionTable);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel1.setText("SEARCH BY NAME:");

        ConfirmButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        ConfirmButton.setText("CONFIRM");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel3.setText("SEARCH BY NUMBER:");

        NumberSearchText.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N

        ArrayList<String[]> data = new ArrayList<>();
        SelectionTable.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        CustomerTableModel model = new CustomerTableModel();
        SelectionTable.setModel(model);
        SelectionTable.setRowSelectionAllowed(true);
        SelectionTable.setColumnSelectionAllowed(false);
        SelectionTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                System.out.println(event.getFirstIndex());
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50,50,50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ConfirmButton)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3))
                            .addGap(47, 47, 47)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(NameSearchText)
                                .addComponent(NumberSearchText)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameSearchText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(NumberSearchText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ConfirmButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void ConfirmButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfirmButtonMouseClicked

        this.dispose();
    }//GEN-LAST:event_ConfirmButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConfirmButton;
    private javax.swing.JTable SelectionTable;
    private javax.swing.JTextField NameSearchText;
    private javax.swing.JTextField NumberSearchText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
