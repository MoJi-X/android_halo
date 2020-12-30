package com.example.myapplication.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class SearchTable {
    private static final String TABLENAME="userinfo1";
    private static final String IPNAME="IP";
    private String tablename;
    private SQLiteDatabase db =null;
    public SearchTable(SQLiteDatabase db){
        this.db = db;
    }
    public List<String>find(){
        List<String>list=new ArrayList<String>();
        String sql ="select id,name,password from "+TABLENAME;
        Cursor result = this.db.rawQuery(sql,null);
        for(result.moveToFirst();!result.isAfterLast();result.moveToNext()){
            list.add(result.getString(0)+" "+ result.getString(1)+" "+ result.getString(2)+" "+result.getString(3));
        }
        this.db.close();
        return list;
    }
    public List<String>find(String tablename){
        List<String>list=new ArrayList<String>();
        String sql ="select * from "+tablename;
        Cursor result = this.db.rawQuery(sql,null);
        for(result.moveToFirst();!result.isAfterLast();result.moveToNext()){
            list.add(result.getString(0)+" "+ result.getString(1)+" "+ result.getString(2)+" "+result.getString(3));
        }
        this.db.close();
        return list;
    }
    public String find_token(String key){
        String sql="select token from"+tablename;
        Cursor result = this.db.rawQuery(sql,null);
        return  result.toString();
    }
    public String find_ip(int id){
        String ip="";
        String sql = "select * from "+IPNAME;
        Cursor result = this.db.rawQuery(sql,null);
        if(result==null){
            return "";
        }
        for(result.moveToFirst();!result.isAfterLast();result.moveToNext()){
            ip=result.getString(1);
        }
        return ip;
    }
}
