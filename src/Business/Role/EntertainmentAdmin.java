/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.EnterAdminRole.EntertainAdminWorkAreaJPanel;

import userinterface.EnterAdminRole.GeoInfraAdminWorkAreaJPanel;


/**
 *
 * @author Nithin
 */
public class EntertainmentAdmin extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise,Network network, EcoSystem business) {
        return new EntertainAdminWorkAreaJPanel(userProcessContainer, account,organization, enterprise, network, business);
    }
 
    
}
