package com.example.knutt.myproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseCheckin extends SQLiteOpenHelper {

    private static final int dbVersion = 1;
    private static final String dbName = "databaseCheckin.sqlite";

    private static final String tableNameCheckin = "Checkintable";
    private static final String colCheckin = "CheckinID";
    private static final String colCheckin2 = "CheckinWord";
    private static final String colCheckin3 = "CheckinRank";
    private static final String colCheckin4  = "CheckinEmotion";

    public DatabaseCheckin(Context context) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+tableNameCheckin+"("+colCheckin+" INTEGER PRIMARY KEY AUTOINCREMENT," +
                colCheckin2+" TEXT,"+colCheckin3+" INTEGER,"+colCheckin4+" TEXT)");

        ContentValues attvalue = new ContentValues();
        ContentValues attvalue2 = new ContentValues();
        ContentValues attvalue3 = new ContentValues();
        ContentValues attvalue4 = new ContentValues();
        ContentValues attvalue5 = new ContentValues();
        ContentValues attvalue6 = new ContentValues();
        ContentValues attvalue7 = new ContentValues();
        ContentValues attvalue8 = new ContentValues();
        ContentValues attvalue9 = new ContentValues();
        ContentValues attvalue10 = new ContentValues();
        ContentValues attvalue11 = new ContentValues();
        ContentValues attvalue12 = new ContentValues();
        ContentValues attvalue13 = new ContentValues();
        ContentValues attvalue14 = new ContentValues();
        ContentValues attvalue15 = new ContentValues();
        ContentValues attvalue16 = new ContentValues();
        ContentValues attvalue17 = new ContentValues();
        ContentValues attvalue18 = new ContentValues();
        ContentValues attvalue19 = new ContentValues();
        ContentValues attvalue20 = new ContentValues();
        ContentValues attvalue21 = new ContentValues();
        ContentValues attvalue22 = new ContentValues();
        ContentValues attvalue23 = new ContentValues();
        ContentValues attvalue24 = new ContentValues();
        ContentValues attvalue25 = new ContentValues();
        ContentValues attvalue26 = new ContentValues();
        ContentValues attvalue27 = new ContentValues();
        ContentValues attvalue28 = new ContentValues();
        ContentValues attvalue29 = new ContentValues();
        ContentValues attvalue30 = new ContentValues();
        ContentValues attvalue31 = new ContentValues();






        attvalue.put("CheckinID",1);
        attvalue.put("CheckinWord","คาเฟ่");
        attvalue.put("CheckinRank",1);
        attvalue.put("CheckinEmotion","7");

        attvalue2.put("CheckinID",2);
        attvalue2.put("CheckinWord","ตลาด");
        attvalue2.put("CheckinRank",1);
        attvalue2.put("CheckinEmotion","8");

        attvalue3.put("CheckinID",3);
        attvalue3.put("CheckinWord","บาร์");
        attvalue3.put("CheckinRank",1);
        attvalue3.put("CheckinEmotion","7");

        attvalue4.put("CheckinID",4);
        attvalue4.put("CheckinWord","โบสถ์");
        attvalue4.put("CheckinRank",0);
        attvalue4.put("CheckinEmotion","6");

        attvalue5.put("CheckinID",5);
        attvalue5.put("CheckinWord","ผับ");
        attvalue5.put("CheckinRank",1);
        attvalue5.put("CheckinEmotion","7");

        attvalue6.put("CheckinID",6);
        attvalue6.put("CheckinWord","พิพิธภัณฑ์");
        attvalue6.put("CheckinRank",1);
        attvalue6.put("CheckinEmotion","8");

        attvalue7.put("CheckinID",7);
        attvalue7.put("CheckinWord","ฟิตเนส");
        attvalue7.put("CheckinRank",1);
        attvalue7.put("CheckinEmotion","8");

        attvalue8.put("CheckinID",8);
        attvalue8.put("CheckinWord","มหาวิทยาลัย");
        attvalue8.put("CheckinRank",1);
        attvalue8.put("CheckinEmotion","8");

        attvalue9.put("CheckinID",9);
        attvalue9.put("CheckinWord","มัสยิด");
        attvalue9.put("CheckinRank",1);
        attvalue9.put("CheckinEmotion","8");

        attvalue10.put("CheckinID",10);
        attvalue10.put("CheckinWord","ยิม");
        attvalue10.put("CheckinRank",1);
        attvalue10.put("CheckinEmotion","8");

        attvalue11.put("CheckinID",11);
        attvalue11.put("CheckinWord","ร้าน");
        attvalue11.put("CheckinRank",1);
        attvalue11.put("CheckinEmotion","8");

        attvalue12.put("CheckinID",12);
        attvalue12.put("CheckinWord","ร้านขายยา");
        attvalue12.put("CheckinRank",-1);
        attvalue12.put("CheckinEmotion","8");

        attvalue13.put("CheckinID",13);
        attvalue13.put("CheckinWord","ร้านอาหาร");
        attvalue13.put("CheckinRank",1);
        attvalue13.put("CheckinEmotion","8");

        attvalue14.put("CheckinID",14);
        attvalue14.put("CheckinWord","รีสอร์ท");
        attvalue14.put("CheckinRank",1);
        attvalue14.put("CheckinEmotion","7");

        attvalue15.put("CheckinID",15);
        attvalue15.put("CheckinWord","โรงพยาบาล");
        attvalue15.put("CheckinRank",-1);
        attvalue15.put("CheckinEmotion","01");

        attvalue16.put("CheckinID",16);
        attvalue16.put("CheckinWord","โรงภาพยนตร์");
        attvalue16.put("CheckinRank",1);
        attvalue16.put("CheckinEmotion","7");

        attvalue17.put("CheckinID",17);
        attvalue17.put("CheckinWord","โรงเรียน");
        attvalue17.put("CheckinRank",1);
        attvalue17.put("CheckinEmotion","8");

        attvalue18.put("CheckinID",18);
        attvalue18.put("CheckinWord","โรงแรม");
        attvalue18.put("CheckinRank",1);
        attvalue18.put("CheckinEmotion","8");

        attvalue19.put("CheckinID",19);
        attvalue19.put("CheckinWord","โรงหนัง");
        attvalue19.put("CheckinRank",1);
        attvalue19.put("CheckinEmotion","7");

        attvalue20.put("CheckinID",20);
        attvalue20.put("CheckinWord","วัด");
        attvalue20.put("CheckinRank",1);
        attvalue20.put("CheckinEmotion","8");

        attvalue21.put("CheckinID",21);
        attvalue21.put("CheckinWord","สนามกีฬา");
        attvalue21.put("CheckinRank",1);
        attvalue21.put("CheckinEmotion","8");

        attvalue22.put("CheckinID",22);
        attvalue22.put("CheckinWord","สนามบิน");
        attvalue22.put("CheckinRank",1);
        attvalue22.put("CheckinEmotion","8");

        attvalue23.put("CheckinID",23);
        attvalue23.put("CheckinWord","สปา");
        attvalue23.put("CheckinRank",1);
        attvalue23.put("CheckinEmotion","8");

        attvalue23.put("CheckinID",23);
        attvalue23.put("CheckinWord","สวน");
        attvalue23.put("CheckinRank",1);
        attvalue23.put("CheckinEmotion","8");

        attvalue24.put("CheckinID",24);
        attvalue24.put("CheckinWord","สวนสนุก");
        attvalue24.put("CheckinRank",1);
        attvalue24.put("CheckinEmotion","7");

        attvalue25.put("CheckinID",25);
        attvalue25.put("CheckinWord","สวนสัตว์");
        attvalue25.put("CheckinRank",1);
        attvalue25.put("CheckinEmotion","7");

        attvalue26.put("CheckinID",26);
        attvalue26.put("CheckinWord","หอสมุด");
        attvalue26.put("CheckinRank",1);
        attvalue26.put("CheckinEmotion","7");

        attvalue27.put("CheckinID",27);
        attvalue27.put("CheckinWord","ห้างสรรพสินค้า");
        attvalue27.put("CheckinRank",1);
        attvalue27.put("CheckinEmotion","7");

        attvalue28.put("CheckinID",28);
        attvalue28.put("CheckinWord","หาด");
        attvalue28.put("CheckinRank",1);
        attvalue28.put("CheckinEmotion","7");

        attvalue29.put("CheckinID",29);
        attvalue29.put("CheckinWord","ทะเล");
        attvalue29.put("CheckinRank",1);
        attvalue29.put("CheckinEmotion","7");

        attvalue30.put("CheckinID",30);
        attvalue30.put("CheckinWord","ภูเขา");
        attvalue30.put("CheckinRank",1);
        attvalue30.put("CheckinEmotion","7");

        attvalue31.put("CheckinID",31);
        attvalue31.put("CheckinWord","น้ำตก");
        attvalue31.put("CheckinRank",1);
        attvalue31.put("CheckinEmotion","7");

        String table_nameatt = "Checkintable";

        sqLiteDatabase.insert(table_nameatt,null,attvalue);
        sqLiteDatabase.insert(table_nameatt,null,attvalue2);
        sqLiteDatabase.insert(table_nameatt,null,attvalue3);
        sqLiteDatabase.insert(table_nameatt,null,attvalue4);
        sqLiteDatabase.insert(table_nameatt,null,attvalue5);
        sqLiteDatabase.insert(table_nameatt,null,attvalue6);
        sqLiteDatabase.insert(table_nameatt,null,attvalue7);
        sqLiteDatabase.insert(table_nameatt,null,attvalue8);
        sqLiteDatabase.insert(table_nameatt,null,attvalue9);
        sqLiteDatabase.insert(table_nameatt,null,attvalue10);
        sqLiteDatabase.insert(table_nameatt,null,attvalue11);
        sqLiteDatabase.insert(table_nameatt,null,attvalue12);
        sqLiteDatabase.insert(table_nameatt,null,attvalue13);
        sqLiteDatabase.insert(table_nameatt,null,attvalue14);
        sqLiteDatabase.insert(table_nameatt,null,attvalue15);
        sqLiteDatabase.insert(table_nameatt,null,attvalue16);
        sqLiteDatabase.insert(table_nameatt,null,attvalue17);
        sqLiteDatabase.insert(table_nameatt,null,attvalue18);
        sqLiteDatabase.insert(table_nameatt,null,attvalue19);
        sqLiteDatabase.insert(table_nameatt,null,attvalue20);
        sqLiteDatabase.insert(table_nameatt,null,attvalue21);
        sqLiteDatabase.insert(table_nameatt,null,attvalue22);
        sqLiteDatabase.insert(table_nameatt,null,attvalue23);
        sqLiteDatabase.insert(table_nameatt,null,attvalue24);
        sqLiteDatabase.insert(table_nameatt,null,attvalue25);
        sqLiteDatabase.insert(table_nameatt,null,attvalue26);
        sqLiteDatabase.insert(table_nameatt,null,attvalue27);
        sqLiteDatabase.insert(table_nameatt,null,attvalue28);
        sqLiteDatabase.insert(table_nameatt,null,attvalue29);
        sqLiteDatabase.insert(table_nameatt,null,attvalue30);
        sqLiteDatabase.insert(table_nameatt,null,attvalue31);









    }

    public ArrayList<HashMap<String,String>> getCheckinWord(){
        try {
            ArrayList<HashMap<String,String>> arr = new ArrayList<HashMap<String,String>>();
            HashMap<String, String> map;

            SQLiteDatabase db = this.getReadableDatabase();
            String sql = "select * from " + tableNameCheckin;
            Cursor cursor = db.rawQuery(sql, null);
            if(cursor != null){
                if(cursor.moveToFirst()){
                    do{
                        map = new HashMap<String,String>();
                        map.put("CheckinID",cursor.getString(0));
                        map.put("CheckinWord",cursor.getString(1));
                        map.put("CheckinRank",cursor.getString(2));
                        map.put("CheckinEmotion",cursor.getString(3));
                        arr.add(map);
                    } while (cursor.moveToNext());
                }

            }
            cursor.close();
            db.close();
            return  arr;

        } catch (Exception e){
            return  null;
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
