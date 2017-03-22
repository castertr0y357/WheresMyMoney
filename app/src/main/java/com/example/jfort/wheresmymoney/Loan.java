package com.example.jfort.wheresmymoney;

import android.graphics.Picture;

import android.provider.ContactsContract;

import java.util.Calendar;

/**
 * Created by Jimmy on 3/21/2017.
 * This class will handle all of the loan objects and allow for ease of coding updates.
 */

public class Loan {
    int id;
    double amount;
    String name;
    Calendar dateAdded;
    Calendar payoffDate;
    Picture contactPicture;
    Picture descriptionPicture;
    String description;
    String contactNumber;
    boolean iOwe;

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
}
