package com.example.betsysanchez.sqlitefundamentos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;

import java.sql.SQLException;

/**
 * Created by BetsySanchez on 26/02/2018.
 */

public class DBAdapter extends RecyclerView.Adapter<DBAdapter.RecyclerViewHolder>{
    private String [][] data;

    public DBAdapter(String[][] data) {
        this.data = data;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contactos,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.nombre.setText(data[position][1]);
        holder.telefono.setText(data[position][2]+"");
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView nombre,telefono;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            nombre=itemView.findViewById(R.id.nombreContacto);
            telefono=itemView.findViewById(R.id.numContacto);
        }
    }
}
