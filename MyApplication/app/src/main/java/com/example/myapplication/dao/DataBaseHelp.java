package com.example.myapplication.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelp extends SQLiteOpenHelper {
    private static final String databasename="com.halo";
    private static final String tablename="userinfo1";
    private static final String IPNAME="IP";
    private static final int version=3;
    public DataBaseHelp(Context context){
        super(context,databasename,null,version);
    }
    public void onCreate(SQLiteDatabase db) {
        System.out.println("try");

        String sql="create table "+ tablename+" ("+
                "id  integer primary key ," +
                "name varchar(50) not null,"+"token varchar(50),"+
                "password varchar(50) not null)";
        db.execSQL(sql);
        String sql2="create table "+ IPNAME+" (id integer primary key, ip varchar(20) not null)";
        db.execSQL(sql2);
        String sql3="insert into "+IPNAME+"(id,ip)"+"values ('1','http://47.113.204.48')";
        db.execSQL(sql3);
        System.out.println("table create success");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table if exists "+tablename;
        db.execSQL(sql);
        this.onCreate(db);
        System.out.println("delete success");
    }
}
