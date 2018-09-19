package com.max.agendasql.Interfaz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.max.agendasql.Adapters.AdapterRecycler;
import com.max.agendasql.Dao.SqliteAgenda;
import com.max.agendasql.Models.Agenda;
import com.max.agendasql.R;

import java.util.ArrayList;

public class Recycler extends AppCompatActivity
{
    private SqliteAgenda sqliteAgenda;
    private ArrayList<Agenda> agendaArrayList;
    private AdapterRecycler adapterRecycler;
    private RecyclerView recyclerViewAgenda;

    public ArrayList<Agenda> getAgendaArrayList() {
        return agendaArrayList;
    }

    public RecyclerView getRecyclerView() {
        return recyclerViewAgenda;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recyclerViewAgenda = findViewById(R.id.recycler);

        sqliteAgenda = new SqliteAgenda(this);
        agendaArrayList = sqliteAgenda.getAgenda();
        adapterRecycler = new AdapterRecycler(this,agendaArrayList,recyclerViewAgenda);
        recyclerViewAgenda.setAdapter(adapterRecycler);
        recyclerViewAgenda.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerViewAgenda.setHasFixedSize(true);

    }
}
