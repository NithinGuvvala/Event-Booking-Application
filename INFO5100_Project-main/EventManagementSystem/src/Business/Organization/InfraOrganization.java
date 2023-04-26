/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;



import Business.Role.InfraRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author kartik
 */
public class InfraOrganization extends Organization{

    public InfraOrganization(String name) {
        super(name);
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new InfraRole());
        return roles;
    }
       @Override
    public Organization.Type getType() {
        return Organization.Type.Infrastructure;
    } 
     
}