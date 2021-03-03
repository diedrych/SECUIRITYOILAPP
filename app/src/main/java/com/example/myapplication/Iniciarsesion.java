package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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
    private EditText usuario;
    private  EditText contraseña;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciarsesion);
        txtuser1 = (EditText)findViewById(R.id.txtuser1);
        txtpass1 = (EditText)findViewById(R.id.txtpass1);
        usuario = (EditText) findViewById(R.id.txtuser1);
        contraseña  = (EditText) findViewById(R.id.txtpass1);

        mAuth = FirebaseAuth.getInstance();
    }
    public void onStart(){
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
    }
    public void iniciamos ( View View){
            if (usuario.getText().toString().isEmpty() ) {


                Toast.makeText(Iniciarsesion.this, "Por Favor Ingrese Su Usuario.",
                        Toast.LENGTH_LONG).show();
return;

            }
            if ( (contraseña.getText().toString().isEmpty())){


                Toast.makeText(Iniciarsesion.this, "Por favor Ingrese Su Contraseña.",
                        Toast.LENGTH_LONG).show();
                return;
        }

            else {
                mAuth.signInWithEmailAndPassword(txtuser1.getText().toString(), txtpass1.getText().toString())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                                    Toast.makeText(Iniciarsesion.this, "BIENVENIDO",
                                            Toast.LENGTH_LONG).show();


                                    siguiente(View );

                                    FirebaseUser user = mAuth.getCurrentUser();

                                }

                                else {

                                    Toast.makeText(Iniciarsesion.this, "No puedes iniciar sesión.",
                                            Toast.LENGTH_LONG ).show();

                                }
                            }
                        });

            }
    }
    public void navegar (View View){
        Intent navegar = new Intent (this, RegistroUsuarios.class);
        startActivity(navegar);

    }

    public void siguiente(View View){
        Intent siguiente = new Intent (this, PruebaInicioSesion.class);
        startActivity(siguiente);

    }

    public void ressetpass(View View){
        Intent ressetpass = new Intent (this, R_Password.class);
        startActivity(ressetpass);

    }








}