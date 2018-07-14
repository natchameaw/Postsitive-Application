package com.example.knutt.myproject;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.support.v7.app.AlertDialog;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.ProfilePictureView;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.text.BreakIterator;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
public class AccountActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private CallbackManager callbackManager;
    private ProfilePictureView profilePictureView;
    private TextView textname,textemail;
    private JSONObject reponse;
    private Button btnpost,btnemo;
    private EditText editTextpost;
    private GridLayout gridLayout;
    private ImageView emo1,emo2,emo3,emo4,emo5,emo6,emo7,emo8,emo9,emo10,emo11,emo12,emo13,emo14,emo15,emo16,emo17,emo18,emo19,emo20,emo21;
    private Database db;
    private Database2 db2;
    private Database3 db3;
    private DatabaseCheckin databaseCheckin;
    private DatabaseNotifiWord databaseNotifiWord;
    private ArrayList<String> passValue  = new ArrayList<>();


    public ArrayList<String> getpassValue(){
        return passValue;
    }







    ArrayList<String> strword = new ArrayList<>() ;
    HashSet<String> emo = new HashSet<>();
    private ArrayList<String> listemo = new ArrayList<>();
    private HashSet<String> listforemo = new HashSet<>();
    private HashSet<String> listforword = new HashSet<>();
    private HashSet<String> testword = new HashSet<>();
    private HashSet<String> testshortcut = new HashSet<>();
    private Map<String,Integer> mappingEmo = new HashMap<>();
    private ArrayList<String> arrMapping = new ArrayList<>();
    private ArrayList<String> arrFrequency = new ArrayList<>();


    /////check
    private DatabaseRealtime databaseRealtime;
    private DatabaseForSummary databaseForSummary;
    private databaserealtimeSetting1 databaserealtimeSetting1;
    private ArrayList<String> arrListWordcheck = new ArrayList<>();
    private ArrayList<String> arrListEmocheck = new ArrayList<>();

    //checkForFriend
    private DatabaseForFriends databaseForFriends;


    int countneg = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this.getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        AppEventsLogger.activateApp(this);
        setContentView(R.layout.activity_account);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        FacebookSdk.addLoggingBehavior(LoggingBehavior.REQUESTS);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btnpost = (Button)findViewById(R.id.btnpost);
        editTextpost =(EditText)findViewById(R.id.edittextpost);
        gridLayout = (GridLayout)findViewById(R.id.gridview);
        btnemo = (Button)findViewById(R.id.emoticonbtn);
        emo1  = (ImageView)findViewById(R.id.emo1);
        emo2  = (ImageView)findViewById(R.id.emo2);
        emo3  = (ImageView)findViewById(R.id.emo3);
        emo4  = (ImageView)findViewById(R.id.emo4);
        emo5  = (ImageView)findViewById(R.id.emo5);
        emo6  = (ImageView)findViewById(R.id.emo6);
        emo7  = (ImageView)findViewById(R.id.emo7);
        emo8  = (ImageView)findViewById(R.id.emo8);
        emo9  = (ImageView)findViewById(R.id.emo9);
        emo10  = (ImageView)findViewById(R.id.emo10);
        emo11 = (ImageView)findViewById(R.id.emo11);
        emo12  = (ImageView)findViewById(R.id.emo12);
        emo13  = (ImageView)findViewById(R.id.emo13);
        emo14  = (ImageView)findViewById(R.id.emo14);
        emo15  = (ImageView)findViewById(R.id.emo15);
        emo16  = (ImageView)findViewById(R.id.emo16);
        emo17  = (ImageView)findViewById(R.id.emo17);
        emo18  = (ImageView)findViewById(R.id.emo18);
        emo19  = (ImageView)findViewById(R.id.emo19);
        emo20  = (ImageView)findViewById(R.id.emo20);
        emo21  = (ImageView)findViewById(R.id.emo21);



        db= new Database(getApplicationContext());
        db.getWritableDatabase();
        db2 = new Database2(getApplicationContext());
        db2.getWritableDatabase();
        db3=new Database3(getApplicationContext());
        db3.getWritableDatabase();
        databaseCheckin = new DatabaseCheckin(getApplicationContext());
        databaseCheckin.getWritableDatabase();

        databaseRealtime = new DatabaseRealtime(getApplicationContext());
        databaseRealtime.getWritableDatabase();

        databaserealtimeSetting1 = new databaserealtimeSetting1(getApplicationContext());
        databaserealtimeSetting1.getWritableDatabase();

        databaseForFriends = new DatabaseForFriends(getApplicationContext());
        databaseForFriends.getWritableDatabase();

        databaseNotifiWord = new DatabaseNotifiWord(getApplicationContext());
        databaseNotifiWord.getWritableDatabase();

        databaseForSummary = new DatabaseForSummary(getApplicationContext());
        databaseForSummary.getWritableDatabase();

        SharedPreferences sp2 = getSharedPreferences("userid", Context.MODE_PRIVATE);
        String id = sp2.getString("userid", "");
        int countSummary = 0;



        ArrayList<HashMap<String,String>> getSummary = databaseForSummary.getSummary();
//









        SharedPreferences spradio = getSharedPreferences("App save radio", Context.MODE_PRIVATE);
        int checkboxRadio = spradio.getInt("checkedRadio",0);

        final ArrayList<HashMap<String, String>> datetimeforchecksetting1 = databaserealtimeSetting1.getDaterealtimesetting1();

        ///check time current
        Calendar checkfirst = Calendar.getInstance();
        checkfirst.add(Calendar.DATE,0);
        SimpleDateFormat cfirst = new SimpleDateFormat("yyyy-MM-dd");
        String dateforfirst = cfirst.format(checkfirst.getTime());
        int forcheck = 0;
        ///

        if(checkboxRadio == 1){
            for(int i = 0;i<datetimeforchecksetting1.size();i++){
                String key = datetimeforchecksetting1.get(i).get("Date");
                if(key.contains(dateforfirst)){
                    forcheck++;
                }

            }
            String key = datetimeforchecksetting1.get(1).get("Date");
            if(forcheck==0 || dateforfirst.contains(key)){

                Calendar c = Calendar.getInstance();
                Calendar c2 = Calendar.getInstance();


                c.add(Calendar.DATE,0);
                c2.add(Calendar.DATE,+1);



                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");


                String formattedDate = df.format(c.getTime());
                String formattedDate2 = df2.format(c2.getTime());


                boolean Date1 = databaserealtimeSetting1.updateDataSetting1("1",formattedDate);
                boolean Date2 = databaserealtimeSetting1.updateDataSetting1("2",formattedDate2);


                final String datecheck11 = datetimeforchecksetting1.get(0).get("Date");
                final String datecheck22 = datetimeforchecksetting1.get(1).get("Date");


            }
        }

        ///new future



        if(getSummary.size() == 0){
            Calendar c = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            Calendar c3 = Calendar.getInstance();
            Calendar c4 = Calendar.getInstance();
            Calendar c5 = Calendar.getInstance();
            Calendar c6 = Calendar.getInstance();
            Calendar c7 = Calendar.getInstance();
            Calendar c8 = Calendar.getInstance();

            c.add(Calendar.DATE,0);
            c2.add(Calendar.DATE,+1);
            c3.add(Calendar.DATE,+2);
            c4.add(Calendar.DATE,+3);
            c5.add(Calendar.DATE,+4);
            c6.add(Calendar.DATE,+5);
            c7.add(Calendar.DATE,+6);
            c8.add(Calendar.DATE,+7);


            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat df3 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat df4 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat df5 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat df6 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat df7 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat df8 = new SimpleDateFormat("yyyy-MM-dd");

            String formattedDate = df.format(c.getTime());
            String formattedDate2 = df2.format(c2.getTime());
            String formattedDate3 = df3.format(c3.getTime());
            String formattedDate4 = df4.format(c4.getTime());
            String formattedDate5 = df5.format(c5.getTime());
            String formattedDate6 = df6.format(c6.getTime());
            String formattedDate7 = df7.format(c7.getTime());
            String formattedDate8 = df8.format(c8.getTime());

            boolean add = databaseForSummary.insertDataSum(id,formattedDate ,formattedDate2 ,formattedDate3,formattedDate4,formattedDate5,formattedDate6,formattedDate7,formattedDate8);
        }else {
            Calendar c = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            Calendar c3 = Calendar.getInstance();
            Calendar c4 = Calendar.getInstance();
            Calendar c5 = Calendar.getInstance();
            Calendar c6 = Calendar.getInstance();
            Calendar c7 = Calendar.getInstance();
            Calendar c8 = Calendar.getInstance();

            c.add(Calendar.DATE,0);
            c2.add(Calendar.DATE,+1);
            c3.add(Calendar.DATE,+2);
            c4.add(Calendar.DATE,+3);
            c5.add(Calendar.DATE,+4);
            c6.add(Calendar.DATE,+5);
            c7.add(Calendar.DATE,+6);
            c8.add(Calendar.DATE,+7);


            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat df3 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat df4 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat df5 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat df6 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat df7 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat df8 = new SimpleDateFormat("yyyy-MM-dd");

            String formattedDate = df.format(c.getTime());
            String formattedDate2 = df2.format(c2.getTime());
            String formattedDate3 = df3.format(c3.getTime());
            String formattedDate4 = df4.format(c4.getTime());
            String formattedDate5 = df5.format(c5.getTime());
            String formattedDate6 = df6.format(c6.getTime());
            String formattedDate7 = df7.format(c7.getTime());
            String formattedDate8 = df8.format(c8.getTime());


            for (int s = 0; s < getSummary.size(); s++) {
                if(id.equals(getSummary.get(s).get("fbID")) ){
                    countSummary++;
                }
            }
            if(countSummary == 0){
                boolean add = databaseForSummary.insertDataSum(id,formattedDate ,formattedDate2 ,formattedDate3,formattedDate4,formattedDate5,formattedDate6,formattedDate7,formattedDate8);
            }
        }
        int checkIDFB = 0;
        String keyDateIDFB = "";
        String IDmaster = "";

        for(int p = 0;p<getSummary.size();p++){
            if(id.equals(getSummary.get(p).get("fbID"))){

                if(dateforfirst.contains(getSummary.get(p).get("Date1"))){
                    checkIDFB++;
                }

                if(dateforfirst.contains(getSummary.get(p).get("Date2"))){
                    checkIDFB++;
                }
                if(dateforfirst.contains(getSummary.get(p).get("Date3"))){
                    checkIDFB++;
                }
                if(dateforfirst.contains(getSummary.get(p).get("Date4"))){
                    checkIDFB++;
                }
                if(dateforfirst.contains(getSummary.get(p).get("Date5"))){
                    checkIDFB++;
                }
                if(dateforfirst.contains(getSummary.get(p).get("Date6"))){
                    checkIDFB++;
                }
                if(dateforfirst.contains(getSummary.get(p).get("Date7"))){
                    checkIDFB++;
                }
                if(dateforfirst.contains(getSummary.get(p).get("Date8"))){
                    checkIDFB++;
                }

                keyDateIDFB = getSummary.get(p).get("Date8");
                IDmaster = getSummary.get(p).get("ID");

                SharedPreferences sharedPref = getSharedPreferences("IDFB", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("IDFB", p);

                SharedPreferences sharedPref2 = getSharedPreferences("IDKey", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor2 = sharedPref2.edit();
                editor2.putString("IDKey", IDmaster);

                editor.commit();


            }
        }

        if(checkIDFB ==0 || dateforfirst.contains(keyDateIDFB)){
            Calendar c = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            Calendar c3 = Calendar.getInstance();
            Calendar c4 = Calendar.getInstance();
            Calendar c5 = Calendar.getInstance();
            Calendar c6 = Calendar.getInstance();
            Calendar c7 = Calendar.getInstance();
            Calendar c8 = Calendar.getInstance();

            c.add(Calendar.DATE,0);
            c2.add(Calendar.DATE,+1);
            c3.add(Calendar.DATE,+2);
            c4.add(Calendar.DATE,+3);
            c5.add(Calendar.DATE,+4);
            c6.add(Calendar.DATE,+5);
            c7.add(Calendar.DATE,+6);
            c8.add(Calendar.DATE,+7);


            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat df3 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat df4 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat df5 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat df6 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat df7 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat df8 = new SimpleDateFormat("yyyy-MM-dd");

            String formattedDate = df.format(c.getTime());
            String formattedDate2 = df2.format(c2.getTime());
            String formattedDate3 = df3.format(c3.getTime());
            String formattedDate4 = df4.format(c4.getTime());
            String formattedDate5 = df5.format(c5.getTime());
            String formattedDate6 = df6.format(c6.getTime());
            String formattedDate7 = df7.format(c7.getTime());
            String formattedDate8 = df8.format(c8.getTime());

            boolean change = databaseForSummary.updateDataSum(IDmaster,formattedDate ,formattedDate2 ,formattedDate3,formattedDate4,formattedDate5,formattedDate6,formattedDate7,formattedDate8);


        }

        ///new future




        final ArrayList<HashMap<String, String>> datetimeforcheck = databaseRealtime.getDaterealtime();

        for(int i = 0;i<datetimeforcheck.size();i++){
            String key = datetimeforcheck.get(i).get("Date");
            if(key.contains(dateforfirst)){
                forcheck++;
            }

        }
        String key = datetimeforcheck.get(7).get("Date");
        if(forcheck==0 || dateforfirst.contains(key)){

            Calendar c = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            Calendar c3 = Calendar.getInstance();
            Calendar c4 = Calendar.getInstance();
            Calendar c5 = Calendar.getInstance();
            Calendar c6 = Calendar.getInstance();
            Calendar c7 = Calendar.getInstance();
            Calendar c8 = Calendar.getInstance();

            c.add(Calendar.DATE,0);
            c2.add(Calendar.DATE,+1);
            c3.add(Calendar.DATE,+2);
            c4.add(Calendar.DATE,+3);
            c5.add(Calendar.DATE,+4);
            c6.add(Calendar.DATE,+5);
            c7.add(Calendar.DATE,+6);
            c8.add(Calendar.DATE,+7);


            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat df3 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat df4 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat df5 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat df6 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat df7 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat df8 = new SimpleDateFormat("yyyy-MM-dd");

            String formattedDate = df.format(c.getTime());
            String formattedDate2 = df2.format(c2.getTime());
            String formattedDate3 = df3.format(c3.getTime());
            String formattedDate4 = df4.format(c4.getTime());
            String formattedDate5 = df5.format(c5.getTime());
            String formattedDate6 = df6.format(c6.getTime());
            String formattedDate7 = df7.format(c7.getTime());
            String formattedDate8 = df8.format(c8.getTime());

            boolean Date1 = databaseRealtime.updateData("1",formattedDate);
            boolean Date2 = databaseRealtime.updateData("2",formattedDate2);
            boolean Date3 = databaseRealtime.updateData("3",formattedDate3);
            boolean Date4 = databaseRealtime.updateData("4",formattedDate4);
            boolean Date5 = databaseRealtime.updateData("5",formattedDate5);
            boolean Date6 = databaseRealtime.updateData("6",formattedDate6);
            boolean Date7 = databaseRealtime.updateData("7",formattedDate7);
            boolean Date8 = databaseRealtime.updateData("8",formattedDate8);

            final String datecheck11 = datetimeforcheck.get(0).get("Date");
            final String datecheck22 = datetimeforcheck.get(1).get("Date");
            final String datecheck33 = datetimeforcheck.get(2).get("Date");
            final String datecheck44 = datetimeforcheck.get(3).get("Date");
            final String datecheck55 = datetimeforcheck.get(4).get("Date");
            final String datecheck66 = datetimeforcheck.get(5).get("Date");
            final String datecheck77 = datetimeforcheck.get(6).get("Date");
            final String datecheck88 = datetimeforcheck.get(7).get("Date");

        }






        btnpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPostAndCheckWord();
            }
        });

        gridLayout.setVisibility(View.GONE);
        btnemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gridLayout.getVisibility() == View.GONE){
                    gridLayout.setVisibility(View.VISIBLE);
                    emo1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int EditTextCursor;

                            SpannableStringBuilder spannableStringBuilder ;



                            EditTextCursor = editTextpost.getSelectionStart();

                            editTextpost.getText().insert(EditTextCursor, "^_^");

                            EditTextCursor = editTextpost.getSelectionStart();

                            spannableStringBuilder = new SpannableStringBuilder(editTextpost.getText());


                            editTextpost.setText(spannableStringBuilder);

                            editTextpost.setSelection(EditTextCursor);

                            //editTextPost.setText("^_^");
                            gridLayout.setVisibility(View.GONE);
                        }
                    });
                    emo2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int EditTextCursor;

                            SpannableStringBuilder spannableStringBuilder ;



                            EditTextCursor = editTextpost.getSelectionStart();

                            editTextpost.getText().insert(EditTextCursor, "8-|");

                            EditTextCursor = editTextpost.getSelectionStart();

                            spannableStringBuilder = new SpannableStringBuilder(editTextpost.getText());


                            editTextpost.setText(spannableStringBuilder);

                            editTextpost.setSelection(EditTextCursor);

                            //editTextPost.setText("^_^");
                            gridLayout.setVisibility(View.GONE);
                        }
                    });

                    emo3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int EditTextCursor;

                            SpannableStringBuilder spannableStringBuilder ;



                            EditTextCursor = editTextpost.getSelectionStart();

                            editTextpost.getText().insert(EditTextCursor, ":-P");

                            EditTextCursor = editTextpost.getSelectionStart();

                            spannableStringBuilder = new SpannableStringBuilder(editTextpost.getText());


                            editTextpost.setText(spannableStringBuilder);

                            editTextpost.setSelection(EditTextCursor);

                            //editTextPost.setText("^_^");
                            gridLayout.setVisibility(View.GONE);

                        }
                    });

                    emo4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int EditTextCursor;

                            SpannableStringBuilder spannableStringBuilder ;



                            EditTextCursor = editTextpost.getSelectionStart();

                            editTextpost.getText().insert(EditTextCursor, ":-O");

                            EditTextCursor = editTextpost.getSelectionStart();

                            spannableStringBuilder = new SpannableStringBuilder(editTextpost.getText());


                            editTextpost.setText(spannableStringBuilder);

                            editTextpost.setSelection(EditTextCursor);

                            //editTextPost.setText("^_^");
                            gridLayout.setVisibility(View.GONE);

                        }
                    });
                    emo5.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int EditTextCursor;

                            SpannableStringBuilder spannableStringBuilder ;



                            EditTextCursor = editTextpost.getSelectionStart();

                            editTextpost.getText().insert(EditTextCursor, ":-D");

                            EditTextCursor = editTextpost.getSelectionStart();

                            spannableStringBuilder = new SpannableStringBuilder(editTextpost.getText());


                            editTextpost.setText(spannableStringBuilder);

                            editTextpost.setSelection(EditTextCursor);

                            //editTextPost.setText("^_^");
                            gridLayout.setVisibility(View.GONE);

                        }
                    });
                    emo6.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int EditTextCursor;

                            SpannableStringBuilder spannableStringBuilder ;



                            EditTextCursor = editTextpost.getSelectionStart();

                            editTextpost.getText().insert(EditTextCursor, "O:)");

                            EditTextCursor = editTextpost.getSelectionStart();

                            spannableStringBuilder = new SpannableStringBuilder(editTextpost.getText());


                            editTextpost.setText(spannableStringBuilder);

                            editTextpost.setSelection(EditTextCursor);

                            //editTextPost.setText("^_^");
                            gridLayout.setVisibility(View.GONE);

                        }
                    });

                    emo7.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int EditTextCursor;

                            SpannableStringBuilder spannableStringBuilder ;



                            EditTextCursor = editTextpost.getSelectionStart();

                            editTextpost.getText().insert(EditTextCursor, "3:)");

                            EditTextCursor = editTextpost.getSelectionStart();

                            spannableStringBuilder = new SpannableStringBuilder(editTextpost.getText());


                            editTextpost.setText(spannableStringBuilder);

                            editTextpost.setSelection(EditTextCursor);

                            //editTextPost.setText("^_^");
                            gridLayout.setVisibility(View.GONE);
                        }
                    });

                    emo8.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int EditTextCursor;

                            SpannableStringBuilder spannableStringBuilder ;



                            EditTextCursor = editTextpost.getSelectionStart();

                            editTextpost.getText().insert(EditTextCursor, ";-)");

                            EditTextCursor = editTextpost.getSelectionStart();

                            spannableStringBuilder = new SpannableStringBuilder(editTextpost.getText());


                            editTextpost.setText(spannableStringBuilder);

                            editTextpost.setSelection(EditTextCursor);

                            //editTextPost.setText("^_^");
                            gridLayout.setVisibility(View.GONE);

                        }
                    });

                    emo9.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int EditTextCursor;

                            SpannableStringBuilder spannableStringBuilder ;



                            EditTextCursor = editTextpost.getSelectionStart();

                            editTextpost.getText().insert(EditTextCursor, "-_-");

                            EditTextCursor = editTextpost.getSelectionStart();

                            spannableStringBuilder = new SpannableStringBuilder(editTextpost.getText());


                            editTextpost.setText(spannableStringBuilder);

                            editTextpost.setSelection(EditTextCursor);

                            //editTextPost.setText("^_^");
                            gridLayout.setVisibility(View.GONE);
                        }
                    });
                    emo10.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int EditTextCursor;

                            SpannableStringBuilder spannableStringBuilder ;



                            EditTextCursor = editTextpost.getSelectionStart();

                            editTextpost.getText().insert(EditTextCursor, ":-/");

                            EditTextCursor = editTextpost.getSelectionStart();

                            spannableStringBuilder = new SpannableStringBuilder(editTextpost.getText());


                            editTextpost.setText(spannableStringBuilder);

                            editTextpost.setSelection(EditTextCursor);

                            //editTextPost.setText("^_^");
                            gridLayout.setVisibility(View.GONE);
                        }
                    });

                    emo11.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            int EditTextCursor;

                            SpannableStringBuilder spannableStringBuilder ;



                            EditTextCursor = editTextpost.getSelectionStart();

                            editTextpost.getText().insert(EditTextCursor, ":-*");

                            EditTextCursor = editTextpost.getSelectionStart();

                            spannableStringBuilder = new SpannableStringBuilder(editTextpost.getText());


                            editTextpost.setText(spannableStringBuilder);

                            editTextpost.setSelection(EditTextCursor);

                            //editTextPost.setText("^_^");
                            gridLayout.setVisibility(View.GONE);

                        }
                    });

                    emo12.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int EditTextCursor;

                            SpannableStringBuilder spannableStringBuilder ;



                            EditTextCursor = editTextpost.getSelectionStart();

                            editTextpost.getText().insert(EditTextCursor, ">:(");

                            EditTextCursor = editTextpost.getSelectionStart();

                            spannableStringBuilder = new SpannableStringBuilder(editTextpost.getText());


                            editTextpost.setText(spannableStringBuilder);

                            editTextpost.setSelection(EditTextCursor);

                            //editTextPost.setText("^_^");
                            gridLayout.setVisibility(View.GONE);

                        }
                    });
                    emo13.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int EditTextCursor;

                            SpannableStringBuilder spannableStringBuilder ;



                            EditTextCursor = editTextpost.getSelectionStart();

                            editTextpost.getText().insert(EditTextCursor, ">:O");

                            EditTextCursor = editTextpost.getSelectionStart();

                            spannableStringBuilder = new SpannableStringBuilder(editTextpost.getText());


                            editTextpost.setText(spannableStringBuilder);

                            editTextpost.setSelection(EditTextCursor);

                            //editTextPost.setText("^_^");
                            gridLayout.setVisibility(View.GONE);

                        }
                    });

                    emo14.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int EditTextCursor;

                            SpannableStringBuilder spannableStringBuilder ;



                            EditTextCursor = editTextpost.getSelectionStart();

                            editTextpost.getText().insert(EditTextCursor, ":'(");

                            EditTextCursor = editTextpost.getSelectionStart();

                            spannableStringBuilder = new SpannableStringBuilder(editTextpost.getText());


                            editTextpost.setText(spannableStringBuilder);

                            editTextpost.setSelection(EditTextCursor);

                            //editTextPost.setText("^_^");
                            gridLayout.setVisibility(View.GONE);

                        }
                    });

                    emo15.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int EditTextCursor;

                            SpannableStringBuilder spannableStringBuilder ;



                            EditTextCursor = editTextpost.getSelectionStart();

                            editTextpost.getText().insert(EditTextCursor, "o.O");

                            EditTextCursor = editTextpost.getSelectionStart();

                            spannableStringBuilder = new SpannableStringBuilder(editTextpost.getText());


                            editTextpost.setText(spannableStringBuilder);

                            editTextpost.setSelection(EditTextCursor);

                            //editTextPost.setText("^_^");
                            gridLayout.setVisibility(View.GONE);

                        }
                    });

                    emo16.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int EditTextCursor;

                            SpannableStringBuilder spannableStringBuilder ;



                            EditTextCursor = editTextpost.getSelectionStart();

                            editTextpost.getText().insert(EditTextCursor, ":-(");

                            EditTextCursor = editTextpost.getSelectionStart();

                            spannableStringBuilder = new SpannableStringBuilder(editTextpost.getText());


                            editTextpost.setText(spannableStringBuilder);

                            editTextpost.setSelection(EditTextCursor);

                            //editTextPost.setText("^_^");
                            gridLayout.setVisibility(View.GONE);

                        }
                    });

                    emo17.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int EditTextCursor;

                            SpannableStringBuilder spannableStringBuilder ;



                            EditTextCursor = editTextpost.getSelectionStart();

                            editTextpost.getText().insert(EditTextCursor, ":-)");

                            EditTextCursor = editTextpost.getSelectionStart();

                            spannableStringBuilder = new SpannableStringBuilder(editTextpost.getText());


                            editTextpost.setText(spannableStringBuilder);

                            editTextpost.setSelection(EditTextCursor);

                            //editTextPost.setText("^_^");
                            gridLayout.setVisibility(View.GONE);

                        }
                    });

                    emo18.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int EditTextCursor;

                            SpannableStringBuilder spannableStringBuilder ;



                            EditTextCursor = editTextpost.getSelectionStart();

                            editTextpost.getText().insert(EditTextCursor, "8-)");

                            EditTextCursor = editTextpost.getSelectionStart();

                            spannableStringBuilder = new SpannableStringBuilder(editTextpost.getText());


                            editTextpost.setText(spannableStringBuilder);

                            editTextpost.setSelection(EditTextCursor);

                            //editTextPost.setText("^_^");
                            gridLayout.setVisibility(View.GONE);
                        }
                    });

                    emo19.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int EditTextCursor;

                            SpannableStringBuilder spannableStringBuilder ;



                            EditTextCursor = editTextpost.getSelectionStart();

                            editTextpost.getText().insert(EditTextCursor, "<3");

                            EditTextCursor = editTextpost.getSelectionStart();

                            spannableStringBuilder = new SpannableStringBuilder(editTextpost.getText());


                            editTextpost.setText(spannableStringBuilder);

                            editTextpost.setSelection(EditTextCursor);

                            //editTextPost.setText("^_^");
                            gridLayout.setVisibility(View.GONE);

                        }
                    });

                    emo20.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int EditTextCursor;

                            SpannableStringBuilder spannableStringBuilder ;



                            EditTextCursor = editTextpost.getSelectionStart();

                            editTextpost.getText().insert(EditTextCursor, ":3");

                            EditTextCursor = editTextpost.getSelectionStart();

                            spannableStringBuilder = new SpannableStringBuilder(editTextpost.getText());


                            editTextpost.setText(spannableStringBuilder);

                            editTextpost.setSelection(EditTextCursor);

                            //editTextPost.setText("^_^");
                            gridLayout.setVisibility(View.GONE);

                        }
                    });

                    emo21.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int EditTextCursor;

                            SpannableStringBuilder spannableStringBuilder ;



                            EditTextCursor = editTextpost.getSelectionStart();

                            editTextpost.getText().insert(EditTextCursor, ":v");

                            EditTextCursor = editTextpost.getSelectionStart();

                            spannableStringBuilder = new SpannableStringBuilder(editTextpost.getText());


                            editTextpost.setText(spannableStringBuilder);

                            editTextpost.setSelection(EditTextCursor);

                            //editTextPost.setText("^_^");
                            gridLayout.setVisibility(View.GONE);

                        }
                    });

                }else{
                    gridLayout.setVisibility(View.GONE);
                }
            }
        });







        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



//
//        GraphRequest request = GraphRequest.newMeRequest(
//                accessToken,
//                new GraphRequest.GraphJSONObjectCallback() {
//                    @Override
//                    public void onCompleted(JSONObject object, GraphResponse response) {    // JSON GETS THE DATA
//                        JSONObject jsonData = response.getJSONObject();
//
//
//                        try {
//                            Context context = null;
//
//                            JSONArray postsData = jsonData.getJSONArray("data");
//                            if (postsData != null) {
//                                SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
//                                SharedPreferences.Editor editor = sharedPref.edit();
//
//                                mSet.clear();
//
//
//
//                                for (int i = 0; i < postsData.length(); i++) {
//                                    JSONObject story = postsData.getJSONObject(i);
//
//                                    if (story.has("id")) {
//                                        String idprofile = story.getString("id");
//                                        mSet.add(idprofile);
//                                        Toast.makeText(AccountActivity.this,"ID profile "+idprofile,Toast.LENGTH_SHORT).show();
//
//
//
//
//
//
//
//                                    }
//
//
//                                }
//
//                                editor.putStringSet("addpro", mSet);
//                                editor.apply();
//
//
//
//
//
//                            }
//
//
//                        } catch (Exception e) {
//                            Log.d("JSON", "error" + e.toString());
//                        }
//
//
//                    }
//                });
//
//        Bundle parameters = new Bundle();
//        parameters.putString("fields", "id,name,friends{id,name}");
//        request.setParameters(parameters);
//        request.executeAsync();
        databaseForFriends.deleteAll();


        AccessToken fbAccessToken = AccessToken.getCurrentAccessToken();

        GraphRequest userFBFriendsGraphRequest = GraphRequest.newMyFriendsRequest(fbAccessToken, new GraphRequest.GraphJSONArrayCallback() {
            @Override
            public void onCompleted(JSONArray returnedObjArr, GraphResponse response) {

                // JSON GETS THE DATA
                JSONObject jsonData = response.getJSONObject();

                try {

                    JSONArray postsData = jsonData.getJSONArray("data");
                    if (postsData != null) {

                        for (int i = 0; i < postsData.length(); i++) {
                            JSONObject story = postsData.getJSONObject(i);

//                                    if (story.has("message")) {
//                                        String postMessage = story.getString("message");
//
//                                        allPostsMessages.add(postMessage);
//
//
//                                        //Toast.makeText(TimelineActivity.this,postMessage,Toast.LENGTH_SHORT).show();
//                                    }
                            if(story.has("id")){
                                String timeMessage = story.getString("id");
                                String Name = story.getString("name");
                                //allPostsMessages.add(timeMessage);
                                boolean addid = databaseForFriends.insertnewData(timeMessage,Name);




                            }



                        }







//                                for(int i = 0;i<allPostsMessages.size();i++){
//
//                                }


                    }


                } catch (Exception e) {
                    Log.d("JSON", "error" + e.toString());
                }

            }
        });

        Bundle requestParameter = new Bundle();
        requestParameter.putString("fields", "id, name, picture");
        userFBFriendsGraphRequest.setParameters(requestParameter);
        userFBFriendsGraphRequest.executeAsync();











//        GraphRequest request = new GraphRequest(
//                AccessToken.getCurrentAccessToken(),
//                "/me?fields=id,name,friends{id,name}",
//                null,
//                HttpMethod.GET,
//                new GraphRequest.Callback() {
//                    public void onCompleted(GraphResponse response) {
//
//                      //  Toast.makeText(AccountActivity.this,"response "+ response.toString(),Toast.LENGTH_SHORT).show();
//
//                        // JSON GETS THE DATA
//                        JSONObject jsonData = response.getJSONObject();
//
//
//
//                        try {
//                            Context context = null;
//
//                            JSONArray postsData = jsonData.getJSONArray("data");
//                            if (postsData != null) {
//                                SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
//                                SharedPreferences.Editor editor = sharedPref.edit();
//
//                                mSet.clear();
//
//
//
//                                for (int i = 0; i < postsData.length(); i++) {
//
//                                    JSONObject story = postsData.getJSONObject(i);
//                                    String id = postsData.getJSONObject(i).getString("id");
//                                    Toast.makeText(AccountActivity.this,"ID profile "+id,Toast.LENGTH_SHORT).show();
////                                    if (story.has("friends{id}")) {
////                                        String idprofile = story.getString("friends{id}");
////                                        mSet.add(idprofile);
////                                        Toast.makeText(AccountActivity.this,"ID profile "+idprofile,Toast.LENGTH_SHORT).show();
////
////
////
////
////
////
////
////                                    }
//
//
//                                }
//
//                                editor.putStringSet("addpro", mSet);
//                                editor.apply();
//
//
//
//
//
//                            }
//
//
//                        } catch (Exception e) {
//                            Log.d("JSON", "error" + e.toString());
//                        }
//
//                    }
//                }
//        );
//        Bundle parameters = new Bundle();
//        parameters.putString("fields", "id,name,friends{id,name},friendlists");
//        request.setParameters(parameters);
//        request.executeAsync();







    }
    public void getPostAndCheckWord(){


        final ArrayList<HashMap<String, String>> attitude = db.getAttitudeList();
        final ArrayList<HashMap<String, String>> emotion = db.getEmotionList();
        final ArrayList<HashMap<String, String>> emoshortcut = db.getEmoticon();
        final ArrayList<HashMap<String, String>> attitude2 = db2.getAttitudeList2();
        final ArrayList<HashMap<String, String>> attitude3 = db3.getAttitudeList3();
        final ArrayList<HashMap<String, String>> attitudeNotifi = databaseNotifiWord.getNotiword();
        final ArrayList<HashMap<String, String>> storyTimeline = databaseCheckin.getCheckinWord();

        final String pattern2 = "([a-zA-Z0-9!@#$&()-`|.+',/\"]{2})";
        final String pattern3 = "([a-zA-Z0-9!@#$&()-`|.+',/\"]{3})";
        final String pattern4 = "([a-zA-Z0-9!@#$&()-`|.+',/\"]{4})";
        final String pattern5 = "([0-8]{1})";

        final Pattern regex2 = Pattern.compile(pattern2);
        final Pattern regex3 = Pattern.compile(pattern3);
        final Pattern regex4 = Pattern.compile(pattern4);
        Pattern regex5 = Pattern.compile(pattern5);


        final String message = editTextpost.getText().toString().trim();





        if (message.length() == 0) {
            Toast.makeText(AccountActivity.this,"Please enter a message.", Toast.LENGTH_LONG).show();
        } else {

            SharedPreferences sp6 = getSharedPreferences("App save6", Context.MODE_PRIVATE);
            int checkboxstate6 = sp6.getInt("checked6",0);

            //clear all collection
            strword.clear();
            emo.clear();
            listemo.clear();
            listforword.clear();
            listforemo.clear();
            testword.clear();
            testshortcut.clear();
            mappingEmo.clear();
            arrMapping.clear();


            int countnumemo = 0;
            int countchexkemo = 0;
            int checkshortcut = 0;

            //emoticon check word
            Matcher m2 = regex2.matcher(message);
            Matcher m3 = regex3.matcher(message);
            Matcher m4 = regex4.matcher(message);
            Matcher m5 ;

            while (m2.find()){
                listemo.add(m2.group(0));
                countnumemo++;
            }
            while (m3.find()){
                listemo.add(m3.group(0));
                countnumemo++;
            }
            while (m4.find()){
                listemo.add(m4.group(0));
                countnumemo++;
            }

            //emoticon check word end!!

            //check word by regular expression

//                for(int i = 0;i<attitude.size();i++){
//                    String checkwordbyregular = attitude.get(i).get("AttitudeWord");
//                    Pattern regexcheck = Pattern.compile(checkwordbyregular);
//                    Matcher mcheck = regexcheck.matcher(message);
//                    while (mcheck.find()){
//                        //add in list
//                        //strword.add(mcheck.group(0));
//                    }
//                }
//
//                for(int i = 0;i<attitude2.size();i++){
//                    String checkwordbyregular = attitude2.get(i).get("AttitudeWord");
//                    Pattern regexcheck = Pattern.compile(checkwordbyregular);
//                    Matcher mcheck = regexcheck.matcher(message);
//                    while (mcheck.find()){
//                        //add in list
//                        //strword.add(mcheck.group(0));
//                    }
//                }
//
//                for(int i = 0;i<attitude3.size();i++){
//                    String checkwordbyregular = attitude3.get(i).get("AttitudeWord");
//                    Pattern regexcheck = Pattern.compile(checkwordbyregular);
//                    Matcher mcheck = regexcheck.matcher(message);
//                    while (mcheck.find()){
//                        //add in list
//                       // strword.add(mcheck.group(0));
//                    }
//                }


            //check word by regular expression end!!





            Locale thaiLocale = new Locale("th");


            BreakIterator boundary = BreakIterator.getWordInstance(thaiLocale);



//BreakIterator boundary = DictionaryBasedBreakIterator.getWordInstance(thaiLocale);

            boundary.setText(message);

            String keepword = "";
            String keepemo = "";







            int start = boundary.first();
            for (int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary.next()) {


                strword.add(message.substring(start, end));


                //Toast.makeText(MainActivity.this,input.substring(start, end) + " ",Toast.LENGTH_SHORT).show();

            }

            BreakIterator boundary2 = BreakIterator.getWordInstance(thaiLocale);

            String connectStr = "";

            for(int m = 0;m<strword.size();m++){
                if(strword.get(m).equals("มาก")){
                    connectStr = connectStr+"ๆ";
                }else{
                    connectStr = connectStr+strword.get(m);
                }
            }

            boundary2.setText(connectStr);
            int start2 = boundary2.first();

            strword.clear();

            for (int end = boundary2.next(); end != BreakIterator.DONE; start2 = end, end = boundary2.next()) {


                strword.add(connectStr.substring(start2, end));


                //Toast.makeText(MainActivity.this,input.substring(start, end) + " ",Toast.LENGTH_SHORT).show();

            }





            int count = 0;
            int countNotifi = 0;
            int checkemo = 0;

            //เช็คค่าทัศนคติ emoshortcut
            for (String s : listemo) {
                String keepingword = "";

                for(int i=0;i<emoshortcut.size();i++){
                    testshortcut.add(emoshortcut.get(i).get("EmoticonShortcut"));
                }
                if(testshortcut.contains(s)){
                    keepemo = keepemo + s;
                }


                for(int i=0;i<emoshortcut.size();i++){
                    if(s.equals(emoshortcut.get(i).get("EmoticonShortcut"))){
                        String rank = emoshortcut.get(i).get("EmoticonRank");
                        int countrank = Integer.parseInt(rank);
                        listforemo.add(emoshortcut.get(i).get("EmoticonShortcut"));
                        //int shcemo = Integer.parseInt(emoshortcut.get(i).get("EmoticonEmoid"));
                        m5 = regex5.matcher(emoshortcut.get(i).get("EmoticonEmoid"));
                        while (m5.find()){
                            int shcemo = Integer.parseInt(m5.group(0));
                            String emotionword = emotion.get(shcemo).get("EmotionWord");
                            keepingword = keepingword + emotionword + " ";
                            if(mappingEmo.get(emotionword) == null){
                                mappingEmo.put(emotionword,1);
                            }else{
                                int countmapping = mappingEmo.get(emotionword);
                                countmapping++;
                                mappingEmo.put(emotionword,countmapping);

                            }
                            emo.add(emotionword);
                        }



                        keepemo = " "+keepemo+ " ="+rank+","+keepingword+"|";//check

                        countchexkemo = countchexkemo + countrank;
                        checkshortcut++;


                    }
                }

            }
            //Toast.makeText(AccountActivity.this,String.valueOf(strword.size()),Toast.LENGTH_LONG).show();
            for(String s:strword){
                //Toast.makeText(AccountActivity.this,s,Toast.LENGTH_LONG).show();

            }


            final String checksc;

            if(countchexkemo>0&& checkshortcut >0) {
                checksc = "ค่าทัศนคติemoticon : " + keepemo + " ==> " + String.valueOf(countchexkemo); //check
            }else if(countchexkemo<0&& checkshortcut >0){
                checksc = "ค่าทัศนคติemoticon : " + keepemo + " ==> " + String.valueOf(countchexkemo); //check
            }else if(countchexkemo == 0 && checkshortcut >0){
                checksc = "ค่าทัศนคติemoticon : " + keepemo + " ==> " + String.valueOf(countchexkemo); //check
            }else{
                checksc = "ค่าทัศนคติemoticon : " + keepemo + " ==> null"; //check
            }
            //เช็คคำทัศนคติ word
            for (int i = 0; i < strword.size(); i++) {
                int icount = i+1;

                String str2 = "";
                String str3 = "";


                if(icount <= strword.size()-1){
                    str2 = strword.get(icount);

                    for(int h = icount;h<=strword.size()-1;h++){
                        if(str2.contains(" ")){
                            str2 = strword.get(h);

                        }else{
                            break;
                        }
                    }


                }

                int icountex = i+2;
                String extrastr = "";

                if(icountex <= strword.size()-1){
                    extrastr = strword.get(icountex);

                    for(int h = icountex;h<=strword.size()-1;h++){
                        if(extrastr.contains(" ")){
                            extrastr = strword.get(h);

                        }else{
                            break;
                        }
                    }


                }

                String str = strword.get(i);
//                if(str2.equals("มาก")){
//                    String strextra = strword.get(extrastr+1);
//
//                    str2 = "ๆ";
//                }


                String keepingword = "";

                for (int j = 0; j < attitude.size(); j++) {

                    testword.add(attitude.get(j).get("AttitudeWord"));

                }
                for (int j = 0; j < attitude2.size(); j++) {

                    testword.add(attitude2.get(j).get("AttitudeWord"));

                }

                for (int j = 0; j < attitude3.size(); j++) {

                    testword.add(attitude3.get(j).get("AttitudeWord"));

                }


                if(testword.contains(str)){
                    keepword = keepword + str;
                }else{
                    keepword = keepword + str+"|";
                }
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
                                    str3=str+"ๆ"+str2;
//                                    if(extrastr.contains("ๆ")){
//                                        str3=str+"ๆ"+str2+extrastr;
//                                    }

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
                                    str3=str+"ๆ"+str2;
//                                    if(extrastr.contains("ๆ")){
//                                        str3=str+"ๆ"+str2+extrastr;
//                                    }

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
//                                    if(extrastr.contains("ๆ")){
//                                        str3=str+"ๆ"+str2+extrastr;
//                                    }



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
                                        str3=str+"ๆ"+str2;
//                                        if(extrastr.contains("ๆ")){
//                                            str3=str+"ๆ"+str2+extrastr;
//                                        }

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
                                        str3=str+"ๆ"+str2;
//                                        if(extrastr.contains("ๆ")){
//                                            str3=str+"ๆ"+str2+extrastr;
//                                        }

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
                                        str3=str+"ๆ"+str2;
//                                        if(extrastr.contains("ๆ")){
//
//                                            str3=str+"ๆ"+str2+extrastr;
//                                        }

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
                       str3 = str2+extrastr+"ๆ";
                   }else{
                       str3 = "ๆ";
                   }



                }

                if(str2.contains("มากๆ")){
                    if(extrastr.contains("ๆ")){
                        str3 = str2+extrastr+"ๆ";
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
                        m5 = regex5.matcher(attitude.get(j).get("Emotion"));
                        while (m5.find()){
                            int attemo = Integer.parseInt(m5.group(0));
                            String emotionword = emotion.get(attemo).get("EmotionWord");
                            keepingword = keepingword + emotionword + " ";

                            if(mappingEmo.get(emotionword) == null){
                                mappingEmo.put(emotionword,1);
                            }else{
                                int countmapping = mappingEmo.get(emotionword);
                                countmapping++;
                                mappingEmo.put(emotionword,countmapping);

                            }

                        }


                        keepword = " "+keepword+" ="+rank+","+keepingword+"|";//check
                        count = count + countrank;
                        checkemo++;

                        String frequen ="([ๆ]{1})";
                        Pattern regexfre = Pattern.compile(frequen);
                        Matcher mfre = regexfre.matcher(str3);
                        int countnumber = 0;
                        while (mfre.find()){
                            count = count + countrank;
                            countnumber++;
                        }

                        for(int c = 0;c <countnumber;c++){
                            while (m5.find()){
                                int attemo = Integer.parseInt(m5.group(0));
                                String emotionword = emotion.get(attemo).get("EmotionWord");
                                if(mappingEmo.get(emotionword) == null){
                                    mappingEmo.put(emotionword,1);
                                }else{
                                    int countmapping = mappingEmo.get(emotionword);
                                    countmapping++;
                                    mappingEmo.put(emotionword,countmapping);

                                }

                            }
                        }

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








                    }
                }


                for (int j = 0; j < attitude2.size(); j++) {
                    if (str.equals(attitude2.get(j).get("AttitudeWord"))) {

                        for(int notifi = 0 ;notifi<attitudeNotifi.size();notifi++){
                            if(attitudeNotifi.get(notifi).get("Word").equals(str)){
                                countNotifi++;
                            }
                        }

                        String rank = attitude2.get(j).get("AttitudeRank");
                        int countrank = Integer.parseInt(rank);
                        m5 = regex5.matcher(attitude2.get(j).get("Emotion"));
                        while (m5.find()){
                            int attemo = Integer.parseInt(m5.group(0));
                            String emotionword = emotion.get(attemo).get("EmotionWord");
                            keepingword = keepingword + emotionword + " ";
                            if(mappingEmo.get(emotionword) == null){
                                mappingEmo.put(emotionword,1);
                            }else{
                                int countmapping = mappingEmo.get(emotionword);
                                countmapping++;
                                mappingEmo.put(emotionword,countmapping);

                            }

                        }


                        keepword = " "+keepword+" ="+rank+","+keepingword+"|";//check
                        count = count + countrank;
                        checkemo++;

                        String frequen ="([ๆ]{1})";
                        Pattern regexfre = Pattern.compile(frequen);
                        Matcher mfre = regexfre.matcher(str3);
                        int countnumber =0;
                        while (mfre.find()){
                            count = count + countrank;
                            countnumber++;
                        }

                        for(int c = 0;c <countnumber;c++){
                            while (m5.find()){
                                int attemo = Integer.parseInt(m5.group(0));
                                String emotionword = emotion.get(attemo).get("EmotionWord");
                                if(mappingEmo.get(emotionword) == null){
                                    mappingEmo.put(emotionword,1);
                                }else{
                                    int countmapping = mappingEmo.get(emotionword);
                                    countmapping++;
                                    mappingEmo.put(emotionword,countmapping);

                                }

                            }
                        }



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

                        for(int notifi = 0 ;notifi<attitudeNotifi.size();notifi++){
                            if(attitudeNotifi.get(notifi).get("Word").equals(str)){
                                countNotifi++;
                            }
                        }

                        String rank = attitude3.get(j).get("AttitudeRank");
                        int countrank = Integer.parseInt(rank);

                        m5 = regex5.matcher(attitude3.get(j).get("Emotion"));
                        while (m5.find()){
                            int attemo = Integer.parseInt(m5.group(0));
                            String emotionword = emotion.get(attemo).get("EmotionWord");
                            keepingword = keepingword + emotionword + " ";
                            if(mappingEmo.get(emotionword) == null){
                                mappingEmo.put(emotionword,1);
                            }else{
                                int countmapping = mappingEmo.get(emotionword);
                                countmapping++;
                                mappingEmo.put(emotionword,countmapping);

                            }

                        }



                        keepword = " "+keepword+" ="+rank+","+keepingword+"|";//check

                        count = count + countrank;
                        checkemo++;

                        String frequen ="([ๆ]{1})";
                        Pattern regexfre = Pattern.compile(frequen);
                        Matcher mfre = regexfre.matcher(str3);
                        int countnumber = 0;
                        while (mfre.find()){
                            count = count + countrank;
                            countnumber++;
                        }
                        for(int c = 0;c <countnumber;c++){
                            while (m5.find()){
                                int attemo = Integer.parseInt(m5.group(0));
                                String emotionword = emotion.get(attemo).get("EmotionWord");
                                if(mappingEmo.get(emotionword) == null){
                                    mappingEmo.put(emotionword,1);
                                }else{
                                    int countmapping = mappingEmo.get(emotionword);
                                    countmapping++;
                                    mappingEmo.put(emotionword,countmapping);

                                }

                            }
                        }
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




                        //Toast.makeText(AccountActivity.this,attitude2.get(j).get("AttitudeWord"),Toast.LENGTH_LONG).show();

                    }
                }





            }
            final String checkwd;
            if(count > 0&&checkemo >0) {
                checkwd = "ค่าทัศนคติword : " + keepword + " ==> " + String.valueOf(count);//check
            }else if(count < 0&&checkemo >0){
                checkwd = "ค่าทัศนคติword : " + keepword + " ==> " + String.valueOf(count);//check
            }else if(count == 0&&checkemo >0){
                checkwd = "ค่าทัศนคติword : " + keepword + " ==> " + String.valueOf(count);//check
            }else{
                checkwd = "ค่าทัศนคติword  : " + keepword + " ==> null";//check
            }


//                if(emo.contains("ไม่แสดงอารมณ์")){
//                    emo.remove("ไม่แสดงอารมณ์");
//
//                }



            if(countchexkemo >0 && checkshortcut >0){
//                    if(emo.contains("กลัว(Fear)")) {
//                        emo.remove("กลัว(Fear)");
//                    }
                if(mappingEmo.containsKey("กลัว(Fear))")) {
                    mappingEmo.remove("กลัว(Fear)");
                }

//                    if(emo.contains("รังเกียจ(Disgust)")){
//                        emo.remove("รังเกียจ(Disgust)");
//
//                    }
                if(mappingEmo.containsKey("รังเกียจ(Disgust))")) {
                    mappingEmo.remove("รังเกียจ(Disgust)");
                }
//                    if(emo.contains("โกรธ(Anger)")){
//                        emo.remove("โกรธ(Anger)");
//                    }
                if(mappingEmo.containsKey("โกรธ(Anger)")) {
                    mappingEmo.remove("โกรธ(Anger)");
                }
//                    if(emo.contains("เศร้าเสียใจ(Sadness)")){
//                        emo.remove("เศร้าเสียใจ(Sadness)");
//                    }
                if(mappingEmo.containsKey("เศร้าเสียใจ(Sadness)")) {
                    mappingEmo.remove("เศร้าเสียใจ(Sadness)");
                }
//                    if(emo.contains("ประหลาดใจ(Surprise)")){
//                        emo.remove("ประหลาดใจ(Surprise)");
//                    }
                if(mappingEmo.containsKey("ประหลาดใจ(Surprise)")) {
                    mappingEmo.remove("ประหลาดใจ(Surprise)");
                }
//                    if(emo.contains("คาดหวัง(Anticipation)")){
//                        emo.remove("คาดหวัง(Anticipation)");
//                    }
                if(mappingEmo.containsKey("คาดหวัง(Anticipation)")) {
                    mappingEmo.remove("คาดหวัง(Anticipation)");
                }

            }else if(countchexkemo == 0 && checkshortcut >0){
//                    if(emo.contains("กลัว(Fear)")) {
//                        emo.remove("กลัว(Fear)");
//                    }
                if(mappingEmo.containsKey("กลัว(Fear)")) {
                    mappingEmo.remove("กลัว(Fear)");
                }
//                    if(emo.contains("รังเกียจ(Disgust)")){
//                        emo.remove("รังเกียจ(Disgust)");
//
//                    }
                if(mappingEmo.containsKey("รังเกียจ(Disgust)")) {
                    mappingEmo.remove("รังเกียจ(Disgust)");
                }
//                    if(emo.contains("โกรธ(Anger)")){
//                        emo.remove("โกรธ(Anger)");
//                    }
                if(mappingEmo.containsKey("โกรธ(Anger)")) {
                    mappingEmo.remove("โกรธ(Anger)");
                }
//                    if(emo.contains("เศร้าเสียใจ(Sadness)")){
//                        emo.remove("เศร้าเสียใจ(Sadness)");
//                    }
                if(mappingEmo.containsKey("เศร้าเสียใจ(Sadness)")) {
                    mappingEmo.remove("เศร้าเสียใจ(Sadness)");
                }
//                    if(emo.contains("ยอมรับ(Acceptance)")){
//                        emo.remove("ยอมรับ(Acceptance)");
//                    }
                if(mappingEmo.containsKey("ยอมรับ(Acceptance)")) {
                    mappingEmo.remove("ยอมรับ(Acceptance)");
                }
//                    if(emo.contains("รื่นเริง(Joy)")){
//                        emo.remove("รื่นเริง(Joy)");
//                    }
                if(mappingEmo.containsKey("รื่นเริง(Joy)")) {
                    mappingEmo.remove("รื่นเริง(Joy)");
                }

            }else if(countchexkemo <0&&checkshortcut>0){
//                    if(emo.contains("ยอมรับ(Acceptance)")){
//                        emo.remove("ยอมรับ(Acceptance)");
//                    }
                if(mappingEmo.containsKey("ยอมรับ(Acceptance)")) {
                    mappingEmo.remove("รยอมรับ(Acceptance)");
                }
//                    if(emo.contains("รื่นเริง(Joy)")){
//                        emo.remove("รื่นเริง(Joy)");
//                    }
                if(mappingEmo.containsKey("รื่นเริง(Joy)")) {
                    mappingEmo.remove("รื่นเริง(Joy)");
                }
//                    if(emo.contains("ประหลาดใจ(Surprise)")){
//                        emo.remove("ประหลาดใจ(Surprise)");
//                    }
                if(mappingEmo.containsKey("ประหลาดใจ(Surprise)")) {
                    mappingEmo.remove("ประหลาดใจ(Surprise)");
                }
//                    if(emo.contains("คาดหวัง(Anticipation)")){
//                        emo.remove("คาดหวัง(Anticipation)");
//                    }
                if(mappingEmo.containsKey("คาดหวัง(Anticipation)")) {
                    mappingEmo.remove("คาดหวัง(Anticipation)");
                }
            }else {

                if(count > 0&&checkemo >0){
                    //                    if(emo.contains("กลัว(Fear)")) {
//                        emo.remove("กลัว(Fear)");
//                    }
                    if(mappingEmo.containsKey("กลัว(Fear))")) {
                        mappingEmo.remove("กลัว(Fear)");
                    }

//                    if(emo.contains("รังเกียจ(Disgust)")){
//                        emo.remove("รังเกียจ(Disgust)");
//
//                    }
                    if(mappingEmo.containsKey("รังเกียจ(Disgust))")) {
                        mappingEmo.remove("รังเกียจ(Disgust)");
                    }
//                    if(emo.contains("โกรธ(Anger)")){
//                        emo.remove("โกรธ(Anger)");
//                    }
                    if(mappingEmo.containsKey("โกรธ(Anger)")) {
                        mappingEmo.remove("โกรธ(Anger)");
                    }
//                    if(emo.contains("เศร้าเสียใจ(Sadness)")){
//                        emo.remove("เศร้าเสียใจ(Sadness)");
//                    }
                    if(mappingEmo.containsKey("เศร้าเสียใจ(Sadness)")) {
                        mappingEmo.remove("เศร้าเสียใจ(Sadness)");
                    }
//                    if(emo.contains("ประหลาดใจ(Surprise)")){
//                        emo.remove("ประหลาดใจ(Surprise)");
//                    }
                    if(mappingEmo.containsKey("ประหลาดใจ(Surprise)")) {
                        mappingEmo.remove("ประหลาดใจ(Surprise)");
                    }
//                    if(emo.contains("คาดหวัง(Anticipation)")){
//                        emo.remove("คาดหวัง(Anticipation)");
//                    }
                    if(mappingEmo.containsKey("คาดหวัง(Anticipation)")) {
                        mappingEmo.remove("คาดหวัง(Anticipation)");
                    }


                }else if(count == 0&&checkemo >0){
                    //                    if(emo.contains("กลัว(Fear)")) {
//                        emo.remove("กลัว(Fear)");
//                    }
                    if(mappingEmo.containsKey("กลัว(Fear)")) {
                        mappingEmo.remove("กลัว(Fear)");
                    }
//                    if(emo.contains("รังเกียจ(Disgust)")){
//                        emo.remove("รังเกียจ(Disgust)");
//
//                    }
                    if(mappingEmo.containsKey("รังเกียจ(Disgust)")) {
                        mappingEmo.remove("รังเกียจ(Disgust)");
                    }
//                    if(emo.contains("โกรธ(Anger)")){
//                        emo.remove("โกรธ(Anger)");
//                    }
                    if(mappingEmo.containsKey("โกรธ(Anger)")) {
                        mappingEmo.remove("โกรธ(Anger)");
                    }
//                    if(emo.contains("เศร้าเสียใจ(Sadness)")){
//                        emo.remove("เศร้าเสียใจ(Sadness)");
//                    }
                    if(mappingEmo.containsKey("เศร้าเสียใจ(Sadness)")) {
                        mappingEmo.remove("เศร้าเสียใจ(Sadness)");
                    }
//                    if(emo.contains("ยอมรับ(Acceptance)")){
//                        emo.remove("ยอมรับ(Acceptance)");
//                    }
                    if(mappingEmo.containsKey("ยอมรับ(Acceptance)")) {
                        mappingEmo.remove("ยอมรับ(Acceptance)");
                    }
//                    if(emo.contains("รื่นเริง(Joy)")){
//                        emo.remove("รื่นเริง(Joy)");
//                    }
                    if(mappingEmo.containsKey("รื่นเริง(Joy)")) {
                        mappingEmo.remove("รื่นเริง(Joy)");
                    }

                }else if(count < 0&&checkemo >0){
                    //                    if(emo.contains("ยอมรับ(Acceptance)")){
//                        emo.remove("ยอมรับ(Acceptance)");
//                    }
                    if(mappingEmo.containsKey("ยอมรับ(Acceptance)")) {
                        mappingEmo.remove("รยอมรับ(Acceptance)");
                    }
//                    if(emo.contains("รื่นเริง(Joy)")){
//                        emo.remove("รื่นเริง(Joy)");
//                    }
                    if(mappingEmo.containsKey("รื่นเริง(Joy)")) {
                        mappingEmo.remove("รื่นเริง(Joy)");
                    }
//                    if(emo.contains("ประหลาดใจ(Surprise)")){
//                        emo.remove("ประหลาดใจ(Surprise)");
//                    }
                    if(mappingEmo.containsKey("ประหลาดใจ(Surprise)")) {
                        mappingEmo.remove("ประหลาดใจ(Surprise)");
                    }
//                    if(emo.contains("คาดหวัง(Anticipation)")){
//                        emo.remove("คาดหวัง(Anticipation)");
//                    }
                    if(mappingEmo.containsKey("คาดหวัง(Anticipation)")) {
                        mappingEmo.remove("คาดหวัง(Anticipation)");
                    }

                }

            }

            int max = -9999999;
            for(Map.Entry m : mappingEmo.entrySet()){
                Integer num = (Integer) m.getValue();
                if(num > max){
                    max = num;
                }

            }

            for(Map.Entry m : mappingEmo.entrySet()){
                Integer num = (Integer) m.getValue();
                if(num == max){
                    arrMapping.add((String)m.getKey());
                }
            }





            // Iterator<String> itremo = emo.iterator();


            /* make the API call */
            final StringBuffer emoneutral = new StringBuffer();
            StringBuffer emopositive = new StringBuffer();
            StringBuffer emonegetive = new StringBuffer();

            int countnum = 0;
            int countnum2 = 0;
            int countnum3 = 0;

            if(checkboxstate6 == 1) {
                if (countchexkemo == 0 && checkshortcut > 0) {
//                        while (itremo.hasNext()) {
//
//
//                            emoneutral.append(itremo.next().toString() + " ");
//                            countnum++;
//
//
//                        }
                    if(arrMapping.size() == 0){
                        emoneutral.append("-");
                    }else if(arrMapping.size() == 1){
                        if(arrMapping.contains("ไม่แสดงอารมณ์")){
                            emoneutral.append("-");
                        }else{
                            for(String s : arrMapping) {
                                emoneutral.append(s);
                            }
                        }
                    }else{
                        if(arrMapping.contains("ไม่แสดงอารมณ์")){
                            arrMapping.remove("ไม่แสดงอารมณ์");
                        }
                        for(String s : arrMapping) {
                            emoneutral.append(s + " ");
                        }

                    }


//                        if (countnum == 0) {
//
//                            emoneutral.append("-");
//                        }
                    final Dialog dialog = new Dialog(AccountActivity.this,R.style.FullHeightDialog);
                    dialog.setContentView(R.layout.neural_layout);
                    //dialog.setTitle("");


                    TextView textatti = (TextView) dialog.findViewById(R.id.textneuralatti);
                    TextView textemo = (TextView) dialog.findViewById(R.id.textneuralemo);
                    Button dialogButton3 = (Button) dialog.findViewById(R.id.btncheckneural);

                    textatti.setText("ทัศนคติ(Attitude)  : เป็นกลาง(Unexpressed)");
                    textemo.setText("อารมณ์(Emotion) : " + emoneutral);
                    ImageView image = (ImageView) dialog.findViewById(R.id.imageviewneural);
                    image.setImageResource(R.drawable.yellow);

                    Button dialogButton = (Button) dialog.findViewById(R.id.postneural_btn);
                    Button dialogButton2 = (Button) dialog.findViewById(R.id.noneural_btn);
                    dialogButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Bundle params = new Bundle();
                            params.putString("message", message);
                            new GraphRequest(
                                    AccessToken.getCurrentAccessToken(),
                                    "/me/feed",
                                    params,
                                    HttpMethod.POST,
                                    new GraphRequest.Callback() {
                                        public void onCompleted(GraphResponse response) {
                                            Toast.makeText(AccountActivity.this, "Post Status Success", Toast.LENGTH_LONG).show();
                                            GraphRequest request = new GraphRequest(
                                                    AccessToken.getCurrentAccessToken(),
                                                    "/me/feed",
                                                    null,
                                                    HttpMethod.GET,
                                                    new GraphRequest.Callback() {
                                                        public void onCompleted(GraphResponse response) {

                                                            // JSON GETS THE DATA
                                                            JSONObject jsonData = response.getJSONObject();

                                                            try {

                                                                JSONArray postsData = jsonData.getJSONArray("data");
                                                                if (postsData != null) {

                                                                    for (int i = 0; i < postsData.length(); i++) {
                                                                        JSONObject story = postsData.getJSONObject(i);

                                                                        if (story.has("id")) {
                                                                            String timeMessage = story.getString("id");
                                                                            String facebook = "https://www.facebook.com/" + timeMessage;
                                                                            Uri uri = Uri.parse(facebook);
                                                                            Intent intentfb = new Intent(Intent.ACTION_VIEW, uri);
                                                                            startActivity(intentfb);
                                                                        }

                                                                    }


                                                                }

                                                            } catch (Exception e) {
                                                                Log.d("JSON", "error" + e.toString());
                                                            }

                                                        }
                                                    }
                                            );
                                            Bundle parameters = new Bundle();
                                            parameters.putString("fields", "id");
                                            parameters.putString("limit", "1");
                                            request.setParameters(parameters);
                                            request.executeAsync();
                                        }
                                    }
                            ).executeAsync();
                            editTextpost.setText("");

                            dialog.dismiss();
                        }
                    });

                    dialogButton2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });

                    dialogButton3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(AccountActivity.this);
                            builder.setMessage(message + "\n\n" + checkwd + "\n\n" + checksc).setTitle("AlertDialog").setCancelable(false)
                                    .setNegativeButton("Exits", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            dialogInterface.cancel();
                                        }
                                    });
                            AlertDialog dialog = builder.create();
                            dialog.show();

                        }
                    });


                    dialog.show();



                } else if (countchexkemo < 0 && checkshortcut > 0) {

                    Bundle params = new Bundle();
                    params.putString("message", message);


//                        while (itremo.hasNext()) {
//
//
//                            emonegetive.append(itremo.next().toString() + " ");
//                            countnum2++;
//
//
//                        }
                    if(arrMapping.size() == 0){
                        emonegetive.append("-");
                    }else if(arrMapping.size() == 1){
                        if(arrMapping.contains("ไม่แสดงอารมณ์")){
                            emonegetive.append("-");
                        }else{
                            for(String s : arrMapping) {
                                emonegetive.append(s);
                            }
                        }
                    }else{
                        if(arrMapping.contains("ไม่แสดงอารมณ์")){
                            arrMapping.remove("ไม่แสดงอารมณ์");
                        }
                        for(String s : arrMapping) {
                            emonegetive.append(s + " ");
                        }

                    }

//                        if (countnum2 == 0) {
//                            emonegetive.append("-");
//                        }
                    final Dialog dialog = new Dialog(AccountActivity.this,R.style.FullHeightDialog);
                    dialog.setContentView(R.layout.negetive_layout);
                    //dialog.setTitle("");


                    TextView textatti = (TextView) dialog.findViewById(R.id.textnegetiveatti);
                    TextView textemo = (TextView) dialog.findViewById(R.id.textnegetiveemo);
                    TextView textnotifi = (TextView) dialog.findViewById(R.id.textnotifi);
                    textnotifi.setText("คำแนะนำ : ไม่ควรโพสต์สถานะที่แสดงทัศนคติทางลบ ลองเปลี่ยนการใช้คำ");
                    Button dialogButton3 = (Button) dialog.findViewById(R.id.btnchecknegetive);

                    textatti.setText("ทัศนคติ(Attitude) : เชิงลบ(Negative)");
                    textemo.setText("อารมณ์(Emotion) : " + emonegetive);

                    ImageView image = (ImageView) dialog.findViewById(R.id.imageviewnegetive);
                    image.setImageResource(R.drawable.red);

                    Button dialogButton = (Button) dialog.findViewById(R.id.postnegetive_btn);
                    Button dialogButton2 = (Button) dialog.findViewById(R.id.nonegetive_btn);
                    dialogButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Bundle params = new Bundle();
                            params.putString("message", message);
                            new GraphRequest(
                                    AccessToken.getCurrentAccessToken(),
                                    "/me/feed",
                                    params,
                                    HttpMethod.POST,
                                    new GraphRequest.Callback() {
                                        public void onCompleted(GraphResponse response) {
                                            Toast.makeText(AccountActivity.this, "Post Status Success", Toast.LENGTH_LONG).show();
                                            GraphRequest request = new GraphRequest(
                                                    AccessToken.getCurrentAccessToken(),
                                                    "/me/feed",
                                                    null,
                                                    HttpMethod.GET,
                                                    new GraphRequest.Callback() {
                                                        public void onCompleted(GraphResponse response) {

                                                            // JSON GETS THE DATA
                                                            JSONObject jsonData = response.getJSONObject();

                                                            try {

                                                                JSONArray postsData = jsonData.getJSONArray("data");
                                                                if (postsData != null) {

                                                                    for (int i = 0; i < postsData.length(); i++) {
                                                                        JSONObject story = postsData.getJSONObject(i);

                                                                        if (story.has("id")) {
                                                                            String timeMessage = story.getString("id");
                                                                            String facebook = "https://www.facebook.com/" + timeMessage;
                                                                            Uri uri = Uri.parse(facebook);
                                                                            Intent intentfb = new Intent(Intent.ACTION_VIEW, uri);
                                                                            startActivity(intentfb);
                                                                        }

                                                                    }


                                                                }

                                                            } catch (Exception e) {
                                                                Log.d("JSON", "error" + e.toString());
                                                            }

                                                        }
                                                    }
                                            );
                                            Bundle parameters = new Bundle();
                                            parameters.putString("fields", "id");
                                            parameters.putString("limit", "1");
                                            request.setParameters(parameters);
                                            request.executeAsync();
                                        }
                                    }
                            ).executeAsync();
                            editTextpost.setText("");
                            if(countneg >=6)
                                showNotification(v);
                            dialog.dismiss();
                        }
                    });

                    dialogButton2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            dialog.dismiss();
                        }
                    });

                    dialogButton3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(AccountActivity.this);
                            builder.setMessage(message + "\n\n" + checkwd + "\n\n" + checksc).setTitle("AlertDialog").setCancelable(false)
                                    .setNegativeButton("Exits", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            dialogInterface.cancel();
                                        }
                                    });
                            AlertDialog dialog = builder.create();
                            dialog.show();

                        }
                    });

                    dialog.show();


                } else if (countchexkemo > 0 && checkshortcut > 0) {

                    Bundle params = new Bundle();
                    params.putString("message", message);
                    new GraphRequest(
                            AccessToken.getCurrentAccessToken(),
                            "/me/feed",
                            params,
                            HttpMethod.POST,
                            new GraphRequest.Callback() {
                                public void onCompleted(GraphResponse response) {
                                    Toast.makeText(AccountActivity.this, "Post Status Success", Toast.LENGTH_LONG).show();
                                    GraphRequest request = new GraphRequest(
                                            AccessToken.getCurrentAccessToken(),
                                            "/me/feed",
                                            null,
                                            HttpMethod.GET,
                                            new GraphRequest.Callback() {
                                                public void onCompleted(GraphResponse response) {

                                                    // JSON GETS THE DATA
                                                    JSONObject jsonData = response.getJSONObject();

                                                    try {

                                                        JSONArray postsData = jsonData.getJSONArray("data");
                                                        if (postsData != null) {

                                                            for (int i = 0; i < postsData.length(); i++) {
                                                                JSONObject story = postsData.getJSONObject(i);

                                                                if (story.has("id")) {
                                                                    String timeMessage = story.getString("id");
                                                                    String facebook = "https://www.facebook.com/" + timeMessage;
                                                                    Uri uri = Uri.parse(facebook);
                                                                    Intent intentfb = new Intent(Intent.ACTION_VIEW, uri);
                                                                    startActivity(intentfb);
                                                                }

                                                            }


                                                        }

                                                    } catch (Exception e) {
                                                        Log.d("JSON", "error" + e.toString());
                                                    }

                                                }
                                            }
                                    );
                                    Bundle parameters = new Bundle();
                                    parameters.putString("fields", "id");
                                    parameters.putString("limit", "1");
                                    request.setParameters(parameters);
                                    request.executeAsync();
                                }
                            }
                    ).executeAsync();
                    editTextpost.setText("");


                } else {


                    if (count == 0 && checkemo > 0) {


                        Bundle params = new Bundle();
                        params.putString("message", message);

//                            while (itremo.hasNext()) {
//
//
//                                emoneutral.append(itremo.next() + " ");
//                                countnum++;
//
//
//                            }
                        if(arrMapping.size() == 0){
                            emoneutral.append("-");
                        }else if(arrMapping.size() == 1){
                            if(arrMapping.contains("ไม่แสดงอารมณ์")){
                                emoneutral.append("-");
                            }else{
                                for(String s : arrMapping) {
                                    emoneutral.append(s);
                                }
                            }
                        }else{
                            if(arrMapping.contains("ไม่แสดงอารมณ์")){
                                arrMapping.remove("ไม่แสดงอารมณ์");
                            }
                            for(String s : arrMapping) {
                                emoneutral.append(s + " ");
                            }

                        }
//                            if (countnum == 0) {
//
//                                emoneutral.append("-");
//                            }
                        final Dialog dialog = new Dialog(AccountActivity.this,R.style.FullHeightDialog);
                        dialog.setContentView(R.layout.neural_layout);
                        //dialog.setTitle("");


                        TextView textatti = (TextView) dialog.findViewById(R.id.textneuralatti);
                        TextView textemo = (TextView) dialog.findViewById(R.id.textneuralemo);
                        Button dialogButton3 = (Button) dialog.findViewById(R.id.btncheckneural);

                        textatti.setText("ทัศนคติ(Attitude)  : เป็นกลาง(Unexpressed)");
                        textemo.setText("อารมณ์(Emotion) : " + emoneutral);
                        ImageView image = (ImageView) dialog.findViewById(R.id.imageviewneural);
                        image.setImageResource(R.drawable.yellow);

                        Button dialogButton = (Button) dialog.findViewById(R.id.postneural_btn);
                        Button dialogButton2 = (Button) dialog.findViewById(R.id.noneural_btn);
                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Bundle params = new Bundle();
                                params.putString("message", message);
                                new GraphRequest(
                                        AccessToken.getCurrentAccessToken(),
                                        "/me/feed",
                                        params,
                                        HttpMethod.POST,
                                        new GraphRequest.Callback() {
                                            public void onCompleted(GraphResponse response) {
                                                Toast.makeText(AccountActivity.this, "Post Status Success", Toast.LENGTH_LONG).show();
                                                GraphRequest request = new GraphRequest(
                                                        AccessToken.getCurrentAccessToken(),
                                                        "/me/feed",
                                                        null,
                                                        HttpMethod.GET,
                                                        new GraphRequest.Callback() {
                                                            public void onCompleted(GraphResponse response) {

                                                                // JSON GETS THE DATA
                                                                JSONObject jsonData = response.getJSONObject();

                                                                try {

                                                                    JSONArray postsData = jsonData.getJSONArray("data");
                                                                    if (postsData != null) {

                                                                        for (int i = 0; i < postsData.length(); i++) {
                                                                            JSONObject story = postsData.getJSONObject(i);

                                                                            if (story.has("id")) {
                                                                                String timeMessage = story.getString("id");
                                                                                String facebook = "https://www.facebook.com/" + timeMessage;
                                                                                Uri uri = Uri.parse(facebook);
                                                                                Intent intentfb = new Intent(Intent.ACTION_VIEW, uri);
                                                                                startActivity(intentfb);
                                                                            }

                                                                        }


                                                                    }

                                                                } catch (Exception e) {
                                                                    Log.d("JSON", "error" + e.toString());
                                                                }

                                                            }
                                                        }
                                                );
                                                Bundle parameters = new Bundle();
                                                parameters.putString("fields", "id");
                                                parameters.putString("limit", "1");
                                                request.setParameters(parameters);
                                                request.executeAsync();
                                            }
                                        }
                                ).executeAsync();
                                editTextpost.setText("");

                                dialog.dismiss();
                            }
                        });

                        dialogButton2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                            }
                        });

                        dialogButton3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(AccountActivity.this);
                                builder.setMessage(message + "\n\n" + checkwd + "\n\n" + checksc).setTitle("AlertDialog").setCancelable(false)
                                        .setNegativeButton("Exits", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                dialogInterface.cancel();
                                            }
                                        });
                                AlertDialog dialog = builder.create();
                                dialog.show();

                            }
                        });

                        dialog.show();


                    } else if (count < 0 && checkemo > 0) {

                        Bundle params = new Bundle();
                        params.putString("message", message);


//                            while (itremo.hasNext()) {
//
//
//                                emonegetive.append(itremo.next() + " ");
//                                countnum2++;
//
//
//                            }
                        if(arrMapping.size() == 0){
                            emonegetive.append("-");
                        }else if(arrMapping.size() == 1){
                            if(arrMapping.contains("ไม่แสดงอารมณ์")){
                                emonegetive.append("-");
                            }else{
                                for(String s : arrMapping) {
                                    emonegetive.append(s);
                                }
                            }
                        }else{
                            if(arrMapping.contains("ไม่แสดงอารมณ์")){
                                arrMapping.remove("ไม่แสดงอารมณ์");
                            }
                            for(String s : arrMapping) {
                                emonegetive.append(s + " ");
                            }

                        }

//                            if (countnum2 == 0) {
//                                emonegetive.append("-");
//                            }
                        final Dialog dialog = new Dialog(AccountActivity.this,R.style.FullHeightDialog);
                        dialog.setContentView(R.layout.negetive_layout);
                        //dialog.setTitle("");


                        TextView textatti = (TextView) dialog.findViewById(R.id.textnegetiveatti);
                        TextView textemo = (TextView) dialog.findViewById(R.id.textnegetiveemo);
                        TextView textnotifi = (TextView) dialog.findViewById(R.id.textnotifi);
                        Button dialogButton3 = (Button) dialog.findViewById(R.id.btnchecknegetive);

                        textatti.setText("ทัศนคติ(Attitude) : เชิงลบ(Negative)");
                        textemo.setText("อารมณ์(Emotion) : " + emonegetive);


                        if(countNotifi==-3 && countNotifi > 0){
                            textnotifi.setText("คำแนะนำ : สถานะที่โพสต์มีคำหยาบมาก ควรเปลี่ยนการใช้คำ");
                        }else if(countNotifi<-3 && countNotifi > 0){
                            textnotifi.setText("คำแนะนำ : สถานะที่โพสต์มีคำหยาบค่อนข้างมาก ควรเปลี่ยนการใช้คำ");
                        }else if(countNotifi > 0){
                            textnotifi.setText("คำแนะนำ : สถานะที่โพสต์มีคำหยาบ ควรเปลี่ยนการใช้คำ");
                        }else{

                            textnotifi.setText("คำแนะนำ : ไม่ควรโพสต์สถานะที่แสดงทัศนคติทางลบ ลองเปลี่ยนการใช้คำ");
                        }

                        ImageView image = (ImageView) dialog.findViewById(R.id.imageviewnegetive);
                        image.setImageResource(R.drawable.red);

                        Button dialogButton = (Button) dialog.findViewById(R.id.postnegetive_btn);
                        Button dialogButton2 = (Button) dialog.findViewById(R.id.nonegetive_btn);
                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Bundle params = new Bundle();
                                params.putString("message", message);
                                new GraphRequest(
                                        AccessToken.getCurrentAccessToken(),
                                        "/me/feed",
                                        params,
                                        HttpMethod.POST,
                                        new GraphRequest.Callback() {
                                            public void onCompleted(GraphResponse response) {
                                                Toast.makeText(AccountActivity.this, "Post Status Success", Toast.LENGTH_LONG).show();
                                                GraphRequest request = new GraphRequest(
                                                        AccessToken.getCurrentAccessToken(),
                                                        "/me/feed",
                                                        null,
                                                        HttpMethod.GET,
                                                        new GraphRequest.Callback() {
                                                            public void onCompleted(GraphResponse response) {

                                                                // JSON GETS THE DATA
                                                                JSONObject jsonData = response.getJSONObject();

                                                                try {

                                                                    JSONArray postsData = jsonData.getJSONArray("data");
                                                                    if (postsData != null) {

                                                                        for (int i = 0; i < postsData.length(); i++) {
                                                                            JSONObject story = postsData.getJSONObject(i);

                                                                            if (story.has("id")) {
                                                                                String timeMessage = story.getString("id");
                                                                                String facebook = "https://www.facebook.com/" + timeMessage;
                                                                                Uri uri = Uri.parse(facebook);
                                                                                Intent intentfb = new Intent(Intent.ACTION_VIEW, uri);
                                                                                startActivity(intentfb);
                                                                            }

                                                                        }


                                                                    }

                                                                } catch (Exception e) {
                                                                    Log.d("JSON", "error" + e.toString());
                                                                }

                                                            }
                                                        }
                                                );
                                                Bundle parameters = new Bundle();
                                                parameters.putString("fields", "id");
                                                parameters.putString("limit", "1");
                                                request.setParameters(parameters);
                                                request.executeAsync();
                                            }
                                        }
                                ).executeAsync();
                                editTextpost.setText("");
                                if(countneg >=6)
                                    showNotification(v);
                                dialog.dismiss();
                            }
                        });

                        dialogButton2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                            }
                        });

                        dialogButton3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(AccountActivity.this);
                                builder.setMessage(message + "\n\n" + checkwd + "\n\n" + checksc).setTitle("AlertDialog").setCancelable(false)
                                        .setNegativeButton("Exits", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                dialogInterface.cancel();
                                            }
                                        });
                                AlertDialog dialog = builder.create();
                                dialog.show();

                            }
                        });

                        dialog.show();


                    } else if (count > 0 && checkemo > 0) {

                        Bundle params = new Bundle();
                        params.putString("message", message);
                        new GraphRequest(
                                AccessToken.getCurrentAccessToken(),
                                "/me/feed",
                                params,
                                HttpMethod.POST,
                                new GraphRequest.Callback() {
                                    public void onCompleted(GraphResponse response) {
                                        Toast.makeText(AccountActivity.this, "Post Status Success", Toast.LENGTH_LONG).show();
                                        GraphRequest request = new GraphRequest(
                                                AccessToken.getCurrentAccessToken(),
                                                "/me/feed",
                                                null,
                                                HttpMethod.GET,
                                                new GraphRequest.Callback() {
                                                    public void onCompleted(GraphResponse response) {

                                                        // JSON GETS THE DATA
                                                        JSONObject jsonData = response.getJSONObject();

                                                        try {

                                                            JSONArray postsData = jsonData.getJSONArray("data");
                                                            if (postsData != null) {

                                                                for (int i = 0; i < postsData.length(); i++) {
                                                                    JSONObject story = postsData.getJSONObject(i);

                                                                    if (story.has("id")) {
                                                                        String timeMessage = story.getString("id");
                                                                        String facebook = "https://www.facebook.com/" + timeMessage;
                                                                        Uri uri = Uri.parse(facebook);
                                                                        Intent intentfb = new Intent(Intent.ACTION_VIEW, uri);
                                                                        startActivity(intentfb);
                                                                    }

                                                                }


                                                            }

                                                        } catch (Exception e) {
                                                            Log.d("JSON", "error" + e.toString());
                                                        }

                                                    }
                                                }
                                        );
                                        Bundle parameters = new Bundle();
                                        parameters.putString("fields", "id");
                                        parameters.putString("limit", "1");
                                        request.setParameters(parameters);
                                        request.executeAsync();
                                    }
                                }
                        ).executeAsync();

                        editTextpost.setText("");



                    } else {

                        AlertDialog.Builder builder = new AlertDialog.Builder(AccountActivity.this);
                        builder.setMessage(message + "\n\n" + checkwd + "\n\n" + checksc).setTitle("AlertDialog").setCancelable(false)
                                .setNegativeButton("Exits", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.cancel();
                                    }
                                });
                        AlertDialog dialog = builder.create();
                        dialog.show();

                        Bundle params = new Bundle();
                        params.putString("message", message);
                        new GraphRequest(
                                AccessToken.getCurrentAccessToken(),
                                "/me/feed",
                                params,
                                HttpMethod.POST,
                                new GraphRequest.Callback() {
                                    public void onCompleted(GraphResponse response) {
                                        Toast.makeText(AccountActivity.this, "Post Status Success", Toast.LENGTH_LONG).show();
                                        GraphRequest request = new GraphRequest(
                                                AccessToken.getCurrentAccessToken(),
                                                "/me/feed",
                                                null,
                                                HttpMethod.GET,
                                                new GraphRequest.Callback() {
                                                    public void onCompleted(GraphResponse response) {

                                                        // JSON GETS THE DATA
                                                        JSONObject jsonData = response.getJSONObject();

                                                        try {

                                                            JSONArray postsData = jsonData.getJSONArray("data");
                                                            if (postsData != null) {

                                                                for (int i = 0; i < postsData.length(); i++) {
                                                                    JSONObject story = postsData.getJSONObject(i);

                                                                    if (story.has("id")) {
                                                                        String timeMessage = story.getString("id");
                                                                        String facebook = "https://www.facebook.com/" + timeMessage;
                                                                        Uri uri = Uri.parse(facebook);
                                                                        Intent intentfb = new Intent(Intent.ACTION_VIEW, uri);
                                                                        startActivity(intentfb);
                                                                    }

                                                                }


                                                            }

                                                        } catch (Exception e) {
                                                            Log.d("JSON", "error" + e.toString());
                                                        }

                                                    }
                                                }
                                        );
                                        Bundle parameters = new Bundle();
                                        parameters.putString("fields", "id");
                                        parameters.putString("limit", "1");
                                        request.setParameters(parameters);
                                        request.executeAsync();
                                    }
                                }
                        ).executeAsync();

                    }

                }
            }else if(checkboxstate6 == 0) {

                if (countchexkemo == 0 && checkshortcut > 0) {


                    Bundle params = new Bundle();
                    params.putString("message", message);

//                        while (itremo.hasNext()) {
//
//
//                            emoneutral.append(itremo.next().toString() + " ");
//                            countnum++;
//
//
//                        }
                    if(arrMapping.size() == 0){
                        emoneutral.append("-");
                    }else if(arrMapping.size() == 1){
                        if(arrMapping.contains("ไม่แสดงอารมณ์")){
                            emoneutral.append("-");
                        }else{
                            for(String s : arrMapping) {
                                emoneutral.append(s);
                            }
                        }
                    }else{
                        if(arrMapping.contains("ไม่แสดงอารมณ์")){
                            arrMapping.remove("ไม่แสดงอารมณ์");
                        }
                        for(String s : arrMapping) {
                            emoneutral.append(s + " ");
                        }

                    }

//                        if (countnum == 0) {
//
//                            emoneutral.append("-");
//                        }
                    final Dialog dialog = new Dialog(AccountActivity.this,R.style.FullHeightDialog);
                    dialog.setContentView(R.layout.neural_layout);
                    //dialog.setTitle("");


                    TextView textatti = (TextView) dialog.findViewById(R.id.textneuralatti);
                    TextView textemo = (TextView) dialog.findViewById(R.id.textneuralemo);
                    Button dialogButton3 = (Button) dialog.findViewById(R.id.btncheckneural);

                    textatti.setText("ทัศนคติ(Attitude)  : เป็นกลาง(Unexpressed)");
                    textemo.setText("อารมณ์(Emotion) : " + emoneutral);
                    ImageView image = (ImageView) dialog.findViewById(R.id.imageviewneural);
                    image.setImageResource(R.drawable.yellow);

                    Button dialogButton = (Button) dialog.findViewById(R.id.postneural_btn);
                    Button dialogButton2 = (Button) dialog.findViewById(R.id.noneural_btn);
                    dialogButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Bundle params = new Bundle();
                            params.putString("message", message);
                            new GraphRequest(
                                    AccessToken.getCurrentAccessToken(),
                                    "/me/feed",
                                    params,
                                    HttpMethod.POST,
                                    new GraphRequest.Callback() {
                                        public void onCompleted(GraphResponse response) {
                                            Toast.makeText(AccountActivity.this, "Post Status Success", Toast.LENGTH_LONG).show();
                                            GraphRequest request = new GraphRequest(
                                                    AccessToken.getCurrentAccessToken(),
                                                    "/me/feed",
                                                    null,
                                                    HttpMethod.GET,
                                                    new GraphRequest.Callback() {
                                                        public void onCompleted(GraphResponse response) {

                                                            // JSON GETS THE DATA
                                                            JSONObject jsonData = response.getJSONObject();

                                                            try {

                                                                JSONArray postsData = jsonData.getJSONArray("data");
                                                                if (postsData != null) {

                                                                    for (int i = 0; i < postsData.length(); i++) {
                                                                        JSONObject story = postsData.getJSONObject(i);

                                                                        if (story.has("id")) {
                                                                            String timeMessage = story.getString("id");
                                                                            String facebook = "https://www.facebook.com/" + timeMessage;
                                                                            Uri uri = Uri.parse(facebook);
                                                                            Intent intentfb = new Intent(Intent.ACTION_VIEW, uri);
                                                                            startActivity(intentfb);
                                                                        }

                                                                    }


                                                                }

                                                            } catch (Exception e) {
                                                                Log.d("JSON", "error" + e.toString());
                                                            }

                                                        }
                                                    }
                                            );
                                            Bundle parameters = new Bundle();
                                            parameters.putString("fields", "id");
                                            parameters.putString("limit", "1");
                                            request.setParameters(parameters);
                                            request.executeAsync();
                                        }
                                    }
                            ).executeAsync();
                            editTextpost.setText("");

                            dialog.dismiss();
                        }
                    });

                    dialogButton2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });

                    dialogButton3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(AccountActivity.this);
                            builder.setMessage(message + "\n\n" + checkwd + "\n\n" + checksc).setTitle("AlertDialog").setCancelable(false)
                                    .setNegativeButton("Exits", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            dialogInterface.cancel();
                                        }
                                    });
                            AlertDialog dialog = builder.create();
                            dialog.show();

                        }
                    });


                    dialog.show();


                } else if (countchexkemo < 0 && checkshortcut > 0) {

                    Bundle params = new Bundle();
                    params.putString("message", message);


//                        while (itremo.hasNext()) {
//
//
//                            emonegetive.append(itremo.next().toString() + " ");
//                            countnum2++;
//
//
//                        }
                    if(arrMapping.size() == 0){
                        emonegetive.append("-");
                    }else if(arrMapping.size() == 1){
                        if(arrMapping.contains("ไม่แสดงอารมณ์")){
                            emonegetive.append("-");
                        }else{
                            for(String s : arrMapping) {
                                emonegetive.append(s);
                            }
                        }
                    }else{
                        if(arrMapping.contains("ไม่แสดงอารมณ์")){
                            arrMapping.remove("ไม่แสดงอารมณ์");
                        }
                        for(String s : arrMapping) {
                            emonegetive.append(s + " ");
                        }

                    }

//                        if (countnum2 == 0) {
//                            emonegetive.append("-");
//                        }
                    final Dialog dialog = new Dialog(AccountActivity.this,R.style.FullHeightDialog);
                    dialog.setContentView(R.layout.negetive_layout);
                    //dialog.setTitle("");


                    TextView textatti = (TextView) dialog.findViewById(R.id.textnegetiveatti);
                    TextView textemo = (TextView) dialog.findViewById(R.id.textnegetiveemo);
                    Button dialogButton3 = (Button) dialog.findViewById(R.id.btnchecknegetive);
                    TextView textnotifi = (TextView) dialog.findViewById(R.id.textnotifi);
                    textnotifi.setText("คำแนะนำ : ไม่ควรโพสต์สถานะที่แสดงทัศนคติทางลบ ลองเปลี่ยนการใช้คำ");

                    textatti.setText("ทัศนคติ(Attitude) : เชิงลบ(Negative)");
                    textemo.setText("อารมณ์(Emotion) : " + emonegetive);
                    ImageView image = (ImageView) dialog.findViewById(R.id.imageviewnegetive);
                    image.setImageResource(R.drawable.red);

                    Button dialogButton = (Button) dialog.findViewById(R.id.postnegetive_btn);
                    Button dialogButton2 = (Button) dialog.findViewById(R.id.nonegetive_btn);
                    dialogButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Bundle params = new Bundle();
                            params.putString("message", message);
                            new GraphRequest(
                                    AccessToken.getCurrentAccessToken(),
                                    "/me/feed",
                                    params,
                                    HttpMethod.POST,
                                    new GraphRequest.Callback() {
                                        public void onCompleted(GraphResponse response) {
                                            Toast.makeText(AccountActivity.this, "Post Status Success", Toast.LENGTH_LONG).show();
                                            GraphRequest request = new GraphRequest(
                                                    AccessToken.getCurrentAccessToken(),
                                                    "/me/feed",
                                                    null,
                                                    HttpMethod.GET,
                                                    new GraphRequest.Callback() {
                                                        public void onCompleted(GraphResponse response) {

                                                            // JSON GETS THE DATA
                                                            JSONObject jsonData = response.getJSONObject();

                                                            try {

                                                                JSONArray postsData = jsonData.getJSONArray("data");
                                                                if (postsData != null) {

                                                                    for (int i = 0; i < postsData.length(); i++) {
                                                                        JSONObject story = postsData.getJSONObject(i);

                                                                        if (story.has("id")) {
                                                                            String timeMessage = story.getString("id");
                                                                            String facebook = "https://www.facebook.com/" + timeMessage;
                                                                            Uri uri = Uri.parse(facebook);
                                                                            Intent intentfb = new Intent(Intent.ACTION_VIEW, uri);
                                                                            startActivity(intentfb);
                                                                        }

                                                                    }


                                                                }

                                                            } catch (Exception e) {
                                                                Log.d("JSON", "error" + e.toString());
                                                            }

                                                        }
                                                    }
                                            );
                                            Bundle parameters = new Bundle();
                                            parameters.putString("fields", "id");
                                            parameters.putString("limit", "1");
                                            request.setParameters(parameters);
                                            request.executeAsync();
                                        }
                                    }
                            ).executeAsync();
                            editTextpost.setText("");
                            if(countneg >=6)
                                showNotification(v);
                            dialog.dismiss();
                        }
                    });

                    dialogButton2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });

                    dialogButton3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(AccountActivity.this);
                            builder.setMessage(message + "\n\n" + checkwd + "\n\n" + checksc).setTitle("AlertDialog").setCancelable(false)
                                    .setNegativeButton("Exits", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            dialogInterface.cancel();
                                        }
                                    });
                            AlertDialog dialog = builder.create();
                            dialog.show();

                        }
                    });

                    dialog.show();


                } else if (countchexkemo > 0 && checkshortcut > 0) {

                    Bundle params = new Bundle();
                    params.putString("message", message);

//                        while (itremo.hasNext()) {
//
//
//                            emopositive.append(itremo.next().toString() + " ");
//                            countnum3++;
//
//
//                        }
                    if(arrMapping.size() == 0){
                        emopositive.append("-");
                    }else if(arrMapping.size() == 1){
                        if(arrMapping.contains("ไม่แสดงอารมณ์")){
                            emopositive.append("-");
                        }else{
                            for(String s : arrMapping) {
                                emopositive.append(s);
                            }
                        }
                    }else{
                        if(arrMapping.contains("ไม่แสดงอารมณ์")){
                            arrMapping.remove("ไม่แสดงอารมณ์");
                        }
                        for(String s : arrMapping) {
                            emopositive.append(s + " ");
                        }

                    }

//                        if (countnum3 == 0) {
//                            emopositive.append("-");
//
//                        }
                    final Dialog dialog = new Dialog(AccountActivity.this,R.style.FullHeightDialog);
                    dialog.setContentView(R.layout.positive_layout);
                    //dialog.setTitle("");


                    TextView textatti = (TextView) dialog.findViewById(R.id.textpositiveatti);
                    TextView textemo = (TextView) dialog.findViewById(R.id.textpositiveemo);

                    Button dialogButton3 = (Button) dialog.findViewById(R.id.btnpostsitive);

                    textatti.setText("ทัศนคติ(Attitude) : เชิงบวก(Positive)");
                    textemo.setText("อารมณ์(Emotion) : " + emopositive);
                    ImageView image = (ImageView) dialog.findViewById(R.id.imageviewpositive);
                    image.setImageResource(R.drawable.green);

                    Button dialogButton = (Button) dialog.findViewById(R.id.post_btn);
                    Button dialogButton2 = (Button) dialog.findViewById(R.id.no_btn);
                    dialogButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Bundle params = new Bundle();
                            params.putString("message", message);
                            new GraphRequest(
                                    AccessToken.getCurrentAccessToken(),
                                    "/me/feed",
                                    params,
                                    HttpMethod.POST,
                                    new GraphRequest.Callback() {
                                        public void onCompleted(GraphResponse response) {
                                            Toast.makeText(AccountActivity.this, "Post Status Success", Toast.LENGTH_LONG).show();
                                            GraphRequest request = new GraphRequest(
                                                    AccessToken.getCurrentAccessToken(),
                                                    "/me/feed",
                                                    null,
                                                    HttpMethod.GET,
                                                    new GraphRequest.Callback() {
                                                        public void onCompleted(GraphResponse response) {

                                                            // JSON GETS THE DATA
                                                            JSONObject jsonData = response.getJSONObject();

                                                            try {

                                                                JSONArray postsData = jsonData.getJSONArray("data");
                                                                if (postsData != null) {

                                                                    for (int i = 0; i < postsData.length(); i++) {
                                                                        JSONObject story = postsData.getJSONObject(i);

                                                                        if (story.has("id")) {
                                                                            String timeMessage = story.getString("id");
                                                                            String facebook = "https://www.facebook.com/" + timeMessage;
                                                                            Uri uri = Uri.parse(facebook);
                                                                            Intent intentfb = new Intent(Intent.ACTION_VIEW, uri);
                                                                            startActivity(intentfb);
                                                                        }

                                                                    }


                                                                }

                                                            } catch (Exception e) {
                                                                Log.d("JSON", "error" + e.toString());
                                                            }

                                                        }
                                                    }
                                            );
                                            Bundle parameters = new Bundle();
                                            parameters.putString("fields", "id");
                                            parameters.putString("limit", "1");
                                            request.setParameters(parameters);
                                            request.executeAsync();
                                        }
                                    }
                            ).executeAsync();
                            editTextpost.setText("");

                            dialog.dismiss();
                        }
                    });

                    dialogButton2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });

                    dialogButton3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(AccountActivity.this);
                            builder.setMessage(message + "\n\n" + checkwd + "\n\n" + checksc).setTitle("AlertDialog").setCancelable(false)
                                    .setNegativeButton("Exits", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            dialogInterface.cancel();
                                        }
                                    });
                            AlertDialog dialog = builder.create();
                            dialog.show();

                        }
                    });


                    dialog.show();


                } else {


                    if (count == 0 && checkemo > 0) {


                        Bundle params = new Bundle();
                        params.putString("message", message);

//                            while (itremo.hasNext()) {
//
//
//                                emoneutral.append(itremo.next() + " ");
//                                countnum++;
//
//
//                            }
                        if(arrMapping.size() == 0){
                            emoneutral.append("-");
                        }else if(arrMapping.size() == 1){
                            if(arrMapping.contains("ไม่แสดงอารมณ์")){
                                emoneutral.append("-");
                            }else{
                                for(String s : arrMapping) {
                                    emoneutral.append(s);
                                }
                            }
                        }else{
                            if(arrMapping.contains("ไม่แสดงอารมณ์")){
                                arrMapping.remove("ไม่แสดงอารมณ์");
                            }
                            for(String s : arrMapping) {
                                emoneutral.append(s + " ");
                            }

                        }
//                            if (countnum == 0) {
//
//                                emoneutral.append("-");
//                            }
                        final Dialog dialog = new Dialog(AccountActivity.this,R.style.FullHeightDialog);
                        dialog.setContentView(R.layout.neural_layout);
                        //dialog.setTitle("");


                        TextView textatti = (TextView) dialog.findViewById(R.id.textneuralatti);
                        TextView textemo = (TextView) dialog.findViewById(R.id.textneuralemo);
                        Button dialogButton3 = (Button) dialog.findViewById(R.id.btncheckneural);

                        textatti.setText("ทัศนคติ(Attitude)  : เป็นกลาง(Unexpressed)");
                        textemo.setText("อารมณ์(Emotion) : " + emoneutral);
                        ImageView image = (ImageView) dialog.findViewById(R.id.imageviewneural);
                        image.setImageResource(R.drawable.yellow);

                        Button dialogButton = (Button) dialog.findViewById(R.id.postneural_btn);
                        Button dialogButton2 = (Button) dialog.findViewById(R.id.noneural_btn);
                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Bundle params = new Bundle();
                                params.putString("message", message);
                                new GraphRequest(
                                        AccessToken.getCurrentAccessToken(),
                                        "/me/feed",
                                        params,
                                        HttpMethod.POST,
                                        new GraphRequest.Callback() {
                                            public void onCompleted(GraphResponse response) {
                                                Toast.makeText(AccountActivity.this, "Post Status Success", Toast.LENGTH_LONG).show();
                                                GraphRequest request = new GraphRequest(
                                                        AccessToken.getCurrentAccessToken(),
                                                        "/me/feed",
                                                        null,
                                                        HttpMethod.GET,
                                                        new GraphRequest.Callback() {
                                                            public void onCompleted(GraphResponse response) {

                                                                // JSON GETS THE DATA
                                                                JSONObject jsonData = response.getJSONObject();

                                                                try {

                                                                    JSONArray postsData = jsonData.getJSONArray("data");
                                                                    if (postsData != null) {

                                                                        for (int i = 0; i < postsData.length(); i++) {
                                                                            JSONObject story = postsData.getJSONObject(i);

                                                                            if (story.has("id")) {
                                                                                String timeMessage = story.getString("id");
                                                                                String facebook = "https://www.facebook.com/" + timeMessage;
                                                                                Uri uri = Uri.parse(facebook);
                                                                                Intent intentfb = new Intent(Intent.ACTION_VIEW, uri);
                                                                                startActivity(intentfb);
                                                                            }

                                                                        }


                                                                    }

                                                                } catch (Exception e) {
                                                                    Log.d("JSON", "error" + e.toString());
                                                                }

                                                            }
                                                        }
                                                );
                                                Bundle parameters = new Bundle();
                                                parameters.putString("fields", "id");
                                                parameters.putString("limit", "1");
                                                request.setParameters(parameters);
                                                request.executeAsync();
                                            }
                                        }
                                ).executeAsync();
                                editTextpost.setText("");

                                dialog.dismiss();
                            }
                        });

                        dialogButton2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                            }
                        });

                        dialogButton3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(AccountActivity.this);
                                builder.setMessage(message + "\n\n" + checkwd + "\n\n" + checksc).setTitle("AlertDialog").setCancelable(false)
                                        .setNegativeButton("Exits", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                dialogInterface.cancel();
                                            }
                                        });
                                AlertDialog dialog = builder.create();
                                dialog.show();

                            }
                        });

                        dialog.show();


                    } else if (count < 0 && checkemo > 0) {

                        Bundle params = new Bundle();
                        params.putString("message", message);


//                            while (itremo.hasNext()) {
//
//
//                                emonegetive.append(itremo.next() + " ");
//                                countnum2++;
//
//
//                            }
                        if(arrMapping.size() == 0){
                            emonegetive.append("-");
                        }else if(arrMapping.size() == 1){
                            if(arrMapping.contains("ไม่แสดงอารมณ์")){
                                emonegetive.append("-");
                            }else{
                                for(String s : arrMapping) {
                                    emonegetive.append(s);
                                }
                            }
                        }else{
                            if(arrMapping.contains("ไม่แสดงอารมณ์")){
                                arrMapping.remove("ไม่แสดงอารมณ์");
                            }
                            for(String s : arrMapping) {
                                emonegetive.append(s + " ");
                            }

                        }

//                            if (countnum2 == 0) {
//                                emonegetive.append("-");
//                            }
                        final Dialog dialog = new Dialog(AccountActivity.this,R.style.FullHeightDialog);
                        dialog.setContentView(R.layout.negetive_layout);
                        //dialog.setTitle("");


                        TextView textatti = (TextView) dialog.findViewById(R.id.textnegetiveatti);
                        TextView textemo = (TextView) dialog.findViewById(R.id.textnegetiveemo);
                        TextView  textnotifi = (TextView) dialog.findViewById(R.id.textnotifi);
                        Button dialogButton3 = (Button) dialog.findViewById(R.id.btnchecknegetive);

                        if(countNotifi==-3 && countNotifi > 0){
                            textnotifi.setText("คำแนะนำ : สถานะที่โพสต์มีคำหยาบมาก ควรเปลี่ยนการใช้คำ");
                        }else if(countNotifi<-3 && countNotifi > 0){
                            textnotifi.setText("คำแนะนำ : สถานะที่โพสต์มีคำหยาบค่อนข้างมาก ควรเปลี่ยนการใช้คำ");
                        }else if(countNotifi > 0){
                            textnotifi.setText("คำแนะนำ : สถานะที่โพสต์มีคำหยาบ ควรเปลี่ยนการใช้คำ");
                        }else{

                            textnotifi.setText("คำแนะนำ : ไม่ควรโพสต์สถานะที่แสดงทัศนคติทางลบ ลองเปลี่ยนการใช้คำ");
                        }

                        textatti.setText("ทัศนคติ(Attitude) : เชิงลบ(Negative)");
                        textemo.setText("อารมณ์(Emotion) : " + emonegetive);
                        ImageView image = (ImageView) dialog.findViewById(R.id.imageviewnegetive);
                        image.setImageResource(R.drawable.red);

                        Button dialogButton = (Button) dialog.findViewById(R.id.postnegetive_btn);
                        Button dialogButton2 = (Button) dialog.findViewById(R.id.nonegetive_btn);
                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Bundle params = new Bundle();
                                params.putString("message", message);
                                new GraphRequest(
                                        AccessToken.getCurrentAccessToken(),
                                        "/me/feed",
                                        params,
                                        HttpMethod.POST,
                                        new GraphRequest.Callback() {
                                            public void onCompleted(GraphResponse response) {
                                                Toast.makeText(AccountActivity.this, "Post Status Success", Toast.LENGTH_LONG).show();
                                                GraphRequest request = new GraphRequest(
                                                        AccessToken.getCurrentAccessToken(),
                                                        "/me/feed",
                                                        null,
                                                        HttpMethod.GET,
                                                        new GraphRequest.Callback() {
                                                            public void onCompleted(GraphResponse response) {

                                                                // JSON GETS THE DATA
                                                                JSONObject jsonData = response.getJSONObject();

                                                                try {

                                                                    JSONArray postsData = jsonData.getJSONArray("data");
                                                                    if (postsData != null) {

                                                                        for (int i = 0; i < postsData.length(); i++) {
                                                                            JSONObject story = postsData.getJSONObject(i);

                                                                            if (story.has("id")) {
                                                                                String timeMessage = story.getString("id");
                                                                                String facebook = "https://www.facebook.com/" + timeMessage;
                                                                                Uri uri = Uri.parse(facebook);
                                                                                Intent intentfb = new Intent(Intent.ACTION_VIEW, uri);
                                                                                startActivity(intentfb);
                                                                            }

                                                                        }


                                                                    }

                                                                } catch (Exception e) {
                                                                    Log.d("JSON", "error" + e.toString());
                                                                }

                                                            }
                                                        }
                                                );
                                                Bundle parameters = new Bundle();
                                                parameters.putString("fields", "id");
                                                parameters.putString("limit", "1");
                                                request.setParameters(parameters);
                                                request.executeAsync();
                                            }
                                        }
                                ).executeAsync();
                                editTextpost.setText("");
                                if(countneg >=6)
                                    showNotification(v);
                                dialog.dismiss();
                            }
                        });

                        dialogButton2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                            }
                        });

                        dialogButton3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(AccountActivity.this);
                                builder.setMessage(message + "\n\n" + checkwd + "\n\n" + checksc).setTitle("AlertDialog").setCancelable(false)
                                        .setNegativeButton("Exits", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                dialogInterface.cancel();
                                            }
                                        });
                                AlertDialog dialog = builder.create();
                                dialog.show();

                            }
                        });

                        dialog.show();


                    } else if (count > 0 && checkemo > 0) {

                        Bundle params = new Bundle();
                        params.putString("message", message);


//                            while (itremo.hasNext()) {
//
//
//                                emopositive.append(itremo.next().toString() + " ");
//                                countnum3++;
//
//
//                            }
                        if(arrMapping.size() == 0){
                            emopositive.append("-");
                        }else if(arrMapping.size() == 1){
                            if(arrMapping.contains("ไม่แสดงอารมณ์")){
                                emopositive.append("-");
                            }else{
                                for(String s : arrMapping) {
                                    emopositive.append(s);
                                }
                            }
                        }else{
                            if(arrMapping.contains("ไม่แสดงอารมณ์")){
                                arrMapping.remove("ไม่แสดงอารมณ์");
                            }
                            for(String s : arrMapping) {
                                emopositive.append(s + " ");
                            }

                        }

//                            if (countnum3 == 0) {
//                                emopositive.append("-");
//
//                            }
                        final Dialog dialog = new Dialog(AccountActivity.this,R.style.FullHeightDialog);
                        dialog.setContentView(R.layout.positive_layout);
                        //dialog.setTitle("");

                        TextView textatti = (TextView) dialog.findViewById(R.id.textpositiveatti);
                        TextView textemo = (TextView) dialog.findViewById(R.id.textpositiveemo);
                        textatti.setText("ทัศนคติ(Attitude) : เชิงบวก(Positive)");
                        textemo.setText("อารมณ์(Emotion) : " + emopositive);
                        ImageView image = (ImageView) dialog.findViewById(R.id.imageviewpositive);
                        image.setImageResource(R.drawable.green);

                        Button dialogButton = (Button) dialog.findViewById(R.id.post_btn);
                        Button dialogButton2 = (Button) dialog.findViewById(R.id.no_btn);
                        Button dialogButton3 = (Button) dialog.findViewById(R.id.btnpostsitive);
                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Bundle params = new Bundle();
                                params.putString("message", message);
                                new GraphRequest(
                                        AccessToken.getCurrentAccessToken(),
                                        "/me/feed",
                                        params,
                                        HttpMethod.POST,
                                        new GraphRequest.Callback() {
                                            public void onCompleted(GraphResponse response) {
                                                Toast.makeText(AccountActivity.this, "Post Status Success", Toast.LENGTH_LONG).show();
                                                GraphRequest request = new GraphRequest(
                                                        AccessToken.getCurrentAccessToken(),
                                                        "/me/feed",
                                                        null,
                                                        HttpMethod.GET,
                                                        new GraphRequest.Callback() {
                                                            public void onCompleted(GraphResponse response) {

                                                                // JSON GETS THE DATA
                                                                JSONObject jsonData = response.getJSONObject();

                                                                try {

                                                                    JSONArray postsData = jsonData.getJSONArray("data");
                                                                    if (postsData != null) {

                                                                        for (int i = 0; i < postsData.length(); i++) {
                                                                            JSONObject story = postsData.getJSONObject(i);

                                                                            if (story.has("id")) {
                                                                                String timeMessage = story.getString("id");
                                                                                String facebook = "https://www.facebook.com/" + timeMessage;
                                                                                Uri uri = Uri.parse(facebook);
                                                                                Intent intentfb = new Intent(Intent.ACTION_VIEW, uri);
                                                                                startActivity(intentfb);
                                                                            }

                                                                        }


                                                                    }

                                                                } catch (Exception e) {
                                                                    Log.d("JSON", "error" + e.toString());
                                                                }

                                                            }
                                                        }
                                                );
                                                Bundle parameters = new Bundle();
                                                parameters.putString("fields", "id");
                                                parameters.putString("limit", "1");
                                                request.setParameters(parameters);
                                                request.executeAsync();
                                            }
                                        }
                                ).executeAsync();

                                editTextpost.setText("");


                                dialog.dismiss();
                            }
                        });

                        dialogButton2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                            }
                        });

                        dialogButton3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(AccountActivity.this);
                                builder.setMessage(message + "\n\n" + checkwd + "\n\n" + checksc).setTitle("AlertDialog").setCancelable(false)
                                        .setNegativeButton("Exits", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                dialogInterface.cancel();
                                            }
                                        });
                                AlertDialog dialog = builder.create();
                                dialog.show();

                            }
                        });

                        dialog.show();


                    } else {

                        AlertDialog.Builder builder = new AlertDialog.Builder(AccountActivity.this);
                        builder.setMessage(message + "\n\n" + checkwd + "\n\n" + checksc).setTitle("AlertDialog").setCancelable(false)
                                .setNegativeButton("Exits", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.cancel();
                                    }
                                });
                        AlertDialog dialog = builder.create();
                        dialog.show();

                        Bundle params = new Bundle();
                        params.putString("message", message);
                        new GraphRequest(
                                AccessToken.getCurrentAccessToken(),
                                "/me/feed",
                                params,
                                HttpMethod.POST,
                                new GraphRequest.Callback() {
                                    public void onCompleted(GraphResponse response) {
                                        Toast.makeText(AccountActivity.this, "Post Status Success", Toast.LENGTH_LONG).show();
                                        GraphRequest request = new GraphRequest(
                                                AccessToken.getCurrentAccessToken(),
                                                "/me/feed",
                                                null,
                                                HttpMethod.GET,
                                                new GraphRequest.Callback() {
                                                    public void onCompleted(GraphResponse response) {

                                                        // JSON GETS THE DATA
                                                        JSONObject jsonData = response.getJSONObject();

                                                        try {

                                                            JSONArray postsData = jsonData.getJSONArray("data");
                                                            if (postsData != null) {

                                                                for (int i = 0; i < postsData.length(); i++) {
                                                                    JSONObject story = postsData.getJSONObject(i);

                                                                    if (story.has("id")) {
                                                                        String timeMessage = story.getString("id");
                                                                        String facebook = "https://www.facebook.com/" + timeMessage;
                                                                        Uri uri = Uri.parse(facebook);
                                                                        Intent intentfb = new Intent(Intent.ACTION_VIEW, uri);
                                                                        startActivity(intentfb);
                                                                    }

                                                                }


                                                            }

                                                        } catch (Exception e) {
                                                            Log.d("JSON", "error" + e.toString());
                                                        }

                                                    }
                                                }
                                        );
                                        Bundle parameters = new Bundle();
                                        parameters.putString("fields", "id");
                                        parameters.putString("limit", "1");
                                        request.setParameters(parameters);
                                        request.executeAsync();
                                    }
                                }
                        ).executeAsync();

                    }


                }
            }





        }



        ////check graph สรุปจำนวนโพสต์




        databaseRealtime = new DatabaseRealtime(getApplicationContext());
        databaseRealtime.getReadableDatabase();

        Calendar check = Calendar.getInstance();
        check.add(Calendar.DATE,0);
        SimpleDateFormat realdatecurrent = new SimpleDateFormat("yyyy-MM-dd");
        String datecurrent = realdatecurrent.format(check.getTime());



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

        final String datecheck1 = datetime.get(0).get("Date");
        final String datecheck2 = datetime.get(1).get("Date");
        final String datecheck3 = datetime.get(2).get("Date");
        final String datecheck4 = datetime.get(3).get("Date");
        final String datecheck5 = datetime.get(4).get("Date");
        final String datecheck6 = datetime.get(5).get("Date");
        final String datecheck7 = datetime.get(6).get("Date");
        final String datecheck8 = datetime.get(7).get("Date");

        final String pattern = "([0-9-]{10})";

        final Pattern regex = Pattern.compile(pattern);
///new Future


        SharedPreferences sp3 = getSharedPreferences("IDFB", Context.MODE_PRIVATE);
        int idFB = sp3.getInt("IDFB", 0);

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


        ///new Future

          //datecheck8
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

                                    //Toast.makeText(AccountActivity.this,String.valueOf(countgrapnege),Toast.LENGTH_SHORT).show();
                                    countneg = countgrapnege;

                                    SharedPreferences sharedPref = getSharedPreferences("countnoti", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedPref.edit();
                                    editor.putInt("countnoti", countneg);
                                    editor.commit();














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

        }else {


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

            SharedPreferences sp = getSharedPreferences("IDKey", Context.MODE_PRIVATE);
            String idkey = sp.getString("IDKey", "");
            databaseForSummary.updateDataSum(idkey,formattedDate ,formattedDate2 ,formattedDate3,formattedDate4,formattedDate5,formattedDate6,formattedDate7,formattedDate8);

            final String DateCheck11 = getIDFB.get(idFB).get("Date1");
            final String DateCheck22 = getIDFB.get(idFB).get("Date2");
            final String DateCheck33 = getIDFB.get(idFB).get("Date3");
            final String DateCheck44 = getIDFB.get(idFB).get("Date4");
            final String DateCheck55 = getIDFB.get(idFB).get("Date5");
            final String DateCheck66 = getIDFB.get(idFB).get("Date6");
            final String DateCheck77 = getIDFB.get(idFB).get("Date7");
            final String DateCheck88 = getIDFB.get(idFB).get("Date8");



//            Date1 = databaseRealtime.updateData("1", formattedDate);
//            Date2 = databaseRealtime.updateData("2", formattedDate2);
//            Date3 = databaseRealtime.updateData("3", formattedDate3);
//            Date4 = databaseRealtime.updateData("4", formattedDate4);
//            Date5 = databaseRealtime.updateData("5", formattedDate5);
//            Date6 = databaseRealtime.updateData("6", formattedDate6);
//            Date7 = databaseRealtime.updateData("7", formattedDate7);
//            Date8 = databaseRealtime.updateData("8", formattedDate8);
//
//
//            final String datecheck11 = datetime.get(0).get("Date");
//            final String datecheck22 = datetime.get(1).get("Date");
//            final String datecheck33 = datetime.get(2).get("Date");
//            final String datecheck44 = datetime.get(3).get("Date");
//            final String datecheck55 = datetime.get(4).get("Date");
//            final String datecheck66 = datetime.get(5).get("Date");
//            final String datecheck77 = datetime.get(6).get("Date");
//            final String datecheck88 = datetime.get(7).get("Date");

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

                                  countneg = countgrapnege;

                                    SharedPreferences sharedPref = getSharedPreferences("countnoti", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedPref.edit();
                                    editor.putInt("countnoti", countneg);
                                    editor.commit();










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

        ////end check graph สรุปจำนวนโพสต์









    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);


        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.account, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            LoginManager.getInstance().logOut();
            Intent intentlog = new Intent(AccountActivity.this, MainActivity.class);
            startActivity(intentlog);
            Toast.makeText(getApplicationContext(), "User logged out success", Toast.LENGTH_SHORT).show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        final Intent intent = getIntent();
        String jsondata = intent.getStringExtra("userProfile");
        JSONObject reponse;

        SharedPreferences sp2 = getSharedPreferences("userid", Context.MODE_PRIVATE);
        String idProfile = sp2.getString("userid", "");

        if (id == R.id.profile) {

            Intent myprofile = new Intent(AccountActivity.this,ProfileActivity.class);
            myprofile.putExtra("userProfile",jsondata);
            startActivity(myprofile);


        }
        else if (id == R.id.timeline) {

            Intent myTimeline = new Intent(AccountActivity.this,TimelineActivity.class);
            startActivity(myTimeline);

        } else if (id == R.id.graph) {

            Intent myGraph = new Intent(AccountActivity.this,SummaryActivity.class);
            startActivity(myGraph);


        } else if (id == R.id.setting) {

            Intent intentsetting = new Intent(AccountActivity.this,SettingActivity.class);
            intentsetting.putExtra("userProfile",jsondata);
            startActivity(intentsetting);




        }
        else if (id == R.id.facebook){



                String facebook = "https://www.facebook.com/"+idProfile;
                Uri uri = Uri.parse(facebook);
                Intent intentfb = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intentfb);

        }

        else if (id == R.id.friendlist){
            Intent intentsetting = new Intent(AccountActivity.this,FriendDetailActivity.class);
            intentsetting.putExtra("userProfile",jsondata);
            startActivity(intentsetting);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    protected void onResume() {
        super.onResume();
        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(this);
    }

    public void showNotification(View view) {

        Context context = AccountActivity.this;
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),
                R.mipmap.ic_launcher);

        // Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.red);
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Notification notification = new NotificationCompat.Builder(this) // this is context
                .setSmallIcon(R.mipmap.negred)
                .setLargeIcon(bitmap)
                .setContentTitle("โพสต์ทัศนคติทางลบบ่อยครั้ง!!!")
                .setContentText("ลองเปลี่ยนคำที่ใช้และพิจารณาก่อนโพสต์")
                .setNumber(countneg+1)
                .setAutoCancel(true)
                /*.setStyle(new NotificationCompat.BigPictureStyle()
                        .bigPicture(bitmap)
                        .bigLargeIcon(null))*/
                .setSound(alarmSound)
                .setVibrate(new long[] { 1000, 1000, 1000})
                .build();

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1000, notification);

        //showNotification(view);

    }



}
