/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkRequest;
import java.util.Date;
/**
 *
 * @author kartik
 */
public class HostSecurityERWorkRequest extends WorkRequest {
   
    private String requestID;
    private String eventName;
    private String evenCat;
    private int attendance;
    private Date plannedDate;
    private UserAccount host;
    private UserAccount location;
    private String locNote;
    private UserAccount infra;
    private String infraNote;
    private UserAccount music;
    private String musicNote;
    private UserAccount food;
    private String foodNote;
    private UserAccount drinks;
    private String drinksNote;
    private Network network;
    private Enterprise enterprise;
    private Organization.Type orgType;
    
    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Organization.Type getOrgType() {
        return orgType;
    }

    public void setOrgType(Organization.Type orgType) {
        this.orgType = orgType;
    }


    public String getLocNote() {
        return locNote;
    }

    public void setLocNote(String locNote) {
        this.locNote = locNote;
    }

    public String getInfraNote() {
        return infraNote;
    }

    public void setInfraNote(String infraNote) {
        this.infraNote = infraNote;
    }

    public String getMusicNote() {
        return musicNote;
    }

    public void setMusicNote(String musicNote) {
        this.musicNote = musicNote;
    }

    public String getFoodNote() {
        return foodNote;
    }

    public void setFoodNote(String foodNote) {
        this.foodNote = foodNote;
    }

    public String getDrinksNote() {
        return drinksNote;
    }

    public void setDrinksNote(String drinksNote) {
        this.drinksNote = drinksNote;
    }
    
    public UserAccount getHost() {
        return host;
    }

    public void setHost(UserAccount host) {
        this.host = host;
    }

    public UserAccount getLocation() {
        return location;
    }

    public void setLocation(UserAccount location) {
        this.location = location;
    }

    public UserAccount getInfra() {
        return infra;
    }

    public void setInfra(UserAccount infra) {
        this.infra = infra;
    }

    public UserAccount getMusic() {
        return music;
    }

    public void setMusic(UserAccount music) {
        this.music = music;
    }

    public UserAccount getFood() {
        return food;
    }

    public void setFood(UserAccount food) {
        this.food = food;
    }

    public UserAccount getDrinks() {
        return drinks;
    }

    public void setDrinks(UserAccount drinks) {
        this.drinks = drinks;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEvenCat() {
        return evenCat;
    }

    public void setEvenCat(String evenCat) {
        this.evenCat = evenCat;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public Date getPlannedDate() {
        return plannedDate;
    }

    public void setPlannedDate(Date plannedDate) {
        this.plannedDate = plannedDate;
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID() {
       int randomNum = (int) (Math.random() * (100 - 500 + 1) + 100);
        this.requestID = "Request " + randomNum;
    }
    
}
