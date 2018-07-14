package com.example.knutt.myproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by KNUTT on 7/2/2561.
 */

public class Database3 extends SQLiteOpenHelper {
    private static final int dbVersion = 1;
    private static final String dbName = "databaseword3.sqlite";

    private static final String tableName5 = "Attitudetable3";
    private static final String col3Antitude1 = "AttitudeID";
    private static final String col3Antitude2 = "AttitudeWord";
    private static final String col3Antitude3 = "AttitudeRank";
    private static final String col3Antitude4 = "Emotion";



    public Database3(Context context) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+tableName5+"("+col3Antitude1+" INTEGER PRIMARY KEY AUTOINCREMENT," +
                col3Antitude2+" TEXT,"+col3Antitude3+" INTEGER,"+col3Antitude4+" TEXT)");

        ContentValues attvalue1001 = new ContentValues();
        ContentValues attvalue1002 = new ContentValues();
        ContentValues attvalue1003 = new ContentValues();
        ContentValues attvalue1004 = new ContentValues();
        ContentValues attvalue1005 = new ContentValues();
        ContentValues attvalue1006 = new ContentValues();
        ContentValues attvalue1007 = new ContentValues();
        ContentValues attvalue1008 = new ContentValues();
        ContentValues attvalue1009 = new ContentValues();
        ContentValues attvalue1010 = new ContentValues();
        ContentValues attvalue1011 = new ContentValues();
        ContentValues attvalue1012 = new ContentValues();
        ContentValues attvalue1013 = new ContentValues();
        ContentValues attvalue1014 = new ContentValues();
        ContentValues attvalue1015 = new ContentValues();
        ContentValues attvalue1016 = new ContentValues();
        ContentValues attvalue1017 = new ContentValues();
        ContentValues attvalue1018 = new ContentValues();
        ContentValues attvalue1019 = new ContentValues();
        ContentValues attvalue1020 = new ContentValues();
        ContentValues attvalue1021 = new ContentValues();
        ContentValues attvalue1022 = new ContentValues();
        ContentValues attvalue1023 = new ContentValues();
        ContentValues attvalue1024 = new ContentValues();
        ContentValues attvalue1025 = new ContentValues();
        ContentValues attvalue1026 = new ContentValues();
        ContentValues attvalue1027 = new ContentValues();
        ContentValues attvalue1028 = new ContentValues();
        ContentValues attvalue1029 = new ContentValues();
        ContentValues attvalue1030 = new ContentValues();
        ContentValues attvalue1031 = new ContentValues();
        ContentValues attvalue1032 = new ContentValues();
        ContentValues attvalue1033 = new ContentValues();
        ContentValues attvalue1034 = new ContentValues();
        ContentValues attvalue1035 = new ContentValues();
        ContentValues attvalue1036 = new ContentValues();
        ContentValues attvalue1037 = new ContentValues();
        ContentValues attvalue1038 = new ContentValues();
        ContentValues attvalue1039 = new ContentValues();
        ContentValues attvalue1040 = new ContentValues();
        ContentValues attvalue1041 = new ContentValues();
        ContentValues attvalue1042 = new ContentValues();
        ContentValues attvalue1043 = new ContentValues();
        ContentValues attvalue1044 = new ContentValues();
        ContentValues attvalue1045 = new ContentValues();
        ContentValues attvalue1046 = new ContentValues();
        ContentValues attvalue1047 = new ContentValues();
        ContentValues attvalue1048 = new ContentValues();
        ContentValues attvalue1049 = new ContentValues();
        ContentValues attvalue1050 = new ContentValues();
        ContentValues attvalue1051 = new ContentValues();
        ContentValues attvalue1052 = new ContentValues();
        ContentValues attvalue1053 = new ContentValues();
        ContentValues attvalue1054 = new ContentValues();
        ContentValues attvalue1055 = new ContentValues();
        ContentValues attvalue1056 = new ContentValues();
        ContentValues attvalue1057 = new ContentValues();
        ContentValues attvalue1058 = new ContentValues();
        ContentValues attvalue1059 = new ContentValues();
        ContentValues attvalue1060 = new ContentValues();
        ContentValues attvalue1061 = new ContentValues();
        ContentValues attvalue1062 = new ContentValues();
        ContentValues attvalue1063 = new ContentValues();
        ContentValues attvalue1064 = new ContentValues();
        ContentValues attvalue1065 = new ContentValues();
        ContentValues attvalue1066 = new ContentValues();
        ContentValues attvalue1067 = new ContentValues();
        ContentValues attvalue1068 = new ContentValues();
        ContentValues attvalue1069 = new ContentValues();
        ContentValues attvalue1070 = new ContentValues();
        ContentValues attvalue1071 = new ContentValues();
        ContentValues attvalue1072 = new ContentValues();
        ContentValues attvalue1073 = new ContentValues();
        ContentValues attvalue1074 = new ContentValues();
        ContentValues attvalue1075 = new ContentValues();
        ContentValues attvalue1076 = new ContentValues();
        ContentValues attvalue1077 = new ContentValues();
        ContentValues attvalue1078 = new ContentValues();
        ContentValues attvalue1079 = new ContentValues();
        ContentValues attvalue1080 = new ContentValues();
        ContentValues attvalue1081 = new ContentValues();
        ContentValues attvalue1082 = new ContentValues();
        ContentValues attvalue1083 = new ContentValues();
        ContentValues attvalue1084 = new ContentValues();
        ContentValues attvalue1085 = new ContentValues();
        ContentValues attvalue1086 = new ContentValues();
        ContentValues attvalue1087 = new ContentValues();
        ContentValues attvalue1088 = new ContentValues();
        ContentValues attvalue1089 = new ContentValues();
        ContentValues attvalue1090 = new ContentValues();
        ContentValues attvalue1091 = new ContentValues();
        ContentValues attvalue1092 = new ContentValues();
        ContentValues attvalue1093 = new ContentValues();
        ContentValues attvalue1094 = new ContentValues();
        ContentValues attvalue1095 = new ContentValues();
        ContentValues attvalue1096 = new ContentValues();
        ContentValues attvalue1097 = new ContentValues();
        ContentValues attvalue1098 = new ContentValues();
        ContentValues attvalue1099 = new ContentValues();
        ContentValues attvalue1100 = new ContentValues();
        ContentValues attvalue1101 = new ContentValues();
        ContentValues attvalue1102 = new ContentValues();
        ContentValues attvalue1103 = new ContentValues();
        ContentValues attvalue1104 = new ContentValues();
        ContentValues attvalue1105 = new ContentValues();
        ContentValues attvalue1106 = new ContentValues();
        ContentValues attvalue1107 = new ContentValues();
        ContentValues attvalue1108 = new ContentValues();
        ContentValues attvalue1109 = new ContentValues();
        ContentValues attvalue1110 = new ContentValues();
        ContentValues attvalue1111 = new ContentValues();
        ContentValues attvalue1112 = new ContentValues();
        ContentValues attvalue1113 = new ContentValues();
        ContentValues attvalue1114 = new ContentValues();
        ContentValues attvalue1115 = new ContentValues();
        ContentValues attvalue1116 = new ContentValues();
        ContentValues attvalue1117 = new ContentValues();
        ContentValues attvalue1118 = new ContentValues();
        ContentValues attvalue1119 = new ContentValues();
        ContentValues attvalue1120 = new ContentValues();
        ContentValues attvalue1121 = new ContentValues();
        ContentValues attvalue1122 = new ContentValues();
        ContentValues attvalue1123 = new ContentValues();
        ContentValues attvalue1124 = new ContentValues();
        ContentValues attvalue1125 = new ContentValues();
        ContentValues attvalue1126 = new ContentValues();
        ContentValues attvalue1127 = new ContentValues();
        ContentValues attvalue1128 = new ContentValues();
        ContentValues attvalue1129 = new ContentValues();
        ContentValues attvalue1130 = new ContentValues();
        ContentValues attvalue1131 = new ContentValues();
        ContentValues attvalue1132 = new ContentValues();
        ContentValues attvalue1133 = new ContentValues();
        ContentValues attvalue1134 = new ContentValues();
        ContentValues attvalue1135 = new ContentValues();
        ContentValues attvalue1136 = new ContentValues();
        ContentValues attvalue1137 = new ContentValues();
        ContentValues attvalue1138 = new ContentValues();
        ContentValues attvalue1139 = new ContentValues();
        ContentValues attvalue1140 = new ContentValues();
        ContentValues attvalue1141 = new ContentValues();
        ContentValues attvalue1142 = new ContentValues();
        ContentValues attvalue1143 = new ContentValues();
        ContentValues attvalue1144 = new ContentValues();
        ContentValues attvalue1145 = new ContentValues();
        ContentValues attvalue1146 = new ContentValues();
        ContentValues attvalue1147 = new ContentValues();
        ContentValues attvalue1148 = new ContentValues();
        ContentValues attvalue1149 = new ContentValues();
        ContentValues attvalue1150 = new ContentValues();
        ContentValues attvalue1151 = new ContentValues();
        ContentValues attvalue1152 = new ContentValues();
        ContentValues attvalue1153 = new ContentValues();
        ContentValues attvalue1154 = new ContentValues();
        ContentValues attvalue1155 = new ContentValues();
        ContentValues attvalue1156 = new ContentValues();
        ContentValues attvalue1157 = new ContentValues();
        ContentValues attvalue1158 = new ContentValues();
        ContentValues attvalue1159 = new ContentValues();
        ContentValues attvalue1160 = new ContentValues();
        ContentValues attvalue1161 = new ContentValues();
        ContentValues attvalue1162 = new ContentValues();
        ContentValues attvalue1163 = new ContentValues();
        ContentValues attvalue1164 = new ContentValues();
        ContentValues attvalue1165 = new ContentValues();
        ContentValues attvalue1166 = new ContentValues();
        ContentValues attvalue1167 = new ContentValues();
        ContentValues attvalue1168 = new ContentValues();
        ContentValues attvalue1169 = new ContentValues();
        ContentValues attvalue1170 = new ContentValues();
        ContentValues attvalue1171 = new ContentValues();
        ContentValues attvalue1172 = new ContentValues();
        ContentValues attvalue1173 = new ContentValues();
        ContentValues attvalue1174 = new ContentValues();
        ContentValues attvalue1175 = new ContentValues();
        ContentValues attvalue1176 = new ContentValues();
        ContentValues attvalue1177 = new ContentValues();
        ContentValues attvalue1178 = new ContentValues();
        ContentValues attvalue1179 = new ContentValues();
        ContentValues attvalue1180 = new ContentValues();
        ContentValues attvalue1181 = new ContentValues();
        ContentValues attvalue1182 = new ContentValues();
        ContentValues attvalue1183 = new ContentValues();
        ContentValues attvalue1184 = new ContentValues();
        ContentValues attvalue1185 = new ContentValues();
        ContentValues attvalue1186 = new ContentValues();
        ContentValues attvalue1187 = new ContentValues();
        ContentValues attvalue1188 = new ContentValues();
        ContentValues attvalue1189 = new ContentValues();
        ContentValues attvalue1190 = new ContentValues();
        ContentValues attvalue1191 = new ContentValues();
        ContentValues attvalue1192 = new ContentValues();
        ContentValues attvalue1193 = new ContentValues();
        ContentValues attvalue1194 = new ContentValues();
        ContentValues attvalue1195 = new ContentValues();
        ContentValues attvalue1196 = new ContentValues();
        ContentValues attvalue1197 = new ContentValues();
        ContentValues attvalue1198 = new ContentValues();
        ContentValues attvalue1199 = new ContentValues();
        ContentValues attvalue1200 = new ContentValues();
        ContentValues attvalue1201 = new ContentValues();
        ContentValues attvalue1202 = new ContentValues();
        ContentValues attvalue1203 = new ContentValues();
        ContentValues attvalue1204 = new ContentValues();
        ContentValues attvalue1205 = new ContentValues();
        ContentValues attvalue1206 = new ContentValues();
        ContentValues attvalue1207 = new ContentValues();
        ContentValues attvalue1208 = new ContentValues();
        ContentValues attvalue1209 = new ContentValues();
        ContentValues attvalue1210 = new ContentValues();
        ContentValues attvalue1211 = new ContentValues();
        ContentValues attvalue1212 = new ContentValues();
        ContentValues attvalue1213 = new ContentValues();
        ContentValues attvalue1214 = new ContentValues();
        ContentValues attvalue1215 = new ContentValues();
        ContentValues attvalue1216 = new ContentValues();
        ContentValues attvalue1217 = new ContentValues();
        ContentValues attvalue1218 = new ContentValues();
        ContentValues attvalue1219 = new ContentValues();
        ContentValues attvalue1220 = new ContentValues();
        ContentValues attvalue1221 = new ContentValues();
        ContentValues attvalue1222 = new ContentValues();
        ContentValues attvalue1223 = new ContentValues();
        ContentValues attvalue1224 = new ContentValues();
        ContentValues attvalue1225 = new ContentValues();
        ContentValues attvalue1226 = new ContentValues();
        ContentValues attvalue1227 = new ContentValues();
        ContentValues attvalue1228 = new ContentValues();
        ContentValues attvalue1229 = new ContentValues();
        ContentValues attvalue1230 = new ContentValues();
        ContentValues attvalue1231 = new ContentValues();
        ContentValues attvalue1232 = new ContentValues();
        ContentValues attvalue1233 = new ContentValues();
        ContentValues attvalue1234 = new ContentValues();
        ContentValues attvalue1235 = new ContentValues();
        ContentValues attvalue1236 = new ContentValues();
        ContentValues attvalue1237 = new ContentValues();
        ContentValues attvalue1238 = new ContentValues();
        ContentValues attvalue1239 = new ContentValues();
        ContentValues attvalue1240 = new ContentValues();
        ContentValues attvalue1241 = new ContentValues();
        ContentValues attvalue1242 = new ContentValues();
        ContentValues attvalue1243 = new ContentValues();
        ContentValues attvalue1244 = new ContentValues();
        ContentValues attvalue1245 = new ContentValues();
        ContentValues attvalue1246 = new ContentValues();
        ContentValues attvalue1247 = new ContentValues();
        ContentValues attvalue1248 = new ContentValues();
        ContentValues attvalue1249 = new ContentValues();
        ContentValues attvalue1250 = new ContentValues();
        ContentValues attvalue1251 = new ContentValues();
        ContentValues attvalue1252 = new ContentValues();
        ContentValues attvalue1253 = new ContentValues();
        ContentValues attvalue1254 = new ContentValues();
        ContentValues attvalue1255 = new ContentValues();
        ContentValues attvalue1256 = new ContentValues();
        ContentValues attvalue1257 = new ContentValues();
        ContentValues attvalue1258 = new ContentValues();
        ContentValues attvalue1259 = new ContentValues();
        ContentValues attvalue1260 = new ContentValues();
        ContentValues attvalue1261 = new ContentValues();
        ContentValues attvalue1262 = new ContentValues();
        ContentValues attvalue1263 = new ContentValues();
        ContentValues attvalue1264 = new ContentValues();
        ContentValues attvalue1265 = new ContentValues();
        ContentValues attvalue1266 = new ContentValues();
        ContentValues attvalue1267 = new ContentValues();
        ContentValues attvalue1268 = new ContentValues();
        ContentValues attvalue1269 = new ContentValues();
        ContentValues attvalue1270 = new ContentValues();
        ContentValues attvalue1271 = new ContentValues();
        ContentValues attvalue1272 = new ContentValues();
        ContentValues attvalue1273 = new ContentValues();
        ContentValues attvalue1274 = new ContentValues();
        ContentValues attvalue1275 = new ContentValues();
        ContentValues attvalue1276 = new ContentValues();
        ContentValues attvalue1277 = new ContentValues();
        ContentValues attvalue1278 = new ContentValues();
        ContentValues attvalue1279 = new ContentValues();
        ContentValues attvalue1280 = new ContentValues();
        ContentValues attvalue1281 = new ContentValues();
        ContentValues attvalue1282 = new ContentValues();
        ContentValues attvalue1283 = new ContentValues();
        ContentValues attvalue1284 = new ContentValues();
        ContentValues attvalue1285 = new ContentValues();
        ContentValues attvalue1286 = new ContentValues();
        ContentValues attvalue1287 = new ContentValues();
        ContentValues attvalue1288 = new ContentValues();
        ContentValues attvalue1289 = new ContentValues();
        ContentValues attvalue1290 = new ContentValues();
        ContentValues attvalue1291 = new ContentValues();
        ContentValues attvalue1292 = new ContentValues();
        ContentValues attvalue1293 = new ContentValues();
        ContentValues attvalue1294 = new ContentValues();
        ContentValues attvalue1295 = new ContentValues();
        ContentValues attvalue1296 = new ContentValues();
        ContentValues attvalue1297 = new ContentValues();
        ContentValues attvalue1298 = new ContentValues();
        ContentValues attvalue1299 = new ContentValues();
        ContentValues attvalue1300 = new ContentValues();
        ContentValues attvalue1301 = new ContentValues();
        ContentValues attvalue1302 = new ContentValues();



        attvalue1001.put("AttitudeID",1001);
        attvalue1001.put("AttitudeWord","อัปมงคล");
        attvalue1001.put("AttitudeRank",-1);
        attvalue1001.put("Emotion","0");

        attvalue1002.put("AttitudeID",1002);
        attvalue1002.put("AttitudeWord","อัปยศ");
        attvalue1002.put("AttitudeRank",-1);
        attvalue1002.put("Emotion","5");

        attvalue1003.put("AttitudeID",1003);
        attvalue1003.put("AttitudeWord","อัปลักษณ์");
        attvalue1003.put("AttitudeRank",-1);
        attvalue1003.put("Emotion","4");

        attvalue1004.put("AttitudeID",1004);
        attvalue1004.put("AttitudeWord","อาฆาต");
        attvalue1004.put("AttitudeRank",-1);
        attvalue1004.put("Emotion","5");

        attvalue1005.put("AttitudeID",1005);
        attvalue1005.put("AttitudeWord","อาภัพ");
        attvalue1005.put("AttitudeRank",-1);
        attvalue1005.put("Emotion","0");

        attvalue1006.put("AttitudeID",1006);
        attvalue1006.put("AttitudeWord","อาย");
        attvalue1006.put("AttitudeRank",-1);
        attvalue1006.put("Emotion","04");

        attvalue1007.put("AttitudeID",1007);
        attvalue1007.put("AttitudeWord","อาวรณ์");
        attvalue1007.put("AttitudeRank",-1);
        attvalue1007.put("Emotion","0");

        attvalue1008.put("AttitudeID",1008);
        attvalue1008.put("AttitudeWord","อำมหิต");
        attvalue1008.put("AttitudeRank",-1);
        attvalue1008.put("Emotion","15");

        attvalue1009.put("AttitudeID",1009);
        attvalue1009.put("AttitudeWord","อิจฉา");
        attvalue1009.put("AttitudeRank",-1);
        attvalue1009.put("Emotion","45");

        attvalue1010.put("AttitudeID",1010);
        attvalue1010.put("AttitudeWord","อิดโรย");
        attvalue1010.put("AttitudeRank",-1);
        attvalue1010.put("Emotion","0");

        attvalue1011.put("AttitudeID",1011);
        attvalue1011.put("AttitudeWord","อึ้ง");
        attvalue1011.put("AttitudeRank",-1);
        attvalue1011.put("Emotion","0");

        attvalue1012.put("AttitudeID",1012);
        attvalue1012.put("AttitudeWord","อึดอัด");
        attvalue1012.put("AttitudeRank",-1);
        attvalue1012.put("Emotion","8");

        attvalue1013.put("AttitudeID",1013);
        attvalue1013.put("AttitudeWord","อุจาด");
        attvalue1013.put("AttitudeRank",-1);
        attvalue1013.put("Emotion","4");

        attvalue1014.put("AttitudeID",1014);
        attvalue1014.put("AttitudeWord","อู้อี้");
        attvalue1014.put("AttitudeRank",-1);
        attvalue1014.put("Emotion","8");

        attvalue1015.put("AttitudeID",1015);
        attvalue1015.put("AttitudeWord","แอนตี้");
        attvalue1015.put("AttitudeRank",-1);
        attvalue1015.put("Emotion","15");

        attvalue1016.put("AttitudeID",1016);
        attvalue1016.put("AttitudeWord","แอบงก");
        attvalue1016.put("AttitudeRank",-1);
        attvalue1016.put("Emotion","8");

        attvalue1017.put("AttitudeID",1017);
        attvalue1017.put("AttitudeWord","แออัด");
        attvalue1017.put("AttitudeRank",-1);
        attvalue1017.put("Emotion","8");

        attvalue1018.put("AttitudeID",1018);
        attvalue1018.put("AttitudeWord","โอ้อวด");
        attvalue1018.put("AttitudeRank",-1);
        attvalue1018.put("Emotion","8");

        attvalue1019.put("AttitudeID",1019);
        attvalue1019.put("AttitudeWord","แฮงก์");
        attvalue1019.put("AttitudeRank",-1);
        attvalue1019.put("Emotion","8");

        attvalue1020.put("AttitudeID",1020);
        attvalue1020.put("AttitudeWord","ไม่");
        attvalue1020.put("AttitudeRank",-1);
        attvalue1020.put("Emotion","8");

        attvalue1021.put("AttitudeID",1021);
        attvalue1021.put("AttitudeWord","ทุเรด");
        attvalue1021.put("AttitudeRank",-1);
        attvalue1021.put("Emotion","4");

        attvalue1022.put("AttitudeID",1022);
        attvalue1022.put("AttitudeWord","ทุเรศ");
        attvalue1022.put("AttitudeRank",-1);
        attvalue1022.put("Emotion","4");

        attvalue1023.put("AttitudeID",1023);
        attvalue1023.put("AttitudeWord","กระชาก");
        attvalue1023.put("AttitudeRank",-1);
        attvalue1023.put("Emotion","8");

        attvalue1024.put("AttitudeID",1024);
        attvalue1024.put("AttitudeWord","กระดอ");
        attvalue1024.put("AttitudeRank",-1);
        attvalue1024.put("Emotion","8");

        attvalue1025.put("AttitudeID",1025);
        attvalue1025.put("AttitudeWord","กระทืบ");
        attvalue1025.put("AttitudeRank",-1);
        attvalue1025.put("Emotion","5");

        attvalue1026.put("AttitudeID",1026);
        attvalue1026.put("AttitudeWord","กระแทก");
        attvalue1026.put("AttitudeRank",-1);
        attvalue1026.put("Emotion","8");

        attvalue1027.put("AttitudeID",1027);
        attvalue1027.put("AttitudeWord","กระหรี่");
        attvalue1027.put("AttitudeRank",-1);
        attvalue1027.put("Emotion","4");

        attvalue1028.put("AttitudeID",1028);
        attvalue1028.put("AttitudeWord","กระหึ่ม");
        attvalue1028.put("AttitudeRank",-1);
        attvalue1028.put("Emotion","8");

        attvalue1029.put("AttitudeID",1029);
        attvalue1029.put("AttitudeWord","กราดเกรี้ยว");
        attvalue1029.put("AttitudeRank",-1);
        attvalue1029.put("Emotion","5");

        attvalue1030.put("AttitudeID",1030);
        attvalue1030.put("AttitudeWord","กลั่นแกล้ง");
        attvalue1030.put("AttitudeRank",-1);
        attvalue1030.put("Emotion","15");

        attvalue1031.put("AttitudeID",1031);
        attvalue1031.put("AttitudeWord","กล่าวหา");
        attvalue1031.put("AttitudeRank",-1);
        attvalue1031.put("Emotion","8");

        attvalue1032.put("AttitudeID",1032);
        attvalue1032.put("AttitudeWord","กวน");
        attvalue1032.put("AttitudeRank",-1);
        attvalue1032.put("Emotion","5");

        attvalue1033.put("AttitudeID",1033);
        attvalue1033.put("AttitudeWord","กวนตีน");
        attvalue1033.put("AttitudeRank",-1);
        attvalue1033.put("Emotion","5");

        attvalue1034.put("AttitudeID",1034);
        attvalue1034.put("AttitudeWord","กวนส้นตีน");
        attvalue1034.put("AttitudeRank",-1);
        attvalue1034.put("Emotion","5");

        attvalue1035.put("AttitudeID",1035);
        attvalue1035.put("AttitudeWord","กวาดล้าง");
        attvalue1035.put("AttitudeRank",-1);
        attvalue1035.put("Emotion","8");

        attvalue1036.put("AttitudeID",1036);
        attvalue1036.put("AttitudeWord","กอบโกย");
        attvalue1036.put("AttitudeRank",-1);
        attvalue1036.put("Emotion","1");

        attvalue1037.put("AttitudeID",1037);
        attvalue1037.put("AttitudeWord","กะหรี่");
        attvalue1037.put("AttitudeRank",-1);
        attvalue1037.put("Emotion","4");

        attvalue1038.put("AttitudeID",1038);
        attvalue1038.put("AttitudeWord","กัก");
        attvalue1038.put("AttitudeRank",-1);
        attvalue1038.put("Emotion","015");

        attvalue1039.put("AttitudeID",1039);
        attvalue1039.put("AttitudeWord","กักขัง");
        attvalue1039.put("AttitudeRank",-1);
        attvalue1039.put("Emotion","015");

        attvalue1040.put("AttitudeID",1040);
        attvalue1040.put("AttitudeWord","กังขา");
        attvalue1040.put("AttitudeRank",-1);
        attvalue1040.put("Emotion","8");

        attvalue1041.put("AttitudeID",1041);
        attvalue1041.put("AttitudeWord","กัด");
        attvalue1041.put("AttitudeRank",-1);
        attvalue1041.put("Emotion","8");

        attvalue1042.put("AttitudeID",1042);
        attvalue1042.put("AttitudeWord","ก้าวก่าย");
        attvalue1042.put("AttitudeRank",-1);
        attvalue1042.put("Emotion","15");

        attvalue1043.put("AttitudeID",1043);
        attvalue1043.put("AttitudeWord","กำจัด");
        attvalue1043.put("AttitudeRank",-1);
        attvalue1043.put("Emotion","8");

        attvalue1044.put("AttitudeID",1044);
        attvalue1044.put("AttitudeWord","กำเริบ");
        attvalue1044.put("AttitudeRank",-1);
        attvalue1044.put("Emotion","8");

        attvalue1045.put("AttitudeID",1045);
        attvalue1045.put("AttitudeWord","เกร็ง");
        attvalue1045.put("AttitudeRank",-1);
        attvalue1045.put("Emotion","8");

        attvalue1046.put("AttitudeID",1046);
        attvalue1046.put("AttitudeWord","เกรงกลัว");
        attvalue1046.put("AttitudeRank",-1);
        attvalue1046.put("Emotion","1");

        attvalue1047.put("AttitudeID",1047);
        attvalue1047.put("AttitudeWord","เกเร");
        attvalue1047.put("AttitudeRank",-1);
        attvalue1047.put("Emotion","45");

        attvalue1048.put("AttitudeID",1048);
        attvalue1048.put("AttitudeWord","เกลื่อน");
        attvalue1048.put("AttitudeRank",-1);
        attvalue1048.put("Emotion","8");

        attvalue1049.put("AttitudeID",1049);
        attvalue1049.put("AttitudeWord","เกิน");
        attvalue1049.put("AttitudeRank",-1);
        attvalue1049.put("Emotion","8");

        attvalue1050.put("AttitudeID",1050);
        attvalue1050.put("AttitudeWord","แก่");
        attvalue1050.put("AttitudeRank",-1);
        attvalue1050.put("Emotion","8");

        attvalue1051.put("AttitudeID",1051);
        attvalue1051.put("AttitudeWord","แก่งแย่ง");
        attvalue1051.put("AttitudeRank",-1);
        attvalue1051.put("Emotion","5");

        attvalue1052.put("AttitudeID",1052);
        attvalue1052.put("AttitudeWord","แกว่ง");
        attvalue1052.put("AttitudeRank",-1);
        attvalue1052.put("Emotion","8");

        attvalue1053.put("AttitudeID",1053);
        attvalue1053.put("AttitudeWord","ข่มขวัญ");
        attvalue1053.put("AttitudeRank",-1);
        attvalue1053.put("Emotion","01");

        attvalue1054.put("AttitudeID",1054);
        attvalue1054.put("AttitudeWord","ข่มขี่");
        attvalue1054.put("AttitudeRank",-1);
        attvalue1054.put("Emotion","01");

        attvalue1055.put("AttitudeID",1055);
        attvalue1055.put("AttitudeWord","ขโมย");
        attvalue1055.put("AttitudeRank",-1);
        attvalue1055.put("Emotion","05");

        attvalue1056.put("AttitudeID",1056);
        attvalue1056.put("AttitudeWord","ขวาง");
        attvalue1056.put("AttitudeRank",-1);
        attvalue1056.put("Emotion","5");

        attvalue1057.put("AttitudeID",1057);
        attvalue1057.put("AttitudeWord","ขวางโลก");
        attvalue1057.put("AttitudeRank",-1);
        attvalue1057.put("Emotion","45");

        attvalue1058.put("AttitudeID",1058);
        attvalue1058.put("AttitudeWord","ขัง");
        attvalue1058.put("AttitudeRank",-1);
        attvalue1058.put("Emotion","015");

        attvalue1059.put("AttitudeID",1059);
        attvalue1059.put("AttitudeWord","ขัดขวาง");
        attvalue1059.put("AttitudeRank",-1);
        attvalue1059.put("Emotion","0");

        attvalue1060.put("AttitudeID",1060);
        attvalue1060.put("AttitudeWord","ขัดข้อง");
        attvalue1060.put("AttitudeRank",-1);
        attvalue1060.put("Emotion","8");

        attvalue1061.put("AttitudeID",1061);
        attvalue1061.put("AttitudeWord","ขัดขืน");
        attvalue1061.put("AttitudeRank",-1);
        attvalue1061.put("Emotion","145");

        attvalue1062.put("AttitudeID",1062);
        attvalue1062.put("AttitudeWord","ขาดแคลน");
        attvalue1062.put("AttitudeRank",-1);
        attvalue1062.put("Emotion","0");

        attvalue1063.put("AttitudeID",1063);
        attvalue1063.put("AttitudeWord","ขาดทุน");
        attvalue1063.put("AttitudeRank",-1);
        attvalue1063.put("Emotion","0");

        attvalue1064.put("AttitudeID",1064);
        attvalue1064.put("AttitudeWord","ขายชาติ");
        attvalue1064.put("AttitudeRank",-1);
        attvalue1064.put("Emotion","45");

        attvalue1065.put("AttitudeID",1065);
        attvalue1065.put("AttitudeWord","ขายหน้า");
        attvalue1065.put("AttitudeRank",-1);
        attvalue1065.put("Emotion","014");

        attvalue1066.put("AttitudeID",1066);
        attvalue1066.put("AttitudeWord","ขาลง");
        attvalue1066.put("AttitudeRank",-1);
        attvalue1066.put("Emotion","8");

        attvalue1067.put("AttitudeID",1067);
        attvalue1067.put("AttitudeWord","ขี้");
        attvalue1067.put("AttitudeRank",-1);
        attvalue1067.put("Emotion","8");

        attvalue1068.put("AttitudeID",1068);
        attvalue1068.put("AttitudeWord","ขืน");
        attvalue1068.put("AttitudeRank",-1);
        attvalue1068.put("Emotion","145");

        attvalue1069.put("AttitudeID",1069);
        attvalue1069.put("AttitudeWord","ขู่เข็ญ");
        attvalue1069.put("AttitudeRank",-1);
        attvalue1069.put("Emotion","1");

        attvalue1070.put("AttitudeID",1070);
        attvalue1070.put("AttitudeWord","เขวี้ยง");
        attvalue1070.put("AttitudeRank",-1);
        attvalue1070.put("Emotion","8");

        attvalue1071.put("AttitudeID",1071);
        attvalue1071.put("AttitudeWord","คดโกง");
        attvalue1071.put("AttitudeRank",-1);
        attvalue1071.put("Emotion","45");

        attvalue1072.put("AttitudeID",1072);
        attvalue1072.put("AttitudeWord","คดงอ");
        attvalue1072.put("AttitudeRank",-1);
        attvalue1072.put("Emotion","2");

        attvalue1073.put("AttitudeID",1073);
        attvalue1073.put("AttitudeWord","คลาดเคลื่อน");
        attvalue1073.put("AttitudeRank",-1);
        attvalue1073.put("Emotion","8");

        attvalue1074.put("AttitudeID",1074);
        attvalue1074.put("AttitudeWord","คลื่นไส้");
        attvalue1074.put("AttitudeRank",-1);
        attvalue1074.put("Emotion","4");

        attvalue1075.put("AttitudeID",1075);
        attvalue1075.put("AttitudeWord","ควย");
        attvalue1075.put("AttitudeRank",-1);
        attvalue1075.put("Emotion","5");

        attvalue1076.put("AttitudeID",1076);
        attvalue1076.put("AttitudeWord","ควาย");
        attvalue1076.put("AttitudeRank",-1);
        attvalue1076.put("Emotion",8);

        attvalue1077.put("AttitudeID",1077);
        attvalue1077.put("AttitudeWord","คว่ำ");
        attvalue1077.put("AttitudeRank",-1);
        attvalue1077.put("Emotion","8");

        attvalue1078.put("AttitudeID",1078);
        attvalue1078.put("AttitudeWord","คอร์รัปชัน");
        attvalue1078.put("AttitudeRank",-1);
        attvalue1078.put("Emotion","4");

        attvalue1079.put("AttitudeID",1079);
        attvalue1079.put("AttitudeWord","คัดค้าน");
        attvalue1079.put("AttitudeRank",-1);
        attvalue1079.put("Emotion","8");

        attvalue1080.put("AttitudeID",1080);
        attvalue1080.put("AttitudeWord","ค้างคา");
        attvalue1080.put("AttitudeRank",-1);
        attvalue1080.put("Emotion","8");

        attvalue1081.put("AttitudeID",1081);
        attvalue1081.put("AttitudeWord","คุมขัง");
        attvalue1081.put("AttitudeRank",-1);
        attvalue1081.put("Emotion","015");

        attvalue1082.put("AttitudeID",1082);
        attvalue1082.put("AttitudeWord","คุมตัว");
        attvalue1082.put("AttitudeRank",-1);
        attvalue1082.put("Emotion","8");

        attvalue1083.put("AttitudeID",1083);
        attvalue1083.put("AttitudeWord","เค้น");
        attvalue1083.put("AttitudeRank",-1);
        attvalue1083.put("Emotion","8");

        attvalue1084.put("AttitudeID",1084);
        attvalue1084.put("AttitudeWord","เคร่ง");
        attvalue1084.put("AttitudeRank",-1);
        attvalue1084.put("Emotion","8");

        attvalue1085.put("AttitudeID",1085);
        attvalue1085.put("AttitudeWord","เคร่งขึม");
        attvalue1085.put("AttitudeRank",-1);
        attvalue1085.put("Emotion","1");

        attvalue1086.put("AttitudeID",1086);
        attvalue1086.put("AttitudeWord","เควี่ย");
        attvalue1086.put("AttitudeRank",-1);
        attvalue1086.put("Emotion","8");

        attvalue1087.put("AttitudeID",1087);
        attvalue1087.put("AttitudeWord","เคือง");
        attvalue1087.put("AttitudeRank",-1);
        attvalue1087.put("Emotion","5");

        attvalue1088.put("AttitudeID",1088);
        attvalue1088.put("AttitudeWord","ฆ่า");
        attvalue1088.put("AttitudeRank",-1);
        attvalue1088.put("Emotion","01");

        attvalue1089.put("AttitudeID",1089);
        attvalue1089.put("AttitudeWord","ฆาต");
        attvalue1089.put("AttitudeRank",-1);
        attvalue1089.put("Emotion","01");

        attvalue1090.put("AttitudeID",1090);
        attvalue1090.put("AttitudeWord","เฆี่ยน");
        attvalue1090.put("AttitudeRank",-1);
        attvalue1090.put("Emotion","15");

        attvalue1091.put("AttitudeID",1091);
        attvalue1091.put("AttitudeWord","งอ");
        attvalue1091.put("AttitudeRank",-1);
        attvalue1091.put("Emotion","8");

        attvalue1092.put("AttitudeID",1092);
        attvalue1092.put("AttitudeWord","เงี่ยน");
        attvalue1092.put("AttitudeRank",-1);
        attvalue1092.put("Emotion","8");

        attvalue1093.put("AttitudeID",1093);
        attvalue1093.put("AttitudeWord","จม");
        attvalue1093.put("AttitudeRank",-1);
        attvalue1093.put("Emotion","8");

        attvalue1094.put("AttitudeID",1094);
        attvalue1094.put("AttitudeWord","จรวย");
        attvalue1094.put("AttitudeRank",-1);
        attvalue1094.put("Emotion","8");

        attvalue1095.put("AttitudeID",1095);
        attvalue1095.put("AttitudeWord","จังไร");
        attvalue1095.put("AttitudeRank",-1);
        attvalue1095.put("Emotion","45");

        attvalue1096.put("AttitudeID",1096);
        attvalue1096.put("AttitudeWord","จัญไร");
        attvalue1096.put("AttitudeRank",-1);
        attvalue1096.put("Emotion","45");

        attvalue1097.put("AttitudeID",1097);
        attvalue1097.put("AttitudeWord","จับกุม");
        attvalue1097.put("AttitudeRank",-1);
        attvalue1097.put("Emotion","8");

        attvalue1098.put("AttitudeID",1098);
        attvalue1098.put("AttitudeWord","จำกัด");
        attvalue1098.put("AttitudeRank",-1);
        attvalue1098.put("Emotion","8");

        attvalue1099.put("AttitudeID",1099);
        attvalue1099.put("AttitudeWord","จิก");
        attvalue1099.put("AttitudeRank",-1);
        attvalue1099.put("Emotion","45");

        attvalue1100.put("AttitudeID",1100);
        attvalue1100.put("AttitudeWord","เจ็บ");
        attvalue1100.put("AttitudeRank",-1);
        attvalue1100.put("Emotion","05");

        attvalue1101.put("AttitudeID",1101);
        attvalue1101.put("AttitudeWord","เจือจาง");
        attvalue1101.put("AttitudeRank",-1);
        attvalue1101.put("Emotion","8");

        attvalue1102.put("AttitudeID",1102);
        attvalue1102.put("AttitudeWord","ฉ้อ");
        attvalue1102.put("AttitudeRank",-1);
        attvalue1102.put("Emotion","45");

        attvalue1103.put("AttitudeID",1103);
        attvalue1103.put("AttitudeWord","ฉีก");
        attvalue1103.put("AttitudeRank",-1);
        attvalue1103.put("Emotion","8");

        attvalue1104.put("AttitudeID",1104);
        attvalue1104.put("AttitudeWord","เฉื่อย");
        attvalue1104.put("AttitudeRank",-1);
        attvalue1104.put("Emotion","8");

        attvalue1105.put("AttitudeID",1105);
        attvalue1105.put("AttitudeWord","ชก");
        attvalue1105.put("AttitudeRank",-1);
        attvalue1105.put("Emotion","5");

        attvalue1106.put("AttitudeID",1106);
        attvalue1106.put("AttitudeWord","ช่วงชิง");
        attvalue1106.put("AttitudeRank",-1);
        attvalue1106.put("Emotion","45");

        attvalue1107.put("AttitudeID",1107);
        attvalue1107.put("AttitudeWord","ชาติหมา");
        attvalue1107.put("AttitudeRank",-1);
        attvalue1107.put("Emotion","5");

        attvalue1108.put("AttitudeID",1108);
        attvalue1108.put("AttitudeWord","ชิบหาย");
        attvalue1108.put("AttitudeRank",-1);
        attvalue1108.put("Emotion","05");

        attvalue1109.put("AttitudeID",1109);
        attvalue1109.put("AttitudeWord","ชู้สาว");
        attvalue1109.put("AttitudeRank",-1);
        attvalue1109.put("Emotion","8");

        attvalue1110.put("AttitudeID",1110);
        attvalue1110.put("AttitudeWord","เชี่ย");
        attvalue1110.put("AttitudeRank",-1);
        attvalue1110.put("Emotion","8");

        attvalue1111.put("AttitudeID",1111);
        attvalue1111.put("AttitudeWord","แซะ");
        attvalue1111.put("AttitudeRank",-1);
        attvalue1111.put("Emotion","45");

        attvalue1112.put("AttitudeID",1112);
        attvalue1112.put("AttitudeWord","เณรคุณ");
        attvalue1112.put("AttitudeRank",-1);
        attvalue1112.put("Emotion","45");

        attvalue1113.put("AttitudeID",1113);
        attvalue1113.put("AttitudeWord","ดับ");
        attvalue1113.put("AttitudeRank",-1);
        attvalue1113.put("Emotion","5");

        attvalue1114.put("AttitudeID",1114);
        attvalue1114.put("AttitudeWord","ดูหมิ่น");
        attvalue1114.put("AttitudeRank",-1);
        attvalue1114.put("Emotion","5");

        attvalue1115.put("AttitudeID",1115);
        attvalue1115.put("AttitudeWord","เดือด");
        attvalue1115.put("AttitudeRank",-1);
        attvalue1115.put("Emotion","5");

        attvalue1116.put("AttitudeID",1116);
        attvalue1116.put("AttitudeWord","แดก");
        attvalue1116.put("AttitudeRank",-1);
        attvalue1116.put("Emotion","8");

        attvalue1117.put("AttitudeID",1117);
        attvalue1117.put("AttitudeWord","ตบ");
        attvalue1117.put("AttitudeRank",-1);
        attvalue1117.put("Emotion","5");

        attvalue1118.put("AttitudeID",1118);
        attvalue1118.put("AttitudeWord","ตราหน้า");
        attvalue1118.put("AttitudeRank",-1);
        attvalue1118.put("Emotion","4");

        attvalue1119.put("AttitudeID",1119);
        attvalue1119.put("AttitudeWord","ตอบโต้");
        attvalue1119.put("AttitudeRank",-1);
        attvalue1119.put("Emotion","5");

        attvalue1120.put("AttitudeID",1120);
        attvalue1120.put("AttitudeWord","ต่อย");
        attvalue1120.put("AttitudeRank",-1);
        attvalue1120.put("Emotion","5");

        attvalue1121.put("AttitudeID",1121);
        attvalue1121.put("AttitudeWord","ต่อสู้");
        attvalue1121.put("AttitudeRank",-1);
        attvalue1121.put("Emotion","5");

        attvalue1122.put("AttitudeID",1122);
        attvalue1122.put("AttitudeWord","ตอแหล");
        attvalue1122.put("AttitudeRank",-1);
        attvalue1122.put("Emotion","45");

        attvalue1123.put("AttitudeID",1123);
        attvalue1123.put("AttitudeWord","ตะลุมบอน");
        attvalue1123.put("AttitudeRank",-1);
        attvalue1123.put("Emotion","5");

        attvalue1124.put("AttitudeID",1124);
        attvalue1124.put("AttitudeWord","ตั้งแง่");
        attvalue1124.put("AttitudeRank",-1);
        attvalue1124.put("Emotion","8");

        attvalue1125.put("AttitudeID",1125);
        attvalue1125.put("AttitudeWord","ตัดขาด");
        attvalue1125.put("AttitudeRank",-1);
        attvalue1125.put("Emotion","0");

        attvalue1126.put("AttitudeID",1126);
        attvalue1126.put("AttitudeWord","ตาขาว");
        attvalue1126.put("AttitudeRank",-1);
        attvalue1126.put("Emotion","1");

        attvalue1127.put("AttitudeID",1127);
        attvalue1127.put("AttitudeWord","ตาย");
        attvalue1127.put("AttitudeRank",-1);
        attvalue1127.put("Emotion","01");

        attvalue1128.put("AttitudeID",1128);
        attvalue1128.put("AttitudeWord","ตายด้าน");
        attvalue1128.put("AttitudeRank",-1);
        attvalue1128.put("Emotion","8");

        attvalue1129.put("AttitudeID",1129);
        attvalue1129.put("AttitudeWord","ติเตียน");
        attvalue1129.put("AttitudeRank",-1);
        attvalue1129.put("Emotion","45");

        attvalue1130.put("AttitudeID",1130);
        attvalue1130.put("AttitudeWord","ตี");
        attvalue1130.put("AttitudeRank",-1);
        attvalue1130.put("Emotion","5");

        attvalue1131.put("AttitudeID",1131);
        attvalue1131.put("AttitudeWord","ถอน");
        attvalue1131.put("AttitudeRank",-1);
        attvalue1131.put("Emotion","8");

        attvalue1132.put("AttitudeID",1132);
        attvalue1132.put("AttitudeWord","ถีบ");
        attvalue1132.put("AttitudeRank",-1);
        attvalue1132.put("Emotion","5");

        attvalue1133.put("AttitudeID",1133);
        attvalue1133.put("AttitudeWord","ถึงฆาต");
        attvalue1133.put("AttitudeRank",-1);
        attvalue1133.put("Emotion","15");

        attvalue1134.put("AttitudeID",1134);
        attvalue1134.put("AttitudeWord","ท่วม");
        attvalue1134.put("AttitudeRank",-1);
        attvalue1134.put("Emotion","01");

        attvalue1135.put("AttitudeID",1135);
        attvalue1135.put("AttitudeWord","ทุบ");
        attvalue1135.put("AttitudeRank",-1);
        attvalue1135.put("Emotion","5");

        attvalue1136.put("AttitudeID",1136);
        attvalue1136.put("AttitudeWord","ทุบตี");
        attvalue1136.put("AttitudeRank",-1);
        attvalue1136.put("Emotion","5");

        attvalue1137.put("AttitudeID",1137);
        attvalue1137.put("AttitudeWord","เท");
        attvalue1137.put("AttitudeRank",-1);
        attvalue1137.put("Emotion","8");

        attvalue1138.put("AttitudeID",1138);
        attvalue1138.put("AttitudeWord","เท็จ");
        attvalue1138.put("AttitudeRank",-1);
        attvalue1138.put("Emotion","8");

        attvalue1139.put("AttitudeID",1139);
        attvalue1139.put("AttitudeWord","แทง");
        attvalue1139.put("AttitudeRank",-1);
        attvalue1139.put("Emotion","05");

        attvalue1140.put("AttitudeID",1140);
        attvalue1140.put("AttitudeWord","น้อย");
        attvalue1140.put("AttitudeRank",-1);
        attvalue1140.put("Emotion","0");

        attvalue1141.put("AttitudeID",1141);
        attvalue1141.put("AttitudeWord","เนรคุณ");
        attvalue1141.put("AttitudeRank",-1);
        attvalue1141.put("Emotion","45");

        attvalue1142.put("AttitudeID",1142);
        attvalue1142.put("AttitudeWord","บกพร่อง");
        attvalue1142.put("AttitudeRank",-1);
        attvalue1142.put("Emotion","8");

        attvalue1143.put("AttitudeID",1143);
        attvalue1143.put("AttitudeWord","บานปลาย");
        attvalue1143.put("AttitudeRank",-1);
        attvalue1143.put("Emotion","8");

        attvalue1144.put("AttitudeID",1144);
        attvalue1144.put("AttitudeWord","บิดเบือน");
        attvalue1144.put("AttitudeRank",-1);
        attvalue1144.put("Emotion","8");

        attvalue1145.put("AttitudeID",1145);
        attvalue1145.put("AttitudeWord","โบ้ย");
        attvalue1145.put("AttitudeRank",-1);
        attvalue1145.put("Emotion","8");

        attvalue1146.put("AttitudeID",1146);
        attvalue1146.put("AttitudeWord","ปฏิเสธ");
        attvalue1146.put("AttitudeRank",-1);
        attvalue1146.put("Emotion","8");

        attvalue1147.put("AttitudeID",1147);
        attvalue1147.put("AttitudeWord","ปด");
        attvalue1147.put("AttitudeRank",-1);
        attvalue1147.put("Emotion","8");

        attvalue1148.put("AttitudeID",1148);
        attvalue1148.put("AttitudeWord","ประจาร");
        attvalue1148.put("AttitudeRank",-1);
        attvalue1148.put("Emotion","4");

        attvalue1149.put("AttitudeID",1149);
        attvalue1149.put("AttitudeWord","ประท้วง");
        attvalue1149.put("AttitudeRank",-1);
        attvalue1149.put("Emotion","8");

        attvalue1150.put("AttitudeID",1150);
        attvalue1150.put("AttitudeWord","ปล้น");
        attvalue1150.put("AttitudeRank",-1);
        attvalue1150.put("Emotion","0145");

        attvalue1151.put("AttitudeID",1151);
        attvalue1151.put("AttitudeWord","ปากเสีย");
        attvalue1151.put("AttitudeRank",-1);
        attvalue1151.put("Emotion","45");

        attvalue1152.put("AttitudeID",1152);
        attvalue1152.put("AttitudeWord","ปากหมา");
        attvalue1152.put("AttitudeRank",-1);
        attvalue1152.put("Emotion","45");

        attvalue1153.put("AttitudeID",1153);
        attvalue1153.put("AttitudeWord","เปล่าเปลี่ยว");
        attvalue1153.put("AttitudeRank",-1);
        attvalue1153.put("Emotion","01");

        attvalue1154.put("AttitudeID",1154);
        attvalue1154.put("AttitudeWord","เปลือง");
        attvalue1154.put("AttitudeRank",-1);
        attvalue1154.put("Emotion","8");

        attvalue1155.put("AttitudeID",1155);
        attvalue1155.put("AttitudeWord","เปื่อย");
        attvalue1155.put("AttitudeRank",-1);
        attvalue1155.put("Emotion","8");

        attvalue1156.put("AttitudeID",1156);
        attvalue1156.put("AttitudeWord","ผิดหวัง");
        attvalue1156.put("AttitudeRank",-1);
        attvalue1156.put("Emotion","0");

        attvalue1157.put("AttitudeID",1157);
        attvalue1157.put("AttitudeWord","พ่อง");
        attvalue1157.put("AttitudeRank",-1);
        attvalue1157.put("Emotion","5");

        attvalue1158.put("AttitudeID",1158);
        attvalue1158.put("AttitudeWord","พ่อมึง");
        attvalue1158.put("AttitudeRank",-1);
        attvalue1158.put("Emotion","5");

        attvalue1159.put("AttitudeID",1159);
        attvalue1159.put("AttitudeWord","พ่อมึงตาย");
        attvalue1159.put("AttitudeRank",-1);
        attvalue1159.put("Emotion","5");

        attvalue1160.put("AttitudeID",1160);
        attvalue1160.put("AttitudeWord","พิการ");
        attvalue1160.put("AttitudeRank",-1);
        attvalue1160.put("Emotion","0");

        attvalue1161.put("AttitudeID",1161);
        attvalue1161.put("AttitudeWord","ฟวย");
        attvalue1161.put("AttitudeRank",-1);
        attvalue1161.put("Emotion","8");

        attvalue1162.put("AttitudeID",1162);
        attvalue1162.put("AttitudeWord","ฟาย");
        attvalue1162.put("AttitudeRank",-1);
        attvalue1162.put("Emotion","8");

        attvalue1163.put("AttitudeID",1163);
        attvalue1163.put("AttitudeWord","มัวหมอง");
        attvalue1163.put("AttitudeRank",-1);
        attvalue1163.put("Emotion","0");

        attvalue1164.put("AttitudeID",1164);
        attvalue1164.put("AttitudeWord","แม่ง");
        attvalue1164.put("AttitudeRank",-1);
        attvalue1164.put("Emotion","5");

        attvalue1165.put("AttitudeID",1165);
        attvalue1165.put("AttitudeWord","แมงดา");
        attvalue1165.put("AttitudeRank",-1);
        attvalue1165.put("Emotion","4");

        attvalue1166.put("AttitudeID",1166);
        attvalue1166.put("AttitudeWord","แม่มึง");
        attvalue1166.put("AttitudeRank",-1);
        attvalue1166.put("Emotion","5");

        attvalue1167.put("AttitudeID",1167);
        attvalue1167.put("AttitudeWord","แม่มึงตาย");
        attvalue1167.put("AttitudeRank",-1);
        attvalue1167.put("Emotion","5");

        attvalue1168.put("AttitudeID",1168);
        attvalue1168.put("AttitudeWord","ยุ่งเหยิง");
        attvalue1168.put("AttitudeRank",-1);
        attvalue1168.put("Emotion","8");

        attvalue1169.put("AttitudeID",1169);
        attvalue1169.put("AttitudeWord","เย็ด");
        attvalue1169.put("AttitudeRank",-1);
        attvalue1169.put("Emotion","8");

        attvalue1170.put("AttitudeID",1170);
        attvalue1170.put("AttitudeWord","เยี่ยว");
        attvalue1170.put("AttitudeRank",-1);
        attvalue1170.put("Emotion","8");

        attvalue1171.put("AttitudeID",1171);
        attvalue1171.put("AttitudeWord","ร้องไห้");
        attvalue1171.put("AttitudeRank",-1);
        attvalue1171.put("Emotion","01");

        attvalue1172.put("AttitudeID",1172);
        attvalue1172.put("AttitudeWord","ระยำ");
        attvalue1172.put("AttitudeRank",-1);
        attvalue1172.put("Emotion","5");

        attvalue1173.put("AttitudeID",1173);
        attvalue1173.put("AttitudeWord","รุ่ยร่าย");
        attvalue1173.put("AttitudeRank",-1);
        attvalue1173.put("Emotion","8");

        attvalue1174.put("AttitudeID",1174);
        attvalue1174.put("AttitudeWord","ลบ");
        attvalue1174.put("AttitudeRank",-1);
        attvalue1174.put("Emotion","8");

        attvalue1175.put("AttitudeID",1175);
        attvalue1175.put("AttitudeWord","ล้ม");
        attvalue1175.put("AttitudeRank",-1);
        attvalue1175.put("Emotion","0");

        attvalue1176.put("AttitudeID",1176);
        attvalue1176.put("AttitudeWord","ลัก");
        attvalue1176.put("AttitudeRank",-1);
        attvalue1176.put("Emotion","05");

        attvalue1177.put("AttitudeID",1177);
        attvalue1177.put("AttitudeWord","ลืม");
        attvalue1177.put("AttitudeRank",-1);
        attvalue1177.put("Emotion","8");

        attvalue1178.put("AttitudeID",1178);
        attvalue1178.put("AttitudeWord","โลเล");
        attvalue1178.put("AttitudeRank",-1);
        attvalue1178.put("Emotion","8");

        attvalue1179.put("AttitudeID",1179);
        attvalue1179.put("AttitudeWord","ว่ายาก");
        attvalue1179.put("AttitudeRank",-1);
        attvalue1179.put("Emotion","8");

        attvalue1180.put("AttitudeID",1180);
        attvalue1180.put("AttitudeWord","วิปโยค");
        attvalue1180.put("AttitudeRank",-1);
        attvalue1180.put("Emotion","8");

        attvalue1181.put("AttitudeID",1181);
        attvalue1181.put("AttitudeWord","วิประโยค");
        attvalue1181.put("AttitudeRank",-1);
        attvalue1181.put("Emotion","8");

        attvalue1182.put("AttitudeID",1182);
        attvalue1182.put("AttitudeWord","สถุน");
        attvalue1182.put("AttitudeRank",-1);
        attvalue1182.put("Emotion","45");

        attvalue1183.put("AttitudeID",1183);
        attvalue1183.put("AttitudeWord","สถุล");
        attvalue1183.put("AttitudeRank",-1);
        attvalue1183.put("Emotion","45");

        attvalue1184.put("AttitudeID",1184);
        attvalue1184.put("AttitudeWord","ส้นตีน");
        attvalue1184.put("AttitudeRank",-1);
        attvalue1184.put("Emotion","5");

        attvalue1185.put("AttitudeID",1185);
        attvalue1185.put("AttitudeWord","สลัว");
        attvalue1185.put("AttitudeRank",-1);
        attvalue1185.put("Emotion","1");

        attvalue1186.put("AttitudeID",1186);
        attvalue1186.put("AttitudeWord","สะเหล่อ");
        attvalue1186.put("AttitudeRank",-1);
        attvalue1186.put("Emotion","45");

        attvalue1187.put("AttitudeID",1187);
        attvalue1187.put("AttitudeWord","สัด");
        attvalue1187.put("AttitudeRank",-1);
        attvalue1187.put("Emotion","5");

        attvalue1188.put("AttitudeID",1188);
        attvalue1188.put("AttitudeWord","สันดาน");
        attvalue1188.put("AttitudeRank",-1);
        attvalue1188.put("Emotion","5");

        attvalue1189.put("AttitudeID",1189);
        attvalue1189.put("AttitudeWord","สับปลับ");
        attvalue1189.put("AttitudeRank",-1);
        attvalue1189.put("Emotion","8");

        attvalue1190.put("AttitudeID",1190);
        attvalue1190.put("AttitudeWord","สัส");
        attvalue1190.put("AttitudeRank",-1);
        attvalue1190.put("Emotion","5");

        attvalue1191.put("AttitudeID",1191);
        attvalue1191.put("AttitudeWord","สาด");
        attvalue1191.put("AttitudeRank",-1);
        attvalue1191.put("Emotion","5");

        attvalue1192.put("AttitudeID",1192);
        attvalue1192.put("AttitudeWord","สิ้นสติ");
        attvalue1192.put("AttitudeRank",-1);
        attvalue1192.put("Emotion","8");

        attvalue1193.put("AttitudeID",1193);
        attvalue1193.put("AttitudeWord","สูญ");
        attvalue1193.put("AttitudeRank",-1);
        attvalue1193.put("Emotion","0");

        attvalue1194.put("AttitudeID",1194);
        attvalue1194.put("AttitudeWord","เสีย");
        attvalue1194.put("AttitudeRank",-1);
        attvalue1194.put("Emotion","0");

        attvalue1195.put("AttitudeID",1195);
        attvalue1195.put("AttitudeWord","เสือก");
        attvalue1195.put("AttitudeRank",-1);
        attvalue1195.put("Emotion","45");

        attvalue1196.put("AttitudeID",1196);
        attvalue1196.put("AttitudeWord","เสื่อมโทรม");
        attvalue1196.put("AttitudeRank",-1);
        attvalue1196.put("Emotion","8");

        attvalue1197.put("AttitudeID",1197);
        attvalue1197.put("AttitudeWord","เสื่อมเสีย");
        attvalue1197.put("AttitudeRank",-1);
        attvalue1197.put("Emotion","0145");

        attvalue1198.put("AttitudeID",1198);
        attvalue1198.put("AttitudeWord","โสมม");
        attvalue1198.put("AttitudeRank",-1);
        attvalue1198.put("Emotion","4");

        attvalue1199.put("AttitudeID",1199);
        attvalue1199.put("AttitudeWord","หงุดหงิด");
        attvalue1199.put("AttitudeRank",-1);
        attvalue1199.put("Emotion","5");

        attvalue1200.put("AttitudeID",1200);
        attvalue1200.put("AttitudeWord","หน้าด้าน");
        attvalue1200.put("AttitudeRank",-1);
        attvalue1200.put("Emotion","45");

        attvalue1201.put("AttitudeID",1201);
        attvalue1201.put("AttitudeWord","หน้าตัวเมีย");
        attvalue1201.put("AttitudeRank",-1);
        attvalue1201.put("Emotion","45");

        attvalue1202.put("AttitudeID",1202);
        attvalue1202.put("AttitudeWord","หมองมัว");
        attvalue1202.put("AttitudeRank",-1);
        attvalue1202.put("Emotion","0");

        attvalue1203.put("AttitudeID",1203);
        attvalue1203.put("AttitudeWord","หรี่");
        attvalue1203.put("AttitudeRank",-1);
        attvalue1203.put("Emotion","8");

        attvalue1204.put("AttitudeID",1204);
        attvalue1204.put("AttitudeWord","หัวร้อน");
        attvalue1204.put("AttitudeRank",-1);
        attvalue1204.put("Emotion","5");

        attvalue1205.put("AttitudeID",1205);
        attvalue1205.put("AttitudeWord","หี");
        attvalue1205.put("AttitudeRank",-1);
        attvalue1205.put("Emotion","8");

        attvalue1206.put("AttitudeID",1206);
        attvalue1206.put("AttitudeWord","เหม็น");
        attvalue1206.put("AttitudeRank",-1);
        attvalue1206.put("Emotion","4");

        attvalue1207.put("AttitudeID",1207);
        attvalue1207.put("AttitudeWord","เหี้ย");
        attvalue1207.put("AttitudeRank",-1);
        attvalue1207.put("Emotion","5");

        attvalue1208.put("AttitudeID",1208);
        attvalue1208.put("AttitudeWord","เหียก");
        attvalue1208.put("AttitudeRank",-1);
        attvalue1208.put("Emotion","4");

        attvalue1209.put("AttitudeID",1209);
        attvalue1209.put("AttitudeWord","อกตัญญู");
        attvalue1209.put("AttitudeRank",-1);
        attvalue1209.put("Emotion","04");

        attvalue1210.put("AttitudeID",1210);
        attvalue1210.put("AttitudeWord","อกแตก");
        attvalue1210.put("AttitudeRank",-1);
        attvalue1210.put("Emotion","5");

        attvalue1211.put("AttitudeID",1211);
        attvalue1211.put("AttitudeWord","อ้วน");
        attvalue1211.put("AttitudeRank",-1);
        attvalue1211.put("Emotion","8");

        attvalue1212.put("AttitudeID",1212);
        attvalue1212.put("AttitudeWord","อัปปรี");
        attvalue1212.put("AttitudeRank",-1);
        attvalue1212.put("Emotion","45");

        attvalue1213.put("AttitudeID",1213);
        attvalue1213.put("AttitudeWord","อัปปรีย์");
        attvalue1213.put("AttitudeRank",-1);
        attvalue1213.put("Emotion","45");

        attvalue1214.put("AttitudeID",1214);
        attvalue1214.put("AttitudeWord","อื้อฉาว");
        attvalue1214.put("AttitudeRank",-1);
        attvalue1214.put("Emotion","5");

        attvalue1215.put("AttitudeID",1215);
        attvalue1215.put("AttitudeWord","อุบาด");
        attvalue1215.put("AttitudeRank",-1);
        attvalue1215.put("Emotion","4");

        attvalue1216.put("AttitudeID",1216);
        attvalue1216.put("AttitudeWord","อุบาท");
        attvalue1216.put("AttitudeRank",-1);
        attvalue1216.put("Emotion","4");

        attvalue1217.put("AttitudeID",1217);
        attvalue1217.put("AttitudeWord","อุบาทว์");
        attvalue1217.put("AttitudeRank",-1);
        attvalue1217.put("Emotion","4");

        attvalue1218.put("AttitudeID",1218);
        attvalue1218.put("AttitudeWord","เฮี้ย");
        attvalue1218.put("AttitudeRank",-1);
        attvalue1218.put("Emotion","5");

        attvalue1219.put("AttitudeID",1219);
        attvalue1219.put("AttitudeWord","ดูแล");
        attvalue1219.put("AttitudeRank",1);
        attvalue1219.put("Emotion","8");

        attvalue1220.put("AttitudeID",1220);
        attvalue1220.put("AttitudeWord","อุ้มชู");
        attvalue1220.put("AttitudeRank",1);
        attvalue1220.put("Emotion","8");

        attvalue1221.put("AttitudeID",1221);
        attvalue1221.put("AttitudeWord","กอด");
        attvalue1221.put("AttitudeRank",1);
        attvalue1221.put("Emotion","27");

        attvalue1222.put("AttitudeID",1222);
        attvalue1222.put("AttitudeWord","การันตี");
        attvalue1222.put("AttitudeRank",1);
        attvalue1222.put("Emotion","2");

        attvalue1223.put("AttitudeID",1223);
        attvalue1223.put("AttitudeWord","ก้าว");
        attvalue1223.put("AttitudeRank",1);
        attvalue1223.put("Emotion","8");

        attvalue1224.put("AttitudeID",1224);
        attvalue1224.put("AttitudeWord","ช่วย");
        attvalue1224.put("AttitudeRank",1);
        attvalue1224.put("Emotion","2");

        attvalue1225.put("AttitudeID",1225);
        attvalue1225.put("AttitudeWord","อนุมัติ");
        attvalue1225.put("AttitudeRank",1);
        attvalue1225.put("Emotion","2");

        attvalue1226.put("AttitudeID",1226);
        attvalue1226.put("AttitudeWord","กตเวที");
        attvalue1226.put("AttitudeRank",1);
        attvalue1226.put("Emotion","8");

        attvalue1227.put("AttitudeID",1227);
        attvalue1227.put("AttitudeWord","กรุณา");
        attvalue1227.put("AttitudeRank",1);
        attvalue1227.put("Emotion","8");

        attvalue1228.put("AttitudeID",1228);
        attvalue1228.put("AttitudeWord","กันเอง");
        attvalue1228.put("AttitudeRank",1);
        attvalue1228.put("Emotion","8");

        attvalue1229.put("AttitudeID",1229);
        attvalue1229.put("AttitudeWord","แข็งขัน");
        attvalue1229.put("AttitudeRank",1);
        attvalue1229.put("Emotion","8");

        attvalue1230.put("AttitudeID",1230);
        attvalue1230.put("AttitudeWord","ปรองดอง");
        attvalue1230.put("AttitudeRank",1);
        attvalue1230.put("Emotion","8");

        attvalue1231.put("AttitudeID",1231);
        attvalue1231.put("AttitudeWord","ครื้นครึก");
        attvalue1231.put("AttitudeRank",1);
        attvalue1231.put("Emotion","7");

        attvalue1232.put("AttitudeID",1232);
        attvalue1232.put("AttitudeWord","ครึกครื้น");
        attvalue1232.put("AttitudeRank",1);
        attvalue1232.put("Emotion","7");

        attvalue1233.put("AttitudeID",1233);
        attvalue1233.put("AttitudeWord","ชุ่มชื้น");
        attvalue1233.put("AttitudeRank",1);
        attvalue1233.put("Emotion","7");

        attvalue1234.put("AttitudeID",1234);
        attvalue1234.put("AttitudeWord","หวาน");
        attvalue1234.put("AttitudeRank",1);
        attvalue1234.put("Emotion","7");

        attvalue1235.put("AttitudeID",1235);
        attvalue1235.put("AttitudeWord","รื่นรมย์");
        attvalue1235.put("AttitudeRank",1);
        attvalue1235.put("Emotion","7");

        attvalue1236.put("AttitudeID",1236);
        attvalue1236.put("AttitudeWord","เชี่ยวชาญ");
        attvalue1236.put("AttitudeRank",1);
        attvalue1236.put("Emotion","8");

        attvalue1237.put("AttitudeID",1237);
        attvalue1237.put("AttitudeWord","แถม");
        attvalue1237.put("AttitudeRank",1);
        attvalue1237.put("Emotion","8");

        attvalue1238.put("AttitudeID",1238);
        attvalue1238.put("AttitudeWord","แท้");
        attvalue1238.put("AttitudeRank",1);
        attvalue1238.put("Emotion","8");

        attvalue1239.put("AttitudeID",1239);
        attvalue1239.put("AttitudeWord","นวล");
        attvalue1239.put("AttitudeRank",1);
        attvalue1239.put("Emotion","8");

        attvalue1240.put("AttitudeID",1240);
        attvalue1240.put("AttitudeWord","ขอบใจ");
        attvalue1240.put("AttitudeRank",1);
        attvalue1240.put("Emotion","7");

        attvalue1241.put("AttitudeID",1241);
        attvalue1241.put("AttitudeWord","แน่");
        attvalue1241.put("AttitudeRank",1);
        attvalue1241.put("Emotion","27");

        attvalue1242.put("AttitudeID",1242);
        attvalue1242.put("AttitudeWord","แน่ชัด");
        attvalue1242.put("AttitudeRank",1);
        attvalue1242.put("Emotion","8");

        attvalue1243.put("AttitudeID",1243);
        attvalue1243.put("AttitudeWord","บริบูรณ์");
        attvalue1243.put("AttitudeRank",1);
        attvalue1243.put("Emotion","8");

        attvalue1244.put("AttitudeID",1244);
        attvalue1244.put("AttitudeWord","บวก");
        attvalue1244.put("AttitudeRank",1);
        attvalue1244.put("Emotion","8");

        attvalue1245.put("AttitudeID",1245);
        attvalue1245.put("AttitudeWord","เบิกบาน");
        attvalue1245.put("AttitudeRank",1);
        attvalue1245.put("Emotion","7");

        attvalue1246.put("AttitudeID",1246);
        attvalue1246.put("AttitudeWord","ปราดเปรียว");
        attvalue1246.put("AttitudeRank",1);
        attvalue1246.put("Emotion","8");

        attvalue1247.put("AttitudeID",1247);
        attvalue1247.put("AttitudeWord","ประหยัด");
        attvalue1247.put("AttitudeRank",1);
        attvalue1247.put("Emotion","8");

        attvalue1248.put("AttitudeID",1248);
        attvalue1248.put("AttitudeWord","เคารพ");
        attvalue1248.put("AttitudeRank",1);
        attvalue1248.put("Emotion","8");

        attvalue1249.put("AttitudeID",1249);
        attvalue1249.put("AttitudeWord","รักษา");
        attvalue1249.put("AttitudeRank",1);
        attvalue1249.put("Emotion","2");

        attvalue1250.put("AttitudeID",1250);
        attvalue1250.put("AttitudeWord","สรรเสริญ");
        attvalue1250.put("AttitudeRank",1);
        attvalue1250.put("Emotion","7");

        attvalue1251.put("AttitudeID",1251);
        attvalue1251.put("AttitudeWord","บำรุง");
        attvalue1251.put("AttitudeRank",1);
        attvalue1251.put("Emotion","8");

        attvalue1252.put("AttitudeID",1252);
        attvalue1252.put("AttitudeWord","เชื่อฟัง");
        attvalue1252.put("AttitudeRank",1);
        attvalue1252.put("Emotion","2");

        attvalue1253.put("AttitudeID",1253);
        attvalue1253.put("AttitudeWord","ยิ้ม");
        attvalue1253.put("AttitudeRank",1);
        attvalue1253.put("Emotion","7");

        attvalue1254.put("AttitudeID",1254);
        attvalue1254.put("AttitudeWord","นมัสการ");
        attvalue1254.put("AttitudeRank",1);
        attvalue1254.put("Emotion","8");

        attvalue1255.put("AttitudeID",1255);
        attvalue1255.put("AttitudeWord","จริง");
        attvalue1255.put("AttitudeRank",1);
        attvalue1255.put("Emotion","2");

        attvalue1256.put("AttitudeID",1256);
        attvalue1256.put("AttitudeWord","แน่แน่ว");
        attvalue1256.put("AttitudeRank",1);
        attvalue1256.put("Emotion","2");

        attvalue1257.put("AttitudeID",1257);
        attvalue1257.put("AttitudeWord","มงคล");
        attvalue1257.put("AttitudeRank",1);
        attvalue1257.put("Emotion","7");

        attvalue1258.put("AttitudeID",1258);
        attvalue1258.put("AttitudeWord","แน่วแน่");
        attvalue1258.put("AttitudeRank",1);
        attvalue1258.put("Emotion","2");

        attvalue1259.put("AttitudeID",1259);
        attvalue1259.put("AttitudeWord","ปลั่ง");
        attvalue1259.put("AttitudeRank",1);
        attvalue1259.put("Emotion","8");

        attvalue1260.put("AttitudeID",1260);
        attvalue1260.put("AttitudeWord","แปล้");
        attvalue1260.put("AttitudeRank",1);
        attvalue1260.put("Emotion","8");

        attvalue1261.put("AttitudeID",1261);
        attvalue1261.put("AttitudeWord","อดออม");
        attvalue1261.put("AttitudeRank",1);
        attvalue1261.put("Emotion","8");

        attvalue1262.put("AttitudeID",1262);
        attvalue1262.put("AttitudeWord","อนุโมทนา");
        attvalue1262.put("AttitudeRank",1);
        attvalue1262.put("Emotion","8");

        attvalue1263.put("AttitudeID",1263);
        attvalue1263.put("AttitudeWord","คุ้มครอง");
        attvalue1263.put("AttitudeRank",1);
        attvalue1263.put("Emotion","8");

        attvalue1264.put("AttitudeID",1264);
        attvalue1264.put("AttitudeWord","พิทักษ์");
        attvalue1264.put("AttitudeRank",1);
        attvalue1264.put("Emotion","8");

        attvalue1265.put("AttitudeID",1265);
        attvalue1265.put("AttitudeWord","มหา");
        attvalue1265.put("AttitudeRank",1);
        attvalue1265.put("Emotion","8");

        attvalue1266.put("AttitudeID",1266);
        attvalue1266.put("AttitudeWord","มั่งมี");
        attvalue1266.put("AttitudeRank",1);
        attvalue1266.put("Emotion","7");

        attvalue1267.put("AttitudeID",1267);
        attvalue1267.put("AttitudeWord","ปลอดภัย");
        attvalue1267.put("AttitudeRank",1);
        attvalue1267.put("Emotion","2");

        attvalue1268.put("AttitudeID",1268);
        attvalue1268.put("AttitudeWord","ทำบุญ");
        attvalue1268.put("AttitudeRank",1);
        attvalue1268.put("Emotion","8");

        attvalue1269.put("AttitudeID",1269);
        attvalue1269.put("AttitudeWord","รุ่ง");
        attvalue1269.put("AttitudeRank",1);
        attvalue1269.put("Emotion","7");

        attvalue1270.put("AttitudeID",1270);
        attvalue1270.put("AttitudeWord","เร็ว");
        attvalue1270.put("AttitudeRank",1);
        attvalue1270.put("Emotion","8");

        attvalue1271.put("AttitudeID",1271);
        attvalue1271.put("AttitudeWord","เรือง");
        attvalue1271.put("AttitudeRank",1);
        attvalue1271.put("Emotion","8");

        attvalue1272.put("AttitudeID",1272);
        attvalue1272.put("AttitudeWord","ล้ำเลิศ");
        attvalue1272.put("AttitudeRank",1);
        attvalue1272.put("Emotion","27");

        attvalue1273.put("AttitudeID",1273);
        attvalue1273.put("AttitudeWord","ลึกซึ้ง");
        attvalue1273.put("AttitudeRank",1);
        attvalue1273.put("Emotion","8");

        attvalue1274.put("AttitudeID",1274);
        attvalue1274.put("AttitudeWord","วาว");
        attvalue1274.put("AttitudeRank",1);
        attvalue1274.put("Emotion","8");

        attvalue1275.put("AttitudeID",1275);
        attvalue1275.put("AttitudeWord","เสถียรภาพ");
        attvalue1275.put("AttitudeRank",1);
        attvalue1275.put("Emotion","8");

        attvalue1276.put("AttitudeID",1276);
        attvalue1276.put("AttitudeWord","เสริมสร้าง");
        attvalue1276.put("AttitudeRank",1);
        attvalue1276.put("Emotion","8");

        attvalue1277.put("AttitudeID",1277);
        attvalue1277.put("AttitudeWord","สร้าง");
        attvalue1277.put("AttitudeRank",1);
        attvalue1277.put("Emotion","8");

        attvalue1278.put("AttitudeID",1278);
        attvalue1278.put("AttitudeWord","เพลิดเพลิน");
        attvalue1278.put("AttitudeRank",1);
        attvalue1278.put("Emotion","7");

        attvalue1279.put("AttitudeID",1279);
        attvalue1279.put("AttitudeWord","เกียรติ");
        attvalue1279.put("AttitudeRank",1);
        attvalue1279.put("Emotion","7");

        attvalue1280.put("AttitudeID",1280);
        attvalue1280.put("AttitudeWord","สนิท");
        attvalue1280.put("AttitudeRank",1);
        attvalue1280.put("Emotion","8");

        attvalue1281.put("AttitudeID",1281);
        attvalue1281.put("AttitudeWord","สร้างสรรค์");
        attvalue1281.put("AttitudeRank",1);
        attvalue1281.put("Emotion","2");

        attvalue1282.put("AttitudeID",1282);
        attvalue1282.put("AttitudeWord","สำเร็จ");
        attvalue1282.put("AttitudeRank",1);
        attvalue1282.put("Emotion","7");

        attvalue1283.put("AttitudeID",1283);
        attvalue1283.put("AttitudeWord","เสมอ");
        attvalue1283.put("AttitudeRank",1);
        attvalue1283.put("Emotion","8");

        attvalue1284.put("AttitudeID",1284);
        attvalue1284.put("AttitudeWord","เหมาะเจาะ");
        attvalue1284.put("AttitudeRank",1);
        attvalue1284.put("Emotion","2");

        attvalue1285.put("AttitudeID",1285);
        attvalue1285.put("AttitudeWord","เหมาะสม");
        attvalue1285.put("AttitudeRank",1);
        attvalue1285.put("Emotion","2");

        attvalue1286.put("AttitudeID",1286);
        attvalue1286.put("AttitudeWord","ทุ่มเท");
        attvalue1286.put("AttitudeRank",1);
        attvalue1286.put("Emotion","8");

        attvalue1287.put("AttitudeID",1287);
        attvalue1287.put("AttitudeWord","โรแมนติก");
        attvalue1287.put("AttitudeRank",1);
        attvalue1287.put("Emotion","7");

        attvalue1288.put("AttitudeID",1288);
        attvalue1288.put("AttitudeWord","มีชื่อ");
        attvalue1288.put("AttitudeRank",1);
        attvalue1288.put("Emotion","27");

        attvalue1289.put("AttitudeID",1289);
        attvalue1289.put("AttitudeWord","พร้อม");
        attvalue1289.put("AttitudeRank",1);
        attvalue1289.put("Emotion","8");

        attvalue1290.put("AttitudeID",1290);
        attvalue1290.put("AttitudeWord","ชอบธรรม");
        attvalue1290.put("AttitudeRank",1);
        attvalue1290.put("Emotion","8");

        attvalue1291.put("AttitudeID",1291);
        attvalue1291.put("AttitudeWord","เห็นด้วย");
        attvalue1291.put("AttitudeRank",1);
        attvalue1291.put("Emotion","8");

        attvalue1292.put("AttitudeID",1292);
        attvalue1292.put("AttitudeWord","อ่อนโยน");
        attvalue1292.put("AttitudeRank",1);
        attvalue1292.put("Emotion","8");

        attvalue1293.put("AttitudeID",1293);
        attvalue1293.put("AttitudeWord","อัศจรรย์");
        attvalue1293.put("AttitudeRank",1);
        attvalue1293.put("Emotion","7");

        attvalue1294.put("AttitudeID",1294);
        attvalue1294.put("AttitudeWord","ประชาธิปไตย");
        attvalue1294.put("AttitudeRank",1);
        attvalue1294.put("Emotion","2");

        attvalue1295.put("AttitudeID",1295);
        attvalue1295.put("AttitudeWord","โอชะ");
        attvalue1295.put("AttitudeRank",1);
        attvalue1295.put("Emotion","7");

        attvalue1296.put("AttitudeID",1296);
        attvalue1296.put("AttitudeWord","เฮง");
        attvalue1296.put("AttitudeRank",1);
        attvalue1296.put("Emotion","7");

        attvalue1297.put("AttitudeID",1297);
        attvalue1297.put("AttitudeWord","คุณค่า");
        attvalue1297.put("AttitudeRank",1);
        attvalue1297.put("Emotion","8");

        attvalue1298.put("AttitudeID",1298);
        attvalue1298.put("AttitudeWord","เชื่อมั่น");
        attvalue1298.put("AttitudeRank",1);
        attvalue1298.put("Emotion","7");

        attvalue1299.put("AttitudeID",1299);
        attvalue1299.put("AttitudeWord","เอาใจใส่");
        attvalue1299.put("AttitudeRank",1);
        attvalue1299.put("Emotion","7");

        attvalue1300.put("AttitudeID",1300);
        attvalue1300.put("AttitudeWord","เอื้อเฟื้อ");
        attvalue1300.put("AttitudeRank",1);
        attvalue1300.put("Emotion","27");

        attvalue1301.put("AttitudeID",1301);
        attvalue1301.put("AttitudeWord","เย้");
        attvalue1301.put("AttitudeRank",1);
        attvalue1301.put("Emotion","7");

        attvalue1302.put("AttitudeID",1302);
        attvalue1302.put("AttitudeWord","ฮ่า");
        attvalue1302.put("AttitudeRank",1);
        attvalue1302.put("Emotion","7");





        String table_nameatt3 = "Attitudetable3";
        
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1001);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1002);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1003);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1004);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1005);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1006);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1007);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1008);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1009);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1010);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1011);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1012);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1013);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1014);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1015);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1016);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1017);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1018);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1019);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1020);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1021);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1022);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1023);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1024);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1025);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1026);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1027);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1028);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1029);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1030);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1031);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1032);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1033);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1034);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1035);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1036);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1037);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1038);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1039);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1040);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1041);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1042);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1043);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1044);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1045);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1046);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1047);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1048);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1049);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1050);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1051);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1052);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1053);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1054);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1055);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1056);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1057);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1058);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1059);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1060);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1061);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1062);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1063);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1064);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1065);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1066);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1067);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1068);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1069);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1070);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1071);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1072);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1073);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1074);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1075);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1076);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1077);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1078);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1079);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1080);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1081);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1082);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1083);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1084);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1085);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1086);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1087);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1088);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1089);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1090);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1091);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1092);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1093);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1094);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1095);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1096);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1097);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1098);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1099);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1100);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1101);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1102);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1103);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1104);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1105);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1106);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1107);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1108);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1109);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1110);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1111);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1112);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1113);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1114);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1115);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1116);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1117);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1118);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1119);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1120);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1121);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1122);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1123);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1124);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1125);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1126);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1127);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1128);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1129);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1130);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1131);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1132);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1133);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1134);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1135);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1136);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1137);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1138);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1139);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1140);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1141);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1142);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1143);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1144);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1145);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1146);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1147);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1148);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1149);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1150);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1151);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1152);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1153);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1154);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1155);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1156);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1157);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1158);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1159);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1160);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1161);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1162);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1163);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1164);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1165);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1166);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1167);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1168);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1169);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1170);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1171);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1172);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1173);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1174);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1175);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1176);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1177);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1178);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1179);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1180);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1181);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1182);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1183);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1184);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1185);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1186);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1187);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1188);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1189);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1190);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1191);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1192);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1193);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1194);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1195);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1196);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1197);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1198);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1199);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1200);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1201);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1202);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1203);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1204);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1205);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1206);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1207);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1208);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1209);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1210);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1211);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1212);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1213);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1214);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1215);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1216);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1217);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1218);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1219);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1220);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1221);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1222);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1223);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1224);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1225);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1226);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1227);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1228);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1229);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1230);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1231);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1232);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1233);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1234);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1235);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1236);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1237);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1238);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1239);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1240);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1241);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1242);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1243);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1244);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1245);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1246);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1247);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1248);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1249);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1250);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1251);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1252);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1253);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1254);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1255);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1256);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1257);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1258);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1259);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1260);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1261);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1262);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1263);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1264);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1265);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1266);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1267);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1268);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1269);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1270);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1271);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1272);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1273);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1274);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1275);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1276);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1277);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1278);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1279);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1280);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1281);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1282);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1283);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1284);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1285);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1286);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1287);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1288);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1289);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1290);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1291);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1292);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1293);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1294);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1295);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1296);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1297);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1298);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1299);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1300);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1301);
        sqLiteDatabase.insert(table_nameatt3,null,attvalue1302);


    }

    public ArrayList<HashMap<String,String>> getAttitudeList3(){
        try{

            ArrayList<HashMap<String,String>> arr = new ArrayList<HashMap<String,String>>();
            HashMap<String,String> map;
            SQLiteDatabase db = this.getReadableDatabase();
            String sql = "SELECT * FROM " + tableName5;
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

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
