/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Host;

import Business.WorkQueue.*;
import java.util.ArrayList;

/**
 *
 * @author Nithin
 */
public class Attendees {
    
    private ArrayList<Attendant> attendeeList;

    public Attendees() {
        attendeeList = new ArrayList();
    }

    public ArrayList<Attendant> getAttendeeList() {
        return attendeeList;
    }
}