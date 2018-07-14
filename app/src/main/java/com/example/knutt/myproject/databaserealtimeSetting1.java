package com.example.knutt.myproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by KNUTT on 18/3/2561.
 */

public class databaserealtimeSetting1 extends SQLiteOpenHelper {

    private static final int dbVersion = 1;
    private static final String dbName = "databaserealtimesetting1.sqlite";

    private static final String tableNameRealsetting1 = "Realtimesetting1";
    private static final String colID = "ID";
    private static final String colReal = "Date";


    public databaserealtimeSetting1(Context context) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+tableNameRealsetting1+"("+colID+" INTEGER PRIMARY KEY AUTOINCREMENT," +
                colReal+" TEXT)");

        ContentValues contentValues = new ContentValues();
        ContentValues contentValues2 = new ContentValues();
        contentValues.put("ID",1);
        contentValues.put("Date","2018-03-18");
        contentValues2.put("ID",2);
        contentValues2.put("Date","2018-03-19");


        String table_realtimesetting1 = "Realtimesetting1";

        sqLiteDatabase.insert(table_realtimesetting1,null,contentValues);
        sqLiteDatabase.insert(table_realtimesetting1,null,contentValues2);



    }

    public boolean updateDataSetting1(String id,String date){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(colID,id);
        contentValues.put(colReal,date);
        db.update(tableNameRealsetting1,contentValues,"ID = ?",new String[]{id});
        return  true;
    }

    public ArrayList<HashMap<String,String>> getDaterealtimesetting1(){
        try{

            ArrayList<HashMap<String,String>> arr = new ArrayList<HashMap<String,String>>();
            HashMap<String,String> map;
            SQLiteDatabase db = this.getReadableDatabase();
            String sql = "SELECT * FROM " + tableNameRealsetting1;
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
