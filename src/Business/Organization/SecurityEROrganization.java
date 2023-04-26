/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.BeveragesRole;
import Business.Role.Role;
import Business.Role.SecurityERRole;
import java.util.ArrayList;

/**
 *
 * @author kartik
 */
public class SecurityEROrganization extends Organization {
    public SecurityEROrganization(String name) {
        super(name);
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new SecurityERRole());
        return roles;
    }
       @Override
    public Organization.Type getType() {
        return Organization.Type.SecurityER;
    }
    
    
}
