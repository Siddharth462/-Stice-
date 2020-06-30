package com.example.jobifyme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.functions.FirebaseFunctions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AddTask extends AppCompatActivity {

    private FirebaseFirestore db= FirebaseFirestore.getInstance();

    ArrayList<String> list = new ArrayList<String>(5);
    ArrayList<String> arrayList = new ArrayList<>(5);
    ArrayList<String>payment = new ArrayList<>(5);
    ArrayList<String>phone = new ArrayList<>(5);
    ArrayList<String> timing = new ArrayList<>(5);
    Map<String,Object> task = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);




    }
    public void goTo(View view)
    {

        EditText editText = findViewById(R.id.editTextTextPersonName7);
        list.add(editText.getText().toString());
        task.put("Name",editText.getText().toString());
        String taskname = editText.getText().toString();

        editText = findViewById(R.id.editTextTextMultiLine2);
        arrayList.add(editText.getText().toString());
        task.put("Description",editText.getText().toString());

        editText = findViewById(R.id.editTextTextPersonName4);

        task.put("Payment",editText.getText().toString());


        editText = findViewById(R.id.editTextTextPersonName6);
        phone.add(editText.getText().toString());
        task.put("Phone",editText.getText().toString());

        editText = findViewById(R.id.editTextTextPersonName5);
        timing.add(editText.getText().toString());
        task.put("Time",editText.getText().toString());

        editText = findViewById(R.id.editTextTextPersonName10);
        task.put("City",editText.getText().toString());


        Intent intent = new Intent(this,TaskList.class);
        db.collection("Tasks").document(taskname).set(task)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(AddTask.this,"Task Added",Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddTask.this,"There was an error",Toast.LENGTH_SHORT).show();
                    }
                });
        startActivity(intent);


    }
}