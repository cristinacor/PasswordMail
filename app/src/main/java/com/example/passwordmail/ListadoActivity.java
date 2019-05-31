package com.example.passwordmail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListadoActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    //nos creamos una variable
    ListView listaPrueba;
    ArrayList<String> listaRobots;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        listaPrueba = findViewById(R.id.listado);
        listaRobots = new ArrayList<>();
        listaRobots.add("Margori");
        listaRobots.add("Lori JJ");
        listaRobots.add("Celia 3000");
        listaRobots.add("Connected0n");
        listaRobots.add("Ailoiu 7.0");
        listaRobots.add("Alpha bis 2");
        listaRobots.add("Margarita");
        listaRobots.add("Marcelier");
        listaRobots.add("Betty 5.0");
        listaRobots.add("Armani on");
        listaRobots.add("Michel lof");
        listaRobots.add("Crist 3.3");
        listaRobots.add("Juliana");
        listaRobots.add("Nico Mora");
        listaRobots.add("Aura mary");


        /*
        hay que definir un adaptador que se encarga de transformar
        todos los elementos del array y los va pintando
        como elementos del listview
        vamos a utilizar un adapatador por defecto
         */

        ArrayAdapter adaptador= new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaRobots);
        //vinculamos el listview y el adfpatador

        listaPrueba.setAdapter(adaptador);

        //definicion de eventos sobre los elmentos de la lista

        listaPrueba.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String robotSeleccionado = listaRobots.get(position);
        Toast.makeText(this,"Has elegido el robot " + robotSeleccionado,Toast.LENGTH_LONG).show();

    }
}
