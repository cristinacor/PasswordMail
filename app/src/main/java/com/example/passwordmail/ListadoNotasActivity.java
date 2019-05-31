package com.example.passwordmail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.passwordmail.dates.Nota;
import com.example.passwordmail.listados.ListadoNotasAdapter;

import java.util.ArrayList;

public class ListadoNotasActivity extends AppCompatActivity {
    ListView listaNota;
    ArrayList <Nota> listaNotas;
    ListadoNotasAdapter listadoNotasAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_notas2);
        listaNota = findViewById(R.id.listaNotas);
        listaNotas = new ArrayList<>();

        listaNotas.add(new Nota("comprar verdura","normal"));
        listaNotas.add(new Nota("visitar a la abuela","urgente"));
        listaNotas.add(new Nota("ir al medico","importante"));
        listaNotas.add(new Nota("reagar las plantas ","normal"));
        listaNotas.add(new Nota("comprar carne","normal"));

       listadoNotasAdapter = new ListadoNotasAdapter(this, listaNotas);
       listaNota.setAdapter(listadoNotasAdapter);

    }
}
