/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Enterprise.SecurityEREnterprise;
import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author kartik
 */
public class OrganizationDirectory {

    private final ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public Organization createOrganization(Type type, String name) {
        Organization organization = null;
        if (type.getValue().equals(Type.Host.getValue())) {
            organization = new HostOrganization(name);
            organizationList.add(organization);
           
        } else if (type.getValue().equals(Type.Location.getValue())) {
            organization = new LocationOrganization(name);
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.Infrastructure.getValue())) {
            organization = new InfraOrganization(name);
            organizationList.add(organization);
        }  
          else if (type.getValue().equals(Type.GovtAuth.getValue())) {
            organization = new AuthOrganization(name);
            organizationList.add(organization);          
        } else if (type.getValue().equals(Type.Food.getValue())) {
            organization = new FoodOrganization(name);
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.Beverages.getValue())) {
            organization = new BeveragesOrganization(name);
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.Delivery.getValue())) {
            organization = new DeliveryOrganization(name);
            organizationList.add(organization);

        }    
        else if (type.getValue().equals(Type.Musician.getValue())) {

            organization = new MusicianOrganization(name);
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.Photographer.getValue())) {
            organization = new PhotographerOrganization(name);
            organizationList.add(organization);

        } else if (type.getValue().equals(Type.SecurityER.getValue())) {
            organization = new SecurityEROrganization(name);
            organizationList.add(organization);
}
      

        return organization;
    }
}
