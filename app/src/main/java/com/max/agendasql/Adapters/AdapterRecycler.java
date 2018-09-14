package com.max.agendasql.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.max.agendasql.Listeners.ListenerRecycler;
import com.max.agendasql.Models.Agenda;
import com.max.agendasql.R;

import java.util.ArrayList;

public class AdapterRecycler extends RecyclerView.Adapter
{
    private Context context;
    private ArrayList<Agenda> agendaArrayList;
    private ListenerRecycler listenerRecycler;

    public AdapterRecycler(Context context,ArrayList<Agenda> agendaArrayList)
    {
        this.context = context;
        this.agendaArrayList = agendaArrayList;
        this.listenerRecycler = new ListenerRecycler();

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        View viewDelacelda = inflater.inflate(R.layout.celdas,parent,false);
        viewDelacelda.setOnClickListener(listenerRecycler);

        AgendaViewHolder agendaViewHolder = new AgendaViewHolder(viewDelacelda);

        return agendaViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
    {
        Agenda unAgenda =  agendaArrayList.get(position);
        AgendaViewHolder agendaViewHolder = (AgendaViewHolder)holder;
        agendaViewHolder.cargarAgenda(unAgenda);
    }

    @Override
    public int getItemCount()
    {
        return agendaArrayList.size();
    }


    private class AgendaViewHolder extends RecyclerView.ViewHolder
    {
        private TextView nombre,apellido,telefono,dni,calle,altura,pisoDto,email;

        public AgendaViewHolder(@NonNull View itemView)
        {
            super(itemView);
            nombre = itemView.findViewById(R.id.tv1);
            apellido = itemView.findViewById(R.id.tv2);
            telefono = itemView.findViewById(R.id.tv3);
            dni = itemView.findViewById(R.id.tv4);
            calle = itemView.findViewById(R.id.tv5);
            altura = itemView.findViewById(R.id.tv6);
            pisoDto = itemView.findViewById(R.id.tv7);
            email = itemView.findViewById(R.id.tv8);
        }

        public void cargarAgenda (Agenda unaAgenda)
        {
            nombre.setText(unaAgenda.getNombre());
            apellido.setText(unaAgenda.getApellido());
            telefono.setText(unaAgenda.getTelefono());
            dni.setText(unaAgenda.getDni());
            calle.setText(unaAgenda.getCalle());
            altura.setText(unaAgenda.getAltura());
            pisoDto.setText(unaAgenda.getPisoDto());
            email.setText(unaAgenda.getEmail());
        }
    }
}
