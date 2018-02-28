package com.example.betsysanchez.sqlitefundamentos;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.betsysanchez.sqlitefundamentos.BD.ConexionSQLiteHelper;

public class MainActivity extends AppCompatActivity {
    ImageButton add;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this);
        recyclerView = findViewById(R.id.recycler);
        String [][] a = conn.consultar("Select * from contacto");
        adapter = new DBAdapter(a);
        layoutManager = new LinearLayoutManager(this);
        add=findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent nuevo = new Intent(getApplicationContext(), NuevoContacto.class);
                startActivity(nuevo);
            }
        });

        recyclerView.setLayoutManager(layoutManager);
        //recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.getAdapter().notifyDataSetChanged();
    }
}
