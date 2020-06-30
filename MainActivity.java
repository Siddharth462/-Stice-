package com.example.jobifyme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_page);



    }
    public void h(View view)
    {

        Intent intent = new Intent(this, OurTeam.class);

        startActivity(intent);
    }
    public void v(View view)
    {

        Intent intent = new Intent(this, StartingPage.class);

        startActivity(intent);
    }

}