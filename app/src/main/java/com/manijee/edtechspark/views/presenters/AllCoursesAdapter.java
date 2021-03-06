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
import com.manijee.edtechspark.model.AllCoursesresponsemodel;
import com.manijee.edtechspark.repository.OnAddToCartListner;
import com.manijee.edtechspark.repository.RecyclerItemOnClickListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AllCoursesAdapter extends RecyclerView.Adapter<AllCoursesAdapter.MyViewHolder>{
    List<AllCoursesresponsemodel> courselist;
    RecyclerItemOnClickListener listener;
OnAddToCartListner cartlistner;
    public AllCoursesAdapter(RecyclerItemOnClickListener listener, OnAddToCartListner cartlistner, List<AllCoursesresponsemodel> courselistf){
        this.listener=listener;
        this.courselist=courselistf;
        this.cartlistner = cartlistner;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_course_recyclear_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        AllCoursesresponsemodel course = courselist.get(position);
        Picasso.get().load(course.getImageUrl()).into(holder.courseimg);
        holder.coursename.setText(course.getName());
        holder.coursedescription.setText(course.getSummary());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList list = new ArrayList<AllCoursesresponsemodel>();
                list.add(course);
                listener.onItemClick(list);
            }
        });
        holder.addtocartcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               cartlistner.onAddToCartClicked(course);
            }
        });
    }
    @Override
    public int getItemCount() {
        return courselist.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView courseimg;
        TextView coursename;
        TextView  coursedescription;
        TextView  courseprice;
        ConstraintLayout card;
        ConstraintLayout addtocartcard;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            courseimg=itemView.findViewById(R.id.coursepic);
            coursename=itemView.findViewById(R.id.coursename);
            coursedescription=itemView.findViewById(R.id.coursedecripstion);
            courseprice=itemView.findViewById(R.id.courseprice);
            card=itemView.findViewById(R.id.upperlayout);
            addtocartcard=itemView.findViewById(R.id.downlayout);
        }
    }
}
