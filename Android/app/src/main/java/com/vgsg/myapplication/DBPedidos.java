package com.vgsg.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBPedidos extends SQLiteOpenHelper {
    private static final int version = 1;
    private static final String name = "comid";
    private static final String tabla = "pedidos";

    public DBPedidos(@Nullable Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table "+tabla+" (id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "producto TEXT NOT NULL, fecha TEXT NOT NULL ,cantidad TEXT NOT NULL, precio_uni TEXT NOT NULL, sub_total TEXT NOT NULL ,total TEXT NOT NULL) ";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void Eliminar(SQLiteDatabase db){
        db.execSQL("DELETE FROM "+tabla);
    }
}
