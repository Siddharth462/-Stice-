package com.example.jobifyme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import javax.xml.datatype.Duration;

public class TaskView extends AppCompatActivity {
TextView editText;
TextView textView;
TextView txtView;
TextView TxtView;
TextView getTxtView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_view);
        Intent intent = getIntent();
/*
        editText = findViewById(R.id.editTextTextPersonName3);
        textView = findViewById(R.id.editTextTextPersonName5);
        txtView = findViewById(R.id.editTextTextPersonName6);
        TxtView = findViewById(R.id.editTextTextMultiLine2);;
        getTxtView = findViewById(R.id.editTextTextPersonName4);
        getTxtView.setText(intent.getStringExtra("Payment"));
        TxtView.setText(intent.getStringExtra("Description"));
        txtView.setText(intent.getStringExtra("Phone"));
        textView.setText(intent.getStringExtra("Time"));
        editText.setText(intent.getStringExtra("task"));*/
    }
}