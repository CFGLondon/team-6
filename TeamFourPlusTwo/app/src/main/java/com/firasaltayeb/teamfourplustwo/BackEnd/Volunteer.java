package com.firasaltayeb.teamfourplustwo.BackEnd;

import java.util.ArrayList;

/**
 * Created by firasAltayeb on 04/12/2015.
 */

public class Volunteer {
    private String name;
    private String interest;
    private int age;
    private ArrayList<String> blackList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<String> getBlackList() {
        return blackList;
    }

    public void setBlackList(ArrayList<String> blackList) {
        this.blackList = blackList;
    }
}
