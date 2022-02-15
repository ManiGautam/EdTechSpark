package com.manijee.edtechspark.views.presenters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.manijee.edtechspark.R;
import com.manijee.edtechspark.model.SubscibedCourseResponseModel;
import com.manijee.edtechspark.repository.RecyclerItemOnClickListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.MyViewHolder>{
    List<SubscibedCourseResponseModel> courselist;
    RecyclerItemOnClickListener listener;

    public CourseAdapter(RecyclerItemOnClickListener listener, List<SubscibedCourseResponseModel> courselistf){
        this.listener=listener;
        this.courselist=courselistf;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_course_recyclear_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.MyViewHolder holder, int position) {
        SubscibedCourseResponseModel course = courselist.get(position);
        Picasso.get().load(course.getImageUrl()).into(holder.courseimg);
        holder.coursename.setText(course.getName());
        holder.coursedescription.setText(course.getDescription());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             ArrayList list = new ArrayList<SubscibedCourseResponseModel>();
             list.add(course);
                listener.onItemClick(list);
            }
        });
    }
    @Override
    public int getItemCount() {
        return courselist.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView courseimg;
        TextView  coursename;
        TextView  coursedescription;
        TextView  courseprice;
        ConstraintLayout card;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            courseimg=itemView.findViewById(R.id.coursepic);
            coursename=itemView.findViewById(R.id.coursename);
            coursedescription=itemView.findViewById(R.id.coursedecripstion);
            courseprice=itemView.findViewById(R.id.courseprice);
            card=itemView.findViewById(R.id.recyclerCard);
        }
    }
}
