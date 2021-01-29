package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //siguiente boton
    public void reportMenu(View view){
        Intent reportMenu = new Intent(this, NewsReportMenu.class);
        startActivity(reportMenu);
    }

    //e_learning boton
    public void ELearning(View view){
        Intent ELearning = new Intent(this, e_learning.class);
        startActivity(ELearning);
    }
}