package com.example.myapplication.dao;

import android.database.sqlite.SQLiteDatabase;

public class OperateTable {
    private static final String TABLENAME="userinfo1";
    private static final String IPNAME="IP";
    private SQLiteDatabase db=null;
    public OperateTable(SQLiteDatabase db){
        this.db=db;
    }
    public void insert(String name,String password,String token){
        String sql="insert into "+TABLENAME+ "(name,token,password)"+" values ('"+name+"','"+token+"','"+password+"')";
        this.db.execSQL(sql);
        this.db.close();
    }

    public void delete(int id){
        String sql="delete from "+TABLENAME+" where id="+id;
        this.db.execSQL(sql);
        this.db.close();
    }
    public void update_API(int id,String ip){
        String sql="update "+IPNAME+" set ip ='"+ip+"'"+" where id="+id;
        this.db.execSQL(sql);
        this.db.close();
    }


}
