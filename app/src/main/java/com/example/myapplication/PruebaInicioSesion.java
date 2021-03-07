package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class PruebaInicioSesion extends AppCompatActivity {

    ImageButton imageButton6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_inicio_sesion);

        imageButton6 = findViewById(R.id.imageButton6);

        imageButton6.setOnClickListener(v ->{
            Intent intent = new Intent(this, ReportsActivity.class);
        });
    }
}