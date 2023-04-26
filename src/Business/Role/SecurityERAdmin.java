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
import userinterface.EnterAdminRole.GeoInfraAdminWorkAreaJPanel;
import userinterface.EnterAdminRole.SecurityERAdminWorkAreaJPanel;

/**
 *
 * @author Nithin
 */
public class SecurityERAdmin extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem business) {
        return new SecurityERAdminWorkAreaJPanel(userProcessContainer, account, organization, enterprise, network, business);
    }

}
