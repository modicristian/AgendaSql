package com.max.agendasql.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import com.max.agendasql.Interfaz.ListaVista;
import com.max.agendasql.Listeners.ListenerImageBorrar;
import com.max.agendasql.Listeners.ListenerImagenEditar;
import com.max.agendasql.Models.Agenda;
import com.max.agendasql.R;
import java.util.ArrayList;

public class AdapterAgenda extends BaseAdapter {
    private ListaVista context;
    private ArrayList<Agenda> agendaArrayList;
    private ListView listView;
    private ListenerImageBorrar listenerImageBorrar;
    private ListenerImagenEditar listenerImagenEditar;

    public AdapterAgenda(ListaVista context, ArrayList<Agenda> agendaArrayList, ListView listView) {
        this.context = context;
        this.agendaArrayList = agendaArrayList;
        this.listView = listView;
    }

    public void setAgendaArrayList(ArrayList<Agenda> agendaArrayList) {
        this.agendaArrayList = agendaArrayList;
    }

    @Override
    public int getCount() {
        return agendaArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return agendaArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View v, ViewGroup vGroup) {
        LayoutInflater milayoutInflater;
        milayoutInflater = (LayoutInflater) this.context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        v = milayoutInflater.inflate(R.layout.celdas, vGroup, false);
        
        TextView nombre, apellido, telefono, dni,email, calle, altura, pisoDto;
        ImageButton imageButton,imagenBotonEditar;

        imagenBotonEditar=v.findViewById(R.id.imagenBotonEditar);
        imageButton=v.findViewById(R.id.imageButtonBorrar);
        nombre = v.findViewById(R.id.tv1);
        apellido = v.findViewById(R.id.tv2);
        telefono = v.findViewById(R.id.tv3);
        dni = v.findViewById(R.id.tv4);
        email=v.findViewById(R.id.tv5);
        calle = v.findViewById(R.id.tv6);
        altura = v.findViewById(R.id.tv7);
        pisoDto = v.findViewById(R.id.tv8);

        listenerImageBorrar= new ListenerImageBorrar(context,listView,agendaArrayList);
        imageButton.setOnClickListener(listenerImageBorrar);
        listenerImagenEditar=new ListenerImagenEditar(context,listView,agendaArrayList);
        imagenBotonEditar.setOnClickListener(listenerImagenEditar);
        //agregar new objeto de editar
        //agregar seteo de boton
        
        nombre.setText(agendaArrayList.get(i).getNombre());
        apellido.setText(agendaArrayList.get(i).getApellido());
        telefono.setText(String.valueOf(agendaArrayList.get(i).getTelefono()));
        dni.setText(String.valueOf(agendaArrayList.get(i).getDni()));
        email.setText(agendaArrayList.get(i).getEmail());
        calle.setText(agendaArrayList.get(i).getCalle());
        altura.setText(String.valueOf(agendaArrayList.get(i).getAltura()));
        pisoDto.setText(String.valueOf(agendaArrayList.get(i).getPisoDto()));

        return v;
    }
}
