package com.example.passwordmail.dates;

import android.util.Log;

import java.util.Calendar;

public class Nota {
    private Calendar fecha;
    private String texto;
    private String categoria;
    private String[] categorias = {"urgente", "importante", "normal"};


    public Nota(String texto, String categoria) {
        this.fecha = Calendar.getInstance();
        this.texto = texto;
        this.categoria = comprobarCategoria(categoria);
    }

    private String comprobarCategoria(String cat) {
        String categoriaAux = "Normal";
        for (int i = 0; i < categorias.length; i++) {

            if (cat.equalsIgnoreCase(categorias[i])) {
                categoriaAux = categorias[i];

            }
        }

        return categoriaAux;
    }

    public String[] getCategorias() {
        return categorias;
    }

    public void setCategorias(String[] categorias) {
        this.categorias = categorias;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }


    public String getFechatoString() {

        return this.fecha.get(Calendar.DAY_OF_MONTH)+ "/"+ this.fecha.get(Calendar.MONTH)+"/"+ this.fecha.get(Calendar.YEAR);

    }
}

