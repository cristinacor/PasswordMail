package com.example.passwordmail;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    EditText edtNombre;
    EditText edtEmail;
    EditText edtPassword;
    EditText edtEdad;
    Button btnEntrar;
    CheckBox checkRecordar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNombre= findViewById(R.id.edtNombre);
        edtEmail = findViewById(R.id.editEmail);
        edtPassword = findViewById(R.id.editPassword);
        edtEdad = findViewById(R.id.editEdad);
        btnEntrar = findViewById(R.id.btnentrar);
        checkRecordar= findViewById(R.id.checkRecordar);
        SharedPreferences prefs = getSharedPreferences("mis preferencias",
                Context.MODE_PRIVATE);

        edtEmail.setText(prefs.getString("email",""));
        edtPassword.setText(prefs.getString("password",""));
        edtNombre.setText(prefs.getString("nombre",""));
        edtEdad.setText(prefs.getString("edad",""));


        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoNombre = edtNombre.getText().toString();
                String textoEmail= edtEmail.getText().toString();
                String textoPass = edtPassword.getText().toString();
                String textoEdad = edtEdad.getText().toString();
                boolean correcto = true;

                if(textoEdad.isEmpty()){
                    edtEdad.setError("Debes de introducir tu edad");
                    correcto= false;
                }if(textoNombre.isEmpty()){
                    edtNombre.setError("Debes introducir tu nombre ");
                    correcto= false;
                }

                if(textoEmail.isEmpty()){
                    edtEmail.setError("Tienes que introducir un correo");
                    correcto = false;
                }
                if(textoPass.isEmpty()){
                    edtPassword.setError("Tienes que introducir una contraseña ");
                    correcto = false;
                }
                if(correcto){


                    Intent intent = new Intent(MainActivity.this,
                            Main2Activity.class);
                    intent.putExtra("email",textoEmail);
                    intent.putExtra("nombre",textoNombre);
                    intent.putExtra("edad",textoEdad);
                    startActivity(intent);
                }

            }
        });

    }
    @Override//esto es para combrobar el estado en que se encuntra lo que hemos creado
    protected void onStart() {
        super.onStart();
        // The activity is about to become visible.
        Log.i("COMPROBANDO","ejecuta onStart");

    }
    @Override
    protected void onResume() {
        super.onResume();
        // The activity has become visible (it is now "resumed").
        Log.i("COMPROBANDO","ejecuta onResume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        // Another activity is taking focus (this activity is about to be "paused").
        Log.i("COMPROBANDO","ejecuta onPause");
        if(checkRecordar.isChecked()){
            SharedPreferences pref = getSharedPreferences("mis preferencias", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor= pref.edit();
            editor.putString("email",edtEmail.getText().toString());
            editor.putString("password",edtPassword.getText().toString());
            editor.putString("nombre",edtNombre.getText().toString());
            editor.putString("edad",edtEdad.getText().toString());

            editor.commit();
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        // The activity is no longer visible (it is now "stopped")
        Log.i("COMPROBANDO","ejecuta onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // The activity is about to be destroyed.
        Log.i("COMPROBANDO","ejecuta onDestroy");
    }
}

