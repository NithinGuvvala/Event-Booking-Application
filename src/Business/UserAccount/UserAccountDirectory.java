/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author nithin
 */
public class UserAccountDirectory {
    
    private ArrayList<UserAccount> userAccountList;

    public UserAccountDirectory() {
        userAccountList = new ArrayList();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
    
    public UserAccount authenticateUser(String username, String password) {
        for (UserAccount ua : userAccountList) {
            if (ua.getUsername().toLowerCase().equals(username.toLowerCase()) && ua.getPassword().equals(password)) {
                return ua;
            }
        }
        return null;
    }
    
    public UserAccount createUserAccount(String username, String password, Employee employee, Role role){
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setEmployee(employee);
        userAccount.setRole(role);
        userAccount.setName(employee.getName());
        userAccount.setStatus("Available");
        userAccountList.add(userAccount);
        return userAccount;
    }

    public boolean checkIfUsernameIsUnique(String username) {
        for (UserAccount ua : userAccountList) {
            if (ua.getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }

    public UserAccount searchUser(String userName) {
        for (UserAccount ua : userAccountList) {
            if (ua.getUsername().equals(userName)) {
                return ua;
            }
        }
        return null;
    }

    public void updateItem(String userName, String fullName, String userEmail) {
        for (UserAccount ua : userAccountList) {
            if (ua.getUsername().equalsIgnoreCase(userName)) {
                ua.setName(fullName);
                ua.setEmail(userEmail);
            }
        }
    }

    public boolean checkIfnameIsUnique(String username) {
        for (UserAccount ua : userAccountList) {
            if (ua.getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkIfPhoneIsUnique(String phone) {
        for (UserAccount ua : userAccountList) {
            if (ua.getPhone() != null) {
                if (ua.getPhone().equals(phone)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkIfEmailIsUnique(String email) {
        for (UserAccount ua : userAccountList) {
            if (ua.getEmail() != null) {
                if (ua.getEmail().equals(email)) {
                    return false;
                }
            }
        }
        return true;
    }

}
