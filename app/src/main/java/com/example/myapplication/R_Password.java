
package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class R_Password extends AppCompatActivity {

    private EditText txtreset;
    private Button btnenviar;
    private String Email;
    private ProgressDialog mDialog;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r__password);
        mDialog =  new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        txtreset = (EditText) findViewById(R.id.txtreset);
        btnenviar = (Button) findViewById(R.id.btnenviar);

        btnenviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Email = txtreset.getText().toString();
                if (!Email.isEmpty()){
                    mDialog.setMessage("Espere...");
                    mDialog.setCanceledOnTouchOutside(false);
                    mDialog.show();
                    Recuperar();
                }else {
                    Toast.makeText(R_Password.this, "Por Favor Ingrese Su Usuario.",
                            Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    private void Recuperar (){
        mAuth.setLanguageCode("es");
        mAuth.sendPasswordResetEmail(Email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful()){
                    mDialog.setMessage("Espere...");
                    mDialog.setCanceledOnTouchOutside(false);
                    mDialog.show();
                    Toast.makeText(R_Password.this, "Se Envio Un Correo Para Reestablecer Tu Contraseña.", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(R_Password.this, "Usuario No Encontrado.", Toast.LENGTH_LONG).show();

                }
                mDialog.dismiss();

            }
        });

    }
}