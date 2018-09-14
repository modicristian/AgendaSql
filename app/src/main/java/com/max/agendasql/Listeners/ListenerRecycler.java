package com.max.agendasql.Listeners;

import android.content.Intent;
import android.view.View;

import com.max.agendasql.Interfaz.ListaVista;
import com.max.agendasql.Interfaz.Principal;

public class ListenerRecycler implements View.OnClickListener
{
    Principal context;

    public ListenerRecycler()
    {
        this.context = context;
    }

    @Override
    public void onClick(View view)
    {
        Intent intent =new Intent(context,ListaVista.class);//crear
        context.startActivity(intent);//iniciar
    }
}
