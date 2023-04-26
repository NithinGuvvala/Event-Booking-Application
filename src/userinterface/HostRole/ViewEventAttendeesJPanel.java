/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.HostRole;

import Business.APIforSMS.APIforSMS;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Host.Attendant;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.AuthRole;
import Business.Role.HostRole;
import Business.Role.SecurityERRole;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.HostGovtWorkRequest;
import Business.WorkQueue.WorkRequest;
import Business.WorkQueue.HostSecurityERWorkRequest;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.CardLayout;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ruchika
 */
public class ViewEventAttendeesJPanel extends javax.swing.JPanel {

   private final JPanel userProcessContainer;
    private final EcoSystem system;
    private final UserAccount userAccount;
 
    
    HostSecurityERWorkRequest securityerRequest = new HostSecurityERWorkRequest();
    /**
     * Creates new form ViewEventsJPanel
     */
    public ViewEventAttendeesJPanel(JPanel userProcessContainer, UserAccount account, EcoSystem system) {
        initComponents();
      
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.userAccount = account;

        popAttendeesTable();
    }
    public void popAttendeesTable() {
        DefaultTableModel model = (DefaultTableModel) tblEventAttendees.getModel();
        model.setRowCount(0);
        for (Network n : system.getNetworkList()) {
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization org : e.getOrganizationDirectory().getOrganizationList()) {
                    for (UserAccount ua : org.getUserAccountDirectory().getUserAccountList()) {
                        if (ua.getRole() instanceof HostRole) {
                            if(ua.equals(userAccount)){
                                for(Attendant att : ua.getAttendees().getAttendeeList()){
                                Object[] row = new Object[3];
                                row[0] = att.getName();
                                row[1] = att.getEmail();
                                row[2] = att.getPhone();
                                model.addRow(row);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEventAttendees = new javax.swing.JTable();
        btnSendMail = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtAttMail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtAttName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAttPhone = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 51, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        enterpriseLabel.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        enterpriseLabel.setForeground(new java.awt.Color(0, 51, 51));
        enterpriseLabel.setText("Attendees List");

        tblEventAttendees.setBackground(new java.awt.Color(204, 204, 255));
        tblEventAttendees.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        tblEventAttendees.setForeground(new java.awt.Color(0, 51, 51));
        tblEventAttendees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "Email ID", "Phone No"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblEventAttendees);

        btnSendMail.setBackground(new java.awt.Color(204, 255, 255));
        btnSendMail.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        btnSendMail.setForeground(new java.awt.Color(255, 0, 0));
        btnSendMail.setText("Send Email");
        btnSendMail.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSendMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendMailActionPerformed(evt);
            }
        });

        jLabel1.setText("Attendee Name:");

        jLabel2.setText("Email ID:");

        jLabel3.setText("Phone Number:");

        btnAdd.setText("Add Attendee");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(352, 352, 352)
                        .addComponent(btnAdd))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSendMail, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(168, 168, 168)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addGap(34, 34, 34)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtAttMail, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                            .addComponent(txtAttPhone)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(29, 29, 29)
                                        .addComponent(txtAttName, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAttName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAttMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnSendMail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAttPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(btnAdd)
                .addGap(27, 27, 27))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 22, -1, 360));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        String attName = txtAttName.getText().trim();
        String attMail = txtAttMail.getText().trim();
        String attPhone = txtAttPhone.getText().trim();
        
        if (attName.isEmpty() || attMail.isEmpty() || attPhone.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Kindly enter all the details to Register!", "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!this.system.validateEmailID(attMail)) {
            return;
        }
        if (!this.system.validateMobileNo(attPhone)) {
            return;
        }
        
        for (Network n : system.getNetworkList()) {
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization org : e.getOrganizationDirectory().getOrganizationList()) {
                    for (UserAccount ua : org.getUserAccountDirectory().getUserAccountList()) {
                        if (ua.getRole() instanceof HostRole) {
                            if(ua.equals(userAccount)){
                                Attendant att = new Attendant();
                                att.setName(attName);
                                att.setPhone(attPhone);
                                att.setEmail(attMail);
                                ua.getAttendees().getAttendeeList().add(att);
                                JOptionPane.showMessageDialog(null, "Attendant Added Successfully!");
                                txtAttMail.setText("");
                                txtAttName.setText("");
                                txtAttPhone.setText("");
                                popAttendeesTable();
                                
                                }
                               }                         
                        }
                    }
                }
            }           
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSendMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendMailActionPerformed
      
        Document document = new Document();
                Font blueFont = FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, new CMYKColor(255, 0, 0, 0));
		Font redFont = FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLD, new CMYKColor(0, 255, 0, 0));
		Font yellowFont = FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 0, 255, 0));
		
		try
		{
//                    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:/Users/gowth/Downloads/JavaiTextPDFExamples/vignesh.pdf"));
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("AddImageExample.pdf"));
			document.open();
			
//                        System.out.println("pdf");
			//Add Image
			Image image1 = Image.getInstance("src/images/your_invited.jpg");
			//For Fixed Positioning
			//image1.setAbsolutePosition(100f, 550f);
			//Scale to new height and new width of image
			image1.scaleAbsolute(550, 200);
			//Add to document
			document.add(image1);
                        document.add(new Paragraph("Dear Friend,"));
                        document.add(new Paragraph("\n"));
                        document.add(new Paragraph("You are most cordially invited to be our guest at the dinner party we have arranged next week. It will be great having you among us!"));
                        document.add(new Paragraph("\n"));
                        document.add(new Paragraph("We are going to arrange a dinner party at our sweet home . Your presence is what we are asking for to make it a memorable one!"));
                        document.add(new Paragraph("\n"));
                        document.add(new Paragraph("Your company is all that we are asking for as we celebrate the night next week with our friends and relatives. Please join us to have a share in our happiness!"));
                        document.add(new Paragraph("\n"));
                        document.add(new Paragraph("It’s always a pleasure to have you with us. Let’s have yet another occasion to sit together and share some delicious foods and desserts. You are cordially invited!"));
                        document.add(new Paragraph("\n"));
                        document.add(new Paragraph("Nothing makes the bonds stronger than sharing the same food with our loved ones. We invite you to join us on next week as we have planned to throw a dinner party at our residence!"));
                        document.add(new Paragraph("\n"));
                        document.add(new Paragraph("\n"));
                        document.add(new Paragraph("\n"));
                        document.add(new Paragraph("\n"));
                        document.add(new Paragraph("\n"));
                        document.add(new Paragraph("\n"));
                        document.add(new Paragraph("Best Regards"));
                      
                        
//			String imageUrl = "your_invited.jpg";
//			Image image2 = Image.getInstance(new URL(imageUrl));
//			document.add(image2);

			document.close();
			writer.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}// TODO add your handling code here:
                
                String filepath = "AddImageExample.pdf";
                for (Attendant att : userAccount.getAttendees().getAttendeeList()) {          
                sendemail(filepath,att.getEmail());
                }
    }//GEN-LAST:event_btnSendMailActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnSendMail;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEventAttendees;
    private javax.swing.JTextField txtAttMail;
    private javax.swing.JTextField txtAttName;
    private javax.swing.JTextField txtAttPhone;
    // End of variables declaration//GEN-END:variables


public void sendemail(String filepath, String email) {
       String host = "smtp.gmail.com";
        String port = "587";
        String mailFrom = "eventura.usa@gmail.com";
        String password = "eventura@123";
 
        // message info
        String mailTo = email;
        String subject = "New email with attachments";
        String message = "Eventura invites you!";
 
        // attachments
        String[] attachFiles = new String[1];
        attachFiles[0] = filepath;
//        attachFiles[1] = "e:/Test/Music.mp3";
//        attachFiles[2] = "e:/Test/Video.mp4";
 
        try {
            sendEmailWithAttachments(host, port, mailFrom, password, mailTo,
                subject, message, attachFiles);
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Could not send email.");
            ex.printStackTrace();
        }
    }
    
    public void sendEmailWithAttachments (String host, String port,
            final String userName, final String password, String toAddress,
            String subject, String message, String[] attachFiles) throws AddressException, MessagingException{
        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.user", userName);
        properties.put("mail.password", password);
 
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
        Session session = Session.getInstance(properties, auth);
 
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
 
        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
 
        // creates message part
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(message, "text/html");
 
        // creates multi-part
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
 
        // adds attachments
        if (attachFiles != null && attachFiles.length > 0) {
            for (String filePath : attachFiles) {
                MimeBodyPart attachPart = new MimeBodyPart();
 
                try {
                    attachPart.attachFile(filePath);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
 
                multipart.addBodyPart(attachPart);
            }
        }
 
        // sets the multi-part as e-mail's content
        msg.setContent(multipart);
 
        // sends the e-mail
        Transport.send(msg);
    }
}