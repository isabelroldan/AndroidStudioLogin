package com.example.androidstudiologin;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.text.TextUtils;
import android.util.Patterns;

public class Screen2 extends AppCompatActivity {
    private boolean isLightTheme = true;

    private EditText emailEditText, userEditText, passwordEditText;
    private Button entrarButton;
    private boolean isEnglish = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.comp_text9);
        userEditText = findViewById(R.id.comp_text2);
        passwordEditText = findViewById(R.id.comp_passw9);
        entrarButton = findViewById(R.id.button8);

        entrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateFields()) {
                    Intent intent = new Intent(Screen2.this, Screen3.class);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean validateFields() {
        boolean isValid = true;

        String email = emailEditText.getText().toString().trim();
        String user = userEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            emailEditText.setError("Ingrese su correo electrónico");
            isValid = false;
            Toast.makeText(Screen2.this, "Ingrese su correo electrónico", Toast.LENGTH_SHORT).show();
        } else if (!isValidEmail(email)) {
            emailEditText.setError("Ingrese un correo electrónico válido");
            isValid = false;
            Toast.makeText(Screen2.this, "Ingrese un correo electrónico válido", Toast.LENGTH_SHORT).show();
        }

        if (TextUtils.isEmpty(user)) {
            userEditText.setError("Ingrese su usuario");
            isValid = false;
            Toast.makeText(Screen2.this, "Ingrese su usuario", Toast.LENGTH_SHORT).show();
        }

        if (TextUtils.isEmpty(password)) {
            passwordEditText.setError("Ingrese su contraseña");
            isValid = false;
            Toast.makeText(Screen2.this, "Ingrese su contraseña", Toast.LENGTH_SHORT).show();
        } else if (password.length() < 6) {
            passwordEditText.setError("La contraseña debe tener al menos 6 caracteres");
            isValid = false;
            Toast.makeText(Screen2.this, "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show();
        }

        return isValid;
    }


    private boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }



}
