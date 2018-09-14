package com.max.agendasql.Listeners;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.max.agendasql.Interfaz.Activity2;
import com.max.agendasql.Interfaz.Principal;

public class ListenerRegistrar implements View.OnClickListener {
    Principal context;

    public ListenerRegistrar(Principal context) {
        this.context = context;
    }

    @Override
    public void onClick(View view) {
        Intent intentRegistrar= new Intent(context, Activity2.class);
        intentRegistrar.putExtra("ID", 0);
        context.startActivity(intentRegistrar);
    }
}
