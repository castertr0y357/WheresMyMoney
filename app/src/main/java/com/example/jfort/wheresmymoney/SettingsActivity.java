package com.example.jfort.wheresmymoney;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

public class SettingsActivity extends Activity implements View.OnClickListener{

    //Objects

    //Persistence
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    String dataName = "WheresMyMoney";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //Initialize Shared preferences
        prefs = getSharedPreferences(dataName, Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    @Override
    public void onPause(){
        super.onPause();
    }

    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    public void finish(){
        super.finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
        }

        return true;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();



    }
}
