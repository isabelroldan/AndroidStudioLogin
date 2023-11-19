package com.example.androidstudiologin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Screen4 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen4);


        Spinner mySpinner = findViewById(R.id.menuDesplegable);

        // Crear una lista de datos
        List<String> listaDatos = new ArrayList<>();
        listaDatos.add("Usuario: "+getIntent().getStringExtra("usuario"));


        // Crear un ArrayAdapter y establecerlo en el Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaDatos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Establecer un tamaño de texto más grande para las opciones del Spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(adapter);
    }

    public void Logout(View view){
        Intent i = new Intent(this, Screen1.class);
        startActivity(i);
    }
}