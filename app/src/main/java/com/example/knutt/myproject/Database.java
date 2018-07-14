package com.example.knutt.myproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by KNUTT on 6/2/2561.
 */

public class Database extends SQLiteOpenHelper {
    private static final int dbVersion = 1;
    private static final String dbName = "databaseword.sqlite";
    //create table Emotion
    private static final String tableName2 = "Emotiontable";
    private static final String colEmotion1 = "EmotionID";
    private static final String colEmotion2 = "EmotionWord";
    //create table Attitude
    private static final String tableName = "Attitudetable";
    private static final String colAntitude1 = "AttitudeID";
    private static final String colAntitude2 = "AttitudeWord";
    private static final String colAntitude3 = "AttitudeRank";
    private static final String colAntitude4 = "Emotion";

    //create table emoticon
    private static final String tableName3 = "emoticon";
    private static final String colEmoticonID = "EmoticonID";
    private static final String colEmoticonShortcut = "EmoticonShortcut";
    private static final String colEmoticonRank = "EmoticonRank";
    private static final String colEmoticonemoID = "EmoticonEmoid";

    public Database(Context context) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        sqLiteDatabase.execSQL("CREATE TABLE "+tableName2+"("+colEmotion1+" INTEGER PRIMARY KEY,"+
                colEmotion2+" TEXT)");

        sqLiteDatabase.execSQL("CREATE TABLE "+tableName+"("+colAntitude1+" INTEGER PRIMARY KEY," +
                colAntitude2+" TEXT,"+colAntitude3+" INTEGER,"+colAntitude4+" TEXT)");

        sqLiteDatabase.execSQL("create table "+tableName3+"("+colEmoticonID+" INTEGER PRIMARY KEY,"+colEmoticonShortcut+" TEXT,"+colEmoticonRank+" INTEGER ,"+colEmoticonemoID+" TEXT)");



        String table_nameemo = "Emotiontable";

        int EmotionID = 0;
        String EmotionWord = "เศร้าเสียใจ(Sadness)";
        int EmotionID2 = 1;
        String EmotionWord2 = "กลัว(Fear)";
        int EmotionID3 = 2;
        String EmotionWord3 = "ยอมรับ(Acceptance)";
        int EmotionID4 = 3;
        String EmotionWord4 = "ประหลาดใจ(Surprise)";
        int EmotionID5 = 4;
        String EmotionWord5 = "รังเกียจ(Disgust)";
        int EmotionID6 = 5;
        String EmotionWord6 = "โกรธ(Anger)";
        int EmotionID7 = 6;
        String EmotionWord7 = "คาดหวัง(Anticipation)";
        int EmotionID8 = 7;
        String EmotionWord8 = "รื่นเริง(Joy)";
        int EmotionID9 = 8;
        String EmotionWord9 = "ไม่แสดงอารมณ์";


        ContentValues emovalue = new ContentValues();
        ContentValues emovalue2 = new ContentValues();
        ContentValues emovalue3 = new ContentValues();
        ContentValues emovalue4 = new ContentValues();
        ContentValues emovalue5 = new ContentValues();
        ContentValues emovalue6 = new ContentValues();
        ContentValues emovalue7 = new ContentValues();
        ContentValues emovalue8 = new ContentValues();
        ContentValues emovalue9 = new ContentValues();

        emovalue.put("EmotionID", EmotionID);
        emovalue.put("EmotionWord", EmotionWord);
        emovalue2.put("EmotionID", EmotionID2);
        emovalue2.put("EmotionWord", EmotionWord2);
        emovalue3.put("EmotionID", EmotionID3);
        emovalue3.put("EmotionWord", EmotionWord3);
        emovalue4.put("EmotionID", EmotionID4);
        emovalue4.put("EmotionWord", EmotionWord4);
        emovalue5.put("EmotionID", EmotionID5);
        emovalue5.put("EmotionWord", EmotionWord5);
        emovalue6.put("EmotionID", EmotionID6);
        emovalue6.put("EmotionWord", EmotionWord6);
        emovalue7.put("EmotionID", EmotionID7);
        emovalue7.put("EmotionWord", EmotionWord7);
        emovalue8.put("EmotionID", EmotionID8);
        emovalue8.put("EmotionWord", EmotionWord8);
        emovalue9.put("EmotionID", EmotionID9);
        emovalue9.put("EmotionWord", EmotionWord9);



        sqLiteDatabase.insert(table_nameemo, null, emovalue);
        sqLiteDatabase.insert(table_nameemo, null, emovalue2);
        sqLiteDatabase.insert(table_nameemo, null, emovalue3);
        sqLiteDatabase.insert(table_nameemo, null, emovalue4);
        sqLiteDatabase.insert(table_nameemo, null, emovalue5);
        sqLiteDatabase.insert(table_nameemo, null, emovalue6);
        sqLiteDatabase.insert(table_nameemo, null, emovalue7);
        sqLiteDatabase.insert(table_nameemo, null, emovalue8);
        sqLiteDatabase.insert(table_nameemo, null, emovalue9);
///////////////////////////////////////////////////////////////////

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
        ContentValues attvalue32 = new ContentValues();
        ContentValues attvalue33 = new ContentValues();
        ContentValues attvalue34 = new ContentValues();
        ContentValues attvalue35 = new ContentValues();
        ContentValues attvalue36 = new ContentValues();
        ContentValues attvalue37 = new ContentValues();
        ContentValues attvalue38 = new ContentValues();
        ContentValues attvalue39 = new ContentValues();
        ContentValues attvalue40 = new ContentValues();
        ContentValues attvalue41 = new ContentValues();
        ContentValues attvalue42 = new ContentValues();
        ContentValues attvalue43 = new ContentValues();
        ContentValues attvalue44 = new ContentValues();
        ContentValues attvalue45 = new ContentValues();
        ContentValues attvalue46 = new ContentValues();
        ContentValues attvalue47 = new ContentValues();
        ContentValues attvalue48 = new ContentValues();
        ContentValues attvalue49 = new ContentValues();
        ContentValues attvalue50 = new ContentValues();
        ContentValues attvalue51 = new ContentValues();
        ContentValues attvalue52 = new ContentValues();
        ContentValues attvalue53 = new ContentValues();
        ContentValues attvalue54 = new ContentValues();
        ContentValues attvalue55 = new ContentValues();
        ContentValues attvalue56 = new ContentValues();
        ContentValues attvalue57 = new ContentValues();
        ContentValues attvalue58 = new ContentValues();
        ContentValues attvalue59 = new ContentValues();
        ContentValues attvalue60 = new ContentValues();
        ContentValues attvalue61 = new ContentValues();
        ContentValues attvalue62 = new ContentValues();
        ContentValues attvalue63 = new ContentValues();
        ContentValues attvalue64 = new ContentValues();
        ContentValues attvalue65 = new ContentValues();
        ContentValues attvalue66 = new ContentValues();
        ContentValues attvalue67 = new ContentValues();
        ContentValues attvalue68 = new ContentValues();
        ContentValues attvalue69 = new ContentValues();
        ContentValues attvalue70 = new ContentValues();
        ContentValues attvalue71 = new ContentValues();
        ContentValues attvalue72 = new ContentValues();
        ContentValues attvalue73 = new ContentValues();
        ContentValues attvalue74 = new ContentValues();
        ContentValues attvalue75 = new ContentValues();
        ContentValues attvalue76 = new ContentValues();
        ContentValues attvalue77 = new ContentValues();
        ContentValues attvalue78 = new ContentValues();
        ContentValues attvalue79 = new ContentValues();
        ContentValues attvalue80 = new ContentValues();
        ContentValues attvalue81 = new ContentValues();
        ContentValues attvalue82 = new ContentValues();
        ContentValues attvalue83 = new ContentValues();
        ContentValues attvalue84 = new ContentValues();
        ContentValues attvalue85 = new ContentValues();
        ContentValues attvalue86 = new ContentValues();
        ContentValues attvalue87 = new ContentValues();
        ContentValues attvalue88 = new ContentValues();
        ContentValues attvalue89 = new ContentValues();
        ContentValues attvalue90 = new ContentValues();
        ContentValues attvalue91 = new ContentValues();
        ContentValues attvalue92 = new ContentValues();
        ContentValues attvalue93 = new ContentValues();
        ContentValues attvalue94 = new ContentValues();
        ContentValues attvalue95 = new ContentValues();
        ContentValues attvalue96 = new ContentValues();
        ContentValues attvalue97 = new ContentValues();
        ContentValues attvalue98 = new ContentValues();
        ContentValues attvalue99 = new ContentValues();
        ContentValues attvalue100 = new ContentValues();
        ContentValues attvalue101 = new ContentValues();
        ContentValues attvalue102 = new ContentValues();
        ContentValues attvalue103 = new ContentValues();
        ContentValues attvalue104 = new ContentValues();
        ContentValues attvalue105 = new ContentValues();
        ContentValues attvalue106 = new ContentValues();
        ContentValues attvalue107 = new ContentValues();
        ContentValues attvalue108 = new ContentValues();
        ContentValues attvalue109 = new ContentValues();
        ContentValues attvalue110 = new ContentValues();
        ContentValues attvalue111 = new ContentValues();
        ContentValues attvalue112 = new ContentValues();
        ContentValues attvalue113 = new ContentValues();
        ContentValues attvalue114 = new ContentValues();
        ContentValues attvalue115 = new ContentValues();
        ContentValues attvalue116 = new ContentValues();
        ContentValues attvalue117 = new ContentValues();
        ContentValues attvalue118 = new ContentValues();
        ContentValues attvalue119 = new ContentValues();
        ContentValues attvalue120 = new ContentValues();
        ContentValues attvalue121 = new ContentValues();
        ContentValues attvalue122 = new ContentValues();
        ContentValues attvalue123 = new ContentValues();
        ContentValues attvalue124 = new ContentValues();
        ContentValues attvalue125 = new ContentValues();
        ContentValues attvalue126 = new ContentValues();
        ContentValues attvalue127 = new ContentValues();
        ContentValues attvalue128 = new ContentValues();
        ContentValues attvalue129 = new ContentValues();
        ContentValues attvalue130 = new ContentValues();
        ContentValues attvalue131 = new ContentValues();
        ContentValues attvalue132 = new ContentValues();
        ContentValues attvalue133 = new ContentValues();
        ContentValues attvalue134 = new ContentValues();
        ContentValues attvalue135 = new ContentValues();
        ContentValues attvalue136 = new ContentValues();
        ContentValues attvalue137 = new ContentValues();
        ContentValues attvalue138 = new ContentValues();
        ContentValues attvalue139 = new ContentValues();
        ContentValues attvalue140 = new ContentValues();
        ContentValues attvalue141 = new ContentValues();
        ContentValues attvalue142 = new ContentValues();
        ContentValues attvalue143 = new ContentValues();
        ContentValues attvalue144 = new ContentValues();
        ContentValues attvalue145 = new ContentValues();
        ContentValues attvalue146 = new ContentValues();
        ContentValues attvalue147 = new ContentValues();
        ContentValues attvalue148 = new ContentValues();
        ContentValues attvalue149 = new ContentValues();
        ContentValues attvalue150 = new ContentValues();
        ContentValues attvalue151 = new ContentValues();
        ContentValues attvalue152 = new ContentValues();
        ContentValues attvalue153 = new ContentValues();
        ContentValues attvalue154 = new ContentValues();
        ContentValues attvalue155 = new ContentValues();
        ContentValues attvalue156 = new ContentValues();
        ContentValues attvalue157 = new ContentValues();
        ContentValues attvalue158 = new ContentValues();
        ContentValues attvalue159 = new ContentValues();
        ContentValues attvalue160 = new ContentValues();
        ContentValues attvalue161 = new ContentValues();
        ContentValues attvalue162 = new ContentValues();
        ContentValues attvalue163 = new ContentValues();
        ContentValues attvalue164 = new ContentValues();
        ContentValues attvalue165 = new ContentValues();
        ContentValues attvalue166 = new ContentValues();
        ContentValues attvalue167 = new ContentValues();
        ContentValues attvalue168 = new ContentValues();
        ContentValues attvalue169 = new ContentValues();
        ContentValues attvalue170 = new ContentValues();
        ContentValues attvalue171 = new ContentValues();
        ContentValues attvalue172 = new ContentValues();
        ContentValues attvalue173 = new ContentValues();
        ContentValues attvalue174 = new ContentValues();
        ContentValues attvalue175 = new ContentValues();
        ContentValues attvalue176 = new ContentValues();
        ContentValues attvalue177 = new ContentValues();
        ContentValues attvalue178 = new ContentValues();
        ContentValues attvalue179 = new ContentValues();
        ContentValues attvalue180 = new ContentValues();
        ContentValues attvalue181 = new ContentValues();
        ContentValues attvalue182 = new ContentValues();
        ContentValues attvalue183 = new ContentValues();
        ContentValues attvalue184 = new ContentValues();
        ContentValues attvalue185 = new ContentValues();
        ContentValues attvalue186 = new ContentValues();
        ContentValues attvalue187 = new ContentValues();
        ContentValues attvalue188 = new ContentValues();
        ContentValues attvalue189 = new ContentValues();
        ContentValues attvalue190 = new ContentValues();
        ContentValues attvalue191 = new ContentValues();
        ContentValues attvalue192 = new ContentValues();
        ContentValues attvalue193 = new ContentValues();
        ContentValues attvalue194 = new ContentValues();
        ContentValues attvalue195 = new ContentValues();
        ContentValues attvalue196 = new ContentValues();
        ContentValues attvalue197 = new ContentValues();
        ContentValues attvalue198 = new ContentValues();
        ContentValues attvalue199 = new ContentValues();
        ContentValues attvalue200 = new ContentValues();
        ContentValues attvalue201 = new ContentValues();
        ContentValues attvalue202 = new ContentValues();
        ContentValues attvalue203 = new ContentValues();
        ContentValues attvalue204 = new ContentValues();
        ContentValues attvalue205 = new ContentValues();
        ContentValues attvalue206 = new ContentValues();
        ContentValues attvalue207 = new ContentValues();
        ContentValues attvalue208 = new ContentValues();
        ContentValues attvalue209 = new ContentValues();
        ContentValues attvalue210 = new ContentValues();
        ContentValues attvalue211 = new ContentValues();
        ContentValues attvalue212 = new ContentValues();
        ContentValues attvalue213 = new ContentValues();
        ContentValues attvalue214 = new ContentValues();
        ContentValues attvalue215 = new ContentValues();
        ContentValues attvalue216 = new ContentValues();
        ContentValues attvalue217 = new ContentValues();
        ContentValues attvalue218 = new ContentValues();
        ContentValues attvalue219 = new ContentValues();
        ContentValues attvalue220 = new ContentValues();
        ContentValues attvalue221 = new ContentValues();
        ContentValues attvalue222 = new ContentValues();
        ContentValues attvalue223 = new ContentValues();
        ContentValues attvalue224 = new ContentValues();
        ContentValues attvalue225 = new ContentValues();
        ContentValues attvalue226 = new ContentValues();
        ContentValues attvalue227 = new ContentValues();
        ContentValues attvalue228 = new ContentValues();
        ContentValues attvalue229 = new ContentValues();
        ContentValues attvalue230 = new ContentValues();
        ContentValues attvalue231 = new ContentValues();
        ContentValues attvalue232 = new ContentValues();
        ContentValues attvalue233 = new ContentValues();
        ContentValues attvalue234 = new ContentValues();
        ContentValues attvalue235 = new ContentValues();
        ContentValues attvalue236 = new ContentValues();
        ContentValues attvalue237 = new ContentValues();
        ContentValues attvalue238 = new ContentValues();
        ContentValues attvalue239 = new ContentValues();
        ContentValues attvalue240 = new ContentValues();
        ContentValues attvalue241 = new ContentValues();
        ContentValues attvalue242 = new ContentValues();
        ContentValues attvalue243 = new ContentValues();
        ContentValues attvalue244 = new ContentValues();
        ContentValues attvalue245 = new ContentValues();
        ContentValues attvalue246 = new ContentValues();
        ContentValues attvalue247 = new ContentValues();
        ContentValues attvalue248 = new ContentValues();
        ContentValues attvalue249 = new ContentValues();
        ContentValues attvalue250 = new ContentValues();
        ContentValues attvalue251 = new ContentValues();
        ContentValues attvalue252 = new ContentValues();
        ContentValues attvalue253 = new ContentValues();
        ContentValues attvalue254 = new ContentValues();
        ContentValues attvalue255 = new ContentValues();
        ContentValues attvalue256 = new ContentValues();
        ContentValues attvalue257 = new ContentValues();
        ContentValues attvalue258 = new ContentValues();
        ContentValues attvalue259 = new ContentValues();
        ContentValues attvalue260 = new ContentValues();
        ContentValues attvalue261 = new ContentValues();
        ContentValues attvalue262 = new ContentValues();
        ContentValues attvalue263 = new ContentValues();
        ContentValues attvalue264 = new ContentValues();
        ContentValues attvalue265 = new ContentValues();
        ContentValues attvalue266 = new ContentValues();
        ContentValues attvalue267 = new ContentValues();
        ContentValues attvalue268 = new ContentValues();
        ContentValues attvalue269 = new ContentValues();
        ContentValues attvalue270 = new ContentValues();
        ContentValues attvalue271 = new ContentValues();
        ContentValues attvalue272 = new ContentValues();
        ContentValues attvalue273 = new ContentValues();
        ContentValues attvalue274 = new ContentValues();
        ContentValues attvalue275 = new ContentValues();
        ContentValues attvalue276 = new ContentValues();
        ContentValues attvalue277 = new ContentValues();
        ContentValues attvalue278 = new ContentValues();
        ContentValues attvalue279 = new ContentValues();
        ContentValues attvalue280 = new ContentValues();
        ContentValues attvalue281 = new ContentValues();
        ContentValues attvalue282 = new ContentValues();
        ContentValues attvalue283 = new ContentValues();
        ContentValues attvalue284 = new ContentValues();
        ContentValues attvalue285 = new ContentValues();
        ContentValues attvalue286 = new ContentValues();
        ContentValues attvalue287 = new ContentValues();
        ContentValues attvalue288 = new ContentValues();
        ContentValues attvalue289 = new ContentValues();
        ContentValues attvalue290 = new ContentValues();
        ContentValues attvalue291 = new ContentValues();
        ContentValues attvalue292 = new ContentValues();
        ContentValues attvalue293 = new ContentValues();
        ContentValues attvalue294 = new ContentValues();
        ContentValues attvalue295 = new ContentValues();
        ContentValues attvalue296 = new ContentValues();
        ContentValues attvalue297 = new ContentValues();
        ContentValues attvalue298 = new ContentValues();
        ContentValues attvalue299 = new ContentValues();
        ContentValues attvalue300 = new ContentValues();
        ContentValues attvalue301 = new ContentValues();
        ContentValues attvalue302 = new ContentValues();
        ContentValues attvalue303 = new ContentValues();
        ContentValues attvalue304 = new ContentValues();
        ContentValues attvalue305 = new ContentValues();
        ContentValues attvalue306 = new ContentValues();
        ContentValues attvalue307 = new ContentValues();
        ContentValues attvalue308 = new ContentValues();
        ContentValues attvalue309 = new ContentValues();
        ContentValues attvalue310 = new ContentValues();
        ContentValues attvalue311 = new ContentValues();
        ContentValues attvalue312 = new ContentValues();
        ContentValues attvalue313 = new ContentValues();
        ContentValues attvalue314 = new ContentValues();
        ContentValues attvalue315 = new ContentValues();
        ContentValues attvalue316 = new ContentValues();
        ContentValues attvalue317 = new ContentValues();
        ContentValues attvalue318 = new ContentValues();
        ContentValues attvalue319 = new ContentValues();
        ContentValues attvalue320 = new ContentValues();
        ContentValues attvalue321 = new ContentValues();
        ContentValues attvalue322 = new ContentValues();
        ContentValues attvalue323 = new ContentValues();
        ContentValues attvalue324 = new ContentValues();
        ContentValues attvalue325 = new ContentValues();
        ContentValues attvalue326 = new ContentValues();
        ContentValues attvalue327 = new ContentValues();
        ContentValues attvalue328 = new ContentValues();
        ContentValues attvalue329 = new ContentValues();
        ContentValues attvalue330 = new ContentValues();
        ContentValues attvalue331 = new ContentValues();
        ContentValues attvalue332 = new ContentValues();
        ContentValues attvalue333 = new ContentValues();
        ContentValues attvalue334 = new ContentValues();
        ContentValues attvalue335 = new ContentValues();
        ContentValues attvalue336 = new ContentValues();
        ContentValues attvalue337 = new ContentValues();
        ContentValues attvalue338 = new ContentValues();
        ContentValues attvalue339 = new ContentValues();
        ContentValues attvalue340 = new ContentValues();
        ContentValues attvalue341 = new ContentValues();
        ContentValues attvalue342 = new ContentValues();
        ContentValues attvalue343 = new ContentValues();
        ContentValues attvalue344 = new ContentValues();
        ContentValues attvalue345 = new ContentValues();
        ContentValues attvalue346 = new ContentValues();
        ContentValues attvalue347 = new ContentValues();
        ContentValues attvalue348 = new ContentValues();
        ContentValues attvalue349 = new ContentValues();
        ContentValues attvalue350 = new ContentValues();
        ContentValues attvalue351 = new ContentValues();
        ContentValues attvalue352 = new ContentValues();
        ContentValues attvalue353 = new ContentValues();
        ContentValues attvalue354 = new ContentValues();
        ContentValues attvalue355 = new ContentValues();
        ContentValues attvalue356 = new ContentValues();
        ContentValues attvalue357 = new ContentValues();
        ContentValues attvalue358 = new ContentValues();
        ContentValues attvalue359 = new ContentValues();
        ContentValues attvalue360 = new ContentValues();
        ContentValues attvalue361 = new ContentValues();
        ContentValues attvalue362 = new ContentValues();
        ContentValues attvalue363 = new ContentValues();
        ContentValues attvalue364 = new ContentValues();
        ContentValues attvalue365 = new ContentValues();
        ContentValues attvalue366 = new ContentValues();
        ContentValues attvalue367 = new ContentValues();
        ContentValues attvalue368 = new ContentValues();
        ContentValues attvalue369 = new ContentValues();
        ContentValues attvalue370 = new ContentValues();
        ContentValues attvalue371 = new ContentValues();
        ContentValues attvalue372 = new ContentValues();
        ContentValues attvalue373 = new ContentValues();
        ContentValues attvalue374 = new ContentValues();
        ContentValues attvalue375 = new ContentValues();
        ContentValues attvalue376 = new ContentValues();
        ContentValues attvalue377 = new ContentValues();
        ContentValues attvalue378 = new ContentValues();
        ContentValues attvalue379 = new ContentValues();
        ContentValues attvalue380 = new ContentValues();
        ContentValues attvalue381 = new ContentValues();
        ContentValues attvalue382 = new ContentValues();
        ContentValues attvalue383 = new ContentValues();
        ContentValues attvalue384 = new ContentValues();
        ContentValues attvalue385 = new ContentValues();
        ContentValues attvalue386 = new ContentValues();
        ContentValues attvalue387 = new ContentValues();
        ContentValues attvalue388 = new ContentValues();
        ContentValues attvalue389 = new ContentValues();
        ContentValues attvalue390 = new ContentValues();
        ContentValues attvalue391 = new ContentValues();
        ContentValues attvalue392 = new ContentValues();
        ContentValues attvalue393 = new ContentValues();
        ContentValues attvalue394 = new ContentValues();
        ContentValues attvalue395 = new ContentValues();
        ContentValues attvalue396 = new ContentValues();
        ContentValues attvalue397 = new ContentValues();
        ContentValues attvalue398 = new ContentValues();
        ContentValues attvalue399 = new ContentValues();
        ContentValues attvalue400 = new ContentValues();
        ContentValues attvalue401 = new ContentValues();
        ContentValues attvalue402 = new ContentValues();
        ContentValues attvalue403 = new ContentValues();
        ContentValues attvalue404 = new ContentValues();
        ContentValues attvalue405 = new ContentValues();
        ContentValues attvalue406 = new ContentValues();
        ContentValues attvalue407 = new ContentValues();
        ContentValues attvalue408 = new ContentValues();
        ContentValues attvalue409 = new ContentValues();
        ContentValues attvalue410 = new ContentValues();
        ContentValues attvalue411 = new ContentValues();
        ContentValues attvalue412 = new ContentValues();
        ContentValues attvalue413 = new ContentValues();
        ContentValues attvalue414 = new ContentValues();
        ContentValues attvalue415 = new ContentValues();
        ContentValues attvalue416 = new ContentValues();
        ContentValues attvalue417 = new ContentValues();
        ContentValues attvalue418 = new ContentValues();
        ContentValues attvalue419 = new ContentValues();
        ContentValues attvalue420 = new ContentValues();
        ContentValues attvalue421 = new ContentValues();
        ContentValues attvalue422 = new ContentValues();
        ContentValues attvalue423 = new ContentValues();
        ContentValues attvalue424 = new ContentValues();
        ContentValues attvalue425 = new ContentValues();
        ContentValues attvalue426 = new ContentValues();
        ContentValues attvalue427 = new ContentValues();
        ContentValues attvalue428 = new ContentValues();
        ContentValues attvalue429 = new ContentValues();
        ContentValues attvalue430 = new ContentValues();
        ContentValues attvalue431 = new ContentValues();
        ContentValues attvalue432 = new ContentValues();
        ContentValues attvalue433 = new ContentValues();
        ContentValues attvalue434 = new ContentValues();
        ContentValues attvalue435 = new ContentValues();
        ContentValues attvalue436 = new ContentValues();
        ContentValues attvalue437 = new ContentValues();
        ContentValues attvalue438 = new ContentValues();
        ContentValues attvalue439 = new ContentValues();
        ContentValues attvalue440 = new ContentValues();
        ContentValues attvalue441 = new ContentValues();
        ContentValues attvalue442 = new ContentValues();
        ContentValues attvalue443 = new ContentValues();
        ContentValues attvalue444 = new ContentValues();
        ContentValues attvalue445 = new ContentValues();
        ContentValues attvalue446 = new ContentValues();
        ContentValues attvalue447 = new ContentValues();
        ContentValues attvalue448 = new ContentValues();
        ContentValues attvalue449 = new ContentValues();
        ContentValues attvalue450 = new ContentValues();
        ContentValues attvalue451 = new ContentValues();
        ContentValues attvalue452 = new ContentValues();
        ContentValues attvalue453 = new ContentValues();
        ContentValues attvalue454 = new ContentValues();
        ContentValues attvalue455 = new ContentValues();
        ContentValues attvalue456 = new ContentValues();
        ContentValues attvalue457 = new ContentValues();
        ContentValues attvalue458 = new ContentValues();
        ContentValues attvalue459 = new ContentValues();
        ContentValues attvalue460 = new ContentValues();
        ContentValues attvalue461 = new ContentValues();
        ContentValues attvalue462 = new ContentValues();
        ContentValues attvalue463 = new ContentValues();
        ContentValues attvalue464 = new ContentValues();
        ContentValues attvalue465 = new ContentValues();
        ContentValues attvalue466 = new ContentValues();
        ContentValues attvalue467 = new ContentValues();
        ContentValues attvalue468 = new ContentValues();
        ContentValues attvalue469 = new ContentValues();
        ContentValues attvalue470 = new ContentValues();
        ContentValues attvalue471 = new ContentValues();
        ContentValues attvalue472 = new ContentValues();
        ContentValues attvalue473 = new ContentValues();
        ContentValues attvalue474 = new ContentValues();
        ContentValues attvalue475 = new ContentValues();
        ContentValues attvalue476 = new ContentValues();
        ContentValues attvalue477 = new ContentValues();
        ContentValues attvalue478 = new ContentValues();
        ContentValues attvalue479 = new ContentValues();
        ContentValues attvalue480 = new ContentValues();
        ContentValues attvalue481 = new ContentValues();
        ContentValues attvalue482 = new ContentValues();
        ContentValues attvalue483 = new ContentValues();
        ContentValues attvalue484 = new ContentValues();
        ContentValues attvalue485 = new ContentValues();
        ContentValues attvalue486 = new ContentValues();
        ContentValues attvalue487 = new ContentValues();
        ContentValues attvalue488 = new ContentValues();
        ContentValues attvalue489 = new ContentValues();
        ContentValues attvalue490 = new ContentValues();
        ContentValues attvalue491 = new ContentValues();
        ContentValues attvalue492 = new ContentValues();
        ContentValues attvalue493 = new ContentValues();
        ContentValues attvalue494 = new ContentValues();
        ContentValues attvalue495 = new ContentValues();
        ContentValues attvalue496 = new ContentValues();
        ContentValues attvalue497 = new ContentValues();
        ContentValues attvalue498 = new ContentValues();
        ContentValues attvalue499 = new ContentValues();
        ContentValues attvalue500 = new ContentValues();




        String table_nameatt = "Attitudetable";

        attvalue.put("AttitudeID",1);
        attvalue.put("AttitudeWord","กตัญญู");
        attvalue.put("AttitudeRank",1);
        attvalue.put("Emotion","8");

        attvalue2.put("AttitudeID",2);
        attvalue2.put("AttitudeWord","ก็ดี");
        attvalue2.put("AttitudeRank",1);
        attvalue2.put("Emotion","27");

        attvalue3.put("AttitudeID",3);
        attvalue3.put("AttitudeWord","กระจ่าง");
        attvalue3.put("AttitudeRank",1);
        attvalue3.put("Emotion","8");

        attvalue4.put("AttitudeID",4);
        attvalue4.put("AttitudeWord","กระฉับกระเฉง");
        attvalue4.put("AttitudeRank",1);
        attvalue4.put("Emotion","8");

        attvalue5.put("AttitudeID",5);
        attvalue5.put("AttitudeWord","กระตือรือร้น");
        attvalue5.put("AttitudeRank",1);
        attvalue5.put("Emotion","7");

        attvalue6.put("AttitudeID",6);
        attvalue6.put("AttitudeWord","กลมกล่อม");
        attvalue6.put("AttitudeRank",1);
        attvalue6.put("Emotion","8");

        attvalue7.put("AttitudeID",7);
        attvalue7.put("AttitudeWord","กล้า");
        attvalue7.put("AttitudeRank",1);
        attvalue7.put("Emotion","2");

        attvalue8.put("AttitudeID",8);
        attvalue8.put("AttitudeWord","กล้าหาญ");
        attvalue8.put("AttitudeRank",1);
        attvalue8.put("Emotion","2");

        attvalue9.put("AttitudeID",9);
        attvalue9.put("AttitudeWord","กว้าง");
        attvalue9.put("AttitudeRank",1);
        attvalue9.put("Emotion","8");

        attvalue10.put("AttitudeID",10);
        attvalue10.put("AttitudeWord","กว้างขวาง");
        attvalue10.put("AttitudeRank",1);
        attvalue10.put("Emotion","8");

        attvalue11.put("AttitudeID",11);
        attvalue11.put("AttitudeWord","กะทัดรัด");
        attvalue11.put("AttitudeRank",1);
        attvalue11.put("Emotion","2");

        attvalue12.put("AttitudeID",12);
        attvalue12.put("AttitudeWord","กังวาน");
        attvalue12.put("AttitudeRank",1);
        attvalue12.put("Emotion","2");

        attvalue13.put("AttitudeID",13);
        attvalue13.put("AttitudeWord","กำยำ");
        attvalue13.put("AttitudeRank",1);
        attvalue13.put("Emotion","8");

        attvalue14.put("AttitudeID",14);
        attvalue14.put("AttitudeWord","กำไร");
        attvalue14.put("AttitudeRank",1);
        attvalue14.put("Emotion","8");

        attvalue15.put("AttitudeID",15);
        attvalue15.put("AttitudeWord","กำลังใจ");
        attvalue15.put("AttitudeRank",1);
        attvalue15.put("Emotion","27");

        attvalue16.put("AttitudeID",16);
        attvalue16.put("AttitudeWord","กิตติมศักดิ์");
        attvalue16.put("AttitudeRank",1);
        attvalue16.put("Emotion","2");

        attvalue17.put("AttitudeID",17);
        attvalue17.put("AttitudeWord","กินใจ");
        attvalue17.put("AttitudeRank",1);
        attvalue17.put("Emotion","2");

        attvalue18.put("AttitudeID",18);
        attvalue18.put("AttitudeWord","เก่ง");
        attvalue18.put("AttitudeRank",1);
        attvalue18.put("Emotion","27");

        attvalue19.put("AttitudeID",19);
        attvalue19.put("AttitudeWord","เกษมสันต์");
        attvalue19.put("AttitudeRank",1);
        attvalue19.put("Emotion","7");

        attvalue20.put("AttitudeID",20);
        attvalue20.put("AttitudeWord","แก่กล้า");
        attvalue20.put("AttitudeRank",1);
        attvalue20.put("Emotion","2");

        attvalue21.put("AttitudeID",21);
        attvalue21.put("AttitudeWord","แก้มใส");
        attvalue21.put("AttitudeRank",1);
        attvalue21.put("Emotion","8");

        attvalue22.put("AttitudeID",22);
        attvalue22.put("AttitudeWord","แกร่ง");
        attvalue22.put("AttitudeRank",1);
        attvalue22.put("Emotion","8");

        attvalue23.put("AttitudeID",23);
        attvalue23.put("AttitudeWord","โก้");
        attvalue23.put("AttitudeRank",1);
        attvalue23.put("Emotion","8");

        attvalue24.put("AttitudeID",24);
        attvalue24.put("AttitudeWord","ขจร");
        attvalue24.put("AttitudeRank",1);
        attvalue24.put("Emotion","8");

        attvalue25.put("AttitudeID",25);
        attvalue25.put("AttitudeWord","ขยัน");
        attvalue25.put("AttitudeRank",1);
        attvalue25.put("Emotion","2");

        attvalue26.put("AttitudeID",26);
        attvalue26.put("AttitudeWord","ขรึม");
        attvalue26.put("AttitudeRank",1);
        attvalue26.put("Emotion","8");

        attvalue27.put("AttitudeID",27);
        attvalue27.put("AttitudeWord","ขลัง");
        attvalue27.put("AttitudeRank",1);
        attvalue27.put("Emotion","8");

        attvalue28.put("AttitudeID",28);
        attvalue28.put("AttitudeWord","ขวัญใจ");
        attvalue28.put("AttitudeRank",1);
        attvalue28.put("Emotion","27");

        attvalue29.put("AttitudeID",29);
        attvalue29.put("AttitudeWord","ของดี");
        attvalue29.put("AttitudeRank",1);
        attvalue29.put("Emotion","2");

        attvalue30.put("AttitudeID",30);
        attvalue30.put("AttitudeWord","ของแท้");
        attvalue30.put("AttitudeRank",1);
        attvalue30.put("Emotion","2");

        attvalue31.put("AttitudeID",31);
        attvalue31.put("AttitudeWord","ขอบคุณ");
        attvalue31.put("AttitudeRank",1);
        attvalue31.put("Emotion","8");

        attvalue32.put("AttitudeID",32);
        attvalue32.put("AttitudeWord","ขายดี");
        attvalue32.put("AttitudeRank",1);
        attvalue32.put("Emotion","7");

        attvalue33.put("AttitudeID",33);
        attvalue33.put("AttitudeWord","ขาวใส");
        attvalue33.put("AttitudeRank",1);
        attvalue33.put("Emotion","8");

        attvalue34.put("AttitudeID",34);
        attvalue34.put("AttitudeWord","ขาวใส");
        attvalue34.put("AttitudeRank",1);
        attvalue34.put("Emotion","8");

        attvalue35.put("AttitudeID",35);
        attvalue35.put("AttitudeWord","ขำขัน");
        attvalue35.put("AttitudeRank",1);
        attvalue35.put("Emotion","7");  //7

        attvalue36.put("AttitudeID",36);
        attvalue36.put("AttitudeWord","ขำขำ");
        attvalue36.put("AttitudeRank",1);
        attvalue36.put("Emotion","7");//7

        attvalue37.put("AttitudeID",37);
        attvalue37.put("AttitudeWord","เข้าท่า");
        attvalue37.put("AttitudeRank",1);
        attvalue37.put("Emotion","2");

        attvalue38.put("AttitudeID",38);
        attvalue38.put("AttitudeWord","แข็งแกร่ง");
        attvalue38.put("AttitudeRank",1);
        attvalue38.put("Emotion","8");

        attvalue39.put("AttitudeID",39);
        attvalue39.put("AttitudeWord","แข็งแรง");
        attvalue39.put("AttitudeRank",1);
        attvalue39.put("Emotion","8");

        attvalue40.put("AttitudeID",40);
        attvalue40.put("AttitudeWord","คนทน");
        attvalue40.put("AttitudeRank",1);
        attvalue40.put("Emotion","8");

        attvalue41.put("AttitudeID",41);
        attvalue41.put("AttitudeWord","คมกริบ");
        attvalue41.put("AttitudeRank",1);
        attvalue41.put("Emotion","8");

        attvalue42.put("AttitudeID",42);
        attvalue42.put("AttitudeWord","คมขำ");
        attvalue42.put("AttitudeRank",1);
        attvalue42.put("Emotion","8");

        attvalue43.put("AttitudeID",43);
        attvalue43.put("AttitudeWord","คมชัด");
        attvalue43.put("AttitudeRank",1);
        attvalue43.put("Emotion","8");

        attvalue44.put("AttitudeID",44);
        attvalue44.put("AttitudeWord","คมสัน");
        attvalue44.put("AttitudeRank",1);
        attvalue44.put("Emotion","8");

        attvalue45.put("AttitudeID",45);
        attvalue45.put("AttitudeWord","ครบรส");
        attvalue45.put("AttitudeRank",1);
        attvalue45.put("Emotion","8");

        attvalue46.put("AttitudeID",46);
        attvalue46.put("AttitudeWord","คล่อง");
        attvalue46.put("AttitudeRank",1);
        attvalue46.put("Emotion","8");

        attvalue47.put("AttitudeID",47);
        attvalue47.put("AttitudeWord","คารมดี");
        attvalue47.put("AttitudeRank",1);
        attvalue47.put("Emotion","7");

        attvalue48.put("AttitudeID",48);
        attvalue48.put("AttitudeWord","คิกขุ");
        attvalue48.put("AttitudeRank",1);
        attvalue48.put("Emotion","7");

        attvalue49.put("AttitudeID",49);
        attvalue49.put("AttitudeWord","คิดดี");
        attvalue49.put("AttitudeRank",1);
        attvalue49.put("Emotion","7");

        attvalue50.put("AttitudeID",50);
        attvalue50.put("AttitudeWord","คิดถึง");
        attvalue50.put("AttitudeRank",1);
        attvalue50.put("Emotion","8");

        attvalue51.put("AttitudeID",51);
        attvalue51.put("AttitudeWord","คิดฮอด");
        attvalue51.put("AttitudeRank",1);
        attvalue51.put("Emotion","8");

        attvalue52.put("AttitudeID",52);
        attvalue52.put("AttitudeWord","คึก");
        attvalue52.put("AttitudeRank",1);
        attvalue52.put("Emotion","7");

        attvalue53.put("AttitudeID",53);
        attvalue53.put("AttitudeWord","คึกคัก");
        attvalue53.put("AttitudeRank",1);
        attvalue53.put("Emotion","7");

        attvalue54.put("AttitudeID",54);
        attvalue54.put("AttitudeWord","คุ้ม");
        attvalue54.put("AttitudeRank",1);
        attvalue54.put("Emotion","2");

        attvalue55.put("AttitudeID",55);
        attvalue55.put("AttitudeWord","คุ้มค่า");
        attvalue55.put("AttitudeRank",1);
        attvalue55.put("Emotion","2");

        attvalue56.put("AttitudeID",56);
        attvalue56.put("AttitudeWord","คู่ควร");
        attvalue56.put("AttitudeRank",1);
        attvalue56.put("Emotion","2");

        attvalue57.put("AttitudeID",57);
        attvalue57.put("AttitudeWord","แคร์");
        attvalue57.put("AttitudeRank",1);
        attvalue57.put("Emotion","8");

        attvalue58.put("AttitudeID",58);
        attvalue58.put("AttitudeWord","ใคร่");
        attvalue58.put("AttitudeRank",1);
        attvalue58.put("Emotion","8");

        attvalue59.put("AttitudeID",59);
        attvalue59.put("AttitudeWord","งดงาม");
        attvalue59.put("AttitudeRank",1);
        attvalue59.put("Emotion","27");

        attvalue60.put("AttitudeID",60);
        attvalue60.put("AttitudeWord","งอกงาม");
        attvalue60.put("AttitudeRank",1);
        attvalue60.put("Emotion","7");

        attvalue61.put("AttitudeID",61);
        attvalue61.put("AttitudeWord","งาม");
        attvalue61.put("AttitudeRank",1);
        attvalue61.put("Emotion","27");

        attvalue62.put("AttitudeID",62);
        attvalue62.put("AttitudeWord","งามตา");
        attvalue62.put("AttitudeRank",1);
        attvalue62.put("Emotion","27");

        attvalue63.put("AttitudeID",63);
        attvalue63.put("AttitudeWord","ง่าย");
        attvalue63.put("AttitudeRank",1);
        attvalue63.put("Emotion","8");

        attvalue64.put("AttitudeID",64);
        attvalue64.put("AttitudeWord","ง่ายดี");
        attvalue64.put("AttitudeRank",1);
        attvalue64.put("Emotion","8");

        attvalue65.put("AttitudeID",65);
        attvalue65.put("AttitudeWord","จริงจัง");
        attvalue65.put("AttitudeRank",1);
        attvalue65.put("Emotion","8");

        attvalue66.put("AttitudeID",66);
        attvalue66.put("AttitudeWord","จริงใจ");
        attvalue66.put("AttitudeRank",1);
        attvalue66.put("Emotion","2");

        attvalue67.put("AttitudeID",67);
        attvalue67.put("AttitudeWord","จับใจ");
        attvalue67.put("AttitudeRank",1);
        attvalue67.put("Emotion","8");

        attvalue68.put("AttitudeID",68);
        attvalue68.put("AttitudeWord","จ๊าบ");
        attvalue68.put("AttitudeRank",1);
        attvalue68.put("Emotion","8");

        attvalue69.put("AttitudeID",69);
        attvalue69.put("AttitudeWord","จุใจ");
        attvalue69.put("AttitudeRank",1);
        attvalue69.put("Emotion","7");

        attvalue70.put("AttitudeID",70);
        attvalue70.put("AttitudeWord","แจ่ม");
        attvalue70.put("AttitudeRank",1);
        attvalue70.put("Emotion","27");

        attvalue71.put("AttitudeID",71);
        attvalue71.put("AttitudeWord","แจ่มใส");
        attvalue71.put("AttitudeRank",1);
        attvalue71.put("Emotion","27");

        attvalue72.put("AttitudeID",72);
        attvalue72.put("AttitudeWord","แจ๋ว");
        attvalue72.put("AttitudeRank",1);
        attvalue72.put("Emotion","2");

        attvalue73.put("AttitudeID",73);
        attvalue73.put("AttitudeWord","ใจกล้า");
        attvalue73.put("AttitudeRank",1);
        attvalue73.put("Emotion","2");

        attvalue74.put("AttitudeID",74);
        attvalue74.put("AttitudeWord","ใจชื้น");
        attvalue74.put("AttitudeRank",1);
        attvalue74.put("Emotion","2");

        attvalue75.put("AttitudeID",75);
        attvalue75.put("AttitudeWord","ใจดี");
        attvalue75.put("AttitudeRank",1);
        attvalue75.put("Emotion","27");

        attvalue76.put("AttitudeID",76);
        attvalue76.put("AttitudeWord","ใจบุญ");
        attvalue76.put("AttitudeRank",1);
        attvalue76.put("Emotion","2");

        attvalue77.put("AttitudeID",77);
        attvalue77.put("AttitudeWord","ใจเย็น");
        attvalue77.put("AttitudeRank",1);
        attvalue77.put("Emotion","2");

        attvalue78.put("AttitudeID",78);
        attvalue78.put("AttitudeWord","ใจรัก");
        attvalue78.put("AttitudeRank",1);
        attvalue78.put("Emotion","2");

        attvalue79.put("AttitudeID",79);
        attvalue79.put("AttitudeWord","ฉลอง");
        attvalue79.put("AttitudeRank",1);
        attvalue79.put("Emotion","7");

        attvalue80.put("AttitudeID",80);
        attvalue80.put("AttitudeWord","ฉลาด");
        attvalue80.put("AttitudeRank",1);
        attvalue80.put("Emotion","2");

        attvalue81.put("AttitudeID",81);
        attvalue81.put("AttitudeWord","ฉลาดเฉลียว");
        attvalue81.put("AttitudeRank",1);
        attvalue81.put("Emotion","2");

        attvalue82.put("AttitudeID",82);
        attvalue82.put("AttitudeWord","ฉะฉาน");
        attvalue82.put("AttitudeRank",1);
        attvalue82.put("Emotion","2");

        attvalue83.put("AttitudeID",83);
        attvalue83.put("AttitudeWord","ฉับไว");
        attvalue83.put("AttitudeRank",1);
        attvalue83.put("Emotion","8");

        attvalue84.put("AttitudeID",84);
        attvalue84.put("AttitudeWord","โฉมงาม");
        attvalue84.put("AttitudeRank",1);
        attvalue84.put("Emotion","2");

        attvalue85.put("AttitudeID",85);
        attvalue85.put("AttitudeWord","ไฉไล");
        attvalue85.put("AttitudeRank",1);
        attvalue85.put("Emotion","27");

        attvalue86.put("AttitudeID",86);
        attvalue86.put("AttitudeWord","ชนะ");
        attvalue86.put("AttitudeRank",1);
        attvalue86.put("Emotion","2");

        attvalue87.put("AttitudeID",87);
        attvalue87.put("AttitudeWord","ชม");
        attvalue87.put("AttitudeRank",1);
        attvalue87.put("Emotion","2");

        attvalue88.put("AttitudeID",88);
        attvalue88.put("AttitudeWord","ชมชอบ");
        attvalue88.put("AttitudeRank",1);
        attvalue88.put("Emotion","2");

        attvalue89.put("AttitudeID",89);
        attvalue89.put("AttitudeWord","ชอบ");
        attvalue89.put("AttitudeRank",1);
        attvalue89.put("Emotion","2");

        attvalue90.put("AttitudeID",90);
        attvalue90.put("AttitudeWord","ชอบจัง");
        attvalue90.put("AttitudeRank",1);
        attvalue90.put("Emotion","2");

        attvalue91.put("AttitudeID",91);
        attvalue91.put("AttitudeWord","ชอบใจ");
        attvalue91.put("AttitudeRank",1);
        attvalue91.put("Emotion","2");

        attvalue92.put("AttitudeID",92);
        attvalue92.put("AttitudeWord","ชัด");
        attvalue92.put("AttitudeRank",1);
        attvalue92.put("Emotion","8");

        attvalue93.put("AttitudeID",93);
        attvalue93.put("AttitudeWord","ชัดเจน");
        attvalue93.put("AttitudeRank",1);
        attvalue93.put("Emotion","8");

        attvalue94.put("AttitudeID",94);
        attvalue94.put("AttitudeWord","ชั้นเยี่ยม");
        attvalue94.put("AttitudeRank",1);
        attvalue94.put("Emotion","2");

        attvalue95.put("AttitudeID",95);
        attvalue95.put("AttitudeWord","ช่างสังเกต");
        attvalue95.put("AttitudeRank",1);
        attvalue95.put("Emotion","8");

        attvalue96.put("AttitudeID",96);
        attvalue96.put("AttitudeWord","ชาญฉลาด");
        attvalue96.put("AttitudeRank",1);
        attvalue96.put("Emotion","2");

        attvalue97.put("AttitudeID",97);
        attvalue97.put("AttitudeWord","ช่ำชอง");
        attvalue97.put("AttitudeRank",1);
        attvalue97.put("Emotion","2");

        attvalue98.put("AttitudeID",98);
        attvalue98.put("AttitudeWord","ชิวชิว");
        attvalue98.put("AttitudeRank",1);
        attvalue98.put("Emotion","7");

        attvalue99.put("AttitudeID",99);
        attvalue99.put("AttitudeWord","ชื่น");
        attvalue99.put("AttitudeRank",1);
        attvalue99.put("Emotion","7");

        attvalue100.put("AttitudeID",100);
        attvalue100.put("AttitudeWord","ชื่นใจ");
        attvalue100.put("AttitudeRank",1);
        attvalue100.put("Emotion","7");

        attvalue101.put("AttitudeID",101);
        attvalue101.put("AttitudeWord","ชื่นชม");
        attvalue101.put("AttitudeRank",1);
        attvalue101.put("Emotion","7");

        attvalue102.put("AttitudeID",102);
        attvalue102.put("AttitudeWord","ชื่นชอบ");
        attvalue102.put("AttitudeRank",1);
        attvalue102.put("Emotion","7");

        attvalue103.put("AttitudeID",103);
        attvalue103.put("AttitudeWord","ชื่นตา");
        attvalue103.put("AttitudeRank",1);
        attvalue103.put("Emotion","7");

        attvalue104.put("AttitudeID",104);
        attvalue104.put("AttitudeWord","ชื่นบาน");
        attvalue104.put("AttitudeRank",1);
        attvalue104.put("Emotion","7");

        attvalue105.put("AttitudeID",105);
        attvalue105.put("AttitudeWord","ชุ่มใจ");
        attvalue105.put("AttitudeRank",1);
        attvalue105.put("Emotion","7");

        attvalue106.put("AttitudeID",106);
        attvalue106.put("AttitudeWord","ชุ่มชื่น");
        attvalue106.put("AttitudeRank",1);
        attvalue106.put("Emotion","7");

        attvalue107.put("AttitudeID",107);
        attvalue107.put("AttitudeWord","โชคดี");
        attvalue107.put("AttitudeRank",1);
        attvalue107.put("Emotion","7");

        attvalue108.put("AttitudeID",108);
        attvalue108.put("AttitudeWord","ไชโย");
        attvalue108.put("AttitudeRank",1);
        attvalue108.put("Emotion","7");

        attvalue109.put("AttitudeID",109);
        attvalue109.put("AttitudeWord","ซาบซึ้ง");
        attvalue109.put("AttitudeRank",1);
        attvalue109.put("Emotion","8");

        attvalue110.put("AttitudeID",110);
        attvalue110.put("AttitudeWord","ซึ้ง");
        attvalue110.put("AttitudeRank",1);
        attvalue110.put("Emotion","8");

        attvalue111.put("AttitudeID",111);
        attvalue111.put("AttitudeWord","ซึ้งใจ");
        attvalue111.put("AttitudeRank",1);
        attvalue111.put("Emotion","8");

        attvalue112.put("AttitudeID",112);
        attvalue112.put("AttitudeWord","ซื่อ");
        attvalue112.put("AttitudeRank",1);
        attvalue112.put("Emotion","2");

        attvalue113.put("AttitudeID",113);
        attvalue113.put("AttitudeWord","ซื่อตรง");
        attvalue113.put("AttitudeRank",1);
        attvalue113.put("Emotion","2");

        attvalue114.put("AttitudeID",114);
        attvalue114.put("AttitudeWord","ซื่อสัตย์");
        attvalue114.put("AttitudeRank",1);
        attvalue114.put("Emotion","2");

        attvalue115.put("AttitudeID",115);
        attvalue115.put("AttitudeWord","แซบ");
        attvalue115.put("AttitudeRank",1);
        attvalue115.put("Emotion","8");

        attvalue116.put("AttitudeID",116);
        attvalue116.put("AttitudeWord","แซ่บ");
        attvalue116.put("AttitudeRank",1);
        attvalue116.put("Emotion","8");

        attvalue117.put("AttitudeID",117);
        attvalue117.put("AttitudeWord","ดังใจ");
        attvalue117.put("AttitudeRank",1);
        attvalue117.put("Emotion","8");

        attvalue118.put("AttitudeID",118);
        attvalue118.put("AttitudeWord","ดิบดี");
        attvalue118.put("AttitudeRank",1);
        attvalue118.put("Emotion","27");

        attvalue119.put("AttitudeID",119);
        attvalue119.put("AttitudeWord","ดี");
        attvalue119.put("AttitudeRank",1);
        attvalue119.put("Emotion","27");

        attvalue120.put("AttitudeID",120);
        attvalue120.put("AttitudeWord","ดีงาม");
        attvalue120.put("AttitudeRank",1);
        attvalue120.put("Emotion","27");

        attvalue121.put("AttitudeID",121);
        attvalue121.put("AttitudeWord","ดีใจ");
        attvalue121.put("AttitudeRank",1);
        attvalue121.put("Emotion","7");

        attvalue122.put("AttitudeID",122);
        attvalue122.put("AttitudeWord","ดี๊ด๊า");
        attvalue122.put("AttitudeRank",1);
        attvalue122.put("Emotion","7");

        attvalue123.put("AttitudeID",123);
        attvalue123.put("AttitudeWord","ดี๊ดี");
        attvalue123.put("AttitudeRank",1);
        attvalue123.put("Emotion","27");

        attvalue124.put("AttitudeID",124);
        attvalue124.put("AttitudeWord","ดีเด่น");
        attvalue124.put("AttitudeRank",1);
        attvalue124.put("Emotion","27");

        attvalue125.put("AttitudeID",125);
        attvalue125.put("AttitudeWord","ดีนะ");
        attvalue125.put("AttitudeRank",1);
        attvalue125.put("Emotion","2");

        attvalue126.put("AttitudeID",126);
        attvalue126.put("AttitudeWord","ดีนะ");
        attvalue126.put("AttitudeRank",1);
        attvalue126.put("Emotion","27");

        attvalue127.put("AttitudeID",127);
        attvalue127.put("AttitudeWord","ดีเยี่ยม");
        attvalue127.put("AttitudeRank",1);
        attvalue127.put("Emotion","27");

        attvalue128.put("AttitudeID",128);
        attvalue128.put("AttitudeWord","ดีเลิศ");
        attvalue128.put("AttitudeRank",1);
        attvalue128.put("Emotion","27");

        attvalue129.put("AttitudeID",129);
        attvalue129.put("AttitudeWord","ดีแล้ว");
        attvalue129.put("AttitudeRank",1);
        attvalue129.put("Emotion","8");

        attvalue130.put("AttitudeID",130);
        attvalue130.put("AttitudeWord","ดูดี");
        attvalue130.put("AttitudeRank",1);
        attvalue130.put("Emotion","8");

        attvalue131.put("AttitudeID",131);
        attvalue131.put("AttitudeWord","เด่น");
        attvalue131.put("AttitudeRank",1);
        attvalue131.put("Emotion","8");

        attvalue132.put("AttitudeID",132);
        attvalue132.put("AttitudeWord","เด่นชัด");
        attvalue132.put("AttitudeRank",1);
        attvalue132.put("Emotion","8");

        attvalue133.put("AttitudeID",133);
        attvalue133.put("AttitudeWord","โดดเด่น");
        attvalue133.put("AttitudeRank",1);
        attvalue133.put("Emotion","8");

        attvalue134.put("AttitudeID",134);
        attvalue134.put("AttitudeWord","โดนใจ");
        attvalue134.put("AttitudeRank",1);
        attvalue134.put("Emotion","27");

        attvalue135.put("AttitudeID",135);
        attvalue135.put("AttitudeWord","ตรงใจ");
        attvalue135.put("AttitudeRank",1);
        attvalue135.put("Emotion","27");

        attvalue136.put("AttitudeID",136);
        attvalue136.put("AttitudeWord","ตรึงใจ");
        attvalue136.put("AttitudeRank",1);
        attvalue136.put("Emotion","8");

        attvalue137.put("AttitudeID",137);
        attvalue137.put("AttitudeWord","ตลก");
        attvalue137.put("AttitudeRank",1);
        attvalue137.put("Emotion","7");

        attvalue138.put("AttitudeID",138);
        attvalue138.put("AttitudeWord","ต้องใจ");
        attvalue138.put("AttitudeRank",1);
        attvalue138.put("Emotion","8");

        attvalue139.put("AttitudeID",139);
        attvalue139.put("AttitudeWord","ตาคม");
        attvalue139.put("AttitudeRank",1);
        attvalue139.put("Emotion","8");

        attvalue140.put("AttitudeID",140);
        attvalue140.put("AttitudeWord","ตาถึง");
        attvalue140.put("AttitudeRank",1);
        attvalue140.put("Emotion","8");

        attvalue141.put("AttitudeID",141);
        attvalue141.put("AttitudeWord","ติดใจ");
        attvalue141.put("AttitudeRank",1);
        attvalue141.put("Emotion","2");

        attvalue142.put("AttitudeID",142);
        attvalue142.put("AttitudeWord","ติดทน");
        attvalue142.put("AttitudeRank",1);
        attvalue142.put("Emotion","8");

        attvalue143.put("AttitudeID",143);
        attvalue143.put("AttitudeWord","ติดหู");
        attvalue143.put("AttitudeRank",1);
        attvalue143.put("Emotion","8");

        attvalue144.put("AttitudeID",144);
        attvalue144.put("AttitudeWord","ตื่นตา");
        attvalue144.put("AttitudeRank",1);
        attvalue144.put("Emotion","7");

        attvalue145.put("AttitudeID",145);
        attvalue145.put("AttitudeWord","ถนัด");
        attvalue145.put("AttitudeRank",1);
        attvalue145.put("Emotion","8");

        attvalue146.put("AttitudeID",146);
        attvalue146.put("AttitudeWord","ถนัดใจ");
        attvalue146.put("AttitudeRank",1);
        attvalue146.put("Emotion","8");

        attvalue147.put("AttitudeID",147);
        attvalue147.put("AttitudeWord","ถึงใจ");
        attvalue147.put("AttitudeRank",1);
        attvalue147.put("Emotion","8");

        attvalue148.put("AttitudeID",148);
        attvalue148.put("AttitudeWord","ถูก");
        attvalue148.put("AttitudeRank",1);
        attvalue148.put("Emotion","8");

        attvalue149.put("AttitudeID",149);
        attvalue149.put("AttitudeWord","ถูกคอ");
        attvalue149.put("AttitudeRank",1);
        attvalue149.put("Emotion","2");

        attvalue150.put("AttitudeID",150);
        attvalue150.put("AttitudeWord","ถูกใจ");
        attvalue150.put("AttitudeRank",1);
        attvalue150.put("Emotion","27");

        attvalue151.put("AttitudeID",151);
        attvalue151.put("AttitudeWord","ถูกดี");
        attvalue151.put("AttitudeRank",1);
        attvalue151.put("Emotion","8");

        attvalue152.put("AttitudeID",152);
        attvalue152.put("AttitudeWord","ถูกต้อง");
        attvalue152.put("AttitudeRank",1);
        attvalue152.put("Emotion","2");

        attvalue153.put("AttitudeID",153);
        attvalue153.put("AttitudeWord","ถูกปาก");
        attvalue153.put("AttitudeRank",1);
        attvalue153.put("Emotion","8");

        attvalue154.put("AttitudeID",154);
        attvalue154.put("AttitudeWord","ทนทาน");
        attvalue154.put("AttitudeRank",1);
        attvalue154.put("Emotion","2");

        attvalue155.put("AttitudeID",155);
        attvalue155.put("AttitudeWord","ทะนุถนอม");
        attvalue155.put("AttitudeRank",1);
        attvalue155.put("Emotion","27");

        attvalue156.put("AttitudeID",156);
        attvalue156.put("AttitudeWord","ทะมัดทะแมง");
        attvalue156.put("AttitudeRank",1);
        attvalue156.put("Emotion","8");

        attvalue157.put("AttitudeID",157);
        attvalue157.put("AttitudeWord","ทะเยอทะยาน");
        attvalue157.put("AttitudeRank",1);
        attvalue157.put("Emotion","27");

        attvalue158.put("AttitudeID",158);
        attvalue158.put("AttitudeWord","ทันใจ");
        attvalue158.put("AttitudeRank",1);
        attvalue158.put("Emotion","8");

        attvalue159.put("AttitudeID",159);
        attvalue159.put("AttitudeWord","ทันสมัย");
        attvalue159.put("AttitudeRank",1);
        attvalue159.put("Emotion","8");

        attvalue160.put("AttitudeID",160);
        attvalue160.put("AttitudeWord","ทึ่ง");
        attvalue160.put("AttitudeRank",1);
        attvalue160.put("Emotion","27");

        attvalue161.put("AttitudeID",161);
        attvalue161.put("AttitudeWord","เทพ");
        attvalue161.put("AttitudeRank",1);
        attvalue161.put("Emotion","2");

        attvalue162.put("AttitudeID",162);
        attvalue162.put("AttitudeWord","นับถือ");
        attvalue162.put("AttitudeRank",1);
        attvalue162.put("Emotion","2");

        attvalue163.put("AttitudeID",163);
        attvalue163.put("AttitudeWord","น่าทึ่ง");
        attvalue163.put("AttitudeRank",1);
        attvalue163.put("Emotion","27");

        attvalue164.put("AttitudeID",164);
        attvalue164.put("AttitudeWord","น่ารัก");
        attvalue164.put("AttitudeRank",1);
        attvalue164.put("Emotion","7");

        attvalue165.put("AttitudeID",165);
        attvalue165.put("AttitudeWord","น่าสน");
        attvalue165.put("AttitudeRank",1);
        attvalue165.put("Emotion","8");

        attvalue166.put("AttitudeID",166);
        attvalue166.put("AttitudeWord","นำขาด");
        attvalue166.put("AttitudeRank",1);
        attvalue166.put("Emotion","8");

        attvalue167.put("AttitudeID",167);
        attvalue167.put("AttitudeWord","น้ำใจ");
        attvalue167.put("AttitudeRank",1);
        attvalue167.put("Emotion","27");

        attvalue168.put("AttitudeID",168);
        attvalue168.put("AttitudeWord","นิยม");
        attvalue168.put("AttitudeRank",1);
        attvalue168.put("Emotion","8");

        attvalue169.put("AttitudeID",169);
        attvalue169.put("AttitudeWord","นุ่ม");
        attvalue169.put("AttitudeRank",1);
        attvalue169.put("Emotion","8");

        attvalue170.put("AttitudeID",170);
        attvalue170.put("AttitudeWord","นุ่มนวล");
        attvalue170.put("AttitudeRank",1);
        attvalue170.put("Emotion","8");

        attvalue171.put("AttitudeID",171);
        attvalue171.put("AttitudeWord","เนียน");
        attvalue171.put("AttitudeRank",1);
        attvalue171.put("Emotion","8");

        attvalue172.put("AttitudeID",172);
        attvalue172.put("AttitudeWord","บริสุทธิ์");
        attvalue172.put("AttitudeRank",1);
        attvalue172.put("Emotion","27");

        attvalue173.put("AttitudeID",173);
        attvalue173.put("AttitudeWord","บอกรัก");
        attvalue173.put("AttitudeRank",1);
        attvalue173.put("Emotion","8");

        attvalue174.put("AttitudeID",174);
        attvalue174.put("AttitudeWord","บึกบึน");
        attvalue174.put("AttitudeRank",1);
        attvalue174.put("Emotion","27");

        attvalue175.put("AttitudeID",175);
        attvalue175.put("AttitudeWord","บุญตา");
        attvalue175.put("AttitudeRank",1);
        attvalue175.put("Emotion","8");

        attvalue176.put("AttitudeID",176);
        attvalue176.put("AttitudeWord","ปรบมือ");
        attvalue176.put("AttitudeRank",1);
        attvalue176.put("Emotion","8");

        attvalue177.put("AttitudeID",177);
        attvalue177.put("AttitudeWord","ประณีต");
        attvalue177.put("AttitudeRank",1);
        attvalue177.put("Emotion","7");

        attvalue178.put("AttitudeID",178);
        attvalue178.put("AttitudeWord","ประทับใจ");
        attvalue178.put("AttitudeRank",1);
        attvalue178.put("Emotion","7");

        attvalue179.put("AttitudeID",179);
        attvalue179.put("AttitudeWord","ประโยชน์");
        attvalue179.put("AttitudeRank",1);
        attvalue179.put("Emotion","8");

        attvalue180.put("AttitudeID",180);
        attvalue180.put("AttitudeWord","ประเสริฐ");
        attvalue180.put("AttitudeRank",1);
        attvalue180.put("Emotion","7");

        attvalue181.put("AttitudeID",181);
        attvalue181.put("AttitudeWord","ปราณี");
        attvalue181.put("AttitudeRank",1);
        attvalue181.put("Emotion","8");

        attvalue182.put("AttitudeID",182);
        attvalue182.put("AttitudeWord","ปลอดโปร่ง");
        attvalue182.put("AttitudeRank",1);
        attvalue182.put("Emotion","8");

        attvalue183.put("AttitudeID",183);
        attvalue183.put("AttitudeWord","ปลื้ม");
        attvalue183.put("AttitudeRank",1);
        attvalue183.put("Emotion","7");

        attvalue184.put("AttitudeID",184);
        attvalue184.put("AttitudeWord","ปลื้มใจ");
        attvalue184.put("AttitudeRank",1);
        attvalue184.put("Emotion","7");

        attvalue185.put("AttitudeID",185);
        attvalue185.put("AttitudeWord","ปากหวาน");
        attvalue185.put("AttitudeRank",1);
        attvalue185.put("Emotion","8");

        attvalue186.put("AttitudeID",186);
        attvalue186.put("AttitudeWord","เป็นปึกแผ่น");
        attvalue186.put("AttitudeRank",1);
        attvalue186.put("Emotion","2");

        attvalue187.put("AttitudeID",187);
        attvalue187.put("AttitudeWord","เป็นเลิศ");
        attvalue187.put("AttitudeRank",1);
        attvalue187.put("Emotion","27");

        attvalue188.put("AttitudeID",188);
        attvalue188.put("AttitudeWord","โปรดปราน");
        attvalue188.put("AttitudeRank",1);
        attvalue188.put("Emotion","27");

        attvalue189.put("AttitudeID",189);
        attvalue189.put("AttitudeWord","ผ่อง");
        attvalue189.put("AttitudeRank",1);
        attvalue189.put("Emotion","8");

        attvalue190.put("AttitudeID",190);
        attvalue190.put("AttitudeWord","ผ่องใส");
        attvalue190.put("AttitudeRank",1);
        attvalue190.put("Emotion","8");

        attvalue191.put("AttitudeID",191);
        attvalue191.put("AttitudeWord","ผ่อนคลาย");
        attvalue191.put("AttitudeRank",1);
        attvalue191.put("Emotion","8");

        attvalue192.put("AttitudeID",192);
        attvalue192.put("AttitudeWord","ผาสุข");
        attvalue192.put("AttitudeRank",1);
        attvalue192.put("Emotion","7");

        attvalue193.put("AttitudeID",193);
        attvalue193.put("AttitudeWord","ผูกพัน");
        attvalue193.put("AttitudeRank",1);
        attvalue193.put("Emotion","8");

        attvalue194.put("AttitudeID",194);
        attvalue194.put("AttitudeWord","ฝันดี");
        attvalue194.put("AttitudeRank",1);
        attvalue194.put("Emotion","7");

        attvalue195.put("AttitudeID",195);
        attvalue195.put("AttitudeWord","ฝีมือดี");
        attvalue195.put("AttitudeRank",1);
        attvalue195.put("Emotion","2");

        attvalue196.put("AttitudeID",196);
        attvalue196.put("AttitudeWord","ใฝ่ฝัน");
        attvalue196.put("AttitudeRank",1);
        attvalue196.put("Emotion","8");

        attvalue198.put("AttitudeID",197);
        attvalue198.put("AttitudeWord","พริ้ง");
        attvalue198.put("AttitudeRank",1);
        attvalue198.put("Emotion","8");

        attvalue199.put("AttitudeID",199);
        attvalue199.put("AttitudeWord","พอใจ");
        attvalue199.put("AttitudeRank",1);
        attvalue199.put("Emotion","7");

        attvalue200.put("AttitudeID",200);
        attvalue200.put("AttitudeWord","พุงกาง");
        attvalue200.put("AttitudeRank",1);
        attvalue200.put("Emotion","8");

        attvalue201.put("AttitudeID",201);
        attvalue201.put("AttitudeWord","ฟรี");
        attvalue201.put("AttitudeRank",1);
        attvalue201.put("Emotion","8");

        attvalue202.put("AttitudeID",202);
        attvalue202.put("AttitudeWord","ฟลุค");
        attvalue202.put("AttitudeRank",1);
        attvalue202.put("Emotion","8");

        attvalue203.put("AttitudeID",203);
        attvalue203.put("AttitudeWord","ฟลุ๊ค");
        attvalue203.put("AttitudeRank",1);
        attvalue203.put("Emotion","8");

        attvalue204.put("AttitudeID",204);
        attvalue204.put("AttitudeWord","ฟูมฟัก");
        attvalue204.put("AttitudeRank",1);
        attvalue204.put("Emotion","8");

        attvalue205.put("AttitudeID",205);
        attvalue205.put("AttitudeWord","แฟร์");
        attvalue205.put("AttitudeRank",1);
        attvalue205.put("Emotion","8");

        attvalue206.put("AttitudeID",206);
        attvalue206.put("AttitudeWord","ไฟแรง");
        attvalue206.put("AttitudeRank",1);
        attvalue206.put("Emotion","8");

        attvalue207.put("AttitudeID",207);
        attvalue207.put("AttitudeWord","ภูมิใจ");
        attvalue207.put("AttitudeRank",1);
        attvalue207.put("Emotion","27");

        attvalue208.put("AttitudeID",208);
        attvalue208.put("AttitudeWord","มหัศจรรย์");
        attvalue208.put("AttitudeRank",1);
        attvalue208.put("Emotion","27");

        attvalue209.put("AttitudeID",209);
        attvalue209.put("AttitudeWord","มั่งคั่ง");
        attvalue209.put("AttitudeRank",1);
        attvalue209.put("Emotion","27");

        attvalue210.put("AttitudeID",210);
        attvalue210.put("AttitudeWord","มั่นคง");
        attvalue210.put("AttitudeRank",1);
        attvalue210.put("Emotion","2");

        attvalue211.put("AttitudeID",211);
        attvalue211.put("AttitudeWord","มั่นใจ");
        attvalue211.put("AttitudeRank",1);
        attvalue211.put("Emotion","2");

        attvalue212.put("AttitudeID",212);
        attvalue212.put("AttitudeWord","มันส์");
        attvalue212.put("AttitudeRank",1);
        attvalue212.put("Emotion","7");

        attvalue213.put("AttitudeID",213);
        attvalue213.put("AttitudeWord","มีใจ");
        attvalue213.put("AttitudeRank",1);
        attvalue213.put("Emotion","2");

        attvalue214.put("AttitudeID",214);
        attvalue214.put("AttitudeWord","เมตตา");
        attvalue214.put("AttitudeRank",1);
        attvalue214.put("Emotion","8");

        attvalue215.put("AttitudeID",215);
        attvalue215.put("AttitudeWord","แม่น");
        attvalue215.put("AttitudeRank",1);
        attvalue215.put("Emotion","2");

        attvalue216.put("AttitudeID",216);
        attvalue216.put("AttitudeWord","แม่นยำ");
        attvalue216.put("AttitudeRank",1);
        attvalue216.put("Emotion","2");

        attvalue217.put("AttitudeID",217);
        attvalue217.put("AttitudeWord","ไมตรี");
        attvalue217.put("AttitudeRank",1);
        attvalue217.put("Emotion","8");

        attvalue218.put("AttitudeID",218);
        attvalue218.put("AttitudeWord","ยกโทษ");
        attvalue218.put("AttitudeRank",1);
        attvalue218.put("Emotion","8");

        attvalue219.put("AttitudeID",219);
        attvalue219.put("AttitudeWord","ยกย่อง");
        attvalue219.put("AttitudeRank",1);
        attvalue219.put("Emotion","2");

        attvalue220.put("AttitudeID",220);
        attvalue220.put("AttitudeWord","ยอดเยี่ยม");
        attvalue220.put("AttitudeRank",1);
        attvalue220.put("Emotion","7");

        attvalue221.put("AttitudeID",221);
        attvalue221.put("AttitudeWord","ยะฮู้");
        attvalue221.put("AttitudeRank",1);
        attvalue221.put("Emotion","7");

        attvalue222.put("AttitudeID",222);
        attvalue222.put("AttitudeWord","ยั่วใจ");
        attvalue222.put("AttitudeRank",1);
        attvalue222.put("Emotion","8");

        attvalue223.put("AttitudeID",223);
        attvalue223.put("AttitudeWord","ยิ่งใหญ่");
        attvalue223.put("AttitudeRank",1);
        attvalue223.put("Emotion","8");

        attvalue224.put("AttitudeID",224);
        attvalue224.put("AttitudeWord","ยินดี");
        attvalue224.put("AttitudeRank",1);
        attvalue224.put("Emotion","27");

        attvalue225.put("AttitudeID",225);
        attvalue225.put("AttitudeWord","ยิ่ม");
        attvalue225.put("AttitudeRank",1);
        attvalue225.put("Emotion","8");

        attvalue226.put("AttitudeID",226);
        attvalue226.put("AttitudeWord","ยืนยง");
        attvalue226.put("AttitudeRank",1);
        attvalue226.put("Emotion","8");

        attvalue227.put("AttitudeID",227);
        attvalue227.put("AttitudeWord","เย็น");
        attvalue227.put("AttitudeRank",1);
        attvalue227.put("Emotion","8");

        attvalue228.put("AttitudeID",228);
        attvalue228.put("AttitudeWord","เยี่ยม");
        attvalue228.put("AttitudeRank",1);
        attvalue228.put("Emotion","7");

        attvalue229.put("AttitudeID",229);
        attvalue229.put("AttitudeWord","แยบยล");
        attvalue229.put("AttitudeRank",1);
        attvalue229.put("Emotion","8");

        attvalue230.put("AttitudeID",230);
        attvalue230.put("AttitudeWord","รวดเร็ว");
        attvalue230.put("AttitudeRank",1);
        attvalue230.put("Emotion","8");

        attvalue231.put("AttitudeID",231);
        attvalue231.put("AttitudeWord","รวมใจ");
        attvalue231.put("AttitudeRank",1);
        attvalue231.put("Emotion","8");

        attvalue232.put("AttitudeID",232);
        attvalue232.put("AttitudeWord","รวย");
        attvalue232.put("AttitudeRank",1);
        attvalue232.put("Emotion","8");

        attvalue233.put("AttitudeID",233);
        attvalue233.put("AttitudeWord","รสโปรด");
        attvalue233.put("AttitudeRank",1);
        attvalue233.put("Emotion","8");

        attvalue234.put("AttitudeID",234);
        attvalue234.put("AttitudeWord","รอดตัว");
        attvalue234.put("AttitudeRank",1);
        attvalue234.put("Emotion","8");

        attvalue235.put("AttitudeID",235);
        attvalue235.put("AttitudeWord","รอบคอบ");
        attvalue235.put("AttitudeRank",1);
        attvalue235.put("Emotion","8");

        attvalue236.put("AttitudeID",236);
        attvalue236.put("AttitudeWord","ระรื่น");
        attvalue236.put("AttitudeRank",1);
        attvalue236.put("Emotion","7");

        attvalue237.put("AttitudeID",277);
        attvalue237.put("AttitudeWord","ระหง");
        attvalue237.put("AttitudeRank",1);
        attvalue237.put("Emotion","8");

        attvalue238.put("AttitudeID",238);
        attvalue238.put("AttitudeWord","รัก");
        attvalue238.put("AttitudeRank",1);
        attvalue238.put("Emotion","7");

        attvalue239.put("AttitudeID",239);
        attvalue239.put("AttitudeWord","รักกัน");
        attvalue239.put("AttitudeRank",1);
        attvalue239.put("Emotion","7");

        attvalue240.put("AttitudeID",240);
        attvalue240.put("AttitudeWord","รักดี");
        attvalue240.put("AttitudeRank",1);
        attvalue240.put("Emotion","27");

        attvalue241.put("AttitudeID",241);
        attvalue241.put("AttitudeWord","รัญจวน");
        attvalue241.put("AttitudeRank",1);
        attvalue241.put("Emotion","8");

        attvalue242.put("AttitudeID",242);
        attvalue242.put("AttitudeWord","ร่าเริง");
        attvalue242.put("AttitudeRank",1);
        attvalue242.put("Emotion","7");

        attvalue243.put("AttitudeID",243);
        attvalue243.put("AttitudeWord","ร่ำรวย");
        attvalue243.put("AttitudeRank",1);
        attvalue243.put("Emotion","7");

        attvalue244.put("AttitudeID",244);
        attvalue244.put("AttitudeWord","รุ่งเรือง");
        attvalue244.put("AttitudeRank",1);
        attvalue244.put("Emotion","7");

        attvalue245.put("AttitudeID",245);
        attvalue245.put("AttitudeWord","รุ่งโรจน์");
        attvalue245.put("AttitudeRank",1);
        attvalue245.put("Emotion","7");

        attvalue246.put("AttitudeID",246);
        attvalue246.put("AttitudeWord","รู้ใจ");
        attvalue246.put("AttitudeRank",1);
        attvalue246.put("Emotion","27");

        attvalue247.put("AttitudeID",247);
        attvalue247.put("AttitudeWord","รูปงาม");
        attvalue247.put("AttitudeRank",1);
        attvalue247.put("Emotion","7");

        attvalue248.put("AttitudeID",248);
        attvalue248.put("AttitudeWord","รูปหล่อ");
        attvalue248.put("AttitudeRank",1);
        attvalue248.put("Emotion","7");

        attvalue249.put("AttitudeID",249);
        attvalue249.put("AttitudeWord","เริ่ด");
        attvalue249.put("AttitudeRank",1);
        attvalue249.put("Emotion","7");

        attvalue250.put("AttitudeID",250);
        attvalue250.put("AttitudeWord","เรียบร้อย");
        attvalue250.put("AttitudeRank",1);
        attvalue250.put("Emotion","8");

        attvalue251.put("AttitudeID",251);
        attvalue251.put("AttitudeWord","ลงตัว");
        attvalue251.put("AttitudeRank",1);
        attvalue251.put("Emotion","7");

        attvalue252.put("AttitudeID",252);
        attvalue252.put("AttitudeWord","ล่อใจ");
        attvalue252.put("AttitudeRank",1);
        attvalue252.put("Emotion","8");

        attvalue253.put("AttitudeID",253);
        attvalue253.put("AttitudeWord","ละมุน");
        attvalue253.put("AttitudeRank",1);
        attvalue253.put("Emotion","7");

        attvalue254.put("AttitudeID",254);
        attvalue254.put("AttitudeWord","ละมุนละไม");
        attvalue254.put("AttitudeRank",1);
        attvalue254.put("Emotion","7");

        attvalue255.put("AttitudeID",255);
        attvalue255.put("AttitudeWord","ละเอียด");
        attvalue255.put("AttitudeRank",1);
        attvalue255.put("Emotion","8");

        attvalue256.put("AttitudeID",256);
        attvalue256.put("AttitudeWord","ละเอียดอ่อน");
        attvalue256.put("AttitudeRank",1);
        attvalue256.put("Emotion","8");

        attvalue257.put("AttitudeID",257);
        attvalue257.put("AttitudeWord","ลาภ");
        attvalue257.put("AttitudeRank",1);
        attvalue257.put("Emotion","7");

        attvalue258.put("AttitudeID",258);
        attvalue258.put("AttitudeWord","ล้ำค่า");
        attvalue258.put("AttitudeRank",1);
        attvalue258.put("Emotion","7");

        attvalue259.put("AttitudeID",259);
        attvalue259.put("AttitudeWord","ล่ำซำ");
        attvalue259.put("AttitudeRank",1);
        attvalue259.put("Emotion","8");

        attvalue260.put("AttitudeID",260);
        attvalue260.put("AttitudeWord","ลึกล้ำ");
        attvalue260.put("AttitudeRank",1);
        attvalue260.put("Emotion","8");

        attvalue261.put("AttitudeID",261);
        attvalue261.put("AttitudeWord","เลิศ");
        attvalue261.put("AttitudeRank",1);
        attvalue261.put("Emotion","7");

        attvalue262.put("AttitudeID",262);
        attvalue262.put("AttitudeWord","โล่ง");
        attvalue262.put("AttitudeRank",1);
        attvalue262.put("Emotion","8");

        attvalue263.put("AttitudeID",263);
        attvalue263.put("AttitudeWord","โล่งใจ");
        attvalue263.put("AttitudeRank",1);
        attvalue263.put("Emotion","8");

        attvalue264.put("AttitudeID",264);
        attvalue264.put("AttitudeWord","โล่งอก");
        attvalue264.put("AttitudeRank",1);
        attvalue264.put("Emotion","8");

        attvalue265.put("AttitudeID",265);
        attvalue265.put("AttitudeWord","ว่องไว");
        attvalue265.put("AttitudeRank",1);
        attvalue265.put("Emotion","8");

        attvalue266.put("AttitudeID",266);
        attvalue266.put("AttitudeWord","วางใจ");
        attvalue266.put("AttitudeRank",1);
        attvalue266.put("Emotion","27");

        attvalue267.put("AttitudeID",267);
        attvalue267.put("AttitudeWord","ว้าว");
        attvalue267.put("AttitudeRank",1);
        attvalue267.put("Emotion","7");

        attvalue268.put("AttitudeID",268);
        attvalue268.put("AttitudeWord","วิ๊งค์");
        attvalue268.put("AttitudeRank",1);
        attvalue268.put("Emotion","8");

        attvalue269.put("AttitudeID",269);
        attvalue269.put("AttitudeWord","วิเศษ");
        attvalue269.put("AttitudeRank",1);
        attvalue269.put("Emotion","7");

        attvalue270.put("AttitudeID",270);
        attvalue270.put("AttitudeWord","ไว");
        attvalue270.put("AttitudeRank",1);
        attvalue270.put("Emotion","8");

        attvalue271.put("AttitudeID",271);
        attvalue271.put("AttitudeWord","ไว้ใจ");
        attvalue271.put("AttitudeRank",1);
        attvalue271.put("Emotion","2");

        attvalue272.put("AttitudeID",272);
        attvalue272.put("AttitudeWord","ศักดิ์สิทธิ์");
        attvalue272.put("AttitudeRank",1);
        attvalue272.put("Emotion","2");

        attvalue273.put("AttitudeID",273);
        attvalue273.put("AttitudeWord","ศิวิไลซ์");
        attvalue273.put("AttitudeRank",1);
        attvalue273.put("Emotion","8");

        attvalue274.put("AttitudeID",274);
        attvalue274.put("AttitudeWord","สงบ");
        attvalue274.put("AttitudeRank",1);
        attvalue274.put("Emotion","27");

        attvalue275.put("AttitudeID",275);
        attvalue275.put("AttitudeWord","สงบดี");
        attvalue275.put("AttitudeRank",1);
        attvalue275.put("Emotion","27");

        attvalue276.put("AttitudeID",276);
        attvalue276.put("AttitudeWord","สงบสุข");
        attvalue276.put("AttitudeRank",1);
        attvalue276.put("Emotion","27");

        attvalue277.put("AttitudeID",277);
        attvalue277.put("AttitudeWord","สง่า");
        attvalue277.put("AttitudeRank",1);
        attvalue277.put("Emotion","7");

        attvalue278.put("AttitudeID",278);
        attvalue278.put("AttitudeWord","สด");
        attvalue278.put("AttitudeRank",1);
        attvalue278.put("Emotion","8");

        attvalue279.put("AttitudeID",279);
        attvalue279.put("AttitudeWord","สดชื่น");
        attvalue279.put("AttitudeRank",1);
        attvalue279.put("Emotion","7");

        attvalue280.put("AttitudeID",280);
        attvalue280.put("AttitudeWord","สดใส");
        attvalue280.put("AttitudeRank",1);
        attvalue280.put("Emotion","7");

        attvalue281.put("AttitudeID",281);
        attvalue281.put("AttitudeWord","สดใสดี");
        attvalue281.put("AttitudeRank",1);
        attvalue281.put("Emotion","7");

        attvalue282.put("AttitudeID",282);
        attvalue282.put("AttitudeWord","สนใจ");
        attvalue282.put("AttitudeRank",1);
        attvalue282.put("Emotion","7");

        attvalue283.put("AttitudeID",283);
        attvalue283.put("AttitudeWord","สนุก");
        attvalue283.put("AttitudeRank",1);
        attvalue283.put("Emotion","7");

        attvalue284.put("AttitudeID",284);
        attvalue284.put("AttitudeWord","สนุกดี");
        attvalue284.put("AttitudeRank",1);
        attvalue284.put("Emotion","7");

        attvalue285.put("AttitudeID",285);
        attvalue285.put("AttitudeWord","สนุกสนาน");
        attvalue285.put("AttitudeRank",1);
        attvalue285.put("Emotion","7");

        attvalue286.put("AttitudeID",286);
        attvalue286.put("AttitudeWord","สบาย");
        attvalue286.put("AttitudeRank",1);
        attvalue286.put("Emotion","7");

        attvalue287.put("AttitudeID",287);
        attvalue287.put("AttitudeWord","สบายใจ");
        attvalue287.put("AttitudeRank",1);
        attvalue287.put("Emotion","7");

        attvalue288.put("AttitudeID",288);
        attvalue288.put("AttitudeWord","สบายดี");
        attvalue288.put("AttitudeRank",1);
        attvalue288.put("Emotion","7");

        attvalue289.put("AttitudeID",289);
        attvalue289.put("AttitudeWord","สบายตา");
        attvalue289.put("AttitudeRank",1);
        attvalue289.put("Emotion","7");

        attvalue290.put("AttitudeID",290);
        attvalue290.put("AttitudeWord","สมจริง");
        attvalue290.put("AttitudeRank",1);
        attvalue290.put("Emotion","8");

        attvalue291.put("AttitudeID",291);
        attvalue291.put("AttitudeWord","สมใจ");
        attvalue291.put("AttitudeRank",1);
        attvalue291.put("Emotion","7");

        attvalue292.put("AttitudeID",292);
        attvalue292.put("AttitudeWord","สมดุล");
        attvalue292.put("AttitudeRank",1);
        attvalue292.put("Emotion","8");

        attvalue293.put("AttitudeID",293);
        attvalue293.put("AttitudeWord","สมบูรณ์");
        attvalue293.put("AttitudeRank",1);
        attvalue293.put("Emotion","8");

        attvalue294.put("AttitudeID",294);
        attvalue294.put("AttitudeWord","สมราคา");
        attvalue294.put("AttitudeRank",1);
        attvalue294.put("Emotion","8");

        attvalue295.put("AttitudeID",295);
        attvalue295.put("AttitudeWord","สมหวัง");
        attvalue295.put("AttitudeRank",1);
        attvalue295.put("Emotion","7");

        attvalue296.put("AttitudeID",296);
        attvalue296.put("AttitudeWord","สลวย");
        attvalue296.put("AttitudeRank",1);
        attvalue296.put("Emotion","8");

        attvalue297.put("AttitudeID",297);
        attvalue297.put("AttitudeWord","สละสลวย");
        attvalue297.put("AttitudeRank",1);
        attvalue297.put("Emotion","8");

        attvalue298.put("AttitudeID",298);
        attvalue298.put("AttitudeWord","สวย");
        attvalue298.put("AttitudeRank",1);
        attvalue298.put("Emotion","7");

        attvalue299.put("AttitudeID",299);
        attvalue299.put("AttitudeWord","สวยคม");
        attvalue299.put("AttitudeRank",1);
        attvalue299.put("Emotion","7");

        attvalue300.put("AttitudeID",300);
        attvalue300.put("AttitudeWord","สวยงาม");
        attvalue300.put("AttitudeRank",1);
        attvalue300.put("Emotion","7");

        attvalue301.put("AttitudeID",301);
        attvalue301.put("AttitudeWord","สวรรค์");
        attvalue301.put("AttitudeRank",1);
        attvalue301.put("Emotion","7");

        attvalue302.put("AttitudeID",302);
        attvalue302.put("AttitudeWord","สว่าง");
        attvalue302.put("AttitudeRank",1);
        attvalue302.put("Emotion","8");

        attvalue303.put("AttitudeID",303);
        attvalue303.put("AttitudeWord","สว่างไสว");
        attvalue303.put("AttitudeRank",1);
        attvalue303.put("Emotion","8");

        attvalue304.put("AttitudeID",304);
        attvalue304.put("AttitudeWord","สะใจ");
        attvalue304.put("AttitudeRank",1);
        attvalue304.put("Emotion","8");

        attvalue305.put("AttitudeID",305);
        attvalue305.put("AttitudeWord","สะใจดี");
        attvalue305.put("AttitudeRank",1);
        attvalue305.put("Emotion","8");

        attvalue306.put("AttitudeID",306);
        attvalue306.put("AttitudeWord","สะดวก");
        attvalue306.put("AttitudeRank",1);
        attvalue306.put("Emotion","8");

        attvalue307.put("AttitudeID",307);
        attvalue307.put("AttitudeWord","สะดวกสบาย");
        attvalue307.put("AttitudeRank",1);
        attvalue307.put("Emotion","8");

        attvalue308.put("AttitudeID",308);
        attvalue308.put("AttitudeWord","สะอาดสะอ้าน");
        attvalue308.put("AttitudeRank",1);
        attvalue308.put("Emotion","27");

        attvalue309.put("AttitudeID",309);
        attvalue309.put("AttitudeWord","สะอาด");
        attvalue309.put("AttitudeRank",1);
        attvalue309.put("Emotion","27");

        attvalue310.put("AttitudeID",310);
        attvalue310.put("AttitudeWord","สะสวย");
        attvalue310.put("AttitudeRank",1);
        attvalue310.put("Emotion","7");

        attvalue311.put("AttitudeID",311);
        attvalue311.put("AttitudeWord","สันติ");
        attvalue311.put("AttitudeRank",1);
        attvalue311.put("Emotion","27");


        attvalue312.put("AttitudeID",312);
        attvalue312.put("AttitudeWord","สันทัด");
        attvalue312.put("AttitudeRank",1);
        attvalue312.put("Emotion","8");

        attvalue313.put("AttitudeID",313);
        attvalue313.put("AttitudeWord","สาสมใจ");
        attvalue313.put("AttitudeRank",1);
        attvalue313.put("Emotion","7");

        attvalue314.put("AttitudeID",314);
        attvalue314.put("AttitudeWord","สำราญ");
        attvalue314.put("AttitudeRank",1);
        attvalue314.put("Emotion","7");

        attvalue315.put("AttitudeID",315);
        attvalue315.put("AttitudeWord","สุโก้ย");
        attvalue315.put("AttitudeRank",1);
        attvalue315.put("Emotion","8");

        attvalue316.put("AttitudeID",316);
        attvalue316.put("AttitudeWord","สุข");
        attvalue316.put("AttitudeRank",1);
        attvalue316.put("Emotion","7");

        attvalue317.put("AttitudeID",317);
        attvalue317.put("AttitudeWord","สุขกาย");
        attvalue317.put("AttitudeRank",1);
        attvalue317.put("Emotion","7");

        attvalue318.put("AttitudeID",318);
        attvalue318.put("AttitudeWord","สุขใจ");
        attvalue318.put("AttitudeRank",1);
        attvalue318.put("Emotion","7");

        attvalue319.put("AttitudeID",319);
        attvalue319.put("AttitudeWord","สุขล้น");
        attvalue319.put("AttitudeRank",1);
        attvalue319.put("Emotion","7");

        attvalue320.put("AttitudeID",320);
        attvalue320.put("AttitudeWord","สุขสม");
        attvalue320.put("AttitudeRank",1);
        attvalue320.put("Emotion","7");

        attvalue321.put("AttitudeID",321);
        attvalue321.put("AttitudeWord","สุขี");
        attvalue321.put("AttitudeRank",1);
        attvalue321.put("Emotion","7");

        attvalue322.put("AttitudeID",322);
        attvalue322.put("AttitudeWord","สุขุม");
        attvalue322.put("AttitudeRank",1);
        attvalue322.put("Emotion","8");

        attvalue323.put("AttitudeID",323);
        attvalue323.put("AttitudeWord","สุโค่ย");
        attvalue323.put("AttitudeRank",1);
        attvalue323.put("Emotion","8");

        attvalue324.put("AttitudeID",324);
        attvalue324.put("AttitudeWord","สุจริต");
        attvalue324.put("AttitudeRank",1);
        attvalue324.put("Emotion","27");

        attvalue325.put("AttitudeID",325);
        attvalue325.put("AttitudeWord","สุภาพ");
        attvalue325.put("AttitudeRank",1);
        attvalue325.put("Emotion","8");

        attvalue326.put("AttitudeID",326);
        attvalue326.put("AttitudeWord","สูง");
        attvalue326.put("AttitudeRank",1);
        attvalue326.put("Emotion","8");

        attvalue327.put("AttitudeID",327);
        attvalue327.put("AttitudeWord","สูงส่ง");
        attvalue327.put("AttitudeRank",1);
        attvalue327.put("Emotion","8");

        attvalue328.put("AttitudeID",328);
        attvalue328.put("AttitudeWord","เสียสละ");
        attvalue328.put("AttitudeRank",1);
        attvalue328.put("Emotion","8");

        attvalue329.put("AttitudeID",329);
        attvalue329.put("AttitudeWord","แสนรู้");
        attvalue329.put("AttitudeRank",1);
        attvalue329.put("Emotion","8");

        attvalue330.put("AttitudeID",330);
        attvalue330.put("AttitudeWord","แสนสุข");
        attvalue330.put("AttitudeRank",1);
        attvalue330.put("Emotion","7");

        attvalue331.put("AttitudeID",331);
        attvalue331.put("AttitudeWord","โสภา");
        attvalue331.put("AttitudeRank",1);
        attvalue331.put("Emotion","8");

        attvalue332.put("AttitudeID",332);
        attvalue332.put("AttitudeWord","ใส");
        attvalue332.put("AttitudeRank",1);
        attvalue332.put("Emotion","8");

        attvalue333.put("AttitudeID",333);
        attvalue333.put("AttitudeWord","ใส่ใจ");
        attvalue333.put("AttitudeRank",1);
        attvalue333.put("Emotion","8");

        attvalue334.put("AttitudeID",334);
        attvalue334.put("AttitudeWord","ใสซื่อ");
        attvalue334.put("AttitudeRank",1);
        attvalue334.put("Emotion","2");

        attvalue335.put("AttitudeID",335);
        attvalue335.put("AttitudeWord","ใสปิ๊ง");
        attvalue335.put("AttitudeRank",1);
        attvalue335.put("Emotion","8");

        attvalue336.put("AttitudeID",336);
        attvalue336.put("AttitudeWord","หนักแน่น");
        attvalue336.put("AttitudeRank",1);
        attvalue336.put("Emotion","2");

        attvalue337.put("AttitudeID",337);
        attvalue337.put("AttitudeWord","หน้านุ่ม");
        attvalue337.put("AttitudeRank",1);
        attvalue337.put("Emotion","8");

        attvalue338.put("AttitudeID",338);
        attvalue338.put("AttitudeWord","หน้าใส");
        attvalue338.put("AttitudeRank",1);
        attvalue338.put("Emotion","8");

        attvalue339.put("AttitudeID",339);
        attvalue339.put("AttitudeWord","หนำใจ");
        attvalue339.put("AttitudeRank",1);
        attvalue339.put("Emotion","7");

        attvalue340.put("AttitudeID",340);
        attvalue340.put("AttitudeWord","หนุก");
        attvalue340.put("AttitudeRank",1);
        attvalue340.put("Emotion","7");

        attvalue341.put("AttitudeID",341);
        attvalue341.put("AttitudeWord","หมดจด");
        attvalue341.put("AttitudeRank",1);
        attvalue341.put("Emotion","2");

        attvalue342.put("AttitudeID",342);
        attvalue342.put("AttitudeWord","หรรษา");
        attvalue342.put("AttitudeRank",1);
        attvalue342.put("Emotion","7");

        attvalue343.put("AttitudeID",343);
        attvalue343.put("AttitudeWord","หรู");
        attvalue343.put("AttitudeRank",1);
        attvalue343.put("Emotion","7");

        attvalue344.put("AttitudeID",344);
        attvalue344.put("AttitudeWord","หรูหรา");
        attvalue344.put("AttitudeRank",1);
        attvalue344.put("Emotion","7");

        attvalue345.put("AttitudeID",345);
        attvalue345.put("AttitudeWord","หลงรัก");
        attvalue345.put("AttitudeRank",1);
        attvalue345.put("Emotion","27");

        attvalue346.put("AttitudeID",346);
        attvalue346.put("AttitudeWord","หลงใหล");
        attvalue346.put("AttitudeRank",1);
        attvalue346.put("Emotion","27");

        attvalue347.put("AttitudeID",347);
        attvalue347.put("AttitudeWord","หล่อ");
        attvalue347.put("AttitudeRank",1);
        attvalue347.put("Emotion","8");

        attvalue348.put("AttitudeID",348);
        attvalue348.put("AttitudeWord","ห่วงใย");
        attvalue348.put("AttitudeRank",1);
        attvalue348.put("Emotion","8");

        attvalue349.put("AttitudeID",349);
        attvalue349.put("AttitudeWord","หวงแหน");
        attvalue349.put("AttitudeRank",1);
        attvalue349.put("Emotion","2");

        attvalue350.put("AttitudeID",350);
        attvalue350.put("AttitudeWord","หอม");
        attvalue350.put("AttitudeRank",1);
        attvalue350.put("Emotion","8");

        attvalue351.put("AttitudeID",351);
        attvalue351.put("AttitudeWord","หอมกรุ่น");
        attvalue351.put("AttitudeRank",1);
        attvalue351.put("Emotion","8");

        attvalue352.put("AttitudeID",352);
        attvalue352.put("AttitudeWord","หอมฉุย");
        attvalue352.put("AttitudeRank",1);
        attvalue352.put("Emotion","8");

        attvalue353.put("AttitudeID",353);
        attvalue353.put("AttitudeWord","หอมหวาน");
        attvalue353.put("AttitudeRank",1);
        attvalue353.put("Emotion","8");

        attvalue354.put("AttitudeID",354);
        attvalue354.put("AttitudeWord","หัวใส");
        attvalue354.put("AttitudeRank",1);
        attvalue354.put("Emotion","8");

        attvalue355.put("AttitudeID",355);
        attvalue355.put("AttitudeWord","ห้าวหาญ");
        attvalue355.put("AttitudeRank",1);
        attvalue355.put("Emotion","2");

        attvalue356.put("AttitudeID",356);
        attvalue356.put("AttitudeWord","หูตาไว");
        attvalue356.put("AttitudeRank",1);
        attvalue356.put("Emotion","8");

        attvalue357.put("AttitudeID",357);
        attvalue357.put("AttitudeWord","แหล่ม");
        attvalue357.put("AttitudeRank",1);
        attvalue357.put("Emotion","8");

        attvalue358.put("AttitudeID",358);
        attvalue358.put("AttitudeWord","ใหม่");
        attvalue358.put("AttitudeRank",1);
        attvalue358.put("Emotion","8");

        attvalue359.put("AttitudeID",359);
        attvalue359.put("AttitudeWord","ใหลหลง");
        attvalue359.put("AttitudeRank",1);
        attvalue359.put("Emotion","27");

        attvalue360.put("AttitudeID",360);
        attvalue360.put("AttitudeWord","องอาจ");
        attvalue360.put("AttitudeRank",1);
        attvalue360.put("Emotion","8");

        attvalue361.put("AttitudeID",361);
        attvalue361.put("AttitudeWord","อิ่ม");
        attvalue361.put("AttitudeRank",1);
        attvalue361.put("Emotion","8");

        attvalue362.put("AttitudeID",362);
        attvalue362.put("AttitudeWord","อบอุ่น");
        attvalue362.put("AttitudeRank",1);
        attvalue362.put("Emotion","2");

        attvalue363.put("AttitudeID",363);
        attvalue363.put("AttitudeWord","อร่อย");
        attvalue363.put("AttitudeRank",1);
        attvalue363.put("Emotion","7");

        attvalue364.put("AttitudeID",364);
        attvalue364.put("AttitudeWord","อลังการ");
        attvalue364.put("AttitudeRank",1);
        attvalue364.put("Emotion","8");

        attvalue365.put("AttitudeID",365);
        attvalue365.put("AttitudeWord","อวยพร");
        attvalue365.put("AttitudeRank",1);
        attvalue365.put("Emotion","27");

        attvalue366.put("AttitudeID",366);
        attvalue366.put("AttitudeWord","อโหสิ");
        attvalue366.put("AttitudeRank",1);
        attvalue366.put("Emotion","8");

        attvalue367.put("AttitudeID",367);
        attvalue367.put("AttitudeWord","ออกรส");
        attvalue367.put("AttitudeRank",1);
        attvalue367.put("Emotion","8");

        attvalue368.put("AttitudeID",368);
        attvalue368.put("AttitudeWord","อ่อนน้อม");
        attvalue368.put("AttitudeRank",1);
        attvalue368.put("Emotion","8");

        attvalue369.put("AttitudeID",369);
        attvalue369.put("AttitudeWord","อาจหาญ");
        attvalue369.put("AttitudeRank",1);
        attvalue369.put("Emotion","2");

        attvalue370.put("AttitudeID",370);
        attvalue370.put("AttitudeWord","อนุโมทนาบุญ");
        attvalue370.put("AttitudeRank",1);
        attvalue370.put("Emotion","27");

        attvalue371.put("AttitudeID",371);
        attvalue371.put("AttitudeWord","อิ่มใจ");
        attvalue371.put("AttitudeRank",1);
        attvalue371.put("Emotion","7");

        attvalue372.put("AttitudeID",372);
        attvalue372.put("AttitudeWord","อิ่มอก");
        attvalue372.put("AttitudeRank",1);
        attvalue372.put("Emotion","7");

        attvalue373.put("AttitudeID",373);
        attvalue373.put("AttitudeWord","อิ่มเอิบ");
        attvalue373.put("AttitudeRank",1);
        attvalue373.put("Emotion","7");

        attvalue374.put("AttitudeID",374);
        attvalue374.put("AttitudeWord","อิสระ");
        attvalue374.put("AttitudeRank",1);
        attvalue374.put("Emotion","27");

        attvalue375.put("AttitudeID",375);
        attvalue375.put("AttitudeWord","อุดมสมบูรณ์");
        attvalue375.put("AttitudeRank",1);
        attvalue375.put("Emotion","8");

        attvalue376.put("AttitudeID",376);
        attvalue376.put("AttitudeWord","อุ่น");
        attvalue376.put("AttitudeRank",1);
        attvalue376.put("Emotion","2");

        attvalue377.put("AttitudeID",377);
        attvalue377.put("AttitudeWord","อุ่นใจ");
        attvalue377.put("AttitudeRank",1);
        attvalue377.put("Emotion","2");

        attvalue378.put("AttitudeID",378);
        attvalue378.put("AttitudeWord","ฮัก");
        attvalue378.put("AttitudeRank",1);
        attvalue378.put("Emotion","8");

        attvalue379.put("AttitudeID",379);
        attvalue379.put("AttitudeWord","ฮาดี");
        attvalue379.put("AttitudeRank",1);
        attvalue379.put("Emotion","7");

        attvalue380.put("AttitudeID",380);
        attvalue380.put("AttitudeWord","ฮิต");
        attvalue380.put("AttitudeRank",1);
        attvalue380.put("Emotion","8");

        attvalue381.put("AttitudeID",381);
        attvalue381.put("AttitudeWord","ฮีโร่");
        attvalue381.put("AttitudeRank",1);
        attvalue381.put("Emotion","8");

        attvalue382.put("AttitudeID",382);
        attvalue382.put("AttitudeWord","ฮึดสู้");
        attvalue382.put("AttitudeRank",1);
        attvalue382.put("Emotion","8");

        attvalue383.put("AttitudeID",383);
        attvalue383.put("AttitudeWord","แฮปปี้");
        attvalue383.put("AttitudeRank",1);
        attvalue383.put("Emotion","7");

        attvalue384.put("AttitudeID",384);
        attvalue384.put("AttitudeWord","กำกวม");
        attvalue384.put("AttitudeRank",0);
        attvalue384.put("Emotion","8");

        attvalue385.put("AttitudeID",385);
        attvalue385.put("AttitudeWord","ขัดเขิน");
        attvalue385.put("AttitudeRank",0);
        attvalue385.put("Emotion","8");

        attvalue386.put("AttitudeID",386);
        attvalue386.put("AttitudeWord","ขำ");
        attvalue386.put("AttitudeRank",0);
        attvalue386.put("Emotion","8");

        attvalue387.put("AttitudeID",387);
        attvalue387.put("AttitudeWord","คลุมเครือ");
        attvalue387.put("AttitudeRank",0);
        attvalue387.put("Emotion","8");

        attvalue388.put("AttitudeID",388);
        attvalue388.put("AttitudeWord","ชิน");
        attvalue388.put("AttitudeRank",0);
        attvalue388.put("Emotion","8");

        attvalue389.put("AttitudeID",389);
        attvalue389.put("AttitudeWord","ใช้ได้");
        attvalue389.put("AttitudeRank",0);
        attvalue389.put("Emotion","8");

        attvalue390.put("AttitudeID",390);
        attvalue390.put("AttitudeWord","ดั้งเดิม");
        attvalue390.put("AttitudeRank",0);
        attvalue390.put("Emotion","8");

        attvalue391.put("AttitudeID",391);
        attvalue391.put("AttitudeWord","ตำแซ่บ");
        attvalue391.put("AttitudeRank",0);
        attvalue391.put("Emotion","8");

        attvalue392.put("AttitudeID",392);
        attvalue392.put("AttitudeWord","ทั่วไป");
        attvalue392.put("AttitudeRank",0);
        attvalue392.put("Emotion","8");

        attvalue393.put("AttitudeID",393);
        attvalue393.put("AttitudeWord","ธรรมดา");
        attvalue393.put("AttitudeRank",0);
        attvalue393.put("Emotion","8");

        attvalue394.put("AttitudeID",394);
        attvalue394.put("AttitudeWord","นิ่ง");
        attvalue394.put("AttitudeRank",0);
        attvalue394.put("Emotion","8");

        attvalue395.put("AttitudeID",395);
        attvalue395.put("AttitudeWord","นิ่ม");
        attvalue395.put("AttitudeRank",0);
        attvalue395.put("Emotion","8");

        attvalue396.put("AttitudeID",396);
        attvalue396.put("AttitudeWord","บอบบาง");
        attvalue396.put("AttitudeRank",0);
        attvalue396.put("Emotion","8");

        attvalue397.put("AttitudeID",397);
        attvalue397.put("AttitudeWord","แบ๊ว");
        attvalue397.put("AttitudeRank",0);
        attvalue397.put("Emotion","8");

        attvalue398.put("AttitudeID",398);
        attvalue398.put("AttitudeWord","ปกติ");
        attvalue398.put("AttitudeRank",0);
        attvalue398.put("Emotion","8");

        attvalue399.put("AttitudeID",399);
        attvalue399.put("AttitudeWord","ปรกติ");
        attvalue399.put("AttitudeRank",0);
        attvalue399.put("Emotion","8");

        attvalue400.put("AttitudeID",400);
        attvalue400.put("AttitudeWord","ลง");
        attvalue400.put("AttitudeRank",0);
        attvalue400.put("Emotion","8");

        attvalue401.put("AttitudeID",401);
        attvalue401.put("AttitudeWord","ปลอบใจ");
        attvalue401.put("AttitudeRank",0);
        attvalue401.put("Emotion","8");

        attvalue402.put("AttitudeID",402);
        attvalue402.put("AttitudeWord","แปลก");
        attvalue402.put("AttitudeRank",0);
        attvalue402.put("Emotion","3");

        attvalue403.put("AttitudeID",403);
        attvalue403.put("AttitudeWord","แปลกใจ");
        attvalue403.put("AttitudeRank",0);
        attvalue403.put("Emotion","3");

        attvalue404.put("AttitudeID",404);
        attvalue404.put("AttitudeWord","พอกิน");
        attvalue404.put("AttitudeRank",0);
        attvalue404.put("Emotion","8");

        attvalue405.put("AttitudeID",405);
        attvalue405.put("AttitudeWord","พอใช้");
        attvalue405.put("AttitudeRank",0);
        attvalue405.put("Emotion","8");

        attvalue406.put("AttitudeID",406);
        attvalue406.put("AttitudeWord","สันโดษ");
        attvalue406.put("AttitudeRank",0);
        attvalue406.put("Emotion","8");

        attvalue407.put("AttitudeID",407);
        attvalue407.put("AttitudeWord","สูสี");
        attvalue407.put("AttitudeRank",0);
        attvalue407.put("Emotion","8");

        attvalue408.put("AttitudeID",408);
        attvalue408.put("AttitudeWord","หม่ำ");
        attvalue408.put("AttitudeRank",0);
        attvalue408.put("Emotion","8");

        attvalue409.put("AttitudeID",409);
        attvalue409.put("AttitudeWord","หยวน");
        attvalue409.put("AttitudeRank",0);
        attvalue409.put("Emotion","8");

        attvalue410.put("AttitudeID",410);
        attvalue410.put("AttitudeWord","อนุโลม");
        attvalue410.put("AttitudeRank",0);
        attvalue410.put("Emotion","8");

        attvalue411.put("AttitudeID",411);
        attvalue411.put("AttitudeWord","ฮา");
        attvalue411.put("AttitudeRank",0);
        attvalue411.put("Emotion","8");

        attvalue412.put("AttitudeID",412);
        attvalue412.put("AttitudeWord","ฮือฮา");
        attvalue412.put("AttitudeRank",0);
        attvalue412.put("Emotion","3");

        attvalue413.put("AttitudeID",413);
        attvalue413.put("AttitudeWord","กดขี่");
        attvalue413.put("AttitudeRank",-1);
        attvalue413.put("Emotion","0145");

        attvalue414.put("AttitudeID",414);
        attvalue414.put("AttitudeWord","กดดัน");
        attvalue414.put("AttitudeRank",-1);
        attvalue414.put("Emotion","8");

        attvalue415.put("AttitudeID",415);
        attvalue415.put("AttitudeWord","กรรโชค");
        attvalue415.put("AttitudeRank",-1);
        attvalue415.put("Emotion","8");

        attvalue416.put("AttitudeID",416);
        attvalue416.put("AttitudeWord","กร่อย");
        attvalue416.put("AttitudeRank",-1);
        attvalue416.put("Emotion","8");

        attvalue417.put("AttitudeID",417);
        attvalue417.put("AttitudeWord","กระจอก");
        attvalue417.put("AttitudeRank",-1);
        attvalue417.put("Emotion","0");

        attvalue418.put("AttitudeID",418);
        attvalue418.put("AttitudeWord","กระดาก");
        attvalue418.put("AttitudeRank",-1);
        attvalue418.put("Emotion","01");

        attvalue419.put("AttitudeID",419);
        attvalue419.put("AttitudeWord","กระแดะ");
        attvalue419.put("AttitudeRank",-1);
        attvalue419.put("Emotion","8");

        attvalue420.put("AttitudeID",420);
        attvalue420.put("AttitudeWord","กระปอด");
        attvalue420.put("AttitudeRank",-1);
        attvalue420.put("Emotion","8");

        attvalue421.put("AttitudeID",421);
        attvalue421.put("AttitudeWord","กระอัก");
        attvalue421.put("AttitudeRank",-1);
        attvalue421.put("Emotion","4");

        attvalue422.put("AttitudeID",422);
        attvalue422.put("AttitudeWord","กร้าน");
        attvalue422.put("AttitudeRank",-1);
        attvalue422.put("Emotion","8");

        attvalue423.put("AttitudeID",423);
        attvalue423.put("AttitudeWord","กร้าว");
        attvalue423.put("AttitudeRank",-1);
        attvalue423.put("Emotion","5");

        attvalue424.put("AttitudeID",424);
        attvalue424.put("AttitudeWord","กริ้ว");
        attvalue424.put("AttitudeRank",-1);
        attvalue424.put("Emotion","5");

        attvalue425.put("AttitudeID",425);
        attvalue425.put("AttitudeWord","กลัว");
        attvalue425.put("AttitudeRank",-1);
        attvalue425.put("Emotion","1");

        attvalue426.put("AttitudeID",426);
        attvalue426.put("AttitudeWord","กลุ้ม");
        attvalue426.put("AttitudeRank",-1);
        attvalue426.put("Emotion","01");

        attvalue427.put("AttitudeID",427);
        attvalue427.put("AttitudeWord","กลุ้มใจ");
        attvalue427.put("AttitudeRank",-1);
        attvalue427.put("Emotion","01");

        attvalue428.put("AttitudeID",428);
        attvalue428.put("AttitudeWord","กวนใจ");
        attvalue428.put("AttitudeRank",-1);
        attvalue428.put("Emotion","5");

        attvalue429.put("AttitudeID",429);
        attvalue429.put("AttitudeWord","ก่อกวน");
        attvalue429.put("AttitudeRank",-1);
        attvalue429.put("Emotion","5");

        attvalue430.put("AttitudeID",430);
        attvalue430.put("AttitudeWord","กะล่อน");
        attvalue430.put("AttitudeRank",-1);
        attvalue430.put("Emotion","8");

        attvalue431.put("AttitudeID",431);
        attvalue431.put("AttitudeWord","กังวล");
        attvalue431.put("AttitudeRank",-1);
        attvalue431.put("Emotion","1");

        attvalue432.put("AttitudeID",432);
        attvalue432.put("AttitudeWord","กัดจิก");
        attvalue432.put("AttitudeRank",-1);
        attvalue432.put("Emotion","5");

        attvalue433.put("AttitudeID",433);
        attvalue433.put("AttitudeWord","กันดาร");
        attvalue433.put("AttitudeRank",-1);
        attvalue433.put("Emotion","0");

        attvalue434.put("AttitudeID",434);
        attvalue434.put("AttitudeWord","กาก");
        attvalue434.put("AttitudeRank",-1);
        attvalue434.put("Emotion","8");

        attvalue435.put("AttitudeID",435);
        attvalue435.put("AttitudeWord","ก้าวร้าว");
        attvalue435.put("AttitudeRank",-1);
        attvalue435.put("Emotion","5");

        attvalue436.put("AttitudeID",436);
        attvalue436.put("AttitudeWord","กำมะลอ");
        attvalue436.put("AttitudeRank",-1);
        attvalue436.put("Emotion","4");

        attvalue437.put("AttitudeID",437);
        attvalue437.put("AttitudeWord","กำแหง");
        attvalue437.put("AttitudeRank",-1);
        attvalue437.put("Emotion","145");

        attvalue438.put("AttitudeID",438);
        attvalue438.put("AttitudeWord","กินแรง");
        attvalue438.put("AttitudeRank",-1);
        attvalue438.put("Emotion","8");

        attvalue439.put("AttitudeID",439);
        attvalue439.put("AttitudeWord","กีดกัน");
        attvalue439.put("AttitudeRank",-1);
        attvalue439.put("Emotion","0145");

        attvalue440.put("AttitudeID",440);
        attvalue440.put("AttitudeWord","เกรียน");
        attvalue440.put("AttitudeRank",-1);
        attvalue440.put("Emotion","8");

        attvalue441.put("AttitudeID",441);
        attvalue441.put("AttitudeWord","เกลียด");
        attvalue441.put("AttitudeRank",-1);
        attvalue441.put("Emotion","4");

        attvalue442.put("AttitudeID",442);
        attvalue442.put("AttitudeWord","เก่า");
        attvalue442.put("AttitudeRank",-1);
        attvalue442.put("Emotion","8");

        attvalue443.put("AttitudeID",443);
        attvalue443.put("AttitudeWord","เกียจ");
        attvalue443.put("AttitudeRank",-1);
        attvalue443.put("Emotion","8");

        attvalue444.put("AttitudeID",444);
        attvalue444.put("AttitudeWord","แก่แดด");
        attvalue444.put("AttitudeRank",-1);
        attvalue444.put("Emotion","8");

        attvalue445.put("AttitudeID",445);
        attvalue445.put("AttitudeWord","แกล้ง");
        attvalue445.put("AttitudeRank",-1);
        attvalue445.put("Emotion","15");

        attvalue446.put("AttitudeID",446);
        attvalue446.put("AttitudeWord","โกง");
        attvalue446.put("AttitudeRank",-1);
        attvalue446.put("Emotion","45");

        attvalue447.put("AttitudeID",447);
        attvalue447.put("AttitudeWord","โกงกิน");
        attvalue447.put("AttitudeRank",-1);
        attvalue447.put("Emotion","45");

        attvalue448.put("AttitudeID",448);
        attvalue448.put("AttitudeWord","โกรธ");
        attvalue448.put("AttitudeRank",-1);
        attvalue448.put("Emotion","5");

        attvalue449.put("AttitudeID",449);
        attvalue449.put("AttitudeWord","โกลาหล");
        attvalue449.put("AttitudeRank",-1);
        attvalue449.put("Emotion","015");

        attvalue450.put("AttitudeID",450);
        attvalue450.put("AttitudeWord","โกหก");
        attvalue450.put("AttitudeRank",-1);
        attvalue450.put("Emotion","045");

        attvalue451.put("AttitudeID",451);
        attvalue451.put("AttitudeWord","ไกล");
        attvalue451.put("AttitudeRank",-1);
        attvalue451.put("Emotion","8");

        attvalue452.put("AttitudeID",452);
        attvalue452.put("AttitudeWord","ข่ม");
        attvalue452.put("AttitudeRank",-1);
        attvalue452.put("Emotion","015");

        attvalue453.put("AttitudeID",453);
        attvalue453.put("AttitudeWord","ขม");
        attvalue453.put("AttitudeRank",-1);
        attvalue453.put("Emotion","045");

        attvalue454.put("AttitudeID",454);
        attvalue454.put("AttitudeWord","ขมขื่น");
        attvalue454.put("AttitudeRank",-1);
        attvalue454.put("Emotion","045");

        attvalue455.put("AttitudeID",455);
        attvalue455.put("AttitudeWord","ข่มขืน");
        attvalue455.put("AttitudeRank",-1);
        attvalue455.put("Emotion","0145");

        attvalue456.put("AttitudeID",456);
        attvalue456.put("AttitudeWord","ข่มขู่");
        attvalue456.put("AttitudeRank",-1);
        attvalue456.put("Emotion","1");

        attvalue457.put("AttitudeID",457);
        attvalue457.put("AttitudeWord","ขยาด");
        attvalue457.put("AttitudeRank",-1);
        attvalue457.put("Emotion","1");

        attvalue458.put("AttitudeID",458);
        attvalue458.put("AttitudeWord","ขแยง");
        attvalue458.put("AttitudeRank",-1);
        attvalue458.put("Emotion","45");

        attvalue459.put("AttitudeID",459);
        attvalue459.put("AttitudeWord","ขรุขระ");
        attvalue459.put("AttitudeRank",-1);
        attvalue459.put("Emotion","8");

        attvalue460.put("AttitudeID",460);
        attvalue460.put("AttitudeWord","ขลาด");
        attvalue460.put("AttitudeRank",-1);
        attvalue460.put("Emotion","1");

        attvalue461.put("AttitudeID",461);
        attvalue461.put("AttitudeWord","ข้องใจ");
        attvalue461.put("AttitudeRank",-1);
        attvalue461.put("Emotion","8");

        attvalue462.put("AttitudeID",462);
        attvalue462.put("AttitudeWord","ขัดใจ");
        attvalue462.put("AttitudeRank",-1);
        attvalue462.put("Emotion","4");

        attvalue463.put("AttitudeID",463);
        attvalue463.put("AttitudeWord","ขัดตา");
        attvalue463.put("AttitudeRank",-1);
        attvalue463.put("Emotion","45");

        attvalue464.put("AttitudeID",464);
        attvalue464.put("AttitudeWord","ขัดยอก");
        attvalue464.put("AttitudeRank",-1);
        attvalue464.put("Emotion","0");

        attvalue465.put("AttitudeID",465);
        attvalue465.put("AttitudeWord","ขัดแย้ง");
        attvalue465.put("AttitudeRank",-1);
        attvalue465.put("Emotion","015");

        attvalue466.put("AttitudeID",466);
        attvalue466.put("AttitudeWord","ขัดสน");
        attvalue466.put("AttitudeRank",-1);
        attvalue466.put("Emotion","045");

        attvalue467.put("AttitudeID",467);
        attvalue467.put("AttitudeWord","ขาด");
        attvalue467.put("AttitudeRank",-1);
        attvalue467.put("Emotion","01");

        attvalue468.put("AttitudeID",468);
        attvalue468.put("AttitudeWord","ขี้เกียจ");
        attvalue468.put("AttitudeRank",-1);
        attvalue468.put("Emotion","8");

        attvalue469.put("AttitudeID",469);
        attvalue469.put("AttitudeWord","ขี้ขลาด");
        attvalue469.put("AttitudeRank",-1);
        attvalue469.put("Emotion","1");

        attvalue470.put("AttitudeID",470);
        attvalue470.put("AttitudeWord","ขี้งก");
        attvalue470.put("AttitudeRank",-1);
        attvalue470.put("Emotion","8");

        attvalue471.put("AttitudeID",471);
        attvalue471.put("AttitudeWord","ขี้แง");
        attvalue471.put("AttitudeRank",-1);
        attvalue471.put("Emotion","01");

        attvalue472.put("AttitudeID",472);
        attvalue472.put("AttitudeWord","ขี้บ่น");
        attvalue472.put("AttitudeRank",-1);
        attvalue472.put("Emotion","8");

        attvalue473.put("AttitudeID",473);
        attvalue473.put("AttitudeWord","ขี้โม้");
        attvalue473.put("AttitudeRank",-1);
        attvalue473.put("Emotion","8");

        attvalue474.put("AttitudeID",474);
        attvalue474.put("AttitudeWord","ขี้เหร่");
        attvalue474.put("AttitudeRank",-1);
        attvalue474.put("Emotion","4");

        attvalue475.put("AttitudeID",475);
        attvalue475.put("AttitudeWord","ขี้อิจฉา");
        attvalue475.put("AttitudeRank",-1);
        attvalue475.put("Emotion","45");

        attvalue476.put("AttitudeID",476);
        attvalue476.put("AttitudeWord","ขึ้ง");
        attvalue476.put("AttitudeRank",-1);
        attvalue476.put("Emotion","5");

        attvalue477.put("AttitudeID",477);
        attvalue477.put("AttitudeWord","ขึ้นวอ");
        attvalue477.put("AttitudeRank",-1);
        attvalue477.put("Emotion","8");

        attvalue478.put("AttitudeID",478);
        attvalue478.put("AttitudeWord","ขืนใจ");
        attvalue478.put("AttitudeRank",-1);
        attvalue478.put("Emotion","0145");

        attvalue479.put("AttitudeID",479);
        attvalue479.put("AttitudeWord","ขุ่น");
        attvalue479.put("AttitudeRank",-1);
        attvalue479.put("Emotion","8");

        attvalue480.put("AttitudeID",480);
        attvalue480.put("AttitudeWord","ขู่");
        attvalue480.put("AttitudeRank",-1);
        attvalue480.put("Emotion","15");

        attvalue481.put("AttitudeID",481);
        attvalue481.put("AttitudeWord","ขูดรีด");
        attvalue481.put("AttitudeRank",-1);
        attvalue481.put("Emotion","8");

        attvalue482.put("AttitudeID",482);
        attvalue482.put("AttitudeWord","เข็ด");
        attvalue482.put("AttitudeRank",-1);
        attvalue482.put("Emotion","1");

        attvalue483.put("AttitudeID",483);
        attvalue483.put("AttitudeWord","แขวะ");
        attvalue483.put("AttitudeRank",-1);
        attvalue483.put("Emotion","45");

        attvalue484.put("AttitudeID",484);
        attvalue484.put("AttitudeWord","โขกสับ");
        attvalue484.put("AttitudeRank",-1);
        attvalue484.put("Emotion","45");

        attvalue485.put("AttitudeID",485);
        attvalue485.put("AttitudeWord","คบชู้");
        attvalue485.put("AttitudeRank",-1);
        attvalue485.put("Emotion","8");

        attvalue486.put("AttitudeID",486);
        attvalue486.put("AttitudeWord","ครหา");
        attvalue486.put("AttitudeRank",-1);
        attvalue486.put("Emotion","45");

        attvalue487.put("AttitudeID",487);
        attvalue487.put("AttitudeWord","ครอบงำ");
        attvalue487.put("AttitudeRank",-1);
        attvalue487.put("Emotion","15");

        attvalue488.put("AttitudeID",488);
        attvalue488.put("AttitudeWord","คล้ำ");
        attvalue488.put("AttitudeRank",-1);
        attvalue488.put("Emotion","8");

        attvalue489.put("AttitudeID",489);
        attvalue489.put("AttitudeWord","คอตก");
        attvalue489.put("AttitudeRank",-1);
        attvalue489.put("Emotion","8");

        attvalue490.put("AttitudeID",490);
        attvalue490.put("AttitudeWord","คะนอง");
        attvalue490.put("AttitudeRank",-1);
        attvalue490.put("Emotion","5");

        attvalue491.put("AttitudeID",491);
        attvalue491.put("AttitudeWord","คับแคบ");
        attvalue491.put("AttitudeRank",-1);
        attvalue491.put("Emotion","8");

        attvalue492.put("AttitudeID",492);
        attvalue492.put("AttitudeWord","คาใจ");
        attvalue492.put("AttitudeRank",-1);
        attvalue492.put("Emotion","01");

        attvalue493.put("AttitudeID",493);
        attvalue493.put("AttitudeWord","คำครหา");
        attvalue493.put("AttitudeRank",-1);
        attvalue493.put("Emotion","45");

        attvalue494.put("AttitudeID",494);
        attvalue494.put("AttitudeWord","คำติ");
        attvalue494.put("AttitudeRank",-1);
        attvalue494.put("Emotion","45");

        attvalue495.put("AttitudeID",495);
        attvalue495.put("AttitudeWord","คกคาม");
        attvalue495.put("AttitudeRank",-1);
        attvalue495.put("Emotion","1");

        attvalue496.put("AttitudeID",496);
        attvalue496.put("AttitudeWord","เครียด");
        attvalue496.put("AttitudeRank",-1);
        attvalue496.put("Emotion","5");

        attvalue497.put("AttitudeID",497);
        attvalue497.put("AttitudeWord","แค้น");
        attvalue497.put("AttitudeRank",-1);
        attvalue497.put("Emotion","5");

        attvalue498.put("AttitudeID",498);
        attvalue498.put("AttitudeWord","แค้นใจ");
        attvalue498.put("AttitudeRank",-1);
        attvalue498.put("Emotion","5");

        attvalue499.put("AttitudeID",499);
        attvalue499.put("AttitudeWord","แคลงใจ");
        attvalue499.put("AttitudeRank",-1);
        attvalue499.put("Emotion","01");

        attvalue500.put("AttitudeID",500);
        attvalue500.put("AttitudeWord","โคม่า");
        attvalue500.put("AttitudeRank",-1);
        attvalue500.put("Emotion","01");

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
        sqLiteDatabase.insert(table_nameatt,null,attvalue32);
        sqLiteDatabase.insert(table_nameatt,null,attvalue33);
        sqLiteDatabase.insert(table_nameatt,null,attvalue34);
        sqLiteDatabase.insert(table_nameatt,null,attvalue35);
        sqLiteDatabase.insert(table_nameatt,null,attvalue36);
        sqLiteDatabase.insert(table_nameatt,null,attvalue37);
        sqLiteDatabase.insert(table_nameatt,null,attvalue38);
        sqLiteDatabase.insert(table_nameatt,null,attvalue39);
        sqLiteDatabase.insert(table_nameatt,null,attvalue40);
        sqLiteDatabase.insert(table_nameatt,null,attvalue41);
        sqLiteDatabase.insert(table_nameatt,null,attvalue42);
        sqLiteDatabase.insert(table_nameatt,null,attvalue43);
        sqLiteDatabase.insert(table_nameatt,null,attvalue44);
        sqLiteDatabase.insert(table_nameatt,null,attvalue45);
        sqLiteDatabase.insert(table_nameatt,null,attvalue46);
        sqLiteDatabase.insert(table_nameatt,null,attvalue47);
        sqLiteDatabase.insert(table_nameatt,null,attvalue48);
        sqLiteDatabase.insert(table_nameatt,null,attvalue49);
        sqLiteDatabase.insert(table_nameatt,null,attvalue50);
        sqLiteDatabase.insert(table_nameatt,null,attvalue51);
        sqLiteDatabase.insert(table_nameatt,null,attvalue52);
        sqLiteDatabase.insert(table_nameatt,null,attvalue53);
        sqLiteDatabase.insert(table_nameatt,null,attvalue54);
        sqLiteDatabase.insert(table_nameatt,null,attvalue55);
        sqLiteDatabase.insert(table_nameatt,null,attvalue56);
        sqLiteDatabase.insert(table_nameatt,null,attvalue57);
        sqLiteDatabase.insert(table_nameatt,null,attvalue58);
        sqLiteDatabase.insert(table_nameatt,null,attvalue59);
        sqLiteDatabase.insert(table_nameatt,null,attvalue60);
        sqLiteDatabase.insert(table_nameatt,null,attvalue61);
        sqLiteDatabase.insert(table_nameatt,null,attvalue62);
        sqLiteDatabase.insert(table_nameatt,null,attvalue63);
        sqLiteDatabase.insert(table_nameatt,null,attvalue64);
        sqLiteDatabase.insert(table_nameatt,null,attvalue65);
        sqLiteDatabase.insert(table_nameatt,null,attvalue66);
        sqLiteDatabase.insert(table_nameatt,null,attvalue67);
        sqLiteDatabase.insert(table_nameatt,null,attvalue68);
        sqLiteDatabase.insert(table_nameatt,null,attvalue69);
        sqLiteDatabase.insert(table_nameatt,null,attvalue70);
        sqLiteDatabase.insert(table_nameatt,null,attvalue71);
        sqLiteDatabase.insert(table_nameatt,null,attvalue72);
        sqLiteDatabase.insert(table_nameatt,null,attvalue73);
        sqLiteDatabase.insert(table_nameatt,null,attvalue74);
        sqLiteDatabase.insert(table_nameatt,null,attvalue75);
        sqLiteDatabase.insert(table_nameatt,null,attvalue76);
        sqLiteDatabase.insert(table_nameatt,null,attvalue77);
        sqLiteDatabase.insert(table_nameatt,null,attvalue78);
        sqLiteDatabase.insert(table_nameatt,null,attvalue79);
        sqLiteDatabase.insert(table_nameatt,null,attvalue80);
        sqLiteDatabase.insert(table_nameatt,null,attvalue81);
        sqLiteDatabase.insert(table_nameatt,null,attvalue82);
        sqLiteDatabase.insert(table_nameatt,null,attvalue83);
        sqLiteDatabase.insert(table_nameatt,null,attvalue84);
        sqLiteDatabase.insert(table_nameatt,null,attvalue85);
        sqLiteDatabase.insert(table_nameatt,null,attvalue86);
        sqLiteDatabase.insert(table_nameatt,null,attvalue87);
        sqLiteDatabase.insert(table_nameatt,null,attvalue88);
        sqLiteDatabase.insert(table_nameatt,null,attvalue89);
        sqLiteDatabase.insert(table_nameatt,null,attvalue90);
        sqLiteDatabase.insert(table_nameatt,null,attvalue91);
        sqLiteDatabase.insert(table_nameatt,null,attvalue92);
        sqLiteDatabase.insert(table_nameatt,null,attvalue93);
        sqLiteDatabase.insert(table_nameatt,null,attvalue94);
        sqLiteDatabase.insert(table_nameatt,null,attvalue95);
        sqLiteDatabase.insert(table_nameatt,null,attvalue96);
        sqLiteDatabase.insert(table_nameatt,null,attvalue97);
        sqLiteDatabase.insert(table_nameatt,null,attvalue98);
        sqLiteDatabase.insert(table_nameatt,null,attvalue99);
        sqLiteDatabase.insert(table_nameatt,null,attvalue100);
        sqLiteDatabase.insert(table_nameatt,null,attvalue101);
        sqLiteDatabase.insert(table_nameatt,null,attvalue102);
        sqLiteDatabase.insert(table_nameatt,null,attvalue103);
        sqLiteDatabase.insert(table_nameatt,null,attvalue104);
        sqLiteDatabase.insert(table_nameatt,null,attvalue105);
        sqLiteDatabase.insert(table_nameatt,null,attvalue106);
        sqLiteDatabase.insert(table_nameatt,null,attvalue107);
        sqLiteDatabase.insert(table_nameatt,null,attvalue108);
        sqLiteDatabase.insert(table_nameatt,null,attvalue109);
        sqLiteDatabase.insert(table_nameatt,null,attvalue110);
        sqLiteDatabase.insert(table_nameatt,null,attvalue111);
        sqLiteDatabase.insert(table_nameatt,null,attvalue112);
        sqLiteDatabase.insert(table_nameatt,null,attvalue113);
        sqLiteDatabase.insert(table_nameatt,null,attvalue114);
        sqLiteDatabase.insert(table_nameatt,null,attvalue115);
        sqLiteDatabase.insert(table_nameatt,null,attvalue116);
        sqLiteDatabase.insert(table_nameatt,null,attvalue117);
        sqLiteDatabase.insert(table_nameatt,null,attvalue118);
        sqLiteDatabase.insert(table_nameatt,null,attvalue119);
        sqLiteDatabase.insert(table_nameatt,null,attvalue120);
        sqLiteDatabase.insert(table_nameatt,null,attvalue121);
        sqLiteDatabase.insert(table_nameatt,null,attvalue122);
        sqLiteDatabase.insert(table_nameatt,null,attvalue123);
        sqLiteDatabase.insert(table_nameatt,null,attvalue124);
        sqLiteDatabase.insert(table_nameatt,null,attvalue125);
        sqLiteDatabase.insert(table_nameatt,null,attvalue126);
        sqLiteDatabase.insert(table_nameatt,null,attvalue127);
        sqLiteDatabase.insert(table_nameatt,null,attvalue128);
        sqLiteDatabase.insert(table_nameatt,null,attvalue129);
        sqLiteDatabase.insert(table_nameatt,null,attvalue130);
        sqLiteDatabase.insert(table_nameatt,null,attvalue131);
        sqLiteDatabase.insert(table_nameatt,null,attvalue132);
        sqLiteDatabase.insert(table_nameatt,null,attvalue133);
        sqLiteDatabase.insert(table_nameatt,null,attvalue134);
        sqLiteDatabase.insert(table_nameatt,null,attvalue135);
        sqLiteDatabase.insert(table_nameatt,null,attvalue136);
        sqLiteDatabase.insert(table_nameatt,null,attvalue137);
        sqLiteDatabase.insert(table_nameatt,null,attvalue138);
        sqLiteDatabase.insert(table_nameatt,null,attvalue139);
        sqLiteDatabase.insert(table_nameatt,null,attvalue140);
        sqLiteDatabase.insert(table_nameatt,null,attvalue141);
        sqLiteDatabase.insert(table_nameatt,null,attvalue142);
        sqLiteDatabase.insert(table_nameatt,null,attvalue143);
        sqLiteDatabase.insert(table_nameatt,null,attvalue144);
        sqLiteDatabase.insert(table_nameatt,null,attvalue145);
        sqLiteDatabase.insert(table_nameatt,null,attvalue146);
        sqLiteDatabase.insert(table_nameatt,null,attvalue147);
        sqLiteDatabase.insert(table_nameatt,null,attvalue148);
        sqLiteDatabase.insert(table_nameatt,null,attvalue149);
        sqLiteDatabase.insert(table_nameatt,null,attvalue150);
        sqLiteDatabase.insert(table_nameatt,null,attvalue151);
        sqLiteDatabase.insert(table_nameatt,null,attvalue152);
        sqLiteDatabase.insert(table_nameatt,null,attvalue153);
        sqLiteDatabase.insert(table_nameatt,null,attvalue154);
        sqLiteDatabase.insert(table_nameatt,null,attvalue155);
        sqLiteDatabase.insert(table_nameatt,null,attvalue156);
        sqLiteDatabase.insert(table_nameatt,null,attvalue157);
        sqLiteDatabase.insert(table_nameatt,null,attvalue158);
        sqLiteDatabase.insert(table_nameatt,null,attvalue159);
        sqLiteDatabase.insert(table_nameatt,null,attvalue160);
        sqLiteDatabase.insert(table_nameatt,null,attvalue161);
        sqLiteDatabase.insert(table_nameatt,null,attvalue162);
        sqLiteDatabase.insert(table_nameatt,null,attvalue163);
        sqLiteDatabase.insert(table_nameatt,null,attvalue164);
        sqLiteDatabase.insert(table_nameatt,null,attvalue165);
        sqLiteDatabase.insert(table_nameatt,null,attvalue166);
        sqLiteDatabase.insert(table_nameatt,null,attvalue167);
        sqLiteDatabase.insert(table_nameatt,null,attvalue168);
        sqLiteDatabase.insert(table_nameatt,null,attvalue169);
        sqLiteDatabase.insert(table_nameatt,null,attvalue170);
        sqLiteDatabase.insert(table_nameatt,null,attvalue171);
        sqLiteDatabase.insert(table_nameatt,null,attvalue172);
        sqLiteDatabase.insert(table_nameatt,null,attvalue173);
        sqLiteDatabase.insert(table_nameatt,null,attvalue174);
        sqLiteDatabase.insert(table_nameatt,null,attvalue175);
        sqLiteDatabase.insert(table_nameatt,null,attvalue176);
        sqLiteDatabase.insert(table_nameatt,null,attvalue177);
        sqLiteDatabase.insert(table_nameatt,null,attvalue178);
        sqLiteDatabase.insert(table_nameatt,null,attvalue179);
        sqLiteDatabase.insert(table_nameatt,null,attvalue180);
        sqLiteDatabase.insert(table_nameatt,null,attvalue181);
        sqLiteDatabase.insert(table_nameatt,null,attvalue182);
        sqLiteDatabase.insert(table_nameatt,null,attvalue183);
        sqLiteDatabase.insert(table_nameatt,null,attvalue184);
        sqLiteDatabase.insert(table_nameatt,null,attvalue185);
        sqLiteDatabase.insert(table_nameatt,null,attvalue186);
        sqLiteDatabase.insert(table_nameatt,null,attvalue187);
        sqLiteDatabase.insert(table_nameatt,null,attvalue188);
        sqLiteDatabase.insert(table_nameatt,null,attvalue189);
        sqLiteDatabase.insert(table_nameatt,null,attvalue190);
        sqLiteDatabase.insert(table_nameatt,null,attvalue191);
        sqLiteDatabase.insert(table_nameatt,null,attvalue192);
        sqLiteDatabase.insert(table_nameatt,null,attvalue193);
        sqLiteDatabase.insert(table_nameatt,null,attvalue194);
        sqLiteDatabase.insert(table_nameatt,null,attvalue195);
        sqLiteDatabase.insert(table_nameatt,null,attvalue196);
        sqLiteDatabase.insert(table_nameatt,null,attvalue197);
        sqLiteDatabase.insert(table_nameatt,null,attvalue198);
        sqLiteDatabase.insert(table_nameatt,null,attvalue199);
        sqLiteDatabase.insert(table_nameatt,null,attvalue200);
        sqLiteDatabase.insert(table_nameatt,null,attvalue201);
        sqLiteDatabase.insert(table_nameatt,null,attvalue202);
        sqLiteDatabase.insert(table_nameatt,null,attvalue203);
        sqLiteDatabase.insert(table_nameatt,null,attvalue204);
        sqLiteDatabase.insert(table_nameatt,null,attvalue205);
        sqLiteDatabase.insert(table_nameatt,null,attvalue206);
        sqLiteDatabase.insert(table_nameatt,null,attvalue207);
        sqLiteDatabase.insert(table_nameatt,null,attvalue208);
        sqLiteDatabase.insert(table_nameatt,null,attvalue209);
        sqLiteDatabase.insert(table_nameatt,null,attvalue210);
        sqLiteDatabase.insert(table_nameatt,null,attvalue211);
        sqLiteDatabase.insert(table_nameatt,null,attvalue212);
        sqLiteDatabase.insert(table_nameatt,null,attvalue213);
        sqLiteDatabase.insert(table_nameatt,null,attvalue214);
        sqLiteDatabase.insert(table_nameatt,null,attvalue215);
        sqLiteDatabase.insert(table_nameatt,null,attvalue216);
        sqLiteDatabase.insert(table_nameatt,null,attvalue217);
        sqLiteDatabase.insert(table_nameatt,null,attvalue218);
        sqLiteDatabase.insert(table_nameatt,null,attvalue219);
        sqLiteDatabase.insert(table_nameatt,null,attvalue220);
        sqLiteDatabase.insert(table_nameatt,null,attvalue221);
        sqLiteDatabase.insert(table_nameatt,null,attvalue222);
        sqLiteDatabase.insert(table_nameatt,null,attvalue223);
        sqLiteDatabase.insert(table_nameatt,null,attvalue224);
        sqLiteDatabase.insert(table_nameatt,null,attvalue225);
        sqLiteDatabase.insert(table_nameatt,null,attvalue226);
        sqLiteDatabase.insert(table_nameatt,null,attvalue227);
        sqLiteDatabase.insert(table_nameatt,null,attvalue228);
        sqLiteDatabase.insert(table_nameatt,null,attvalue229);
        sqLiteDatabase.insert(table_nameatt,null,attvalue230);
        sqLiteDatabase.insert(table_nameatt,null,attvalue231);
        sqLiteDatabase.insert(table_nameatt,null,attvalue232);
        sqLiteDatabase.insert(table_nameatt,null,attvalue233);
        sqLiteDatabase.insert(table_nameatt,null,attvalue234);
        sqLiteDatabase.insert(table_nameatt,null,attvalue235);
        sqLiteDatabase.insert(table_nameatt,null,attvalue236);
        sqLiteDatabase.insert(table_nameatt,null,attvalue237);
        sqLiteDatabase.insert(table_nameatt,null,attvalue238);
        sqLiteDatabase.insert(table_nameatt,null,attvalue239);
        sqLiteDatabase.insert(table_nameatt,null,attvalue240);
        sqLiteDatabase.insert(table_nameatt,null,attvalue241);
        sqLiteDatabase.insert(table_nameatt,null,attvalue242);
        sqLiteDatabase.insert(table_nameatt,null,attvalue243);
        sqLiteDatabase.insert(table_nameatt,null,attvalue244);
        sqLiteDatabase.insert(table_nameatt,null,attvalue245);
        sqLiteDatabase.insert(table_nameatt,null,attvalue246);
        sqLiteDatabase.insert(table_nameatt,null,attvalue247);
        sqLiteDatabase.insert(table_nameatt,null,attvalue248);
        sqLiteDatabase.insert(table_nameatt,null,attvalue249);
        sqLiteDatabase.insert(table_nameatt,null,attvalue250);
        sqLiteDatabase.insert(table_nameatt,null,attvalue251);
        sqLiteDatabase.insert(table_nameatt,null,attvalue252);
        sqLiteDatabase.insert(table_nameatt,null,attvalue253);
        sqLiteDatabase.insert(table_nameatt,null,attvalue254);
        sqLiteDatabase.insert(table_nameatt,null,attvalue255);
        sqLiteDatabase.insert(table_nameatt,null,attvalue256);
        sqLiteDatabase.insert(table_nameatt,null,attvalue257);
        sqLiteDatabase.insert(table_nameatt,null,attvalue258);
        sqLiteDatabase.insert(table_nameatt,null,attvalue259);
        sqLiteDatabase.insert(table_nameatt,null,attvalue260);
        sqLiteDatabase.insert(table_nameatt,null,attvalue261);
        sqLiteDatabase.insert(table_nameatt,null,attvalue262);
        sqLiteDatabase.insert(table_nameatt,null,attvalue263);
        sqLiteDatabase.insert(table_nameatt,null,attvalue264);
        sqLiteDatabase.insert(table_nameatt,null,attvalue265);
        sqLiteDatabase.insert(table_nameatt,null,attvalue266);
        sqLiteDatabase.insert(table_nameatt,null,attvalue267);
        sqLiteDatabase.insert(table_nameatt,null,attvalue268);
        sqLiteDatabase.insert(table_nameatt,null,attvalue269);
        sqLiteDatabase.insert(table_nameatt,null,attvalue270);
        sqLiteDatabase.insert(table_nameatt,null,attvalue271);
        sqLiteDatabase.insert(table_nameatt,null,attvalue272);
        sqLiteDatabase.insert(table_nameatt,null,attvalue273);
        sqLiteDatabase.insert(table_nameatt,null,attvalue274);
        sqLiteDatabase.insert(table_nameatt,null,attvalue275);
        sqLiteDatabase.insert(table_nameatt,null,attvalue276);
        sqLiteDatabase.insert(table_nameatt,null,attvalue277);
        sqLiteDatabase.insert(table_nameatt,null,attvalue278);
        sqLiteDatabase.insert(table_nameatt,null,attvalue279);
        sqLiteDatabase.insert(table_nameatt,null,attvalue280);
        sqLiteDatabase.insert(table_nameatt,null,attvalue281);
        sqLiteDatabase.insert(table_nameatt,null,attvalue282);
        sqLiteDatabase.insert(table_nameatt,null,attvalue283);
        sqLiteDatabase.insert(table_nameatt,null,attvalue284);
        sqLiteDatabase.insert(table_nameatt,null,attvalue285);
        sqLiteDatabase.insert(table_nameatt,null,attvalue286);
        sqLiteDatabase.insert(table_nameatt,null,attvalue287);
        sqLiteDatabase.insert(table_nameatt,null,attvalue288);
        sqLiteDatabase.insert(table_nameatt,null,attvalue289);
        sqLiteDatabase.insert(table_nameatt,null,attvalue290);
        sqLiteDatabase.insert(table_nameatt,null,attvalue291);
        sqLiteDatabase.insert(table_nameatt,null,attvalue292);
        sqLiteDatabase.insert(table_nameatt,null,attvalue293);
        sqLiteDatabase.insert(table_nameatt,null,attvalue294);
        sqLiteDatabase.insert(table_nameatt,null,attvalue295);
        sqLiteDatabase.insert(table_nameatt,null,attvalue296);
        sqLiteDatabase.insert(table_nameatt,null,attvalue297);
        sqLiteDatabase.insert(table_nameatt,null,attvalue298);
        sqLiteDatabase.insert(table_nameatt,null,attvalue299);
        sqLiteDatabase.insert(table_nameatt,null,attvalue300);
        sqLiteDatabase.insert(table_nameatt,null,attvalue301);
        sqLiteDatabase.insert(table_nameatt,null,attvalue302);
        sqLiteDatabase.insert(table_nameatt,null,attvalue303);
        sqLiteDatabase.insert(table_nameatt,null,attvalue304);
        sqLiteDatabase.insert(table_nameatt,null,attvalue305);
        sqLiteDatabase.insert(table_nameatt,null,attvalue306);
        sqLiteDatabase.insert(table_nameatt,null,attvalue307);
        sqLiteDatabase.insert(table_nameatt,null,attvalue308);
        sqLiteDatabase.insert(table_nameatt,null,attvalue309);
        sqLiteDatabase.insert(table_nameatt,null,attvalue310);
        sqLiteDatabase.insert(table_nameatt,null,attvalue311);
        sqLiteDatabase.insert(table_nameatt,null,attvalue312);
        sqLiteDatabase.insert(table_nameatt,null,attvalue313);
        sqLiteDatabase.insert(table_nameatt,null,attvalue314);
        sqLiteDatabase.insert(table_nameatt,null,attvalue315);
        sqLiteDatabase.insert(table_nameatt,null,attvalue316);
        sqLiteDatabase.insert(table_nameatt,null,attvalue317);
        sqLiteDatabase.insert(table_nameatt,null,attvalue318);
        sqLiteDatabase.insert(table_nameatt,null,attvalue319);
        sqLiteDatabase.insert(table_nameatt,null,attvalue320);
        sqLiteDatabase.insert(table_nameatt,null,attvalue321);
        sqLiteDatabase.insert(table_nameatt,null,attvalue322);
        sqLiteDatabase.insert(table_nameatt,null,attvalue323);
        sqLiteDatabase.insert(table_nameatt,null,attvalue324);
        sqLiteDatabase.insert(table_nameatt,null,attvalue325);
        sqLiteDatabase.insert(table_nameatt,null,attvalue326);
        sqLiteDatabase.insert(table_nameatt,null,attvalue327);
        sqLiteDatabase.insert(table_nameatt,null,attvalue328);
        sqLiteDatabase.insert(table_nameatt,null,attvalue329);
        sqLiteDatabase.insert(table_nameatt,null,attvalue330);
        sqLiteDatabase.insert(table_nameatt,null,attvalue331);
        sqLiteDatabase.insert(table_nameatt,null,attvalue332);
        sqLiteDatabase.insert(table_nameatt,null,attvalue333);
        sqLiteDatabase.insert(table_nameatt,null,attvalue334);
        sqLiteDatabase.insert(table_nameatt,null,attvalue335);
        sqLiteDatabase.insert(table_nameatt,null,attvalue336);
        sqLiteDatabase.insert(table_nameatt,null,attvalue337);
        sqLiteDatabase.insert(table_nameatt,null,attvalue338);
        sqLiteDatabase.insert(table_nameatt,null,attvalue339);
        sqLiteDatabase.insert(table_nameatt,null,attvalue340);
        sqLiteDatabase.insert(table_nameatt,null,attvalue341);
        sqLiteDatabase.insert(table_nameatt,null,attvalue342);
        sqLiteDatabase.insert(table_nameatt,null,attvalue343);
        sqLiteDatabase.insert(table_nameatt,null,attvalue344);
        sqLiteDatabase.insert(table_nameatt,null,attvalue345);
        sqLiteDatabase.insert(table_nameatt,null,attvalue346);
        sqLiteDatabase.insert(table_nameatt,null,attvalue347);
        sqLiteDatabase.insert(table_nameatt,null,attvalue348);
        sqLiteDatabase.insert(table_nameatt,null,attvalue349);
        sqLiteDatabase.insert(table_nameatt,null,attvalue350);
        sqLiteDatabase.insert(table_nameatt,null,attvalue351);
        sqLiteDatabase.insert(table_nameatt,null,attvalue352);
        sqLiteDatabase.insert(table_nameatt,null,attvalue353);
        sqLiteDatabase.insert(table_nameatt,null,attvalue354);
        sqLiteDatabase.insert(table_nameatt,null,attvalue355);
        sqLiteDatabase.insert(table_nameatt,null,attvalue356);
        sqLiteDatabase.insert(table_nameatt,null,attvalue357);
        sqLiteDatabase.insert(table_nameatt,null,attvalue358);
        sqLiteDatabase.insert(table_nameatt,null,attvalue359);
        sqLiteDatabase.insert(table_nameatt,null,attvalue360);
        sqLiteDatabase.insert(table_nameatt,null,attvalue361);
        sqLiteDatabase.insert(table_nameatt,null,attvalue362);
        sqLiteDatabase.insert(table_nameatt,null,attvalue363);
        sqLiteDatabase.insert(table_nameatt,null,attvalue364);
        sqLiteDatabase.insert(table_nameatt,null,attvalue365);
        sqLiteDatabase.insert(table_nameatt,null,attvalue366);
        sqLiteDatabase.insert(table_nameatt,null,attvalue367);
        sqLiteDatabase.insert(table_nameatt,null,attvalue368);
        sqLiteDatabase.insert(table_nameatt,null,attvalue369);
        sqLiteDatabase.insert(table_nameatt,null,attvalue370);
        sqLiteDatabase.insert(table_nameatt,null,attvalue371);
        sqLiteDatabase.insert(table_nameatt,null,attvalue372);
        sqLiteDatabase.insert(table_nameatt,null,attvalue373);
        sqLiteDatabase.insert(table_nameatt,null,attvalue374);
        sqLiteDatabase.insert(table_nameatt,null,attvalue375);
        sqLiteDatabase.insert(table_nameatt,null,attvalue376);
        sqLiteDatabase.insert(table_nameatt,null,attvalue377);
        sqLiteDatabase.insert(table_nameatt,null,attvalue378);
        sqLiteDatabase.insert(table_nameatt,null,attvalue379);
        sqLiteDatabase.insert(table_nameatt,null,attvalue380);
        sqLiteDatabase.insert(table_nameatt,null,attvalue381);
        sqLiteDatabase.insert(table_nameatt,null,attvalue382);
        sqLiteDatabase.insert(table_nameatt,null,attvalue383);
        sqLiteDatabase.insert(table_nameatt,null,attvalue384);
        sqLiteDatabase.insert(table_nameatt,null,attvalue385);
        sqLiteDatabase.insert(table_nameatt,null,attvalue386);
        sqLiteDatabase.insert(table_nameatt,null,attvalue387);
        sqLiteDatabase.insert(table_nameatt,null,attvalue388);
        sqLiteDatabase.insert(table_nameatt,null,attvalue389);
        sqLiteDatabase.insert(table_nameatt,null,attvalue390);
        sqLiteDatabase.insert(table_nameatt,null,attvalue391);
        sqLiteDatabase.insert(table_nameatt,null,attvalue392);
        sqLiteDatabase.insert(table_nameatt,null,attvalue393);
        sqLiteDatabase.insert(table_nameatt,null,attvalue394);
        sqLiteDatabase.insert(table_nameatt,null,attvalue395);
        sqLiteDatabase.insert(table_nameatt,null,attvalue396);
        sqLiteDatabase.insert(table_nameatt,null,attvalue397);
        sqLiteDatabase.insert(table_nameatt,null,attvalue398);
        sqLiteDatabase.insert(table_nameatt,null,attvalue399);
        sqLiteDatabase.insert(table_nameatt,null,attvalue400);
        sqLiteDatabase.insert(table_nameatt,null,attvalue401);
        sqLiteDatabase.insert(table_nameatt,null,attvalue402);
        sqLiteDatabase.insert(table_nameatt,null,attvalue403);
        sqLiteDatabase.insert(table_nameatt,null,attvalue404);
        sqLiteDatabase.insert(table_nameatt,null,attvalue405);
        sqLiteDatabase.insert(table_nameatt,null,attvalue406);
        sqLiteDatabase.insert(table_nameatt,null,attvalue407);
        sqLiteDatabase.insert(table_nameatt,null,attvalue408);
        sqLiteDatabase.insert(table_nameatt,null,attvalue409);
        sqLiteDatabase.insert(table_nameatt,null,attvalue410);
        sqLiteDatabase.insert(table_nameatt,null,attvalue411);
        sqLiteDatabase.insert(table_nameatt,null,attvalue412);
        sqLiteDatabase.insert(table_nameatt,null,attvalue413);
        sqLiteDatabase.insert(table_nameatt,null,attvalue414);
        sqLiteDatabase.insert(table_nameatt,null,attvalue415);
        sqLiteDatabase.insert(table_nameatt,null,attvalue416);
        sqLiteDatabase.insert(table_nameatt,null,attvalue417);
        sqLiteDatabase.insert(table_nameatt,null,attvalue418);
        sqLiteDatabase.insert(table_nameatt,null,attvalue419);
        sqLiteDatabase.insert(table_nameatt,null,attvalue420);
        sqLiteDatabase.insert(table_nameatt,null,attvalue421);
        sqLiteDatabase.insert(table_nameatt,null,attvalue422);
        sqLiteDatabase.insert(table_nameatt,null,attvalue423);
        sqLiteDatabase.insert(table_nameatt,null,attvalue424);
        sqLiteDatabase.insert(table_nameatt,null,attvalue425);
        sqLiteDatabase.insert(table_nameatt,null,attvalue426);
        sqLiteDatabase.insert(table_nameatt,null,attvalue427);
        sqLiteDatabase.insert(table_nameatt,null,attvalue428);
        sqLiteDatabase.insert(table_nameatt,null,attvalue429);
        sqLiteDatabase.insert(table_nameatt,null,attvalue430);
        sqLiteDatabase.insert(table_nameatt,null,attvalue431);
        sqLiteDatabase.insert(table_nameatt,null,attvalue432);
        sqLiteDatabase.insert(table_nameatt,null,attvalue433);
        sqLiteDatabase.insert(table_nameatt,null,attvalue434);
        sqLiteDatabase.insert(table_nameatt,null,attvalue435);
        sqLiteDatabase.insert(table_nameatt,null,attvalue436);
        sqLiteDatabase.insert(table_nameatt,null,attvalue437);
        sqLiteDatabase.insert(table_nameatt,null,attvalue438);
        sqLiteDatabase.insert(table_nameatt,null,attvalue439);
        sqLiteDatabase.insert(table_nameatt,null,attvalue440);
        sqLiteDatabase.insert(table_nameatt,null,attvalue441);
        sqLiteDatabase.insert(table_nameatt,null,attvalue442);
        sqLiteDatabase.insert(table_nameatt,null,attvalue443);
        sqLiteDatabase.insert(table_nameatt,null,attvalue444);
        sqLiteDatabase.insert(table_nameatt,null,attvalue445);
        sqLiteDatabase.insert(table_nameatt,null,attvalue446);
        sqLiteDatabase.insert(table_nameatt,null,attvalue447);
        sqLiteDatabase.insert(table_nameatt,null,attvalue448);
        sqLiteDatabase.insert(table_nameatt,null,attvalue449);
        sqLiteDatabase.insert(table_nameatt,null,attvalue450);
        sqLiteDatabase.insert(table_nameatt,null,attvalue451);
        sqLiteDatabase.insert(table_nameatt,null,attvalue452);
        sqLiteDatabase.insert(table_nameatt,null,attvalue453);
        sqLiteDatabase.insert(table_nameatt,null,attvalue454);
        sqLiteDatabase.insert(table_nameatt,null,attvalue455);
        sqLiteDatabase.insert(table_nameatt,null,attvalue456);
        sqLiteDatabase.insert(table_nameatt,null,attvalue457);
        sqLiteDatabase.insert(table_nameatt,null,attvalue458);
        sqLiteDatabase.insert(table_nameatt,null,attvalue459);
        sqLiteDatabase.insert(table_nameatt,null,attvalue460);
        sqLiteDatabase.insert(table_nameatt,null,attvalue461);
        sqLiteDatabase.insert(table_nameatt,null,attvalue462);
        sqLiteDatabase.insert(table_nameatt,null,attvalue463);
        sqLiteDatabase.insert(table_nameatt,null,attvalue464);
        sqLiteDatabase.insert(table_nameatt,null,attvalue465);
        sqLiteDatabase.insert(table_nameatt,null,attvalue466);
        sqLiteDatabase.insert(table_nameatt,null,attvalue467);
        sqLiteDatabase.insert(table_nameatt,null,attvalue468);
        sqLiteDatabase.insert(table_nameatt,null,attvalue469);
        sqLiteDatabase.insert(table_nameatt,null,attvalue470);
        sqLiteDatabase.insert(table_nameatt,null,attvalue471);
        sqLiteDatabase.insert(table_nameatt,null,attvalue472);
        sqLiteDatabase.insert(table_nameatt,null,attvalue473);
        sqLiteDatabase.insert(table_nameatt,null,attvalue474);
        sqLiteDatabase.insert(table_nameatt,null,attvalue475);
        sqLiteDatabase.insert(table_nameatt,null,attvalue476);
        sqLiteDatabase.insert(table_nameatt,null,attvalue477);
        sqLiteDatabase.insert(table_nameatt,null,attvalue478);
        sqLiteDatabase.insert(table_nameatt,null,attvalue479);
        sqLiteDatabase.insert(table_nameatt,null,attvalue480);
        sqLiteDatabase.insert(table_nameatt,null,attvalue481);
        sqLiteDatabase.insert(table_nameatt,null,attvalue482);
        sqLiteDatabase.insert(table_nameatt,null,attvalue483);
        sqLiteDatabase.insert(table_nameatt,null,attvalue484);
        sqLiteDatabase.insert(table_nameatt,null,attvalue485);
        sqLiteDatabase.insert(table_nameatt,null,attvalue486);
        sqLiteDatabase.insert(table_nameatt,null,attvalue487);
        sqLiteDatabase.insert(table_nameatt,null,attvalue488);
        sqLiteDatabase.insert(table_nameatt,null,attvalue489);
        sqLiteDatabase.insert(table_nameatt,null,attvalue490);
        sqLiteDatabase.insert(table_nameatt,null,attvalue491);
        sqLiteDatabase.insert(table_nameatt,null,attvalue492);
        sqLiteDatabase.insert(table_nameatt,null,attvalue493);
        sqLiteDatabase.insert(table_nameatt,null,attvalue494);
        sqLiteDatabase.insert(table_nameatt,null,attvalue495);
        sqLiteDatabase.insert(table_nameatt,null,attvalue496);
        sqLiteDatabase.insert(table_nameatt,null,attvalue497);
        sqLiteDatabase.insert(table_nameatt,null,attvalue498);
        sqLiteDatabase.insert(table_nameatt,null,attvalue499);
        sqLiteDatabase.insert(table_nameatt,null,attvalue500);









        ContentValues emoticonvalue = new ContentValues();
        ContentValues emoticonvalue2 = new ContentValues();
        ContentValues emoticonvalue3 = new ContentValues();
        ContentValues emoticonvalue4 = new ContentValues();
        ContentValues emoticonvalue5 = new ContentValues();
        ContentValues emoticonvalue6 = new ContentValues();
        ContentValues emoticonvalue7 = new ContentValues();
        ContentValues emoticonvalue8 = new ContentValues();
        ContentValues emoticonvalue9 = new ContentValues();
        ContentValues emoticonvalue10 = new ContentValues();
        ContentValues emoticonvalue11= new ContentValues();
        ContentValues emoticonvalue12 = new ContentValues();
        ContentValues emoticonvalue13 = new ContentValues();
        ContentValues emoticonvalue14 = new ContentValues();
        ContentValues emoticonvalue15 = new ContentValues();
        ContentValues emoticonvalue16 = new ContentValues();
        ContentValues emoticonvalue17 = new ContentValues();
        ContentValues emoticonvalue18 = new ContentValues();
        ContentValues emoticonvalue19 = new ContentValues();
        ContentValues emoticonvalue20 = new ContentValues();
        ContentValues emoticonvalue21 = new ContentValues();
        ContentValues emoticonvalue22 = new ContentValues();
        ContentValues emoticonvalue23 = new ContentValues();
        ContentValues emoticonvalue24 = new ContentValues();
        ContentValues emoticonvalue25 = new ContentValues();
        ContentValues emoticonvalue26 = new ContentValues();
        ContentValues emoticonvalue27 = new ContentValues();
        ContentValues emoticonvalue28 = new ContentValues();
        ContentValues emoticonvalue29 = new ContentValues();
        ContentValues emoticonvalue30 = new ContentValues();
        ContentValues emoticonvalue31 = new ContentValues();
        ContentValues emoticonvalue32 = new ContentValues();
        ContentValues emoticonvalue33 = new ContentValues();
        ContentValues emoticonvalue34 = new ContentValues();
        ContentValues emoticonvalue35 = new ContentValues();
        ContentValues emoticonvalue36 = new ContentValues();
        ContentValues emoticonvalue37 = new ContentValues();
        ContentValues emoticonvalue38 = new ContentValues();
        ContentValues emoticonvalue39 = new ContentValues();
        ContentValues emoticonvalue40 = new ContentValues();
        ContentValues emoticonvalue41 = new ContentValues();
        ContentValues emoticonvalue42 = new ContentValues();
        ContentValues emoticonvalue43 = new ContentValues();
        ContentValues emoticonvalue44 = new ContentValues();
        ContentValues emoticonvalue45 = new ContentValues();
        ContentValues emoticonvalue46 = new ContentValues();
        ContentValues emoticonvalue47 = new ContentValues();
        ContentValues emoticonvalue48 = new ContentValues();
        ContentValues emoticonvalue49 = new ContentValues();
        ContentValues emoticonvalue50 = new ContentValues();
        ContentValues emoticonvalue51 = new ContentValues();


        String table_nameemoticon = "emoticon";



        emoticonvalue.put("EmoticonID",1);
        emoticonvalue.put("EmoticonShortcut",":-)");
        emoticonvalue.put("EmoticonRank",1);
        emoticonvalue.put("EmoticonEmoid","27");

        emoticonvalue2.put("EmoticonID",2);
        emoticonvalue2.put("EmoticonShortcut",":)");
        emoticonvalue2.put("EmoticonRank",1);
        emoticonvalue2.put("EmoticonEmoid","27");

        emoticonvalue3.put("EmoticonID",3);
        emoticonvalue3.put("EmoticonShortcut",":]");
        emoticonvalue3.put("EmoticonRank",1);
        emoticonvalue3.put("EmoticonEmoid","27");

        emoticonvalue4.put("EmoticonID",4);
        emoticonvalue4.put("EmoticonShortcut","=)");
        emoticonvalue4.put("EmoticonRank",1);
        emoticonvalue4.put("EmoticonEmoid","27");

        emoticonvalue5.put("EmoticonID",5);
        emoticonvalue5.put("EmoticonShortcut",":-(");
        emoticonvalue5.put("EmoticonRank",-1);
        emoticonvalue5.put("EmoticonEmoid","0");

        emoticonvalue6.put("EmoticonID",6);
        emoticonvalue6.put("EmoticonShortcut",":(");
        emoticonvalue6.put("EmoticonRank",-1);
        emoticonvalue6.put("EmoticonEmoid","0");

        emoticonvalue7.put("EmoticonID",7);
        emoticonvalue7.put("EmoticonShortcut",":[");
        emoticonvalue7.put("EmoticonRank",-1);
        emoticonvalue7.put("EmoticonEmoid","0");

        emoticonvalue8.put("EmoticonID",8);
        emoticonvalue8.put("EmoticonShortcut","=(");
        emoticonvalue8.put("EmoticonRank",-1);
        emoticonvalue8.put("EmoticonEmoid","0");

        emoticonvalue9.put("EmoticonID",9);
        emoticonvalue9.put("EmoticonShortcut",":-P");
        emoticonvalue9.put("EmoticonRank",1);
        emoticonvalue9.put("EmoticonEmoid","7");

        emoticonvalue10.put("EmoticonID",10);
        emoticonvalue10.put("EmoticonShortcut",":-p");
        emoticonvalue10.put("EmoticonRank",1);
        emoticonvalue10.put("EmoticonEmoid","7");

        emoticonvalue11.put("EmoticonID",11);
        emoticonvalue11.put("EmoticonShortcut",":p");
        emoticonvalue11.put("EmoticonRank",1);
        emoticonvalue11.put("EmoticonEmoid","7");

        emoticonvalue12.put("EmoticonID",12);
        emoticonvalue12.put("EmoticonShortcut","=P");
        emoticonvalue12.put("EmoticonRank",1);
        emoticonvalue12.put("EmoticonEmoid","7");

        emoticonvalue13.put("EmoticonID",13);
        emoticonvalue13.put("EmoticonShortcut",";-)");
        emoticonvalue13.put("EmoticonRank",1);
        emoticonvalue13.put("EmoticonEmoid","27");

        emoticonvalue14.put("EmoticonID",14);
        emoticonvalue14.put("EmoticonShortcut",";)");
        emoticonvalue14.put("EmoticonRank",1);
        emoticonvalue14.put("EmoticonEmoid","27");

        emoticonvalue15.put("EmoticonID",15);
        emoticonvalue15.put("EmoticonShortcut",":-D");
        emoticonvalue15.put("EmoticonRank",1);
        emoticonvalue15.put("EmoticonEmoid","27");

        emoticonvalue16.put("EmoticonID",16);
        emoticonvalue16.put("EmoticonShortcut",":D");
        emoticonvalue16.put("EmoticonRank",1);
        emoticonvalue16.put("EmoticonEmoid","27");

        emoticonvalue17.put("EmoticonID",17);
        emoticonvalue17.put("EmoticonShortcut","=D");
        emoticonvalue17.put("EmoticonRank",1);
        emoticonvalue17.put("EmoticonEmoid","27");

        emoticonvalue18.put("EmoticonID",18);
        emoticonvalue18.put("EmoticonShortcut",":-O");
        emoticonvalue18.put("EmoticonRank",0);
        emoticonvalue18.put("EmoticonEmoid","3");

        emoticonvalue19.put("EmoticonID",19);
        emoticonvalue19.put("EmoticonShortcut",":O");
        emoticonvalue19.put("EmoticonRank",0);
        emoticonvalue19.put("EmoticonEmoid","3");

        emoticonvalue20.put("EmoticonID",20);
        emoticonvalue20.put("EmoticonShortcut",":-o");
        emoticonvalue20.put("EmoticonRank",0);
        emoticonvalue20.put("EmoticonEmoid","3");

        emoticonvalue21.put("EmoticonID",21);
        emoticonvalue21.put("EmoticonShortcut",":o");
        emoticonvalue21.put("EmoticonRank",0);
        emoticonvalue21.put("EmoticonEmoid","3");

        emoticonvalue22.put("EmoticonID",22);
        emoticonvalue22.put("EmoticonShortcut",":'(");
        emoticonvalue22.put("EmoticonRank",-1);
        emoticonvalue22.put("EmoticonEmoid","0");

        emoticonvalue23.put("EmoticonID",23);
        emoticonvalue23.put("EmoticonShortcut","8-)");
        emoticonvalue23.put("EmoticonRank",1);
        emoticonvalue23.put("EmoticonEmoid","8");

        emoticonvalue24.put("EmoticonID",24);
        emoticonvalue24.put("EmoticonShortcut","B-)");
        emoticonvalue24.put("EmoticonRank",1);
        emoticonvalue24.put("EmoticonEmoid","8");

        emoticonvalue25.put("EmoticonID",25);
        emoticonvalue25.put("EmoticonShortcut","8-|");
        emoticonvalue25.put("EmoticonRank",1);
        emoticonvalue25.put("EmoticonEmoid","8");

        emoticonvalue26.put("EmoticonID",26);
        emoticonvalue26.put("EmoticonShortcut","8|");
        emoticonvalue26.put("EmoticonRank",1);
        emoticonvalue26.put("EmoticonEmoid","8");

        emoticonvalue27.put("EmoticonID",27);
        emoticonvalue27.put("EmoticonShortcut","B-|");
        emoticonvalue27.put("EmoticonRank",1);
        emoticonvalue27.put("EmoticonEmoid","8");

        emoticonvalue28.put("EmoticonID",28);
        emoticonvalue28.put("EmoticonShortcut","B|");
        emoticonvalue28.put("EmoticonRank",1);
        emoticonvalue28.put("EmoticonEmoid","8");

        emoticonvalue29.put("EmoticonID",29);
        emoticonvalue29.put("EmoticonShortcut",">:(");
        emoticonvalue29.put("EmoticonRank",-1);
        emoticonvalue29.put("EmoticonEmoid","0145");

        emoticonvalue30.put("EmoticonID",30);
        emoticonvalue30.put("EmoticonShortcut",">:-(");
        emoticonvalue30.put("EmoticonRank",-1);
        emoticonvalue30.put("EmoticonEmoid","0145");

        emoticonvalue31.put("EmoticonID",31);
        emoticonvalue31.put("EmoticonShortcut",">:O");
        emoticonvalue31.put("EmoticonRank",-1);
        emoticonvalue31.put("EmoticonEmoid","45");

        emoticonvalue32.put("EmoticonID",32);
        emoticonvalue32.put("EmoticonShortcut",">:-O");
        emoticonvalue32.put("EmoticonRank",-1);
        emoticonvalue32.put("EmoticonEmoid","45");

        emoticonvalue33.put("EmoticonID",33);
        emoticonvalue33.put("EmoticonShortcut",">:o");
        emoticonvalue33.put("EmoticonRank",-1);
        emoticonvalue33.put("EmoticonEmoid","45");

        emoticonvalue34.put("EmoticonID",34);
        emoticonvalue34.put("EmoticonShortcut",">:-o");
        emoticonvalue34.put("EmoticonRank",-1);
        emoticonvalue34.put("EmoticonEmoid","45");

        emoticonvalue35.put("EmoticonID",35);
        emoticonvalue35.put("EmoticonShortcut",":/");
        emoticonvalue35.put("EmoticonRank",0);
        emoticonvalue35.put("EmoticonEmoid","8");

        emoticonvalue36.put("EmoticonID",36);
        emoticonvalue36.put("EmoticonShortcut",":-/");
        emoticonvalue36.put("EmoticonRank",0);
        emoticonvalue36.put("EmoticonEmoid","8");

        emoticonvalue37.put("EmoticonID",37);
        emoticonvalue37.put("EmoticonShortcut",":\\");
        emoticonvalue37.put("EmoticonRank",0);
        emoticonvalue37.put("EmoticonEmoid","8");

        emoticonvalue38.put("EmoticonID",38);
        emoticonvalue38.put("EmoticonShortcut",":-\\");
        emoticonvalue38.put("EmoticonRank",0);
        emoticonvalue38.put("EmoticonEmoid","8");

        emoticonvalue39.put("EmoticonID",39);
        emoticonvalue39.put("EmoticonShortcut","o.O");
        emoticonvalue39.put("EmoticonRank",-1);
        emoticonvalue39.put("EmoticonEmoid","8");

        emoticonvalue40.put("EmoticonID",40);
        emoticonvalue40.put("EmoticonShortcut","O.o");
        emoticonvalue40.put("EmoticonRank",-1);
        emoticonvalue40.put("EmoticonEmoid","8");

        emoticonvalue41.put("EmoticonID",41);
        emoticonvalue41.put("EmoticonShortcut",":-*");
        emoticonvalue41.put("EmoticonRank",1);
        emoticonvalue41.put("EmoticonEmoid","7");

        emoticonvalue42.put("EmoticonID",42);
        emoticonvalue42.put("EmoticonShortcut",":*");
        emoticonvalue42.put("EmoticonRank",1);
        emoticonvalue42.put("EmoticonEmoid","7");

        emoticonvalue43.put("EmoticonID",43);
        emoticonvalue43.put("EmoticonShortcut","3:)");
        emoticonvalue43.put("EmoticonRank",-1);
        emoticonvalue43.put("EmoticonEmoid","0145");

        emoticonvalue44.put("EmoticonID",44);
        emoticonvalue44.put("EmoticonShortcut","3:-)");
        emoticonvalue44.put("EmoticonRank",-1);
        emoticonvalue44.put("EmoticonEmoid","0145");

        emoticonvalue45.put("EmoticonID",45);
        emoticonvalue45.put("EmoticonShortcut","O:)");
        emoticonvalue45.put("EmoticonRank",1);
        emoticonvalue45.put("EmoticonEmoid","27");

        emoticonvalue46.put("EmoticonID",46);
        emoticonvalue46.put("EmoticonShortcut","O:-)");
        emoticonvalue46.put("EmoticonRank",1);
        emoticonvalue46.put("EmoticonEmoid","27");

        emoticonvalue47.put("EmoticonID",47);
        emoticonvalue47.put("EmoticonShortcut","<3");
        emoticonvalue47.put("EmoticonRank",1);
        emoticonvalue47.put("EmoticonEmoid","7");

        emoticonvalue48.put("EmoticonID",48);
        emoticonvalue48.put("EmoticonShortcut","^_^");
        emoticonvalue48.put("EmoticonRank",1);
        emoticonvalue48.put("EmoticonEmoid","7");

        emoticonvalue49.put("EmoticonID",49);
        emoticonvalue49.put("EmoticonShortcut","-_-");
        emoticonvalue49.put("EmoticonRank",-1);
        emoticonvalue49.put("EmoticonEmoid","5");

        emoticonvalue50.put("EmoticonID",50);
        emoticonvalue50.put("EmoticonShortcut",":v");
        emoticonvalue50.put("EmoticonRank",0);
        emoticonvalue50.put("EmoticonEmoid","8");

        emoticonvalue51.put("EmoticonID",51);
        emoticonvalue51.put("EmoticonShortcut",":3");
        emoticonvalue51.put("EmoticonRank",1);
        emoticonvalue51.put("EmoticonEmoid","8");

        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue2);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue3);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue4);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue5);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue6);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue7);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue8);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue9);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue10);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue11);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue12);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue13);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue14);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue15);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue16);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue17);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue18);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue19);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue20);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue21);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue22);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue23);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue24);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue25);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue26);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue27);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue28);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue29);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue30);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue31);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue32);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue33);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue34);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue35);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue36);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue37);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue38);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue39);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue40);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue41);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue42);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue43);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue44);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue45);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue46);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue47);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue48);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue49);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue50);
        sqLiteDatabase.insert(table_nameemoticon,null,emoticonvalue51);





    }

    public ArrayList<HashMap<String,String>> getAttitudeList(){
        try{

            ArrayList<HashMap<String,String>> arr = new ArrayList<HashMap<String,String>>();
            HashMap<String,String> map;
            SQLiteDatabase db = this.getReadableDatabase();
            String sql = "SELECT * FROM " + tableName;
            Cursor cur = db.rawQuery(sql,null);
            if(cur!= null){
                if(cur.moveToFirst()){

                    do{
                        map = new HashMap<String,String>();
                        map.put("AttitudeID",cur.getString(0));
                        map.put("AttitudeWord",cur.getString(1));
                        map.put("AttitudeRank",cur.getString(2));
                        map.put("Emotion",cur.getString(3));
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

    public ArrayList<HashMap<String,String>> getEmoticon(){

        try {
            ArrayList<HashMap<String,String>> arr = new ArrayList<HashMap<String,String>>();
            HashMap<String, String> map;

            SQLiteDatabase db = this.getReadableDatabase();
            String sql = "select * from " + tableName3;
            Cursor cursor = db.rawQuery(sql, null);
            if(cursor != null){
                if(cursor.moveToFirst()){

                    do{
                        map = new HashMap<String,String>();
                        map.put("EmoticonID",cursor.getString(0));
                        map.put("EmoticonShortcut",cursor.getString(1));
                        map.put("EmoticonRank",cursor.getString(2));
                        map.put("EmoticonEmoid",cursor.getString(3));
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

    public ArrayList<HashMap<String,String>>  getEmotionList(){
        try {
            ArrayList<HashMap<String,String>> arr = new ArrayList<HashMap<String,String>>();
            HashMap<String, String> map;

            SQLiteDatabase db = this.getReadableDatabase();
            String sql = "select * from " + tableName2;
            Cursor cursor = db.rawQuery(sql, null);
            if(cursor != null){
                if(cursor.moveToFirst()){
                    do{
                        map = new HashMap<String,String>();
                        map.put("EmotionID",cursor.getString(0));
                        map.put("EmotionWord",cursor.getString(1));
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
