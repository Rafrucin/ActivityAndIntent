package com.example.activityandintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button secondActivityBtn = (Button) findViewById(R.id.secondActivityBtn);
        Button googleBtn = (Button) findViewById(R.id.googleBtn);
        Button listActivityBtn = (Button) findViewById(R.id.listActivityBtn);

        secondActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent statIntent = new Intent(getApplicationContext(), SecondActivity.class);
                statIntent.putExtra("com.example.activityandintent.SOMETHING", "HELLO WORLD");
                startActivity(statIntent);
            }
        });

        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String google = "http://www.google.com";
                Uri webaddress = Uri.parse(google);
                Intent goToGoogle = new Intent(Intent.ACTION_VIEW, webaddress);
                if (goToGoogle.resolveActivity(getPackageManager()) !=null){
                    startActivity(goToGoogle);
                }
            }
        });

        listActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startListAct = new Intent(getApplicationContext(), ListActivity.class);
                startActivity(startListAct);
            }
        });
    }
}