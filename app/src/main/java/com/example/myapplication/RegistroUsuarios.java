package com.example.myapplication;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;


public class


RegistroUsuarios extends AppCompatActivity {

    private FirebaseAuth mAuth;

   private   EditText  txtuser;
   private EditText txtpass;
   private  EditText contraseña;
   private EditText usuario;

   private   Button btnregistrar;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);

        mAuth = FirebaseAuth.getInstance();
        txtuser = findViewById(R.id.txtuser);
        txtpass =  findViewById(R.id.txtpass);
        contraseña =  (EditText)findViewById(R.id.txtpass);
        usuario = (EditText)findViewById(R.id.txtuser);
        btnregistrar = findViewById(R.id.btnregistrar);

    }

    public void onStart(){
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
    }


    public void Registrate(View View){

        if (usuario.getText().toString().isEmpty()){
            Toast.makeText(RegistroUsuarios.this, "Por favor Ingrese Un Usuario", Toast.LENGTH_SHORT).show();
            return;
        }
        if (contraseña.getText().toString().isEmpty()){
            Toast.makeText(RegistroUsuarios.this, "Por favor Ingrese Una Contraseña ", Toast.LENGTH_SHORT).show();

        }

        if (txtpass.getText().toString().length()<=6)
        {
            Toast.makeText(RegistroUsuarios.this, "Su Contraseña Necesita Minimo 6 Caracteres", Toast.LENGTH_SHORT).show();
            return;
        }



        mAuth.createUserWithEmailAndPassword(txtuser.getText().toString(), txtpass.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {


                        if (task.isSuccessful()) {
                            Toast.makeText(RegistroUsuarios.this, "el usuario se registro", Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                        }
                        else {

                            Toast.makeText(RegistroUsuarios.this, "El usuario no se registro", Toast.LENGTH_SHORT).show();
                        }

                    }
                });




    }





    }





