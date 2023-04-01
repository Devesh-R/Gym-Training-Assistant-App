package com.dev19.gymapplication;

import static com.dev19.gymapplication.Utils.ALL_TRAININGS_KEY;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class TrainingActivity extends AppCompatActivity implements PlanDialog.PassPlanInterface {

    private Button btnAddPlan;
    private ImageView img;
    private TextView txtName,longDesc;
    public static String TRAINING_KEY="training";
    public static final String TAG="TrainingActivity";
    @Override
    public void getPlan(Plan plan) {

        if(Utils.getInstance(getApplicationContext()).addPlan(plan)){
            Log.d(TAG,"getPlan :Plan: "+plan.toString());
            Toast.makeText(this, plan.getTraining().getName()+ " Added Successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, PlanActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

       initViews();

        Intent intent= getIntent();
        if(null!=intent){
           final  Training training=intent.getParcelableExtra(TRAINING_KEY);
            /**
             * this getParcelable receives the book object so that we can directly use operations on that book
             */
            if(null!=training){
                txtName.setText(training.getName());
                longDesc.setText(training.getLongDesc());
                Glide.with(this).asBitmap().load(training.getImageUrl()).into(img);

                btnAddPlan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        PlanDialog planDialog = new PlanDialog();
                        Bundle bundle= new Bundle();
                        bundle.putParcelable(TRAINING_KEY,training);
                        planDialog.setArguments(bundle);
                        planDialog.show(getSupportFragmentManager(),"plan detail dialog");
                    }
                });

            }
        }

    }



    private void initViews() {

        btnAddPlan=findViewById(R.id.btnAddPlan);
        txtName=findViewById(R.id.txtname);
        img= findViewById(R.id.image);
        longDesc=findViewById(R.id.longDesc);
    }


}