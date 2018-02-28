package com.example.betsysanchez.sqlitefundamentos;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.betsysanchez.sqlitefundamentos.BD.ConexionSQLiteHelper;
import com.example.betsysanchez.sqlitefundamentos.utilidades.utilidades;

/**
 * Created by BetsySanchez on 26/02/2018.
 */

public class NuevoContacto extends AppCompatActivity {
    EditText nombre;
    EditText telefono;
 //   EditText id;
    Button reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevo_contacto);
     //   id=findViewById(R.id.id);
        nombre=findViewById(R.id.nombre);
        telefono=findViewById(R.id.telefono);
        reg=findViewById(R.id.registrar);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarContactos();
                finish();
                Intent i=new Intent(NuevoContacto.this,MainActivity.class);
                startActivity(i);
            }
        });
    }

    private void registrarContactos() {
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this);
        SQLiteDatabase db=conn.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(utilidades.campo_nombre,nombre.getText().toString());
        values.put(utilidades.campo_telefono,telefono.getText().toString());

        Long idRsultante=db.insert(utilidades.TablaContacto, utilidades.campo_id,values);
        Toast.makeText(getApplicationContext(),"Id Registro: "+idRsultante,Toast.LENGTH_SHORT).show();
    }
}
