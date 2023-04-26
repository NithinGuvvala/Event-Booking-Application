/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Host;

import Business.EcoSystem;
import java.util.ArrayList;

/**
 *
 * @author ruchika
 */
public class HostDirectory {
    private ArrayList<Host> hostDir;
    
    public HostDirectory(){
        hostDir = new ArrayList<Host>();
    }

    public ArrayList<Host> getHostDir() {
        return hostDir;
    }

    public void setHostDir(ArrayList<Host> hostDir) {
        this.hostDir = hostDir;
    }

    public void addHost(Host host){
        hostDir.add(host);
    }
    
    public Host getHostId(int index){
        return hostDir.get(index);
    }
    
    public String genHostID(){
        return "Host "+(hostDir.size()+1);
    }
    
     public Host getHost(String id){
        for(Host host: hostDir){
            if(host.getHostID().equalsIgnoreCase(id)){
                return host;
            }
        }
        return null;
    }
    
        public boolean isContactNoUnique(String contactNo){
        for(Host host : hostDir){
            if(host.getHostContact().equalsIgnoreCase(contactNo)){
                return false;
            }
        }
        return true;
    }
    
    public boolean isEmailUnique(String email){
        for(Host host : hostDir){
            if(host.getHostEmail().equalsIgnoreCase(email)){
                return false;
            }
        }
        return true;
    }
    
    public void deleteHost(int index,EcoSystem system){
        String id = hostDir.get(index).getHostID();
        for(int i =0; i <system.getUserAccountDirectory().getUserAccountList().size();i++){
            if(system.getUserAccountDirectory().getUserAccountList().get(i)
                    .getEmployee().getName().equalsIgnoreCase(id)){
                system.getUserAccountDirectory().getUserAccountList().remove(i);
            } else System.out.println("Host does not Exist!");
        }
        hostDir.remove(index);
    }
    
    public void updateHost(String hostNo, String hostName, String hostContact, String hostAddr,String hostZipCode,String hostEmail){
        for(Host host: hostDir){
            if(host.getHostID().equalsIgnoreCase(hostNo)){
                
                host.setHostName(hostName);
                host.setHostEmail(hostEmail);
                host.setHostContact(hostContact);
                host.setHostAddr(hostAddr);
                host.setHostZipCode(hostZipCode); 
                break;
            }
        }
    }
}
