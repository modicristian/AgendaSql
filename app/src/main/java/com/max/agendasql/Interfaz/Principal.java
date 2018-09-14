package com.max.agendasql.Interfaz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.max.agendasql.Listeners.ListenerRecycler;
import com.max.agendasql.Listeners.ListenerRegistrar;
import com.max.agendasql.Listeners.ListenerVerRegistro;
import com.max.agendasql.R;

public class Principal extends AppCompatActivity
{
    private Button botonRegistrar,botonVerListado,botonRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        botonRegistrar=findViewById(R.id.botonRegistrar);
        botonVerListado=findViewById(R.id.botonVerListado);
        botonRecycler=findViewById(R.id.botonRecycler);

        ListenerRegistrar listenerRegistrar=new ListenerRegistrar(this);
        ListenerVerRegistro listenerVerRegistro=new ListenerVerRegistro(this);
        ListenerRecycler listenerRecycler = new ListenerRecycler(this);

        botonRegistrar.setOnClickListener(listenerRegistrar);
        botonVerListado.setOnClickListener(listenerVerRegistro);
        botonRecycler.setOnClickListener(listenerRecycler);
    }
}
