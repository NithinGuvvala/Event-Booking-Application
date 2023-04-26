/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.FoodRole;

import Business.APIforSMS.APIforSMS;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.BevDeliveryWorkRequest;
import Business.WorkQueue.FoodDeliveryWorkRequest;
import Business.WorkQueue.HostBeverageWorkRequest;
import Business.WorkQueue.HostFoodWorkRequest;
import Business.WorkQueue.LocInfraWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Nithin
 */
public class FoodRequestJPanel extends javax.swing.JPanel {

    private final JPanel userProcessContainer;
    private final UserAccount account;
    private final EcoSystem business;
    /**
     * Creates new form FoodRequestJPanel
     */
    public FoodRequestJPanel(JPanel userProcessContainer, UserAccount account, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.business = business;
        populateFoodRequests();
    }
    
       public void goDelivery(HostFoodWorkRequest request){
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
                                    FoodDeliveryWorkRequest foodRequest = new FoodDeliveryWorkRequest();                                                           
                                    foodRequest.setRequestID();
                                    foodRequest.setSender(account);
                                    foodRequest.setLocation(account);
                                    foodRequest.setInfra(ua);
                                    foodRequest.setStatus("Pending");
                                    if (!comment.isEmpty()) foodRequest.setMessage(comment);
                                    foodRequest.setAttendance(request.getAttendance());
                                    foodRequest.setEventName(request.getEventName());
                                    foodRequest.setEvenCat(request.getEvenCat());
                                    foodRequest.setPlannedDate(request.getPlannedDate());
                                    foodRequest.setOrgType(Organization.Type.Delivery);
                                    
                                    
                                    e.getWorkQueue().getWorkRequestList().add(foodRequest);
                                    System.out.println("Request"+foodRequest.toString()+"  >> Added to Enterprise "+e);
                                    JOptionPane.showMessageDialog(null, "Delivery Request Sent Successfully!");
                                    APIforSMS sms = new APIforSMS(ua.getPhone(), "Hello "+ua.getName()+", Food Team:"+request.getLocation().getName()+" likes to book a Delivery package on "+String.valueOf(foodRequest.getPlannedDate() ).substring(0,10)+". Kindly login for more details.");
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
                                   FoodDeliveryWorkRequest foodRequest = new FoodDeliveryWorkRequest();                                                          
                                    foodRequest.setRequestID();
                                    foodRequest.setSender(account);
                                    foodRequest.setHost(account);
                                    foodRequest.setInfra(uaa);
                                    foodRequest.setLocation(account);
                                    foodRequest.setStatus("Pending");
                                    if (!comment.isEmpty()) foodRequest.setMessage(comment);
                                    foodRequest.setAttendance(request.getAttendance());
                                    foodRequest.setEventName(request.getEventName());
                                    foodRequest.setEvenCat(request.getEvenCat());
                                    foodRequest.setPlannedDate(request.getPlannedDate());
                                    foodRequest.setOrgType(Organization.Type.Delivery);
                                    
                                    
                                    e.getWorkQueue().getWorkRequestList().add(foodRequest);
                                    System.out.println("Request"+foodRequest.toString()+"  >> Added to Enterprise "+e);
                                    JOptionPane.showMessageDialog(null, "Delivery Request Sent Successfully!");
                                    APIforSMS sms = new APIforSMS(uaa.getPhone(), "Hello "+uaa.getName()+", Food Team:"+request.getLocation().getName()+" likes to book a Delivery package on "+String.valueOf(foodRequest.getPlannedDate() ).substring(0,10)+". Kindly login for more details.");
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

    public void populateFoodRequests() {
        DefaultTableModel model = (DefaultTableModel) tblFoodRequests.getModel();
        model.setRowCount(0);
        for (Network n : business.getNetworkList()) {
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                for (WorkRequest workRequest : e.getWorkQueue().getWorkRequestList()) {
                    if (workRequest instanceof HostFoodWorkRequest) {
                        if(((HostFoodWorkRequest) workRequest).getLocation()!=null){
                        if (((HostFoodWorkRequest) workRequest).getLocation().getUsername().equals(account.getUsername())) {
                            Object[] row = new Object[model.getColumnCount()];
                            row[0] = workRequest;
                            row[1] = ((HostFoodWorkRequest) workRequest).getEventName();
                            row[2] = ((HostFoodWorkRequest) workRequest).getEvenCat();
                            row[3] = ((HostFoodWorkRequest) workRequest).getAttendance();
                            row[4] = ((HostFoodWorkRequest) workRequest).getPlannedDate();
                            row[5] = ((HostFoodWorkRequest) workRequest).getHost();
                            row[6] = ((HostFoodWorkRequest) workRequest).getHost().getCity();
                            row[7] = ((HostFoodWorkRequest) workRequest).getStatus();
                            row[8] = ((HostFoodWorkRequest) workRequest).getMessage();
                            row[9] = ((HostFoodWorkRequest) workRequest).getLocNote();
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
        tblFoodRequests = new javax.swing.JTable();
        btnfoodapprovereq = new javax.swing.JButton();
        btnfoodrejectreq = new javax.swing.JButton();
        txtAddMsg = new javax.swing.JTextField();
        blAddMessage = new javax.swing.JLabel();
        txtAddMsg1 = new javax.swing.JTextField();
        blAddMessage1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 153, 0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Manage Food Requests");

        tblFoodRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request Type", "Event Name", "Event Category", "Attendance", "Planned Date", "Host", "Host City", "Status", "Message from Host", "Loc Team Reply"
            }
        ));
        jScrollPane1.setViewportView(tblFoodRequests);

        btnfoodapprovereq.setBackground(new java.awt.Color(153, 153, 0));
        btnfoodapprovereq.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnfoodapprovereq.setText("Approve Request");
        btnfoodapprovereq.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnfoodapprovereq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfoodapprovereqActionPerformed(evt);
            }
        });

        btnfoodrejectreq.setBackground(new java.awt.Color(153, 153, 0));
        btnfoodrejectreq.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnfoodrejectreq.setText("Reject Request");
        btnfoodrejectreq.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnfoodrejectreq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfoodrejectreqActionPerformed(evt);
            }
        });

        blAddMessage.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        blAddMessage.setForeground(new java.awt.Color(41, 50, 80));
        blAddMessage.setText("Additional Message:");

        txtAddMsg1.setBackground(new java.awt.Color(204, 204, 255));

        blAddMessage1.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        blAddMessage1.setForeground(new java.awt.Color(41, 50, 80));
        blAddMessage1.setText("Additional Message:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(blAddMessage)
                                .addGap(18, 18, 18)
                                .addComponent(txtAddMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(397, 397, 397))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(446, 446, 446))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnfoodapprovereq, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnfoodrejectreq, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(417, 417, 417))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(blAddMessage)
                    .addComponent(txtAddMsg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnfoodapprovereq, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnfoodrejectreq, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));
    }// </editor-fold>//GEN-END:initComponents
                                    

    private void btnfoodapprovereqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfoodapprovereqActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblFoodRequests.getSelectedRow();
        if (selectedRow >= 0) {
            HostFoodWorkRequest request = (HostFoodWorkRequest) tblFoodRequests.getValueAt(selectedRow, 0);
            String message = txtAddMsg.getText();
            if (message.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Kindly enter additional details to the Host.");
                return;
            }
            if (!request.getStatus().equals("Awaiting Govt Approval")) {

                if (!"Order Approved".equals(request.getStatus())) {
                    request.setStatus("Food Order Approved");
                    request.setMessage(message);
                    JOptionPane.showMessageDialog(null, "Food Order is Approved!");
                    account.setStatus("Food Order Approved");
                    populateFoodRequests();
                    goDelivery(request);
                } else {
                    JOptionPane.showMessageDialog(null, "Food Order is already Approved!");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Select an appropriate Order!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select one row!");
        }
    }//GEN-LAST:event_btnfoodapprovereqActionPerformed

    private void btnfoodrejectreqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfoodrejectreqActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblFoodRequests.getSelectedRow();
        if (selectedRow >= 0) {
            HostFoodWorkRequest request = (HostFoodWorkRequest) tblFoodRequests.getValueAt(selectedRow, 0);
            String message = txtAddMsg.getText();
            if (message.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Kindly enter the reason for Rejection");
                return;
            }
            if (!"Completed".equals(request.getStatus()) && !"In Progress".equals(request.getStatus())) {
                request.setStatus("Rejected");
                request.setMessage(message);
                JOptionPane.showMessageDialog(null, "Food Order Rejected!");
                    account.setStatus("Available");
                populateFoodRequests();
            } else {
                JOptionPane.showMessageDialog(null, "Food Order is already " + request.getStatus());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Kindly select a row.");
        }
    }//GEN-LAST:event_btnfoodrejectreqActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel blAddMessage;
    private javax.swing.JLabel blAddMessage1;
    private javax.swing.JButton btnfoodapprovereq;
    private javax.swing.JButton btnfoodrejectreq;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFoodRequests;
    private javax.swing.JTextField txtAddMsg;
    private javax.swing.JTextField txtAddMsg1;
    // End of variables declaration//GEN-END:variables
}
