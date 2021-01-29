package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class e_learning extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_learning);
    }

    //ir al menu normatividad
    public void Normativity(View view){
        Intent Normativity = new Intent(this, normativity.class);
        startActivity(Normativity);
    }
}