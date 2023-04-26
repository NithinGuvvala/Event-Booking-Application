/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

import Business.Role.MusicianRole;
import Business.Role.PhotographerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author kartik
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
