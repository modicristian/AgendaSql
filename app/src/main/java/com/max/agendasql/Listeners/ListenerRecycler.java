package com.max.agendasql.Listeners;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.max.agendasql.Interfaz.ListaVista;
import com.max.agendasql.Interfaz.Principal;
import com.max.agendasql.Interfaz.Recycler;

public class ListenerRecycler implements View.OnClickListener
{
    Principal context;

    public ListenerRecycler(Principal context)
    {
        this.context = context;
    }

    @Override
    public void onClick(View view)
    {
        Intent intent =new Intent(context,Recycler.class);//crear
        context.startActivity(intent);//iniciar
    }
}
