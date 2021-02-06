package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;

public class popuphands extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popuphands);

        DisplayMetrics windowsmeasures = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(windowsmeasures);

        int width = windowsmeasures.widthPixels;
        int tall = windowsmeasures.heightPixels;

        getWindow().setLayout((int)(width*0.85),(int)(tall*0.5));

    }
}