package com.example.knutt.myproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class FriendsActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private LinearLayout linearLayout;

    private TextView[] mDots;
    private int position;

    private SliderAdapter sliderAdapter;
    private DatabaseForFriends databaseForFriends ;
    private ArrayAdapter<String> addAdapter;
    private SliderAdapter AdapterArr;
    private ArrayList<String> arrayList = new ArrayList<String>();
    private ArrayList<String> arrayListAddid = new ArrayList<String>();
    private ListView listView;


//    public FriendsActivity(int position){
//        this.position = position;
//    }











    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        databaseForFriends = new DatabaseForFriends(getApplicationContext());
//        listView = (ListView) findViewById(R.id.ListviewFriend);
        ArrayList<HashMap<String, String>> test = databaseForFriends.getIDFriends();
        for(int i = 0;i<test.size();i++){
            String arr = test.get(i).get("FriendsIDFB");
            arrayList.add(arr);
        }


        GraphRequest request = GraphRequest.newGraphPathRequest(
                AccessToken.getCurrentAccessToken(),
                "/"+arrayList.get(0)+"/feed",
                new GraphRequest.Callback() {
                    @Override
                    public void onCompleted(GraphResponse response) {

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
                                    if(story.has("message")){
                                        String Message = story.getString("message");
                                        //arrayListAddid.add(Message);
                                        Toast.makeText(FriendsActivity.this,"message my friends ==> "+Message,Toast.LENGTH_SHORT).show();




                                    }



                                }



                            }



                        } catch (Exception e) {
                            Log.d("JSON", "error" + e.toString());
                        }

                    }
                });

        request.executeAsync();
        Bundle parameters = new Bundle();
        parameters.putString("fields", "created_time,message");
        request.setParameters(parameters);
        request.executeAsync();


        viewPager = (ViewPager)findViewById(R.id.sliderviewpage);
        linearLayout = (LinearLayout)findViewById(R.id.dotslide);

        sliderAdapter = new SliderAdapter(arrayList,this);





        viewPager.setAdapter(sliderAdapter);

        adddotPaging(0);

        viewPager.addOnPageChangeListener(viewlist);

    }



//    public String[] num(){
//        ArrayList<HashMap<String, String>> test = databaseForFriends.getIDFriends();
//        for(int i = 0;i<test.size();i++){
//            String arr = test.get(i).get("FriendsIDFB");
//            number[i] = arr;
//        }
//        Toast.makeText(FriendsActivity.this,"123 == "+String.valueOf(test.size()),Toast.LENGTH_LONG).show();
//return number ;
//
//    }


    public void adddotPaging(int posittion){

        final ArrayList<HashMap<String, String>> test = databaseForFriends.getIDFriends();

        mDots = new TextView[test.size()];
        linearLayout.removeAllViews();

        for(int i = 0;i<mDots.length;i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorPrimaryDark));

            linearLayout.addView(mDots[i]);



        }
        if(mDots.length > 0){
            mDots[posittion].setTextColor(getResources().getColor(R.color.colorAccent));
        }
    }

    ViewPager.OnPageChangeListener viewlist = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
              adddotPaging(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }


    };


}


