package com.example.androidstudiologin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Screen1 extends AppCompatActivity {

    private EditText metName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen1);

        metName = (EditText) findViewById(R.id.usuario);
    }

    public void LogIn(View view){
        Intent i = new Intent(this, Screen4.class);

        i.putExtra("usuario", metName.getText().toString());

        startActivity(i);

    }

    public void newUser(View view){
        Intent i = new Intent(this, Screen2.class);
        startActivity(i);
    }

    public void forgotPassword(View view){
        Intent i = new Intent(this, Screen3.class);
        startActivity(i);
    }
}