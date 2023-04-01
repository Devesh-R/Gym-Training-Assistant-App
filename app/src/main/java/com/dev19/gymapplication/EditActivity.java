package com.dev19.gymapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.util.Util;

import java.util.ArrayList;

public class EditActivity extends AppCompatActivity implements  PlanAdapter.RemovePlan {

    private TextView txtday;
    private RecyclerView recyclerView;
    private Button addPlan;
    private PlanAdapter adpater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        intiViews();

        adpater= new PlanAdapter(this);
        adpater.setType("edit");
        recyclerView.setAdapter(adpater);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        if(null!=intent){
            String day = intent.getStringExtra("day");
            if(null!=day){
                txtday.setText(day);
                ArrayList<Plan> plans = getPlansByDay(day);
                adpater.setPlans(plans);
            }
        }

        addPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addPlanIntent = new Intent(EditActivity.this,AllTrainingsActivity.class);
                startActivity(addPlanIntent);
            }
        });
    }

    private ArrayList<Plan> getPlansByDay(String day){

        ArrayList<Plan> allPlans = Utils.getInstance(EditActivity.this).getPlans();
        ArrayList<Plan> plans = new ArrayList<>();
        for(Plan p:allPlans){
            if(p.getDay().equalsIgnoreCase(day)){
                plans.add(p);
            }
        }
        return plans;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,PlanActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void intiViews() {

        txtday= findViewById(R.id.txtDay);
        recyclerView=findViewById(R.id.rec);
        addPlan=findViewById(R.id.addplan);
    }

    @Override
    public void onRemoveResult(Plan plan) {
        if(Utils.getInstance(EditActivity.this).removePlan(plan)){
            Toast.makeText(this, "Training removed from your plan", Toast.LENGTH_SHORT).show();
            adpater.setPlans(getPlansByDay(plan.getDay()));
        }
    }
}