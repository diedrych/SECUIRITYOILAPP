package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class content extends AppCompatActivity {

    ImageView hands;
    ImageView focus;
    ImageView machinery;
    ImageView query;
    ImageView cleaning;
    ImageView warn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        hands=(ImageView)findViewById(R.id.hands);
        hands.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hands = new Intent(content.this, popuphands.class);
                startActivity(hands);

            }
        });
        focus=(ImageView)findViewById(R.id.focus);
        focus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent focus = new Intent(content.this, popupfocus.class);
                startActivity(focus);

            }
        });
        machinery=(ImageView)findViewById(R.id.machinery);
        machinery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent machinery = new Intent(content.this, popupmachinery.class);
                startActivity(machinery);

            }
        });
        query=(ImageView)findViewById(R.id.query);
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent query = new Intent(content.this, popupquery.class);
                startActivity(query);

            }
        });
        cleaning=(ImageView)findViewById(R.id.cleaning);
        cleaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cleaning = new Intent(content.this, popupcleaning.class);
                startActivity(cleaning);

            }
        });
        warn=(ImageView)findViewById(R.id.warn);
        warn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent warn = new Intent(content.this, popupwarn.class);
                startActivity(warn);

            }
        });

    }
}