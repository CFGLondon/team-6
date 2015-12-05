package com.firasaltayeb.teamfourplustwo.BackEnd;

import java.util.ArrayList;

/**
 * Created by firasAltayeb on 04/12/2015.
 */
public class Volunteer {
    private String firstName;
    private String lastName;
    private int age;
    private String interest;
    private String gender;
    private String address;
    private String blackList;
    private String whiteList;


    public Volunteer(String firstName,String lastName,String gender,int age,String interest,String address, String blackList, String whiteList){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.interest = interest;
        this.address = address;
        this.blackList = blackList;
        this.whiteList = whiteList;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getBlackList() {
        return blackList;
    }

    public void setBlackList(String blackList) {
        this.blackList = blackList;
    }

    public String getWhiteList() {
        return whiteList;
    }

    public void setWhiteList(String whiteList) {
        this.whiteList = whiteList;
    }
}
