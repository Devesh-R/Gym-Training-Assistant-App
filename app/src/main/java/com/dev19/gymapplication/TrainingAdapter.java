package com.dev19.gymapplication;


import static com.dev19.gymapplication.TrainingActivity.TRAINING_KEY;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class TrainingAdapter extends  RecyclerView.Adapter<TrainingAdapter.ViewHolder> {

    private ArrayList<Training> trainings = new ArrayList<>();
    private Context context;

    public void setTrainings(ArrayList<Training> trainings) {
        this.trainings = trainings;
        notifyDataSetChanged();
    }

    public TrainingAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.training_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.activityname.setText(trainings.get(position).getName());
        holder.shortdesc.setText(trainings.get(position).getShortDesc());
        Glide.with(context).asBitmap().load(trainings.get(position).getImageUrl()).into(holder.image);
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context,TrainingActivity.class);
                intent.putExtra(TRAINING_KEY,trainings.get(position));
                /**
                 * in the above line we are passing the book that is pressed or clicked, and in previous library project
                 * we have sent the id of the clicked book, then we get that id and iterating through all the book
                 * and we found the book with the id and we did operations on that..
                 * but here we are passing the book itself.
                 */
                context.startActivity(intent);
                Toast.makeText(context, trainings.get(position).getName()+" is pressed", Toast.LENGTH_SHORT).show();
            }
        });


    }


    @Override
    public int getItemCount() {
        return trainings.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        private MaterialCardView parent;
        private ImageView image;
        private TextView activityname;
        private TextView shortdesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent=itemView.findViewById(R.id.parent);
            image=itemView.findViewById(R.id.image);
            activityname=itemView.findViewById(R.id.name);
            shortdesc=itemView.findViewById(R.id.shortDesc);


        }
    }

}
