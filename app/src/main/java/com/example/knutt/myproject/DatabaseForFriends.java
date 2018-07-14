package com.example.knutt.myproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseForFriends extends SQLiteOpenHelper{

    private static final int dbVersion = 1;
    private static final String dbName = "databaseFriends.sqlite";
    //create table Emotion
    private static final String tableNamefriend = "friendstable";
    private static final String colfriend1 = "FriendsID";
    private static final String colfriend2 = "FriendsIDFB";
    private static final String colfriend3 = "FriendsNameFB";





    public DatabaseForFriends(Context context) {

            super(context, dbName, null, dbVersion);

    }

    public ArrayList<HashMap<String,String>> getIDFriends(){
        try{

            ArrayList<HashMap<String,String>> arr = new ArrayList<HashMap<String,String>>();
            HashMap<String,String> map;
            SQLiteDatabase db = this.getReadableDatabase();
            String sql = "SELECT * FROM " + tableNamefriend;
            Cursor cur = db.rawQuery(sql,null);
            if(cur!= null){
                if(cur.moveToFirst()){

                    do{
                        map = new HashMap<String,String>();
                        map.put("FriendsID",cur.getString(0));
                        map.put("FriendsIDFB",cur.getString(1));
                        map.put("FriendsNameFB",cur.getString(2));
                        arr.add(map);

                    }while (cur.moveToNext());
                }

            }
            cur.close();
            db.close();
            return arr;
        }catch (Exception e){
            return null;
        }

    }





    public boolean insertnewData(String idfriends,String Name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(colfriend2,idfriends);
        contentValues.put(colfriend3,Name);
        long insert = db.insert(tableNamefriend,null,contentValues);
        return  true;
    }



    public void deleteAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ tableNamefriend);
        db.close();
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+tableNamefriend +"("+colfriend1+" INTEGER PRIMARY KEY,"+
                colfriend2+" TEXT,"+colfriend3+" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
