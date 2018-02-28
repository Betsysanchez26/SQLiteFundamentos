package com.example.betsysanchez.sqlitefundamentos;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.betsysanchez.sqlitefundamentos.BD.ConexionSQLiteHelper;

public class MainActivity extends AppCompatActivity {
    ImageButton add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_contactos",null,1);
        add=findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nuevo = new Intent(getApplicationContext(), NuevoContacto.class);
                startActivity(nuevo);
            }
        });


    }
}
