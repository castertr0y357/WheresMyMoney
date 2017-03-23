package com.example.jfort.wheresmymoney;

import android.graphics.Picture;
import java.util.Calendar;

/**
 * Created by Jimmy on 3/21/2017.
 * This class will handle all of the loan objects and allow for ease of coding updates.
 */

public class Loan {
    private int id;
    private double amount;
    private String name;
    private Calendar dateAdded;
    private Calendar payoffDate;
    private Picture contactPicture;
    private Picture descriptionPicture;
    private String description;
    private String contactNumber;
    private boolean iOwe;

    //Full information provided
    Loan(int id, double amount, String name, Calendar payoffDate, Picture contactPicture, String description, Picture descriptionPicture, String contactNumber, boolean iOwe){
        this.id = id;
        this.amount = amount;
        this.name = name;
        this.payoffDate = payoffDate;
        this.contactPicture = contactPicture;
        this.description = description;
        this.descriptionPicture = descriptionPicture;
        this.contactNumber = contactNumber;
        this.iOwe = iOwe;
        this.dateAdded = Calendar.getInstance();
    }

    //Bare minimum provided
    Loan(int id, double amount, String name, Calendar payoffDate, boolean iOwe){
        this.id = id;
        this.amount = amount;
        this.name = name;
        this.payoffDate = payoffDate;
        this.iOwe = iOwe;
        this.dateAdded = Calendar.getInstance();
    }

    Loan(int id, double amount, String name, Calendar payoffDate, String description, boolean iOwe){
        this.id = id;
        this.amount = amount;
        this.name = name;
        this.payoffDate = payoffDate;
        this.description = description;
        this.iOwe = iOwe;
        this.dateAdded = Calendar.getInstance();
    }

    Loan(int id, double amount, String name, Calendar payoffDate, String description, Picture descriptionPicture, boolean iOwe){
        this.id = id;
        this.amount = amount;
        this.name = name;
        this.payoffDate = payoffDate;
        this.description = description;
        this.descriptionPicture = descriptionPicture;
        this.iOwe = iOwe;
        this.dateAdded = Calendar.getInstance();
    }

    Loan(int id, double amount, String name, Calendar payoffDate, Picture contactPicture, String contactNumber, boolean iOwe){
        this.id = id;
        this.amount = amount;
        this.name = name;
        this.payoffDate = payoffDate;
        this.contactPicture = contactPicture;
        this.contactNumber = contactNumber;
        this.iOwe = iOwe;
        this.dateAdded = Calendar.getInstance();
    }

    int getId(){
        return id;
    }

    double getAmount(){
        return amount;
    }

    void setAmount(Double amount){
        this.amount = amount;
    }

    String getName(){
        return name;
    }

    void setName(String name){
        this.name = name;
    }

    Calendar getDateAdded(){
        return dateAdded;
    }

    Calendar getPayoffDate(){
        return payoffDate;
    }

    void setPayoffDate(Calendar date){
        payoffDate = date;
    }

    Picture getContactPicture(){
        return contactPicture;
    }

    void setContactPicture(Picture picture){
        contactPicture = picture;
    }

    Picture getDescriptionPicture(){
        return descriptionPicture;
    }

    void setDescriptionPicture(Picture picture){
        descriptionPicture = picture;
    }

    String getDescription(){
        return description;
    }

    void setDescription(String description){
        this.description = description;
    }

    String getContactNumber(){
        return contactNumber;
    }

    void setContactNumber(String number){
        contactNumber = number;
    }

    boolean getIOwe(){
        return iOwe;
    }

    void setiOwe(boolean iOwe){
        this.iOwe = iOwe;
    }
}
