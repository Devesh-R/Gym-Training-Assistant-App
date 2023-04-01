package com.dev19.gymapplication;

import androidx.annotation.ArrayRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class PlanActivity extends AppCompatActivity {

    private TextView monedit,tuesedit,wededit,thuredit,friedit,satedit,sunedit;
    private RecyclerView monrec,tuesrec,wedrec,thurrec,frirec,satrec,sunrec;
    private NestedScrollView nestedScrollView;
    private Button addPlan;
    private RelativeLayout noPlanLayout;
    private PlanAdapter monAdapter,tueAdapter,wedAdapter,thurAdapter,friAdapter,satAdapter,sunAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        initViews();

        ArrayList<Plan> plans = Utils.getInstance(PlanActivity.this).getPlans();
        if(null!=plans){
            if(plans.size()>0){
                noPlanLayout.setVisibility(View.GONE);
                nestedScrollView.setVisibility(View.VISIBLE);
                initRecViews();

                setEditOnClickListener();
            }else{
                noPlanLayout.setVisibility(View.VISIBLE);
                nestedScrollView.setVisibility(View.GONE);
                addPlan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(PlanActivity.this,AllTrainingsActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                });
            }

        }else{
            noPlanLayout.setVisibility(View.VISIBLE);
            nestedScrollView.setVisibility(View.GONE);
            addPlan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(PlanActivity.this,AllTrainingsActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            });
        }
    }

    private void setEditOnClickListener() {

        final Intent intent = new Intent(this,EditActivity.class);
        monedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("day","Monday");
                startActivity(intent);
            }
        });
        tuesedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("day","Tuesday");
                startActivity(intent);
            }
        });

        wededit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("day","Wednesday");
                startActivity(intent);
            }
        });

        thuredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("day","Thursday");
                startActivity(intent);
            }
        });
        friedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("day","Friday");
                startActivity(intent);
            }
        });

        satedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("day","Saturday");
                startActivity(intent);
            }
        });
        sunedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("day","Sunday");
                startActivity(intent);
            }
        });




    }

    private void initRecViews() {

        monAdapter=new PlanAdapter(this);
        monrec.setAdapter(monAdapter);
        monrec.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        monAdapter.setPlans(getPlansByDay("Monday"));

        tueAdapter=new PlanAdapter(this);
        tuesrec.setAdapter(tueAdapter);
        tuesrec.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        tueAdapter.setPlans(getPlansByDay("Tuesday"));

        wedAdapter=new PlanAdapter(this);
        wedrec.setAdapter(wedAdapter);
        wedrec.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        wedAdapter.setPlans(getPlansByDay("Wednesday"));

        thurAdapter=new PlanAdapter(this);
        thurrec.setAdapter(thurAdapter);
        thurrec.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        thurAdapter.setPlans(getPlansByDay("Thursday"));

        friAdapter=new PlanAdapter(this);
        frirec.setAdapter(friAdapter);
        frirec.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        friAdapter.setPlans(getPlansByDay("Friday"));

        satAdapter=new PlanAdapter(this);
        satrec.setAdapter(satAdapter);
        satrec.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        satAdapter.setPlans(getPlansByDay("Saturday"));

        sunAdapter=new PlanAdapter(this);
        sunrec.setAdapter(sunAdapter);
        sunrec.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        sunAdapter.setPlans(getPlansByDay("Sunday"));

    }

    private ArrayList<Plan> getPlansByDay(String day){

        ArrayList<Plan> allPlans = Utils.getInstance(getApplicationContext()).getPlans();
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
        Intent intent = new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        super.onBackPressed();
    }

    private void initViews() {

        monedit=findViewById(R.id.mondayEdit);
        tuesedit=findViewById(R.id.tuesdayEdit);
        wededit=findViewById(R.id.wednesdayEdit);
        thuredit=findViewById(R.id.thursdayEdit);
        friedit=findViewById(R.id.fridayEdit);
        satedit=findViewById(R.id.satEdit);
        sunedit=findViewById(R.id.sunEdit);
        monrec=findViewById(R.id.mondayRecView);
        tuesrec=findViewById(R.id.tuesdayRecView);
        wedrec=findViewById(R.id.wednesdayRecView);
        thurrec=findViewById(R.id.thursdayRecView);
        frirec=findViewById(R.id.fridayRecView);
        satrec=findViewById(R.id.satRecView);
        sunrec=findViewById(R.id.sunRecView);
        addPlan=findViewById(R.id.btnAddPlan);
        nestedScrollView = findViewById(R.id.nestedScrollView);
        noPlanLayout=findViewById(R.id.noplanlayout);

    }
}