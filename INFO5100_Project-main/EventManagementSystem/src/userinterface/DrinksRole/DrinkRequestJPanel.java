/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DrinksRole;

import Business.APIforSMS.APIforSMS;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.BevDeliveryWorkRequest;
import Business.WorkQueue.FoodDeliveryWorkRequest;
import Business.WorkQueue.HostBeverageWorkRequest;
import Business.WorkQueue.WorkRequest;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kartik
 */
public class DrinkRequestJPanel extends javax.swing.JPanel {

    private final JPanel userProcessContainer;
    private final UserAccount account;
    private final EcoSystem business;
    /**
     * Creates new form DrinkRequestJPanel
     */
    public DrinkRequestJPanel(JPanel userProcessContainer, UserAccount account, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.business = business;
        populateDrinkRequests();
    }
    
    public void goDelivery(HostBeverageWorkRequest request){
                String comment = txtAddMsg.getText();
                    for (Network n : business.getNetworkList()) {
                    for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                        for (Organization org : e.getOrganizationDirectory().getOrganizationList()) {
                            if(org.getType().equals(Organization.Type.Delivery)){
                            for (UserAccount ua : org.getUserAccountDirectory().getUserAccountList()) {
                                if(ua.getSpec1()!=null && account.getCity()!=null){
                                if ( (account.getCity().equals(ua.getSpec1()) || 
                                        account.getCity().equals(ua.getSpec2()) || 
                                        account.getCity().equals(ua.getSpec3()) )&&
                                        "Available".equals(ua.getStatus()) ) {
                                    BevDeliveryWorkRequest bevRequest = new BevDeliveryWorkRequest();                                                           
                                    bevRequest.setRequestID();
                                    bevRequest.setSender(account);
                                    bevRequest.setLocation(account);
                                    bevRequest.setInfra(ua);
                                    bevRequest.setStatus("Pending");
                                    if (!comment.isEmpty()) bevRequest.setMessage(comment);
                                    bevRequest.setAttendance(request.getAttendance());
                                    bevRequest.setEventName(request.getEventName());
                                    bevRequest.setEvenCat(request.getEvenCat());
                                    bevRequest.setPlannedDate(request.getPlannedDate());
                                    bevRequest.setOrgType(Organization.Type.Delivery);
                                    
                                    
                                    e.getWorkQueue().getWorkRequestList().add(bevRequest);
                                    System.out.println("Request"+bevRequest.toString()+"  >> Added to Enterprise "+e);
                                    JOptionPane.showMessageDialog(null, "Delivery Request Sent Successfully!");
                                    APIforSMS sms = new APIforSMS(ua.getPhone(), "Hello "+ua.getName()+", Beverages Team:"+request.getLocation().getName()+" likes to book a Delivery package on "+String.valueOf(bevRequest.getPlannedDate() ).substring(0,10)+". Kindly login for more details.");
                                    //system.sendEmailMessage(ua.getEmail(), "Hello! You have one new work request! Please login to know more!");
                                } else{
                                JOptionPane.showMessageDialog(null, "No Delivery Teams Available in Cities : "+ua.getSpec1()+", "+ua.getSpec2()+" and "+ua.getSpec3()+" ");
                                }
                                }else{
                                
                                    for (Network network : business.getNetworkList()) {
                                    for (Enterprise enter : network.getEnterpriseDirectory().getEnterpriseList()) {
                                     for (Organization orga : enter.getOrganizationDirectory().getOrganizationList()) {
                                    if(orga.getType().equals(Organization.Type.Delivery)){
                                    for (UserAccount uaa : org.getUserAccountDirectory().getUserAccountList()) {
                                   if ("Available".equals(uaa.getStatus()) ) {
                                   BevDeliveryWorkRequest bevRequest = new BevDeliveryWorkRequest();                                                          
                                    bevRequest.setRequestID();
                                    bevRequest.setSender(account);
                                    bevRequest.setHost(account);
                                    bevRequest.setLocation(account);
                                    bevRequest.setInfra(uaa);
                                    bevRequest.setStatus("Pending");
                                    if (!comment.isEmpty()) bevRequest.setMessage(comment);
                                    bevRequest.setAttendance(request.getAttendance());
                                    bevRequest.setEventName(request.getEventName());
                                    bevRequest.setEvenCat(request.getEvenCat());
                                    bevRequest.setPlannedDate(request.getPlannedDate());
                                    bevRequest.setOrgType(Organization.Type.Delivery);
                                    
                                    
                                    e.getWorkQueue().getWorkRequestList().add(bevRequest);
                                    System.out.println("Request"+bevRequest.toString()+"  >> Added to Enterprise "+e);
                                    JOptionPane.showMessageDialog(null, "Delivery Request Sent Successfully!");
                                    APIforSMS sms = new APIforSMS(uaa.getPhone(), "Hello "+uaa.getName()+", Beverages Team:"+request.getLocation().getName()+" likes to book a Delivery package on "+String.valueOf(bevRequest.getPlannedDate() ).substring(0,10)+". Kindly login for more details.");
                                    //system.sendEmailMessage(ua.getEmail(), "Hello! You have one new work request! Please login to know more!");
                                } else {
                                    JOptionPane.showMessageDialog(null, "No Delivery Teams Available Currently!");
                                   }
                            }
                        }
                        }
                    }
                }
                                }
                            }
                        }
                        }
                    }
                }
    }

    public void populateDrinkRequests() {
        DefaultTableModel model = (DefaultTableModel) tbldrinkRequests.getModel();
        model.setRowCount(0);
        for (Network n : business.getNetworkList()) {
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                for (WorkRequest workRequest : e.getWorkQueue().getWorkRequestList()) {
                    if (workRequest instanceof HostBeverageWorkRequest) {
                       
                        if(((HostBeverageWorkRequest) workRequest).getLocation()!=null){
                        if (((HostBeverageWorkRequest) workRequest).getLocation().getUsername().equals(account.getUsername())) {
                            Object[] row = new Object[model.getColumnCount()];
                            row[0] = workRequest;
                            row[1] = ((HostBeverageWorkRequest) workRequest).getEventName();
                            row[2] = ((HostBeverageWorkRequest) workRequest).getEvenCat();
                            row[3] = ((HostBeverageWorkRequest) workRequest).getAttendance();
                            row[4] = ((HostBeverageWorkRequest) workRequest).getPlannedDate();
                            row[5] = ((HostBeverageWorkRequest) workRequest).getHost();
                            row[6] = ((HostBeverageWorkRequest) workRequest).getHost().getCity();
                            row[7] = ((HostBeverageWorkRequest) workRequest).getStatus();
                            row[8] = ((HostBeverageWorkRequest) workRequest).getMessage();
                            row[9] = ((HostBeverageWorkRequest) workRequest).getLocNote();
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldrinkRequests = new javax.swing.JTable();
        btndrinkapprovereq = new javax.swing.JButton();
        btndrinkrejectreq = new javax.swing.JButton();
        txtAddMsg = new javax.swing.JTextField();
        blAddMessage = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 102, 255));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Manage Beverage Requests");

        tbldrinkRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request Type", "Event Name", "Event Category", "Attendance", "Planned Date", "Host", "Host City", "Status", "Message from Host", "Location Team Reply"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbldrinkRequests);

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(440, 440, 440)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(blAddMessage)
                        .addGap(18, 18, 18)
                        .addComponent(txtAddMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btndrinkapprovereq)
                        .addGap(54, 54, 54)
                        .addComponent(btndrinkrejectreq)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(149, 149, 149))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btndrinkapprovereqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndrinkapprovereqActionPerformed
        // TODO add your handling code here:
        int selectedRow = tbldrinkRequests.getSelectedRow();
        if (selectedRow >= 0) {
            HostBeverageWorkRequest request = (HostBeverageWorkRequest) tbldrinkRequests.getValueAt(selectedRow, 0);
            String message = txtAddMsg.getText();
            if (message.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Kindly enter additional details to the Host.");
                return;
            }
            if (!request.getStatus().equals("Awaiting Govt Approval")) {
            if (!"Beverage Order Approved".equals(request.getStatus())) {
                request.setStatus("Beverage Order Approved");
                request.setMessage(message);
                JOptionPane.showMessageDialog(null, "Beverage Order is Approved!");
                    account.setStatus("Booked");
                populateDrinkRequests();
                goDelivery(request);
            } else {
                JOptionPane.showMessageDialog(null, "Beverage Order is already Approved!");
            }
            } else {
                JOptionPane.showMessageDialog(null, "Select an appropriate Beverage Order!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select one row!");
        }
    }//GEN-LAST:event_btndrinkapprovereqActionPerformed

    private void btndrinkrejectreqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndrinkrejectreqActionPerformed
        // TODO add your handling code here:
        int selectedRow = tbldrinkRequests.getSelectedRow();
        if (selectedRow >= 0) {
            HostBeverageWorkRequest request = (HostBeverageWorkRequest) tbldrinkRequests.getValueAt(selectedRow, 0);
            String message = txtAddMsg.getText();
            if (message.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Kindly enter the reason for Rejection");
                return;
            }
            if (!"Completed".equals(request.getStatus()) && !"In Progress".equals(request.getStatus())) {
                request.setStatus("Rejected");
                request.setMessage(message);
                JOptionPane.showMessageDialog(null, "Beverage Order Rejected!");
                    account.setStatus("Available");
                populateDrinkRequests();
            } else {
                JOptionPane.showMessageDialog(null, "Beverage Order is already " + request.getStatus());
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
    private javax.swing.JTable tbldrinkRequests;
    private javax.swing.JTextField txtAddMsg;
    // End of variables declaration//GEN-END:variables
}
