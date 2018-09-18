package com.max.agendasql.Interfaz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.ListView;
import com.max.agendasql.Adapters.AdapterAgenda;
import com.max.agendasql.Dao.SqliteAgenda;
import com.max.agendasql.Listeners.ListenerCheckBoxNombre;
import com.max.agendasql.Models.Agenda;
import com.max.agendasql.R;
import java.util.ArrayList;

public class ListaVista extends AppCompatActivity {
    private SqliteAgenda sqliteAgenda;
    private ArrayList<Agenda>agendaArrayList;
    private AdapterAgenda adapterAgenda;
    private ListView listViewAgenda;
    private ListenerCheckBoxNombre listenerCheckBoxNombre;
    private CheckBox checkBoxNombre, checkBoxDni;

    public AdapterAgenda getAdapterAgenda() {
        return adapterAgenda;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        checkBoxNombre = findViewById(R.id.checkboxNombre);

        listViewAgenda=findViewById(R.id.ListaAgenda);

        sqliteAgenda=new SqliteAgenda(this);
        agendaArrayList=sqliteAgenda.getAgenda();
        adapterAgenda= new AdapterAgenda(this, agendaArrayList, listViewAgenda);

        listViewAgenda.setAdapter(adapterAgenda);

        ListenerCheckBoxNombre listenerCheckBoxNombre = new ListenerCheckBoxNombre(this,listViewAgenda,agendaArrayList);
        checkBoxNombre.setOnClickListener(listenerCheckBoxNombre);


    }
}
