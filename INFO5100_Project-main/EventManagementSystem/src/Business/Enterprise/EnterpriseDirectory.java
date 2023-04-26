/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author kartik
 */
public class EnterpriseDirectory {

    private ArrayList<Enterprise> enterpriseList;

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }

    public EnterpriseDirectory() {
        enterpriseList = new ArrayList<Enterprise>();
    }

    //Create enterprise
    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type) {
        Enterprise enterprise = null;
        if (null != type) {
            switch (type) {
                case GeoInfra:
                    enterprise = new GeoInfraEnterprise(name);
                    enterpriseList.add(enterprise);
                    break;
                case Catering:
                    enterprise = new CateringEnterprise(name);
                    enterpriseList.add(enterprise);
                    break;
                case Entertainment:
                    enterprise = new EntertainmentEnterprise(name);
                    enterpriseList.add(enterprise);
                    break;
                case SecurityER:
                    enterprise = new SecurityEREnterprise(name);
                    enterpriseList.add(enterprise);
                    break;
                case Government:
                    enterprise = new GovtEnterprise(name);
                    enterpriseList.add(enterprise);
                    break;     
                default:
                    break;
            }
        }
        return enterprise;
    }
}
