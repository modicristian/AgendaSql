package com.max.agendasql.Listeners;

import android.view.View;
import android.widget.ListView;

import com.max.agendasql.Dao.SqliteAgenda;
import com.max.agendasql.Interfaz.ListaVista;
import com.max.agendasql.Interfaz.Principal;
import com.max.agendasql.Models.Agenda;

import java.util.ArrayList;

public class ListenerCheckBoxNombre implements View.OnClickListener
{
    private SqliteAgenda sqliteAgenda;
    private ListaVista context;
    private ListView listView;
    private ArrayList<Agenda> agendaArrayList;

    public ListenerCheckBoxNombre(ListaVista context, ListView listView, ArrayList<Agenda> agendaArrayList)
    {
        this.context = context;
        this.listView = listView;
        this.agendaArrayList = agendaArrayList;
    }

    @Override
    public void onClick(View view)
    {
        sqliteAgenda= new SqliteAgenda(context);
        ArrayList<Agenda> agendaArrayList = new ArrayList<Agenda>();

        agendaArrayList = sqliteAgenda.getAgendaPorNombre();

        context.getAdapterAgenda().setAgendaArrayList(agendaArrayList);
        context.getAdapterAgenda().notifyDataSetChanged();

    }
}
