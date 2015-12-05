package com.firasaltayeb.teamfourplustwo.BackEnd;

import java.util.ArrayList;

/**
 * Created by firasAltayeb on 04/12/2015.
 */

public class Volunteer {
    private String name;
    private int age;
    private String interest;
    private String gender;
    private String address;
    private ArrayList<String> blackList = new ArrayList<String>();
    private ArrayList<String> whiteList = new ArrayList<String>();


    public Volunteer(String name,String gender,int age){
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}