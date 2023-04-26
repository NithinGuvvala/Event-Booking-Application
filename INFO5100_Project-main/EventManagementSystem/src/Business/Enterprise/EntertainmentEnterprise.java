/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.MusicianRole;
import Business.Role.PhotographerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Saivignesh Sridhar
 */
public class EntertainmentEnterprise extends Enterprise {

    public EntertainmentEnterprise(String name) {
        super(name, EnterpriseType.Entertainment);
    }

    @Override

    public ArrayList<Role> getSupportedRole() {
        roles = new ArrayList<Role>();
        roles.add(new PhotographerRole());
        roles.add(new MusicianRole());
        return roles;
    }
}
