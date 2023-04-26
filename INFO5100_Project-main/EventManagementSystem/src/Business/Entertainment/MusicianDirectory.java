/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Entertainment;

import Business.EcoSystem;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author ruchika
 */
public class MusicianDirectory {
    private ArrayList<Musician> musicianDirectory;
    
    public MusicianDirectory() throws IOException{
        musicianDirectory = new ArrayList<Musician>();
        
    }

    public ArrayList<Musician> getMusicianDirectory() {
        return musicianDirectory;
    }

    public void setMusicianDirectory(ArrayList<Musician> MusicianDirectory) {
        this.musicianDirectory = MusicianDirectory;
    }

    public MusicianDirectory(ArrayList<Musician> MusicianDirectory) {
        this.musicianDirectory = MusicianDirectory;
    }
    
    public void add(Musician musician) {
       musician.setMusicianno("Band_"+(musicianDirectory.size()+1));
       musicianDirectory.add(musician);
    }
    
    public void deleteRestaurant(int index,EcoSystem system){
        String id = musicianDirectory.get(index).getMusicianno();
        for(int i =0; i <system.getUserAccountDirectory().getUserAccountList().size();i++){
            if(system.getUserAccountDirectory().getUserAccountList().get(i).getEmployee().getName().equalsIgnoreCase(id)){
                system.getUserAccountDirectory().getUserAccountList().remove(i);
            }
        }
        musicianDirectory.remove(index);
    }
    
    public Musician setmusicianNo(int index){
        return musicianDirectory.get(index);
    }

    public String getRestName(String restaurantId) {
        for(Musician musician: musicianDirectory){
            if(musician.getMusicianno().equalsIgnoreCase(restaurantId)){
                return musician.getMusicPlan();
            }
        }
        return "";
    }
    
    public Musician getMusician(String id){
        for(Musician restaurant: musicianDirectory){
            if(restaurant.getMusicianno().equalsIgnoreCase(id)){
                return restaurant;
            }
        }
        return null;
    }
}
