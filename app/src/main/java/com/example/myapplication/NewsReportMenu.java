package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;
import android.view.View.OnClickListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

public class NewsReportMenu extends AppCompatActivity {

    private ImageView iw1, iw2, iw3, iw4, iw5, iw6;
    private TextView tw1, tw2, tw3, tw4, tw5, tw6;
    private EditText date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_report_menu);

        iw1 =(ImageView)findViewById(R.id.accident);
        tw1 =(TextView) findViewById(R.id.accidentText);

        iw2 =(ImageView)findViewById(R.id.insurance);
        tw2 =(TextView) findViewById(R.id.insuranceText);

        iw3 =(ImageView)findViewById(R.id.helmet);
        tw3 =(TextView) findViewById(R.id.helmetText);

        iw4 =(ImageView)findViewById(R.id.tool);
        tw4 =(TextView) findViewById(R.id.toolText);

        iw5 =(ImageView)findViewById(R.id.machine);
        tw5 =(TextView) findViewById(R.id.machineText);

        iw6 =(ImageView)findViewById(R.id.enviroment);
        tw6 =(TextView) findViewById(R.id.enviromentText);


        //Agrega el icono al action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
/*
        iw2.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                Intent i = new Intent(v.getContext(), newsForm.class);

                i.putExtra("dato", iw2.getContentDescription().toString());
                i.putExtra("code", tw2.getContentDescription().toString());
                startActivity(i);
            }
        });
        */
    }



    public void passNewForm(View view){
        Intent i = new Intent(this, newsForm.class);
        i.putExtra("dato", iw1.getContentDescription().toString());
        i.putExtra("code", tw1.getContentDescription().toString());
        startActivity(i);
    }

    public void passNewForm2(View view){
        Intent i = new Intent(this, newsForm.class);
        i.putExtra("dato", iw2.getContentDescription().toString());
        i.putExtra("code", tw2.getContentDescription().toString());
        startActivity(i);
    }

    public void passNewForm3(View view){
        Intent i = new Intent(this, newsForm.class);
        i.putExtra("dato", iw3.getContentDescription().toString());
        i.putExtra("code", tw3.getContentDescription().toString());
        startActivity(i);
    }

    public void passNewForm4(View view){
        Intent i = new Intent(this, newsForm.class);
        i.putExtra("dato", iw4.getContentDescription().toString());
        i.putExtra("code", tw4.getContentDescription().toString());
        startActivity(i);
    }

    public void passNewForm5(View view){
        Intent i = new Intent(this, newsForm.class);
        i.putExtra("dato", iw5.getContentDescription().toString());
        i.putExtra("code", tw5.getContentDescription().toString());
        startActivity(i);
    }

    public void passNewForm6(View view){
        Intent i = new Intent(this, newsForm.class);
        i.putExtra("dato", iw6.getContentDescription().toString());
        i.putExtra("code", tw6.getContentDescription().toString());
        startActivity(i);
    }


    //metodo para mostrar y ocultar el menu
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }

    //metodo para asignar funcion a las opciones del menu
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.mainMenu){
            //debe redirigir al activity del menu principal
            Toast.makeText(this, "menu principal", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.signOff){
            //debe cerrar sesion
            Toast.makeText(this, "cerrar sesion", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}