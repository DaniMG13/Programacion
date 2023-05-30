package com.vgsg.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DB extends SQLiteOpenHelper {

    private static final int version = 1;
    private static final String name = "eats";
    private static final String tabla = "carrito";

    public DB(@Nullable Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table "+tabla+" (id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "producto TEXT NOT NULL, descripcion TEXT NOT NULL, cantidad INTEGER NOT NULL, precio_uni FLOAT NOT NULL, total FLOAT NOT NULL) ";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void Eliminar(SQLiteDatabase db){
        db.execSQL("DELETE FROM "+tabla);
    }
}
