package com.max.agendasql.Listeners;

import android.view.View;
import android.widget.ListView;

import com.max.agendasql.Dao.SqliteAgenda;
import com.max.agendasql.Interfaz.ListaVista;
import com.max.agendasql.Models.Agenda;

import java.util.ArrayList;

public class ListenerCheckBoxDni implements View.OnClickListener
{
    private SqliteAgenda sqliteAgenda;
    private ListaVista context;
    private ListView listView;
    private ArrayList<Agenda> agendaArrayList;

    public ListenerCheckBoxDni(ListaVista context, ListView listView, ArrayList<Agenda> agendaArrayList)
    {
        this.context = context;
        this.listView = listView;
        this.agendaArrayList = agendaArrayList;
    }

    @Override
    public void onClick(View view)
    {
        sqliteAgenda= new SqliteAgenda(context);
        agendaArrayList = new ArrayList<Agenda>();

        agendaArrayList = sqliteAgenda.getAgendaPorDNI();

        context.getAdapterAgenda().setAgendaArrayList(agendaArrayList);
        context.getAdapterAgenda().notifyDataSetChanged();
    }
}
