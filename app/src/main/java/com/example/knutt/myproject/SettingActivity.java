package com.example.knutt.myproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.HashSet;

public class SettingActivity extends AppCompatActivity {

    Button backbtnsetting;
    private CheckBox checkBox;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;

    private CheckBox checkBox6;
    private CheckBox checkBox7;
    private CheckBox checkBox8;
    private CheckBox checkBox9;
    private HashSet<String> map = new HashSet<>();
    int countcheck = 0;
    private RadioGroup radioGroup;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting2);


        checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkBox4 = (CheckBox) findViewById(R.id.checkBox4);

        checkBox6 = (CheckBox) findViewById(R.id.checkBox6);
        checkBox7 = (CheckBox) findViewById(R.id.checkBox7);
        checkBox8 = (CheckBox) findViewById(R.id.checkBox8);
        checkBox9 = (CheckBox) findViewById(R.id.checkBox9);


        final Intent intent = getIntent();
        final String jsondata = intent.getStringExtra("userProfile");



        SharedPreferences sp = getSharedPreferences("App save", Context.MODE_PRIVATE);
        int checkboxstate = sp.getInt("checked",0);
        SharedPreferences sp2 = getSharedPreferences("App save2", Context.MODE_PRIVATE);
        int checkboxstate2 = sp2.getInt("checked2",0);
        SharedPreferences sp3 = getSharedPreferences("App save3", Context.MODE_PRIVATE);
        int checkboxstate3 = sp3.getInt("checked3",0);
        SharedPreferences sp4 = getSharedPreferences("App save4", Context.MODE_PRIVATE);
        int checkboxstate4 = sp4.getInt("checked4",0);

        SharedPreferences sp6 = getSharedPreferences("App save6", Context.MODE_PRIVATE);
        int checkboxstate6 = sp6.getInt("checked6",0);
        SharedPreferences sp7 = getSharedPreferences("App save7", Context.MODE_PRIVATE);
        int checkboxstate7 = sp7.getInt("checked7",0);
        SharedPreferences sp8 = getSharedPreferences("App save8", Context.MODE_PRIVATE);
        int checkboxstate8 = sp8.getInt("checked8",0);
        SharedPreferences sp9 = getSharedPreferences("App save9", Context.MODE_PRIVATE);
        int checkboxstate9 = sp9.getInt("checked9",0);




        if (checkboxstate == 1) {
            checkBox.setChecked(true);
        }else {
            checkBox.setChecked(false);
        }

        if (checkboxstate2 == 1) {
            checkBox2.setChecked(true);
        }else {
            checkBox2.setChecked(false);
        }
        if (checkboxstate3 == 1) {
            checkBox3.setChecked(true);
        }else {
            checkBox3.setChecked(false);
        }
        if (checkboxstate4 == 1) {
            checkBox4.setChecked(true);
        }else {
            checkBox4.setChecked(false);
        }

        if (checkboxstate6 == 1) {
            checkBox6.setChecked(true);
        }else {
            checkBox6.setChecked(false);
        }
        if (checkboxstate7 == 1) {
            checkBox7.setChecked(true);
        }else {
            checkBox7.setChecked(false);
        }
        if (checkboxstate8 == 1) {
            checkBox8.setChecked(true);
        }else {
            checkBox8.setChecked(false);
        }
        if (checkboxstate9 == 1) {
            checkBox9.setChecked(true);
        }else {
            checkBox9.setChecked(false);
        }

        SharedPreferences spradio = getSharedPreferences("App save radio", Context.MODE_PRIVATE);
        int checkboxRadio = spradio.getInt("checkedRadio",0);



//        radioGroup = (RadioGroup) findViewById(R.id.radio_g);
//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                if(i == R.id.day1){
//                    Toast.makeText(SettingActivity.this,"day1",Toast.LENGTH_SHORT).show();
//                    SharedPreferences sharedPref = getSharedPreferences("App save radio", Context.MODE_PRIVATE);
//                    SharedPreferences.Editor editor = sharedPref.edit();
//                    editor.putInt("checkedRadio", 1);
//                    editor.commit();
//
//                }else if(i == R.id.day2){
//                    Toast.makeText(SettingActivity.this,"day2",Toast.LENGTH_SHORT).show();
//                    SharedPreferences sharedPref = getSharedPreferences("App save radio", Context.MODE_PRIVATE);
//                    SharedPreferences.Editor editor = sharedPref.edit();
//                    editor.putInt("checkedRadio", 2);
//                    editor.commit();
//                }else if(i == R.id.day3){
//                    Toast.makeText(SettingActivity.this,"day3",Toast.LENGTH_SHORT).show();
//                    SharedPreferences sharedPref = getSharedPreferences("App save radio", Context.MODE_PRIVATE);
//                    SharedPreferences.Editor editor = sharedPref.edit();
//                    editor.putInt("checkedRadio", 3);
//                    editor.commit();
//                }else if(i == R.id.day4){
//                    Toast.makeText(SettingActivity.this,"day4",Toast.LENGTH_SHORT).show();
//                    SharedPreferences sharedPref = getSharedPreferences("App save radio", Context.MODE_PRIVATE);
//                    SharedPreferences.Editor editor = sharedPref.edit();
//                    editor.putInt("checkedRadio", 4);
//                    editor.commit();
//                }else if(i == R.id.day5){
//                    Toast.makeText(SettingActivity.this,"day5",Toast.LENGTH_SHORT).show();
//                    SharedPreferences sharedPref = getSharedPreferences("App save radio", Context.MODE_PRIVATE);
//                    SharedPreferences.Editor editor = sharedPref.edit();
//                    editor.putInt("checkedRadio", 5);
//                    editor.commit();
//                }else if(i == R.id.day6){
//                    Toast.makeText(SettingActivity.this,"day6",Toast.LENGTH_SHORT).show();
//                    SharedPreferences sharedPref = getSharedPreferences("App save radio", Context.MODE_PRIVATE);
//                    SharedPreferences.Editor editor = sharedPref.edit();
//                    editor.putInt("checkedRadio", 6);
//                    editor.commit();
//                }
//            }
//        });













    }



    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();


        if (view.getId() == R.id.checkBox) {
            if (checked) {


                SharedPreferences sharedPref = getSharedPreferences("App save", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("checked", 1);
                editor.commit();
               // Toast.makeText(SettingActivity.this, "1", Toast.LENGTH_SHORT).show();
            }else{

                SharedPreferences sharedPref = getSharedPreferences("App save", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("checked", 0);
                editor.commit();


            }
        }
        if(view.getId() == R.id.checkBox2){
            if (checked) {
                SharedPreferences sharedPref = getSharedPreferences("App save2", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("checked2", 1);
                editor.commit();
               // Toast.makeText(SettingActivity.this, "2", Toast.LENGTH_SHORT).show();
            }else{
                SharedPreferences sharedPref = getSharedPreferences("App save2", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("checked2", 0);
                editor.commit();
            }
        }
        if(view.getId() == R.id.checkBox3){
            if (checked) {
                SharedPreferences sharedPref = getSharedPreferences("App save3", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("checked3", 1);
                editor.commit();
               // Toast.makeText(SettingActivity.this, "3", Toast.LENGTH_SHORT).show();
            }else{
                SharedPreferences sharedPref = getSharedPreferences("App save3", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("checked3", 0);
                editor.commit();

            }
        }
        if(view.getId() == R.id.checkBox4){
            if (checked) {
                SharedPreferences sharedPref = getSharedPreferences("App save4", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("checked4", 1);
                editor.commit();
                //Toast.makeText(SettingActivity.this, "4", Toast.LENGTH_SHORT).show();
            }else{
                SharedPreferences sharedPref = getSharedPreferences("App save4", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("checked4", 0);
                editor.commit();

            }
        }

        if(view.getId() == R.id.checkBox6){
            if (checked) {
                SharedPreferences sharedPref = getSharedPreferences("App save6", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("checked6", 1);
                editor.commit();
               // Toast.makeText(SettingActivity.this, "6", Toast.LENGTH_SHORT).show();
            }else{
                SharedPreferences sharedPref = getSharedPreferences("App save6", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("checked6", 0);
                editor.commit();

            }
        }
        if (view.getId() == R.id.checkBox7) {
            if (checked) {


                SharedPreferences sharedPref = getSharedPreferences("App save7", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("checked7", 1);
                editor.commit();
               // Toast.makeText(SettingActivity.this, "1", Toast.LENGTH_SHORT).show();
            }else{

                SharedPreferences sharedPref = getSharedPreferences("App save7", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("checked7", 0);
                editor.commit();


            }
        }
        if(view.getId() == R.id.checkBox8){
            if (checked) {
                SharedPreferences sharedPref = getSharedPreferences("App save8", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("checked8", 1);
                editor.commit();
               // Toast.makeText(SettingActivity.this, "2", Toast.LENGTH_SHORT).show();
            }else{
                SharedPreferences sharedPref = getSharedPreferences("App save8", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("checked8", 0);
                editor.commit();
            }
        }
        if(view.getId() == R.id.checkBox9){
            if (checked) {
                SharedPreferences sharedPref = getSharedPreferences("App save9", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("checked9", 1);
                editor.commit();
                //Toast.makeText(SettingActivity.this, "3", Toast.LENGTH_SHORT).show();
            }else{
                SharedPreferences sharedPref = getSharedPreferences("App save9", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("checked9", 0);
                editor.commit();

            }
        }









    }
//    public void onCheckboxClicked2(View view){
//        boolean checked2 = ((RadioButton) view).isChecked();
//        if(view.getId() == R.id.day1){
//            if(checked2){
//                Toast.makeText(SettingActivity.this,"day1",Toast.LENGTH_SHORT).show();
//                SharedPreferences sharedPref = getSharedPreferences("App save radio", Context.MODE_PRIVATE);
//                SharedPreferences.Editor editor = sharedPref.edit();
//                editor.putInt("checkedRadio", 1);
//                editor.commit();
//            }
//
//        }else if(view.getId() == R.id.day2){
//            if(checked2){
//                Toast.makeText(SettingActivity.this,"day2",Toast.LENGTH_SHORT).show();
//                SharedPreferences sharedPref = getSharedPreferences("App save radio", Context.MODE_PRIVATE);
//                SharedPreferences.Editor editor = sharedPref.edit();
//                editor.putInt("checkedRadio", 2);
//                editor.commit();
//            }
//
//        }else if(view.getId() == R.id.day3){
//            if(checked2){
//                Toast.makeText(SettingActivity.this,"day3",Toast.LENGTH_SHORT).show();
//                SharedPreferences sharedPref = getSharedPreferences("App save radio", Context.MODE_PRIVATE);
//                SharedPreferences.Editor editor = sharedPref.edit();
//                editor.putInt("checkedRadio", 3);
//                editor.commit();
//            }
//
//        }else if(view.getId() == R.id.day4){
//            if(checked2){
//                Toast.makeText(SettingActivity.this,"day4",Toast.LENGTH_SHORT).show();
//                SharedPreferences sharedPref = getSharedPreferences("App save radio", Context.MODE_PRIVATE);
//                SharedPreferences.Editor editor = sharedPref.edit();
//                editor.putInt("checkedRadio", 4);
//                editor.commit();
//            }
//
//        }else if(view.getId() == R.id.day5){
//            if(checked2){
//                Toast.makeText(SettingActivity.this,"day5",Toast.LENGTH_SHORT).show();
//                SharedPreferences sharedPref = getSharedPreferences("App save radio", Context.MODE_PRIVATE);
//                SharedPreferences.Editor editor = sharedPref.edit();
//                editor.putInt("checkedRadio", 5);
//                editor.commit();
//            }
//
//        }else if(view.getId() == R.id.day6){
//            if(checked2){
//                Toast.makeText(SettingActivity.this,"day6",Toast.LENGTH_SHORT).show();
//                SharedPreferences sharedPref = getSharedPreferences("App save radio", Context.MODE_PRIVATE);
//                SharedPreferences.Editor editor = sharedPref.edit();
//                editor.putInt("checkedRadio", 6);
//                editor.commit();
//            }
//
//        }
//    }



    @Override
    protected void onResume() {
        super.onResume();

    }












}


