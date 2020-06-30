package com.example.jobifyme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class FirstScreen extends AppCompatActivity {

    ArrayList<String> arrlist = new ArrayList<String>(5);
    ArrayList<String> arrayList = new ArrayList<>(5);
ArrayList<String>payment = new ArrayList<>(5);
    final ArrayList<String> list = new ArrayList<>() ;

String x;
String y ;

    ArrayList<String>phone = new ArrayList<>(5);
ArrayList<String> timing = new ArrayList<>(5);
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);
        Intent intent = getIntent();
        this.x = intent.getStringExtra("");
        this.y = intent.getStringExtra("k");
        arrlist.add("Item1");
        arrlist.add("Item2");
        arrlist.add("Item3");
        arrayList.add("Description");
        arrayList.add("Some description");
        arrayList.add("Some more description");
        phone.add("9090232322");
        phone.add("7878343434");
        phone.add("2938475610");
        timing.add("30");
        timing.add("30");
        timing.add("10");
    payment.add("10");
    payment.add("20");
    payment.add("30");
        }


    public void viewTasks(View view)
    {



        Intent intent = new Intent(this,TaskList.class);
        intent.putExtra("City",x);



        startActivity(intent);
    }
    public void addTask(View view)
    {
        Intent intent = new Intent(this,AddTask.class);
        intent.putExtra("City",x);
        intent.putExtra("",y);
        startActivity(intent);
    }
    public void deleteTask(View v)
    {
        Intent intent = new Intent(this,DeleteTask.class);
        startActivity(intent);
    }
    public void addAlert(View view)
    {
        Intent intent = new Intent(this,AddAlert.class);
        startActivity(intent);
    }
}