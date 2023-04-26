/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.EnterpriseDirectory;

/**
 *
 * @author Ruchika
 */
public class Network {

    private String name;
    private String code;
    private String imgPath;

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    private String igLimit;

    public String getIgLimit() {
        return igLimit;
    }

    public void setIgLimit(String igLimit) {
        this.igLimit = igLimit;
    }

    public String getOgLimit() {
        return ogLimit;
    }

    public void setOgLimit(String ogLimit) {
        this.ogLimit = ogLimit;
    }
    private String ogLimit;
    private String maskMandatory;

    public String getMaskMandatory() {
        return maskMandatory;
    }

    public void setMaskMandatory(String maskMandatory) {
        this.maskMandatory = maskMandatory;
    }
    private final EnterpriseDirectory enterpriseDirectory;

    public Network() {
        enterpriseDirectory = new EnterpriseDirectory();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    @Override
    public String toString() {
        return name;
    }

}
