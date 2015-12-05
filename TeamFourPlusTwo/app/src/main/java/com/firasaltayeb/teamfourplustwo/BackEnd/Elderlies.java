package com.firasaltayeb.teamfourplustwo.BackEnd;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by firasAltayeb on 05/12/2015.
 */
public class Elderlies {

    static public ArrayList<Elderly> ElderliesArray = new ArrayList<>();

    static public void AddElderlies(Elderly elderly){
        ElderliesArray.add(elderly);
        Log.d("number of elderlies",ElderliesArray.size() + "");
    }
}
