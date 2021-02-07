package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity<EdicText, EdiText> extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //siguiente boton
    public void reportMenu(View view) {
        Intent reportMenu = new Intent(this, NewsReportMenu.class);
        startActivity(reportMenu);
    }


    //e_learning boton
    public void ELearning(View view) {
        Intent ELearning = new Intent(this, e_learning.class);
        startActivity(ELearning);
    }

    // boton inicio de sesion
    public void iniciar(View View) {
        Intent iniciar = new Intent(this, Iniciarsesion.class);
        startActivity(iniciar);

    }

}
