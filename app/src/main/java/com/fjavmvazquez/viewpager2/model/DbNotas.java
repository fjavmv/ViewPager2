package com.fjavmvazquez.viewpager2.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbNotas extends  DbHelper{

    private  Context mContext;

    public DbNotas(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    public long crearNota(String titulo, String fecha, String description){
        long id = 0;
        try{
            DbHelper dbHelper = new DbHelper(mContext,DbUtilitis.DATABASE_NAME,null,DbUtilitis.DATABASE_VERSION);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("titulo_nota",titulo);
            contentValues.put("fecha_nota",fecha);
            contentValues.put("description",description);
            id = db.insert(DbUtilitis.TABLE_NAME,null,contentValues);
        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }



}
