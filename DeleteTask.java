package com.example.jobifyme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class DeleteTask extends AppCompatActivity implements FruitSelectionListener {
RecyclerView recyclerView;
ArrayList<String> list = new ArrayList<>();
RecyclerView.Adapter mAdapter;
    FirebaseFirestore db= FirebaseFirestore.getInstance();

String phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_task);
        recyclerView = findViewById(R.id.recycle);

        Intent intent = getIntent();
        phone = intent.getStringExtra("Phone");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        CollectionReference collectionReference = db.collection("Tasks");
        collectionReference
                //.whereEqualTo("Phone",phone)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                String s = document.getId();
                                list.add(s);
                            }

                            mAdapter = new Adapter2(list, DeleteTask.this);
                            recyclerView.setAdapter(mAdapter);
                            mAdapter.notifyDataSetChanged();

                        }

                    }
                });
    }

    @Override
    public void onFruitSelected(String FruitName) {
        db.collection("Tasks")
                .document(FruitName)
                .delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        mAdapter.notifyDataSetChanged();
                        Toast.makeText(DeleteTask.this,"Successfully deleted",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(DeleteTask.this,FirstScreen.class);
                        startActivity(intent);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(DeleteTask.this,"There was an error deleting",Toast.LENGTH_SHORT).show();
                    }
                });
    }
}