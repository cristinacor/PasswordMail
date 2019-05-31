package com.example.passwordmail.listados;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.passwordmail.R;
import com.example.passwordmail.dates.Nota;

import java.util.ArrayList;

public class ListadoNotasAdapter extends ArrayAdapter<Nota> {
    private ArrayList<Nota> listaNotas;
    private Context mContext;
    private int lastPosition = -1;

    public ListadoNotasAdapter(Context context, ArrayList<Nota> listaNotas) {
        super(context, R.layout.activity_listado_notas2,listaNotas);

        this.listaNotas = listaNotas;
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Nota nota = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_nota, parent, false);
        }
        // Lookup view for data population
        ImageView imageView= (ImageView) convertView.findViewById(R.id.imageView2);
        TextView txtFecha = (TextView) convertView.findViewById(R.id.txtFecha);
        TextView txtTexto = (TextView) convertView.findViewById(R.id.txtTexto);
        // Populate the data into the template view using the data object
        String[] categorias = nota.getCategorias();
        String categoria = nota.getCategoria();
        if(categoria.equalsIgnoreCase(categorias[0])){
            imageView.setImageResource(R.drawable.ic_nota_urgente);
        }
        else if(categoria.equalsIgnoreCase(categorias[1])){
            imageView.setImageResource((R.drawable.ic_nota_amarillo));
        }
        else{
            imageView.setImageResource(R.drawable.ic_nota_verde);
        }
        txtFecha.setText(nota.getFechatoString());
        txtTexto.setText(nota.getTexto());
        // Return the completed view to render on screen
        return convertView;
    }

}
