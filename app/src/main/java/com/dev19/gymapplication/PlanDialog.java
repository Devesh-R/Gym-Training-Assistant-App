package com.dev19.gymapplication;

import static com.dev19.gymapplication.TrainingActivity.TRAINING_KEY;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class PlanDialog extends DialogFragment {

    public interface PassPlanInterface{
        void getPlan(Plan plan);
    }

    private PassPlanInterface passPlanInterface;
    private Button btnAdd,btnDismiss;
    private Spinner spinnerDay;
    private EditText edtMinutes;
    private TextView txtname;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_plan_details,null);
        initviews(view);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity()).setView(view).setTitle("Set Plan");

        Bundle bundle= getArguments();
        if(null!=bundle){
            Training training= bundle.getParcelable(TRAINING_KEY);
            if(null!=training){
                txtname.setText(training.getName());
                btnDismiss.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dismiss();
                    }
                });
                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String day= spinnerDay.getSelectedItem().toString();
                        int minute = Integer.valueOf(edtMinutes.getText().toString());
                        Plan plan = new Plan(training,day,minute,false);

                        try{
                            passPlanInterface= (PassPlanInterface) getActivity();
                            passPlanInterface.getPlan(plan);
                            dismiss();
                        }catch (ClassCastException e){
                            e.printStackTrace();
                            dismiss();
                        }

                    }
                });

            }
        }

        return builder.create();
    }

    private void initviews(View view) {

        spinnerDay=view.findViewById(R.id.spinnerDay);
        btnAdd= view.findViewById(R.id.btnAdd);
        btnDismiss= view.findViewById(R.id.btnDismiss);
        txtname=view.findViewById(R.id.ttxtName);
        edtMinutes=view.findViewById(R.id.edtTxtminutes);
    }
}
