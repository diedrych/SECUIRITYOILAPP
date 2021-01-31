package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class e_learning extends AppCompatActivity {

    ImageView normativity;
    ImageView content;
    ImageView consider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_learning);
        //ir al menu normatividad
        normativity=findViewById(R.id.normativity);
        normativity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(e_learning.this, normativity.class));
            }
        });
        //ir al menu consejos de cuidado
        content=findViewById(R.id.care_tips);
        content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(e_learning.this, content.class));
            }
        });
        //ir al menu para tener en cuenta
        consider=findViewById(R.id.consider);
        consider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(e_learning.this, consider.class));
            }
        });
    }
}