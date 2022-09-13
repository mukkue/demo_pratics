package com.example.anrroidaddtocart;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SqlitedatabaseDemo extends SQLiteOpenHelper {
    public SqlitedatabaseDemo(@Nullable Context context) {
        super(context, "Mydata", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Addtocart(id int primary key,name varchar,price int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void InsertData(int id,String name,int p){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("id",id);
        contentValues.put("name",name);
        contentValues.put("price",p);
        sqLiteDatabase.insert("Addtocart",null,contentValues);
    }

    public Cursor DisplayCartitems(){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor cc=sqLiteDatabase.rawQuery("select * from Addtocart",null);
        return cc;
    }

    public void updatepriceandQuanity(String p,int i){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        sqLiteDatabase.execSQL("update Addtocart set price='"+p+"' where id='"+i+"'");
    }

    public void deletTablerow(int id){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        sqLiteDatabase.execSQL("delete from Addtocart where id='"+id+"'");
    }
}
