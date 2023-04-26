/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.DeliveryRole;
import Business.Role.BeveragesRole;
import Business.Role.Role;
import Business.Role.FoodRole;
import java.util.ArrayList;

/**
 *
 * @author kartik
 */
public class CateringEnterprise extends Enterprise {

    public CateringEnterprise(String name) {
        super(name, EnterpriseType.Catering);
    }

    @Override

    public ArrayList<Role> getSupportedRole() {
        roles = new ArrayList<Role>();
        roles.add(new DeliveryRole());
        roles.add(new BeveragesRole());
        roles.add(new FoodRole());
        return roles;
    }

}
