/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.GovtAdmin;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author kartik
 */
public class GovtEnterprise extends Enterprise {

    public GovtEnterprise(String name) {
        super(name, EnterpriseType.Government);
    }

    @Override

    public ArrayList<Role> getSupportedRole() {
        roles = new ArrayList<Role>();
        roles.add(new GovtAdmin());
        return roles;
    }
}
