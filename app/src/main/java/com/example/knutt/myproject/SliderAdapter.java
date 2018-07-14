package com.example.knutt.myproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.widget.ProfilePictureView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class SliderAdapter extends PagerAdapter{





    Context context;
    LayoutInflater layoutInflater;

    private ArrayList<String> arrAdd = new ArrayList<>();
    private ArrayList<String> arrState = new ArrayList<>();
    private ListView listView;
     private ArrayAdapter<String> adapter;
    private ArrayAdapter<String> addarradapter;
    private FriendsActivity friendsActivity;











    public SliderAdapter(ArrayList<String> arr,Context context){
        this.context = context;
        this.arrAdd = arr;

    }
    public SliderAdapter(ArrayAdapter<String> arrayAdapter){
        this.adapter = arrayAdapter;
    }






    @Override
    public int getCount() {

        return arrAdd.size();

    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {


        return view == (RelativeLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

//       friendsActivity = new FriendsActivity(position);




        layoutInflater =(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container,false);





        ProfilePictureView profilePictureView = (ProfilePictureView) view.findViewById(R.id.profileview);



        profilePictureView.setProfileId(arrAdd.get(position));
        addData(friendsActivity,position);








       container.addView(view);
       return  view;

    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }



    public void addData(final FriendsActivity friendsActivity, int position){

           GraphRequest request = GraphRequest.newGraphPathRequest(
                AccessToken.getCurrentAccessToken(),
                "/"+arrAdd.get(position)+"/feed",
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
                                        arrState.add(Message);




                                    }



                                }



                            }

                            addarradapter = new ArrayAdapter<String>(friendsActivity,R.layout.index_listviewfriend,arrState);
                            listView.setAdapter(addarradapter);




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


    }










}
