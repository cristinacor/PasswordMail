package com.example.passwordmail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView txtSaludo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtSaludo = findViewById(R.id.txtSaludo);

        Bundle extras = getIntent().getExtras();
        String email = extras.getString("email","sin email");
        String nombre = extras.getString("nombre","sin nombre");
        String edad = extras.getString("edad","no años");

        txtSaludo.setText(" Hola "+ nombre + ", tienes "+
                edad+ " años  y tu correo elctronico es " +email);
    }
}
