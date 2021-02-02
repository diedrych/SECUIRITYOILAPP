package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.pm.PackageManager;
import android.Manifest;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class newsForm extends AppCompatActivity {

    DatabaseReference mRootReference;
    TextInputLayout textInputLayout;
    AutoCompleteTextView autoCompleteTextView;
    AutoCompleteTextView autoCompletePriority;
    private TextView tv1;
    File photoFile = null;
    private EditText Element;
    private EditText Priority;
    private EditText Description;
    private ImageView img;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_form);

        //se crea la instancia a la base de datos
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        mRootReference = FirebaseDatabase.getInstance().getReference();
        textInputLayout=findViewById(R.id.dropDownOption);
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        autoCompletePriority = findViewById(R.id.autoCompletePriority);
        Element = (EditText)findViewById(R.id.autoCompleteTextView);
        Priority = (EditText)findViewById(R.id.autoCompletePriority);
        Description = (EditText)findViewById(R.id.editDescription);


        ArrayList<String> options = new ArrayList<String>();


        tv1 =(TextView)findViewById(R.id.textViewTitle);
        String dato = getIntent().getStringExtra("dato");
        String code =  getIntent().getStringExtra("code");
        tv1.setText(dato);

        db.collection("subtypes_of_novelty").whereEqualTo("type_novelty_key", code).get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot document: task.getResult()){
                                Log.d("data:", document.getId() + "=> " + document.getData());
                               String subtypesName =document.getData().get("subtype_novelty_name").toString();
                                String subtypesId =document.getId().toString();
                               options.add(subtypesName);
                            }
                        }else{
                            Log.w("error", "error getting documents");
                        }
                    }
                });


        if (ContextCompat.checkSelfPermission(newsForm.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(newsForm.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(newsForm.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 1000);
        }

        Collections.sort(options);
        ArrayAdapter<String> adapter= new ArrayAdapter<>(
                this, R.layout.dropdown_item, options
        );

        String[] priority = {"Alto", "Medio", "Bajo"};
        ArrayAdapter<String> priorities = new ArrayAdapter<>(
                this, R.layout.dropdown_item, priority
        );

        autoCompleteTextView.setAdapter(adapter);
        autoCompletePriority.setAdapter(priorities);
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


    //metodo para crear nombre unico a cada foto
    String mCurrentPhotoPath;
    private File createImageFile() throws IOException{
        String timeStamp=new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "Backup_" + timeStamp +"_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(imageFileName, ".jpg", storageDir);

        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }


    //Metodo que toma foto y crea el archivo
    static final int REQUEST_TAKE_PHOTO = 1;
    public void takePicture(View view){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePictureIntent.resolveActivity(getPackageManager()) != null){
           // File photoFile=null;
            try{
                photoFile=createImageFile();

            }catch (IOException ex){

            }

            if(photoFile != null){
                Uri photoURI= FileProvider.getUriForFile(this, "com.example.android.fileprovider", photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI.toString());
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);

            }

        }

    }


    //metodo para guardar la novedad
    public void  saveNovelties(View view){
        String prior = Priority.getText().toString().trim();
        String elem = Element.getText().toString().trim();
        String desc = Description.getText().toString().trim();

        Log.d("data:", desc);


        if(!validateInputs(prior, elem, desc)){
            FirebaseFirestore db = FirebaseFirestore.getInstance();

            Map<String, Object> map= new HashMap<>();
            map.put("date", new Date().getTime());
            map.put("priority", prior);
            map.put("condition", elem);
            map.put("description", desc);

            db.collection("news_report").add(map).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                @Override
                public void onSuccess(DocumentReference documentReference) {
                    Toast.makeText(newsForm.this, "Reporte creado con Exito", Toast.LENGTH_LONG).show();
                    Element.setText(null);
                    Priority.setText(null);
                    Description.setText(null);

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(newsForm.this, "Fallo la creacion del reporte", Toast.LENGTH_LONG).show();
                }
            });



        }

    }


   //metodo para valida que los campos esten llenos
   private boolean validateInputs(String prior, String cond, String desc) {
       if (prior.isEmpty()) {
           autoCompletePriority.setError("Ingrese la prioridad");
           autoCompletePriority.requestFocus();
           return true;
       }

       if (cond.isEmpty()) {
           autoCompleteTextView.setError("Ingrese la condición");
           autoCompleteTextView.requestFocus();
           return true;
       }

       if (desc.isEmpty()) {
           Description.setError("Ingrese la descripción");
           Description.requestFocus();
           return true;
       }

       return false;
   }
}