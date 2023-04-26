/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;


import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseDirectory;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.Entertainment.MusicianDirectory;
import java.util.ArrayList;
import Business.UserAccount.UserAccount;
import java.awt.Color;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author kartik
 */
public class EcoSystem extends Organization{
    
    private static EcoSystem business;
    private EnterpriseDirectory enterpriseDirectory;
    private OrganizationDirectory organizationDirectory;
    private MusicianDirectory musicianDirectory;
   

    private ArrayList<Network> networkList;

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public void setOrganizationDirectory(OrganizationDirectory organizationDirectory) {
        this.organizationDirectory = organizationDirectory;
    }

    public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }

    public static void setInstance(EcoSystem system) {
        business = system;
    }

    public Network createAndAddNetwork() {
        Network network = new Network();
        networkList.add(network);
        return network;
    }
    
    

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<Role>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }

    private EcoSystem() {
        super(null);
        networkList = new ArrayList<Network>();
        enterpriseDirectory = new EnterpriseDirectory();
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public void setEnterpriseDirectory(EnterpriseDirectory enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }
    
    public MusicianDirectory getmusicianDirectory() {
        return musicianDirectory;
    }

    public Network fetchNetwork(String networkCode) {
        for (Network n : business.getNetworkList()) {
            if (n.getCode().toLowerCase().equals(networkCode.toLowerCase())) {
                System.out.println("Found network");
              return n;
            }
        }
        return null;
    }
    
public void DeleteNetwork(String networkCode, int index) {
    try{
          for (Network n : business.getNetworkList()) {
             if (n.getName().toLowerCase().equals(networkCode.toLowerCase())) {
                networkList.remove(index);
            } 
        }
    }catch(Exception e){
    System.out.println("Network does not Exist!");
    }
    }
    
    public boolean checkIfNetworkIsUnique(String netCode) {
        for (Network n : business.getNetworkList()) {
            if (n.getCode().toLowerCase().equals(netCode.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    public boolean checkIfEnterpriseIsUnique(String entName) {
        for (Network n : business.getNetworkList()) {
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                if (e.getName().toLowerCase().equals(entName.toLowerCase())) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkIfUserIsUnique(String userName) {
        boolean flag = true;
        for (Network n : business.getNetworkList()) {
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                for (UserAccount u : e.getUserAccountDirectory().getUserAccountList()) {
                    if (u.getUsername().toLowerCase().equals(userName.toLowerCase())) {
                        flag = false;
                    }
                }
                for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
                    for (UserAccount u : o.getUserAccountDirectory().getUserAccountList()) {
                        if (u.getUsername().toLowerCase().equals(userName.toLowerCase())) {
                            flag = false;
                        }
                    }
                }
            }
        }
        if ("admin".equals(userName.toLowerCase())) {
            flag = false;
        }
        if (!flag) {
            JOptionPane.showMessageDialog(null, "" + userName + " already exists! Please try a different Username.", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    public boolean checkIfPhoneIsUnique(String phone, String username) {
        for (Network n : business.getNetworkList()) {
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
                    for (UserAccount u : o.getUserAccountDirectory().getUserAccountList()) {
                        if (u.getPhone() != null) {
                            if (u.getPhone().equals(phone) && !u.getUsername().equals(username)) {
                                JOptionPane.showMessageDialog(null, "This contact number is already mapped to a User!", "Error!", JOptionPane.ERROR_MESSAGE);
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }


    public boolean checkIfEmailIsUnique(String email, String username) {
        for (Network n : business.getNetworkList()) {
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
                    for (UserAccount u : o.getUserAccountDirectory().getUserAccountList()) {
                        if (u.getEmail() != null) {
                            if (u.getEmail().toLowerCase().equals(email.toLowerCase()) && !u.getUsername().equals(username)) {
                                JOptionPane.showMessageDialog(null, "This Email ID is already mapped to a User!", "Error!", JOptionPane.ERROR_MESSAGE);
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public Boolean validateMobileNo(String phoneNo) {
        Pattern pattern;
        Matcher matcher;
        String PHONE_PATTERN = "^[0-9]{10}$";
        pattern = Pattern.compile(PHONE_PATTERN);
        matcher = pattern.matcher(phoneNo);
        if (matcher.matches()) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Phone Format! Sample: 9253365683", "Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public Boolean validateEmailID(String email) {
        Pattern pattern;
        Matcher matcher;
        String EMAIL_PATTERN
                = "^[\\w!#$%&�*+/=?`{|}~^-]+(?:\\.[\\w!#$%&�*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        if (matcher.matches()) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Email ID Format! Sample: abc@xyz.com", "Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public Boolean validatePassword(String password) {
        Pattern p1;
        p1 = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()�[{}]:;',?/*~$^+=<>]).{6,15}$");
        Matcher m1 = p1.matcher(password);
        boolean b1 = m1.matches();
        if (!b1) {
            JOptionPane.showMessageDialog(null, "Password does not match the Criteria! \n Criteria: \nPassword must contain at least one digit -> [0-9].\n"
                    + "Password must contain at least one lowercase character -> [a-z].\n"
                    + "Password must contain at least one UPPERCASE character -> [A-Z].\n"
                    + "Password must contain at least one Special character such as ! @ # & ( ).\n"
                    + "Password must contain a length of at least 6 characters and a maximum of 15 characters.", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    public boolean isDouble(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public boolean isInt(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public boolean isNull(String strNum) {
        if (strNum.trim().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
