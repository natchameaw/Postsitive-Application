package com.example.knutt.myproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by KNUTT on 23/2/2561.
 */

public class DatabaseRealtime extends SQLiteOpenHelper{

    private static final int dbVersion = 1;
    private static final String dbName = "databaserealtime.sqlite";

    private static final String tableNameReal = "Realtime";
    private static final String colID = "ID";
    private static final String colReal = "Date";

    private static final String tableNameReal2 = "Realtime2";
    private static final String colID2 = "ID";
    private static final String colReal2 = "Date";

    public DatabaseRealtime(Context context) {
        super(context, dbName, null, dbVersion);


    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+tableNameReal+"("+colID+" INTEGER PRIMARY KEY AUTOINCREMENT," +
                colReal+" TEXT)");

        sqLiteDatabase.execSQL("CREATE TABLE "+tableNameReal2+"("+colID2+" INTEGER PRIMARY KEY AUTOINCREMENT," +
                colReal2+" TEXT)");

        ContentValues contentValues = new ContentValues();
        ContentValues contentValues2 = new ContentValues();
        ContentValues contentValues3 = new ContentValues();
        ContentValues contentValues4 = new ContentValues();
        ContentValues contentValues5 = new ContentValues();
        ContentValues contentValues6 = new ContentValues();
        ContentValues contentValues7 = new ContentValues();
        ContentValues contentValues8 = new ContentValues();


        contentValues.put("ID",1);
        contentValues.put("Date","2018-02-15");

        contentValues2.put("ID",2);
        contentValues2.put("Date","2018-02-16");

        contentValues3.put("ID",3);
        contentValues3.put("Date","2018-02-17");

        contentValues4.put("ID",4);
        contentValues4.put("Date","2018-02-18");

        contentValues5.put("ID",5);
        contentValues5.put("Date","2018-02-19");

        contentValues6.put("ID",6);
        contentValues6.put("Date","2018-02-20");

        contentValues7.put("ID",7);
        contentValues7.put("Date","2018-02-26");

        contentValues8.put("ID",8);
        contentValues8.put("Date","2018-02-27");

        String table_realtime = "Realtime";

        sqLiteDatabase.insert(table_realtime,null,contentValues);
        sqLiteDatabase.insert(table_realtime,null,contentValues2);
        sqLiteDatabase.insert(table_realtime,null,contentValues3);
        sqLiteDatabase.insert(table_realtime,null,contentValues4);
        sqLiteDatabase.insert(table_realtime,null,contentValues5);
        sqLiteDatabase.insert(table_realtime,null,contentValues6);
        sqLiteDatabase.insert(table_realtime,null,contentValues7);
        sqLiteDatabase.insert(table_realtime,null,contentValues8);

        ContentValues contentValuesdate = new ContentValues();
        contentValuesdate.put("ID",1);
        contentValuesdate.put("Date","2018-02-25");

        String table_realtime2 = "Realtime2";

        sqLiteDatabase.insert(table_realtime2,null,contentValuesdate);

    }

    public boolean updateData(String id,String date){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(colID,id);
        contentValues.put(colReal,date);
        db.update(tableNameReal,contentValues,"ID = ?",new String[]{id});
        return  true;
    }

    public boolean updateData2(String id,String date){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(colID2,id);
        contentValues.put(colReal2,date);
        db.update(tableNameReal2,contentValues,"ID = ?",new String[]{id});
        return  true;
    }

    public boolean insertnewData(String date){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(colReal2,date);
        long insert = db.insert(tableNameReal2,null,contentValues);
        return  true;
    }

    public void deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(tableNameReal2,"ID = ?",new String[]{id});

    }

    public ArrayList<HashMap<String,String>> getDaterealtime(){
        try{

            ArrayList<HashMap<String,String>> arr = new ArrayList<HashMap<String,String>>();
            HashMap<String,String> map;
            SQLiteDatabase db = this.getReadableDatabase();
            String sql = "SELECT * FROM " + tableNameReal;
            Cursor cur = db.rawQuery(sql,null);
            if(cur!= null){
                if(cur.moveToFirst()){

                    do{
                        map = new HashMap<String,String>();
                        map.put("ID",cur.getString(0));
                        map.put("Date",cur.getString(1));
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
    public ArrayList<HashMap<String,String>> getDaterealtime2(){
        try{

            ArrayList<HashMap<String,String>> arr = new ArrayList<HashMap<String,String>>();
            HashMap<String,String> map;
            SQLiteDatabase db = this.getReadableDatabase();
            String sql = "SELECT * FROM " + tableNameReal2;
            Cursor cur = db.rawQuery(sql,null);
            if(cur!= null){
                if(cur.moveToFirst()){

                    do{
                        map = new HashMap<String,String>();
                        map.put("ID",cur.getString(0));
                        map.put("Date",cur.getString(1));
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





    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
