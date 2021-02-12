package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class PruebaInicioSesion extends AppCompatActivity {

    ImageButton elearning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_inicio_sesion);
    }


    public void passNewFormppa(View view) {
        Intent i = new Intent(this, NewsReportMenu.class);
        startActivity(i);
    }

    //e_learning boton
    public void elearning(View view){
        Intent i = new Intent(this, e_learning.class);
        startActivity(i);
    }
}