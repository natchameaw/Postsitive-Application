package com.example.knutt.myproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseNotifiWord extends SQLiteOpenHelper {

    private static final int dbVersion = 1;
    private static final String dbName = "databasewordforNotifi.sqlite";
    //create table Emotion
    private static final String tableNameNoti = "NotifiWord";
    private static final String colNoti1 = "WordID";
    private static final String colNoti2 = "Word";


    public DatabaseNotifiWord(Context context) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+tableNameNoti+"("+colNoti1+" INTEGER PRIMARY KEY,"+
               colNoti2+" TEXT)");



        ContentValues noti = new ContentValues();
        ContentValues noti2 = new ContentValues();
        ContentValues noti3 = new ContentValues();
        ContentValues noti4 = new ContentValues();
        ContentValues noti5 = new ContentValues();
        ContentValues noti6 = new ContentValues();
        ContentValues noti7 = new ContentValues();
        ContentValues noti8 = new ContentValues();
        ContentValues noti9 = new ContentValues();
        ContentValues noti10 = new ContentValues();
        ContentValues noti11 = new ContentValues();
        ContentValues noti12 = new ContentValues();
        ContentValues noti13 = new ContentValues();
        ContentValues noti14 = new ContentValues();
        ContentValues noti15 = new ContentValues();
        ContentValues noti16 = new ContentValues();
        ContentValues noti17 = new ContentValues();
        ContentValues noti18 = new ContentValues();
        ContentValues noti19 = new ContentValues();
        ContentValues noti20 = new ContentValues();
        ContentValues noti21 = new ContentValues();
        ContentValues noti22 = new ContentValues();
        ContentValues noti23 = new ContentValues();
        ContentValues noti24 = new ContentValues();
        ContentValues noti25 = new ContentValues();
        ContentValues noti26 = new ContentValues();
        ContentValues noti27 = new ContentValues();
        ContentValues noti28 = new ContentValues();
        ContentValues noti29 = new ContentValues();
        ContentValues noti30 = new ContentValues();
        ContentValues noti31 = new ContentValues();
        ContentValues noti32 = new ContentValues();
        ContentValues noti33 = new ContentValues();
        ContentValues noti34 = new ContentValues();
        ContentValues noti35 = new ContentValues();
        ContentValues noti36 = new ContentValues();
        ContentValues noti37 = new ContentValues();
        ContentValues noti38 = new ContentValues();
        ContentValues noti39 = new ContentValues();
        ContentValues noti40 = new ContentValues();
        ContentValues noti41 = new ContentValues();
        ContentValues noti42 = new ContentValues();
        ContentValues noti43 = new ContentValues();
        ContentValues noti44 = new ContentValues();
        ContentValues noti45 = new ContentValues();
        ContentValues noti46 = new ContentValues();
        ContentValues noti47 = new ContentValues();
        ContentValues noti48 = new ContentValues();
        ContentValues noti49 = new ContentValues();
        ContentValues noti50 = new ContentValues();
        ContentValues noti51 = new ContentValues();



        noti.put("WordID",1);
        noti.put("Word","ฉิบหาย");

        noti2.put("WordID",2);
        noti2.put("Word","แรด");

        noti3.put("WordID",3);
        noti3.put("Word","ห่า");

        noti4.put("WordID",4);
        noti4.put("Word","ทุเรด");

        noti5.put("WordID",5);
        noti5.put("Word","ทุเรด");

        noti6.put("WordID",6);
        noti6.put("Word","ทุเรศ");

        noti7.put("WordID",7);
        noti7.put("Word","กระดอ");

        noti8.put("WordID",8);
        noti8.put("Word","กระหรี่");

        noti9.put("WordID",9);
        noti9.put("Word","กวนตีน");

        noti10.put("WordID",10);
        noti10.put("Word","กวนส้นตีน");

        noti11.put("WordID",11);
        noti11.put("Word","กะหรี่");

        noti12.put("WordID",12);
        noti12.put("Word","ควย");

        noti13.put("WordID",13);
        noti13.put("Word","เควี่ย");

        noti14.put("WordID",14);
        noti14.put("Word","เงี่ยน");

        noti15.put("WordID",15);
        noti15.put("Word","จังไร");

        noti16.put("WordID",16);
        noti16.put("Word","จังไร");

        noti17.put("WordID",17);
        noti17.put("Word","จัญไร");

        noti18.put("WordID",18);
        noti18.put("Word","ชาติหมา");

        noti19.put("WordID",19);
        noti19.put("Word","ชิบหาย");

        noti20.put("WordID",20);
        noti20.put("Word","เชี่ย");

        noti21.put("WordID",21);
        noti21.put("Word","แดก");

        noti22.put("WordID",22);
        noti22.put("Word","ตอแหล");

        noti23.put("WordID",23);
        noti23.put("Word","ปากหมา");

        noti24.put("WordID",24);
        noti24.put("Word","พ่อง");

        noti25.put("WordID",25);
        noti25.put("Word","พ่อมึง");

        noti26.put("WordID",26);
        noti26.put("Word","พ่อมึงตาย");

        noti27.put("WordID",27);
        noti27.put("Word","ฟวย");

        noti28.put("WordID",28);
        noti28.put("Word","ฟาย");

        noti29.put("WordID",29);
        noti29.put("Word","แม่ง");

        noti30.put("WordID",30);
        noti30.put("Word","แม่มึง");

        noti31.put("WordID",31);
        noti31.put("Word","แม่มึงตาย");

        noti32.put("WordID",32);
        noti32.put("Word","เย็ด");

        noti33.put("WordID",33);
        noti33.put("Word","เยี่ยว");

        noti34.put("WordID",34);
        noti34.put("Word","ระยำ");

        noti35.put("WordID",35);
        noti35.put("Word","สถุน");

        noti35.put("WordID",35);
        noti35.put("Word","สถุล");

        noti36.put("WordID",36);
        noti36.put("Word","ส้นตีน");

        noti37.put("WordID",37);
        noti37.put("Word","สสะเหล่อ");

        noti38.put("WordID",38);
        noti38.put("Word","สัด");

        noti39.put("WordID",39);
        noti39.put("Word","สัส");

        noti40.put("WordID",40);
        noti40.put("Word","สาด");

        noti41.put("WordID",41);
        noti41.put("Word","เสือก");

        noti42.put("WordID",42);
        noti42.put("Word","หน้าด้าน");

        noti43.put("WordID",43);
        noti43.put("Word","หน้าตัวเมีย");

        noti44.put("WordID",44);
        noti44.put("Word","หี");

        noti45.put("WordID",45);
        noti45.put("Word","เหี้ย");

        noti46.put("WordID",46);
        noti46.put("Word","อัปปรี");

        noti47.put("WordID",47);
        noti47.put("Word","อัปปรีย์");

        noti48.put("WordID",48);
        noti48.put("Word","อุบาด");

        noti49.put("WordID",49);
        noti49.put("Word","อุบาท");

        noti50.put("WordID",50);
        noti50.put("Word","อุบาทว์");

        noti51.put("WordID",51);
        noti51.put("Word","เฮี้ย");

        String table_noti = "NotifiWord";

        sqLiteDatabase.insert(table_noti,null,noti);
        sqLiteDatabase.insert(table_noti,null,noti2);
        sqLiteDatabase.insert(table_noti,null,noti3);
        sqLiteDatabase.insert(table_noti,null,noti4);
        sqLiteDatabase.insert(table_noti,null,noti5);
        sqLiteDatabase.insert(table_noti,null,noti6);
        sqLiteDatabase.insert(table_noti,null,noti7);
        sqLiteDatabase.insert(table_noti,null,noti8);
        sqLiteDatabase.insert(table_noti,null,noti9);
        sqLiteDatabase.insert(table_noti,null,noti10);
        sqLiteDatabase.insert(table_noti,null,noti11);
        sqLiteDatabase.insert(table_noti,null,noti12);
        sqLiteDatabase.insert(table_noti,null,noti13);
        sqLiteDatabase.insert(table_noti,null,noti14);
        sqLiteDatabase.insert(table_noti,null,noti15);
        sqLiteDatabase.insert(table_noti,null,noti16);
        sqLiteDatabase.insert(table_noti,null,noti17);
        sqLiteDatabase.insert(table_noti,null,noti18);
        sqLiteDatabase.insert(table_noti,null,noti19);
        sqLiteDatabase.insert(table_noti,null,noti20);
        sqLiteDatabase.insert(table_noti,null,noti21);
        sqLiteDatabase.insert(table_noti,null,noti22);
        sqLiteDatabase.insert(table_noti,null,noti23);
        sqLiteDatabase.insert(table_noti,null,noti24);
        sqLiteDatabase.insert(table_noti,null,noti25);
        sqLiteDatabase.insert(table_noti,null,noti26);
        sqLiteDatabase.insert(table_noti,null,noti27);
        sqLiteDatabase.insert(table_noti,null,noti28);
        sqLiteDatabase.insert(table_noti,null,noti29);
        sqLiteDatabase.insert(table_noti,null,noti30);
        sqLiteDatabase.insert(table_noti,null,noti31);
        sqLiteDatabase.insert(table_noti,null,noti32);
        sqLiteDatabase.insert(table_noti,null,noti33);
        sqLiteDatabase.insert(table_noti,null,noti34);
        sqLiteDatabase.insert(table_noti,null,noti35);
        sqLiteDatabase.insert(table_noti,null,noti36);
        sqLiteDatabase.insert(table_noti,null,noti37);
        sqLiteDatabase.insert(table_noti,null,noti38);
        sqLiteDatabase.insert(table_noti,null,noti39);
        sqLiteDatabase.insert(table_noti,null,noti40);
        sqLiteDatabase.insert(table_noti,null,noti41);
        sqLiteDatabase.insert(table_noti,null,noti42);
        sqLiteDatabase.insert(table_noti,null,noti43);
        sqLiteDatabase.insert(table_noti,null,noti44);
        sqLiteDatabase.insert(table_noti,null,noti45);
        sqLiteDatabase.insert(table_noti,null,noti46);
        sqLiteDatabase.insert(table_noti,null,noti47);
        sqLiteDatabase.insert(table_noti,null,noti48);
        sqLiteDatabase.insert(table_noti,null,noti49);
        sqLiteDatabase.insert(table_noti,null,noti50);
        sqLiteDatabase.insert(table_noti,null,noti51);



















    }

    public ArrayList<HashMap<String,String>> getNotiword(){
        try{

            ArrayList<HashMap<String,String>> arr = new ArrayList<HashMap<String,String>>();
            HashMap<String,String> map;
            SQLiteDatabase db = this.getReadableDatabase();
            String sql = "SELECT * FROM " + tableNameNoti;
            Cursor cur = db.rawQuery(sql,null);
            if(cur!= null){
                if(cur.moveToFirst()){

                    do{
                        map = new HashMap<String,String>();
                        map.put("WordID",cur.getString(0));
                        map.put("Word",cur.getString(1));
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
