package com.dev19.gymapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView btnplan, btnallTrainings,btnabout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initviews();
        Utils.getInstance(getApplicationContext()).initTrainings();
        btnplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PlanActivity.class);
                startActivity(intent);

            }
        });

        btnallTrainings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllTrainingsActivity.class);
                startActivity(intent);

            }
        });

        btnabout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this).setTitle("ABOUT")
                        .setMessage("This application is developed by Devesh R. All rights reserved ⓒ"+"\n Click visit button to Rate this application")
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).setPositiveButton("Visit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                       Intent intent =new Intent(MainActivity.this, WebActivity.class);
                                       startActivity(intent);
                            }
                        });

                builder.create().show();
            }
        });
    }

    private void initviews() {
        btnabout=findViewById(R.id.btnAbout);
        btnallTrainings =findViewById(R.id.btnAllActivities);
        btnplan=findViewById(R.id.btnPlanActivity);
    }
}