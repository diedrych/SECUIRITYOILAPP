package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.net.HttpURLConnection;
import java.net.URL;

public class normativity extends AppCompatActivity {

    ImageView dowload_rule_100;
    ImageView dowload_rule_1072;
    ImageView dowload_rule_614;
    ImageView dowload_rule_1281;
    ImageView dowload_rule_1295;
    ImageView dowload_rule_2400;
    ImageView dowload_rule_1016;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normativity);
        dowload_rule_100=(ImageView)findViewById(R.id.dowload_rule_100);
        dowload_rule_100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String MY_URL = "https://www.minsalud.gov.co/sites/rid/Lists/BibliotecaDigital/RIDE/DE/DIJ/ley-100-de-1993.pdf";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(MY_URL)));

            }
        });
        dowload_rule_1072=(ImageView)findViewById(R.id.dowload_rule_1072);
        dowload_rule_1072.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String MY_URL = "https://www.mintrabajo.gov.co/documents/20147/0/DUR+Sector+Trabajo+Actualizado+a+15+de+abril++de+2016.pdf/a32b1dcf-7a4e-8a37-ac16-c121928719c8";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(MY_URL)));
            }
        });
        dowload_rule_614=(ImageView)findViewById(R.id.dowload_rule_614);
        dowload_rule_614.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String MY_URL = "http://copaso.upbbga.edu.co/legislacion/decreto_614%2084%20Organizacion%20y%20Administracion%20Salud%20Ocupacional.pdf";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(MY_URL)));
            }
        });
        dowload_rule_1281=(ImageView)findViewById(R.id.dowload_rule_1281);
        dowload_rule_1281.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String MY_URL = "https://normativa.colpensiones.gov.co/colpens/docs/pdf/decreto_1281_1994.pdf";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(MY_URL)));
            }
        });
        dowload_rule_1295=(ImageView)findViewById(R.id.dowload_rule_1295);
        dowload_rule_1295.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String MY_URL = "http://www.unipamplona.edu.co/unipamplona/portalIG/home_54/recursos/01general/04122012/decreto_1295_1994.pdf";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(MY_URL)));
            }
        });
        dowload_rule_2400=(ImageView)findViewById(R.id.dowload_rule_2400);
        dowload_rule_2400.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String MY_URL = "http://copaso.upbbga.edu.co/legislacion/Res.2400-1979.pdf";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(MY_URL)));
            }
        });
        dowload_rule_1016=(ImageView)findViewById(R.id.dowload_rule_1016);
        dowload_rule_1016.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String MY_URL = "http://copaso.upbbga.edu.co/legislacion/Resolucion%201016%20de%2089.%20Progrmas%20de%20Salud%20Ocupacional.pdf";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(MY_URL)));
            }
        });
        }
}