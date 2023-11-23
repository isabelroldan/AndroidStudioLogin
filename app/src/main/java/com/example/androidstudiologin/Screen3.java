package com.example.androidstudiologin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.regex.Pattern;


public class Screen3 extends AppCompatActivity {


    private EditText emailEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);


        emailEditText = findViewById(R.id.editTextTextEmailAddress);
        Button sendButton = findViewById(R.id.button2);


        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString().trim();
                if (isValidEmail(email)) {
                    Toast.makeText(Screen3.this, "Correo enviado a: " + email, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Screen3.this, "Por favor, introduce un correo electrónico válido", Toast.LENGTH_SHORT).show();
                }
            }
        });
        TextView loginTextView = findViewById(R.id.textView6);
        loginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la nueva Activity aquí
                Intent intent = new Intent(Screen3.this, Screen1.class); // Reemplaza OtraActivity con el nombre de tu siguiente actividad
                startActivity(intent);
            }
        });
    }



    private boolean isValidEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return !TextUtils.isEmpty(email) && pattern.matcher(email).matches();
    }
}
