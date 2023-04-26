/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Host.Attendees;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;
import java.awt.Image;

/**
 *
 * @author nithin
 */
public class UserAccount {
    
    private String username;
    private String password;
    private String name;
    private String status;
    public Employee employee;
    private Role role;
    private WorkQueue workQueue;
    private String Phone;
    private String Street;
    private String Zipcode;
    private String Email;
    private String City;
    private String State;
    private Enterprise userEnterpriseList;
    private Organization userOrganizationList;
    private Image userPhoto;
    private Image package1Photo;
    private Image package2Photo;
    private String drinkitem1;
    private String drinkitem2;
    private String drinkitem3;
    private String fooditem1;
    private String fooditem2;
    private String fooditem3;
    private double drinkprice;
    private double foodprice;
    private String message;
    private String approvermesg;
    private String spec1;
    private String spec2;
    private String spec3;
    private String hostName;

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }
    private Attendees attendees;

    public Attendees getAttendees() {
        return attendees;
    }

    public void setAttendees(Attendees attendees) {
        this.attendees = attendees;
    }

    public String getApprovermesg() {
        return approvermesg;
    }

    public void setApprovermesg(String approvermesg) {
        this.approvermesg = approvermesg;
    }

    
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSpec1() {
        return spec1;
    }

    public void setSpec1(String spec1) {
        this.spec1 = spec1;
    }

    public String getSpec2() {
        return spec2;
    }

    public void setSpec2(String spec2) {
        this.spec2 = spec2;
    }

    public String getSpec3() {
        return spec3;
    }

    public void setSpec3(String spec3) {
        this.spec3 = spec3;
    }
   

    public String getDrinkitem1() {
        return drinkitem1;
    }

    public void setDrinkitem1(String drinkitem1) {
        this.drinkitem1 = drinkitem1;
    }

    public String getDrinkitem2() {
        return drinkitem2;
    }

    public void setDrinkitem2(String drinkitem2) {
        this.drinkitem2 = drinkitem2;
    }

    public String getDrinkitem3() {
        return drinkitem3;
    }

    public void setDrinkitem3(String drinkitem3) {
        this.drinkitem3 = drinkitem3;
    }

    public String getFooditem1() {
        return fooditem1;
    }

    public void setFooditem1(String fooditem1) {
        this.fooditem1 = fooditem1;
    }

    public String getFooditem2() {
        return fooditem2;
    }

    public void setFooditem2(String fooditem2) {
        this.fooditem2 = fooditem2;
    }

    public String getFooditem3() {
        return fooditem3;
    }

    public void setFooditem3(String fooditem3) {
        this.fooditem3 = fooditem3;
    }

    public double getDrinkprice() {
        return drinkprice;
    }

    public void setDrinkprice(double drinkprice) {
        this.drinkprice = drinkprice;
    }

    public double getFoodprice() {
        return foodprice;
    }

    public void setFoodprice(double foodprice) {
        this.foodprice = foodprice;
    }  
    
    public Image getPackage1Photo() {
        return package1Photo;
    }

    public void setPackage1Photo(Image package1Photo) {
        this.package1Photo = package1Photo;
    }

    public Image getPackage2Photo() {
        return package2Photo;
    }

    public void setPackage2Photo(Image package2Photo) {
        this.package2Photo = package2Photo;
    }
    
    
    
    public Image getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(Image userPhoto) {
        this.userPhoto = userPhoto;
    }
    public UserAccount() {
        workQueue = new WorkQueue();
        attendees = new Attendees();
    }
    
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public Enterprise getUserEnterpriseList() {
        return userEnterpriseList;
    }

    public void setUserEnterpriseList(Enterprise userEnterpriseList) {
        this.userEnterpriseList = userEnterpriseList;
    }

    public Organization getUserOrganizationList() {
        return userOrganizationList;
    }

    public void setUserOrganizationList(Organization userOrganizationList) {
        this.userOrganizationList = userOrganizationList;
    }

    @Override
    public String toString() {
        return name;
    }

    public Object getUserAccountDirectory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public String getZipcode() {
        return Zipcode;
    }

    public void setZipcode(String Zipcode) {
        this.Zipcode = Zipcode;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }
}
