/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import Business.Role.SecurityERRole;
import java.util.ArrayList;

/**
 *
 * @author kartik
 */
public class SecurityEREnterprise extends Enterprise {

    public SecurityEREnterprise(String name) {
        super(name, EnterpriseType.SecurityER);
    }

    @Override

    public ArrayList<Role> getSupportedRole() {
        roles = new ArrayList<Role>();
        roles.add(new SecurityERRole());
        return roles;
    }

}
