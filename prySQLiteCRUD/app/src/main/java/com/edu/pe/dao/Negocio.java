package com.edu.pe.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.edu.pe.clases.Departamento;

import java.util.ArrayList;
import java.util.List;

public class Negocio {
    HelpSql  obj;
    SQLiteDatabase conex;

    public Negocio(Context contexto){
        obj=new HelpSql(contexto);
    }

    public void AbrirConexion(){
        conex=obj.getWritableDatabase();
    }

    public long Adicion(Departamento p){
        ContentValues ct=new ContentValues();

        ct.put("cliente",p.getCliente());
        ct.put("tipo_depar",p.getTipo());
        ct.put("anios",p.getAnios());

        long res= conex.insert("departamento",null,ct);
        return  res;
    }

    public List<Departamento>  listado(){
        List<Departamento> lista=new ArrayList<>();
        Cursor c=null;
        c=conex.rawQuery("select * from departamento",null);

        while(c.moveToNext()){
            Departamento p=new Departamento();
            p.setNro(c.getInt(0));
            p.setCliente(c.getString(1));
            p.setTipo(c.getInt(2));
            p.setAnios(c.getInt(3));
            lista.add(p);
        }
        return lista;
    }

    public Departamento Consulta(String nro){
        Departamento p=null;
        Cursor c=null;
        String parametros[]={nro};
        c=conex.rawQuery("select * from departamento where nro=?",parametros);

        while(c.moveToNext()){
            p=new Departamento();
            p.setNro(c.getInt(0));
            p.setCliente(c.getString(1));
            p.setTipo(c.getInt(2));
            p.setAnios(c.getInt(3));
        }
        return p;
    }

    public int Eliminar(String nro){
        int res = 0;
        Object parametros[] = {nro};
        try{
            res = (int) conex.delete("departamento","nro="+nro,null);
            //conex.execSQL("delete from departamento where nro =?" , parametros);
        }catch (Exception e){
        }
        return res;
    }
}
