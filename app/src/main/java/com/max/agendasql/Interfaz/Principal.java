package com.max.agendasql.Interfaz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

import com.max.agendasql.Listeners.ListenerRecycler;
import com.max.agendasql.Listeners.ListenerRegistrar;
import com.max.agendasql.Listeners.ListenerVerRegistro;
import com.max.agendasql.R;

public class Principal extends AppCompatActivity
{
    private Button botonRegistrar,botonVerListado,botonRecycler;
    private android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
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

        toolbar = findViewById(R.id.tolbar);

        setSupportActionBar(toolbar);

        getActionBar().setDisplayShowTitleEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setDisplayUseLogoEnabled(true);
        getActionBar().setLogo(R.drawable.images);
        getActionBar().setTitle("MI AGENDA");
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }
    @Override
        public boolean onOptionsItemSelected (MenuItem item)
    {
        //acciones android puras
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        //acciones del menu definido por el desarrollador
        switch (item.getItemId()) {
            case R.id.agregar_cli:

                Toast.makeText(this, "Agregar Cliente", Toast.LENGTH_SHORT).show();
                break;
            case R.id.salir:
                super.finish();
                break;
            default:
                break;
        }
        return true;
    }

}
