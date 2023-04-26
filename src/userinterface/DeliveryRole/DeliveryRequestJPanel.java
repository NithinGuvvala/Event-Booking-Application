/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DeliveryRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.BevDeliveryWorkRequest;
import Business.WorkQueue.FoodDeliveryWorkRequest;
import Business.WorkQueue.HostLocWorkRequest;
import Business.WorkQueue.LocInfraWorkRequest;
import Business.WorkQueue.WorkRequest;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ruchika
 */
public class DeliveryRequestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DeliveryRequestJPanel
     */
     private final JPanel userProcessContainer;
    private final UserAccount account;
    private final EcoSystem business;
    public DeliveryRequestJPanel(JPanel userProcessContainer, UserAccount account, EcoSystem business) {
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.business = business;
        initComponents();
        populateDeliveryRequests();
    }
    public void populateDeliveryRequests() {
        DefaultTableModel model = (DefaultTableModel) tblDeliveryReq.getModel();
        model.setRowCount(0);
        for (Network n : business.getNetworkList()) {
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                for (WorkRequest workRequest : e.getWorkQueue().getWorkRequestList()) {
                    if (workRequest instanceof FoodDeliveryWorkRequest) {
                        if(((FoodDeliveryWorkRequest) workRequest).getInfra()!=null){
                        if (((FoodDeliveryWorkRequest) workRequest).getInfra().getUsername().equals(account.getUsername())) {
                            Object[] row = new Object[model.getColumnCount()];
                            row[0] = workRequest;
                            row[1] = ((FoodDeliveryWorkRequest) workRequest).getEventName();
                            row[2] = ((FoodDeliveryWorkRequest) workRequest).getEvenCat();
                            row[3] = ((FoodDeliveryWorkRequest) workRequest).getAttendance();
                            row[4] = ((FoodDeliveryWorkRequest) workRequest).getPlannedDate();
                            row[5] = ((FoodDeliveryWorkRequest) workRequest).getInfra();
                            if(((FoodDeliveryWorkRequest) workRequest).getHost()!=null){
                            row[6] = ((FoodDeliveryWorkRequest) workRequest).getHost().getCity();
                            }
                            row[7] = ((FoodDeliveryWorkRequest) workRequest).getStatus();
                            row[8] = ((FoodDeliveryWorkRequest) workRequest).getMessage();
                            row[9] = ((FoodDeliveryWorkRequest) workRequest).getInfraNote();
                            model.addRow(row);
                        }
                    }
                    }
                    else if (workRequest instanceof BevDeliveryWorkRequest) {
                        if(((BevDeliveryWorkRequest) workRequest).getInfra()!=null){
                        if (((BevDeliveryWorkRequest) workRequest).getInfra().getUsername().equals(account.getUsername())) {
                            Object[] row = new Object[model.getColumnCount()];
                            row[0] = workRequest;
                            row[1] = ((BevDeliveryWorkRequest) workRequest).getEventName();
                            row[2] = ((BevDeliveryWorkRequest) workRequest).getEvenCat();
                            row[3] = ((BevDeliveryWorkRequest) workRequest).getAttendance();
                            row[4] = ((BevDeliveryWorkRequest) workRequest).getPlannedDate();
                            row[5] = ((BevDeliveryWorkRequest) workRequest).getInfra();
                            if(((BevDeliveryWorkRequest) workRequest).getHost()!=null){
                            row[6] = ((BevDeliveryWorkRequest) workRequest).getHost().getCity();
                            }
                            row[7] = ((BevDeliveryWorkRequest) workRequest).getStatus();
                            row[8] = ((BevDeliveryWorkRequest) workRequest).getMessage();
                            row[9] = ((BevDeliveryWorkRequest) workRequest).getInfraNote();
                            model.addRow(row);
                        }
                    }
                    }
                }
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDeliveryReq = new javax.swing.JTable();
        btndrinkapprovereq = new javax.swing.JButton();
        btndrinkrejectreq = new javax.swing.JButton();
        txtAddMsg = new javax.swing.JTextField();
        blAddMessage = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 204, 204));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        tblDeliveryReq.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request Type", "Event Name", "Event Category", "Attendance", "Planned Date", "Assigned to", "Host City", "Status", "Message from Host", "Location Team Reply"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDeliveryReq);

        btndrinkapprovereq.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btndrinkapprovereq.setText("Approve Request");
        btndrinkapprovereq.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btndrinkapprovereq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndrinkapprovereqActionPerformed(evt);
            }
        });

        btndrinkrejectreq.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btndrinkrejectreq.setText("Reject Request");
        btndrinkrejectreq.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btndrinkrejectreq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndrinkrejectreqActionPerformed(evt);
            }
        });

        txtAddMsg.setBackground(new java.awt.Color(204, 204, 255));

        blAddMessage.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        blAddMessage.setForeground(new java.awt.Color(41, 50, 80));
        blAddMessage.setText("Additional Message:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addComponent(blAddMessage)
                .addGap(47, 47, 47)
                .addComponent(txtAddMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btndrinkapprovereq)
                .addGap(34, 34, 34)
                .addComponent(btndrinkrejectreq)
                .addContainerGap(117, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 825, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(blAddMessage)
                        .addComponent(txtAddMsg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btndrinkapprovereq)
                        .addComponent(btndrinkrejectreq)))
                .addGap(27, 27, 27))
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Manage Delivery Requests");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(499, 499, 499)
                        .addComponent(jLabel1)))
                .addGap(418, 418, 418))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(171, 171, 171))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btndrinkapprovereqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndrinkapprovereqActionPerformed
        // TODO add your handling code here:
         int selectedRow = tblDeliveryReq.getSelectedRow();
        if (selectedRow >= 0) {
            WorkRequest request = (WorkRequest) tblDeliveryReq.getValueAt(selectedRow, 0);
            String message = txtAddMsg.getText();
            if (message.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Kindly enter additional details to the Host.");
                return;
            }
            if (!request.getStatus().equals("Awaiting Govt Approval")) {
            if (!"Event Authorized".equals(request.getStatus())) {
                request.setStatus("Delivery Team Booked");
                request.setMessage(message);
                JOptionPane.showMessageDialog(null, "Delivery Team is Booked!");
                    account.setStatus("Booked");
                populateDeliveryRequests();
            } else {
                JOptionPane.showMessageDialog(null, "Team is already booked!");
            }
            } else {
                JOptionPane.showMessageDialog(null, "Select an appropriate Request!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select one row!");
        }
        
    }//GEN-LAST:event_btndrinkapprovereqActionPerformed

    private void btndrinkrejectreqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndrinkrejectreqActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblDeliveryReq.getSelectedRow();
        if (selectedRow >= 0) {
            WorkRequest request = (WorkRequest) tblDeliveryReq.getValueAt(selectedRow, 0);
            String message = txtAddMsg.getText();
            if (message.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Kindly enter the reason for Rejection");
                return;
            }
            if (!"Completed".equals(request.getStatus()) && !"In Progress".equals(request.getStatus())) {
                request.setStatus("Rejected");
                request.setMessage(message);
                JOptionPane.showMessageDialog(null, "Delivery Rejected!");
                    account.setStatus("Available");
                populateDeliveryRequests();
            } else {
                JOptionPane.showMessageDialog(null, " The Delivery is already " + request.getStatus());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Kindly select a row.");
        }
    }//GEN-LAST:event_btndrinkrejectreqActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel blAddMessage;
    private javax.swing.JButton btndrinkapprovereq;
    private javax.swing.JButton btndrinkrejectreq;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDeliveryReq;
    private javax.swing.JTextField txtAddMsg;
    // End of variables declaration//GEN-END:variables
}
