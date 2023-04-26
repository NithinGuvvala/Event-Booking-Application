/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Host;

import java.awt.Image;

/**
 *
 * @author ruchika
 */
public class Host {
    private String hostID;
    private String hostName;
    private String hostContact;
    private String hostEmail;
    private String hostAddr;
    private String hostZipCode;
    private Image hostPhoto;

    public String getHostID() {
        return hostID;
    }

    public void setHostID(String hostID) {
        this.hostID = hostID;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getHostContact() {
        return hostContact;
    }

    public void setHostContact(String hostContact) {
        this.hostContact = hostContact;
    }

    public String getHostEmail() {
        return hostEmail;
    }

    public void setHostEmail(String hostEmail) {
        this.hostEmail = hostEmail;
    }

    public String getHostAddr() {
        return hostAddr;
    }

    public void setHostAddr(String hostAddr) {
        this.hostAddr = hostAddr;
    }

    public String getHostZipCode() {
        return hostZipCode;
    }

    public void setHostZipCode(String hostZipCode) {
        this.hostZipCode = hostZipCode;
    }

    public Image getHostPhoto() {
        return hostPhoto;
    }

    public void setHostPhoto(Image hostPhoto) {
        this.hostPhoto = hostPhoto;
    }

    
}
