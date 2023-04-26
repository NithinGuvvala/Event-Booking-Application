/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.UserRegistration;

import Business.APIforSMS.APIforSMS;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.HostRole;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.UserRegistrationRequest;
import Business.WorkQueue.WorkQueue;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Ruchika
 */
public class UserRegistrationJPanel extends javax.swing.JPanel {

    private final EcoSystem system;
    private boolean flag = false;

    /**
     * Creates new form UserRegistrationJPanel
     */
    public UserRegistrationJPanel(JPanel userProcessContainer, EcoSystem system) {
        initComponents();
        this.system = system;
        populateNetworkComboBox();
        populateOrgTypes();
    }

    public void populateNetworkComboBox() {
        stateCombo.removeAllItems();
        for (Network network : system.getNetworkList()) {
            stateCombo.addItem(network);
        }
    }
    public void populateOrgTypes() {
        cbOrg.addItem(Organization.Type.Host);
        cbOrg.addItem(Organization.Type.Beverages);
        cbOrg.addItem(Organization.Type.Delivery);
//        cbOrg.addItem(Organization.Type.ER);
        cbOrg.addItem(Organization.Type.Food);
        cbOrg.addItem(Organization.Type.Photographer);
        cbOrg.addItem(Organization.Type.GovtAuth);
        cbOrg.addItem(Organization.Type.Infrastructure);
        cbOrg.addItem(Organization.Type.Location);
        cbOrg.addItem(Organization.Type.Musician);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        UsrNameLabel = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        txtContact = new javax.swing.JTextField();
        stateCombo = new javax.swing.JComboBox();
        btnRegister = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        pbPwdStr = new javax.swing.JProgressBar();
        jLabel8 = new javax.swing.JLabel();
        cbOrg = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 51));
        setMinimumSize(new java.awt.Dimension(1338, 900));
        setPreferredSize(new java.awt.Dimension(1338, 900));
        setRequestFocusEnabled(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(25, 56, 82));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sign Up to Host an Event");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, -1, -1));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(25, 56, 82));
        jLabel2.setText("Name");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, -1, -1));

        txtName.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txtName.setForeground(new java.awt.Color(25, 56, 82));
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNameKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNameKeyTyped(evt);
            }
        });
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 240, 250, 30));

        UsrNameLabel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        UsrNameLabel.setForeground(new java.awt.Color(25, 56, 82));
        UsrNameLabel.setText("Username");
        add(UsrNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, -1, -1));

        txtUsername.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(25, 56, 82));
        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsernameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsernameKeyTyped(evt);
            }
        });
        add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 300, 250, 30));

        passwordLabel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(25, 56, 82));
        passwordLabel.setText("Password");
        add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 370, 62, 20));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(25, 56, 82));
        jLabel5.setText("Email Id");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 440, -1, 20));

        txtEmail.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(25, 56, 82));
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });
        add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 430, 250, 30));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(25, 56, 82));
        jLabel6.setText("State");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 500, -1, 20));

        txtCity.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txtCity.setForeground(new java.awt.Color(25, 56, 82));
        txtCity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCityKeyTyped(evt);
            }
        });
        add(txtCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 540, 250, 30));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(25, 56, 82));
        jLabel7.setText("City");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 550, -1, -1));

        lblPhone.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblPhone.setForeground(new java.awt.Color(25, 56, 82));
        lblPhone.setText("Contact No");
        add(lblPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 600, -1, 30));

        txtContact.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txtContact.setForeground(new java.awt.Color(25, 56, 82));
        txtContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContactActionPerformed(evt);
            }
        });
        txtContact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContactKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtContactKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContactKeyTyped(evt);
            }
        });
        add(txtContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 600, 250, 30));

        stateCombo.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        stateCombo.setForeground(new java.awt.Color(25, 56, 82));
        stateCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                stateComboItemStateChanged(evt);
            }
        });
        stateCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stateComboActionPerformed(evt);
            }
        });
        stateCombo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                stateComboKeyReleased(evt);
            }
        });
        add(stateCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 490, 250, 30));

        btnRegister.setBackground(new java.awt.Color(255, 51, 255));
        btnRegister.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(25, 56, 82));
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 650, -1, -1));

        txtPassword.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(25, 56, 82));
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPasswordKeyTyped(evt);
            }
        });
        add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 360, 250, 30));

        pbPwdStr.setMaximum(15);
        pbPwdStr.setMinimum(6);
        pbPwdStr.setValue(0);
        add(pbPwdStr, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 400, 250, 10));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(25, 56, 82));
        jLabel8.setText("Organization");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, -1, 20));

        cbOrg.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        cbOrg.setForeground(new java.awt.Color(25, 56, 82));
        cbOrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbOrgActionPerformed(evt);
            }
        });
        cbOrg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cbOrgKeyTyped(evt);
            }
        });
        add(cbOrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 200, 250, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/banne.png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 680, 1360, 140));
    }// </editor-fold>//GEN-END:initComponents

    private void stateComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stateComboActionPerformed

    }//GEN-LAST:event_stateComboActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed

        Network network = (Network) stateCombo.getSelectedItem();
        Organization.Type type = (Organization.Type) cbOrg.getSelectedItem();
        String emailAddress = txtEmail.getText();
        String username = txtUsername.getText();
        String name = txtName.getText();
        String password = txtPassword.getText();
        String phone = txtContact.getText();
        String city = txtCity.getText();
        if (network == null || type == null || name.isEmpty() || username.isEmpty() || password.isEmpty() || emailAddress.isEmpty()
                || city.isEmpty() || phone.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Kindly enter all the details to Register!", "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!system.validatePassword(password)) {
            return;
        }
        if (!system.checkIfUserIsUnique(username)) {
            return;
        }
        if (!this.system.validateEmailID(emailAddress)) {
            return;
        }
        if (!this.system.validateMobileNo(phone)) {
            return;
        }

        for (Network n : system.getNetworkList()) {
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
                    for (UserAccount u : o.getUserAccountDirectory().getUserAccountList()) {
                        if (u.getEmail() != null) {
                            if (u.getEmail().toLowerCase().equals(emailAddress.toLowerCase())) {
                                JOptionPane.showMessageDialog(null, "This Email Address already exists in our system", "Error!", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                        }
                    }
                }
            }
        }
        for (Network n : system.getNetworkList()) {
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
                    for (UserAccount u : o.getUserAccountDirectory().getUserAccountList()) {
                        if (u.getPhone() != null) {
                            if (u.getPhone().equals(phone)) {
                                JOptionPane.showMessageDialog(null, "This Contact Number already exists in our system", "Error!", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                        }
                    }
                }
            }
        }
        if (Organization.Type.Host == type) {
            flag = true;
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
             if (enterprise.getEnterpriseType() == Enterprise.EnterpriseType.GeoInfra) {
                Organization org = enterprise.getOrganizationDirectory().createOrganization(Organization.Type.Host, name);
                    Employee emp = org.getEmployeeDirectory().createEmployee(name);
                    UserAccount ua1 = org.getUserAccountDirectory().createUserAccount(username, password, emp, new HostRole());
                    ua1.setEmail(emailAddress);
                    ua1.setPhone(phone);
                    ua1.setCity(city);
                    String bodyMsg = "Hello " + username + ", \n Your account is activated. You are a Host now!";
                 APIforSMS sendSMS = new APIforSMS(phone, bodyMsg);   
             }
            }
        } else {
            UserRegistrationRequest registrationRequest = new UserRegistrationRequest();
            registrationRequest.setName(name);
            registrationRequest.setUserName(username);
            registrationRequest.setUserPassword(password);
            registrationRequest.setUserEmailId(emailAddress);
            registrationRequest.setNetwork(network);
            registrationRequest.setUserCity(city);
            registrationRequest.setOrgType(type);
            registrationRequest.setStatus("Requested");
            registrationRequest.setUserContact(phone);

            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    if (org.getType() == type) {
                        if (enterprise.getWorkQueue() == null) {
                            enterprise.setWorkQueue(new WorkQueue());
                        }
                        flag = true;
                        enterprise.getWorkQueue().getWorkRequestList().add(registrationRequest);
                        break;
                    }
                }
            }
        }
        if (flag) {
            String bodyMsg = "Hello " + username + ", \n Thank you for registering with us. Feel free to login to your account after the next 2 hours.";
        //    system.sendEmailMessage(emailAddress, bodyMsg);
                APIforSMS sendSMS = new APIforSMS(phone, bodyMsg);
            JOptionPane.showMessageDialog(null, "You have been registered succesfully!");
        } else {
            JOptionPane.showMessageDialog(null, "This Organization is not yet active in our Enterprise");
        }
        txtName.setText("");
        txtUsername.setText("");
        txtPassword.setText("");
        txtEmail.setText("");
        txtCity.setText("");
        txtContact.setText("");
    
        btnRegister.setEnabled(true);
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameKeyPressed

    private void txtNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyTyped
        // TODO add your handling code here
    }//GEN-LAST:event_txtNameKeyTyped

    private void txtUsernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txtUsernameKeyTyped

    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txtEmailKeyTyped

    private void stateComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_stateComboItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_stateComboItemStateChanged

    private void txtCityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCityKeyTyped
        // TODO add your handling code here
    }//GEN-LAST:event_txtCityKeyTyped

    private void txtContactKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContactKeyTyped
        // TODO add your handling code here: 
    }//GEN-LAST:event_txtContactKeyTyped

    private void txtUsernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameKeyReleased


    private void txtContactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContactKeyPressed
        // TODO add your handling code here:         
    }//GEN-LAST:event_txtContactKeyPressed

    private void txtContactKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContactKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContactKeyReleased

    private void txtContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContactActionPerformed

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailKeyReleased

    private void stateComboKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stateComboKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_stateComboKeyReleased

    private void txtPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyTyped
        int pwSize = txtPassword.getText().length();    
        pbPwdStr.setValue(pwSize);// TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordKeyTyped

    private void cbOrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOrgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbOrgActionPerformed

    private void cbOrgKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbOrgKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_cbOrgKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel UsrNameLabel;
    private javax.swing.JButton btnRegister;
    private javax.swing.JComboBox cbOrg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JProgressBar pbPwdStr;
    private javax.swing.JComboBox stateCombo;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
