package com.example.jobifyme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskList extends AppCompatActivity implements FruitSelectionListener {
RecyclerView recyclerView;
String city;
    ArrayList<String> list = new ArrayList<>();

    private FirebaseFirestore db= FirebaseFirestore.getInstance();
private RecyclerView.Adapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
       Intent intent = getIntent();
       city = intent.getStringExtra("City");



        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        CollectionReference collectionReference = db.collection("Tasks");
        collectionReference
                //.whereEqualTo("City",city)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                String s = document.getId();
                                list.add(s);
                            }

                                mAdapter = new MyAdapter(list, TaskList.this);
                                recyclerView.setAdapter(mAdapter);
                                mAdapter.notifyDataSetChanged();

                        }

                    }
                });




    }

@Override
    public void onFruitSelected(String FruitName) {

        Intent intent = new Intent(this,TaskView.class);
     /*   int x = arr.indexOf(FruitName);

    intent.putExtra("Phone",Phone.get(x));
    intent.putExtra("Time", Time.get(x));
    intent.putExtra("Description",Description.get(x));
    intent.putExtra("Payment",City);*/
    intent.putExtra("task",FruitName);
        startActivity(intent);
    }
}