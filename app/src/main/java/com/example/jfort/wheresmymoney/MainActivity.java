package com.example.jfort.wheresmymoney;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.text.DecimalFormat;
import java.util.Calendar;

//import android.icu.text.DecimalFormat;

public class MainActivity extends Activity implements View.OnClickListener{

    //Declaration of all the different variables, objects, and processes to use goes here
    //Variables
    int contactCounter;
    String contactCounterString;
    String contactNameString;
    String moneyPurposeString;
    double amount;
    int month;
    int day;
    int year;
    String date;
    String dateAdded;


    //Objects
    Button iOweSomeoneButton;
    Button someoneOwesMeButton;
    ImageButton settingsButton;


    //Shared Preferences
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    String dataName = "WheresMyMoney";

    //Formatting
    DecimalFormat twoDec = new DecimalFormat("0.00");

    //Context
    final Context context = this;

    //Screen setting
    Display display;
    Point size;

    //Views
    LayoutInflater li;

    //Alert Dialogs
    AlertDialog alertDialog;
    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

    //App starts running here with onCreate process, and begins to execute
    //everything specified in here
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Variable initialization

        //Object initialization
        iOweSomeoneButton = (Button)findViewById(R.id.iOweSomeoneButton);
        iOweSomeoneButton.setOnClickListener(this);
        someoneOwesMeButton = (Button)findViewById(R.id.someoneOwesMeButton);
        someoneOwesMeButton.setOnClickListener(this);
        settingsButton = (ImageButton)findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(this);

        //Shared Preferences initialization
        prefs = getSharedPreferences(dataName, Context.MODE_PRIVATE);
        editor = prefs.edit();

        //Set date
        Calendar instant = Calendar.getInstance();
        month = instant.get(Calendar.MONTH) + 1;
        Log.i("info", "Month is " + month);
        day = instant.get(Calendar.DAY_OF_MONTH);
        Log.i("info", "Day is " + day);
        year = instant.get(Calendar.YEAR);
        Log.i("info", "Year is " + year);
        date = "" + month + "/" + day + "/" + year;
        Log.i("info", "Date is " + date);

        //Display
        display = getWindowManager().getDefaultDisplay();
        size = new Point();

        //Views
        li = LayoutInflater.from(context);

    }//End of onCreate

    //onPause describes what happens when the App loses focus and moves to the background.
    //It's good to write code to help save any work that was done to SharedPreferences
    //so that it doesn't get lost when the memory gets cleared out
    @Override
    public void onPause(){

        super.onPause();
    }//End of onPause

    //onResume handles what happens when the App gains focus again after being paused
    //This code does not get executed if the process is stopped
    @Override
    public void onResume(){

        super.onResume();
    }//End of onResume

    //finish is the graceful way to end an App's process
    //It's a good idea to clean up stuff that you might have temporarily saved in persistence so
    //that it doesn't cause problems the next time the App launches
    @Override
    public void finish(){

        super.finish();
    }//End of finish

    //This will override the default function of the back key.
    //I like to put this in here so that someone doesn't accidentally close down the App and lose
    //any unsaved work.
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_BACK){
            //quitDialog();
        }

        return true;
    }//End of onKeyDown

    //onClick handles what happens when you click a button
    //I like to use If/Else statements so that I can handle non-static button IDs
    //Like buttons that are generated through java code, instead of placed in the layout file
    @Override
    public void onClick(View v){
        int id = v.getId();

        if (id == R.id.settingsButton){
            Intent settings = new Intent(this, SettingsActivity.class);
            startActivity(settings);
        }
    }//End of onClick


    void saveInfo() {
        //get moneydetailsml view
        View moneydetailsView = li.inflate(R.layout.moneydetails, null);

        //set moneydetailsml to alertdialog builder
        alertDialogBuilder.setView(moneydetailsView);

        final EditText contactName = (EditText) moneydetailsView.findViewById(R.id.contactName);
        final EditText dollarAmount = (EditText) moneydetailsView.findViewById(R.id.dollarAmount);
        final EditText moneyPurpose = (EditText) moneydetailsView.findViewById(R.id.moneyPurpose);

        //set dialog message
        alertDialogBuilder.setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                contactNameString = contactName.getText().toString();
                if (contactNameString.equals("")) {
                    contactNameString = "N/A";
                }
                saveInfo = date + " " + contactCounterString + " - " + mealInfo;
                contactCounter = "" + restaurantNumber;
                editor.putString(counter, saveInfo);
                editor.putString("mealAmount", mealAmountString);
                restaurantNumber++;
                editor.putInt(restaurantCounter, restaurantNumber);
                editor.commit();
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        //create alert dialog
        alertDialogBuilder.create();

        //show it
        alertDialog.show();
    }

    public void quitDialog(){
        View quitDialogView = li.inflate(R.layout.quitdialog, null);

        //set moneydetails.xmlo alertdialog builder
        alertDialogBuilder.setView(quitDialogView);

        //set dialog message
        alertDialogBuilder.setCancelable(false).setPositiveButton("Quit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();
            }
        }).setNegativeButton("Don't Quit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        //create alert dialog
        alertDialog = alertDialogBuilder.create();

        //show it
        alertDialog.show();
    }

}//End of whole program
