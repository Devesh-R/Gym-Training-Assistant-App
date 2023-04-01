package com.dev19.gymapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class AllTrainingsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TrainingAdapter trainingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_trainings);
        recyclerView = findViewById(R.id.recyclerview);
        trainingAdapter = new TrainingAdapter(this);
        recyclerView.setAdapter(trainingAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        ArrayList<Training> allTrainings = Utils.getInstance(getApplicationContext()).getTrainings();
        if (null != allTrainings) {
            trainingAdapter.setTrainings(allTrainings);
        }
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }
}