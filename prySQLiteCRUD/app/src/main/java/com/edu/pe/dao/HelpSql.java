package com.edu.pe.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class HelpSql extends SQLiteOpenHelper {
    public static int version = 1;

    public static final String base = "bddepartmento.db";

    public static final String tabla1 = "create table Departamento(" +
                                "nro Integer primary key autoincrement," +
                                "cliente text," +
                                "tipo_depar Integer, " +
                                "anios Integer)";

    public HelpSql(@Nullable Context context) {
        super(context, base, null, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Departamento ");
        Log.w("Mensaje","actualizando la "+oldVersion+" con la nueva "+newVersion);
        db.execSQL(tabla1);
    }
}
