package com.dev19.gymapplication;

import static android.content.Context.MODE_PRIVATE;
import static android.content.Context.PRINT_SERVICE;
import android.content.SharedPreferences;
import static com.dev19.gymapplication.TrainingActivity.TRAINING_KEY;
import static com.dev19.gymapplication.Utils.ALL_TRAININGS_KEY;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.util.Util;
import com.google.android.material.card.MaterialCardView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class PlanAdapter extends RecyclerView.Adapter<PlanAdapter.ViewHolder> {

    public interface  RemovePlan{
        void onRemoveResult(Plan plan);
    }
    RecyclerView mparent;
    private RemovePlan removePlan;
    private ArrayList<Plan> plans = new ArrayList<>();
    private Context context;
    private String type ="";

    public ArrayList<Plan> getPlans() {
        return plans;
    }

    public void setPlans(ArrayList<Plan> plans) {
        this.plans = plans;
        notifyDataSetChanged();
    }

    public PlanAdapter(Context context) {
        this.context = context;

    }

    public void setType(String type) {
        this.type = type;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plan_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.txtName.setText(plans.get(position).getTraining().getName());
        holder.txtdescription.setText(plans.get(position).getTraining().getShortDesc());
        holder.txttime.setText(String.valueOf(plans.get(position).getMinutes()));
        Glide.with(context).asBitmap().load(plans.get(position).getTraining().getImageUrl()).into(holder.image);

            switch (position) {
                case 0:
                    holder.checkBox.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            SharedPreferences.Editor editor = context.getSharedPreferences("PREF1", MODE_PRIVATE).edit();
                            editor.putBoolean("CK0", holder.checkBox.isChecked());
                            plans.get(position).setAccomplished(true);
                            editor.apply();
                            // Toast.makeText(context,"CK STATE SAVED",Toast.LENGTH_SHORT).show();

                        }
                    });
                    break;
                case 1:
                    holder.checkBox.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            SharedPreferences.Editor editor = context.getSharedPreferences("PREF1", MODE_PRIVATE).edit();
                            editor.putBoolean("CK1", holder.checkBox.isChecked());
                            plans.get(position).setAccomplished(true);
                            editor.apply();
                            // Toast.makeText(context,"CK STATE SAVED",Toast.LENGTH_SHORT).show();

                        }
                    });
                    break;
                case 2:
                    holder.checkBox.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            SharedPreferences.Editor editor = context.getSharedPreferences("PREF1", MODE_PRIVATE).edit();
                            editor.putBoolean("CK2", holder.checkBox.isChecked());
                            plans.get(position).setAccomplished(true);
                            editor.apply();
                            // Toast.makeText(context,"CK STATE SAVED",Toast.LENGTH_SHORT).show();

                        }
                    });
                    break;
                case 3:
                    holder.checkBox.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            SharedPreferences.Editor editor = context.getSharedPreferences("PREF1", MODE_PRIVATE).edit();
                            editor.putBoolean("CK3", holder.checkBox.isChecked());
                            plans.get(position).setAccomplished(true);
                            editor.apply();
                            // Toast.makeText(context,"CK STATE SAVED",Toast.LENGTH_SHORT).show();

                        }
                    });
                    break;

            }

//        holder.checkBox.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SharedPreferences.Editor editor= context.getSharedPreferences("PREF1",MODE_PRIVATE).edit();
//                editor.putBoolean("CK1",holder.checkBox.isChecked());
//                plans.get(position).setAccomplished(true);
//                editor.apply();
//               // Toast.makeText(context,"CK STATE SAVED",Toast.LENGTH_SHORT).show();
//
//            }
//        });

        SharedPreferences sharedPreferences = context.getSharedPreferences("PREF1", MODE_PRIVATE);

            switch (position) {
                case 0:

                    boolean c0_state = sharedPreferences.getBoolean("CK0", false);
                    holder.checkBox.setChecked(c0_state);
                    break;
                case 1:
                    boolean c1_state = sharedPreferences.getBoolean("CK1", false);
                    holder.checkBox.setChecked(c1_state);
                    break;
                case 2:
                    boolean c2_state = sharedPreferences.getBoolean("CK2", false);
                    holder.checkBox.setChecked(c2_state);
                    break;
                case 3:
                    boolean c3_state = sharedPreferences.getBoolean("CK3", false);
                    holder.checkBox.setChecked(c3_state);
                    break;
                default:
                    holder.checkBox.setChecked(false);
                    break;
            }


            holder.parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, TrainingActivity.class);
                    intent.putExtra(TRAINING_KEY, plans.get(position).getTraining());
                    context.startActivity(intent);
                }
            });


        if(type.equals("edit")){
//             holder.checkBox.setOnClickListener(new View.OnClickListener() {
//                 @Override
//                 public void onClick(View v) {
//                     AlertDialog.Builder builder= new AlertDialog.Builder(context).setTitle("Finished").
//                             setMessage("Have you finished "+plans.get(position).getTraining().getName() + " ?").
//                             setNegativeButton("No", new DialogInterface.OnClickListener() {
//                                 @Override
//                                 public void onClick(DialogInterface dialog, int which) {
//
//                                 }
//                             }).setPositiveButton("yes", new DialogInterface.OnClickListener() {
//                                 @Override
//                                 public void onClick(DialogInterface dialog, int which) {
//                                     for(Plan p : Utils.getInstance(context).getPlans()){
//                                           if(p.equals(plans.get(position))){
//
//                                           }
//                                     }
////                                     holder.empcircle.setVisibility(View.GONE);
////                                     holder.checkcircle.setVisibility(View.VISIBLE);
////
////                                     notifyDataSetChanged();
//
//                                 }
//                             });
//
//                     builder.create().show();
//                 }
//             });

             holder.parent.setOnLongClickListener(new View.OnLongClickListener() {
                 @Override
                 public boolean onLongClick(View v) {

                     AlertDialog.Builder builder = new AlertDialog.Builder(context).setTitle("Remove").setMessage("Are you sure you want to delete "+plans.get(position).getTraining().getName()+"?")
                     .setNegativeButton("No", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {

                         }
                     }).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                 @Override
                                 public void onClick(DialogInterface dialog, int which) {
//                                    if( Utils.removePlan(plans.get(position))){
//                                        Toast.makeText(context, "Plan Removed Successfully", Toast.LENGTH_SHORT).show();
//                                        notifyDataSetChanged();

                                     try{
                                         removePlan=(RemovePlan) context;
                                         removePlan.onRemoveResult(plans.get(position));

                                    }catch (ClassCastException e){
                                         e.printStackTrace();
                                     }

                                 }
                             });

                     builder.create().show();

                     return true;  //inorder the longonclick to work we have to return true
                 }
             });
        }


    }

    @Override
    public int getItemCount() {
       return plans.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txttime,txtdescription,txtName;
        private CheckBox checkBox;
        private MaterialCardView parent;
        private ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox=itemView.findViewById(R.id.checkBox);
            txtdescription= itemView.findViewById(R.id.txtdescription);
            parent=itemView.findViewById(R.id.parent);
            image = itemView.findViewById(R.id.trainingImage);
            txtName=itemView.findViewById(R.id.txtname);
            txttime=itemView.findViewById(R.id.txttime);




        }
    }
}
