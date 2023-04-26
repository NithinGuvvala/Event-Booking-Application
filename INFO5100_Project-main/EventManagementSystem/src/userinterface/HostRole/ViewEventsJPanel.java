/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.HostRole;

import Business.APIforSMS.APIforSMS;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.AuthRole;
import Business.Role.SecurityERRole;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.HostGovtWorkRequest;
import Business.WorkQueue.WorkRequest;
import Business.WorkQueue.HostSecurityERWorkRequest;
import com.twilio.rest.conversations.v1.service.Role;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nithin
 */
public class ViewEventsJPanel extends javax.swing.JPanel {

   private final JPanel userProcessContainer;
    private final EcoSystem system;
    private final UserAccount userAccount;
    private final Organization organization;
    private final Network network;
    private final Enterprise enterprise;
    private HostGovtWorkRequest request;
    
    HostSecurityERWorkRequest securityerRequest = new HostSecurityERWorkRequest();
    /**
     * Creates new form ViewEventsJPanel
     */
    public ViewEventsJPanel(JPanel userProcessContainer, UserAccount account, Enterprise ent, EcoSystem system,  Network net, Organization org) {
        initComponents();
      
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.userAccount = account;
        this.organization = org;
        this.enterprise = ent;
        this.network = net;

        populateEventsTable();
    }
    public void populateEventsTable() {
        DefaultTableModel model = (DefaultTableModel) tblEvents.getModel();
        model.setRowCount(0);
        for (Network n : system.getNetworkList()) {
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization org : e.getOrganizationDirectory().getOrganizationList()) {
                    for (UserAccount ua : org.getUserAccountDirectory().getUserAccountList()) {
                        if (ua.getRole() instanceof AuthRole) {
                            for(WorkRequest request : ua.getWorkQueue().getWorkRequestList()){
                             if ( request instanceof HostGovtWorkRequest) {
                                 if(((HostGovtWorkRequest) request).getHost().equals(userAccount)){
                Object[] row = new Object[8];
                row[0] = ((HostGovtWorkRequest) request).getEventName();
                row[1] = ((HostGovtWorkRequest) request).getEvenCat();
                row[2] = request;
                row[3] = ((HostGovtWorkRequest) request).getAttendance();
                row[4] = String.valueOf(((HostGovtWorkRequest) request).getPlannedDate() ).substring(0,10);
                row[5] = request.getStatus();

                model.addRow(row);
                                 }
                                }
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
        enterpriseLabel = new javax.swing.JLabel();
        lbl_StateView = new javax.swing.JLabel();
        lblView = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEvents = new javax.swing.JTable();
        btnSOS = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 102, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        enterpriseLabel.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        enterpriseLabel.setForeground(new java.awt.Color(0, 51, 51));
        enterpriseLabel.setText("Events Conducted");

        lbl_StateView.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbl_StateView.setForeground(new java.awt.Color(25, 56, 82));
        lbl_StateView.setText("Kindly select an Event and Click View to check the details");

        lblView.setBackground(new java.awt.Color(255, 255, 255));
        lblView.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblView.setForeground(new java.awt.Color(25, 56, 82));
        lblView.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblView.setText("View");
        lblView.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(25, 56, 82)));
        lblView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblViewMousePressed(evt);
            }
        });

        tblEvents.setBackground(new java.awt.Color(204, 204, 255));
        tblEvents.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        tblEvents.setForeground(new java.awt.Color(0, 51, 51));
        tblEvents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Event Name", "Event Category", "Request Type", "Attendance", "Planned Date", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblEvents);

        btnSOS.setBackground(new java.awt.Color(204, 255, 255));
        btnSOS.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        btnSOS.setForeground(new java.awt.Color(255, 0, 0));
        btnSOS.setText("SOS");
        btnSOS.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSOSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_StateView)
                .addGap(60, 60, 60)
                .addComponent(lblView, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSOS, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(280, 280, 280)
                            .addComponent(enterpriseLabel))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(btnSOS, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_StateView, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblView, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSOSActionPerformed
        int selectedRow =tblEvents.getSelectedRow();
        int count = tblEvents.getSelectedRowCount();

        if (count == 1) {
            if (selectedRow >= 0) {
                HostGovtWorkRequest request =   (HostGovtWorkRequest)tblEvents.getValueAt(selectedRow, 2);
//                String comment = addnInfoLoc.getText();

                if(!request.getStatus().equals("SOS Issued")){
                    for (Network n : system.getNetworkList()) {
                    for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                        for (Organization org : e.getOrganizationDirectory().getOrganizationList()) {
                            if(org.getType().equals(Organization.Type.SecurityER)){   
                                for (UserAccount ua : org.getUserAccountDirectory().getUserAccountList()) {
                                    securityerRequest.setRequestID();
                                    securityerRequest.setSender(userAccount);
                                    securityerRequest.setHost(userAccount);
                                    securityerRequest.setLocation(ua);
                                    
                                    securityerRequest.setLocNote(userAccount.getCity());
                                    securityerRequest.setStatus("SOS Issued");
//                                    if (!comment.isEmpty()) locRequest.setMessage(comment);
                                    securityerRequest.setAttendance(request.getAttendance());
                                    securityerRequest.setEventName(request.getEventName());
                                    securityerRequest.setEvenCat(request.getEvenCat());
                                    securityerRequest.setPlannedDate(request.getPlannedDate());
                                    securityerRequest.setOrgType(Organization.Type.SecurityER);
                                    
                                    
                                    e.getWorkQueue().getWorkRequestList().add(securityerRequest);
                                    System.out.println("Request"+securityerRequest.toString()+"  >> Added to Enterprise "+e);
                                    JOptionPane.showMessageDialog(null, "Location Request Sent Successfully to "+ua.getUsername()+" !");
                                    
                                    APIforSMS sms = new APIforSMS(ua.getPhone(), "Hello "+ua.getName()+",  A Host likes to notify on emergency request "+String.valueOf(((HostGovtWorkRequest) request).getPlannedDate() ).substring(0,10)+". Kindly login for more details.");
                                    //system.sendEmailMessage(locTeam.getEmail(), "Hello! You have one new work request! Please login to know more!");
                            }
                            }
                        }
                    }
                    }
                    
                                    for (Network n : system.getNetworkList()) {
                            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                                for (Organization org : e.getOrganizationDirectory().getOrganizationList()) {
                                    for (UserAccount ua : org.getUserAccountDirectory().getUserAccountList()) {
                                        if (ua.getRole() instanceof AuthRole) {
                                            for(WorkRequest wr : ua.getWorkQueue().getWorkRequestList()){
                                             if ( wr instanceof HostGovtWorkRequest) {
                                                 if(((HostGovtWorkRequest) wr).getHost().equals(userAccount)){
                                                     wr.setStatus("Awaiting SOS Approval");
                                                 }
                                                }
                                            }
                                        }
                                    }
                                }
                            }   
                        }
                 populateEventsTable();
                }                   
                else {
                  JOptionPane.showMessageDialog(null, "SOS already Issued for this Event!");
                }        
            }else {
            JOptionPane.showMessageDialog(null, "Please select an Event to send SOS!");
                 }    
            }
    }//GEN-LAST:event_btnSOSActionPerformed

    private void lblViewMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewMousePressed
        // TODO add your handling code here:

        int selectedRow = tblEvents.getSelectedRow();
        int count = tblEvents.getSelectedRowCount();
        if (count == 1) {
            if (selectedRow >= 0) {
                
                HostGovtWorkRequest request = (HostGovtWorkRequest) tblEvents.getValueAt(selectedRow,2);
                if(request.getStatus().equals("Awaiting Govt Approval")){
                JOptionPane.showMessageDialog(null, "Waiting for Government Authority to Approve.");
                }
                else if (request.getStatus().equals("Rejected")){
                JOptionPane.showMessageDialog(null, "Event Rejected. Kindly select an different Event.");
                }
                else{
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                ViewEventDetailsJPanel viewEventDetailsJPanel = new ViewEventDetailsJPanel(userProcessContainer, userAccount, system, network, request);
                userProcessContainer.add(viewEventDetailsJPanel);
                layout.next(userProcessContainer);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select a Row to continue.");
        }
    }//GEN-LAST:event_lblViewMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSOS;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblView;
    private javax.swing.JLabel lbl_StateView;
    private javax.swing.JTable tblEvents;
    // End of variables declaration//GEN-END:variables
}
