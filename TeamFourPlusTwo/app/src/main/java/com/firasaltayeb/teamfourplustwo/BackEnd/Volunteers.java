package com.firasaltayeb.teamfourplustwo.BackEnd;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by firasAltayeb on 05/12/2015.
 */
public class Volunteers {

    static boolean contains;
    static public ArrayList<Volunteer> VolunteersArray = new ArrayList<>();

    static public void AddVolunteers(Volunteer volunteer){
        isVolunteersExist(volunteer);
        if(!contains) {
            VolunteersArray.add(volunteer);
        }
        Log.d("number of Volunteers", VolunteersArray.size() + "");
    }

    public static void isVolunteersExist(Volunteer volunteer){
        for(Volunteer volunteerliesItem : VolunteersArray) {
            if (volunteerliesItem.getFirstName().equals(volunteer.getFirstName()) &&
                    volunteerliesItem.getLastName().equals(volunteer.getLastName())) {
                contains = true;
                break;
            }
            else {
                contains = false;
            }
        }
    }

}