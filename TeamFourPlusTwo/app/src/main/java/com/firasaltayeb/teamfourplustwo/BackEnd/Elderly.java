package com.firasaltayeb.teamfourplustwo.BackEnd;

import java.util.ArrayList;

/**
 * Created by firasAltayeb on 04/12/2015.
 */
public class Elderly {
    private String name;
    private int age;
    private String gender;
    private String interest;
    private ArrayList<String> blackList;

    public Elderly(String name,String gender,int age){
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
