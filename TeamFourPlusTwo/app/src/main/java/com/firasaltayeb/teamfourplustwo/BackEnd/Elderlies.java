package com.firasaltayeb.teamfourplustwo.BackEnd;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by firasAltayeb on 05/12/2015.
 */
public class Elderlies {

    static boolean contains;
    static public ArrayList<Elderly> ElderliesArray = new ArrayList<>();

    static public void AddElderlies(Elderly elderly){
        iselderExist(elderly);
        if(!contains) {
            ElderliesArray.add(elderly);
        }
        Log.d("number of elderlies",ElderliesArray.size() + "");
    }

    public static void iselderExist(Elderly elderly){
        for(Elderly elderliesItem : ElderliesArray) {
            if (elderliesItem.getName().equals(elderly.getName()) && elderliesItem.getGender().equals(elderly.getGender())
                    && elderliesItem.getAge() == elderly.getAge()) {
                contains = true;
                break;
            }
            else {
                contains = false;
            }
        }
    }

}
