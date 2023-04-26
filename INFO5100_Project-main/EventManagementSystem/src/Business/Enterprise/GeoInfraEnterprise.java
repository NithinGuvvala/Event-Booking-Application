/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;
import Business.Role.LocationRole;
import Business.Role.InfraRole;
/**
 *
 * @author kartik
 */
public class GeoInfraEnterprise extends Enterprise {

    public GeoInfraEnterprise(String name) {
        super(name, EnterpriseType.GeoInfra);
    }

    @Override

    public ArrayList<Role> getSupportedRole() {
        roles = new ArrayList<Role>();
        roles.add(new LocationRole());
        roles.add(new InfraRole());
        return roles;
    }

}
