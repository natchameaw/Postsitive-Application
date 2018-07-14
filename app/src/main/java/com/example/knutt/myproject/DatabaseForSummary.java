package com.example.knutt.myproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseForSummary extends SQLiteOpenHelper {

    private static final int dbVersion = 1;
    private static final String dbName = "databaseSummary.sqlite";

    private static final String tableNameSummary = "Summarytable";
    private static final String colID = "ID";
    private static final String colIDFB = "fbID";
    private static final String colDate1 = "Date1";
    private static final String colDate2 = "Date2";
    private static final String colDate3 = "Date3";
    private static final String colDate4 = "Date4";
    private static final String colDate5 = "Date5";
    private static final String colDate6 = "Date6";
    private static final String colDate7 = "Date7";
    private static final String colDate8 = "Date8";


    public DatabaseForSummary(Context context) {
        super(context, dbName, null, dbVersion);


    }

    public ArrayList<HashMap<String,String>> getSummary(){
        try{

            ArrayList<HashMap<String,String>> arr = new ArrayList<HashMap<String,String>>();
            HashMap<String,String> map;
            SQLiteDatabase db = this.getReadableDatabase();
            String sql = "SELECT * FROM " + tableNameSummary;
            Cursor cur = db.rawQuery(sql,null);
            if(cur!= null){
                if(cur.moveToFirst()){

                    do{
                        map = new HashMap<String,String>();
                        map.put("ID",cur.getString(0));
                        map.put("fbID",cur.getString(1));
                        map.put("Date1",cur.getString(2));
                        map.put("Date2",cur.getString(3));
                        map.put("Date3",cur.getString(4));
                        map.put("Date4",cur.getString(5));
                        map.put("Date5",cur.getString(6));
                        map.put("Date6",cur.getString(7));
                        map.put("Date7",cur.getString(8));
                        map.put("Date8",cur.getString(9));
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

    public boolean insertDataSum(String getid,String day1,String day2,String day3,String day4,String day5,String day6,String day7,String day8){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(colIDFB,getid);
        contentValues.put(colDate1,day1);
        contentValues.put(colDate2,day2);
        contentValues.put(colDate3,day3);
        contentValues.put(colDate4,day4);
        contentValues.put(colDate5,day5);
        contentValues.put(colDate6,day6);
        contentValues.put(colDate7,day7);
        contentValues.put(colDate8,day8);


        long insert = db.insert(tableNameSummary,null,contentValues);
        return  true;
    }

    public boolean updateDataSum(String id,String day1,String day2,String day3,String day4,String day5,String day6,String day7,String day8){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(colID,id);
        contentValues.put(colDate1,day1);
        contentValues.put(colDate2,day2);
        contentValues.put(colDate3,day3);
        contentValues.put(colDate4,day4);
        contentValues.put(colDate5,day5);
        contentValues.put(colDate6,day6);
        contentValues.put(colDate7,day7);
        contentValues.put(colDate8,day8);
        db.update(tableNameSummary,contentValues,"ID = ?",new String[]{id});
        return  true;
    }





    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE "+tableNameSummary +"("+colID+" INTEGER PRIMARY KEY,"+
                colIDFB+" TEXT,"+colDate1+" TEXT,"+colDate2+" TEXT,"+colDate3+" TEXT,"+colDate4+" TEXT,"+colDate5+" TEXT,"+colDate6+" TEXT,"+colDate7+" TEXT,"+colDate8+" TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
