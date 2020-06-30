package com.example.jobifyme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StartingPage extends AppCompatActivity {
Button button ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void Buton(View view)
    {

        Intent intent = new Intent(this, FirstScreen.class);
        EditText editText = findViewById(R.id.editText2);
        intent.putExtra("",editText.getText().toString());
        editText = findViewById(R.id.editText);
        intent.putExtra("k",editText.getText().toString());
        startActivity(intent);
    }
}