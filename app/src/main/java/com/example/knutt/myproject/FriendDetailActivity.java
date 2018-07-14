package com.example.knutt.myproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.login.widget.ProfilePictureView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


import jp.wasabeef.picasso.transformations.CropCircleTransformation;

import static com.facebook.FacebookSdk.getApplicationContext;

public class FriendDetailActivity extends AppCompatActivity {

private ListView listView;
private DatabaseForFriends databaseForFriends;
private ArrayList<String> addName = new ArrayList<>();
private ArrayList<String> addID= new ArrayList<>();
private TreeMap<String,String> add = new TreeMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_detail);

        databaseForFriends = new DatabaseForFriends(getApplicationContext());
        ArrayList<HashMap<String, String>> test = databaseForFriends.getIDFriends();
        for(int i = 0;i<test.size();i++){
            add.put(test.get(i).get("FriendsIDFB"),test.get(i).get("FriendsNameFB"));


        }
        Map<String, String> sortedMap = sortByValue(add);
        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            addID.add(entry.getKey());
            addName.add(entry.getValue());

        }






        listView = (ListView)findViewById(R.id.Listview);
        MyAdapter myAdapter = new MyAdapter(this,addName,addID);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = addName.get(i);
                String id = addID.get(i);
                SharedPreferences sharedPref = getSharedPreferences("friendname", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("name", name);
                editor.commit();
                SharedPreferences sharedPref2 = getSharedPreferences("friendname2", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor2 = sharedPref2.edit();
                editor2.putString("id", id);
                editor2.commit();
               // Toast.makeText(FriendDetailActivity.this,name+id,Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(FriendDetailActivity.this,FriendTimelineActivity.class);
                startActivity(intent);
            }
        });





    }
    private static Map<String, String> sortByValue(Map<String,String> add) {


        List<Map.Entry<String, String>> list = new LinkedList<Map.Entry<String, String>>(add.entrySet());


        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            public int compare(Map.Entry<String, String> o1,
                               Map.Entry<String, String> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });


        Map<String, String> sortedMap = new LinkedHashMap<String, String>();
        for (Map.Entry<String, String> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }




        return sortedMap;
    }

}

class MyAdapter extends ArrayAdapter<String>{
    Context context;
    ArrayList<String> name;
    ArrayList<String> id ;

    public MyAdapter(Context context, ArrayList<String> name,ArrayList<String> id) {
        super(context, R.layout.index_paging,R.id.textname,name);
        this.context = context;
        this.name = name;
        this.id = id;
    }
    @Override
    public View getView(int position,View convertView,ViewGroup parent ){
        LayoutInflater layoutInflater =(LayoutInflater) getApplicationContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.index_paging,parent,false);

        TextView textView = (TextView) row.findViewById(R.id.textname);

        ImageView profilePic = (ImageView) row.findViewById(R.id.profilepagging);

        Picasso.get()
                .load("https://graph.facebook.com/v2.2/" + id.get(position) + "/picture?height=120&type=normal") //extract as User instance method
                .transform(new CropCircleTransformation())
                .resize(120, 120)
                .into(profilePic);





        textView.setTextColor(Color.WHITE);

        textView.setText(name.get(position));





        return row;

    }

}




