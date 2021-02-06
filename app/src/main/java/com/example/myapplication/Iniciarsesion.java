package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Iniciarsesion extends AppCompatActivity {

    private EditText txtuser1;
    private EditText txtpass1;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciarsesion);

        txtuser1 = findViewById(R.id.txtuser1);
        txtpass1 = findViewById(R.id.txtpass1);

        mAuth = FirebaseAuth.getInstance();
    }

    public void onStart(){
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    public void iniciamos ( View View){

        mAuth.signInWithEmailAndPassword(txtuser1.getText().toString(), txtpass1.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Iniciarsesion.this, "Inicio Exitoso",
                                    Toast.LENGTH_SHORT).show();

                            siguiente(View );

                            FirebaseUser user = mAuth.getCurrentUser();

                        } else {

                            Toast.makeText(Iniciarsesion.this, "No puedes iniciar sesión.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });



    }
    public void navegar (View View){
        Intent navegar = new Intent (this, RegistroUsuarios.class);
        startActivity(navegar);

    }

    public void siguiente(View View){
        Intent siguiente = new Intent (this, PruebaInicioSesion.class);
        startActivity(siguiente);

    }

}