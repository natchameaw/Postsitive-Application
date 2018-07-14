package com.example.knutt.myproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.BreakIterator;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SummaryActivity extends AppCompatActivity {

    ArrayList<String> strword = new ArrayList<>() ;
    HashSet<String> emo = new HashSet<>();
    private ArrayList<String> listemo = new ArrayList<>();
    private DatabaseRealtime databaseRealtime;
    private Database db;
    private Database2 db2;
    private Database3 db3;
    private DatabaseCheckin databaseCheckin;
    private databaserealtimeSetting1 databaserealtimeSetting1;
    private DatabaseForSummary databaseForSummary;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        db = new Database(getApplicationContext());
        databaseRealtime = new DatabaseRealtime(getApplicationContext());
        db2 = new Database2(getApplicationContext());
        db3 = new Database3(getApplicationContext());
        databaseCheckin = new DatabaseCheckin(getApplicationContext());


        
        setPiechart();




    }

    private void setPiechart() {
        //////////////////
        final ArrayList<HashMap<String, String>> attitude = db.getAttitudeList();
        final ArrayList<HashMap<String, String>> emotion = db.getEmotionList();
        final ArrayList<HashMap<String, String>> emoshortcut = db.getEmoticon();
        final ArrayList<HashMap<String, String>> attitude2 = db2.getAttitudeList2();
        final ArrayList<HashMap<String, String>> attitude3 = db3.getAttitudeList3();
        final ArrayList<HashMap<String, String>> storyTimeline =  databaseCheckin.getCheckinWord();

        final String pattern2 = "([a-zA-Z0-9!@#$&()-`|.+',/\"]{2})";
        final String pattern3 = "([a-zA-Z0-9!@#$&()-`|.+',/\"]{3})";
        final String pattern4 = "([a-zA-Z0-9!@#$&()-`|.+',/\"]{4})";
        final String pattern5 = "([0-8]{1})";

        final Pattern regex2 = Pattern.compile(pattern2);
        final Pattern regex3 = Pattern.compile(pattern3);
        final Pattern regex4 = Pattern.compile(pattern4);

        databaseRealtime = new DatabaseRealtime(getApplicationContext());
        databaseRealtime.getReadableDatabase();

        //time current
        Calendar check = Calendar.getInstance();
        check.add(Calendar.DATE,0);
        SimpleDateFormat realdatecurrent = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat rrrr = new SimpleDateFormat("yyyy-MM-dd:HH-mm-ss");
        String datecurrent = realdatecurrent.format(check.getTime());

        SharedPreferences spradio = getSharedPreferences("App save radio", Context.MODE_PRIVATE);


        databaserealtimeSetting1 = new databaserealtimeSetting1(getApplicationContext());
        databaserealtimeSetting1.getWritableDatabase();




//        String ddd = rrrr.format(check.getTime());
//        Toast.makeText(SummaryActivity.this,ddd,Toast.LENGTH_LONG).show();



        SimpleDateFormat df ;
        SimpleDateFormat df2;
        SimpleDateFormat df3 ;
        SimpleDateFormat df4 ;
        SimpleDateFormat df5 ;
        SimpleDateFormat df6 ;
        SimpleDateFormat df7 ;
        SimpleDateFormat df8 ;

        final String formattedDate ;
        final String formattedDate2 ;
        final String formattedDate3 ;
        final String formattedDate4 ;
        final String formattedDate5 ;
        final String formattedDate6 ;
        final String formattedDate7 ;
        final String formattedDate8 ;


        boolean Date1 ;
        boolean Date2 ;
        boolean Date3;
        boolean Date4;
        boolean Date5;
        boolean Date6;
        boolean Date7;
        boolean Date8;




        final ArrayList<HashMap<String, String>> datetime = databaseRealtime.getDaterealtime();
        final ArrayList<HashMap<String, String>> datetimesetting1 = databaserealtimeSetting1.getDaterealtimesetting1();
        //original
        final String datecheck1 = datetime.get(0).get("Date");
        final String datecheck2 = datetime.get(1).get("Date");
        final String datecheck3 = datetime.get(2).get("Date");
        final String datecheck4 = datetime.get(3).get("Date");
        final String datecheck5 = datetime.get(4).get("Date");
        final String datecheck6 = datetime.get(5).get("Date");
        final String datecheck7 = datetime.get(6).get("Date");
        final String datecheck8 = datetime.get(7).get("Date");

        //setting1
        final String datechecksetting11 = datetimesetting1.get(0).get("Date");
        final String datechecksetting12 = datetimesetting1.get(1).get("Date");

        final String pattern = "([0-9-]{10})";

        final Pattern regex = Pattern.compile(pattern);

        //new
        SharedPreferences spID = getSharedPreferences("IDFB", Context.MODE_PRIVATE);
        int idFB = spID.getInt("IDFB", 0);

        databaseForSummary = new DatabaseForSummary(getApplicationContext());
        final ArrayList<HashMap<String, String>> getIDFB = databaseForSummary.getSummary();


        final String DateCheck1 = getIDFB.get(idFB).get("Date1");
        final String DateCheck2 = getIDFB.get(idFB).get("Date2");
        final String DateCheck3 = getIDFB.get(idFB).get("Date3");
        final String DateCheck4 = getIDFB.get(idFB).get("Date4");
        final String DateCheck5 = getIDFB.get(idFB).get("Date5");
        final String DateCheck6 = getIDFB.get(idFB).get("Date6");
        final String DateCheck7 = getIDFB.get(idFB).get("Date7");
        final String DateCheck8 = getIDFB.get(idFB).get("Date8");

        //new



       if (!(datecurrent.contains(DateCheck8))) {

           GraphRequest request = new GraphRequest(
                   AccessToken.getCurrentAccessToken(),
                   "/me/feed?limit=500",
                   null,
                   HttpMethod.GET,
                   new GraphRequest.Callback() {
                       public void onCompleted(GraphResponse response) {

                           // JSON GETS THE DATA
                           JSONObject jsonData = response.getJSONObject();

                           try {

                               JSONArray postsData = jsonData.getJSONArray("data");
                               if (postsData != null) {

                                   int countgrappos = 0;
                                   int countgrapnege = 0;
                                   int countgraphneural = 0;
                                   int countgraphnot = 0;

                                   for (int i = 0; i < postsData.length(); i++) {

                                       strword.clear();
                                       emo.clear();
                                       listemo.clear();


                                       int countchexkemo = 0;
                                       int count = 0;
                                       int checkifemo = 0;
                                       int checkifword = 0;

                                       JSONObject story = postsData.getJSONObject(i);

//
                                       if (story.has("created_time")) {
                                           String timeMessage = story.getString("created_time");
                                           //allPostsMessages.add(timeMessage);
                                           Matcher m = regex.matcher(timeMessage);
                                           if (m.find()) {
                                               //allPostsMessages.add(m.group(0));

                                               if (m.group(0).contains(DateCheck1)) {
                                                   if (story.has("message")) {

                                                       String postMessage = story.getString("message");
                                                       Matcher m22 = regex2.matcher(postMessage);
                                                       Matcher m33 = regex3.matcher(postMessage);
                                                       Matcher m44 = regex4.matcher(postMessage);

                                                       while (m22.find()) {
                                                           listemo.add(m22.group(0));
                                                       }

                                                       while (m33.find()) {
                                                           listemo.add(m33.group(0));

                                                       }

                                                       while (m44.find()) {
                                                           listemo.add(m44.group(0));

                                                       }


                                                       //check word
                                                       Locale thaiLocale = new Locale("th");


                                                       BreakIterator boundary = BreakIterator.getWordInstance(thaiLocale);

                                                       boundary.setText(postMessage);


                                                       int start = boundary.first();
                                                       for (int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary.next()) {

                                                           strword.add(postMessage.substring(start, end));


                                                       }
                                                       BreakIterator boundary2 = BreakIterator.getWordInstance(thaiLocale);

                                                       String connectStr = "";

                                                       for(int l = 0;l<strword.size();l++){
                                                           if(strword.get(l).equals("มาก")){
                                                               connectStr = connectStr+"ๆ";
                                                           }else{
                                                               connectStr = connectStr+strword.get(l);
                                                           }
                                                       }

                                                       boundary2.setText(connectStr);
                                                       int start2 = boundary2.first();

                                                       strword.clear();

                                                       for (int end = boundary2.next(); end != BreakIterator.DONE; start2 = end, end = boundary2.next()) {


                                                           strword.add(connectStr.substring(start2, end));


                                                           //Toast.makeText(MainActivity.this,input.substring(start, end) + " ",Toast.LENGTH_SHORT).show();

                                                       }

                                                       for (String s : listemo) {
                                                           for (int k = 0; k < emoshortcut.size(); k++) {
                                                               if (s.equals(emoshortcut.get(k).get("EmoticonShortcut"))) {
                                                                   String rank = emoshortcut.get(k).get("EmoticonRank");
                                                                   int countrank = Integer.parseInt(rank);
                                                                   countchexkemo = countchexkemo + countrank;
                                                                   checkifemo++;
                                                               }
                                                           }

                                                       }



                                                       for (int h = 0; h < strword.size(); h++) {
                                                           int icount = h+1;
                                                           String str2 = "";
                                                           String str3 = "";

                                                           if(icount <= strword.size()-1){
                                                               str2 = strword.get(icount);
                                                               for(int k = icount;k<=strword.size()-1;k++){
                                                                   if(str2.contains(" ")){
                                                                       str2 = strword.get(k);
                                                                   }else{
                                                                       break;
                                                                   }
                                                               }


                                                           }

                                                           int icountex = h+2;
                                                           String extrastr = "";

                                                           if(icountex <= strword.size()-1){
                                                               extrastr = strword.get(icountex);

                                                               for(int l = icountex;l<=strword.size()-1;l++){
                                                                   if(extrastr.contains(" ")){
                                                                       extrastr = strword.get(l);

                                                                   }else{
                                                                       break;
                                                                   }
                                                               }


                                                           }

                                                           String str = strword.get(h);


                                                           int counttarget = 0;

                                                           if(str.contains("ๆ")){
                                                               for(int a = 0;a<attitude.size();a++){
                                                                   String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           if(counttarget != 1){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else{
                                                                               str3 = str+"ๆ";
                                                                           }

                                                                       } else{
                                                                           str3 = str+"ๆ";
                                                                       }

                                                                   }

                                                               }

                                                               for(int a = 0;a<attitude2.size();a++){
                                                                   String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           if((counttarget != 1)){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else{
                                                                               str3 = str+"ๆ";
                                                                           }
                                                                       }else{
                                                                           str3 = str+"ๆ";
                                                                       }

                                                                   }
                                                               }

                                                               for(int a = 0;a<attitude3.size();a++){
                                                                   String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }

                                                                           if(counttarget != 1){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else {
                                                                               str3 = str+"ๆ";
                                                                           }
                                                                       }else{
                                                                           str3 = str+"ๆ";
                                                                       }


                                                                   }
                                                               }



                                                           }else{
                                                               if(str2.contains("ๆ")){
                                                                   //str3 = str2;
                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               if(counttarget != 1){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else{
                                                                                   str3 = "";
                                                                               }

                                                                           }

                                                                       }

                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               if((counttarget != 1)){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else{
                                                                                   str3 = "";
                                                                               }
                                                                           }

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }

                                                                               if(counttarget != 1){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else {
                                                                                   str3 = "";
                                                                               }
                                                                           }


                                                                       }
                                                                   }

                                                               }



                                                           }


                                                           /////////+++++++++++++++++++++++

                                                           if(str2.contains("มาก")){
                                                               if(extrastr.contains("ๆ")){
                                                                   str3 = str2+extrastr;
                                                               }else{
                                                                   str3 = "ๆ";
                                                               }



                                                           }

                                                           if(str2.contains("มากๆ")){
                                                               if(extrastr.contains("ๆ")){
                                                                   str3 = str2+extrastr;
                                                               }else{
                                                                   str3 = "ๆๆ";
                                                               }
                                                           }

                                                           ////////++++++++++++++++++++++++


                                                           // Toast.makeText(MainActivity.this,str,Toast.LENGTH_LONG).show();
                                                           for (int j = 0; j < attitude.size(); j++) {
                                                               if (str.equals(attitude.get(j).get("AttitudeWord"))) {

                                                                   String rank = attitude.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);

                                                                   count = count + countrank;

                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }

                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }


                                                           for (int j = 0; j < attitude2.size(); j++) {
                                                               if (str.equals(attitude2.get(j).get("AttitudeWord"))) {
                                                                   String rank = attitude2.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);


                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }

                                                           for (int j = 0; j < attitude3.size(); j++) {
                                                               if (str.equals(attitude3.get(j).get("AttitudeWord"))) {
                                                                   String rank = attitude3.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);


                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }


                                                       }



                                                   }
                                                   if(story.has("story")){
                                                       String PostStory = story.getString("story");
                                                       for(int n = 0;n<storyTimeline.size();n++){

                                                           String checkwordbyregular = storyTimeline.get(n).get("CheckinWord");
                                                           Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                           Matcher mcheck = regexcheck.matcher(PostStory);
                                                           String rank = storyTimeline.get(n).get("CheckinRank");
                                                           int countrank = Integer.parseInt(rank);

                                                           if (mcheck.find()){
                                                               count = count+countrank;
                                                               checkifword++;
                                                           }

                                                       }


                                                   }

                                                   if (checkifemo > 0 && countchexkemo > 0) {
                                                       countgrappos++;

                                                   } else if (checkifemo > 0 && countchexkemo == 0) {
                                                       countgraphneural++;

                                                   } else if (checkifemo > 0 && countchexkemo < 0) {
                                                       countgrapnege++;
                                                   } else {
                                                       if (checkifword > 0 && count > 0) {
                                                           countgrappos++;
                                                       } else if (checkifword > 0 && count == 0) {
                                                           countgraphneural++;
                                                       } else if (checkifword > 0 && count < 0) {
                                                           countgrapnege++;
                                                       } else {
                                                           countgraphnot++;
                                                       }
                                                   }





                                               } else if (m.group(0).contains(DateCheck2)) {

                                                   if (story.has("message")) {

                                                       String postMessage = story.getString("message");
                                                       Matcher m22 = regex2.matcher(postMessage);
                                                       Matcher m33 = regex3.matcher(postMessage);
                                                       Matcher m44 = regex4.matcher(postMessage);

                                                       while (m22.find()) {
                                                           listemo.add(m22.group(0));
                                                       }

                                                       while (m33.find()) {
                                                           listemo.add(m33.group(0));

                                                       }

                                                       while (m44.find()) {
                                                           listemo.add(m44.group(0));

                                                       }

                                                       //check word
                                                       Locale thaiLocale = new Locale("th");


                                                       BreakIterator boundary = BreakIterator.getWordInstance(thaiLocale);

                                                       boundary.setText(postMessage);


                                                       int start = boundary.first();
                                                       for (int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary.next()) {

                                                           strword.add(postMessage.substring(start, end));


                                                       }

                                                       BreakIterator boundary2 = BreakIterator.getWordInstance(thaiLocale);

                                                       String connectStr = "";

                                                       for(int l = 0;l<strword.size();l++){
                                                           if(strword.get(l).equals("มาก")){
                                                               connectStr = connectStr+"ๆ";
                                                           }else{
                                                               connectStr = connectStr+strword.get(l);
                                                           }
                                                       }

                                                       boundary2.setText(connectStr);
                                                       int start2 = boundary2.first();

                                                       strword.clear();

                                                       for (int end = boundary2.next(); end != BreakIterator.DONE; start2 = end, end = boundary2.next()) {


                                                           strword.add(connectStr.substring(start2, end));


                                                           //Toast.makeText(MainActivity.this,input.substring(start, end) + " ",Toast.LENGTH_SHORT).show();

                                                       }

                                                       for (String s : listemo) {
                                                           for (int k = 0; k < emoshortcut.size(); k++) {
                                                               if (s.equals(emoshortcut.get(k).get("EmoticonShortcut"))) {
                                                                   String rank = emoshortcut.get(k).get("EmoticonRank");
                                                                   int countrank = Integer.parseInt(rank);
                                                                   countchexkemo = countchexkemo + countrank;
                                                                   checkifemo++;
                                                               }
                                                           }

                                                       }

                                                       for (int h = 0; h < strword.size(); h++) {
                                                           int icount = h+1;
                                                           String str2 = "";
                                                           String str3 = "";

                                                           if(icount <= strword.size()-1){
                                                               str2 = strword.get(icount);
                                                               for(int k = icount;k<=strword.size()-1;k++){
                                                                   if(str2.contains(" ")){
                                                                       str2 = strword.get(k);
                                                                   }else{
                                                                       break;
                                                                   }
                                                               }


                                                           }

                                                           int icountex = h+2;
                                                           String extrastr = "";

                                                           if(icountex <= strword.size()-1){
                                                               extrastr = strword.get(icountex);

                                                               for(int l = icountex;l<=strword.size()-1;l++){
                                                                   if(extrastr.contains(" ")){
                                                                       extrastr = strword.get(l);

                                                                   }else{
                                                                       break;
                                                                   }
                                                               }


                                                           }

                                                           String str = strword.get(h);


                                                           int counttarget = 0;

                                                           if(str.contains("ๆ")){
                                                               for(int a = 0;a<attitude.size();a++){
                                                                   String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           if(counttarget != 1){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else{
                                                                               str3 = str+"ๆ";
                                                                           }

                                                                       } else{
                                                                           str3 = str+"ๆ";
                                                                       }

                                                                   }

                                                               }

                                                               for(int a = 0;a<attitude2.size();a++){
                                                                   String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           if((counttarget != 1)){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else{
                                                                               str3 = str+"ๆ";
                                                                           }
                                                                       }else{
                                                                           str3 = str+"ๆ";
                                                                       }

                                                                   }
                                                               }

                                                               for(int a = 0;a<attitude3.size();a++){
                                                                   String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }

                                                                           if(counttarget != 1){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else {
                                                                               str3 = str+"ๆ";
                                                                           }
                                                                       }else{
                                                                           str3 = str+"ๆ";
                                                                       }


                                                                   }
                                                               }



                                                           }else{
                                                               if(str2.contains("ๆ")){
                                                                   //str3 = str2;
                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               if(counttarget != 1){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else{
                                                                                   str3 = "";
                                                                               }

                                                                           }

                                                                       }

                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               if((counttarget != 1)){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else{
                                                                                   str3 = "";
                                                                               }
                                                                           }

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }

                                                                               if(counttarget != 1){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else {
                                                                                   str3 = "";
                                                                               }
                                                                           }


                                                                       }
                                                                   }

                                                               }



                                                           }


                                                           /////////+++++++++++++++++++++++

                                                           if(str2.contains("มาก")){
                                                               if(extrastr.contains("ๆ")){
                                                                   str3 = str2+extrastr;
                                                               }else{
                                                                   str3 = "ๆ";
                                                               }



                                                           }

                                                           if(str2.contains("มากๆ")){
                                                               if(extrastr.contains("ๆ")){
                                                                   str3 = str2+extrastr;
                                                               }else{
                                                                   str3 = "ๆๆ";
                                                               }
                                                           }

                                                           ////////++++++++++++++++++++++++


                                                           // Toast.makeText(MainActivity.this,str,Toast.LENGTH_LONG).show();
                                                           for (int j = 0; j < attitude.size(); j++) {
                                                               if (str.equals(attitude.get(j).get("AttitudeWord"))) {

                                                                   String rank = attitude.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);

                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }


                                                           for (int j = 0; j < attitude2.size(); j++) {
                                                               if (str.equals(attitude2.get(j).get("AttitudeWord"))) {
                                                                   String rank = attitude2.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);


                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }

                                                           for (int j = 0; j < attitude3.size(); j++) {
                                                               if (str.equals(attitude3.get(j).get("AttitudeWord"))) {
                                                                   String rank = attitude3.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);


                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }


                                                       }



                                                   }

                                                   if(story.has("story")){
                                                       String PostStory = story.getString("story");
                                                       for(int n = 0;n<storyTimeline.size();n++){

                                                           String checkwordbyregular = storyTimeline.get(n).get("CheckinWord");
                                                           Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                           Matcher mcheck = regexcheck.matcher(PostStory);
                                                           String rank = storyTimeline.get(n).get("CheckinRank");
                                                           int countrank = Integer.parseInt(rank);

                                                           if (mcheck.find()){
                                                               count = count+countrank;
                                                               checkifword++;
                                                           }

                                                       }


                                                   }

                                                   if (checkifemo > 0 && countchexkemo > 0) {
                                                       countgrappos++;

                                                   } else if (checkifemo > 0 && countchexkemo == 0) {
                                                       countgraphneural++;

                                                   } else if (checkifemo > 0 && countchexkemo < 0) {
                                                       countgrapnege++;
                                                   } else {
                                                       if (checkifword > 0 && count > 0) {
                                                           countgrappos++;
                                                       } else if (checkifword > 0 && count == 0) {
                                                           countgraphneural++;
                                                       } else if (checkifword > 0 && count < 0) {
                                                           countgrapnege++;
                                                       } else {
                                                           countgraphnot++;
                                                       }
                                                   }


                                               } else if (m.group(0).contains(DateCheck3)) {

                                                   if (story.has("message")) {

                                                       String postMessage = story.getString("message");
                                                       Matcher m22 = regex2.matcher(postMessage);
                                                       Matcher m33 = regex3.matcher(postMessage);
                                                       Matcher m44 = regex4.matcher(postMessage);

                                                       while (m22.find()) {
                                                           listemo.add(m22.group(0));
                                                       }

                                                       while (m33.find()) {
                                                           listemo.add(m33.group(0));

                                                       }

                                                       while (m44.find()) {
                                                           listemo.add(m44.group(0));

                                                       }

                                                       //check word
                                                       Locale thaiLocale = new Locale("th");


                                                       BreakIterator boundary = BreakIterator.getWordInstance(thaiLocale);

                                                       boundary.setText(postMessage);


                                                       int start = boundary.first();
                                                       for (int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary.next()) {

                                                           strword.add(postMessage.substring(start, end));


                                                       }
                                                       BreakIterator boundary2 = BreakIterator.getWordInstance(thaiLocale);

                                                       String connectStr = "";

                                                       for(int l = 0;l<strword.size();l++){
                                                           if(strword.get(l).equals("มาก")){
                                                               connectStr = connectStr+"ๆ";
                                                           }else{
                                                               connectStr = connectStr+strword.get(l);
                                                           }
                                                       }

                                                       boundary2.setText(connectStr);
                                                       int start2 = boundary2.first();

                                                       strword.clear();

                                                       for (int end = boundary2.next(); end != BreakIterator.DONE; start2 = end, end = boundary2.next()) {


                                                           strword.add(connectStr.substring(start2, end));


                                                           //Toast.makeText(MainActivity.this,input.substring(start, end) + " ",Toast.LENGTH_SHORT).show();

                                                       }

                                                       for (String s : listemo) {
                                                           for (int k = 0; k < emoshortcut.size(); k++) {
                                                               if (s.equals(emoshortcut.get(k).get("EmoticonShortcut"))) {
                                                                   String rank = emoshortcut.get(k).get("EmoticonRank");
                                                                   int countrank = Integer.parseInt(rank);
                                                                   countchexkemo = countchexkemo + countrank;
                                                                   checkifemo++;
                                                               }
                                                           }

                                                       }

                                                       for (int h = 0; h < strword.size(); h++) {
                                                           int icount = h+1;
                                                           String str2 = "";
                                                           String str3 = "";

                                                           if(icount <= strword.size()-1){
                                                               str2 = strword.get(icount);
                                                               for(int k = icount;k<=strword.size()-1;k++){
                                                                   if(str2.contains(" ")){
                                                                       str2 = strword.get(k);
                                                                   }else{
                                                                       break;
                                                                   }
                                                               }


                                                           }
                                                           int icountex = h+2;
                                                           String extrastr = "";

                                                           if(icountex <= strword.size()-1){
                                                               extrastr = strword.get(icountex);

                                                               for(int l = icountex;l<=strword.size()-1;l++){
                                                                   if(extrastr.contains(" ")){
                                                                       extrastr = strword.get(l);

                                                                   }else{
                                                                       break;
                                                                   }
                                                               }


                                                           }

                                                           String str = strword.get(h);


                                                           int counttarget = 0;

                                                           if(str.contains("ๆ")){
                                                               for(int a = 0;a<attitude.size();a++){
                                                                   String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           if(counttarget != 1){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else{
                                                                               str3 = str+"ๆ";
                                                                           }

                                                                       } else{
                                                                           str3 = str+"ๆ";
                                                                       }

                                                                   }

                                                               }

                                                               for(int a = 0;a<attitude2.size();a++){
                                                                   String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           if((counttarget != 1)){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else{
                                                                               str3 = str+"ๆ";
                                                                           }
                                                                       }else{
                                                                           str3 = str+"ๆ";
                                                                       }

                                                                   }
                                                               }

                                                               for(int a = 0;a<attitude3.size();a++){
                                                                   String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }

                                                                           if(counttarget != 1){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else {
                                                                               str3 = str+"ๆ";
                                                                           }
                                                                       }else{
                                                                           str3 = str+"ๆ";
                                                                       }


                                                                   }
                                                               }



                                                           }else{
                                                               if(str2.contains("ๆ")){
                                                                   //str3 = str2;
                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               if(counttarget != 1){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else{
                                                                                   str3 = "";
                                                                               }

                                                                           }

                                                                       }

                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               if((counttarget != 1)){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else{
                                                                                   str3 = "";
                                                                               }
                                                                           }

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }

                                                                               if(counttarget != 1){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else {
                                                                                   str3 = "";
                                                                               }
                                                                           }


                                                                       }
                                                                   }

                                                               }



                                                           }


                                                           /////////+++++++++++++++++++++++

                                                           if(str2.contains("มาก")){
                                                               if(extrastr.contains("ๆ")){
                                                                   str3 = str2+extrastr;
                                                               }else{
                                                                   str3 = "ๆ";
                                                               }



                                                           }

                                                           if(str2.contains("มากๆ")){
                                                               if(extrastr.contains("ๆ")){
                                                                   str3 = str2+extrastr;
                                                               }else{
                                                                   str3 = "ๆๆ";
                                                               }
                                                           }

                                                           ////////++++++++++++++++++++++++


                                                           // Toast.makeText(MainActivity.this,str,Toast.LENGTH_LONG).show();
                                                           for (int j = 0; j < attitude.size(); j++) {
                                                               if (str.equals(attitude.get(j).get("AttitudeWord"))) {

                                                                   String rank = attitude.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);

                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }


                                                           for (int j = 0; j < attitude2.size(); j++) {
                                                               if (str.equals(attitude2.get(j).get("AttitudeWord"))) {
                                                                   String rank = attitude2.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);


                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }

                                                           for (int j = 0; j < attitude3.size(); j++) {
                                                               if (str.equals(attitude3.get(j).get("AttitudeWord"))) {
                                                                   String rank = attitude3.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);


                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }


                                                       }



                                                   }
                                                   if(story.has("story")){
                                                       String PostStory = story.getString("story");
                                                       for(int n = 0;n<storyTimeline.size();n++){

                                                           String checkwordbyregular = storyTimeline.get(n).get("CheckinWord");
                                                           Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                           Matcher mcheck = regexcheck.matcher(PostStory);
                                                           String rank = storyTimeline.get(n).get("CheckinRank");
                                                           int countrank = Integer.parseInt(rank);

                                                           if (mcheck.find()){
                                                               count = count+countrank;
                                                               checkifword++;
                                                           }

                                                       }


                                                   }

                                                   if (checkifemo > 0 && countchexkemo > 0) {
                                                       countgrappos++;

                                                   } else if (checkifemo > 0 && countchexkemo == 0) {
                                                       countgraphneural++;

                                                   } else if (checkifemo > 0 && countchexkemo < 0) {
                                                       countgrapnege++;
                                                   } else {
                                                       if (checkifword > 0 && count > 0) {
                                                           countgrappos++;
                                                       } else if (checkifword > 0 && count == 0) {
                                                           countgraphneural++;
                                                       } else if (checkifword > 0 && count < 0) {
                                                           countgrapnege++;
                                                       } else {
                                                           countgraphnot++;
                                                       }
                                                   }

                                               } else if (m.group(0).contains(DateCheck4)) {

                                                   if (story.has("message")) {

                                                       String postMessage = story.getString("message");
                                                       Matcher m22 = regex2.matcher(postMessage);
                                                       Matcher m33 = regex3.matcher(postMessage);
                                                       Matcher m44 = regex4.matcher(postMessage);

                                                       while (m22.find()) {
                                                           listemo.add(m22.group(0));
                                                       }

                                                       while (m33.find()) {
                                                           listemo.add(m33.group(0));

                                                       }

                                                       while (m44.find()) {
                                                           listemo.add(m44.group(0));

                                                       }

                                                       //check word
                                                       Locale thaiLocale = new Locale("th");


                                                       BreakIterator boundary = BreakIterator.getWordInstance(thaiLocale);

                                                       boundary.setText(postMessage);


                                                       int start = boundary.first();
                                                       for (int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary.next()) {

                                                           strword.add(postMessage.substring(start, end));


                                                       }
                                                       BreakIterator boundary2 = BreakIterator.getWordInstance(thaiLocale);

                                                       String connectStr = "";

                                                       for(int l = 0;l<strword.size();l++){
                                                           if(strword.get(l).equals("มาก")){
                                                               connectStr = connectStr+"ๆ";
                                                           }else{
                                                               connectStr = connectStr+strword.get(l);
                                                           }
                                                       }

                                                       boundary2.setText(connectStr);
                                                       int start2 = boundary2.first();

                                                       strword.clear();

                                                       for (int end = boundary2.next(); end != BreakIterator.DONE; start2 = end, end = boundary2.next()) {


                                                           strword.add(connectStr.substring(start2, end));


                                                           //Toast.makeText(MainActivity.this,input.substring(start, end) + " ",Toast.LENGTH_SHORT).show();

                                                       }

                                                       for (String s : listemo) {
                                                           for (int k = 0; k < emoshortcut.size(); k++) {
                                                               if (s.equals(emoshortcut.get(k).get("EmoticonShortcut"))) {
                                                                   String rank = emoshortcut.get(k).get("EmoticonRank");
                                                                   int countrank = Integer.parseInt(rank);
                                                                   countchexkemo = countchexkemo + countrank;
                                                                   checkifemo++;
                                                               }
                                                           }

                                                       }

                                                       for (int h = 0; h < strword.size(); h++) {
                                                           int icount = h+1;
                                                           String str2 = "";
                                                           String str3 = "";

                                                           if(icount <= strword.size()-1){
                                                               str2 = strword.get(icount);
                                                               for(int k = icount;k<=strword.size()-1;k++){
                                                                   if(str2.contains(" ")){
                                                                       str2 = strword.get(k);
                                                                   }else{
                                                                       break;
                                                                   }
                                                               }


                                                           }

                                                           int icountex = h+2;
                                                           String extrastr = "";

                                                           if(icountex <= strword.size()-1){
                                                               extrastr = strword.get(icountex);

                                                               for(int l = icountex;l<=strword.size()-1;l++){
                                                                   if(extrastr.contains(" ")){
                                                                       extrastr = strword.get(l);

                                                                   }else{
                                                                       break;
                                                                   }
                                                               }


                                                           }

                                                           String str = strword.get(h);


                                                           int counttarget = 0;

                                                           if(str.contains("ๆ")){
                                                               for(int a = 0;a<attitude.size();a++){
                                                                   String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           if(counttarget != 1){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else{
                                                                               str3 = str+"ๆ";
                                                                           }

                                                                       } else{
                                                                           str3 = str+"ๆ";
                                                                       }

                                                                   }

                                                               }

                                                               for(int a = 0;a<attitude2.size();a++){
                                                                   String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           if((counttarget != 1)){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else{
                                                                               str3 = str+"ๆ";
                                                                           }
                                                                       }else{
                                                                           str3 = str+"ๆ";
                                                                       }

                                                                   }
                                                               }

                                                               for(int a = 0;a<attitude3.size();a++){
                                                                   String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }

                                                                           if(counttarget != 1){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else {
                                                                               str3 = str+"ๆ";
                                                                           }
                                                                       }else{
                                                                           str3 = str+"ๆ";
                                                                       }


                                                                   }
                                                               }



                                                           }else{
                                                               if(str2.contains("ๆ")){
                                                                   //str3 = str2;
                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               if(counttarget != 1){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else{
                                                                                   str3 = "";
                                                                               }

                                                                           }

                                                                       }

                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               if((counttarget != 1)){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else{
                                                                                   str3 = "";
                                                                               }
                                                                           }

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }

                                                                               if(counttarget != 1){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else {
                                                                                   str3 = "";
                                                                               }
                                                                           }


                                                                       }
                                                                   }

                                                               }



                                                           }


                                                           /////////+++++++++++++++++++++++

                                                           if(str2.contains("มาก")){
                                                               if(extrastr.contains("ๆ")){
                                                                   str3 = str2+extrastr;
                                                               }else{
                                                                   str3 = "ๆ";
                                                               }



                                                           }

                                                           if(str2.contains("มากๆ")){
                                                               if(extrastr.contains("ๆ")){
                                                                   str3 = str2+extrastr;
                                                               }else{
                                                                   str3 = "ๆๆ";
                                                               }
                                                           }

                                                           ////////++++++++++++++++++++++++


                                                           // Toast.makeText(MainActivity.this,str,Toast.LENGTH_LONG).show();
                                                           for (int j = 0; j < attitude.size(); j++) {
                                                               if (str.equals(attitude.get(j).get("AttitudeWord"))) {

                                                                   String rank = attitude.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);

                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }


                                                           for (int j = 0; j < attitude2.size(); j++) {
                                                               if (str.equals(attitude2.get(j).get("AttitudeWord"))) {
                                                                   String rank = attitude2.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);


                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }

                                                           for (int j = 0; j < attitude3.size(); j++) {
                                                               if (str.equals(attitude3.get(j).get("AttitudeWord"))) {
                                                                   String rank = attitude3.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);


                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }


                                                       }



                                                   }
                                                   if(story.has("story")){
                                                       String PostStory = story.getString("story");
                                                       for(int n = 0;n<storyTimeline.size();n++){

                                                           String checkwordbyregular = storyTimeline.get(n).get("CheckinWord");
                                                           Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                           Matcher mcheck = regexcheck.matcher(PostStory);

                                                           String rank = storyTimeline.get(n).get("CheckinRank");
                                                           int countrank = Integer.parseInt(rank);

                                                           if (mcheck.find()){
                                                               count = count+countrank;
                                                               checkifword++;
                                                           }

                                                       }


                                                   }

                                                   if (checkifemo > 0 && countchexkemo > 0) {
                                                       countgrappos++;

                                                   } else if (checkifemo > 0 && countchexkemo == 0) {
                                                       countgraphneural++;

                                                   } else if (checkifemo > 0 && countchexkemo < 0) {
                                                       countgrapnege++;
                                                   } else {
                                                       if (checkifword > 0 && count > 0) {
                                                           countgrappos++;
                                                       } else if (checkifword > 0 && count == 0) {
                                                           countgraphneural++;
                                                       } else if (checkifword > 0 && count < 0) {
                                                           countgrapnege++;
                                                       } else {
                                                           countgraphnot++;
                                                       }
                                                   }


                                               } else if (m.group(0).contains(DateCheck5)) {

                                                   if (story.has("message")) {

                                                       String postMessage = story.getString("message");
                                                       Matcher m22 = regex2.matcher(postMessage);
                                                       Matcher m33 = regex3.matcher(postMessage);
                                                       Matcher m44 = regex4.matcher(postMessage);

                                                       while (m22.find()) {
                                                           listemo.add(m22.group(0));
                                                       }

                                                       while (m33.find()) {
                                                           listemo.add(m33.group(0));

                                                       }

                                                       while (m44.find()) {
                                                           listemo.add(m44.group(0));

                                                       }

                                                       //check word
                                                       Locale thaiLocale = new Locale("th");


                                                       BreakIterator boundary = BreakIterator.getWordInstance(thaiLocale);

                                                       boundary.setText(postMessage);


                                                       int start = boundary.first();
                                                       for (int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary.next()) {

                                                           strword.add(postMessage.substring(start, end));


                                                       }
                                                       BreakIterator boundary2 = BreakIterator.getWordInstance(thaiLocale);

                                                       String connectStr = "";

                                                       for(int l = 0;l<strword.size();l++){
                                                           if(strword.get(l).equals("มาก")){
                                                               connectStr = connectStr+"ๆ";
                                                           }else{
                                                               connectStr = connectStr+strword.get(l);
                                                           }
                                                       }

                                                       boundary2.setText(connectStr);
                                                       int start2 = boundary2.first();

                                                       strword.clear();

                                                       for (int end = boundary2.next(); end != BreakIterator.DONE; start2 = end, end = boundary2.next()) {


                                                           strword.add(connectStr.substring(start2, end));


                                                           //Toast.makeText(MainActivity.this,input.substring(start, end) + " ",Toast.LENGTH_SHORT).show();

                                                       }

                                                       for (String s : listemo) {
                                                           for (int k = 0; k < emoshortcut.size(); k++) {
                                                               if (s.equals(emoshortcut.get(k).get("EmoticonShortcut"))) {
                                                                   String rank = emoshortcut.get(k).get("EmoticonRank");
                                                                   int countrank = Integer.parseInt(rank);
                                                                   countchexkemo = countchexkemo + countrank;
                                                                   checkifemo++;
                                                               }
                                                           }

                                                       }

                                                       for (int h = 0; h < strword.size(); h++) {
                                                           int icount = h+1;
                                                           String str2 = "";
                                                           String str3 = "";

                                                           if(icount <= strword.size()-1){
                                                               str2 = strword.get(icount);
                                                               for(int k = icount;k<=strword.size()-1;k++){
                                                                   if(str2.contains(" ")){
                                                                       str2 = strword.get(k);
                                                                   }else{
                                                                       break;
                                                                   }
                                                               }


                                                           }

                                                           int icountex = h+2;
                                                           String extrastr = "";

                                                           if(icountex <= strword.size()-1){
                                                               extrastr = strword.get(icountex);

                                                               for(int l = icountex;l<=strword.size()-1;l++){
                                                                   if(extrastr.contains(" ")){
                                                                       extrastr = strword.get(l);

                                                                   }else{
                                                                       break;
                                                                   }
                                                               }


                                                           }

                                                           String str = strword.get(h);


                                                           int counttarget = 0;

                                                           if(str.contains("ๆ")){
                                                               for(int a = 0;a<attitude.size();a++){
                                                                   String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           if(counttarget != 1){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else{
                                                                               str3 = str+"ๆ";
                                                                           }

                                                                       } else{
                                                                           str3 = str+"ๆ";
                                                                       }

                                                                   }

                                                               }

                                                               for(int a = 0;a<attitude2.size();a++){
                                                                   String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           if((counttarget != 1)){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else{
                                                                               str3 = str+"ๆ";
                                                                           }
                                                                       }else{
                                                                           str3 = str+"ๆ";
                                                                       }

                                                                   }
                                                               }

                                                               for(int a = 0;a<attitude3.size();a++){
                                                                   String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }

                                                                           if(counttarget != 1){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else {
                                                                               str3 = str+"ๆ";
                                                                           }
                                                                       }else{
                                                                           str3 = str+"ๆ";
                                                                       }


                                                                   }
                                                               }



                                                           }else{
                                                               if(str2.contains("ๆ")){
                                                                   //str3 = str2;
                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               if(counttarget != 1){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else{
                                                                                   str3 = "";
                                                                               }

                                                                           }

                                                                       }

                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               if((counttarget != 1)){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else{
                                                                                   str3 = "";
                                                                               }
                                                                           }

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }

                                                                               if(counttarget != 1){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else {
                                                                                   str3 = "";
                                                                               }
                                                                           }


                                                                       }
                                                                   }

                                                               }



                                                           }


                                                           /////////+++++++++++++++++++++++

                                                           if(str2.contains("มาก")){
                                                               if(extrastr.contains("ๆ")){
                                                                   str3 = str2+extrastr;
                                                               }else{
                                                                   str3 = "ๆ";
                                                               }



                                                           }

                                                           if(str2.contains("มากๆ")){
                                                               if(extrastr.contains("ๆ")){
                                                                   str3 = str2+extrastr;
                                                               }else{
                                                                   str3 = "ๆๆ";
                                                               }
                                                           }

                                                           ////////++++++++++++++++++++++++


                                                           // Toast.makeText(MainActivity.this,str,Toast.LENGTH_LONG).show();
                                                           for (int j = 0; j < attitude.size(); j++) {
                                                               if (str.equals(attitude.get(j).get("AttitudeWord"))) {

                                                                   String rank = attitude.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);

                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }


                                                           for (int j = 0; j < attitude2.size(); j++) {
                                                               if (str.equals(attitude2.get(j).get("AttitudeWord"))) {
                                                                   String rank = attitude2.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);


                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }

                                                           for (int j = 0; j < attitude3.size(); j++) {
                                                               if (str.equals(attitude3.get(j).get("AttitudeWord"))) {
                                                                   String rank = attitude3.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);


                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }


                                                       }



                                                   }
                                                   if(story.has("story")){
                                                       String PostStory = story.getString("story");
                                                       for(int n = 0;n<storyTimeline.size();n++){

                                                           String checkwordbyregular = storyTimeline.get(n).get("CheckinWord");
                                                           Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                           Matcher mcheck = regexcheck.matcher(PostStory);
                                                           String rank = storyTimeline.get(n).get("CheckinRank");
                                                           int countrank = Integer.parseInt(rank);

                                                           if (mcheck.find()){
                                                               count = count+countrank;
                                                               checkifword++;
                                                           }

                                                       }


                                                   }

                                                   if (checkifemo > 0 && countchexkemo > 0) {
                                                       countgrappos++;

                                                   } else if (checkifemo > 0 && countchexkemo == 0) {
                                                       countgraphneural++;

                                                   } else if (checkifemo > 0 && countchexkemo < 0) {
                                                       countgrapnege++;
                                                   } else {
                                                       if (checkifword > 0 && count > 0) {
                                                           countgrappos++;
                                                       } else if (checkifword > 0 && count == 0) {
                                                           countgraphneural++;
                                                       } else if (checkifword > 0 && count < 0) {
                                                           countgrapnege++;
                                                       } else {
                                                           countgraphnot++;
                                                       }
                                                   }


                                               } else if (m.group(0).contains(DateCheck6)) {

                                                   if (story.has("message")) {

                                                       String postMessage = story.getString("message");
                                                       Matcher m22 = regex2.matcher(postMessage);
                                                       Matcher m33 = regex3.matcher(postMessage);
                                                       Matcher m44 = regex4.matcher(postMessage);

                                                       while (m22.find()) {
                                                           listemo.add(m22.group(0));
                                                       }

                                                       while (m33.find()) {
                                                           listemo.add(m33.group(0));

                                                       }

                                                       while (m44.find()) {
                                                           listemo.add(m44.group(0));

                                                       }

                                                       //check word
                                                       Locale thaiLocale = new Locale("th");


                                                       BreakIterator boundary = BreakIterator.getWordInstance(thaiLocale);

                                                       boundary.setText(postMessage);


                                                       int start = boundary.first();
                                                       for (int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary.next()) {

                                                           strword.add(postMessage.substring(start, end));


                                                       }

                                                       BreakIterator boundary2 = BreakIterator.getWordInstance(thaiLocale);

                                                       String connectStr = "";

                                                       for(int l = 0;l<strword.size();l++){
                                                           if(strword.get(l).equals("มาก")){
                                                               connectStr = connectStr+"ๆ";
                                                           }else{
                                                               connectStr = connectStr+strword.get(l);
                                                           }
                                                       }

                                                       boundary2.setText(connectStr);
                                                       int start2 = boundary2.first();

                                                       strword.clear();

                                                       for (int end = boundary2.next(); end != BreakIterator.DONE; start2 = end, end = boundary2.next()) {


                                                           strword.add(connectStr.substring(start2, end));


                                                           //Toast.makeText(MainActivity.this,input.substring(start, end) + " ",Toast.LENGTH_SHORT).show();

                                                       }

                                                       for (String s : listemo) {
                                                           for (int k = 0; k < emoshortcut.size(); k++) {
                                                               if (s.equals(emoshortcut.get(k).get("EmoticonShortcut"))) {
                                                                   String rank = emoshortcut.get(k).get("EmoticonRank");
                                                                   int countrank = Integer.parseInt(rank);
                                                                   countchexkemo = countchexkemo + countrank;
                                                                   checkifemo++;
                                                               }
                                                           }

                                                       }

                                                       for (int h = 0; h < strword.size(); h++) {
                                                           int icount = h+1;
                                                           String str2 = "";
                                                           String str3 = "";

                                                           if(icount <= strword.size()-1){
                                                               str2 = strword.get(icount);
                                                               for(int k = icount;k<=strword.size()-1;k++){
                                                                   if(str2.contains(" ")){
                                                                       str2 = strword.get(k);
                                                                   }else{
                                                                       break;
                                                                   }
                                                               }


                                                           }

                                                           int icountex = h+2;
                                                           String extrastr = "";

                                                           if(icountex <= strword.size()-1){
                                                               extrastr = strword.get(icountex);

                                                               for(int l = icountex;l<=strword.size()-1;l++){
                                                                   if(extrastr.contains(" ")){
                                                                       extrastr = strword.get(l);

                                                                   }else{
                                                                       break;
                                                                   }
                                                               }


                                                           }

                                                           String str = strword.get(h);


                                                           int counttarget = 0;

                                                           if(str.contains("ๆ")){
                                                               for(int a = 0;a<attitude.size();a++){
                                                                   String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           if(counttarget != 1){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else{
                                                                               str3 = str+"ๆ";
                                                                           }

                                                                       } else{
                                                                           str3 = str+"ๆ";
                                                                       }

                                                                   }

                                                               }

                                                               for(int a = 0;a<attitude2.size();a++){
                                                                   String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           if((counttarget != 1)){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else{
                                                                               str3 = str+"ๆ";
                                                                           }
                                                                       }else{
                                                                           str3 = str+"ๆ";
                                                                       }

                                                                   }
                                                               }

                                                               for(int a = 0;a<attitude3.size();a++){
                                                                   String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }

                                                                           if(counttarget != 1){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else {
                                                                               str3 = str+"ๆ";
                                                                           }
                                                                       }else{
                                                                           str3 = str+"ๆ";
                                                                       }


                                                                   }
                                                               }



                                                           }else{
                                                               if(str2.contains("ๆ")){
                                                                   //str3 = str2;
                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               if(counttarget != 1){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else{
                                                                                   str3 = "";
                                                                               }

                                                                           }

                                                                       }

                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               if((counttarget != 1)){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else{
                                                                                   str3 = "";
                                                                               }
                                                                           }

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }

                                                                               if(counttarget != 1){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else {
                                                                                   str3 = "";
                                                                               }
                                                                           }


                                                                       }
                                                                   }

                                                               }



                                                           }


                                                           /////////+++++++++++++++++++++++

                                                           if(str2.contains("มาก")){
                                                               if(extrastr.contains("ๆ")){
                                                                   str3 = str2+extrastr;
                                                               }else{
                                                                   str3 = "ๆ";
                                                               }



                                                           }

                                                           if(str2.contains("มากๆ")){
                                                               if(extrastr.contains("ๆ")){
                                                                   str3 = str2+extrastr;
                                                               }else{
                                                                   str3 = "ๆๆ";
                                                               }
                                                           }

                                                           ////////++++++++++++++++++++++++


                                                           // Toast.makeText(MainActivity.this,str,Toast.LENGTH_LONG).show();
                                                           for (int j = 0; j < attitude.size(); j++) {
                                                               if (str.equals(attitude.get(j).get("AttitudeWord"))) {

                                                                   String rank = attitude.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);

                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }


                                                           for (int j = 0; j < attitude2.size(); j++) {
                                                               if (str.equals(attitude2.get(j).get("AttitudeWord"))) {
                                                                   String rank = attitude2.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);


                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }

                                                           for (int j = 0; j < attitude3.size(); j++) {
                                                               if (str.equals(attitude3.get(j).get("AttitudeWord"))) {
                                                                   String rank = attitude3.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);


                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }


                                                       }




                                                   }

                                                   if(story.has("story")){
                                                       String PostStory = story.getString("story");
                                                       for(int n = 0;n<storyTimeline.size();n++){

                                                           String checkwordbyregular = storyTimeline.get(n).get("CheckinWord");
                                                           Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                           Matcher mcheck = regexcheck.matcher(PostStory);

                                                           String rank = storyTimeline.get(n).get("CheckinRank");
                                                           int countrank = Integer.parseInt(rank);

                                                           if (mcheck.find()){
                                                               count = count+countrank;
                                                               checkifword++;
                                                           }

                                                       }


                                                   }

                                                   if (checkifemo > 0 && countchexkemo > 0) {
                                                       countgrappos++;

                                                   } else if (checkifemo > 0 && countchexkemo == 0) {
                                                       countgraphneural++;

                                                   } else if (checkifemo > 0 && countchexkemo < 0) {
                                                       countgrapnege++;
                                                   } else {
                                                       if (checkifword > 0 && count > 0) {
                                                           countgrappos++;
                                                       } else if (checkifword > 0 && count == 0) {
                                                           countgraphneural++;
                                                       } else if (checkifword > 0 && count < 0) {
                                                           countgrapnege++;
                                                       } else {
                                                           countgraphnot++;
                                                       }
                                                   }


                                               } else if (m.group(0).contains(DateCheck7)) {

                                                   if (story.has("message")) {

                                                       String postMessage = story.getString("message");
                                                       Matcher m22 = regex2.matcher(postMessage);
                                                       Matcher m33 = regex3.matcher(postMessage);
                                                       Matcher m44 = regex4.matcher(postMessage);

                                                       while (m22.find()) {
                                                           listemo.add(m22.group(0));
                                                       }

                                                       while (m33.find()) {
                                                           listemo.add(m33.group(0));

                                                       }

                                                       while (m44.find()) {
                                                           listemo.add(m44.group(0));

                                                       }

                                                       //check word
                                                       Locale thaiLocale = new Locale("th");


                                                       BreakIterator boundary = BreakIterator.getWordInstance(thaiLocale);

                                                       boundary.setText(postMessage);


                                                       int start = boundary.first();
                                                       for (int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary.next()) {

                                                           strword.add(postMessage.substring(start, end));


                                                       }
                                                       BreakIterator boundary2 = BreakIterator.getWordInstance(thaiLocale);

                                                       String connectStr = "";

                                                       for(int l = 0;l<strword.size();l++){
                                                           if(strword.get(l).equals("มาก")){
                                                               connectStr = connectStr+"ๆ";
                                                           }else{
                                                               connectStr = connectStr+strword.get(l);
                                                           }
                                                       }

                                                       boundary2.setText(connectStr);
                                                       int start2 = boundary2.first();

                                                       strword.clear();

                                                       for (int end = boundary2.next(); end != BreakIterator.DONE; start2 = end, end = boundary2.next()) {


                                                           strword.add(connectStr.substring(start2, end));


                                                           //Toast.makeText(MainActivity.this,input.substring(start, end) + " ",Toast.LENGTH_SHORT).show();

                                                       }

                                                       for (String s : listemo) {
                                                           for (int k = 0; k < emoshortcut.size(); k++) {
                                                               if (s.equals(emoshortcut.get(k).get("EmoticonShortcut"))) {
                                                                   String rank = emoshortcut.get(k).get("EmoticonRank");
                                                                   int countrank = Integer.parseInt(rank);
                                                                   countchexkemo = countchexkemo + countrank;
                                                                   checkifemo++;
                                                               }
                                                           }

                                                       }

                                                       for (int h = 0; h < strword.size(); h++) {
                                                           int icount = h+1;
                                                           String str2 = "";
                                                           String str3 = "";

                                                           if(icount <= strword.size()-1){
                                                               str2 = strword.get(icount);
                                                               for(int k = icount;k<=strword.size()-1;k++){
                                                                   if(str2.contains(" ")){
                                                                       str2 = strword.get(k);
                                                                   }else{
                                                                       break;
                                                                   }
                                                               }


                                                           }

                                                           int icountex = h+2;
                                                           String extrastr = "";

                                                           if(icountex <= strword.size()-1){
                                                               extrastr = strword.get(icountex);

                                                               for(int l = icountex;l<=strword.size()-1;l++){
                                                                   if(extrastr.contains(" ")){
                                                                       extrastr = strword.get(l);

                                                                   }else{
                                                                       break;
                                                                   }
                                                               }


                                                           }

                                                           String str = strword.get(h);


                                                           int counttarget = 0;

                                                           if(str.contains("ๆ")){
                                                               for(int a = 0;a<attitude.size();a++){
                                                                   String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           if(counttarget != 1){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else{
                                                                               str3 = str+"ๆ";
                                                                           }

                                                                       } else{
                                                                           str3 = str+"ๆ";
                                                                       }

                                                                   }

                                                               }

                                                               for(int a = 0;a<attitude2.size();a++){
                                                                   String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           if((counttarget != 1)){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else{
                                                                               str3 = str+"ๆ";
                                                                           }
                                                                       }else{
                                                                           str3 = str+"ๆ";
                                                                       }

                                                                   }
                                                               }

                                                               for(int a = 0;a<attitude3.size();a++){
                                                                   String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }

                                                                           if(counttarget != 1){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else {
                                                                               str3 = str+"ๆ";
                                                                           }
                                                                       }else{
                                                                           str3 = str+"ๆ";
                                                                       }


                                                                   }
                                                               }



                                                           }else{
                                                               if(str2.contains("ๆ")){
                                                                   //str3 = str2;
                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               if(counttarget != 1){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else{
                                                                                   str3 = "";
                                                                               }

                                                                           }

                                                                       }

                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               if((counttarget != 1)){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else{
                                                                                   str3 = "";
                                                                               }
                                                                           }

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }

                                                                               if(counttarget != 1){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else {
                                                                                   str3 = "";
                                                                               }
                                                                           }


                                                                       }
                                                                   }

                                                               }



                                                           }


                                                           /////////+++++++++++++++++++++++

                                                           if(str2.contains("มาก")){
                                                               if(extrastr.contains("ๆ")){
                                                                   str3 = str2+extrastr;
                                                               }else{
                                                                   str3 = "ๆ";
                                                               }



                                                           }

                                                           if(str2.contains("มากๆ")){
                                                               if(extrastr.contains("ๆ")){
                                                                   str3 = str2+extrastr;
                                                               }else{
                                                                   str3 = "ๆๆ";
                                                               }
                                                           }

                                                           ////////++++++++++++++++++++++++


                                                           // Toast.makeText(MainActivity.this,str,Toast.LENGTH_LONG).show();
                                                           for (int j = 0; j < attitude.size(); j++) {
                                                               if (str.equals(attitude.get(j).get("AttitudeWord"))) {

                                                                   String rank = attitude.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);

                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }


                                                           for (int j = 0; j < attitude2.size(); j++) {
                                                               if (str.equals(attitude2.get(j).get("AttitudeWord"))) {
                                                                   String rank = attitude2.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);


                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }

                                                           for (int j = 0; j < attitude3.size(); j++) {
                                                               if (str.equals(attitude3.get(j).get("AttitudeWord"))) {
                                                                   String rank = attitude3.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);


                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }


                                                       }




                                                   }
                                                   if(story.has("story")){
                                                       String PostStory = story.getString("story");
                                                       for(int n = 0;n<storyTimeline.size();n++){

                                                           String checkwordbyregular = storyTimeline.get(n).get("CheckinWord");
                                                           Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                           Matcher mcheck = regexcheck.matcher(PostStory);
                                                           String rank = storyTimeline.get(n).get("CheckinRank");
                                                           int countrank = Integer.parseInt(rank);

                                                           if (mcheck.find()){
                                                               count = count+countrank;
                                                               checkifword++;
                                                           }

                                                       }


                                                   }

                                                   if (checkifemo > 0 && countchexkemo > 0) {
                                                       countgrappos++;

                                                   } else if (checkifemo > 0 && countchexkemo == 0) {
                                                       countgraphneural++;

                                                   } else if (checkifemo > 0 && countchexkemo < 0) {
                                                       countgrapnege++;
                                                   } else {
                                                       if (checkifword > 0 && count > 0) {
                                                           countgrappos++;
                                                       } else if (checkifword > 0 && count == 0) {
                                                           countgraphneural++;
                                                       } else if (checkifword > 0 && count < 0) {
                                                           countgrapnege++;
                                                       } else {
                                                           countgraphnot++;
                                                       }
                                                   }


                                               }
                                           }

                                       }


                                   }

                                   TextView textView = (TextView)findViewById(R.id.textV);
                                   textView.setText("สรุปทัศนคติโดยรวมใน 1 สัปดาห์"+"("+DateCheck1+ " ถึง "+DateCheck7+")");

                                   ArrayList<String> nameCount = new ArrayList<>();
                                   ArrayList<Integer> numberCount = new ArrayList<>();
                                   nameCount.clear();
                                   numberCount.clear();


                                   if(countgrappos>0){
                                       numberCount.add(countgrappos);
                                       nameCount.add("ทัศนคติเชิงบวก");
                                   }
                                   if(countgrapnege>0){
                                       numberCount.add(countgrapnege);
                                       nameCount.add("ทัศนคติเชิงลบ");

                                   }
                                   if(countgraphneural>0){
                                       numberCount.add(countgraphneural);
                                       nameCount.add("ทัศนคติเป็นกลาง");

                                   }
                                   if(countgraphnot>0){
                                       numberCount.add(countgraphnot);
                                       nameCount.add("ไม่แสดงออกถึงทัศนคติเลย");

                                   }



                                   List<PieEntry> pieEntries = new ArrayList<>();
                                   for (int i = 0; i < numberCount.size(); i++) {
                                       pieEntries.add(new PieEntry(numberCount.get(i), nameCount.get(i)));

                                   }


                                   PieDataSet pieDataSet = new PieDataSet(pieEntries, " ");
                                   ArrayList<Integer> colors = new ArrayList<>();

                                   if(countgrappos>0){
                                       colors.add(Color.rgb(0, 143, 0));
                                   }
                                   if(countgrapnege>0){
                                       colors.add(Color.rgb(200, 0, 0));
                                   }
                                   if(countgraphneural>0){
                                       colors.add(Color.rgb(255, 192, 0));
                                   }
                                   if(countgraphnot>0){
                                       colors.add(Color.rgb(127,127,127));
                                   }




                                   pieDataSet.setColors(colors);
                                   PieData pieData = new PieData(pieDataSet);





                                   PieChart pieChart = (PieChart) findViewById(R.id.chart);
                                   pieChart.setData(pieData);
                                   pieChart.setHoleRadius(25f);
                                   pieChart.setTransparentCircleAlpha(0);
                                   pieChart.animateY(1000);
                                   pieChart.invalidate();

                               }


                           } catch (Exception e) {
                               Log.d("JSON", "error" + e.toString());
                           }

                       }
                   }
           );
           Bundle parameters = new Bundle();
           parameters.putString("fields", "created_time,message,story");
           request.setParameters(parameters);
           request.executeAsync();

       } else {


           Calendar c = Calendar.getInstance();
           Calendar c2 = Calendar.getInstance();
           Calendar c3 = Calendar.getInstance();
           Calendar c4 = Calendar.getInstance();
           Calendar c5 = Calendar.getInstance();
           Calendar c6 = Calendar.getInstance();
           Calendar c7 = Calendar.getInstance();
           Calendar c8 = Calendar.getInstance();

           c.add(Calendar.DATE, 0);
           c2.add(Calendar.DATE, +1);
           c3.add(Calendar.DATE, +2);
           c4.add(Calendar.DATE, +3);
           c5.add(Calendar.DATE, +4);
           c6.add(Calendar.DATE, +5);
           c7.add(Calendar.DATE, +6);
           c8.add(Calendar.DATE, +7);


           df = new SimpleDateFormat("yyyy-MM-dd");
           df2 = new SimpleDateFormat("yyyy-MM-dd");
           df3 = new SimpleDateFormat("yyyy-MM-dd");
           df4 = new SimpleDateFormat("yyyy-MM-dd");
           df5 = new SimpleDateFormat("yyyy-MM-dd");
           df6 = new SimpleDateFormat("yyyy-MM-dd");
           df7 = new SimpleDateFormat("yyyy-MM-dd");
           df8 = new SimpleDateFormat("yyyy-MM-dd");

           formattedDate = df.format(c.getTime());
           formattedDate2 = df2.format(c2.getTime());
           formattedDate3 = df3.format(c3.getTime());
           formattedDate4 = df4.format(c4.getTime());
           formattedDate5 = df5.format(c5.getTime());
           formattedDate6 = df6.format(c6.getTime());
           formattedDate7 = df7.format(c7.getTime());
           formattedDate8 = df8.format(c8.getTime());

           SharedPreferences idK = getSharedPreferences("IDKey", Context.MODE_PRIVATE);
           String idkey = idK.getString("IDKey", "");
           databaseForSummary.updateDataSum(idkey,formattedDate ,formattedDate2 ,formattedDate3,formattedDate4,formattedDate5,formattedDate6,formattedDate7,formattedDate8);

           final String DateCheck11 = getIDFB.get(idFB).get("Date1");
           final String DateCheck22 = getIDFB.get(idFB).get("Date2");
           final String DateCheck33 = getIDFB.get(idFB).get("Date3");
           final String DateCheck44 = getIDFB.get(idFB).get("Date4");
           final String DateCheck55 = getIDFB.get(idFB).get("Date5");
           final String DateCheck66 = getIDFB.get(idFB).get("Date6");
           final String DateCheck77 = getIDFB.get(idFB).get("Date7");
           final String DateCheck88 = getIDFB.get(idFB).get("Date8");

//           Date1 = databaseRealtime.updateData("1", formattedDate);
//           Date2 = databaseRealtime.updateData("2", formattedDate2);
//           Date3 = databaseRealtime.updateData("3", formattedDate3);
//           Date4 = databaseRealtime.updateData("4", formattedDate4);
//           Date5 = databaseRealtime.updateData("5", formattedDate5);
//           Date6 = databaseRealtime.updateData("6", formattedDate6);
//           Date7 = databaseRealtime.updateData("7", formattedDate7);
//           Date8 = databaseRealtime.updateData("8", formattedDate8);
//
//           final String datecheck11 = datetime.get(0).get("Date");
//           final String datecheck22 = datetime.get(1).get("Date");
//           final String datecheck33 = datetime.get(2).get("Date");
//           final String datecheck44 = datetime.get(3).get("Date");
//           final String datecheck55 = datetime.get(4).get("Date");
//           final String datecheck66 = datetime.get(5).get("Date");
//           final String datecheck77 = datetime.get(6).get("Date");
//           final String datecheck88 = datetime.get(7).get("Date");

           GraphRequest request = new GraphRequest(
                   AccessToken.getCurrentAccessToken(),
                   "/me/feed?limit=500",
                   null,
                   HttpMethod.GET,
                   new GraphRequest.Callback() {
                       public void onCompleted(GraphResponse response) {

                           // JSON GETS THE DATA
                           JSONObject jsonData = response.getJSONObject();

                           try {

                               JSONArray postsData = jsonData.getJSONArray("data");
                               if (postsData != null) {

                                   int countgrappos = 0;
                                   int countgrapnege = 0;
                                   int countgraphneural = 0;
                                   int countgraphnot = 0;

                                   for (int i = 0; i < postsData.length(); i++) {
                                       strword.clear();
                                       emo.clear();
                                       listemo.clear();


                                       int countchexkemo = 0;
                                       int count = 0;
                                       int checkifemo = 0;
                                       int checkifword = 0;

                                       JSONObject story = postsData.getJSONObject(i);

                                       if (story.has("created_time")) {
                                           String timeMessage = story.getString("created_time");
                                           //allPostsMessages.add(timeMessage);
                                           Matcher m = regex.matcher(timeMessage);
                                           if (m.find()) {
                                               //allPostsMessages.add(m.group(0));

                                               if (m.group(0).contains(DateCheck11)) {
                                                   if (story.has("message")) {

                                                       String postMessage = story.getString("message");
                                                       Matcher m22 = regex2.matcher(postMessage);
                                                       Matcher m33 = regex3.matcher(postMessage);
                                                       Matcher m44 = regex4.matcher(postMessage);

                                                       while (m22.find()) {
                                                           listemo.add(m22.group(0));
                                                       }

                                                       while (m33.find()) {
                                                           listemo.add(m33.group(0));

                                                       }

                                                       while (m44.find()) {
                                                           listemo.add(m44.group(0));

                                                       }

                                                       //check word
                                                       Locale thaiLocale = new Locale("th");


                                                       BreakIterator boundary = BreakIterator.getWordInstance(thaiLocale);

                                                       boundary.setText(postMessage);


                                                       int start = boundary.first();
                                                       for (int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary.next()) {

                                                           strword.add(postMessage.substring(start, end));


                                                       }

                                                       BreakIterator boundary2 = BreakIterator.getWordInstance(thaiLocale);

                                                       String connectStr = "";

                                                       for(int l = 0;l<strword.size();l++){
                                                           if(strword.get(l).equals("มาก")){
                                                               connectStr = connectStr+"ๆ";
                                                           }else{
                                                               connectStr = connectStr+strword.get(l);
                                                           }
                                                       }

                                                       boundary2.setText(connectStr);
                                                       int start2 = boundary2.first();

                                                       strword.clear();

                                                       for (int end = boundary2.next(); end != BreakIterator.DONE; start2 = end, end = boundary2.next()) {


                                                           strword.add(connectStr.substring(start2, end));


                                                           //Toast.makeText(MainActivity.this,input.substring(start, end) + " ",Toast.LENGTH_SHORT).show();

                                                       }

                                                       for (String s : listemo) {
                                                           for (int k = 0; k < emoshortcut.size(); k++) {
                                                               if (s.equals(emoshortcut.get(k).get("EmoticonShortcut"))) {
                                                                   String rank = emoshortcut.get(k).get("EmoticonRank");
                                                                   int countrank = Integer.parseInt(rank);
                                                                   countchexkemo = countchexkemo + countrank;
                                                                   checkifemo++;
                                                               }
                                                           }

                                                       }

                                                       for (int h = 0; h < strword.size(); h++) {
                                                           int icount = h+1;
                                                           String str2 = "";
                                                           String str3 = "";

                                                           if(icount <= strword.size()-1){
                                                               str2 = strword.get(icount);
                                                               for(int k = icount;k<=strword.size()-1;k++){
                                                                   if(str2.contains(" ")){
                                                                       str2 = strword.get(k);
                                                                   }else{
                                                                       break;
                                                                   }
                                                               }


                                                           }

                                                           int icountex = h+2;
                                                           String extrastr = "";

                                                           if(icountex <= strword.size()-1){
                                                               extrastr = strword.get(icountex);

                                                               for(int l = icountex;l<=strword.size()-1;l++){
                                                                   if(extrastr.contains(" ")){
                                                                       extrastr = strword.get(l);

                                                                   }else{
                                                                       break;
                                                                   }
                                                               }


                                                           }

                                                           String str = strword.get(h);


                                                           int counttarget = 0;

                                                           if(str.contains("ๆ")){
                                                               for(int a = 0;a<attitude.size();a++){
                                                                   String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           if(counttarget != 1){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else{
                                                                               str3 = str+"ๆ";
                                                                           }

                                                                       } else{
                                                                           str3 = str+"ๆ";
                                                                       }

                                                                   }

                                                               }

                                                               for(int a = 0;a<attitude2.size();a++){
                                                                   String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           if((counttarget != 1)){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else{
                                                                               str3 = str+"ๆ";
                                                                           }
                                                                       }else{
                                                                           str3 = str+"ๆ";
                                                                       }

                                                                   }
                                                               }

                                                               for(int a = 0;a<attitude3.size();a++){
                                                                   String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }

                                                                           if(counttarget != 1){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else {
                                                                               str3 = str+"ๆ";
                                                                           }
                                                                       }else{
                                                                           str3 = str+"ๆ";
                                                                       }


                                                                   }
                                                               }



                                                           }else{
                                                               if(str2.contains("ๆ")){
                                                                   //str3 = str2;
                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               if(counttarget != 1){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else{
                                                                                   str3 = "";
                                                                               }

                                                                           }

                                                                       }

                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               if((counttarget != 1)){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else{
                                                                                   str3 = "";
                                                                               }
                                                                           }

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }

                                                                               if(counttarget != 1){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else {
                                                                                   str3 = "";
                                                                               }
                                                                           }


                                                                       }
                                                                   }

                                                               }



                                                           }


                                                           /////////+++++++++++++++++++++++

                                                           if(str2.contains("มาก")){
                                                               if(extrastr.contains("ๆ")){
                                                                   str3 = str2+extrastr;
                                                               }else{
                                                                   str3 = "ๆ";
                                                               }



                                                           }

                                                           if(str2.contains("มากๆ")){
                                                               if(extrastr.contains("ๆ")){
                                                                   str3 = str2+extrastr;
                                                               }else{
                                                                   str3 = "ๆๆ";
                                                               }
                                                           }

                                                           ////////++++++++++++++++++++++++


                                                           // Toast.makeText(MainActivity.this,str,Toast.LENGTH_LONG).show();
                                                           for (int j = 0; j < attitude.size(); j++) {
                                                               if (str.equals(attitude.get(j).get("AttitudeWord"))) {

                                                                   String rank = attitude.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);

                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }


                                                           for (int j = 0; j < attitude2.size(); j++) {
                                                               if (str.equals(attitude2.get(j).get("AttitudeWord"))) {
                                                                   String rank = attitude2.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);


                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }

                                                           for (int j = 0; j < attitude3.size(); j++) {
                                                               if (str.equals(attitude3.get(j).get("AttitudeWord"))) {
                                                                   String rank = attitude3.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);


                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }


                                                       }




                                                   }

                                                   if(story.has("story")){
                                                       String PostStory = story.getString("story");
                                                       for(int n = 0;n<storyTimeline.size();n++){

                                                           String checkwordbyregular = storyTimeline.get(n).get("CheckinWord");
                                                           Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                           Matcher mcheck = regexcheck.matcher(PostStory);
                                                           String rank = storyTimeline.get(n).get("CheckinRank");
                                                           int countrank = Integer.parseInt(rank);

                                                           if (mcheck.find()){
                                                               count = count+countrank;
                                                               checkifword++;
                                                           }

                                                       }


                                                   }

                                                   if (checkifemo > 0 && countchexkemo > 0) {
                                                       countgrappos++;

                                                   } else if (checkifemo > 0 && countchexkemo == 0) {
                                                       countgraphneural++;

                                                   } else if (checkifemo > 0 && countchexkemo < 0) {
                                                       countgrapnege++;
                                                   } else {
                                                       if (checkifword > 0 && count > 0) {
                                                           countgrappos++;
                                                       } else if (checkifword > 0 && count == 0) {
                                                           countgraphneural++;
                                                       } else if (checkifword > 0 && count < 0) {
                                                           countgrapnege++;
                                                       } else {
                                                           countgraphnot++;
                                                       }
                                                   }

                                               } else if (m.group(0).contains(DateCheck22)) {

                                                   if (story.has("message")) {
                                                       String postMessage = story.getString("message");
                                                       Matcher m22 = regex2.matcher(postMessage);
                                                       Matcher m33 = regex3.matcher(postMessage);
                                                       Matcher m44 = regex4.matcher(postMessage);

                                                       while (m22.find()) {
                                                           listemo.add(m22.group(0));
                                                       }

                                                       while (m33.find()) {
                                                           listemo.add(m33.group(0));

                                                       }

                                                       while (m44.find()) {
                                                           listemo.add(m44.group(0));

                                                       }

                                                       //check word
                                                       Locale thaiLocale = new Locale("th");


                                                       BreakIterator boundary = BreakIterator.getWordInstance(thaiLocale);

                                                       boundary.setText(postMessage);


                                                       int start = boundary.first();
                                                       for (int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary.next()) {

                                                           strword.add(postMessage.substring(start, end));


                                                       }

                                                       BreakIterator boundary2 = BreakIterator.getWordInstance(thaiLocale);

                                                       String connectStr = "";

                                                       for(int l = 0;l<strword.size();l++){
                                                           if(strword.get(l).equals("มาก")){
                                                               connectStr = connectStr+"ๆ";
                                                           }else{
                                                               connectStr = connectStr+strword.get(l);
                                                           }
                                                       }

                                                       boundary2.setText(connectStr);
                                                       int start2 = boundary2.first();

                                                       strword.clear();

                                                       for (int end = boundary2.next(); end != BreakIterator.DONE; start2 = end, end = boundary2.next()) {


                                                           strword.add(connectStr.substring(start2, end));


                                                           //Toast.makeText(MainActivity.this,input.substring(start, end) + " ",Toast.LENGTH_SHORT).show();

                                                       }

                                                       for (String s : listemo) {
                                                           for (int k = 0; k < emoshortcut.size(); k++) {
                                                               if (s.equals(emoshortcut.get(k).get("EmoticonShortcut"))) {
                                                                   String rank = emoshortcut.get(k).get("EmoticonRank");
                                                                   int countrank = Integer.parseInt(rank);
                                                                   countchexkemo = countchexkemo + countrank;
                                                                   checkifemo++;
                                                               }
                                                           }

                                                       }

                                                       for (int h = 0; h < strword.size(); h++) {
                                                           int icount = h+1;
                                                           String str2 = "";
                                                           String str3 = "";

                                                           if(icount <= strword.size()-1){
                                                               str2 = strword.get(icount);
                                                               for(int k = icount;k<=strword.size()-1;k++){
                                                                   if(str2.contains(" ")){
                                                                       str2 = strword.get(k);
                                                                   }else{
                                                                       break;
                                                                   }
                                                               }


                                                           }

                                                           int icountex = h+2;
                                                           String extrastr = "";

                                                           if(icountex <= strword.size()-1){
                                                               extrastr = strword.get(icountex);

                                                               for(int l = icountex;l<=strword.size()-1;l++){
                                                                   if(extrastr.contains(" ")){
                                                                       extrastr = strword.get(l);

                                                                   }else{
                                                                       break;
                                                                   }
                                                               }


                                                           }

                                                           String str = strword.get(h);


                                                           int counttarget = 0;

                                                           if(str.contains("ๆ")){
                                                               for(int a = 0;a<attitude.size();a++){
                                                                   String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           if(counttarget != 1){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else{
                                                                               str3 = str+"ๆ";
                                                                           }

                                                                       } else{
                                                                           str3 = str+"ๆ";
                                                                       }

                                                                   }

                                                               }

                                                               for(int a = 0;a<attitude2.size();a++){
                                                                   String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           if((counttarget != 1)){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else{
                                                                               str3 = str+"ๆ";
                                                                           }
                                                                       }else{
                                                                           str3 = str+"ๆ";
                                                                       }

                                                                   }
                                                               }

                                                               for(int a = 0;a<attitude3.size();a++){
                                                                   String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }

                                                                           if(counttarget != 1){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else {
                                                                               str3 = str+"ๆ";
                                                                           }
                                                                       }else{
                                                                           str3 = str+"ๆ";
                                                                       }


                                                                   }
                                                               }



                                                           }else{
                                                               if(str2.contains("ๆ")){
                                                                   //str3 = str2;
                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               if(counttarget != 1){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else{
                                                                                   str3 = "";
                                                                               }

                                                                           }

                                                                       }

                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               if((counttarget != 1)){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else{
                                                                                   str3 = "";
                                                                               }
                                                                           }

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }

                                                                               if(counttarget != 1){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else {
                                                                                   str3 = "";
                                                                               }
                                                                           }


                                                                       }
                                                                   }

                                                               }



                                                           }


                                                           /////////+++++++++++++++++++++++

                                                           if(str2.contains("มาก")){
                                                               if(extrastr.contains("ๆ")){
                                                                   str3 = str2+extrastr;
                                                               }else{
                                                                   str3 = "ๆ";
                                                               }



                                                           }

                                                           if(str2.contains("มากๆ")){
                                                               if(extrastr.contains("ๆ")){
                                                                   str3 = str2+extrastr;
                                                               }else{
                                                                   str3 = "ๆๆ";
                                                               }
                                                           }

                                                           ////////++++++++++++++++++++++++


                                                           // Toast.makeText(MainActivity.this,str,Toast.LENGTH_LONG).show();
                                                           for (int j = 0; j < attitude.size(); j++) {
                                                               if (str.equals(attitude.get(j).get("AttitudeWord"))) {

                                                                   String rank = attitude.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);

                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }


                                                           for (int j = 0; j < attitude2.size(); j++) {
                                                               if (str.equals(attitude2.get(j).get("AttitudeWord"))) {
                                                                   String rank = attitude2.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);


                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }

                                                           for (int j = 0; j < attitude3.size(); j++) {
                                                               if (str.equals(attitude3.get(j).get("AttitudeWord"))) {
                                                                   String rank = attitude3.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);


                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }


                                                       }


                                                   }
                                                   if(story.has("story")){
                                                       String PostStory = story.getString("story");
                                                       for(int n = 0;n<storyTimeline.size();n++){

                                                           String checkwordbyregular = storyTimeline.get(n).get("CheckinWord");
                                                           Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                           Matcher mcheck = regexcheck.matcher(PostStory);
                                                           String rank = storyTimeline.get(n).get("CheckinRank");
                                                           int countrank = Integer.parseInt(rank);

                                                           if (mcheck.find()){
                                                               count = count+countrank;
                                                               checkifword++;
                                                           }

                                                       }


                                                   }

                                                   if (checkifemo > 0 && countchexkemo > 0) {
                                                       countgrappos++;

                                                   } else if (checkifemo > 0 && countchexkemo == 0) {
                                                       countgraphneural++;

                                                   } else if (checkifemo > 0 && countchexkemo < 0) {
                                                       countgrapnege++;
                                                   } else {
                                                       if (checkifword > 0 && count > 0) {
                                                           countgrappos++;
                                                       } else if (checkifword > 0 && count == 0) {
                                                           countgraphneural++;
                                                       } else if (checkifword > 0 && count < 0) {
                                                           countgrapnege++;
                                                       } else {
                                                           countgraphnot++;
                                                       }
                                                   }


                                               } else if (m.group(0).contains(DateCheck33)) {

                                                   if (story.has("message")) {

                                                       String postMessage = story.getString("message");
                                                       Matcher m22 = regex2.matcher(postMessage);
                                                       Matcher m33 = regex3.matcher(postMessage);
                                                       Matcher m44 = regex4.matcher(postMessage);

                                                       while (m22.find()) {
                                                           listemo.add(m22.group(0));
                                                       }

                                                       while (m33.find()) {
                                                           listemo.add(m33.group(0));

                                                       }

                                                       while (m44.find()) {
                                                           listemo.add(m44.group(0));

                                                       }

                                                       //check word
                                                       Locale thaiLocale = new Locale("th");


                                                       BreakIterator boundary = BreakIterator.getWordInstance(thaiLocale);

                                                       boundary.setText(postMessage);


                                                       int start = boundary.first();
                                                       for (int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary.next()) {

                                                           strword.add(postMessage.substring(start, end));


                                                       }

                                                       BreakIterator boundary2 = BreakIterator.getWordInstance(thaiLocale);

                                                       String connectStr = "";

                                                       for(int l = 0;l<strword.size();l++){
                                                           if(strword.get(l).equals("มาก")){
                                                               connectStr = connectStr+"ๆ";
                                                           }else{
                                                               connectStr = connectStr+strword.get(l);
                                                           }
                                                       }

                                                       boundary2.setText(connectStr);
                                                       int start2 = boundary2.first();

                                                       strword.clear();

                                                       for (int end = boundary2.next(); end != BreakIterator.DONE; start2 = end, end = boundary2.next()) {


                                                           strword.add(connectStr.substring(start2, end));


                                                           //Toast.makeText(MainActivity.this,input.substring(start, end) + " ",Toast.LENGTH_SHORT).show();

                                                       }

                                                       for (String s : listemo) {
                                                           for (int k = 0; k < emoshortcut.size(); k++) {
                                                               if (s.equals(emoshortcut.get(k).get("EmoticonShortcut"))) {
                                                                   String rank = emoshortcut.get(k).get("EmoticonRank");
                                                                   int countrank = Integer.parseInt(rank);
                                                                   countchexkemo = countchexkemo + countrank;
                                                                   checkifemo++;
                                                               }
                                                           }

                                                       }

                                                       for (int h = 0; h < strword.size(); h++) {
                                                           int icount = h+1;
                                                           String str2 = "";
                                                           String str3 = "";

                                                           if(icount <= strword.size()-1){
                                                               str2 = strword.get(icount);
                                                               for(int k = icount;k<=strword.size()-1;k++){
                                                                   if(str2.contains(" ")){
                                                                       str2 = strword.get(k);
                                                                   }else{
                                                                       break;
                                                                   }
                                                               }


                                                           }

                                                           int icountex = h+2;
                                                           String extrastr = "";

                                                           if(icountex <= strword.size()-1){
                                                               extrastr = strword.get(icountex);

                                                               for(int l = icountex;l<=strword.size()-1;l++){
                                                                   if(extrastr.contains(" ")){
                                                                       extrastr = strword.get(l);

                                                                   }else{
                                                                       break;
                                                                   }
                                                               }


                                                           }

                                                           String str = strword.get(h);


                                                           int counttarget = 0;

                                                           if(str.contains("ๆ")){
                                                               for(int a = 0;a<attitude.size();a++){
                                                                   String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           if(counttarget != 1){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else{
                                                                               str3 = str+"ๆ";
                                                                           }

                                                                       } else{
                                                                           str3 = str+"ๆ";
                                                                       }

                                                                   }

                                                               }

                                                               for(int a = 0;a<attitude2.size();a++){
                                                                   String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           if((counttarget != 1)){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else{
                                                                               str3 = str+"ๆ";
                                                                           }
                                                                       }else{
                                                                           str3 = str+"ๆ";
                                                                       }

                                                                   }
                                                               }

                                                               for(int a = 0;a<attitude3.size();a++){
                                                                   String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }

                                                                           if(counttarget != 1){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else {
                                                                               str3 = str+"ๆ";
                                                                           }
                                                                       }else{
                                                                           str3 = str+"ๆ";
                                                                       }


                                                                   }
                                                               }



                                                           }else{
                                                               if(str2.contains("ๆ")){
                                                                   //str3 = str2;
                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               if(counttarget != 1){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else{
                                                                                   str3 = "";
                                                                               }

                                                                           }

                                                                       }

                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               if((counttarget != 1)){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else{
                                                                                   str3 = "";
                                                                               }
                                                                           }

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }

                                                                               if(counttarget != 1){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else {
                                                                                   str3 = "";
                                                                               }
                                                                           }


                                                                       }
                                                                   }

                                                               }



                                                           }


                                                           /////////+++++++++++++++++++++++

                                                           if(str2.contains("มาก")){
                                                               if(extrastr.contains("ๆ")){
                                                                   str3 = str2+extrastr;
                                                               }else{
                                                                   str3 = "ๆ";
                                                               }



                                                           }

                                                           if(str2.contains("มากๆ")){
                                                               if(extrastr.contains("ๆ")){
                                                                   str3 = str2+extrastr;
                                                               }else{
                                                                   str3 = "ๆๆ";
                                                               }
                                                           }

                                                           ////////++++++++++++++++++++++++


                                                           // Toast.makeText(MainActivity.this,str,Toast.LENGTH_LONG).show();
                                                           for (int j = 0; j < attitude.size(); j++) {
                                                               if (str.equals(attitude.get(j).get("AttitudeWord"))) {

                                                                   String rank = attitude.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);

                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }


                                                           for (int j = 0; j < attitude2.size(); j++) {
                                                               if (str.equals(attitude2.get(j).get("AttitudeWord"))) {
                                                                   String rank = attitude2.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);


                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }

                                                           for (int j = 0; j < attitude3.size(); j++) {
                                                               if (str.equals(attitude3.get(j).get("AttitudeWord"))) {
                                                                   String rank = attitude3.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);


                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }


                                                       }




                                                   }

                                                   if(story.has("story")){
                                                       String PostStory = story.getString("story");
                                                       for(int n = 0;n<storyTimeline.size();n++){

                                                           String checkwordbyregular = storyTimeline.get(n).get("CheckinWord");
                                                           Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                           Matcher mcheck = regexcheck.matcher(PostStory);
                                                           String rank = storyTimeline.get(n).get("CheckinRank");
                                                           int countrank = Integer.parseInt(rank);

                                                           if (mcheck.find()){
                                                               count = count+countrank;
                                                               checkifword++;
                                                           }

                                                       }


                                                   }

                                                   if (checkifemo > 0 && countchexkemo > 0) {
                                                       countgrappos++;

                                                   } else if (checkifemo > 0 && countchexkemo == 0) {
                                                       countgraphneural++;

                                                   } else if (checkifemo > 0 && countchexkemo < 0) {
                                                       countgrapnege++;
                                                   } else {
                                                       if (checkifword > 0 && count > 0) {
                                                           countgrappos++;
                                                       } else if (checkifword > 0 && count == 0) {
                                                           countgraphneural++;
                                                       } else if (checkifword > 0 && count < 0) {
                                                           countgrapnege++;
                                                       } else {
                                                           countgraphnot++;
                                                       }
                                                   }

                                               } else if (m.group(0).contains(DateCheck44)) {

                                                   if (story.has("message")) {

                                                       String postMessage = story.getString("message");
                                                       Matcher m22 = regex2.matcher(postMessage);
                                                       Matcher m33 = regex3.matcher(postMessage);
                                                       Matcher m44 = regex4.matcher(postMessage);

                                                       while (m22.find()) {
                                                           listemo.add(m22.group(0));
                                                       }

                                                       while (m33.find()) {
                                                           listemo.add(m33.group(0));

                                                       }

                                                       while (m44.find()) {
                                                           listemo.add(m44.group(0));

                                                       }

                                                       //check word
                                                       Locale thaiLocale = new Locale("th");


                                                       BreakIterator boundary = BreakIterator.getWordInstance(thaiLocale);

                                                       boundary.setText(postMessage);


                                                       int start = boundary.first();
                                                       for (int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary.next()) {

                                                           strword.add(postMessage.substring(start, end));


                                                       }

                                                       BreakIterator boundary2 = BreakIterator.getWordInstance(thaiLocale);

                                                       String connectStr = "";

                                                       for(int l = 0;l<strword.size();l++){
                                                           if(strword.get(l).equals("มาก")){
                                                               connectStr = connectStr+"ๆ";
                                                           }else{
                                                               connectStr = connectStr+strword.get(l);
                                                           }
                                                       }

                                                       boundary2.setText(connectStr);
                                                       int start2 = boundary2.first();

                                                       strword.clear();

                                                       for (int end = boundary2.next(); end != BreakIterator.DONE; start2 = end, end = boundary2.next()) {


                                                           strword.add(connectStr.substring(start2, end));


                                                           //Toast.makeText(MainActivity.this,input.substring(start, end) + " ",Toast.LENGTH_SHORT).show();

                                                       }

                                                       for (String s : listemo) {
                                                           for (int k = 0; k < emoshortcut.size(); k++) {
                                                               if (s.equals(emoshortcut.get(k).get("EmoticonShortcut"))) {
                                                                   String rank = emoshortcut.get(k).get("EmoticonRank");
                                                                   int countrank = Integer.parseInt(rank);
                                                                   countchexkemo = countchexkemo + countrank;
                                                                   checkifemo++;
                                                               }
                                                           }

                                                       }

                                                       for (int h = 0; h < strword.size(); h++) {
                                                           int icount = h+1;
                                                           String str2 = "";
                                                           String str3 = "";

                                                           if(icount <= strword.size()-1){
                                                               str2 = strword.get(icount);
                                                               for(int k = icount;k<=strword.size()-1;k++){
                                                                   if(str2.contains(" ")){
                                                                       str2 = strword.get(k);
                                                                   }else{
                                                                       break;
                                                                   }
                                                               }


                                                           }

                                                           int icountex = h+2;
                                                           String extrastr = "";

                                                           if(icountex <= strword.size()-1){
                                                               extrastr = strword.get(icountex);

                                                               for(int l = icountex;l<=strword.size()-1;l++){
                                                                   if(extrastr.contains(" ")){
                                                                       extrastr = strword.get(l);

                                                                   }else{
                                                                       break;
                                                                   }
                                                               }


                                                           }

                                                           String str = strword.get(h);


                                                           int counttarget = 0;

                                                           if(str.contains("ๆ")){
                                                               for(int a = 0;a<attitude.size();a++){
                                                                   String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           if(counttarget != 1){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else{
                                                                               str3 = str+"ๆ";
                                                                           }

                                                                       } else{
                                                                           str3 = str+"ๆ";
                                                                       }

                                                                   }

                                                               }

                                                               for(int a = 0;a<attitude2.size();a++){
                                                                   String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           if((counttarget != 1)){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else{
                                                                               str3 = str+"ๆ";
                                                                           }
                                                                       }else{
                                                                           str3 = str+"ๆ";
                                                                       }

                                                                   }
                                                               }

                                                               for(int a = 0;a<attitude3.size();a++){
                                                                   String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }

                                                                           if(counttarget != 1){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else {
                                                                               str3 = str+"ๆ";
                                                                           }
                                                                       }else{
                                                                           str3 = str+"ๆ";
                                                                       }


                                                                   }
                                                               }



                                                           }else{
                                                               if(str2.contains("ๆ")){
                                                                   //str3 = str2;
                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               if(counttarget != 1){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else{
                                                                                   str3 = "";
                                                                               }

                                                                           }

                                                                       }

                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               if((counttarget != 1)){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else{
                                                                                   str3 = "";
                                                                               }
                                                                           }

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }

                                                                               if(counttarget != 1){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else {
                                                                                   str3 = "";
                                                                               }
                                                                           }


                                                                       }
                                                                   }

                                                               }



                                                           }


                                                           /////////+++++++++++++++++++++++

                                                           if(str2.contains("มาก")){
                                                               if(extrastr.contains("ๆ")){
                                                                   str3 = str2+extrastr;
                                                               }else{
                                                                   str3 = "ๆ";
                                                               }



                                                           }

                                                           if(str2.contains("มากๆ")){
                                                               if(extrastr.contains("ๆ")){
                                                                   str3 = str2+extrastr;
                                                               }else{
                                                                   str3 = "ๆๆ";
                                                               }
                                                           }

                                                           ////////++++++++++++++++++++++++


                                                           // Toast.makeText(MainActivity.this,str,Toast.LENGTH_LONG).show();
                                                           for (int j = 0; j < attitude.size(); j++) {
                                                               if (str.equals(attitude.get(j).get("AttitudeWord"))) {

                                                                   String rank = attitude.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);

                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }


                                                           for (int j = 0; j < attitude2.size(); j++) {
                                                               if (str.equals(attitude2.get(j).get("AttitudeWord"))) {
                                                                   String rank = attitude2.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);


                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }

                                                           for (int j = 0; j < attitude3.size(); j++) {
                                                               if (str.equals(attitude3.get(j).get("AttitudeWord"))) {
                                                                   String rank = attitude3.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);


                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }


                                                       }



                                                   }

                                                   if(story.has("story")){
                                                       String PostStory = story.getString("story");
                                                       for(int n = 0;n<storyTimeline.size();n++){

                                                           String checkwordbyregular = storyTimeline.get(n).get("CheckinWord");
                                                           Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                           Matcher mcheck = regexcheck.matcher(PostStory);
                                                           String rank = storyTimeline.get(n).get("CheckinRank");
                                                           int countrank = Integer.parseInt(rank);

                                                           if (mcheck.find()){
                                                               count = count+countrank;
                                                               checkifword++;
                                                           }

                                                       }


                                                   }

                                                   if (checkifemo > 0 && countchexkemo > 0) {
                                                       countgrappos++;

                                                   } else if (checkifemo > 0 && countchexkemo == 0) {
                                                       countgraphneural++;

                                                   } else if (checkifemo > 0 && countchexkemo < 0) {
                                                       countgrapnege++;
                                                   } else {
                                                       if (checkifword > 0 && count > 0) {
                                                           countgrappos++;
                                                       } else if (checkifword > 0 && count == 0) {
                                                           countgraphneural++;
                                                       } else if (checkifword > 0 && count < 0) {
                                                           countgrapnege++;
                                                       } else {
                                                           countgraphnot++;
                                                       }
                                                   }


                                               } else if (m.group(0).contains(DateCheck55)) {

                                                   if (story.has("message")) {

                                                       String postMessage = story.getString("message");
                                                       Matcher m22 = regex2.matcher(postMessage);
                                                       Matcher m33 = regex3.matcher(postMessage);
                                                       Matcher m44 = regex4.matcher(postMessage);

                                                       while (m22.find()) {
                                                           listemo.add(m22.group(0));
                                                       }

                                                       while (m33.find()) {
                                                           listemo.add(m33.group(0));

                                                       }

                                                       while (m44.find()) {
                                                           listemo.add(m44.group(0));

                                                       }

                                                       //check word
                                                       Locale thaiLocale = new Locale("th");


                                                       BreakIterator boundary = BreakIterator.getWordInstance(thaiLocale);

                                                       boundary.setText(postMessage);


                                                       int start = boundary.first();
                                                       for (int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary.next()) {

                                                           strword.add(postMessage.substring(start, end));


                                                       }

                                                       BreakIterator boundary2 = BreakIterator.getWordInstance(thaiLocale);

                                                       String connectStr = "";

                                                       for(int l = 0;l<strword.size();l++){
                                                           if(strword.get(l).equals("มาก")){
                                                               connectStr = connectStr+"ๆ";
                                                           }else{
                                                               connectStr = connectStr+strword.get(l);
                                                           }
                                                       }

                                                       boundary2.setText(connectStr);
                                                       int start2 = boundary2.first();

                                                       strword.clear();

                                                       for (int end = boundary2.next(); end != BreakIterator.DONE; start2 = end, end = boundary2.next()) {


                                                           strword.add(connectStr.substring(start2, end));


                                                           //Toast.makeText(MainActivity.this,input.substring(start, end) + " ",Toast.LENGTH_SHORT).show();

                                                       }

                                                       for (String s : listemo) {
                                                           for (int k = 0; k < emoshortcut.size(); k++) {
                                                               if (s.equals(emoshortcut.get(k).get("EmoticonShortcut"))) {
                                                                   String rank = emoshortcut.get(k).get("EmoticonRank");
                                                                   int countrank = Integer.parseInt(rank);
                                                                   countchexkemo = countchexkemo + countrank;
                                                                   checkifemo++;
                                                               }
                                                           }

                                                       }

                                                       for (int h = 0; h < strword.size(); h++) {
                                                           int icount = h+1;
                                                           String str2 = "";
                                                           String str3 = "";

                                                           if(icount <= strword.size()-1){
                                                               str2 = strword.get(icount);
                                                               for(int k = icount;k<=strword.size()-1;k++){
                                                                   if(str2.contains(" ")){
                                                                       str2 = strword.get(k);
                                                                   }else{
                                                                       break;
                                                                   }
                                                               }


                                                           }

                                                           int icountex = h+2;
                                                           String extrastr = "";

                                                           if(icountex <= strword.size()-1){
                                                               extrastr = strword.get(icountex);

                                                               for(int l = icountex;l<=strword.size()-1;l++){
                                                                   if(extrastr.contains(" ")){
                                                                       extrastr = strword.get(l);

                                                                   }else{
                                                                       break;
                                                                   }
                                                               }


                                                           }

                                                           String str = strword.get(h);


                                                           int counttarget = 0;

                                                           if(str.contains("ๆ")){
                                                               for(int a = 0;a<attitude.size();a++){
                                                                   String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           if(counttarget != 1){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else{
                                                                               str3 = str+"ๆ";
                                                                           }

                                                                       } else{
                                                                           str3 = str+"ๆ";
                                                                       }

                                                                   }

                                                               }

                                                               for(int a = 0;a<attitude2.size();a++){
                                                                   String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           if((counttarget != 1)){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else{
                                                                               str3 = str+"ๆ";
                                                                           }
                                                                       }else{
                                                                           str3 = str+"ๆ";
                                                                       }

                                                                   }
                                                               }

                                                               for(int a = 0;a<attitude3.size();a++){
                                                                   String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }

                                                                           if(counttarget != 1){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else {
                                                                               str3 = str+"ๆ";
                                                                           }
                                                                       }else{
                                                                           str3 = str+"ๆ";
                                                                       }


                                                                   }
                                                               }



                                                           }else{
                                                               if(str2.contains("ๆ")){
                                                                   //str3 = str2;
                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               if(counttarget != 1){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else{
                                                                                   str3 = "";
                                                                               }

                                                                           }

                                                                       }

                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               if((counttarget != 1)){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else{
                                                                                   str3 = "";
                                                                               }
                                                                           }

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }

                                                                               if(counttarget != 1){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else {
                                                                                   str3 = "";
                                                                               }
                                                                           }


                                                                       }
                                                                   }

                                                               }



                                                           }


                                                           /////////+++++++++++++++++++++++

                                                           if(str2.contains("มาก")){
                                                               if(extrastr.contains("ๆ")){
                                                                   str3 = str2+extrastr;
                                                               }else{
                                                                   str3 = "ๆ";
                                                               }



                                                           }

                                                           if(str2.contains("มากๆ")){
                                                               if(extrastr.contains("ๆ")){
                                                                   str3 = str2+extrastr;
                                                               }else{
                                                                   str3 = "ๆๆ";
                                                               }
                                                           }

                                                           ////////++++++++++++++++++++++++


                                                           // Toast.makeText(MainActivity.this,str,Toast.LENGTH_LONG).show();
                                                           for (int j = 0; j < attitude.size(); j++) {
                                                               if (str.equals(attitude.get(j).get("AttitudeWord"))) {

                                                                   String rank = attitude.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);

                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }


                                                           for (int j = 0; j < attitude2.size(); j++) {
                                                               if (str.equals(attitude2.get(j).get("AttitudeWord"))) {
                                                                   String rank = attitude2.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);


                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }

                                                           for (int j = 0; j < attitude3.size(); j++) {
                                                               if (str.equals(attitude3.get(j).get("AttitudeWord"))) {
                                                                   String rank = attitude3.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);


                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }


                                                       }



                                                   }

                                                   if(story.has("story")){
                                                       String PostStory = story.getString("story");
                                                       for(int n = 0;n<storyTimeline.size();n++){

                                                           String checkwordbyregular = storyTimeline.get(n).get("CheckinWord");
                                                           Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                           Matcher mcheck = regexcheck.matcher(PostStory);
                                                           String rank = storyTimeline.get(n).get("CheckinRank");
                                                           int countrank = Integer.parseInt(rank);

                                                           if (mcheck.find()){
                                                               count = count+countrank;
                                                               checkifword++;
                                                           }

                                                       }


                                                   }

                                                   if (checkifemo > 0 && countchexkemo > 0) {
                                                       countgrappos++;

                                                   } else if (checkifemo > 0 && countchexkemo == 0) {
                                                       countgraphneural++;

                                                   } else if (checkifemo > 0 && countchexkemo < 0) {
                                                       countgrapnege++;
                                                   } else {
                                                       if (checkifword > 0 && count > 0) {
                                                           countgrappos++;
                                                       } else if (checkifword > 0 && count == 0) {
                                                           countgraphneural++;
                                                       } else if (checkifword > 0 && count < 0) {
                                                           countgrapnege++;
                                                       } else {
                                                           countgraphnot++;
                                                       }
                                                   }


                                               } else if (m.group(0).contains(DateCheck66)) {

                                                   if (story.has("message")) {

                                                       String postMessage = story.getString("message");
                                                       Matcher m22 = regex2.matcher(postMessage);
                                                       Matcher m33 = regex3.matcher(postMessage);
                                                       Matcher m44 = regex4.matcher(postMessage);

                                                       while (m22.find()) {
                                                           listemo.add(m22.group(0));
                                                       }

                                                       while (m33.find()) {
                                                           listemo.add(m33.group(0));

                                                       }

                                                       while (m44.find()) {
                                                           listemo.add(m44.group(0));

                                                       }

                                                       //check word
                                                       Locale thaiLocale = new Locale("th");


                                                       BreakIterator boundary = BreakIterator.getWordInstance(thaiLocale);

                                                       boundary.setText(postMessage);


                                                       int start = boundary.first();
                                                       for (int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary.next()) {

                                                           strword.add(postMessage.substring(start, end));


                                                       }
                                                       BreakIterator boundary2 = BreakIterator.getWordInstance(thaiLocale);

                                                       String connectStr = "";

                                                       for(int l = 0;l<strword.size();l++){
                                                           if(strword.get(l).equals("มาก")){
                                                               connectStr = connectStr+"ๆ";
                                                           }else{
                                                               connectStr = connectStr+strword.get(l);
                                                           }
                                                       }

                                                       boundary2.setText(connectStr);
                                                       int start2 = boundary2.first();

                                                       strword.clear();

                                                       for (int end = boundary2.next(); end != BreakIterator.DONE; start2 = end, end = boundary2.next()) {


                                                           strword.add(connectStr.substring(start2, end));


                                                           //Toast.makeText(MainActivity.this,input.substring(start, end) + " ",Toast.LENGTH_SHORT).show();

                                                       }

                                                       for (String s : listemo) {
                                                           for (int k = 0; k < emoshortcut.size(); k++) {
                                                               if (s.equals(emoshortcut.get(k).get("EmoticonShortcut"))) {
                                                                   String rank = emoshortcut.get(k).get("EmoticonRank");
                                                                   int countrank = Integer.parseInt(rank);
                                                                   countchexkemo = countchexkemo + countrank;
                                                                   checkifemo++;
                                                               }
                                                           }

                                                       }

                                                       for (int h = 0; h < strword.size(); h++) {
                                                           int icount = h+1;
                                                           String str2 = "";
                                                           String str3 = "";

                                                           if(icount <= strword.size()-1){
                                                               str2 = strword.get(icount);
                                                               for(int k = icount;k<=strword.size()-1;k++){
                                                                   if(str2.contains(" ")){
                                                                       str2 = strword.get(k);
                                                                   }else{
                                                                       break;
                                                                   }
                                                               }


                                                           }

                                                           int icountex = h+2;
                                                           String extrastr = "";

                                                           if(icountex <= strword.size()-1){
                                                               extrastr = strword.get(icountex);

                                                               for(int l = icountex;l<=strword.size()-1;l++){
                                                                   if(extrastr.contains(" ")){
                                                                       extrastr = strword.get(l);

                                                                   }else{
                                                                       break;
                                                                   }
                                                               }


                                                           }

                                                           String str = strword.get(h);


                                                           int counttarget = 0;

                                                           if(str.contains("ๆ")){
                                                               for(int a = 0;a<attitude.size();a++){
                                                                   String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           if(counttarget != 1){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else{
                                                                               str3 = str+"ๆ";
                                                                           }

                                                                       } else{
                                                                           str3 = str+"ๆ";
                                                                       }

                                                                   }

                                                               }

                                                               for(int a = 0;a<attitude2.size();a++){
                                                                   String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           if((counttarget != 1)){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else{
                                                                               str3 = str+"ๆ";
                                                                           }
                                                                       }else{
                                                                           str3 = str+"ๆ";
                                                                       }

                                                                   }
                                                               }

                                                               for(int a = 0;a<attitude3.size();a++){
                                                                   String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }

                                                                           if(counttarget != 1){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else {
                                                                               str3 = str+"ๆ";
                                                                           }
                                                                       }else{
                                                                           str3 = str+"ๆ";
                                                                       }


                                                                   }
                                                               }



                                                           }else{
                                                               if(str2.contains("ๆ")){
                                                                   //str3 = str2;
                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               if(counttarget != 1){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else{
                                                                                   str3 = "";
                                                                               }

                                                                           }

                                                                       }

                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               if((counttarget != 1)){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else{
                                                                                   str3 = "";
                                                                               }
                                                                           }

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }

                                                                               if(counttarget != 1){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else {
                                                                                   str3 = "";
                                                                               }
                                                                           }


                                                                       }
                                                                   }

                                                               }



                                                           }


                                                           /////////+++++++++++++++++++++++

                                                           if(str2.contains("มาก")){
                                                               if(extrastr.contains("ๆ")){
                                                                   str3 = str2+extrastr;
                                                               }else{
                                                                   str3 = "ๆ";
                                                               }



                                                           }

                                                           if(str2.contains("มากๆ")){
                                                               if(extrastr.contains("ๆ")){
                                                                   str3 = str2+extrastr;
                                                               }else{
                                                                   str3 = "ๆๆ";
                                                               }
                                                           }

                                                           ////////++++++++++++++++++++++++


                                                           // Toast.makeText(MainActivity.this,str,Toast.LENGTH_LONG).show();
                                                           for (int j = 0; j < attitude.size(); j++) {
                                                               if (str.equals(attitude.get(j).get("AttitudeWord"))) {

                                                                   String rank = attitude.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);

                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }


                                                           for (int j = 0; j < attitude2.size(); j++) {
                                                               if (str.equals(attitude2.get(j).get("AttitudeWord"))) {
                                                                   String rank = attitude2.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);


                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }

                                                           for (int j = 0; j < attitude3.size(); j++) {
                                                               if (str.equals(attitude3.get(j).get("AttitudeWord"))) {
                                                                   String rank = attitude3.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);


                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }


                                                       }



                                                   }
                                                   if(story.has("story")){
                                                       String PostStory = story.getString("story");
                                                       for(int n = 0;n<storyTimeline.size();n++){

                                                           String checkwordbyregular = storyTimeline.get(n).get("CheckinWord");
                                                           Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                           Matcher mcheck = regexcheck.matcher(PostStory);
                                                           String rank = storyTimeline.get(n).get("CheckinRank");
                                                           int countrank = Integer.parseInt(rank);

                                                           if (mcheck.find()){
                                                               count = count+countrank;
                                                               checkifword++;
                                                           }

                                                       }


                                                   }

                                                   if (checkifemo > 0 && countchexkemo > 0) {
                                                       countgrappos++;

                                                   } else if (checkifemo > 0 && countchexkemo == 0) {
                                                       countgraphneural++;

                                                   } else if (checkifemo > 0 && countchexkemo < 0) {
                                                       countgrapnege++;
                                                   } else {
                                                       if (checkifword > 0 && count > 0) {
                                                           countgrappos++;
                                                       } else if (checkifword > 0 && count == 0) {
                                                           countgraphneural++;
                                                       } else if (checkifword > 0 && count < 0) {
                                                           countgrapnege++;
                                                       } else {
                                                           countgraphnot++;
                                                       }
                                                   }



                                               } else if (m.group(0).contains(DateCheck77)) {

                                                   if (story.has("message")) {

                                                       String postMessage = story.getString("message");
                                                       Matcher m22 = regex2.matcher(postMessage);
                                                       Matcher m33 = regex3.matcher(postMessage);
                                                       Matcher m44 = regex4.matcher(postMessage);

                                                       while (m22.find()) {
                                                           listemo.add(m22.group(0));
                                                       }

                                                       while (m33.find()) {
                                                           listemo.add(m33.group(0));

                                                       }

                                                       while (m44.find()) {
                                                           listemo.add(m44.group(0));

                                                       }

                                                       //check word
                                                       Locale thaiLocale = new Locale("th");


                                                       BreakIterator boundary = BreakIterator.getWordInstance(thaiLocale);

                                                       boundary.setText(postMessage);


                                                       int start = boundary.first();
                                                       for (int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary.next()) {

                                                           strword.add(postMessage.substring(start, end));


                                                       }

                                                       BreakIterator boundary2 = BreakIterator.getWordInstance(thaiLocale);

                                                       String connectStr = "";

                                                       for(int l = 0;l<strword.size();l++){
                                                           if(strword.get(l).equals("มาก")){
                                                               connectStr = connectStr+"ๆ";
                                                           }else{
                                                               connectStr = connectStr+strword.get(l);
                                                           }
                                                       }

                                                       boundary2.setText(connectStr);
                                                       int start2 = boundary2.first();

                                                       strword.clear();

                                                       for (int end = boundary2.next(); end != BreakIterator.DONE; start2 = end, end = boundary2.next()) {


                                                           strword.add(connectStr.substring(start2, end));


                                                           //Toast.makeText(MainActivity.this,input.substring(start, end) + " ",Toast.LENGTH_SHORT).show();

                                                       }

                                                       for (String s : listemo) {
                                                           for (int k = 0; k < emoshortcut.size(); k++) {
                                                               if (s.equals(emoshortcut.get(k).get("EmoticonShortcut"))) {
                                                                   String rank = emoshortcut.get(k).get("EmoticonRank");
                                                                   int countrank = Integer.parseInt(rank);
                                                                   countchexkemo = countchexkemo + countrank;
                                                                   checkifemo++;
                                                               }
                                                           }

                                                       }

                                                       for (int h = 0; h < strword.size(); h++) {
                                                           int icount = h+1;
                                                           String str2 = "";
                                                           String str3 = "";

                                                           if(icount <= strword.size()-1){
                                                               str2 = strword.get(icount);
                                                               for(int k = icount;k<=strword.size()-1;k++){
                                                                   if(str2.contains(" ")){
                                                                       str2 = strword.get(k);
                                                                   }else{
                                                                       break;
                                                                   }
                                                               }


                                                           }

                                                           int icountex = h+2;
                                                           String extrastr = "";

                                                           if(icountex <= strword.size()-1){
                                                               extrastr = strword.get(icountex);

                                                               for(int l = icountex;l<=strword.size()-1;l++){
                                                                   if(extrastr.contains(" ")){
                                                                       extrastr = strword.get(l);

                                                                   }else{
                                                                       break;
                                                                   }
                                                               }


                                                           }

                                                           String str = strword.get(h);


                                                           int counttarget = 0;

                                                           if(str.contains("ๆ")){
                                                               for(int a = 0;a<attitude.size();a++){
                                                                   String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           if(counttarget != 1){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else{
                                                                               str3 = str+"ๆ";
                                                                           }

                                                                       } else{
                                                                           str3 = str+"ๆ";
                                                                       }

                                                                   }

                                                               }

                                                               for(int a = 0;a<attitude2.size();a++){
                                                                   String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           if((counttarget != 1)){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else{
                                                                               str3 = str+"ๆ";
                                                                           }
                                                                       }else{
                                                                           str3 = str+"ๆ";
                                                                       }

                                                                   }
                                                               }

                                                               for(int a = 0;a<attitude3.size();a++){
                                                                   String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                   Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                   Matcher mcheck = regexcheck.matcher(str);
                                                                   if(mcheck.find()){
                                                                       str = mcheck.group(0);
                                                                       if(str2.contains("ๆ")) {

                                                                           for (int b = 0; b < attitude.size(); b++) {
                                                                               String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude2.size(); b++) {
                                                                               String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }
                                                                           for (int b = 0; b < attitude3.size(); b++) {
                                                                               String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                               Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                               Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                               if (mcheck2.find()) {
                                                                                   counttarget++;
                                                                               }
                                                                           }

                                                                           if(counttarget != 1){
                                                                               str3 = str+"ๆ"+str2;

                                                                           }else {
                                                                               str3 = str+"ๆ";
                                                                           }
                                                                       }else{
                                                                           str3 = str+"ๆ";
                                                                       }


                                                                   }
                                                               }



                                                           }else{
                                                               if(str2.contains("ๆ")){
                                                                   //str3 = str2;
                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               if(counttarget != 1){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else{
                                                                                   str3 = "";
                                                                               }

                                                                           }

                                                                       }

                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               if((counttarget != 1)){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else{
                                                                                   str3 = "";
                                                                               }
                                                                           }

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                                       Matcher mcheck = regexcheck.matcher(str);
                                                                       if(mcheck.find()){
                                                                           str = mcheck.group(0);
                                                                           if(str2.contains("ๆ")) {

                                                                               for (int b = 0; b < attitude.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude2.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude2.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }
                                                                               for (int b = 0; b < attitude3.size(); b++) {
                                                                                   String checkwordbyregular2 = attitude3.get(b).get("AttitudeWord");
                                                                                   Pattern regexcheck2 = Pattern.compile(checkwordbyregular2);
                                                                                   Matcher mcheck2 = regexcheck2.matcher(str2);
                                                                                   if (mcheck2.find()) {
                                                                                       counttarget++;
                                                                                   }
                                                                               }

                                                                               if(counttarget != 1){
                                                                                   str3 = str+"ๆ"+str2;

                                                                               }else {
                                                                                   str3 = "";
                                                                               }
                                                                           }


                                                                       }
                                                                   }

                                                               }



                                                           }


                                                           /////////+++++++++++++++++++++++

                                                           if(str2.contains("มาก")){
                                                               if(extrastr.contains("ๆ")){
                                                                   str3 = str2+extrastr;
                                                               }else{
                                                                   str3 = "ๆ";
                                                               }



                                                           }

                                                           if(str2.contains("มากๆ")){
                                                               if(extrastr.contains("ๆ")){
                                                                   str3 = str2+extrastr;
                                                               }else{
                                                                   str3 = "ๆๆ";
                                                               }
                                                           }

                                                           ////////++++++++++++++++++++++++


                                                           // Toast.makeText(MainActivity.this,str,Toast.LENGTH_LONG).show();
                                                           for (int j = 0; j < attitude.size(); j++) {
                                                               if (str.equals(attitude.get(j).get("AttitudeWord"))) {

                                                                   String rank = attitude.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);

                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }


                                                           for (int j = 0; j < attitude2.size(); j++) {
                                                               if (str.equals(attitude2.get(j).get("AttitudeWord"))) {
                                                                   String rank = attitude2.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);


                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }

                                                           for (int j = 0; j < attitude3.size(); j++) {
                                                               if (str.equals(attitude3.get(j).get("AttitudeWord"))) {
                                                                   String rank = attitude3.get(j).get("AttitudeRank");
                                                                   int countrank = Integer.parseInt(rank);


                                                                   count = count + countrank;
                                                                   String frequen ="([ๆ]{1})";
                                                                   Pattern regexfre = Pattern.compile(frequen);
                                                                   Matcher mfre = regexfre.matcher(str3);

                                                                   while (mfre.find()){
                                                                       count = count + countrank;

                                                                   }
                                                                   checkifword++;
                                                                   int countextra = 0;

                                                                   for(int a = 0;a<attitude.size();a++){
                                                                       String checkwordbyregular = attitude.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }


                                                                   }

                                                                   for(int a = 0;a<attitude2.size();a++){
                                                                       String checkwordbyregular = attitude2.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude2.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);

                                                                       }
                                                                   }

                                                                   for(int a = 0;a<attitude3.size();a++){
                                                                       String checkwordbyregular = attitude3.get(a).get("AttitudeWord");
                                                                       if(checkwordbyregular.equals(str2)){
                                                                           String rankextra = attitude3.get(a).get("AttitudeRank");
                                                                           countextra =  Integer.parseInt(rankextra);


                                                                       }
                                                                   }
                                                                   if(str.equals("ไม่") && !str2.contains("ๆ")){
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == -1){
                                                                       count = count + 2;
                                                                       i++;
                                                                   }
                                                                   if(str.equals("ไม่") && countextra == 1){
                                                                       count = count - 2;
                                                                       i++;
                                                                   }


                                                               }
                                                           }


                                                       }


                                                   }
                                                   if(story.has("story")){
                                                       String PostStory = story.getString("story");
                                                       for(int n = 0;n<storyTimeline.size();n++){

                                                           String checkwordbyregular = storyTimeline.get(n).get("CheckinWord");
                                                           Pattern regexcheck = Pattern.compile(checkwordbyregular);
                                                           Matcher mcheck = regexcheck.matcher(PostStory);
                                                           String rank = storyTimeline.get(n).get("CheckinRank");
                                                           int countrank = Integer.parseInt(rank);

                                                           if (mcheck.find()){
                                                               count = count+countrank;
                                                               checkifword++;
                                                           }

                                                       }


                                                   }

                                                   if (checkifemo > 0 && countchexkemo > 0) {
                                                       countgrappos++;

                                                   } else if (checkifemo > 0 && countchexkemo == 0) {
                                                       countgraphneural++;

                                                   } else if (checkifemo > 0 && countchexkemo < 0) {
                                                       countgrapnege++;
                                                   } else {
                                                       if (checkifword > 0 && count > 0) {
                                                           countgrappos++;
                                                       } else if (checkifword > 0 && count == 0) {
                                                           countgraphneural++;
                                                       } else if (checkifword > 0 && count < 0) {
                                                           countgrapnege++;
                                                       } else {
                                                           countgraphnot++;
                                                       }
                                                   }


                                               }
                                           }
                                           //Toast.makeText(TimelineActivity.this,timeMessage,Toast.LENGTH_SHORT).show();
                                       }


                                   }

                                   TextView textView = (TextView)findViewById(R.id.textV);
                                   textView.setText("สรุปทัศนคติโดยรวมใน 1 สัปดาห์"+"("+DateCheck11+ " ถึง "+DateCheck77+")");


                                   //Toast.makeText(TimelineActivity.this,allPostsMessages.size(),Toast.LENGTH_SHORT).show();

//                                for(int i = 0;i<allPostsMessages.size();i++){
//
//                                }
                                   ArrayList<String> nameCount = new ArrayList<>();
                                   ArrayList<Integer> numberCount = new ArrayList<>();
                                   nameCount.clear();
                                   numberCount.clear();


                                   if(countgrappos>0){
                                       numberCount.add(countgrappos);
                                       nameCount.add("ทัศนคติเชิงบวก");
                                   }
                                   if(countgrapnege>0){
                                       numberCount.add(countgrapnege);
                                       nameCount.add("ทัศนคติเชิงลบ");

                                   }
                                   if(countgraphneural>0){
                                       numberCount.add(countgraphneural);
                                       nameCount.add("ทัศนคติเป็นกลาง");

                                   }
                                   if(countgraphnot>0){
                                       numberCount.add(countgraphnot);
                                       nameCount.add("ไม่แสดงออกถึงทัศนคติเลย");

                                   }



                                   List<PieEntry> pieEntries = new ArrayList<>();
                                   for (int i = 0; i < numberCount.size(); i++) {
                                       pieEntries.add(new PieEntry(numberCount.get(i), nameCount.get(i)));

                                   }


                                   PieDataSet pieDataSet = new PieDataSet(pieEntries, " ");
                                   ArrayList<Integer> colors = new ArrayList<>();

                                   if(countgrappos>0){
                                       colors.add(Color.rgb(0, 143, 0));
                                   }
                                   if(countgrapnege>0){
                                       colors.add(Color.rgb(200, 0, 0));
                                   }
                                   if(countgraphneural>0){
                                       colors.add(Color.rgb(255, 192, 0));
                                   }
                                   if(countgraphnot>0){
                                       colors.add(Color.rgb(127,127,127));
                                   }




                                   pieDataSet.setColors(colors);
                                   PieData pieData = new PieData(pieDataSet);





                                   PieChart pieChart = (PieChart) findViewById(R.id.chart);
                                   pieChart.setData(pieData);
                                   pieChart.setHoleRadius(25f);
                                   pieChart.setTransparentCircleAlpha(0);
                                   pieChart.animateY(1000);
                                   pieChart.invalidate();

                               }


                           } catch (Exception e) {
                               Log.d("JSON", "error" + e.toString());
                           }

                       }
                   }
           );
           Bundle parameters = new Bundle();
           parameters.putString("fields", "created_time,message,story");
           request.setParameters(parameters);
           request.executeAsync();


       }

        //////////////////

    }
}
