package com.example.betsysanchez.sqlitefundamentos.BD;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.betsysanchez.sqlitefundamentos.NuevoContacto;
import com.example.betsysanchez.sqlitefundamentos.utilidades.utilidades;

/**
 * Created by BetsySanchez on 26/02/2018.
 */

public class ConexionSQLiteHelper extends SQLiteOpenHelper {
    private SQLiteDatabase db=getWritableDatabase();
    private static final String name="bd_contactos.db";
    public ConexionSQLiteHelper(Context context) {
        super(context, name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(utilidades.crearTablaContacto);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS CONTACTO");
        onCreate(db);
    }
    public String[][] consultar(String sql){
        Cursor c = db.rawQuery(sql,null);
        String [][] elementos = new String [c.getCount()][c.getColumnCount()];
        if (c.moveToFirst()){
            int contador=0;
            do{
                elementos[contador][0]=c.getString(c.getColumnIndex("id"));
                elementos[contador][1]=c.getString(c.getColumnIndex("nombre"));
                elementos[contador][2]=c.getString(c.getColumnIndex("telefono"));
                contador++;
            }while(c.moveToNext());
        }
        if(c!=null){c.close();}
        return elementos;
    }
}
