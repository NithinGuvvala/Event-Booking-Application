/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.EnterAdminRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Ruchika
 */
public class CateringAdminWorkAreaJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    Enterprise enterprise;
    EcoSystem system;
    Network network;
    UserAccount account;
    Organization organization;
    /**
     * Creates new form CateringAdminWorkAreaJPanel
     */
    public CateringAdminWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.system = business;
        this.network = network;
        this.enterprise = enterprise;
        this.organization = organization;
        manageOrganization();
    }

    private void manageOrganization() {
        CateringManageOrgJPanel cateringManageOrgJPanel = new CateringManageOrgJPanel(enterprise.getOrganizationDirectory());
        jPanel4.add("CateringManageOrgJPanel", cateringManageOrgJPanel);
        CardLayout layout = (CardLayout) jPanel4.getLayout();
        layout.next(jPanel4);
    }

    private void manageEmployee() {
        CateringManageEmpJPanel cateringManageEmpJPanel = new CateringManageEmpJPanel(enterprise.getOrganizationDirectory());
        jPanel4.add("CateringManageEmpJPanel", cateringManageEmpJPanel);
        CardLayout layout = (CardLayout) jPanel4.getLayout();
        layout.next(jPanel4);
    }

    private void manageUsers() {
        CateringManageUsersJPanel CateringManageUsersJPanel = new CateringManageUsersJPanel(enterprise, system, organization);
        jPanel4.add("CateringManageUsersJPanel", CateringManageUsersJPanel);
        CardLayout layout = (CardLayout) jPanel4.getLayout();
        layout.next(jPanel4);
    }

    private void manageRequests() {
        CateringManageWorkReqsJPanel cateringManageWorkReqsJPanel = new CateringManageWorkReqsJPanel(enterprise);
        jPanel4.add("CateringManageWorkReqsJPanel", cateringManageWorkReqsJPanel);
        CardLayout layout = (CardLayout) jPanel4.getLayout();
        layout.next(jPanel4);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        manageOrgPanel = new javax.swing.JPanel();
        manageOrganization = new javax.swing.JLabel();
        manageEmp = new javax.swing.JPanel();
        manageEmployeeLabel = new javax.swing.JLabel();
        manageUserAcc = new javax.swing.JPanel();
        manageUserAccountLabel = new javax.swing.JLabel();
        manageRequestPanel = new javax.swing.JPanel();
        manageRequestLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();

        jSplitPane1.setDividerLocation(260);

        jPanel3.setBackground(new java.awt.Color(153, 153, 0));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel1.setText("Catering Enterprise");

        manageOrgPanel.setBackground(new java.awt.Color(204, 204, 255));
        manageOrgPanel.setForeground(new java.awt.Color(255, 255, 204));
        manageOrgPanel.setToolTipText("");
        manageOrgPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        manageOrgPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                manageOrgPanelMousePressed(evt);
            }
        });

        manageOrganization.setBackground(new java.awt.Color(215, 81, 81));
        manageOrganization.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        manageOrganization.setText("Manage Organization");
        manageOrganization.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                manageOrganizationMousePressed(evt);
            }
        });

        javax.swing.GroupLayout manageOrgPanelLayout = new javax.swing.GroupLayout(manageOrgPanel);
        manageOrgPanel.setLayout(manageOrgPanelLayout);
        manageOrgPanelLayout.setHorizontalGroup(
            manageOrgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manageOrgPanelLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(manageOrganization)
                .addGap(50, 50, 50))
        );
        manageOrgPanelLayout.setVerticalGroup(
            manageOrgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageOrgPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(manageOrganization, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        manageEmp.setBackground(new java.awt.Color(204, 204, 255));
        manageEmp.setForeground(new java.awt.Color(255, 255, 204));
        manageEmp.setToolTipText("");
        manageEmp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        manageEmp.setPreferredSize(new java.awt.Dimension(264, 48));
        manageEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                manageEmpMousePressed(evt);
            }
        });

        manageEmployeeLabel.setBackground(new java.awt.Color(215, 81, 81));
        manageEmployeeLabel.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        manageEmployeeLabel.setText("Manage Team");
        manageEmployeeLabel.setAutoscrolls(true);
        manageEmployeeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                manageEmployeeLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout manageEmpLayout = new javax.swing.GroupLayout(manageEmp);
        manageEmp.setLayout(manageEmpLayout);
        manageEmpLayout.setHorizontalGroup(
            manageEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageEmpLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(manageEmployeeLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        manageEmpLayout.setVerticalGroup(
            manageEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manageEmpLayout.createSequentialGroup()
                .addGap(0, 24, Short.MAX_VALUE)
                .addComponent(manageEmployeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        manageUserAcc.setBackground(new java.awt.Color(204, 204, 255));
        manageUserAcc.setForeground(new java.awt.Color(255, 255, 204));
        manageUserAcc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        manageUserAcc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                manageUserAccMousePressed(evt);
            }
        });

        manageUserAccountLabel.setBackground(new java.awt.Color(215, 81, 81));
        manageUserAccountLabel.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        manageUserAccountLabel.setText("Manage Users");
        manageUserAccountLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        manageUserAccountLabel.setPreferredSize(new java.awt.Dimension(115, 16));

        javax.swing.GroupLayout manageUserAccLayout = new javax.swing.GroupLayout(manageUserAcc);
        manageUserAcc.setLayout(manageUserAccLayout);
        manageUserAccLayout.setHorizontalGroup(
            manageUserAccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageUserAccLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(manageUserAccountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        manageUserAccLayout.setVerticalGroup(
            manageUserAccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(manageUserAccountLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
        );

        manageRequestPanel.setBackground(new java.awt.Color(204, 204, 255));
        manageRequestPanel.setForeground(new java.awt.Color(255, 255, 204));
        manageRequestPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        manageRequestPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                manageRequestPanelMousePressed(evt);
            }
        });

        manageRequestLabel.setBackground(new java.awt.Color(255, 213, 90));
        manageRequestLabel.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        manageRequestLabel.setText("Manage Requests");
        manageRequestLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        manageRequestLabel.setPreferredSize(new java.awt.Dimension(115, 16));

        javax.swing.GroupLayout manageRequestPanelLayout = new javax.swing.GroupLayout(manageRequestPanel);
        manageRequestPanel.setLayout(manageRequestPanelLayout);
        manageRequestPanelLayout.setHorizontalGroup(
            manageRequestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageRequestPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(manageRequestLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        manageRequestPanelLayout.setVerticalGroup(
            manageRequestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manageRequestPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(manageRequestLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 17, Short.MAX_VALUE)
                        .addComponent(manageOrgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(manageEmp, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
                    .addComponent(manageUserAcc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(manageRequestPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(manageOrgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manageEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(manageUserAcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(manageRequestPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(405, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {manageEmp, manageOrgPanel, manageRequestPanel, manageUserAcc});

        jSplitPane1.setLeftComponent(jPanel3);

        jPanel4.setBackground(new java.awt.Color(102, 0, 255));
        jPanel4.setLayout(new java.awt.CardLayout());
        jSplitPane1.setRightComponent(jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1107, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void manageOrganizationMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageOrganizationMousePressed
        manageOrganization();
    }//GEN-LAST:event_manageOrganizationMousePressed

    private void manageOrgPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageOrgPanelMousePressed
        // TODO add your handling code here:
        manageOrganization();
    }//GEN-LAST:event_manageOrgPanelMousePressed

    private void manageEmployeeLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageEmployeeLabelMousePressed
        manageEmployee();
    }//GEN-LAST:event_manageEmployeeLabelMousePressed

    private void manageEmpMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageEmpMousePressed
        // TODO add your handling code here:
        manageEmployee();
    }//GEN-LAST:event_manageEmpMousePressed

    private void manageUserAccMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageUserAccMousePressed
        manageUsers();
    }//GEN-LAST:event_manageUserAccMousePressed

    private void manageRequestPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageRequestPanelMousePressed
        // TODO add your handling code here:
        manageRequests();
    }//GEN-LAST:event_manageRequestPanelMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel manageEmp;
    private javax.swing.JLabel manageEmployeeLabel;
    private javax.swing.JPanel manageOrgPanel;
    private javax.swing.JLabel manageOrganization;
    private javax.swing.JLabel manageRequestLabel;
    private javax.swing.JPanel manageRequestPanel;
    private javax.swing.JPanel manageUserAcc;
    private javax.swing.JLabel manageUserAccountLabel;
    // End of variables declaration//GEN-END:variables
}
