package com.example.androidstudiologin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Locale;

public class Screen1 extends AppCompatActivity {

    private EditText metName;
    private EditText metPassword;



    /*private SharedPreferences sharedPreferences;*/
    private SharedPreferences sharedPreferences;

    private Switch switchTheme;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen1);

        metName = (EditText) findViewById(R.id.usuario);
        metPassword = (EditText) findViewById(R.id.contraseña);

        /*sharedPreferences =  PreferenceManager.getDefaultSharedPreferences(this);

        ToggleButton toggleIdioma = findViewById(R.id.toggleIdioma);
        toggleIdioma.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                cambiarIdioma("es");
            } else {
                cambiarIdioma("en");
            }
        });*/

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        ToggleButton toggleIdioma = findViewById(R.id.toggleIdioma);
        toggleIdioma.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                cambiarIdioma("es");
            } else {
                cambiarIdioma("en");
            }
        });

        switchTheme = findViewById(R.id.switch1);
        switchTheme.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // Cambiar a tema oscuro
                setDarkTheme();
            } else {
                // Cambiar a tema claro
                setLightTheme();
            }
        });

        // Aplicar el tema inicial
        if (switchTheme.isChecked()) {
            setDarkTheme();
        } else {
            setLightTheme();
        }
    }


    private void cambiarIdioma(String idioma) {
        // Guardar el idioma seleccionado en SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("idioma", idioma);
        editor.apply();

        // Obtener la configuración actual
        Configuration config = getResources().getConfiguration();

        // Establecer el nuevo idioma
        Locale locale = new Locale(idioma);
        Locale.setDefault(locale);
        config.locale = locale;

        // Actualizar la configuración de recursos
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());

        // Actualizar las vistas manualmente (puedes poner todas las actualizaciones necesarias aquí)
        actualizarVistas();
    }

    private void actualizarVistas() {
        // Actualizar cada vista que pueda cambiar con el cambio de idioma
        TextView textViewBienvenido = findViewById(R.id.textView);
        textViewBienvenido.setText(R.string.bienvenido);

        EditText editTextUsuario = findViewById(R.id.usuario);
        editTextUsuario.setHint(R.string.usuario);

        EditText editTextContraseña = findViewById(R.id.contraseña);
        editTextContraseña.setHint(R.string.contraseña);

        // Añade las siguientes líneas para los elementos adicionales
        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setText(R.string.entrar);

        TextView textViewContraseñaOlvidada = findViewById(R.id.textView2);
        textViewContraseñaOlvidada.setText(R.string.contraseñaOlvidada);

        TextView textViewNuevoUsuario = findViewById(R.id.textView3);
        textViewNuevoUsuario.setText(R.string.nuevoUsuario);
    }
    /*private void cambiarIdioma(String idioma) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("idioma", idioma);
        editor.apply();

        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }*/

    /*@Override
    protected void attachBaseContext(Context newBase) {
        // Cambiar el contexto de la aplicación para reflejar el nuevo idioma
        String idioma = sharedPreferences.getString("idioma", "en");
        Locale locale = new Locale(idioma);
        Configuration config = new Configuration(newBase.getResources().getConfiguration());
        Locale.setDefault(locale);
        config.setLocale(locale);
        super.attachBaseContext(newBase.createConfigurationContext(config));
    }*/

    private void setDarkTheme() {
        // Cambiar el fondo a negro y el texto a blanco
        getWindow().getDecorView().setBackgroundColor(ContextCompat.getColor(this, R.color.black));

        // Cambiar el color del texto según el estado del interruptor
        int textColor = ContextCompat.getColor(this, R.color.white);

        // Actualizar cada vista que pueda cambiar con el cambio de tema
        TextView textViewBienvenido = findViewById(R.id.textView);
        textViewBienvenido.setTextColor(textColor);

        EditText editTextUsuario = findViewById(R.id.usuario);
        editTextUsuario.setHintTextColor(textColor);

        EditText editTextContraseña = findViewById(R.id.contraseña);
        editTextContraseña.setHintTextColor(textColor);

        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setTextColor(textColor);

        TextView textViewContraseñaOlvidada = findViewById(R.id.textView2);
        textViewContraseñaOlvidada.setTextColor(textColor);

        TextView textViewNuevoUsuario = findViewById(R.id.textView3);
        textViewNuevoUsuario.setTextColor(textColor);
    }

    private void setLightTheme() {
        // Cambiar el fondo a blanco y el texto a negro
        getWindow().getDecorView().setBackgroundColor(ContextCompat.getColor(this, R.color.white));

        // Cambiar el color del texto según el estado del interruptor
        int textColor = ContextCompat.getColor(this, R.color.black);

        // Actualizar cada vista que pueda cambiar con el cambio de tema
        TextView textViewBienvenido = findViewById(R.id.textView);
        textViewBienvenido.setTextColor(textColor);

        EditText editTextUsuario = findViewById(R.id.usuario);
        editTextUsuario.setHintTextColor(textColor);

        EditText editTextContraseña = findViewById(R.id.contraseña);
        editTextContraseña.setHintTextColor(textColor);

        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setTextColor(textColor);

        TextView textViewContraseñaOlvidada = findViewById(R.id.textView2);
        textViewContraseñaOlvidada.setTextColor(textColor);

        TextView textViewNuevoUsuario = findViewById(R.id.textView3);
        textViewNuevoUsuario.setTextColor(textColor);
    }

    public void LogIn(View view){

        String usuario = metName.getText().toString();

        String password = metPassword.getText().toString();

        if(usuario.length()==0){
            Toast.makeText(this, "Falta el usuario", Toast.LENGTH_SHORT).show();
        }
        if(usuario == null){
            Toast.makeText(this, "Falta el usuario", Toast.LENGTH_SHORT).show();
        }
        if(password.length()==0){
            Toast.makeText(this, "Falta la contraseña", Toast.LENGTH_SHORT).show();
        }
        if(password==null){
            Toast.makeText(this, "Falta la contraseña", Toast.LENGTH_SHORT).show();
        }
        if(usuario.length()!=0 && password.length()!=0){
            Toast.makeText(this, "Login correcto", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(this, Screen4.class);

            i.putExtra("usuario", metName.getText().toString());

            startActivity(i);
        }
        if(usuario=="usuario" && password=="contraseña"){
            Toast.makeText(this, "Login correcto", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(this, Screen4.class);

            i.putExtra("usuario", metName.getText().toString());

            startActivity(i);
        }



    }

    /*public void newUser(View view){
        Intent i = new Intent(this, Screen2.class);
        startActivity(i);
    }

    public void forgotPassword(View view){
        Intent i = new Intent(this, Screen3.class);
        startActivity(i);
    }*/
}